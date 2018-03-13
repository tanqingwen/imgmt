package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class AppTicket implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String ticketId;
	/**
	 *  
	 */
	private String ticketTimeId;
	/**
	 *  
	 */
	private String ticketAddressId;
	/**
	 *  
	 */
	private String ticketAgeId;
	/**
	 *  
	 */
	private String ticketStatus;
	/**
	 *  
	 */
	private String ticketStarttime;
	/**
	 *  
	 */
	private String ticketSendtime;
	/**
	 *  
	 */
	private String ticketEdittime;
	/**
	 *  
	 */
	private String mobileNumber;
	/**
	 * 
	 * @param ticketId
	 */
	public void setTicketId(String ticketId){
		this.ticketId = ticketId;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketId(){
    	return ticketId;
    }
	/**
	 * 
	 * @param ticketTimeId
	 */
	public void setTicketTimeId(String ticketTimeId){
		this.ticketTimeId = ticketTimeId;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketTimeId(){
    	return ticketTimeId;
    }
	/**
	 * 
	 * @param ticketAddressId
	 */
	public void setTicketAddressId(String ticketAddressId){
		this.ticketAddressId = ticketAddressId;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketAddressId(){
    	return ticketAddressId;
    }
	/**
	 * 
	 * @param ticketAgeId
	 */
	public void setTicketAgeId(String ticketAgeId){
		this.ticketAgeId = ticketAgeId;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketAgeId(){
    	return ticketAgeId;
    }
	/**
	 * 
	 * @param ticketStatus
	 */
	public void setTicketStatus(String ticketStatus){
		this.ticketStatus = ticketStatus;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketStatus(){
    	return ticketStatus;
    }
	/**
	 * 
	 * @param ticketStarttime
	 */
	public void setTicketStarttime(String ticketStarttime){
		this.ticketStarttime = ticketStarttime;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketStarttime(){
    	return ticketStarttime;
    }
	/**
	 * 
	 * @param ticketSendtime
	 */
	public void setTicketSendtime(String ticketSendtime){
		this.ticketSendtime = ticketSendtime;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketSendtime(){
    	return ticketSendtime;
    }
	/**
	 * 
	 * @param ticketEdittime
	 */
	public void setTicketEdittime(String ticketEdittime){
		this.ticketEdittime = ticketEdittime;
	}
	
    /**
     * 
     * @return
     */	
    public String getTicketEdittime(){
    	return ticketEdittime;
    }
	/**
	 * 
	 * @param mobileNumber
	 */
	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}
	
    /**
     * 
     * @return
     */	
    public String getMobileNumber(){
    	return mobileNumber;
    }
}