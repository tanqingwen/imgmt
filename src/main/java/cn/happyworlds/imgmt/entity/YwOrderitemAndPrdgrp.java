package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author yanjy
 */
public class YwOrderitemAndPrdgrp implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  票种代码ID
	 */
	private String hwProdctGroup;
	/**
	 *  用户入园时间
	 */
	private String hwAdmissionTime;
	/**
	 *  单价
	 */
	private java.math.BigDecimal hwUnitPrice;
	/**
	 *  订票数量
	 */
	private String hwTicketCount;
	/**
	 *  票总价
	 */
	private java.math.BigDecimal hwAmount;
	/**
	 *  门票描述
	 */
	private String prGroupDesc;	
	/**
	 *  门票总数
	 */
	private String ticketCount;
	/**
	 *  类别
	 */
	private String hwCategory;
	/**
	 *  所有总价
	 */
	private String ticketAmount;
	
	public String getHwProdctGroup() {
		return hwProdctGroup;
	}
	public void setHwProdctGroup(String hwProdctGroup) {
		this.hwProdctGroup = hwProdctGroup;
	}
	public String getHwAdmissionTime() {
		return hwAdmissionTime;
	}
	public void setHwAdmissionTime(String hwAdmissionTime) {
		this.hwAdmissionTime = hwAdmissionTime;
	}
	public java.math.BigDecimal getHwUnitPrice() {
		return hwUnitPrice;
	}
	public void setHwUnitPrice(java.math.BigDecimal hwUnitPrice) {
		this.hwUnitPrice = hwUnitPrice;
	}
	public String getHwTicketCount() {
		return hwTicketCount;
	}
	public void setHwTicketCount(String hwTicketCount) {
		this.hwTicketCount = hwTicketCount;
	}
	public java.math.BigDecimal getHwAmount() {
		return hwAmount;
	}
	public void setHwAmount(java.math.BigDecimal hwAmount) {
		this.hwAmount = hwAmount;
	}
	public String getPrGroupDesc() {
		return prGroupDesc;
	}
	public void setPrGroupDesc(String prGroupDesc) {
		this.prGroupDesc = prGroupDesc;
	}
	public String getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(String ticketCount) {
		this.ticketCount = ticketCount;
	}
	public String getHwCategory() {
		return hwCategory;
	}
	public void setHwCategory(String hwCategory) {
		this.hwCategory = hwCategory;
	}
	public String getTicketAmount() {
		return ticketAmount;
	}
	public void setTicketAmount(String ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	}