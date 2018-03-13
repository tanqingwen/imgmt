package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class YwPayrecord implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  平台订单号
	 */
	private String hwSn;
	/**
	 *  商户订单号
	 */
	private String hwFlowId;
	/**
	 *  付费订单号
	 */
	private String hwPayId;
	/**
	 *  订单ID
	 */
	private String hwOrderId;
	/**
	 *  会员ID
	 */
	private String hwMemberId;
	/**
	 *  手机号码
	 */
	private String hwMobilePhone;
	/**
	 *  姓名
	 */
	private String hwName;
	/**
	 *  订单、押金、充值
	 */
	private String hwType;
	/**
	 *  总金额
	 */
	private java.math.BigDecimal hwAmount;
	/**
	 *  门票金额
	 */
	private java.math.BigDecimal hwAmountTicket;
	/**
	 *  应付押金金额
	 */
	private java.math.BigDecimal hwDepositPayable;
	/**
	 *  实付押金金额
	 */
	private java.math.BigDecimal hwDepositActure;
	/**
	 *  充值金额
	 */
	private java.math.BigDecimal hwAmountRecharge;
	/**
	 *  押金单价
	 */
	private java.math.BigDecimal hwDepositPrice;
	/**
	 *  押金卡数量
	 */
	private Integer hwDepositQty;
	/**
	 *  开卡数量
	 */
	private Integer hwActivateQty;
	/**
	 *  代付支付流水ID
	 */
	private Integer hwSnPayother;
	/**
	 *  支付方式：微信(1)、支付宝(2)、现金(3)、POS(4)、余额(5)、代付(6)
	 */
	private String hwPayType;
	/**
	 *  支付状态：支付（Y） ，未支付（N）
	 */
	private String hwPayStatus;
	/**
	 *  生成时间
	 */
	private String hwGenerationTime;
	/**
	 *  支付时间
	 */
	private String hwPayTime;
	/**
	 *  乐园售票换卡窗口工作人员用户ID
	 */
	private String hwOperatorId;
	/**
	 *  乐园工作人员操作终端窗口
	 */
	private String hwTerminalId;
	/**
	 *  预留字段1
	 */
	private String hwPayReserve1;
	/**
	 *  预留字段2
	 */
	private String hwPayReserve2;
	/**
	 *  预留字段3
	 */
	private String hwPayReserve3;
	/**
	 *  预留字段4
	 */
	private String hwPayReserve4;
	/**
	 *  
	 */
	private String hwPayAccount;
	/**
	 * 平台订单号
	 * @param hwSn
	 */
	public String ticketName ;
	
	
	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public void setHwSn(String hwSn){
		this.hwSn = hwSn;
	}
	
    /**
     * 平台订单号
     * @return
     */	
    public String getHwSn(){
    	return hwSn;
    }
	/**
	 * 商户订单号
	 * @param hwFlowId
	 */
	public void setHwFlowId(String hwFlowId){
		this.hwFlowId = hwFlowId;
	}
	
    /**
     * 商户订单号
     * @return
     */	
    public String getHwFlowId(){
    	return hwFlowId;
    }
	/**
	 * 付费订单号
	 * @param hwPayId
	 */
	public void setHwPayId(String hwPayId){
		this.hwPayId = hwPayId;
	}
	
    /**
     * 付费订单号
     * @return
     */	
    public String getHwPayId(){
    	return hwPayId;
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
	 * 姓名
	 * @param hwName
	 */
	public void setHwName(String hwName){
		this.hwName = hwName;
	}
	
    /**
     * 姓名
     * @return
     */	
    public String getHwName(){
    	return hwName;
    }
	/**
	 * 订单、押金、充值
	 * @param hwType
	 */
	public void setHwType(String hwType){
		this.hwType = hwType;
	}
	
    /**
     * 订单、押金、充值
     * @return
     */	
    public String getHwType(){
    	return hwType;
    }
	/**
	 * 总金额
	 * @param hwAmount
	 */
	public void setHwAmount(java.math.BigDecimal hwAmount){
		this.hwAmount = hwAmount;
	}
	
    /**
     * 总金额
     * @return
     */	
    public java.math.BigDecimal getHwAmount(){
    	return hwAmount;
    }
	/**
	 * 门票金额
	 * @param hwAmountTicket
	 */
	public void setHwAmountTicket(java.math.BigDecimal hwAmountTicket){
		this.hwAmountTicket = hwAmountTicket;
	}
	
    /**
     * 门票金额
     * @return
     */	
    public java.math.BigDecimal getHwAmountTicket(){
    	return hwAmountTicket;
    }
	/**
	 * 应付押金金额
	 * @param hwDepositPayable
	 */
	public void setHwDepositPayable(java.math.BigDecimal hwDepositPayable){
		this.hwDepositPayable = hwDepositPayable;
	}
	
    /**
     * 应付押金金额
     * @return
     */	
    public java.math.BigDecimal getHwDepositPayable(){
    	return hwDepositPayable;
    }
	/**
	 * 实付押金金额
	 * @param hwDepositActure
	 */
	public void setHwDepositActure(java.math.BigDecimal hwDepositActure){
		this.hwDepositActure = hwDepositActure;
	}
	
    /**
     * 实付押金金额
     * @return
     */	
    public java.math.BigDecimal getHwDepositActure(){
    	return hwDepositActure;
    }
	/**
	 * 充值金额
	 * @param hwAmountRecharge
	 */
	public void setHwAmountRecharge(java.math.BigDecimal hwAmountRecharge){
		this.hwAmountRecharge = hwAmountRecharge;
	}
	
    /**
     * 充值金额
     * @return
     */	
    public java.math.BigDecimal getHwAmountRecharge(){
    	return hwAmountRecharge;
    }
	/**
	 * 押金单价
	 * @param hwDepositPrice
	 */
	public void setHwDepositPrice(java.math.BigDecimal hwDepositPrice){
		this.hwDepositPrice = hwDepositPrice;
	}
	
    /**
     * 押金单价
     * @return
     */	
    public java.math.BigDecimal getHwDepositPrice(){
    	return hwDepositPrice;
    }
	/**
	 * 押金卡数量
	 * @param hwDepositQty
	 */
	public void setHwDepositQty(Integer hwDepositQty){
		this.hwDepositQty = hwDepositQty;
	}
	
    /**
     * 押金卡数量
     * @return
     */	
    public Integer getHwDepositQty(){
    	return hwDepositQty;
    }
	/**
	 * 开卡数量
	 * @param hwActivateQty
	 */
	public void setHwActivateQty(Integer hwActivateQty){
		this.hwActivateQty = hwActivateQty;
	}
	
    /**
     * 开卡数量
     * @return
     */	
    public Integer getHwActivateQty(){
    	return hwActivateQty;
    }
	/**
	 * 代付支付流水ID
	 * @param hwSnPayother
	 */
	public void setHwSnPayother(Integer hwSnPayother){
		this.hwSnPayother = hwSnPayother;
	}
	
    /**
     * 代付支付流水ID
     * @return
     */	
    public Integer getHwSnPayother(){
    	return hwSnPayother;
    }
	/**
	 * 支付方式：微信(1)、支付宝(2)、现金(3)、POS(4)、余额(5)、代付(6)
	 * @param hwPayType
	 */
	public void setHwPayType(String hwPayType){
		this.hwPayType = hwPayType;
	}
	
    /**
     * 支付方式：微信(1)、支付宝(2)、现金(3)、POS(4)、余额(5)、代付(6)
     * @return
     */	
    public String getHwPayType(){
    	return hwPayType;
    }
	/**
	 * 支付状态：支付（Y） ，未支付（N）
	 * @param hwPayStatus
	 */
	public void setHwPayStatus(String hwPayStatus){
		this.hwPayStatus = hwPayStatus;
	}
	
    /**
     * 支付状态：支付（Y） ，未支付（N）
     * @return
     */	
    public String getHwPayStatus(){
    	return hwPayStatus;
    }
	/**
	 * 生成时间
	 * @param hwGenerationTime
	 */
	public void setHwGenerationTime(String hwGenerationTime){
		this.hwGenerationTime = hwGenerationTime;
	}
	
    /**
     * 生成时间
     * @return
     */	
    public String getHwGenerationTime(){
    	return hwGenerationTime;
    }
	/**
	 * 支付时间
	 * @param hwPayTime
	 */
	public void setHwPayTime(String hwPayTime){
		this.hwPayTime = hwPayTime;
	}
	
    /**
     * 支付时间
     * @return
     */	
    public String getHwPayTime(){
    	return hwPayTime;
    }
	/**
	 * 乐园售票换卡窗口工作人员用户ID
	 * @param hwOperatorId
	 */
	public void setHwOperatorId(String hwOperatorId){
		this.hwOperatorId = hwOperatorId;
	}
	
    /**
     * 乐园售票换卡窗口工作人员用户ID
     * @return
     */	
    public String getHwOperatorId(){
    	return hwOperatorId;
    }
	/**
	 * 乐园工作人员操作终端窗口
	 * @param hwTerminalId
	 */
	public void setHwTerminalId(String hwTerminalId){
		this.hwTerminalId = hwTerminalId;
	}
	
    /**
     * 乐园工作人员操作终端窗口
     * @return
     */	
    public String getHwTerminalId(){
    	return hwTerminalId;
    }
	/**
	 * 预留字段1
	 * @param hwPayReserve1
	 */
	public void setHwPayReserve1(String hwPayReserve1){
		this.hwPayReserve1 = hwPayReserve1;
	}
	
    /**
     * 预留字段1
     * @return
     */	
    public String getHwPayReserve1(){
    	return hwPayReserve1;
    }
	/**
	 * 预留字段2
	 * @param hwPayReserve2
	 */
	public void setHwPayReserve2(String hwPayReserve2){
		this.hwPayReserve2 = hwPayReserve2;
	}
	
    /**
     * 预留字段2
     * @return
     */	
    public String getHwPayReserve2(){
    	return hwPayReserve2;
    }
	/**
	 * 预留字段3
	 * @param hwPayReserve3
	 */
	public void setHwPayReserve3(String hwPayReserve3){
		this.hwPayReserve3 = hwPayReserve3;
	}
	
    /**
     * 预留字段3
     * @return
     */	
    public String getHwPayReserve3(){
    	return hwPayReserve3;
    }
	/**
	 * 预留字段4
	 * @param hwPayReserve4
	 */
	public void setHwPayReserve4(String hwPayReserve4){
		this.hwPayReserve4 = hwPayReserve4;
	}
	
    /**
     * 预留字段4
     * @return
     */	
    public String getHwPayReserve4(){
    	return hwPayReserve4;
    }
	/**
	 * 
	 * @param hwPayAccount
	 */
	public void setHwPayAccount(String hwPayAccount){
		this.hwPayAccount = hwPayAccount;
	}
	
    /**
     * 
     * @return
     */	
    public String getHwPayAccount(){
    	return hwPayAccount;
    }
}