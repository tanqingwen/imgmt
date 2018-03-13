package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MPhoneRepository {
	/**
	 *  电话仓库ID
	 */
	private String id;
	/**
	 *  客户id
	 */
	private Long customerId;
	/**
	 *  联系类型
	 */
	private String contactType;
	/**
	 *  区号
	 */
	private String phoneAreaCode;
	/**
	 *  电话
	 */
	private String phoneNo;
	/**
	 *  持有人姓名
	 */
	private String customerName;
	/**
	 *  电话状态
	 */
	private String status;
	/**
	 *  是否首要联系方式
	 */
	private String isMajor;
	/**
	 *  是否验证
	 */
	private String isValidated;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 电话仓库ID
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	
    /**
     * 电话仓库ID
     * @return
     */	
    public String getId(){
    	return id;
    }
	/**
	 * 客户id
	 * @param customerId
	 */
	public void setCustomerId(Long customerId){
		this.customerId = customerId;
	}
	
    /**
     * 客户id
     * @return
     */	
    public Long getCustomerId(){
    	return customerId;
    }
	/**
	 * 联系类型
	 * @param contactType
	 */
	public void setContactType(String contactType){
		this.contactType = contactType;
	}
	
    /**
     * 联系类型
     * @return
     */	
    public String getContactType(){
    	return contactType;
    }
	/**
	 * 区号
	 * @param phoneAreaCode
	 */
	public void setPhoneAreaCode(String phoneAreaCode){
		this.phoneAreaCode = phoneAreaCode;
	}
	
    /**
     * 区号
     * @return
     */	
    public String getPhoneAreaCode(){
    	return phoneAreaCode;
    }
	/**
	 * 电话
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}
	
    /**
     * 电话
     * @return
     */	
    public String getPhoneNo(){
    	return phoneNo;
    }
	/**
	 * 持有人姓名
	 * @param customerName
	 */
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	
    /**
     * 持有人姓名
     * @return
     */	
    public String getCustomerName(){
    	return customerName;
    }
	/**
	 * 电话状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 电话状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
	/**
	 * 是否首要联系方式
	 * @param isMajor
	 */
	public void setIsMajor(String isMajor){
		this.isMajor = isMajor;
	}
	
    /**
     * 是否首要联系方式
     * @return
     */	
    public String getIsMajor(){
    	return isMajor;
    }
	/**
	 * 是否验证
	 * @param isValidated
	 */
	public void setIsValidated(String isValidated){
		this.isValidated = isValidated;
	}
	
    /**
     * 是否验证
     * @return
     */	
    public String getIsValidated(){
    	return isValidated;
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