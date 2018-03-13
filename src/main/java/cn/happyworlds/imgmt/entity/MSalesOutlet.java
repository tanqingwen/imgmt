package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MSalesOutlet {
	/**
	 *  销售代表门店联系ID
	 */
	private Long saleOutId;
	/**
	 *  销售代表编号
	 */
	private String salesId;
	/**
	 *  门店编号
	 */
	private String outletId;
	/**
	 *  商户流水编号
	 */
	private String mmId;
	/**
	 *  销售代表名称
	 */
	private String salesName;
	/**
	 *  门店名称
	 */
	private String outletName;
	/**
	 *  商户名称
	 */
	private String merchantName;
	/**
	 *  状态
	 */
	private String soStatus;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 销售代表门店联系ID
	 * @param saleOutId
	 */
	public void setSaleOutId(Long saleOutId){
		this.saleOutId = saleOutId;
	}
	
    /**
     * 销售代表门店联系ID
     * @return
     */	
    public Long getSaleOutId(){
    	return saleOutId;
    }
	/**
	 * 销售代表编号
	 * @param salesId
	 */
	public void setSalesId(String salesId){
		this.salesId = salesId;
	}
	
    /**
     * 销售代表编号
     * @return
     */	
    public String getSalesId(){
    	return salesId;
    }
	/**
	 * 门店编号
	 * @param outletId
	 */
	public void setOutletId(String outletId){
		this.outletId = outletId;
	}
	
    /**
     * 门店编号
     * @return
     */	
    public String getOutletId(){
    	return outletId;
    }
	/**
	 * 商户流水编号
	 * @param mmId
	 */
	public void setMmId(String mmId){
		this.mmId = mmId;
	}
	
    /**
     * 商户流水编号
     * @return
     */	
    public String getMmId(){
    	return mmId;
    }
	/**
	 * 销售代表名称
	 * @param salesName
	 */
	public void setSalesName(String salesName){
		this.salesName = salesName;
	}
	
    /**
     * 销售代表名称
     * @return
     */	
    public String getSalesName(){
    	return salesName;
    }
	/**
	 * 门店名称
	 * @param outletName
	 */
	public void setOutletName(String outletName){
		this.outletName = outletName;
	}
	
    /**
     * 门店名称
     * @return
     */	
    public String getOutletName(){
    	return outletName;
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
	 * 状态
	 * @param soStatus
	 */
	public void setSoStatus(String soStatus){
		this.soStatus = soStatus;
	}
	
    /**
     * 状态
     * @return
     */	
    public String getSoStatus(){
    	return soStatus;
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