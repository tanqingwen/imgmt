package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class CpPlstic implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String pcCardholderNo;
	/**
	 *  
	 */
	private String pcCardholderName;
	/**
	 *  
	 */
	private String pcOplasticCd;
	/**
	 *  
	 */
	private String pcNplasticCd;
	/**
	 *  
	 */
	private String pcOplasticDate;
	/**
	 *  
	 */
	private String pcNplasticDate;
	/**
	 *  
	 */
	private String pcAction;
	/**
	 *  
	 */
	private String pcOffId;
	/**
	 *  
	 */
	private String pcTimestamp;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param pcCardholderNo
	 */
	public void setPcCardholderNo(String pcCardholderNo){
		this.pcCardholderNo = pcCardholderNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcCardholderNo(){
    	return pcCardholderNo;
    }
	/**
	 * 
	 * @param pcCardholderName
	 */
	public void setPcCardholderName(String pcCardholderName){
		this.pcCardholderName = pcCardholderName;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcCardholderName(){
    	return pcCardholderName;
    }
	/**
	 * 
	 * @param pcOplasticCd
	 */
	public void setPcOplasticCd(String pcOplasticCd){
		this.pcOplasticCd = pcOplasticCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcOplasticCd(){
    	return pcOplasticCd;
    }
	/**
	 * 
	 * @param pcNplasticCd
	 */
	public void setPcNplasticCd(String pcNplasticCd){
		this.pcNplasticCd = pcNplasticCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcNplasticCd(){
    	return pcNplasticCd;
    }
	/**
	 * 
	 * @param pcOplasticDate
	 */
	public void setPcOplasticDate(String pcOplasticDate){
		this.pcOplasticDate = pcOplasticDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcOplasticDate(){
    	return pcOplasticDate;
    }
	/**
	 * 
	 * @param pcNplasticDate
	 */
	public void setPcNplasticDate(String pcNplasticDate){
		this.pcNplasticDate = pcNplasticDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcNplasticDate(){
    	return pcNplasticDate;
    }
	/**
	 * 
	 * @param pcAction
	 */
	public void setPcAction(String pcAction){
		this.pcAction = pcAction;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcAction(){
    	return pcAction;
    }
	/**
	 * 
	 * @param pcOffId
	 */
	public void setPcOffId(String pcOffId){
		this.pcOffId = pcOffId;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcOffId(){
    	return pcOffId;
    }
	/**
	 * 
	 * @param pcTimestamp
	 */
	public void setPcTimestamp(String pcTimestamp){
		this.pcTimestamp = pcTimestamp;
	}
	
    /**
     * 
     * @return
     */	
    public String getPcTimestamp(){
    	return pcTimestamp;
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