package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class TSysOption {
	/**
	 *  参数ID
	 */
	private String id;
	/**
	 *  商户流水编号
	 */
	private String mmId;
	/**
	 *  参数值
	 */
	private String data;
	/**
	 *  参数描述
	 */
	private String remark;
	/**
	 *  更新时间
	 */
	private String updatedAt;
	/**
	 *  更新人
	 */
	private String updatedBy;
	/**
	 * 参数ID
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	
    /**
     * 参数ID
     * @return
     */	
    public String getId(){
    	return id;
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
	 * 参数值
	 * @param data
	 */
	public void setData(String data){
		this.data = data;
	}
	
    /**
     * 参数值
     * @return
     */	
    public String getData(){
    	return data;
    }
	/**
	 * 参数描述
	 * @param remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
    /**
     * 参数描述
     * @return
     */	
    public String getRemark(){
    	return remark;
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
	 * 更新人
	 * @param updatedBy
	 */
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;
	}
	
    /**
     * 更新人
     * @return
     */	
    public String getUpdatedBy(){
    	return updatedBy;
    }
}