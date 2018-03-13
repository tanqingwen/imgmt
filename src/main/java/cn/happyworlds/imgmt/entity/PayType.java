package cn.happyworlds.imgmt.entity;

public class PayType {
	private String payType;
	
	private String payMoney;

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Override
	public String toString() {
		return "PayType [payType=" + payType + ", payMoney=" + payMoney + "]";
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	
}
