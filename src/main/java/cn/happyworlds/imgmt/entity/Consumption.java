package cn.happyworlds.imgmt.entity;

public class Consumption {
	private String ctCardNumber;		//卡号
	
	private String prGroupDesc;			//卡种名称
	
	private String cbEmbossname;		//姓名
	
	private String ctTerminalId;		//终端号
	
	private String ctMerchantId;		//显示场馆号
	
	private String tmDbaName;			//查询场馆号
	
	private String tmModel;				//车牌号
	
	private String ctDisputeDate;		//交易起始时间，结束时间
	
	private String ctApproveTime;		//交易上传时间
	
	private String ctTranZone;			//时间

	private String ctBillCurrAmt;		//交易金额
	
	private String ctCardAmount;		//交易前的余额
	
	private String ctTranAmount;		//交易金额

	private String ctOutstdAfterPost;	//卡片余额

	public String getCtMerchantId() {
		return ctMerchantId;
	}

	public void setCtMerchantId(String ctMerchantId) {
		this.ctMerchantId = ctMerchantId;
	}

	public String getCtTranAmount() {
		return ctTranAmount;
	}

	public void setCtTranAmount(String ctTranAmount) {
		this.ctTranAmount = ctTranAmount;
	}

	public String getCtCardNumber() {
		return ctCardNumber;
	}

	public void setCtCardNumber(String ctCardNumber) {
		this.ctCardNumber = ctCardNumber;
	}

	public String getPrGroupDesc() {
		return prGroupDesc;
	}

	public void setPrGroupDesc(String prGroupDesc) {
		this.prGroupDesc = prGroupDesc;
	}

	public String getCtTerminalId() {
		return ctTerminalId;
	}

	public void setCtTerminalId(String ctTerminalId) {
		this.ctTerminalId = ctTerminalId;
	}

	public String getCbEmbossname() {
		return cbEmbossname;
	}

	public void setCbEmbossname(String cbEmbossname) {
		this.cbEmbossname = cbEmbossname;
	}

	public String getTmDbaName() {
		return tmDbaName;
	}

	public void setTmDbaName(String tmDbaName) {
		this.tmDbaName = tmDbaName;
	}

	public String getTmModel() {
		return tmModel;
	}

	public void setTmModel(String tmModel) {
		this.tmModel = tmModel;
	}

	public String getCtDisputeDate() {
		return ctDisputeDate;
	}

	public void setCtDisputeDate(String ctDisputeDate) {
		this.ctDisputeDate = ctDisputeDate;
	}

	public String getCtApproveTime() {
		return ctApproveTime;
	}

	public void setCtApproveTime(String ctApproveTime) {
		this.ctApproveTime = ctApproveTime;
	}
	
	public String getCtTranZone() {
		return ctTranZone;
	}

	public void setCtTranZone(String ctTranZone) {
		this.ctTranZone = ctTranZone;
	}

	public String getCtBillCurrAmt() {
		return ctBillCurrAmt;
	}

	public void setCtBillCurrAmt(String ctBillCurrAmt) {
		this.ctBillCurrAmt = ctBillCurrAmt;
	}
	

	public String getCtCardAmount() {
		return ctCardAmount;
	}

	public void setCtCardAmount(String ctCardAmount) {
		this.ctCardAmount = ctCardAmount;
	}

	public String getCtOutstdAfterPost() {
		return ctOutstdAfterPost;
	}

	public void setCtOutstdAfterPost(String ctOutstdAfterPost) {
		this.ctOutstdAfterPost = ctOutstdAfterPost;
	}
	


	


	
}
