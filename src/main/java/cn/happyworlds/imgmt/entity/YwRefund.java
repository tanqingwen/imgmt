package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class YwRefund implements Serializable {

    private static final long serialVersionUID = 1L;

	/**   0
	 *  退款流水id
	 */
	private Integer hwId;
	/**
	 *  会员ID
	 */
	private String hwMemberId;
	/**
	 *  手机号码
	 */
	private String hwMobilePhone;
	/**
	 *  退款金额
	 */
	private java.math.BigDecimal hwRefundAmount;
	/**
	 *  银行卡号
	 */
	private String hwBankCardno;
	/**
	 *  姓名
	 */
	private String hwName;
	/**
	 *  退款开户行
	 */
	private String hwBank;
	/**
	 *  退款类型：退回信用卡账户、会员余额、现金、会员提现
	 */
	private String hwRefundType;
	/**
	 *  申请退款时间
	 */
	private java.util.Date hwApplyTime;
	/**
	 *  退款执行时间
	 */
	private java.util.Date hwExecuteTime;
	/**
	 *  退款执行状态：成功、失败
	 */
	private String hwState;
	/**
	 *  异常信息
	 */
	private String hwAbnormalInfo;
	/**
	 * 退款流水id
	 * @param hwId
	 */
	public void setHwId(Integer hwId){
		this.hwId = hwId;
	}
	
    /**
     * 退款流水id
     * @return
     */	
    public Integer getHwId(){
    	return hwId;
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
	 * 退款金额
	 * @param hwRefundAmount
	 */
	public void setHwRefundAmount(java.math.BigDecimal hwRefundAmount){
		this.hwRefundAmount = hwRefundAmount;
	}
	
    /**
     * 退款金额
     * @return
     */	
    public java.math.BigDecimal getHwRefundAmount(){
    	return hwRefundAmount;
    }
	/**
	 * 银行卡号
	 * @param hwBankCardno
	 */
	public void setHwBankCardno(String hwBankCardno){
		this.hwBankCardno = hwBankCardno;
	}
	
    /**
     * 银行卡号
     * @return
     */	
    public String getHwBankCardno(){
    	return hwBankCardno;
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
	 * 退款开户行
	 * @param hwBank
	 */
	public void setHwBank(String hwBank){
		this.hwBank = hwBank;
	}
	
    /**
     * 退款开户行
     * @return
     */	
    public String getHwBank(){
    	return hwBank;
    }
	/**
	 * 退款类型：退回信用卡账户、会员余额、现金、会员提现
	 * @param hwRefundType
	 */
	public void setHwRefundType(String hwRefundType){
		this.hwRefundType = hwRefundType;
	}
	
    /**
     * 退款类型：退回信用卡账户、会员余额、现金、会员提现
     * @return
     */	
    public String getHwRefundType(){
    	return hwRefundType;
    }
	/**
	 * 申请退款时间
	 * @param hwApplyTime
	 */
	public void setHwApplyTime(java.util.Date hwApplyTime){
		this.hwApplyTime = hwApplyTime;
	}
	
    /**
     * 申请退款时间
     * @return
     */	
    public java.util.Date getHwApplyTime(){
    	return hwApplyTime;
    }
	/**
	 * 退款执行时间
	 * @param hwExecuteTime
	 */
	public void setHwExecuteTime(java.util.Date hwExecuteTime){
		this.hwExecuteTime = hwExecuteTime;
	}
	
    /**
     * 退款执行时间
     * @return
     */	
    public java.util.Date getHwExecuteTime(){
    	return hwExecuteTime;
    }
	/**
	 * 退款执行状态：成功、失败
	 * @param hwState
	 */
	public void setHwState(String hwState){
		this.hwState = hwState;
	}
	
    /**
     * 退款执行状态：成功、失败
     * @return
     */	
    public String getHwState(){
    	return hwState;
    }
	/**
	 * 异常信息
	 * @param hwAbnormalInfo
	 */
	public void setHwAbnormalInfo(String hwAbnormalInfo){
		this.hwAbnormalInfo = hwAbnormalInfo;
	}
	
    /**
     * 异常信息
     * @return
     */	
    public String getHwAbnormalInfo(){
    	return hwAbnormalInfo;
    }
}