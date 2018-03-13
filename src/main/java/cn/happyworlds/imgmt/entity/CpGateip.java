package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpGateip implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Integer gaId;
	/**
	 *  
	 */
	private String gaIp;
	/**
	 *  
	 */
	private String gaTm;
	/**
	 *  
	 */
	private Integer gaState;
	/**
	 * 
	 * @param gaId
	 */
	public void setGaId(Integer gaId){
		this.gaId = gaId;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getGaId(){
    	return gaId;
    }
	/**
	 * 
	 * @param gaIp
	 */
	public void setGaIp(String gaIp){
		this.gaIp = gaIp;
	}
	
    /**
     * 
     * @return
     */	
    public String getGaIp(){
    	return gaIp;
    }
	/**
	 * 
	 * @param gaTm
	 */
	public void setGaTm(String gaTm){
		this.gaTm = gaTm;
	}
	
    /**
     * 
     * @return
     */	
    public String getGaTm(){
    	return gaTm;
    }
	/**
	 * 
	 * @param gaState
	 */
	public void setGaState(Integer gaState){
		this.gaState = gaState;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getGaState(){
    	return gaState;
    }
}