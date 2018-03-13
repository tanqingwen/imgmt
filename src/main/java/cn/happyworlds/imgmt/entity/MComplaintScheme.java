package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaintScheme {
	/**
	 *  投诉方案ID
	 */
	private Long complaintSchemeId;
	/**
	 *  投诉方案名称
	 */
	private String complaintSchemeApellation;
	/**
	 *  投诉方案状态
	 */
	private String status;
	/**
	 * 投诉方案ID
	 * @param complaintSchemeId
	 */
	public void setComplaintSchemeId(Long complaintSchemeId){
		this.complaintSchemeId = complaintSchemeId;
	}
	
    /**
     * 投诉方案ID
     * @return
     */	
    public Long getComplaintSchemeId(){
    	return complaintSchemeId;
    }
	/**
	 * 投诉方案名称
	 * @param complaintSchemeApellation
	 */
	public void setComplaintSchemeApellation(String complaintSchemeApellation){
		this.complaintSchemeApellation = complaintSchemeApellation;
	}
	
    /**
     * 投诉方案名称
     * @return
     */	
    public String getComplaintSchemeApellation(){
    	return complaintSchemeApellation;
    }
	/**
	 * 投诉方案状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 投诉方案状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
}