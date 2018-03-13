package cn.happyworlds.imgmt.entity;

public class FillCard {
	private String cl_old_card;				//旧卡号
	
	private String cl_new_card;				//新卡号
	
	private String CB_EMBOSSNAME;			//姓名
	
	private String CB_IDNO;	//身份证
	
	private String cl_timestamp;			//换卡日期
	
	private String CT_FEE_AMOUNT;			//换卡费
	
	private String cl_auth_user_id;			//操作员cl_auth_user_id

	public String getCl_old_card() {
		return cl_old_card;
	}

	public void setCl_old_card(String cl_old_card) {
		this.cl_old_card = cl_old_card;
	}

	public String getCl_new_card() {
		return cl_new_card;
	}

	public void setCl_new_card(String cl_new_card) {
		this.cl_new_card = cl_new_card;
	}

	public String getCB_EMBOSSNAME() {
		return CB_EMBOSSNAME;
	}

	public void setCB_EMBOSSNAME(String cB_EMBOSSNAME) {
		this.CB_EMBOSSNAME = cB_EMBOSSNAME;
	}

	public String getCB_IDNO() {
		return CB_IDNO;
	}

	public void setCB_IDNO(String CB_IDNO) {
		this.CB_IDNO = CB_IDNO;
	}

	public String getCl_timestamp() {
		return cl_timestamp;
	}

	public void setCl_timestamp(String cl_timestamp) {
		this.cl_timestamp = cl_timestamp;
	}

	public String getCT_FEE_AMOUNT() {
		return CT_FEE_AMOUNT;
	}

	public void setCT_FEE_AMOUNT(String cT_FEE_AMOUNT) {
		this.CT_FEE_AMOUNT = cT_FEE_AMOUNT;
	}

	public String getcl_auth_user_id() {
		return cl_auth_user_id;
	}

	public void setcl_auth_user_id(String cl_auth_user_id) {
		this.cl_auth_user_id = cl_auth_user_id;
	}
	
	
	

	
}
