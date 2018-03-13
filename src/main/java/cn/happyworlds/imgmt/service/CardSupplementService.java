package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.bean.HappyCardBean;
import cn.happyworlds.imgmt.entity.CpAenuwk;
import cn.happyworlds.imgmt.entity.CpBlkmlc;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCopmst;
import cn.happyworlds.imgmt.entity.CpCrdlnk;
import cn.happyworlds.imgmt.entity.CpCrdmtn;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpCtrycd;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpMlrprn;
import cn.happyworlds.imgmt.entity.CpNuwork;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.mapper.CpAenuwkMapper;
import cn.happyworlds.imgmt.mapper.CpBlkmlcMapper;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCopmstMapper;
import cn.happyworlds.imgmt.mapper.CpCrdlnkMapper;
import cn.happyworlds.imgmt.mapper.CpCrdmtnMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpCtrycdMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpMlrprnMapper;
import cn.happyworlds.imgmt.mapper.CpNuworkMapper;
import cn.happyworlds.imgmt.mapper.CpPrdgrpMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class CardSupplementService {

	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private CpPrdgrpMapper cpPrdgrpMapper;
	@Autowired
	private CpCopmstMapper cpCopmstMapper;
	@Autowired
	private CpCrdmtnMapper cpCrdmtnMapper;
	@Autowired
	private CpAenuwkMapper cpAenuwkMapper;
	@Autowired
	private CpNuworkMapper cpNuworkMapper;
	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpCeptrxMapper ceptrxMapper;
	@Autowired
	private CpBlkmlcMapper blkmlcMapper;
	@Autowired
	private CpCrdlnkMapper linkMapper;
	@Autowired
	private CpCtrycdMapper ctryMapper;
	@Autowired
	private CpMlrprnMapper mlrprnMapper;
	
	private int rnThruYY;
	
	/**
	 * 挂失补卡判断
	 * @param cardNo
	 * @return
	 * @author Hugh
	 */
	public StatusResult<String> doCheck(String cardNo){
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("cmCardholderNo", cardNo);
			params.put("cmDesc", "CB_PLASTIC_CD");
			params.put("cmNewContents", "L");
			List<CpCrdmtn> crdmtnList=cpCrdmtnMapper.searchCpCrdmtnByParams(params);
			if(null!=crdmtnList && crdmtnList.size()>0){
				SimpleDateFormat formatSysDate = new SimpleDateFormat(
						"yyyy-MM-dd.hh.mm.ss.SSSSSS");
				
				String time = crdmtnList.get(0).getCmTimestamp();
				Calendar cld = Calendar.getInstance();
				cld.setTime(formatSysDate.parse(time));
				cld.add(Calendar.MINUTE, 15);
				Date now = new Date();
				if(cld.getTime().after(now)){
					return StatusResult.create("FALSE","挂失15分钟后才能换卡");
				}
			}else{
				return StatusResult.create("FALSE","换卡前请先挂失");
			}
			return StatusResult.create("1");
		}catch(Throwable e){
			return StatusResult.create("FALSE", "方法异常！");
		}
	}
	
	
	/**
	 * 挂失补卡是否满足条件可以补卡
	 * 
	 * @param oldCardNo
	 * @param newCardNo
	 * @return
	 * @author Hugh
	 */
	public StatusResult<String> checkCardReplace(String oldCardNo,String newCardNo){
		
		CpCrdtbl ordcrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCardNo);
		CpCrdtbl newcrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(newCardNo);
		String j="0";
		if(null!=ordcrdtbl && null!=newcrdtbl){
			String accountType = newcrdtbl.getCbIndaccRule().toString();
			int length=accountType.length();
			if(length<4){
				accountType="0";
			}else if(length==4){
				accountType=accountType.substring(0, 1);
			}
			
			//新卡账户
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbIndividualAcctno", newcrdtbl.getCbIndividualAcctno());
			params.put("cbIndividualAcctType","1");
			List<CpIndacc> indaccList = cpIndaccMapper.searchCpIndaccByParams(params);
			String account="";
			if(null!=indaccList && indaccList.size()>0){
				account=indaccList.get(0).getCbExternalAcct(); // 外部账号
			}
			if(account.length()>19){
				account=account.substring(account.length()-19, account.length());
			}
			
			//旧卡张号
			Map<String, String> paramsold = new HashMap<String, String>();
			params.put("cbIndividualAcctno", ordcrdtbl.getCbIndividualAcctno());
			params.put("cbIndividualAcctType","1");
			List<CpIndacc> oldindaccList = cpIndaccMapper.searchCpIndaccByParams(paramsold);
			String oldaccount="";
			if(null!=oldindaccList && oldindaccList.size()>0){
				oldaccount=oldindaccList.get(0).getCbExternalAcct(); // 外部账号
			}
			if(oldaccount.length()>19){
				oldaccount=oldaccount.substring(oldaccount.length()-19, oldaccount.length());
			}
			
			j="1";
			return StatusResult.create(j);
		}else{
			return StatusResult.create("FALSE","无效卡号或无效IDNO");
		}
	}

	/**
	 * 挂失补卡提交写卡
	 * 
	 * @param oldCardNo
	 * @param newCardNo
	 * @param cbPrdct1 新卡客户等级
	 * @param yajin 押金
	 * @param varBlock0str
	 * @param trxnCode 交易代码  SUPPL  
	 * @param varRn_reason
	 * @param varNC_EMERGENCY
	 * @return 
	 * @author Hugh
	 */
	
	public StatusResult<List<String>>  doCheckerApprove(String oldCardNo,String newCardNo,String cbPrdct1,String yajin,String varBlock0str,String trxnCode, String varRn_reason,String varNC_EMERGENCY,String staffId){
		String strNewBin=""; //预先定义空串
		BigDecimal messageid = null;
		BigDecimal bmessageid = null;
		List<String> res = new ArrayList<String>();
		//onMakerSave
		StatusResult<List<String>> r= onMakerSave(oldCardNo,newCardNo,varRn_reason,strNewBin);
		if("FALSE".equals(r.getStatus())){
			return r;
		}
		String newCardBin="";
		if(null==strNewBin || "".equals(strNewBin)){
			newCardBin=oldCardNo.substring(0,6);
		}else{
			newCardBin=strNewBin;
		}

		CpCrdtbl crdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCardNo);
//		if("CHANGE".equals(trxnCode)){
//			checkAllowCardsCHANGE(cbPrdct1,crdtbl.getCbIdType(),crdtbl.getCbIdno());
//		}else if("SUPPL".equals(trxnCode)){ //挂失补卡为SUPPL
//			StatusResult<List<String>> r1 = checkAllowCards(cbPrdct1,crdtbl.getCbIdType(),crdtbl.getCbIdno());
//			System.out.println("----r1:"+r1);
//			System.out.println("---bbb");
//			if("FALSE".equals(r1.getStatus())){
//				return r1;
//			}
//		}
		//csttbl
		Map<String, String> params = new HashMap<String, String>();
		params.put("cbIdType", crdtbl.getCbIdType());
		params.put("cbCustomerIdno", crdtbl.getCbIdno());
		List<CpCsttbl> csttblList = cpCsttblMapper.searchCpCsttblByParams(params);
		if(null==csttblList || csttblList.size()<=0){
			return StatusResult.create("FALSE", "客户不存在");
		}
		
		//indacc
		CpIndacc indaccDto = cpIndaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
		if(null==indaccDto){
			return StatusResult.create("FALSE", "账户不存在");
		}
		
		//账户表里有限额(根据时间判断的)
		Long bigLocalLmt=getLmt(crdtbl.getCbIndividualAcctno());
		
		//获取币种
		String strCurrInd = GetCurrInd(oldCardNo);
		
		//持卡人号码与产品组不匹配
		if(null!=newCardNo && !"".equals(newCardNo)){
			chkCardNumLength(newCardNo);  
		}else {
			//制卡:求解这个方法中逻辑是干嘛的废掉了
			//StatusResult<String> r2 = makeCardNo(oldCardNo,newCardBin);
			StatusResult<List<String>> r2 = makeCardNo();
			if("FALSE".equals(r2.getStatus())){
				return r2;
			}
			newCardNo = r2.getValue().toString();
		}	
		chkValid(oldCardNo,newCardNo,varRn_reason);
		checkPlasticCd(oldCardNo,newCardNo);
		StatusResult<List<String>> r3 = openCard("0",newCardNo,crdtbl.getCbIdType(),crdtbl.getCbIdno(),crdtbl.getCbEmbossname(),crdtbl.getCbSourceCd(),cbPrdct1,crdtbl.getCbSuspendDate(),staffId);
		if("FALSE".equals(r3.getStatus())){
			return r3;
		}
		// messageid = new BigDecimal(r3.getValue().toString());
		try {
//			HappyCardBean happyCardBean = new HappyCardBean();
//			List<String> nlist = happyCardBean.newCard(newCardNo, crdtbl.getCbEmbossname(), varBlock0str, cbPrdct1, yajin, crdtbl.getCbSuspendDate());
//			System.out.println("---res:"+nlist);
//			res=nlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//换卡时激活新卡省略
		//更新卡表
		updateCRDTBL(oldCardNo, newCardNo, cbPrdct1,yajin,staffId);
		
		//插入cp_mlrprn表
		insertMLRPRN(newCardNo);
		//插入cp_crdlnk
		if(!oldCardNo.equals(newCardNo)){
			StatusResult<List<String>> s = insertCRDLNK(oldCardNo, newCardNo,varRn_reason,staffId);
			if("FALSE".equals(s.getStatus())){
				return s;
			}
		}
		
		
		//插入流水表
		CpCeptrx ceptrx = new  CpCeptrx();
		ceptrx.setCtBranchId(crdtbl.getCbCentreCd());
		Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
		ceptrx.setCtTranId(tranId);
		//start 主键流水messageId
		BigDecimal seqname = sequenceMapper.searchSerialToName();
		if(seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
			sequenceMapper.truncateSerial();
		}
		bmessageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
		
		ceptrx.setCtMessageId(bmessageid.longValue());
		//end
		
		ceptrx.setCtCustomerId(csttblList.get(0).getCbCustomerRefNo());
		ceptrx.setCtCustomerId(csttblList.get(0).getCbCustomerRefNo());
		ceptrx.setCtCardNumber(oldCardNo);
//		ceptrx.setCtTranTime(SysDateFormat.getNowDate("HHmmss"));
		ceptrx.setCtTranTime(DateTimes.nowDateTime());
		ceptrx.setCtDbCr("C");
		ceptrx.setCtTranAmount(BigDecimal.ZERO);
		ceptrx.setCtCardAmount(BigDecimal.ZERO);
		if("CHANGE".equals(trxnCode)){
			ceptrx.setCtDescription("坏卡换卡");
		}else if("SUPPL".equals(trxnCode)){
			ceptrx.setCtDescription("挂失补卡");
		}
		ceptrx.setCtCurrcode("156");
		ceptrx.setCtApproveTime(SysDateFormat.getNowDate("yyyyMMddHHmmss"));
		
		List<CpSysprm> sysprmList=cpSysprmMapper.searchCpSysprmByParams(null);
		
		ceptrx.setCtPostTime(sysprmList.get(0).getSpNextProcessingDate());
		ceptrx.setCtAccountId(indaccDto.getCbIndividualAcctno());
		ceptrx.setCtTranCode(trxnCode);
		ceptrx.setCtTxrnType("C");
		ceptrx.setCtBillCurrCd(Long.parseLong("156"));
		ceptrx.setCtBillCurrAmt(BigDecimal.ZERO);
		ceptrx.setCtAgeCodeAfterPost("00");
		ceptrx.setCtReversalFlag("0");
		ceptrx.setCtOutstdB4Post(indaccDto.getCbOutstdBal());
		ceptrx.setCtOutstdAfterPost(BigDecimal.ZERO);
		ceptrx.setCtUserCreate(staffId);
		ceptrx.setCtStatus("0");
		ceptrx.setCtDc("0");
		ceptrx.setCtTranNum("1");
		ceptrx.setCtTranZone("0");
		ceptrx.setCtOpenZone("0");
		ceptrx.setCtCustomerId(indaccDto.getCbCustomerId());
		ceptrxMapper.insertCpCeptrx(ceptrx);
		
		//黑名单表
		String oldCardNo1=oldCardNo.substring(10); 
		CpBlkmlc blkmlc = new CpBlkmlc();
		blkmlc.setBmCardNo(oldCardNo1);
		blkmlc.setBmReasonCode("R");
		blkmlc.setBmOrgId(staffId);
		blkmlc.setBmInTime(SysDateFormat.getNowDate("yyyyMMdd"));
		blkmlc.setBmCardName(crdtbl.getCbEmbossname());
		blkmlc.setBmProductCode(BigDecimal.ZERO.longValue());
		blkmlc.setBmBlack("Y");
		
		CpBlkmlc oldblkmlc = blkmlcMapper.searchCpBlkmlcByBmCardNo(oldCardNo1);
		if(null==oldblkmlc){
			blkmlcMapper.insertCpBlkmlc(oldblkmlc);
		}
		return StatusResult.create(res);
	}
	
	public StatusResult<List<String>> onMakerSave(String oldCardNo,String newCardNo,String varRn_reason,String strNewBin){
		checkPreCardType(oldCardNo);
		if(null!=newCardNo && !"".equals(newCardNo)){
			StatusResult<List<String>> r = chkCardNumLength(newCardNo);
			if("FALSE".equals(r.getStatus())){
				return r;
			}
			StatusResult<List<String>> r1 = chkValid(oldCardNo,newCardNo,varRn_reason);
			if("FALSE".equals(r1.getStatus())){
				return r1;
			}
			StatusResult<List<String>> r2 = checkCardType(newCardNo);
			if("FALSE".equals(r2.getStatus())){
				return r2;
			}
			/**判断用户有无数据访问权限暂省略 */
		}else{
			newCardNo="";
		}
		return checkPlasticCd(oldCardNo, newCardNo);
	}
	
	//检查旧卡类型
	public StatusResult<String> checkPreCardType(String oldCardNo){
		
		CpCrdtbl crdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCardNo);
		if(null!=crdtbl){
			if("P".equals(crdtbl.getCbIdType())){
				return StatusResult.create("FALSE","预制卡不允许做该交易");
			}
		}else{
			return StatusResult.create("FALSE","不能找到卡");
		}
		return StatusResult.create("OK","成功");
	}
	
	//检查新卡长度
	public StatusResult<List<String>> chkCardNumLength(String newCardNo){
		String newCardNo1=newCardNo.substring(0,6);
		System.out.println("--新卡:"+newCardNo1);
		//查询产品表
		Map<String, String> params = new HashMap<String, String>();
		params.put("prBin", newCardNo1);
		List<CpPrdgrp> prdgrpList = cpPrdgrpMapper.searchCpPrdgrpByParams(params);
		if(null!=prdgrpList && prdgrpList.size()>0){
			if(prdgrpList.get(0).getPrCardholderNoLen().intValue()!=newCardNo.length()){
				return StatusResult.create("FALSE","持卡人号码长度与产品组中的不匹配");
			}
		}else{
			return StatusResult.create("FALSE","未找到该产品代码");
		}
		return StatusResult.create("OK","成功");
	}
	
	//
	public StatusResult<List<String>> chkValid(String strOldCrd,String strNewCrd,String varRn_reason){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("coBillCardholderNo", strNewCrd);
		List<CpCopmst> copmstList = cpCopmstMapper.searchCpCopmstByParams(params);
		if(null!=copmstList && copmstList.size()>0){
			return StatusResult.create("FALSE","持卡人号码已在公司帐单帐户中");
		}
		if(null!=varRn_reason && (!"".equals(varRn_reason))){
			if("LC".equals(varRn_reason) || "SC".equals(varRn_reason)
					|| "FC".equals(varRn_reason) || "UC".equals(varRn_reason)
					|| "RI".equals(varRn_reason) || "NR".equals(varRn_reason)
					|| "DC".equals(varRn_reason)) { 
				if (strOldCrd.equals(strNewCrd)) {
					return StatusResult.create("FALSE","换卡原因为LC, SC, FC, UC, RI, NR, DC不允许补卡");
				}
			}
		}
		return StatusResult.create("OK","成功");
	}
	
	
	public StatusResult<List<String>> checkCardType(String newCardNo){
		
		CpCrdtbl crdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(newCardNo);
		if(null!=crdtbl){
			if(!"P".equals(crdtbl.getCbIdType())){
				return StatusResult.create("FALSE","不是预制卡，不能替换");
			}
		}else{
			return StatusResult.create("FALSE","不能找到卡");
		}
		return StatusResult.create("OK","成功");
	}
	
	
	public StatusResult<List<String>> checkPlasticCd(String oldCardNo, String newCardNo){
		CpCrdtbl crdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCardNo);
		String plasticCd=crdtbl.getCbPlasticCd();
		if(plasticCd==null){
			plasticCd="";
		}
		if("D".equals(plasticCd)){
			return StatusResult.create("FALSE","已销卡不能换卡");
		}
		if(oldCardNo.equals(newCardNo)){
			if(!"".equals(plasticCd.trim())){
				return StatusResult.create("FALSE","不能续卡");
			}
		}
		return StatusResult.create("OK","成功");
	}
	
	public StatusResult<String> checkAllowCardsCHANGE(String prdgrp, String idtype, String idno) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("cbIdType", idtype);
		params.put("cbIdno", idno);
		params.put("cbCardPrdctGroup", prdgrp);
		params.put("cbPlasticCd","P");
		// or params.put("cbPlasticCd"," ");
		CpPrdgrp prdgrpDto = cpPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(prdgrp));
		if (null != prdgrpDto) {
			int nums = prdgrpDto.getPrAllowCardNums().intValue() + 1;
			List<CpCrdtbl> crdtblList = cpCrdtblMapper.searchCpCrdtblByParams(params);
			if (crdtblList.size() > nums && nums > 0) {
				return StatusResult.create("FALSE", prdgrpDto.getPrGroupDesc() + "每个客户只能开" + nums + "张卡,该客户已不能再办理");
			}
		} else {
			return StatusResult.create("FALSE", "系统中未找到卡类型: " + prdgrp);
		}
		return StatusResult.create("OK", "成功");
	}
	
	
	//新卡：客户等级
	//旧卡：证件类型
	//旧卡：证件号码
//	public StatusResult<List<String>> checkAllowCards(String prdgrp ,String idtype ,String idno){
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("cbIdType", idtype);
//		params.put("cbIdno", idno);
//		params.put("cbCardPrdctGroup", prdgrp);
//		params.put("cbPlasticCd", "P");
//		// or params.put("cbPlasticCd"," ");
//		CpPrdgrp prdgrpDto = cpPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(prdgrp));
//		System.out.println("---1prdgrpDto:"+prdgrpDto);
//		if (null != prdgrpDto) {
//			int nums = prdgrpDto.getPrAllowCardNums().intValue(); //库里是1
//			List<CpCrdtbl> crdtblList = cpCrdtblMapper.searchCpCrdtblByParams(params);
//			System.out.println("---2nums:"+nums+"---:"+crdtblList);
//			if (crdtblList.size() > nums && nums>0) {
//				return StatusResult.create("FALSE", prdgrpDto.getPrGroupDesc() + "每个客户只能开" + nums + "张卡,该客户已不能再办理");
//			}
//		} else {
//			return StatusResult.create("FALSE", "系统中未找到卡类型: " + prdgrp);
//		}
//		return StatusResult.create("OK","成功");
//	}
	
	
	public Long getLmt(String acctno){
		
		String dateyyyyMMdd = SysDateFormat.getNowDate("yyyyMMdd");
		Map<String, String> params = new HashMap<String, String>();
		params.put("cbIndividualAcctno", acctno);
		params.put("cbIndividualAcctType", "1");
		List<CpIndacc> indaccList = cpIndaccMapper.searchCpIndaccByParams(params);
		Long bigLocalLmt = null;
		if(null!=indaccList && indaccList.size()>0){
			CpIndacc newIndacc=indaccList.get(0);
			if(null!=newIndacc){
				if(!"".equals(newIndacc.getCbTempStartDate()) && (!"".equals(newIndacc.getCbTempEndDate()))){
					if((Integer.parseInt(newIndacc.getCbTempStartDate()) <= Integer.parseInt(dateyyyyMMdd)) && (Integer.parseInt(dateyyyyMMdd) <= Integer.parseInt(newIndacc.getCbTempEndDate()))){
						bigLocalLmt=newIndacc.getCbTempLineLimit();
					}else{
						bigLocalLmt=newIndacc.getCbTempLineLimit();
					}
				}else{
					bigLocalLmt = newIndacc.getCbTempLineLimit();
				}
			}else{
				bigLocalLmt=(long) 0;
			}
		}
		return bigLocalLmt;
	}
	
	
	//币种
	public String GetCurrInd(String oldCardNo) {

		CpCrdtbl crdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCardNo);
		String prdGroup = "";
		if (null != crdtbl) {
			prdGroup = crdtbl.getCbCardPrdctGroup().toString();
		}
		
		CpPrdgrp prdgrp = cpPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(prdGroup));
		return prdgrp.getPrCurrInd();
	}
	
	//改造为制卡
	public StatusResult<List<String>> makeCardNo(){
		try{
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbCardPrdctGroup", "1100");
			params.put("cbIdType", "P");
			params.put("cbIdno", "99999");
			
			List<CpCrdtbl> crdtblList=cpCrdtblMapper.searchCpCrdtblByParams(params);
			String cardNo="";
			List<String> list = new ArrayList<String>();
			if(null!=crdtblList && crdtblList.size()>0){
				cardNo=crdtblList.get(0).getCbCardholderNo();
				list.add(cardNo);
				return StatusResult.create(list);
			}else{
				return StatusResult.create("FALSE", "预制卡已用完,请申请制卡");
			}
		}catch (Throwable e) {
			return StatusResult.create("FALSE", "生成卡号异常，请稍后再试！");
		}
	}
	
	
	//制卡改造：处理方式为随机分配预制卡
	public StatusResult<String> makeCardNo1(String oldCardNo,String newCardBin){
		
		StringBuffer bufCardNo = new StringBuffer();
		java.util.Random rnd = new java.util.Random();
		
		int intUpperValue = 0;
		java.math.BigDecimal bigAmex = null, bigBin;
		boolean bolStatus = true;
		String strCardNo,strBrand,strProdctCD;
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("prBin", newCardBin);
		List prdgrpList = cpPrdgrpMapper.searchCpPrdgrpByParams(params);
		if(null == prdgrpList){
			return StatusResult.create("FALSE", "客户等级不存在");
		}
		
		CpPrdgrp newprdgrp = (CpPrdgrp)prdgrpList.get(0);
		
		//卡号上限
		if(null!=newprdgrp.getPrUpperRangeValue()){
			intUpperValue = newprdgrp.getPrUpperRangeValue().intValue();
		}
		
		//备用默认是空的
		if(null!=newprdgrp.getPrAmexProduct()){
			bigAmex=new BigDecimal(newprdgrp.getPrAmexProduct());
		}
		
		//卡号前6位
		bigBin = new BigDecimal(newCardBin);
		
		//卡组织(P:预制卡)
		strBrand = newprdgrp.getPrCardBrand();
		
		while(bolStatus){
				if(intUpperValue>0){
					bufCardNo.append(rnd.nextInt(intUpperValue));
				}
			if("A".equals(strBrand)){
				while(bufCardNo.length() < 7){
					bufCardNo.insert(0, "0");
				}
				
				Map<String, String> params1 = new HashMap<String, String>();
				//新
				CpAenuwk aenuwk = new CpAenuwk(); 
				aenuwk.setNuAeBin(bigBin.longValue());
				aenuwk.setNuAeProd(bigAmex.longValue());
				aenuwk.setNuAeSeq(Long.parseLong(bufCardNo.toString()));
				
				params1.put("nuAeBin", bigBin+"");
				params1.put("nuAeProd", bigAmex+"");
				params1.put("nuAeSeq", bufCardNo.toString());
				bufCardNo.insert(0, bigAmex.toString());
				List<CpAenuwk> aenuwkList = cpAenuwkMapper.searchCpAenuwkByParams(params1);
				if(null ==aenuwkList){
					cpAenuwkMapper.insertCpAenuwk(aenuwk);
					bolStatus = false;
				}else{
					break;
				}
			}else{
				while(bufCardNo.length()<9){
					bufCardNo.insert(0, "0");
				}
				
				CpNuwork nuwork = new CpNuwork();
				nuwork.setNuBinNo(bigBin.longValue()); //卡号前6位
				nuwork.setNuSeqNo(Long.parseLong(bufCardNo.toString()));
				
				Map<String, String> params2 = new HashMap<String, String>();
				System.out.println("bingBin: " + bigBin);
				System.out.println("bufCardNo.toString(): " + bufCardNo);
				params2.put("nuBinNo", bigBin+"");
				params2.put("nuSeqNo", bufCardNo.toString());
				
				List<CpNuwork> nuworkList = cpNuworkMapper.searchCpNuworkByParams(params2);
				
				if(null==nuworkList){
					nuwork.setNuUsageInd("S");
					cpNuworkMapper.insertCpNuwork(nuwork);
					bolStatus = false;
				}else{
					break;
				}
				
			}
		}
		
		bufCardNo.insert(0, bigBin.toString());
		if("A".equals(strBrand)){
			while(bufCardNo.length()<14){
				bufCardNo.insert(0, "0");
			}
		}else{
			while(bufCardNo.length()<15){
				bufCardNo.insert(0, "0");
			}
		}
		
		strCardNo = bufCardNo.toString();
		//测试用
		strCardNo="10044324";
		bufCardNo = null;
		strCardNo = cardDigit(strCardNo);
		return StatusResult.create(strCardNo);
	}
	
	
	public String cardDigit(String strCardNo){
		int intCardNoLen = strCardNo.length();
		boolean bolStatus = true;
		int i;
		int intTotal = 0;
		int intDigits = 0;
		String strTotal;

		for (i = intCardNoLen; i > 0; i--) {
			if (bolStatus) {
				intDigits = new Integer(strCardNo.substring(i - 1, i))
						.intValue() * 2;
				if (intDigits > 9)
					intDigits -= 9;
				intTotal += intDigits;
				bolStatus = false;
			} else {
				intTotal = intTotal
						+ new Integer(strCardNo.substring(i - 1, i)).intValue();
				bolStatus = true;
			}
		}
		strTotal = String.valueOf(intTotal);
		strTotal = strTotal.substring(strTotal.length() - 1, strTotal.length());
		intDigits = new Integer(strTotal).intValue();
		intDigits = 10 - intDigits;
		if (intDigits == 10) {
			return (strCardNo + "0");
		} else {
			return (strCardNo + intDigits);
		}
	}
	
	//cardno 新卡号
	public StatusResult<List<String>> openCard(String chargeAmount,String cardno,String idtype,String nricno,String name,String mobile,String cardtype,String birthday,String user){
		BigDecimal messageid = null;
		String language = "cn";
		String NDACC_RULE="0";
		String validDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat vsdf = new SimpleDateFormat("yyMMdd");
		Calendar cld = Calendar.getInstance();
		//
		
//		根据客户等级判断
//		CpPrdgrp prdgrpDto = cpPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(cardtype));
//		if(null==prdgrpDto){
//			return StatusResult.create("FALSE","系统中未找到卡类型");
//		}
		if(checkcardno(cardno)){
			CpCrdtbl crdtbl1 = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardno);
			List<CpSysprm> sysprmList=cpSysprmMapper.searchCpSysprmByParams(null);
			
			String oldAnnivDate = crdtbl1.getCbAnnivDate();
			String accountType = crdtbl1.getCbIndaccRule().toString();
			String oldindaccrule=accountType;
			int length=accountType.length();
			if(length<4){
				accountType="0";
			}else if(length==4){
				accountType=accountType.substring(0,1);
			}
			
		    Map<String, String> params = new HashMap<String, String>();
			params.put("cbIndividualAcctno", crdtbl1.getCbIndividualAcctno());
			params.put("cbIndividualAcctType", "1");
			
			List<CpIndacc> indaccList = cpIndaccMapper.searchCpIndaccByParams(params);
			String account="";
			if(null!=indaccList && indaccList.size()>0){
				CpIndacc newCpindacc = indaccList.get(0);
				
//				客户等级
//				newCpindacc.setCbProductCd(Integer.parseInt(cardtype));
				newCpindacc.setCbIndCardholderNo(cardno);
				newCpindacc.setCbCustomerId("P"+cardno);
				cpIndaccMapper.updateCpIndacc(newCpindacc);
				if(null!=newCpindacc.getCbExternalAcct()){
					account=newCpindacc.getCbExternalAcct();
					if(account.length()>19){
						account=account.substring(account.length()-19, account.length());
					}
				}
				
				account="0"+accountType+account;
				if(!"P".equals(crdtbl1.getCbIdType())){
					return StatusResult.create("FALSE","非预制卡");
				}
				
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				Date now = new Date();
				String nowDate = format.format(now);

				crdtbl1.setCbIdType(idtype);
				crdtbl1.setCbIdno(nricno);
				crdtbl1.setCbBscIdType(idtype);
				crdtbl1.setCbBasicCustomerIdno(nricno);
				crdtbl1.setCbAnnivDate(sysprmList.get(0).getSpNextProcessingDate());
				crdtbl1.setCbBillCycle(Integer.parseInt(sysprmList.get(0).getSpNextProcessingDate().substring(6)));

				crdtbl1.setCbSuspendDate(birthday);
//				crdtbl1.setCbCardPrdctGroup(Integer.parseInt(cardtype));
				crdtbl1.setCbIndaccRule(Integer.parseInt(NDACC_RULE));
				crdtbl1.setCbEmbossname(name);
				crdtbl1.setCbSourceCd(mobile);
				crdtbl1.setCbCvki(Integer.parseInt(chargeAmount));
				crdtbl1.setCbExpiryCcyymm(validDate);
				crdtbl1.setCbModUser(user);
				cpCrdtblMapper.updateCpCrdtbl(crdtbl1);
				
				BigDecimal balance = BigDecimal.ZERO;
				Map<String, String> paramsCst = new HashMap<String, String>();
				paramsCst.put("cbIdType",idtype);
				paramsCst.put("cbCustomerIdno",nricno);
				List<CpCsttbl> csttblList = cpCsttblMapper.searchCpCsttblByParams(paramsCst);
				if(null!=csttblList && csttblList.size()>0){
					CpCsttbl oldCsttbl=(CpCsttbl)csttblList.get(0);
					oldCsttbl.setCbHomePhone(mobile);
					oldCsttbl.setCbCardholderName(name);
					oldCsttbl.setCbDob(birthday);
					cpCsttblMapper.updateCpCsttbl(oldCsttbl);
				}else{
					CpCsttbl newCsttbl = new CpCsttbl(); 
					newCsttbl.setCbIdType(idtype);
					newCsttbl.setCbCustomerIdno(nricno);
					newCsttbl.setCbHomePhone(mobile);
					newCsttbl.setCbCardholderName(name);
					newCsttbl.setCbDob(birthday);
					cpCsttblMapper.insertCpCsttbl(newCsttbl);
				}
				
				
				//卡维护历史表:cp_crdmtn
				CpCrdmtn cpCrdmtn=new CpCrdmtn();
				
				Map<String, String> params2 = new HashMap<String, String>();
				params2.put("cmCardholderNo", cardno);
				params2.put("cmModDate", sysprmList.get(0).getSpNextProcessingDate());
				params2.put("cmCustomerIdno",nricno);
				params2.put("cmIdType",idtype);
				//排序
				List<CpCrdmtn> crdMtnList=cpCrdmtnMapper.searchCpCrdmtnByParams(params2);
				int intSeqNo=0;
				int tmpIndex=0;
				if(null==crdMtnList || crdMtnList.size()==0){
					intSeqNo=0;
				}else{
					CpCrdmtn tmpCrdmtn = new CpCrdmtn();
					tmpIndex = crdMtnList.size()-1;
					tmpCrdmtn=(CpCrdmtn)crdMtnList.get(tmpIndex);
					intSeqNo=tmpCrdmtn.getCmMtnSeq().intValue();
				}	
				cpCrdmtn.setCmCardholderNo(cardno);
				cpCrdmtn.setCmModDate(sysprmList.get(0).getSpNextProcessingDate());
				cpCrdmtn.setCmCustomerIdno(nricno);
				cpCrdmtn.setCmIdType(idtype);
				cpCrdmtn.setCmMtnSeq((long)intSeqNo + 1);
				cpCrdmtn.setCmOffId(user);
				Date sysDate = new Date();
				SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
				cpCrdmtn.setCmTimestamp(formatSysDate.format(sysDate));
				cpCrdmtn.setCmDesc("CB_ANNIV_DATE");
				cpCrdmtn.setCmMtnSeq((long)intSeqNo+1);
				cpCrdmtn.setCmOldContents(oldAnnivDate);
				cpCrdmtn.setCmNewContents(sysprmList.get(0).getSpNextProcessingDate());
				
				intSeqNo =intSeqNo+1;
				
				cpCrdmtnMapper.insertCpCrdmtn(cpCrdmtn);
				
				//cp_ceptrx
				CpCeptrx cpCeptrx=new CpCeptrx();
				cpCeptrx.setCtBranchId(crdtbl1.getCbCentreCd());
				Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
				cpCeptrx.setCtTranId(tranId);
				
				//start 主键流水messageId
				BigDecimal seqname = sequenceMapper.searchSerialToName();
				if(seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
					sequenceMapper.truncateSerial();
				}
				messageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
				//end
				
				cpCeptrx.setCtMessageId(messageid.longValue());
				cpCeptrx.setCtCardNumber(cardno);
//				cpCeptrx.setCtTranTime(getNowDate("HHmmss"));
				cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
				cpCeptrx.setCtDbCr("C");
				cpCeptrx.setCtTranAmount(BigDecimal.ZERO);
				cpCeptrx.setCtCardAmount(cpCeptrx.getCtTranAmount());
				cpCeptrx.setCtDescription("开卡");
				cpCeptrx.setCtCurrcode("156");
				cpCeptrx.setCtApproveTime(getNowDate("yyyyMMddHHmmss"));
				cpCeptrx.setCtPostTime(sysprmList.get(0).getSpNextProcessingDate());
				cpCeptrx.setCtAccountId(indaccList.get(0).getCbIndividualAcctno());
				cpCeptrx.setCtTranCode("OPENCARD");
				cpCeptrx.setCtTranCode("OPENCARD");
				cpCeptrx.setCtTxrnType("C");
				cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
				cpCeptrx.setCtBillCurrAmt(cpCeptrx.getCtTranAmount());
				cpCeptrx.setCtAgeCodeB4Post("00");
				cpCeptrx.setCtAgeCodeAfterPost("00");
				cpCeptrx.setCtReversalFlag("0");
				cpCeptrx.setCtOutstdB4Post(balance);
				cpCeptrx.setCtOutstdAfterPost(indaccList.get(0).getCbOutstdBal());
				cpCeptrx.setCtUserCreate(user);
				cpCeptrx.setCtStatus("0");
				cpCeptrx.setCtDc("0");
				cpCeptrx.setCtTranNum("1");
				cpCeptrx.setCtTranZone("0");
				cpCeptrx.setCtOpenZone("0");
				cpCeptrx.setCtCustomerId(indaccList.get(0).getCbCustomerId());
				cpCeptrx.setCtFeeAmount(new BigDecimal(chargeAmount));
				ceptrxMapper.insertCpCeptrx(cpCeptrx);
			}
		}else{
			return StatusResult.create("FALSE","无效卡号");
		}
		List<String> list = new ArrayList<String>();
		list.add(String.valueOf(messageid));
		return StatusResult.create(list);
	}
	
	
	public boolean checkcardno(String cardno) {
		boolean exist = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("cbCardholderNo", cardno);
		params.put("cbPlasticCd", "P");
		// params.put("CB_PLASTIC_CD", " ");
		List<CpCrdtbl> crdtblList = cpCrdtblMapper.searchCpCrdtblByParams(params);
		if (null != crdtblList && crdtblList.size() > 0) {
			exist = true;
		}
		return exist;
	}
	
	public static String getNowDate(String strDateFormat){
	    if (strDateFormat==null) 
	    	return "";
         	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(strDateFormat);
            java.util.Date currentTime = new java.util.Date();
            return formatter.format(currentTime).toString();
    }
	
	/**
	 * 
	 * @param oldCardNo
	 * @param newCardNo
	 * @param cbPrdct1  新卡客户等级
	 * @param yajin 押金
	 * @param staffId
	 * @author Hugh
	 */
	public void updateCRDTBL(String oldCardNo,String newCardNo,String cbPrdct1,String yajin,String staffId){
	
		
		String strRnThruYY = String.valueOf(rnThruYY);
		if(strRnThruYY.length()==1){
			strRnThruYY = "0"+strRnThruYY;
		}
		
		//查询新卡
		CpCrdtbl newcrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(newCardNo);
		String strExpireDate="";
		String basicsupp="";
		String strIndAcc="";
		String cic_cancel="";
		//删除新卡
		if(null!=newcrdtbl){
			basicsupp = newcrdtbl.getCbBasicSuppInd(); // 主副卡标志B
			strIndAcc = newcrdtbl.getCbIndividualAcctno(); //账号
			cic_cancel = newcrdtbl.getCbCicCancel(); // 分区授权0
			strExpireDate = newcrdtbl.getCbExpiryCcyymm(); //控制分时授权
			cpCrdtblMapper.deleteCpCrdtblByCbCardholderNo(newCardNo);
		}
		
		//查询旧卡
		CpCrdtbl oldcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCardNo);
		System.out.println(oldCardNo + "换" + newCardNo);
		String oldprdgrp = oldcrdtbl.getCbCardPrdctGroup().toString();
		//更新旧卡记录
		oldcrdtbl.setCbPlasticDate(SysDateFormat.getNowDate("yyyyMMdd")); //制卡日期
		oldcrdtbl.setCbPlasticCd("D");
		cpCrdtblMapper.updateCpCrdtbl(oldcrdtbl);
		//插入黑名单表
		String oldCardNo1 = oldCardNo.substring(10);
		CpBlkmlc oldblkmlc = blkmlcMapper.searchCpBlkmlcByBmCardNo(oldCardNo1);
		if(null==oldblkmlc){
			CpBlkmlc blkmlc = new CpBlkmlc();
			blkmlc.setBmCardNo(oldCardNo1);
			blkmlc.setBmReasonCode("D");
			blkmlc.setBmOrgId(staffId); //机构ID
			blkmlc.setBmInTime(SysDateFormat.getNowDate("yyyyMMdd"));
			blkmlc.setBmCardName(oldcrdtbl.getCbEmbossname());
			blkmlc.setBmProductCode(BigDecimal.ZERO.longValue());
			blkmlc.setBmBlack("Y");
			blkmlcMapper.insertCpBlkmlc(blkmlc);
		}
		oldcrdtbl.setCbCardPrdctGroup(Integer.parseInt(cbPrdct1)); //新卡客户等级
		oldcrdtbl.setCbCifFlag("C"); //？
		oldcrdtbl.setCbDcmsFlag("C");//？
		oldcrdtbl.setCbCafRefreshFlag("y"); //?
		
		//客户等级
		CpPrdgrp newPrdgrp = cpPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(cbPrdct1));
		String sActivationFg = newPrdgrp.getPrReplcCardActivation(); //换卡激活标志
		
		boolean boolRepl= (oldCardNo.equals(newCardNo) &&  strRnThruYY.equals(strExpireDate.substring(2,4)));
		
		if(sActivationFg!=null && sActivationFg.equalsIgnoreCase("Y") && !boolRepl){
			oldcrdtbl.setCbNewPlasticCd("U");
			oldcrdtbl.setCbNewExpiryCcyymm("20" + strRnThruYY + strExpireDate.substring(4, 6));
		}else{
			oldcrdtbl.setCbPlasticCd("U");
			oldcrdtbl.setCbNewPlasticCd("P");
			oldcrdtbl.setCbPlasticDate(" ");
			oldcrdtbl.setCbExpiryCcyymm(strExpireDate);
			oldcrdtbl.setCbNewExpiryCcyymm(" ");
		}
		
		oldcrdtbl.setCbNewPlasticDate(" ");
		oldcrdtbl.setCbFirstUseInd(" ");
		oldcrdtbl.setCbFirstUseDate(" ");
		oldcrdtbl.setCbFirstUseTime(" ");
		oldcrdtbl.setCbCardholderNo(newCardNo);
		oldcrdtbl.setCbBasicSuppInd(basicsupp);
		
		if(basicsupp!=null && !"".equals(basicsupp) && "B".equals(basicsupp)){
			oldcrdtbl.setCbBasicCardholderNo(newCardNo);
			oldcrdtbl.setCbBasicSuppInd("B");
		}
		oldcrdtbl.setCbPinOffset("000000FFFFFF");
		oldcrdtbl.setCbCicCancel(cic_cancel);
		
		System.out.println("---oldcrd:"+oldcrdtbl);
		cpCrdtblMapper.insertCpCrdtbl(oldcrdtbl);
		
		//查询新
		Map<String, String> paramsnIndacc = new HashMap<String, String>();
		paramsnIndacc.put("cbIndividualAcctno", strIndAcc);
		paramsnIndacc.put("cbIndividualAcctType", "1");
		cpIndaccMapper.deleteCpIndaccByParams(paramsnIndacc);
		
		//查询旧
		Map<String, String> paramsoIndacc = new HashMap<String, String>();
		paramsoIndacc.put("cbIndCardholderNo", oldCardNo);
		paramsoIndacc.put("cbProductCd", oldprdgrp);
		List<CpIndacc> indaccList = cpIndaccMapper.searchCpIndaccByParams(paramsoIndacc);
		System.out.println("---indaccList:"+indaccList.size());
		if(null!=indaccList && indaccList.size()>0){
			CpIndacc upIndacc = (CpIndacc)indaccList.get(0);
			upIndacc.setCbIndCardholderNo(newCardNo);
			upIndacc.setCbProductCd(Integer.parseInt(cbPrdct1));
			cpIndaccMapper.updateCpIndacc(upIndacc);
		}
	}
	
	
	public void insertMLRPRN(String newCardNo){
		
		List<CpSysprm> sysprmList = cpSysprmMapper.searchCpSysprmByParams(null);
		String varWsMlrDate = sysprmList.get(0).getSpProcessingDate();
		
		//查找新卡记录
		CpCrdtbl newcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(newCardNo);
		
		//查找客户记录
		Map<String, String> paramsCsttbl = new HashMap<String, String>();
		paramsCsttbl.put("cbIdType", newcrdtbl.getCbIdType());
		paramsCsttbl.put("cbCustomerIdno", newcrdtbl.getCbIdno());
		List<CpCsttbl> csttblList = cpCsttblMapper.searchCpCsttblByParams(paramsCsttbl);
		String field1 = "";
		String field2 = "";
		String field3 = "";
		String field4 = "";
		String field5 = "";
		String field6 = "";
		String field7 = "";
		String field8 = "";
		String field9 = "";
		String field10 = "";
		
		CpMlrprn mlrprn = new CpMlrprn();
		mlrprn.setWsMlrDate(varWsMlrDate);
		//
		mlrprn.setWsMlrSeqNo(null);
		mlrprn.setWsMlrActionType("N");
		mlrprn.setWsMlrProductGroup(newcrdtbl.getCbCardPrdctGroup().longValue());
		mlrprn.setWsMlrBranchId(newcrdtbl.getCbCollectCd());
		mlrprn.setWsMlrUserField1(newcrdtbl.getCbUserField1());
		mlrprn.setWsMlrCardholderNo(newCardNo);
		mlrprn.setWsMlrPan(newCardNo.substring(4));
		mlrprn.setWsMlrField0(csttblList.get(0).getCbCardholderName());
		switch (newcrdtbl.getCbBillAddrCd().charAt(0)){ //账单地址默认H
		case 'H':
			field1 = " ";
			field2 = csttblList.get(0).getCbHomeAddr1(); //家庭地址
			field3 = csttblList.get(0).getCbHomeAddr2();
			field4 = csttblList.get(0).getCbHomeAddr3();
			field5 = csttblList.get(0).getCbHomeAddr4();
			field6 = csttblList.get(0).getCbHomeAddr5();
			field7 = csttblList.get(0).getCbHomeCity();	//家庭地址所在城市
			field8 = csttblList.get(0).getCbHomeState();//家庭地址所在省
			
			CpCtrycd ctrycd = ctryMapper.searchCpCtrycdBySysAlphaCtryCd(csttblList.get(0).getCbHomeCntryCd());
			if(null!=ctrycd){
				if(null!=ctrycd.getSysCtryDescription() && !"".equals(ctrycd.getSysCtryDescription())){
					field9=ctrycd.getSysCtryDescription();
				}else{
					field9=csttblList.get(0).getCbHomeCntryCd();// 家庭地址所在国家
					field10=csttblList.get(0).getCbHomePostcode(); //邮政编码
				}
			}else{
				field9=csttblList.get(0).getCbHomeCntryCd();// 家庭地址所在国家
				field10=csttblList.get(0).getCbHomePostcode(); //邮政编码
			}
			break;
		case 'C':
			if("".equals(newcrdtbl.getCbCorporateId())){
				
				field1 = csttblList.get(0).getCbCompanyName();
				field2 = csttblList.get(0).getCbCoAddr1();
				field3 = csttblList.get(0).getCbCoAddr2();
				field4 = csttblList.get(0).getCbCoAddr3();
				field5 = csttblList.get(0).getCbCoAddr4();
				field6 = csttblList.get(0).getCbCoAddr5();
				field7 = csttblList.get(0).getCbCoCity();
				field8 = csttblList.get(0).getCbCoState();
				CpCtrycd ctrycd1 = ctryMapper.searchCpCtrycdBySysAlphaCtryCd(csttblList.get(0).getCbCoCntryCd());
				if(null!=ctrycd1.getSysCtryDescription() && !"".equals(ctrycd1.getSysCtryDescription())){
					field9 = ctrycd1.getSysCtryDescription();
				}else{
					field9 = csttblList.get(0).getCbCoCntryCd();
					field10 = csttblList.get(0).getCbCoPostcode();
				}
			}else{
				CpCopmst copmst = cpCopmstMapper.searchCpCopmstByCoCorporateId(newcrdtbl.getCbCorporateId());
				field1 = copmst.getCoCompanyName();
				field2 = copmst.getCoMailAddLine1();
				field3 = copmst.getCoMailAddLine2();
				field4 = copmst.getCoMailAddLine3();
				field5 = copmst.getCoMailAddLine4();
				field6 = copmst.getCoMailAddLine5();
				field7 = copmst.getCoMailCity();
				field8 = copmst.getCoMailState();
				
				CpCtrycd ctrcd2 = ctryMapper.searchCpCtrycdBySysAlphaCtryCd(copmst.getCoMailCntryCd());
				if(null!=ctrcd2.getSysCtryDescription() && !"".equals(ctrcd2.getSysCtryDescription())){
					field9 = ctrcd2.getSysCtryDescription();
				}else{
					field9 = copmst.getCoMailCntryCd();
					field10 = copmst.getCoMailAddPostcode();
				}
			}
			break;
		case '1':
			field1 = " ";
			field2 = csttblList.get(0).getCbAlt1BillAddr1();
			field3 = csttblList.get(0).getCbAlt1BillAddr2();
			field4 = csttblList.get(0).getCbAlt1BillAddr3();
			field5 = csttblList.get(0).getCbAlt1BillAddr4();
			field6 = csttblList.get(0).getCbAlt1BillAddr5();
			field7 = csttblList.get(0).getCbAlt1BillCity();
			field8 = csttblList.get(0).getCbAlt1BillState();
			
			CpCtrycd ctrycd3 = ctryMapper.searchCpCtrycdBySysAlphaCtryCd(csttblList.get(0).getCbAlt1BillCntryCd());
			if(null!=ctrycd3.getSysCtryDescription() && !"".equals(ctrycd3.getSysCtryDescription())){
				field9 = ctrycd3.getSysCtryDescription();
			}else{
				field9 = csttblList.get(0).getCbAlt1BillCntryCd();
				field10 = csttblList.get(0).getCbAlt1BillAddrPostcode();
			}
			break;
		case '2':
			field1 = " ";
			field2 = csttblList.get(0).getCbAlt2BillAddr1();
			field3 = csttblList.get(0).getCbAlt2BillAddr2();
			field4 = csttblList.get(0).getCbAlt2BillAddr3();
			field5 = csttblList.get(0).getCbAlt2BillAddr4();
			field6 = csttblList.get(0).getCbAlt2BillAddr5();
			field7 = csttblList.get(0).getCbAlt2BillCity();
			field8 = csttblList.get(0).getCbAlt2BillState();
			
			CpCtrycd ctrycd4 = ctryMapper.searchCpCtrycdBySysAlphaCtryCd(csttblList.get(0).getCbAlt2BillCntryCd());
			if(null!=ctrycd4.getSysCtryDescription() && !"".equals(ctrycd4.getSysCtryDescription())){
				field9 = ctrycd4.getSysCtryDescription();
			}else{
				field9 = csttblList.get(0).getCbAlt2BillCntryCd();
				field10 = csttblList.get(0).getCbAlt2BillAddrPostcode();
			}
			break;
		default:
			break;
		}

		mlrprn.setWsMlrField1(field1);
		mlrprn.setWsMlrField2(field2);
		mlrprn.setWsMlrField3(field3);
		mlrprn.setWsMlrField4(field4);
		mlrprn.setWsMlrField5(field5);
		mlrprn.setWsMlrField6(field6);
		mlrprn.setWsMlrField7(field7);
		mlrprn.setWsMlrField8(field8);
		mlrprn.setWsMlrField9(field9);
		mlrprn.setWsMlrField10(field10);
		mlrprn.setWsMlrFmtAddrLine1(field1);
		mlrprn.setWsMlrFmtAddrLine2(field2);
		mlrprn.setWsMlrFmtAddrLine3(field3);
		mlrprn.setWsMlrFmtAddrLine4(field4);
		mlrprn.setWsMlrFmtAddrLine5(field5);
		mlrprn.setWsMlrFmtAddrLine6(field6);
		mlrprnMapper.insertCpMlrprn(mlrprn);
	}
	
	
	public StatusResult<List<String>> insertCRDLNK(String oldCardNo, String newCardNo, String varRn_reason, String staffId) {

		String time = SysDateFormat.getNowDate("yyyyMMdd");
		List<CpSysprm> sysprmList = cpSysprmMapper.searchCpSysprmByParams(null);
		String nextdate = sysprmList.get(0).getSpNextProcessingDate();
		CpCrdlnk crdlnk = new CpCrdlnk();
		crdlnk.setClOldCard(oldCardNo);
		crdlnk.setClNewCard(newCardNo);
		crdlnk.setClConvertDate(nextdate);
		crdlnk.setClActivatedFlag(" ");
		crdlnk.setClDeliveryMethod("PE");
		crdlnk.setClReason(varRn_reason);

		CpCrdtbl oldcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCardNo);
		crdlnk.setClOldProdctGroup(oldcrdtbl.getCbCardPrdctGroup().longValue());
		crdlnk.setClNewProdctGroup(oldcrdtbl.getCbCardPrdctGroup().longValue());
		String flag = "N";

		CpPrdgrp oldprdgrp = cpPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(oldcrdtbl.getCbCardPrdctGroup());
		flag = oldprdgrp.getPrReplcCardActivation(); // 换卡激活标志
		crdlnk.setClActiveFlag(flag);
		crdlnk.setClOldLclCrlmt(new BigDecimal(0).longValue());
		crdlnk.setClNewLclCrlmt(new BigDecimal(0).longValue());
		crdlnk.setClOldFrgnCrlmt(new BigDecimal(0).longValue());
		crdlnk.setClNewFrgnCrlmt(new BigDecimal(0).longValue());
		crdlnk.setClLatestCardno(newCardNo);
		crdlnk.setClModDate(time);
		crdlnk.setClUserId(staffId);

		Date sysDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
		crdlnk.setClTimestamp(format.format(sysDate));
		crdlnk.setClAuthUserId(staffId);

		CpCrdlnk oldcrdlink = linkMapper.searchCpCrdlnkByClOldCard(oldCardNo);
		if (null != oldcrdlink) {
			return StatusResult.create("FALSE", "旧卡号已经换过卡,不能再换卡");
		} else {
			linkMapper.insertCpCrdlnk(crdlnk);
		}

		// 更新字段
		crdlnk.setClLatestCardno(newCardNo);
		Map<String, String> paramsLink = new HashMap<String, String>();
		paramsLink.put("clLatestCardno", oldCardNo);
		linkMapper.updateCpCrdlnkByParams(paramsLink);
		
		return StatusResult.create("OK", "成功");
	}
	
	
	
}
