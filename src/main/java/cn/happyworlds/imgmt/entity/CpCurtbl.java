package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpCurtbl implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Long cuCurrCd;
	/**
	 *  
	 */
	private String cuAlphaCd;
	/**
	 *  
	 */
	private Integer cuExponent;
	/**
	 *  
	 */
	private java.math.BigDecimal cuConvRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuBaseRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuRmbRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuUsdRate;
	/**
	 *  
	 */
	private String cuUsdMethod;
	/**
	 *  
	 */
	private java.math.BigDecimal cuCashBuyingRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuCashSellingRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuTelBuyingRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuTelSellingRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuMiddleRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuFlatBuyingRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuFlatSellingRate;
	/**
	 *  
	 */
	private java.math.BigDecimal cuSettleRate;
	/**
	 *  
	 */
	private String cuUserId;
	/**
	 *  
	 */
	private String cuModDate;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param cuCurrCd
	 */
	public void setCuCurrCd(Long cuCurrCd){
		this.cuCurrCd = cuCurrCd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getCuCurrCd(){
    	return cuCurrCd;
    }
	/**
	 * 
	 * @param cuAlphaCd
	 */
	public void setCuAlphaCd(String cuAlphaCd){
		this.cuAlphaCd = cuAlphaCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCuAlphaCd(){
    	return cuAlphaCd;
    }
	/**
	 * 
	 * @param cuExponent
	 */
	public void setCuExponent(Integer cuExponent){
		this.cuExponent = cuExponent;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getCuExponent(){
    	return cuExponent;
    }
	/**
	 * 
	 * @param cuConvRate
	 */
	public void setCuConvRate(java.math.BigDecimal cuConvRate){
		this.cuConvRate = cuConvRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuConvRate(){
    	return cuConvRate;
    }
	/**
	 * 
	 * @param cuBaseRate
	 */
	public void setCuBaseRate(java.math.BigDecimal cuBaseRate){
		this.cuBaseRate = cuBaseRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuBaseRate(){
    	return cuBaseRate;
    }
	/**
	 * 
	 * @param cuRmbRate
	 */
	public void setCuRmbRate(java.math.BigDecimal cuRmbRate){
		this.cuRmbRate = cuRmbRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuRmbRate(){
    	return cuRmbRate;
    }
	/**
	 * 
	 * @param cuUsdRate
	 */
	public void setCuUsdRate(java.math.BigDecimal cuUsdRate){
		this.cuUsdRate = cuUsdRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuUsdRate(){
    	return cuUsdRate;
    }
	/**
	 * 
	 * @param cuUsdMethod
	 */
	public void setCuUsdMethod(String cuUsdMethod){
		this.cuUsdMethod = cuUsdMethod;
	}
	
    /**
     * 
     * @return
     */	
    public String getCuUsdMethod(){
    	return cuUsdMethod;
    }
	/**
	 * 
	 * @param cuCashBuyingRate
	 */
	public void setCuCashBuyingRate(java.math.BigDecimal cuCashBuyingRate){
		this.cuCashBuyingRate = cuCashBuyingRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuCashBuyingRate(){
    	return cuCashBuyingRate;
    }
	/**
	 * 
	 * @param cuCashSellingRate
	 */
	public void setCuCashSellingRate(java.math.BigDecimal cuCashSellingRate){
		this.cuCashSellingRate = cuCashSellingRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuCashSellingRate(){
    	return cuCashSellingRate;
    }
	/**
	 * 
	 * @param cuTelBuyingRate
	 */
	public void setCuTelBuyingRate(java.math.BigDecimal cuTelBuyingRate){
		this.cuTelBuyingRate = cuTelBuyingRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuTelBuyingRate(){
    	return cuTelBuyingRate;
    }
	/**
	 * 
	 * @param cuTelSellingRate
	 */
	public void setCuTelSellingRate(java.math.BigDecimal cuTelSellingRate){
		this.cuTelSellingRate = cuTelSellingRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuTelSellingRate(){
    	return cuTelSellingRate;
    }
	/**
	 * 
	 * @param cuMiddleRate
	 */
	public void setCuMiddleRate(java.math.BigDecimal cuMiddleRate){
		this.cuMiddleRate = cuMiddleRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuMiddleRate(){
    	return cuMiddleRate;
    }
	/**
	 * 
	 * @param cuFlatBuyingRate
	 */
	public void setCuFlatBuyingRate(java.math.BigDecimal cuFlatBuyingRate){
		this.cuFlatBuyingRate = cuFlatBuyingRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuFlatBuyingRate(){
    	return cuFlatBuyingRate;
    }
	/**
	 * 
	 * @param cuFlatSellingRate
	 */
	public void setCuFlatSellingRate(java.math.BigDecimal cuFlatSellingRate){
		this.cuFlatSellingRate = cuFlatSellingRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuFlatSellingRate(){
    	return cuFlatSellingRate;
    }
	/**
	 * 
	 * @param cuSettleRate
	 */
	public void setCuSettleRate(java.math.BigDecimal cuSettleRate){
		this.cuSettleRate = cuSettleRate;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCuSettleRate(){
    	return cuSettleRate;
    }
	/**
	 * 
	 * @param cuUserId
	 */
	public void setCuUserId(String cuUserId){
		this.cuUserId = cuUserId;
	}
	
    /**
     * 
     * @return
     */	
    public String getCuUserId(){
    	return cuUserId;
    }
	/**
	 * 
	 * @param cuModDate
	 */
	public void setCuModDate(String cuModDate){
		this.cuModDate = cuModDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCuModDate(){
    	return cuModDate;
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