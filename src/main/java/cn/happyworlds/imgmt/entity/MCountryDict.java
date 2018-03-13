package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MCountryDict {
	/**
	 *  国家字母代码
	 */
	private String alphaCtryCd;
	/**
	 *  国家数字代码
	 */
	private String numericCtryCd;
	/**
	 *  
	 */
	private String altAlphaCtryCd;
	/**
	 *  国家名称
	 */
	private String ctryDescription;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 国家字母代码
	 * @param alphaCtryCd
	 */
	public void setAlphaCtryCd(String alphaCtryCd){
		this.alphaCtryCd = alphaCtryCd;
	}
	
    /**
     * 国家字母代码
     * @return
     */	
    public String getAlphaCtryCd(){
    	return alphaCtryCd;
    }
	/**
	 * 国家数字代码
	 * @param numericCtryCd
	 */
	public void setNumericCtryCd(String numericCtryCd){
		this.numericCtryCd = numericCtryCd;
	}
	
    /**
     * 国家数字代码
     * @return
     */	
    public String getNumericCtryCd(){
    	return numericCtryCd;
    }
	/**
	 * 
	 * @param altAlphaCtryCd
	 */
	public void setAltAlphaCtryCd(String altAlphaCtryCd){
		this.altAlphaCtryCd = altAlphaCtryCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getAltAlphaCtryCd(){
    	return altAlphaCtryCd;
    }
	/**
	 * 国家名称
	 * @param ctryDescription
	 */
	public void setCtryDescription(String ctryDescription){
		this.ctryDescription = ctryDescription;
	}
	
    /**
     * 国家名称
     * @return
     */	
    public String getCtryDescription(){
    	return ctryDescription;
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