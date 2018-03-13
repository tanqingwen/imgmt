package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.to.Constants;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class BatchCrdtblService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BatchCrdtblService.class);
	private static final String STR_FORMAT = "00000000000000000000";
	private static final String ACCT_REF_NO = "000000000000";
	
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	
	
	public StatusResult<String> insertDate(String custLevel, int startCardNo) {
		DecimalFormat df = new DecimalFormat(STR_FORMAT);
		DecimalFormat arn = new DecimalFormat(ACCT_REF_NO);
		DecimalFormat dfCard=new DecimalFormat("00000000");

		String time = SysDateFormat.getNowDate("yyyyMMdd");

		CpCrdtbl newCrdtbl = new CpCrdtbl();
		
		String str2=dfCard.format(startCardNo);
		String cardNo = Constants.baseBIN + str2; // 16位卡号
		
		
		Long AcctNoTmp = sequenceMapper.searchIndaccseq("ACCTNOSEQ");
		String AcctNo = df.format(AcctNoTmp); // 账号
		String AcctRefNo = arn.format(AcctNoTmp); // 对照账号

		
		//String cardNo = CardDigit(cardNoTmp);// 校验卡号

		newCrdtbl.setCbCardholderNo(cardNo);
		newCrdtbl.setCbBasicSuppInd("B");
		newCrdtbl.setCbIdType("P");
		newCrdtbl.setCbIdno("99999");
		newCrdtbl.setCbBscIdType("P");
		newCrdtbl.setCbBasicCustomerIdno("99999");
		newCrdtbl.setCbBasicCardholderNo(cardNo);
		newCrdtbl.setCbIndividualAcctno(AcctNo);
		newCrdtbl.setCbSeparateStmtInd("");
		newCrdtbl.setCbEmbossname("U.N.K.N.O.W");
		newCrdtbl.setCbBillCycle(10);
		newCrdtbl.setCbAutopayInd(0);
		newCrdtbl.setCbAutopayBankBranch("");
		newCrdtbl.setCbAutopayBankAccno("");
		newCrdtbl.setCbAutopayAccname("");
		newCrdtbl.setCbFrgnAutopayInd(0);
		newCrdtbl.setCbAutopayFrgnBankBranch("");
		newCrdtbl.setCbAutopayFrgnBankAccno("");
		newCrdtbl.setCbAutopayFrgnAccname("");
		newCrdtbl.setCbPinGenInd("0");
		newCrdtbl.setCbCurrBankRel("0");
		newCrdtbl.setCbCentreCd("000001");
		newCrdtbl.setCbSourceCd("");
		newCrdtbl.setCbRecommenderNo("");
		newCrdtbl.setCbRecommenderName("");
		newCrdtbl.setCbMicrofilmNo("");
		newCrdtbl.setCbAnnivDate(time);
		newCrdtbl.setCbCardPrdctGroup(Integer.parseInt(custLevel));
		newCrdtbl.setCbFeeCd(1);
		newCrdtbl.setCbCreditGuarantee("");
		newCrdtbl.setCbRenewalFlag("");
		newCrdtbl.setCbSuspendDate("");
		newCrdtbl.setCbBankruptcyDate("");
		newCrdtbl.setCbBankruptcyDate("");
		newCrdtbl.setCbCancelDate("");
		newCrdtbl.setCbLegalDate("");
		newCrdtbl.setCbFraudDate("");
		newCrdtbl.setCbReserveDate("");
		newCrdtbl.setCbReserveDate("");
		newCrdtbl.setCbReinstateDate("");
		newCrdtbl.setCbExpiryCcyymm("211401");
		newCrdtbl.setCbPlasticCd("P");
		newCrdtbl.setCbPlasticDate("");
		newCrdtbl.setCb4dbc("100");
		newCrdtbl.setCbNewExpiryCcyymm("");
		newCrdtbl.setCbNewPlasticCd("");
		newCrdtbl.setCbNewPlasticDate("");
		newCrdtbl.setCbNew4dbc("100");
		newCrdtbl.setCbXrefInd("");
		newCrdtbl.setCbXrefAccno("");
		newCrdtbl.setCbUserFieldNum1(null);
		newCrdtbl.setCbUserFieldNum2(null);
		newCrdtbl.setCbUserFieldNum3(null);
		newCrdtbl.setCbUserFieldNum4(null);
		newCrdtbl.setCbUserCode1("");
		newCrdtbl.setCbUserCode2("");
		newCrdtbl.setCbUserCode3("");
		newCrdtbl.setCbUserCode4("");
		newCrdtbl.setCbUserDate1(time);
		newCrdtbl.setCbUserDate2("");
		newCrdtbl.setCbUserAmt1(null);
		newCrdtbl.setCbUserAmt2(null);
		newCrdtbl.setCbUserField1("");
		newCrdtbl.setCbUserField2("");
		newCrdtbl.setCbUserField3("");
		newCrdtbl.setCbModDate(time);
		newCrdtbl.setCbModUser("0001");
		newCrdtbl.setCbPinOffset("0000FFFFFFFF");
		newCrdtbl.setCbPvki(5);
		newCrdtbl.setCbCicCancel("0");
		newCrdtbl.setCbCrshldInd("N");
		newCrdtbl.setCbCrshldEnrolDate("");
		newCrdtbl.setCbCrshldTerminateDate("");
		newCrdtbl.setCbCorporateId("");
		newCrdtbl.setCbSic("");
		newCrdtbl.setCbRelationship("");
		newCrdtbl.setCbFraudFlag1(0);
		newCrdtbl.setCbFraudFlag2("");
		newCrdtbl.setCbFirstUseDate("");
		newCrdtbl.setCbFirstUseTime("");
		newCrdtbl.setCbFirstUseInd("");
		newCrdtbl.setCbOldIdType("");
		newCrdtbl.setCbOldCustomerIdno("");
		newCrdtbl.setCbCifFlag("");
		newCrdtbl.setCbDcmsFlag("");
		newCrdtbl.setCbCafRefreshFlag("");
		newCrdtbl.setCbCafUpdateFlag("");
		newCrdtbl.setCbCafPinFlag("");
		newCrdtbl.setCbCafTagFlag("");
		newCrdtbl.setCbCardCollMethod("B");
		newCrdtbl.setCbCardDeliveryAddr("");
		newCrdtbl.setCbBillAddrCd("H");
		newCrdtbl.setCbRwdsAccno("");
		newCrdtbl.setCbLegalAddrCd("H");
		newCrdtbl.setCbLastRenewFeeYear(time.substring(0, 4));
		newCrdtbl.setCbStatusCd("");
		newCrdtbl.setCbMonitorCd("");
		newCrdtbl.setCbCollectCd("600000");
		newCrdtbl.setCbEmployeeId("");
		newCrdtbl.setCbIndaccRule(156);
		newCrdtbl.setCbIndaccNo1("");
		newCrdtbl.setCbIndaccRule1(0);
		newCrdtbl.setCbIndaccNo2("");
		newCrdtbl.setCbIndaccRule2(0);
		newCrdtbl.setCbIndaccNo3("");
		newCrdtbl.setCbIndaccRule3(0);

		newCrdtbl.setCbIndaccNo4("");
		newCrdtbl.setCbIndaccRule4(0);

		newCrdtbl.setCbIndaccNo5("");
		newCrdtbl.setCbIndaccRule5(0);

		newCrdtbl.setCbIndaccNo6("");
		newCrdtbl.setCbIndaccRule6(0);

		newCrdtbl.setCbIndaccNo7("");
		newCrdtbl.setCbIndaccRule7(0);

		newCrdtbl.setCbIndaccNo8("");
		newCrdtbl.setCbIndaccRule8(0);

		newCrdtbl.setCbIndaccNo9("");
		newCrdtbl.setCbIndaccRule9(0);
		newCrdtbl.setCbPvv(0);
		newCrdtbl.setCbPvvOffset(0);
		newCrdtbl.setCbCvki(0);
		newCrdtbl.setChecksum("");

		// 检查卡记录
		CpCrdtbl crdtblDto = cpCrdtblMapper.searchCpCrdtblByCbIdno(cardNo);
		if (null != crdtblDto) {
			return StatusResult.create("FALSE", "起始卡号记录已存在");
		}

		cpCrdtblMapper.insertCpCrdtbl(newCrdtbl);

		// 账户表
		CpIndacc indaccDto = new CpIndacc();
		indaccDto.setCbIndividualAcctno(AcctNo);
		indaccDto.setCbIndividualAcctType(BigDecimal.ONE.intValue());
		indaccDto.setCbProductCd(new BigDecimal(custLevel).intValue());
		indaccDto.setCbFinAcctno("");
		indaccDto.setCbLineLimit(null);
		indaccDto.setCbTempLineLimit(null);
		indaccDto.setCbTempStartDate("");
		indaccDto.setCbTempEndDate("");
		indaccDto.setCbOutstdBal(BigDecimal.ZERO);
		indaccDto.setCbFeeWaiverSpend(null);
		indaccDto.setCbIndCardholderNo(cardNo);
		indaccDto.setCbAcctClass(1);
		indaccDto.setCbCustomerId("P" + cardNo);
		indaccDto.setCbBranchId("600000");
		indaccDto.setCbAcctRefNo(AcctRefNo);
		indaccDto.setCbOpenDate(time);
		indaccDto.setCbCloseDate("");
		indaccDto.setCbAcruInterest(null);
		indaccDto.setCbLastIntDate(time);
		indaccDto.setCbAcctStatus("");
		indaccDto.setCbAcctAgeCd("0");
		indaccDto.setCbFatherIndacc(cardNo);
		indaccDto.setCbExternalAcct(null);
		indaccDto.setCbIntRule(1);
		indaccDto.setCbMngfeeRule(null);
		indaccDto.setCbStatementRule(101);
		indaccDto.setCbMngfeeRule(null);
		indaccDto.setCbStatementRule(new BigDecimal(101).intValue());
		indaccDto.setCbNextStmDate("");
		indaccDto.setCbBlockBal(null);
		indaccDto.setCbCurrencyCode(new BigDecimal(156).intValue());
		indaccDto.setCbOdintRule(null);
		indaccDto.setCbPenaltyRule(0);

		indaccDto.setCbOdStartDate("");
		indaccDto.setCbBillCycle(null);
		indaccDto.setCbLastFinhstSeq(null);
		indaccDto.setCbPenaltyInd("N");
		indaccDto.setCbOdGroupid(null);
		indaccDto.setCbExternalBranch(null);
		cpIndaccMapper.insertCpIndacc(indaccDto);

		// 财务账户表(Cp_fintbl)省略
		return StatusResult.create("OK","开"+ cardNo + "成功");
	}


	public static String CardDigit(String strCardNo) {

		int intCardNoLen = strCardNo.length();
		boolean bolStatus = true;
		int i;
		int intTotal = 0;
		int intDigits = 0;
		String strTotal;

		for (i = intCardNoLen; i > 0; i--) {
			if (bolStatus) {
				intDigits = new Integer(strCardNo.substring(i - 1, i)).intValue() * 2;
				if (intDigits > 9)
					intDigits -= 9;
				intTotal += intDigits;
				bolStatus = false;
			} else {
				intTotal = intTotal + new Integer(strCardNo.substring(i - 1, i)).intValue();
				bolStatus = true;
			}
		}
		strTotal = String.valueOf(intTotal);
		strTotal = strTotal.substring(strTotal.length() - 1, strTotal.length());
		//// System.out.println("sonink ... strTotal=====" + strTotal);
		intDigits = new Integer(strTotal).intValue();
		//// System.out.println("sonink ... intDigits=====" + intDigits);
		intDigits = 10 - intDigits;
		if (intDigits == 10) {
			return (strCardNo + "0");
		} else {
			return (strCardNo + intDigits);
		}
	}
	
}
