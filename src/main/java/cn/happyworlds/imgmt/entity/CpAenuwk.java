package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author wyb
 */
public class CpAenuwk implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Long nuAeBin;
	/**
	 *  
	 */
	private Long nuAeProd;
	/**
	 *  
	 */
	private Long nuAeSeq;
	/**
	 *  
	 */
	private String nuAeUsageInd;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param nuAeBin
	 */
	public void setNuAeBin(Long nuAeBin){
		this.nuAeBin = nuAeBin;
	}
	
    /**
     * 
     * @return
     */	
    public Long getNuAeBin(){
    	return nuAeBin;
    }
	/**
	 * 
	 * @param nuAeProd
	 */
	public void setNuAeProd(Long nuAeProd){
		this.nuAeProd = nuAeProd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getNuAeProd(){
    	return nuAeProd;
    }
	/**
	 * 
	 * @param nuAeSeq
	 */
	public void setNuAeSeq(Long nuAeSeq){
		this.nuAeSeq = nuAeSeq;
	}
	
    /**
     * 
     * @return
     */	
    public Long getNuAeSeq(){
    	return nuAeSeq;
    }
	/**
	 * 
	 * @param nuAeUsageInd
	 */
	public void setNuAeUsageInd(String nuAeUsageInd){
		this.nuAeUsageInd = nuAeUsageInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getNuAeUsageInd(){
    	return nuAeUsageInd;
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