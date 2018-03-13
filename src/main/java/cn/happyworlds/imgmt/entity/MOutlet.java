package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MOutlet {
	/**
	 *  商户编号
	 */
	private String mmId;
	/**
	 *  商户联系人
	 */
	private String MContactName;
	/**
	 *  商户联系人电话
	 */
	private String MContactPhone;
	/**
	 *  门店流水编号
	 */
	private String outletId;
	/**
	 *  门店编号
	 */
	private String outletCode;
	/**
	 *  门店名称
	 */
	private String outletName;
	/**
	 *  用户编号
	 */
	private String OUserId;
	/**
	 *  组织编号
	 */
	private String OOrgId;
	/**
	 *  客户经理姓名
	 */
	private String OClientmanagerName;
	/**
	 *  客户经理代码
	 */
	private String OClientmanagerNo;
	/**
	 *  客户经理代码
	 */
	private String OClientmanagerPhone;
	/**
	 *  邮编
	 */
	private String OZipcode;
	/**
	 *  店员人数
	 */
	private String OClerksNumber;
	/**
	 *  每月分期款量
	 */
	private String OInstallmentAmount;
	/**
	 *  商品类型
	 */
	private String OCommodityType;
	/**
	 *  门店类型
	 */
	private String OOutletType;
	/**
	 *  佣金比例
	 */
	private java.math.BigDecimal ODiscountRate;
	/**
	 *  营业时间（每日）
	 */
	private String OBusinessHours;
	/**
	 *  门店所在国家
	 */
	private String OPhyCountry;
	/**
	 *  门店所在省份
	 */
	private String OPhyState;
	/**
	 *  门店所在城市
	 */
	private String OPhyCity;
	/**
	 *  门店所在区县
	 */
	private String OPhyDistrict;
	/**
	 *  门店详细地址
	 */
	private String OPhyAddLine;
	/**
	 *  门店面积(平方)
	 */
	private Long OPhyArea;
	/**
	 *  风险类型
	 */
	private String ORiskStatus;
	/**
	 *  门店开发专业姓名
	 */
	private String OAtantName;
	/**
	 *  门店开发专业手机
	 */
	private String OAtantMobile;
	/**
	 *  门店联系人
	 */
	private String OContactName;
	/**
	 *  联系人职务
	 */
	private String OContactJob;
	/**
	 *  联系人区号
	 */
	private String OContactDistrictno;
	/**
	 *  联系人电话
	 */
	private String OContactPhone;
	/**
	 *  黑名单标识
	 */
	private String OBlackInd;
	/**
	 *  加入黑名单原因
	 */
	private String OBlackReason;
	/**
	 *  行动代码
	 */
	private String OActionCode;
	/**
	 *  门店状态
	 */
	private String OStatus;
	/**
	 *  门店开户银行名
	 */
	private String OAccountName;
	/**
	 *  门店开户银行
	 */
	private String OBankName;
	/**
	 *  门店账户银行账号
	 */
	private String OBankAccount;
	/**
	 *  门店申请时间
	 */
	private String OApplyDate;
	/**
	 *  门店复合时间
	 */
	private String OCheckDate;
	/**
	 *  备注
	 */
	private String ORemark;
	/**
	 *  自定义字段1
	 */
	private java.math.BigDecimal OUserAmt1;
	/**
	 *  自定义字段1
	 */
	private java.math.BigDecimal OUserAmt2;
	/**
	 *  自定义字段1
	 */
	private java.math.BigDecimal OUserAmt3;
	/**
	 *  自定义字段1
	 */
	private java.math.BigDecimal OUserAmt4;
	/**
	 *  自定义编码1
	 */
	private String OUserCode1;
	/**
	 *  自定义编码1
	 */
	private String OUserCode2;
	/**
	 *  备用字段1
	 */
	private String OUserField1;
	/**
	 *  备用字段2
	 */
	private String OUserField2;
	/**
	 *  备用字段3
	 */
	private String OUserField3;
	/**
	 *  备用字段4
	 */
	private String OUserField4;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 商户编号
	 * @param mmId
	 */
	public void setMmId(String mmId){
		this.mmId = mmId;
	}
	
    /**
     * 商户编号
     * @return
     */	
    public String getMmId(){
    	return mmId;
    }
	/**
	 * 商户联系人
	 * @param MContactName
	 */
	public void setMContactName(String MContactName){
		this.MContactName = MContactName;
	}
	
    /**
     * 商户联系人
     * @return
     */	
    public String getMContactName(){
    	return MContactName;
    }
	/**
	 * 商户联系人电话
	 * @param MContactPhone
	 */
	public void setMContactPhone(String MContactPhone){
		this.MContactPhone = MContactPhone;
	}
	
    /**
     * 商户联系人电话
     * @return
     */	
    public String getMContactPhone(){
    	return MContactPhone;
    }
	/**
	 * 门店流水编号
	 * @param outletId
	 */
	public void setOutletId(String outletId){
		this.outletId = outletId;
	}
	
    /**
     * 门店流水编号
     * @return
     */	
    public String getOutletId(){
    	return outletId;
    }
	/**
	 * 门店编号
	 * @param outletCode
	 */
	public void setOutletCode(String outletCode){
		this.outletCode = outletCode;
	}
	
    /**
     * 门店编号
     * @return
     */	
    public String getOutletCode(){
    	return outletCode;
    }
	/**
	 * 门店名称
	 * @param outletName
	 */
	public void setOutletName(String outletName){
		this.outletName = outletName;
	}
	
    /**
     * 门店名称
     * @return
     */	
    public String getOutletName(){
    	return outletName;
    }
	/**
	 * 用户编号
	 * @param OUserId
	 */
	public void setOUserId(String OUserId){
		this.OUserId = OUserId;
	}
	
    /**
     * 用户编号
     * @return
     */	
    public String getOUserId(){
    	return OUserId;
    }
	/**
	 * 组织编号
	 * @param OOrgId
	 */
	public void setOOrgId(String OOrgId){
		this.OOrgId = OOrgId;
	}
	
    /**
     * 组织编号
     * @return
     */	
    public String getOOrgId(){
    	return OOrgId;
    }
	/**
	 * 客户经理姓名
	 * @param OClientmanagerName
	 */
	public void setOClientmanagerName(String OClientmanagerName){
		this.OClientmanagerName = OClientmanagerName;
	}
	
    /**
     * 客户经理姓名
     * @return
     */	
    public String getOClientmanagerName(){
    	return OClientmanagerName;
    }
	/**
	 * 客户经理代码
	 * @param OClientmanagerNo
	 */
	public void setOClientmanagerNo(String OClientmanagerNo){
		this.OClientmanagerNo = OClientmanagerNo;
	}
	
    /**
     * 客户经理代码
     * @return
     */	
    public String getOClientmanagerNo(){
    	return OClientmanagerNo;
    }
	/**
	 * 客户经理代码
	 * @param OClientmanagerPhone
	 */
	public void setOClientmanagerPhone(String OClientmanagerPhone){
		this.OClientmanagerPhone = OClientmanagerPhone;
	}
	
    /**
     * 客户经理代码
     * @return
     */	
    public String getOClientmanagerPhone(){
    	return OClientmanagerPhone;
    }
	/**
	 * 邮编
	 * @param OZipcode
	 */
	public void setOZipcode(String OZipcode){
		this.OZipcode = OZipcode;
	}
	
    /**
     * 邮编
     * @return
     */	
    public String getOZipcode(){
    	return OZipcode;
    }
	/**
	 * 店员人数
	 * @param OClerksNumber
	 */
	public void setOClerksNumber(String OClerksNumber){
		this.OClerksNumber = OClerksNumber;
	}
	
    /**
     * 店员人数
     * @return
     */	
    public String getOClerksNumber(){
    	return OClerksNumber;
    }
	/**
	 * 每月分期款量
	 * @param OInstallmentAmount
	 */
	public void setOInstallmentAmount(String OInstallmentAmount){
		this.OInstallmentAmount = OInstallmentAmount;
	}
	
    /**
     * 每月分期款量
     * @return
     */	
    public String getOInstallmentAmount(){
    	return OInstallmentAmount;
    }
	/**
	 * 商品类型
	 * @param OCommodityType
	 */
	public void setOCommodityType(String OCommodityType){
		this.OCommodityType = OCommodityType;
	}
	
    /**
     * 商品类型
     * @return
     */	
    public String getOCommodityType(){
    	return OCommodityType;
    }
	/**
	 * 门店类型
	 * @param OOutletType
	 */
	public void setOOutletType(String OOutletType){
		this.OOutletType = OOutletType;
	}
	
    /**
     * 门店类型
     * @return
     */	
    public String getOOutletType(){
    	return OOutletType;
    }
	/**
	 * 佣金比例
	 * @param ODiscountRate
	 */
	public void setODiscountRate(java.math.BigDecimal ODiscountRate){
		this.ODiscountRate = ODiscountRate;
	}
	
    /**
     * 佣金比例
     * @return
     */	
    public java.math.BigDecimal getODiscountRate(){
    	return ODiscountRate;
    }
	/**
	 * 营业时间（每日）
	 * @param OBusinessHours
	 */
	public void setOBusinessHours(String OBusinessHours){
		this.OBusinessHours = OBusinessHours;
	}
	
    /**
     * 营业时间（每日）
     * @return
     */	
    public String getOBusinessHours(){
    	return OBusinessHours;
    }
	/**
	 * 门店所在国家
	 * @param OPhyCountry
	 */
	public void setOPhyCountry(String OPhyCountry){
		this.OPhyCountry = OPhyCountry;
	}
	
    /**
     * 门店所在国家
     * @return
     */	
    public String getOPhyCountry(){
    	return OPhyCountry;
    }
	/**
	 * 门店所在省份
	 * @param OPhyState
	 */
	public void setOPhyState(String OPhyState){
		this.OPhyState = OPhyState;
	}
	
    /**
     * 门店所在省份
     * @return
     */	
    public String getOPhyState(){
    	return OPhyState;
    }
	/**
	 * 门店所在城市
	 * @param OPhyCity
	 */
	public void setOPhyCity(String OPhyCity){
		this.OPhyCity = OPhyCity;
	}
	
    /**
     * 门店所在城市
     * @return
     */	
    public String getOPhyCity(){
    	return OPhyCity;
    }
	/**
	 * 门店所在区县
	 * @param OPhyDistrict
	 */
	public void setOPhyDistrict(String OPhyDistrict){
		this.OPhyDistrict = OPhyDistrict;
	}
	
    /**
     * 门店所在区县
     * @return
     */	
    public String getOPhyDistrict(){
    	return OPhyDistrict;
    }
	/**
	 * 门店详细地址
	 * @param OPhyAddLine
	 */
	public void setOPhyAddLine(String OPhyAddLine){
		this.OPhyAddLine = OPhyAddLine;
	}
	
    /**
     * 门店详细地址
     * @return
     */	
    public String getOPhyAddLine(){
    	return OPhyAddLine;
    }
	/**
	 * 门店面积(平方)
	 * @param OPhyArea
	 */
	public void setOPhyArea(Long OPhyArea){
		this.OPhyArea = OPhyArea;
	}
	
    /**
     * 门店面积(平方)
     * @return
     */	
    public Long getOPhyArea(){
    	return OPhyArea;
    }
	/**
	 * 风险类型
	 * @param ORiskStatus
	 */
	public void setORiskStatus(String ORiskStatus){
		this.ORiskStatus = ORiskStatus;
	}
	
    /**
     * 风险类型
     * @return
     */	
    public String getORiskStatus(){
    	return ORiskStatus;
    }
	/**
	 * 门店开发专业姓名
	 * @param OAtantName
	 */
	public void setOAtantName(String OAtantName){
		this.OAtantName = OAtantName;
	}
	
    /**
     * 门店开发专业姓名
     * @return
     */	
    public String getOAtantName(){
    	return OAtantName;
    }
	/**
	 * 门店开发专业手机
	 * @param OAtantMobile
	 */
	public void setOAtantMobile(String OAtantMobile){
		this.OAtantMobile = OAtantMobile;
	}
	
    /**
     * 门店开发专业手机
     * @return
     */	
    public String getOAtantMobile(){
    	return OAtantMobile;
    }
	/**
	 * 门店联系人
	 * @param OContactName
	 */
	public void setOContactName(String OContactName){
		this.OContactName = OContactName;
	}
	
    /**
     * 门店联系人
     * @return
     */	
    public String getOContactName(){
    	return OContactName;
    }
	/**
	 * 联系人职务
	 * @param OContactJob
	 */
	public void setOContactJob(String OContactJob){
		this.OContactJob = OContactJob;
	}
	
    /**
     * 联系人职务
     * @return
     */	
    public String getOContactJob(){
    	return OContactJob;
    }
	/**
	 * 联系人区号
	 * @param OContactDistrictno
	 */
	public void setOContactDistrictno(String OContactDistrictno){
		this.OContactDistrictno = OContactDistrictno;
	}
	
    /**
     * 联系人区号
     * @return
     */	
    public String getOContactDistrictno(){
    	return OContactDistrictno;
    }
	/**
	 * 联系人电话
	 * @param OContactPhone
	 */
	public void setOContactPhone(String OContactPhone){
		this.OContactPhone = OContactPhone;
	}
	
    /**
     * 联系人电话
     * @return
     */	
    public String getOContactPhone(){
    	return OContactPhone;
    }
	/**
	 * 黑名单标识
	 * @param OBlackInd
	 */
	public void setOBlackInd(String OBlackInd){
		this.OBlackInd = OBlackInd;
	}
	
    /**
     * 黑名单标识
     * @return
     */	
    public String getOBlackInd(){
    	return OBlackInd;
    }
	/**
	 * 加入黑名单原因
	 * @param OBlackReason
	 */
	public void setOBlackReason(String OBlackReason){
		this.OBlackReason = OBlackReason;
	}
	
    /**
     * 加入黑名单原因
     * @return
     */	
    public String getOBlackReason(){
    	return OBlackReason;
    }
	/**
	 * 行动代码
	 * @param OActionCode
	 */
	public void setOActionCode(String OActionCode){
		this.OActionCode = OActionCode;
	}
	
    /**
     * 行动代码
     * @return
     */	
    public String getOActionCode(){
    	return OActionCode;
    }
	/**
	 * 门店状态
	 * @param OStatus
	 */
	public void setOStatus(String OStatus){
		this.OStatus = OStatus;
	}
	
    /**
     * 门店状态
     * @return
     */	
    public String getOStatus(){
    	return OStatus;
    }
	/**
	 * 门店开户银行名
	 * @param OAccountName
	 */
	public void setOAccountName(String OAccountName){
		this.OAccountName = OAccountName;
	}
	
    /**
     * 门店开户银行名
     * @return
     */	
    public String getOAccountName(){
    	return OAccountName;
    }
	/**
	 * 门店开户银行
	 * @param OBankName
	 */
	public void setOBankName(String OBankName){
		this.OBankName = OBankName;
	}
	
    /**
     * 门店开户银行
     * @return
     */	
    public String getOBankName(){
    	return OBankName;
    }
	/**
	 * 门店账户银行账号
	 * @param OBankAccount
	 */
	public void setOBankAccount(String OBankAccount){
		this.OBankAccount = OBankAccount;
	}
	
    /**
     * 门店账户银行账号
     * @return
     */	
    public String getOBankAccount(){
    	return OBankAccount;
    }
	/**
	 * 门店申请时间
	 * @param OApplyDate
	 */
	public void setOApplyDate(String OApplyDate){
		this.OApplyDate = OApplyDate;
	}
	
    /**
     * 门店申请时间
     * @return
     */	
    public String getOApplyDate(){
    	return OApplyDate;
    }
	/**
	 * 门店复合时间
	 * @param OCheckDate
	 */
	public void setOCheckDate(String OCheckDate){
		this.OCheckDate = OCheckDate;
	}
	
    /**
     * 门店复合时间
     * @return
     */	
    public String getOCheckDate(){
    	return OCheckDate;
    }
	/**
	 * 备注
	 * @param ORemark
	 */
	public void setORemark(String ORemark){
		this.ORemark = ORemark;
	}
	
    /**
     * 备注
     * @return
     */	
    public String getORemark(){
    	return ORemark;
    }
	/**
	 * 自定义字段1
	 * @param OUserAmt1
	 */
	public void setOUserAmt1(java.math.BigDecimal OUserAmt1){
		this.OUserAmt1 = OUserAmt1;
	}
	
    /**
     * 自定义字段1
     * @return
     */	
    public java.math.BigDecimal getOUserAmt1(){
    	return OUserAmt1;
    }
	/**
	 * 自定义字段1
	 * @param OUserAmt2
	 */
	public void setOUserAmt2(java.math.BigDecimal OUserAmt2){
		this.OUserAmt2 = OUserAmt2;
	}
	
    /**
     * 自定义字段1
     * @return
     */	
    public java.math.BigDecimal getOUserAmt2(){
    	return OUserAmt2;
    }
	/**
	 * 自定义字段1
	 * @param OUserAmt3
	 */
	public void setOUserAmt3(java.math.BigDecimal OUserAmt3){
		this.OUserAmt3 = OUserAmt3;
	}
	
    /**
     * 自定义字段1
     * @return
     */	
    public java.math.BigDecimal getOUserAmt3(){
    	return OUserAmt3;
    }
	/**
	 * 自定义字段1
	 * @param OUserAmt4
	 */
	public void setOUserAmt4(java.math.BigDecimal OUserAmt4){
		this.OUserAmt4 = OUserAmt4;
	}
	
    /**
     * 自定义字段1
     * @return
     */	
    public java.math.BigDecimal getOUserAmt4(){
    	return OUserAmt4;
    }
	/**
	 * 自定义编码1
	 * @param OUserCode1
	 */
	public void setOUserCode1(String OUserCode1){
		this.OUserCode1 = OUserCode1;
	}
	
    /**
     * 自定义编码1
     * @return
     */	
    public String getOUserCode1(){
    	return OUserCode1;
    }
	/**
	 * 自定义编码1
	 * @param OUserCode2
	 */
	public void setOUserCode2(String OUserCode2){
		this.OUserCode2 = OUserCode2;
	}
	
    /**
     * 自定义编码1
     * @return
     */	
    public String getOUserCode2(){
    	return OUserCode2;
    }
	/**
	 * 备用字段1
	 * @param OUserField1
	 */
	public void setOUserField1(String OUserField1){
		this.OUserField1 = OUserField1;
	}
	
    /**
     * 备用字段1
     * @return
     */	
    public String getOUserField1(){
    	return OUserField1;
    }
	/**
	 * 备用字段2
	 * @param OUserField2
	 */
	public void setOUserField2(String OUserField2){
		this.OUserField2 = OUserField2;
	}
	
    /**
     * 备用字段2
     * @return
     */	
    public String getOUserField2(){
    	return OUserField2;
    }
	/**
	 * 备用字段3
	 * @param OUserField3
	 */
	public void setOUserField3(String OUserField3){
		this.OUserField3 = OUserField3;
	}
	
    /**
     * 备用字段3
     * @return
     */	
    public String getOUserField3(){
    	return OUserField3;
    }
	/**
	 * 备用字段4
	 * @param OUserField4
	 */
	public void setOUserField4(String OUserField4){
		this.OUserField4 = OUserField4;
	}
	
    /**
     * 备用字段4
     * @return
     */	
    public String getOUserField4(){
    	return OUserField4;
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