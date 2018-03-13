package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MMerchantCc {
	/**
	 *  商户编号
	 */
	private String merchantId;
	/**
	 *  商户流水编号
	 */
	private String mmId;
	/**
	 *  商户员工编号
	 */
	private String mmUserId;
	/**
	 *  商户系统参数编号
	 */
	private String mmOrgId;
	/**
	 *  商户名称
	 */
	private String merchantName;
	/**
	 *  营业执照号
	 */
	private String mmBussinessLicense;
	/**
	 *  法人
	 */
	private String mmPersonName;
	/**
	 *  法人身份证
	 */
	private String mmPersonCardno;
	/**
	 *  分店数量
	 */
	private String mmBranchNumber;
	/**
	 *  签约日期
	 */
	private String contractDate;
	/**
	 *  会计人员姓名
	 */
	private String accountantName;
	/**
	 *  会计人员电话区号
	 */
	private String accountantDistrictno;
	/**
	 *  会计人员电话
	 */
	private String accountantMobile;
	/**
	 *  开户名
	 */
	private String mmAccountName;
	/**
	 *  商户开户银行
	 */
	private String mmBankName;
	/**
	 *  商户账户银行账号
	 */
	private String mmBankAccount;
	/**
	 *  所在国家
	 */
	private String phyCountry;
	/**
	 *  所在省市
	 */
	private String phyState;
	/**
	 *  所在城市
	 */
	private String phyCity;
	/**
	 *  地区
	 */
	private String phyArea;
	/**
	 *  街道
	 */
	private String phyStreet;
	/**
	 *  门牌号
	 */
	private String phyHouseNumber;
	/**
	 *  地址行1
	 */
	private String phyAddLine1;
	/**
	 *  地址行2
	 */
	private String phyAddLine2;
	/**
	 *  商户地址邮编
	 */
	private String phyZipcode;
	/**
	 *  开发专员姓名
	 */
	private String accountManager;
	/**
	 *  开发专员电话
	 */
	private String accountMobile;
	/**
	 *  联系人姓名
	 */
	private String contactName;
	/**
	 *  联系人职务
	 */
	private String contactJob;
	/**
	 *  联系人区号
	 */
	private String contactDistrictno;
	/**
	 *  联系人电话
	 */
	private String contactPhone;
	/**
	 *  联系人手机
	 */
	private String contactMobile;
	/**
	 *  注册名称
	 */
	private String regName;
	/**
	 *  注册地址行1
	 */
	private String regAddLine1;
	/**
	 *  注册地址行2
	 */
	private String regAddLine2;
	/**
	 *  注册地址邮编
	 */
	private String regZipcode;
	/**
	 *  客户经理姓名
	 */
	private String clientManagerName;
	/**
	 *  客户经理代码
	 */
	private String clientManagerNo;
	/**
	 *  佣金比例
	 */
	private java.math.BigDecimal discountRate;
	/**
	 *  黑名单标识
	 */
	private String blackInd;
	/**
	 *  加入黑名单原因
	 */
	private String blackReason;
	/**
	 *  触犯后行动
	 */
	private String actionCode;
	/**
	 *  授权类型
	 */
	private String authType;
	/**
	 *  佣金方向
	 */
	private String fundsDirection;
	/**
	 *  首次佣金支付日期
	 */
	private String firstCommission;
	/**
	 *  佣金支付频率（月）
	 */
	private Byte commissionFreq;
	/**
	 *  风险类型
	 */
	private String riskType;
	/**
	 *  商户状态
	 */
	private String status;
	/**
	 *  商户申请时间
	 */
	private String mmApplyDate;
	/**
	 *  商户复合时间
	 */
	private String mmCheckDate;
	/**
	 *  备注
	 */
	private String mmRemark;
	/**
	 *  自定义金额1
	 */
	private java.math.BigDecimal userAmt1;
	/**
	 *  自定义金额2
	 */
	private java.math.BigDecimal userAmt2;
	/**
	 *  自定义金额3
	 */
	private java.math.BigDecimal userAmt3;
	/**
	 *  自定义金额4
	 */
	private java.math.BigDecimal userAmt4;
	/**
	 *  用户编码1
	 */
	private String userCode1;
	/**
	 *  用户编码2
	 */
	private String userCode2;
	/**
	 *  备用字段1
	 */
	private String userField1;
	/**
	 *  备用字段2
	 */
	private String userField2;
	/**
	 *  备用字段3
	 */
	private String userField3;
	/**
	 *  备用字段4
	 */
	private String userField4;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 商户编号
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}
	
    /**
     * 商户编号
     * @return
     */	
    public String getMerchantId(){
    	return merchantId;
    }
	/**
	 * 商户流水编号
	 * @param mmId
	 */
	public void setMmId(String mmId){
		this.mmId = mmId;
	}
	
    /**
     * 商户流水编号
     * @return
     */	
    public String getMmId(){
    	return mmId;
    }
	/**
	 * 商户员工编号
	 * @param mmUserId
	 */
	public void setMmUserId(String mmUserId){
		this.mmUserId = mmUserId;
	}
	
    /**
     * 商户员工编号
     * @return
     */	
    public String getMmUserId(){
    	return mmUserId;
    }
	/**
	 * 商户系统参数编号
	 * @param mmOrgId
	 */
	public void setMmOrgId(String mmOrgId){
		this.mmOrgId = mmOrgId;
	}
	
    /**
     * 商户系统参数编号
     * @return
     */	
    public String getMmOrgId(){
    	return mmOrgId;
    }
	/**
	 * 商户名称
	 * @param merchantName
	 */
	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}
	
    /**
     * 商户名称
     * @return
     */	
    public String getMerchantName(){
    	return merchantName;
    }
	/**
	 * 营业执照号
	 * @param mmBussinessLicense
	 */
	public void setMmBussinessLicense(String mmBussinessLicense){
		this.mmBussinessLicense = mmBussinessLicense;
	}
	
    /**
     * 营业执照号
     * @return
     */	
    public String getMmBussinessLicense(){
    	return mmBussinessLicense;
    }
	/**
	 * 法人
	 * @param mmPersonName
	 */
	public void setMmPersonName(String mmPersonName){
		this.mmPersonName = mmPersonName;
	}
	
    /**
     * 法人
     * @return
     */	
    public String getMmPersonName(){
    	return mmPersonName;
    }
	/**
	 * 法人身份证
	 * @param mmPersonCardno
	 */
	public void setMmPersonCardno(String mmPersonCardno){
		this.mmPersonCardno = mmPersonCardno;
	}
	
    /**
     * 法人身份证
     * @return
     */	
    public String getMmPersonCardno(){
    	return mmPersonCardno;
    }
	/**
	 * 分店数量
	 * @param mmBranchNumber
	 */
	public void setMmBranchNumber(String mmBranchNumber){
		this.mmBranchNumber = mmBranchNumber;
	}
	
    /**
     * 分店数量
     * @return
     */	
    public String getMmBranchNumber(){
    	return mmBranchNumber;
    }
	/**
	 * 签约日期
	 * @param contractDate
	 */
	public void setContractDate(String contractDate){
		this.contractDate = contractDate;
	}
	
    /**
     * 签约日期
     * @return
     */	
    public String getContractDate(){
    	return contractDate;
    }
	/**
	 * 会计人员姓名
	 * @param accountantName
	 */
	public void setAccountantName(String accountantName){
		this.accountantName = accountantName;
	}
	
    /**
     * 会计人员姓名
     * @return
     */	
    public String getAccountantName(){
    	return accountantName;
    }
	/**
	 * 会计人员电话区号
	 * @param accountantDistrictno
	 */
	public void setAccountantDistrictno(String accountantDistrictno){
		this.accountantDistrictno = accountantDistrictno;
	}
	
    /**
     * 会计人员电话区号
     * @return
     */	
    public String getAccountantDistrictno(){
    	return accountantDistrictno;
    }
	/**
	 * 会计人员电话
	 * @param accountantMobile
	 */
	public void setAccountantMobile(String accountantMobile){
		this.accountantMobile = accountantMobile;
	}
	
    /**
     * 会计人员电话
     * @return
     */	
    public String getAccountantMobile(){
    	return accountantMobile;
    }
	/**
	 * 开户名
	 * @param mmAccountName
	 */
	public void setMmAccountName(String mmAccountName){
		this.mmAccountName = mmAccountName;
	}
	
    /**
     * 开户名
     * @return
     */	
    public String getMmAccountName(){
    	return mmAccountName;
    }
	/**
	 * 商户开户银行
	 * @param mmBankName
	 */
	public void setMmBankName(String mmBankName){
		this.mmBankName = mmBankName;
	}
	
    /**
     * 商户开户银行
     * @return
     */	
    public String getMmBankName(){
    	return mmBankName;
    }
	/**
	 * 商户账户银行账号
	 * @param mmBankAccount
	 */
	public void setMmBankAccount(String mmBankAccount){
		this.mmBankAccount = mmBankAccount;
	}
	
    /**
     * 商户账户银行账号
     * @return
     */	
    public String getMmBankAccount(){
    	return mmBankAccount;
    }
	/**
	 * 所在国家
	 * @param phyCountry
	 */
	public void setPhyCountry(String phyCountry){
		this.phyCountry = phyCountry;
	}
	
    /**
     * 所在国家
     * @return
     */	
    public String getPhyCountry(){
    	return phyCountry;
    }
	/**
	 * 所在省市
	 * @param phyState
	 */
	public void setPhyState(String phyState){
		this.phyState = phyState;
	}
	
    /**
     * 所在省市
     * @return
     */	
    public String getPhyState(){
    	return phyState;
    }
	/**
	 * 所在城市
	 * @param phyCity
	 */
	public void setPhyCity(String phyCity){
		this.phyCity = phyCity;
	}
	
    /**
     * 所在城市
     * @return
     */	
    public String getPhyCity(){
    	return phyCity;
    }
	/**
	 * 地区
	 * @param phyArea
	 */
	public void setPhyArea(String phyArea){
		this.phyArea = phyArea;
	}
	
    /**
     * 地区
     * @return
     */	
    public String getPhyArea(){
    	return phyArea;
    }
	/**
	 * 街道
	 * @param phyStreet
	 */
	public void setPhyStreet(String phyStreet){
		this.phyStreet = phyStreet;
	}
	
    /**
     * 街道
     * @return
     */	
    public String getPhyStreet(){
    	return phyStreet;
    }
	/**
	 * 门牌号
	 * @param phyHouseNumber
	 */
	public void setPhyHouseNumber(String phyHouseNumber){
		this.phyHouseNumber = phyHouseNumber;
	}
	
    /**
     * 门牌号
     * @return
     */	
    public String getPhyHouseNumber(){
    	return phyHouseNumber;
    }
	/**
	 * 地址行1
	 * @param phyAddLine1
	 */
	public void setPhyAddLine1(String phyAddLine1){
		this.phyAddLine1 = phyAddLine1;
	}
	
    /**
     * 地址行1
     * @return
     */	
    public String getPhyAddLine1(){
    	return phyAddLine1;
    }
	/**
	 * 地址行2
	 * @param phyAddLine2
	 */
	public void setPhyAddLine2(String phyAddLine2){
		this.phyAddLine2 = phyAddLine2;
	}
	
    /**
     * 地址行2
     * @return
     */	
    public String getPhyAddLine2(){
    	return phyAddLine2;
    }
	/**
	 * 商户地址邮编
	 * @param phyZipcode
	 */
	public void setPhyZipcode(String phyZipcode){
		this.phyZipcode = phyZipcode;
	}
	
    /**
     * 商户地址邮编
     * @return
     */	
    public String getPhyZipcode(){
    	return phyZipcode;
    }
	/**
	 * 开发专员姓名
	 * @param accountManager
	 */
	public void setAccountManager(String accountManager){
		this.accountManager = accountManager;
	}
	
    /**
     * 开发专员姓名
     * @return
     */	
    public String getAccountManager(){
    	return accountManager;
    }
	/**
	 * 开发专员电话
	 * @param accountMobile
	 */
	public void setAccountMobile(String accountMobile){
		this.accountMobile = accountMobile;
	}
	
    /**
     * 开发专员电话
     * @return
     */	
    public String getAccountMobile(){
    	return accountMobile;
    }
	/**
	 * 联系人姓名
	 * @param contactName
	 */
	public void setContactName(String contactName){
		this.contactName = contactName;
	}
	
    /**
     * 联系人姓名
     * @return
     */	
    public String getContactName(){
    	return contactName;
    }
	/**
	 * 联系人职务
	 * @param contactJob
	 */
	public void setContactJob(String contactJob){
		this.contactJob = contactJob;
	}
	
    /**
     * 联系人职务
     * @return
     */	
    public String getContactJob(){
    	return contactJob;
    }
	/**
	 * 联系人区号
	 * @param contactDistrictno
	 */
	public void setContactDistrictno(String contactDistrictno){
		this.contactDistrictno = contactDistrictno;
	}
	
    /**
     * 联系人区号
     * @return
     */	
    public String getContactDistrictno(){
    	return contactDistrictno;
    }
	/**
	 * 联系人电话
	 * @param contactPhone
	 */
	public void setContactPhone(String contactPhone){
		this.contactPhone = contactPhone;
	}
	
    /**
     * 联系人电话
     * @return
     */	
    public String getContactPhone(){
    	return contactPhone;
    }
	/**
	 * 联系人手机
	 * @param contactMobile
	 */
	public void setContactMobile(String contactMobile){
		this.contactMobile = contactMobile;
	}
	
    /**
     * 联系人手机
     * @return
     */	
    public String getContactMobile(){
    	return contactMobile;
    }
	/**
	 * 注册名称
	 * @param regName
	 */
	public void setRegName(String regName){
		this.regName = regName;
	}
	
    /**
     * 注册名称
     * @return
     */	
    public String getRegName(){
    	return regName;
    }
	/**
	 * 注册地址行1
	 * @param regAddLine1
	 */
	public void setRegAddLine1(String regAddLine1){
		this.regAddLine1 = regAddLine1;
	}
	
    /**
     * 注册地址行1
     * @return
     */	
    public String getRegAddLine1(){
    	return regAddLine1;
    }
	/**
	 * 注册地址行2
	 * @param regAddLine2
	 */
	public void setRegAddLine2(String regAddLine2){
		this.regAddLine2 = regAddLine2;
	}
	
    /**
     * 注册地址行2
     * @return
     */	
    public String getRegAddLine2(){
    	return regAddLine2;
    }
	/**
	 * 注册地址邮编
	 * @param regZipcode
	 */
	public void setRegZipcode(String regZipcode){
		this.regZipcode = regZipcode;
	}
	
    /**
     * 注册地址邮编
     * @return
     */	
    public String getRegZipcode(){
    	return regZipcode;
    }
	/**
	 * 客户经理姓名
	 * @param clientManagerName
	 */
	public void setClientManagerName(String clientManagerName){
		this.clientManagerName = clientManagerName;
	}
	
    /**
     * 客户经理姓名
     * @return
     */	
    public String getClientManagerName(){
    	return clientManagerName;
    }
	/**
	 * 客户经理代码
	 * @param clientManagerNo
	 */
	public void setClientManagerNo(String clientManagerNo){
		this.clientManagerNo = clientManagerNo;
	}
	
    /**
     * 客户经理代码
     * @return
     */	
    public String getClientManagerNo(){
    	return clientManagerNo;
    }
	/**
	 * 佣金比例
	 * @param discountRate
	 */
	public void setDiscountRate(java.math.BigDecimal discountRate){
		this.discountRate = discountRate;
	}
	
    /**
     * 佣金比例
     * @return
     */	
    public java.math.BigDecimal getDiscountRate(){
    	return discountRate;
    }
	/**
	 * 黑名单标识
	 * @param blackInd
	 */
	public void setBlackInd(String blackInd){
		this.blackInd = blackInd;
	}
	
    /**
     * 黑名单标识
     * @return
     */	
    public String getBlackInd(){
    	return blackInd;
    }
	/**
	 * 加入黑名单原因
	 * @param blackReason
	 */
	public void setBlackReason(String blackReason){
		this.blackReason = blackReason;
	}
	
    /**
     * 加入黑名单原因
     * @return
     */	
    public String getBlackReason(){
    	return blackReason;
    }
	/**
	 * 触犯后行动
	 * @param actionCode
	 */
	public void setActionCode(String actionCode){
		this.actionCode = actionCode;
	}
	
    /**
     * 触犯后行动
     * @return
     */	
    public String getActionCode(){
    	return actionCode;
    }
	/**
	 * 授权类型
	 * @param authType
	 */
	public void setAuthType(String authType){
		this.authType = authType;
	}
	
    /**
     * 授权类型
     * @return
     */	
    public String getAuthType(){
    	return authType;
    }
	/**
	 * 佣金方向
	 * @param fundsDirection
	 */
	public void setFundsDirection(String fundsDirection){
		this.fundsDirection = fundsDirection;
	}
	
    /**
     * 佣金方向
     * @return
     */	
    public String getFundsDirection(){
    	return fundsDirection;
    }
	/**
	 * 首次佣金支付日期
	 * @param firstCommission
	 */
	public void setFirstCommission(String firstCommission){
		this.firstCommission = firstCommission;
	}
	
    /**
     * 首次佣金支付日期
     * @return
     */	
    public String getFirstCommission(){
    	return firstCommission;
    }
	/**
	 * 佣金支付频率（月）
	 * @param commissionFreq
	 */
	public void setCommissionFreq(Byte commissionFreq){
		this.commissionFreq = commissionFreq;
	}
	
    /**
     * 佣金支付频率（月）
     * @return
     */	
    public Byte getCommissionFreq(){
    	return commissionFreq;
    }
	/**
	 * 风险类型
	 * @param riskType
	 */
	public void setRiskType(String riskType){
		this.riskType = riskType;
	}
	
    /**
     * 风险类型
     * @return
     */	
    public String getRiskType(){
    	return riskType;
    }
	/**
	 * 商户状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 商户状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
	/**
	 * 商户申请时间
	 * @param mmApplyDate
	 */
	public void setMmApplyDate(String mmApplyDate){
		this.mmApplyDate = mmApplyDate;
	}
	
    /**
     * 商户申请时间
     * @return
     */	
    public String getMmApplyDate(){
    	return mmApplyDate;
    }
	/**
	 * 商户复合时间
	 * @param mmCheckDate
	 */
	public void setMmCheckDate(String mmCheckDate){
		this.mmCheckDate = mmCheckDate;
	}
	
    /**
     * 商户复合时间
     * @return
     */	
    public String getMmCheckDate(){
    	return mmCheckDate;
    }
	/**
	 * 备注
	 * @param mmRemark
	 */
	public void setMmRemark(String mmRemark){
		this.mmRemark = mmRemark;
	}
	
    /**
     * 备注
     * @return
     */	
    public String getMmRemark(){
    	return mmRemark;
    }
	/**
	 * 自定义金额1
	 * @param userAmt1
	 */
	public void setUserAmt1(java.math.BigDecimal userAmt1){
		this.userAmt1 = userAmt1;
	}
	
    /**
     * 自定义金额1
     * @return
     */	
    public java.math.BigDecimal getUserAmt1(){
    	return userAmt1;
    }
	/**
	 * 自定义金额2
	 * @param userAmt2
	 */
	public void setUserAmt2(java.math.BigDecimal userAmt2){
		this.userAmt2 = userAmt2;
	}
	
    /**
     * 自定义金额2
     * @return
     */	
    public java.math.BigDecimal getUserAmt2(){
    	return userAmt2;
    }
	/**
	 * 自定义金额3
	 * @param userAmt3
	 */
	public void setUserAmt3(java.math.BigDecimal userAmt3){
		this.userAmt3 = userAmt3;
	}
	
    /**
     * 自定义金额3
     * @return
     */	
    public java.math.BigDecimal getUserAmt3(){
    	return userAmt3;
    }
	/**
	 * 自定义金额4
	 * @param userAmt4
	 */
	public void setUserAmt4(java.math.BigDecimal userAmt4){
		this.userAmt4 = userAmt4;
	}
	
    /**
     * 自定义金额4
     * @return
     */	
    public java.math.BigDecimal getUserAmt4(){
    	return userAmt4;
    }
	/**
	 * 用户编码1
	 * @param userCode1
	 */
	public void setUserCode1(String userCode1){
		this.userCode1 = userCode1;
	}
	
    /**
     * 用户编码1
     * @return
     */	
    public String getUserCode1(){
    	return userCode1;
    }
	/**
	 * 用户编码2
	 * @param userCode2
	 */
	public void setUserCode2(String userCode2){
		this.userCode2 = userCode2;
	}
	
    /**
     * 用户编码2
     * @return
     */	
    public String getUserCode2(){
    	return userCode2;
    }
	/**
	 * 备用字段1
	 * @param userField1
	 */
	public void setUserField1(String userField1){
		this.userField1 = userField1;
	}
	
    /**
     * 备用字段1
     * @return
     */	
    public String getUserField1(){
    	return userField1;
    }
	/**
	 * 备用字段2
	 * @param userField2
	 */
	public void setUserField2(String userField2){
		this.userField2 = userField2;
	}
	
    /**
     * 备用字段2
     * @return
     */	
    public String getUserField2(){
    	return userField2;
    }
	/**
	 * 备用字段3
	 * @param userField3
	 */
	public void setUserField3(String userField3){
		this.userField3 = userField3;
	}
	
    /**
     * 备用字段3
     * @return
     */	
    public String getUserField3(){
    	return userField3;
    }
	/**
	 * 备用字段4
	 * @param userField4
	 */
	public void setUserField4(String userField4){
		this.userField4 = userField4;
	}
	
    /**
     * 备用字段4
     * @return
     */	
    public String getUserField4(){
    	return userField4;
    }
	/**
	 * checksum
	 * @param checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}
	
    /**
     * checksum
     * @return
     */	
    public String getChecksum(){
    	return checksum;
    }
}