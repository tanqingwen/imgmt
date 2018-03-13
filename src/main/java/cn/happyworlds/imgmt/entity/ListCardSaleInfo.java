package cn.happyworlds.imgmt.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author yanjy
 * cp_ceptrx,cp_trxcde,cp_crdtbl
 */
public class ListCardSaleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 *  
	 */
	private String cbEmbossname;
	/**
	 *  
	 */
	private String ctCardNumber;
	/**
	 *  
	 */
	private String cbIdno;
	/**
	 *  
	 */
	private String ctPostTime;
	/**
	 *  
	 */
	private String ctTranTime;
	/**
	 *  
	 */
	private String ctTranCode;
	/**
	 *  
	 */
	private String sysTrxnDesc;	
	/**
	 *  
	 */
	private java.math.BigDecimal ctTranAmount;
	/**
	 *  
	 */
	private java.math.BigDecimal ctCardAmount;
	/**
	 *  
	 */
	private java.math.BigDecimal ctOutstdB4Post;
	/**
	 *  
	 */
	private java.math.BigDecimal ctOutstdAfterPost;
	
	private String recommerderNo;
	
	public String getRecommerderNo() {
		return recommerderNo;
	}
	public void setRecommerderNo(String recommerderNo) {
		this.recommerderNo = recommerderNo!=null?recommerderNo.replace("HWCARD", ""):recommerderNo;
	}
	public String getCbEmbossname() {
		return cbEmbossname;
	}
	public void setCbEmbossname(String cbEmbossname) {
		this.cbEmbossname = cbEmbossname;
	}
	public String getCtCardNumber() {
		return ctCardNumber;
	}
	public void setCtCardNumber(String ctCardNumber) {
		this.ctCardNumber = ctCardNumber;
	}
	public String getCbIdno() {
		return cbIdno;
	}
	public void setCbIdno(String cbIdno) {
		this.cbIdno = cbIdno;
	}
	public String getCtPostTime() {
		return ctPostTime;
	}
	public void setCtPostTime(String ctPostTime) {
		this.ctPostTime = ctPostTime;
	}
	public String getCtTranTime() {
		return ctTranTime;
	}
	public void setCtTranTime(String ctTranTime) {
		this.ctTranTime = ctTranTime;
	}
	public String getCtTranCode() {
		return ctTranCode;
	}
	public void setCtTranCode(String ctTranCode) {
		this.ctTranCode = ctTranCode;
	}
	public String getSysTrxnDesc() {
		return sysTrxnDesc;
	}
	public void setSysTrxnDesc(String sysTrxnDesc) {
		this.sysTrxnDesc = sysTrxnDesc;
	}
	public java.math.BigDecimal getCtTranAmount() {
		return ctTranAmount;
	}
	public void setCtTranAmount(java.math.BigDecimal ctTranAmount) {
		this.ctTranAmount = ctTranAmount!=null?ctTranAmount.setScale(2, BigDecimal.ROUND_HALF_UP):ctTranAmount;
	}
	public java.math.BigDecimal getCtCardAmount() {
		return ctCardAmount;
	}
	public void setCtCardAmount(java.math.BigDecimal ctCardAmount) {
		this.ctCardAmount = ctCardAmount!=null?ctCardAmount.setScale(2, BigDecimal.ROUND_HALF_UP):ctCardAmount;
	}
	public java.math.BigDecimal getCtOutstdB4Post() {
		return ctOutstdB4Post;
	}
	public void setCtOutstdB4Post(java.math.BigDecimal ctOutstdB4Post) {
		this.ctOutstdB4Post = ctOutstdB4Post!=null?ctOutstdB4Post.setScale(2, BigDecimal.ROUND_HALF_UP):ctOutstdB4Post;
	}
	public java.math.BigDecimal getCtOutstdAfterPost() {
		return ctOutstdAfterPost;
	}
	public void setCtOutstdAfterPost(java.math.BigDecimal ctOutstdAfterPost) {
		this.ctOutstdAfterPost = ctOutstdAfterPost!=null?ctOutstdAfterPost.setScale(2, BigDecimal.ROUND_HALF_UP):ctOutstdAfterPost;
	}

}