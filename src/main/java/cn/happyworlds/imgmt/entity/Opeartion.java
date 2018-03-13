package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author yanjy
 */
public class Opeartion implements Serializable {
	private static final long serialVersionUID = 1L;

    //卡号，姓名，卡类型，日期，时间，金额，起始日期，结束日期，操作类型，操作员
    //cardNo，name，cardType，date，time，amt,timeStart，timeEnd，opType,User
	/**
	 *  
	 */
	private String ctCardNumber;//账务流水表里的卡号cp_ceptrx	
	/**
	 *  
	 */
	private String cbEmbossname;//卡表的凸印姓名cp_crdtbl
	/**
	 *  
	 */
	private String prGroupDesc;//产品组表的描述cp_prdgrp
	/**
	 *  
	 */
	private String ctApproveTime;//账务流水表里的授权时间cp_ceptrx
	/**
	 *  
	 */
	private String ctFeeAmount;//(开卡，挂失，解挂三项操作显示的金额)账务流水表里的押金cp_ceptrx
	/**
	 *  
	 */
	private String ctTranAmount;//(退卡，撤销两项操作显示的金额)账务流水表里的交易金额cp_ceptrx
	/**
	 *  
	 */
	private String ctBillCurrAmt;//(押金退换时显示的金额)账务流水表里的金额cp_ceptrx
	/**
	 *  
	 */
	private String ctUserCreate;//账务流水表里建立的用户cp_ceptrx
	/**
	 *  
	 */
	private String ctTranCode;//账务流水表的操作类型
	private String money;
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCtCardNumber() {
		return ctCardNumber;
	}
	public void setCtCardNumber(String ctCardNumber) {
		this.ctCardNumber = ctCardNumber;
	}
	public String getCbEmbossname() {
		return cbEmbossname;
	}
	public void setCbEmbossname(String cbEmbossname) {
		this.cbEmbossname = cbEmbossname;
	}
	public String getPrGroupDesc() {
		return prGroupDesc;
	}
	public void setPrGroupDesc(String prGroupDesc) {
		this.prGroupDesc = prGroupDesc;
	}
	public String getCtApproveTime() {
		return ctApproveTime;
	}
	public void setCtApproveTime(String ctApproveTime) {
		this.ctApproveTime = ctApproveTime;
	}
	public String getCtFeeAmount() {
		return ctFeeAmount;
	}
	public void setCtFeeAmount(String ctFeeAmount) {
		this.ctFeeAmount = ctFeeAmount;
	}
	public String getCtTranAmount() {
		return ctTranAmount;
	}
	public void setCtTranAmount(String ctTranAmount) {
		this.ctTranAmount = ctTranAmount;
	}
	public String getCtBillCurrAmt() {
		return ctBillCurrAmt;
	}
	public void setCtBillCurrAmt(String ctBillCurrAmt) {
		this.ctBillCurrAmt = ctBillCurrAmt;
	}
	public String getCtUserCreate() {
		return ctUserCreate;
	}
	public void setCtUserCreate(String ctUserCreate) {
		this.ctUserCreate = ctUserCreate;
	}
	public String getCtTranCode() {
		return ctTranCode;
	}
	public void setCtTranCode(String ctTranCode) {
		this.ctTranCode = ctTranCode;
	}
	
	
	
	
	
	
	
	
	
	
	
		
    
    
}