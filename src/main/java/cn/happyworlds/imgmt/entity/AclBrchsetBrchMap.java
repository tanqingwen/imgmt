package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author YanJiangyuan,160907
 */
public class AclBrchsetBrchMap implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String branchId;
	/**
	 *  
	 */
	private String branchSetId;
	/**
	 *  
	 */
	private String sysFlag;
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
	 * @param branchId
	 */
	public void setBranchId(String branchId){
		this.branchId = branchId;
	}
	
    /**
     * 
     * @return
     */	
    public String getBranchId(){
    	return branchId;
    }
	/**
	 * 
	 * @param branchSetId
	 */
	public void setBranchSetId(String branchSetId){
		this.branchSetId = branchSetId;
	}
	
    /**
     * 
     * @return
     */	
    public String getBranchSetId(){
    	return branchSetId;
    }
	/**
	 * 
	 * @param sysFlag
	 */
	public void setSysFlag(String sysFlag){
		this.sysFlag = sysFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getSysFlag(){
    	return sysFlag;
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
}