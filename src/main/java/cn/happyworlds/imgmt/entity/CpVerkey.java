package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class CpVerkey implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String vkValue;
	/**
	 *  
	 */
	private String vkKey;
	/**
	 *  
	 */
	private String vkDesc;
	/**
	 *  
	 */
	private String vkModDate;
	/**
	 *  
	 */
	private String vkUserId;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param vkValue
	 */
	public void setVkValue(String vkValue){
		this.vkValue = vkValue;
	}
	
    /**
     * 
     * @return
     */	
    public String getVkValue(){
    	return vkValue;
    }
	/**
	 * 
	 * @param vkKey
	 */
	public void setVkKey(String vkKey){
		this.vkKey = vkKey;
	}
	
    /**
     * 
     * @return
     */	
    public String getVkKey(){
    	return vkKey;
    }
	/**
	 * 
	 * @param vkDesc
	 */
	public void setVkDesc(String vkDesc){
		this.vkDesc = vkDesc;
	}
	
    /**
     * 
     * @return
     */	
    public String getVkDesc(){
    	return vkDesc;
    }
	/**
	 * 
	 * @param vkModDate
	 */
	public void setVkModDate(String vkModDate){
		this.vkModDate = vkModDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getVkModDate(){
    	return vkModDate;
    }
	/**
	 * 
	 * @param vkUserId
	 */
	public void setVkUserId(String vkUserId){
		this.vkUserId = vkUserId;
	}
	
    /**
     * 
     * @return
     */	
    public String getVkUserId(){
    	return vkUserId;
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