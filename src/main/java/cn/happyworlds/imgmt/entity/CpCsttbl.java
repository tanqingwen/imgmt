package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class CpCsttbl implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  会员ID
	 */
	private String cbMemberCode;
	/**
	 *  证件类型
	 */
	private String cbIdType;
	/**
	 *  身份证
	 */
	private String cbCustomerIdno;
	/**
	 *  需与身份证上姓名一致
	 */
	private String cbCardholderName;
	/**
	 *  存放手机号码
	 */
	private String cbMobileNo;
	/**
	 *  用户密码
	 */
	private String cbQualification;
	/**
	 *  电子邮箱
	 */
	private String cbEmail;
	/**
	 *  性别--1为男，2为女
	 */
	private String cbSex;
	/**
	 *  出生日期
	 */
	private String cbDob;
	/**
	 *  用户生日
	 */
	private String cbResidencyCode;
	/**
	 *  身份类型
	 */
	private String cbTitle;
	/**
	 *  国籍
	 */
	private String cbNationality;
	/**
	 *  余额
	 */
	private java.math.BigDecimal cbUserAmt1;
	/**
	 *  限额
	 */
	private Long cbCustLimit;
	/**
	 *  微信ID
	 */
	private String cbUserCode1;
	/**
	 *  支付宝ID
	 */
	private String cbUserCode2;
	/**
	 *  新浪微博ID
	 */
	private String cbUserCode3;
	/**
	 *  用户昵称
	 */
	private String cbUserField1;
	/**
	 *  用户头像保存地址
	 */
	private String cbUserField2;
	/**
	 *  会员类型
	 */
	private String cbNricIssuType;
	/**
	 *  积分
	 */
	private String cbStopDunn;
	/**
	 *  客户号
	 */
	private String cbCustomerRefNo;
	/**
	 *  会员等级
	 */
	private String cbNricIssuIdno;
	/**
	 *  被冻结的余额
	 */
	private Long cbOdGroupid;
	/**
	 *  押金余额
	 */
	private String cbOpenDate;
	/**
	 *  所属会员ID
	 */
	private String cbDepartmentCode;
	/**
	 *  会员状态--1正常,2被冻结，3黑名单
	 */
	private String cbAlt2BillState;
	/**
	 *  绑定的时间
	 */
	private String cbModDate;
	/**
	 *  更新时间
	 */
	private String cbModTime;
	/**
	 *  登陆IP
	 */
	private String cbRecommenderId;
	/**
	 *  常住地址1
	 */
	private String cbHomeAddr1;
	/**
	 *  家庭地址2
	 */
	private String cbHomeAddr2;
	/**
	 *  家庭地址3
	 */
	private String cbHomeAddr3;
	/**
	 *  家庭地址4
	 */
	private String cbHomeAddr4;
	/**
	 *  家庭地址5
	 */
	private String cbHomeAddr5;
	/**
	 *  家庭地址所在城市
	 */
	private String cbHomeCity;
	/**
	 *  家庭地址所在省
	 */
	private String cbHomeState;
	/**
	 *  家庭地址所在国家
	 */
	private String cbHomeCntryCd;
	/**
	 *  家庭地址邮政编码
	 */
	private String cbHomePostcode;
	/**
	 *  护照
	 */
	private String cbPassportNo;
	/**
	 *  机构号
	 */
	private String cbBranchId;
	/**
	 *  社会状态
	 */
	private String cbSocialStatus;
	/**
	 *  家庭电话
	 */
	private String cbHomePhone;
	/**
	 *  Y/N .长期居住
	 */
	private String cbPrOfCountry;
	/**
	 *  婚姻状态
	 */
	private String cbMaritalStatus;
	/**
	 *  住房拥有情况
	 */
	private String cbHomeOwnership;
	/**
	 *  房屋类型
	 */
	private String cbHouseType;
	/**
	 *  居住年数
	 */
	private Long cbYearThere;
	/**
	 *  流动资产
	 */
	private String cbLiquidAsset;
	/**
	 *  传呼号
	 */
	private String cbPagerNo;
	/**
	 *  公司名称
	 */
	private String cbCompanyName;
	/**
	 *  公司地址1
	 */
	private String cbCoAddr1;
	/**
	 *  公司地址2
	 */
	private String cbCoAddr2;
	/**
	 *  公司地址3
	 */
	private String cbCoAddr3;
	/**
	 *  公司地址4
	 */
	private String cbCoAddr4;
	/**
	 *  公司地址5
	 */
	private String cbCoAddr5;
	/**
	 *  公司所在城市
	 */
	private String cbCoCity;
	/**
	 *  公司所在省
	 */
	private String cbCoState;
	/**
	 *  公司所在国家
	 */
	private String cbCoCntryCd;
	/**
	 *  公司邮编
	 */
	private String cbCoPostcode;
	/**
	 *  公司电话
	 */
	private String cbCoPhone;
	/**
	 *  公司传真
	 */
	private String cbCoFaxno;
	/**
	 *  职务
	 */
	private String cbCoDesgn;
	/**
	 *  公司架构
	 */
	private String cbCompStructure;
	/**
	 *  工作稳定性
	 */
	private String cbEmpStability;
	/**
	 *  月基本收入
	 */
	private Long cbMthBasicSalary;
	/**
	 *  月津贴
	 */
	private Long cbMthFixedAllow;
	/**
	 *  其他收入
	 */
	private Long cbOtherIncome;
	/**
	 *  服务年数
	 */
	private Long cbLengthSrv;
	/**
	 *  是否自我雇佣
	 */
	private String cbSelfEmploy;
	/**
	 *  行业代码
	 */
	private String cbBussSic;
	/**
	 *  上个公司名称
	 */
	private String cbExEmployName;
	/**
	 *  上个公司工作年数
	 */
	private Long cbExLengthService;
	/**
	 *  上个公司职务
	 */
	private String cbExEmployDesgn;
	/**
	 *  其他贷款银行1
	 */
	private String cbOthLoanBank1;
	/**
	 *  其他贷款类型1
	 */
	private String cbOthLoanType1;
	/**
	 *  其他贷款金额1
	 */
	private Long cbOthLoanAmt1;
	/**
	 *  其他贷款银行2
	 */
	private String cbOthLoanBank2;
	/**
	 *  其他贷款类型2
	 */
	private String cbOthLoanType2;
	/**
	 *  其他贷款金额2
	 */
	private Long cbOthLoanAmt2;
	/**
	 *  其他贷款银行3
	 */
	private String cbOthLoanBank3;
	/**
	 *  其他贷款类型3
	 */
	private String cbOthLoanType3;
	/**
	 *  其他贷款金额3
	 */
	private Long cbOthLoanAmt3;
	/**
	 *  贷记卡号1
	 */
	private String cbCrCardNo1;
	/**
	 *  贷记卡号2
	 */
	private String cbCrCardNo2;
	/**
	 *  透支限额1
	 */
	private Long cbCrCardLimit1;
	/**
	 *  透支限额2
	 */
	private Long cbCrCardLimit2;
	/**
	 *  贷记卡号3
	 */
	private String cbCrCardNo3;
	/**
	 *  透支限额3
	 */
	private Long cbCrCardLimit3;
	/**
	 *  其他银行借贷状态
	 */
	private String cbOthBankCrStatus;
	/**
	 *  母亲姓名
	 */
	private String cbMotherName;
	/**
	 *  配偶姓名
	 */
	private String cbSpouseName;
	/**
	 *  配偶证件号
	 */
	private String cbSpouseNric;
	/**
	 *  配偶工作公司名
	 */
	private String cbSpouseEmployName;
	/**
	 *  抚养人数
	 */
	private Long cbNoOfDependents;
	/**
	 *  联系人姓名
	 */
	private String cbRelName;
	/**
	 *  联系人证件号
	 */
	private String cbRelNric;
	/**
	 *  联系人生日
	 */
	private String cbRelDob;
	/**
	 *  联系人性别
	 */
	private String cbRelSex;
	/**
	 *  与持卡人关系
	 */
	private String cbRelRelationToCh;
	/**
	 *  联系人职务
	 */
	private String cbRelDesgn;
	/**
	 *  联系地址-1
	 */
	private String cbRelAddr1;
	/**
	 *  联系地址-2
	 */
	private String cbRelAddr2;
	/**
	 *  联系地址-3
	 */
	private String cbRelAddr3;
	/**
	 *  联系地址-4
	 */
	private String cbRelAddr4;
	/**
	 *  联系地址-5
	 */
	private String cbRelAddr5;
	/**
	 *  联系人所在城市
	 */
	private String cbRelCity;
	/**
	 *  联系人所在省
	 */
	private String cbRelState;
	/**
	 *  联系人所在国家
	 */
	private String cbRelCntryCd;
	/**
	 *  联系人电话
	 */
	private String cbRelTelno;
	/**
	 *  客户级别
	 */
	private String cbCustClass;
	/**
	 *  兴趣组
	 */
	private String cbInterestGrpCode;
	/**
	 *  其他地址1
	 */
	private String cbAlt1BillAddr1;
	/**
	 *  其他地址2
	 */
	private String cbAlt1BillAddr2;
	/**
	 *  其他地址3
	 */
	private String cbAlt1BillAddr3;
	/**
	 *  其他地址4
	 */
	private String cbAlt1BillAddr4;
	/**
	 *  其他地址5
	 */
	private String cbAlt1BillAddr5;
	/**
	 *  
	 */
	private String cbAlt1BillCity;
	/**
	 *  
	 */
	private String cbAlt1BillState;
	/**
	 *  
	 */
	private String cbAlt1BillCntryCd;
	/**
	 *  
	 */
	private String cbAlt1BillAddrPostcode;
	/**
	 *  
	 */
	private String cbAlt2BillAddr1;
	/**
	 *  
	 */
	private String cbAlt2BillAddr2;
	/**
	 *  
	 */
	private String cbAlt2BillAddr3;
	/**
	 *  
	 */
	private String cbAlt2BillAddr4;
	/**
	 *  
	 */
	private String cbAlt2BillAddr5;
	/**
	 *  
	 */
	private String cbAlt2BillCity;
	/**
	 *  
	 */
	private String cbAlt2BillCntryCd;
	/**
	 *  
	 */
	private String cbAlt2BillAddrPostcode;
	/**
	 *  
	 */
	private String cbDirectMailInd;
	/**
	 *  语言标志
	 */
	private String cbLanguageInd;
	/**
	 *  照片标志
	 */
	private String cbPhotoInd;
	/**
	 *  客户监控标志
	 */
	private String cbCustMonitorCd;
	/**
	 *  
	 */
	private String cbCustStatusCd;
	/**
	 *  
	 */
	private String cbNricIssuDate;
	/**
	 *  
	 */
	private String cbNricIssuPlace;
	/**
	 *  
	 */
	private String cbDistrict;
	/**
	 *  
	 */
	private String cbCloseDate;
	/**
	 *  
	 */
	private String cbPob;
	/**
	 *  
	 */
	private String cbAttribute;
	/**
	 *  
	 */
	private String cbSourceCd;
	/**
	 *  
	 */
	private String cbRecommenderName;
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
	private java.math.BigDecimal cbUserAmt2;
	/**
	 *  
	 */
	private String cbSmsStatus;
	/**
	 *  
	 */
	private String cbSmsMobileNo;
	/**
	 *  
	 */
	private String cbIbStatus;
	/**
	 *  
	 */
	private String cbMlzoneId;
	/**
	 *  
	 */
	private String cbMlclassId;
	/**
	 *  
	 */
	private String cbEngName;
	/**
	 *  
	 */
	private String checksum;
	/**
	 *  
	 */
	private String cbAlt2billState;
	/**
	 *  
	 */
	private String cbAlt1billAddr1;
	/**
	 *  
	 */
	private String cbAlt1billAddr2;
	/**
	 *  
	 */
	private String cbAlt1billAddr3;
	/**
	 *  
	 */
	private String cbAlt1billAddr4;
	/**
	 *  
	 */
	private String cbAlt1billAddr5;
	/**
	 *  
	 */
	private String cbAlt1billCity;
	/**
	 *  
	 */
	private String cbAlt1billState;
	/**
	 *  
	 */
	private String cbAlt1billCntryCd;
	/**
	 *  
	 */
	private String cbAlt1billAddrPostcode;
	/**
	 *  
	 */
	private String cbAlt2billAddr1;
	/**
	 *  
	 */
	private String cbAlt2billAddr2;
	/**
	 *  
	 */
	private String cbAlt2billAddr3;
	/**
	 *  
	 */
	private String cbAlt2billAddr4;
	/**
	 *  
	 */
	private String cbAlt2billAddr5;
	/**
	 *  
	 */
	private String cbAlt2billCity;
	/**
	 *  
	 */
	private String cbAlt2billCntryCd;
	/**
	 *  
	 */
	private String cbAlt2billAddrPostcode;
	/**
	 * 会员ID
	 * @param cbMemberCode
	 */
	public void setCbMemberCode(String cbMemberCode){
		this.cbMemberCode = cbMemberCode;
	}
	
    /**
     * 会员ID
     * @return
     */	
    public String getCbMemberCode(){
    	return cbMemberCode;
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
	 * 身份证
	 * @param cbCustomerIdno
	 */
	public void setCbCustomerIdno(String cbCustomerIdno){
		this.cbCustomerIdno = cbCustomerIdno;
	}
	
    /**
     * 身份证
     * @return
     */	
    public String getCbCustomerIdno(){
    	return cbCustomerIdno;
    }
	/**
	 * 需与身份证上姓名一致
	 * @param cbCardholderName
	 */
	public void setCbCardholderName(String cbCardholderName){
		this.cbCardholderName = cbCardholderName;
	}
	
    /**
     * 需与身份证上姓名一致
     * @return
     */	
    public String getCbCardholderName(){
    	return cbCardholderName;
    }
	/**
	 * 存放手机号码
	 * @param cbMobileNo
	 */
	public void setCbMobileNo(String cbMobileNo){
		this.cbMobileNo = cbMobileNo;
	}
	
    /**
     * 存放手机号码
     * @return
     */	
    public String getCbMobileNo(){
    	return cbMobileNo;
    }
	/**
	 * 用户密码
	 * @param cbQualification
	 */
	public void setCbQualification(String cbQualification){
		this.cbQualification = cbQualification;
	}
	
    /**
     * 用户密码
     * @return
     */	
    public String getCbQualification(){
    	return cbQualification;
    }
	/**
	 * 电子邮箱
	 * @param cbEmail
	 */
	public void setCbEmail(String cbEmail){
		this.cbEmail = cbEmail;
	}
	
    /**
     * 电子邮箱
     * @return
     */	
    public String getCbEmail(){
    	return cbEmail;
    }
	/**
	 * 性别--1为男，2为女
	 * @param cbSex
	 */
	public void setCbSex(String cbSex){
		this.cbSex = cbSex;
	}
	
    /**
     * 性别--1为男，2为女
     * @return
     */	
    public String getCbSex(){
    	return cbSex;
    }
	/**
	 * 出生日期
	 * @param cbDob
	 */
	public void setCbDob(String cbDob){
		this.cbDob = cbDob;
	}
	
    /**
     * 出生日期
     * @return
     */	
    public String getCbDob(){
    	return cbDob;
    }
	/**
	 * 用户生日
	 * @param cbResidencyCode
	 */
	public void setCbResidencyCode(String cbResidencyCode){
		this.cbResidencyCode = cbResidencyCode;
	}
	
    /**
     * 用户生日
     * @return
     */	
    public String getCbResidencyCode(){
    	return cbResidencyCode;
    }
	/**
	 * 身份类型
	 * @param cbTitle
	 */
	public void setCbTitle(String cbTitle){
		this.cbTitle = cbTitle;
	}
	
    /**
     * 身份类型
     * @return
     */	
    public String getCbTitle(){
    	return cbTitle;
    }
	/**
	 * 国籍
	 * @param cbNationality
	 */
	public void setCbNationality(String cbNationality){
		this.cbNationality = cbNationality;
	}
	
    /**
     * 国籍
     * @return
     */	
    public String getCbNationality(){
    	return cbNationality;
    }
	/**
	 * 余额
	 * @param cbUserAmt1
	 */
	public void setCbUserAmt1(java.math.BigDecimal cbUserAmt1){
		this.cbUserAmt1 = cbUserAmt1;
	}
	
    /**
     * 余额
     * @return
     */	
    public java.math.BigDecimal getCbUserAmt1(){
    	return cbUserAmt1;
    }
	/**
	 * 限额
	 * @param cbCustLimit
	 */
	public void setCbCustLimit(Long cbCustLimit){
		this.cbCustLimit = cbCustLimit;
	}
	
    /**
     * 限额
     * @return
     */	
    public Long getCbCustLimit(){
    	return cbCustLimit;
    }
	/**
	 * 微信ID
	 * @param cbUserCode1
	 */
	public void setCbUserCode1(String cbUserCode1){
		this.cbUserCode1 = cbUserCode1;
	}
	
    /**
     * 微信ID
     * @return
     */	
    public String getCbUserCode1(){
    	return cbUserCode1;
    }
	/**
	 * 支付宝ID
	 * @param cbUserCode2
	 */
	public void setCbUserCode2(String cbUserCode2){
		this.cbUserCode2 = cbUserCode2;
	}
	
    /**
     * 支付宝ID
     * @return
     */	
    public String getCbUserCode2(){
    	return cbUserCode2;
    }
	/**
	 * 新浪微博ID
	 * @param cbUserCode3
	 */
	public void setCbUserCode3(String cbUserCode3){
		this.cbUserCode3 = cbUserCode3;
	}
	
    /**
     * 新浪微博ID
     * @return
     */	
    public String getCbUserCode3(){
    	return cbUserCode3;
    }
	/**
	 * 用户昵称
	 * @param cbUserField1
	 */
	public void setCbUserField1(String cbUserField1){
		this.cbUserField1 = cbUserField1;
	}
	
    /**
     * 用户昵称
     * @return
     */	
    public String getCbUserField1(){
    	return cbUserField1;
    }
	/**
	 * 用户头像保存地址
	 * @param cbUserField2
	 */
	public void setCbUserField2(String cbUserField2){
		this.cbUserField2 = cbUserField2;
	}
	
    /**
     * 用户头像保存地址
     * @return
     */	
    public String getCbUserField2(){
    	return cbUserField2;
    }
	/**
	 * 会员类型
	 * @param cbNricIssuType
	 */
	public void setCbNricIssuType(String cbNricIssuType){
		this.cbNricIssuType = cbNricIssuType;
	}
	
    /**
     * 会员类型
     * @return
     */	
    public String getCbNricIssuType(){
    	return cbNricIssuType;
    }
	/**
	 * 积分
	 * @param cbStopDunn
	 */
	public void setCbStopDunn(String cbStopDunn){
		this.cbStopDunn = cbStopDunn;
	}
	
    /**
     * 积分
     * @return
     */	
    public String getCbStopDunn(){
    	return cbStopDunn;
    }
	/**
	 * 客户号
	 * @param cbCustomerRefNo
	 */
	public void setCbCustomerRefNo(String cbCustomerRefNo){
		this.cbCustomerRefNo = cbCustomerRefNo;
	}
	
    /**
     * 客户号
     * @return
     */	
    public String getCbCustomerRefNo(){
    	return cbCustomerRefNo;
    }
	/**
	 * 会员等级
	 * @param cbNricIssuIdno
	 */
	public void setCbNricIssuIdno(String cbNricIssuIdno){
		this.cbNricIssuIdno = cbNricIssuIdno;
	}
	
    /**
     * 会员等级
     * @return
     */	
    public String getCbNricIssuIdno(){
    	return cbNricIssuIdno;
    }
	/**
	 * 被冻结的余额
	 * @param cbOdGroupid
	 */
	public void setCbOdGroupid(Long cbOdGroupid){
		this.cbOdGroupid = cbOdGroupid;
	}
	
    /**
     * 被冻结的余额
     * @return
     */	
    public Long getCbOdGroupid(){
    	return cbOdGroupid;
    }
	/**
	 * 押金余额
	 * @param cbOpenDate
	 */
	public void setCbOpenDate(String cbOpenDate){
		this.cbOpenDate = cbOpenDate;
	}
	
    /**
     * 押金余额
     * @return
     */	
    public String getCbOpenDate(){
    	return cbOpenDate;
    }
	/**
	 * 所属会员ID
	 * @param cbDepartmentCode
	 */
	public void setCbDepartmentCode(String cbDepartmentCode){
		this.cbDepartmentCode = cbDepartmentCode;
	}
	
    /**
     * 所属会员ID
     * @return
     */	
    public String getCbDepartmentCode(){
    	return cbDepartmentCode;
    }
	/**
	 * 会员状态--1正常,2被冻结，3黑名单
	 * @param cbAlt2BillState
	 */
	public void setCbAlt2BillState(String cbAlt2BillState){
		this.cbAlt2BillState = cbAlt2BillState;
	}
	
    /**
     * 会员状态--1正常,2被冻结，3黑名单
     * @return
     */	
    public String getCbAlt2BillState(){
    	return cbAlt2BillState;
    }
	/**
	 * 绑定的时间
	 * @param cbModDate
	 */
	public void setCbModDate(String cbModDate){
		this.cbModDate = cbModDate;
	}
	
    /**
     * 绑定的时间
     * @return
     */	
    public String getCbModDate(){
    	return cbModDate;
    }
	/**
	 * 更新时间
	 * @param cbModTime
	 */
	public void setCbModTime(String cbModTime){
		this.cbModTime = cbModTime;
	}
	
    /**
     * 更新时间
     * @return
     */	
    public String getCbModTime(){
    	return cbModTime;
    }
	/**
	 * 登陆IP
	 * @param cbRecommenderId
	 */
	public void setCbRecommenderId(String cbRecommenderId){
		this.cbRecommenderId = cbRecommenderId;
	}
	
    /**
     * 登陆IP
     * @return
     */	
    public String getCbRecommenderId(){
    	return cbRecommenderId;
    }
	/**
	 * 常住地址1
	 * @param cbHomeAddr1
	 */
	public void setCbHomeAddr1(String cbHomeAddr1){
		this.cbHomeAddr1 = cbHomeAddr1;
	}
	
    /**
     * 常住地址1
     * @return
     */	
    public String getCbHomeAddr1(){
    	return cbHomeAddr1;
    }
	/**
	 * 家庭地址2
	 * @param cbHomeAddr2
	 */
	public void setCbHomeAddr2(String cbHomeAddr2){
		this.cbHomeAddr2 = cbHomeAddr2;
	}
	
    /**
     * 家庭地址2
     * @return
     */	
    public String getCbHomeAddr2(){
    	return cbHomeAddr2;
    }
	/**
	 * 家庭地址3
	 * @param cbHomeAddr3
	 */
	public void setCbHomeAddr3(String cbHomeAddr3){
		this.cbHomeAddr3 = cbHomeAddr3;
	}
	
    /**
     * 家庭地址3
     * @return
     */	
    public String getCbHomeAddr3(){
    	return cbHomeAddr3;
    }
	/**
	 * 家庭地址4
	 * @param cbHomeAddr4
	 */
	public void setCbHomeAddr4(String cbHomeAddr4){
		this.cbHomeAddr4 = cbHomeAddr4;
	}
	
    /**
     * 家庭地址4
     * @return
     */	
    public String getCbHomeAddr4(){
    	return cbHomeAddr4;
    }
	/**
	 * 家庭地址5
	 * @param cbHomeAddr5
	 */
	public void setCbHomeAddr5(String cbHomeAddr5){
		this.cbHomeAddr5 = cbHomeAddr5;
	}
	
    /**
     * 家庭地址5
     * @return
     */	
    public String getCbHomeAddr5(){
    	return cbHomeAddr5;
    }
	/**
	 * 家庭地址所在城市
	 * @param cbHomeCity
	 */
	public void setCbHomeCity(String cbHomeCity){
		this.cbHomeCity = cbHomeCity;
	}
	
    /**
     * 家庭地址所在城市
     * @return
     */	
    public String getCbHomeCity(){
    	return cbHomeCity;
    }
	/**
	 * 家庭地址所在省
	 * @param cbHomeState
	 */
	public void setCbHomeState(String cbHomeState){
		this.cbHomeState = cbHomeState;
	}
	
    /**
     * 家庭地址所在省
     * @return
     */	
    public String getCbHomeState(){
    	return cbHomeState;
    }
	/**
	 * 家庭地址所在国家
	 * @param cbHomeCntryCd
	 */
	public void setCbHomeCntryCd(String cbHomeCntryCd){
		this.cbHomeCntryCd = cbHomeCntryCd;
	}
	
    /**
     * 家庭地址所在国家
     * @return
     */	
    public String getCbHomeCntryCd(){
    	return cbHomeCntryCd;
    }
	/**
	 * 家庭地址邮政编码
	 * @param cbHomePostcode
	 */
	public void setCbHomePostcode(String cbHomePostcode){
		this.cbHomePostcode = cbHomePostcode;
	}
	
    /**
     * 家庭地址邮政编码
     * @return
     */	
    public String getCbHomePostcode(){
    	return cbHomePostcode;
    }
	/**
	 * 护照
	 * @param cbPassportNo
	 */
	public void setCbPassportNo(String cbPassportNo){
		this.cbPassportNo = cbPassportNo;
	}
	
    /**
     * 护照
     * @return
     */	
    public String getCbPassportNo(){
    	return cbPassportNo;
    }
	/**
	 * 机构号
	 * @param cbBranchId
	 */
	public void setCbBranchId(String cbBranchId){
		this.cbBranchId = cbBranchId;
	}
	
    /**
     * 机构号
     * @return
     */	
    public String getCbBranchId(){
    	return cbBranchId;
    }
	/**
	 * 社会状态
	 * @param cbSocialStatus
	 */
	public void setCbSocialStatus(String cbSocialStatus){
		this.cbSocialStatus = cbSocialStatus;
	}
	
    /**
     * 社会状态
     * @return
     */	
    public String getCbSocialStatus(){
    	return cbSocialStatus;
    }
	/**
	 * 家庭电话
	 * @param cbHomePhone
	 */
	public void setCbHomePhone(String cbHomePhone){
		this.cbHomePhone = cbHomePhone;
	}
	
    /**
     * 家庭电话
     * @return
     */	
    public String getCbHomePhone(){
    	return cbHomePhone;
    }
	/**
	 * Y/N .长期居住
	 * @param cbPrOfCountry
	 */
	public void setCbPrOfCountry(String cbPrOfCountry){
		this.cbPrOfCountry = cbPrOfCountry;
	}
	
    /**
     * Y/N .长期居住
     * @return
     */	
    public String getCbPrOfCountry(){
    	return cbPrOfCountry;
    }
	/**
	 * 婚姻状态
	 * @param cbMaritalStatus
	 */
	public void setCbMaritalStatus(String cbMaritalStatus){
		this.cbMaritalStatus = cbMaritalStatus;
	}
	
    /**
     * 婚姻状态
     * @return
     */	
    public String getCbMaritalStatus(){
    	return cbMaritalStatus;
    }
	/**
	 * 住房拥有情况
	 * @param cbHomeOwnership
	 */
	public void setCbHomeOwnership(String cbHomeOwnership){
		this.cbHomeOwnership = cbHomeOwnership;
	}
	
    /**
     * 住房拥有情况
     * @return
     */	
    public String getCbHomeOwnership(){
    	return cbHomeOwnership;
    }
	/**
	 * 房屋类型
	 * @param cbHouseType
	 */
	public void setCbHouseType(String cbHouseType){
		this.cbHouseType = cbHouseType;
	}
	
    /**
     * 房屋类型
     * @return
     */	
    public String getCbHouseType(){
    	return cbHouseType;
    }
	/**
	 * 居住年数
	 * @param cbYearThere
	 */
	public void setCbYearThere(Long cbYearThere){
		this.cbYearThere = cbYearThere;
	}
	
    /**
     * 居住年数
     * @return
     */	
    public Long getCbYearThere(){
    	return cbYearThere;
    }
	/**
	 * 流动资产
	 * @param cbLiquidAsset
	 */
	public void setCbLiquidAsset(String cbLiquidAsset){
		this.cbLiquidAsset = cbLiquidAsset;
	}
	
    /**
     * 流动资产
     * @return
     */	
    public String getCbLiquidAsset(){
    	return cbLiquidAsset;
    }
	/**
	 * 传呼号
	 * @param cbPagerNo
	 */
	public void setCbPagerNo(String cbPagerNo){
		this.cbPagerNo = cbPagerNo;
	}
	
    /**
     * 传呼号
     * @return
     */	
    public String getCbPagerNo(){
    	return cbPagerNo;
    }
	/**
	 * 公司名称
	 * @param cbCompanyName
	 */
	public void setCbCompanyName(String cbCompanyName){
		this.cbCompanyName = cbCompanyName;
	}
	
    /**
     * 公司名称
     * @return
     */	
    public String getCbCompanyName(){
    	return cbCompanyName;
    }
	/**
	 * 公司地址1
	 * @param cbCoAddr1
	 */
	public void setCbCoAddr1(String cbCoAddr1){
		this.cbCoAddr1 = cbCoAddr1;
	}
	
    /**
     * 公司地址1
     * @return
     */	
    public String getCbCoAddr1(){
    	return cbCoAddr1;
    }
	/**
	 * 公司地址2
	 * @param cbCoAddr2
	 */
	public void setCbCoAddr2(String cbCoAddr2){
		this.cbCoAddr2 = cbCoAddr2;
	}
	
    /**
     * 公司地址2
     * @return
     */	
    public String getCbCoAddr2(){
    	return cbCoAddr2;
    }
	/**
	 * 公司地址3
	 * @param cbCoAddr3
	 */
	public void setCbCoAddr3(String cbCoAddr3){
		this.cbCoAddr3 = cbCoAddr3;
	}
	
    /**
     * 公司地址3
     * @return
     */	
    public String getCbCoAddr3(){
    	return cbCoAddr3;
    }
	/**
	 * 公司地址4
	 * @param cbCoAddr4
	 */
	public void setCbCoAddr4(String cbCoAddr4){
		this.cbCoAddr4 = cbCoAddr4;
	}
	
    /**
     * 公司地址4
     * @return
     */	
    public String getCbCoAddr4(){
    	return cbCoAddr4;
    }
	/**
	 * 公司地址5
	 * @param cbCoAddr5
	 */
	public void setCbCoAddr5(String cbCoAddr5){
		this.cbCoAddr5 = cbCoAddr5;
	}
	
    /**
     * 公司地址5
     * @return
     */	
    public String getCbCoAddr5(){
    	return cbCoAddr5;
    }
	/**
	 * 公司所在城市
	 * @param cbCoCity
	 */
	public void setCbCoCity(String cbCoCity){
		this.cbCoCity = cbCoCity;
	}
	
    /**
     * 公司所在城市
     * @return
     */	
    public String getCbCoCity(){
    	return cbCoCity;
    }
	/**
	 * 公司所在省
	 * @param cbCoState
	 */
	public void setCbCoState(String cbCoState){
		this.cbCoState = cbCoState;
	}
	
    /**
     * 公司所在省
     * @return
     */	
    public String getCbCoState(){
    	return cbCoState;
    }
	/**
	 * 公司所在国家
	 * @param cbCoCntryCd
	 */
	public void setCbCoCntryCd(String cbCoCntryCd){
		this.cbCoCntryCd = cbCoCntryCd;
	}
	
    /**
     * 公司所在国家
     * @return
     */	
    public String getCbCoCntryCd(){
    	return cbCoCntryCd;
    }
	/**
	 * 公司邮编
	 * @param cbCoPostcode
	 */
	public void setCbCoPostcode(String cbCoPostcode){
		this.cbCoPostcode = cbCoPostcode;
	}
	
    /**
     * 公司邮编
     * @return
     */	
    public String getCbCoPostcode(){
    	return cbCoPostcode;
    }
	/**
	 * 公司电话
	 * @param cbCoPhone
	 */
	public void setCbCoPhone(String cbCoPhone){
		this.cbCoPhone = cbCoPhone;
	}
	
    /**
     * 公司电话
     * @return
     */	
    public String getCbCoPhone(){
    	return cbCoPhone;
    }
	/**
	 * 公司传真
	 * @param cbCoFaxno
	 */
	public void setCbCoFaxno(String cbCoFaxno){
		this.cbCoFaxno = cbCoFaxno;
	}
	
    /**
     * 公司传真
     * @return
     */	
    public String getCbCoFaxno(){
    	return cbCoFaxno;
    }
	/**
	 * 职务
	 * @param cbCoDesgn
	 */
	public void setCbCoDesgn(String cbCoDesgn){
		this.cbCoDesgn = cbCoDesgn;
	}
	
    /**
     * 职务
     * @return
     */	
    public String getCbCoDesgn(){
    	return cbCoDesgn;
    }
	/**
	 * 公司架构
	 * @param cbCompStructure
	 */
	public void setCbCompStructure(String cbCompStructure){
		this.cbCompStructure = cbCompStructure;
	}
	
    /**
     * 公司架构
     * @return
     */	
    public String getCbCompStructure(){
    	return cbCompStructure;
    }
	/**
	 * 工作稳定性
	 * @param cbEmpStability
	 */
	public void setCbEmpStability(String cbEmpStability){
		this.cbEmpStability = cbEmpStability;
	}
	
    /**
     * 工作稳定性
     * @return
     */	
    public String getCbEmpStability(){
    	return cbEmpStability;
    }
	/**
	 * 月基本收入
	 * @param cbMthBasicSalary
	 */
	public void setCbMthBasicSalary(Long cbMthBasicSalary){
		this.cbMthBasicSalary = cbMthBasicSalary;
	}
	
    /**
     * 月基本收入
     * @return
     */	
    public Long getCbMthBasicSalary(){
    	return cbMthBasicSalary;
    }
	/**
	 * 月津贴
	 * @param cbMthFixedAllow
	 */
	public void setCbMthFixedAllow(Long cbMthFixedAllow){
		this.cbMthFixedAllow = cbMthFixedAllow;
	}
	
    /**
     * 月津贴
     * @return
     */	
    public Long getCbMthFixedAllow(){
    	return cbMthFixedAllow;
    }
	/**
	 * 其他收入
	 * @param cbOtherIncome
	 */
	public void setCbOtherIncome(Long cbOtherIncome){
		this.cbOtherIncome = cbOtherIncome;
	}
	
    /**
     * 其他收入
     * @return
     */	
    public Long getCbOtherIncome(){
    	return cbOtherIncome;
    }
	/**
	 * 服务年数
	 * @param cbLengthSrv
	 */
	public void setCbLengthSrv(Long cbLengthSrv){
		this.cbLengthSrv = cbLengthSrv;
	}
	
    /**
     * 服务年数
     * @return
     */	
    public Long getCbLengthSrv(){
    	return cbLengthSrv;
    }
	/**
	 * 是否自我雇佣
	 * @param cbSelfEmploy
	 */
	public void setCbSelfEmploy(String cbSelfEmploy){
		this.cbSelfEmploy = cbSelfEmploy;
	}
	
    /**
     * 是否自我雇佣
     * @return
     */	
    public String getCbSelfEmploy(){
    	return cbSelfEmploy;
    }
	/**
	 * 行业代码
	 * @param cbBussSic
	 */
	public void setCbBussSic(String cbBussSic){
		this.cbBussSic = cbBussSic;
	}
	
    /**
     * 行业代码
     * @return
     */	
    public String getCbBussSic(){
    	return cbBussSic;
    }
	/**
	 * 上个公司名称
	 * @param cbExEmployName
	 */
	public void setCbExEmployName(String cbExEmployName){
		this.cbExEmployName = cbExEmployName;
	}
	
    /**
     * 上个公司名称
     * @return
     */	
    public String getCbExEmployName(){
    	return cbExEmployName;
    }
	/**
	 * 上个公司工作年数
	 * @param cbExLengthService
	 */
	public void setCbExLengthService(Long cbExLengthService){
		this.cbExLengthService = cbExLengthService;
	}
	
    /**
     * 上个公司工作年数
     * @return
     */	
    public Long getCbExLengthService(){
    	return cbExLengthService;
    }
	/**
	 * 上个公司职务
	 * @param cbExEmployDesgn
	 */
	public void setCbExEmployDesgn(String cbExEmployDesgn){
		this.cbExEmployDesgn = cbExEmployDesgn;
	}
	
    /**
     * 上个公司职务
     * @return
     */	
    public String getCbExEmployDesgn(){
    	return cbExEmployDesgn;
    }
	/**
	 * 其他贷款银行1
	 * @param cbOthLoanBank1
	 */
	public void setCbOthLoanBank1(String cbOthLoanBank1){
		this.cbOthLoanBank1 = cbOthLoanBank1;
	}
	
    /**
     * 其他贷款银行1
     * @return
     */	
    public String getCbOthLoanBank1(){
    	return cbOthLoanBank1;
    }
	/**
	 * 其他贷款类型1
	 * @param cbOthLoanType1
	 */
	public void setCbOthLoanType1(String cbOthLoanType1){
		this.cbOthLoanType1 = cbOthLoanType1;
	}
	
    /**
     * 其他贷款类型1
     * @return
     */	
    public String getCbOthLoanType1(){
    	return cbOthLoanType1;
    }
	/**
	 * 其他贷款金额1
	 * @param cbOthLoanAmt1
	 */
	public void setCbOthLoanAmt1(Long cbOthLoanAmt1){
		this.cbOthLoanAmt1 = cbOthLoanAmt1;
	}
	
    /**
     * 其他贷款金额1
     * @return
     */	
    public Long getCbOthLoanAmt1(){
    	return cbOthLoanAmt1;
    }
	/**
	 * 其他贷款银行2
	 * @param cbOthLoanBank2
	 */
	public void setCbOthLoanBank2(String cbOthLoanBank2){
		this.cbOthLoanBank2 = cbOthLoanBank2;
	}
	
    /**
     * 其他贷款银行2
     * @return
     */	
    public String getCbOthLoanBank2(){
    	return cbOthLoanBank2;
    }
	/**
	 * 其他贷款类型2
	 * @param cbOthLoanType2
	 */
	public void setCbOthLoanType2(String cbOthLoanType2){
		this.cbOthLoanType2 = cbOthLoanType2;
	}
	
    /**
     * 其他贷款类型2
     * @return
     */	
    public String getCbOthLoanType2(){
    	return cbOthLoanType2;
    }
	/**
	 * 其他贷款金额2
	 * @param cbOthLoanAmt2
	 */
	public void setCbOthLoanAmt2(Long cbOthLoanAmt2){
		this.cbOthLoanAmt2 = cbOthLoanAmt2;
	}
	
    /**
     * 其他贷款金额2
     * @return
     */	
    public Long getCbOthLoanAmt2(){
    	return cbOthLoanAmt2;
    }
	/**
	 * 其他贷款银行3
	 * @param cbOthLoanBank3
	 */
	public void setCbOthLoanBank3(String cbOthLoanBank3){
		this.cbOthLoanBank3 = cbOthLoanBank3;
	}
	
    /**
     * 其他贷款银行3
     * @return
     */	
    public String getCbOthLoanBank3(){
    	return cbOthLoanBank3;
    }
	/**
	 * 其他贷款类型3
	 * @param cbOthLoanType3
	 */
	public void setCbOthLoanType3(String cbOthLoanType3){
		this.cbOthLoanType3 = cbOthLoanType3;
	}
	
    /**
     * 其他贷款类型3
     * @return
     */	
    public String getCbOthLoanType3(){
    	return cbOthLoanType3;
    }
	/**
	 * 其他贷款金额3
	 * @param cbOthLoanAmt3
	 */
	public void setCbOthLoanAmt3(Long cbOthLoanAmt3){
		this.cbOthLoanAmt3 = cbOthLoanAmt3;
	}
	
    /**
     * 其他贷款金额3
     * @return
     */	
    public Long getCbOthLoanAmt3(){
    	return cbOthLoanAmt3;
    }
	/**
	 * 贷记卡号1
	 * @param cbCrCardNo1
	 */
	public void setCbCrCardNo1(String cbCrCardNo1){
		this.cbCrCardNo1 = cbCrCardNo1;
	}
	
    /**
     * 贷记卡号1
     * @return
     */	
    public String getCbCrCardNo1(){
    	return cbCrCardNo1;
    }
	/**
	 * 贷记卡号2
	 * @param cbCrCardNo2
	 */
	public void setCbCrCardNo2(String cbCrCardNo2){
		this.cbCrCardNo2 = cbCrCardNo2;
	}
	
    /**
     * 贷记卡号2
     * @return
     */	
    public String getCbCrCardNo2(){
    	return cbCrCardNo2;
    }
	/**
	 * 透支限额1
	 * @param cbCrCardLimit1
	 */
	public void setCbCrCardLimit1(Long cbCrCardLimit1){
		this.cbCrCardLimit1 = cbCrCardLimit1;
	}
	
    /**
     * 透支限额1
     * @return
     */	
    public Long getCbCrCardLimit1(){
    	return cbCrCardLimit1;
    }
	/**
	 * 透支限额2
	 * @param cbCrCardLimit2
	 */
	public void setCbCrCardLimit2(Long cbCrCardLimit2){
		this.cbCrCardLimit2 = cbCrCardLimit2;
	}
	
    /**
     * 透支限额2
     * @return
     */	
    public Long getCbCrCardLimit2(){
    	return cbCrCardLimit2;
    }
	/**
	 * 贷记卡号3
	 * @param cbCrCardNo3
	 */
	public void setCbCrCardNo3(String cbCrCardNo3){
		this.cbCrCardNo3 = cbCrCardNo3;
	}
	
    /**
     * 贷记卡号3
     * @return
     */	
    public String getCbCrCardNo3(){
    	return cbCrCardNo3;
    }
	/**
	 * 透支限额3
	 * @param cbCrCardLimit3
	 */
	public void setCbCrCardLimit3(Long cbCrCardLimit3){
		this.cbCrCardLimit3 = cbCrCardLimit3;
	}
	
    /**
     * 透支限额3
     * @return
     */	
    public Long getCbCrCardLimit3(){
    	return cbCrCardLimit3;
    }
	/**
	 * 其他银行借贷状态
	 * @param cbOthBankCrStatus
	 */
	public void setCbOthBankCrStatus(String cbOthBankCrStatus){
		this.cbOthBankCrStatus = cbOthBankCrStatus;
	}
	
    /**
     * 其他银行借贷状态
     * @return
     */	
    public String getCbOthBankCrStatus(){
    	return cbOthBankCrStatus;
    }
	/**
	 * 母亲姓名
	 * @param cbMotherName
	 */
	public void setCbMotherName(String cbMotherName){
		this.cbMotherName = cbMotherName;
	}
	
    /**
     * 母亲姓名
     * @return
     */	
    public String getCbMotherName(){
    	return cbMotherName;
    }
	/**
	 * 配偶姓名
	 * @param cbSpouseName
	 */
	public void setCbSpouseName(String cbSpouseName){
		this.cbSpouseName = cbSpouseName;
	}
	
    /**
     * 配偶姓名
     * @return
     */	
    public String getCbSpouseName(){
    	return cbSpouseName;
    }
	/**
	 * 配偶证件号
	 * @param cbSpouseNric
	 */
	public void setCbSpouseNric(String cbSpouseNric){
		this.cbSpouseNric = cbSpouseNric;
	}
	
    /**
     * 配偶证件号
     * @return
     */	
    public String getCbSpouseNric(){
    	return cbSpouseNric;
    }
	/**
	 * 配偶工作公司名
	 * @param cbSpouseEmployName
	 */
	public void setCbSpouseEmployName(String cbSpouseEmployName){
		this.cbSpouseEmployName = cbSpouseEmployName;
	}
	
    /**
     * 配偶工作公司名
     * @return
     */	
    public String getCbSpouseEmployName(){
    	return cbSpouseEmployName;
    }
	/**
	 * 抚养人数
	 * @param cbNoOfDependents
	 */
	public void setCbNoOfDependents(Long cbNoOfDependents){
		this.cbNoOfDependents = cbNoOfDependents;
	}
	
    /**
     * 抚养人数
     * @return
     */	
    public Long getCbNoOfDependents(){
    	return cbNoOfDependents;
    }
	/**
	 * 联系人姓名
	 * @param cbRelName
	 */
	public void setCbRelName(String cbRelName){
		this.cbRelName = cbRelName;
	}
	
    /**
     * 联系人姓名
     * @return
     */	
    public String getCbRelName(){
    	return cbRelName;
    }
	/**
	 * 联系人证件号
	 * @param cbRelNric
	 */
	public void setCbRelNric(String cbRelNric){
		this.cbRelNric = cbRelNric;
	}
	
    /**
     * 联系人证件号
     * @return
     */	
    public String getCbRelNric(){
    	return cbRelNric;
    }
	/**
	 * 联系人生日
	 * @param cbRelDob
	 */
	public void setCbRelDob(String cbRelDob){
		this.cbRelDob = cbRelDob;
	}
	
    /**
     * 联系人生日
     * @return
     */	
    public String getCbRelDob(){
    	return cbRelDob;
    }
	/**
	 * 联系人性别
	 * @param cbRelSex
	 */
	public void setCbRelSex(String cbRelSex){
		this.cbRelSex = cbRelSex;
	}
	
    /**
     * 联系人性别
     * @return
     */	
    public String getCbRelSex(){
    	return cbRelSex;
    }
	/**
	 * 与持卡人关系
	 * @param cbRelRelationToCh
	 */
	public void setCbRelRelationToCh(String cbRelRelationToCh){
		this.cbRelRelationToCh = cbRelRelationToCh;
	}
	
    /**
     * 与持卡人关系
     * @return
     */	
    public String getCbRelRelationToCh(){
    	return cbRelRelationToCh;
    }
	/**
	 * 联系人职务
	 * @param cbRelDesgn
	 */
	public void setCbRelDesgn(String cbRelDesgn){
		this.cbRelDesgn = cbRelDesgn;
	}
	
    /**
     * 联系人职务
     * @return
     */	
    public String getCbRelDesgn(){
    	return cbRelDesgn;
    }
	/**
	 * 联系地址-1
	 * @param cbRelAddr1
	 */
	public void setCbRelAddr1(String cbRelAddr1){
		this.cbRelAddr1 = cbRelAddr1;
	}
	
    /**
     * 联系地址-1
     * @return
     */	
    public String getCbRelAddr1(){
    	return cbRelAddr1;
    }
	/**
	 * 联系地址-2
	 * @param cbRelAddr2
	 */
	public void setCbRelAddr2(String cbRelAddr2){
		this.cbRelAddr2 = cbRelAddr2;
	}
	
    /**
     * 联系地址-2
     * @return
     */	
    public String getCbRelAddr2(){
    	return cbRelAddr2;
    }
	/**
	 * 联系地址-3
	 * @param cbRelAddr3
	 */
	public void setCbRelAddr3(String cbRelAddr3){
		this.cbRelAddr3 = cbRelAddr3;
	}
	
    /**
     * 联系地址-3
     * @return
     */	
    public String getCbRelAddr3(){
    	return cbRelAddr3;
    }
	/**
	 * 联系地址-4
	 * @param cbRelAddr4
	 */
	public void setCbRelAddr4(String cbRelAddr4){
		this.cbRelAddr4 = cbRelAddr4;
	}
	
    /**
     * 联系地址-4
     * @return
     */	
    public String getCbRelAddr4(){
    	return cbRelAddr4;
    }
	/**
	 * 联系地址-5
	 * @param cbRelAddr5
	 */
	public void setCbRelAddr5(String cbRelAddr5){
		this.cbRelAddr5 = cbRelAddr5;
	}
	
    /**
     * 联系地址-5
     * @return
     */	
    public String getCbRelAddr5(){
    	return cbRelAddr5;
    }
	/**
	 * 联系人所在城市
	 * @param cbRelCity
	 */
	public void setCbRelCity(String cbRelCity){
		this.cbRelCity = cbRelCity;
	}
	
    /**
     * 联系人所在城市
     * @return
     */	
    public String getCbRelCity(){
    	return cbRelCity;
    }
	/**
	 * 联系人所在省
	 * @param cbRelState
	 */
	public void setCbRelState(String cbRelState){
		this.cbRelState = cbRelState;
	}
	
    /**
     * 联系人所在省
     * @return
     */	
    public String getCbRelState(){
    	return cbRelState;
    }
	/**
	 * 联系人所在国家
	 * @param cbRelCntryCd
	 */
	public void setCbRelCntryCd(String cbRelCntryCd){
		this.cbRelCntryCd = cbRelCntryCd;
	}
	
    /**
     * 联系人所在国家
     * @return
     */	
    public String getCbRelCntryCd(){
    	return cbRelCntryCd;
    }
	/**
	 * 联系人电话
	 * @param cbRelTelno
	 */
	public void setCbRelTelno(String cbRelTelno){
		this.cbRelTelno = cbRelTelno;
	}
	
    /**
     * 联系人电话
     * @return
     */	
    public String getCbRelTelno(){
    	return cbRelTelno;
    }
	/**
	 * 客户级别
	 * @param cbCustClass
	 */
	public void setCbCustClass(String cbCustClass){
		this.cbCustClass = cbCustClass;
	}
	
    /**
     * 客户级别
     * @return
     */	
    public String getCbCustClass(){
    	return cbCustClass;
    }
	/**
	 * 兴趣组
	 * @param cbInterestGrpCode
	 */
	public void setCbInterestGrpCode(String cbInterestGrpCode){
		this.cbInterestGrpCode = cbInterestGrpCode;
	}
	
    /**
     * 兴趣组
     * @return
     */	
    public String getCbInterestGrpCode(){
    	return cbInterestGrpCode;
    }
	/**
	 * 其他地址1
	 * @param cbAlt1BillAddr1
	 */
	public void setCbAlt1BillAddr1(String cbAlt1BillAddr1){
		this.cbAlt1BillAddr1 = cbAlt1BillAddr1;
	}
	
    /**
     * 其他地址1
     * @return
     */	
    public String getCbAlt1BillAddr1(){
    	return cbAlt1BillAddr1;
    }
	/**
	 * 其他地址2
	 * @param cbAlt1BillAddr2
	 */
	public void setCbAlt1BillAddr2(String cbAlt1BillAddr2){
		this.cbAlt1BillAddr2 = cbAlt1BillAddr2;
	}
	
    /**
     * 其他地址2
     * @return
     */	
    public String getCbAlt1BillAddr2(){
    	return cbAlt1BillAddr2;
    }
	/**
	 * 其他地址3
	 * @param cbAlt1BillAddr3
	 */
	public void setCbAlt1BillAddr3(String cbAlt1BillAddr3){
		this.cbAlt1BillAddr3 = cbAlt1BillAddr3;
	}
	
    /**
     * 其他地址3
     * @return
     */	
    public String getCbAlt1BillAddr3(){
    	return cbAlt1BillAddr3;
    }
	/**
	 * 其他地址4
	 * @param cbAlt1BillAddr4
	 */
	public void setCbAlt1BillAddr4(String cbAlt1BillAddr4){
		this.cbAlt1BillAddr4 = cbAlt1BillAddr4;
	}
	
    /**
     * 其他地址4
     * @return
     */	
    public String getCbAlt1BillAddr4(){
    	return cbAlt1BillAddr4;
    }
	/**
	 * 其他地址5
	 * @param cbAlt1BillAddr5
	 */
	public void setCbAlt1BillAddr5(String cbAlt1BillAddr5){
		this.cbAlt1BillAddr5 = cbAlt1BillAddr5;
	}
	
    /**
     * 其他地址5
     * @return
     */	
    public String getCbAlt1BillAddr5(){
    	return cbAlt1BillAddr5;
    }
	/**
	 * 
	 * @param cbAlt1BillCity
	 */
	public void setCbAlt1BillCity(String cbAlt1BillCity){
		this.cbAlt1BillCity = cbAlt1BillCity;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1BillCity(){
    	return cbAlt1BillCity;
    }
	/**
	 * 
	 * @param cbAlt1BillState
	 */
	public void setCbAlt1BillState(String cbAlt1BillState){
		this.cbAlt1BillState = cbAlt1BillState;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1BillState(){
    	return cbAlt1BillState;
    }
	/**
	 * 
	 * @param cbAlt1BillCntryCd
	 */
	public void setCbAlt1BillCntryCd(String cbAlt1BillCntryCd){
		this.cbAlt1BillCntryCd = cbAlt1BillCntryCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1BillCntryCd(){
    	return cbAlt1BillCntryCd;
    }
	/**
	 * 
	 * @param cbAlt1BillAddrPostcode
	 */
	public void setCbAlt1BillAddrPostcode(String cbAlt1BillAddrPostcode){
		this.cbAlt1BillAddrPostcode = cbAlt1BillAddrPostcode;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1BillAddrPostcode(){
    	return cbAlt1BillAddrPostcode;
    }
	/**
	 * 
	 * @param cbAlt2BillAddr1
	 */
	public void setCbAlt2BillAddr1(String cbAlt2BillAddr1){
		this.cbAlt2BillAddr1 = cbAlt2BillAddr1;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillAddr1(){
    	return cbAlt2BillAddr1;
    }
	/**
	 * 
	 * @param cbAlt2BillAddr2
	 */
	public void setCbAlt2BillAddr2(String cbAlt2BillAddr2){
		this.cbAlt2BillAddr2 = cbAlt2BillAddr2;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillAddr2(){
    	return cbAlt2BillAddr2;
    }
	/**
	 * 
	 * @param cbAlt2BillAddr3
	 */
	public void setCbAlt2BillAddr3(String cbAlt2BillAddr3){
		this.cbAlt2BillAddr3 = cbAlt2BillAddr3;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillAddr3(){
    	return cbAlt2BillAddr3;
    }
	/**
	 * 
	 * @param cbAlt2BillAddr4
	 */
	public void setCbAlt2BillAddr4(String cbAlt2BillAddr4){
		this.cbAlt2BillAddr4 = cbAlt2BillAddr4;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillAddr4(){
    	return cbAlt2BillAddr4;
    }
	/**
	 * 
	 * @param cbAlt2BillAddr5
	 */
	public void setCbAlt2BillAddr5(String cbAlt2BillAddr5){
		this.cbAlt2BillAddr5 = cbAlt2BillAddr5;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillAddr5(){
    	return cbAlt2BillAddr5;
    }
	/**
	 * 
	 * @param cbAlt2BillCity
	 */
	public void setCbAlt2BillCity(String cbAlt2BillCity){
		this.cbAlt2BillCity = cbAlt2BillCity;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillCity(){
    	return cbAlt2BillCity;
    }
	/**
	 * 
	 * @param cbAlt2BillCntryCd
	 */
	public void setCbAlt2BillCntryCd(String cbAlt2BillCntryCd){
		this.cbAlt2BillCntryCd = cbAlt2BillCntryCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillCntryCd(){
    	return cbAlt2BillCntryCd;
    }
	/**
	 * 
	 * @param cbAlt2BillAddrPostcode
	 */
	public void setCbAlt2BillAddrPostcode(String cbAlt2BillAddrPostcode){
		this.cbAlt2BillAddrPostcode = cbAlt2BillAddrPostcode;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2BillAddrPostcode(){
    	return cbAlt2BillAddrPostcode;
    }
	/**
	 * 
	 * @param cbDirectMailInd
	 */
	public void setCbDirectMailInd(String cbDirectMailInd){
		this.cbDirectMailInd = cbDirectMailInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbDirectMailInd(){
    	return cbDirectMailInd;
    }
	/**
	 * 语言标志
	 * @param cbLanguageInd
	 */
	public void setCbLanguageInd(String cbLanguageInd){
		this.cbLanguageInd = cbLanguageInd;
	}
	
    /**
     * 语言标志
     * @return
     */	
    public String getCbLanguageInd(){
    	return cbLanguageInd;
    }
	/**
	 * 照片标志
	 * @param cbPhotoInd
	 */
	public void setCbPhotoInd(String cbPhotoInd){
		this.cbPhotoInd = cbPhotoInd;
	}
	
    /**
     * 照片标志
     * @return
     */	
    public String getCbPhotoInd(){
    	return cbPhotoInd;
    }
	/**
	 * 客户监控标志
	 * @param cbCustMonitorCd
	 */
	public void setCbCustMonitorCd(String cbCustMonitorCd){
		this.cbCustMonitorCd = cbCustMonitorCd;
	}
	
    /**
     * 客户监控标志
     * @return
     */	
    public String getCbCustMonitorCd(){
    	return cbCustMonitorCd;
    }
	/**
	 * 
	 * @param cbCustStatusCd
	 */
	public void setCbCustStatusCd(String cbCustStatusCd){
		this.cbCustStatusCd = cbCustStatusCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCustStatusCd(){
    	return cbCustStatusCd;
    }
	/**
	 * 
	 * @param cbNricIssuDate
	 */
	public void setCbNricIssuDate(String cbNricIssuDate){
		this.cbNricIssuDate = cbNricIssuDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbNricIssuDate(){
    	return cbNricIssuDate;
    }
	/**
	 * 
	 * @param cbNricIssuPlace
	 */
	public void setCbNricIssuPlace(String cbNricIssuPlace){
		this.cbNricIssuPlace = cbNricIssuPlace;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbNricIssuPlace(){
    	return cbNricIssuPlace;
    }
	/**
	 * 
	 * @param cbDistrict
	 */
	public void setCbDistrict(String cbDistrict){
		this.cbDistrict = cbDistrict;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbDistrict(){
    	return cbDistrict;
    }
	/**
	 * 
	 * @param cbCloseDate
	 */
	public void setCbCloseDate(String cbCloseDate){
		this.cbCloseDate = cbCloseDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbCloseDate(){
    	return cbCloseDate;
    }
	/**
	 * 
	 * @param cbPob
	 */
	public void setCbPob(String cbPob){
		this.cbPob = cbPob;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbPob(){
    	return cbPob;
    }
	/**
	 * 
	 * @param cbAttribute
	 */
	public void setCbAttribute(String cbAttribute){
		this.cbAttribute = cbAttribute;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAttribute(){
    	return cbAttribute;
    }
	/**
	 * 
	 * @param cbSourceCd
	 */
	public void setCbSourceCd(String cbSourceCd){
		this.cbSourceCd = cbSourceCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbSourceCd(){
    	return cbSourceCd;
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
	 * @param cbSmsStatus
	 */
	public void setCbSmsStatus(String cbSmsStatus){
		this.cbSmsStatus = cbSmsStatus;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbSmsStatus(){
    	return cbSmsStatus;
    }
	/**
	 * 
	 * @param cbSmsMobileNo
	 */
	public void setCbSmsMobileNo(String cbSmsMobileNo){
		this.cbSmsMobileNo = cbSmsMobileNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbSmsMobileNo(){
    	return cbSmsMobileNo;
    }
	/**
	 * 
	 * @param cbIbStatus
	 */
	public void setCbIbStatus(String cbIbStatus){
		this.cbIbStatus = cbIbStatus;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbIbStatus(){
    	return cbIbStatus;
    }
	/**
	 * 
	 * @param cbMlzoneId
	 */
	public void setCbMlzoneId(String cbMlzoneId){
		this.cbMlzoneId = cbMlzoneId;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbMlzoneId(){
    	return cbMlzoneId;
    }
	/**
	 * 
	 * @param cbMlclassId
	 */
	public void setCbMlclassId(String cbMlclassId){
		this.cbMlclassId = cbMlclassId;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbMlclassId(){
    	return cbMlclassId;
    }
	/**
	 * 
	 * @param cbEngName
	 */
	public void setCbEngName(String cbEngName){
		this.cbEngName = cbEngName;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbEngName(){
    	return cbEngName;
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
	/**
	 * 
	 * @param cbAlt2billState
	 */
	public void setCbAlt2billState(String cbAlt2billState){
		this.cbAlt2billState = cbAlt2billState;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billState(){
    	return cbAlt2billState;
    }
	/**
	 * 
	 * @param cbAlt1billAddr1
	 */
	public void setCbAlt1billAddr1(String cbAlt1billAddr1){
		this.cbAlt1billAddr1 = cbAlt1billAddr1;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billAddr1(){
    	return cbAlt1billAddr1;
    }
	/**
	 * 
	 * @param cbAlt1billAddr2
	 */
	public void setCbAlt1billAddr2(String cbAlt1billAddr2){
		this.cbAlt1billAddr2 = cbAlt1billAddr2;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billAddr2(){
    	return cbAlt1billAddr2;
    }
	/**
	 * 
	 * @param cbAlt1billAddr3
	 */
	public void setCbAlt1billAddr3(String cbAlt1billAddr3){
		this.cbAlt1billAddr3 = cbAlt1billAddr3;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billAddr3(){
    	return cbAlt1billAddr3;
    }
	/**
	 * 
	 * @param cbAlt1billAddr4
	 */
	public void setCbAlt1billAddr4(String cbAlt1billAddr4){
		this.cbAlt1billAddr4 = cbAlt1billAddr4;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billAddr4(){
    	return cbAlt1billAddr4;
    }
	/**
	 * 
	 * @param cbAlt1billAddr5
	 */
	public void setCbAlt1billAddr5(String cbAlt1billAddr5){
		this.cbAlt1billAddr5 = cbAlt1billAddr5;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billAddr5(){
    	return cbAlt1billAddr5;
    }
	/**
	 * 
	 * @param cbAlt1billCity
	 */
	public void setCbAlt1billCity(String cbAlt1billCity){
		this.cbAlt1billCity = cbAlt1billCity;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billCity(){
    	return cbAlt1billCity;
    }
	/**
	 * 
	 * @param cbAlt1billState
	 */
	public void setCbAlt1billState(String cbAlt1billState){
		this.cbAlt1billState = cbAlt1billState;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billState(){
    	return cbAlt1billState;
    }
	/**
	 * 
	 * @param cbAlt1billCntryCd
	 */
	public void setCbAlt1billCntryCd(String cbAlt1billCntryCd){
		this.cbAlt1billCntryCd = cbAlt1billCntryCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billCntryCd(){
    	return cbAlt1billCntryCd;
    }
	/**
	 * 
	 * @param cbAlt1billAddrPostcode
	 */
	public void setCbAlt1billAddrPostcode(String cbAlt1billAddrPostcode){
		this.cbAlt1billAddrPostcode = cbAlt1billAddrPostcode;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt1billAddrPostcode(){
    	return cbAlt1billAddrPostcode;
    }
	/**
	 * 
	 * @param cbAlt2billAddr1
	 */
	public void setCbAlt2billAddr1(String cbAlt2billAddr1){
		this.cbAlt2billAddr1 = cbAlt2billAddr1;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billAddr1(){
    	return cbAlt2billAddr1;
    }
	/**
	 * 
	 * @param cbAlt2billAddr2
	 */
	public void setCbAlt2billAddr2(String cbAlt2billAddr2){
		this.cbAlt2billAddr2 = cbAlt2billAddr2;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billAddr2(){
    	return cbAlt2billAddr2;
    }
	/**
	 * 
	 * @param cbAlt2billAddr3
	 */
	public void setCbAlt2billAddr3(String cbAlt2billAddr3){
		this.cbAlt2billAddr3 = cbAlt2billAddr3;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billAddr3(){
    	return cbAlt2billAddr3;
    }
	/**
	 * 
	 * @param cbAlt2billAddr4
	 */
	public void setCbAlt2billAddr4(String cbAlt2billAddr4){
		this.cbAlt2billAddr4 = cbAlt2billAddr4;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billAddr4(){
    	return cbAlt2billAddr4;
    }
	/**
	 * 
	 * @param cbAlt2billAddr5
	 */
	public void setCbAlt2billAddr5(String cbAlt2billAddr5){
		this.cbAlt2billAddr5 = cbAlt2billAddr5;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billAddr5(){
    	return cbAlt2billAddr5;
    }
	/**
	 * 
	 * @param cbAlt2billCity
	 */
	public void setCbAlt2billCity(String cbAlt2billCity){
		this.cbAlt2billCity = cbAlt2billCity;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billCity(){
    	return cbAlt2billCity;
    }
	/**
	 * 
	 * @param cbAlt2billCntryCd
	 */
	public void setCbAlt2billCntryCd(String cbAlt2billCntryCd){
		this.cbAlt2billCntryCd = cbAlt2billCntryCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billCntryCd(){
    	return cbAlt2billCntryCd;
    }
	/**
	 * 
	 * @param cbAlt2billAddrPostcode
	 */
	public void setCbAlt2billAddrPostcode(String cbAlt2billAddrPostcode){
		this.cbAlt2billAddrPostcode = cbAlt2billAddrPostcode;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbAlt2billAddrPostcode(){
    	return cbAlt2billAddrPostcode;
    }
}