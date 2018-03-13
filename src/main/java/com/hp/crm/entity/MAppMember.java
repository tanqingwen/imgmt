package com.hp.crm.entity;
/**
 * 
 * @author Hugh
 *
 */
public class MAppMember {
	/**
	 * 会员ID
	 */
	private String memberId;
	/**
	 * 会员姓名
	 */
	private String memberName;
	/**
	 * 会员身份证 
	 */
	private String memberCard;
	/**
	 * 会员所订票券号
	 */
	private String memberTicketId;
	/**
	 * 状况
	 */
	private String memberStatus;
	/**
	 * 类型(一般游客、年票游客、储值卡游客等)
	 */
	private String memberType;
	/**
	 * 时间
	 */
	private String memberTime;
	/**
	 * 有效期
	 */
	private String memberValidity;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberCard() {
		return memberCard;
	}
	public void setMemberCard(String memberCard) {
		this.memberCard = memberCard;
	}
	public String getMemberTicketId() {
		return memberTicketId;
	}
	public void setMemberTicketId(String memberTicketId) {
		this.memberTicketId = memberTicketId;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getMemberTime() {
		return memberTime;
	}
	public void setMemberTime(String memberTime) {
		this.memberTime = memberTime;
	}
	public String getMemberValidity() {
		return memberValidity;
	}
	public void setMemberValidity(String memberValidity) {
		this.memberValidity = memberValidity;
	}
	
	
}
