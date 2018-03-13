package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MTypeModel {
	/**
	 *  业务类型ID
	 */
	private Long typeId;
	/**
	 *  业务类型描述
	 */
	private String typeDesc;
	/**
	 *  checksum
	 */
	private String checksum;
	/**
	 * 业务类型ID
	 * @param typeId
	 */
	public void setTypeId(Long typeId){
		this.typeId = typeId;
	}
	
    /**
     * 业务类型ID
     * @return
     */	
    public Long getTypeId(){
    	return typeId;
    }
	/**
	 * 业务类型描述
	 * @param typeDesc
	 */
	public void setTypeDesc(String typeDesc){
		this.typeDesc = typeDesc;
	}
	
    /**
     * 业务类型描述
     * @return
     */	
    public String getTypeDesc(){
    	return typeDesc;
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