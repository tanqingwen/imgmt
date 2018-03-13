package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpSysprm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String spId;
	/**
	 *  
	 */
	private String spProcessingDate;
	/**
	 *  
	 */
	private Long spProcessingDdd;
	/**
	 *  
	 */
	private String spNextProcessingDate;
	/**
	 *  
	 */
	private Long spNextProcessingDdd;
	/**
	 *  
	 */
	private Long spEchoInterval;
	/**
	 *  
	 */
	private Long spApplAprRtnPrd;
	/**
	 *  
	 */
	private Long spApplDelRtnPrd;
	/**
	 *  
	 */
	private Long spApplDecRtnPrd;
	/**
	 *  
	 */
	private Long spApplCanRtnPrd;
	/**
	 *  
	 */
	private Long spCurAuthHistRtnPrd;
	/**
	 *  
	 */
	private Long spOldAuthHistRtnPrd;
	/**
	 *  
	 */
	private Long spMemoRtnPrd;
	/**
	 *  
	 */
	private String spExcpAcPostInd;
	/**
	 *  
	 */
	private java.math.BigDecimal spGstRt;
	/**
	 *  
	 */
	private Long spPmtGracePeriod;
	/**
	 *  
	 */
	private String spAgeingDateInd;
	/**
	 *  
	 */
	private String spIncomeRecognition;
	/**
	 *  
	 */
	private Long spAutopayDays;
	/**
	 *  
	 */
	private Long spPayDueDays;
	/**
	 *  
	 */
	private Long spReviewDays;
	/**
	 *  
	 */
	private Long spLytPtsValidityPrd;
	/**
	 *  
	 */
	private String spCustCrlmtOpt;
	/**
	 *  
	 */
	private String spCustDelOpt;
	/**
	 *  
	 */
	private String spCustCollOpt;
	/**
	 *  
	 */
	private String spCrShieldEnrolment;
	/**
	 *  
	 */
	private String spDateDisplayFormat;
	/**
	 *  
	 */
	private String spLanguageInd;
	/**
	 *  
	 */
	private String spSkipStmtGenInd;
	/**
	 *  
	 */
	private Long spRenewRevMth;
	/**
	 *  
	 */
	private String spPinVerInd;
	/**
	 *  
	 */
	private Long spVerkeyLen;
	/**
	 *  
	 */
	private String spPrmModDate;
	/**
	 *  
	 */
	private String spPrmUserId;
	/**
	 *  
	 */
	private String spPntMergedCustLvl;
	/**
	 *  
	 */
	private String spMcPaymentTrxnInd;
	/**
	 *  
	 */
	private Long spDailyBosCaLmt;
	/**
	 *  
	 */
	private String spIpmPreEditFg;
	/**
	 *  
	 */
	private Long spFinalRefundPrd;
	/**
	 *  
	 */
	private String spIntRule;
	/**
	 *  
	 */
	private Long spOdExpiryRevDay;
	/**
	 *  
	 */
	private Long spOdPenaltyAge;
	/**
	 *  
	 */
	private Long spDailyPosCaLmt;
	/**
	 *  
	 */
	private String spAcctLimitation;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param spId
	 */
	public void setSpId(String spId){
		this.spId = spId;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpId(){
    	return spId;
    }
	/**
	 * 
	 * @param spProcessingDate
	 */
	public void setSpProcessingDate(String spProcessingDate){
		this.spProcessingDate = spProcessingDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpProcessingDate(){
    	return spProcessingDate;
    }
	/**
	 * 
	 * @param spProcessingDdd
	 */
	public void setSpProcessingDdd(Long spProcessingDdd){
		this.spProcessingDdd = spProcessingDdd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpProcessingDdd(){
    	return spProcessingDdd;
    }
	/**
	 * 
	 * @param spNextProcessingDate
	 */
	public void setSpNextProcessingDate(String spNextProcessingDate){
		this.spNextProcessingDate = spNextProcessingDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpNextProcessingDate(){
    	return spNextProcessingDate;
    }
	/**
	 * 
	 * @param spNextProcessingDdd
	 */
	public void setSpNextProcessingDdd(Long spNextProcessingDdd){
		this.spNextProcessingDdd = spNextProcessingDdd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpNextProcessingDdd(){
    	return spNextProcessingDdd;
    }
	/**
	 * 
	 * @param spEchoInterval
	 */
	public void setSpEchoInterval(Long spEchoInterval){
		this.spEchoInterval = spEchoInterval;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpEchoInterval(){
    	return spEchoInterval;
    }
	/**
	 * 
	 * @param spApplAprRtnPrd
	 */
	public void setSpApplAprRtnPrd(Long spApplAprRtnPrd){
		this.spApplAprRtnPrd = spApplAprRtnPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpApplAprRtnPrd(){
    	return spApplAprRtnPrd;
    }
	/**
	 * 
	 * @param spApplDelRtnPrd
	 */
	public void setSpApplDelRtnPrd(Long spApplDelRtnPrd){
		this.spApplDelRtnPrd = spApplDelRtnPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpApplDelRtnPrd(){
    	return spApplDelRtnPrd;
    }
	/**
	 * 
	 * @param spApplDecRtnPrd
	 */
	public void setSpApplDecRtnPrd(Long spApplDecRtnPrd){
		this.spApplDecRtnPrd = spApplDecRtnPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpApplDecRtnPrd(){
    	return spApplDecRtnPrd;
    }
	/**
	 * 
	 * @param spApplCanRtnPrd
	 */
	public void setSpApplCanRtnPrd(Long spApplCanRtnPrd){
		this.spApplCanRtnPrd = spApplCanRtnPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpApplCanRtnPrd(){
    	return spApplCanRtnPrd;
    }
	/**
	 * 
	 * @param spCurAuthHistRtnPrd
	 */
	public void setSpCurAuthHistRtnPrd(Long spCurAuthHistRtnPrd){
		this.spCurAuthHistRtnPrd = spCurAuthHistRtnPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpCurAuthHistRtnPrd(){
    	return spCurAuthHistRtnPrd;
    }
	/**
	 * 
	 * @param spOldAuthHistRtnPrd
	 */
	public void setSpOldAuthHistRtnPrd(Long spOldAuthHistRtnPrd){
		this.spOldAuthHistRtnPrd = spOldAuthHistRtnPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpOldAuthHistRtnPrd(){
    	return spOldAuthHistRtnPrd;
    }
	/**
	 * 
	 * @param spMemoRtnPrd
	 */
	public void setSpMemoRtnPrd(Long spMemoRtnPrd){
		this.spMemoRtnPrd = spMemoRtnPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpMemoRtnPrd(){
    	return spMemoRtnPrd;
    }
	/**
	 * 
	 * @param spExcpAcPostInd
	 */
	public void setSpExcpAcPostInd(String spExcpAcPostInd){
		this.spExcpAcPostInd = spExcpAcPostInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpExcpAcPostInd(){
    	return spExcpAcPostInd;
    }
	/**
	 * 
	 * @param spGstRt
	 */
	public void setSpGstRt(java.math.BigDecimal spGstRt){
		this.spGstRt = spGstRt;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getSpGstRt(){
    	return spGstRt;
    }
	/**
	 * 
	 * @param spPmtGracePeriod
	 */
	public void setSpPmtGracePeriod(Long spPmtGracePeriod){
		this.spPmtGracePeriod = spPmtGracePeriod;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpPmtGracePeriod(){
    	return spPmtGracePeriod;
    }
	/**
	 * 
	 * @param spAgeingDateInd
	 */
	public void setSpAgeingDateInd(String spAgeingDateInd){
		this.spAgeingDateInd = spAgeingDateInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpAgeingDateInd(){
    	return spAgeingDateInd;
    }
	/**
	 * 
	 * @param spIncomeRecognition
	 */
	public void setSpIncomeRecognition(String spIncomeRecognition){
		this.spIncomeRecognition = spIncomeRecognition;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpIncomeRecognition(){
    	return spIncomeRecognition;
    }
	/**
	 * 
	 * @param spAutopayDays
	 */
	public void setSpAutopayDays(Long spAutopayDays){
		this.spAutopayDays = spAutopayDays;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpAutopayDays(){
    	return spAutopayDays;
    }
	/**
	 * 
	 * @param spPayDueDays
	 */
	public void setSpPayDueDays(Long spPayDueDays){
		this.spPayDueDays = spPayDueDays;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpPayDueDays(){
    	return spPayDueDays;
    }
	/**
	 * 
	 * @param spReviewDays
	 */
	public void setSpReviewDays(Long spReviewDays){
		this.spReviewDays = spReviewDays;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpReviewDays(){
    	return spReviewDays;
    }
	/**
	 * 
	 * @param spLytPtsValidityPrd
	 */
	public void setSpLytPtsValidityPrd(Long spLytPtsValidityPrd){
		this.spLytPtsValidityPrd = spLytPtsValidityPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpLytPtsValidityPrd(){
    	return spLytPtsValidityPrd;
    }
	/**
	 * 
	 * @param spCustCrlmtOpt
	 */
	public void setSpCustCrlmtOpt(String spCustCrlmtOpt){
		this.spCustCrlmtOpt = spCustCrlmtOpt;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpCustCrlmtOpt(){
    	return spCustCrlmtOpt;
    }
	/**
	 * 
	 * @param spCustDelOpt
	 */
	public void setSpCustDelOpt(String spCustDelOpt){
		this.spCustDelOpt = spCustDelOpt;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpCustDelOpt(){
    	return spCustDelOpt;
    }
	/**
	 * 
	 * @param spCustCollOpt
	 */
	public void setSpCustCollOpt(String spCustCollOpt){
		this.spCustCollOpt = spCustCollOpt;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpCustCollOpt(){
    	return spCustCollOpt;
    }
	/**
	 * 
	 * @param spCrShieldEnrolment
	 */
	public void setSpCrShieldEnrolment(String spCrShieldEnrolment){
		this.spCrShieldEnrolment = spCrShieldEnrolment;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpCrShieldEnrolment(){
    	return spCrShieldEnrolment;
    }
	/**
	 * 
	 * @param spDateDisplayFormat
	 */
	public void setSpDateDisplayFormat(String spDateDisplayFormat){
		this.spDateDisplayFormat = spDateDisplayFormat;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpDateDisplayFormat(){
    	return spDateDisplayFormat;
    }
	/**
	 * 
	 * @param spLanguageInd
	 */
	public void setSpLanguageInd(String spLanguageInd){
		this.spLanguageInd = spLanguageInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpLanguageInd(){
    	return spLanguageInd;
    }
	/**
	 * 
	 * @param spSkipStmtGenInd
	 */
	public void setSpSkipStmtGenInd(String spSkipStmtGenInd){
		this.spSkipStmtGenInd = spSkipStmtGenInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpSkipStmtGenInd(){
    	return spSkipStmtGenInd;
    }
	/**
	 * 
	 * @param spRenewRevMth
	 */
	public void setSpRenewRevMth(Long spRenewRevMth){
		this.spRenewRevMth = spRenewRevMth;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpRenewRevMth(){
    	return spRenewRevMth;
    }
	/**
	 * 
	 * @param spPinVerInd
	 */
	public void setSpPinVerInd(String spPinVerInd){
		this.spPinVerInd = spPinVerInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpPinVerInd(){
    	return spPinVerInd;
    }
	/**
	 * 
	 * @param spVerkeyLen
	 */
	public void setSpVerkeyLen(Long spVerkeyLen){
		this.spVerkeyLen = spVerkeyLen;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpVerkeyLen(){
    	return spVerkeyLen;
    }
	/**
	 * 
	 * @param spPrmModDate
	 */
	public void setSpPrmModDate(String spPrmModDate){
		this.spPrmModDate = spPrmModDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpPrmModDate(){
    	return spPrmModDate;
    }
	/**
	 * 
	 * @param spPrmUserId
	 */
	public void setSpPrmUserId(String spPrmUserId){
		this.spPrmUserId = spPrmUserId;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpPrmUserId(){
    	return spPrmUserId;
    }
	/**
	 * 
	 * @param spPntMergedCustLvl
	 */
	public void setSpPntMergedCustLvl(String spPntMergedCustLvl){
		this.spPntMergedCustLvl = spPntMergedCustLvl;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpPntMergedCustLvl(){
    	return spPntMergedCustLvl;
    }
	/**
	 * 
	 * @param spMcPaymentTrxnInd
	 */
	public void setSpMcPaymentTrxnInd(String spMcPaymentTrxnInd){
		this.spMcPaymentTrxnInd = spMcPaymentTrxnInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpMcPaymentTrxnInd(){
    	return spMcPaymentTrxnInd;
    }
	/**
	 * 
	 * @param spDailyBosCaLmt
	 */
	public void setSpDailyBosCaLmt(Long spDailyBosCaLmt){
		this.spDailyBosCaLmt = spDailyBosCaLmt;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpDailyBosCaLmt(){
    	return spDailyBosCaLmt;
    }
	/**
	 * 
	 * @param spIpmPreEditFg
	 */
	public void setSpIpmPreEditFg(String spIpmPreEditFg){
		this.spIpmPreEditFg = spIpmPreEditFg;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpIpmPreEditFg(){
    	return spIpmPreEditFg;
    }
	/**
	 * 
	 * @param spFinalRefundPrd
	 */
	public void setSpFinalRefundPrd(Long spFinalRefundPrd){
		this.spFinalRefundPrd = spFinalRefundPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpFinalRefundPrd(){
    	return spFinalRefundPrd;
    }
	/**
	 * 
	 * @param spIntRule
	 */
	public void setSpIntRule(String spIntRule){
		this.spIntRule = spIntRule;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpIntRule(){
    	return spIntRule;
    }
	/**
	 * 
	 * @param spOdExpiryRevDay
	 */
	public void setSpOdExpiryRevDay(Long spOdExpiryRevDay){
		this.spOdExpiryRevDay = spOdExpiryRevDay;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpOdExpiryRevDay(){
    	return spOdExpiryRevDay;
    }
	/**
	 * 
	 * @param spOdPenaltyAge
	 */
	public void setSpOdPenaltyAge(Long spOdPenaltyAge){
		this.spOdPenaltyAge = spOdPenaltyAge;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpOdPenaltyAge(){
    	return spOdPenaltyAge;
    }
	/**
	 * 
	 * @param spDailyPosCaLmt
	 */
	public void setSpDailyPosCaLmt(Long spDailyPosCaLmt){
		this.spDailyPosCaLmt = spDailyPosCaLmt;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSpDailyPosCaLmt(){
    	return spDailyPosCaLmt;
    }
	/**
	 * 
	 * @param spAcctLimitation
	 */
	public void setSpAcctLimitation(String spAcctLimitation){
		this.spAcctLimitation = spAcctLimitation;
	}
	
    /**
     * 
     * @return
     */	
    public String getSpAcctLimitation(){
    	return spAcctLimitation;
    }
	/**
	 * 
	 * @param checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}
	
    /**
     * 
     * @return
     */	
    public String getChecksum(){
    	return checksum;
    }
}