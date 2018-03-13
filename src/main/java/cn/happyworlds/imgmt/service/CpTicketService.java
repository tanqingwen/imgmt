package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
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
import cn.happyworlds.imgmt.entity.CpMemberPoint;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
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
import cn.happyworlds.imgmt.mapper.CpMemberPointMapper;
import cn.happyworlds.imgmt.mapper.CpPrdgrpMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.DistrictMapper;
import cn.happyworlds.imgmt.mapper.ReCpTicketMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.mapper.TicketShoppingCartMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Digests;
import cn.happyworlds.imgmt.util.Objects;
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
public class CpTicketService {

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
	private CpCeptrxMapper cpCeptrxMapper;
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpTktypeMapper cpTktypeMapper;
	@Autowired
	private YwOrderMapper yworderMapper;
	@Autowired
	private YwOrderitemMapper yworderitemMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private CrdtblService crdtblService;
	@Autowired
	private DistrictMapper districtMapper;
	@Autowired
	private TicketShoppingCartMapper ticketshoppingcartMapper;	
	@Autowired
	private CartTicketService cartticketService;
	
	@Autowired
	private CpMemberPointMapper cpMemberPointMapper;
	
	@Autowired
	private CpPrdgrpMapper cpPrdgrpMapper;
	
	/**
	 * 查询已转票
	 * 转票表的票劵类型要查询得到相对应的票劵表的票劵类别ID
	 */
	public Result<PageInfo<CpTicket>> CpAcqgrpConvertList(final String tkCardNo, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(tkCardNo)) {
			params.put("tkCardNo", tkCardNo);
		}
		List<CpTicket> page = reCpTicketMapper.searchCpTicketAndCpTktypeConvert(params, pageBounds);
		return Result.create(new PageInfo<CpTicket>(page));
	}
	
	/**
	 * 查询可退票
	 * 转票表的票劵类型要查询得到相对应的票劵表的票劵类别ID，票劵类别要不等于99999，最近入院日期要为空
	 */
	public Result<PageInfo<CpTicket>> CpAcqgrpBackList(final String tkCardNo, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(tkCardNo)) {
			params.put("tkCardNo", tkCardNo);
		}
		List<CpTicket> page = reCpTicketMapper.searchCpTicketAndCpTktypeBack(params, pageBounds);
		for(CpTicket ct :page){			
			if(ct.getTkCardNo() != null){
				ct.setTicketName(cpTktypeMapper.searchCpTktypeByTtTypeId(ct.getTkTicketType().intValue()).getTtTypeDesc());
				CpCrdtbl cpCrdtbl =cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(ct.getTkCardNo());
				ct.setCredentyNumber(cpCrdtbl.getCbIdno());
				ct.setCredentyName(cpCrdtbl.getCbEmbossname());
			}
			
		}
		return Result.create(new PageInfo<CpTicket>(page));
	}
	
	/**
	 * 转入转出票
	 * 待转入卡号,选择的数据，userid
	 */
	public StatusResult<String> ChangeTicket(String tkCardNo1,String[] rsManagement,String userid) {
		StatusResult<String> r = null;
		for (int i = 0; i < rsManagement.length; i++) {
			CpTicket cpTicket = cpTicketMapper.searchCpTicketByTkTicketId(Long.parseLong(rsManagement[i]));
			
//			获取退票金额
			CpTktype type=cpTktypeMapper.searchCpTktypeByTtTypeId(cpTicket.getTkTicketType().intValue());
//			获取退票金额
			BigDecimal price= type.getTtListPrice();
			//將資金退回賬戶
			
			String oldcardno=cpTicket.getTkCardNo();
			cpTicket.setTkCardNo(tkCardNo1);
			cpTicketMapper.updateCpTicket(cpTicket);
			String tk_ticket_id = cpTicket.getTkTicketId().toString();
			String tk_ticket_type = cpTicket.getTkTicketType().toString();
			r = Water(tkCardNo1, "TRANTKIN", "转票转入", userid,tk_ticket_id,tk_ticket_type,price);
			if(r==null){
				r = Water(oldcardno, "TRANTKOUT", "转票转出", userid,tk_ticket_id,tk_ticket_type,price);
			}
		}
		
		return r;
	}
	
	/**
	 * 退票
	 * 选择的数据，userid
	 */
	@Transactional(rollbackFor = Exception.class)
	public StatusResult<String> BackTicket(String[] rsManagement,String userid) {
		StatusResult<String> r = null;
		for (int i = 0; i < rsManagement.length; i++) {
			CpTicket cpTicket = cpTicketMapper.searchCpTicketByTkTicketId(Long.parseLong(rsManagement[i]));
			YwOrderitem ywOrderItem = yworderitemMapper.searchYwOrderitemByHwOrderitemId(String.valueOf(cpTicket.getTkTicketId()));
			
			YwOrder ywOrder = new YwOrder();
			String orderID = automaticgrowthService.nextdindang("name");
			ywOrder.setHwOrderId(orderID);
			ywOrder.setHwType("4");
			ywOrder.setHwChannel("3");
			YwOrder ord =yworderMapper.searchYwOrderByHwOrderId(ywOrderItem.getHwOrderId());
			ywOrder.setHwMobilePhone(ord.getHwMobilePhone());
			ywOrder.setHwMoney(ywOrderItem.getHwAmount());
			ywOrder.setHwOperatorId(ywOrderItem.getHwOperatorId());
			ywOrder.setHwOrderFinishtime(DateTimes.getTimeStr(new Date()));
			ywOrder.setHwMemberId(ywOrderItem.getHwMemberId());
			ywOrder.setHwOrderAddtime(DateTimes.getTimeStr(new Date()));
			ywOrder.setHwOrderState("");
			yworderMapper.insertYwOrder(ywOrder);
//			退票id
			//Integer ticketId=cpTicket.getTkTicketId().intValue();
//			获取退票金额
			//YwOrderitem orderItem= yworderitemMapper.searchYwOrderitemByHwOrderitemId(ticketId);
//			获取退票金额
			BigDecimal price=ywOrderItem.getHwAmount();
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("cbIndCardholderNo", cpTicket.getTkCardNo());
			List<CpIndacc> cpIndaccs =cpIndaccMapper.searchCpIndaccByParams(paramMap);
			CpIndacc cpIndacc =cpIndaccs.get(0);
			cpIndacc.setCbOutstdBal(cpIndacc.getCbOutstdBal().add(ywOrderItem.getHwAmount()));
			
			//將退票金额退回会员卡
			cpIndaccMapper.updateCpIndacc(cpIndacc);
			//cpCrdtblMapper.searchAvailableNumber();
			//修改订单明细状态
			ywOrderItem.setHwStatus("R");
			yworderitemMapper.updateYwOrderitem(ywOrderItem);
			
			
			String oldcardno=cpTicket.getTkCardNo();
			//修改票状态
			//cpTicket.setTkTicketType(Long.parseLong("99999"));
			cpTicket.setTkStatus("R");
			cpTicketMapper.updateCpTicket(cpTicket);
			String tk_ticket_id = cpTicket.getTkTicketId().toString();
			String tk_ticket_type = cpTicket.getTkTicketType().toString();
			r = Water(oldcardno, "UNTICKET", "退票", userid,tk_ticket_id,tk_ticket_type,price);
		}
		return r;
	}
	
	/**
	 * 转票写账务流水
	 * 卡号，交易类型英文，交易类型中文，操作Userid，票号，票劵类别,退票id,退票金额
	 */
	public StatusResult<String> Water(String card_no,String code,String desc,String user ,String ticketId,String ticketType,BigDecimal price){
		
		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(card_no);
		if(cpCrdtbl==null){
			return StatusResult.create("CPCRDTBL_NOT_EXIST", "卡不存在");
		}
		
		Map<String, String> cpIndaccParams = new HashMap<>();
		cpIndaccParams.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
		cpIndaccParams.put("cbIndividualAcctType", "1");
		List<CpIndacc> cpIndacc = cpIndaccMapper.searchCpIndaccByParams(cpIndaccParams);
		if(cpIndacc.size()==0){
			return StatusResult.create("CPINDACC_NOT_EXIST", "账户不存在");
		}
		
		List<CpSysprm> cpSysprm = cpSysprmMapper.searchCpSysprmByParams(null);
		
		//跟着“APNONSSEQ”查函数nextval，set账务流水表里的CT_TRAN_ID
		Long ctTranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");
		
		CpCeptrx ceptrx = new CpCeptrx();
		//ticket no
		ceptrx.setCtUserStatus1(ticketId);
		//ticket type
		ceptrx.setCtUserStatus2(ticketType);
		ceptrx.setCtBranchId(cpCrdtbl.getCbCentreCd());
		ceptrx.setCtTranId(ctTranId);
		ceptrx.setCtCustomerId("0");
		ceptrx.setCtCardNumber(card_no);
//		ceptrx.setCtTranTime(SysDateFormat.getNowDate("HHmmss"));
		ceptrx.setCtTranTime(DateTimes.nowDateTime());
		ceptrx.setCtDbCr("C");
		ceptrx.setCtTranAmount(BigDecimal.ZERO);
		ceptrx.setCtCardAmount(ceptrx.getCtTranAmount());
		ceptrx.setCtDescription(desc);
		ceptrx.setCtCurrcode("156");
		ceptrx.setCtApproveTime(SysDateFormat.getNowDate("yyyyMMddHHmmss"));
		ceptrx.setCtPostTime(cpSysprm.get(0).getSpNextProcessingDate());
		ceptrx.setCtAccountId(cpCrdtbl.getCbIndividualAcctno());
		ceptrx.setCtTranCode(code);
		ceptrx.setCtTxrnType("C");
		ceptrx.setCtTranAmount(new BigDecimal("-"+price));
		ceptrx.setCtCardAmount(new BigDecimal("-"+price));
		ceptrx.setCtBillCurrCd(new BigDecimal("156").longValue());
		ceptrx.setCtBillCurrAmt(ceptrx.getCtTranAmount());
		ceptrx.setCtAgeCodeB4Post("00");
		ceptrx.setCtAgeCodeAfterPost("00");
		ceptrx.setCtReversalFlag("0");
		ceptrx.setCtOutstdAfterPost(cpIndacc.get(0).getCbOutstdBal());
		ceptrx.setCtUserCreate(user);
		ceptrx.setCtStatus("0");
		ceptrx.setCtDc("0");
		ceptrx.setCtTranNum("1");
		ceptrx.setCtTranZone("0");
		ceptrx.setCtOpenZone("0");
		cpCeptrxMapper.insertCpCeptrx(ceptrx);
		
//		退票积分处理
		pointUpdate(cpCrdtbl, price.intValue());
		
//		退票会员等级处理
		//cardGrpUpdate(cpCrdtbl, price.intValue());
		return null;
	}
	
	/**
	 * 实名绑票
	 * @param orderid
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public StatusResult<?> RealNameCard(String orderid)throws Exception {
		CpCsttbl cpcsttbl = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("hwOrderId", orderid);
		List<YwOrderitem> list =yworderitemMapper.searchYwOrderitemByParams(params);
		for(int i=0; i<list.size(); i++){
			YwOrderitem  yworderitem = list.get(i);
			Map<String, String> paramMap = new HashMap<String, String>();
			params.put("cbCardholderNo", "333502"+yworderitem.getHwCardhosternumber());
			params.put("cbRecommenderNo", "HWCARD"+yworderitem.getHwCardserialno());
			List<CpCrdtbl> cards = cpCrdtblMapper.searchCpCrdtblByParams(paramMap);			
			if(cards.size()==0){
				return StatusResult.create("FALSE", "没有找到对应的卡号");
			}
			cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(yworderitem.getHwMemberId());
			if(cpcsttbl == null){
				StatusResult<?> aaa = cartticketService.cpcsttbladd(yworderitem.getHwCredentytype(), yworderitem.getHwMemberId(), yworderitem.getHwCredentyname(), yworderitem.getHwMobile(), yworderitem.getHwBirthday(), yworderitem.getHwAddress());
				if("OK".equals(aaa.getStatus())) {
					cpcsttbl = (CpCsttbl)aaa.getValue();
				}else{
					return StatusResult.create("FALSE", aaa.getComment());
				}
			}
			CpCrdtbl cpCrdtbl = cards.get(0);
			if(cpCrdtbl.getCbIdno().equals(cpcsttbl.getCbCustomerIdno())){
				StatusResult<String> ddd = cartticketService.cpticketdanrenadd(cpCrdtbl, cpcsttbl,yworderitem);
				if("OK".equals(ddd.getStatus())){
					return StatusResult.create(ddd);
				}else{
					return StatusResult.create("FAIL",ddd.getComment());
				}
			}else{
				cartticketService.cpticketdanrenadd( cpCrdtbl,cpcsttbl, yworderitem);
			}
			
		}
		return StatusResult.create("FAIL","绑票失败");
	}
	
	public	StatusResult<String> cartCardAndBuy(String orderid,String staffId) throws ParseException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("hwOrderId", orderid);
		String cbMobileNo = null;
		List<YwOrderitem> list =yworderitemMapper.searchYwOrderitemByParams(params);
		for(int i=0; i<list.size(); i++){
			YwOrderitem  yworderitem = list.get(i);
			if("9".equals(yworderitem.getHwCredentytype())){
				Map<String, String> paramMap = new HashMap<String, String>();
				params.put("cbCardholderNo", "333502"+yworderitem.getHwCardhosternumber());
				List<CpCrdtbl> cards = cpCrdtblMapper.searchCpCrdtblByParams(paramMap);
				if(cards.size()==0){
					return StatusResult.create("FALSE", "没有找到对应的卡号");
				}
				CpCrdtbl cpCrdtbl = cards.get(0);	
				return cartticketService.cpticketdanrenadd( cpCrdtbl,null, yworderitem);
			}
			CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(yworderitem.getHwMemberId());
			try {
				if(StringUtils.isEmpty(cpcsttbl)){
					/*String zhengjian = "";
					if(StringUtils.isEmpty(yworderitem.getHwMemberId())){
						if(StringUtils.isEmpty(yworderitem.getHwSpecialcredentynumber())){
							//如果是无证件类型，此时会员业务如何处理？？
							//zhengjian = yworderitem.get
						}else{
							zhengjian = yworderitem.getHwSpecialcredentynumber();
						}
					}else{
						zhengjian = yworderitem.getHwMemberId();
					}*/
					StatusResult aaa = cartticketService.cpcsttbladd(yworderitem.getHwCredentytype(), yworderitem.getHwMemberId(), yworderitem.getHwCredentyname(), cbMobileNo, yworderitem.getHwBirthday(), yworderitem.getHwAddress());
					if("OK".equals(aaa.getStatus())){
						CpCsttbl cp_csttbl = (CpCsttbl)aaa.getValue();
						StatusResult bbb = cartticketService.CpCrdtlbadd(cp_csttbl, yworderitem.getHwCardhosternumber(), yworderitem.getHwCardserialno(), staffId);
						if("OK".equals(bbb.getStatus())){
							CpCrdtbl cp_crdtbl = (CpCrdtbl)bbb.getValue();
//							if(Integer.parseInt(amount)>0){
//								StatusResult ccc =cartticketService.cpindaccupdate(cp_crdtbl, amount, staffId);
//								if(!"OK".equals(ccc.getStatus())){
//									return ccc;
//								}
//							}
							StatusResult<String> ddd = cartticketService.cpticketdanrenadd( cp_crdtbl, cp_csttbl,yworderitem);
							if(!"OK".equals(ddd.getStatus())){
								return ddd;
							}
							
////							积分处理
//							pointAdd(cp_crdtbl, vartkAmount);
//							
////							会员等级处理
//							NoCardGrp(cp_crdtbl, cp_csttbl, vartkAmount, tktypeStr);
							continue;
						}else{
							return bbb;
						}
					}else{
						return aaa;
					}
				}
				CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbIdno(cpcsttbl.getCbCustomerIdno());
				if(StringUtils.isEmpty(cpcrdtbl)){
					StatusResult bbb = cartticketService.CpCrdtlbadd(cpcsttbl, yworderitem.getHwCardhosternumber(), yworderitem.getHwCardserialno(), staffId);
					if("OK".equals(bbb.getStatus())){
						CpCrdtbl cp_crdtbl = (CpCrdtbl)bbb.getValue();
//						if(Integer.parseInt(amount)>0){
//							StatusResult ccc =cartticketService.cpindaccupdate(cp_crdtbl, amount, staffId);
//							if(!"OK".equals(ccc.getStatus())){
//								return ccc;
//							}
//							
//						}
						StatusResult<String> ddd = cartticketService.cpticketdanrenadd(cp_crdtbl, cpcsttbl,yworderitem);
						if(!"OK".equals(ddd.getStatus())){
							return ddd;
						}
						continue;
					}else{
						return bbb;
					}
				}
//				if(Integer.parseInt(amount)>0){
//					StatusResult ccc =cartticketService.cpindaccupdate(cpcrdtbl, amount, staffId);
//					if(!"OK".equals(ccc.getStatus())){
//						return ccc;
//					}
//				}
				if(!cpcrdtbl.getCbCardholderNo().equals("333502"+yworderitem.getHwCardhosternumber())){
					cpcrdtbl.setCbPlasticCd("D");
					CpIndacc acc = cpIndaccMapper.searchCpIndaccByAcctNo(cpcrdtbl.getCbIndividualAcctno());
					cpCrdtblMapper.updateCpCrdtbl(cpcrdtbl);//老卡注销
					CpCrdtbl new_cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo("333502"+yworderitem.getHwCardhosternumber());
					new_cpcrdtbl.setCbIndividualAcctno(acc.getCbIndividualAcctno());
					cpCrdtblMapper.updateCpCrdtbl(new_cpcrdtbl);   //变更新卡帐号
					acc.setCbCustomerId("P"+"333502"+yworderitem.getHwCardhosternumber());
					acc.setCbIndCardholderNo("333502"+yworderitem.getHwCardhosternumber());
					cpIndaccMapper.updateCpIndacc(acc);   //变更老帐号的卡号
					CpIndacc acc1 = cpIndaccMapper.searchCpIndaccByAcctNo(new_cpcrdtbl.getCbIndividualAcctno());	
					acc1.setCbCustomerId("P9999");
					acc1.setCbIndCardholderNo("9999");
					cpIndaccMapper.updateCpIndacc(acc1); //新卡的帐户的卡号要处理
				}
				StatusResult<String> ddd = cartticketService.cpticketdanrenadd(cpcrdtbl, cpcsttbl,yworderitem);
				if(!"OK".equals(ddd.getStatus())){
					return ddd;
				}
				
//				积分处理
//				pointAdd(cpcrdtbl, vartkAmount);
//				
//				会员等级处理
//				cardGrp(cpcrdtbl, cpcsttbl, vartkAmount, tktypeStr);
				continue;
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	
		return StatusResult.create("OK","购票成功");
	}
	
	//非实名购票添加票卷过闸
	public boolean tictekadd(String orderId){
		boolean zhi = false;
		Long return_cpticket = null;
		try {
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("hwOrderId", orderId);
			String cbMobileNo = null;
			List<YwOrderitem> list =yworderitemMapper.searchYwOrderitemByParams(params);
			for(int i =0;i<list.size();i++){
				YwOrderitem ywitem = list.get(i);
				CpTicket cpticket=new CpTicket();
				cpticket.setTkTicketId(Long.valueOf(ywitem.getHwOrderitemId()));
				cpticket.setTkCardNo(null);
				cpticket.setTkTicketType(Long.valueOf(ywitem.getHwProdctGroup()));
				cpticket.setTkStatus("T");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String piao=ywitem.getHwProdctGroup();
				CpTktype tktype=cpTktypeMapper.searchCpTktype(piao);
				String strDate= tktype.getCouponDate();
				int days= tktype.getCouponDays();
				Date date=sdf.parse(strDate);
				Calendar cal=Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DAY_OF_YEAR, days);
				Date date2=cal.getTime();
				String dateee=sdf.format(date2);
				cpticket.setTkEffectiveDate(strDate);
				cpticket.setTkExpireDate(dateee);
				cpticket.setTkActiveDate("");
				cpticket.setTkRetriveDate("");
				return_cpticket = cpTicketMapper.insertCpTicket(cpticket);
				if(return_cpticket>0){
					zhi = true;
				}				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return zhi;
	}

//	public StatusResult<String> ticket(TicketShoppingCart tsc,String staffId){
//		String cbMobileNo = tsc.getMobile();
//		String amount = tsc.getAmount();
//		String tktypeStr = tsc.getTicketType();
//		int varTkPaperNo = tsc.getVarTkPaperNo();
//		String ticketform = tsc.getTicketform();
//		String prProdctGroup = tsc.getVaroldPrdgrp();
//		String CbRwdsAccno = tsc.getCbRwdsAccno();
//		String cbCardholderNo = tsc.getCbCardholderNo();
//		String cbIdType = tsc.getCbIdType();
//		String cbCustomerIdno = tsc.getIdNo();
//		String cbCustomerName =tsc.getUname();
//		String CbDob =tsc.getBirthday();
//		String Address = tsc.getAddress();
//		String vartkAmount = tsc.getVartkAmount();
//		String totalAmountPaid = tsc.getTotalAmountPaid();
//		YwOrder yworder = new YwOrder();
//		String orderID = automaticgrowthService.nextdindang("name");
//		yworder.setHwOrderId(orderID);
//		yworder.setHwCustomerName(cbCustomerName);
//		yworder.setHwMobilePhone(cbMobileNo);		//手机号					 
//		yworder.setHwChannel("3");				//渠道ID		1为微信，2为APP，3现场，4官网，5为OTA
//		BigDecimal ac_amount = new BigDecimal(vartkAmount);
//		yworder.setHwMoney(ac_amount);					//金额		从接口传过来
//		yworder.setHwOrderState("W");
////		yworder.setHwOrderState("N");					//状态		Y为已支付，N为未支付
//		yworder.setHwOrderAddtime(DateTimes.newDateTime());//订单生成时间	获取当前时间
//		yworder.setHwOrderPaytime(DateTimes.newDateTime());//订单生成时间	获取当前时间
//		yworder.setHwOrderFinishtime(DateTimes.newDateTime());//
//		yworder.setHwPaymentStatus("Y");
//		yworderMapper.insertYwOrder(yworder);
//		
//		CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbMobileNo(cbMobileNo);
//		try {
//			if(StringUtils.isEmpty(cpcsttbl)){
//				StatusResult aaa = cartticketService.cpcsttbladd(cbIdType, cbCustomerIdno, cbCustomerName, cbMobileNo, CbDob, prProdctGroup, Address);
//				if("OK".equals(aaa.getStatus())){
//					CpCsttbl cp_csttbl = (CpCsttbl)aaa.getValue();
//					StatusResult bbb = cartticketService.CpCrdtlbadd(cp_csttbl, ticketform, cbCardholderNo, CbRwdsAccno, prProdctGroup, staffId);
//					if("OK".equals(bbb.getStatus())){
//						CpCrdtbl cp_crdtbl = (CpCrdtbl)bbb.getValue();
//						if(Integer.parseInt(amount)>0){
//							StatusResult ccc =cartticketService.cpindaccupdate(cp_crdtbl, amount, staffId);
//							if(!"OK".equals(ccc.getStatus())){
//								return ccc;
//							}
//						}
//						StatusResult<String> ddd = cartticketService.cpticketdanrenadd(tktypeStr, cp_crdtbl, cp_csttbl, yworder);
//						if(!"OK".equals(ddd.getStatus())){
//							return ddd;
//						}
//						
////						积分处理
//						pointAdd(cp_crdtbl, vartkAmount);
//						
////						会员等级处理
//						NoCardGrp(cp_crdtbl, cp_csttbl, vartkAmount, tktypeStr);
//						
//						return ddd;
//					}else{
//						return bbb;
//					}
//				}else{
//					return aaa;
//				}
//			}
//			CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbIdno(cpcsttbl.getCbCustomerIdno());
//			if(StringUtils.isEmpty(cpcrdtbl)){
//				StatusResult bbb = cartticketService.CpCrdtlbadd(cpcsttbl, ticketform, cbCardholderNo, CbRwdsAccno, prProdctGroup, staffId);
//				if("OK".equals(bbb.getStatus())){
//					CpCrdtbl cp_crdtbl = (CpCrdtbl)bbb.getValue();
//					if(Integer.parseInt(amount)>0){
//						StatusResult ccc =cartticketService.cpindaccupdate(cp_crdtbl, amount, staffId);
//						if(!"OK".equals(ccc.getStatus())){
//							return ccc;
//						}
//					}
//					StatusResult<String> ddd = cartticketService.cpticketdanrenadd(tktypeStr, cp_crdtbl, cpcsttbl, yworder);
//					if(!"OK".equals(ddd.getStatus())){
//						return ddd;
//					}
//				}else{
//					return bbb;
//				}
//			}
//			if(Integer.parseInt(amount)>0){
//				StatusResult ccc =cartticketService.cpindaccupdate(cpcrdtbl, amount, staffId);
//				if(!"OK".equals(ccc.getStatus())){
//					return ccc;
//				}
//			}
//			StatusResult<String> ddd = cartticketService.cpticketdanrenadd(tktypeStr, cpcrdtbl, cpcsttbl, yworder);
//			if(!"OK".equals(ddd.getStatus())){
//				return ddd;
//			}
//			
//			
////			积分处理
//			pointAdd(cpcrdtbl, vartkAmount);
//			
////			会员等级处理
//			cardGrp(cpcrdtbl, cpcsttbl, vartkAmount, tktypeStr);
//			
//		} catch (Exception e) {
//			System.out.println("Exception :" +e);
//		}
//		
//
//	return StatusResult.create("OK","购票成功");
//	}
	
	/**
	 * 根据卡号获取到卡面号
	 * @param cardNo
	 * @return
	 */
	public StatusResult<String> kamianhaiselect(String cardNo){
		
		CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
		
		String kaminahao = cpcrdtbl.getCbRecommenderNo();
		return StatusResult.create(kaminahao);
	}
	/**
	 * 
	 * @param cardNo
	 * @return
	 */
	
	public StatusResult<Map<String,Object>> getMemberMsgByCardNo(String cardNo){
		Map<String,Object> map = new  HashMap<String, Object>();
		CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
		CpCsttbl member =cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cpcrdtbl.getCbIdno());
		String kaminahao = cpcrdtbl.getCbRecommenderNo();
		map.put("cardNo", kaminahao);
		map.put("status", cpcrdtbl.getCbPlasticCd());
		if(member!=null){
			map.put("idType", member.getCbIdType());
			map.put("idNo", member.getCbCustomerIdno());
			map.put("name", member.getCbCardholderName());
			map.put("birthDay", member.getCbDob());
			map.put("address", member.getCbHomeAddr1());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			try {
				int age =DateTimes.getAge(sdf.parse(member.getCbDob()));
				map.put("age", age);
			} catch (ParseException e) {
				map.put("age", 30);
			}
		}
		return StatusResult.create(map);
	}
	/**
	 * 添加购物车
	 * @param tsc
	 * @return
	 */
	public Result<TicketShoppingCart> ticketshoppingcartAdd(TicketShoppingCart tsc,String staffId) {
		tsc.setUserCreate(staffId);
		if("".equals(tsc.getMobile())){
			return Result.create("FALSE", "手机号不能为空");
		}else if("".equals(tsc.getTicketType())){
			return Result.create("FALSE", "票劵ID不能为空");
		}else if("".equals(tsc.getIdNo())){
			return Result.create("FALSE", "证件号码不能为空");
		}else if("".equals(tsc.getUname())){
			return Result.create("FALSE", "姓名不能为空");
		}else if("".equals(tsc.getBirthday())){
			return Result.create("FALSE", "出身日期不能为空");
		}else if("".equals(tsc.getTotalAmountPaid())){
			return Result.create("FALSE", "总金额不能为空");
		}
		try {
			ticketshoppingcartMapper.insertTicketShoppingCart(tsc);
			return Result.create(tsc);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CART_ADD_FAILED", "购物车添加失败");
		}
	}
	
	/**
	 * 查看购物车
	 * @param tsc
	 * @return
	 */
	public Result<List<TicketShoppingCart>> ticketshoppingcartShow(String staffId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userCreate", ""+staffId);
		List<TicketShoppingCart> page = ticketshoppingcartMapper.searchTicketShoppingCartByParams(params);
		return Result.create(page);
	}
	
	public String aa(){
		
		return null;
	}

	public StatusResult<String> pointAdd(CpCrdtbl crdtbl,String vartkAmount){
		System.out.println("----------将积分存入账户表indacc中--------");
		
		CpMemberPoint point=cpMemberPointMapper.searchCpMemberPointByPoId("1001");
		Integer result=null;
		if(Integer.parseInt(vartkAmount)>0){
			result= Integer.parseInt(vartkAmount)/Integer.parseInt(point.getPoTypeId())*point.getPoNumber();
//			查询用户的账户
			CpIndacc indacc=cpIndaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
			if(indacc.getCbExternalBranch() == null){
				result=result+0;
			}else{
				result=result+Integer.parseInt(indacc.getCbExternalBranch());
			}
//			更新积分
			indacc.setCbExternalBranch(result.toString());
			cpIndaccMapper.updateCpIndacc(indacc);
		}
		return StatusResult.create("OK", "积分添加成功");
	}
	
	public StatusResult<String> pointUpdate(CpCrdtbl crdtbl,Integer vartkAmount){
		System.out.println("----------退票将积分从账户表indacc中减去--------");
		
		CpMemberPoint point=cpMemberPointMapper.searchCpMemberPointByPoId("1001");
		Integer result=null;
		if(vartkAmount>0){
			result= vartkAmount/Integer.parseInt(point.getPoTypeId())*point.getPoNumber();
//			查询用户的账户
			CpIndacc indacc=cpIndaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
			if(Integer.parseInt(indacc.getCbExternalBranch()) <= 0){
				result=0;
			}else{
				result=Integer.parseInt(indacc.getCbExternalBranch())-result;
			}
//			更新积分
			indacc.setCbExternalBranch(result.toString());
			cpIndaccMapper.updateCpIndacc(indacc);
		}
		return StatusResult.create("OK", "积分减去成功");
	}
	
//	无卡时，会员等级处理
	public StatusResult<String> NoCardGrp(CpCrdtbl cpCrdtbl,CpCsttbl cp_csttbl,String vartkAmount,String tktypeStr){
		System.out.println("---------------无卡购票会员等级处理-------------");
		if(Integer.parseInt(cp_csttbl.getCbAlt2BillAddr2())<=0){
			String []typeList = tktypeStr.split(",");
			if(typeList.length == 0){
				return StatusResult.create("FALSE", "票劵ID为空");
			}
			if(Integer.parseInt(vartkAmount)<5000 && Integer.parseInt(vartkAmount)>0){
				cp_csttbl.setCbNricIssuIdno("1101");
				cpCrdtbl.setCbCardPrdctGroup(1101);
			}else if(Integer.parseInt(vartkAmount)<10000 && Integer.parseInt(vartkAmount)>5000){
				cp_csttbl.setCbNricIssuIdno("1102");
				cpCrdtbl.setCbCardPrdctGroup(1102);
			}else if(Integer.parseInt(vartkAmount)<20000 && Integer.parseInt(vartkAmount)>10000){
				cp_csttbl.setCbNricIssuIdno("1103");
				cpCrdtbl.setCbCardPrdctGroup(1103);
			}else if(Integer.parseInt(vartkAmount)>20000){
				cp_csttbl.setCbNricIssuIdno("1104");
				cpCrdtbl.setCbCardPrdctGroup(1104);
			}
//			消费金额
			Integer money=0;
			if(cp_csttbl.getCbAlt2BillAddr1() == null){
				money=Integer.parseInt(vartkAmount);
			}else{
				money=Integer.parseInt(cp_csttbl.getCbAlt2BillAddr1())+Integer.parseInt(vartkAmount);
			}
			cp_csttbl.setCbAlt2BillAddr1(money.toString());
//			购买次数
			Integer count=0;
			if(cp_csttbl.getCbAlt2BillAddr2() == null){
				count=typeList.length;
			}else{
				count=Integer.parseInt(cp_csttbl.getCbAlt2BillAddr2())+typeList.length;
			}
			cp_csttbl.setCbAlt2BillAddr2(count.toString());
			cpCsttblMapper.updateCpCsttbl(cp_csttbl);
			cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
		}
		
		return StatusResult.create("OK", "会员等级更新成功");
	}
	
//	有卡时，会员等级更新
	public StatusResult<String> cardGrp(CpCrdtbl cpCrdtbl,CpCsttbl cp_csttbl,String vartkAmount,String tktypeStr){
		System.out.println("---------------有卡购票会员等级处理-------------");
			String []typeList = tktypeStr.split(",");
			if(typeList.length == 0){
				return StatusResult.create("FALSE", "票劵ID为空");
			}
			
//			消费金额
			Integer money=0;
			if(Integer.parseInt(cp_csttbl.getCbAlt2BillAddr1()) ==0){
				money=Integer.parseInt(vartkAmount);
			}else{
				money=Integer.parseInt(cp_csttbl.getCbAlt2BillAddr1())+Integer.parseInt(vartkAmount);
			}
			cp_csttbl.setCbAlt2BillAddr1(money.toString());
//			购买次数
			Integer count=0;
			if(Integer.parseInt(cp_csttbl.getCbAlt2BillAddr2()) == 0){
				count=typeList.length;
			}else{
				count=Integer.parseInt(cp_csttbl.getCbAlt2BillAddr2())+typeList.length;
			}
			cp_csttbl.setCbAlt2BillAddr2(count.toString());
			if(money<5000 && money>0){
				cp_csttbl.setCbNricIssuIdno("1101");
				cpCrdtbl.setCbCardPrdctGroup(1101);
			}else if(money<10000 && money>5000){
				cp_csttbl.setCbNricIssuIdno("1102");
				cpCrdtbl.setCbCardPrdctGroup(1102);
			}else if(money<20000 && money>10000){
				cp_csttbl.setCbNricIssuIdno("1103");
				cpCrdtbl.setCbCardPrdctGroup(1103);
			}else if(money>20000){
				cp_csttbl.setCbNricIssuIdno("1104");
				cpCrdtbl.setCbCardPrdctGroup(1104);
			}
			
			cpCsttblMapper.updateCpCsttbl(cp_csttbl);
			cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
		
		return StatusResult.create("OK", "会员等级更新成功");
	}
	
	public StatusResult<String> cardGrpUpdate(CpCrdtbl cpCrdtbl,Integer price){
		System.out.println("-----------退票会员等级处理--------------");
		CpCsttbl cpCsttbl= cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cpCrdtbl.getCbBasicCustomerIdno());
		Integer money=0;
//		退票消费金额处理
		if(Integer.parseInt(cpCsttbl.getCbAlt2BillAddr1()) <= 0){
			money=0;
		}else{
			money=Integer.parseInt(cpCsttbl.getCbAlt2BillAddr1())-price;
		}
		cpCsttbl.setCbAlt2BillAddr1(money.toString());
//		退票消费购票次数处理
		Integer count=0;
		if(Integer.parseInt(cpCsttbl.getCbAlt2BillAddr2()) <= 0){
			count=0;
		}else{
			count=Integer.parseInt(cpCsttbl.getCbAlt2BillAddr2())-1;
		}
		cpCsttbl.setCbAlt2BillAddr2(count.toString());
//		退票会员等级处理
		if(money<5000 && money>0){
			cpCsttbl.setCbNricIssuIdno("1101");
			cpCrdtbl.setCbCardPrdctGroup(1101);
		}else if(money<10000 && money>5000){
			cpCsttbl.setCbNricIssuIdno("1102");
			cpCrdtbl.setCbCardPrdctGroup(1102);
		}else if(money<20000 && money>10000){
			cpCsttbl.setCbNricIssuIdno("1103");
			cpCrdtbl.setCbCardPrdctGroup(1103);
		}else if(money>20000){
			cpCsttbl.setCbNricIssuIdno("1104");
			cpCrdtbl.setCbCardPrdctGroup(1104);
		}
//		更新
		cpCsttblMapper.updateCpCsttbl(cpCsttbl);
		cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
		
		return StatusResult.create("OK", "会员等级更新成功");
	}
	
	public int authentication(String id){
		int i = 0;
		try {
			DateTime a = new DateTime();
			DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date bb =sdf.parse(id);
			DateTime b = new DateTime(bb);		
			if(a.getMonthOfYear()<=b.getMonthOfYear()){
				if(a.getDayOfMonth()<=b.getDayOfMonth()){
					i = a.getYear()-b.getYear();
				}else{
					i = (a.getYear()-b.getYear())-1;
				}				
			}else{
				i = (a.getYear()-b.getYear())-1;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	/**
	 * 终端绑卡处理
	 * @param order
	 * @return
	 * @throws ParseException 
	 */
	public StatusResult<String> ticketProcessByZD(YwOrder order) throws ParseException{
		System.out.println("-----------终端绑卡处理--------------");
		Map<String, String> params = new HashMap<String, String>();
		params.put("hwOrderId", order.getHwOrderId());
		List<YwOrderitem> list =yworderitemMapper.searchYwOrderitemByParams(params);
		for(YwOrderitem item : list){
			CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(item.getHwMemberId());
			if(Objects.isEmpty(cpcsttbl))
				return StatusResult.create("SUCCESS", "终端绑卡处理成功");
			CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbIdno(cpcsttbl.getCbCustomerIdno());
			if(Objects.isEmpty(cpcrdtbl) || !"U".equals(cpcrdtbl.getCbPlasticCd()))
				return StatusResult.create("SUCCESS", "终端绑卡处理成功");
			StatusResult<String> result = cartticketService.cpticketdanrenadd(cpcrdtbl,cpcsttbl, item);
			if(!"OK".equals(result.getStatus())){
				return StatusResult.create("FAIL", "终端绑卡处理失败");
			}
		}
		return StatusResult.create("SUCCESS", "终端绑卡处理成功");
	}
}
