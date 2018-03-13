package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplianceProcess {
	/**
	 *  投诉ID
	 */
	private String id;
	/**
	 *  投诉人
	 */
	private Long userId;
	/**
	 *  投诉日期
	 */
	private String complianceDate;
	/**
	 *  投诉渠道
	 */
	private String complianceChannel;
	/**
	 *  投诉类型
	 */
	private String complianceType;
	/**
	 *  要求回电手机
	 */
	private String replyPhone;
	/**
	 *  合同编号
	 */
	private Long contactId;
	/**
	 *  上一阶段
	 */
	private String lastStep;
	/**
	 *  当前阶段
	 */
	private String currentStep;
	/**
	 *  下一阶段
	 */
	private String nextStep;
	/**
	 *  跟进部门
	 */
	private String followDepartment;
	/**
	 *  收到部门反馈
	 */
	private String receiveDepartment;
	/**
	 *  投诉判断
	 */
	private String complianceJudge;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 投诉ID
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	
    /**
     * 投诉ID
     * @return
     */	
    public String getId(){
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
	 * 投诉日期
	 * @param complianceDate
	 */
	public void setComplianceDate(String complianceDate){
		this.complianceDate = complianceDate;
	}
	
    /**
     * 投诉日期
     * @return
     */	
    public String getComplianceDate(){
    	return complianceDate;
    }
	/**
	 * 投诉渠道
	 * @param complianceChannel
	 */
	public void setComplianceChannel(String complianceChannel){
		this.complianceChannel = complianceChannel;
	}
	
    /**
     * 投诉渠道
     * @return
     */	
    public String getComplianceChannel(){
    	return complianceChannel;
    }
	/**
	 * 投诉类型
	 * @param complianceType
	 */
	public void setComplianceType(String complianceType){
		this.complianceType = complianceType;
	}
	
    /**
     * 投诉类型
     * @return
     */	
    public String getComplianceType(){
    	return complianceType;
    }
	/**
	 * 要求回电手机
	 * @param replyPhone
	 */
	public void setReplyPhone(String replyPhone){
		this.replyPhone = replyPhone;
	}
	
    /**
     * 要求回电手机
     * @return
     */	
    public String getReplyPhone(){
    	return replyPhone;
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
	 * 上一阶段
	 * @param lastStep
	 */
	public void setLastStep(String lastStep){
		this.lastStep = lastStep;
	}
	
    /**
     * 上一阶段
     * @return
     */	
    public String getLastStep(){
    	return lastStep;
    }
	/**
	 * 当前阶段
	 * @param currentStep
	 */
	public void setCurrentStep(String currentStep){
		this.currentStep = currentStep;
	}
	
    /**
     * 当前阶段
     * @return
     */	
    public String getCurrentStep(){
    	return currentStep;
    }
	/**
	 * 下一阶段
	 * @param nextStep
	 */
	public void setNextStep(String nextStep){
		this.nextStep = nextStep;
	}
	
    /**
     * 下一阶段
     * @return
     */	
    public String getNextStep(){
    	return nextStep;
    }
	/**
	 * 跟进部门
	 * @param followDepartment
	 */
	public void setFollowDepartment(String followDepartment){
		this.followDepartment = followDepartment;
	}
	
    /**
     * 跟进部门
     * @return
     */	
    public String getFollowDepartment(){
    	return followDepartment;
    }
	/**
	 * 收到部门反馈
	 * @param receiveDepartment
	 */
	public void setReceiveDepartment(String receiveDepartment){
		this.receiveDepartment = receiveDepartment;
	}
	
    /**
     * 收到部门反馈
     * @return
     */	
    public String getReceiveDepartment(){
    	return receiveDepartment;
    }
	/**
	 * 投诉判断
	 * @param complianceJudge
	 */
	public void setComplianceJudge(String complianceJudge){
		this.complianceJudge = complianceJudge;
	}
	
    /**
     * 投诉判断
     * @return
     */	
    public String getComplianceJudge(){
    	return complianceJudge;
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