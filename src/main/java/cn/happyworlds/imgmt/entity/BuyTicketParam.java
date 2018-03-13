package cn.happyworlds.imgmt.entity;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BuyTicketParam {

	
	private String hwIp;
	
	private String phoneNumber;
	
	private BigDecimal orderAmount;
	
	private String payType;
	
	private BigDecimal chargeAmount;
	
	private String visitTime;
	/*
	 * 判断是否为实名购票
	 */
	private String realName;
	
	private List<Item>  items;

	
	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}


	public BigDecimal getOrderAmount() {
		return orderAmount!=null?orderAmount.setScale(2, BigDecimal.ROUND_HALF_UP):orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount!=null?orderAmount.setScale(2, BigDecimal.ROUND_HALF_UP):orderAmount;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount!=null?chargeAmount.setScale(2, BigDecimal.ROUND_HALF_UP):chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount!=null?chargeAmount.setScale(2, BigDecimal.ROUND_HALF_UP):chargeAmount;
	}
	/**
	 * 判断是否实名
	 * @return
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 判断是否实名
	 * @return
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	 
}
