package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpBlkmlc implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String bmCardNo;
	/**
	 *  
	 */
	private String bmOrgId;
	/**
	 *  
	 */
	private Long bmProductCode;
	/**
	 *  
	 */
	private String bmAccountId;
	/**
	 *  
	 */
	private String bmAccRefNo;
	/**
	 *  
	 */
	private String bmCardName;
	/**
	 *  
	 */
	private String bmReasonCode;
	/**
	 *  
	 */
	private Long bmStage;
	/**
	 *  
	 */
	private String bmInTime;
	/**
	 *  
	 */
	private String bmOutTime;
	/**
	 *  
	 */
	private String bmBlack;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param bmCardNo
	 */
	public void setBmCardNo(String bmCardNo){
		this.bmCardNo = bmCardNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmCardNo(){
    	return bmCardNo;
    }
	/**
	 * 
	 * @param bmOrgId
	 */
	public void setBmOrgId(String bmOrgId){
		this.bmOrgId = bmOrgId;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmOrgId(){
    	return bmOrgId;
    }
	/**
	 * 
	 * @param bmProductCode
	 */
	public void setBmProductCode(Long bmProductCode){
		this.bmProductCode = bmProductCode;
	}
	
    /**
     * 
     * @return
     */	
    public Long getBmProductCode(){
    	return bmProductCode;
    }
	/**
	 * 
	 * @param bmAccountId
	 */
	public void setBmAccountId(String bmAccountId){
		this.bmAccountId = bmAccountId;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmAccountId(){
    	return bmAccountId;
    }
	/**
	 * 
	 * @param bmAccRefNo
	 */
	public void setBmAccRefNo(String bmAccRefNo){
		this.bmAccRefNo = bmAccRefNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmAccRefNo(){
    	return bmAccRefNo;
    }
	/**
	 * 
	 * @param bmCardName
	 */
	public void setBmCardName(String bmCardName){
		this.bmCardName = bmCardName;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmCardName(){
    	return bmCardName;
    }
	/**
	 * 
	 * @param bmReasonCode
	 */
	public void setBmReasonCode(String bmReasonCode){
		this.bmReasonCode = bmReasonCode;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmReasonCode(){
    	return bmReasonCode;
    }
	/**
	 * 
	 * @param bmStage
	 */
	public void setBmStage(Long bmStage){
		this.bmStage = bmStage;
	}
	
    /**
     * 
     * @return
     */	
    public Long getBmStage(){
    	return bmStage;
    }
	/**
	 * 
	 * @param bmInTime
	 */
	public void setBmInTime(String bmInTime){
		this.bmInTime = bmInTime;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmInTime(){
    	return bmInTime;
    }
	/**
	 * 
	 * @param bmOutTime
	 */
	public void setBmOutTime(String bmOutTime){
		this.bmOutTime = bmOutTime;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmOutTime(){
    	return bmOutTime;
    }
	/**
	 * 
	 * @param bmBlack
	 */
	public void setBmBlack(String bmBlack){
		this.bmBlack = bmBlack;
	}
	
    /**
     * 
     * @return
     */	
    public String getBmBlack(){
    	return bmBlack;
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