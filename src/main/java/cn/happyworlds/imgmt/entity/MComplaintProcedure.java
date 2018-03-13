package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaintProcedure {
	/**
	 *  阶段ID
	 */
	private Long id;
	/**
	 *  阶段描述
	 */
	private String idDesc;
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
	 * 阶段ID
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
    /**
     * 阶段ID
     * @return
     */	
    public Long getId(){
    	return id;
    }
	/**
	 * 阶段描述
	 * @param idDesc
	 */
	public void setIdDesc(String idDesc){
		this.idDesc = idDesc;
	}
	
    /**
     * 阶段描述
     * @return
     */	
    public String getIdDesc(){
    	return idDesc;
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