package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.bean.HappyCardBean;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.District;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.TicketShoppingCart;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.DistrictMapper;
import cn.happyworlds.imgmt.mapper.ReCpTicketMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.mapper.TicketShoppingCartMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Digests;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.StringUtil;
import cn.happyworlds.imgmt.util.SysDateFormat;
import cn.happyworlds.imgmt.util.ToolsUtil;
import cn.happyworlds.imgmt.web.Permission;
import cn.happyworlds.imgmt.web.WebAction;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class CartTicketService {

	@Autowired
	private CpTicketMapper cpTicketMapper;
	@Autowired
	private ReCpTicketMapper reCpTicketMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	@Autowired
	private YwOrderitemMapper yworderitemMapper;
	@Autowired
	private CpCeptrxMapper cpCeptrxMapper;
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpTktypeMapper cpTktypeMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private CrdtblService crdtblService;
	@Autowired
	private DistrictMapper districtMapper;
	@Autowired
	private TicketShoppingCartMapper ticketshoppingcartMapper;
	@Autowired
	private BuyCpprdgrpService buyCpprdgrpService;
	@Autowired
	private TicketService ticketService;
	
	

	/**
	 * 
	 * @param cbIdType				证件类型
	 * @param cbCustomerIdno		身份证号
	 * @param cbCustomerName		身份证姓名
	 * @param cbMobileNo			手机号
	 * @param CbDob					出生日期
	 * @param prProdctGroup			会员等级
	 * @param Address				身份证住址
	 * @return
	 */
	public StatusResult<CpCsttbl> cpcsttbladd(String cbIdType,String cbCustomerIdno,String cbCustomerName ,String cbMobileNo,String CbDob,String Address){
		Long newcsttbl = 0L;
		CpCsttbl csttbl = new CpCsttbl();
		csttbl.setCbMemberCode(automaticgrowthService.sqlNextHuiyuan("ID"));
		csttbl.setCbIdType(cbIdType.substring(0,1));							
		csttbl.setCbCustomerIdno(cbCustomerIdno);			
		csttbl.setCbCardholderName(cbCustomerName);
		csttbl.setCbDob(CbDob);
		csttbl.setCbMobileNo(cbMobileNo);
		if(cbCustomerIdno.length()!=18){
			
		}else if(cbCustomerIdno.length()==18){
			String CbSex = cbCustomerIdno.substring(16, 17);
			if(Integer.parseInt(CbSex)%2==0 ){
				csttbl.setCbSex("F");
			}else{
				csttbl.setCbSex("M");
			}		
			csttbl.setCbHomePhone(cbMobileNo);
			csttbl.setCbHomeAddr1(Address);
			csttbl.setCbAlt2BillAddr2("0");
			String cbHomeState = cbCustomerIdno.substring(0, 2);
			cbHomeState = cbHomeState+"0000";
			District district2  = districtMapper.searchDistrictByCode(cbHomeState);
			if(StringUtils.isEmpty(district2)){
				return StatusResult.create("FALSE","身份证号码没有找到对应的省");
			}
			csttbl.setCbHomeState(district2.getName()+district2.getSuffix());
		}
		try {
						
			newcsttbl=cpCsttblMapper.insertCpCsttbl(csttbl);
		} finally {
			if(newcsttbl <= 0){
				return StatusResult.create("FALSE","添加会员数据失败");
			}
		}	
		CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cbCustomerIdno);
		return StatusResult.create(cpcsttbl);
	
	}
	public StatusResult<CpCsttbl> hahaha(String cbIdType,String cbCustomerIdno,String cbCustomerName ,String cbMobileNo,String CbDob,String prProdctGroup,String Address){
		Long newcsttbl = 0L;
		if(cbCustomerIdno.length()!=18){
			return StatusResult.create("FALSE","身份证号码长度不足18位");
		}
		String CbSex = cbCustomerIdno.substring(16, 17);
		CpCsttbl csttbl = new CpCsttbl();
		csttbl.setCbMemberCode(automaticgrowthService.sqlNextHuiyuan("ID"));
		csttbl.setCbIdType(cbIdType);							
		csttbl.setCbCustomerIdno(cbCustomerIdno);			
		csttbl.setCbCardholderName(cbCustomerName);
		csttbl.setCbDob(CbDob);
		csttbl.setCbMobileNo(cbMobileNo);
		if(Integer.parseInt(CbSex)%2==0 ){
			csttbl.setCbSex("F");
		}else{
			csttbl.setCbSex("M");
		}		
		csttbl.setCbHomePhone(cbMobileNo);
		csttbl.setCbNricIssuIdno(prProdctGroup);
		csttbl.setCbHomeAddr1(Address);
		//获取身份证前6位来判断是属于什么县
		String cbHomeCity = cbCustomerIdno.substring(0, 6);
		System.out.println("cbHomeCity"+cbHomeCity);
		District district  = districtMapper.searchDistrictByCode(cbHomeCity);
		if(StringUtils.isEmpty(district)){
			return StatusResult.create("FALSE","身份证号码没有找到对应的县");
		}
		csttbl.setCbHomeCity(district.getName()+district.getSuffix());
		//获取身份证前6位来判断是属于什么省
		String cbHomeState = cbCustomerIdno.substring(0, 2);
		cbHomeState = cbHomeState+"0000";
		System.out.println("cbHomeState"+cbHomeState);
		District district2  = districtMapper.searchDistrictByCode(cbHomeState);
		if(StringUtils.isEmpty(district2)){
			return StatusResult.create("FALSE","身份证号码没有找到对应的省");
		}
		csttbl.setCbHomeState(district2.getName()+district2.getSuffix());
		try {
						
			newcsttbl=cpCsttblMapper.insertCpCsttbl(csttbl);
		} finally {
			if(newcsttbl <= 0){
				return StatusResult.create("FALSE","添加会员数据失败");
			}
		}	
		CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cbCustomerIdno);
		return StatusResult.create(cpcsttbl);
	}
	
	/**
	 * 会员卡绑定方法
	 * @param cpcsttbl				会员对象
	 * @param ticketform			票劵形式（11虚拟卡，12实体卡）
	 * @param cbCardholderNo		卡号（票劵形式等于12才会用到）
	 * @param cBrwdsAccno			卡面流水号（票劵形式等于12才会用到）
	 * @param prProdctGroup			会员等级
	 * @param staffId				操作人员
	 * @return
	 */
	public StatusResult<CpCrdtbl> CpCrdtlbadd(CpCsttbl cpcsttbl,String cbCardholderNo,String cBrwdsAccno, String staffId){
		System.out.println("_______________________进人会员卡绑定方法_______________________");
		Long return_cpCrdtbl = 0L;
		Long ceptrx = 0L;
		CpCrdtbl cpcrdtbl = new CpCrdtbl();
		CpCrdtbl cp___crdtbl = cpCrdtblMapper.searchCpCrdtblByCbIdno(cpcsttbl.getCbCustomerIdno());
		if(cp___crdtbl != null){
			return StatusResult.create("FALSE", "用户已绑定卡，不能在绑卡");
		}
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("cbCardholderNo", "333502"+cbCardholderNo);
		//params.put("cbRwdsAccno", cBrwdsAccno);
		List<CpCrdtbl> list = cpCrdtblMapper.searchCpCrdtblByParams(params);
		if(list.size()==0){
			return StatusResult.create("FALSE", "没有找到对应的卡号");
		}
		cpcrdtbl = list.get(0);		
		
		cpcrdtbl.setCbIdType("1");//由预制卡改为可用卡	
		cpcrdtbl.setCbIdno(cpcsttbl.getCbCustomerIdno());	
		cpcrdtbl.setCbBscIdType("1");//由预制卡改为可用卡
		cpcrdtbl.setCbBasicCustomerIdno(cpcsttbl.getCbCustomerIdno());
		cpcrdtbl.setCbEmbossname(cpcsttbl.getCbCardholderName());
		cpcrdtbl.setCbSourceCd(cpcsttbl.getCbMobileNo());//手机号
		cpcrdtbl.setCbPlasticCd("U");				
		cpcrdtbl.setCbReserveDate(DateTimes.nowDate());
		cpcrdtbl.setCbReinstateDate(DateTimes.nowTime());
		cpcrdtbl.setCbModDate(DateTimes.nowDate());
		cpcrdtbl.setCbModUser(staffId);
		try {
			return_cpCrdtbl=cpCrdtblMapper.updateCpCrdtbl(cpcrdtbl);	
		} finally {
			if(return_cpCrdtbl <= 0){
				return StatusResult.create("FALSE", "绑定卡表失败");
			}
		}
		BigDecimal messageid = null;
		CpCeptrx cpCeptrx = new CpCeptrx();
		cpCeptrx.setCtBranchId(cpcrdtbl.getCbCentreCd());
		Long tranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");// 交易tranId
		cpCeptrx.setCtTranId(tranId);
		messageid = sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
		CpIndacc cpindacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpcrdtbl.getCbIndividualAcctno());
		cpCeptrx.setCtMessageId(messageid.longValue());
		cpCeptrx.setCtCardNumber(cpcrdtbl.getCbCardholderNo());
//		cpCeptrx.setCtTranTime(DateTimes.nowTime());
		cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
		cpCeptrx.setCtDbCr("C");
		cpCeptrx.setCtTranAmount(BigDecimal.ZERO);
		cpCeptrx.setCtCardAmount(cpCeptrx.getCtTranAmount());
		cpCeptrx.setCtDescription("开卡");
		cpCeptrx.setCtCurrcode("156");
		cpCeptrx.setCtApproveTime(DateTimes.nowTimestamp());
		cpCeptrx.setCtPostTime(DateTimes.nowDate());
		cpCeptrx.setCtAccountId(cpindacc.getCbIndividualAcctno());
		cpCeptrx.setCtTranCode("OPENCARD");
		cpCeptrx.setCtStmtDate(DateTimes.nowTime());
		cpCeptrx.setCtTxrnType("C");
		cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
		cpCeptrx.setCtBillCurrAmt(cpCeptrx.getCtTranAmount());
		cpCeptrx.setCtAgeCodeB4Post("00");
		cpCeptrx.setCtAgeCodeAfterPost("00");
		cpCeptrx.setCtReversalFlag("0");
		cpCeptrx.setCtOutstdB4Post(BigDecimal.ZERO);
		cpCeptrx.setCtOutstdAfterPost(cpindacc.getCbOutstdBal());
		cpCeptrx.setCtUserCreate(staffId);
		cpCeptrx.setCtStatus("0");
		cpCeptrx.setCtDc("0");
		cpCeptrx.setCtTranNum("1");
		cpCeptrx.setCtTranZone("0");
		cpCeptrx.setCtOpenZone("0");
		cpCeptrx.setCtCustomerId(cpindacc.getCbCustomerId());
		try {
			ceptrx = cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
		} finally {
			if(ceptrx<=0){
				StatusResult.create("FALSE","添加开卡记录失败");
			}
		}	
		return StatusResult.create(cpcrdtbl);
	}
	
	/**
	 * 会员充值方法
	 * @param crdtbl			会员对象
	 * @param amount			充值金额
	 * @param staffId			操作员
	 * @return
	 */
	public StatusResult<String> cpindaccupdate(CpCrdtbl crdtbl, String amount,String staffId){
		System.out.println("_______________________进人会员充值方法_______________________");
		Long return_cpindacc = 0L;
		Long ceptrx = 0L;
		BigDecimal messageid = null;
		BigDecimal ac_amount = new BigDecimal(amount);
		CpIndacc cpindacc = cpIndaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
		BigDecimal balance = BigDecimal.ZERO;
		balance = cpindacc.getCbOutstdBal();
		if(null==cpindacc.getCbOutstdBal()){
			cpindacc.setCbOutstdBal(ac_amount);
		}else{
			cpindacc.setCbOutstdBal(cpindacc.getCbOutstdBal().add(ac_amount));
		}
		try {
			return_cpindacc=cpIndaccMapper.updateCpIndacc(cpindacc);
		} finally {
			if(return_cpindacc <= 0 ){
				return StatusResult.create("FALSE","更新账户表失败");
			}
		}
		CpCeptrx cpCeptrx = new CpCeptrx();
		cpCeptrx.setCtBranchId(crdtbl.getCbCentreCd());		
		Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
		cpCeptrx.setCtTranId(tranId);		
		messageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
		//end					
		cpCeptrx.setCtMessageId(messageid.longValue());
		cpCeptrx.setCtCardNumber(crdtbl.getCbCardholderNo());
//		cpCeptrx.setCtTranTime(DateTimes.nowTime());
		cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
		cpCeptrx.setCtDbCr("C");
		cpCeptrx.setCtTranAmount(ac_amount.negate());
		cpCeptrx.setCtCardAmount(ac_amount);
		cpCeptrx.setCtDescription("充值");
		cpCeptrx.setCtCurrcode("156");
		cpCeptrx.setCtApproveTime(DateTimes.nowTimestamp());
		//cpCeptrx.setCtPostTime(null);
		cpCeptrx.setCtAccountId(cpindacc.getCbIndividualAcctno());
		cpCeptrx.setCtTranCode("DEPOSIT");
		cpCeptrx.setCtStmtDate(DateTimes.nowTime());
		cpCeptrx.setCtTxrnType("C");
		cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
		cpCeptrx.setCtBillCurrAmt(ac_amount);
		cpCeptrx.setCtAgeCodeB4Post("00");
		cpCeptrx.setCtAgeCodeAfterPost("00");
		cpCeptrx.setCtReversalFlag("0");
		cpCeptrx.setCtOutstdB4Post(balance);
		cpCeptrx.setCtOutstdAfterPost(cpindacc.getCbOutstdBal());
		cpCeptrx.setCtUserCreate(staffId);
		cpCeptrx.setCtStatus("0");
		cpCeptrx.setCtDc("0");
		cpCeptrx.setCtTranNum("1");
		cpCeptrx.setCtTranZone("0");
		cpCeptrx.setCtOpenZone("0");
		cpCeptrx.setCtCustomerId(cpindacc.getCbCustomerId());
		try {
			ceptrx = cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
		} finally {
			if(ceptrx <= 0){
				return StatusResult.create("FALSE","添加流水表数据失败");
			}
		}
		
		return StatusResult.create("OK","充值成功");
	}
	/**
	 * 卡和票劵绑定                               用的是这个---------------------------------
	 * @param tktypeStr				票劵ID
	 * @param cpcrdtbl				会员对象
	 * @param cpcsttbl				卡对象
	 * @return
	 * @throws ParseException 
	 */
	@Transactional
	public StatusResult<String> cpticketdanrenadd(CpCrdtbl cpcrdtbl,CpCsttbl cpcsttbl,YwOrderitem yworderitem) throws ParseException{
		System.out.println("_______________________进人会员票劵绑卡方法_______________________");
		Long return_cpticket = 0L;
		Long return_cpceptrx =0L;
		if(StringUtils.isEmpty(yworderitem.getHwProdctGroup())){
			return StatusResult.create("FALSE", "票劵ID为空");
		}
		CpIndacc cpindacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpcrdtbl.getCbIndividualAcctno());
		if(StringUtils.isEmpty(cpindacc)){
			return StatusResult.create("FALSE", "没有找到对应的账户");
		}
		CpTktype cptktype = cpTktypeMapper.searchCpTktypeByTtTypeId(Integer.parseInt(yworderitem.getHwProdctGroup()));
		if(StringUtils.isEmpty(cptktype)){
			return StatusResult.create("FALSE", "票劵ID未找到,请查看是否有误");
		}
		//创建卡门票映射表
		CpTicket cpticket=new CpTicket();
		//调用数据库函数，自动增长列
		//Long ticketId=sequenceMapper.searchNexttkToTicketId("TICEKTSEQ");
		cpticket.setTkTicketId(Long.valueOf(yworderitem.getHwOrderitemId()));
		//卡号
		cpticket.setTkCardNo(cpcrdtbl.getCbCardholderNo());
		cpticket.setTkStatus("T");
		//票劵ID
		cpticket.setTkTicketType(Long.parseLong(yworderitem.getHwProdctGroup()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//购票日期
		/**
		 * ????? A   qiang
		 */
		String piao=yworderitem.getHwProdctGroup();
		CpTktype tktype=cpTktypeMapper.searchCpTktype(piao);
		String strDate= tktype.getCouponDate();
//		if(StringUtils.isEmpty(strDate)){
			Date effectiveDate = new Date();  //生效日期
			Calendar calendar=Calendar.getInstance();			  
			try {
				if(!StringUtils.isEmpty(yworderitem.getHwVisitTime())){
					effectiveDate = DateUtils.parseDate(yworderitem.getHwVisitTime(), new String[]{"yyyyMMdd","yyyyMMdd HHmmss"});
				}
				calendar.setTime(sdf.parse(sdf.format(effectiveDate)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cpticket.setTkEffectiveDate(sdf.format(new Date()));//系统日期
			calendar.add(Calendar.DATE,cptktype.getTtExpirePeriod());
			//购票日期往后推一个月
			cpticket.setTkExpireDate(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
//		}else{
//			
//			int days= tktype.getCouponDays();
//			Date date=sdf.parse(strDate);
//			Calendar cal=Calendar.getInstance();
//			cal.setTime(date);
//			cal.add(Calendar.DAY_OF_YEAR, days);
//			Date date2=cal.getTime();
//			String dateee=sdf.format(date2);
//			cpticket.setTkEffectiveDate(strDate);
//			cpticket.setTkExpireDate(dateee);
//		}
		
		/*Date effectiveDate = new Date();  //生效日期
		Calendar calendar=Calendar.getInstance();			  
		try {
			if(!StringUtils.isEmpty(yworderitem.getHwVisitTime())){
				effectiveDate = DateUtils.parseDate(yworderitem.getHwVisitTime(), new String[]{"yyyyMMdd","yyyyMMdd HHmmss"});
			}
			calendar.setTime(sdf.parse(sdf.format(effectiveDate)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cpticket.setTkEffectiveDate(sdf.format(new Date()));//系统日期
		calendar.add(Calendar.DATE,cptktype.getTtExpirePeriod());
		//购票日期往后推一个月
		cpticket.setTkExpireDate(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));*/
		//最近入园日期
		cpticket.setTkActiveDate("");
		cpticket.setTkRetriveDate("");
		//插入一条数据
		try {
			return_cpticket = cpTicketMapper.insertCpTicket(cpticket);
		} finally {
			if(return_cpticket <= 0){
				return StatusResult.create("FALSE", "票劵和会员绑定失败");				
			}
		}
		BigDecimal balance = new BigDecimal(0);

		CpCeptrx cpceptrx1=new CpCeptrx();
		cpceptrx1.setCtBranchId(cpcrdtbl.getCbCentreCd());
		cpceptrx1.setCtTranId(Long.parseLong(automaticgrowthService.sqlNextVal("APNONSSEQ")));
		cpceptrx1.setCtMessageId(Long.parseLong(automaticgrowthService.nextSerial()));
		cpceptrx1.setCtCustomerId(cpcsttbl==null?"":cpcsttbl.getCbMemberCode());
		cpceptrx1.setCtCardNumber(cpcrdtbl.getCbCardholderNo());//卡号
//		cpceptrx1.setCtTranTime(DateTimes.nowTimestamp());//开卡时间
		cpceptrx1.setCtTranTime(DateTimes.nowDateTime());//开卡时间
		cpceptrx1.setCtDbCr("C");
		cpceptrx1.setCtTranAmount(yworderitem.getHwAmount());//票价
		cpceptrx1.setCtCardAmount(cptktype.getTtListPrice());
		cpceptrx1.setCtDescription("购票");  
		cpceptrx1.setCtApproveTime(DateTimes.nowTimestamp());
		cpceptrx1.setCtPostTime(automaticgrowthService.getPostTime());
		cpceptrx1.setCtAccountId(cpindacc.getCbIndividualAcctno());//账号id
		cpceptrx1.setCtTranCode("BUYTICKET");
		cpceptrx1.setCtTxrnType("C");
		cpceptrx1.setCtUserStatus1(cpticket.getTkTicketId().toString());//票号
		cpceptrx1.setCtUserStatus2(""+cptktype.getTtTypeId());//票类别
		cpceptrx1.setCtUserStatus3("I");
		cpceptrx1.setCtBillCurrCd(Long.parseLong("156"));
		cpceptrx1.setCtBillCurrAmt(cptktype.getTtListPrice());
		cpceptrx1.setCtAgeCodeB4Post("00");
		cpceptrx1.setCtAgeCodeAfterPost("00");
		cpceptrx1.setCtReversalFlag("0");
		cpceptrx1.setCtOutstdB4Post(balance);
		cpceptrx1.setCtOutstdAfterPost(cpindacc.getCbOutstdBal());
		cpceptrx1.setCtUserCreate("System");
		cpceptrx1.setCtStatus("0");
		cpceptrx1.setCtDc("0");
		cpceptrx1.setCtTranNum("1");
		cpceptrx1.setCtTranZone("0");
		cpceptrx1.setCtOpenZone("0");
		cpceptrx1.setCtCustomerId(cpindacc.getCbCustomerId());
		cpceptrx1.setCtDisputeDate(DateTimes.nowDate());
		try {
			return_cpceptrx = cpCeptrxMapper.insertCpCeptrx(cpceptrx1);	
		} finally {
			if(return_cpceptrx <=0){
				return StatusResult.create("FALSE", "添加购票流水记录失败");
			}
		}
		
		return StatusResult.create("OK","卡和票劵绑定成功");
	}
	/**
	 * 卡和票劵绑定
	 * @param tktypeStr				票劵ID
	 * @param cpcrdtbl				会员对象
	 * @param cpcsttbl				卡对象
	 * @return
	 */
	@Transactional
	public StatusResult<String> cpticketadd(String tktypeStr,CpCrdtbl cpcrdtbl,CpCsttbl cpcsttbl,String shoppingId){
		System.out.println("_______________________进人会员票劵绑卡方法_______________________");
		Long return_cpticket = 0L;
		Long return_cpceptrx =0L;
		Long tsi = 0L;
		String []tktypeList = tktypeStr.split(",");
		if(tktypeList.length == 0){
			return StatusResult.create("FALSE", "票劵ID为空");
		}
		CpIndacc cpindacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpcrdtbl.getCbIndividualAcctno());
		if(StringUtils.isEmpty(cpindacc)){
			return StatusResult.create("FALSE", "没有找到对应的账户");
		}
		//计算金额
		//循环取得数组里面的票劵ID
		for(int i = 0; i < tktypeList.length; i++){
			String typeId = tktypeList[i];
			//通过票劵ID去票劵表中获取票劵详情
			CpTktype cptktype = cpTktypeMapper.searchCpTktypeByTtTypeId(Integer.parseInt(typeId));
			if(StringUtils.isEmpty(cptktype)){
				return StatusResult.create("FALSE", "票劵ID未找到,请查看是否有误");
			}
			String nowDate = SysDateFormat.getNowDate("yyyyMMdd");
			boolean flag = false;
			if(buyCpprdgrpService.ifLegalHoliday(nowDate)){
				flag=true;
			}
			int cbcardprdctgroup = cpcrdtbl.getCbCardPrdctGroup();
			String PrdctGroup = ""+cbcardprdctgroup;
			StatusResult<BigDecimal> finalAmount =ticketService.tkpriceInf(typeId, PrdctGroup,flag);
			//添加流水信息（CP_TICKET）
			//创建卡门票映射表
			CpTicket cpticket=new CpTicket();
			//调用数据库函数，自动增长列
			Long ticketId=sequenceMapper.searchNexttkToTicketId("TICEKTSEQ");
			cpticket.setTkTicketId(ticketId);
			//卡号
			cpticket.setTkCardNo(cpcrdtbl.getCbCardholderNo());
			//票劵ID
			cpticket.setTkTicketType(Long.parseLong(typeId));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			//购票日期
			cpticket.setTkEffectiveDate(sdf.format(new Date()));//系统日期
			Calendar calendar=Calendar.getInstance();			  
			try {
				calendar.setTime(sdf.parse(sdf.format(new Date())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			calendar.add(Calendar.DATE,cptktype.getTtExpirePeriod());
			//购票日期往后推一个月
			cpticket.setTkExpireDate(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
			//最近入园日期
			cpticket.setTkActiveDate("");
			cpticket.setTkRetriveDate("");
			//插入一条数据
			try {
				return_cpticket = cpTicketMapper.insertCpTicket(cpticket);
			} finally {
				if(return_cpticket <= 0){
					return StatusResult.create("FALSE", "票劵和会员绑定失败");				
				}
			}
			BigDecimal balance = new BigDecimal(0);
			CpCeptrx cpceptrx1=new CpCeptrx();
			cpceptrx1.setCtBranchId(cpcrdtbl.getCbCentreCd());
			cpceptrx1.setCtTranId(Long.parseLong(automaticgrowthService.sqlNextVal("APNONSSEQ")));
			cpceptrx1.setCtMessageId(Long.parseLong(automaticgrowthService.nextSerial()));
			cpceptrx1.setCtCustomerId(cpcsttbl.getCbMemberCode());
			cpceptrx1.setCtCardNumber(cpcrdtbl.getCbCardholderNo());//卡号
//			cpceptrx1.setCtTranTime(DateTimes.nowTimestamp());//开卡时间
			cpceptrx1.setCtTranTime(DateTimes.nowDateTime());//开卡时间
			cpceptrx1.setCtDbCr("C");
			cpceptrx1.setCtTranAmount(finalAmount.getValue());//票价
			cpceptrx1.setCtCardAmount(cptktype.getTtListPrice());
			cpceptrx1.setCtDescription("购票");  
			cpceptrx1.setCtApproveTime(DateTimes.nowTimestamp());
			cpceptrx1.setCtPostTime(automaticgrowthService.getPostTime());
			cpceptrx1.setCtAccountId(cpindacc.getCbIndividualAcctno());//账号id
			cpceptrx1.setCtTranCode("BUYTICKET");
			cpceptrx1.setCtTxrnType("C");
			cpceptrx1.setCtUserStatus1(cpticket.getTkTicketId().toString());//票号
			cpceptrx1.setCtUserStatus2(""+cptktype.getTtTypeId());//票类别
			cpceptrx1.setCtUserStatus3("I");
			cpceptrx1.setCtBillCurrCd(Long.parseLong("156"));
			cpceptrx1.setCtBillCurrAmt(cptktype.getTtListPrice());
			cpceptrx1.setCtAgeCodeB4Post("00");
			cpceptrx1.setCtAgeCodeAfterPost("00");
			cpceptrx1.setCtReversalFlag("0");
			cpceptrx1.setCtOutstdB4Post(balance);
			cpceptrx1.setCtOutstdAfterPost(cpindacc.getCbOutstdBal());
			cpceptrx1.setCtUserCreate("System");
			cpceptrx1.setCtStatus("0");
			cpceptrx1.setCtDc("0");
			cpceptrx1.setCtTranNum("1");
			cpceptrx1.setCtTranZone("0");
			cpceptrx1.setCtOpenZone("0");
			cpceptrx1.setCtCustomerId(cpindacc.getCbCustomerId());
			cpceptrx1.setCtDisputeDate(DateTimes.nowDate());
//			cpceptrx1.setCtFeeAmount(new BigDecimal(0));
			try {
				return_cpceptrx = cpCeptrxMapper.insertCpCeptrx(cpceptrx1);	
			} finally {
				if(return_cpceptrx <=0){
					return StatusResult.create("FALSE", "添加购票流水记录失败");
				}
			}
		}
		try {
			tsi = ticketshoppingdelete(shoppingId);
		} finally {
			if(tsi <=0){
				return StatusResult.create("FALSE", "删除购物车表记录失败");
			}
		}
		return StatusResult.create("OK","卡和票劵绑定成功");
	}
	public Long ticketshoppingdelete(String shoppingId){
		int id = Integer.parseInt(shoppingId);
		long r = 0;
		try {
			r  = ticketshoppingcartMapper.deleteTicketShoppingCartByShoppingId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r ;	
	}
	
}
