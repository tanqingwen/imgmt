package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaint {
	/**
	 *  投诉ID
	 */
	private Long id;
	/**
	 *  投诉人
	 */
	private Long userId;
	/**
	 *  投诉处理起始日期
	 */
	private String startDate;
	/**
	 *  投诉处理结束日期
	 */
	private String endDate;
	/**
	 *  投诉处理进度
	 */
	private String complaintStatus;
	/**
	 *  投诉渠道
	 */
	private String complaintChannel;
	/**
	 *  投诉类型
	 */
	private String complaintType;
	/**
	 *  合同编号
	 */
	private Long contactId;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 投诉ID
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
    /**
     * 投诉ID
     * @return
     */	
    public Long getId(){
    	return id;
    }
	/**
	 * 投诉人
	 * @param userId
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}
	
    /**
     * 投诉人
     * @return
     */	
    public Long getUserId(){
    	return userId;
    }
	/**
	 * 投诉处理起始日期
	 * @param startDate
	 */
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
    /**
     * 投诉处理起始日期
     * @return
     */	
    public String getStartDate(){
    	return startDate;
    }
	/**
	 * 投诉处理结束日期
	 * @param endDate
	 */
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	
    /**
     * 投诉处理结束日期
     * @return
     */	
    public String getEndDate(){
    	return endDate;
    }
	/**
	 * 投诉处理进度
	 * @param complaintStatus
	 */
	public void setComplaintStatus(String complaintStatus){
		this.complaintStatus = complaintStatus;
	}
	
    /**
     * 投诉处理进度
     * @return
     */	
    public String getComplaintStatus(){
    	return complaintStatus;
    }
	/**
	 * 投诉渠道
	 * @param complaintChannel
	 */
	public void setComplaintChannel(String complaintChannel){
		this.complaintChannel = complaintChannel;
	}
	
    /**
     * 投诉渠道
     * @return
     */	
    public String getComplaintChannel(){
    	return complaintChannel;
    }
	/**
	 * 投诉类型
	 * @param complaintType
	 */
	public void setComplaintType(String complaintType){
		this.complaintType = complaintType;
	}
	
    /**
     * 投诉类型
     * @return
     */	
    public String getComplaintType(){
    	return complaintType;
    }
	/**
	 * 合同编号
	 * @param contactId
	 */
	public void setContactId(Long contactId){
		this.contactId = contactId;
	}
	
    /**
     * 合同编号
     * @return
     */	
    public Long getContactId(){
    	return contactId;
    }
	/**
	 * checksum
	 * @param checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}
	
    /**
     * checksum
     * @return
     */	
    public String getChecksum(){
    	return checksum;
    }
}