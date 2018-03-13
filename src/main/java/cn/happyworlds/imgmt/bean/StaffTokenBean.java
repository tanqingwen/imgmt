package cn.happyworlds.imgmt.bean;

public class StaffTokenBean {

	private String id;
	private String roles;
	private String status;
	private String token;
	public StaffTokenBean(){}
	public StaffTokenBean(String id,String roles,String status){
		this.id = id;
		this.roles = roles;
		this.status = status;
	}
	public StaffTokenBean(String id,String roles,String status, String token){
		this.id = id;
		this.roles = roles;
		this.status = status;
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
