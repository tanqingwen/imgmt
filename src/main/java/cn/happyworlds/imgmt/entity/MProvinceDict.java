package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MProvinceDict {
	/**
	 *  省份ID
	 */
	private String provinceId;
	/**
	 *  国家字母代码
	 */
	private String alphaCtryCd;
	/**
	 *  省份名称
	 */
	private String provinceName;
	/**
	 *  位置ID
	 */
	private String locationId;
	/**
	 *  区域代码
	 */
	private String regionCd;
	/**
	 *  邮遍
	 */
	private String zipCode;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 省份ID
	 * @param provinceId
	 */
	public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	}
	
    /**
     * 省份ID
     * @return
     */	
    public String getProvinceId(){
    	return provinceId;
    }
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
	 * 省份名称
	 * @param provinceName
	 */
	public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	}
	
    /**
     * 省份名称
     * @return
     */	
    public String getProvinceName(){
    	return provinceName;
    }
	/**
	 * 位置ID
	 * @param locationId
	 */
	public void setLocationId(String locationId){
		this.locationId = locationId;
	}
	
    /**
     * 位置ID
     * @return
     */	
    public String getLocationId(){
    	return locationId;
    }
	/**
	 * 区域代码
	 * @param regionCd
	 */
	public void setRegionCd(String regionCd){
		this.regionCd = regionCd;
	}
	
    /**
     * 区域代码
     * @return
     */	
    public String getRegionCd(){
    	return regionCd;
    }
	/**
	 * 邮遍
	 * @param zipCode
	 */
	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}
	
    /**
     * 邮遍
     * @return
     */	
    public String getZipCode(){
    	return zipCode;
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