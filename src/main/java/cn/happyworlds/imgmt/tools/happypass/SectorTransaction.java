package cn.happyworlds.imgmt.tools.happypass;

import java.util.List;


public class SectorTransaction extends Sector {

	private static final long serialVersionUID = -5030099256273677411L;
	
	private String transactionTime;// 交易时间（日时分秒）
	private String balanceBefore;// 交易前余额
	private String transactionAmount;// 交易金额
	private String transactionType;// 交易类型
	private String terminalNumber;// 终端号
	private int index;// 交易记录指针

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getBalanceBefore() {
		return balanceBefore;
	}

	public void setBalanceBefore(String balanceBefore) {
		this.balanceBefore = balanceBefore;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTerminalNumber() {
		return terminalNumber;
	}

	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	@Override
	protected Sector buildBlocks() {
		try{
			byte[] block = new byte[16];
			System.arraycopy(Codec.bcdDecode(transactionTime), 0, block, 0, 4);
			System.arraycopy(Codec.bcdDecode(balanceBefore), 0, block, 4, 4);
			System.arraycopy(Codec.bcdDecode(transactionAmount), 0, block, 8, 3);
			System.arraycopy(Codec.bcdDecode(transactionType), 0, block, 11, 1);
			System.arraycopy(Codec.bcdDecode(terminalNumber), 0, block, 12, 4);
		
			if (index <= 9 && index >= 1) {
				// 根据指针决定写到块区
				switch ((index - 1) % 3) {
				case 0:
					setBlock0(block);
					break;
				case 1:
					setBlock1(block);
					break;
				case 2:
					setBlock2(block);
					break;
				default:
					break;
				}
			} else {
				throw new RuntimeException("index should between 1 and 9");
			}
			
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				System.out.print("this.transactionTime="+this.transactionTime);
				System.out.print("this.balanceBefore="+this.balanceBefore);
				System.out.print("this.transactionAmount="+this.transactionAmount);
				System.out.print("this.transactionType="+this.transactionType);
				System.out.println("this.terminalNumber="+this.terminalNumber);
				e.printStackTrace();
				
			} 
		}

		buildBlock3();
			
		return this;
	}

	@Override
	protected Sector parseBlocks(List<String> blockstr) {
		//TODO 交易区
		return this;
	}
}
