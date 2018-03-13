package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MComplaintJudge {
	/**
	 *  投诉判断ID
	 */
	private Long complaintJudgeId;
	/**
	 *  投诉判断名称
	 */
	private String complaintJudgeApellation;
	/**
	 *  投诉判断状态
	 */
	private String status;
	/**
	 * 投诉判断ID
	 * @param complaintJudgeId
	 */
	public void setComplaintJudgeId(Long complaintJudgeId){
		this.complaintJudgeId = complaintJudgeId;
	}
	
    /**
     * 投诉判断ID
     * @return
     */	
    public Long getComplaintJudgeId(){
    	return complaintJudgeId;
    }
	/**
	 * 投诉判断名称
	 * @param complaintJudgeApellation
	 */
	public void setComplaintJudgeApellation(String complaintJudgeApellation){
		this.complaintJudgeApellation = complaintJudgeApellation;
	}
	
    /**
     * 投诉判断名称
     * @return
     */	
    public String getComplaintJudgeApellation(){
    	return complaintJudgeApellation;
    }
	/**
	 * 投诉判断状态
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
    /**
     * 投诉判断状态
     * @return
     */	
    public String getStatus(){
    	return status;
    }
}