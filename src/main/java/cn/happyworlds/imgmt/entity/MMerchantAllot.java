package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MMerchantAllot {
	/**
	 *  分配编号
	 */
	private String allotId;
	/**
	 *  产品类别
	 */
	private String productType;
	/**
	 *  门店ID
	 */
	private String merchantId;
	/**
	 *  商户名称
	 */
	private String merchantName;
	/**
	 *  描述
	 */
	private String allotDesc;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 分配编号
	 * @param allotId
	 */
	public void setAllotId(String allotId){
		this.allotId = allotId;
	}
	
    /**
     * 分配编号
     * @return
     */	
    public String getAllotId(){
    	return allotId;
    }
	/**
	 * 产品类别
	 * @param productType
	 */
	public void setProductType(String productType){
		this.productType = productType;
	}
	
    /**
     * 产品类别
     * @return
     */	
    public String getProductType(){
    	return productType;
    }
	/**
	 * 门店ID
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}
	
    /**
     * 门店ID
     * @return
     */	
    public String getMerchantId(){
    	return merchantId;
    }
	/**
	 * 商户名称
	 * @param merchantName
	 */
	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}
	
    /**
     * 商户名称
     * @return
     */	
    public String getMerchantName(){
    	return merchantName;
    }
	/**
	 * 描述
	 * @param allotDesc
	 */
	public void setAllotDesc(String allotDesc){
		this.allotDesc = allotDesc;
	}
	
    /**
     * 描述
     * @return
     */	
    public String getAllotDesc(){
    	return allotDesc;
    }
	/**
	 * checksum
	 * @param checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}
	
    /**
     * checksum
     * @return
     */	
    public String getChecksum(){
    	return checksum;
    }
}