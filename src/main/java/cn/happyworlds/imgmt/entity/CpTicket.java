package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpTicket implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Long tkTicketId;
	/**
	 *  
	 */
	private String tkCardNo;
	/**
	 *  
	 */
	private Long tkTicketType;
	/**
	 *  
	 */
	private String tkEffectiveDate;
	/**
	 *  
	 */
	private String tkExpireDate;
	/**
	 *  
	 */
	private String tkActiveDate;
	/**
	 *  
	 */
	private String tkRetriveDate;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param tkTicketId
	 */
	
	private String ticketName ;
	
	private String credentyName;
	
	private String credentyNumber;
	
	private String tkStatus;
	
	//卡流水号
	private String cbRemmenderNo;
	
	
	public String getCbRemmenderNo() {
		return cbRemmenderNo;
	}

	public void setCbRemmenderNo(String cbRemmenderNo) {
		this.cbRemmenderNo = cbRemmenderNo;
	}

	public String getTkStatus() {
		return tkStatus;
	}

	public void setTkStatus(String tkStatus) {
		this.tkStatus = tkStatus;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getCredentyName() {
		return credentyName;
	}

	public void setCredentyName(String credentyName) {
		this.credentyName = credentyName;
	}

	public String getCredentyNumber() {
		return credentyNumber;
	}

	public void setCredentyNumber(String credentyNumber) {
		this.credentyNumber = credentyNumber;
	}

	public void setTkTicketId(Long tkTicketId){
		this.tkTicketId = tkTicketId;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTkTicketId(){
    	return tkTicketId;
    }
	/**
	 * 
	 * @param tkCardNo
	 */
	public void setTkCardNo(String tkCardNo){
		this.tkCardNo = tkCardNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getTkCardNo(){
    	return tkCardNo;
    }
	/**
	 * 
	 * @param tkTicketType
	 */
	public void setTkTicketType(Long tkTicketType){
		this.tkTicketType = tkTicketType;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTkTicketType(){
    	return tkTicketType;
    }
	/**
	 * 
	 * @param tkEffectiveDate
	 */
	public void setTkEffectiveDate(String tkEffectiveDate){
		this.tkEffectiveDate = tkEffectiveDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getTkEffectiveDate(){
    	return tkEffectiveDate;
    }
	/**
	 * 
	 * @param tkExpireDate
	 */
	public void setTkExpireDate(String tkExpireDate){
		this.tkExpireDate = tkExpireDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getTkExpireDate(){
    	return tkExpireDate;
    }
	/**
	 * 
	 * @param tkActiveDate
	 */
	public void setTkActiveDate(String tkActiveDate){
		this.tkActiveDate = tkActiveDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getTkActiveDate(){
    	return tkActiveDate;
    }
	/**
	 * 
	 * @param tkRetriveDate
	 */
	public void setTkRetriveDate(String tkRetriveDate){
		this.tkRetriveDate = tkRetriveDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getTkRetriveDate(){
    	return tkRetriveDate;
    }
	/**
	 * 
	 * @param checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}
	
    /**
     * 
     * @return
     */	
    public String getChecksum(){
    	return checksum;
    }
}