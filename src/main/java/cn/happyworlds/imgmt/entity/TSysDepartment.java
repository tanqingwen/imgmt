package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author yanjy
 */
public class TSysDepartment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 *  部门ID
	 */
	private String deptId;
	/**
	 *  父级部门ID
	 */
	private String deptParentId;
	/**
	 *  部门名称
	 */
	private String deptName;
	/**
	 *  级别
	 */
	private String deptLevel;
	/**
	 *  部门描述
	 */
	private String deptRemark;
	/**
	 *  部门状态
	 */
	private String deptStatus;
	/**
	 *  创建时间
	 */
	private String deptCreateDate;
	/**
	 *  更新时间
	 */
	private String deptUpdateDate;
	/**
	 *  创建人
	 */
	private String deptCreateBy;
	/**
	 *  更新人
	 */
	private String deptUpdateBy;
	/**
	 * 部门ID
	 * @param deptId
	 */
	public void setDeptId(String deptId){
		this.deptId = deptId;
	}
	
    /**
     * 部门ID
     * @return
     */	
    public String getDeptId(){
    	return deptId;
    }
	/**
	 * 父级部门ID
	 * @param deptParentId
	 */
	public void setDeptParentId(String deptParentId){
		this.deptParentId = deptParentId;
	}
	
    /**
     * 父级部门ID
     * @return
     */	
    public String getDeptParentId(){
    	return deptParentId;
    }
	/**
	 * 部门名称
	 * @param deptName
	 */
	public void setDeptName(String deptName){
		this.deptName = deptName;
	}
	
    /**
     * 部门名称
     * @return
     */	
    public String getDeptName(){
    	return deptName;
    }
	/**
	 * 级别
	 * @param deptLevel
	 */
	public void setDeptLevel(String deptLevel){
		this.deptLevel = deptLevel;
	}
	
    /**
     * 级别
     * @return
     */	
    public String getDeptLevel(){
    	return deptLevel;
    }
	/**
	 * 部门描述
	 * @param deptRemark
	 */
	public void setDeptRemark(String deptRemark){
		this.deptRemark = deptRemark;
	}
	
    /**
     * 部门描述
     * @return
     */	
    public String getDeptRemark(){
    	return deptRemark;
    }
	/**
	 * 部门状态
	 * @param deptStatus
	 */
	public void setDeptStatus(String deptStatus){
		this.deptStatus = deptStatus;
	}
	
    /**
     * 部门状态
     * @return
     */	
    public String getDeptStatus(){
    	return deptStatus;
    }
	/**
	 * 创建时间
	 * @param deptCreateDate
	 */
	public void setDeptCreateDate(String deptCreateDate){
		this.deptCreateDate = deptCreateDate;
	}
	
    /**
     * 创建时间
     * @return
     */	
    public String getDeptCreateDate(){
    	return deptCreateDate;
    }
	/**
	 * 更新时间
	 * @param deptUpdateDate
	 */
	public void setDeptUpdateDate(String deptUpdateDate){
		this.deptUpdateDate = deptUpdateDate;
	}
	
    /**
     * 更新时间
     * @return
     */	
    public String getDeptUpdateDate(){
    	return deptUpdateDate;
    }
	/**
	 * 创建人
	 * @param deptCreateBy
	 */
	public void setDeptCreateBy(String deptCreateBy){
		this.deptCreateBy = deptCreateBy;
	}
	
    /**
     * 创建人
     * @return
     */	
    public String getDeptCreateBy(){
    	return deptCreateBy;
    }
	/**
	 * 更新人
	 * @param deptUpdateBy
	 */
	public void setDeptUpdateBy(String deptUpdateBy){
		this.deptUpdateBy = deptUpdateBy;
	}
	
    /**
     * 更新人
     * @return
     */	
    public String getDeptUpdateBy(){
    	return deptUpdateBy;
    }
}