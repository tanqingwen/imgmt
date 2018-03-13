package cn.happyworlds.imgmt.tools.happypass;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cn.happyworlds.imgmt.util.StringUtil;


public class SectorReleas extends Sector {

	private static final long serialVersionUID = 5903204762786196833L;
	
	// 第4块
	private String cityCode; // 城市代码 2 byte BCD
	private String appCode; // 应用代码 2 byte BCD
	private String serialNumber; // 发行流水号 4 byte BCD
	private String authCode; // 认证代码 4 byte HEX
	private String enabledState; // 启用标识 1 byte HEX
	private String cardType; // 卡类型 1 byte HEX
	private String cashPledge; // 押金 1 byte HEX
	private String block4Checkbit; // 第4扇区校验位 1 byte HEX

	// 第5块
	private String validDate; // 有效日期 3 byte
	private String enableDate; // 启用日期 3 byte
	private String customerName; // 客户姓名 9 byte
	private String block5Checkbit; // 1 byte

	// 第6块
	private String chargeTime; // 充值时间，年月日时分 5 byte
	private String chargeBeforeBalance; // 充值前余额 4 byte
	private String lastChargeAmount; // 本次充值金额 3 byte
	private String operator; // 操作员 3 byte
	private String block6Checkbit; // 1 byte

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getEnabledState() {
		return enabledState;
	}

	public void setEnabledState(String enabledState) {
		this.enabledState = enabledState;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCashPledge() {
		return cashPledge;
	}

	public void setCashPledge(String cashPledge) {
		this.cashPledge = cashPledge;
	}

	public String getBlock4Checkbit() {
		return block4Checkbit;
	}

	public void setBlock4Checkbit(String block4Checkbit) {
		this.block4Checkbit = block4Checkbit;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getEnableDate() {
		return enableDate;
	}

	public void setEnableDate(String enableDate) {
		this.enableDate = enableDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBlock5Checkbit() {
		return block5Checkbit;
	}

	public void setBlock5Checkbit(String block5Checkbit) {
		this.block5Checkbit = block5Checkbit;
	}

	public String getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
	}

	public String getChargeBeforeBalance() {
		return chargeBeforeBalance;
	}

	public void setChargeBeforeBalance(String chargeBeforeBalance) {
		this.chargeBeforeBalance = chargeBeforeBalance;
	}

	public String getLastChargeAmount() {
		return lastChargeAmount;
	}

	public void setLastChargeAmount(String lastChargeAmount) {
		this.lastChargeAmount = lastChargeAmount;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getBlock6Checkbit() {
		return block6Checkbit;
	}

	public void setBlock6Checkbit(String block6Checkbit) {
		this.block6Checkbit = block6Checkbit;
	}
	
	
	
	@Override
	protected Sector buildBlocks() {
		try{
			byte block0[] = new byte[16];
			
			//第一个是要复制的数组，第二个是从要复制的数组的第几个开始，第三个是复制到那，四个是复制到的数组第几个开始
			//最后一个是复制长度
			System.arraycopy(Codec.bcdDecode(this.cityCode, 4), 0, block0, 0, 2);
			System.arraycopy(Codec.bcdDecode(this.appCode, 2), 0, block0, 2, 1);
			//System.arraycopy(Codec.bcdDecode(this.serialNumber, 8), 0, block0, 4, 4);
			//System.arraycopy(Codec.bcdDecode(this.authCode,8), 0, block0, 8, 4);
			//block0[12] = Codec.bcdDecode(this.enabledState, 2)[0];
			//block0[13] = Codec.bcdDecode(this.cardType, 2)[0];
			//block0[14] = Codec.bcdDecode(this.cashPledge, 2)[0];
			//block0[15] = calcCheckbit(block0);
			
			System.arraycopy(Codec.bcdDecode(this.serialNumber, 10), 0, block0, 3, 5);
			System.arraycopy(Codec.bcdDecode(this.authCode,8), 0, block0, 8, 4);
			block0[12] = Codec.bcdDecode(this.enabledState, 2)[0];
			block0[13] = Codec.bcdDecode(this.cardType, 2)[0];
			block0[14] = Codec.bcdDecode(this.cashPledge, 2)[0];
			block0[15] = calcCheckbit(block0);
			
			setBlock0(block0);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				System.out.print("this.cityCode="+this.cityCode);
				System.out.print(",this.appCode="+this.appCode);
				System.out.print(",this.serialNumber="+this.serialNumber);
				System.out.print(",this.authCode="+this.authCode);
				System.out.print(",this.enabledState="+this.enabledState);
				System.out.print(",this.cardType="+this.cardType);
				System.out.println(",this.cashPledge="+this.cashPledge);
				e.printStackTrace();
			}
		}
		try{
			byte block1[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(this.validDate, 6), 0, block1, 0, 3);
			System.arraycopy(Codec.bcdDecode(this.enableDate, 6), 0, block1, 3, 3);
			System.arraycopy(this.customerName.getBytes("GBK"), 0, block1, 6, 9);
	
			block1[15] = calcCheckbit(block1);
		
			setBlock1(block1);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				System.out.print("this.validDate="+this.validDate);
				System.out.print(",this.enableDate="+this.enableDate);
				System.out.println(",this.customerName="+this.customerName);
				e.printStackTrace();
			} 
		} catch (UnsupportedEncodingException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				System.out.println("this.customerName="+this.customerName);
				e.printStackTrace();
			}
		}
		
		try{
			byte block2[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(this.chargeTime, 10), 0, block2, 0, 5);
			System.arraycopy(Codec.bcdDecode(this.chargeBeforeBalance, 8), 0, block2, 5, 4);
			System.arraycopy(Codec.bcdDecode(this.lastChargeAmount, 6), 0, block2, 9, 3);
			System.arraycopy(Codec.bcdDecode(this.operator, 6), 0, block2, 12, 3);
			block2[15] = calcCheckbit(block2);		
			
			setBlock2(block2);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				e.printStackTrace();
			} 
		}
		
		buildBlock3();
		
		return this;
	}

	@Override
	protected Sector parseBlocks(List<String> blockstr) {
		StringBuffer sb = null;
		try{
			int size = blockstr.size();
			if(size>0&&StringUtil.hasText(blockstr.get(0))){
				sb = new StringBuffer(blockstr.get(0));
//				if(!checkbit(blockstr.get(0))){
//					throw new Block0ValidationException("0block checkvalue error");
//				}
				super.setBlock0(blockstr.get(0));
				this.cityCode = sb.substring(0,4);
				this.appCode = sb.substring(4,8);
				this.serialNumber = sb.substring(8, 16);
				this.authCode = sb.substring(16,24);
				this.enabledState = sb.substring(24,26);
				this.cardType = sb.substring(26,28);
				this.cashPledge = sb.substring(28, 30);
			}
			if(size>1&&StringUtil.hasText(blockstr.get(1))){
				sb = new StringBuffer(blockstr.get(1));
//				if(!checkbit(blockstr.get(1))){
//					throw new Block1ValidationException("1block checkvalue error");
//				}
				super.setBlock1(blockstr.get(1));
				this.validDate = sb.substring(0,6);
				this.enableDate = sb.substring(6,12);
				this.customerName = new String(Codec.hexDecode(sb.substring(12, 30)),"GBK");
			}
			if(size>2&&StringUtil.hasText(blockstr.get(2))){
				sb = new StringBuffer(blockstr.get(2));
//				if(!checkbit(blockstr.get(2))){
//					throw new Block2ValidationException("2block checkvalue error");
//				}
				super.setBlock2(blockstr.get(2));
				this.chargeTime = sb.substring(0, 10);
				this.chargeBeforeBalance = sb.substring(10, 18);
				this.lastChargeAmount = sb.substring(18, 24);
				this.operator = sb.substring(24, 30);
			}
			if(size>3&&StringUtil.hasText(blockstr.get(3))){
				sb = new StringBuffer(blockstr.get(3));
				super.setBlock3(blockstr.get(3));
				super.setKeyA(sb.substring(0,12));
				super.setController(sb.substring(12,20));
				super.setKeyB(sb.substring(20,32));
			}
			return this;
		}catch (Exception e) {
			e.printStackTrace();
			if(sb!=null){
				System.out.println("解析错误"+sb.toString());	
			}
			return null;
		}
	}
	
	
}
