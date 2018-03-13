package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author
 */
public class CpPosprm implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String ppBrand;
	/**
	 *  
	 */
	private String ppVersion;
	/**
	 *  
	 */
	private String ppType;
	/**
	 *  
	 */
	private Long ppSeq;
	/**
	 *  
	 */
	private String ppTagName;
	/**
	 *  
	 */
	private Long ppTagSeq;
	/**
	 *  
	 */
	private Long ppTagLength;
	/**
	 *  
	 */
	private String ppTagData;
	/**
	 *  
	 */
	private String ppTagDefault;
	/**
	 *  
	 */
	private Long ppDispSeq;
	/**
	 *  
	 */
	private String ppDispInd;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param ppBrand
	 */
	public void setPpBrand(String ppBrand){
		this.ppBrand = ppBrand;
	}
	
    /**
     * 
     * @return
     */	
    public String getPpBrand(){
    	return ppBrand;
    }
	/**
	 * 
	 * @param ppVersion
	 */
	public void setPpVersion(String ppVersion){
		this.ppVersion = ppVersion;
	}
	
    /**
     * 
     * @return
     */	
    public String getPpVersion(){
    	return ppVersion;
    }
	/**
	 * 
	 * @param ppType
	 */
	public void setPpType(String ppType){
		this.ppType = ppType;
	}
	
    /**
     * 
     * @return
     */	
    public String getPpType(){
    	return ppType;
    }
	/**
	 * 
	 * @param ppSeq
	 */
	public void setPpSeq(Long ppSeq){
		this.ppSeq = ppSeq;
	}
	
    /**
     * 
     * @return
     */	
    public Long getPpSeq(){
    	return ppSeq;
    }
	/**
	 * 
	 * @param ppTagName
	 */
	public void setPpTagName(String ppTagName){
		this.ppTagName = ppTagName;
	}
	
    /**
     * 
     * @return
     */	
    public String getPpTagName(){
    	return ppTagName;
    }
	/**
	 * 
	 * @param ppTagSeq
	 */
	public void setPpTagSeq(Long ppTagSeq){
		this.ppTagSeq = ppTagSeq;
	}
	
    /**
     * 
     * @return
     */	
    public Long getPpTagSeq(){
    	return ppTagSeq;
    }
	/**
	 * 
	 * @param ppTagLength
	 */
	public void setPpTagLength(Long ppTagLength){
		this.ppTagLength = ppTagLength;
	}
	
    /**
     * 
     * @return
     */	
    public Long getPpTagLength(){
    	return ppTagLength;
    }
	/**
	 * 
	 * @param ppTagData
	 */
	public void setPpTagData(String ppTagData){
		this.ppTagData = ppTagData;
	}
	
    /**
     * 
     * @return
     */	
    public String getPpTagData(){
    	return ppTagData;
    }
	/**
	 * 
	 * @param ppTagDefault
	 */
	public void setPpTagDefault(String ppTagDefault){
		this.ppTagDefault = ppTagDefault;
	}
	
    /**
     * 
     * @return
     */	
    public String getPpTagDefault(){
    	return ppTagDefault;
    }
	/**
	 * 
	 * @param ppDispSeq
	 */
	public void setPpDispSeq(Long ppDispSeq){
		this.ppDispSeq = ppDispSeq;
	}
	
    /**
     * 
     * @return
     */	
    public Long getPpDispSeq(){
    	return ppDispSeq;
    }
	/**
	 * 
	 * @param ppDispInd
	 */
	public void setPpDispInd(String ppDispInd){
		this.ppDispInd = ppDispInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getPpDispInd(){
    	return ppDispInd;
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