package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class CpAcqmer implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Integer amGroupId;
	private String amGroupdec;
	/**
	 *  
	 */
	private String amMerchantId;
	/**
	 *  
	 */
	private String amRecycleType;
	/**
	 *  
	 */
	private Integer amRecycleDate;
	/**
	 *  
	 */
	private String amUserDefine0;
	/**
	 *  
	 */
	private String amUserDefine1;
	/**
	 *  
	 */
	private String amUserDefine2;
	/**
	 *  
	 */
	private String amUserDefine3;
	/**
	 *  
	 */
	private String amUserDefine4;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param amGroupId
	 */
	public void setAmGroupId(Integer amGroupId){
		this.amGroupId = amGroupId;
	}
	
    public String getAmGroupdec() {
		return amGroupdec;
	}

	public void setAmGroupdec(String amGroupdec) {
		this.amGroupdec = amGroupdec;
	}

	/**
     * 
     * @return
     */	
    public Integer getAmGroupId(){
    	return amGroupId;
    }
	/**
	 * 
	 * @param amMerchantId
	 */
	public void setAmMerchantId(String amMerchantId){
		this.amMerchantId = amMerchantId;
	}
	
    /**
     * 
     * @return
     */	
    public String getAmMerchantId(){
    	return amMerchantId;
    }
	/**
	 * 
	 * @param amRecycleType
	 */
	public void setAmRecycleType(String amRecycleType){
		this.amRecycleType = amRecycleType;
	}
	
    /**
     * 
     * @return
     */	
    public String getAmRecycleType(){
    	return amRecycleType;
    }
	/**
	 * 
	 * @param amRecycleDate
	 */
	public void setAmRecycleDate(Integer amRecycleDate){
		this.amRecycleDate = amRecycleDate;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getAmRecycleDate(){
    	return amRecycleDate;
    }
	/**
	 * 
	 * @param amUserDefine0
	 */
	public void setAmUserDefine0(String amUserDefine0){
		this.amUserDefine0 = amUserDefine0;
	}
	
    /**
     * 
     * @return
     */	
    public String getAmUserDefine0(){
    	return amUserDefine0;
    }
	/**
	 * 
	 * @param amUserDefine1
	 */
	public void setAmUserDefine1(String amUserDefine1){
		this.amUserDefine1 = amUserDefine1;
	}
	
    /**
     * 
     * @return
     */	
    public String getAmUserDefine1(){
    	return amUserDefine1;
    }
	/**
	 * 
	 * @param amUserDefine2
	 */
	public void setAmUserDefine2(String amUserDefine2){
		this.amUserDefine2 = amUserDefine2;
	}
	
    /**
     * 
     * @return
     */	
    public String getAmUserDefine2(){
    	return amUserDefine2;
    }
	/**
	 * 
	 * @param amUserDefine3
	 */
	public void setAmUserDefine3(String amUserDefine3){
		this.amUserDefine3 = amUserDefine3;
	}
	
    /**
     * 
     * @return
     */	
    public String getAmUserDefine3(){
    	return amUserDefine3;
    }
	/**
	 * 
	 * @param amUserDefine4
	 */
	public void setAmUserDefine4(String amUserDefine4){
		this.amUserDefine4 = amUserDefine4;
	}
	
    /**
     * 
     * @return
     */	
    public String getAmUserDefine4(){
    	return amUserDefine4;
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
