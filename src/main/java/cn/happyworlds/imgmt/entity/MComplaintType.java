package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaintType {
	/**
	 *  投诉类型ID
	 */
	private Long complaintTypeId;
	/**
	 *  投诉类型名称
	 */
	private String complaintTypeApellation;
	/**
	 *  投诉类型状态
	 */
	private String status;
	/**
	 * 投诉类型ID
	 * @param complaintTypeId
	 */
	public void setComplaintTypeId(Long complaintTypeId){
		this.complaintTypeId = complaintTypeId;
	}
	
    /**
     * 投诉类型ID
     * @return
     */	
    public Long getComplaintTypeId(){
    	return complaintTypeId;
    }
	/**
	 * 投诉类型名称
	 * @param complaintTypeApellation
	 */
	public void setComplaintTypeApellation(String complaintTypeApellation){
		this.complaintTypeApellation = complaintTypeApellation;
	}
	
    /**
     * 投诉类型名称
     * @return
     */	
    public String getComplaintTypeApellation(){
    	return complaintTypeApellation;
    }
	/**
	 * 投诉类型状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 投诉类型状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
}