package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class CpCommodity implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  商品类别ID
	 */
	private Integer ccTypeId;
	/**
	 *  商品类别名称
	 */
	private String ccTypeDesc;
	/**
	 *  允许售票起始时间
	 */
	private String ccStartDate;
	/**
	 *  允许售票结束时间
	 */
	private String ccEndDate;
	/**
	 *  开园时间
	 */
	private String ccStartTime;
	/**
	 *  闭园时间
	 */
	private String ccEndTime;
	/**
	 *  商品有效周期，单位为天
	 */
	private Integer ccExpirePeriod;
	/**
	 *  用户类型，0，全部有效；1，儿童长者
	 */
	private String ccUserType;
	/**
	 *  是否可重复使用
	 */
	private String ccRecycleType;
	/**
	 *  商品状态
	 */
	private String ccTypeStatus;
	/**
	 *  使用者
	 */
	private String ccTypeUser;
	/**
	 *  可以使用的商户地址，增值项目也在该清单
	 */
	private Integer ccAcqListsId;
	/**
	 *  常规价格
	 */
	private java.math.BigDecimal ccListPrice;
	/**
	 *  普通折扣率
	 */
	private java.math.BigDecimal ccDiscountRate1;
	/**
	 *  普通折扣价，如同时设置了折扣率，以此为准
	 */
	private java.math.BigDecimal ccDiscountPrice1;
	/**
	 *  特别折扣率
	 */
	private java.math.BigDecimal ccDiscountRate2;
	/**
	 *  特别折扣价，如同时设置了折扣率，以此为准
	 */
	private java.math.BigDecimal ccDiscountPrice2;
	/**
	 *  商品描述
	 */
	private String ccTicketDes;
	/**
	 *  商品类型
	 */
	private String ccTicketType;
	/**
	 *  商品图片
	 */
	private String ccTicketPic;
	/**
	 *  商品详情小图
	 */
	private String ccTicketPic2;
	/**
	 *  商品详情大图
	 */
	private String ccTicketPic3;
	/**
	 *  景点
	 */
	private String ccTicketPic4;
	/**
	 *  
	 */
	private String checksum;
	/**
	 * 商品类别ID
	 * @param ccTypeId
	 */
	public void setCcTypeId(Integer ccTypeId){
		this.ccTypeId = ccTypeId;
	}
	
    /**
     * 商品类别ID
     * @return
     */	
    public Integer getCcTypeId(){
    	return ccTypeId;
    }
	/**
	 * 商品类别名称
	 * @param ccTypeDesc
	 */
	public void setCcTypeDesc(String ccTypeDesc){
		this.ccTypeDesc = ccTypeDesc;
	}
	
    /**
     * 商品类别名称
     * @return
     */	
    public String getCcTypeDesc(){
    	return ccTypeDesc;
    }
	/**
	 * 允许售票起始时间
	 * @param ccStartDate
	 */
	public void setCcStartDate(String ccStartDate){
		this.ccStartDate = ccStartDate;
	}
	
    /**
     * 允许售票起始时间
     * @return
     */	
    public String getCcStartDate(){
    	return ccStartDate;
    }
	/**
	 * 允许售票结束时间
	 * @param ccEndDate
	 */
	public void setCcEndDate(String ccEndDate){
		this.ccEndDate = ccEndDate;
	}
	
    /**
     * 允许售票结束时间
     * @return
     */	
    public String getCcEndDate(){
    	return ccEndDate;
    }
	/**
	 * 开园时间
	 * @param ccStartTime
	 */
	public void setCcStartTime(String ccStartTime){
		this.ccStartTime = ccStartTime;
	}
	
    /**
     * 开园时间
     * @return
     */	
    public String getCcStartTime(){
    	return ccStartTime;
    }
	/**
	 * 闭园时间
	 * @param ccEndTime
	 */
	public void setCcEndTime(String ccEndTime){
		this.ccEndTime = ccEndTime;
	}
	
    /**
     * 闭园时间
     * @return
     */	
    public String getCcEndTime(){
    	return ccEndTime;
    }
	/**
	 * 商品有效周期，单位为天
	 * @param ccExpirePeriod
	 */
	public void setCcExpirePeriod(Integer ccExpirePeriod){
		this.ccExpirePeriod = ccExpirePeriod;
	}
	
    /**
     * 商品有效周期，单位为天
     * @return
     */	
    public Integer getCcExpirePeriod(){
    	return ccExpirePeriod;
    }
	/**
	 * 用户类型，0，全部有效；1，儿童长者
	 * @param ccUserType
	 */
	public void setCcUserType(String ccUserType){
		this.ccUserType = ccUserType;
	}
	
    /**
     * 用户类型，0，全部有效；1，儿童长者
     * @return
     */	
    public String getCcUserType(){
    	return ccUserType;
    }
	/**
	 * 是否可重复使用
	 * @param ccRecycleType
	 */
	public void setCcRecycleType(String ccRecycleType){
		this.ccRecycleType = ccRecycleType;
	}
	
    /**
     * 是否可重复使用
     * @return
     */	
    public String getCcRecycleType(){
    	return ccRecycleType;
    }
	/**
	 * 商品状态
	 * @param ccTypeStatus
	 */
	public void setCcTypeStatus(String ccTypeStatus){
		this.ccTypeStatus = ccTypeStatus;
	}
	
    /**
     * 商品状态
     * @return
     */	
    public String getCcTypeStatus(){
    	return ccTypeStatus;
    }
	/**
	 * 使用者
	 * @param ccTypeUser
	 */
	public void setCcTypeUser(String ccTypeUser){
		this.ccTypeUser = ccTypeUser;
	}
	
    /**
     * 使用者
     * @return
     */	
    public String getCcTypeUser(){
    	return ccTypeUser;
    }
	/**
	 * 可以使用的商户地址，增值项目也在该清单
	 * @param ccAcqListsId
	 */
	public void setCcAcqListsId(Integer ccAcqListsId){
		this.ccAcqListsId = ccAcqListsId;
	}
	
    /**
     * 可以使用的商户地址，增值项目也在该清单
     * @return
     */	
    public Integer getCcAcqListsId(){
    	return ccAcqListsId;
    }
	/**
	 * 常规价格
	 * @param ccListPrice
	 */
	public void setCcListPrice(java.math.BigDecimal ccListPrice){
		this.ccListPrice = ccListPrice;
	}
	
    /**
     * 常规价格
     * @return
     */	
    public java.math.BigDecimal getCcListPrice(){
    	return ccListPrice;
    }
	/**
	 * 普通折扣率
	 * @param ccDiscountRate1
	 */
	public void setCcDiscountRate1(java.math.BigDecimal ccDiscountRate1){
		this.ccDiscountRate1 = ccDiscountRate1;
	}
	
    /**
     * 普通折扣率
     * @return
     */	
    public java.math.BigDecimal getCcDiscountRate1(){
    	return ccDiscountRate1;
    }
	/**
	 * 普通折扣价，如同时设置了折扣率，以此为准
	 * @param ccDiscountPrice1
	 */
	public void setCcDiscountPrice1(java.math.BigDecimal ccDiscountPrice1){
		this.ccDiscountPrice1 = ccDiscountPrice1;
	}
	
    /**
     * 普通折扣价，如同时设置了折扣率，以此为准
     * @return
     */	
    public java.math.BigDecimal getCcDiscountPrice1(){
    	return ccDiscountPrice1;
    }
	/**
	 * 特别折扣率
	 * @param ccDiscountRate2
	 */
	public void setCcDiscountRate2(java.math.BigDecimal ccDiscountRate2){
		this.ccDiscountRate2 = ccDiscountRate2;
	}
	
    /**
     * 特别折扣率
     * @return
     */	
    public java.math.BigDecimal getCcDiscountRate2(){
    	return ccDiscountRate2;
    }
	/**
	 * 特别折扣价，如同时设置了折扣率，以此为准
	 * @param ccDiscountPrice2
	 */
	public void setCcDiscountPrice2(java.math.BigDecimal ccDiscountPrice2){
		this.ccDiscountPrice2 = ccDiscountPrice2;
	}
	
    /**
     * 特别折扣价，如同时设置了折扣率，以此为准
     * @return
     */	
    public java.math.BigDecimal getCcDiscountPrice2(){
    	return ccDiscountPrice2;
    }
	/**
	 * 商品描述
	 * @param ccTicketDes
	 */
	public void setCcTicketDes(String ccTicketDes){
		this.ccTicketDes = ccTicketDes;
	}
	
    /**
     * 商品描述
     * @return
     */	
    public String getCcTicketDes(){
    	return ccTicketDes;
    }
	/**
	 * 商品类型
	 * @param ccTicketType
	 */
	public void setCcTicketType(String ccTicketType){
		this.ccTicketType = ccTicketType;
	}
	
    /**
     * 商品类型
     * @return
     */	
    public String getCcTicketType(){
    	return ccTicketType;
    }
	/**
	 * 商品图片
	 * @param ccTicketPic
	 */
	public void setCcTicketPic(String ccTicketPic){
		this.ccTicketPic = ccTicketPic;
	}
	
    /**
     * 商品图片
     * @return
     */	
    public String getCcTicketPic(){
    	return ccTicketPic;
    }
	/**
	 * 商品详情小图
	 * @param ccTicketPic2
	 */
	public void setCcTicketPic2(String ccTicketPic2){
		this.ccTicketPic2 = ccTicketPic2;
	}
	
    /**
     * 商品详情小图
     * @return
     */	
    public String getCcTicketPic2(){
    	return ccTicketPic2;
    }
	/**
	 * 商品详情大图
	 * @param ccTicketPic3
	 */
	public void setCcTicketPic3(String ccTicketPic3){
		this.ccTicketPic3 = ccTicketPic3;
	}
	
    /**
     * 商品详情大图
     * @return
     */	
    public String getCcTicketPic3(){
    	return ccTicketPic3;
    }
	/**
	 * 景点
	 * @param 
	 */
	public void setCcTicketPic4(String ccTicketPic4){
		this.ccTicketPic4 = ccTicketPic4;
	}
	
    /**
     * 景点
     * @return
     */	
    public String getCcTicketPic4(){
    	return ccTicketPic4;
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