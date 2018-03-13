package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class CpDiscount implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  ä¼˜æƒ å�·id
	 */
	private String disId;
	/**
	 *  åˆ¸ç±»åž‹
	 */
	private String disType;
	/**
	 *  ä½¿ç”¨è¯´æ˜Ž
	 */
	private String disService;
	/**
	 *  åˆ¸æ��è¿°
	 */
	private String disDesc;
	/**
	 *  ä½¿ç”¨å¼€å§‹æ—¶é—´
	 */
	private String disBeginTime;
	/**
	 *  ä½¿ç”¨ç»“æ�Ÿæ—¶é—´
	 */
	private String disEndTime;
	/**
	 *  é‡‘é¢�
	 */
	private java.math.BigDecimal disMoney;
	/**
	 *  ä½¿ç”¨åº—é“ºæ��è¿°
	 */
	private String disShop;
	/**
	 *  é¢„ç•™å­—æ®µ
	 */
	private String disShop2;
	/**
	 *  é¢„ç•™å­—æ®µ
	 */
	private String disShop3;
	/**
	 *  ä¼˜æƒ åˆ¸æœ‰æ•ˆå‘¨æœŸ(å¤©)
	 */
	private Integer disPeriod;
	/**
	 *  ä¼˜æƒ åˆ¸çŠ¶æ€�
	 */
	private String disStatus;
	/**
	 *  ä¼˜æƒ åˆ¸å›¾ç‰‡
	 */
	private String disUrl;
	/**
	 *  
	 */
	private String checksum;
	
	private String usersId;  //绑定的用户ids
	private String hasUsed;  //使用已使用
	
	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getHasUsed() {
		return hasUsed;
	}

	public void setHasUsed(String hasUsed) {
		this.hasUsed = hasUsed;
	}

	/**
	 * ä¼˜æƒ å�·id
	 * @param disId
	 */
	public void setDisId(String disId){
		this.disId = disId;
	}
	
    /**
     * ä¼˜æƒ å�·id
     * @return
     */	
    public String getDisId(){
    	return disId;
    }
	/**
	 * åˆ¸ç±»åž‹
	 * @param disType
	 */
	public void setDisType(String disType){
		this.disType = disType;
	}
	
    /**
     * åˆ¸ç±»åž‹
     * @return
     */	
    public String getDisType(){
    	return disType;
    }
	/**
	 * ä½¿ç”¨è¯´æ˜Ž
	 * @param disService
	 */
	public void setDisService(String disService){
		this.disService = disService;
	}
	
    /**
     * ä½¿ç”¨è¯´æ˜Ž
     * @return
     */	
    public String getDisService(){
    	return disService;
    }
	/**
	 * åˆ¸æ��è¿°
	 * @param disDesc
	 */
	public void setDisDesc(String disDesc){
		this.disDesc = disDesc;
	}
	
    /**
     * åˆ¸æ��è¿°
     * @return
     */	
    public String getDisDesc(){
    	return disDesc;
    }
	/**
	 * ä½¿ç”¨å¼€å§‹æ—¶é—´
	 * @param disBeginTime
	 */
	public void setDisBeginTime(String disBeginTime){
		this.disBeginTime = disBeginTime;
	}
	
    /**
     * ä½¿ç”¨å¼€å§‹æ—¶é—´
     * @return
     */	
    public String getDisBeginTime(){
    	return disBeginTime;
    }
	/**
	 * ä½¿ç”¨ç»“æ�Ÿæ—¶é—´
	 * @param disEndTime
	 */
	public void setDisEndTime(String disEndTime){
		this.disEndTime = disEndTime;
	}
	
    /**
     * ä½¿ç”¨ç»“æ�Ÿæ—¶é—´
     * @return
     */	
    public String getDisEndTime(){
    	return disEndTime;
    }
	/**
	 * é‡‘é¢�
	 * @param disMoney
	 */
	public void setDisMoney(java.math.BigDecimal disMoney){
		this.disMoney = disMoney;
	}
	
    /**
     * é‡‘é¢�
     * @return
     */	
    public java.math.BigDecimal getDisMoney(){
    	return disMoney;
    }
	/**
	 * ä½¿ç”¨åº—é“ºæ��è¿°
	 * @param disShop
	 */
	public void setDisShop(String disShop){
		this.disShop = disShop;
	}
	
    /**
     * ä½¿ç”¨åº—é“ºæ��è¿°
     * @return
     */	
    public String getDisShop(){
    	return disShop;
    }
	/**
	 * é¢„ç•™å­—æ®µ
	 * @param disShop2
	 */
	public void setDisShop2(String disShop2){
		this.disShop2 = disShop2;
	}
	
    /**
     * é¢„ç•™å­—æ®µ
     * @return
     */	
    public String getDisShop2(){
    	return disShop2;
    }
	/**
	 * é¢„ç•™å­—æ®µ
	 * @param disShop3
	 */
	public void setDisShop3(String disShop3){
		this.disShop3 = disShop3;
	}
	
    /**
     * é¢„ç•™å­—æ®µ
     * @return
     */	
    public String getDisShop3(){
    	return disShop3;
    }
	/**
	 * ä¼˜æƒ åˆ¸æœ‰æ•ˆå‘¨æœŸ(å¤©)
	 * @param disPeriod
	 */
	public void setDisPeriod(Integer disPeriod){
		this.disPeriod = disPeriod;
	}
	
    /**
     * ä¼˜æƒ åˆ¸æœ‰æ•ˆå‘¨æœŸ(å¤©)
     * @return
     */	
    public Integer getDisPeriod(){
    	return disPeriod;
    }
	/**
	 * ä¼˜æƒ åˆ¸çŠ¶æ€�
	 * @param disStatus
	 */
	public void setDisStatus(String disStatus){
		this.disStatus = disStatus;
	}
	
    /**
     * ä¼˜æƒ åˆ¸çŠ¶æ€�
     * @return
     */	
    public String getDisStatus(){
    	return disStatus;
    }
	/**
	 * ä¼˜æƒ åˆ¸å›¾ç‰‡
	 * @param disUrl
	 */
	public void setDisUrl(String disUrl){
		this.disUrl = disUrl;
	}
	
    /**
     * ä¼˜æƒ åˆ¸å›¾ç‰‡
     * @return
     */	
    public String getDisUrl(){
    	return disUrl;
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