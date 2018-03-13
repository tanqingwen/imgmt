package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaintChannel {
	/**
	 *  投诉渠道ID
	 */
	private Long complaintChannelId;
	/**
	 *  投诉渠道名称
	 */
	private String complaintChannelApellation;
	/**
	 *  投诉渠道状态
	 */
	private String status;
	/**
	 * 投诉渠道ID
	 * @param complaintChannelId
	 */
	public void setComplaintChannelId(Long complaintChannelId){
		this.complaintChannelId = complaintChannelId;
	}
	
    /**
     * 投诉渠道ID
     * @return
     */	
    public Long getComplaintChannelId(){
    	return complaintChannelId;
    }
	/**
	 * 投诉渠道名称
	 * @param complaintChannelApellation
	 */
	public void setComplaintChannelApellation(String complaintChannelApellation){
		this.complaintChannelApellation = complaintChannelApellation;
	}
	
    /**
     * 投诉渠道名称
     * @return
     */	
    public String getComplaintChannelApellation(){
    	return complaintChannelApellation;
    }
	/**
	 * 投诉渠道状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 投诉渠道状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
}