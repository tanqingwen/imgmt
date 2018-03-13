package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class YwTicket implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  ????????
	 */
	private String hwTicketCode;
	/**
	 *  ??ID
	 */
	private String hwMemberId;
	/**
	 *  ??????????
	 */
	private String hwTicketPeriod;
	/**
	 *  ?????????????
	 */
	private String hwTicketStartdate;
	/**
	 *  ?????????????
	 */
	private String hwTicketExpirydate;
	/**
	 *  ??
	 */
	private String hwCardNumber;
	/**
	 *  ??????????????
	 */
	private String hwTicketState;
	/**
	 *  ??ID
	 */
	private String hwBrakeId;
	/**
	 *  ????ID: ??????????ID
	 */
	private String hwEnterGateId;
	/**
	 *  ??????:????????
	 */
	private String hwEnterGateTime;
	/**
	 *  ????????ID
	 */
	private String hwOutGateId;
	/**
	 *  ????????
	 */
	private String hwOutGateTime;
	/**
	 * ????????
	 * @param hwTicketCode
	 */
	public void setHwTicketCode(String hwTicketCode){
		this.hwTicketCode = hwTicketCode;
	}
	
    /**
     * ????????
     * @return
     */	
    public String getHwTicketCode(){
    	return hwTicketCode;
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
	 * ??????????
	 * @param hwTicketPeriod
	 */
	public void setHwTicketPeriod(String hwTicketPeriod){
		this.hwTicketPeriod = hwTicketPeriod;
	}
	
    /**
     * ??????????
     * @return
     */	
    public String getHwTicketPeriod(){
    	return hwTicketPeriod;
    }
	/**
	 * ?????????????
	 * @param hwTicketStartdate
	 */
	public void setHwTicketStartdate(String hwTicketStartdate){
		this.hwTicketStartdate = hwTicketStartdate;
	}
	
    /**
     * ?????????????
     * @return
     */	
    public String getHwTicketStartdate(){
    	return hwTicketStartdate;
    }
	/**
	 * ?????????????
	 * @param hwTicketExpirydate
	 */
	public void setHwTicketExpirydate(String hwTicketExpirydate){
		this.hwTicketExpirydate = hwTicketExpirydate;
	}
	
    /**
     * ?????????????
     * @return
     */	
    public String getHwTicketExpirydate(){
    	return hwTicketExpirydate;
    }
	/**
	 * ??
	 * @param hwCardNumber
	 */
	public void setHwCardNumber(String hwCardNumber){
		this.hwCardNumber = hwCardNumber;
	}
	
    /**
     * ??
     * @return
     */	
    public String getHwCardNumber(){
    	return hwCardNumber;
    }
	/**
	 * ??????????????
	 * @param hwTicketState
	 */
	public void setHwTicketState(String hwTicketState){
		this.hwTicketState = hwTicketState;
	}
	
    /**
     * ??????????????
     * @return
     */	
    public String getHwTicketState(){
    	return hwTicketState;
    }
	/**
	 * ??ID
	 * @param hwBrakeId
	 */
	public void setHwBrakeId(String hwBrakeId){
		this.hwBrakeId = hwBrakeId;
	}
	
    /**
     * ??ID
     * @return
     */	
    public String getHwBrakeId(){
    	return hwBrakeId;
    }
	/**
	 * ????ID: ??????????ID
	 * @param hwEnterGateId
	 */
	public void setHwEnterGateId(String hwEnterGateId){
		this.hwEnterGateId = hwEnterGateId;
	}
	
    /**
     * ????ID: ??????????ID
     * @return
     */	
    public String getHwEnterGateId(){
    	return hwEnterGateId;
    }
	/**
	 * ??????:????????
	 * @param hwEnterGateTime
	 */
	public void setHwEnterGateTime(String hwEnterGateTime){
		this.hwEnterGateTime = hwEnterGateTime;
	}
	
    /**
     * ??????:????????
     * @return
     */	
    public String getHwEnterGateTime(){
    	return hwEnterGateTime;
    }
	/**
	 * ????????ID
	 * @param hwOutGateId
	 */
	public void setHwOutGateId(String hwOutGateId){
		this.hwOutGateId = hwOutGateId;
	}
	
    /**
     * ????????ID
     * @return
     */	
    public String getHwOutGateId(){
    	return hwOutGateId;
    }
	/**
	 * ????????
	 * @param hwOutGateTime
	 */
	public void setHwOutGateTime(String hwOutGateTime){
		this.hwOutGateTime = hwOutGateTime;
	}
	
    /**
     * ????????
     * @return
     */	
    public String getHwOutGateTime(){
    	return hwOutGateTime;
    }
}