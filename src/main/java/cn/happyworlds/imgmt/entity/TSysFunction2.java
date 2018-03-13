package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class TSysFunction2 implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  权限ID
	 */
	private Integer funtId;
	/**
	 *  父级权限ID
	 */
	private Integer funtParentId;
	/**
	 *  角色ID
	 */
	private String id;
	/**
	 *  功能名称
	 */
	private String name;
	/**
	 *  级别
	 */
	private Integer funtLevel;
	/**
	 *  创建时间
	 */
	private String funtCreateDate;
	/**
	 *  修改时间
	 */
	private String funtUpdateData;
	/**
	 *  创建人
	 */
	private String funtCreateBy;
	/**
	 *  更新人
	 */
	private String funtUpdateBy;
	/**
	 *  功能模块
	 */
	private String module;
	/**
	 *  功能名称
	 */
	private String remark;
	/**
	 * 权限ID
	 * @param funtId
	 */
	public void setFuntId(Integer funtId){
		this.funtId = funtId;
	}
	
    /**
     * 权限ID
     * @return
     */	
    public Integer getFuntId(){
    	return funtId;
    }
	/**
	 * 父级权限ID
	 * @param funtParentId
	 */
	public void setFuntParentId(Integer funtParentId){
		this.funtParentId = funtParentId;
	}
	
    /**
     * 父级权限ID
     * @return
     */	
    public Integer getFuntParentId(){
    	return funtParentId;
    }
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
	 * 功能名称
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 功能名称
     * @return
     */	
    public String getName(){
    	return name;
    }
	/**
	 * 级别
	 * @param funtLevel
	 */
	public void setFuntLevel(Integer funtLevel){
		this.funtLevel = funtLevel;
	}
	
    /**
     * 级别
     * @return
     */	
    public Integer getFuntLevel(){
    	return funtLevel;
    }
	/**
	 * 创建时间
	 * @param funtCreateDate
	 */
	public void setFuntCreateDate(String funtCreateDate){
		this.funtCreateDate = funtCreateDate;
	}
	
    /**
     * 创建时间
     * @return
     */	
    public String getFuntCreateDate(){
    	return funtCreateDate;
    }
	/**
	 * 修改时间
	 * @param funtUpdateData
	 */
	public void setFuntUpdateData(String funtUpdateData){
		this.funtUpdateData = funtUpdateData;
	}
	
    /**
     * 修改时间
     * @return
     */	
    public String getFuntUpdateData(){
    	return funtUpdateData;
    }
	/**
	 * 创建人
	 * @param funtCreateBy
	 */
	public void setFuntCreateBy(String funtCreateBy){
		this.funtCreateBy = funtCreateBy;
	}
	
    /**
     * 创建人
     * @return
     */	
    public String getFuntCreateBy(){
    	return funtCreateBy;
    }
	/**
	 * 更新人
	 * @param funtUpdateBy
	 */
	public void setFuntUpdateBy(String funtUpdateBy){
		this.funtUpdateBy = funtUpdateBy;
	}
	
    /**
     * 更新人
     * @return
     */	
    public String getFuntUpdateBy(){
    	return funtUpdateBy;
    }
	/**
	 * 功能模块
	 * @param module
	 */
	public void setModule(String module){
		this.module = module;
	}
	
    /**
     * 功能模块
     * @return
     */	
    public String getModule(){
    	return module;
    }
	/**
	 * 功能名称
	 * @param remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
    /**
     * 功能名称
     * @return
     */	
    public String getRemark(){
    	return remark;
    }
}