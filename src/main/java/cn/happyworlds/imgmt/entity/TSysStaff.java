package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class TSysStaff {
	/**
	 *  员工ID
	 */
	private String id;
	/**
	 *  登录密码
	 */
	private String password;
	/**
	 *  角色列表
	 */
	private String roles;
	/**
	 *  员工机构
	 */
	private String organizations;
	
	private String OrgName;
	/**
	 *  员工状态
	 */
	private String status;
	/**
	 *  密码错误次数
	 */
	private Integer pwdFailCnt;
	/**
	 *  TOTP密钥
	 */
	private String totpKey;
	/**
	 *  员工姓名
	 */
	private String name;
	/**
	 *  员工邮箱
	 */
	private String email;
	/**
	 *  员工姓别
	 */
	private String gender;
	/**
	 *  员工电话号码
	 */
	private String phoneNumber;
	/**
	 *  最后登录时间
	 */
	private String lastLoginAt;
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
	 * 员工ID
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	
    /**
     * 员工ID
     * @return
     */	
    public String getId(){
    	return id;
    }
	/**
	 * 登录密码
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
    /**
     * 登录密码
     * @return
     */	
    public String getPassword(){
    	return password;
    }
	/**
	 * 角色列表
	 * @param roles
	 */
	public void setRoles(String roles){
		this.roles = roles;
	}
	
    /**
     * 角色列表
     * @return
     */	
    public String getRoles(){
    	return roles;
    }
	/**
	 * 员工机构
	 * @param organizations
	 */
	public void setOrganizations(String organizations){
		this.organizations = organizations;
	}
	
    /**
     * 员工机构
     * @return
     */	
    public String getOrganizations(){
    	return organizations;
    }
	/**
	 * 员工状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 员工状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
	/**
	 * 密码错误次数
	 * @param pwdFailCnt
	 */
	public void setPwdFailCnt(Integer pwdFailCnt){
		this.pwdFailCnt = pwdFailCnt;
	}
	
    /**
     * 密码错误次数
     * @return
     */	
    public Integer getPwdFailCnt(){
    	return pwdFailCnt;
    }
	/**
	 * TOTP密钥
	 * @param totpKey
	 */
	public void setTotpKey(String totpKey){
		this.totpKey = totpKey;
	}
	
    /**
     * TOTP密钥
     * @return
     */	
    public String getTotpKey(){
    	return totpKey;
    }
	/**
	 * 员工姓名
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 员工姓名
     * @return
     */	
    public String getName(){
    	return name;
    }
	/**
	 * 员工邮箱
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
    /**
     * 员工邮箱
     * @return
     */	
    public String getEmail(){
    	return email;
    }
	/**
	 * 员工姓别
	 * @param gender
	 */
	public void setGender(String gender){
		this.gender = gender;
	}
	
    /**
     * 员工姓别
     * @return
     */	
    public String getGender(){
    	return gender;
    }
	/**
	 * 员工电话号码
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
    /**
     * 员工电话号码
     * @return
     */	
    public String getPhoneNumber(){
    	return phoneNumber;
    }
	/**
	 * 最后登录时间
	 * @param lastLoginAt
	 */
	public void setLastLoginAt(String lastLoginAt){
		this.lastLoginAt = lastLoginAt;
	}
	
    /**
     * 最后登录时间
     * @return
     */	
    public String getLastLoginAt(){
    	return lastLoginAt;
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

	public String getOrgName() {
		return OrgName;
	}

	public void setOrgName(String orgName) {
		OrgName = orgName;
	}
    
    
}