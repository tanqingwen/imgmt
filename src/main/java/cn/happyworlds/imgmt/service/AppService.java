package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.StatusResult;
import scala.annotation.meta.param;

@Service
public class AppService {

	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private YwOrderitemMapper ywOrderitemMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private CpTicketMapper cpTicketMapper;
	@Autowired
	private SybWxPayService sybwxpayservice;
	
	/**
	 * 查询订单列表
	 * @param staffId		操作人id
	 * @param channel		渠道
	 * @param pageNum		页码
	 * @param pageSize		页数
	 * @return
	 */
	public StatusResult<PageInfo<YwOrder>> queryOrder(String staffId, String channel, Integer pageNum, Integer pageSize){
		Map<String, String> params = new HashMap<>();
		params.put("hwType", "1");
		params.put("hwChannel", channel);
		params.put("operatorId", staffId);
		params.put("payTypes", "'Y','R'");
		List<YwOrder> list = ywOrderMapper.searchYwOrderByPos(params, new PageBounds(pageNum, pageSize));
		System.out.println(list.size());
		return StatusResult.create(new PageInfo<YwOrder>(list));
	}
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<Object> cancelCheck(String orderId, String ip, String operatorId) throws Exception{
		YwOrder order = getOrder(orderId);
		Map<String, String> orderMap = new HashMap<>();
		orderMap.put("hwOrderId", orderId);
		List<YwOrderitem> itemList = ywOrderitemMapper.searchYwOrderitemByParams(orderMap);
		String msg = checkOrderUsed(itemList, order);
		if(!StringUtils.isEmpty(msg))
			return retError(msg);
		String orderID = automaticgrowthService.nextdindang("name");
		YwOrder cancelOrder = createOrder(orderID, order.getHwMobilePhone(), "12", "4", order.getHwMoney(), "N", 
				"N", null, operatorId, null, order.getHwOrderId(), ip);
		String[] serialNos = {""};
		if(!StringUtils.isEmpty(order.getHwPaymentListid()))
			serialNos = order.getHwPaymentListid().split(",");
		String origRefNo = "";
		if(serialNos.length > 1)
			origRefNo = serialNos[1];
		Map<String, Object> result = new HashMap<>();
		result.put("orderId", cancelOrder.getHwOrderId());
		result.put("origOrderId", order.getHwOrderId());
		result.put("serialNo", serialNos[0]);
		result.put("refId", origRefNo);
		result.put("payType", order.getHwPayType());
		result.put("money", order.getHwMoney());
		return StatusResult.create(result);
	}
	/**
	 * 智能pos支付
	 * @param ip			pos ip
	 * @param businessId	交易码
	 * @param orderId		订单id
	 * @return
	 * @throws Exception
	 */
	public StatusResult<String> pos_pay(String ip, String businessId, String orderId) throws Exception{
		YwOrder order = getOrder(orderId);
		if(order == null)
			return StatusResult.create("error", "订单不存在");
		if(!order.getHwPaymentStatus().equals("N"))
			return StatusResult.create("error", "订单已支付或已无效");
		if(!"12".equals(order.getHwChannel()))
			return StatusResult.create("error", "非智能pos订单");
		StatusResult<String> result = sybwxpayservice.batchzhinengPOS(ip, businessId, 
				String.valueOf(order.getHwMoney().doubleValue()), getTransCheck());
		return result;
	}
	/**
	 * 智能pos撤销
	 * @param ip			pos ip
	 * @param businessId	交易码
	 * @param orderId		订单号
	 * @param operatorId    操作人
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<Object> pos_cancel(String ip, String businessId, String orderId, String operatorId) throws Exception{
		YwOrder order = getOrder(orderId);
		Map<String, String> orderMap = new HashMap<>();
		orderMap.put("hwOrderId", orderId);
		List<YwOrderitem> itemList = ywOrderitemMapper.searchYwOrderitemByParams(orderMap);
		String msg = checkOrderUsed(itemList, order);
		if(!StringUtils.isEmpty(msg))
			return retError(msg);
		String orderID = automaticgrowthService.nextdindang("name");
		YwOrder cancelOrder = createOrder(orderID, order.getHwMobilePhone(), "12", "4", order.getHwMoney(), "N", 
				"N", null, operatorId, null, null, ip);
		StatusResult<String> result = sybwxpayservice.batchzhinengPOSCancel(ip, businessId, 
				String.valueOf(order.getHwMoney().doubleValue()), order.getHwPaymentListid().split(",")[0], getTransCheck());
		if(result.isOk()){
			cancelOrder.setHwOrderFinishtime(DateTimes.nowTimestamp());
			cancelOrder.setHwOrderPaytime(DateTimes.nowTimestamp());
			cancelOrder.setHwPaymentStatus("Y");
			cancelOrder.setHwPaymentListid("");
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
			return StatusResult.create("FAIL", "撤销成功");
		}else{
			throw new Exception("撤销失败");
		}
	}
	/**
	 * 智能pos 退款
	 * @param ip			pos ip
	 * @param businessId	交易码
	 * @param amount		交易金额
	 * @param orderId		订单id
	 * @param operatorId	操作人
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<Object> pos_refund(String ip, String businessId, String amount, String orderId, String operatorId) throws Exception{
		YwOrder order = getOrder(orderId);
		Map<String, String> orderMap = new HashMap<>();
		orderMap.put("hwOrderId", orderId);
		List<YwOrderitem> itemList = ywOrderitemMapper.searchYwOrderitemByParams(orderMap);
		String msg = checkOrderUsed(itemList, order);
		if(!StringUtils.isEmpty(msg))
			return retError(msg);
		String[] serialNos = order.getHwPaymentListid().split(",");
		if(serialNos.length != 2 || StringUtils.isEmpty(serialNos[1]))
			return StatusResult.create("error", "原始参考号为空");
		String origRefNo = serialNos[1];
		String orderID = automaticgrowthService.nextdindang("name");
		YwOrder cancelOrder = createOrder(orderID, order.getHwMobilePhone(), "12", "4", order.getHwMoney(), "N", 
				"N", null, operatorId, null, null, ip);
		StatusResult<String> result = sybwxpayservice.batchzhinengPOSRefund(ip, businessId, amount, origRefNo, 
				order.getHwOrderPaytime().substring(0,8), getTransCheck());
		if(result.isOk()){
			cancelOrder.setHwOrderFinishtime(DateTimes.nowTimestamp());
			cancelOrder.setHwOrderPaytime(DateTimes.nowTimestamp());
			cancelOrder.setHwPaymentStatus("Y");
			cancelOrder.setHwPaymentListid("");
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
			return StatusResult.create("FAIL", "退款成功");
		}else{
			throw new Exception("退款失败");
		}
	}
	/**
	 * 
	 * @param orderId
	 * @param operatorId
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<Object> cancel(String orderId, String operatorId, String ip) throws Exception{
		try{
			YwOrder order = getOrder(orderId);
			Map<String, String> orderMap = new HashMap<>();
			orderMap.put("hwOrderId", orderId);
			List<YwOrderitem> itemList = ywOrderitemMapper.searchYwOrderitemByParams(orderMap);
			String msg = checkOrderUsed(itemList, order);
			if(!StringUtils.isEmpty(msg))
				return retError(msg);
			String orderID = automaticgrowthService.nextdindang("name");
			YwOrder cancelOrder = createOrder(orderID, order.getHwMobilePhone(), "12", "4", order.getHwMoney(), "N", 
					"N", null, operatorId, null, null, ip);
			StatusResult<String> cancelResult = sybwxpayservice.batchzhinengPOS(ip, "200300001", String.valueOf(cancelOrder.getHwMoney().doubleValue()), "");
//			Map<String, String> cancelResult = sybwxpayservice.cancel(order.getHwMoney().multiply(new BigDecimal(100)).longValue(),
//					orderID, order.getHwPaymentListid(), order.getHwOrderId());
			System.out.println(cancelResult.getValue());
			if(cancelResult.isOk()){
				cancelOrder.setHwOrderFinishtime(DateTimes.nowTimestamp());
				cancelOrder.setHwOrderPaytime(DateTimes.nowTimestamp());
				cancelOrder.setHwPaymentStatus("Y");
				cancelOrder.setHwPaymentListid("");
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
				return StatusResult.create("FAIL", "撤销成功");
			}else{
				throw new Exception("撤销失败");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("系统异常", e);
		}
	}
	private YwOrder getOrder(String orderId){
		return ywOrderMapper.searchYwOrderByHwOrderId(orderId);
	}
	private String getTransCheck(){
		return String.valueOf(System.currentTimeMillis());
	}
	private StatusResult<Object> retError(String msg){
		return StatusResult.create("error", msg);
	}
	private String checkOrderUsed(List<YwOrderitem> itemList,YwOrder order){
		if(Objects.isNull(order) || !"Y".equals(order.getHwPaymentStatus()))
			return "未找到订单信息或订单已使用";
		if(!"12".equals(order.getHwChannel()))
			return "非智能pos订单";
		if(!order.getHwPayType().startsWith("ZNPOS"))
			return "非智能pos支付方式";
		if(itemList == null || itemList.size() == 0)
			return "未找到票信息";
		for(YwOrderitem item : itemList){
			if(!"T".equals(item.getHwStatus()))
				return "订单已使用";
		}
		return null;
	}
	/**
	 * 创建订单
	 * @param orderId		订单id
	 * @param phone			手机号
	 * @param channel		渠道
	 * @param hwType		订单类型
	 * @param money			金额
	 * @param orderState	状态
	 * @param payState		支付状态
	 * @param payType		支付方式
	 * @param operatorId	操作人
	 * @param serialNo		流水号
	 * @param ziOrderId		子订单号
	 * @return
	 */
	private YwOrder createOrder(String orderId,String phone,String channel,String hwType,
			BigDecimal money,String orderState, String payState, String payType, 
			String operatorId, String serialNo, String ziOrderId, String hwIp){
		YwOrder order = new YwOrder();
		order.setHwOrderId(orderId);
		order.setHwMobilePhone(phone);
		order.setHwChannel(channel);
		order.setHwType(hwType);
		order.setHwMoney(money);
		order.setHwOrderState(orderState);
		order.setHwPaymentStatus(payState);
		order.setHwPayType(payType);
		order.setHwOperatorId(operatorId);
		order.setHwPaymentListid(serialNo);
		order.setHwSonOrderList(ziOrderId);
		order.setHwOrderAddtime(DateTimes.getDateTime(new Date()));
		order.setHwIp(hwIp);
		ywOrderMapper.insertYwOrder(order);
		return order;
	}

}
