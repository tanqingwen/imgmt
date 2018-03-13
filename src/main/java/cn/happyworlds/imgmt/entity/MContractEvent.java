package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MContractEvent {
	/**
	 *  分配编号
	 */
	private Long eventId;
	/**
	 *  合同id
	 */
	private Long contractId;
	/**
	 *  线下真实合同编号
	 */
	private String contractNo;
	/**
	 *  事件类型
	 */
	private String eventType;
	/**
	 *  事件类型
	 */
	private String eventContent;
	/**
	 *  创建部门
	 */
	private String department;
	/**
	 *  创建时间
	 */
	private String createdAt;
	/**
	 *  更新时间
	 */
	private String updatedAt;
	/**
	 *  创建人
	 */
	private String createdBy;
	/**
	 *  更新人
	 */
	private String updatedBy;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 分配编号
	 * @param eventId
	 */
	public void setEventId(Long eventId){
		this.eventId = eventId;
	}
	
    /**
     * 分配编号
     * @return
     */	
    public Long getEventId(){
    	return eventId;
    }
	/**
	 * 合同id
	 * @param contractId
	 */
	public void setContractId(Long contractId){
		this.contractId = contractId;
	}
	
    /**
     * 合同id
     * @return
     */	
    public Long getContractId(){
    	return contractId;
    }
	/**
	 * 线下真实合同编号
	 * @param contractNo
	 */
	public void setContractNo(String contractNo){
		this.contractNo = contractNo;
	}
	
    /**
     * 线下真实合同编号
     * @return
     */	
    public String getContractNo(){
    	return contractNo;
    }
	/**
	 * 事件类型
	 * @param eventType
	 */
	public void setEventType(String eventType){
		this.eventType = eventType;
	}
	
    /**
     * 事件类型
     * @return
     */	
    public String getEventType(){
    	return eventType;
    }
	/**
	 * 事件类型
	 * @param eventContent
	 */
	public void setEventContent(String eventContent){
		this.eventContent = eventContent;
	}
	
    /**
     * 事件类型
     * @return
     */	
    public String getEventContent(){
    	return eventContent;
    }
	/**
	 * 创建部门
	 * @param department
	 */
	public void setDepartment(String department){
		this.department = department;
	}
	
    /**
     * 创建部门
     * @return
     */	
    public String getDepartment(){
    	return department;
    }
	/**
	 * 创建时间
	 * @param createdAt
	 */
	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}
	
    /**
     * 创建时间
     * @return
     */	
    public String getCreatedAt(){
    	return createdAt;
    }
	/**
	 * 更新时间
	 * @param updatedAt
	 */
	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}
	
    /**
     * 更新时间
     * @return
     */	
    public String getUpdatedAt(){
    	return updatedAt;
    }
	/**
	 * 创建人
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;
	}
	
    /**
     * 创建人
     * @return
     */	
    public String getCreatedBy(){
    	return createdBy;
    }
	/**
	 * 更新人
	 * @param updatedBy
	 */
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;
	}
	
    /**
     * 更新人
     * @return
     */	
    public String getUpdatedBy(){
    	return updatedBy;
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