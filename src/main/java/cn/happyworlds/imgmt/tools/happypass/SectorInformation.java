package cn.happyworlds.imgmt.tools.happypass;

import java.util.List;


import cn.happyworlds.imgmt.tools.happypass.exception.Block0ValidationException;
import cn.happyworlds.imgmt.tools.happypass.exception.Block1ValidationException;
import cn.happyworlds.imgmt.util.StringUtil;


public class SectorInformation extends Sector {

	private static final long serialVersionUID = -8080745710165518639L;
	
	private int transactionIndex1;// 交易记录指针
	private int transactionCount1;// 钱包累计交易次数
	private int transactionCourseCount1;// 交易过程次数
	private String monthlyTicket1;// 月票累计交易测试
	private String blackFlag1;// 黑名单标识
	private String fileFlag1;// 文件标识

	private int transactionIndex2;// 交易记录指针
	private int transactionCount2;// 钱包累计交易次数
	private int transactionCourseCount2;// 交易过程次数
	private String monthlyTicket2;// 月票累计交易测试
	private String blackFlag2;// 黑名单标识
	private String fileFlag2;// 文件标识

	public int getTransactionIndex1() {
		return transactionIndex1;
	}

	public void setTransactionIndex1(int transactionIndex1) {
		this.transactionIndex1 = transactionIndex1;
	}

	public int getTransactionCount1() {
		return transactionCount1;
	}

	public void setTransactionCount1(int transactionCount1) {
		this.transactionCount1 = transactionCount1;
	}

	public int getTransactionCourseCount1() {
		return transactionCourseCount1;
	}

	public void setTransactionCourseCount1(int transactionCourseCount1) {
		this.transactionCourseCount1 = transactionCourseCount1;
	}

	public String getMonthlyTicket1() {
		return monthlyTicket1;
	}

	public void setMonthlyTicket1(String monthlyTicket1) {
		this.monthlyTicket1 = monthlyTicket1;
	}

	public String getBlackFlag1() {
		return blackFlag1;
	}

	public void setBlackFlag1(String blackFlag1) {
		this.blackFlag1 = blackFlag1;
	}

	public String getFileFlag1() {
		return fileFlag1;
	}

	public void setFileFlag1(String fileFlag1) {
		this.fileFlag1 = fileFlag1;
	}

	public int getTransactionIndex2() {
		return transactionIndex2;
	}

	public void setTransactionIndex2(int transactionIndex2) {
		this.transactionIndex2 = transactionIndex2;
	}

	public int getTransactionCount2() {
		return transactionCount2;
	}

	public void setTransactionCount2(int transactionCount2) {
		this.transactionCount2 = transactionCount2;
	}

	public int getTransactionCourseCount2() {
		return transactionCourseCount2;
	}

	public void setTransactionCourseCount2(int transactionCourseCount2) {
		this.transactionCourseCount2 = transactionCourseCount2;
	}

	public String getMonthlyTicket2() {
		return monthlyTicket2;
	}

	public void setMonthlyTicket2(String monthlyTicket2) {
		this.monthlyTicket2 = monthlyTicket2;
	}

	public String getBlackFlag2() {
		return blackFlag2;
	}

	public void setBlackFlag2(String blackFlag2) {
		this.blackFlag2 = blackFlag2;
	}

	public String getFileFlag2() {
		return fileFlag2;
	}

	public void setFileFlag2(String fileFlag2) {
		this.fileFlag2 = fileFlag2;
	}

	@Override
	protected Sector buildBlocks() {
		try{	
			byte block[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(Codec.int2hex(this.transactionIndex1), 2), 0, block, 0, 1);
			System.arraycopy(Codec.bcdDecode(Codec.int2hex(this.transactionCount1), 4), 0, block, 1, 2);
			System.arraycopy(Codec.bcdDecode(StringUtil.leftContact(Codec.int2hex(this.transactionCourseCount1),4,'0'), 2), 0, block, 3, 1);
			System.arraycopy(Codec.bcdDecode(this.monthlyTicket1,4), 0, block, 4, 2);
			System.arraycopy(Codec.bcdDecode(this.blackFlag1, 2), 0, block, 6, 1);
			System.arraycopy(Codec.bcdDecode(this.fileFlag1, 2), 0, block, 7, 1);
			System.arraycopy(Codec.bcdDecode("FFFFFFFFFFFFFF", 14), 0, block, 8, 7);
			block[15] = calcCheckbit(block);
			setBlock0(block);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				System.out.print("this.transactionIndex1="+this.transactionIndex1);
				System.out.print("this.transactionCount1="+this.transactionCount1);
				System.out.print("this.transactionCourseCount1="+this.transactionCourseCount1);
				System.out.print("this.monthlyTicket1="+this.monthlyTicket1);
				System.out.print("this.blackFlag1="+this.blackFlag1);
				System.out.println("this.fileFlag1="+this.fileFlag1);
				e.printStackTrace();
			}
		}
		try{
			byte block[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(Codec.int2hex(this.transactionIndex2), 2), 0, block, 0, 1);
			System.arraycopy(Codec.bcdDecode(Codec.int2hex(this.transactionCount2), 4), 0, block, 1, 2);
			System.arraycopy(Codec.bcdDecode(StringUtil.leftContact(Codec.int2hex(this.transactionCourseCount2),4,'0'), 2), 0, block, 3, 1);
			System.arraycopy(Codec.bcdDecode(this.monthlyTicket2,4), 0, block, 4, 2);
			System.arraycopy(Codec.bcdDecode(this.blackFlag2, 2), 0, block, 6, 1);
			System.arraycopy(Codec.bcdDecode(this.fileFlag2, 2), 0, block, 7, 1);
			System.arraycopy(Codec.bcdDecode("FFFFFFFFFFFFFF", 14), 0, block, 8, 7);
			block[15] = calcCheckbit(block);
			setBlock1(block);
		}catch (NullPointerException e) {
			if(e.getStackTrace().length>1){
				StackTraceElement stackTraceElement= e.getStackTrace()[1]; 
				System.err.print("Skip->File="+stackTraceElement.getFileName()); 
				System.err.println(",Line="+stackTraceElement.getLineNumber());	
			}else{
				System.out.print("this.transactionIndex2="+this.transactionIndex2);
				System.out.print("this.transactionCount2="+this.transactionCount2);
				System.out.print("this.transactionCourseCount2="+this.transactionCourseCount2);
				System.out.print("this.monthlyTicket2="+this.monthlyTicket2);
				System.out.print("this.blackFlag2="+this.blackFlag2);
				System.out.println("this.fileFlag2="+this.fileFlag2);
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
				this.transactionIndex1 = Codec.hex2int(sb.substring(0, 2));
				this.transactionCount1 = Codec.hex2int(sb.substring(2, 6));
				this.transactionCourseCount1 = Codec.hex2int(sb.substring(6, 8));
				this.monthlyTicket1 = sb.substring(8, 12);
				this.blackFlag1 = sb.substring(12, 14);
				this.fileFlag1 = sb.substring(14, 16);
				
			}
			if(size>1&&StringUtil.hasText(blockstr.get(1))){
				sb = new StringBuffer(blockstr.get(1));
//				if(!checkbit(blockstr.get(1))){
//					throw new Block1ValidationException("1block checkvalue error");
//				}
				super.setBlock1(blockstr.get(1));
				this.transactionIndex2 = Codec.hex2int(sb.substring(0, 2));
				this.transactionCount2 = Codec.hex2int(sb.substring(2, 6));
				this.transactionCourseCount2 = Codec.hex2int(sb.substring(6, 8));
				this.monthlyTicket2 = sb.substring(8, 12);
				this.blackFlag2 = sb.substring(12, 14);
				this.fileFlag2 = sb.substring(14, 16);
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
