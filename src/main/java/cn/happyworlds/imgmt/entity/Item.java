package cn.happyworlds.imgmt.entity;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Item {

	
	private String ticketType;
	
	private String objGrade;
	
	private String specialCredentyType;
	
	private String specialCredentyNumber;
	
	private String cardSerialNo;
	
	private String cardHosterNumber;
	
	private String credentyType;
	
	private String credentyNumber;
	
	private String authCode;
	
	private String  credentyName;
	
	private String birthDay;
	
	private BigDecimal itemAmount;
	
	private Float discount;
	
	private Integer ticketNumber;
	
	private String address;
	
	private BigDecimal rechargeAmount;
	
	private String ticketName;
	
	private String hwIp;
	

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getHwIp() {
		return hwIp;
	}

	public void setHwIp(String hwIp) {
		this.hwIp = hwIp;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getObjGrade() {
		return objGrade;
	}

	public void setObjGrade(String objGrade) {
		this.objGrade = objGrade;
	}

	public String getSpecialCredentyType() {
		return specialCredentyType;
	}

	public void setSpecialCredentyType(String specialCredentyType) {
		this.specialCredentyType = specialCredentyType;
	}

	public String getSpecialCredentyNumber() {
		return specialCredentyNumber;
	}

	public void setSpecialCredentyNumber(String specialCredentyNumber) {
		this.specialCredentyNumber = specialCredentyNumber;
	}

	public String getCardSerialNo() {
		return cardSerialNo;
	}

	public void setCardSerialNo(String cardSerialNo) {
		this.cardSerialNo = cardSerialNo;
	}

	public String getCardHosterNumber() {
		return cardHosterNumber;
	}

	public void setCardHosterNumber(String cardHosterNumber) {
		this.cardHosterNumber = cardHosterNumber;
	}

	public String getCredentyType() {
		return credentyType;
	}

	public void setCredentyType(String credentyType) {
		this.credentyType = credentyType;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}


	public String getCredentyName() {
		return credentyName;
	}

	public void setCredentyName(String credentyName) {
		this.credentyName = credentyName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public BigDecimal getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public String getCredentyNumber() {
		return credentyNumber;
	}

	public void setCredentyNumber(String credentyNumber) {
		this.credentyNumber = credentyNumber;
	}
	
	
	
	
	

	


}
