package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class TSysRole {
	/**
	 *  角色ID
	 */
	private String id;
	/**
	 *  角色名称
	 */
	private String name;
	/**
	 *  功能列表
	 */
	private String functions;
	/**
	 *  角色状态
	 */
	private String status;
	/**
	 *  参数描述
	 */
	private String remark;
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
	 * 角色ID
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	
    /**
     * 角色ID
     * @return
     */	
    public String getId(){
    	return id;
    }
	/**
	 * 角色名称
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 角色名称
     * @return
     */	
    public String getName(){
    	return name;
    }
	/**
	 * 功能列表
	 * @param functions
	 */
	public void setFunctions(String functions){
		this.functions = functions;
	}
	
    /**
     * 功能列表
     * @return
     */	
    public String getFunctions(){
    	return functions;
    }
	/**
	 * 角色状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 角色状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
	/**
	 * 参数描述
	 * @param remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
    /**
     * 参数描述
     * @return
     */	
    public String getRemark(){
    	return remark;
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
}