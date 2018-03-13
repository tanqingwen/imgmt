package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author wyb
 */
public class CpNuwork implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Long nuBinNo;
	/**
	 *  
	 */
	private Long nuSeqNo;
	/**
	 *  
	 */
	private String nuUsageInd;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param nuBinNo
	 */
	public void setNuBinNo(Long nuBinNo){
		this.nuBinNo = nuBinNo;
	}
	
    /**
     * 
     * @return
     */	
    public Long getNuBinNo(){
    	return nuBinNo;
    }
	/**
	 * 
	 * @param nuSeqNo
	 */
	public void setNuSeqNo(Long nuSeqNo){
		this.nuSeqNo = nuSeqNo;
	}
	
    /**
     * 
     * @return
     */	
    public Long getNuSeqNo(){
    	return nuSeqNo;
    }
	/**
	 * 
	 * @param nuUsageInd
	 */
	public void setNuUsageInd(String nuUsageInd){
		this.nuUsageInd = nuUsageInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getNuUsageInd(){
    	return nuUsageInd;
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