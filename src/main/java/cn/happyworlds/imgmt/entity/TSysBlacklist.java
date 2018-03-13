package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class TSysBlacklist {
	/**
	 *  
	 */
	private Long id;
	/**
	 *  身份证号码
	 */
	private String idcardNo;
	/**
	 *  平台用户ID
	 */
	private Long userId;
	/**
	 *  手机号码
	 */
	private String mobile;
	/**
	 *  电子邮箱
	 */
	private String email;
	/**
	 *  毕业学校
	 */
	private String school;
	/**
	 *  毕业时间
	 */
	private Integer graduateTime;
	/**
	 *  身份证名称
	 */
	private String idcardName;
	/**
	 *  身份证提供商
	 */
	private Byte vendor;
	/**
	 *  
	 */
	private java.util.Date createTime;
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
    /**
     * 
     * @return
     */	
    public Long getId(){
    	return id;
    }
	/**
	 * 身份证号码
	 * @param idcardNo
	 */
	public void setIdcardNo(String idcardNo){
		this.idcardNo = idcardNo;
	}
	
    /**
     * 身份证号码
     * @return
     */	
    public String getIdcardNo(){
    	return idcardNo;
    }
	/**
	 * 平台用户ID
	 * @param userId
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}
	
    /**
     * 平台用户ID
     * @return
     */	
    public Long getUserId(){
    	return userId;
    }
	/**
	 * 手机号码
	 * @param mobile
	 */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
    /**
     * 手机号码
     * @return
     */	
    public String getMobile(){
    	return mobile;
    }
	/**
	 * 电子邮箱
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
    /**
     * 电子邮箱
     * @return
     */	
    public String getEmail(){
    	return email;
    }
	/**
	 * 毕业学校
	 * @param school
	 */
	public void setSchool(String school){
		this.school = school;
	}
	
    /**
     * 毕业学校
     * @return
     */	
    public String getSchool(){
    	return school;
    }
	/**
	 * 毕业时间
	 * @param graduateTime
	 */
	public void setGraduateTime(Integer graduateTime){
		this.graduateTime = graduateTime;
	}
	
    /**
     * 毕业时间
     * @return
     */	
    public Integer getGraduateTime(){
    	return graduateTime;
    }
	/**
	 * 身份证名称
	 * @param idcardName
	 */
	public void setIdcardName(String idcardName){
		this.idcardName = idcardName;
	}
	
    /**
     * 身份证名称
     * @return
     */	
    public String getIdcardName(){
    	return idcardName;
    }
	/**
	 * 身份证提供商
	 * @param vendor
	 */
	public void setVendor(Byte vendor){
		this.vendor = vendor;
	}
	
    /**
     * 身份证提供商
     * @return
     */	
    public Byte getVendor(){
    	return vendor;
    }
	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
    /**
     * 
     * @return
     */	
    public java.util.Date getCreateTime(){
    	return createTime;
    }
}