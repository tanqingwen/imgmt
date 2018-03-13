package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpSeckey implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Long skProdctGroup;
	/**
	 *  
	 */
	private String skValue;
	/**
	 *  
	 */
	private String skKey;
	/**
	 *  
	 */
	private String skDesc;
	/**
	 *  
	 */
	private String skModDate;
	/**
	 *  
	 */
	private String skUserId;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param skProdctGroup
	 */
	public void setSkProdctGroup(Long skProdctGroup){
		this.skProdctGroup = skProdctGroup;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSkProdctGroup(){
    	return skProdctGroup;
    }
	/**
	 * 
	 * @param skValue
	 */
	public void setSkValue(String skValue){
		this.skValue = skValue;
	}
	
    /**
     * 
     * @return
     */	
    public String getSkValue(){
    	return skValue;
    }
	/**
	 * 
	 * @param skKey
	 */
	public void setSkKey(String skKey){
		this.skKey = skKey;
	}
	
    /**
     * 
     * @return
     */	
    public String getSkKey(){
    	return skKey;
    }
	/**
	 * 
	 * @param skDesc
	 */
	public void setSkDesc(String skDesc){
		this.skDesc = skDesc;
	}
	
    /**
     * 
     * @return
     */	
    public String getSkDesc(){
    	return skDesc;
    }
	/**
	 * 
	 * @param skModDate
	 */
	public void setSkModDate(String skModDate){
		this.skModDate = skModDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getSkModDate(){
    	return skModDate;
    }
	/**
	 * 
	 * @param skUserId
	 */
	public void setSkUserId(String skUserId){
		this.skUserId = skUserId;
	}
	
    /**
     * 
     * @return
     */	
    public String getSkUserId(){
    	return skUserId;
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