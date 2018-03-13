package cn.happyworlds.imgmt.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 充值流水表
 * @author ydz
 *
 */
public class YwCharge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444237193807298988L;

	private String hwSn;  //充值明细id
	
	private String hwOrderId; //所属订单id
	
	private BigDecimal hwChargeAmount; //充值金额
	
	private String hwPayType; //支付方式
	
	private String hwTradeSn; //第三方交易流水号
	
	private String hwAddTime; //创建时间
	
	private Byte hwPayState; //支付状态 0：未支付 ，1：已支付
	
	private String hwOperatorId; //作业员id
	
	private String hwCardHosterNumber;  //持卡人流水号
	
	private String hwCardSerialNo; //卡流水号
	
	private String hwIdentityNo; //身份证号码
	
	private String hwIdentityName; //身份证姓名
	
	private String hwPayTime; //支付时间

	public String getHwSn() {
		return hwSn;
	}

	public void setHwSn(String hwSn) {
		this.hwSn = hwSn;
	}

	public String getHwOrderId() {
		return hwOrderId;
	}

	public void setHwOrderId(String hwOrderId) {
		this.hwOrderId = hwOrderId;
	}

	public BigDecimal getHwChargeAmount() {
		return hwChargeAmount;
	}

	public void setHwChargeAmount(BigDecimal hwChargeAmount) {
		this.hwChargeAmount = hwChargeAmount;
	}

	public String getHwPayType() {
		return hwPayType;
	}

	public void setHwPayType(String hwPayType) {
		this.hwPayType = hwPayType;
	}

	public String getHwTradeSn() {
		return hwTradeSn;
	}

	public void setHwTradeSn(String hwTradeSn) {
		this.hwTradeSn = hwTradeSn;
	}

	public String getHwAddTime() {
		return hwAddTime;
	}

	public void setHwAddTime(String hwAddTime) {
		this.hwAddTime = hwAddTime;
	}

	public Byte getHwPayState() {
		return hwPayState;
	}

	public void setHwPayState(Byte hwPayState) {
		this.hwPayState = hwPayState;
	}

	public String getHwOperatorId() {
		return hwOperatorId;
	}

	public void setHwOperatorId(String hwOperatorId) {
		this.hwOperatorId = hwOperatorId;
	}

	public String getHwCardHosterNumber() {
		return hwCardHosterNumber;
	}

	public void setHwCardHosterNumber(String hwCardHosterNumber) {
		this.hwCardHosterNumber = hwCardHosterNumber;
	}

	public String getHwCardSerialNo() {
		return hwCardSerialNo;
	}

	public void setHwCardSerialNo(String hwCardSerialNo) {
		this.hwCardSerialNo = hwCardSerialNo;
	}

	public String getHwIdentityNo() {
		return hwIdentityNo;
	}

	public void setHwIdentityNo(String hwIdentityNo) {
		this.hwIdentityNo = hwIdentityNo;
	}

	public String getHwIdentityName() {
		return hwIdentityName;
	}

	public void setHwIdentityName(String hwIdentityName) {
		this.hwIdentityName = hwIdentityName;
	}

	public String getHwPayTime() {
		return hwPayTime;
	}

	public void setHwPayTime(String hwPayTime) {
		this.hwPayTime = hwPayTime;
	}
	
	
	
	
	
	
	
}
