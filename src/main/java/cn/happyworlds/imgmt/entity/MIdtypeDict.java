package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class MIdtypeDict {
	/**
	 *  证件类型
	 */
	private String idtypeId;
	/**
	 *  证件描述
	 */
	private String idtypeDesc;
	/**
	 *  起始位置
	 */
	private String idtypeForm;
	/**
	 *  最大长度
	 */
	private String idtypeLength;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 证件类型
	 * @param idtypeId
	 */
	public void setIdtypeId(String idtypeId){
		this.idtypeId = idtypeId;
	}
	
    /**
     * 证件类型
     * @return
     */	
    public String getIdtypeId(){
    	return idtypeId;
    }
	/**
	 * 证件描述
	 * @param idtypeDesc
	 */
	public void setIdtypeDesc(String idtypeDesc){
		this.idtypeDesc = idtypeDesc;
	}
	
    /**
     * 证件描述
     * @return
     */	
    public String getIdtypeDesc(){
    	return idtypeDesc;
    }
	/**
	 * 起始位置
	 * @param idtypeForm
	 */
	public void setIdtypeForm(String idtypeForm){
		this.idtypeForm = idtypeForm;
	}
	
    /**
     * 起始位置
     * @return
     */	
    public String getIdtypeForm(){
    	return idtypeForm;
    }
	/**
	 * 最大长度
	 * @param idtypeLength
	 */
	public void setIdtypeLength(String idtypeLength){
		this.idtypeLength = idtypeLength;
	}
	
    /**
     * 最大长度
     * @return
     */	
    public String getIdtypeLength(){
    	return idtypeLength;
    }
	/**
	 * 
	 * @param checksum
	 */
	public void setChecksum(String checksum){
		this.checksum = checksum;
	}
	
    /**
     * 
     * @return
     */	
    public String getChecksum(){
    	return checksum;
    }
}