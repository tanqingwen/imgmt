package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaintProcedureSet {
	/**
	 *  ID
	 */
	private Long id;
	/**
	 *  阶段ID
	 */
	private Long procedureId;
	/**
	 *  上一阶段ID
	 */
	private Long procedureSetId;
	/**
	 *  状态
	 */
	private String status;
	/**
	 *  修改时间
	 */
	private String modifyTime;
	/**
	 *  修改人
	 */
	private String modifyBy;
	/**
	 *  checksum
	 */
	private String checksum;
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
	 * 阶段ID
	 * @param procedureId
	 */
	public void setProcedureId(Long procedureId){
		this.procedureId = procedureId;
	}
	
    /**
     * 阶段ID
     * @return
     */	
    public Long getProcedureId(){
    	return procedureId;
    }
	/**
	 * 上一阶段ID
	 * @param procedureSetId
	 */
	public void setProcedureSetId(Long procedureSetId){
		this.procedureSetId = procedureSetId;
	}
	
    /**
     * 上一阶段ID
     * @return
     */	
    public Long getProcedureSetId(){
    	return procedureSetId;
    }
	/**
	 * 状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
	/**
	 * 修改时间
	 * @param modifyTime
	 */
	public void setModifyTime(String modifyTime){
		this.modifyTime = modifyTime;
	}
	
    /**
     * 修改时间
     * @return
     */	
    public String getModifyTime(){
    	return modifyTime;
    }
	/**
	 * 修改人
	 * @param modifyBy
	 */
	public void setModifyBy(String modifyBy){
		this.modifyBy = modifyBy;
	}
	
    /**
     * 修改人
     * @return
     */	
    public String getModifyBy(){
    	return modifyBy;
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