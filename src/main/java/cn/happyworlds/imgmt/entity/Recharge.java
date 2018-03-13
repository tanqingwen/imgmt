package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author yanjy
 */
public class Recharge implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String ctCardNumber;//账务流水表里的卡号cp_ceptrx
	/**
	 *  
	 */
	private String prGroupDesc;//产品组表的描述cp_prdgrp
	/**
	 *  
	 */
	private String cbEmbossname;//卡表的凸印姓名cp_crdtbl
	/**
	 *  
	 */
	private String ctApproveTime;//账务流水表里的授权时间cp_ceptrx
	/**
	 *  
	 */
	private java.math.BigDecimal ctBillCurrAmt;//账务流水表里的记账金额cp_ceptrx
	/**
	 *  
	 */
	private String ctUserCreate;//账务流水表里的建立用户cp_ceptrx
	/**
	 *  
	 */
	private String ctReversalFlag;//账务流水表里的撤销标志cp_ceptrx
	
	public String getCtApproveTime() {
		return ctApproveTime;
	}

	public void setCtApproveTime(String ctApproveTime) {
		this.ctApproveTime = ctApproveTime;
	}

	public String getCtReversalFlag() {
		return ctReversalFlag;
	}

	public void setCtReversalFlag(String ctReversalFlag) {
		this.ctReversalFlag = ctReversalFlag;
	}

	/**
	 * 
	 * @param ctCardNumber
	 */
	public void setCtCardNumber(String ctCardNumber){
		this.ctCardNumber = ctCardNumber;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtCardNumber(){
    	return ctCardNumber;
    }
	/**
	 * 
	 * @param prGroupDesc
	 */
	public void setPrGroupDesc(String prGroupDesc){
		this.prGroupDesc = prGroupDesc;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrGroupDesc(){
    	return prGroupDesc;
    }
    
    /**
	 * 
	 * @param cbEmbossname
	 */
	public void setCbEmbossname(String cbEmbossname){
		this.cbEmbossname = cbEmbossname;
	}
	
    /**
     * 
     * @return
     */	
    public String getCbEmbossname(){
    	return cbEmbossname;
    }
    
	
    /**
	 * 
	 * @param ctBillCurrAmt
	 */
	public void setCtBillCurrAmt(java.math.BigDecimal ctBillCurrAmt){
		this.ctBillCurrAmt = ctBillCurrAmt;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCtBillCurrAmt(){
    	return ctBillCurrAmt;
    }

	/**
	 * 
	 * @param ctUserCreate
	 */
	public void setCtUserCreate(String ctUserCreate){
		this.ctUserCreate = ctUserCreate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtUserCreate(){
    	return ctUserCreate;
    }
}