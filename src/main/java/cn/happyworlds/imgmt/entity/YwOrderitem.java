package cn.happyworlds.imgmt.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author tqw
 */
public class YwOrderitem implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  订单详情id
	 */
	private String hwOrderitemId;
	/**
	 *  订单ID
	 */
	private String hwOrderId;
	/**
	 *  游客身份证号码
	 */
	private String hwMemberId;
	/**
	 *  门票类别id
	 */
	private String hwProdctGroup;
	/**
	 *  票种子类：一日、两日、三日（暂未使用）
	 */
	private String hwSubclass;
	/**
	 *  场馆ID，多场馆以，分开（暂未使用）
	 */
	private String hwVenueid;
	/**
	 *  用户入园时间（yyyyMMdd hhmmss）
	 */
	private String hwAdmissionTime;
	/**
	 *  截止时间
	 */
	private String hwEndTime;
	/**
	 *  订票数量，缺省为1
	 */
	private Integer hwTicketCount;
	/**
	 *  已用票数
	 */
	private Integer hwUsedCount;
	/**
	 *  可用票数
	 */
	private Integer hwAvailableCount;
	/**
	 *  应付单价
	 */
	private java.math.BigDecimal hwUnitPrice;
	/**
	 *  应付总价
	 */
	private java.math.BigDecimal hwAmount;
	/**
	 *  优惠方式：会员、儿童长者、周末假日，缺省平日
	 */
	private String hwSpecialMethod;
	/**
	 *  订单状态：正常、完成、过期
	 */
	private String hwStatus;
	/**
	 *  特殊证件类型
	 */
	private String hwSpecialcredentytype;
	/**
	 *  特殊证件号码
	 */
	private String hwSpecialcredentynumber;
	/**
	 *  出生日期
	 */
	private String hwBirthday;
	/**
	 *  折扣率
	 */
	private Float hwDiscount;
	/**
	 *  卡流水号
	 */
	private String hwCardserialno;
	/**
	 *  持卡人号码
	 */
	private String hwCardhosternumber;
	/**
	 *  入园次数，默认为0，1为入园状态
	 */
	private Boolean hwUseCount;
	/**
	 *  证件姓名
	 */
	private String hwCredentyname;
	/**
	 *  证件类型
	 */
	private String hwCredentytype;
	/**
	 *  户籍地址
	 */
	private String hwAddress;
	
	private String hwTicketName;
	
	//是否帮卡
	private Boolean isBind;
	//作业员Id
	private String hwOperatorId;
	
	private BigDecimal hwChargeAmount;
	
	private String hwMobile;
	
	private String hwVisitTime;
	
	

	public String getHwVisitTime() {
		return hwVisitTime;
	}

	public void setHwVisitTime(String hwVisitTime) {
		this.hwVisitTime = hwVisitTime;
	}

	public String getHwMobile() {
		return hwMobile;
	}

	public void setHwMobile(String hwMobile) {
		this.hwMobile = hwMobile;
	}

	public BigDecimal getHwChargeAmount() {
		return hwChargeAmount;
	}

	public void setHwChargeAmount(BigDecimal hwChargeAmount) {
		this.hwChargeAmount = hwChargeAmount;
	}

	public String getHwOperatorId() {
		return hwOperatorId;
	}

	public void setHwOperatorId(String hwOperatorId) {
		this.hwOperatorId = hwOperatorId;
	}

	public Boolean getIsBind() {
		return isBind;
	}

	public void setIsBind(Boolean isBind) {
		this.isBind = isBind;
	}

	public String getHwTicketName() {
		return hwTicketName;
	}

	public void setHwTicketName(String hwTicketName) {
		this.hwTicketName = hwTicketName;
	}

	/**
	 * 订单详情id
	 * @param hwOrderitemId
	 */
	public void setHwOrderitemId(String hwOrderitemId){
		this.hwOrderitemId = hwOrderitemId;
	}
	
    /**
     * 订单详情id
     * @return
     */	
    public String getHwOrderitemId(){
    	return hwOrderitemId;
    }
	/**
	 * 订单ID
	 * @param hwOrderId
	 */
	public void setHwOrderId(String hwOrderId){
		this.hwOrderId = hwOrderId;
	}
	
    /**
     * 订单ID
     * @return
     */	
    public String getHwOrderId(){
    	return hwOrderId;
    }
	/**
	 * 游客身份证号码
	 * @param hwMemberId
	 */
	public void setHwMemberId(String hwMemberId){
		this.hwMemberId = hwMemberId;
	}
	
    /**
     * 游客身份证号码
     * @return
     */	
    public String getHwMemberId(){
    	return hwMemberId;
    }
	/**
	 * 门票类别id
	 * @param hwProdctGroup
	 */
	public void setHwProdctGroup(String hwProdctGroup){
		this.hwProdctGroup = hwProdctGroup;
	}
	
    /**
     * 门票类别id
     * @return
     */	
    public String getHwProdctGroup(){
    	return hwProdctGroup;
    }
	/**
	 * 票种子类：一日、两日、三日（暂未使用）
	 * @param hwSubclass
	 */
	public void setHwSubclass(String hwSubclass){
		this.hwSubclass = hwSubclass;
	}
	
    /**
     * 票种子类：一日、两日、三日（暂未使用）
     * @return
     */	
    public String getHwSubclass(){
    	return hwSubclass;
    }
	/**
	 * 场馆ID，多场馆以，分开（暂未使用）
	 * @param hwVenueid
	 */
	public void setHwVenueid(String hwVenueid){
		this.hwVenueid = hwVenueid;
	}
	
    /**
     * 场馆ID，多场馆以，分开（暂未使用）
     * @return
     */	
    public String getHwVenueid(){
    	return hwVenueid;
    }
	/**
	 * 用户入园时间（yyyyMMdd hhmmss）
	 * @param hwAdmissionTime
	 */
	public void setHwAdmissionTime(String hwAdmissionTime){
		this.hwAdmissionTime = hwAdmissionTime;
	}
	
    /**
     * 用户入园时间（yyyyMMdd hhmmss）
     * @return
     */	
    public String getHwAdmissionTime(){
    	return hwAdmissionTime;
    }
	/**
	 * 截止时间
	 * @param hwEndTime
	 */
	public void setHwEndTime(String hwEndTime){
		this.hwEndTime = hwEndTime;
	}
	
    /**
     * 截止时间
     * @return
     */	
    public String getHwEndTime(){
    	return hwEndTime;
    }
	/**
	 * 订票数量，缺省为1
	 * @param hwTicketCount
	 */
	public void setHwTicketCount(Integer hwTicketCount){
		this.hwTicketCount = hwTicketCount;
	}
	
    /**
     * 订票数量，缺省为1
     * @return
     */	
    public Integer getHwTicketCount(){
    	return hwTicketCount;
    }
	/**
	 * 已用票数
	 * @param hwUsedCount
	 */
	public void setHwUsedCount(Integer hwUsedCount){
		this.hwUsedCount = hwUsedCount;
	}
	
    /**
     * 已用票数
     * @return
     */	
    public Integer getHwUsedCount(){
    	return hwUsedCount;
    }
	/**
	 * 可用票数
	 * @param hwAvailableCount
	 */
	public void setHwAvailableCount(Integer hwAvailableCount){
		this.hwAvailableCount = hwAvailableCount;
	}
	
    /**
     * 可用票数
     * @return
     */	
    public Integer getHwAvailableCount(){
    	return hwAvailableCount;
    }
	/**
	 * 应付单价
	 * @param hwUnitPrice
	 */
	public void setHwUnitPrice(java.math.BigDecimal hwUnitPrice){
		this.hwUnitPrice = hwUnitPrice;
	}
	
    /**
     * 应付单价
     * @return
     */	
    public java.math.BigDecimal getHwUnitPrice(){
    	return hwUnitPrice;
    }
	/**
	 * 应付总价
	 * @param hwAmount
	 */
	public void setHwAmount(java.math.BigDecimal hwAmount){
		this.hwAmount = hwAmount;
	}
	
    /**
     * 应付总价
     * @return
     */	
    public java.math.BigDecimal getHwAmount(){
    	return hwAmount;
    }
	/**
	 * 优惠方式：会员、儿童长者、周末假日，缺省平日
	 * @param hwSpecialMethod
	 */
	public void setHwSpecialMethod(String hwSpecialMethod){
		this.hwSpecialMethod = hwSpecialMethod;
	}
	
    /**
     * 优惠方式：会员、儿童长者、周末假日，缺省平日
     * @return
     */	
    public String getHwSpecialMethod(){
    	return hwSpecialMethod;
    }
	/**
	 * 订单状态：正常、完成、过期
	 * @param hwStatus
	 */
	public void setHwStatus(String hwStatus){
		this.hwStatus = hwStatus;
	}
	
    /**
     * 订单状态：正常、完成、过期
     * @return
     */	
    public String getHwStatus(){
    	return hwStatus;
    }
	/**
	 * 特殊证件类型
	 * @param hwSpecialcredentytype
	 */
	public void setHwSpecialcredentytype(String hwSpecialcredentytype){
		this.hwSpecialcredentytype = hwSpecialcredentytype;
	}
	
    /**
     * 特殊证件类型
     * @return
     */	
    public String getHwSpecialcredentytype(){
    	return hwSpecialcredentytype;
    }
	/**
	 * 特殊证件号码
	 * @param hwSpecialcredentynumber
	 */
	public void setHwSpecialcredentynumber(String hwSpecialcredentynumber){
		this.hwSpecialcredentynumber = hwSpecialcredentynumber;
	}
	
    /**
     * 特殊证件号码
     * @return
     */	
    public String getHwSpecialcredentynumber(){
    	return hwSpecialcredentynumber;
    }
	/**
	 * 出生日期
	 * @param hwBirthday
	 */
	public void setHwBirthday(String hwBirthday){
		this.hwBirthday = hwBirthday;
	}
	
    /**
     * 出生日期
     * @return
     */	
    public String getHwBirthday(){
    	return hwBirthday;
    }
	/**
	 * 折扣率
	 * @param hwDiscount
	 */
	public void setHwDiscount(Float hwDiscount){
		this.hwDiscount = hwDiscount;
	}
	
    /**
     * 折扣率
     * @return
     */	
    public Float getHwDiscount(){
    	return hwDiscount;
    }
	/**
	 * 卡流水号
	 * @param hwCardserialno
	 */
	public void setHwCardserialno(String hwCardserialno){
		this.hwCardserialno = hwCardserialno;
	}
	
    /**
     * 卡流水号
     * @return
     */	
    public String getHwCardserialno(){
    	return hwCardserialno;
    }
	/**
	 * 持卡人号码
	 * @param hwCardhosternumber
	 */
	public void setHwCardhosternumber(String hwCardhosternumber){
		this.hwCardhosternumber = hwCardhosternumber;
	}
	
    /**
     * 持卡人号码
     * @return
     */	
    public String getHwCardhosternumber(){
    	return hwCardhosternumber;
    }
	/**
	 * 入园次数，默认为0，1为入园状态
	 * @param hwUseCount
	 */
	public void setHwUseCount(Boolean hwUseCount){
		this.hwUseCount = hwUseCount;
	}
	
    /**
     * 入园次数，默认为0，1为入园状态
     * @return
     */	
    public Boolean getHwUseCount(){
    	return hwUseCount;
    }
	/**
	 * 证件姓名
	 * @param hwCredentyname
	 */
	public void setHwCredentyname(String hwCredentyname){
		this.hwCredentyname = hwCredentyname;
	}
	
    /**
     * 证件姓名
     * @return
     */	
    public String getHwCredentyname(){
    	return hwCredentyname;
    }
	/**
	 * 证件类型
	 * @param hwCredentytype
	 */
	public void setHwCredentytype(String hwCredentytype){
		this.hwCredentytype = hwCredentytype;
	}
	
    /**
     * 证件类型
     * @return
     */	
    public String getHwCredentytype(){
    	return hwCredentytype;
    }
	/**
	 * 户籍地址
	 * @param hwAddress
	 */
	public void setHwAddress(String hwAddress){
		this.hwAddress = hwAddress;
	}
	
    /**
     * 户籍地址
     * @return
     */	
    public String getHwAddress(){
    	return hwAddress;
    }
}