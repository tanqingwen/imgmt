package cn.happyworlds.imgmt.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author yanjy
 */
public class VipCardStat implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 *  cp_crdtbl‘卡号、会员卡信息查询、会员卡情况查询
	 */
	private String cbCardholderNo;
	/**
	 *  cp_crdtbl‘姓名、会员卡信息查询
	 */
	private String cbEmbossname;
	/**
	 *  cp_crdtbl‘证件类型、会员卡信息查询
	 */
	private String cbIdType;
	/**
	 *  cp_crdtbl‘证件号码、会员卡信息查询、会员卡情况查询
	 */
	private String cbIdno;
	/**
	 *  cp_crdtbl‘手机号码、会员卡信息查询
	 */
	private String cbSourceCd;
	/**
	 *  cp_crdtbl‘押金、会员卡信息查询
	 */
	private Integer cbCvki;
	/**
	 *  cp_crdtbl‘时间、会员卡信息查询、会员卡情况查询
	 */
	private String cbAnnivDate;
	/**
	 *  cp_prdgrp‘卡产品、会员卡信息查询、会员卡情况查询
	 */
	private String prGroupDesc;
	/**
	 *  cp_crdtbl‘操作员、会员卡信息查询
	 */
	private String cbModUser;
	/**
	 *  cp_crdtbl‘状态、会员卡信息查询、会员卡情况查询
	 */
	private String cbPlasticCd;
	/**
	 *  cp_indacc‘余额、会员卡情况查询
	 */
	private java.math.BigDecimal cbOutstdBal;
	/**
	 *  cp_crdtbl‘卡有效期、会员卡情况查询
	 */
	private String cbExpiryCcyymm;
	/**
	 *  cp_idtype‘卡主证件类型、会员卡情况查询
	 */
	private String cbIdDesc;
	/**
	 *  cp_crdtbl、会员卡情况查询
	 */
	private String cbCifFlag;
	
	private String cbAcctStatus;
	/**
	 * cbAcctStatus 账户状态
	 */
	
	private String cbExternalBranch;
	/**
	 * cbExternalBranch 会员卡积分
	 */
	public String getCbAcctStatus() {
		return cbAcctStatus;
	}
	public String getCbExternalBranch() {
		return cbExternalBranch;
	}
	public void setCbExternalBranch(String cbExternalBranch) {
		this.cbExternalBranch = cbExternalBranch;
	}
	public void setCbAcctStatus(String cbAcctStatus) {
		this.cbAcctStatus = cbAcctStatus;
	}
	public String getCbCifFlag() {
		return cbCifFlag;
	}
	public void setCbCifFlag(String cbCifFlag) {
		this.cbCifFlag = cbCifFlag;
	}
	public java.math.BigDecimal getCbOutstdBal() {
		return cbOutstdBal;
	}
	public void setCbOutstdBal(java.math.BigDecimal cbOutstdBal) {
		this.cbOutstdBal = cbOutstdBal!=null?cbOutstdBal.setScale(2, BigDecimal.ROUND_HALF_UP):cbOutstdBal;
	}
	public String getCbExpiryCcyymm() {
		return cbExpiryCcyymm;
	}
	public void setCbExpiryCcyymm(String cbExpiryCcyymm) {
		this.cbExpiryCcyymm = cbExpiryCcyymm;
	}
	public String getCbIdDesc() {
		return cbIdDesc;
	}
	public void setCbIdDesc(String cbIdDesc) {
		this.cbIdDesc = cbIdDesc;
	}
	public String getCbCardholderNo() {
		return cbCardholderNo;
	}
	public void setCbCardholderNo(String cbCardholderNo) {
		this.cbCardholderNo = cbCardholderNo;
	}
	public String getCbEmbossname() {
		return cbEmbossname;
	}
	public void setCbEmbossname(String cbEmbossname) {
		this.cbEmbossname = cbEmbossname;
	}
	public String getCbIdType() {
		return cbIdType;
	}
	public void setCbIdType(String cbIdType) {
		this.cbIdType = cbIdType;
	}
	public String getCbIdno() {
		return cbIdno;
	}
	public void setCbIdno(String cbIdno) {
		this.cbIdno = cbIdno;
	}
	public String getCbSourceCd() {
		return cbSourceCd;
	}
	public void setCbSourceCd(String cbSourceCd) {
		this.cbSourceCd = cbSourceCd;
	}
	public Integer getCbCvki() {
		return cbCvki;
	}
	public void setCbCvki(Integer cbCvki) {
		this.cbCvki = cbCvki;
	}
	public String getCbAnnivDate() {
		return cbAnnivDate;
	}
	public void setCbAnnivDate(String cbAnnivDate) {
		this.cbAnnivDate = cbAnnivDate;
	}
	public String getPrGroupDesc() {
		return prGroupDesc;
	}
	public void setPrGroupDesc(String prGroupDesc) {
		this.prGroupDesc = prGroupDesc;
	}
	public String getCbModUser() {
		return cbModUser;
	}
	public void setCbModUser(String cbModUser) {
		this.cbModUser = cbModUser;
	}
	public String getCbPlasticCd() {
		return cbPlasticCd;
	}
	public void setCbPlasticCd(String cbPlasticCd) {
		this.cbPlasticCd = cbPlasticCd;
	}
	
}