package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaintProcess {
	/**
	 *  投诉信息ID
	 */
	private Long id;
	/**
	 *  投诉id
	 */
	private Long complaintId;
	/**
	 *  登记日期
	 */
	private String recordDate;
	/**
	 *  登记人
	 */
	private String recordUser;
	/**
	 *  跟进人
	 */
	private String followStaffId;
	/**
	 *  跟进详情
	 */
	private String messageText;
	/**
	 *  要求回电手机
	 */
	private String replyPhone;
	/**
	 *  上一阶段
	 */
	private Long previousStep;
	/**
	 *  当前阶段
	 */
	private Long currentStep;
	/**
	 *  下一阶段
	 */
	private Long nextStep;
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
	private Long complaintJudge;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 投诉信息ID
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
    /**
     * 投诉信息ID
     * @return
     */	
    public Long getId(){
    	return id;
    }
	/**
	 * 投诉id
	 * @param complaintId
	 */
	public void setComplaintId(Long complaintId){
		this.complaintId = complaintId;
	}
	
    /**
     * 投诉id
     * @return
     */	
    public Long getComplaintId(){
    	return complaintId;
    }
	/**
	 * 登记日期
	 * @param recordDate
	 */
	public void setRecordDate(String recordDate){
		this.recordDate = recordDate;
	}
	
    /**
     * 登记日期
     * @return
     */	
    public String getRecordDate(){
    	return recordDate;
    }
	/**
	 * 登记人
	 * @param recordUser
	 */
	public void setRecordUser(String recordUser){
		this.recordUser = recordUser;
	}
	
    /**
     * 登记人
     * @return
     */	
    public String getRecordUser(){
    	return recordUser;
    }
	/**
	 * 跟进人
	 * @param followStaffId
	 */
	public void setFollowStaffId(String followStaffId){
		this.followStaffId = followStaffId;
	}
	
    /**
     * 跟进人
     * @return
     */	
    public String getFollowStaffId(){
    	return followStaffId;
    }
	/**
	 * 跟进详情
	 * @param messageText
	 */
	public void setMessageText(String messageText){
		this.messageText = messageText;
	}
	
    /**
     * 跟进详情
     * @return
     */	
    public String getMessageText(){
    	return messageText;
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
	 * 上一阶段
	 * @param previousStep
	 */
	public void setPreviousStep(Long previousStep){
		this.previousStep = previousStep;
	}
	
    /**
     * 上一阶段
     * @return
     */	
    public Long getPreviousStep(){
    	return previousStep;
    }
	/**
	 * 当前阶段
	 * @param currentStep
	 */
	public void setCurrentStep(Long currentStep){
		this.currentStep = currentStep;
	}
	
    /**
     * 当前阶段
     * @return
     */	
    public Long getCurrentStep(){
    	return currentStep;
    }
	/**
	 * 下一阶段
	 * @param nextStep
	 */
	public void setNextStep(Long nextStep){
		this.nextStep = nextStep;
	}
	
    /**
     * 下一阶段
     * @return
     */	
    public Long getNextStep(){
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
	 * @param complaintJudge
	 */
	public void setComplaintJudge(Long complaintJudge){
		this.complaintJudge = complaintJudge;
	}
	
    /**
     * 投诉判断
     * @return
     */	
    public Long getComplaintJudge(){
    	return complaintJudge;
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