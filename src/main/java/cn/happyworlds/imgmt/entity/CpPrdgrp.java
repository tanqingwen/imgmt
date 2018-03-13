package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class CpPrdgrp implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  é—¨ç¥¨ä»£ç �ï¼Œå”¯ä¸€
	 */
	private Integer prProdctGroup;
	/**
	 *  é—¨ç¥¨æ��è¿°
	 */
	private String prGroupDesc;
	/**
	 *  
	 */
	private Integer prBin;
	/**
	 *  
	 */
	private String prCardBrand;
	/**
	 *  
	 */
	private String prCardType;
	/**
	 *  
	 */
	private Integer prBillCyc;
	/**
	 *  
	 */
	private String prNewCardActivation;
	/**
	 *  
	 */
	private String prReplcCardActivation;
	/**
	 *  
	 */
	private String prReissueCardActivation;
	/**
	 *  
	 */
	private Long prUpperRangeValue;
	/**
	 *  
	 */
	private Integer prNewCardValidPrd;
	/**
	 *  
	 */
	private Integer prRenewalValidPrd;
	/**
	 *  
	 */
	private Integer prRenewalDormantPrd;
	/**
	 *  
	 */
	private Integer prCardholderNoLen;
	/**
	 *  ç¥¨åˆ¸æŠ˜æ‰£
	 */
	private Integer prCurr4dbc;
	/**
	 *  
	 */
	private Integer prNext4dbc;
	/**
	 *  
	 */
	private String prNext4dbcDate;
	/**
	 *  
	 */
	private Integer prAmexProduct;
	/**
	 *  
	 */
	private String prCurrInd;
	/**
	 *  
	 */
	private Long prLowerRangeValue;
	/**
	 *  
	 */
	private Integer prPinLength;
	/**
	 *  
	 */
	private String prCardnoRandFlag;
	/**
	 *  
	 */
	private Long prMinCardno;
	/**
	 *  
	 */
	private String prPinFlag;
	/**
	 *  ç¥¨åŠµæ•°é‡�
	 */
	private Integer prPinerrNumber;
	/**
	 *  
	 */
	private Integer prCancelCardDays;
	/**
	 *  
	 */
	private Integer prAllowCardNums;
	/**
	 *  
	 */
	private Integer prProductNum;
	/**
	 *  
	 */
	private String prBranchId;
	/**
	 *  
	 */
	private String prPlasticType;
	/**
	 *  
	 */
	private String prEncryptFlag;
	/**
	 *  
	 */
	private String prCardnumRule;
	/**
	 *  
	 */
	private String checksum;
	/**
<<<<<<< HEAD
=======
	 *  
	 */
	private Integer prCurr4Dbc;
	/**
	 *  
	 */
	private Integer prNext4Dbc;
	/**
	 *  
	 */
	private String prNext4DbcDate;
	/**
	 *  
	 */
	private String hwTicketPic;
	/**
	 *  
	 */
	private java.math.BigDecimal hwPrice;
	/**
	 *  
	 */
	private java.math.BigDecimal hwPriceOne;
	/**
	 *  
	 */
	private java.math.BigDecimal hwPriceTwo;
	/**
	 *  
	 */
	private java.math.BigDecimal hwPriceThree;
	/**
	 *  
	 */
	private java.math.BigDecimal hwHolidayPrice;
	/**
	 *  
	 */
	private java.math.BigDecimal hwChildprice;
	/**
	 *  
	 */
	private java.math.BigDecimal hwElderPrice;
	/**
	 *  
	 */
	private java.math.BigDecimal hwSoldierPrice;
	/**
	 *  
	 */
	private java.math.BigDecimal hwTeacherPrice;
	/**
	 *  
	 */
	private java.math.BigDecimal hwStaffPrice;
	/**
	 *  
	 */
	private java.math.BigDecimal hwSpecialPrice;
	/**
	 *  
	 */
	private String hwCategory;
	/**
	 *  
	 */
	private String hwStartdate;
	/**
	 *  
	 */
	private String hwEnddate;
	/**
	 *  
	 */
	private String hwVenueid;
	/**
	 *  
	 */
	private String hwGateid;
	/**
	 *  
	 */
	private String hwMemberSupport;
	/**
	 *  
	 */
	private String hwState;
	/**
	 *  
	 */
	private java.util.Date hwDate;
	/**
	 *  
	 */
	private String hwUserid;
	/**
	 *  
	 */
	private String hwTicketDes;
	/**
	 *  
	 */
	private String hwTicketPic2;
	/**
	 *  
	 */
	private String hwTicketPic3;
	/**
>>>>>>> 6d714466e5555032c7cf54343d8227b107a51089
	 * é—¨ç¥¨ä»£ç �ï¼Œå”¯ä¸€
	 * @param prProdctGroup
	 */
	public void setPrProdctGroup(Integer prProdctGroup){
		this.prProdctGroup = prProdctGroup;
	}
	
    /**
     * é—¨ç¥¨ä»£ç �ï¼Œå”¯ä¸€
     * @return
     */	
    public Integer getPrProdctGroup(){
    	return prProdctGroup;
    }
	/**
	 * é—¨ç¥¨æ��è¿°
	 * @param prGroupDesc
	 */
	public void setPrGroupDesc(String prGroupDesc){
		this.prGroupDesc = prGroupDesc;
	}
	
    /**
     * é—¨ç¥¨æ��è¿°
     * @return
     */	
    public String getPrGroupDesc(){
    	return prGroupDesc;
    }
	/**
	 * 
	 * @param prBin
	 */
	public void setPrBin(Integer prBin){
		this.prBin = prBin;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrBin(){
    	return prBin;
    }
	/**
	 * 
	 * @param prCardBrand
	 */
	public void setPrCardBrand(String prCardBrand){
		this.prCardBrand = prCardBrand;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrCardBrand(){
    	return prCardBrand;
    }
	/**
	 * 
	 * @param prCardType
	 */
	public void setPrCardType(String prCardType){
		this.prCardType = prCardType;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrCardType(){
    	return prCardType;
    }
	/**
	 * 
	 * @param prBillCyc
	 */
	public void setPrBillCyc(Integer prBillCyc){
		this.prBillCyc = prBillCyc;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrBillCyc(){
    	return prBillCyc;
    }
	/**
	 * 
	 * @param prNewCardActivation
	 */
	public void setPrNewCardActivation(String prNewCardActivation){
		this.prNewCardActivation = prNewCardActivation;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrNewCardActivation(){
    	return prNewCardActivation;
    }
	/**
	 * 
	 * @param prReplcCardActivation
	 */
	public void setPrReplcCardActivation(String prReplcCardActivation){
		this.prReplcCardActivation = prReplcCardActivation;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrReplcCardActivation(){
    	return prReplcCardActivation;
    }
	/**
	 * 
	 * @param prReissueCardActivation
	 */
	public void setPrReissueCardActivation(String prReissueCardActivation){
		this.prReissueCardActivation = prReissueCardActivation;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrReissueCardActivation(){
    	return prReissueCardActivation;
    }
	/**
	 * 
	 * @param prUpperRangeValue
	 */
	public void setPrUpperRangeValue(Long prUpperRangeValue){
		this.prUpperRangeValue = prUpperRangeValue;
	}
	
    /**
     * 
     * @return
     */	
    public Long getPrUpperRangeValue(){
    	return prUpperRangeValue;
    }
	/**
	 * 
	 * @param prNewCardValidPrd
	 */
	public void setPrNewCardValidPrd(Integer prNewCardValidPrd){
		this.prNewCardValidPrd = prNewCardValidPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrNewCardValidPrd(){
    	return prNewCardValidPrd;
    }
	/**
	 * 
	 * @param prRenewalValidPrd
	 */
	public void setPrRenewalValidPrd(Integer prRenewalValidPrd){
		this.prRenewalValidPrd = prRenewalValidPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrRenewalValidPrd(){
    	return prRenewalValidPrd;
    }
	/**
	 * 
	 * @param prRenewalDormantPrd
	 */
	public void setPrRenewalDormantPrd(Integer prRenewalDormantPrd){
		this.prRenewalDormantPrd = prRenewalDormantPrd;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrRenewalDormantPrd(){
    	return prRenewalDormantPrd;
    }
	/**
	 * 
	 * @param prCardholderNoLen
	 */
	public void setPrCardholderNoLen(Integer prCardholderNoLen){
		this.prCardholderNoLen = prCardholderNoLen;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrCardholderNoLen(){
    	return prCardholderNoLen;
    }
	/**
	 * ç¥¨åˆ¸æŠ˜æ‰£
	 * @param prCurr4dbc
	 */
	public void setPrCurr4dbc(Integer prCurr4dbc){
		this.prCurr4dbc = prCurr4dbc;
	}
	
    /**
     * ç¥¨åˆ¸æŠ˜æ‰£
     * @return
     */	
    public Integer getPrCurr4dbc(){
    	return prCurr4dbc;
    }
	/**
	 * 
	 * @param prNext4dbc
	 */
	public void setPrNext4dbc(Integer prNext4dbc){
		this.prNext4dbc = prNext4dbc;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrNext4dbc(){
    	return prNext4dbc;
    }
	/**
	 * 
	 * @param prNext4dbcDate
	 */
	public void setPrNext4dbcDate(String prNext4dbcDate){
		this.prNext4dbcDate = prNext4dbcDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrNext4dbcDate(){
    	return prNext4dbcDate;
    }
	/**
	 * 
	 * @param prAmexProduct
	 */
	public void setPrAmexProduct(Integer prAmexProduct){
		this.prAmexProduct = prAmexProduct;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrAmexProduct(){
    	return prAmexProduct;
    }
	/**
	 * 
	 * @param prCurrInd
	 */
	public void setPrCurrInd(String prCurrInd){
		this.prCurrInd = prCurrInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrCurrInd(){
    	return prCurrInd;
    }
	/**
	 * 
	 * @param prLowerRangeValue
	 */
	public void setPrLowerRangeValue(Long prLowerRangeValue){
		this.prLowerRangeValue = prLowerRangeValue;
	}
	
    /**
     * 
     * @return
     */	
    public Long getPrLowerRangeValue(){
    	return prLowerRangeValue;
    }
	/**
	 * 
	 * @param prPinLength
	 */
	public void setPrPinLength(Integer prPinLength){
		this.prPinLength = prPinLength;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrPinLength(){
    	return prPinLength;
    }
	/**
	 * 
	 * @param prCardnoRandFlag
	 */
	public void setPrCardnoRandFlag(String prCardnoRandFlag){
		this.prCardnoRandFlag = prCardnoRandFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrCardnoRandFlag(){
    	return prCardnoRandFlag;
    }
	/**
	 * 
	 * @param prMinCardno
	 */
	public void setPrMinCardno(Long prMinCardno){
		this.prMinCardno = prMinCardno;
	}
	
    /**
     * 
     * @return
     */	
    public Long getPrMinCardno(){
    	return prMinCardno;
    }
	/**
	 * 
	 * @param prPinFlag
	 */
	public void setPrPinFlag(String prPinFlag){
		this.prPinFlag = prPinFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrPinFlag(){
    	return prPinFlag;
    }
	/**
	 * ç¥¨åŠµæ•°é‡�
	 * @param prPinerrNumber
	 */
	public void setPrPinerrNumber(Integer prPinerrNumber){
		this.prPinerrNumber = prPinerrNumber;
	}
	
    /**
     * ç¥¨åŠµæ•°é‡�
     * @return
     */	
    public Integer getPrPinerrNumber(){
    	return prPinerrNumber;
    }
	/**
	 * 
	 * @param prCancelCardDays
	 */
	public void setPrCancelCardDays(Integer prCancelCardDays){
		this.prCancelCardDays = prCancelCardDays;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrCancelCardDays(){
    	return prCancelCardDays;
    }
	/**
	 * 
	 * @param prAllowCardNums
	 */
	public void setPrAllowCardNums(Integer prAllowCardNums){
		this.prAllowCardNums = prAllowCardNums;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrAllowCardNums(){
    	return prAllowCardNums;
    }
	/**
	 * 
	 * @param prProductNum
	 */
	public void setPrProductNum(Integer prProductNum){
		this.prProductNum = prProductNum;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getPrProductNum(){
    	return prProductNum;
    }
	/**
	 * 
	 * @param prBranchId
	 */
	public void setPrBranchId(String prBranchId){
		this.prBranchId = prBranchId;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrBranchId(){
    	return prBranchId;
    }
	/**
	 * 
	 * @param prPlasticType
	 */
	public void setPrPlasticType(String prPlasticType){
		this.prPlasticType = prPlasticType;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrPlasticType(){
    	return prPlasticType;
    }
	/**
	 * 
	 * @param prEncryptFlag
	 */
	public void setPrEncryptFlag(String prEncryptFlag){
		this.prEncryptFlag = prEncryptFlag;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrEncryptFlag(){
    	return prEncryptFlag;
    }
	/**
	 * 
	 * @param prCardnumRule
	 */
	public void setPrCardnumRule(String prCardnumRule){
		this.prCardnumRule = prCardnumRule;
	}
	
    /**
     * 
     * @return
     */	
    public String getPrCardnumRule(){
    	return prCardnumRule;
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