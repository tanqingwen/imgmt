package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MBusinessModel {
	/**
	 *  ID
	 */
	private Long id;
	/**
	 *  业务模式描述
	 */
	private String idDesc;
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
	 * 业务模式描述
	 * @param idDesc
	 */
	public void setIdDesc(String idDesc){
		this.idDesc = idDesc;
	}
	
    /**
     * 业务模式描述
     * @return
     */	
    public String getIdDesc(){
    	return idDesc;
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