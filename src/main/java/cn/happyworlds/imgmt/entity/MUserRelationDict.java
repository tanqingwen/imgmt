package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MUserRelationDict {
	/**
	 *  关系ID
	 */
	private String userRelationId;
	/**
	 *  关系描述
	 */
	private String userRelationDesc;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 关系ID
	 * @param userRelationId
	 */
	public void setUserRelationId(String userRelationId){
		this.userRelationId = userRelationId;
	}
	
    /**
     * 关系ID
     * @return
     */	
    public String getUserRelationId(){
    	return userRelationId;
    }
	/**
	 * 关系描述
	 * @param userRelationDesc
	 */
	public void setUserRelationDesc(String userRelationDesc){
		this.userRelationDesc = userRelationDesc;
	}
	
    /**
     * 关系描述
     * @return
     */	
    public String getUserRelationDesc(){
    	return userRelationDesc;
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
}