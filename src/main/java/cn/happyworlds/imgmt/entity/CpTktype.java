package cn.happyworlds.imgmt.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Hugh
 */
public class CpTktype implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  票劵ID
	 */
	private Integer ttTypeId;
	/**
	 *  票劵名称
	 */
	private String ttTypeDesc;
	/**
	 *  允许售票起始时间
	 */
	private String ttStartDate;
	/**
	 *  允许售票结束时间
	 */
	private String ttEndDate;
	/**
	 *  开园时间
	 */
	private String ttStartTime;
	/**
	 *  闭园时间
	 */
	private String ttEndTime;
	/**
	 *  票券有效周期，单位为天
	 */
	private Integer ttExpirePeriod;
	/**
	 *  用户类型，0，全部有效；1，儿童长者
	 */
	private String ttUserType;
	/**
	 *  是否可重复使用
	 */
	private String ttRecycleType;
	/**
	 *  票劵状态
	 */
	private String ttTypeStatus;
	/**
	 *  使用者
	 */
	private String ttTypeUser;
	/**
	 *  可以使用的商户地址，增值项目也在该清单
	 */
	private Integer ttAcqListsId;
	/**
	 *  常规价格
	 */
	private java.math.BigDecimal ttListPrice;
	/**
	 *  普通折扣率
	 */
	private java.math.BigDecimal ttDiscountRate1;
	/**
	 *  普通折扣价，如同时设置了折扣率，以此为准
	 */
	private java.math.BigDecimal ttDiscountPrice1;
	/**
	 *  特别折扣率
	 */
	private java.math.BigDecimal ttDiscountRate2;
	/**
	 *  特别折扣价，如同时设置了折扣率，以此为准
	 */
	private java.math.BigDecimal ttDiscountPrice2;
	/**
	 *  票描述
	 */
	private String ttTicketDes;
	/**
	 *  票类型
	 */
	private String ttTicketType;
	/**
	 *  票图片
	 */
	private String ttTicketPic;
	/**
	 *  票详情小图
	 */
	private String ttTicketPic2;
	/**
	 *  票详情大图
	 */
	private String ttTicketPic3;
	/**
	 *  景点
	 */
	private String ttViewId;
	/**
	 *  
	 */
	private String checksum;
	/**
	 *  生效日期
	 */ 
	private String valid_date;
	/**
	 *  失效日期
	 */ 	
	private String lose_date;
	
	/**
	 * 开始时间
	 */
	private String couponDate;
	/**
	 * 结束天数
	 * 
	 */
	private int couponDays;
	public Integer getTtTypeId() {
		return ttTypeId;
	}
	public void setTtTypeId(Integer ttTypeId) {
		this.ttTypeId = ttTypeId;
	}
	public CpTktype() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpTktype(Integer ttTypeId, String ttTypeDesc, String ttStartDate, String ttEndDate, String ttStartTime,
			String ttEndTime, Integer ttExpirePeriod, String ttUserType, String ttRecycleType, String ttTypeStatus,
			String ttTypeUser, Integer ttAcqListsId, BigDecimal ttListPrice, BigDecimal ttDiscountRate1,
			BigDecimal ttDiscountPrice1, BigDecimal ttDiscountRate2, BigDecimal ttDiscountPrice2, String ttTicketDes,
			String ttTicketType, String ttTicketPic, String ttTicketPic2, String ttTicketPic3, String ttViewId,
			String checksum, String valid_date, String lose_date, String couponDate, int couponDays) {
		super();
		this.ttTypeId = ttTypeId;
		this.ttTypeDesc = ttTypeDesc;
		this.ttStartDate = ttStartDate;
		this.ttEndDate = ttEndDate;
		this.ttStartTime = ttStartTime;
		this.ttEndTime = ttEndTime;
		this.ttExpirePeriod = ttExpirePeriod;
		this.ttUserType = ttUserType;
		this.ttRecycleType = ttRecycleType;
		this.ttTypeStatus = ttTypeStatus;
		this.ttTypeUser = ttTypeUser;
		this.ttAcqListsId = ttAcqListsId;
		this.ttListPrice = ttListPrice;
		this.ttDiscountRate1 = ttDiscountRate1;
		this.ttDiscountPrice1 = ttDiscountPrice1;
		this.ttDiscountRate2 = ttDiscountRate2;
		this.ttDiscountPrice2 = ttDiscountPrice2;
		this.ttTicketDes = ttTicketDes;
		this.ttTicketType = ttTicketType;
		this.ttTicketPic = ttTicketPic;
		this.ttTicketPic2 = ttTicketPic2;
		this.ttTicketPic3 = ttTicketPic3;
		this.ttViewId = ttViewId;
		this.checksum = checksum;
		this.valid_date = valid_date;
		this.lose_date = lose_date;
		this.couponDate = couponDate;
		this.couponDays = couponDays;
	}
	public String getTtTypeDesc() {
		return ttTypeDesc;
	}
	public void setTtTypeDesc(String ttTypeDesc) {
		this.ttTypeDesc = ttTypeDesc;
	}
	public String getTtStartDate() {
		return ttStartDate;
	}
	public void setTtStartDate(String ttStartDate) {
		this.ttStartDate = ttStartDate;
	}
	public String getTtEndDate() {
		return ttEndDate;
	}
	public void setTtEndDate(String ttEndDate) {
		this.ttEndDate = ttEndDate;
	}
	public String getTtStartTime() {
		return ttStartTime;
	}
	public void setTtStartTime(String ttStartTime) {
		this.ttStartTime = ttStartTime;
	}
	public String getTtEndTime() {
		return ttEndTime;
	}
	public void setTtEndTime(String ttEndTime) {
		this.ttEndTime = ttEndTime;
	}
	public Integer getTtExpirePeriod() {
		return ttExpirePeriod;
	}
	public void setTtExpirePeriod(Integer ttExpirePeriod) {
		this.ttExpirePeriod = ttExpirePeriod;
	}
	public String getTtUserType() {
		return ttUserType;
	}
	public void setTtUserType(String ttUserType) {
		this.ttUserType = ttUserType;
	}
	public String getTtRecycleType() {
		return ttRecycleType;
	}
	public void setTtRecycleType(String ttRecycleType) {
		this.ttRecycleType = ttRecycleType;
	}
	public String getTtTypeStatus() {
		return ttTypeStatus;
	}
	public void setTtTypeStatus(String ttTypeStatus) {
		this.ttTypeStatus = ttTypeStatus;
	}
	public String getTtTypeUser() {
		return ttTypeUser;
	}
	public void setTtTypeUser(String ttTypeUser) {
		this.ttTypeUser = ttTypeUser;
	}
	public Integer getTtAcqListsId() {
		return ttAcqListsId;
	}
	public void setTtAcqListsId(Integer ttAcqListsId) {
		this.ttAcqListsId = ttAcqListsId;
	}
	public java.math.BigDecimal getTtListPrice() {
		return ttListPrice;
	}
	public void setTtListPrice(java.math.BigDecimal ttListPrice) {
		this.ttListPrice = ttListPrice;
	}
	public java.math.BigDecimal getTtDiscountRate1() {
		return ttDiscountRate1;
	}
	public void setTtDiscountRate1(java.math.BigDecimal ttDiscountRate1) {
		this.ttDiscountRate1 = ttDiscountRate1;
	}
	public java.math.BigDecimal getTtDiscountPrice1() {
		return ttDiscountPrice1;
	}
	public void setTtDiscountPrice1(java.math.BigDecimal ttDiscountPrice1) {
		this.ttDiscountPrice1 = ttDiscountPrice1;
	}
	public java.math.BigDecimal getTtDiscountRate2() {
		return ttDiscountRate2;
	}
	public void setTtDiscountRate2(java.math.BigDecimal ttDiscountRate2) {
		this.ttDiscountRate2 = ttDiscountRate2;
	}
	public java.math.BigDecimal getTtDiscountPrice2() {
		return ttDiscountPrice2;
	}
	public void setTtDiscountPrice2(java.math.BigDecimal ttDiscountPrice2) {
		this.ttDiscountPrice2 = ttDiscountPrice2;
	}
	public String getTtTicketDes() {
		return ttTicketDes;
	}
	public void setTtTicketDes(String ttTicketDes) {
		this.ttTicketDes = ttTicketDes;
	}
	public String getTtTicketType() {
		return ttTicketType;
	}
	public void setTtTicketType(String ttTicketType) {
		this.ttTicketType = ttTicketType;
	}
	public String getTtTicketPic() {
		return ttTicketPic;
	}
	public void setTtTicketPic(String ttTicketPic) {
		this.ttTicketPic = ttTicketPic;
	}
	public String getTtTicketPic2() {
		return ttTicketPic2;
	}
	public void setTtTicketPic2(String ttTicketPic2) {
		this.ttTicketPic2 = ttTicketPic2;
	}
	public String getTtTicketPic3() {
		return ttTicketPic3;
	}
	public void setTtTicketPic3(String ttTicketPic3) {
		this.ttTicketPic3 = ttTicketPic3;
	}
	public String getTtViewId() {
		return ttViewId;
	}
	public void setTtViewId(String ttViewId) {
		this.ttViewId = ttViewId;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getValid_date() {
		return valid_date;
	}
	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}
	public String getLose_date() {
		return lose_date;
	}
	public void setLose_date(String lose_date) {
		this.lose_date = lose_date;
	}
	public String getCouponDate() {
		return couponDate;
	}
	public void setCouponDate(String couponDate) {
		this.couponDate = couponDate;
	}
	public int getCouponDays() {
		return couponDays;
	}
	public void setCouponDays(int couponDays) {
		this.couponDays = couponDays;
	}


	
	
}