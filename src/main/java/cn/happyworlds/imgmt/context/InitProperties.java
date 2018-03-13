package cn.happyworlds.imgmt.context;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "init")
public class InitProperties {

	//商户号码
	private String merchantNo;
	//场馆号码
	private String venueNo;
	//终端规则
	private String terminalNo;
	//闸机规则
	private String gateNo;
	
	private String batchNumber;
	
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getVenueNo() {
		return venueNo;
	}
	public void setVenueNo(String venueNo) {
		this.venueNo = venueNo;
	}
	public String getTerminalNo() {
		return terminalNo;
	}
	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}
	public String getGateNo() {
		return gateNo;
	}
	public void setGateNo(String gateNo) {
		this.gateNo = gateNo;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	


}
