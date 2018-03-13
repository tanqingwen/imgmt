package cn.happyworlds.imgmt.entity;

public class CpTuiPiao {
	private String ticketno;//'退票订单号',
	private String returnTime;//'退票时间',
	private String refundChannels;//'退票渠道',
	private String refundAmount;//'退票金额',
	private String refundPayment;//退票支付状态',
	private String sonorderlist;//'退票单号',
	private String orderTime;//下单时间
	private String orderFinish;//订单完成时间
	private String orderPayType;//'订单支付方式',
	private String orderMoney;//'支付金额',
	private String orderName;//'售票员姓名'
	public String getTicketno() {
		return ticketno;
	}
	public void setTicketno(String ticketno) {
		this.ticketno = ticketno;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getRefundChannels() {
		return refundChannels;
	}
	public void setRefundChannels(String refundChannels) {
		this.refundChannels = refundChannels;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundPayment() {
		return refundPayment;
	}
	public void setRefundPayment(String refundPayment) {
		this.refundPayment = refundPayment;
	}
	public String getSonorderlist() {
		return sonorderlist;
	}
	public void setSonorderlist(String sonorderlist) {
		this.sonorderlist = sonorderlist;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderFinish() {
		return orderFinish;
	}
	public void setOrderFinish(String orderFinish) {
		this.orderFinish = orderFinish;
	}
	public String getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(String orderPayType) {
		this.orderPayType = orderPayType;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public CpTuiPiao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpTuiPiao(String ticketno, String returnTime, String refundChannels, String refundAmount,
			String refundPayment, String sonorderlist, String orderTime, String orderFinish, String orderPayType,
			String orderMoney, String orderName) {
		super();
		this.ticketno = ticketno;
		this.returnTime = returnTime;
		this.refundChannels = refundChannels;
		this.refundAmount = refundAmount;
		this.refundPayment = refundPayment;
		this.sonorderlist = sonorderlist;
		this.orderTime = orderTime;
		this.orderFinish = orderFinish;
		this.orderPayType = orderPayType;
		this.orderMoney = orderMoney;
		this.orderName = orderName;
	}
	
}
