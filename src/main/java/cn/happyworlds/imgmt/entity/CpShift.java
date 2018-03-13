package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author 
 */
public class CpShift implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  交班表id
	 */
	private Integer cpShiftId;
	/**
	 *  打印时间
	 */
	private String cpShiftDate;
	/**
	 *  交班员工工号
	 */
	private String cpShiftUserno;
	/**
	 *  交班员工姓名
	 */
	private String cpShiftUser;
	/**
	 *  pos机号
	 */
	private String cpShiftPosno;
	/**
	 *  营业毛额
	 */
	private String cpShiftYyme;
	/**
	 *  折扣
	 */
	private String cpShiftZhekou;
	/**
	 *  交易笔数
	 */
	private String cpShiftJybs;
	/**
	 *  退票笔数
	 */
	private String cpShiftTpbs;
	/**
	 *  退票总额
	 */
	private String cpShiftTpze;
	/**
	 *  微信金额
	 */
	private String cpShiftWxje;
	/**
	 *  支付宝金额
	 */
	private String cpShiftZfbje;
	/**
	 *  现金
	 */
	private String cpShiftXj;
	/**
	 *  公关卡
	 */
	private String cpShiftGgkje;
	/**
	 *  信用卡
	 */
	private String cpShiftXykje;
	/**
	 *  充值卡
	 */
	private String cpShiftCzkje;
	/**
	 *  支付小计
	 */
	private String cpShiftZfxj;
	/**
	 *  微信充值金额
	 */
	private String cpShiftWxcz;
	/**
	 *  信用卡充值金额
	 */
	private String cpShiftXykcz;
	/**
	 *  支付宝充值金额
	 */
	private String cpShiftZfbcz;
	/**
	 *  现金充值金额
	 */
	private String cpShiftXjcz;
	/**
	 *  充值次数
	 */
	private String cpShiftCzcs;
	/**
	 *  充值总额
	 */
	private String cpShiftCzze;
	/**
	 *  柜台明细现金收入
	 */
	private String cpShiftXjsr;
	/**
	 *  柜台现金明细-充值现金金额
	 */
	private String cpShiftCzxj;
	/**
	 *  柜台现金明细-交班现金
	 */
	private String cpShiftJbxj;
	/**
	 *  当班收银
	 */
	private String cpShiftDbsy;
	/**
	 *  下班收银
	 */
	private String cpShiftXbsy;
	/**
	 *  值班主管
	 */
	private String cpShiftZbzg;
	/**
	 * 交班为1，结班为2'
	 */
	private String cpShiftType;
	/**
	 * 备用1
	 */
	private String cpBeiyongOne;
	/**
	 * 2
	 */
	private String cpBeiyongTwo;
	/**
	 * 场馆号
	 */
	private String cpMerchantNo;
	public Integer getCpShiftId() {
		return cpShiftId;
	}
	public void setCpShiftId(Integer cpShiftId) {
		this.cpShiftId = cpShiftId;
	}
	public String getCpShiftDate() {
		return cpShiftDate;
	}
	public void setCpShiftDate(String cpShiftDate) {
		this.cpShiftDate = cpShiftDate;
	}
	public String getCpShiftUserno() {
		return cpShiftUserno;
	}
	public void setCpShiftUserno(String cpShiftUserno) {
		this.cpShiftUserno = cpShiftUserno;
	}
	public String getCpShiftUser() {
		return cpShiftUser;
	}
	public void setCpShiftUser(String cpShiftUser) {
		this.cpShiftUser = cpShiftUser;
	}
	public String getCpShiftPosno() {
		return cpShiftPosno;
	}
	public void setCpShiftPosno(String cpShiftPosno) {
		this.cpShiftPosno = cpShiftPosno;
	}
	public String getCpShiftYyme() {
		return cpShiftYyme;
	}
	public void setCpShiftYyme(String cpShiftYyme) {
		this.cpShiftYyme = cpShiftYyme;
	}
	public String getCpShiftZhekou() {
		return cpShiftZhekou;
	}
	public void setCpShiftZhekou(String cpShiftZhekou) {
		this.cpShiftZhekou = cpShiftZhekou;
	}
	public String getCpShiftJybs() {
		return cpShiftJybs;
	}
	public void setCpShiftJybs(String cpShiftJybs) {
		this.cpShiftJybs = cpShiftJybs;
	}
	public String getCpShiftTpbs() {
		return cpShiftTpbs;
	}
	public void setCpShiftTpbs(String cpShiftTpbs) {
		this.cpShiftTpbs = cpShiftTpbs;
	}
	public String getCpShiftTpze() {
		return cpShiftTpze;
	}
	public void setCpShiftTpze(String cpShiftTpze) {
		this.cpShiftTpze = cpShiftTpze;
	}
	public String getCpShiftWxje() {
		return cpShiftWxje;
	}
	public void setCpShiftWxje(String cpShiftWxje) {
		this.cpShiftWxje = cpShiftWxje;
	}
	public String getCpShiftZfbje() {
		return cpShiftZfbje;
	}
	public void setCpShiftZfbje(String cpShiftZfbje) {
		this.cpShiftZfbje = cpShiftZfbje;
	}
	public String getCpShiftXj() {
		return cpShiftXj;
	}
	public void setCpShiftXj(String cpShiftXj) {
		this.cpShiftXj = cpShiftXj;
	}
	public String getCpShiftGgkje() {
		return cpShiftGgkje;
	}
	public void setCpShiftGgkje(String cpShiftGgkje) {
		this.cpShiftGgkje = cpShiftGgkje;
	}
	public String getCpShiftXykje() {
		return cpShiftXykje;
	}
	public void setCpShiftXykje(String cpShiftXykje) {
		this.cpShiftXykje = cpShiftXykje;
	}
	public String getCpShiftCzkje() {
		return cpShiftCzkje;
	}
	public void setCpShiftCzkje(String cpShiftCzkje) {
		this.cpShiftCzkje = cpShiftCzkje;
	}
	public String getCpShiftZfxj() {
		return cpShiftZfxj;
	}
	public void setCpShiftZfxj(String cpShiftZfxj) {
		this.cpShiftZfxj = cpShiftZfxj;
	}
	public String getCpShiftWxcz() {
		return cpShiftWxcz;
	}
	public void setCpShiftWxcz(String cpShiftWxcz) {
		this.cpShiftWxcz = cpShiftWxcz;
	}
	public String getCpShiftXykcz() {
		return cpShiftXykcz;
	}
	public void setCpShiftXykcz(String cpShiftXykcz) {
		this.cpShiftXykcz = cpShiftXykcz;
	}
	public String getCpShiftZfbcz() {
		return cpShiftZfbcz;
	}
	public void setCpShiftZfbcz(String cpShiftZfbcz) {
		this.cpShiftZfbcz = cpShiftZfbcz;
	}
	public String getCpShiftXjcz() {
		return cpShiftXjcz;
	}
	public void setCpShiftXjcz(String cpShiftXjcz) {
		this.cpShiftXjcz = cpShiftXjcz;
	}
	public String getCpShiftCzcs() {
		return cpShiftCzcs;
	}
	public void setCpShiftCzcs(String cpShiftCzcs) {
		this.cpShiftCzcs = cpShiftCzcs;
	}
	public String getCpShiftCzze() {
		return cpShiftCzze;
	}
	public void setCpShiftCzze(String cpShiftCzze) {
		this.cpShiftCzze = cpShiftCzze;
	}
	public String getCpShiftXjsr() {
		return cpShiftXjsr;
	}
	public void setCpShiftXjsr(String cpShiftXjsr) {
		this.cpShiftXjsr = cpShiftXjsr;
	}
	public String getCpShiftCzxj() {
		return cpShiftCzxj;
	}
	public void setCpShiftCzxj(String cpShiftCzxj) {
		this.cpShiftCzxj = cpShiftCzxj;
	}
	public String getCpShiftJbxj() {
		return cpShiftJbxj;
	}
	public void setCpShiftJbxj(String cpShiftJbxj) {
		this.cpShiftJbxj = cpShiftJbxj;
	}
	public String getCpShiftDbsy() {
		return cpShiftDbsy;
	}
	public void setCpShiftDbsy(String cpShiftDbsy) {
		this.cpShiftDbsy = cpShiftDbsy;
	}
	public String getCpShiftXbsy() {
		return cpShiftXbsy;
	}
	public void setCpShiftXbsy(String cpShiftXbsy) {
		this.cpShiftXbsy = cpShiftXbsy;
	}
	public String getCpShiftZbzg() {
		return cpShiftZbzg;
	}
	public void setCpShiftZbzg(String cpShiftZbzg) {
		this.cpShiftZbzg = cpShiftZbzg;
	}
	public String getCpShiftType() {
		return cpShiftType;
	}
	public void setCpShiftType(String cpShiftType) {
		this.cpShiftType = cpShiftType;
	}
	public String getCpBeiyongOne() {
		return cpBeiyongOne;
	}
	public void setCpBeiyongOne(String cpBeiyongOne) {
		this.cpBeiyongOne = cpBeiyongOne;
	}
	public String getCpBeiyongTwo() {
		return cpBeiyongTwo;
	}
	public void setCpBeiyongTwo(String cpBeiyongTwo) {
		this.cpBeiyongTwo = cpBeiyongTwo;
	}
	public String getCpMerchantNo() {
		return cpMerchantNo;
	}
	public void setCpMerchantNo(String cpMerchantNo) {
		this.cpMerchantNo = cpMerchantNo;
	}
	public CpShift() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpShift(Integer cpShiftId, String cpShiftDate, String cpShiftUserno, String cpShiftUser, String cpShiftPosno,
			String cpShiftYyme, String cpShiftZhekou, String cpShiftJybs, String cpShiftTpbs, String cpShiftTpze,
			String cpShiftWxje, String cpShiftZfbje, String cpShiftXj, String cpShiftGgkje, String cpShiftXykje,
			String cpShiftCzkje, String cpShiftZfxj, String cpShiftWxcz, String cpShiftXykcz, String cpShiftZfbcz,
			String cpShiftXjcz, String cpShiftCzcs, String cpShiftCzze, String cpShiftXjsr, String cpShiftCzxj,
			String cpShiftJbxj, String cpShiftDbsy, String cpShiftXbsy, String cpShiftZbzg, String cpShiftType,
			String cpBeiyongOne, String cpBeiyongTwo, String cpMerchantNo) {
		super();
		this.cpShiftId = cpShiftId;
		this.cpShiftDate = cpShiftDate;
		this.cpShiftUserno = cpShiftUserno;
		this.cpShiftUser = cpShiftUser;
		this.cpShiftPosno = cpShiftPosno;
		this.cpShiftYyme = cpShiftYyme;
		this.cpShiftZhekou = cpShiftZhekou;
		this.cpShiftJybs = cpShiftJybs;
		this.cpShiftTpbs = cpShiftTpbs;
		this.cpShiftTpze = cpShiftTpze;
		this.cpShiftWxje = cpShiftWxje;
		this.cpShiftZfbje = cpShiftZfbje;
		this.cpShiftXj = cpShiftXj;
		this.cpShiftGgkje = cpShiftGgkje;
		this.cpShiftXykje = cpShiftXykje;
		this.cpShiftCzkje = cpShiftCzkje;
		this.cpShiftZfxj = cpShiftZfxj;
		this.cpShiftWxcz = cpShiftWxcz;
		this.cpShiftXykcz = cpShiftXykcz;
		this.cpShiftZfbcz = cpShiftZfbcz;
		this.cpShiftXjcz = cpShiftXjcz;
		this.cpShiftCzcs = cpShiftCzcs;
		this.cpShiftCzze = cpShiftCzze;
		this.cpShiftXjsr = cpShiftXjsr;
		this.cpShiftCzxj = cpShiftCzxj;
		this.cpShiftJbxj = cpShiftJbxj;
		this.cpShiftDbsy = cpShiftDbsy;
		this.cpShiftXbsy = cpShiftXbsy;
		this.cpShiftZbzg = cpShiftZbzg;
		this.cpShiftType = cpShiftType;
		this.cpBeiyongOne = cpBeiyongOne;
		this.cpBeiyongTwo = cpBeiyongTwo;
		this.cpMerchantNo = cpMerchantNo;
	}
	
	
}