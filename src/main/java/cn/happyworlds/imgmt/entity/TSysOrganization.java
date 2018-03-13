package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class TSysOrganization {
	/**
	 *  机构ID
	 */
	private String id;
	/**
	 *  父级机构ID
	 */
	private String parentId;
	/**
	 *  机构名称
	 */
	private String name;
	/**
	 *  级别
	 */
	private String levelId;
	/**
	 *  机构描述
	 */
	private String remark;
	/**
	 *  机构状态
	 */
	private String status;
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
	 * 机构ID
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	
    /**
     * 机构ID
     * @return
     */	
    public String getId(){
    	return id;
    }
	/**
	 * 父级机构ID
	 * @param parentId
	 */
	public void setParentId(String parentId){
		this.parentId = parentId;
	}
	
    /**
     * 父级机构ID
     * @return
     */	
    public String getParentId(){
    	return parentId;
    }
	/**
	 * 机构名称
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 机构名称
     * @return
     */	
    public String getName(){
    	return name;
    }
	/**
	 * 级别
	 * @param levelId
	 */
	public void setLevelId(String levelId){
		this.levelId = levelId;
	}
	
    /**
     * 级别
     * @return
     */	
    public String getLevelId(){
    	return levelId;
    }
	/**
	 * 机构描述
	 * @param remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
    /**
     * 机构描述
     * @return
     */	
    public String getRemark(){
    	return remark;
    }
	/**
	 * 机构状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 机构状态
     * @return
     */	
    public String getStatus(){
    	return status;
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