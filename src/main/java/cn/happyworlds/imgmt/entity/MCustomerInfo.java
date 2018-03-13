package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MCustomerInfo {
	/**
	 *  客户id
	 */
	private Long customerId;
	/**
	 *  客户城市
	 */
	private String customerCity;
	/**
	 *  户籍地址
	 */
	private String customerLegalAddress;
	/**
	 *  家庭地址
	 */
	private String customerHomeAddress;
	/**
	 *  公司地址
	 */
	private String customerCompanyAddress;
	/**
	 *  婚姻状态：0未婚，1已婚，2其他
	 */
	private String customerMarrstatu;
	/**
	 *  子女情况：0未知，1无子女，2有子女
	 */
	private String customerChildren;
	/**
	 *  客户座机
	 */
	private String customerPhone;
	/**
	 *  客户成员姓名
	 */
	private String customerMemberName;
	/**
	 *  客户手机
	 */
	private String customerMobile;
	/**
	 *  创建时间
	 */
	private String createdAt;
	/**
	 *  更新时间
	 */
	private String updatedAt;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 客户id
	 * @param customerId
	 */
	public void setCustomerId(Long customerId){
		this.customerId = customerId;
	}
	
    /**
     * 客户id
     * @return
     */	
    public Long getCustomerId(){
    	return customerId;
    }
	/**
	 * 客户城市
	 * @param customerCity
	 */
	public void setCustomerCity(String customerCity){
		this.customerCity = customerCity;
	}
	
    /**
     * 客户城市
     * @return
     */	
    public String getCustomerCity(){
    	return customerCity;
    }
	/**
	 * 户籍地址
	 * @param customerLegalAddress
	 */
	public void setCustomerLegalAddress(String customerLegalAddress){
		this.customerLegalAddress = customerLegalAddress;
	}
	
    /**
     * 户籍地址
     * @return
     */	
    public String getCustomerLegalAddress(){
    	return customerLegalAddress;
    }
	/**
	 * 家庭地址
	 * @param customerHomeAddress
	 */
	public void setCustomerHomeAddress(String customerHomeAddress){
		this.customerHomeAddress = customerHomeAddress;
	}
	
    /**
     * 家庭地址
     * @return
     */	
    public String getCustomerHomeAddress(){
    	return customerHomeAddress;
    }
	/**
	 * 公司地址
	 * @param customerCompanyAddress
	 */
	public void setCustomerCompanyAddress(String customerCompanyAddress){
		this.customerCompanyAddress = customerCompanyAddress;
	}
	
    /**
     * 公司地址
     * @return
     */	
    public String getCustomerCompanyAddress(){
    	return customerCompanyAddress;
    }
	/**
	 * 婚姻状态：0未婚，1已婚，2其他
	 * @param customerMarrstatu
	 */
	public void setCustomerMarrstatu(String customerMarrstatu){
		this.customerMarrstatu = customerMarrstatu;
	}
	
    /**
     * 婚姻状态：0未婚，1已婚，2其他
     * @return
     */	
    public String getCustomerMarrstatu(){
    	return customerMarrstatu;
    }
	/**
	 * 子女情况：0未知，1无子女，2有子女
	 * @param customerChildren
	 */
	public void setCustomerChildren(String customerChildren){
		this.customerChildren = customerChildren;
	}
	
    /**
     * 子女情况：0未知，1无子女，2有子女
     * @return
     */	
    public String getCustomerChildren(){
    	return customerChildren;
    }
	/**
	 * 客户座机
	 * @param customerPhone
	 */
	public void setCustomerPhone(String customerPhone){
		this.customerPhone = customerPhone;
	}
	
    /**
     * 客户座机
     * @return
     */	
    public String getCustomerPhone(){
    	return customerPhone;
    }
	/**
	 * 客户成员姓名
	 * @param customerMemberName
	 */
	public void setCustomerMemberName(String customerMemberName){
		this.customerMemberName = customerMemberName;
	}
	
    /**
     * 客户成员姓名
     * @return
     */	
    public String getCustomerMemberName(){
    	return customerMemberName;
    }
	/**
	 * 客户手机
	 * @param customerMobile
	 */
	public void setCustomerMobile(String customerMobile){
		this.customerMobile = customerMobile;
	}
	
    /**
     * 客户手机
     * @return
     */	
    public String getCustomerMobile(){
    	return customerMobile;
    }
	/**
	 * 创建时间
	 * @param createdAt
	 */
	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}
	
    /**
     * 创建时间
     * @return
     */	
    public String getCreatedAt(){
    	return createdAt;
    }
	/**
	 * 更新时间
	 * @param updatedAt
	 */
	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}
	
    /**
     * 更新时间
     * @return
     */	
    public String getUpdatedAt(){
    	return updatedAt;
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