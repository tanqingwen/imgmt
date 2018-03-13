package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

public class CpChannels implements Serializable {
	private Integer cpChannelId;
	private String cpMercial;
	private String cpTicketName;
	private String cpOrderSum;
	private String cpTicketSum;
	private String cpAmountsReceivable;
	private String cpAmount;
	private String cpOrderTime;
	public Integer getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(Integer cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public String getCpMercial() {
		return cpMercial;
	}
	public void setCpMercial(String cpMercial) {
		this.cpMercial = cpMercial;
	}
	public String getCpTicketName() {
		return cpTicketName;
	}
	public void setCpTicketName(String cpTicketName) {
		this.cpTicketName = cpTicketName;
	}
	public String getCpOrderSum() {
		return cpOrderSum;
	}
	public void setCpOrderSum(String cpOrderSum) {
		this.cpOrderSum = cpOrderSum;
	}
	public String getCpTicketSum() {
		return cpTicketSum;
	}
	public void setCpTicketSum(String cpTicketSum) {
		this.cpTicketSum = cpTicketSum;
	}
	public String getCpAmountsReceivable() {
		return cpAmountsReceivable;
	}
	public void setCpAmountsReceivable(String cpAmountsReceivable) {
		this.cpAmountsReceivable = cpAmountsReceivable;
	}
	public String getCpAmount() {
		return cpAmount;
	}
	public void setCpAmount(String cpAmount) {
		this.cpAmount = cpAmount;
	}
	public String getCpOrderTime() {
		return cpOrderTime;
	}
	public void setCpOrderTime(String cpOrderTime) {
		this.cpOrderTime = cpOrderTime;
	}
	public CpChannels() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpChannels(Integer cpChannelId, String cpMercial, String cpTicketName, String cpOrderSum, String cpTicketSum,
			String cpAmountsReceivable, String cpAmount, String cpOrderTime) {
		super();
		this.cpChannelId = cpChannelId;
		this.cpMercial = cpMercial;
		this.cpTicketName = cpTicketName;
		this.cpOrderSum = cpOrderSum;
		this.cpTicketSum = cpTicketSum;
		this.cpAmountsReceivable = cpAmountsReceivable;
		this.cpAmount = cpAmount;
		this.cpOrderTime = cpOrderTime;
	}
}
