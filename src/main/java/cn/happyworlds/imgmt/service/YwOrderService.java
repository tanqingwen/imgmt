package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.json.TypeRef;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@Service
public class YwOrderService {

	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private YwOrderitemMapper ywOrderitemMapper;
	@Autowired
	private SybWxPayService sybwxpayservice;
	@Autowired
	private CpTicketMapper cpTicketMapper;
	
	
	public Result<PageInfo<YwOrder>> ywOrderList(String hwMobilePhone,String hwOrderId,PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(hwMobilePhone)) {
			params.put("hwMobilePhone", hwMobilePhone);
		}if (StringUtils.hasText(hwOrderId)) {
			params.put("hwOrderId", hwOrderId);
		}
		params.put("hwOrderStates","S");
		List<YwOrder> page = ywOrderMapper.searchYwOrderByParams(params,pageBounds);
		return Result.create(new PageInfo<YwOrder>(page));
	}
	
	public Long deleteYwOrderByHwOrderId(final String hwOrderId) {
		Long r = ywOrderMapper.deleteYwOrderByHwOrderId(hwOrderId);
		return r;
	}
	public List<YwOrderitem> ywOrderLists(String hwOrderId) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(hwOrderId)) {
			params.put("hwOrderId", hwOrderId);
		}
		List<YwOrderitem> page = ywOrderitemMapper.searchYwOrderitemByParams(params);
		return page;
	}
	
	public YwOrderitem ywOrderGetById(String hwOrderitemId) {
		YwOrderitem ywOrderitem = ywOrderitemMapper.searchYwOrderitemByHwOrderitemId(hwOrderitemId);
		return ywOrderitem;
	}
	
	/**
	 * 
	 * @param data
	 * @param hwOrderId				订单号
	 * @param hwMobilePhone			手机号
	 * @param hwOperatorId			作业员ID			
	 * @param hwChannel				订单渠道
	 * @param hwPayType				支付类型
	 * @param hwType				订单类型
	 * @param starttime				订单完成开始时间
	 * @param endtime				订单完成结束时间
	 * @return
	 */
	public List<YwOrder> yworderlist(String data){
		Map<String, String> val = Jackson.readJson(data, new TypeRef<Map<String, String>>());
		List<YwOrder> list = new ArrayList<YwOrder>();
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(val.get("hwOrderId"))) {
			params.put("hwOrderId", val.get("hwOrderId"));
		}
		if (StringUtils.hasText(val.get("hwMobilePhone"))) {
			params.put("hwMobilePhone", val.get("hwMobilePhone")); 
		}
		if (StringUtils.hasText(val.get("hwOperatorId"))) {
			params.put("hwOperatorId", val.get("hwOperatorId"));
		}
		if (StringUtils.hasText(val.get("hwChannel"))) {
			params.put("hwChannel", val.get("hwChannel"));
		}
		if (StringUtils.hasText(val.get("hwPayType"))) {
			params.put("hwPayType", val.get("hwPayType"));
		}
		if (StringUtils.hasText(val.get("hwType"))) {
			params.put("hwType", val.get("hwType"));
		}
		if (StringUtils.hasText(val.get("starttime"))) {
			params.put("starttime", val.get("starttime"));
		}
		if (StringUtils.hasText(val.get("endtime"))) {
			params.put("endtime", val.get("endtime"));
		}
		params.put("hwPaymentStatus", "Y");
		list =  ywOrderMapper.searchYwOrderByParamstime(params);
		
		return list;
	}
	
	public StatusResult<?> YworderbuyId(String orderId){
		YwOrder order = new YwOrder();
		try {
			if(Objects.isNull(orderId))
				return StatusResult.create("error", "订单号为空");
			order = ywOrderMapper.searchYwOrderByHwOrderId(orderId);
			if(Objects.isNull(order))
				return StatusResult.create("error", "未找到订单信息");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			StatusResult.create("error", "查找订单失败");
		}
		return StatusResult.create(order);
	}
	
	public StatusResult<?> refundyworder(YwOrder order,String operatorId,List<YwOrderitem> itemList,String PaymentListid) throws Exception{
		
		String orderID = automaticgrowthService.nextdindang("name");
		YwOrder cancelOrder = new YwOrder();
		cancelOrder.setHwOrderId(orderID);
//			cancelOrder.setHwMemberId("");  //待确认
		cancelOrder.setHwMobilePhone(order.getHwMobilePhone());
		cancelOrder.setHwChannel(order.getHwChannel()); 
		cancelOrder.setHwMoney(order.getHwMoney());
		cancelOrder.setHwOrderState("N");
		cancelOrder.setHwPaymentStatus("N");
		cancelOrder.setHwOrderAddtime(DateTimes.newDateTime());
		cancelOrder.setHwOperatorId(operatorId);
		cancelOrder.setHwType("4");
		cancelOrder.setHwSonOrderList(order.getHwOrderId());
		ywOrderMapper.insertYwOrder(cancelOrder);
		
		cancelOrder.setHwOrderFinishtime(DateTimes.newDateTime());
		cancelOrder.setHwOrderPaytime(DateTimes.newDateTime());
		cancelOrder.setHwPaymentStatus("Y");
		if(PaymentListid != null){
			cancelOrder.setHwPaymentListid(PaymentListid);
		}
		
		ywOrderMapper.updateYwOrder(cancelOrder);
		order.setHwOrderState("R");
		ywOrderMapper.updateYwOrder(order);
		for(YwOrderitem item : itemList){
			item.setHwStatus("R");
			item.setHwOperatorId(operatorId);
			ywOrderitemMapper.updateYwOrderitem(item);
			CpTicket ticket = cpTicketMapper.searchCpTicketByTkTicketId(Long.parseLong(item.getHwOrderitemId()));
			if(!Objects.isNull(ticket)){
				ticket.setTkStatus("R");
				cpTicketMapper.updateCpTicket(ticket);
			}
		}
		return StatusResult.create("OK", "退款成功");
	}
	
	public StatusResult<?> refundyworderpay(YwOrder order,String operatorId,String paytype,List<YwOrderitem> itemList) throws Exception{
		
		String orderID = automaticgrowthService.nextdindang("name");
		YwOrder cancelOrder = new YwOrder();
		cancelOrder.setHwOrderId(orderID);
//			cancelOrder.setHwMemberId("");  //待确认
		cancelOrder.setHwMobilePhone(order.getHwMobilePhone());
		cancelOrder.setHwChannel(order.getHwChannel());
		cancelOrder.setHwMoney(order.getHwMoney());
		cancelOrder.setHwOrderState("N");
		cancelOrder.setHwPaymentStatus("N");
		cancelOrder.setHwOrderAddtime(DateTimes.newDateTime());
		cancelOrder.setHwOperatorId(operatorId);
		cancelOrder.setHwType("4");
		cancelOrder.setHwSonOrderList(order.getHwOrderId());
		ywOrderMapper.insertYwOrder(cancelOrder);
		Map<String, String> cancelResult = sybwxpayservice.refund(order.getHwMoney().multiply(new BigDecimal(100)).longValue(),
				orderID, order.getHwPaymentListid(), order.getHwOrderId());
		if("0000".equals(cancelResult.get("trxstatus"))){
			cancelOrder.setHwOrderFinishtime(DateTimes.newDateTime());
			cancelOrder.setHwOrderPaytime(DateTimes.newDateTime());
			cancelOrder.setHwPaymentStatus("Y");
			cancelOrder.setHwPaymentListid(cancelResult.get("trxid"));  
			ywOrderMapper.updateYwOrder(cancelOrder);
			order.setHwOrderState("R");
			ywOrderMapper.updateYwOrder(order);
			for(YwOrderitem item : itemList){
				item.setHwStatus("R");
				item.setHwOperatorId(operatorId);
				ywOrderitemMapper.updateYwOrderitem(item);
				CpTicket ticket = cpTicketMapper.searchCpTicketByTkTicketId(Long.parseLong(item.getHwOrderitemId()));
				if(!Objects.isNull(ticket)){
					ticket.setTkStatus("R");
					cpTicketMapper.updateCpTicket(ticket);
				}
			}
			return StatusResult.create("OK", "退款成功");
		}else{
			throw new RuntimeException("退款失败");
		}
	}
	
	public Result<PageInfo<YwOrder>> tuiPiaoList(String orderId,PageBounds pageBounds) {
		Map<String, String> params=new HashMap<>();
		if(StringUtils.hasText(orderId)) {//检查字段是否为空
			params.put("hwOrderId", orderId);
		}
		String hwTypes = "'1','2','3','4','10'";
		params.put("hwTypes", hwTypes);
		params.put("hwPaymentStatus", "Y");
		params.put("hwType","1" );
		params.put("orderId", "hw_order_id");
		params.put("hwOrderState", "N");
		List<YwOrder> page=ywOrderMapper.searchYwOrderByParams(params,pageBounds);
		return Result.create(new PageInfo<YwOrder>(page));
	}
}
