package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author zhoupeng
 */
public class CpBrchid implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String brBranchId;
	/**
	 *  
	 */
	private String brBranchName;
	/**
	 *  
	 */
	private String brCostCentre;
	/**
	 *  
	 */
	private String brUserId;
	/**
	 *  
	 */
	private String brModDate;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param brBranchId
	 */
	public void setBrBranchId(String brBranchId){
		this.brBranchId = brBranchId;
	}
	
    /**
     * 
     * @return
     */	
    public String getBrBranchId(){
    	return brBranchId;
    }
	/**
	 * 
	 * @param brBranchName
	 */
	public void setBrBranchName(String brBranchName){
		this.brBranchName = brBranchName;
	}
	
    /**
     * 
     * @return
     */	
    public String getBrBranchName(){
    	return brBranchName;
    }
	/**
	 * 
	 * @param brCostCentre
	 */
	public void setBrCostCentre(String brCostCentre){
		this.brCostCentre = brCostCentre;
	}
	
    /**
     * 
     * @return
     */	
    public String getBrCostCentre(){
    	return brCostCentre;
    }
	/**
	 * 
	 * @param brUserId
	 */
	public void setBrUserId(String brUserId){
		this.brUserId = brUserId;
	}
	
    /**
     * 
     * @return
     */	
    public String getBrUserId(){
    	return brUserId;
    }
	/**
	 * 
	 * @param brModDate
	 */
	public void setBrModDate(String brModDate){
		this.brModDate = brModDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getBrModDate(){
    	return brModDate;
    }
	/**
	 * 
	 * @param checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}
	
    /**
     * 
     * @return
     */	
    public String getChecksum(){
    	return checksum;
    }

	@Override
	public String toString() {
		return "CpBrchid [brBranchId=" + brBranchId + ", brBranchName=" + brBranchName + ", brCostCentre="
				+ brCostCentre + ", brUserId=" + brUserId + ", brModDate=" + brModDate + ", checksum=" + checksum + "]";
	}
    
    
}