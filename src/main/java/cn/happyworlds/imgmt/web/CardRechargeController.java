package cn.happyworlds.imgmt.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.bean.HappyCardBean;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.json.TypeRef;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.service.AutomaticGrowthService;
import cn.happyworlds.imgmt.service.CardRechargeService;
import cn.happyworlds.imgmt.service.CrdtblService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.SybWxPayService;
import cn.happyworlds.imgmt.to.Constants;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@CrossOrigin
@Controller
@RequestMapping("/CardRecharge")
public class CardRechargeController {

	@Autowired
	private CrdtblService crdtblService;
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CardRechargeService cardRechargeService;
	@Autowired
	private SybWxPayService sybwxpayservice;
	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	
	

	@WebAction(Permission.AMOUNT_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		return "card_recharge/add";
	}
	
	
	//@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/getKey", method = RequestMethod.POST)
	public StatusResult<List<String>> getKey(String cardNumber,int type){
		
		//提取方法
		String cardtype="";
		CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
		StatusResult<List<String>> r = crdtblService.getCardtype(cpCrdtbl);
		if("FALSE".equals(r.getStatus())){
			return r;
		}else{
			cardtype = r.getValue().toString();	
		}
		HappyCardBean happyCardBean = new HappyCardBean();
		List<String> list=happyCardBean.getKey(cardNumber, type,cardtype);
		return StatusResult.create(list);
	}
	
	
	
	@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/getWviBalance", method = RequestMethod.POST)
	public StatusResult<String> getWviBalance(String cardNumber){
		
		try{
			CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
			StatusResult<String> str=crdtblService.getWviBalance(cpCrdtbl);
			if(null==str ||  "".equals(str)){
				return StatusResult.create("FAILE","使用证件信息没有找到对应数据");
			}else{
				return str;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/getBalance", method = RequestMethod.POST)
	public StatusResult<String> getBalance(String cardNumber){
		
		try{
			
			CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
			StatusResult<String> str=crdtblService.getBalance(cpCrdtbl);
			if(null==str ||  "".equals(str)){
				return StatusResult.create("FAILE","余额查询异常");
			}else{
				return str;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@WebAction(Permission.AMOUNT_ADD)
	@ResponseBody
	@RequestMapping(value = "/doCoreTran", method = RequestMethod.POST)
	public StatusResult<List<String>> doCoreTran(String pay,String cardNumber,String blocks,String amount,String moneyReceived,String cashChange){
		String staffId = WebContext.getCurrentStaff().getId();
		try{
				return crdtblService.doCharge(moneyReceived,cashChange,cardNumber, amount, "DEPOSIT","充值", staffId);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//会员卡微信充值
	@WebAction(Permission.AMOUNT_ADD)
	@RequestMapping(value="/weChatCard", method = RequestMethod.GET)
	public String weChat(String varAc_amount,String cbCardholderNo,HttpServletRequest request){
		System.out.println("--------卡信息---："+varAc_amount+"---2--"+cbCardholderNo);
		HttpSession session=request.getSession();
		session.setAttribute("tbl", varAc_amount);
		return "card_recharge/weChat";
	}
	
	//柜台购票 | 充值 读卡获取信息
	@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/getCardMess", method = RequestMethod.POST)
	public StatusResult<String[]> getCardMess(String cardNumber){
		try{
			CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
			String[] str=crdtblService.getCardInfo(cpCrdtbl);
			if(null==str || str.length<=0){
				return StatusResult.create("FALSE","使用证件信息没有找到对应数据");
			}else{
				return StatusResult.create(str);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//会员卡充值订单
	
	@ResponseBody
	@RequestMapping(value = "/charge/start", method = RequestMethod.POST)
	public StatusResult<?> charge(@RequestParam("amount")BigDecimal amount,@RequestParam("cardNumber")String cardNumber,@RequestParam("hw_channel")String hw_channel,@RequestParam("payType")String payType,@RequestParam("hwIp")String hwIp ){
		String staffId = "";
		
		try{
			if("3".equals(hw_channel)){
				staffId = WebContext.getCurrentStaff().getId();
				if("W04".equals(payType)){
					payType = "XC_WX";
				}else if("A04".equals(payType)){
					payType = "XC_ZFB";
				}
			}else if("10".equals(hw_channel)){
				staffId  = "personal";
				if("W04".equals(payType)){
					payType = "YTJ_WX";
				}else if("A04".equals(payType)){
					payType = "YTJ_ZFB";
				}
			}
			CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
			if(Objects.isNull(cpCrdtbl) && cardNumber.length() >= 8){
				cpCrdtbl = crdtblService.getCrdtblByRwdsAccnoAndUsing(cardNumber.substring(0, 8));
			}
			CpCsttbl cpCsttbl =cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cpCrdtbl.getCbIdno());
			if(cpCsttbl==null){
				return StatusResult.create("FALSE","使用证件信息没有找到对应数据");
			}
			String[] str=crdtblService.getCardInfo(cpCrdtbl);
			if(null==str || str.length<=0){
				return StatusResult.create("FALSE","使用证件信息没有找到对应数据");
			}else{
				YwOrder ywOrder = new YwOrder();
				String orderID = automaticgrowthService.nextdindang("name");
				ywOrder.setHwOrderId(orderID);
				ywOrder.setHwChannel(hw_channel);
				ywOrder.setHwType("2");
				ywOrder.setHwOrderState("N");
				ywOrder.setHwIp(hwIp);
				ywOrder.setHwMemberId(str[1]);
				ywOrder.setHwCustomerName(str[2]);
				ywOrder.setHwMobilePhone(cpCsttbl.getCbMobileNo()==null?"":cpCsttbl.getCbMobileNo());
				ywOrder.setHwMoney(amount);
				ywOrder.setHwOrderAddtime(DateTimes.getDateTime(new Date()));
				ywOrder.setHwPaymentStatus("N");
				ywOrder.setHwPayType(payType);
				ywOrder.setHwOperatorId(staffId);
				ywOrderMapper.insertYwOrder(ywOrder);
				return StatusResult.create(orderID);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/updateOrderStatus",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public  StatusResult updateOrderStatus(@RequestParam("orderId")String orderId,@RequestParam("payType") String payType,@RequestParam("receiptsPrice")BigDecimal receiptsPrice,@RequestParam("hwPaymentListid")String hwPaymentListid){
		YwOrder ywOrder =ywOrderMapper.searchYwOrderByHwOrderId(orderId);
		if(ywOrder!=null){
			if("Y".equals(ywOrder.getHwPaymentStatus())){
				StatusResult.create("PAYED", "订单已支付");
			}
			ywOrder.setHwPaymentStatus("Y");
			ywOrder.setHwPayType(payType);
			ywOrder.setHwPaymentListid(hwPaymentListid);
			ywOrder.setHwOrderPaytime(DateTimes.newDateTime());
			ywOrderMapper.updateYwOrder(ywOrder);//流水ID		随机生成32位字母加数字
			CpCrdtbl cpCrdtbl =cpCrdtblMapper.searchCpCrdtblByCbIdno(ywOrder.getHwMemberId());
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("cbIndCardholderNo", cpCrdtbl.getCbCardholderNo());
			List<CpIndacc> cpIndaccs =cpIndaccMapper.searchCpIndaccByParams(paramMap);
			CpIndacc cpIndacc =cpIndaccs.get(0);
			cpIndacc.setCbOutstdBal(cpIndacc.getCbOutstdBal().add(ywOrder.getHwMoney()));
			//將退票金额退回会员卡
			cpIndaccMapper.updateCpIndacc(cpIndacc);
			return  StatusResult.create("SUCCESS", orderId);
		}
		return StatusResult.create("FAIL", "更新订单状态失败");
	}
	
	@RequestMapping(value="/queryItemsByOrderId",method=RequestMethod.GET)
	public String queryOrderItemsByOrderId(String orderId,Model model,String receiptsPrice){
		if(StringUtils.isNotEmpty(orderId)){
			 YwOrder ywOrder= ywOrderMapper.searchYwOrderByHwOrderId(orderId);
			 ywOrder.setHwMoney(ywOrder.getHwMoney().setScale(2,BigDecimal.ROUND_HALF_UP));
			 CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbIdno(ywOrder.getHwMemberId());
			 Map<String,String> paramMap = new HashMap<String,String>();
			 paramMap.put("cbIndCardholderNo", cpCrdtbl.getCbCardholderNo());
			 List<CpIndacc> cpIndaccs =cpIndaccMapper.searchCpIndaccByParams(paramMap);
			 CpIndacc indacc = cpIndaccs.get(0);
			 indacc.setCbOutstdBal(indacc.getCbOutstdBal().setScale(2, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("ywOrder",ywOrder);
			 model.addAttribute("cpCrdtbl",cpCrdtbl);
			 model.addAttribute("cpIndacc",indacc);
			 model.addAttribute("receiptsPrice", receiptsPrice);
		}
		return "card_recharge/chargeDetail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/seachMoney" , method = RequestMethod.POST)
	public StatusResult<List<CpCrdtbl>> seachMoney(String idNo,String cbRecommenderNo){
		if(!StringUtils.isNotEmpty(idNo)){
			return StatusResult.create("FALSE", "身份证号不能为空");
		}
		if(!StringUtils.isNotEmpty(cbRecommenderNo)){
			return StatusResult.create("FALSE", "卡面号不能为空");
		}
		Map<String, String> map=new HashMap<String,String>();
		map.put("cbIdno", idNo);
		map.put("cbRecommenderNo", Constants.serialBIN+cbRecommenderNo);
		map.put("cbPlasticCd", "U");
		List<CpCrdtbl> list=cpCrdtblMapper.searchCpCrdtblByParams(map);
		if(list != null){
			return StatusResult.create("SUCCESS",list);
		}else{
			return StatusResult.create("FALSE", "卡面号或身份证号输入有误!");
		}
	}
	
	/**
	 * 会员提现接口
	 * @param CardId		卡号
	 * @param AMOUNT		金额
	 * @param ACCOUNT_NO	银行卡号
	 * @param ACCOUNT_NAME	客户名
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/CardWithdrawals", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public StatusResult CardWithdrawals(String CardId,String AMOUNT,String ACCOUNT_NO,String ACCOUNT_NAME)throws Exception{
		
		CardId = "HWCARD"+CardId;
		String staffId = WebContext.getCurrentStaff().getId();
		if(!StringUtils.isNotEmpty(CardId)){
			return StatusResult.create("FALSE", "卡号不能为空");
		}
		CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbRecommenderNo(CardId);
		if(null==cpcrdtbl){
			return StatusResult.create("FALSE", "卡号不存在");
		}
		CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cpcrdtbl.getCbIdno());
		if(null==cpcsttbl){
			return StatusResult.create("FALSE", "会员不存在");
		}
		StatusResult<String> aaa = cardRechargeService.Carddindang(cpcsttbl, AMOUNT, staffId);
		if(aaa.getStatus().equals("OK")){
			StatusResult<String> daifu = sybwxpayservice.batchDaiShou(AMOUNT,ACCOUNT_NO,ACCOUNT_NAME);			
			if(daifu.getStatus().equals("OK")){
				cardRechargeService.CardYwPayrecode(cpcsttbl, AMOUNT, staffId, aaa.getValue(), daifu.getValue());
				StatusResult<String> bbb = cardRechargeService.CardWithdrawals(cpcrdtbl.getCbCardholderNo(), AMOUNT, staffId);
				if(bbb.getStatus().equals("OK")){
					return StatusResult.create("SUCCESS", "提现成功") ;			
				}else{
					return StatusResult.create("FAIL", bbb.getComment());	
				} 
			}else{
				return StatusResult.create("FAIL", daifu.getComment());
			}			
		}else{
			return StatusResult.create("FAIL", aaa.getComment());	
		}	
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/tonglian/charge", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public StatusResult testCharge(@RequestParam("formAmount") BigDecimal formAmount,@RequestParam("payCode") String payCode,RedirectAttributes ra,HttpServletRequest request,@RequestParam("formOrderId")String formOrderId,@RequestParam("payType")String payType) throws Exception{
		long trxamt = formAmount.multiply(new BigDecimal("100")).longValue();
		try{
			Map<String, String> map = sybwxpayservice.pay(trxamt, formOrderId, payType, "会员卡充值", "充值", "", payCode,"","");
			if("0000".equals(map.get("trxstatus"))){
				if("W04".equals(payType)){
					payType="YTJ_WX";
				}else if ("A04".equals(payType)){
					payType="YTJ_ZFB";
				}
				return updateOrderStatus(formOrderId, payType, new BigDecimal("0"), map.get("trxid"));
			}else{
				return StatusResult.create("FAIL", "付款失败") ;
			}
		}catch (Exception e) {
			return StatusResult.create("FAIL", "付款失败") ;
		}
	}

	@RequestMapping("/tonglian/pos")
	@ResponseBody
	public StatusResult posPay(String business_id,String amount,String orderId,String ip ){
		ip ="192.168.1.40";
		StatusResult<String> receive=null;;
		try {
			receive = sybwxpayservice.batchzhinengPOS(ip,business_id,amount,orderId);
			System.out.println(receive);
			String value =receive.getValue();
			System.out.println(value);
			Map<String ,Object> map =Jackson.readJson(value,  new TypeRef<Map<String,Object>>());
			if("00".equals(map.get("rejcode"))){
				return this.updateOrderStatus(orderId, "POS", new BigDecimal("0"), (String)map.get("ref_no"));
			}
		} catch (Exception e) {
			System.out.println("错误");
			receive = StatusResult.create("error", "参数错误");
		}
		return receive;
	}
}
