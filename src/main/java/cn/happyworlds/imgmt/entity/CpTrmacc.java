package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class CpTrmacc extends CpTrmmst implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private String tmTerminalId;
	/**
	 *  
	 */
	private String tmMerchantId;
	/**
	 *  
	 */
	private String tmDateInst;
	/**
	 *  
	 */
	private String tmDateCanx;
	/**
	 *  
	 */
	private String tmHostSerial; //闸机IP
	/**
	 *  
	 */
	private String tmEdcSerial; //区分终端/闸机(1/0)
	/**
	 *  
	 */
	private String tmEdcPrinterNo;
	/**
	 *  
	 */
	private String tmLastSettleDate;
	/**
	 *  
	 */
	private Long tmLastBatchNo;
	/**
	 *  
	 */
	private String tmBatchClose;
	/**
	 *  
	 */
	private String tmDbaName;
	/**
	 *  
	 */
	private String tmPhyState;
	/**
	 *  
	 */
	private String tmPhyCity;
	/**
	 *  
	 */
	private String tmPhyCountry;
	/**
	 *  
	 */
	private String tmVsTermType;
	/**
	 *  
	 */
	private Long tmMcTermType;
	/**
	 *  
	 */
	private String tmAeTermType;
	/**
	 *  
	 */
	private Long tmTrxnCurrCd;
	/**
	 *  
	 */
	private java.math.BigDecimal tmMonthlyRentalFee;
	/**
	 *  
	 */
	private String tmEmvCompliantFg;
	/**
	 *  
	 */
	private String tmCurrentKey;
	/**
	 *  
	 */
	private String tmOldKey;
	/**
	 *  
	 */
	private String tmRegionCd;
	/**
	 *  
	 */
	private String tmDownload;
	/**
	 *  
	 */
	private Long tmModeType;
	/**
	 *  
	 */
	private String tmStatus;
	/**
	 *  
	 */
	private String tmActiveTime;
	/**
	 *  
	 */
	private String tmVersionNo;
	/**
	 *  
	 */
	private String tmPinKey;
	/**
	 *  
	 */
	private String tmMacKey;
	/**
	 *  
	 */
	private String tmBlklstSeq;
	/**
	 *  
	 */
	private String tmOldMackey;
	/**
	 *  
	 */
	private String tmOldPinkey;
	/**
	 *  
	 */
	private String tmMasterKey;
	/**
	 *  
	 */
	private String tmBrand;
	/**
	 *  
	 */
	private String tmModel;
	/**
	 *  
	 */
	private String tmIswatch;
	/**
	 *  
	 */
	private String tmOrgid;
	/**
	 *  
	 */
	private String tmNetaddr;
	/**
	 *  
	 */
	private Long tmNetport;
	/**
	 *  
	 */
	private String tmContactaddr;
	/**
	 *  
	 */
	private String tmTermaddr;
	/**
	 *  
	 */
	private String tmAdminid;
	/**
	 *  
	 */
	private String tmOpertermid;
	/**
	 *  
	 */
	private Long tmInstType;
	/**
	 *  
	 */
	private String tmSystem;
	/**
	 *  
	 */
	private String tmUseState;
	/**
	 *  
	 */
	private String tmLayType;
	/**
	 *  
	 */
	private String tmIsselfbank;
	/**
	 *  
	 */
	private String tmIsvideowatch;
	/**
	 *  
	 */
	private String tmIsups;
	/**
	 *  
	 */
	private String tmGeog;
	/**
	 *  
	 */
	private String tmFuncArea;
	/**
	 *  
	 */
	private String tmProtoco;
	/**
	 *  
	 */
	private String tmSetupUser;
	/**
	 *  
	 */
	private String tmSetupTimestamp;
	/**
	 *  
	 */
	private String tmAuthUser;
	/**
	 *  
	 */
	private String tmAuthTimestamp;
	/**
	 *  
	 */
	private String tmAppvUser;
	/**
	 *  
	 */
	private String tmAppvTimestamp;
	/**
	 *  
	 */
	private String tmDownInd;
	/**
	 *  
	 */
	private String tmDownTimestamp;
	/**
	 *  
	 */
	private String tmApplStatus;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 
	 * @param tmTerminalId
	 */
	public void setTmTerminalId(String tmTerminalId){
		this.tmTerminalId = tmTerminalId;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmTerminalId(){
    	return tmTerminalId;
    }
	/**
	 * 
	 * @param tmMerchantId
	 */
	public void setTmMerchantId(String tmMerchantId){
		this.tmMerchantId = tmMerchantId;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmMerchantId(){
    	return tmMerchantId;
    }
	/**
	 * 
	 * @param tmDateInst
	 */
	public void setTmDateInst(String tmDateInst){
		this.tmDateInst = tmDateInst;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmDateInst(){
    	return tmDateInst;
    }
	/**
	 * 
	 * @param tmDateCanx
	 */
	public void setTmDateCanx(String tmDateCanx){
		this.tmDateCanx = tmDateCanx;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmDateCanx(){
    	return tmDateCanx;
    }
	/**
	 * 
	 * @param tmHostSerial
	 */
	public void setTmHostSerial(String tmHostSerial){
		this.tmHostSerial = tmHostSerial;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmHostSerial(){
    	return tmHostSerial;
    }
	/**
	 * 
	 * @param tmEdcSerial
	 */
	public void setTmEdcSerial(String tmEdcSerial){
		this.tmEdcSerial = tmEdcSerial;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmEdcSerial(){
    	return tmEdcSerial;
    }
	/**
	 * 
	 * @param tmEdcPrinterNo
	 */
	public void setTmEdcPrinterNo(String tmEdcPrinterNo){
		this.tmEdcPrinterNo = tmEdcPrinterNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmEdcPrinterNo(){
    	return tmEdcPrinterNo;
    }
	/**
	 * 
	 * @param tmLastSettleDate
	 */
	public void setTmLastSettleDate(String tmLastSettleDate){
		this.tmLastSettleDate = tmLastSettleDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmLastSettleDate(){
    	return tmLastSettleDate;
    }
	/**
	 * 
	 * @param tmLastBatchNo
	 */
	public void setTmLastBatchNo(Long tmLastBatchNo){
		this.tmLastBatchNo = tmLastBatchNo;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTmLastBatchNo(){
    	return tmLastBatchNo;
    }
	/**
	 * 
	 * @param tmBatchClose
	 */
	public void setTmBatchClose(String tmBatchClose){
		this.tmBatchClose = tmBatchClose;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmBatchClose(){
    	return tmBatchClose;
    }
	/**
	 * 
	 * @param tmDbaName
	 */
	public void setTmDbaName(String tmDbaName){
		this.tmDbaName = tmDbaName;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmDbaName(){
    	return tmDbaName;
    }
	/**
	 * 
	 * @param tmPhyState
	 */
	public void setTmPhyState(String tmPhyState){
		this.tmPhyState = tmPhyState;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmPhyState(){
    	return tmPhyState;
    }
	/**
	 * 
	 * @param tmPhyCity
	 */
	public void setTmPhyCity(String tmPhyCity){
		this.tmPhyCity = tmPhyCity;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmPhyCity(){
    	return tmPhyCity;
    }
	/**
	 * 
	 * @param tmPhyCountry
	 */
	public void setTmPhyCountry(String tmPhyCountry){
		this.tmPhyCountry = tmPhyCountry;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmPhyCountry(){
    	return tmPhyCountry;
    }
	/**
	 * 
	 * @param tmVsTermType
	 */
	public void setTmVsTermType(String tmVsTermType){
		this.tmVsTermType = tmVsTermType;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmVsTermType(){
    	return tmVsTermType;
    }
	/**
	 * 
	 * @param tmMcTermType
	 */
	public void setTmMcTermType(Long tmMcTermType){
		this.tmMcTermType = tmMcTermType;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTmMcTermType(){
    	return tmMcTermType;
    }
	/**
	 * 
	 * @param tmAeTermType
	 */
	public void setTmAeTermType(String tmAeTermType){
		this.tmAeTermType = tmAeTermType;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmAeTermType(){
    	return tmAeTermType;
    }
	/**
	 * 
	 * @param tmTrxnCurrCd
	 */
	public void setTmTrxnCurrCd(Long tmTrxnCurrCd){
		this.tmTrxnCurrCd = tmTrxnCurrCd;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTmTrxnCurrCd(){
    	return tmTrxnCurrCd;
    }
	/**
	 * 
	 * @param tmMonthlyRentalFee
	 */
	public void setTmMonthlyRentalFee(java.math.BigDecimal tmMonthlyRentalFee){
		this.tmMonthlyRentalFee = tmMonthlyRentalFee;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getTmMonthlyRentalFee(){
    	return tmMonthlyRentalFee;
    }
	/**
	 * 
	 * @param tmEmvCompliantFg
	 */
	public void setTmEmvCompliantFg(String tmEmvCompliantFg){
		this.tmEmvCompliantFg = tmEmvCompliantFg;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmEmvCompliantFg(){
    	return tmEmvCompliantFg;
    }
	/**
	 * 
	 * @param tmCurrentKey
	 */
	public void setTmCurrentKey(String tmCurrentKey){
		this.tmCurrentKey = tmCurrentKey;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmCurrentKey(){
    	return tmCurrentKey;
    }
	/**
	 * 
	 * @param tmOldKey
	 */
	public void setTmOldKey(String tmOldKey){
		this.tmOldKey = tmOldKey;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmOldKey(){
    	return tmOldKey;
    }
	/**
	 * 
	 * @param tmRegionCd
	 */
	public void setTmRegionCd(String tmRegionCd){
		this.tmRegionCd = tmRegionCd;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmRegionCd(){
    	return tmRegionCd;
    }
	/**
	 * 
	 * @param tmDownload
	 */
	public void setTmDownload(String tmDownload){
		this.tmDownload = tmDownload;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmDownload(){
    	return tmDownload;
    }
	/**
	 * 
	 * @param tmModeType
	 */
	public void setTmModeType(Long tmModeType){
		this.tmModeType = tmModeType;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTmModeType(){
    	return tmModeType;
    }
	/**
	 * 
	 * @param tmStatus
	 */
	public void setTmStatus(String tmStatus){
		this.tmStatus = tmStatus;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmStatus(){
    	return tmStatus;
    }
	/**
	 * 
	 * @param tmActiveTime
	 */
	public void setTmActiveTime(String tmActiveTime){
		this.tmActiveTime = tmActiveTime;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmActiveTime(){
    	return tmActiveTime;
    }
	/**
	 * 
	 * @param tmVersionNo
	 */
	public void setTmVersionNo(String tmVersionNo){
		this.tmVersionNo = tmVersionNo;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmVersionNo(){
    	return tmVersionNo;
    }
	/**
	 * 
	 * @param tmPinKey
	 */
	public void setTmPinKey(String tmPinKey){
		this.tmPinKey = tmPinKey;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmPinKey(){
    	return tmPinKey;
    }
	/**
	 * 
	 * @param tmMacKey
	 */
	public void setTmMacKey(String tmMacKey){
		this.tmMacKey = tmMacKey;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmMacKey(){
    	return tmMacKey;
    }
	/**
	 * 
	 * @param tmBlklstSeq
	 */
	public void setTmBlklstSeq(String tmBlklstSeq){
		this.tmBlklstSeq = tmBlklstSeq;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmBlklstSeq(){
    	return tmBlklstSeq;
    }
	/**
	 * 
	 * @param tmOldMackey
	 */
	public void setTmOldMackey(String tmOldMackey){
		this.tmOldMackey = tmOldMackey;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmOldMackey(){
    	return tmOldMackey;
    }
	/**
	 * 
	 * @param tmOldPinkey
	 */
	public void setTmOldPinkey(String tmOldPinkey){
		this.tmOldPinkey = tmOldPinkey;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmOldPinkey(){
    	return tmOldPinkey;
    }
	/**
	 * 
	 * @param tmMasterKey
	 */
	public void setTmMasterKey(String tmMasterKey){
		this.tmMasterKey = tmMasterKey;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmMasterKey(){
    	return tmMasterKey;
    }
	/**
	 * 
	 * @param tmBrand
	 */
	public void setTmBrand(String tmBrand){
		this.tmBrand = tmBrand;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmBrand(){
    	return tmBrand;
    }
	/**
	 * 
	 * @param tmModel
	 */
	public void setTmModel(String tmModel){
		this.tmModel = tmModel;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmModel(){
    	return tmModel;
    }
	/**
	 * 
	 * @param tmIswatch
	 */
	public void setTmIswatch(String tmIswatch){
		this.tmIswatch = tmIswatch;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmIswatch(){
    	return tmIswatch;
    }
	/**
	 * 
	 * @param tmOrgid
	 */
	public void setTmOrgid(String tmOrgid){
		this.tmOrgid = tmOrgid;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmOrgid(){
    	return tmOrgid;
    }
	/**
	 * 
	 * @param tmNetaddr
	 */
	public void setTmNetaddr(String tmNetaddr){
		this.tmNetaddr = tmNetaddr;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmNetaddr(){
    	return tmNetaddr;
    }
	/**
	 * 
	 * @param tmNetport
	 */
	public void setTmNetport(Long tmNetport){
		this.tmNetport = tmNetport;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTmNetport(){
    	return tmNetport;
    }
	/**
	 * 
	 * @param tmContactaddr
	 */
	public void setTmContactaddr(String tmContactaddr){
		this.tmContactaddr = tmContactaddr;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmContactaddr(){
    	return tmContactaddr;
    }
	/**
	 * 
	 * @param tmTermaddr
	 */
	public void setTmTermaddr(String tmTermaddr){
		this.tmTermaddr = tmTermaddr;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmTermaddr(){
    	return tmTermaddr;
    }
	/**
	 * 
	 * @param tmAdminid
	 */
	public void setTmAdminid(String tmAdminid){
		this.tmAdminid = tmAdminid;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmAdminid(){
    	return tmAdminid;
    }
	/**
	 * 
	 * @param tmOpertermid
	 */
	public void setTmOpertermid(String tmOpertermid){
		this.tmOpertermid = tmOpertermid;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmOpertermid(){
    	return tmOpertermid;
    }
	/**
	 * 
	 * @param tmInstType
	 */
	public void setTmInstType(Long tmInstType){
		this.tmInstType = tmInstType;
	}
	
    /**
     * 
     * @return
     */	
    public Long getTmInstType(){
    	return tmInstType;
    }
	/**
	 * 
	 * @param tmSystem
	 */
	public void setTmSystem(String tmSystem){
		this.tmSystem = tmSystem;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmSystem(){
    	return tmSystem;
    }
	/**
	 * 
	 * @param tmUseState
	 */
	public void setTmUseState(String tmUseState){
		this.tmUseState = tmUseState;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmUseState(){
    	return tmUseState;
    }
	/**
	 * 
	 * @param tmLayType
	 */
	public void setTmLayType(String tmLayType){
		this.tmLayType = tmLayType;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmLayType(){
    	return tmLayType;
    }
	/**
	 * 
	 * @param tmIsselfbank
	 */
	public void setTmIsselfbank(String tmIsselfbank){
		this.tmIsselfbank = tmIsselfbank;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmIsselfbank(){
    	return tmIsselfbank;
    }
	/**
	 * 
	 * @param tmIsvideowatch
	 */
	public void setTmIsvideowatch(String tmIsvideowatch){
		this.tmIsvideowatch = tmIsvideowatch;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmIsvideowatch(){
    	return tmIsvideowatch;
    }
	/**
	 * 
	 * @param tmIsups
	 */
	public void setTmIsups(String tmIsups){
		this.tmIsups = tmIsups;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmIsups(){
    	return tmIsups;
    }
	/**
	 * 
	 * @param tmGeog
	 */
	public void setTmGeog(String tmGeog){
		this.tmGeog = tmGeog;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmGeog(){
    	return tmGeog;
    }
	/**
	 * 
	 * @param tmFuncArea
	 */
	public void setTmFuncArea(String tmFuncArea){
		this.tmFuncArea = tmFuncArea;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmFuncArea(){
    	return tmFuncArea;
    }
	/**
	 * 
	 * @param tmProtoco
	 */
	public void setTmProtoco(String tmProtoco){
		this.tmProtoco = tmProtoco;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmProtoco(){
    	return tmProtoco;
    }
	/**
	 * 
	 * @param tmSetupUser
	 */
	public void setTmSetupUser(String tmSetupUser){
		this.tmSetupUser = tmSetupUser;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmSetupUser(){
    	return tmSetupUser;
    }
	/**
	 * 
	 * @param tmSetupTimestamp
	 */
	public void setTmSetupTimestamp(String tmSetupTimestamp){
		this.tmSetupTimestamp = tmSetupTimestamp;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmSetupTimestamp(){
    	return tmSetupTimestamp;
    }
	/**
	 * 
	 * @param tmAuthUser
	 */
	public void setTmAuthUser(String tmAuthUser){
		this.tmAuthUser = tmAuthUser;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmAuthUser(){
    	return tmAuthUser;
    }
	/**
	 * 
	 * @param tmAuthTimestamp
	 */
	public void setTmAuthTimestamp(String tmAuthTimestamp){
		this.tmAuthTimestamp = tmAuthTimestamp;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmAuthTimestamp(){
    	return tmAuthTimestamp;
    }
	/**
	 * 
	 * @param tmAppvUser
	 */
	public void setTmAppvUser(String tmAppvUser){
		this.tmAppvUser = tmAppvUser;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmAppvUser(){
    	return tmAppvUser;
    }
	/**
	 * 
	 * @param tmAppvTimestamp
	 */
	public void setTmAppvTimestamp(String tmAppvTimestamp){
		this.tmAppvTimestamp = tmAppvTimestamp;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmAppvTimestamp(){
    	return tmAppvTimestamp;
    }
	/**
	 * 
	 * @param tmDownInd
	 */
	public void setTmDownInd(String tmDownInd){
		this.tmDownInd = tmDownInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmDownInd(){
    	return tmDownInd;
    }
	/**
	 * 
	 * @param tmDownTimestamp
	 */
	public void setTmDownTimestamp(String tmDownTimestamp){
		this.tmDownTimestamp = tmDownTimestamp;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmDownTimestamp(){
    	return tmDownTimestamp;
    }
	/**
	 * 
	 * @param tmApplStatus
	 */
	public void setTmApplStatus(String tmApplStatus){
		this.tmApplStatus = tmApplStatus;
	}
	
    /**
     * 
     * @return
     */	
    public String getTmApplStatus(){
    	return tmApplStatus;
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