package cn.happyworlds.imgmt.web;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.happyworlds.imgmt.entity.CardRecharge;
import cn.happyworlds.imgmt.entity.CpShift;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.entity.PayType;
import cn.happyworlds.imgmt.entity.Shifting;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.mapper.CardRechargeMapper;
import cn.happyworlds.imgmt.mapper.CpShiftMapper;
import cn.happyworlds.imgmt.mapper.CpTrmmstMapper;
import cn.happyworlds.imgmt.mapper.ShiftingMapper;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;
import scala.languageFeature.reflectiveCalls;

@CrossOrigin
@Controller
@RequestMapping("/app/shifting")
public class AppShiftingController {
	
	@Autowired
	private ShiftingMapper shiftingMapper;
	
	@Autowired
	private CardRechargeMapper cardMapper;
	
	@Autowired
	private CpShiftMapper cpShiftMapper;
	
	@Autowired
	private CpTrmmstMapper cpTrmmstMapper;//pos设备ip
	
	
	
	@RestAction
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public String add(){
		return "shifting/add";
	}
	/**
	 * 结班
	 * 
	 * @param m
	 * @param posIp
	 * @return
	 */
	@RestAction
	@ResponseBody
	@RequestMapping(value = "/shift" , method =RequestMethod.GET)
	public String shift(Model m,String posIp){
		if(StringUtils.isEmpty(posIp)){
			return Jackson.writeJson(StatusResult.create("缺少终端ip"));
		}
		//根据终端ip获取终端名称
		CpTrmmst cpTrmmst=cpTrmmstMapper.seachTrmmstByIp(posIp);
		String zdmc=cpTrmmst.getTmDateCanx();
		
		CpShift cpShift=new CpShift();//结班
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String staffId = WebContext.getCurrentStaffByToken().getId();
		String userName= WebContext.getCurrentStaffByToken().getName();
		String day =df.format(new Date());
		// <--判断是否存在 存在直接返回验证shuju是否存在
		Map<String, String> mappp=new HashMap<>();
			mappp.put("cpShiftUserno", staffId);
			mappp.put("cpShiftDate", day);
			mappp.put("cpShiftPosno", posIp);
		List<CpShift> list111= cpShiftMapper.searchCpShiftByParams(mappp);
		System.out.println(list111.size());
		if(list111.size()>0){
			return Jackson.writeJson(StatusResult.create("你今天的班次已提交"));
		}
		//-->
		
		/**
		 * 查看今天的机器号是否已经结班
		 */
		CpShift cpS=cpShiftMapper.searchJieBan(day, posIp);
		System.out.println(cpS);
		if(!org.springframework.util.StringUtils.isEmpty(cpS)){
			return Jackson.writeJson(StatusResult.create("今天已经结过班了"));
		}
		
		
		Map<String, String> map=new HashMap<>();
		map.put("userId", staffId);
		map.put("day", day);
		map.put("ip", posIp);
		double tcash=0;
		double ccash=0;
		//前班交接总额
		double totalSum=0;
		List<Shifting> list=shiftingMapper.searchShifting(map);
		List<Shifting> list2=shiftingMapper.searchMoney(map);
		
		Shifting ft1=shiftingMapper.searchCount(staffId, day,posIp);
		Shifting ticketCash=shiftingMapper.searchTicketCash(staffId, day,posIp);
		Shifting cardCash=shiftingMapper.searchCardCash(staffId, day);//from  yw_charge,查询充值现金
		
		List<CardRecharge> list3=cardMapper.seachCard(map);
		Shifting ticketRefund=shiftingMapper.searchTicketRefund(staffId, day,posIp);//
		/**
		 * 前班交班现金
		 */
		CpShift refundXj=cpShiftMapper.searchRefundXj(day,posIp);
		if(refundXj==null){
			return Jackson.writeJson(StatusResult.create("还无人交班"));
		}
		String  qbjbxj= refundXj.getCpShiftXj();
		//--------------前班交班现金
		List<Shifting> totalRefund=shiftingMapper.searchTotalRefund(map);
		/**
		 * 结班查询当日总营业额 和支付小计，根据ip地址和日期查询当日总营业额和总利润
		 */
		 
		Map<String, String> map4=new HashMap<>();
		
		map4.put("cpShiftPosno", posIp);
		map4.put("cpShiftDate", day);
		List<CpShift> list4=cpShiftMapper.searchCpShiftByParams(map4);
		BigDecimal aa=BigDecimal.ZERO;//当日收银机或者pos机总营业额
		BigDecimal bb=BigDecimal.ZERO;//当日金额小计
		for (CpShift cpShift2 : list4) {
			aa= aa.add(new BigDecimal(cpShift2.getCpShiftYyme()));
			bb= bb.add(new BigDecimal(cpShift2.getCpShiftZfxj()));
		}
		String aaaaa=aa.toString();
		String bbbaa=bb.toString();
		m.addAttribute("aa",aaaaa);
		m.addAttribute("bb",bbbaa);
		//------------------------------
		/**
		 * 查询当日前班的总现金和总利润 
		 */
		CpShift shift=cpShiftMapper.searchQianBan(day,posIp);
		Double qbze=Double.parseDouble(shift.getCpBeiyongTwo());//前班收入总额  
		
		
		if(ticketCash== null){
			tcash =0.0;
		}else{
			tcash = Double.parseDouble(ticketCash.getPayMoney());
		}
		if(cardCash== null){
			ccash = 0.0;
		}else{
			ccash =Double.parseDouble(cardCash.getPayMoney());
		}
		double cash = tcash+ccash;
		double sumMoney = 0.0;
		double disCount = 0.0;
		double tickRefundSum=0.0;
		Integer tickRefund=0;
		System.out.println("ticketRefund:--"+ticketRefund);
		if(ticketRefund == null){
			tickRefund=0;
		}else{
			if(ticketRefund.getTicketRefund() == null){
				tickRefund=0;
			}else{
				tickRefund=ticketRefund.getTicketRefund();
			}
		}
		if(ticketRefund == null ){
			tickRefundSum=0.0;
		}else{
			System.out.println("ticketRefund.getTicketRefundSum():"+ticketRefund.getTicketRefundSum());
			if(StringUtils.isNotEmpty(ticketRefund.getTicketRefundSum())){
				tickRefundSum=Double.parseDouble(ticketRefund.getTicketRefundSum());
			}else{
				tickRefundSum=0.0;
			}
			
		}
		/**
		 * A qiang
		 */
		BigDecimal sumMoney2=BigDecimal.ZERO;
		for (Shifting s : list) {
			//sumMoney+=Double.parseDouble(s.getTicketSum());
			sumMoney2= sumMoney2.add(new BigDecimal(s.getTicketSum()));
			
			disCount+=Double.parseDouble(s.getTicketDiscount());
		}
		sumMoney=sumMoney2.doubleValue();//算结班总营业额
		double paySum=0.0;
		for (Shifting s : list2) {
			paySum +=Double.parseDouble(s.getPayMoney());
		}
		
		/**
		 * 
		 */
		
		Integer payCount = 0;
		double cardSum = 0.0;
		for (CardRecharge c : list3) {
			payCount +=c.getTypeCount();
			cardSum +=c.getTypeSum();
		}
		if(totalRefund.size()>0){
			for (Shifting s : totalRefund) {
				totalSum +=Double.parseDouble(s.getOperatorMoney());
			}
		}
		
		//当班营业明细
		//算结班总营业额-打折钱-退票钱=毛利
		BigDecimal a1=new BigDecimal(Double.toString(sumMoney));
		BigDecimal a2=new BigDecimal(Double.toString(disCount));
		BigDecimal a3=new BigDecimal(Double.toString(tickRefundSum));
		double subtotal=a1.subtract(a2).subtract(a3).doubleValue();
		//计算前班交结总额数据
		BigDecimal dec1=new BigDecimal(qbze).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal dec2=new BigDecimal(subtotal);
		//今日总额
		double preMoney=dec1.add(dec2).doubleValue();
		
		Map<String,String> aaa = new HashMap<String, String>();
		aaa.put("XC_ZFB", "0.00");
		aaa.put("XC_WX", "0.00");
		aaa.put("POS","0.00");
		aaa.put("CASH", "0.00");
		aaa.put("PUBLIC", "0.00");
		aaa.put("RECHARGE", "0.00");
		for(int i =0; i<list2.size();i++){
			if("XC_ZFB".equals(list2.get(i).getPayType()) || "ZNPOS_ZFB".equals(list2.get(i).getPayType())){
				aaa.put("XC_ZFB", list2.get(i).getPayMoney());
			}else if("XC_WX".equals(list2.get(i).getPayType()) || "ZNPOS_WX".equals(list2.get(i).getPayType())){
				aaa.put("XC_WX", list2.get(i).getPayMoney());
			}else if("POS".equals(list2.get(i).getPayType())){
				aaa.put("POS", list2.get(i).getPayMoney());
			}else if("CASH".equals(list2.get(i).getPayType()) || "ZNPOS_CASH".equals(list2.get(i).getPayType())){
				aaa.put("CASH", list2.get(i).getPayMoney());
			}else if("PUBLIC".equals(list2.get(i).getPayType())){
				aaa.put("PUBLIC", list2.get(i).getPayMoney());
			}else if("RECHARGE".equals(list2.get(i).getPayType())){
				aaa.put("RECHARGE", list2.get(i).getPayMoney());
			}
		}
		Map<String, Object> recharge=new HashMap<String,Object>();
		recharge.put("POS", "0.0");
		recharge.put("CASH", "0.0");
		recharge.put("XC_WX", "0.0");
		recharge.put("XC_ZFB", "0.0");
		for (int i = 0; i < list3.size(); i++) {
			if("XC_ZFB".equals(list3.get(i).getPayType())){
				recharge.put("XC_ZFB", list3.get(i).getTypeSum());
			}else if("XC_WX".equals(list3.get(i).getPayType())){
				recharge.put("XC_WX", list3.get(i).getTypeSum());
			}else if("CASH".equals(list3.get(i).getPayType())){
				recharge.put("CASH", list3.get(i).getTypeSum());
			}else if("POS".equals(list3.get(i).getPayType())){
				recharge.put("POS", list3.get(i).getTypeSum());
			}
		}
		m.addAttribute("posIp", posIp);
		m.addAttribute("list", list);
		m.addAttribute("payMoney", sumMoney);//当日营业额
		m.addAttribute("disCount",disCount);//?????
		m.addAttribute("payY", ft1.getPayY());//交易笔数
		m.addAttribute("tickRefund", tickRefund);//退票笔数
		m.addAttribute("tickRefundSum", tickRefundSum);//退票总额
		m.addAttribute("subtotal", subtotal);//结班小计
		m.addAttribute("totalRefund", totalRefund);
		
		
		
		m.addAttribute("list2", aaa);
		m.addAttribute("userId", staffId);
		m.addAttribute("userName", userName);
		
		
		m.addAttribute("payCount", payCount);
		m.addAttribute("paySum", paySum);
		m.addAttribute("recharge", recharge);
		
		m.addAttribute("cardSum", cardSum);
		m.addAttribute("ticketCash", tcash);
		m.addAttribute("cardCash", ccash);
		m.addAttribute("cash", cash);
		m.addAttribute("totalSum", qbze);//前班交接总额
		m.addAttribute("overMoney", preMoney);//结班总额
		/**
		 * 结班交易记录
		 */
		cpShift.setCpShiftPosno(posIp);//ip
		cpShift.setCpShiftDate(day);//班别号
		cpShift.setCpShiftUser(userName);//交班员员工号
		cpShift.setCpShiftUserno(staffId);//结班员工工号
		
		cpShift.setCpShiftYyme(String.valueOf(sumMoney));//当日营业毛额
		cpShift.setCpShiftZhekou(String.valueOf(disCount));//zhekou
		cpShift.setCpShiftJybs(ft1.getPayY().toString());//交易笔数
		cpShift.setCpShiftTpbs(tickRefund.toString());//退票笔数
		cpShift.setCpShiftTpze(String.valueOf(tickRefundSum));//退票总额
		cpShift.setCpShiftZfxj(String.valueOf(subtotal));//交班小计
		//当日支付分类
		cpShift.setCpShiftZfbje(aaa.get("XC_ZFB"));//支付宝
		cpShift.setCpShiftWxje(aaa.get("XC_WX"));//微信支付
		cpShift.setCpShiftXykje(aaa.get("POS"));//信用卡支付
		cpShift.setCpShiftGgkje(aaa.get("PUBLIC"));//公关卡支付
		cpShift.setCpShiftXj(aaa.get("CASH"));//现金支付
		cpShift.setCpShiftCzkje(aaa.get("RECHARGE"));//充值卡
		cpShift.setCpShiftZfxj(String.valueOf(subtotal));//支付小计
		//会员卡充值
		cpShift.setCpShiftWxcz(recharge.get("XC_WX").toString());//微信充值
		/*cpShift.setCpShiftXykcz(recharge.get("POS").toString());//信用卡充值
*/		cpShift.setCpShiftZfbcz(recharge.get("XC_ZFB").toString());//支付宝充值
		cpShift.setCpShiftXjcz(recharge.get("CASH").toString());//现金充值
		cpShift.setCpShiftCzcs(String.valueOf(payCount));//充值次数
		cpShift.setCpShiftCzze(String.valueOf(cardSum));//充值总额
		//柜台明细
		cpShift.setCpShiftJbxj(qbjbxj);//前班交班现金总额
		cpShift.setCpShiftXjsr(String.valueOf(tcash));//现金收入
		cpShift.setCpShiftCzxj(String.valueOf(cardCash));//充值现金金额
		cpShift.setCpBeiyongOne(bbbaa);//当日结班收入
		cpShift.setCpBeiyongTwo(String.valueOf(qbze));//前班交接总额
		
		cpShift.setCpShiftZbzg(String.valueOf(preMoney));//当日总额
		//当班收银
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd HHmmss");
		cpShift.setCpShiftXykcz(nowtime);//交班时间的时间精确到时分秒
		cpShift.setCpShiftDbsy(userName);
		cpShift.setCpShiftXbsy(zdmc);//根据ip查设备名称
		cpShift.setCpShiftType("2");
		cpShiftMapper.insertCpShift(cpShift);
		
		return Jackson.writeJson(StatusResult.create("成功"));
	}
	
	/**
	 * 交班                  1111111
	 * @param m
	 * @param posIp
	 * @return
	 * RestAction pos机权限
	 */
	@RestAction
	@ResponseBody
	@RequestMapping(value = "/duty" , method =RequestMethod.GET)
	public String duty(Model m,String posIp){
		if(StringUtils.isEmpty(posIp)){
			return Jackson.writeJson(StatusResult.create("缺少终端ip"));
		}
		//根据终端ip获取终端名称
		CpTrmmst cpTrmmst=cpTrmmstMapper.seachTrmmstByIp(posIp);
		if(cpTrmmst == null)
			return Jackson.writeJson(StatusResult.create("error", "未找到终端记录【" + posIp + "】"));
		String zdmc=cpTrmmst.getTmDateCanx();
		
		
		CpShift cpShift=new CpShift();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		String staffId = WebContext.getCurrentStaffByToken().getId();//得到登录人的userid
		String userName= WebContext.getCurrentStaffByToken().getName();//得到登录人的name
		String day =df.format(new Date());
		//判断是否存在 存在直接返回
		Map<String, String> mappp=new HashMap<>();
			mappp.put("cpShiftUserno", staffId);
			mappp.put("cpShiftDate", day);
			mappp.put("cpShiftPosno", posIp);
		List<CpShift> list111= cpShiftMapper.searchCpShiftByParams(mappp);
		if(list111.size()>0){
			return Jackson.writeJson(StatusResult.create("你今天已经交过班了"));
		}
		
		Map<String, String> map=new HashMap<>();
		map.put("userId", staffId);
		map.put("ip", posIp);
		map.put("day", day);
		double tcash=0;
		double ccash=0;
		List<Shifting> list=shiftingMapper.searchShifting(map);//根据当前人登录账号和现在的时间查询   from yw_orderitem 
		/**
		 * from yw_order
		 * sum(hw_money) AS 'pay_money' 今天的订单总的实际付款金额
		 * hw_pay_type 'pay_type', 订单的支付类型
		 */

		List<Shifting> list2=shiftingMapper.searchMoney(map);
		
		Shifting ft1=shiftingMapper.searchCount(staffId, day,posIp);
		Shifting ticketCash=shiftingMapper.searchTicketCash(staffId, day,posIp);//总的实付金额
		Shifting cardCash=shiftingMapper.searchCardCash(staffId, day);
		
		List<CardRecharge> list3=cardMapper.seachCard(map);
		Shifting ticketRefund=shiftingMapper.searchTicketRefund(staffId, day,posIp);
		/**
		 * 查看今天的机器号是否已经结班
		 */
		CpShift cpS=cpShiftMapper.searchJieBan(day, posIp);
		System.out.println(cpS);
		if(!org.springframework.util.StringUtils.isEmpty(cpS)){
			return Jackson.writeJson(StatusResult.create("今天已经结过班了"));
		}
		
		
		if(ticketCash== null){
			tcash =0.0;
		}else{
			tcash = Double.parseDouble(ticketCash.getPayMoney());
		}
		if(cardCash== null){
			ccash = 0.0;
		}else{
			ccash =Double.parseDouble(cardCash.getPayMoney());
		}
		double cash = tcash+ccash;
		double sumMoney = 0.0;
		double disCount = 0.0;
		double tickRefundSum=0.0;
		Integer tickRefund=0;
		if(ticketRefund == null){
			tickRefund=0;
		}else{
			if(ticketRefund.getTicketRefund() == null){
				tickRefund=0;
			}else{
				tickRefund=ticketRefund.getTicketRefund();
			}
		}
		if(ticketRefund == null ){
			tickRefundSum=0.0;
		}else{
			if(StringUtils.isNotEmpty(ticketRefund.getTicketRefundSum())){
				tickRefundSum=Double.parseDouble(ticketRefund.getTicketRefundSum());
			}else{
				tickRefundSum=0.0;
			}
			
		}
		/**
		 * A qiang
		 */
		BigDecimal sumMoney2=BigDecimal.ZERO;
		for (Shifting s : list) {
			sumMoney2= sumMoney2.add(new BigDecimal(s.getTicketSum()));
			disCount+=Double.parseDouble(s.getTicketDiscount());
		}
		sumMoney=sumMoney2.doubleValue();//算结班总营业额
		double paySum=0.0;
		
		for (Shifting s : list2) {
			paySum +=Double.parseDouble(s.getPayMoney());
		}
		Integer payCount = 0;
		double cardSum = 0.0;
		for (CardRecharge c : list3) {
			payCount +=c.getTypeCount();
			cardSum +=c.getTypeSum();
		}
		//当班营业明细
		//算结班总营业额-打折钱-退票钱=毛利
		BigDecimal a1=new BigDecimal(Double.toString(sumMoney));
		BigDecimal a2=new BigDecimal(Double.toString(disCount));
		BigDecimal a3=new BigDecimal(Double.toString(tickRefundSum));
		double subtotal=a1.subtract(a2).subtract(a3).doubleValue();
		
		m.addAttribute("posIp", posIp);
		m.addAttribute("list", list);
		m.addAttribute("payMoney", sumMoney);
		m.addAttribute("disCount",disCount);
		m.addAttribute("payY", ft1.getPayY());
		m.addAttribute("tickRefund", tickRefund);
		m.addAttribute("tickRefundSum", tickRefundSum);
		m.addAttribute("subtotal", subtotal);
		
		//当日支付分类
		Map<String,String> aaa = new HashMap<String, String>();
		aaa.put("XC_ZFB", "0.0");
		aaa.put("XC_WX", "0.0");
		aaa.put("POS","0.0");
		aaa.put("CASH", "0.0");
		aaa.put("PUBLIC", "0.0");
		aaa.put("RECHARGE", "0.0");
		for(int i =0; i<list2.size();i++){
			if("XC_ZFB".equals(list2.get(i).getPayType()) || "ZNPOS_ZFB".equals(list2.get(i).getPayType())){
				aaa.put("XC_ZFB", list2.get(i).getPayMoney());
			}else if("XC_WX".equals(list2.get(i).getPayType()) || "ZNPOS_WX".equals(list2.get(i).getPayType())){
				aaa.put("XC_WX", list2.get(i).getPayMoney());
			}else if("POS".equals(list2.get(i).getPayType()) || "ZNPOS_CARD".equals(list2.get(i).getPayType())){
				aaa.put("POS", list2.get(i).getPayMoney());
			}else if("CASH".equals(list2.get(i).getPayType()) || "ZNPOS_CASH".equals(list2.get(i).getPayType())){
				aaa.put("CASH", list2.get(i).getPayMoney());
			}else if("PUBLIC".equals(list2.get(i).getPayType())){
				aaa.put("PUBLIC", list2.get(i).getPayMoney());
			}else if("RECHARGE".equals(list2.get(i).getPayType())){
				aaa.put("RECHARGE", list2.get(i).getPayMoney());
			}
		}
		//会员卡充值
		Map<String, Object> recharge=new HashMap<String,Object>();
		recharge.put("POS", "0.0");
		recharge.put("CASH", "0.0");
		recharge.put("XC_WX", "0.0");
		recharge.put("XC_ZFB", "0.0");
		for (int i = 0; i < list3.size(); i++) {
			if("XC_ZFB".equals(list3.get(i).getPayType())){
				recharge.put("XC_ZFB", list3.get(i).getTypeSum());
			}else if("XC_WX".equals(list3.get(i).getPayType())){
				recharge.put("XC_WX", list3.get(i).getTypeSum());
			}else if("CASH".equals(list3.get(i).getPayType())){
				recharge.put("CASH", list3.get(i).getTypeSum());
			}else if("POS".equals(list3.get(i).getPayType())){
				recharge.put("POS", list3.get(i).getTypeSum());
			}
		}
		m.addAttribute("list2", aaa);
		m.addAttribute("userId", staffId);
		m.addAttribute("userName", userName);
		
		
		m.addAttribute("payCount", payCount);
		m.addAttribute("paySum", paySum);
		m.addAttribute("recharge", recharge);
		
		m.addAttribute("cardSum", cardSum);
		m.addAttribute("ticketCash", tcash);
		m.addAttribute("cardCash", ccash);
		m.addAttribute("cash", cash);
		
		
		
		/**
		 * 交结班表里记录数据
		 */
		cpShift.setCpShiftPosno(posIp);//Pos机ID
		cpShift.setCpShiftDate(day);//班别号
		cpShift.setCpShiftUser(userName);//交班员员姓名
		cpShift.setCpShiftUserno(staffId);//交班员工工号
		
		cpShift.setCpShiftYyme(String.valueOf(sumMoney));//当日营业额
		cpShift.setCpShiftZhekou(String.valueOf(disCount));//zhekou
		cpShift.setCpShiftJybs(ft1.getPayY().toString());//交易笔数
		cpShift.setCpShiftTpbs(tickRefund.toString());//退票笔数
		cpShift.setCpShiftTpze(String.valueOf(tickRefundSum));//退票总额
		cpShift.setCpShiftZfxj(String.valueOf(subtotal));//交班小计
		//当日支付分类
		cpShift.setCpShiftWxje(aaa.get("XC_WX"));//微信支付
		cpShift.setCpShiftZfbje(aaa.get("XC_ZFB"));//支付宝
		cpShift.setCpShiftXykje(aaa.get("POS"));//信用卡支付
		cpShift.setCpShiftGgkje(aaa.get("PUBLIC"));//公关卡支付
		cpShift.setCpShiftXj(aaa.get("CASH"));//现金支付
		cpShift.setCpShiftCzkje(aaa.get("RECHARGE"));//充值卡
		cpShift.setCpShiftZfxj(String.valueOf(subtotal));//当日支付小计
		//会员卡充值
		cpShift.setCpShiftWxcz(recharge.get("XC_WX").toString());//微信充值
		/*cpShift.setCpShiftXykcz(recharge.get("POS").toString());//信用卡充值
*/		cpShift.setCpShiftZfbcz(recharge.get("XC_ZFB").toString());//支付宝充值
		cpShift.setCpShiftXjcz(recharge.get("CASH").toString());//现金充值
		cpShift.setCpShiftCzcs(String.valueOf(payCount));//充值次数
		cpShift.setCpShiftCzze(String.valueOf(cardSum));//充值总额
		//柜台明细
		cpShift.setCpShiftXjsr(String.valueOf(tcash));//现金收入
		cpShift.setCpShiftCzxj(String.valueOf(cardCash));//充值现金金额
		//当班收银
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd HHmmss");
		cpShift.setCpShiftXykcz(nowtime);//交班时间的时间精确到时分秒
		cpShift.setCpShiftDbsy(userName);
		cpShift.setCpShiftXbsy(zdmc);//终端名称
		cpShift.setCpShiftZbzg("");
		cpShift.setCpShiftType("1");
		cpShiftMapper.insertCpShift(cpShift);
		
		
		return Jackson.writeJson(StatusResult.create("成功"));
	}
}
