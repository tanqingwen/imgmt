package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.StatusResult;

@Service
public class PaymentService {

	@Autowired
	private SybWxPayService sybwxpayservice;
	@Autowired
	private YwOrderMapper yworderMapper;
	@Autowired
	private YwOrderitemMapper yworderitemMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private CpTicketMapper cpTicketMapper;
	@Autowired
	private YwOrderService ywOrderService;
	
	/**
	 * 统一支付接口
	 * @param trxamt	交易金额
	 * @param reqsn		订单号
	 * @param paytype	交易方式
	 * @param body		标题
	 * @param remark	备注
	 * @param acct		支付平台用户标识JS支付时使用  微信支付-用户的微信openid  支付宝支付-用户user_id
	 * @param authcode	授权码
	 * @param notify_url	回调地址
	 * @param limit_pay		no_credit--指定不能使用信用卡支付  暂时只对微信支付有效,仅支持no_credit
	 * @return
	 * @throws Exception 
	 */
	public StatusResult<String> pay(long trxamt,String reqsn,String paytype,String body,
			String remark,String acct,String authcode,String notify_url,String limit_pay) throws Exception{
		sybwxpayservice.pay(trxamt, reqsn, paytype, body, remark, acct, authcode, notify_url, limit_pay);
		return StatusResult.create("");
	}
	
	/**
	 * 
	 * @param orderId
	 * @param operatorId
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<String> cancel(String orderId, String operatorId) throws Exception{
		try{
			YwOrder order = yworderMapper.searchYwOrderByHwOrderId(orderId);
			if(Objects.isNull(order) || "R".equals(order.getHwOrderState()) || "P".equals(order.getHwOrderState()))
				return StatusResult.create("error", "未找到订单信息或订单已使用");
			if(!"10".equals(order.getHwChannel()))
				return StatusResult.create("error", "非现场购票订单");
			if(!"XC_WX".equals(order.getHwPayType()) && !"XC_ZFB".equals(order.getHwPayType()))
				return StatusResult.create("error", "仅支持现场微信扫码和现场支付宝扫码订单退票");
			Map<String, String> orderMap = new HashMap<>();
			orderMap.put("hwOrderId", order.getHwOrderId());
			List<YwOrderitem> itemList = yworderitemMapper.searchYwOrderitemByParams(orderMap);
			for(YwOrderitem item : itemList){
				if(!"T".equals(item.getHwStatus()))
					return StatusResult.create("error", "订单已使用");
			}
			//现场微信、支付宝扫码撤销
			if("XC_WX".equals(order.getHwPayType()) || "XC_ZFB".equals(order.getHwPayType())){
				String orderID = automaticgrowthService.nextdindang("name");
				YwOrder cancelOrder = new YwOrder();
				cancelOrder.setHwOrderId(orderID);
//				cancelOrder.setHwMemberId("");  //待确认
				cancelOrder.setHwMobilePhone(order.getHwMobilePhone());
				cancelOrder.setHwChannel(order.getHwChannel());
				cancelOrder.setHwMoney(order.getHwMoney());
				cancelOrder.setHwOrderState("N");
				cancelOrder.setHwPaymentStatus("N");
				cancelOrder.setHwOrderAddtime(DateTimes.nowTimestamp());
				cancelOrder.setHwOperatorId(operatorId);
				cancelOrder.setHwType("4");
				yworderMapper.insertYwOrder(cancelOrder);
				Map<String, String> cancelResult = sybwxpayservice.cancel(order.getHwMoney().multiply(new BigDecimal(100)).longValue(),
						orderID, order.getHwPaymentListid(), order.getHwOrderId());
				if("0000".equals(cancelResult.get("trxstatus"))){
					cancelOrder.setHwOrderFinishtime(DateTimes.nowTimestamp());
					cancelOrder.setHwOrderPaytime(DateTimes.nowTimestamp());
					cancelOrder.setHwPaymentStatus("Y");
					cancelOrder.setHwPaymentListid(cancelResult.get("trxid"));
					yworderMapper.updateYwOrder(cancelOrder);
					order.setHwOrderState("R");
					yworderMapper.updateYwOrder(order);
					for(YwOrderitem item : itemList){
						item.setHwStatus("R");
						item.setHwOperatorId(operatorId);
						yworderitemMapper.updateYwOrderitem(item);
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
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("系统异常", e);
		}
		return StatusResult.create("FAIL", "撤销失败");
	}
	/**
	 * 退票
	 * @param orderId
	 * @param operatorId
	 * @return
	 * @throws Exception 
	 */
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<?> refundByOrder(String orderId, String operatorId,String PaymentListid) throws Exception{
		YwOrder order = yworderMapper.searchYwOrderByHwOrderId(orderId);
		if(Objects.isNull(order))
			return StatusResult.create("error", "未找到订单信息");
		if(!"Y".equals(order.getHwPaymentStatus()) && "W".equals(order.getHwOrderState()))
			return StatusResult.create("error", "订单异常");
		Map<String, String> orderMap = new HashMap<>();
		orderMap.put("hwOrderId", order.getHwOrderId());
		List<YwOrderitem> itemList = yworderitemMapper.searchYwOrderitemByParams(orderMap);
		for(YwOrderitem item : itemList){
			if(!"T".equals(item.getHwStatus()))
				return StatusResult.create("error", "订单已使用");
		}
		if("1".equals(order.getHwChannel())){
			
		}else if("2".equals(order.getHwChannel())){
			
		}else if("3".equals(order.getHwChannel())){
			if("XC_WX".equals(order.getHwPayType()) || "XC_ZFB".equals(order.getHwPayType())){
				return ywOrderService.refundyworderpay(order, operatorId, order.getHwPayType(), itemList);
			}else if("CASH".equals(order.getHwPayType()) || "cash".equals(order.getHwPayType())){
				return ywOrderService.refundyworder(order, operatorId, itemList,PaymentListid);
			}else if("POS".equals(order.getHwPayType())){
				return ywOrderService.refundyworder(order, operatorId, itemList,PaymentListid);
			}else if("ZNPOS_WX".equals(order.getHwPayType()) || "ZNPOS_ZFB".equals(order.getHwPayType())){
				
			}
		}else if("4".equals(order.getHwChannel())){
			
		}else if("10".equals(order.getHwChannel())){
			if("XC_WX".equals(order.getHwPayType()) || "XC_ZFB".equals(order.getHwPayType())){
				return ywOrderService.refundyworderpay(order, operatorId, order.getHwPayType(), itemList);		
			}
		}else{
			return StatusResult.create("error", "订单渠道错误");
		}
			
		if(!"XC_WX".equals(order.getHwPayType()) && !"XC_ZFB".equals(order.getHwPayType()))
			return StatusResult.create("error", "仅支持现场微信扫码和现场支付宝扫码订单退票");
		//现场微信、支付宝扫码撤销
		if("XC_WX".equals(order.getHwPayType()) || "XC_ZFB".equals(order.getHwPayType())){
			String orderID = automaticgrowthService.nextdindang("name");
			YwOrder cancelOrder = new YwOrder();
			cancelOrder.setHwOrderId(orderID);
//				cancelOrder.setHwMemberId("");  //待确认
			cancelOrder.setHwMobilePhone(order.getHwMobilePhone());
			cancelOrder.setHwChannel(order.getHwChannel());
			cancelOrder.setHwMoney(order.getHwMoney());
			cancelOrder.setHwOrderState("N");
			cancelOrder.setHwPaymentStatus("N");
			cancelOrder.setHwOrderAddtime(DateTimes.nowTimestamp());
			cancelOrder.setHwOperatorId(operatorId);
			cancelOrder.setHwType("4");
			cancelOrder.setHwSonOrderList(orderId);
			yworderMapper.insertYwOrder(cancelOrder);
			Map<String, String> cancelResult = sybwxpayservice.refund(order.getHwMoney().multiply(new BigDecimal(100)).longValue(),
					orderID, order.getHwPaymentListid(), order.getHwOrderId());
			if("0000".equals(cancelResult.get("trxstatus"))){
				cancelOrder.setHwOrderFinishtime(DateTimes.nowTimestamp());
				cancelOrder.setHwOrderPaytime(DateTimes.nowTimestamp());
				cancelOrder.setHwPaymentStatus("Y");
				cancelOrder.setHwPaymentListid(cancelResult.get("trxid"));
				yworderMapper.updateYwOrder(cancelOrder);
				order.setHwOrderState("R");
				yworderMapper.updateYwOrder(order);
				for(YwOrderitem item : itemList){
					item.setHwStatus("R");
					item.setHwOperatorId(operatorId);
					yworderitemMapper.updateYwOrderitem(item);
					CpTicket ticket = cpTicketMapper.searchCpTicketByTkTicketId(Long.parseLong(item.getHwOrderitemId()));
					if(!Objects.isNull(ticket)){
						ticket.setTkStatus("R");
						cpTicketMapper.updateCpTicket(ticket);
					}
				}
				return StatusResult.create("OK", "退款成功");
			}else{
				return StatusResult.create("FAIL", "退款失败");
			}
		}
		return StatusResult.create("FAIL", "退款失败");
	}
	/**
	 * 退票
	 * @param itemId
	 * @param operatorId
	 * @return
	 * @throws Exception 
	 */
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<String> refund(String itemId, String operatorId) throws Exception{
		YwOrderitem item = yworderitemMapper.searchYwOrderitemByHwOrderitemId(itemId);
		YwOrder order = yworderMapper.searchYwOrderByHwOrderId(item.getHwOrderId());
		if(Objects.isNull(order))
			return StatusResult.create("error", "未找到订单信息");
		if(!"3".equals(order.getHwChannel()))
			return StatusResult.create("error", "非现场购票订单");
		if(!"XC_WX".equals(order.getHwPayType()) && !"XC_ZFB".equals(order.getHwPayType()))
			return StatusResult.create("error", "仅支持现场微信扫码和现场支付宝扫码订单退票");
		Map<String, String> orderMap = new HashMap<>();
		orderMap.put("hwOrderId", order.getHwOrderId());
		if(!"T".equals(item.getHwStatus()))
			return StatusResult.create("error", "票已使用");
		//现场微信、支付宝扫码撤销
		if("XC_WX".equals(order.getHwPayType()) || "XC_ZFB".equals(order.getHwPayType())){
			String orderID = automaticgrowthService.nextdindang("name");
			YwOrder cancelOrder = new YwOrder();
			cancelOrder.setHwOrderId(orderID);
//				cancelOrder.setHwMemberId("");  //待确认
			cancelOrder.setHwMobilePhone(order.getHwMobilePhone());
			cancelOrder.setHwChannel(order.getHwChannel());
			cancelOrder.setHwMoney(item.getHwAmount());
			cancelOrder.setHwOrderState("N");
			cancelOrder.setHwPaymentStatus("N");
			cancelOrder.setHwOrderAddtime(DateTimes.nowTimestamp());
			cancelOrder.setHwOperatorId(operatorId);
			cancelOrder.setHwType("4");
			cancelOrder.setHwSonOrderList(order.getHwOrderId());
			yworderMapper.insertYwOrder(cancelOrder);
			Map<String, String> cancelResult = sybwxpayservice.refund(item.getHwAmount().multiply(new BigDecimal(100)).longValue(),
					orderID, order.getHwPaymentListid(), order.getHwOrderId());
			if("0000".equals(cancelResult.get("trxstatus"))){
				cancelOrder.setHwOrderFinishtime(DateTimes.nowTimestamp());
				cancelOrder.setHwOrderPaytime(DateTimes.nowTimestamp());
				cancelOrder.setHwPaymentStatus("Y");
				cancelOrder.setHwPaymentListid(cancelResult.get("trxid"));
				yworderMapper.updateYwOrder(cancelOrder);
				order.setHwOrderState("R");
				yworderMapper.updateYwOrder(order);
				item.setHwStatus("R");
				item.setHwOperatorId(operatorId);
				yworderitemMapper.updateYwOrderitem(item);
				CpTicket ticket = cpTicketMapper.searchCpTicketByTkTicketId(Long.parseLong(item.getHwOrderitemId()));
				if(!Objects.isNull(ticket)){
					ticket.setTkStatus("R");
					cpTicketMapper.updateCpTicket(ticket);
				}
				return StatusResult.create("FAIL", "退款成功");
			}else{
				throw new RuntimeException("撤销失败");
			}
		}
		return StatusResult.create("FAIL", "退款失败");
	}
	/**
	 * 根据票id 退票
	 * @param orderId
	 * @return
	 * @throws Exception 
	 */
	public StatusResult<String> cancelByItemId(String itemId, String operatorId) throws Exception{
		YwOrderitem item = yworderitemMapper.searchYwOrderitemByHwOrderitemId(itemId);
		YwOrder order = yworderMapper.searchYwOrderByHwOrderId(item.getHwOrderId());
		if(Objects.isNull(order) || Objects.isNull(item))
			return StatusResult.create("error", "未找到订单或订单详情信息");
		YwOrder ywOrder = new YwOrder();
		String orderID = automaticgrowthService.nextdindang("name");
		ywOrder.setHwOrderId(orderID);
		ywOrder.setHwType("4");
		ywOrder.setHwChannel("3");
		ywOrder.setHwMobilePhone(order.getHwMobilePhone());
		ywOrder.setHwMoney(order.getHwMoney());
		ywOrder.setHwOperatorId(operatorId);
		ywOrder.setHwOrderFinishtime(DateTimes.getTimeStr(new Date()));
		ywOrder.setHwMemberId(order.getHwMemberId());
		ywOrder.setHwOrderAddtime(DateTimes.getTimeStr(new Date()));
		ywOrder.setHwOrderState("");
		yworderMapper.insertYwOrder(ywOrder);
		long trxamt = order.getHwMoney().multiply(new BigDecimal(100)).longValue();
		Map<String, String> result = sybwxpayservice.refund(trxamt, orderID, order.getHwPaymentListid(), order.getHwOrderId());
		return StatusResult.create("退款成功");
	}
}
