package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class YwCardMapping implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  ??(??)
	 */
	private String hwCardId;
	/**
	 *  ????IC????????
	 */
	private String hwType;
	/**
	 *  ??ID
	 */
	private String hwMemberId;
	/**
	 *  ???????????
	 */
	private String hwMemberName;
	/**
	 *  ??ID
	 */
	private String hwOrderId;
	/**
	 *  ??ID?????????????ID?????
	 */
	private String hwGuideId;
	/**
	 *  ????ID
	 */
	private String hwDepositId;
	/**
	 *  ????ID
	 */
	private Integer hwPaySn;
	/**
	 *  ????
	 */
	private java.math.BigDecimal hwDepositAmount;
	/**
	 *  ?????????????
	 */
	private String hwState;
	/**
	 *  ????
	 */
	private String hwActivateTime;
	/**
	 *  ??????ID
	 */
	private String hwOperatorId;
	/**
	 *  ??????ID
	 */
	private String hwTerminalId;
	/**
	 *  ???????0???????1
	 */
	private String hwCardCount;
	/**
	 * ??(??)
	 * @param hwCardId
	 */
	public void setHwCardId(String hwCardId){
		this.hwCardId = hwCardId;
	}
	
    /**
     * ??(??)
     * @return
     */	
    public String getHwCardId(){
    	return hwCardId;
    }
	/**
	 * ????IC????????
	 * @param hwType
	 */
	public void setHwType(String hwType){
		this.hwType = hwType;
	}
	
    /**
     * ????IC????????
     * @return
     */	
    public String getHwType(){
    	return hwType;
    }
	/**
	 * ??ID
	 * @param hwMemberId
	 */
	public void setHwMemberId(String hwMemberId){
		this.hwMemberId = hwMemberId;
	}
	
    /**
     * ??ID
     * @return
     */	
    public String getHwMemberId(){
    	return hwMemberId;
    }
	/**
	 * ???????????
	 * @param hwMemberName
	 */
	public void setHwMemberName(String hwMemberName){
		this.hwMemberName = hwMemberName;
	}
	
    /**
     * ???????????
     * @return
     */	
    public String getHwMemberName(){
    	return hwMemberName;
    }
	/**
	 * ??ID
	 * @param hwOrderId
	 */
	public void setHwOrderId(String hwOrderId){
		this.hwOrderId = hwOrderId;
	}
	
    /**
     * ??ID
     * @return
     */	
    public String getHwOrderId(){
    	return hwOrderId;
    }
	/**
	 * ??ID?????????????ID?????
	 * @param hwGuideId
	 */
	public void setHwGuideId(String hwGuideId){
		this.hwGuideId = hwGuideId;
	}
	
    /**
     * ??ID?????????????ID?????
     * @return
     */	
    public String getHwGuideId(){
    	return hwGuideId;
    }
	/**
	 * ????ID
	 * @param hwDepositId
	 */
	public void setHwDepositId(String hwDepositId){
		this.hwDepositId = hwDepositId;
	}
	
    /**
     * ????ID
     * @return
     */	
    public String getHwDepositId(){
    	return hwDepositId;
    }
	/**
	 * ????ID
	 * @param hwPaySn
	 */
	public void setHwPaySn(Integer hwPaySn){
		this.hwPaySn = hwPaySn;
	}
	
    /**
     * ????ID
     * @return
     */	
    public Integer getHwPaySn(){
    	return hwPaySn;
    }
	/**
	 * ????
	 * @param hwDepositAmount
	 */
	public void setHwDepositAmount(java.math.BigDecimal hwDepositAmount){
		this.hwDepositAmount = hwDepositAmount;
	}
	
    /**
     * ????
     * @return
     */	
    public java.math.BigDecimal getHwDepositAmount(){
    	return hwDepositAmount;
    }
	/**
	 * ?????????????
	 * @param hwState
	 */
	public void setHwState(String hwState){
		this.hwState = hwState;
	}
	
    /**
     * ?????????????
     * @return
     */	
    public String getHwState(){
    	return hwState;
    }
	/**
	 * ????
	 * @param hwActivateTime
	 */
	public void setHwActivateTime(String hwActivateTime){
		this.hwActivateTime = hwActivateTime;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwActivateTime(){
    	return hwActivateTime;
    }
	/**
	 * ??????ID
	 * @param hwOperatorId
	 */
	public void setHwOperatorId(String hwOperatorId){
		this.hwOperatorId = hwOperatorId;
	}
	
    /**
     * ??????ID
     * @return
     */	
    public String getHwOperatorId(){
    	return hwOperatorId;
    }
	/**
	 * ??????ID
	 * @param hwTerminalId
	 */
	public void setHwTerminalId(String hwTerminalId){
		this.hwTerminalId = hwTerminalId;
	}
	
    /**
     * ??????ID
     * @return
     */	
    public String getHwTerminalId(){
    	return hwTerminalId;
    }
	/**
	 * ???????0???????1
	 * @param hwCardCount
	 */
	public void setHwCardCount(String hwCardCount){
		this.hwCardCount = hwCardCount;
	}
	
    /**
     * ???????0???????1
     * @return
     */	
    public String getHwCardCount(){
    	return hwCardCount;
    }
}