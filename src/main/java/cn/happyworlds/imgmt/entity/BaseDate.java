package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author tqw
 */
public class BaseDate  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 业务类型
	 */
	private String business_id;
	/**
	 * 金额（12位，分为单位，不足左补0）
	 */
	private String amount;
	/**
	 * 原始流水号（6位，不足左补0）
	 */
	private String orig_trace_no;
	/**
	 * 授权码（6位，不足左补0）
	 */
	private String orig_auth_no;
	/**
	 * 原系统参考号（12位，不足左补0）
	 */
	private String orig_ref_no;
	/**
	 * 原交易日期（4位，MMDD）
	 */
	private String orig_date;
	/**
	 * 卡号
	 */
	private String cardno;
	/**
	 * 卡片有效期
	 */
	private String exp_date;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 交易唯一标识（30位）
	 * 备注：1. TransCheck参考格式为YYYYMMDD + hhmmss + 收银小票号（保证每笔交易的TransCheck唯一值即可，最好不要超过20位）
	 */
	private String trans_check;
	/**
	 * 操作员号
	 */
	private String oper_no;
	/**
	 * 流水号
	 */
	private String trace_no;
	/**
	 * 批次号
	 */
	private String batch_no;
	
	/**
	 * 商户号
	 */
	private String merch_id;
	/**
	 * 商户名
	 */
	private String merch_name;
	/**
	 * 终端号
	 */
	private String ter_id;
	/**
	 * 系统参考号
	 */
	private String ref_no;
	/**
	 * 卡组织或钱包机构
	 */
	private String cups;
	/**
	 * 授权码
	 */
	private String auth_no;
	/**
	 * 返回码
	 */
	private String rejcode;
	/**
	 * 发卡行号
	 */
	private String iss_no;
	/**
	 * 发卡行名称
	 */
	private String iss_name;
	/**
	 * 交易日期
	 */
	private String date;
	/**
	 * 交易时间
	 */
	private String time;
	/**
	 * 返回码解释
	 */
	private String rejcode_cn;
	
	
	
	/**
	 * 业务类型
	 */
	public String getBusiness_id() {
		return business_id;
	}
	/**
	 * 业务类型
	 */
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	/**
	 * 金额（12位，分为单位，不足左补0）
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 金额（12位，分为单位，不足左补0）
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 原始流水号（6位，不足左补0）
	 */
	public String getOrig_trace_no() {
		return orig_trace_no;
	}
	/**
	 * 原始流水号（6位，不足左补0）
	 */
	public void setOrig_trace_no(String orig_trace_no) {
		this.orig_trace_no = orig_trace_no;
	}
	/**
	 * 授权码（6位，不足左补0）
	 */
	public String getOrig_auth_no() {
		return orig_auth_no;
	}
	/**
	 * 授权码（6位，不足左补0）
	 */
	public void setOrig_auth_no(String orig_auth_no) {
		this.orig_auth_no = orig_auth_no;
	}
	/**
	 * 原系统参考号（12位，不足左补0）
	 */
	public String getOrig_ref_no() {
		return orig_ref_no;
	}
	/**
	 * 原系统参考号（12位，不足左补0）
	 */
	public void setOrig_ref_no(String orig_ref_no) {
		this.orig_ref_no = orig_ref_no;
	}
	/**
	 * 原交易日期（4位，MMDD）
	 */
	public String getOrig_date() {
		return orig_date;
	}
	/**
	 * 原交易日期（4位，MMDD）
	 */
	public void setOrig_date(String orig_date) {
		this.orig_date = orig_date;
	}
	/**
	 * 卡号
	 */
	public String getCardno() {
		return cardno;
	}
	/**
	 * 卡号
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	/**
	 * 卡片有效期
	 */
	public String getExp_date() {
		return exp_date;
	}
	/**
	 * 卡片有效期
	 */
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	/**
	 * 备注
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 交易唯一标识（30位）
	 */
	public String getTrans_check() {
		return trans_check;
	}
	/**
	 * 交易唯一标识（30位）
	 */
	public void setTrans_check(String trans_check) {
		this.trans_check = trans_check;
	}
	/**
	 * 操作员号
	 */
	public String getOper_no() {
		return oper_no;
	}
	/**
	 * 操作员号
	 */
	public void setOper_no(String oper_no) {
		this.oper_no = oper_no;
	}
	/**
	 * 流水号
	 */
	public String getTrace_no() {
		return trace_no;
	}
	/**
	 * 流水号
	 */
	public void setTrace_no(String trace_no) {
		this.trace_no = trace_no;
	}
	/**
	 * 批次号
	 */
	public String getBatch_no() {
		return batch_no;
	}
	/**
	 * 批次号
	 */
	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}
	/**
	 * 商户号
	 */
	public String getMerch_id() {
		return merch_id;
	}
	/**
	 * 商户号
	 */
	public void setMerch_id(String merch_id) {
		this.merch_id = merch_id;
	}
	/**
	 * 商户名
	 */
	public String getMerch_name() {
		return merch_name;
	}
	/**
	 * 商户名
	 */
	public void setMerch_name(String merch_name) {
		this.merch_name = merch_name;
	}
	/**
	 * 终端号
	 */
	public String getTer_id() {
		return ter_id;
	}
	/**
	 * 终端号
	 */
	public void setTer_id(String ter_id) {
		this.ter_id = ter_id;
	}
	/**
	 * 系统参考号
	 */
	public String getRef_no() {
		return ref_no;
	}
	/**
	 * 系统参考号
	 */
	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}
	/**
	 * 卡组织或钱包机构
	 */
	public String getCups() {
		return cups;
	}
	/**
	 * 卡组织或钱包机构
	 */
	public void setCups(String cups) {
		this.cups = cups;
	}
	/**
	 * 返回码
	 */	
	public String getRejcode() {
		return rejcode;
	}
	/**
	 * 返回码
	 */
	public void setRejcode(String rejcode) {
		this.rejcode = rejcode;
	}
	/**
	 * 发卡行号
	 */
	public String getIss_no() {
		return iss_no;
	}
	/**
	 * 发卡行号
	 */
	public void setIss_no(String iss_no) {
		this.iss_no = iss_no;
	}
	/**
	 * 发卡行名称
	 */
	public String getIss_name() {
		return iss_name;
	}
	/**
	 * 发卡行名称
	 */
	public void setIss_name(String iss_name) {
		this.iss_name = iss_name;
	}
	/**
	 * 交易日期
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 交易日期
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 交易时间
	 */
	public String getTime() {
		return time;
	}
	/**
	 * 交易时间
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 返回码解释
	 */
	public String getRejcode_cn() {
		return rejcode_cn;
	}
	/**
	 * 返回码解释
	 */
	public void setRejcode_cn(String rejcode_cn) {
		this.rejcode_cn = rejcode_cn;
	}

	
	public BaseDate() {
		// TODO Auto-generated constructor stub
	}

	public BaseDate(String business_id, String amount, String orig_trace_no, String orig_auth_no, String orig_ref_no,
			String orig_date, String cardno, String exp_date, String memo, String trans_check, String oper_no,
			String trace_no, String batch_no, String merch_id, String merch_name, String ter_id, String ref_no,
			String cups, String auth_no, String rejcode, String iss_no, String iss_name, String date, String time,
			String rejcode_cn) {
		super();
		this.business_id = business_id;
		this.amount = amount;
		this.orig_trace_no = orig_trace_no;
		this.orig_auth_no = orig_auth_no;
		this.orig_ref_no = orig_ref_no;
		this.orig_date = orig_date;
		this.cardno = cardno;
		this.exp_date = exp_date;
		this.memo = memo;
		this.trans_check = trans_check;
		this.oper_no = oper_no;
		this.trace_no = trace_no;
		this.batch_no = batch_no;
		this.merch_id = merch_id;
		this.merch_name = merch_name;
		this.ter_id = ter_id;
		this.ref_no = ref_no;
		this.cups = cups;
		this.auth_no = auth_no;
		this.rejcode = rejcode;
		this.iss_no = iss_no;
		this.iss_name = iss_name;
		this.date = date;
		this.time = time;
		this.rejcode_cn = rejcode_cn;
	}
	
	
	
	
}
