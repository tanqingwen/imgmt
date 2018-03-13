package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author wyb
 */
public class CpCtrycd implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String sysAlphaCtryCd;
	/**
	 *  
	 */
	private Long sysNumericCtryCd;
	/**
	 *  
	 */
	private String sysAltAlphaCtryCd;
	/**
	 *  
	 */
	private String sysCtryDescription;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param sysAlphaCtryCd
	 */
	public void setSysAlphaCtryCd(String sysAlphaCtryCd){
		this.sysAlphaCtryCd = sysAlphaCtryCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSysAlphaCtryCd(){
    	return sysAlphaCtryCd;
    }
	/**
	 * 
	 * @param sysNumericCtryCd
	 */
	public void setSysNumericCtryCd(Long sysNumericCtryCd){
		this.sysNumericCtryCd = sysNumericCtryCd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getSysNumericCtryCd(){
    	return sysNumericCtryCd;
    }
	/**
	 * 
	 * @param sysAltAlphaCtryCd
	 */
	public void setSysAltAlphaCtryCd(String sysAltAlphaCtryCd){
		this.sysAltAlphaCtryCd = sysAltAlphaCtryCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getSysAltAlphaCtryCd(){
    	return sysAltAlphaCtryCd;
    }
	/**
	 * 
	 * @param sysCtryDescription
	 */
	public void setSysCtryDescription(String sysCtryDescription){
		this.sysCtryDescription = sysCtryDescription;
	}
	
    /**
     * 
     * @return
     */	
    public String getSysCtryDescription(){
    	return sysCtryDescription;
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