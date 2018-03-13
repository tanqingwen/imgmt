package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.CpBlkmlc;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdmtn;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpPlstic;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.entity.YwRefund;
import cn.happyworlds.imgmt.mapper.CpBlkmlcMapper;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCrdmtnMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpPlsticMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.mapper.YwRefundMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.ProcessDate;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class CardDestroyService {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CardDestroyService.class);

	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private YwRefundMapper ywRefundMapper;
	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	@Autowired
	private CpIndaccMapper indaccMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpCeptrxMapper ceptrxMapper;
	@Autowired
	private CpBlkmlcMapper blkmlcMapper;
	@Autowired
	private CpPlsticMapper plsticMapper;
	@Autowired
	private CpCrdmtnMapper crdmtnMapper;

	/**
	 * step 1: search card in cp_crdtbl by params
	 */
	public List<CpCrdtbl> searchCpCrdtblByParams(Map<String, String> map) {
		List<CpCrdtbl> list = cpCrdtblMapper.searchCpCrdtblByParams(map);
		return list;
	}

	/**
	 * step 2: change hw_deposit_balance
	 */
	public void updateCpCsttblByHwMemberId(Map<String, String> map, BigDecimal deposit) {
		List<CpCsttbl> list = cpCsttblMapper.searchCpCsttblByParams(map);
		CpCsttbl cpCsttbl = list.get(0);
		//cpCsttbl.setHwDepositBalance(deposit);
		cpCsttblMapper.updateCpCsttbl(cpCsttbl);
	}

	/**
	 * step 3: generate a serial number temperately set 00+now
	 */
	public int generateSerialNo() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmm");
		String time = dateFormat.format(date);
		String serialNoStr = "00" + time;
		int serialNo = Integer.valueOf(serialNoStr).intValue();
		System.out.println("service:step 4:" + serialNo);
		return serialNo;
	}

	/**
	 * step 4: insert an item in yw_refund
	 */
	public void insertYwRefund(int serialNo, BigDecimal deposit) {
		Date date = new Date();

		YwRefund ywRefund = new YwRefund();
		ywRefund.setHwId(serialNo);
		ywRefund.setHwRefundAmount(deposit);
		ywRefund.setHwExecuteTime(date);
		ywRefundMapper.insertYwRefund(ywRefund);
	}

	/**
	 * step 5: update old card in cp_crdtbl status = "D" date = now
	 */
	public void updateOldCard(String oldCard) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String time = dateFormat.format(date);

		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCard);
		cpCrdtbl.setCbPlasticCd("D");
		cpCrdtbl.setCbPlasticDate(time);
		cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
	}

	/**
	 * 退卡检查更新表
	 * 
	 * @param cardNumber
	 * @param cbIdType
	 * @param cbIdno
	 * @param varDesc
	 * 
	 * @return
	 * @throws Exception 
	 */
	public StatusResult<String> doCheckerApprove(String cardNumber, String cbIdType, String cbIdno, String staffId,String varDesc,String varDestype) throws Exception {
		BigDecimal messageid = null;
		Map<String, String> param = new HashMap<>();
		CpCrdtbl crdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNumber);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		String nowDate = format.format(now);
		// 查询cp_sysprm
		List<CpSysprm> sysprmList = cpSysprmMapper.searchCpSysprmByParams(null);
		CpSysprm cpSysprm = new CpSysprm();
		String strDate = "";
		if (null != sysprmList) {
			cpSysprm = sysprmList.get(0);
			strDate = cpSysprm.getSpNextProcessingDate();
		}
		CpIndacc indacc = indaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
		if (null != indacc) {
			param.put("cbIdType", crdtbl.getCbIdType());
			param.put("cbCustomerIdno", crdtbl.getCbIdno());
			List<CpCsttbl> csttblList = cpCsttblMapper.searchCpCsttblByParams(param);
			if (null != csttblList && csttblList.size() > 0) {
				BigDecimal tranAmount = indacc.getCbOutstdBal(); // 余额
//				BigDecimal feeAmount = new BigDecimal(crdtbl.getCbCvki()); // 押金
//				BigDecimal fee = BigDecimal.valueOf(5);
//				if (feeAmount.compareTo(fee) != 0) {
//					tranAmount = tranAmount.add(feeAmount);
//				}

				//退到客户账户
				if("Y".equalsIgnoreCase(varDestype)){
					Map<String, String> paramCst = new HashMap<>();
					paramCst.put("cbIdType", crdtbl.getCbIdType());
					paramCst.put("cbCustomerIdno", crdtbl.getCbBasicCustomerIdno());
					List<CpCsttbl> csttblNew = cpCsttblMapper.searchCpCsttblByParams(paramCst);
					CpCsttbl cpCsttblNew = csttblNew.get(0);
					if(null==cpCsttblNew.getCbUserAmt1()){
						cpCsttblNew.setCbUserAmt1(tranAmount);
					}else{
						cpCsttblNew.setCbUserAmt1(cpCsttblNew.getCbUserAmt1().add(tranAmount));
					}
					cpCsttblMapper.updateCpCsttbl(cpCsttblNew);
				}
					
				// 插入流水表
				CpCeptrx cpCeptrx = new CpCeptrx();
				cpCeptrx.setCtBranchId(crdtbl.getCbCentreCd());
				Long tranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");// 交易tranId
				cpCeptrx.setCtTranId(tranId);

				// start 主键流水messageId
				BigDecimal seqname = sequenceMapper.searchSerialToName();
				if (seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd"))) != 0) {
					sequenceMapper.truncateSerial();
				}
				messageid = sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
				// end

				cpCeptrx.setCtMessageId(messageid.longValue());
				cpCeptrx.setCtCustomerId(indacc.getCbCustomerId());
				cpCeptrx.setCtCardNumber(crdtbl.getCbCardholderNo());
//				cpCeptrx.setCtTranTime(SysDateFormat.getNowDate("HHmmss"));
				cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
				cpCeptrx.setCtDbCr("D");
				cpCeptrx.setCtTranAmount(tranAmount);
				cpCeptrx.setCtCardAmount(cpCeptrx.getCtTranAmount());
				cpCeptrx.setCtDescription("退卡");
				cpCeptrx.setCtCurrcode("156");
				cpCeptrx.setCtApproveTime(SysDateFormat.getNowDate("yyyyMMddHHmmss"));
				cpCeptrx.setCtPostTime(strDate);
				cpCeptrx.setCtAccountId(indacc.getCbIndividualAcctno());
				cpCeptrx.setCtTranCode("DESTORY");
				cpCeptrx.setCtTxrnType("D");
				cpCeptrx.setCtBillCurrCd(new BigDecimal("156").longValue());
				cpCeptrx.setCtBillCurrAmt(cpCeptrx.getCtTranAmount());
				
				cpCeptrx.setCtAgeCodeAfterPost("00");
				cpCeptrx.setCtReversalFlag("0");
				cpCeptrx.setCtOutstdB4Post(indacc.getCbOutstdBal());
				cpCeptrx.setCtOutstdAfterPost(BigDecimal.ZERO);
				cpCeptrx.setCtUserCreate(staffId);
				cpCeptrx.setCtStatus("0");
				cpCeptrx.setCtDc("0");
				cpCeptrx.setCtTranNum("1");
				cpCeptrx.setCtTranZone("0");
				cpCeptrx.setCtOpenZone("0");
				ceptrxMapper.insertCpCeptrx(cpCeptrx);

				// 先查询
				CpBlkmlc yblkmlc = blkmlcMapper.searchCpBlkmlcByBmCardNo(cardNumber.substring(10));
				if (null == yblkmlc) {
					// 插入黑名单表
					CpBlkmlc blkmlc = new CpBlkmlc();
					blkmlc.setBmCardNo(cardNumber.substring(10));
					blkmlc.setBmReasonCode("D");
					blkmlc.setBmOrgId(staffId);
					blkmlc.setBmInTime(SysDateFormat.getNowDate("yyyyMMdd"));
					blkmlc.setBmCardName(crdtbl.getCbEmbossname());
					blkmlc.setBmProductCode(BigDecimal.ZERO.longValue());
					blkmlc.setBmBlack("Y");
					blkmlcMapper.insertCpBlkmlc(blkmlc);

				}
			} else {
				return StatusResult.create("FALSE", "客户信息不存在!");
			}
		} else {
			return StatusResult.create("FALSE", "账户信息不存在!");
		}

		// 清理INDACC和CRDTBL
		cleanDestoryCard(cardNumber);
		//
		if (insert_cp_plstic(crdtbl, nowDate, staffId)) {
			if (update_cp_crdtbl(crdtbl,cardNumber, nowDate)) {
				if (insert_cp_crdmtn(crdtbl, strDate, staffId,varDesc)) {
					StatusResult.create(messageid + "");
				}
			}
		}
		return StatusResult.create(messageid + "");
	}

	
	/**
	 * 柜台退卡清理卡信息
	 * 
	 * @param cardNo
	 * 
	 * @author Hugh
	 */
	public void cleanDestoryCard(String cardNo) {
		CpCrdtbl crdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
		if (null != crdtbl) {
			CpIndacc indacc = indaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
			if (null != indacc) {
				// 清理卡+卡号+账号1+外部账号
				indacc.setCbExternalAcct(""); // 外部账号
				indacc.setCbExternalBranch("");
				crdtbl.setCbIndaccRule(new BigDecimal(0).intValue()); // 默认156,开卡0
				indacc.setCbOutstdBal(BigDecimal.ZERO); // 余额
				System.out.println("---4:"+indacc);
				indaccMapper.updateCpIndacc(indacc);
			}
			String strAccountNo1 = crdtbl.getCbIndaccNo1(); // 外部账号1
			Map<String, String> param = new HashMap<>();
			param.put("cbIndividualAcctno", strAccountNo1);
			param.put("cbIndividualAcctType", new BigDecimal(1).toString());
			List<CpIndacc> indaccList = indaccMapper.searchCpIndaccByParams(param);
			if (!"".equals(strAccountNo1) && null != indaccList && indaccList.size() > 0) {
				// 清理卡+卡号+账号2+外部账号
				CpIndacc newIndacc = indaccList.get(0);
				newIndacc.setCbExternalAcct("");
				newIndacc.setCbExternalBranch("");
				crdtbl.setCbIndaccRule1(new BigDecimal(0).intValue());
				newIndacc.setCbOutstdBal(BigDecimal.ZERO);
				indaccMapper.updateCpIndacc(newIndacc);
			}
			String strAccountNo2 = crdtbl.getCbIndaccNo2(); // 外部账号1
			Map<String, String> param1 = new HashMap<>();
			param.put("cbIndividualAcctno", strAccountNo2);
			param.put("cbIndividualAcctType", new BigDecimal(1).toString());
			List<CpIndacc> indaccList1 = indaccMapper.searchCpIndaccByParams(param1);
			if (!"".equals(strAccountNo2) && null != indaccList1 && indaccList1.size() > 0) {
				// 清理卡+卡号+账号3+外部账号
				CpIndacc newIndacc1 = indaccList1.get(0);
				newIndacc1.setCbExternalAcct("");
				newIndacc1.setCbExternalBranch("");
				crdtbl.setCbIndaccRule1(new BigDecimal(0).intValue());
				newIndacc1.setCbOutstdBal(BigDecimal.ZERO);
				indaccMapper.updateCpIndacc(newIndacc1);
			}
			String strAccountNo3 = crdtbl.getCbIndaccNo3(); // 外部账号1
			Map<String, String> param2 = new HashMap<>();
			param.put("cbIndividualAcctno", strAccountNo3);
			param.put("cbIndividualAcctType", new BigDecimal(1).toString());
			List<CpIndacc> indaccList2 = indaccMapper.searchCpIndaccByParams(param2);
			if (!"".equals(strAccountNo2) && null != indaccList2 && indaccList2.size() > 0) {
				// 清理卡+卡号+账号4+外部账号
				CpIndacc newIndacc2 = indaccList2.get(0);
				newIndacc2.setCbExternalAcct("");
				newIndacc2.setCbExternalBranch("");
				crdtbl.setCbIndaccRule1(new BigDecimal(0).intValue());
				newIndacc2.setCbOutstdBal(BigDecimal.ZERO);
				indaccMapper.updateCpIndacc(newIndacc2);
			}
			String strAccountNo4 = crdtbl.getCbIndaccNo4(); // 外部账号1
			Map<String, String> param3 = new HashMap<>();
			param3.put("cbIndividualAcctno", strAccountNo3);
			param3.put("cbIndividualAcctType", new BigDecimal(1).toString());
			List<CpIndacc> indaccList3 = indaccMapper.searchCpIndaccByParams(param3);
			if (!"".equals(strAccountNo4) && null != indaccList3 && indaccList3.size() > 0) {
				// 清理卡+卡号+账号5+外部账号
				CpIndacc newIndacc3 = indaccList3.get(0);
				newIndacc3.setCbExternalAcct("");
				newIndacc3.setCbExternalBranch("");
				crdtbl.setCbIndaccRule1(new BigDecimal(0).intValue());
				newIndacc3.setCbOutstdBal(BigDecimal.ZERO);
				indaccMapper.updateCpIndacc(newIndacc3);
			}
			String strAccountNo5 = crdtbl.getCbIndaccNo5(); // 外部账号1
			Map<String, String> param4 = new HashMap<>();
			param4.put("cbIndividualAcctno", strAccountNo4);
			param4.put("cbIndividualAcctType", new BigDecimal(1).toString());
			List<CpIndacc> indaccList4 = indaccMapper.searchCpIndaccByParams(param4);
			if (!"".equals(strAccountNo5) && null != indaccList4 && indaccList4.size() > 0) {
				// 清理卡+卡号+账号6+外部账号
				CpIndacc newIndacc4 = indaccList4.get(0);
				newIndacc4.setCbExternalAcct("");
				newIndacc4.setCbExternalBranch("");
				crdtbl.setCbIndaccRule1(new BigDecimal(0).intValue());
				newIndacc4.setCbOutstdBal(BigDecimal.ZERO);
				indaccMapper.updateCpIndacc(newIndacc4);
			}
		}
	}

	/**
	 * 柜台退卡插入CpPlstic
	 * 
	 * @param crdtbl
	 * @param SysDate
	 * @param staffId
	 * @return
	 * @throws Exception
	 * 
	 * @author Hugh
	 */
	protected boolean insert_cp_plstic(CpCrdtbl crdtbl, String SysDate, String staffId) throws Exception {
		boolean checkFlag = false;
		try {
			// insert cp_plstic
			Date sysDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
			CpPlstic obPls = new CpPlstic();
			obPls.setPcCardholderNo(crdtbl.getCbCardholderNo());
			obPls.setPcCardholderName(crdtbl.getCbEmbossname());
			obPls.setPcOplasticCd(crdtbl.getCbNewPlasticCd());
			obPls.setPcNplasticCd("D");
			obPls.setPcOplasticDate(crdtbl.getCbNewPlasticDate());
			obPls.setPcNplasticDate(SysDate);
			obPls.setPcAction("D");
			obPls.setPcOffId(staffId);
			obPls.setPcTimestamp(format.format(sysDate));
			plsticMapper.insertCpPlstic(obPls);
			checkFlag = true;
		} catch (Exception e) {
			log.error("Error Insert record into CP_PLSTIC:" + e.getMessage());
			throw new Exception("向数据库插入记录错误!");
		}
		return checkFlag;
	}

	/**
	 * 柜台退卡更新Cpcrdtbl
	 * 
	 * @param cardNumber
	 * @param SysDate
	 * @return
	 * @throws Exception
	 * 
	 * @author Hugh
	 */
	protected boolean update_cp_crdtbl(CpCrdtbl crdtbl,String cardNumber, String SysDate) throws Exception {

		boolean checkFlag = false;
		try {
			if (!"D".equals(crdtbl.getCbCifFlag()) || !"C".equals(crdtbl.getCbCifFlag())) {
				crdtbl.setCbCifFlag("U");
			}
			
			CpCrdtbl ycrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNumber);
			Date sysDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String newEdxpiryDate = ycrdtbl.getCbNewExpiryCcyymm();

			// 更新
			crdtbl.setCbNewPlasticCd("");
			crdtbl.setCbPlasticCd("D");
			crdtbl.setCbPlasticDate(format.format(sysDate));
			crdtbl.setCbExpiryCcyymm(newEdxpiryDate);
			crdtbl.setCbNewExpiryCcyymm("");
			cpCrdtblMapper.updateCpCrdtbl(crdtbl);
			checkFlag = true;
		} catch (Exception e) {
			log.error("Error update the cp_crdtbl: " + e.getMessage());
			throw new Exception("向数据库更新记录出错!");
		}
		return checkFlag;
	}

	
	/**
	 * 
	 * @param crdtbl
	 * @param SysDate
	 * @param staffId
	 * @param desc
	 * @return
	 * 
	 * @author Hugh
	 * @throws Exception 
	 */
	public boolean insert_cp_crdmtn(CpCrdtbl crdtbl, String SysDate, String staffId, String desc) throws Exception {

		boolean checkFlag = false;
		try {
			CpCrdmtn crdmtn = new CpCrdmtn();
			Date sysDate = new Date();
			SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
			// 查询cp_sysprm
			List<CpSysprm> sysprmList = cpSysprmMapper.searchCpSysprmByParams(null);
			CpSysprm cpSysprm = new CpSysprm();
			if (null != sysprmList) {
				cpSysprm = sysprmList.get(0);
			}
			String proDate = cpSysprm.getSpNextProcessingDate();
			
			crdmtn.setCmCardholderNo(crdtbl.getCbCardholderNo());
			crdmtn.setCmCustomerIdno(crdtbl.getCbIdno());
			crdmtn.setCmIdType(crdtbl.getCbIdType());
			crdmtn.setCmModDate(proDate);
			crdmtn.setCmOffId(staffId);
			crdmtn.setCmDesc("DesCrd");
			String str = crdtbl.getCbPlasticCd();
			if (str == null || "".equals(str)) {
				str = " ";
			}
			crdmtn.setCmOldContents(str + ": " + desc);
			crdmtn.setCmNewContents("D");
			crdmtn.setCmTimestamp(formatSysDate.format(sysDate));
			int intSeqNo = -1;	
			
			//
			Map<String, String> param = new HashMap<>();
			param.put("cmIdType", crdtbl.getCbIdType());
			param.put("cmCustomerIdno", crdtbl.getCbIdno());
			param.put("cmCardholderNo", crdtbl.getCbCardholderNo());
			param.put("cmModDate", proDate);
			
			List<CpCrdmtn> crdMtnList=crdmtnMapper.searchCpCrdmtnByParams(param);
			if(null!=crdMtnList && crdMtnList.size()>0){
				int size= crdMtnList.size();
				intSeqNo+=crdMtnList.get(size).getCmMtnSeq().intValue();
			}
			crdmtn.setCmMtnSeq(new Long(intSeqNo));
			
			crdmtnMapper.insertCpCrdmtn(crdmtn);
		} catch (Exception e) {
			log.error("Error update the cp_crdmetn: " + e.getMessage());
			throw new Exception("向数据库更新记录出错!");
		}
		return checkFlag;
	}
	
	
}
