package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MCityDict {
	/**
	 *  城市ID
	 */
	private String cityId;
	/**
	 *  省份ID
	 */
	private String provinceId;
	/**
	 *  城市名称
	 */
	private String cityName;
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
	 * 城市ID
	 * @param cityId
	 */
	public void setCityId(String cityId){
		this.cityId = cityId;
	}
	
    /**
     * 城市ID
     * @return
     */	
    public String getCityId(){
    	return cityId;
    }
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
	 * 城市名称
	 * @param cityName
	 */
	public void setCityName(String cityName){
		this.cityName = cityName;
	}
	
    /**
     * 城市名称
     * @return
     */	
    public String getCityName(){
    	return cityName;
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