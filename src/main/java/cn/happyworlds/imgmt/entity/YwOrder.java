package cn.happyworlds.imgmt.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author tqw
 */
public class YwOrder implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  订单ID（唯一)
	 */
	private String hwOrderId;
	/**
	 *  会员ID
	 */
	private String hwMemberId;
	/**
	 *  订单客户名
	 */
	private String hwCustomerName;
	/**
	 *  手机号码
	 */
	private String hwMobilePhone;
	/**
	 *  客户电邮
	 */
	private String hwCustomerEmail;
	/**
	 *  渠道ID:微信公众号(1),APP(2),现场(3),官网(4),OTA(5)
	 */
	private String hwChannel;
	/**
	 *  支付流水ID
	 */
	private String hwPaymentListid;
	/**
	 *  金额
	 */
	private java.math.BigDecimal hwMoney;
	/**
	 *  状态:N正常、已退票R、部分退票P
	 */
	private String hwOrderState;
	/**
	 *  凭据
	 */
	private String hwCredential;
	/**
	 *  订单生成时间
	 */
	private String hwOrderAddtime;
	/**
	 *  订单支付时间
	 */
	private String hwOrderPaytime;
	/**
	 *  订单完成时间
	 */
	private String hwOrderFinishtime;
	/**
	 *  订单支付状态（已支付Y）(未支付N)
	 */
	private String hwPaymentStatus;
	
	//作业员Id
	private String hwOperatorId;
	
	
	private String hwPayType;
	
	private String hwIp;
	
	private String hwType; //订单类型
	
	private String hwSonOrderList;  //子订单id 列表
	
	private int ticketNumber;
	
	private int channel;
	
	private String ticketName;
	
	private int count;
	
	private double sum;
	
	private int num;
	
	
	
	
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getHwSonOrderList() {
		return hwSonOrderList;
	}

	public void setHwSonOrderList(String hwSonOrderList) {
		this.hwSonOrderList = hwSonOrderList;
	}

	public String getHwType() {
		return hwType;
	}

	public void setHwType(String hwType) {
		this.hwType = hwType;
	}

	public String getHwIp() {
		return hwIp;
	}

	public void setHwIp(String hwIp) {
		this.hwIp = hwIp;
	}

	public String getHwPayType() {
		return hwPayType;
	}

	public void setHwPayType(String hwPayType) {
		this.hwPayType = hwPayType;
	}

	public String getHwOperatorId() {
		return hwOperatorId;
	}

	public void setHwOperatorId(String hwOperatorId) {
		this.hwOperatorId = hwOperatorId;
	}

	/**
	 * 订单ID（唯一)
	 * @param hwOrderId
	 */
	public void setHwOrderId(String hwOrderId){
		this.hwOrderId = hwOrderId;
	}
	
    /**
     * 订单ID（唯一)
     * @return
     */	
    public String getHwOrderId(){
    	return hwOrderId;
    }
	/**
	 * 会员ID
	 * @param hwMemberId
	 */
	public void setHwMemberId(String hwMemberId){
		this.hwMemberId = hwMemberId;
	}
	
    /**
     * 会员ID
     * @return
     */	
    public String getHwMemberId(){
    	return hwMemberId;
    }
	/**
	 * 订单客户名
	 * @param hwCustomerName
	 */
	public void setHwCustomerName(String hwCustomerName){
		this.hwCustomerName = hwCustomerName;
	}
	
    /**
     * 订单客户名
     * @return
     */	
    public String getHwCustomerName(){
    	return hwCustomerName;
    }
	/**
	 * 手机号码
	 * @param hwMobilePhone
	 */
	public void setHwMobilePhone(String hwMobilePhone){
		this.hwMobilePhone = hwMobilePhone;
	}
	
    /**
     * 手机号码
     * @return
     */	
    public String getHwMobilePhone(){
    	return hwMobilePhone;
    }
	/**
	 * 客户电邮
	 * @param hwCustomerEmail
	 */
	public void setHwCustomerEmail(String hwCustomerEmail){
		this.hwCustomerEmail = hwCustomerEmail;
	}
	
    /**
     * 客户电邮
     * @return
     */	
    public String getHwCustomerEmail(){
    	return hwCustomerEmail;
    }
	/**
	 * 渠道ID:微信公众号(1),APP(2),现场(3),官网(4),OTA(5)
	 * @param hwChannel
	 */
	public void setHwChannel(String hwChannel){
		this.hwChannel = hwChannel;
	}
	
    /**
     * 渠道ID:微信公众号(1),APP(2),现场(3),官网(4),OTA(5)
     * @return
     */	
    public String getHwChannel(){
    	return hwChannel;
    }
	/**
	 * 支付流水ID
	 * @param hwPaymentListid
	 */
	public void setHwPaymentListid(String hwPaymentListid){
		this.hwPaymentListid = hwPaymentListid;
	}
	
    /**
     * 支付流水ID
     * @return
     */	
    public String getHwPaymentListid(){
    	return hwPaymentListid;
    }
	/**
	 * 金额
	 * @param hwMoney
	 */
	public void setHwMoney(java.math.BigDecimal hwMoney){
		this.hwMoney = hwMoney;
	}
	
    /**
     * 金额
     * @return
     */	
    public java.math.BigDecimal getHwMoney(){
    	return hwMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
	/**
	 * 状态:N正常、已退票R、部分退票P
	 * @param hwOrderState
	 */
	public void setHwOrderState(String hwOrderState){
		this.hwOrderState = hwOrderState;
	}
	
    /**
     * 状态:N正常、已退票R、部分退票P
     * @return
     */	
    public String getHwOrderState(){
    	return hwOrderState;
    }
	/**
	 * 凭据
	 * @param hwCredential
	 */
	public void setHwCredential(String hwCredential){
		this.hwCredential = hwCredential;
	}
	
    /**
     * 凭据
     * @return
     */	
    public String getHwCredential(){
    	return hwCredential;
    }
	/**
	 * 订单生成时间
	 * @param hwOrderAddtime
	 */
	public void setHwOrderAddtime(String hwOrderAddtime){
		this.hwOrderAddtime = hwOrderAddtime;
	}
	
    /**
     * 订单生成时间
     * @return
     */	
    public String getHwOrderAddtime(){
    	return hwOrderAddtime;
    }
	/**
	 * 订单支付时间
	 * @param hwOrderPaytime
	 */
	public void setHwOrderPaytime(String hwOrderPaytime){
		this.hwOrderPaytime = hwOrderPaytime;
	}
	
    /**
     * 订单支付时间
     * @return
     */	
    public String getHwOrderPaytime(){
    	return hwOrderPaytime;
    }
	/**
	 * 订单完成时间
	 * @param hwOrderFinishtime
	 */
	public void setHwOrderFinishtime(String hwOrderFinishtime){
		this.hwOrderFinishtime = hwOrderFinishtime;
	}
	
    /**
     * 订单完成时间
     * @return
     */	
    public String getHwOrderFinishtime(){
    	return hwOrderFinishtime;
    }

	public String getHwPaymentStatus() {
		return hwPaymentStatus;
	}

	public void setHwPaymentStatus(String hwPaymentStatus) {
		this.hwPaymentStatus = hwPaymentStatus;
	}
	
}