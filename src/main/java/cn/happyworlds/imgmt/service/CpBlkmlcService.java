package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpBlkmlc;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdmtn;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.mapper.CpBlkmlcMapper;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCrdmtnMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class CpBlkmlcService {

	@Autowired
	private CpBlkmlcMapper cpBlkmlcMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private CpCeptrxMapper cpCeptrxMapper;
	@Autowired
	private CpCrdmtnMapper cpCrdmtnMapper;
	@Autowired
	private CpSysprmMapper sysprmMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	
	public Result<PageInfo<CpBlkmlc>> list(String bmCardNo,String bmCardName,PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(bmCardNo)) {
			params.put("bmCardNo", bmCardNo);
		}
		if (StringUtils.hasText(bmCardName)) {
			params.put("bmCardName", bmCardName);
		}
		List<CpBlkmlc> page = cpBlkmlcMapper.searchCpBlkmlcByParams(params, pageBounds);
		return Result.create(new PageInfo<CpBlkmlc>(page));
	}
	

	public StatusResult<String> add(String bmCardNo,String idtype,String idno,String userid) {
//		if(bmCardNo.equals("")){
//			Map<String, String> cpCrdtblparams = new HashMap<>();
//			cpCrdtblparams.put("cbIdType", idtype);
//			cpCrdtblparams.put("cbIdno", idno);
//			List<CpCrdtbl> cpCrdtbls = cpCrdtblMapper.searchCpCrdtblByParams(cpCrdtblparams);
//			if(cpCrdtbls.size()==0){
//				return StatusResult.create("CARDNOEXIST_NO","证件号对应的卡号不存在");
//			}else{
//				bmCardNo=cpCrdtbls.get(0).getCbCardholderNo();
//			}
//		}
		
		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(bmCardNo);
		if(cpCrdtbl==null){
			return StatusResult.create("CARDNOEXIST_NO","卡号不存在");
		}else{
			//idno不等于“”，并且与卡表的身份证号码不相同就返回
			if(!"".equals(idno)&&!idno.equals(cpCrdtbl.getCbIdno())){
				return StatusResult.create("CARDNOMARRY_NO","卡号与证件号码不匹配");
			}
			if(!"".equals(idtype)&&!idtype.equals(cpCrdtbl.getCbIdType())){
				return StatusResult.create("CARDNOMARRY_NO","卡号与证件类型不匹配");
			}
			CpBlkmlc cpblkmlc = cpBlkmlcMapper.searchCpBlkmlcByBmCardNo(bmCardNo.substring(10));
			if (cpblkmlc!=null) {
				return StatusResult.create("DUPLICATING", "同样的黑名单ID已经存在于列表中！");
			}else{
				CpBlkmlc blkmlc = new CpBlkmlc();
				blkmlc.setBmCardNo(bmCardNo.substring(10));
				blkmlc.setBmInTime(SysDateFormat.getNowDate("yyyyMMdd"));
				blkmlc.setBmOrgId(userid);
				blkmlc.setBmProductCode(new BigDecimal(1111).longValue());
				blkmlc.setBmReasonCode("L");
				blkmlc.setBmCardName(cpCrdtbl.getCbEmbossname());
				cpBlkmlcMapper.insertCpBlkmlc(blkmlc);
				return null;
			}
		}
	}
	
	public Long delete(final String bmCardNo) {
		Long r = cpBlkmlcMapper.deleteCpBlkmlcByBmCardNo(bmCardNo);
		return r;
	}
	
	public Result<CpBlkmlc> searchCpBlkmlcByBmCardNo(String bmCardNo) {
		CpBlkmlc cpBlkmlc = cpBlkmlcMapper.searchCpBlkmlcByBmCardNo(bmCardNo);
		return Result.create(cpBlkmlc);
	}
	
	public Result<CpBlkmlc> update(CpBlkmlc cpBlkmlc){
		try {
			cpBlkmlcMapper.updateCpBlkmlc(cpBlkmlc);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CPBLKMLC_UPDATE_FAILED", "黑名单更新失败");
		}
		return Result.create(cpBlkmlc);
	}
	
	
	/**
	 * 
	 * @param cardNo
	 * @param newPlasticCode
	 * @return
	 * 
	 * @author Hugh
	 */
	public StatusResult<String> loseCard(String cardNo, String newPlasticCode, String staffId) throws Exception {
		BigDecimal messageid = null;
		CpCrdtbl crdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
		List<CpSysprm> cpSysprm = sysprmMapper.searchCpSysprmByParams(null);
		try{
			if (null != crdtbl) {
				String plaCode = crdtbl.getCbPlasticCd().trim();
				if (plaCode.equalsIgnoreCase("D")) {
					return StatusResult.create("FALSE", "此卡已销卡，不能再销！");
				}
				if (plaCode.equals(newPlasticCode.trim())) {
					return StatusResult.create("FALSE", "请检查卡片状态,当前状态不能进行此操作！");
				}
				if (newPlasticCode.equalsIgnoreCase("P")) {
					if (plaCode.equalsIgnoreCase("L")) {
						return 	StatusResult.create("FALSE", "此卡已挂失！");
					}
					if (plaCode.equalsIgnoreCase("O")) {
						return StatusResult.create("FALSE", "此卡已锁定！");
					}
					if (plaCode.equalsIgnoreCase("X")) {
						return StatusResult.create("FALSE", "卡片状态异常！");
					}
				}
				if (newPlasticCode.equalsIgnoreCase("L")) {
					if (plaCode.equalsIgnoreCase("X")) {
						return StatusResult.create("FALSE", "卡片状态异常！");
					}
//					if (plaCode.equalsIgnoreCase("U")) {
//						return StatusResult.create("FALSE", "卡片未激活！");
//					}
				}
				// 卡维护历史表
				try{
					CpCrdmtn crdmtn = new CpCrdmtn();
					crdmtn.setCmIdType(crdtbl.getCbIdType());
					crdmtn.setCmCustomerIdno(crdtbl.getCbBasicCustomerIdno());
					crdmtn.setCmCardholderNo(cardNo);
					crdmtn.setCmModDate(cpSysprm.get(0).getSpNextProcessingDate());
					// 计算卡维护历史表CP_CRDMTN的修改序号CM_MTN_SEQ,20160831max是34
					long mtnSeq;
					if(sequenceMapper.searchCpCrdmtnToParamsMax()==null){
						mtnSeq = 1;
					}else{
						mtnSeq = sequenceMapper.searchCpCrdmtnToParamsMax() + 1;
					}
					crdmtn.setCmMtnSeq(mtnSeq);
					crdmtn.setCmOffId(staffId);
					SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
					Date sysDate = new Date();
					crdmtn.setCmTimestamp(formatSysDate.format(sysDate));
					crdmtn.setCmDesc("CB_PLASTIC_CD");
					if (crdtbl.getCbPlasticCd() == null || crdtbl.getCbPlasticCd().trim().equals("")) {
						crdmtn.setCmOldContents(" ");
					} else {
						crdmtn.setCmOldContents(crdtbl.getCbPlasticCd());
					}
					if (newPlasticCode == null || newPlasticCode.equals("")) {
						crdmtn.setCmNewContents(" ");
					} else {
						crdmtn.setCmNewContents(newPlasticCode);
					}
					cpCrdmtnMapper.insertCpCrdmtn(crdmtn);
		
					// 更新卡表状态
					if(newPlasticCode == null || newPlasticCode.equals("")){
						crdtbl.setCbPlasticCd("U");
					}else{
					crdtbl.setCbPlasticCd(newPlasticCode);
					}
					cpCrdtblMapper.updateCpCrdtbl(crdtbl);
				}catch(Exception e){
					return StatusResult.create("FALSE", "插入卡维护表记录异常！");
				}
				// 对blkmlc表操作
				/*if (null != newPlasticCode && !"".equals(newPlasticCode)) {
					try {
						CpBlkmlc blkmlc = new CpBlkmlc();
						blkmlc.setBmCardNo(cardNo.substring(10));
						blkmlc.setBmOrgId(staffId);
						blkmlc.setBmProductCode(BigDecimal.ZERO.longValue());
						blkmlc.setBmAccountId("1");
						blkmlc.setBmAccRefNo("1");
						blkmlc.setBmCardName(crdtbl.getCbEmbossname());
						blkmlc.setBmReasonCode("L");
						blkmlc.setBmStage(Long.valueOf("1"));
						blkmlc.setBmInTime(SysDateFormat.getNowDate("yyyyMMdd"));
						blkmlc.setBmOutTime(SysDateFormat.getNowDate("yyyyMMdd"));
						blkmlc.setBmBlack("Y");
						cpBlkmlcMapper.insertCpBlkmlc(blkmlc);
					} catch (Exception e) {
						return StatusResult.create("FALSE", "插入黑名单记录异常！");
					}
				} else {
					cpBlkmlcMapper.deleteCpBlkmlcByBmCardNo(cardNo.substring(10));
				}*/
	
				// 对cp_csttbl表操作
				Map<String, String> params = new HashMap<String, String>();
				params.put("cbIdType", crdtbl.getCbIdType());
				params.put("cbCustomerIdno", crdtbl.getCbIdno());
				List<CpCsttbl> csttblList = cpCsttblMapper.searchCpCsttblByParams(params);
	
				// 对cp_indacc表操作
				Map<String, String> params1 = new HashMap<String, String>();
				params1.put("cbIndividualAcctType", "1");
				params1.put("cbIndividualAcctno", crdtbl.getCbIndividualAcctno());
				List<CpIndacc> indaccList = cpIndaccMapper.searchCpIndaccByParams(params1);
	
				// 对cp_ceptrx
				CpCeptrx ceptrx = new CpCeptrx();
				ceptrx.setCtBranchId(crdtbl.getCbCentreCd());
				Long tranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");// 交易tranId
				ceptrx.setCtTranId(tranId);
				// start 主键流水messageId
				BigDecimal seqname = sequenceMapper.searchSerialToName();
				if (seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd"))) != 0) {
					sequenceMapper.truncateSerial();
				}
				messageid = sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
				// end
	
				ceptrx.setCtMessageId(messageid.longValue());
				ceptrx.setCtCustomerId(csttblList.get(0).getCbCustomerRefNo());
				ceptrx.setCtCardNumber(cardNo);
//				ceptrx.setCtTranTime(SysDateFormat.getNowDate("HHmmss"));
				ceptrx.setCtTranTime(DateTimes.nowDateTime());
				ceptrx.setCtDbCr("C");
				ceptrx.setCtTranAmount(BigDecimal.ZERO);
				ceptrx.setCtCardAmount(ceptrx.getCtTranAmount());
				if (null != newPlasticCode && !newPlasticCode.trim().equals("")) {
					ceptrx.setCtDescription("挂失");
					ceptrx.setCtTranCode("LOSS");
				} else {
					ceptrx.setCtDescription("解挂");
					ceptrx.setCtTranCode("UNLOSS");
				}
				ceptrx.setCtCurrcode("156");
				ceptrx.setCtApproveTime(SysDateFormat.getNowDate("yyyyMMddHHmmss"));
				// 查询cp_sysprm
				ceptrx.setCtPostTime(cpSysprm.get(0).getSpNextProcessingDate());
				ceptrx.setCtAccountId(indaccList.get(0).getCbIndividualAcctno());
				ceptrx.setCtTxrnType("C");
				ceptrx.setCtBillCurrCd(new BigDecimal("156").longValue());
				ceptrx.setCtBillCurrAmt(ceptrx.getCtTranAmount());
				ceptrx.setCtAgeCodeAfterPost("00");
				ceptrx.setCtReversalFlag("0");
				ceptrx.setCtOutstdB4Post(indaccList.get(0).getCbOutstdBal());
				ceptrx.setCtOutstdAfterPost(indaccList.get(0).getCbOutstdBal());
				ceptrx.setCtUserCreate(staffId);
				ceptrx.setCtStatus("0");
				ceptrx.setCtDc("0");
				ceptrx.setCtTranNum("1");
				ceptrx.setCtTranZone("0");
				ceptrx.setCtOpenZone("0");
				ceptrx.setCtCustomerId(indaccList.get(0).getCbCustomerId());
				System.out.println("-----:"+ceptrx);
				cpCeptrxMapper.insertCpCeptrx(ceptrx);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return StatusResult.create(messageid.toString());	
	}	
}
