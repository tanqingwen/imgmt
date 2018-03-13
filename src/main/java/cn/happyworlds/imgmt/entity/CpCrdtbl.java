package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class CpCrdtbl implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  卡号
	 */
	private String cbCardholderNo;
	/**
	 *  
	 */
	private String cbBasicSuppInd;
	/**
	 *  证件类型
	 */
	private String cbIdType;
	/**
	 *  证件号码
	 */
	private String cbIdno;
	/**
	 *  证件类型
	 */
	private String cbBscIdType;
	/**
	 *  证件号码
	 */
	private String cbBasicCustomerIdno;
	/**
	 *  卡号
	 */
	private String cbBasicCardholderNo;
	/**
	 *  账户号码
	 */
	private String cbIndividualAcctno;
	/**
	 *  账单分离标志
	 */
	private String cbSeparateStmtInd;
	/**
	 *  证件姓名
	 */
	private String cbEmbossname;
	/**
	 *  账单周期
	 */
	private Integer cbBillCycle;
	/**
	 *  自动支付标志
	 */
	private Integer cbAutopayInd;
	/**
	 *  自动还款机构
	 */
	private String cbAutopayBankBranch;
	/**
	 *  自动还款银行账号
	 */
	private String cbAutopayBankAccno;
	/**
	 *  自动还款账户名称
	 */
	private String cbAutopayAccname;
	/**
	 *  他行自动还款标志
	 */
	private Integer cbFrgnAutopayInd;
	/**
	 *  他行自动还款机构
	 */
	private String cbAutopayFrgnBankBranch;
	/**
	 *  他行自动还款账户
	 */
	private String cbAutopayFrgnBankAccno;
	/**
	 *  他行自动还款户名
	 */
	private String cbAutopayFrgnAccname;
	/**
	 *  密码建立标示
	 */
	private String cbPinGenInd;
	/**
	 *  与银行关系
	 */
	private String cbCurrBankRel;
	/**
	 *  发卡机构
	 */
	private String cbCentreCd;
	/**
	 *  手机号
	 */
	private String cbSourceCd;
	/**
	 *  卡面号
	 */
	private String cbRecommenderNo;
	/**
	 *  
	 */
	private String cbRecommenderName;
	/**
	 *  
	 */
	private String cbMicrofilmNo;
	/**
	 *  激活日期
	 */
	private String cbAnnivDate;
	/**
	 *  卡产品组
	 */
	private Integer cbCardPrdctGroup;
	/**
	 *  费用代码
	 */
	private Integer cbFeeCd;
	/**
	 *  
	 */
	private String cbCreditGuarantee;
	/**
	 *  续卡标志
	 */
	private String cbRenewalFlag;
	/**
	 *  出生日期
	 */
	private String cbSuspendDate;
	/**
	 *  
	 */
	private String cbBankruptcyDate;
	/**
	 *  销卡日期
	 */
	private String cbCancelDate;
	/**
	 *  法律日期
	 */
	private String cbLegalDate;
	/**
	 *  欺诈日期
	 */
	private String cbFraudDate;
	/**
	 *  .状态改变日期
	 */
	private String cbReserveDate;
	/**
	 *  
	 */
	private String cbReinstateDate;
	/**
	 *  到期日
	 */
	private String cbExpiryCcyymm;
	/**
	 *  卡状态
	 */
	private String cbPlasticCd;
	/**
	 *  制卡日期
	 */
	private String cbPlasticDate;
	/**
	 *  
	 */
	private String cb4dbc;
	/**
	 *  新到期日
	 */
	private String cbNewExpiryCcyymm;
	/**
	 *  新卡片状态
	 */
	private String cbNewPlasticCd;
	/**
	 *  新制卡日期
	 */
	private String cbNewPlasticDate;
	/**
	 *  
	 */
	private String cbNew4dbc;
	/**
	 *  
	 */
	private String cbXrefInd;
	/**
	 *  
	 */
	private String cbXrefAccno;
	/**
	 *  
	 */
	private Long cbUserFieldNum1;
	/**
	 *  
	 */
	private Integer cbUserFieldNum2;
	/**
	 *  
	 */
	private Long cbUserFieldNum3;
	/**
	 *  
	 */
	private Integer cbUserFieldNum4;
	/**
	 *  
	 */
	private String cbUserCode1;
	/**
	 *  
	 */
	private String cbUserCode2;
	/**
	 *  
	 */
	private String cbUserCode3;
	/**
	 *  
	 */
	private String cbUserCode4;
	/**
	 *  
	 */
	private String cbUserDate1;
	/**
	 *  
	 */
	private String cbUserDate2;
	/**
	 *  
	 */
	private java.math.BigDecimal cbUserAmt1;
	/**
	 *  
	 */
	private java.math.BigDecimal cbUserAmt2;
	/**
	 *  
	 */
	private String cbUserField1;
	/**
	 *  
	 */
	private String cbUserField2;
	/**
	 *  
	 */
	private String cbUserField3;
	/**
	 *  修改日期
	 */
	private String cbModDate;
	/**
	 *  修改用户
	 */
	private String cbModUser;
	/**
	 *  密码偏移量
	 */
	private String cbPinOffset;
	/**
	 *  密钥索引
	 */
	private Integer cbPvki;
	/**
	 *  
	 */
	private String cbCicCancel;
	/**
	 *  
	 */
	private String cbCrshldInd;
	/**
	 *  
	 */
	private String cbCrshldEnrolDate;
	/**
	 *  
	 */
	private String cbCrshldTerminateDate;
	/**
	 *  公司ID
	 */
	private String cbCorporateId;
	/**
	 *  行业代码
	 */
	private String cbSic;
	/**
	 *  关系
	 */
	private String cbRelationship;
	/**
	 *  
	 */
	private Integer cbFraudFlag1;
	/**
	 *  
	 */
	private String cbFraudFlag2;
	/**
	 *  首次使用日期
	 */
	private String cbFirstUseDate;
	/**
	 *  首次使用时间
	 */
	private String cbFirstUseTime;
	/**
	 *  首次使用标志
	 */
	private String cbFirstUseInd;
	/**
	 *  
	 */
	private String cbOldIdType;
	/**
	 *  
	 */
	private String cbOldCustomerIdno;
	/**
	 *  
	 */
	private String cbCifFlag;
	/**
	 *  
	 */
	private String cbDcmsFlag;
	/**
	 *  
	 */
	private String cbCafRefreshFlag;
	/**
	 *  
	 */
	private String cbCafUpdateFlag;
	/**
	 *  
	 */
	private String cbCafPinFlag;
	/**
	 *  
	 */
	private String cbCafTagFlag;
	/**
	 *  卡收集标志
	 */
	private String cbCardCollMethod;
	/**
	 *  
	 */
	private String cbCardDeliveryAddr;
	/**
	 *  
	 */
	private String cbBillAddrCd;
	/**
	 *  物理卡号
	 */
	private String cbRwdsAccno;
	/**
	 *  法律信函投递地址
	 */
	private String cbLegalAddrCd;
	/**
	 *  上次续卡费用年
	 */
	private String cbLastRenewFeeYear;
	/**
	 *  状态
	 */
	private String cbStatusCd;
	/**
	 *  监控代码
	 */
	private String cbMonitorCd;
	/**
	 *  
	 */
	private String cbCollectCd;
	/**
	 *  员工号
	 */
	private String cbEmployeeId;
	/**
	 *  账号规则
	 */
	private Integer cbIndaccRule;
	/**
	 *  外部账号1
	 */
	private String cbIndaccNo1;
	/**
	 *  账号规则1
	 */
	private Integer cbIndaccRule1;
	/**
	 *  外部账号2
	 */
	private String cbIndaccNo2;
	/**
	 *  账号规则2
	 */
	private Integer cbIndaccRule2;
	/**
	 *  外部账号3
	 */
	private String cbIndaccNo3;
	/**
	 *  账号规则3
	 */
	private Integer cbIndaccRule3;
	/**
	 *  外部账号4
	 */
	private String cbIndaccNo4;
	/**
	 *  账号规则4
	 */
	private Integer cbIndaccRule4;
	/**
	 *  外部账号5
	 */
	private String cbIndaccNo5;
	/**
	 *  账号规则5
	 */
	private Integer cbIndaccRule5;
	/**
	 *  外部账号6
	 */
	private String cbIndaccNo6;
	/**
	 *  账号规则6
	 */
	private Integer cbIndaccRule6;
	/**
	 *  外部账号7
	 */
	private String cbIndaccNo7;
	/**
	 *  账号规则7
	 */
	private Integer cbIndaccRule7;
	/**
	 *  外部账号8
	 */
	private String cbIndaccNo8;
	/**
	 *  账号规则8
	 */
	private Integer cbIndaccRule8;
	/**
	 *  外部账号9
	 */
	private String cbIndaccNo9;
	/**
	 *  账号规则9
	 */
	private Integer cbIndaccRule9;
	/**
	 *  
	 */
	private Integer cbPvv;
	/**
	 *  
	 */
	private Integer cbPvvOffset;
	/**
	 *  
	 */
	private Integer cbCvki;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 卡号
	 * @param cbCardholderNo
	 */
	public void setCbCardholderNo(String cbCardholderNo){
		this.cbCardholderNo = cbCardholderNo;
	}
	
    /**
     * 卡号
     * @return
     */	
    public String getCbCardholderNo(){
    	return cbCardholderNo;
    }
	/**
	 * 
	 * @param cbBasicSuppInd
	 */
	public void setCbBasicSuppInd(String cbBasicSuppInd){
		this.cbBasicSuppInd = cbBasicSuppInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbBasicSuppInd(){
    	return cbBasicSuppInd;
    }
	/**
	 * 证件类型
	 * @param cbIdType
	 */
	public void setCbIdType(String cbIdType){
		this.cbIdType = cbIdType;
	}
	
    /**
     * 证件类型
     * @return
     */	
    public String getCbIdType(){
    	return cbIdType;
    }
	/**
	 * 证件号码
	 * @param cbIdno
	 */
	public void setCbIdno(String cbIdno){
		this.cbIdno = cbIdno;
	}
	
    /**
     * 证件号码
     * @return
     */	
    public String getCbIdno(){
    	return cbIdno;
    }
	/**
	 * 证件类型
	 * @param cbBscIdType
	 */
	public void setCbBscIdType(String cbBscIdType){
		this.cbBscIdType = cbBscIdType;
	}
	
    /**
     * 证件类型
     * @return
     */	
    public String getCbBscIdType(){
    	return cbBscIdType;
    }
	/**
	 * 证件号码
	 * @param cbBasicCustomerIdno
	 */
	public void setCbBasicCustomerIdno(String cbBasicCustomerIdno){
		this.cbBasicCustomerIdno = cbBasicCustomerIdno;
	}
	
    /**
     * 证件号码
     * @return
     */	
    public String getCbBasicCustomerIdno(){
    	return cbBasicCustomerIdno;
    }
	/**
	 * 卡号
	 * @param cbBasicCardholderNo
	 */
	public void setCbBasicCardholderNo(String cbBasicCardholderNo){
		this.cbBasicCardholderNo = cbBasicCardholderNo;
	}
	
    /**
     * 卡号
     * @return
     */	
    public String getCbBasicCardholderNo(){
    	return cbBasicCardholderNo;
    }
	/**
	 * 账户号码
	 * @param cbIndividualAcctno
	 */
	public void setCbIndividualAcctno(String cbIndividualAcctno){
		this.cbIndividualAcctno = cbIndividualAcctno;
	}
	
    /**
     * 账户号码
     * @return
     */	
    public String getCbIndividualAcctno(){
    	return cbIndividualAcctno;
    }
	/**
	 * 账单分离标志
	 * @param cbSeparateStmtInd
	 */
	public void setCbSeparateStmtInd(String cbSeparateStmtInd){
		this.cbSeparateStmtInd = cbSeparateStmtInd;
	}
	
    /**
     * 账单分离标志
     * @return
     */	
    public String getCbSeparateStmtInd(){
    	return cbSeparateStmtInd;
    }
	/**
	 * 证件姓名
	 * @param cbEmbossname
	 */
	public void setCbEmbossname(String cbEmbossname){
		this.cbEmbossname = cbEmbossname;
	}
	
    /**
     * 证件姓名
     * @return
     */	
    public String getCbEmbossname(){
    	return cbEmbossname;
    }
	/**
	 * 账单周期
	 * @param cbBillCycle
	 */
	public void setCbBillCycle(Integer cbBillCycle){
		this.cbBillCycle = cbBillCycle;
	}
	
    /**
     * 账单周期
     * @return
     */	
    public Integer getCbBillCycle(){
    	return cbBillCycle;
    }
	/**
	 * 自动支付标志
	 * @param cbAutopayInd
	 */
	public void setCbAutopayInd(Integer cbAutopayInd){
		this.cbAutopayInd = cbAutopayInd;
	}
	
    /**
     * 自动支付标志
     * @return
     */	
    public Integer getCbAutopayInd(){
    	return cbAutopayInd;
    }
	/**
	 * 自动还款机构
	 * @param cbAutopayBankBranch
	 */
	public void setCbAutopayBankBranch(String cbAutopayBankBranch){
		this.cbAutopayBankBranch = cbAutopayBankBranch;
	}
	
    /**
     * 自动还款机构
     * @return
     */	
    public String getCbAutopayBankBranch(){
    	return cbAutopayBankBranch;
    }
	/**
	 * 自动还款银行账号
	 * @param cbAutopayBankAccno
	 */
	public void setCbAutopayBankAccno(String cbAutopayBankAccno){
		this.cbAutopayBankAccno = cbAutopayBankAccno;
	}
	
    /**
     * 自动还款银行账号
     * @return
     */	
    public String getCbAutopayBankAccno(){
    	return cbAutopayBankAccno;
    }
	/**
	 * 自动还款账户名称
	 * @param cbAutopayAccname
	 */
	public void setCbAutopayAccname(String cbAutopayAccname){
		this.cbAutopayAccname = cbAutopayAccname;
	}
	
    /**
     * 自动还款账户名称
     * @return
     */	
    public String getCbAutopayAccname(){
    	return cbAutopayAccname;
    }
	/**
	 * 他行自动还款标志
	 * @param cbFrgnAutopayInd
	 */
	public void setCbFrgnAutopayInd(Integer cbFrgnAutopayInd){
		this.cbFrgnAutopayInd = cbFrgnAutopayInd;
	}
	
    /**
     * 他行自动还款标志
     * @return
     */	
    public Integer getCbFrgnAutopayInd(){
    	return cbFrgnAutopayInd;
    }
	/**
	 * 他行自动还款机构
	 * @param cbAutopayFrgnBankBranch
	 */
	public void setCbAutopayFrgnBankBranch(String cbAutopayFrgnBankBranch){
		this.cbAutopayFrgnBankBranch = cbAutopayFrgnBankBranch;
	}
	
    /**
     * 他行自动还款机构
     * @return
     */	
    public String getCbAutopayFrgnBankBranch(){
    	return cbAutopayFrgnBankBranch;
    }
	/**
	 * 他行自动还款账户
	 * @param cbAutopayFrgnBankAccno
	 */
	public void setCbAutopayFrgnBankAccno(String cbAutopayFrgnBankAccno){
		this.cbAutopayFrgnBankAccno = cbAutopayFrgnBankAccno;
	}
	
    /**
     * 他行自动还款账户
     * @return
     */	
    public String getCbAutopayFrgnBankAccno(){
    	return cbAutopayFrgnBankAccno;
    }
	/**
	 * 他行自动还款户名
	 * @param cbAutopayFrgnAccname
	 */
	public void setCbAutopayFrgnAccname(String cbAutopayFrgnAccname){
		this.cbAutopayFrgnAccname = cbAutopayFrgnAccname;
	}
	
    /**
     * 他行自动还款户名
     * @return
     */	
    public String getCbAutopayFrgnAccname(){
    	return cbAutopayFrgnAccname;
    }
	/**
	 * 密码建立标示
	 * @param cbPinGenInd
	 */
	public void setCbPinGenInd(String cbPinGenInd){
		this.cbPinGenInd = cbPinGenInd;
	}
	
    /**
     * 密码建立标示
     * @return
     */	
    public String getCbPinGenInd(){
    	return cbPinGenInd;
    }
	/**
	 * 与银行关系
	 * @param cbCurrBankRel
	 */
	public void setCbCurrBankRel(String cbCurrBankRel){
		this.cbCurrBankRel = cbCurrBankRel;
	}
	
    /**
     * 与银行关系
     * @return
     */	
    public String getCbCurrBankRel(){
    	return cbCurrBankRel;
    }
	/**
	 * 发卡机构
	 * @param cbCentreCd
	 */
	public void setCbCentreCd(String cbCentreCd){
		this.cbCentreCd = cbCentreCd;
	}
	
    /**
     * 发卡机构
     * @return
     */	
    public String getCbCentreCd(){
    	return cbCentreCd;
    }
	/**
	 * 手机号
	 * @param cbSourceCd
	 */
	public void setCbSourceCd(String cbSourceCd){
		this.cbSourceCd = cbSourceCd;
	}
	
    /**
     * 手机号
     * @return
     */	
    public String getCbSourceCd(){
    	return cbSourceCd;
    }
	/**
	 * 
	 * @param 卡面号
	 */
	public void setCbRecommenderNo(String cbRecommenderNo){
		this.cbRecommenderNo = cbRecommenderNo;
	}
	
    /**
     * 
     * @return 卡面号
     */	
    public String getCbRecommenderNo(){
    	return cbRecommenderNo;
    }
	/**
	 * 
	 * @param cbRecommenderName
	 */
	public void setCbRecommenderName(String cbRecommenderName){
		this.cbRecommenderName = cbRecommenderName;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbRecommenderName(){
    	return cbRecommenderName;
    }
	/**
	 * 
	 * @param cbMicrofilmNo
	 */
	public void setCbMicrofilmNo(String cbMicrofilmNo){
		this.cbMicrofilmNo = cbMicrofilmNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbMicrofilmNo(){
    	return cbMicrofilmNo;
    }
	/**
	 * 激活日期
	 * @param cbAnnivDate
	 */
	public void setCbAnnivDate(String cbAnnivDate){
		this.cbAnnivDate = cbAnnivDate;
	}
	
    /**
     * 激活日期
     * @return
     */	
    public String getCbAnnivDate(){
    	return cbAnnivDate;
    }
	/**
	 * 卡产品组
	 * @param cbCardPrdctGroup
	 */
	public void setCbCardPrdctGroup(Integer cbCardPrdctGroup){
		this.cbCardPrdctGroup = cbCardPrdctGroup;
	}
	
    /**
     * 卡产品组
     * @return
     */	
    public Integer getCbCardPrdctGroup(){
    	return cbCardPrdctGroup;
    }
	/**
	 * 费用代码
	 * @param cbFeeCd
	 */
	public void setCbFeeCd(Integer cbFeeCd){
		this.cbFeeCd = cbFeeCd;
	}
	
    /**
     * 费用代码
     * @return
     */	
    public Integer getCbFeeCd(){
    	return cbFeeCd;
    }
	/**
	 * 
	 * @param cbCreditGuarantee
	 */
	public void setCbCreditGuarantee(String cbCreditGuarantee){
		this.cbCreditGuarantee = cbCreditGuarantee;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCreditGuarantee(){
    	return cbCreditGuarantee;
    }
	/**
	 * 续卡标志
	 * @param cbRenewalFlag
	 */
	public void setCbRenewalFlag(String cbRenewalFlag){
		this.cbRenewalFlag = cbRenewalFlag;
	}
	
    /**
     * 续卡标志
     * @return
     */	
    public String getCbRenewalFlag(){
    	return cbRenewalFlag;
    }
	/**
	 * 
	 * @param 出生日期
	 */
	public void setCbSuspendDate(String cbSuspendDate){
		this.cbSuspendDate = cbSuspendDate;
	}
	
    /**
     * 
     * @return 出生日期
     */	
    public String getCbSuspendDate(){
    	return cbSuspendDate;
    }
	/**
	 * 
	 * @param cbBankruptcyDate
	 */
	public void setCbBankruptcyDate(String cbBankruptcyDate){
		this.cbBankruptcyDate = cbBankruptcyDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbBankruptcyDate(){
    	return cbBankruptcyDate;
    }
	/**
	 * 销卡日期
	 * @param cbCancelDate
	 */
	public void setCbCancelDate(String cbCancelDate){
		this.cbCancelDate = cbCancelDate;
	}
	
    /**
     * 销卡日期
     * @return
     */	
    public String getCbCancelDate(){
    	return cbCancelDate;
    }
	/**
	 * 法律日期
	 * @param cbLegalDate
	 */
	public void setCbLegalDate(String cbLegalDate){
		this.cbLegalDate = cbLegalDate;
	}
	
    /**
     * 法律日期
     * @return
     */	
    public String getCbLegalDate(){
    	return cbLegalDate;
    }
	/**
	 * 欺诈日期
	 * @param cbFraudDate
	 */
	public void setCbFraudDate(String cbFraudDate){
		this.cbFraudDate = cbFraudDate;
	}
	
    /**
     * 欺诈日期
     * @return
     */	
    public String getCbFraudDate(){
    	return cbFraudDate;
    }
	/**
	 * .状态改变日期
	 * @param cbReserveDate
	 */
	public void setCbReserveDate(String cbReserveDate){
		this.cbReserveDate = cbReserveDate;
	}
	
    /**
     * .状态改变日期
     * @return
     */	
    public String getCbReserveDate(){
    	return cbReserveDate;
    }
	/**
	 * 
	 * @param cbReinstateDate
	 */
	public void setCbReinstateDate(String cbReinstateDate){
		this.cbReinstateDate = cbReinstateDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbReinstateDate(){
    	return cbReinstateDate;
    }
	/**
	 * 到期日
	 * @param cbExpiryCcyymm
	 */
	public void setCbExpiryCcyymm(String cbExpiryCcyymm){
		this.cbExpiryCcyymm = cbExpiryCcyymm;
	}
	
    /**
     * 到期日
     * @return
     */	
    public String getCbExpiryCcyymm(){
    	return cbExpiryCcyymm;
    }
	/**
	 * 卡状态
	 * @param cbPlasticCd
	 */
	public void setCbPlasticCd(String cbPlasticCd){
		this.cbPlasticCd = cbPlasticCd;
	}
	
    /**
     * 卡状态
     * @return
     */	
    public String getCbPlasticCd(){
    	return cbPlasticCd;
    }
	/**
	 * 制卡日期
	 * @param cbPlasticDate
	 */
	public void setCbPlasticDate(String cbPlasticDate){
		this.cbPlasticDate = cbPlasticDate;
	}
	
    /**
     * 制卡日期
     * @return
     */	
    public String getCbPlasticDate(){
    	return cbPlasticDate;
    }
	/**
	 * 
	 * @param cb4dbc
	 */
	public void setCb4dbc(String cb4dbc){
		this.cb4dbc = cb4dbc;
	}
	
    /**
     * 
     * @return
     */	
    public String getCb4dbc(){
    	return cb4dbc;
    }
	/**
	 * 新到期日
	 * @param cbNewExpiryCcyymm
	 */
	public void setCbNewExpiryCcyymm(String cbNewExpiryCcyymm){
		this.cbNewExpiryCcyymm = cbNewExpiryCcyymm;
	}
	
    /**
     * 新到期日
     * @return
     */	
    public String getCbNewExpiryCcyymm(){
    	return cbNewExpiryCcyymm;
    }
	/**
	 * 新卡片状态
	 * @param cbNewPlasticCd
	 */
	public void setCbNewPlasticCd(String cbNewPlasticCd){
		this.cbNewPlasticCd = cbNewPlasticCd;
	}
	
    /**
     * 新卡片状态
     * @return
     */	
    public String getCbNewPlasticCd(){
    	return cbNewPlasticCd;
    }
	/**
	 * 新制卡日期
	 * @param cbNewPlasticDate
	 */
	public void setCbNewPlasticDate(String cbNewPlasticDate){
		this.cbNewPlasticDate = cbNewPlasticDate;
	}
	
    /**
     * 新制卡日期
     * @return
     */	
    public String getCbNewPlasticDate(){
    	return cbNewPlasticDate;
    }
	/**
	 * 
	 * @param cbNew4dbc
	 */
	public void setCbNew4dbc(String cbNew4dbc){
		this.cbNew4dbc = cbNew4dbc;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbNew4dbc(){
    	return cbNew4dbc;
    }
	/**
	 * 
	 * @param cbXrefInd
	 */
	public void setCbXrefInd(String cbXrefInd){
		this.cbXrefInd = cbXrefInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbXrefInd(){
    	return cbXrefInd;
    }
	/**
	 * 
	 * @param cbXrefAccno
	 */
	public void setCbXrefAccno(String cbXrefAccno){
		this.cbXrefAccno = cbXrefAccno;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbXrefAccno(){
    	return cbXrefAccno;
    }
	/**
	 * 
	 * @param cbUserFieldNum1
	 */
	public void setCbUserFieldNum1(Long cbUserFieldNum1){
		this.cbUserFieldNum1 = cbUserFieldNum1;
	}
	
    /**
     * 
     * @return
     */	
    public Long getCbUserFieldNum1(){
    	return cbUserFieldNum1;
    }
	/**
	 * 
	 * @param cbUserFieldNum2
	 */
	public void setCbUserFieldNum2(Integer cbUserFieldNum2){
		this.cbUserFieldNum2 = cbUserFieldNum2;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getCbUserFieldNum2(){
    	return cbUserFieldNum2;
    }
	/**
	 * 
	 * @param cbUserFieldNum3
	 */
	public void setCbUserFieldNum3(Long cbUserFieldNum3){
		this.cbUserFieldNum3 = cbUserFieldNum3;
	}
	
    /**
     * 
     * @return
     */	
    public Long getCbUserFieldNum3(){
    	return cbUserFieldNum3;
    }
	/**
	 * 
	 * @param cbUserFieldNum4
	 */
	public void setCbUserFieldNum4(Integer cbUserFieldNum4){
		this.cbUserFieldNum4 = cbUserFieldNum4;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getCbUserFieldNum4(){
    	return cbUserFieldNum4;
    }
	/**
	 * 
	 * @param cbUserCode1
	 */
	public void setCbUserCode1(String cbUserCode1){
		this.cbUserCode1 = cbUserCode1;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserCode1(){
    	return cbUserCode1;
    }
	/**
	 * 
	 * @param cbUserCode2
	 */
	public void setCbUserCode2(String cbUserCode2){
		this.cbUserCode2 = cbUserCode2;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserCode2(){
    	return cbUserCode2;
    }
	/**
	 * 
	 * @param cbUserCode3
	 */
	public void setCbUserCode3(String cbUserCode3){
		this.cbUserCode3 = cbUserCode3;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserCode3(){
    	return cbUserCode3;
    }
	/**
	 * 
	 * @param cbUserCode4
	 */
	public void setCbUserCode4(String cbUserCode4){
		this.cbUserCode4 = cbUserCode4;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserCode4(){
    	return cbUserCode4;
    }
	/**
	 * 
	 * @param cbUserDate1
	 */
	public void setCbUserDate1(String cbUserDate1){
		this.cbUserDate1 = cbUserDate1;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserDate1(){
    	return cbUserDate1;
    }
	/**
	 * 
	 * @param cbUserDate2
	 */
	public void setCbUserDate2(String cbUserDate2){
		this.cbUserDate2 = cbUserDate2;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserDate2(){
    	return cbUserDate2;
    }
	/**
	 * 
	 * @param cbUserAmt1
	 */
	public void setCbUserAmt1(java.math.BigDecimal cbUserAmt1){
		this.cbUserAmt1 = cbUserAmt1;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCbUserAmt1(){
    	return cbUserAmt1;
    }
	/**
	 * 
	 * @param cbUserAmt2
	 */
	public void setCbUserAmt2(java.math.BigDecimal cbUserAmt2){
		this.cbUserAmt2 = cbUserAmt2;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCbUserAmt2(){
    	return cbUserAmt2;
    }
	/**
	 * 
	 * @param cbUserField1
	 */
	public void setCbUserField1(String cbUserField1){
		this.cbUserField1 = cbUserField1;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserField1(){
    	return cbUserField1;
    }
	/**
	 * 
	 * @param cbUserField2
	 */
	public void setCbUserField2(String cbUserField2){
		this.cbUserField2 = cbUserField2;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserField2(){
    	return cbUserField2;
    }
	/**
	 * 
	 * @param cbUserField3
	 */
	public void setCbUserField3(String cbUserField3){
		this.cbUserField3 = cbUserField3;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbUserField3(){
    	return cbUserField3;
    }
	/**
	 * 修改日期
	 * @param cbModDate
	 */
	public void setCbModDate(String cbModDate){
		this.cbModDate = cbModDate;
	}
	
    /**
     * 修改日期
     * @return
     */	
    public String getCbModDate(){
    	return cbModDate;
    }
	/**
	 * 修改用户
	 * @param cbModUser
	 */
	public void setCbModUser(String cbModUser){
		this.cbModUser = cbModUser;
	}
	
    /**
     * 修改用户
     * @return
     */	
    public String getCbModUser(){
    	return cbModUser;
    }
	/**
	 * 密码偏移量
	 * @param cbPinOffset
	 */
	public void setCbPinOffset(String cbPinOffset){
		this.cbPinOffset = cbPinOffset;
	}
	
    /**
     * 密码偏移量
     * @return
     */	
    public String getCbPinOffset(){
    	return cbPinOffset;
    }
	/**
	 * 密钥索引
	 * @param cbPvki
	 */
	public void setCbPvki(Integer cbPvki){
		this.cbPvki = cbPvki;
	}
	
    /**
     * 密钥索引
     * @return
     */	
    public Integer getCbPvki(){
    	return cbPvki;
    }
	/**
	 * 
	 * @param cbCicCancel
	 */
	public void setCbCicCancel(String cbCicCancel){
		this.cbCicCancel = cbCicCancel;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCicCancel(){
    	return cbCicCancel;
    }
	/**
	 * 
	 * @param cbCrshldInd
	 */
	public void setCbCrshldInd(String cbCrshldInd){
		this.cbCrshldInd = cbCrshldInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCrshldInd(){
    	return cbCrshldInd;
    }
	/**
	 * 
	 * @param cbCrshldEnrolDate
	 */
	public void setCbCrshldEnrolDate(String cbCrshldEnrolDate){
		this.cbCrshldEnrolDate = cbCrshldEnrolDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCrshldEnrolDate(){
    	return cbCrshldEnrolDate;
    }
	/**
	 * 
	 * @param cbCrshldTerminateDate
	 */
	public void setCbCrshldTerminateDate(String cbCrshldTerminateDate){
		this.cbCrshldTerminateDate = cbCrshldTerminateDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCrshldTerminateDate(){
    	return cbCrshldTerminateDate;
    }
	/**
	 * 公司ID
	 * @param cbCorporateId
	 */
	public void setCbCorporateId(String cbCorporateId){
		this.cbCorporateId = cbCorporateId;
	}
	
    /**
     * 公司ID
     * @return
     */	
    public String getCbCorporateId(){
    	return cbCorporateId;
    }
	/**
	 * 行业代码
	 * @param cbSic
	 */
	public void setCbSic(String cbSic){
		this.cbSic = cbSic;
	}
	
    /**
     * 行业代码
     * @return
     */	
    public String getCbSic(){
    	return cbSic;
    }
	/**
	 * 关系
	 * @param cbRelationship
	 */
	public void setCbRelationship(String cbRelationship){
		this.cbRelationship = cbRelationship;
	}
	
    /**
     * 关系
     * @return
     */	
    public String getCbRelationship(){
    	return cbRelationship;
    }
	/**
	 * 
	 * @param cbFraudFlag1
	 */
	public void setCbFraudFlag1(Integer cbFraudFlag1){
		this.cbFraudFlag1 = cbFraudFlag1;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getCbFraudFlag1(){
    	return cbFraudFlag1;
    }
	/**
	 * 
	 * @param cbFraudFlag2
	 */
	public void setCbFraudFlag2(String cbFraudFlag2){
		this.cbFraudFlag2 = cbFraudFlag2;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbFraudFlag2(){
    	return cbFraudFlag2;
    }
	/**
	 * 首次使用日期
	 * @param cbFirstUseDate
	 */
	public void setCbFirstUseDate(String cbFirstUseDate){
		this.cbFirstUseDate = cbFirstUseDate;
	}
	
    /**
     * 首次使用日期
     * @return
     */	
    public String getCbFirstUseDate(){
    	return cbFirstUseDate;
    }
	/**
	 * 首次使用时间
	 * @param cbFirstUseTime
	 */
	public void setCbFirstUseTime(String cbFirstUseTime){
		this.cbFirstUseTime = cbFirstUseTime;
	}
	
    /**
     * 首次使用时间
     * @return
     */	
    public String getCbFirstUseTime(){
    	return cbFirstUseTime;
    }
	/**
	 * 首次使用标志
	 * @param cbFirstUseInd
	 */
	public void setCbFirstUseInd(String cbFirstUseInd){
		this.cbFirstUseInd = cbFirstUseInd;
	}
	
    /**
     * 首次使用标志
     * @return
     */	
    public String getCbFirstUseInd(){
    	return cbFirstUseInd;
    }
	/**
	 * 
	 * @param cbOldIdType
	 */
	public void setCbOldIdType(String cbOldIdType){
		this.cbOldIdType = cbOldIdType;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbOldIdType(){
    	return cbOldIdType;
    }
	/**
	 * 
	 * @param cbOldCustomerIdno
	 */
	public void setCbOldCustomerIdno(String cbOldCustomerIdno){
		this.cbOldCustomerIdno = cbOldCustomerIdno;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbOldCustomerIdno(){
    	return cbOldCustomerIdno;
    }
	/**
	 * 
	 * @param cbCifFlag
	 */
	public void setCbCifFlag(String cbCifFlag){
		this.cbCifFlag = cbCifFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCifFlag(){
    	return cbCifFlag;
    }
	/**
	 * 
	 * @param cbDcmsFlag
	 */
	public void setCbDcmsFlag(String cbDcmsFlag){
		this.cbDcmsFlag = cbDcmsFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbDcmsFlag(){
    	return cbDcmsFlag;
    }
	/**
	 * 
	 * @param cbCafRefreshFlag
	 */
	public void setCbCafRefreshFlag(String cbCafRefreshFlag){
		this.cbCafRefreshFlag = cbCafRefreshFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCafRefreshFlag(){
    	return cbCafRefreshFlag;
    }
	/**
	 * 
	 * @param cbCafUpdateFlag
	 */
	public void setCbCafUpdateFlag(String cbCafUpdateFlag){
		this.cbCafUpdateFlag = cbCafUpdateFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCafUpdateFlag(){
    	return cbCafUpdateFlag;
    }
	/**
	 * 
	 * @param cbCafPinFlag
	 */
	public void setCbCafPinFlag(String cbCafPinFlag){
		this.cbCafPinFlag = cbCafPinFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCafPinFlag(){
    	return cbCafPinFlag;
    }
	/**
	 * 
	 * @param cbCafTagFlag
	 */
	public void setCbCafTagFlag(String cbCafTagFlag){
		this.cbCafTagFlag = cbCafTagFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCafTagFlag(){
    	return cbCafTagFlag;
    }
	/**
	 * 卡收集标志
	 * @param cbCardCollMethod
	 */
	public void setCbCardCollMethod(String cbCardCollMethod){
		this.cbCardCollMethod = cbCardCollMethod;
	}
	
    /**
     * 卡收集标志
     * @return
     */	
    public String getCbCardCollMethod(){
    	return cbCardCollMethod;
    }
	/**
	 * 
	 * @param cbCardDeliveryAddr
	 */
	public void setCbCardDeliveryAddr(String cbCardDeliveryAddr){
		this.cbCardDeliveryAddr = cbCardDeliveryAddr;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCardDeliveryAddr(){
    	return cbCardDeliveryAddr;
    }
	/**
	 * 
	 * @param cbBillAddrCd
	 */
	public void setCbBillAddrCd(String cbBillAddrCd){
		this.cbBillAddrCd = cbBillAddrCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbBillAddrCd(){
    	return cbBillAddrCd;
    }
	/**
	 * 物理卡号
	 * @param cbRwdsAccno
	 */
	public void setCbRwdsAccno(String cbRwdsAccno){
		this.cbRwdsAccno = cbRwdsAccno;
	}
	
    /**
     * 物理卡号
     * @return
     */	
    public String getCbRwdsAccno(){
    	return cbRwdsAccno;
    }
	/**
	 * 法律信函投递地址
	 * @param cbLegalAddrCd
	 */
	public void setCbLegalAddrCd(String cbLegalAddrCd){
		this.cbLegalAddrCd = cbLegalAddrCd;
	}
	
    /**
     * 法律信函投递地址
     * @return
     */	
    public String getCbLegalAddrCd(){
    	return cbLegalAddrCd;
    }
	/**
	 * 上次续卡费用年
	 * @param cbLastRenewFeeYear
	 */
	public void setCbLastRenewFeeYear(String cbLastRenewFeeYear){
		this.cbLastRenewFeeYear = cbLastRenewFeeYear;
	}
	
    /**
     * 上次续卡费用年
     * @return
     */	
    public String getCbLastRenewFeeYear(){
    	return cbLastRenewFeeYear;
    }
	/**
	 * 状态
	 * @param cbStatusCd
	 */
	public void setCbStatusCd(String cbStatusCd){
		this.cbStatusCd = cbStatusCd;
	}
	
    /**
     * 状态
     * @return
     */	
    public String getCbStatusCd(){
    	return cbStatusCd;
    }
	/**
	 * 监控代码
	 * @param cbMonitorCd
	 */
	public void setCbMonitorCd(String cbMonitorCd){
		this.cbMonitorCd = cbMonitorCd;
	}
	
    /**
     * 监控代码
     * @return
     */	
    public String getCbMonitorCd(){
    	return cbMonitorCd;
    }
	/**
	 * 
	 * @param cbCollectCd
	 */
	public void setCbCollectCd(String cbCollectCd){
		this.cbCollectCd = cbCollectCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCollectCd(){
    	return cbCollectCd;
    }
	/**
	 * 员工号
	 * @param cbEmployeeId
	 */
	public void setCbEmployeeId(String cbEmployeeId){
		this.cbEmployeeId = cbEmployeeId;
	}
	
    /**
     * 员工号
     * @return
     */	
    public String getCbEmployeeId(){
    	return cbEmployeeId;
    }
	/**
	 * 账号规则
	 * @param cbIndaccRule
	 */
	public void setCbIndaccRule(Integer cbIndaccRule){
		this.cbIndaccRule = cbIndaccRule;
	}
	
    /**
     * 账号规则
     * @return
     */	
    public Integer getCbIndaccRule(){
    	return cbIndaccRule;
    }
	/**
	 * 外部账号1
	 * @param cbIndaccNo1
	 */
	public void setCbIndaccNo1(String cbIndaccNo1){
		this.cbIndaccNo1 = cbIndaccNo1;
	}
	
    /**
     * 外部账号1
     * @return
     */	
    public String getCbIndaccNo1(){
    	return cbIndaccNo1;
    }
	/**
	 * 账号规则1
	 * @param cbIndaccRule1
	 */
	public void setCbIndaccRule1(Integer cbIndaccRule1){
		this.cbIndaccRule1 = cbIndaccRule1;
	}
	
    /**
     * 账号规则1
     * @return
     */	
    public Integer getCbIndaccRule1(){
    	return cbIndaccRule1;
    }
	/**
	 * 外部账号2
	 * @param cbIndaccNo2
	 */
	public void setCbIndaccNo2(String cbIndaccNo2){
		this.cbIndaccNo2 = cbIndaccNo2;
	}
	
    /**
     * 外部账号2
     * @return
     */	
    public String getCbIndaccNo2(){
    	return cbIndaccNo2;
    }
	/**
	 * 账号规则2
	 * @param cbIndaccRule2
	 */
	public void setCbIndaccRule2(Integer cbIndaccRule2){
		this.cbIndaccRule2 = cbIndaccRule2;
	}
	
    /**
     * 账号规则2
     * @return
     */	
    public Integer getCbIndaccRule2(){
    	return cbIndaccRule2;
    }
	/**
	 * 外部账号3
	 * @param cbIndaccNo3
	 */
	public void setCbIndaccNo3(String cbIndaccNo3){
		this.cbIndaccNo3 = cbIndaccNo3;
	}
	
    /**
     * 外部账号3
     * @return
     */	
    public String getCbIndaccNo3(){
    	return cbIndaccNo3;
    }
	/**
	 * 账号规则3
	 * @param cbIndaccRule3
	 */
	public void setCbIndaccRule3(Integer cbIndaccRule3){
		this.cbIndaccRule3 = cbIndaccRule3;
	}
	
    /**
     * 账号规则3
     * @return
     */	
    public Integer getCbIndaccRule3(){
    	return cbIndaccRule3;
    }
	/**
	 * 外部账号4
	 * @param cbIndaccNo4
	 */
	public void setCbIndaccNo4(String cbIndaccNo4){
		this.cbIndaccNo4 = cbIndaccNo4;
	}
	
    /**
     * 外部账号4
     * @return
     */	
    public String getCbIndaccNo4(){
    	return cbIndaccNo4;
    }
	/**
	 * 账号规则4
	 * @param cbIndaccRule4
	 */
	public void setCbIndaccRule4(Integer cbIndaccRule4){
		this.cbIndaccRule4 = cbIndaccRule4;
	}
	
    /**
     * 账号规则4
     * @return
     */	
    public Integer getCbIndaccRule4(){
    	return cbIndaccRule4;
    }
	/**
	 * 外部账号5
	 * @param cbIndaccNo5
	 */
	public void setCbIndaccNo5(String cbIndaccNo5){
		this.cbIndaccNo5 = cbIndaccNo5;
	}
	
    /**
     * 外部账号5
     * @return
     */	
    public String getCbIndaccNo5(){
    	return cbIndaccNo5;
    }
	/**
	 * 账号规则5
	 * @param cbIndaccRule5
	 */
	public void setCbIndaccRule5(Integer cbIndaccRule5){
		this.cbIndaccRule5 = cbIndaccRule5;
	}
	
    /**
     * 账号规则5
     * @return
     */	
    public Integer getCbIndaccRule5(){
    	return cbIndaccRule5;
    }
	/**
	 * 外部账号6
	 * @param cbIndaccNo6
	 */
	public void setCbIndaccNo6(String cbIndaccNo6){
		this.cbIndaccNo6 = cbIndaccNo6;
	}
	
    /**
     * 外部账号6
     * @return
     */	
    public String getCbIndaccNo6(){
    	return cbIndaccNo6;
    }
	/**
	 * 账号规则6
	 * @param cbIndaccRule6
	 */
	public void setCbIndaccRule6(Integer cbIndaccRule6){
		this.cbIndaccRule6 = cbIndaccRule6;
	}
	
    /**
     * 账号规则6
     * @return
     */	
    public Integer getCbIndaccRule6(){
    	return cbIndaccRule6;
    }
	/**
	 * 外部账号7
	 * @param cbIndaccNo7
	 */
	public void setCbIndaccNo7(String cbIndaccNo7){
		this.cbIndaccNo7 = cbIndaccNo7;
	}
	
    /**
     * 外部账号7
     * @return
     */	
    public String getCbIndaccNo7(){
    	return cbIndaccNo7;
    }
	/**
	 * 账号规则7
	 * @param cbIndaccRule7
	 */
	public void setCbIndaccRule7(Integer cbIndaccRule7){
		this.cbIndaccRule7 = cbIndaccRule7;
	}
	
    /**
     * 账号规则7
     * @return
     */	
    public Integer getCbIndaccRule7(){
    	return cbIndaccRule7;
    }
	/**
	 * 外部账号8
	 * @param cbIndaccNo8
	 */
	public void setCbIndaccNo8(String cbIndaccNo8){
		this.cbIndaccNo8 = cbIndaccNo8;
	}
	
    /**
     * 外部账号8
     * @return
     */	
    public String getCbIndaccNo8(){
    	return cbIndaccNo8;
    }
	/**
	 * 账号规则8
	 * @param cbIndaccRule8
	 */
	public void setCbIndaccRule8(Integer cbIndaccRule8){
		this.cbIndaccRule8 = cbIndaccRule8;
	}
	
    /**
     * 账号规则8
     * @return
     */	
    public Integer getCbIndaccRule8(){
    	return cbIndaccRule8;
    }
	/**
	 * 外部账号9
	 * @param cbIndaccNo9
	 */
	public void setCbIndaccNo9(String cbIndaccNo9){
		this.cbIndaccNo9 = cbIndaccNo9;
	}
	
    /**
     * 外部账号9
     * @return
     */	
    public String getCbIndaccNo9(){
    	return cbIndaccNo9;
    }
	/**
	 * 账号规则9
	 * @param cbIndaccRule9
	 */
	public void setCbIndaccRule9(Integer cbIndaccRule9){
		this.cbIndaccRule9 = cbIndaccRule9;
	}
	
    /**
     * 账号规则9
     * @return
     */	
    public Integer getCbIndaccRule9(){
    	return cbIndaccRule9;
    }
	/**
	 * 
	 * @param cbPvv
	 */
	public void setCbPvv(Integer cbPvv){
		this.cbPvv = cbPvv;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getCbPvv(){
    	return cbPvv;
    }
	/**
	 * 
	 * @param cbPvvOffset
	 */
	public void setCbPvvOffset(Integer cbPvvOffset){
		this.cbPvvOffset = cbPvvOffset;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getCbPvvOffset(){
    	return cbPvvOffset;
    }
	/**
	 * 
	 * @param cbCvki
	 */
	public void setCbCvki(Integer cbCvki){
		this.cbCvki = cbCvki;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getCbCvki(){
    	return cbCvki;
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