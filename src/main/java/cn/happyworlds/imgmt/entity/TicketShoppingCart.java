package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class TicketShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  购物车ID
	 */
	private Integer shoppingId;
	/**
	 *  手机号
	 */
	private String mobile;
	/**
	 *  预存金额
	 */
	private String amount;
	/**
	 *  票卷种类
	 */
	private String ticketType;
	/**
	 *  购买数量
	 */
	private Integer varTkPaperNo;
	/**
	 *  特殊证件类型
	 */
	private String specialCertificate;
	/**
	 *  特殊证件号
	 */
	private String specialCertificateNumber;
	/**
	 *  票劵形式
	 */
	private String ticketform;
	/**
	 *  会员等级
	 */
	private String varoldPrdgrp;
	/**
	 *  卡面流水号
	 */
	private String cbRwdsAccno;
	/**
	 *  持卡人号码
	 */
	private String cbCardholderNo;
	/**
	 *  证件类型
	 */
	private String cbIdType;
	/**
	 *  证件号码
	 */
	private String idNo;
	/**
	 *  姓名
	 */
	private String uname;
	/**
	 *  出生日期
	 */
	private String birthday;
	/**
	 *  身份证地址
	 */
	private String address;
	/**
	 *  票劵金额
	 */
	private String vartkAmount;
	/**
	 *  总金额
	 */
	private String totalAmountPaid;
	/**
	 *  创建用户信息
	 */
	private String userCreate;
	/**
	 * 购物车ID
	 * @param shoppingId
	 */
	public void setShoppingId(Integer shoppingId){
		this.shoppingId = shoppingId;
	}
	
    /**
     * 购物车ID
     * @return
     */	
    public Integer getShoppingId(){
    	return shoppingId;
    }
	/**
	 * 手机号
	 * @param mobile
	 */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
    /**
     * 手机号
     * @return
     */	
    public String getMobile(){
    	return mobile;
    }
	/**
	 * 预存金额
	 * @param amount
	 */
	public void setAmount(String amount){
		this.amount = amount;
	}
	
    /**
     * 预存金额
     * @return
     */	
    public String getAmount(){
    	return amount;
    }
	/**
	 * 票卷种类
	 * @param ticketType
	 */
	public void setTicketType(String ticketType){
		this.ticketType = ticketType;
	}
	
    /**
     * 票卷种类
     * @return
     */	
    public String getTicketType(){
    	return ticketType;
    }
	/**
	 * 购买数量
	 * @param varTkPaperNo
	 */
	public void setVarTkPaperNo(Integer varTkPaperNo){
		this.varTkPaperNo = varTkPaperNo;
	}
	
    /**
     * 购买数量
     * @return
     */	
    public Integer getVarTkPaperNo(){
    	return varTkPaperNo;
    }
	/**
	 * 特殊证件类型
	 * @param specialCertificate
	 */
	public void setSpecialCertificate(String specialCertificate){
		this.specialCertificate = specialCertificate;
	}
	
    /**
     * 特殊证件类型
     * @return
     */	
    public String getSpecialCertificate(){
    	return specialCertificate;
    }
	/**
	 * 特殊证件号
	 * @param specialCertificateNumber
	 */
	public void setSpecialCertificateNumber(String specialCertificateNumber){
		this.specialCertificateNumber = specialCertificateNumber;
	}
	
    /**
     * 特殊证件号
     * @return
     */	
    public String getSpecialCertificateNumber(){
    	return specialCertificateNumber;
    }
	/**
	 * 票劵形式
	 * @param ticketform
	 */
	public void setTicketform(String ticketform){
		this.ticketform = ticketform;
	}
	
    /**
     * 票劵形式
     * @return
     */	
    public String getTicketform(){
    	return ticketform;
    }
	/**
	 * 会员等级
	 * @param varoldPrdgrp
	 */
	public void setVaroldPrdgrp(String varoldPrdgrp){
		this.varoldPrdgrp = varoldPrdgrp;
	}
	
    /**
     * 会员等级
     * @return
     */	
    public String getVaroldPrdgrp(){
    	return varoldPrdgrp;
    }
	/**
	 * 卡面流水号
	 * @param cbRwdsAccno
	 */
	public void setCbRwdsAccno(String cbRwdsAccno){
		this.cbRwdsAccno = cbRwdsAccno;
	}
	
    /**
     * 卡面流水号
     * @return
     */	
    public String getCbRwdsAccno(){
    	return cbRwdsAccno;
    }
	/**
	 * 持卡人号码
	 * @param cbCardholderNo
	 */
	public void setCbCardholderNo(String cbCardholderNo){
		this.cbCardholderNo = cbCardholderNo;
	}
	
    /**
     * 持卡人号码
     * @return
     */	
    public String getCbCardholderNo(){
    	return cbCardholderNo;
    }
	/**
	 * 证件类型
	 * @param cbIdType
	 */
	public void setCbIdType(String cbIdType){
		this.cbIdType = cbIdType;
	}
	
    /**
     * 证件类型
     * @return
     */	
    public String getCbIdType(){
    	return cbIdType;
    }
	/**
	 * 证件号码
	 * @param idNo
	 */
	public void setIdNo(String idNo){
		this.idNo = idNo;
	}
	
    /**
     * 证件号码
     * @return
     */	
    public String getIdNo(){
    	return idNo;
    }
	/**
	 * 姓名
	 * @param uname
	 */
	public void setUname(String uname){
		this.uname = uname;
	}
	
    /**
     * 姓名
     * @return
     */	
    public String getUname(){
    	return uname;
    }
	/**
	 * 出生日期
	 * @param birthday
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	
    /**
     * 出生日期
     * @return
     */	
    public String getBirthday(){
    	return birthday;
    }
	/**
	 * 身份证地址
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}
	
    /**
     * 身份证地址
     * @return
     */	
    public String getAddress(){
    	return address;
    }
	/**
	 * 票劵金额
	 * @param vartkAmount
	 */
	public void setVartkAmount(String vartkAmount){
		this.vartkAmount = vartkAmount;
	}
	
    /**
     * 票劵金额
     * @return
     */	
    public String getVartkAmount(){
    	return vartkAmount;
    }
	/**
	 * 总金额
	 * @param totalAmountPaid
	 */
	public void setTotalAmountPaid(String totalAmountPaid){
		this.totalAmountPaid = totalAmountPaid;
	}
	
    /**
     * 总金额
     * @return
     */	
    public String getTotalAmountPaid(){
    	return totalAmountPaid;
    }
	/**
	 * 创建用户信息
	 * @param userCreate
	 */
	public void setUserCreate(String userCreate){
		this.userCreate = userCreate;
	}
	
    /**
     * 创建用户信息
     * @return
     */	
    public String getUserCreate(){
    	return userCreate;
    }
}