package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.bean.cpm.PlasticCdStat;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpPrdgrpMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.util.SysDateFormat;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.LastCalendar;
import cn.happyworlds.imgmt.util.ProcessDate;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.StringUtil;

@Service
public class TicketService {

	@Autowired
	private CpTicketMapper ticketMapper;
	@Autowired
	private CpTktypeMapper tktypeMapper;
	@Autowired
	private CpCrdtblMapper crdtblMapper;
	@Autowired
	private CpCsttblMapper csttblMapper;
	@Autowired
	private CpIndaccMapper indaccMapper;
	@Autowired
	private CpCeptrxMapper ceptrxMapper;
	@Autowired
	private CpPrdgrpMapper prdgrpMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	
	/**
	 * 柜台购票初始页面加载
	 * 
	 * String nowDate
	 * @param tkTypeList
	 * 
	 * @author Hugh
	 * 
	 */
	public Result<List<CpTktype>> getTkTypeList(String nowDate, Result<List<CpTktype>> tkTypeList) {

		if (null != tkTypeList) {
			List<CpTktype> tkTypeAll = tkTypeList.getValue();
			for (int i = 0; i < tkTypeAll.size(); i++) {
				CpTktype newCpTktype = tkTypeAll.get(i);
				// 生效日期
				newCpTktype.setValid_date(nowDate);
				// 失效日期
				String expnireDate = this.getSpecifiedDayAfterBynum(nowDate,
						newCpTktype.getTtExpirePeriod().intValue() - 1);
				newCpTktype.setLose_date(expnireDate);
			}
		}
		return tkTypeList;
	}
	
	
	/**
	 * 柜台购票提交
	 * 
	 * @param cardNo
	 * @param idNo
	 * @param ticketType
	 * @param paperNo
	 * @param amount
	 * @param status
	 * @param staffId
	 * 
	 * @author Hugh 
	 */
	public StatusResult<String> addTicket(String cardNo,String idNo,String ticketType,String paperNo,String amount,String status,String staffId) {
		BigDecimal vamount=new BigDecimal(amount);
		int fornum=1;
		if(null!=paperNo){
			fornum=Integer.parseInt(paperNo);
		}
		BigDecimal balance=new BigDecimal(0);
		//查询卡记录
		List<CpCrdtbl> crdtblList=this.crdtblAllList(cardNo, idNo);
		if(null!=crdtblList && crdtblList.size()>0){
			if("L".equals(crdtblList.get(0).getCbPlasticCd())){
				return StatusResult.create("FALSE","挂失卡不能购票!");	
			}else if("D".equals(crdtblList.get(0).getCbPlasticCd())){
				return StatusResult.create("FALSE","已销卡不能购票!");
			}
		}else{
			return StatusResult.create("FALSE","找不到卡号!");
		}
		//查询会员记录			
		CpCsttbl cpCsttbl=csttblMapper.searchCpCsttblByCbCustomerIdno(idNo);
		if(null==cpCsttbl){
			return StatusResult.create("FALSE","客户信息不存在!");
		}
		//查询账户记录
		List<CpIndacc> indaccList=this.indaccList(cardNo);
		if(null!=indaccList && indaccList.size()>0){
			if(indaccList.get(0).getCbOutstdBal().compareTo(vamount)<0){
				return StatusResult.create("FALSE","账户余额不足!");
			}else{
				balance=indaccList.get(0).getCbOutstdBal();
				indaccList.get(0).setCbOutstdBal(indaccList.get(0).getCbOutstdBal().subtract(vamount));
				indaccMapper.updateCpIndacc(indaccList.get(0));
			}
		}else{
			return StatusResult.create("FALSE","账户信息不存在!");
		}
		
		int num=0; //循环
		for(int j=0;j<fornum;j++){
			for(int i=0;i<ticketType.split(",").length;i++){
				Long ticketId=sequenceMapper.searchNexttkToTicketId("TICEKTSEQ");
				String tktype=ticketType.split(",")[i];
				//查询票券记录
				CpTicket cpTicket=ticketMapper.searchCpTicketByTkTicketId(ticketId);
				if(null==cpTicket){
					String[] activedate=this.getTkPrice(tktype, "1");
					CpTicket ticketDto = new CpTicket();
					ticketDto.setTkTicketId(ticketId);
					ticketDto.setTkCardNo(cardNo);
					ticketDto.setTkTicketType(Long.parseLong(tktype));
					ticketDto.setTkEffectiveDate(activedate[1]);
					ticketDto.setTkExpireDate(activedate[2]);
					ticketMapper.insertCpTicket(ticketDto);
				}
				CpCeptrx ceptrx = new CpCeptrx();
				ceptrx.setCtBranchId(crdtblList.get(0).getCbCentreCd()); //发卡机构
				Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
				ceptrx.setCtTranId(tranId);
				
				//start 主键流水messageId
				BigDecimal name = sequenceMapper.searchSerialToName();
				if(name.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
					sequenceMapper.truncateSerial();
				}
				BigDecimal messageId=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
				//end
				ceptrx.setCtMessageId(messageId.longValue());
				ceptrx.setCtCardNumber(cardNo);
//				ceptrx.setCtTranTime(SysDateFormat.getNowDate("HHmmss"));
				ceptrx.setCtTranTime(DateTimes.nowDateTime());
				ceptrx.setCtDbCr("C"); //借贷标志
				ceptrx.setCtTranAmount(vamount);
				ceptrx.setCtCardAmount(vamount);
				ceptrx.setCtDescription("购票");
				ceptrx.setCtCurrcode("156"); //币种
				ceptrx.setCtApproveTime(SysDateFormat.getNowDate("yyyyMMddHHmmss"));
				List<CpSysprm> sysprmList = cpSysprmMapper.searchCpSysprmByParams(null);
				CpSysprm cpSysprm = new CpSysprm();
				if (null != sysprmList) {
					cpSysprm = sysprmList.get(0);
				}
				ceptrx.setCtPostTime(cpSysprm.getSpNextProcessingDate());
				ceptrx.setCtAccountId(indaccList.get(0).getCbIndividualAcctno());
				ceptrx.setCtTranCode("BUYTICKET");
				ceptrx.setCtTxrnType("C");
				ceptrx.setCtUserStatus1(ticketId.toString()); //票号
				ceptrx.setCtUserStatus2(tktype); //票类别
				ceptrx.setCtUserStatus3(status); //渠道
				ceptrx.setCtDisputeDate(SysDateFormat.getNowDate("yyyyMMdd"));
				ceptrx.setCtBillCurrCd(Long.parseLong("156"));
				ceptrx.setCtBillCurrAmt(vamount);
				ceptrx.setCtAgeCodeB4Post("00");
				ceptrx.setCtAgeCodeAfterPost("0");
				ceptrx.setCtReversalFlag("0");
				ceptrx.setCtOutstdB4Post(balance);
				ceptrx.setCtOutstdAfterPost(indaccList.get(0).getCbOutstdBal());
				ceptrx.setCtUserCreate(staffId);
				ceptrx.setCtStatus("0");
				ceptrx.setCtDc("0");
				ceptrx.setCtTranNum("1"); //交易次数
				ceptrx.setCtTranZone("0");
				ceptrx.setCtOpenZone("0");
				ceptrx.setCtCustomerId(indaccList.get(0).getCbCustomerId());
				ceptrxMapper.insertCpCeptrx(ceptrx);
				num++;
			}
		}
		return StatusResult.create(String.valueOf(num));
	}
	
	
	/**
	 * 柜台购票获取卡记录
	 * 
	 * @param cardNo
	 * @param idNo
	 * 
	 * @author Hugh
	 */
	public List<CpCrdtbl> crdtblAllList(String cardNo, String idNo) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cardNo)) {
			params.put("cbCardholderNo", cardNo);
		}
		if (StringUtils.hasText(idNo)) {
			params.put("cbIdno", idNo);
		}
		return crdtblMapper.searchCpCrdtblByParams(params);
	}

	
	/**
	 * 柜台购票获取账户记录
	 * 
	 * @param cardNo
	 * 
	 * @author Hugh
	 */
	public List<CpIndacc> indaccList(String cardNo) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cardNo)) {
			params.put("cbIndCardholderNo", cardNo);
		}
		return indaccMapper.searchCpIndaccByParams(params);
	}
	
	
	/**
	 * 柜台购票获取激活票券日期
	 * 
	 * @param typeId
	 * @param num
	 * 
	 * @author Hugh
	 */
	public String[] getTkPrice(String typeId,String num){

		String nowDate=SysDateFormat.getNowDate("yyyyMMdd");
		String nowTime=SysDateFormat.getNowDate("HHmmss");
		String activeDate=nowDate; //生效日期为当天
		String expireDate=""; //失效日期 通过tt_expire_period来算   --票券有效周期，单位为天
		BigDecimal period,amount=new BigDecimal(0);
		try {
            
			CpTktype tkType=tktypeMapper.searchCpTktypeByTtTypeId(Integer.parseInt(typeId));
			if(null!=tkType){
				amount=tkType.getTtListPrice();
				period=new BigDecimal(tkType.getTtExpirePeriod());
				boolean priceFalg=new BigDecimal(num).doubleValue()>0;
				if(0!=tkType.getTtDiscountRate1().doubleValue()){//普通折扣率
					if(priceFalg)
					amount = amount.multiply(new BigDecimal(num)).multiply(tkType.getTtDiscountRate1());
				}
                if(0!=tkType.getTtDiscountPrice1().doubleValue()){//普通折扣价，如同时设置了折扣率，以此为准
                	amount = tkType.getTtDiscountPrice1();
				}
				if(0!=tkType.getTtDiscountRate2().doubleValue()){// 特别折扣率    
					if(priceFalg)
				    amount = amount.multiply(new BigDecimal(num)).multiply(tkType.getTtDiscountRate2());
				}
				if(0!=tkType.getTtDiscountPrice2().doubleValue()){//特别折扣价，如同时设置了折扣率，以此为准   
					amount = tkType.getTtDiscountPrice2();
				}
				expireDate=LastCalendar.getSpecifiedDayAfterBynum(nowDate, tkType.getTtExpirePeriod().intValue()-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return new String[]{
				new DecimalFormat("0.00").format(amount.doubleValue()),//折扣后金额 
				activeDate,//生效日期
				expireDate//失效日期
		};
	}
	
	
	/**
	 * 选中票券类别时计算折扣
	 * @param ttTypeId
	 * @param prodct
	 * @param num
	 * @param flag是否在节假内
	 *
	 *multiply乘法add加法
	 * @author Hugh
	 */
	public StatusResult<BigDecimal> tkpriceInf(String ttTypeId, String ticketKind, boolean flag){
		
		BigDecimal amount = new BigDecimal(0);
//		BigDecimal resAmt = new BigDecimal(0);
		CpTktype cpTktype = new CpTktype();
//		String ttType[] = ttTypeId.split(",");
		cpTktype=tktypeMapper.searchCpTktypeByTtTypeId(Integer.parseInt(ttTypeId));
		if (null != cpTktype) {
			if(flag){
				amount = cpTktype.getTtListPrice().multiply(new BigDecimal(0.8));
			}else{
				amount = cpTktype.getTtListPrice(); // 常规价格
				
			}
		}
//		resAmt = resAmt.add(amount);
//		for (int i = 0; i < ttType.length; i++) {
//			// 查询是否有票券
//			
//				boolean priceFalg = new BigDecimal(num).doubleValue() > 0; // 数量
//				if (0 != cpTktype.getTtDiscountRate1().doubleValue()) {// 普通折扣率
//					if (priceFalg)
//						amount = amount.multiply(new BigDecimal(num)).multiply(cpTktype.getTtDiscountRate1());
//				}
//				if (0 != cpTktype.getTtDiscountPrice1().doubleValue()) {// 普通折扣价，如同时设置了折扣率，以此为准
//					amount = cpTktype.getTtDiscountPrice1();
//					amount = amount.multiply(new BigDecimal(num));
//				}
//				if (0 != cpTktype.getTtDiscountRate2().doubleValue()) {// 特别折扣率
//					if (priceFalg)
//						amount = amount.multiply(new BigDecimal(num)).multiply(cpTktype.getTtDiscountRate2());
//				}
//				if (0 != cpTktype.getTtDiscountPrice2().doubleValue()) {// 特别折扣价，如同时设置了折扣率，以此为准
//					amount = cpTktype.getTtDiscountPrice2();
//					amount = amount.multiply(new BigDecimal(num));
//				}
//			
//		}

		// 计算会员等级折扣
		switch(ticketKind){
			case "1" :
				amount = amount.multiply(new BigDecimal(1));
				break;
			case "2" :
				amount = amount.multiply(new BigDecimal(0.5));
				break;
			case "3" :
				amount = amount.multiply(new BigDecimal(0.5));
				break;
			case "4" :
				amount = amount.multiply(new BigDecimal(0.5));
				break;
			case "5" :
				amount = amount.multiply(new BigDecimal(0));
				break;
			case "6" :
				amount = amount.multiply(new BigDecimal(0));
				break;
			case "7" :
				amount = amount.multiply(new BigDecimal(0));
				break;
		}
		
//		CpPrdgrp cpPrdgrp=prdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(prodct));
//		if (null != cpPrdgrp) {  
//			resAmt = new BigDecimal(cpPrdgrp.getPrCurr4dbc()).multiply(new BigDecimal(0.01).multiply(resAmt));
//			resAmt = resAmt.setScale(0,BigDecimal.ROUND_HALF_UP);
//			
//			
//		} else {
//			return StatusResult.create("FALSE", "会员折扣信息有误");
//		}
		amount = amount.setScale(0,BigDecimal.ROUND_HALF_UP);
		return StatusResult.create(amount);
	}
	
	
	/**
	 * 获得指定日期的 前/后 num天 num为负数向前递减 反之
	 * 
	 * @param specifiedDay
	 * @param num
	 * 
	 * @author Hugh
	 */
	public String getSpecifiedDayAfterBynum(String specifiedDay, int num) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}
	
	
	/**
	 * 微信股票柜台取卡，根据手机号订单定位信息
	 * 
	 * @param mobileNo
	 * 
	 * 
	 * @author Hugh
	 */
	public StatusResult<String[]> cardInfoByMobile(String mobileNo){
		
		Map<String, String> params = new HashMap<>();
		params.put("cbIdType", "4"); //手机号
		params.put("cbIdno", mobileNo);
		List<CpCrdtbl> crdtblList=crdtblMapper.searchCpCrdtblByParams(params);
		CpCrdtbl newCrdtbl = new CpCrdtbl(); 
		if(null!=crdtblList && crdtblList.size()>0){
			newCrdtbl=(CpCrdtbl)crdtblList.get(0);
			String cvki="";
			if(null!=newCrdtbl.getCbCvki() && !"".equals(newCrdtbl.getCbCvki())){
				cvki=newCrdtbl.getCbCvki().toString();
			}
			CpIndacc indacc = indaccMapper.searchCpIndaccByAcctNo(newCrdtbl.getCbIndividualAcctno());
			String allStr[] = new String[]{
					newCrdtbl.getCbCardholderNo(),
					newCrdtbl.getCbIdType(),
					newCrdtbl.getCbIdno(),
					newCrdtbl.getCbSourceCd(),
					indacc.getCbOutstdBal().toString(),
					newCrdtbl.getCbEmbossname(),
					newCrdtbl.getCbCardPrdctGroup().toString(),
					newCrdtbl.getCbSourceCd(),
					newCrdtbl.getCbSuspendDate(),
					cvki,
					newCrdtbl.getCbPlasticCd()+"-"+StringUtil.checkNull(PlasticCdStat.cardStatus.get(newCrdtbl.getCbPlasticCd()))+"卡"
			};
			return StatusResult.create(allStr);
		}else{
			return StatusResult.create("ERROR","该手机号订单信息不存在!");
		}
	}
	public StatusResult<CpTicket> queryTkTicketId(String tkTicketId){
		CpTicket type=ticketMapper.searchCpTicketByTkTicketId(Long.valueOf(tkTicketId));
		return StatusResult.create("SUCCESS",type);
		
	}
}
