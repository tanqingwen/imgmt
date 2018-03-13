package cn.happyworlds.imgmt.web;


import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.cmp.OOBCertHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.ls.LSInput;

import cn.happyworlds.imgmt.entity.CardRecharge;
import cn.happyworlds.imgmt.entity.CpShift;
import cn.happyworlds.imgmt.entity.Shifting;
import cn.happyworlds.imgmt.mapper.CardRechargeMapper;
import cn.happyworlds.imgmt.mapper.CpShiftMapper;
import cn.happyworlds.imgmt.mapper.CpTrmmstMapper;
import cn.happyworlds.imgmt.mapper.ShiftingMapper;
import cn.happyworlds.imgmt.util.SysDateFormat;

@CrossOrigin
@Controller
@RequestMapping("/shifting")
public class ShiftingController {
	
	@Autowired
	private ShiftingMapper shiftingMapper;
	
	@Autowired
	private CardRechargeMapper cardMapper;
	
	@Autowired
	private CpShiftMapper cpShiftMapper;
	
	@Autowired
	private CpTrmmstMapper cpTrmmstMapper;
	
	
	
	@WebAction(Permission.YWRESTAURANT_LIST)
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
	 * @throws UnknownHostException 
	 */
	@WebAction(Permission.YWRESTAURANT_LIST)
	@RequestMapping(value = "/shift" , method =RequestMethod.GET)
	public String shift(Model m,String ip) throws UnknownHostException{
		if(ip==null){
			m.addAttribute("tip_msg", "ip为空");
			return "shifting/add";
		}
		CpShift cpShift=new CpShift();//结班
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		System.out.println(df.format(new Date()));
		
		/**
		 * 获取本机ip
		 */
		String localip=ip;
		
		String staffId = WebContext.getCurrentStaff().getId();//得到登录人id
		String userName=WebContext.getCurrentStaff().getName();//得到登录人姓名
		
		String day =df.format(new Date());
		Map<String, String> map=new HashMap<>();
		map.put("userId", staffId);
		map.put("day", day);
		map.put("ip", localip);
		// <--判断是否存在 存在直接返回验证shuju是否存在
		Map<String, String> mappp=new HashMap<>();
			mappp.put("cpShiftUserno", staffId);
			mappp.put("cpShiftDate", day);
			mappp.put("cpShiftPosno", ip);
		List<CpShift> list111= cpShiftMapper.searchCpShiftByParams(mappp);
		System.out.println(list111.size());
		if(list111.size()>0){
			m.addAttribute("tip_msg", "你今天的班次已提交");
			return "shifting/add";
		}
		/**
		 * 查看今天的机器号是否已经结班
		 */
		CpShift cpS=cpShiftMapper.searchJieBan(day, localip);
		System.out.println(cpS);
		if(!org.springframework.util.StringUtils.isEmpty(cpS)){
			m.addAttribute("tip_msg", "今天已经结过班了");
			return "shifting/add";
		}
		
		double tcash=0;
		double ccash=0;
		//前班交接总额
		double totalSum=0;
		/**
		 * from   yw_orderitem
		 */
		List<Shifting> list=shiftingMapper.searchShifting(map);//根据员工工号、当前日期、ip地址  查询Shifting
		
		/**
		 * from yw_order
		 */
		List<Shifting> list2=shiftingMapper.searchMoney(map);//根据员工工号和当前日期查询Money
		
		Shifting ft1=shiftingMapper.searchCount(staffId, day,localip); 
		Shifting ticketCash=shiftingMapper.searchTicketCash(staffId, day,localip);
		Shifting cardCash=shiftingMapper.searchCardCash(staffId, day);//from  yw_charge,查询充值现金
		
		map.put("posIp", localip);
		List<CardRecharge> list3=cardMapper.seachCard(map);
		Shifting ticketRefund=shiftingMapper.searchTicketRefund(staffId, day,localip);
		/**
		 * 前班交班现金
		 */
		CpShift refundXj=cpShiftMapper.searchRefundXj(day,localip);
		if(refundXj==null){
			m.addAttribute("tip_msg","还无人交班");
			return "shifting/add";
		}
		String  qbjbxj= refundXj.getCpShiftXj();
		//前班交班现金
		List<Shifting> totalRefund=shiftingMapper.searchTotalRefund(map);
		
		/**
		 * 结班查询当日总营业额 和支付小计，根据ip地址和日期查询当日总营业额和总利润
		 */
		Map<String, String> map4=new HashMap<>();
		
		map4.put("cpShiftPosno", localip);
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
		CpShift shift=cpShiftMapper.searchQianBan(day,localip);
		if(shift==null){
			m.addAttribute("tip_msg", "订单数据有误");
			return "shifting/add";
		}
		Double qbze=Double.parseDouble(shift.getCpBeiyongTwo());//前班总额  
		
		
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
		m.addAttribute("posIp", localip);//收银ip
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
		m.addAttribute("totalSum", qbze);//前班交班总额
		m.addAttribute("overMoney", preMoney);//当日结班总额
		m.addAttribute("QBJBXJ",qbjbxj);//前班交班现金总额
		/**
		 * 结班交易记录
		 */
		
		cpShift.setCpShiftPosno(localip);//ip
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
		cpShift.setCpShiftXbsy("");
		cpShift.setCpShiftType("2");
		cpShiftMapper.insertCpShift(cpShift);
		//
		cpShift.setCpMerchantNo("");
		
		
		
		return "shifting/shift";
	}
	
	private HttpServletRequest getRequest() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 交班                  111111111111111111111111111111111111111111111111111111
	 * @param m
	 * @param posIp
	 * @return
	 * @throws UnknownHostException 
	 */
	@WebAction(Permission.YWRESTAURANT_LIST)
	@RequestMapping(value = "/duty" , method =RequestMethod.GET)
	public String duty(Model m,String ip) throws UnknownHostException{
		if(ip==null){
			m.addAttribute("tip_msg", "ip为空");
			return "shifting/add";
		}
		CpShift cpShift=new CpShift();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		/**
		 * 获取本机ip
		 */
		/*InetAddress ia =null;
		ia=ia.getLocalHost();
		String localname=ia.getHostName();*/
		String localip=ip;
		/**
		 * 
		 */
		String staffId = WebContext.getCurrentStaff().getId();//得到登录人的userid
		String userName= WebContext.getCurrentStaff().getName();//得到登录人的name
		String day =df.format(new Date());
		Map<String, String> map=new HashMap<>();
		map.put("userId", staffId);
		map.put("day", day);
		map.put("ip", localip);
		// <--判断是否存在 存在直接返回验证shuju是否存在
		Map<String, String> mappp=new HashMap<>();
			mappp.put("cpShiftUserno", staffId);
			mappp.put("cpShiftDate", day);
			mappp.put("cpShiftPosno", ip);
		List<CpShift> list111= cpShiftMapper.searchCpShiftByParams(mappp);
		System.out.println(list111.size());
		if(list111.size()>0){
			m.addAttribute("tip_msg", "你今天已经交过班了");
			return "shifting/add";
		}
		/**
		 * 查看今天的机器号是否已经结班
		 */
		CpShift cpS=cpShiftMapper.searchJieBan(day, localip);
		System.out.println(cpS);
		if(!org.springframework.util.StringUtils.isEmpty(cpS)){
			m.addAttribute("tip_msg", "今天已经结过班了");
			return "shifting/add";
		}
		
		double tcash=0;
		double ccash=0;
		
		/**
		 * from   yw_orderitem
		 * 
		 * hw_ticketname AS 'ticket_name'票名
		 * count(hw_prodct_group) AS 'ticket_count' 门票类别的数量
		 * sum(hw_unit_price) AS 'ticket_sum' 单个票类型的总额 （当班营业额）
		 * hw_prodct_group AS 'ticket_id', 门票类别的id
		 * sum(=hw_unit_price - hw_amount * hw_discount=) AS 'ticket_discount'  // (原价-折扣后的价格*dis_count)
		 * 现在改为sum(=hw_unit_price - hw_amount ) AS 'ticket_discount'  // 折扣价
		 */
		List<Shifting> list=shiftingMapper.searchShifting(map);//根据员工工号和当前日期查询Shifting
		
		/**
		 * from yw_order
		 * sum(hw_money) AS 'pay_money' 今天的订单总的实际付款金额
		 * hw_pay_type 'pay_type', 订单的支付类型
		 */
		List<Shifting> list2=shiftingMapper.searchMoney(map);//根据员工工号和当前日期查询Money
		
		
		/**
		 * count(1) AS 'pay_y' 查今天订单成功付款次数
		 */
		Shifting ft1=shiftingMapper.searchCount(staffId, day,localip);
		/**
		 * sum(hw_money) AS 'pay_money' 查询总的现金收入   from yw_order
		 */
		Shifting ticketCash=shiftingMapper.searchTicketCash(staffId, day,localip);
		/**
		 * 查询充值金额现金  from yw_charge
		 */
		Shifting cardCash=shiftingMapper.searchCardCash(staffId, day);
		
		
		map.put("posIp", ip);
		/**
		 * from  yw_order
		 * hw_pay_type AS 'pay_type' 支付类型
		 * 
		 * AND hw_type = '2' 订单类型为2    2表示充值
		 * 
		 */
		List<CardRecharge> list3=cardMapper.seachCard(map);
		
		/**
		 * 查询退票 
		 * 
		 */
		Shifting ticketRefund=shiftingMapper.searchTicketRefund(staffId, day,localip);
		if(ticketCash== null){
			tcash =0.0;
		}else{
			tcash = Double.parseDouble(ticketCash.getPayMoney());//支付现金总额
		}
		if(cardCash== null){
			ccash = 0.0;
		}else{
			ccash =Double.parseDouble(cardCash.getPayMoney());//充值现金总额
		}
		double cash = tcash+ccash;//总现金收入
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
				tickRefund=ticketRefund.getTicketRefund();//退票笔数
			}
		}
		if(ticketRefund == null ){
			tickRefundSum=0.0;
		}else{
			if(StringUtils.isNotEmpty(ticketRefund.getTicketRefundSum())){
				tickRefundSum=Double.parseDouble(ticketRefund.getTicketRefundSum());//退票总额
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
		sumMoney=sumMoney2.doubleValue();//算交班总营业额
		double paySum=0.0;
		/**
		 * list2
		 * from yw_order
		 * sum(hw_money) AS 'pay_money' 今天的订单总的实际付款金额
		 * hw_pay_type 'pay_type', 订单的支付类型
		 */
		for (Shifting s : list2) {
			paySum +=Double.parseDouble(s.getPayMoney());//实际付款总金额
		}
		Integer payCount = 0;
		double cardSum = 0.0;
		for (CardRecharge c : list3) {
			payCount +=c.getTypeCount();
			cardSum +=c.getTypeSum();
		}
		double subtotal=paySum-disCount-tickRefundSum;
		BigDecimal a1=new BigDecimal(Double.toString(sumMoney));
		BigDecimal a2=new BigDecimal(Double.toString(disCount));
		BigDecimal a3=new BigDecimal(Double.toString(tickRefundSum));
		subtotal=a1.subtract(a2).subtract(a3).doubleValue();
		System.out.println(subtotal);//实际付款总金额-折扣钱-退票总额
		
		
		
		m.addAttribute("posIp", localip);
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
		m.addAttribute("paySum", subtotal);    //支付小计
		m.addAttribute("recharge", recharge);
		
		m.addAttribute("cardSum", cardSum);
		m.addAttribute("ticketCash", aaa.get("CASH"));//票现金
		m.addAttribute("cardCash", ccash);
		m.addAttribute("cash", aaa.get("CASH"));
		
		
		
		/**
		 * 交结班表里记录数据
		 */
		cpShift.setCpShiftPosno(localip);//Pos机ID
		cpShift.setCpShiftDate(day);//班别号
		cpShift.setCpShiftUser(userName);//交班员员姓名
		cpShift.setCpShiftUserno(staffId);//交班员工工号
		
		cpShift.setCpShiftYyme(String.valueOf(sumMoney));//当日营业额
		cpShift.setCpShiftZhekou(String.valueOf(disCount));//zhekou
		cpShift.setCpShiftJybs(ft1.getPayY().toString());//交易笔数
		cpShift.setCpShiftTpbs(tickRefund.toString());//退票笔数
		cpShift.setCpShiftTpze(String.valueOf(tickRefundSum));//退票总额
		cpShift.setCpShiftJbxj(String.valueOf(subtotal));//交班小计
		//当日支付分类
		cpShift.setCpShiftWxje(aaa.get("XC_WX"));//微信支付
		cpShift.setCpShiftZfbje(aaa.get("XC_ZFB"));//支付宝
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
		cpShift.setCpShiftXjsr(String.valueOf(tcash));//现金收入
		cpShift.setCpShiftCzxj(String.valueOf(cardCash));//充值现金金额
		//当班收银
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd HHmmss");
		cpShift.setCpShiftXykcz(nowtime);//交班时间的时间精确到时分秒
		cpShift.setCpShiftDbsy(userName);
		//	cpShift.setCpShiftXbsy(zdmc);//终端名称
		cpShift.setCpShiftType("1");
		cpShiftMapper.insertCpShift(cpShift);
		
		return "shifting/duty";
	}
}
