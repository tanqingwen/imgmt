package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class CpCeptrx implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  机构
	 */
	private String ctBranchId;
	/**
	 *  主键流水号
	 */
	private Long ctTranId;
	/**
	 *  主键流水号(暂不使用)
	 */
	private Long ctMessageId;
	/**
	 *  客户号
	 */
	private String ctCustomerId;
	/**
	 *  商户号
	 */
	private String ctMerchantId;
	/**
	 *  终端号
	 */
	private String ctTerminalId;
	/**
	 *  卡号
	 */
	private String ctCardNumber;
	/**
	 *  开卡地区
	 */
	private String ctOpenZone;
	/**
	 *  交易地区
	 */
	private String ctTranZone;
	/**
	 *  交易号
	 */
	private String ctTranNum;
	/**
	 *  交易时间
	 */
	private String ctTranTime;
	/**
	 *  商户名称
	 */
	private String ctDealName;
	/**
	 *  商户地址
	 */
	private String ctDealAddr;
	/**
	 *  参考号
	 */
	private String ctRefno;
	/**
	 *  借贷标志
	 */
	private String ctDbCr;
	/**
	 *  交易金额
	 */
	private java.math.BigDecimal ctTranAmount;
	/**
	 *  卡金额
	 */
	private java.math.BigDecimal ctCardAmount;
	/**
	 *  费用
	 */
	private java.math.BigDecimal ctFeeAmount;
	/**
	 *  小费
	 */
	private java.math.BigDecimal ctVatAmount;
	/**
	 *  描述
	 */
	private String ctDescription;
	/**
	 *  币种
	 */
	private String ctCurrcode;
	/**
	 *  兑换率
	 */
	private Long ctExchangeRate;
	/**
	 *  对方账号
	 */
	private String ctDestinationAc;
	/**
	 *  建立用户
	 */
	private String ctUserCreate;
	/**
	 *  授权用户
	 */
	private String ctUserApprove;
	/**
	 *  授权时间
	 */
	private String ctApproveTime;
	/**
	 *  记账时间
	 */
	private String ctPostTime;
	/**
	 *  状态
	 */
	private String ctStatus;
	/**
	 *  账号
	 */
	private String ctAccountId;
	/**
	 *  交易码  待确认
	 */
	private String ctTranCode;
	/**
	 *  透支金额
	 */
	private java.math.BigDecimal ctOdAmount;
	/**
	 *  透支标志
	 */
	private String ctDc;
	/**
	 *  收单行
	 */
	private String ctAcquireBank;
	/**
	 *  费用
	 */
	private java.math.BigDecimal ctBankFee;
	/**
	 *  
	 */
	private java.math.BigDecimal ctBankVat;
	/**
	 *  结算日期
	 */
	private String ctStmtDate;
	/**
	 *  
	 */
	private String ctActionStatus;
	/**
	 *  交易类型 待确认
	 */
	private String ctTxrnType;
	/**
	 *  转账对方姓名
	 */
	private String cpTxferName;
	/**
	 *  批次号
	 */
	private String ctBatchNo;
	/**
	 *  授权码
	 */
	private String ctApprovalCd;
	/**
	 *  记账币种
	 */
	private Long ctBillCurrCd;
	/**
	 *  记账金额
	 */
	private java.math.BigDecimal ctBillCurrAmt;
	/**
	 *  商户类别代码
	 */
	private Long ctMcc;
	/**
	 *  
	 */
	private String ctTcc;
	/**
	 *  原交易入账日期
	 */
	private String ctOrgPostDate;
	/**
	 *  原交易主键流水号
	 */
	private Long ctOrgTrxnId;
	/**
	 *  
	 */
	private String ctDisputeDate;
	/**
	 *  
	 */
	private String ctResolutionDate;
	/**
	 *  
	 */
	private String ctResolutionInd;
	/**
	 *  
	 */
	private Long ctChgbakRefno;
	/**
	 *  商户名
	 */
	private String ctMercName;
	/**
	 *  商户信息
	 */
	private String ctMercInfo;
	/**
	 *  收单号
	 */
	private Long ctAcqMemberId;
	/**
	 *  销售点输入方式
	 */
	private String ctPosEntry;
	/**
	 *  日期
	 */
	private Long ctProcDate;
	/**
	 *  发卡行bin
	 */
	private String ctIssuerBin;
	/**
	 *  收单行bin
	 */
	private String ctAcqBin;
	/**
	 *  流水号
	 */
	private Long ctTraceNo;
	/**
	 *  授权币种
	 */
	private String ctAuthCurr;
	/**
	 *  授权应答
	 */
	private String ctAuthResp;
	/**
	 *  授权金额
	 */
	private java.math.BigDecimal ctAuthAmt;
	/**
	 *  记账前账龄代码
	 */
	private String ctAgeCodeB4Post;
	/**
	 *  记账前余额
	 */
	private java.math.BigDecimal ctOutstdB4Post;
	/**
	 *  记账后账龄代码
	 */
	private String ctAgeCodeAfterPost;
	/**
	 *  记账后余额
	 */
	private java.math.BigDecimal ctOutstdAfterPost;
	/**
	 *  
	 */
	private String ctCrdAccId;
	/**
	 *  用户状态1
	 */
	private String ctUserStatus1;
	/**
	 *  用户状态2
	 */
	private String ctUserStatus2;
	/**
	 *  用户状态3
	 */
	private String ctUserStatus3;
	/**
	 *  用户金额1
	 */
	private java.math.BigDecimal ctUserAmt1;
	/**
	 *  用户金额2
	 */
	private java.math.BigDecimal ctUserAmt2;
	/**
	 *  用户金额3
	 */
	private java.math.BigDecimal ctUserAmt3;
	/**
	 *  用户金额4
	 */
	private java.math.BigDecimal ctUserAmt4;
	/**
	 *  用户笔数1
	 */
	private Long ctUserCnt1;
	/**
	 *  用户笔数2
	 */
	private Long ctUserCnt2;
	/**
	 *  用户笔数3
	 */
	private Long ctUserCnt3;
	/**
	 *  主副卡标志
	 */
	private String ctBasicSuppInd;
	/**
	 *  授权标志
	 */
	private String authFlag;
	/**
	 *  初次交易时间
	 */
	private String firstTime;
	/**
	 *  转账名称
	 */
	private String ctTxferName;
	/**
	 *  转账标志
	 */
	private String ctTxferStatus;
	/**
	 *  打印状态
	 */
	private String ctPrintStatus;
	/**
	 *  撤销标志
	 */
	private String ctReversalFlag;
	/**
	 *  备注
	 */
	private String ctNote;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 机构
	 * @param ctBranchId
	 */
	public void setCtBranchId(String ctBranchId){
		this.ctBranchId = ctBranchId;
	}
	
    /**
     * 机构
     * @return
     */	
    public String getCtBranchId(){
    	return ctBranchId;
    }
	/**
	 * 主键流水号
	 * @param ctTranId
	 */
	public void setCtTranId(Long ctTranId){
		this.ctTranId = ctTranId;
	}
	
    /**
     * 主键流水号
     * @return
     */	
    public Long getCtTranId(){
    	return ctTranId;
    }
	/**
	 * 主键流水号(暂不使用)
	 * @param ctMessageId
	 */
	public void setCtMessageId(Long ctMessageId){
		this.ctMessageId = ctMessageId;
	}
	
    /**
     * 主键流水号(暂不使用)
     * @return
     */	
    public Long getCtMessageId(){
    	return ctMessageId;
    }
	/**
	 * 客户号
	 * @param ctCustomerId
	 */
	public void setCtCustomerId(String ctCustomerId){
		this.ctCustomerId = ctCustomerId;
	}
	
    /**
     * 客户号
     * @return
     */	
    public String getCtCustomerId(){
    	return ctCustomerId;
    }
	/**
	 * 商户号
	 * @param ctMerchantId
	 */
	public void setCtMerchantId(String ctMerchantId){
		this.ctMerchantId = ctMerchantId;
	}
	
    /**
     * 商户号
     * @return
     */	
    public String getCtMerchantId(){
    	return ctMerchantId;
    }
	/**
	 * 终端号
	 * @param ctTerminalId
	 */
	public void setCtTerminalId(String ctTerminalId){
		this.ctTerminalId = ctTerminalId;
	}
	
    /**
     * 终端号
     * @return
     */	
    public String getCtTerminalId(){
    	return ctTerminalId;
    }
	/**
	 * 卡号
	 * @param ctCardNumber
	 */
	public void setCtCardNumber(String ctCardNumber){
		this.ctCardNumber = ctCardNumber;
	}
	
    /**
     * 卡号
     * @return
     */	
    public String getCtCardNumber(){
    	return ctCardNumber;
    }
	/**
	 * 开卡地区
	 * @param ctOpenZone
	 */
	public void setCtOpenZone(String ctOpenZone){
		this.ctOpenZone = ctOpenZone;
	}
	
    /**
     * 开卡地区
     * @return
     */	
    public String getCtOpenZone(){
    	return ctOpenZone;
    }
	/**
	 * 交易地区
	 * @param ctTranZone
	 */
	public void setCtTranZone(String ctTranZone){
		this.ctTranZone = ctTranZone;
	}
	
    /**
     * 交易地区
     * @return
     */	
    public String getCtTranZone(){
    	return ctTranZone;
    }
	/**
	 * 交易号
	 * @param ctTranNum
	 */
	public void setCtTranNum(String ctTranNum){
		this.ctTranNum = ctTranNum;
	}
	
    /**
     * 交易号
     * @return
     */	
    public String getCtTranNum(){
    	return ctTranNum;
    }
	/**
	 * 交易时间
	 * @param ctTranTime
	 */
	public void setCtTranTime(String ctTranTime){
		this.ctTranTime = ctTranTime;
	}
	
    /**
     * 交易时间
     * @return
     */	
    public String getCtTranTime(){
    	return ctTranTime;
    }
	/**
	 * 商户名称
	 * @param ctDealName
	 */
	public void setCtDealName(String ctDealName){
		this.ctDealName = ctDealName;
	}
	
    /**
     * 商户名称
     * @return
     */	
    public String getCtDealName(){
    	return ctDealName;
    }
	/**
	 * 商户地址
	 * @param ctDealAddr
	 */
	public void setCtDealAddr(String ctDealAddr){
		this.ctDealAddr = ctDealAddr;
	}
	
    /**
     * 商户地址
     * @return
     */	
    public String getCtDealAddr(){
    	return ctDealAddr;
    }
	/**
	 * 参考号
	 * @param ctRefno
	 */
	public void setCtRefno(String ctRefno){
		this.ctRefno = ctRefno;
	}
	
    /**
     * 参考号
     * @return
     */	
    public String getCtRefno(){
    	return ctRefno;
    }
	/**
	 * 借贷标志
	 * @param ctDbCr
	 */
	public void setCtDbCr(String ctDbCr){
		this.ctDbCr = ctDbCr;
	}
	
    /**
     * 借贷标志
     * @return
     */	
    public String getCtDbCr(){
    	return ctDbCr;
    }
	/**
	 * 交易金额
	 * @param ctTranAmount
	 */
	public void setCtTranAmount(java.math.BigDecimal ctTranAmount){
		this.ctTranAmount = ctTranAmount;
	}
	
    /**
     * 交易金额
     * @return
     */	
    public java.math.BigDecimal getCtTranAmount(){
    	return ctTranAmount;
    }
	/**
	 * 卡金额
	 * @param ctCardAmount
	 */
	public void setCtCardAmount(java.math.BigDecimal ctCardAmount){
		this.ctCardAmount = ctCardAmount;
	}
	
    /**
     * 卡金额
     * @return
     */	
    public java.math.BigDecimal getCtCardAmount(){
    	return ctCardAmount;
    }
	/**
	 * 费用
	 * @param ctFeeAmount
	 */
	public void setCtFeeAmount(java.math.BigDecimal ctFeeAmount){
		this.ctFeeAmount = ctFeeAmount;
	}
	
    /**
     * 费用
     * @return
     */	
    public java.math.BigDecimal getCtFeeAmount(){
    	return ctFeeAmount;
    }
	/**
	 * 小费
	 * @param ctVatAmount
	 */
	public void setCtVatAmount(java.math.BigDecimal ctVatAmount){
		this.ctVatAmount = ctVatAmount;
	}
	
    /**
     * 小费
     * @return
     */	
    public java.math.BigDecimal getCtVatAmount(){
    	return ctVatAmount;
    }
	/**
	 * 描述
	 * @param ctDescription
	 */
	public void setCtDescription(String ctDescription){
		this.ctDescription = ctDescription;
	}
	
    /**
     * 描述
     * @return
     */	
    public String getCtDescription(){
    	return ctDescription;
    }
	/**
	 * 币种
	 * @param ctCurrcode
	 */
	public void setCtCurrcode(String ctCurrcode){
		this.ctCurrcode = ctCurrcode;
	}
	
    /**
     * 币种
     * @return
     */	
    public String getCtCurrcode(){
    	return ctCurrcode;
    }
	/**
	 * 兑换率
	 * @param ctExchangeRate
	 */
	public void setCtExchangeRate(Long ctExchangeRate){
		this.ctExchangeRate = ctExchangeRate;
	}
	
    /**
     * 兑换率
     * @return
     */	
    public Long getCtExchangeRate(){
    	return ctExchangeRate;
    }
	/**
	 * 对方账号
	 * @param ctDestinationAc
	 */
	public void setCtDestinationAc(String ctDestinationAc){
		this.ctDestinationAc = ctDestinationAc;
	}
	
    /**
     * 对方账号
     * @return
     */	
    public String getCtDestinationAc(){
    	return ctDestinationAc;
    }
	/**
	 * 建立用户
	 * @param ctUserCreate
	 */
	public void setCtUserCreate(String ctUserCreate){
		this.ctUserCreate = ctUserCreate;
	}
	
    /**
     * 建立用户
     * @return
     */	
    public String getCtUserCreate(){
    	return ctUserCreate;
    }
	/**
	 * 授权用户
	 * @param ctUserApprove
	 */
	public void setCtUserApprove(String ctUserApprove){
		this.ctUserApprove = ctUserApprove;
	}
	
    /**
     * 授权用户
     * @return
     */	
    public String getCtUserApprove(){
    	return ctUserApprove;
    }
	/**
	 * 授权时间
	 * @param ctApproveTime
	 */
	public void setCtApproveTime(String ctApproveTime){
		this.ctApproveTime = ctApproveTime;
	}
	
    /**
     * 授权时间
     * @return
     */	
    public String getCtApproveTime(){
    	return ctApproveTime;
    }
	/**
	 * 记账时间
	 * @param ctPostTime
	 */
	public void setCtPostTime(String ctPostTime){
		this.ctPostTime = ctPostTime;
	}
	
    /**
     * 记账时间
     * @return
     */	
    public String getCtPostTime(){
    	return ctPostTime;
    }
	/**
	 * 状态
	 * @param ctStatus
	 */
	public void setCtStatus(String ctStatus){
		this.ctStatus = ctStatus;
	}
	
    /**
     * 状态
     * @return
     */	
    public String getCtStatus(){
    	return ctStatus;
    }
	/**
	 * 账号
	 * @param ctAccountId
	 */
	public void setCtAccountId(String ctAccountId){
		this.ctAccountId = ctAccountId;
	}
	
    /**
     * 账号
     * @return
     */	
    public String getCtAccountId(){
    	return ctAccountId;
    }
	/**
	 * 交易码  待确认
	 * @param ctTranCode
	 */
	public void setCtTranCode(String ctTranCode){
		this.ctTranCode = ctTranCode;
	}
	
    /**
     * 交易码  待确认
     * @return
     */	
    public String getCtTranCode(){
    	return ctTranCode;
    }
	/**
	 * 透支金额
	 * @param ctOdAmount
	 */
	public void setCtOdAmount(java.math.BigDecimal ctOdAmount){
		this.ctOdAmount = ctOdAmount;
	}
	
    /**
     * 透支金额
     * @return
     */	
    public java.math.BigDecimal getCtOdAmount(){
    	return ctOdAmount;
    }
	/**
	 * 透支标志
	 * @param ctDc
	 */
	public void setCtDc(String ctDc){
		this.ctDc = ctDc;
	}
	
    /**
     * 透支标志
     * @return
     */	
    public String getCtDc(){
    	return ctDc;
    }
	/**
	 * 收单行
	 * @param ctAcquireBank
	 */
	public void setCtAcquireBank(String ctAcquireBank){
		this.ctAcquireBank = ctAcquireBank;
	}
	
    /**
     * 收单行
     * @return
     */	
    public String getCtAcquireBank(){
    	return ctAcquireBank;
    }
	/**
	 * 费用
	 * @param ctBankFee
	 */
	public void setCtBankFee(java.math.BigDecimal ctBankFee){
		this.ctBankFee = ctBankFee;
	}
	
    /**
     * 费用
     * @return
     */	
    public java.math.BigDecimal getCtBankFee(){
    	return ctBankFee;
    }
	/**
	 * 
	 * @param ctBankVat
	 */
	public void setCtBankVat(java.math.BigDecimal ctBankVat){
		this.ctBankVat = ctBankVat;
	}
	
    /**
     * 
     * @return
     */	
    public java.math.BigDecimal getCtBankVat(){
    	return ctBankVat;
    }
	/**
	 * 结算日期
	 * @param ctStmtDate
	 */
	public void setCtStmtDate(String ctStmtDate){
		this.ctStmtDate = ctStmtDate;
	}
	
    /**
     * 结算日期
     * @return
     */	
    public String getCtStmtDate(){
    	return ctStmtDate;
    }
	/**
	 * 
	 * @param ctActionStatus
	 */
	public void setCtActionStatus(String ctActionStatus){
		this.ctActionStatus = ctActionStatus;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtActionStatus(){
    	return ctActionStatus;
    }
	/**
	 * 交易类型 待确认
	 * @param ctTxrnType
	 */
	public void setCtTxrnType(String ctTxrnType){
		this.ctTxrnType = ctTxrnType;
	}
	
    /**
     * 交易类型 待确认
     * @return
     */	
    public String getCtTxrnType(){
    	return ctTxrnType;
    }
	/**
	 * 转账对方姓名
	 * @param cpTxferName
	 */
	public void setCpTxferName(String cpTxferName){
		this.cpTxferName = cpTxferName;
	}
	
    /**
     * 转账对方姓名
     * @return
     */	
    public String getCpTxferName(){
    	return cpTxferName;
    }
	/**
	 * 批次号
	 * @param ctBatchNo
	 */
	public void setCtBatchNo(String ctBatchNo){
		this.ctBatchNo = ctBatchNo;
	}
	
    /**
     * 批次号
     * @return
     */	
    public String getCtBatchNo(){
    	return ctBatchNo;
    }
	/**
	 * 授权码
	 * @param ctApprovalCd
	 */
	public void setCtApprovalCd(String ctApprovalCd){
		this.ctApprovalCd = ctApprovalCd;
	}
	
    /**
     * 授权码
     * @return
     */	
    public String getCtApprovalCd(){
    	return ctApprovalCd;
    }
	/**
	 * 记账币种
	 * @param ctBillCurrCd
	 */
	public void setCtBillCurrCd(Long ctBillCurrCd){
		this.ctBillCurrCd = ctBillCurrCd;
	}
	
    /**
     * 记账币种
     * @return
     */	
    public Long getCtBillCurrCd(){
    	return ctBillCurrCd;
    }
	/**
	 * 记账金额
	 * @param ctBillCurrAmt
	 */
	public void setCtBillCurrAmt(java.math.BigDecimal ctBillCurrAmt){
		this.ctBillCurrAmt = ctBillCurrAmt;
	}
	
    /**
     * 记账金额
     * @return
     */	
    public java.math.BigDecimal getCtBillCurrAmt(){
    	return ctBillCurrAmt;
    }
	/**
	 * 商户类别代码
	 * @param ctMcc
	 */
	public void setCtMcc(Long ctMcc){
		this.ctMcc = ctMcc;
	}
	
    /**
     * 商户类别代码
     * @return
     */	
    public Long getCtMcc(){
    	return ctMcc;
    }
	/**
	 * 
	 * @param ctTcc
	 */
	public void setCtTcc(String ctTcc){
		this.ctTcc = ctTcc;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtTcc(){
    	return ctTcc;
    }
	/**
	 * 原交易入账日期
	 * @param ctOrgPostDate
	 */
	public void setCtOrgPostDate(String ctOrgPostDate){
		this.ctOrgPostDate = ctOrgPostDate;
	}
	
    /**
     * 原交易入账日期
     * @return
     */	
    public String getCtOrgPostDate(){
    	return ctOrgPostDate;
    }
	/**
	 * 原交易主键流水号
	 * @param ctOrgTrxnId
	 */
	public void setCtOrgTrxnId(Long ctOrgTrxnId){
		this.ctOrgTrxnId = ctOrgTrxnId;
	}
	
    /**
     * 原交易主键流水号
     * @return
     */	
    public Long getCtOrgTrxnId(){
    	return ctOrgTrxnId;
    }
	/**
	 * 
	 * @param ctDisputeDate
	 */
	public void setCtDisputeDate(String ctDisputeDate){
		this.ctDisputeDate = ctDisputeDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtDisputeDate(){
    	return ctDisputeDate;
    }
	/**
	 * 
	 * @param ctResolutionDate
	 */
	public void setCtResolutionDate(String ctResolutionDate){
		this.ctResolutionDate = ctResolutionDate;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtResolutionDate(){
    	return ctResolutionDate;
    }
	/**
	 * 
	 * @param ctResolutionInd
	 */
	public void setCtResolutionInd(String ctResolutionInd){
		this.ctResolutionInd = ctResolutionInd;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtResolutionInd(){
    	return ctResolutionInd;
    }
	/**
	 * 
	 * @param ctChgbakRefno
	 */
	public void setCtChgbakRefno(Long ctChgbakRefno){
		this.ctChgbakRefno = ctChgbakRefno;
	}
	
    /**
     * 
     * @return
     */	
    public Long getCtChgbakRefno(){
    	return ctChgbakRefno;
    }
	/**
	 * 商户名
	 * @param ctMercName
	 */
	public void setCtMercName(String ctMercName){
		this.ctMercName = ctMercName;
	}
	
    /**
     * 商户名
     * @return
     */	
    public String getCtMercName(){
    	return ctMercName;
    }
	/**
	 * 商户信息
	 * @param ctMercInfo
	 */
	public void setCtMercInfo(String ctMercInfo){
		this.ctMercInfo = ctMercInfo;
	}
	
    /**
     * 商户信息
     * @return
     */	
    public String getCtMercInfo(){
    	return ctMercInfo;
    }
	/**
	 * 收单号
	 * @param ctAcqMemberId
	 */
	public void setCtAcqMemberId(Long ctAcqMemberId){
		this.ctAcqMemberId = ctAcqMemberId;
	}
	
    /**
     * 收单号
     * @return
     */	
    public Long getCtAcqMemberId(){
    	return ctAcqMemberId;
    }
	/**
	 * 销售点输入方式
	 * @param ctPosEntry
	 */
	public void setCtPosEntry(String ctPosEntry){
		this.ctPosEntry = ctPosEntry;
	}
	
    /**
     * 销售点输入方式
     * @return
     */	
    public String getCtPosEntry(){
    	return ctPosEntry;
    }
	/**
	 * 日期
	 * @param ctProcDate
	 */
	public void setCtProcDate(Long ctProcDate){
		this.ctProcDate = ctProcDate;
	}
	
    /**
     * 日期
     * @return
     */	
    public Long getCtProcDate(){
    	return ctProcDate;
    }
	/**
	 * 发卡行bin
	 * @param ctIssuerBin
	 */
	public void setCtIssuerBin(String ctIssuerBin){
		this.ctIssuerBin = ctIssuerBin;
	}
	
    /**
     * 发卡行bin
     * @return
     */	
    public String getCtIssuerBin(){
    	return ctIssuerBin;
    }
	/**
	 * 收单行bin
	 * @param ctAcqBin
	 */
	public void setCtAcqBin(String ctAcqBin){
		this.ctAcqBin = ctAcqBin;
	}
	
    /**
     * 收单行bin
     * @return
     */	
    public String getCtAcqBin(){
    	return ctAcqBin;
    }
	/**
	 * 流水号
	 * @param ctTraceNo
	 */
	public void setCtTraceNo(Long ctTraceNo){
		this.ctTraceNo = ctTraceNo;
	}
	
    /**
     * 流水号
     * @return
     */	
    public Long getCtTraceNo(){
    	return ctTraceNo;
    }
	/**
	 * 授权币种
	 * @param ctAuthCurr
	 */
	public void setCtAuthCurr(String ctAuthCurr){
		this.ctAuthCurr = ctAuthCurr;
	}
	
    /**
     * 授权币种
     * @return
     */	
    public String getCtAuthCurr(){
    	return ctAuthCurr;
    }
	/**
	 * 授权应答
	 * @param ctAuthResp
	 */
	public void setCtAuthResp(String ctAuthResp){
		this.ctAuthResp = ctAuthResp;
	}
	
    /**
     * 授权应答
     * @return
     */	
    public String getCtAuthResp(){
    	return ctAuthResp;
    }
	/**
	 * 授权金额
	 * @param ctAuthAmt
	 */
	public void setCtAuthAmt(java.math.BigDecimal ctAuthAmt){
		this.ctAuthAmt = ctAuthAmt;
	}
	
    /**
     * 授权金额
     * @return
     */	
    public java.math.BigDecimal getCtAuthAmt(){
    	return ctAuthAmt;
    }
	/**
	 * 记账前账龄代码
	 * @param ctAgeCodeB4Post
	 */
	public void setCtAgeCodeB4Post(String ctAgeCodeB4Post){
		this.ctAgeCodeB4Post = ctAgeCodeB4Post;
	}
	
    /**
     * 记账前账龄代码
     * @return
     */	
    public String getCtAgeCodeB4Post(){
    	return ctAgeCodeB4Post;
    }
	/**
	 * 记账前余额
	 * @param ctOutstdB4Post
	 */
	public void setCtOutstdB4Post(java.math.BigDecimal ctOutstdB4Post){
		this.ctOutstdB4Post = ctOutstdB4Post;
	}
	
    /**
     * 记账前余额
     * @return
     */	
    public java.math.BigDecimal getCtOutstdB4Post(){
    	return ctOutstdB4Post;
    }
	/**
	 * 记账后账龄代码
	 * @param ctAgeCodeAfterPost
	 */
	public void setCtAgeCodeAfterPost(String ctAgeCodeAfterPost){
		this.ctAgeCodeAfterPost = ctAgeCodeAfterPost;
	}
	
    /**
     * 记账后账龄代码
     * @return
     */	
    public String getCtAgeCodeAfterPost(){
    	return ctAgeCodeAfterPost;
    }
	/**
	 * 记账后余额
	 * @param ctOutstdAfterPost
	 */
	public void setCtOutstdAfterPost(java.math.BigDecimal ctOutstdAfterPost){
		this.ctOutstdAfterPost = ctOutstdAfterPost;
	}
	
    /**
     * 记账后余额
     * @return
     */	
    public java.math.BigDecimal getCtOutstdAfterPost(){
    	return ctOutstdAfterPost;
    }
	/**
	 * 
	 * @param ctCrdAccId
	 */
	public void setCtCrdAccId(String ctCrdAccId){
		this.ctCrdAccId = ctCrdAccId;
	}
	
    /**
     * 
     * @return
     */	
    public String getCtCrdAccId(){
    	return ctCrdAccId;
    }
	/**
	 * 用户状态1
	 * @param ctUserStatus1
	 */
	public void setCtUserStatus1(String ctUserStatus1){
		this.ctUserStatus1 = ctUserStatus1;
	}
	
    /**
     * 用户状态1
     * @return
     */	
    public String getCtUserStatus1(){
    	return ctUserStatus1;
    }
	/**
	 * 用户状态2
	 * @param ctUserStatus2
	 */
	public void setCtUserStatus2(String ctUserStatus2){
		this.ctUserStatus2 = ctUserStatus2;
	}
	
    /**
     * 用户状态2
     * @return
     */	
    public String getCtUserStatus2(){
    	return ctUserStatus2;
    }
	/**
	 * 用户状态3
	 * @param ctUserStatus3
	 */
	public void setCtUserStatus3(String ctUserStatus3){
		this.ctUserStatus3 = ctUserStatus3;
	}
	
    /**
     * 用户状态3
     * @return
     */	
    public String getCtUserStatus3(){
    	return ctUserStatus3;
    }
	/**
	 * 用户金额1
	 * @param ctUserAmt1
	 */
	public void setCtUserAmt1(java.math.BigDecimal ctUserAmt1){
		this.ctUserAmt1 = ctUserAmt1;
	}
	
    /**
     * 用户金额1
     * @return
     */	
    public java.math.BigDecimal getCtUserAmt1(){
    	return ctUserAmt1;
    }
	/**
	 * 用户金额2
	 * @param ctUserAmt2
	 */
	public void setCtUserAmt2(java.math.BigDecimal ctUserAmt2){
		this.ctUserAmt2 = ctUserAmt2;
	}
	
    /**
     * 用户金额2
     * @return
     */	
    public java.math.BigDecimal getCtUserAmt2(){
    	return ctUserAmt2;
    }
	/**
	 * 用户金额3
	 * @param ctUserAmt3
	 */
	public void setCtUserAmt3(java.math.BigDecimal ctUserAmt3){
		this.ctUserAmt3 = ctUserAmt3;
	}
	
    /**
     * 用户金额3
     * @return
     */	
    public java.math.BigDecimal getCtUserAmt3(){
    	return ctUserAmt3;
    }
	/**
	 * 用户金额4
	 * @param ctUserAmt4
	 */
	public void setCtUserAmt4(java.math.BigDecimal ctUserAmt4){
		this.ctUserAmt4 = ctUserAmt4;
	}
	
    /**
     * 用户金额4
     * @return
     */	
    public java.math.BigDecimal getCtUserAmt4(){
    	return ctUserAmt4;
    }
	/**
	 * 用户笔数1
	 * @param ctUserCnt1
	 */
	public void setCtUserCnt1(Long ctUserCnt1){
		this.ctUserCnt1 = ctUserCnt1;
	}
	
    /**
     * 用户笔数1
     * @return
     */	
    public Long getCtUserCnt1(){
    	return ctUserCnt1;
    }
	/**
	 * 用户笔数2
	 * @param ctUserCnt2
	 */
	public void setCtUserCnt2(Long ctUserCnt2){
		this.ctUserCnt2 = ctUserCnt2;
	}
	
    /**
     * 用户笔数2
     * @return
     */	
    public Long getCtUserCnt2(){
    	return ctUserCnt2;
    }
	/**
	 * 用户笔数3
	 * @param ctUserCnt3
	 */
	public void setCtUserCnt3(Long ctUserCnt3){
		this.ctUserCnt3 = ctUserCnt3;
	}
	
    /**
     * 用户笔数3
     * @return
     */	
    public Long getCtUserCnt3(){
    	return ctUserCnt3;
    }
	/**
	 * 主副卡标志
	 * @param ctBasicSuppInd
	 */
	public void setCtBasicSuppInd(String ctBasicSuppInd){
		this.ctBasicSuppInd = ctBasicSuppInd;
	}
	
    /**
     * 主副卡标志
     * @return
     */	
    public String getCtBasicSuppInd(){
    	return ctBasicSuppInd;
    }
	/**
	 * 授权标志
	 * @param authFlag
	 */
	public void setAuthFlag(String authFlag){
		this.authFlag = authFlag;
	}
	
    /**
     * 授权标志
     * @return
     */	
    public String getAuthFlag(){
    	return authFlag;
    }
	/**
	 * 初次交易时间
	 * @param firstTime
	 */
	public void setFirstTime(String firstTime){
		this.firstTime = firstTime;
	}
	
    /**
     * 初次交易时间
     * @return
     */	
    public String getFirstTime(){
    	return firstTime;
    }
	/**
	 * 转账名称
	 * @param ctTxferName
	 */
	public void setCtTxferName(String ctTxferName){
		this.ctTxferName = ctTxferName;
	}
	
    /**
     * 转账名称
     * @return
     */	
    public String getCtTxferName(){
    	return ctTxferName;
    }
	/**
	 * 转账标志
	 * @param ctTxferStatus
	 */
	public void setCtTxferStatus(String ctTxferStatus){
		this.ctTxferStatus = ctTxferStatus;
	}
	
    /**
     * 转账标志
     * @return
     */	
    public String getCtTxferStatus(){
    	return ctTxferStatus;
    }
	/**
	 * 打印状态
	 * @param ctPrintStatus
	 */
	public void setCtPrintStatus(String ctPrintStatus){
		this.ctPrintStatus = ctPrintStatus;
	}
	
    /**
     * 打印状态
     * @return
     */	
    public String getCtPrintStatus(){
    	return ctPrintStatus;
    }
	/**
	 * 撤销标志
	 * @param ctReversalFlag
	 */
	public void setCtReversalFlag(String ctReversalFlag){
		this.ctReversalFlag = ctReversalFlag;
	}
	
    /**
     * 撤销标志
     * @return
     */	
    public String getCtReversalFlag(){
    	return ctReversalFlag;
    }
	/**
	 * 备注
	 * @param ctNote
	 */
	public void setCtNote(String ctNote){
		this.ctNote = ctNote;
	}
	
    /**
     * 备注
     * @return
     */	
    public String getCtNote(){
    	return ctNote;
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