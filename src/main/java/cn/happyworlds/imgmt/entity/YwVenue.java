package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author json
 */
public class YwVenue implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  ??ID
	 */
	private String hwVenueId;
	/**
	 *  
	 */
	private String hwVenueName;
	/**
	 *  ????
	 */
	private String hwVenueNote;
	/**
	 *  ????
	 */
	private String hwVenueIntroduce;
	/**
	 *  场馆图片1
	 */
	private String hwVenuePic1;
	/**
	 *  场馆图片2
	 */
	private String hwVenuePic2;
	/**
	 *  ????
	 */
	private String hwVenusPos;
	/**
	 *  ????
	 */
	private Integer hwGateNumber;
	/**
	 *  ??ID??????????
	 */
	private String hwGateId;
	/**
	 *  ????
	 */
	private String hwOpenTime;
	/**
	 *  ???
	 */
	private String hwLeader;
	/**
	 *  ????
	 */
	private String hwContractPhone;
	/**
	 *  ????
	 */
	private java.util.Date hwAddtime;
	
	private MultipartFile hwVenuePicfile1;//场馆图片1
	private MultipartFile hwVenuePicfile2;//场馆图片2
	
	public MultipartFile getHwVenuePicfile1() {
		return hwVenuePicfile1;
	}

	public void setHwVenuePicfile1(MultipartFile hwVenuePicfile1) {
		this.hwVenuePicfile1 = hwVenuePicfile1;
	}

	public MultipartFile getHwVenuePicfile2() {
		return hwVenuePicfile2;
	}

	public void setHwVenuePicfile2(MultipartFile hwVenuePicfile2) {
		this.hwVenuePicfile2 = hwVenuePicfile2;
	}

	/**
	 * ??ID
	 * @param hwVenueId
	 */
	public void setHwVenueId(String hwVenueId){
		this.hwVenueId = hwVenueId;
	}
	
    /**
     * ??ID
     * @return
     */	
    public String getHwVenueId(){
    	return hwVenueId;
    }
	/**
	 * 
	 * @param hwVenueName
	 */
	public void setHwVenueName(String hwVenueName){
		this.hwVenueName = hwVenueName;
	}
	
    /**
     * 
     * @return
     */	
    public String getHwVenueName(){
    	return hwVenueName;
    }
	/**
	 * ????
	 * @param hwVenueNote
	 */
	public void setHwVenueNote(String hwVenueNote){
		this.hwVenueNote = hwVenueNote;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwVenueNote(){
    	return hwVenueNote;
    }
    /**
     * ????
     * @return
     */
    public void setHwVenueIntroduce(String hwVenueIntroduce){
		this.hwVenueIntroduce = hwVenueIntroduce;
	}
    /**
     * ????
     * @return
     */
    public String getHwVenueIntroduce(){
    	return hwVenueIntroduce;
    }
	/**
	 * 
	 * @param hwVenuePic1
	 */
	public void setHwVenuePic1(String hwVenuePic1){
		this.hwVenuePic1 = hwVenuePic1;
	}
	
    /**
     * 
     * @return
     */	
    public String getHwVenuePic1(){
    	return hwVenuePic1;
    }
    /**
	 * 
	 * @param hwVenuePic2
	 */
	public void setHwVenuePic2(String hwVenuePic2){
		this.hwVenuePic2 = hwVenuePic2;
	}
	
    /**
     * 
     * @return
     */	
    public String getHwVenuePic2(){
    	return hwVenuePic2;
    }
	/**
	 * ????
	 * @param hwVenusPos
	 */
	public void setHwVenusPos(String hwVenusPos){
		this.hwVenusPos = hwVenusPos;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwVenusPos(){
    	return hwVenusPos;
    }
	/**
	 * ????
	 * @param hwGateNumber
	 */
	public void setHwGateNumber(Integer hwGateNumber){
		this.hwGateNumber = hwGateNumber;
	}
	
    /**
     * ????
     * @return
     */	
    public Integer getHwGateNumber(){
    	return hwGateNumber;
    }
	/**
	 * ??ID??????????
	 * @param hwGateId
	 */
	public void setHwGateId(String hwGateId){
		this.hwGateId = hwGateId;
	}
	
    /**
     * ??ID??????????
     * @return
     */	
    public String getHwGateId(){
    	return hwGateId;
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
	/**
	 * ???
	 * @param hwLeader
	 */
	public void setHwLeader(String hwLeader){
		this.hwLeader = hwLeader;
	}
	
    /**
     * ???
     * @return
     */	
    public String getHwLeader(){
    	return hwLeader;
    }
	/**
	 * ????
	 * @param hwContractPhone
	 */
	public void setHwContractPhone(String hwContractPhone){
		this.hwContractPhone = hwContractPhone;
	}
	
    /**
     * ????
     * @return
     */	
    public String getHwContractPhone(){
    	return hwContractPhone;
    }
	/**
	 * ????
	 * @param hwAddtime
	 */
	public void setHwAddtime(java.util.Date hwAddtime){
		this.hwAddtime = hwAddtime;
	}
	
    /**
     * ????
     * @return
     */	
    public java.util.Date getHwAddtime(){
    	return hwAddtime;
    }
}