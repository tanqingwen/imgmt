package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

public class CpActpcd implements Serializable{

	/**
	 * zhouPeng
	 */
	private static final long serialVersionUID = 1L;

	private String sysAcctTypeCode;
	
	private String sysAcctTypeDesc;
	
	private String checksum;

	public CpActpcd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CpActpcd(String sysAcctTypeCode, String sysAcctTypeDesc, String checksum) {
		super();
		this.sysAcctTypeCode = sysAcctTypeCode;
		this.sysAcctTypeDesc = sysAcctTypeDesc;
		this.checksum = checksum;
	}

	public String getSysAcctTypeCode() {
		return sysAcctTypeCode;
	}

	public void setSysAcctTypeCode(String sysAcctTypeCode) {
		this.sysAcctTypeCode = sysAcctTypeCode;
	}

	public String getSysAcctTypeDesc() {
		return sysAcctTypeDesc;
	}

	public void setSysAcctTypeDesc(String sysAcctTypeDesc) {
		this.sysAcctTypeDesc = sysAcctTypeDesc;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CpActpcd [sysAcctTypeCode=" + sysAcctTypeCode + ", sysAcctTypeDesc=" + sysAcctTypeDesc + ", checksum="
				+ checksum + "]";
	}
	
	
	
}
