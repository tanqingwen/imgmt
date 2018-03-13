package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;   // allow Spring injection
import org.springframework.stereotype.Service;   // allow service

import cn.happyworlds.imgmt.entity.CpBlkmlc;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpPlstic;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.CpBlkmlcMapper;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpPlsticMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class CardDService {

	// Spring will inject the container only after using this annotation
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpCeptrxMapper cpCeptrxMapper;
	@Autowired
	private CpBlkmlcMapper cpblkmlcMapper;
	@Autowired
	private CpPlsticMapper cpPlsticMapper;
	
	/**
	 * step 1: search cbCardholderNo in cp_crdtbl by params
	 * 
	 * @author yanjy
	 */
	public CpCrdtbl searchCpCrdtblByParams(String cbCardholderNo) {
		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
		return cpCrdtbl;
	}
	
	/**
	 * 退卡操作
	 * 
	 * 
	 * @author yanjy
	 */
	public Result<CpCrdtbl> doCheckerApprove(String cbCardholderNo,String varDesc,TSysStaff currentStaff) {
		CpCrdtbl crdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
		//退卡原因
		if(varDesc == null){
			varDesc="";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String SysDate = format.format(new Date());
		//系统参数表CP_SYSPRM的SP_PROCESSING_DATE上一系统日期
		List<CpSysprm> cpSysprm = cpSysprmMapper.searchCpSysprmByParams(null);
		String strDate = cpSysprm.get(0).getSpNextProcessingDate();
		//账户表CpIndacc信息
		CpIndacc cpIndacc = cpIndaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
		if(cpIndacc==null){
			return Result.create("NUMBER_ERROR","账户信息不存在");
		}
		//会员表CpCsttbl跟着证件种类和证件号码查数据
		Map<String, String> cpCsttblParams = new HashMap<>();
		cpCsttblParams.put("cbIdType", crdtbl.getCbIdType());
		cpCsttblParams.put("cbCustomerIdno",crdtbl.getCbIdno());
		List<CpCsttbl> cpCsttbl = cpCsttblMapper.searchCpCsttblByParams(cpCsttblParams);
		BigDecimal tranAmount = cpIndacc.getCbOutstdBal();
		BigDecimal feeAmount= new BigDecimal(crdtbl.getCbCvki());//==5?cpCrdtbl.getCbCvki():0;
		BigDecimal fee=BigDecimal.valueOf(5);
		//比较大小，不相等加5
		if(feeAmount.compareTo(fee)!=0){
			tranAmount = tranAmount.add(feeAmount);
		}
		
		//账务流水表Cp_Ceptrx插入一条数据
		//跟着“APNONSSEQ”查函数nextval，set账务流水表里的CT_TRAN_ID
		Long ctTranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");
		
		//查询serial表，nextserial函数，set账务流水表里的CT_MESSAGE_ID
		BigDecimal name = sequenceMapper.searchSerialToName();
		if(name.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyMMdd")))!=0){
			sequenceMapper.truncateSerial();
		}
		BigDecimal messageid = sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyMMdd"));
		
		CpCeptrx ceptrx = new CpCeptrx();
		ceptrx.setCtBranchId(crdtbl.getCbCentreCd());
		ceptrx.setCtTranId(ctTranId);
		ceptrx.setCtMessageId(messageid.longValue());
		ceptrx.setCtCustomerId(cpCsttbl.get(0).getCbCustomerRefNo());
		ceptrx.setCtCardNumber(crdtbl.getCbBasicCardholderNo());
//		ceptrx.setCtTranTime(SysDateFormat.getNowDate("HHmmss"));
		ceptrx.setCtTranTime(DateTimes.nowDateTime());
		ceptrx.setCtDbCr("D");
		ceptrx.setCtTranAmount(tranAmount);
		ceptrx.setCtCardAmount(ceptrx.getCtTranAmount());
		ceptrx.setCtDescription("退卡");
		ceptrx.setCtCurrcode("156");
		ceptrx.setCtApproveTime(SysDateFormat.getNowDate("yyyyMMddHHmmss"));
		ceptrx.setCtPostTime(strDate);
		ceptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
		ceptrx.setCtTranCode("DESTORY");
		ceptrx.setCtTxrnType("D");
		ceptrx.setCtBillCurrCd(new BigDecimal("156").longValue());
		ceptrx.setCtBillCurrAmt(ceptrx.getCtTranAmount());
		ceptrx.setCtAgeCodeB4Post("00");
		ceptrx.setCtAgeCodeAfterPost("00");
		ceptrx.setCtReversalFlag("0");
		ceptrx.setCtOutstdB4Post(cpIndacc.getCbOutstdBal());
		ceptrx.setCtOutstdAfterPost(BigDecimal.ZERO);
		ceptrx.setCtUserCreate(currentStaff.getId());
		ceptrx.setCtStatus("0");
		ceptrx.setCtDc("0");
		ceptrx.setCtTranNum("1");
		ceptrx.setCtTranZone("0");
		ceptrx.setCtOpenZone("0");
		ceptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
		cpCeptrxMapper.insertCpCeptrx(ceptrx);
		
		//黑名单insert数据
		CpBlkmlc blkmlc = new CpBlkmlc();
		blkmlc.setBmCardNo(crdtbl.getCbCardholderNo().substring(10));
		blkmlc.setBmReasonCode("D");
		blkmlc.setBmOrgId(currentStaff.getId());
		blkmlc.setBmInTime(SysDateFormat.getNowDate("yyyyMMdd"));
		blkmlc.setBmCardName(crdtbl.getCbEmbossname());
		blkmlc.setBmProductCode(BigDecimal.ZERO.longValue());
		blkmlc.setBmBlack("Y");
		cpblkmlcMapper.insertCpBlkmlc(blkmlc);
		
		// 清理INDACC和CRDTBL
		cleanDestoryCard(cbCardholderNo);
		insert_cp_plstic(crdtbl, SysDate,currentStaff.getId());
		update_cp_crdtbl(crdtbl, SysDate);
		
		return null;
	}
	
	/**
	 * 清理INDACC和CRDTBL1
	 * 
	 * 
	 * @author yanjy
	 */
	public void cleanDestoryCard(String cbCardholderNo) {
		CpCrdtbl crdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
		List<CpIndacc> cpIndaccs = new ArrayList<CpIndacc>();
		Map<String, String> cpIndaccParams = new HashMap<>();
		
		String strAccountNo0=crdtbl.getCbIndividualAcctno();
		CpIndacc cpIndacc = cpIndaccMapper.searchCpIndaccByAcctNo(strAccountNo0);
		if(cpIndacc!=null){
			System.out.println("清理卡["+cbCardholderNo+"]帐号1["+cpIndacc.getCbExternalAcct()+"]");
			cpIndacc.setCbExternalAcct("");
			cpIndacc.setCbExternalBranch("");
			crdtbl.setCbIndaccRule(0);
			cpIndacc.setCbOutstdBal(BigDecimal.ZERO);
			cpIndaccMapper.updateCpIndacc(cpIndacc);
			
		}
		
		String strAccountNo1 = crdtbl.getCbIndaccNo1();
		if (!"".equals(strAccountNo1) && cpIndaccs.size()>0) {
			cpIndaccParams.put("cbIndividualAcctno", strAccountNo1);
			cpIndaccParams.put("cbIndividualAcctType","1");
			cpIndaccs = cpIndaccMapper.searchCpIndaccByParams(cpIndaccParams);
			System.out.println("清理卡[" + cbCardholderNo + "]帐号2[" + cpIndaccs.get(0).getCbExternalAcct() + "]");
			cpIndaccParams.put("cbExternalAcct", "");
			cpIndaccParams.put("cbExternalBranch","");
			cpIndaccParams.put("cbOutstdBal","0");
			crdtbl.setCbIndaccRule1(0);
			cpIndaccMapper.updateCpIndaccByParams(cpIndaccParams);
			
		}
		String strAccountNo2 = crdtbl.getCbIndaccNo2();
		cpIndaccParams.clear();
		if (!"".equals(strAccountNo2) && cpIndaccs.size()>0) {
			cpIndaccParams.put("cbIndividualAcctno", strAccountNo2);
			cpIndaccParams.put("cbIndividualAcctType","1");
			cpIndaccs = cpIndaccMapper.searchCpIndaccByParams(cpIndaccParams);
			System.out.println("清理卡[" + cbCardholderNo + "]帐号3[" + cpIndaccs.get(0).getCbExternalAcct() + "]");
			cpIndaccParams.put("cbExternalAcct", "");
			cpIndaccParams.put("cbExternalBranch","");
			cpIndaccParams.put("cbOutstdBal","0");
			crdtbl.setCbIndaccRule2(0);
			cpIndaccMapper.updateCpIndaccByParams(cpIndaccParams);
			
		}
		
		String strAccountNo3 = crdtbl.getCbIndaccNo3();
		cpIndaccParams.clear();
		if (!"".equals(strAccountNo3) && cpIndaccs.size()>0) {
			cpIndaccParams.put("cbIndividualAcctno", strAccountNo3);
			cpIndaccParams.put("cbIndividualAcctType","1");
			cpIndaccs = cpIndaccMapper.searchCpIndaccByParams(cpIndaccParams);
			System.out.println("清理卡[" + cbCardholderNo + "]帐号4[" + cpIndaccs.get(0).getCbExternalAcct() + "]");
			cpIndaccParams.put("cbExternalAcct", "");
			cpIndaccParams.put("cbExternalBranch","");
			cpIndaccParams.put("cbOutstdBal","0");
			crdtbl.setCbIndaccRule3(0);
			cpIndaccMapper.updateCpIndaccByParams(cpIndaccParams);
			
		}
		
		String strAccountNo4 = crdtbl.getCbIndaccNo4();
		cpIndaccParams.clear();
		if (!"".equals(strAccountNo4) && cpIndaccs.size()>0) {
			cpIndaccParams.put("cbIndividualAcctno", strAccountNo4);
			cpIndaccParams.put("cbIndividualAcctType","1");
			cpIndaccs = cpIndaccMapper.searchCpIndaccByParams(cpIndaccParams);
			System.out.println("清理卡[" + cbCardholderNo + "]帐号5[" + cpIndaccs.get(0).getCbExternalAcct() + "]");
			cpIndaccParams.put("cbExternalAcct", "");
			cpIndaccParams.put("cbExternalBranch","");
			cpIndaccParams.put("cbOutstdBal","0");
			crdtbl.setCbIndaccRule4(0);
			cpIndaccMapper.updateCpIndaccByParams(cpIndaccParams);
			
		}
		
		String strAccountNo5 = crdtbl.getCbIndaccNo5();
		cpIndaccParams.clear();
		if (!"".equals(strAccountNo5) && cpIndaccs.size()>0) {
			cpIndaccParams.put("cbIndividualAcctno", strAccountNo5);
			cpIndaccParams.put("cbIndividualAcctType","1");
			cpIndaccs = cpIndaccMapper.searchCpIndaccByParams(cpIndaccParams);
			System.out.println("清理卡[" + cbCardholderNo + "]帐号6[" + cpIndaccs.get(0).getCbExternalAcct() + "]");
			cpIndaccParams.put("cbExternalAcct", "");
			cpIndaccParams.put("cbExternalBranch","");
			cpIndaccParams.put("cbOutstdBal","0");
			crdtbl.setCbIndaccRule5(0);
			cpIndaccMapper.updateCpIndaccByParams(cpIndaccParams);
			
		}
		System.out.println("清理卡[" + cbCardholderNo + "]相关信息");
		cpCrdtblMapper.updateCpCrdtbl(crdtbl);
	}
	
	/**
	 * 清理INDACC和CRDTBL2
	 * 
	 * 
	 * @author yanjy
	 */
	public void insert_cp_plstic(CpCrdtbl cpCrdtbl, String SysDate,String userId) {
		Date sysDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
		CpPlstic obPls = new CpPlstic();
		obPls.setPcCardholderNo(cpCrdtbl.getCbCardholderNo());
		obPls.setPcCardholderName(cpCrdtbl.getCbEmbossname());
		obPls.setPcOplasticCd(cpCrdtbl.getCbNewPlasticCd());
		obPls.setPcNplasticCd("D");
		obPls.setPcOplasticDate(cpCrdtbl.getCbNewPlasticDate());
		obPls.setPcNplasticDate(SysDate);
		obPls.setPcAction("D");
		obPls.setPcOffId(userId);
		obPls.setPcTimestamp(format.format(sysDate));
		cpPlsticMapper.insertCpPlstic(obPls);
	}
	
	/**
	 * 清理INDACC和CRDTBL3
	 * 
	 * 
	 * @author yanjy
	 */
	public void update_cp_crdtbl(CpCrdtbl cpCrdtbl, String SysDate) {
		// Update cp_crdtbl
		CpCrdtbl obup = new CpCrdtbl();
		obup.setCbCardholderNo(cpCrdtbl.getCbCardholderNo());
		// obup.CB_NEW_PLASTIC_CD("D");
		obup.setCbNewPlasticDate(SysDate);
		if (!cpCrdtbl.getCbCifFlag().equals("D")||!cpCrdtbl.getCbCifFlag().equals("C")) {
			obup.setCbCifFlag("U");
		}

		Date sysDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		// String newPlasticDate = aOB_CP_CRDTBL.CB_NEW_PLASTIC_DATE();
		String newExpiryDate = cpCrdtbl.getCbNewExpiryCcyymm();
		System.out.println("newPlasticDate is:" + format.format(sysDate)
						+ "              newExpiryDate is:" + newExpiryDate);

		obup.setCbNewPlasticCd("");
		obup.setCbPlasticCd("D");
		obup.setCbPlasticDate(format.format(sysDate));
		obup.setCbExpiryCcyymm(newExpiryDate);
		// zz comment this line for per 2 sr 628
		// obup.CB_NEW_PLASTIC_DATE("");
		obup.setCbNewExpiryCcyymm("");

		// add by hualei at 20030905 ends

		cpCrdtblMapper.updateCpCrdtbl(obup);
	}

}
