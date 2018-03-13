package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class YwGate implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  闸机ID
	 */
	private String hwGateId;
	/**
	 *  闸机名称
	 */
	private String hwGateName;
	/**
	 *  闸机说明
	 */
	private String hwGateNote;
	/**
	 *  所属场馆
	 */
	private String hwVenueId;
	/**
	 *  闸机位置
	 */
	private String hwGateLoc;
	/**
	 *  闸机IP地址
	 */
	private String hwGateIp;
	/**
	 *  开放时间
	 */
	private String hwOpenTime;
	/**
	 * ??ID
	 * @param hwGateId
	 */
	public void setHwGateId(String hwGateId){
		this.hwGateId = hwGateId;
	}
	
    /**
     * ??ID
     * @return
     */	
    public String getHwGateId(){
    	return hwGateId;
    }
	/**
	 * ????
	 * @param hwGateName
	 */
	public void setHwGateName(String hwGateName){
		this.hwGateName = hwGateName;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwGateName(){
    	return hwGateName;
    }
	/**
	 * ????
	 * @param hwGateNote
	 */
	public void setHwGateNote(String hwGateNote){
		this.hwGateNote = hwGateNote;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwGateNote(){
    	return hwGateNote;
    }
	/**
	 * ????
	 * @param hwVenueId
	 */
	public void setHwVenueId(String hwVenueId){
		this.hwVenueId = hwVenueId;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwVenueId(){
    	return hwVenueId;
    }
	/**
	 * ????
	 * @param hwGateLoc
	 */
	public void setHwGateLoc(String hwGateLoc){
		this.hwGateLoc = hwGateLoc;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwGateLoc(){
    	return hwGateLoc;
    }
	/**
	 * ??IP??
	 * @param hwGateIp
	 */
	public void setHwGateIp(String hwGateIp){
		this.hwGateIp = hwGateIp;
	}
	
    /**
     * ??IP??
     * @return
     */	
    public String getHwGateIp(){
    	return hwGateIp;
    }
	/**
	 * ????
	 * @param hwOpenTime
	 */
	public void setHwOpenTime(String hwOpenTime){
		this.hwOpenTime = hwOpenTime;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwOpenTime(){
    	return hwOpenTime;
    }
}