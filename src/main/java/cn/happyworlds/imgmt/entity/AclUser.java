package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class AclUser implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String userId;
	/**
	 *  
	 */
	private String userName;
	/**
	 *  
	 */
	private String userPasswd;
	/**
	 *  
	 */
	private String status;
	/**
	 *  
	 */
	private String depName;
	/**
	 *  
	 */
	private String occupation;
	/**
	 *  
	 */
	private String emailId;
	/**
	 *  
	 */
	private String contactNo;
	/**
	 *  
	 */
	private String passwordCreTime;
	/**
	 *  
	 */
	private String passwordExpTime;
	/**
	 *  
	 */
	private Long failCount;
	/**
	 *  
	 */
	private String modifyTime;
	/**
	 *  
	 */
	private String modifyBy;
	/**
	 *  
	 */
	private Long comPort;
	/**
	 * 
	 * @param userId
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	
    /**
     * 
     * @return
     */	
    public String getUserId(){
    	return userId;
    }
	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
	
    /**
     * 
     * @return
     */	
    public String getUserName(){
    	return userName;
    }
	/**
	 * 
	 * @param userPasswd
	 */
	public void setUserPasswd(String userPasswd){
		this.userPasswd = userPasswd;
	}
	
    /**
     * 
     * @return
     */	
    public String getUserPasswd(){
    	return userPasswd;
    }
	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 
     * @return
     */	
    public String getStatus(){
    	return status;
    }
	/**
	 * 
	 * @param depName
	 */
	public void setDepName(String depName){
		this.depName = depName;
	}
	
    /**
     * 
     * @return
     */	
    public String getDepName(){
    	return depName;
    }
	/**
	 * 
	 * @param occupation
	 */
	public void setOccupation(String occupation){
		this.occupation = occupation;
	}
	
    /**
     * 
     * @return
     */	
    public String getOccupation(){
    	return occupation;
    }
	/**
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId){
		this.emailId = emailId;
	}
	
    /**
     * 
     * @return
     */	
    public String getEmailId(){
    	return emailId;
    }
	/**
	 * 
	 * @param contactNo
	 */
	public void setContactNo(String contactNo){
		this.contactNo = contactNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getContactNo(){
    	return contactNo;
    }
	/**
	 * 
	 * @param passwordCreTime
	 */
	public void setPasswordCreTime(String passwordCreTime){
		this.passwordCreTime = passwordCreTime;
	}
	
    /**
     * 
     * @return
     */	
    public String getPasswordCreTime(){
    	return passwordCreTime;
    }
	/**
	 * 
	 * @param passwordExpTime
	 */
	public void setPasswordExpTime(String passwordExpTime){
		this.passwordExpTime = passwordExpTime;
	}
	
    /**
     * 
     * @return
     */	
    public String getPasswordExpTime(){
    	return passwordExpTime;
    }
	/**
	 * 
	 * @param failCount
	 */
	public void setFailCount(Long failCount){
		this.failCount = failCount;
	}
	
    /**
     * 
     * @return
     */	
    public Long getFailCount(){
    	return failCount;
    }
	/**
	 * 
	 * @param modifyTime
	 */
	public void setModifyTime(String modifyTime){
		this.modifyTime = modifyTime;
	}
	
    /**
     * 
     * @return
     */	
    public String getModifyTime(){
    	return modifyTime;
    }
	/**
	 * 
	 * @param modifyBy
	 */
	public void setModifyBy(String modifyBy){
		this.modifyBy = modifyBy;
	}
	
    /**
     * 
     * @return
     */	
    public String getModifyBy(){
    	return modifyBy;
    }
	/**
	 * 
	 * @param comPort
	 */
	public void setComPort(Long comPort){
		this.comPort = comPort;
	}
	
    /**
     * 
     * @return
     */	
    public Long getComPort(){
    	return comPort;
    }
}