package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MSupportDoc {
	/**
	 *  ID
	 */
	private Long id;
	/**
	 *  业务模式ID
	 */
	private Long businessModelId;
	/**
	 *  文件名称
	 */
	private String docName;
	/**
	 *  文件代码
	 */
	private String docCode;
	/**
	 *  文件类型ID
	 */
	private Long docTypeId;
	/**
	 *  文件路径
	 */
	private String docPath;
	/**
	 *  现有标志
	 */
	private Boolean existentFlag;
	/**
	 *  默认标志
	 */
	private Boolean defaultFlag;
	/**
	 *  主要标志
	 */
	private Boolean primaryFlag;
	/**
	 * ID
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
    /**
     * ID
     * @return
     */	
    public Long getId(){
    	return id;
    }
	/**
	 * 业务模式ID
	 * @param businessModelId
	 */
	public void setBusinessModelId(Long businessModelId){
		this.businessModelId = businessModelId;
	}
	
    /**
     * 业务模式ID
     * @return
     */	
    public Long getBusinessModelId(){
    	return businessModelId;
    }
	/**
	 * 文件名称
	 * @param docName
	 */
	public void setDocName(String docName){
		this.docName = docName;
	}
	
    /**
     * 文件名称
     * @return
     */	
    public String getDocName(){
    	return docName;
    }
	/**
	 * 文件代码
	 * @param docCode
	 */
	public void setDocCode(String docCode){
		this.docCode = docCode;
	}
	
    /**
     * 文件代码
     * @return
     */	
    public String getDocCode(){
    	return docCode;
    }
	/**
	 * 文件类型ID
	 * @param docTypeId
	 */
	public void setDocTypeId(Long docTypeId){
		this.docTypeId = docTypeId;
	}
	
    /**
     * 文件类型ID
     * @return
     */	
    public Long getDocTypeId(){
    	return docTypeId;
    }
	/**
	 * 文件路径
	 * @param docPath
	 */
	public void setDocPath(String docPath){
		this.docPath = docPath;
	}
	
    /**
     * 文件路径
     * @return
     */	
    public String getDocPath(){
    	return docPath;
    }
	/**
	 * 现有标志
	 * @param existentFlag
	 */
	public void setExistentFlag(Boolean existentFlag){
		this.existentFlag = existentFlag;
	}
	
    /**
     * 现有标志
     * @return
     */	
    public Boolean getExistentFlag(){
    	return existentFlag;
    }
	/**
	 * 默认标志
	 * @param defaultFlag
	 */
	public void setDefaultFlag(Boolean defaultFlag){
		this.defaultFlag = defaultFlag;
	}
	
    /**
     * 默认标志
     * @return
     */	
    public Boolean getDefaultFlag(){
    	return defaultFlag;
    }
	/**
	 * 主要标志
	 * @param primaryFlag
	 */
	public void setPrimaryFlag(Boolean primaryFlag){
		this.primaryFlag = primaryFlag;
	}
	
    /**
     * 主要标志
     * @return
     */	
    public Boolean getPrimaryFlag(){
    	return primaryFlag;
    }
}