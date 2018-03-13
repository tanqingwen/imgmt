package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class DisUser implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Integer id;
	/**
	 *  ç”¨æˆ·id
	 */
	private String userId;
	/**
	 *  ä¼˜æƒ åˆ¸id
	 */
	private String disId;
	/**
	 *  ä¼˜æƒ åˆ¸ä½¿ç”¨çŠ¶æ€�Nï¼ˆæœªä½¿ç”¨ï¼‰Yï¼ˆå·²ä½¿ç”¨ï¼‰
	 */
	private String disStatus;
	/**
	 *  
	 */
	private String disName1;
	/**
	 *  
	 */
	private String disName2;
	/**
	 *  
	 */
	private String disName3;
	/**
	 *  
	 */
	private String disName4;
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getId(){
    	return id;
    }
	/**
	 * ç”¨æˆ·id
	 * @param userId
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	
    /**
     * ç”¨æˆ·id
     * @return
     */	
    public String getUserId(){
    	return userId;
    }
	/**
	 * ä¼˜æƒ åˆ¸id
	 * @param disId
	 */
	public void setDisId(String disId){
		this.disId = disId;
	}
	
    /**
     * ä¼˜æƒ åˆ¸id
     * @return
     */	
    public String getDisId(){
    	return disId;
    }
	/**
	 * ä¼˜æƒ åˆ¸ä½¿ç”¨çŠ¶æ€�Nï¼ˆæœªä½¿ç”¨ï¼‰Yï¼ˆå·²ä½¿ç”¨ï¼‰
	 * @param disStatus
	 */
	public void setDisStatus(String disStatus){
		this.disStatus = disStatus;
	}
	
    /**
     * ä¼˜æƒ åˆ¸ä½¿ç”¨çŠ¶æ€�Nï¼ˆæœªä½¿ç”¨ï¼‰Yï¼ˆå·²ä½¿ç”¨ï¼‰
     * @return
     */	
    public String getDisStatus(){
    	return disStatus;
    }
	/**
	 * 
	 * @param disName1
	 */
	public void setDisName1(String disName1){
		this.disName1 = disName1;
	}
	
    /**
     * 
     * @return
     */	
    public String getDisName1(){
    	return disName1;
    }
	/**
	 * 
	 * @param disName2
	 */
	public void setDisName2(String disName2){
		this.disName2 = disName2;
	}
	
    /**
     * 
     * @return
     */	
    public String getDisName2(){
    	return disName2;
    }
	/**
	 * 
	 * @param disName3
	 */
	public void setDisName3(String disName3){
		this.disName3 = disName3;
	}
	
    /**
     * 
     * @return
     */	
    public String getDisName3(){
    	return disName3;
    }
	/**
	 * 
	 * @param disName4
	 */
	public void setDisName4(String disName4){
		this.disName4 = disName4;
	}
	
    /**
     * 
     * @return
     */	
    public String getDisName4(){
    	return disName4;
    }
}