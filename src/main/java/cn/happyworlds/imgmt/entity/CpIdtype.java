package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpIdtype implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String cbIdType;
	/**
	 *  
	 */
	private String cbIdDesc;
	/**
	 *  
	 */
	private String cbIdForm;
	/**
	 *  
	 */
	private String cbLength;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param cbIdType
	 */
	public void setCbIdType(String cbIdType){
		this.cbIdType = cbIdType;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbIdType(){
    	return cbIdType;
    }
	/**
	 * 
	 * @param cbIdDesc
	 */
	public void setCbIdDesc(String cbIdDesc){
		this.cbIdDesc = cbIdDesc;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbIdDesc(){
    	return cbIdDesc;
    }
	/**
	 * 
	 * @param cbIdForm
	 */
	public void setCbIdForm(String cbIdForm){
		this.cbIdForm = cbIdForm;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbIdForm(){
    	return cbIdForm;
    }
	/**
	 * 
	 * @param cbLength
	 */
	public void setCbLength(String cbLength){
		this.cbLength = cbLength;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbLength(){
    	return cbLength;
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