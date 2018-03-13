package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpCrdmtn implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String cmIdType;
	/**
	 *  
	 */
	private String cmCustomerIdno;
	/**
	 *  
	 */
	private String cmCardholderNo;
	/**
	 *  
	 */
	private String cmModDate;
	/**
	 *  
	 */
	private Long cmMtnSeq;
	/**
	 *  
	 */
	private String cmDesc;
	/**
	 *  
	 */
	private String cmOldContents;
	/**
	 *  
	 */
	private String cmNewContents;
	/**
	 *  
	 */
	private String cmOffId;
	/**
	 *  
	 */
	private String cmTimestamp;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param cmIdType
	 */
	public void setCmIdType(String cmIdType){
		this.cmIdType = cmIdType;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmIdType(){
    	return cmIdType;
    }
	/**
	 * 
	 * @param cmCustomerIdno
	 */
	public void setCmCustomerIdno(String cmCustomerIdno){
		this.cmCustomerIdno = cmCustomerIdno;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmCustomerIdno(){
    	return cmCustomerIdno;
    }
	/**
	 * 
	 * @param cmCardholderNo
	 */
	public void setCmCardholderNo(String cmCardholderNo){
		this.cmCardholderNo = cmCardholderNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmCardholderNo(){
    	return cmCardholderNo;
    }
	/**
	 * 
	 * @param cmModDate
	 */
	public void setCmModDate(String cmModDate){
		this.cmModDate = cmModDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmModDate(){
    	return cmModDate;
    }
	/**
	 * 
	 * @param cmMtnSeq
	 */
	public void setCmMtnSeq(Long cmMtnSeq){
		this.cmMtnSeq = cmMtnSeq;
	}
	
    /**
     * 
     * @return
     */	
    public Long getCmMtnSeq(){
    	return cmMtnSeq;
    }
	/**
	 * 
	 * @param cmDesc
	 */
	public void setCmDesc(String cmDesc){
		this.cmDesc = cmDesc;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmDesc(){
    	return cmDesc;
    }
	/**
	 * 
	 * @param cmOldContents
	 */
	public void setCmOldContents(String cmOldContents){
		this.cmOldContents = cmOldContents;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmOldContents(){
    	return cmOldContents;
    }
	/**
	 * 
	 * @param cmNewContents
	 */
	public void setCmNewContents(String cmNewContents){
		this.cmNewContents = cmNewContents;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmNewContents(){
    	return cmNewContents;
    }
	/**
	 * 
	 * @param cmOffId
	 */
	public void setCmOffId(String cmOffId){
		this.cmOffId = cmOffId;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmOffId(){
    	return cmOffId;
    }
	/**
	 * 
	 * @param cmTimestamp
	 */
	public void setCmTimestamp(String cmTimestamp){
		this.cmTimestamp = cmTimestamp;
	}
	
    /**
     * 
     * @return
     */	
    public String getCmTimestamp(){
    	return cmTimestamp;
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