package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpAcqgrp implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Long alGroupId;
	/**
	 *  
	 */
	private String alDesc;
	/**
	 *  
	 */
	private String checksum;
	/**
	 *  
	 */
	private Long status;
	/**
	 * 
	 * @param alGroupId
	 */
	public void setAlGroupId(Long alGroupId){
		this.alGroupId = alGroupId;
	}
	
    /**
     * 
     * @return
     */	
    public Long getAlGroupId(){
    	return alGroupId;
    }
	/**
	 * 
	 * @param alDesc
	 */
	public void setAlDesc(String alDesc){
		this.alDesc = alDesc;
	}
	
    /**
     * 
     * @return
     */	
    public String getAlDesc(){
    	return alDesc;
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
	/**
	 * 
	 * @param status
	 */
	public void setStatus(Long status){
		this.status = status;
	}
	
    /**
     * 
     * @return
     */	
    public Long getStatus(){
    	return status;
    }
}