package cn.happyworlds.imgmt.tools.happypass;

import java.util.List;

import cn.happyworlds.imgmt.tools.happypass.exception.Block0ValidationException;
import cn.happyworlds.imgmt.util.StringUtil;


public class SectorWallet extends Sector {
	
	private static final long serialVersionUID = -2294138301621078423L;
	
	// 第8块
	private String totalChargeAmount; // 累计充值余额 5 byte
	private String balance; // 金额 4 byte
	private String terminalNumber; // 终端编号 2 byte
	private String customerNameExtend; // 客户姓名扩展 4 byte
	private String block8Checkbit; // 1 byte

	// 第9块
	private String wallet1;// 钱包
	private String walletReverse;// 钱包(取反)
	private String wallet2;// 钱包
	private String block9Checkbit; // 4 byte

	// 第10块
	private String wallet1BackUp;// 钱包
	private String walletReverseBackUp;// 钱包(取反)
	private String wallet2BackUp;// 钱包
	private String block10Checkbit; // 4 byte

	public String getTotalChargeAmount() {
		return totalChargeAmount;
	}

	public void setTotalChargeAmount(String totalChargeAmount) {
		this.totalChargeAmount = totalChargeAmount;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getTerminalNumber() {
		return terminalNumber;
	}

	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public String getCustomerNameExtend() {
		return customerNameExtend;
	}

	public void setCustomerNameExtend(String customerNameExtend) {
		this.customerNameExtend = customerNameExtend;
	}

	public String getBlock8Checkbit() {
		return block8Checkbit;
	}

	public void setBlock8Checkbit(String block8Checkbit) {
		this.block8Checkbit = block8Checkbit;
	}

	public String getWallet1() {
		return wallet1;
	}

	public void setWallet1(String wallet1) {
		this.wallet1 = wallet1;
	}

	public String getWalletReverse() {
		return walletReverse;
	}

	public void setWalletReverse(String walletReverse) {
		this.walletReverse = walletReverse;
	}

	public String getWallet2() {
		return wallet2;
	}

	public void setWallet2(String wallet2) {
		this.wallet2 = wallet2;
	}

	public String getBlock9Checkbit() {
		return block9Checkbit;
	}

	public void setBlock9Checkbit(String block9Checkbit) {
		this.block9Checkbit = block9Checkbit;
	}

	public String getWallet1BackUp() {
		return wallet1BackUp;
	}

	public void setWallet1BackUp(String wallet1BackUp) {
		this.wallet1BackUp = wallet1BackUp;
	}

	public String getWalletReverseBackUp() {
		return walletReverseBackUp;
	}

	public void setWalletReverseBackUp(String walletReverseBackUp) {
		this.walletReverseBackUp = walletReverseBackUp;
	}

	public String getWallet2BackUp() {
		return wallet2BackUp;
	}

	public void setWallet2BackUp(String wallet2BackUp) {
		this.wallet2BackUp = wallet2BackUp;
	}

	public String getBlock10Checkbit() {
		return block10Checkbit;
	}

	public void setBlock10Checkbit(String block10Checkbit) {
		this.block10Checkbit = block10Checkbit;
	}

	@Override
	protected Sector buildBlocks() {
		try{
			// 扇区8
			byte block0[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(this.totalChargeAmount, 8), 0, block0, 0, 4);
			System.arraycopy(Codec.bcdDecode(this.balance, 8), 0, block0, 4, 4);
			System.arraycopy(Codec.bcdDecode(this.terminalNumber, 8), 0, block0, 8, 4);
			System.arraycopy(this.customerNameExtend.getBytes(), 0, block0, 12, 3);
			block0[15] = calcCheckbit(block0);
			
			setBlock0(block0);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				e.printStackTrace();
			} 
		}
		try{
			// 扇区9
			byte block1[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(wallet1), 0, block1, 0, 4);
			System.arraycopy(Codec.bcdDecode(walletReverse), 0, block1, 4, 4);
			System.arraycopy(Codec.bcdDecode(wallet2), 0, block1, 8, 4);
			System.arraycopy(Codec.bcdDecode(block9Checkbit), 0, block1, 12, 4);
			
			setBlock1(block1);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				System.out.print("this.wallet1="+this.wallet1);
				System.out.print("this.walletReverse="+this.walletReverse);
				System.out.print("this.wallet2="+this.wallet2);
				System.out.println("this.block9Checkbit="+this.block9Checkbit);
				e.printStackTrace();
			} 
		}
		try{
			// 扇区10
			byte block2[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(wallet1BackUp), 0, block2, 0, 4);
			System.arraycopy(Codec.bcdDecode(walletReverseBackUp), 0, block2, 4, 4);
			System.arraycopy(Codec.bcdDecode(wallet2BackUp), 0, block2, 8, 4);
			System.arraycopy(Codec.bcdDecode(block10Checkbit), 0, block2, 12, 4);
			
			setBlock2(block2);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());
			}else{
				System.out.print("this.wallet1BackUp="+this.wallet1BackUp);
				System.out.print("this.walletReverseBackUp="+this.walletReverseBackUp);
				System.out.print("this.wallet2BackUp="+this.wallet2BackUp);
				System.out.println("this.block10Checkbit="+this.block10Checkbit);
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
				this.totalChargeAmount = sb.substring(0, 8);
				this.balance = sb.substring(8, 16);
				this.terminalNumber = sb.substring(16, 24); 
				this.customerNameExtend = new String(Codec.hexDecode(sb.substring(24, 30)),"GBK");
				
			}
			if(size>1&&StringUtil.hasText(blockstr.get(1))){
				sb = new StringBuffer(blockstr.get(1));
				super.setBlock1(blockstr.get(1));
				this.wallet1 = sb.substring(0, 8);
				this.walletReverse = sb.substring(8, 16);
				this.wallet2 = sb.substring(16, 24);
				this.block9Checkbit = sb.substring(24, 32);
			}
			if(size>2&&StringUtil.hasText(blockstr.get(2))){
				sb = new StringBuffer(blockstr.get(2));
				super.setBlock2(blockstr.get(2));
				this.wallet1BackUp = sb.substring(0, 8);
				this.walletReverseBackUp = sb.substring(8, 16);
				this.wallet2BackUp = sb.substring(16, 24);
				this.block10Checkbit = sb.substring(24, 32);
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
