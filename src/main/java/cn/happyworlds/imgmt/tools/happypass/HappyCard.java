package cn.happyworlds.imgmt.tools.happypass;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


import cn.happyworlds.imgmt.tools.happypass.Codec;
import cn.happyworlds.imgmt.tools.happypass.Sector;
import cn.happyworlds.imgmt.tools.happypass.SectorInformation;
import cn.happyworlds.imgmt.tools.happypass.SectorReleas;
import cn.happyworlds.imgmt.tools.happypass.SectorTransaction;
import cn.happyworlds.imgmt.tools.happypass.SectorWallet;
import cn.happyworlds.imgmt.util.*;

import cn.happyworlds.imgmt.util.DES;

import cn.happyworlds.imgmt.to.Constants;

public class HappyCard {
	
	private static final String DATE_PATTERN = "yyMMdd";
	private static final String DATE_PATTERN1 = "ddHHmmss";
	private static final String DATE_PATTERN2 = "yyMMddHHmm";
	private static final String CONTROLLER = "ff078069";
	private static final String DEFAULTKEY = "FFFFFFFFFFFF";
	private static final String DEFAULTVAL = "00000000000000000000000000000000";
	private static final String SECTKEY1 = "01";
	private static final String CVKEY = "CVK";
	private static final String SECTKEY2 = "02";
	private static final String SECTKEY35 = "03";
	private static final String SECTKEY6 = "06";
	SimpleDateFormat sdf = new SimpleDateFormat();
	

	public static String getController() {
		return CONTROLLER;
	}
	public static String getDefaultkey() {
		return DEFAULTKEY;
	}
	public static String getDefaultval() {
		return DEFAULTVAL;
	}
	
	
	public List<Sector> genCard1(String cardNumber,String block0str,Map<String,String> keyMap) {

		List<Sector> sectors = new ArrayList<Sector>();
		String csnKey = block0str.substring(0,6);
		SectorReleas sr = new SectorReleas();
		//1扇区0块(城市代码、应用代码、发行流水号、认证代码、启用标识、校验位)
		sr.setCityCode(Constants.baseBIN.substring(0,4));
		sr.setAppCode(Constants.baseBIN.substring(4,6));//行业代码
		sr.setSerialNumber(cardNumber);
		sr.setAuthCode(asciiMac(keyMap.get(CVKEY), Codec.bcdDecode(block0str.substring(0,8)+sr.getCityCode()+sr.getAppCode()+sr.getSerialNumber())));
		sr.setEnabledState("02");
		sr.setCardType("1100");
		sr.setCashPledge("0");

		String res = DES.dataDistributed(sr.getCityCode()+sr.getAppCode()+cardNumber, keyMap.get(SECTKEY1));
		sr.setKeyA(csnKey+csnKey);
		sr.setKeyB(res.substring(res.length()-12,res.length()));
		sr.setController(CONTROLLER);
		
		sr.buildBlocks();
		
		sectors.add(sr);
		return sectors;
	}
	
	
	public List<Sector> genCard(String cardNumber, String customerName, String operator, String terminalNumber , String block0str,String cardtype,String validDate,Map<String,String> keyMap) {
		List<Sector> sectors = new ArrayList<Sector>();
		//String walletKey = block0str.substring(0,8)+cardNumber;
		System.out.println("---block0str:"+block0str);
		String csnKey = block0str.substring(0,6);
		Calendar cld = Calendar.getInstance();
		Date now = cld.getTime();
		String chargeAmount = "00000000";
		SectorReleas sr = new SectorReleas();
		//1扇区0块
		sr.setCityCode(Constants.baseBIN.substring(0,4));
		sr.setAppCode(Constants.baseBIN.substring(4,8));//行业代码
		sr.setSerialNumber(cardNumber);
		sr.setAuthCode(asciiMac(keyMap.get(CVKEY), Codec.bcdDecode(block0str.substring(0,8)+sr.getCityCode()+sr.getAppCode()+sr.getSerialNumber())));
		sr.setEnabledState("02");
		sr.setCardType(cardtype);
//		sr.setCashPledge(fee);
		
		String res = DES.dataDistributed(sr.getCityCode()+sr.getAppCode()+cardNumber, keyMap.get(SECTKEY1));
		sr.setKeyA(csnKey+csnKey);
		sr.setKeyB(res.substring(res.length()-12,res.length()));
		sr.setController(CONTROLLER);
		
		//1扇区1块
		sdf.applyPattern(DATE_PATTERN);
		sr.setValidDate(validDate);
		sr.setEnableDate(sdf.format(now));
		sr.setCustomerName(calcCustomerName(customerName));
		
//		//1扇区2块
		sr.setChargeTime("0000000000");
		sr.setChargeBeforeBalance("00000000");
		sr.setLastChargeAmount(chargeAmount);
		sr.setOperator(operator);
		sr.buildBlocks();
		
		sectors.add(sr);
		
//		//2扇区0块
//		SectorWallet sw = new SectorWallet();
//		setKeys(sw, keyMap.get(SECTKEY2), cardNumber);
//		sw.setTotalChargeAmount(chargeAmount);
//		sw.setBalance(chargeAmount);
//		sw.setTerminalNumber(terminalNumber);
//		sw.setCustomerNameExtend(calcCustomerNameExtend(customerName));
//		
//		//2扇区1块
//		String walletReverse = DES.reverse(chargeAmount); 
//		sw.setWallet1(chargeAmount);
//		sw.setWalletReverse(walletReverse);
//		sw.setWallet2(chargeAmount);
//		sw.setBlock9Checkbit(asciiMac(walletKey, Codec.bcdDecode(sw.getWallet1()+sw.getWalletReverse()+sw.getWallet2())));
//
//		//2扇区2块
//		sw.setWallet1BackUp(chargeAmount);
//		sw.setWalletReverseBackUp(walletReverse);
//		sw.setWallet2BackUp(chargeAmount);
//		sw.setBlock10Checkbit(asciiMac(walletKey, Codec.bcdDecode(sw.getWallet1BackUp()+sw.getWalletReverseBackUp()+sw.getWallet2BackUp())));
//		
//		sw.buildBlocks();
//		sectors.add(sw);
//		//3扇区
//		SectorTransaction st = new SectorTransaction();
//		setKeys(st, keyMap.get(SECTKEY35), cardNumber);
//		st.buildBlock3();
//		sectors.add(st);
//		//4扇区
//		sectors.add(st);
//		//5扇区
//		sectors.add(st);
//		
//		SectorInformation si = new SectorInformation();
//		setKeys(si, keyMap.get(SECTKEY6), cardNumber);
//		si.setTransactionIndex1(0);//交易记录指针
//		si.setTransactionCount1(0);//钱包累计交易次数
//		si.setTransactionCourseCount1(2);//交易过程次数
//		si.setMonthlyTicket1("FFFF");//月票累计交易测试
//		si.setBlackFlag1("00");//黑名单标识
//		si.setFileFlag1("10");//文件标识
//		
//		si.setTransactionIndex2(0);//交易记录指针
//		si.setTransactionCount2(0);//钱包累计交易次数
//		si.setTransactionCourseCount2(2);//交易过程次数
//		si.setMonthlyTicket2("FFFF");//月票累计交易测试
//		si.setBlackFlag2("00");//黑名单标识
//		si.setFileFlag2("10");//文件标识
//
//		si.buildBlocks();
//		sectors.add(si);
//		
		System.out.println("----4:"+sectors);
		return sectors;
	}

	
	private String calcCustomerName(String customerName) {
		byte[] nameBytes = new byte[]{};
		int namelen = 9;
		try {
			nameBytes = customerName.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(nameBytes.length == namelen) {
			return customerName;
		}
		if(nameBytes.length > namelen) {
			try {
				return new String(nameBytes, 0, namelen, "GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		StringBuilder buf = new StringBuilder(customerName);
		for(int i=0; i<namelen - nameBytes.length; i++) {
			buf.append(" ");
		}
		return buf.toString();
	}
	
	protected String asciiMac(String mak, byte[] data) {
		String m = DES.mac(mak, data);
		if(m==null){
			return null;
		}
		System.out.println(m);
		return Codec.hexEncode(m.substring(0,4).getBytes());
	}
	
	private String calcCustomerNameExtend(String customerName) {
		byte[] nameBytes = customerName.getBytes();
		int namelen = 9;
		int extendlen = 3;
		if(nameBytes.length <= namelen) {
			return "   ";
		}
		if(nameBytes.length >= namelen+extendlen) {
			return new String(nameBytes, namelen, extendlen);
		}
		StringBuilder buf = new StringBuilder(new String(nameBytes, namelen, nameBytes.length -extendlen));
		for(int i=0; i<nameBytes.length-namelen; i++) {
			buf.append(" ");
		}
		return buf.toString();
	}
	
	private void setKeys (Sector sector,String key,String element){
		String res = DES.dataDistributed(Codec.hexEncode(element.getBytes()), key);
		sector.setKeyA(res.substring(0,12));
		sector.setKeyB(res.substring(res.length()-12,res.length()));
		sector.setController(CONTROLLER);
	}
	
	
	public List<Sector> genCharge(String[]blocks ,String operator,String terminalNumber,String chargeAmount){
		String block0str = blocks[0];//0-0
		
		String block4str = blocks[1];//1-0
		
		String block8str = blocks[2];//2-0
		String block9str = blocks[3];//2-1
		
		String block24str = blocks[4];//6-0
		
		String cardNumber = block4str.substring(8,16);
		BigDecimal chargeAmountNumber = new BigDecimal(chargeAmount);
		
		String totalChargeAmount = BigDecimal.valueOf(Long.parseLong(block8str.substring(0,8), 16)).add(chargeAmountNumber).toString();
		String customerNameExtend= block8str.substring(24,30);
		
		String beforeBalance = block9str.substring(0,8);
		String wallet2 = block9str.substring(16,24);
		
		
		String wallet1 = BigDecimal.valueOf(Long.parseLong(beforeBalance, 16)).add(chargeAmountNumber).toString();
		wallet2 = BigDecimal.valueOf(Long.parseLong(wallet2, 16)).add(chargeAmountNumber).toString();
		
		int idx = Integer.valueOf(block24str.substring(0,2));
		int index = ++idx;
		if(index>9){
			index = 1;
		}
		int trxnCount = Integer.parseInt(block24str.substring(2,6),16);
		
		String cns = block0str.substring(0,8);
		String walletKey = cns+cardNumber;
		Calendar cld = Calendar.getInstance();
		Date now = cld.getTime();
		List<Sector> sectors = new ArrayList<Sector>();
		
		SectorReleas sr = new SectorReleas();
		//1扇区2块
		sdf.applyPattern(DATE_PATTERN2);
		sr.setChargeTime(sdf.format(now));
		sr.setChargeBeforeBalance(beforeBalance);
		sr.setLastChargeAmount(StringUtil.leftContact(Codec.num2hex(chargeAmountNumber.toString()), 6, '0'));
		sr.setOperator(operator);
		
		sr.buildBlocks();
		
		sectors.add(sr);
		
		//2扇区0块
		SectorWallet sw = new SectorWallet();
		totalChargeAmount = StringUtil.leftContact(Codec.num2hex(totalChargeAmount), 8, '0');
		wallet1 = StringUtil.leftContact(Codec.num2hex(wallet1), 8, '0');
		wallet2 = StringUtil.leftContact(Codec.num2hex(wallet2), 8, '0');
		sw.setTotalChargeAmount(totalChargeAmount);
		sw.setBalance(wallet1);
		sw.setTerminalNumber(terminalNumber);
		sw.setCustomerNameExtend(customerNameExtend);
		
		//2扇区1块
		String walletReverse = DES.reverse(wallet1);
		sw.setWallet1(wallet1);
		sw.setWalletReverse(walletReverse);
		sw.setWallet2(wallet1);
		sw.setBlock9Checkbit(asciiMac(walletKey, Codec.bcdDecode(sw.getWallet1()+sw.getWalletReverse()+sw.getWallet2())));

		//2扇区2块
		sw.setWallet1BackUp(sw.getWallet1());
		sw.setWalletReverseBackUp(sw.getWalletReverse());
		sw.setWallet2BackUp(sw.getWallet2());
		sw.setBlock10Checkbit(sw.getBlock9Checkbit());
		
		sw.buildBlocks();
		sectors.add(sw);
		
		//3-5扇区N块
		SectorTransaction emptyst = null;
		if(index>=4&&index<=6){
			sectors.add(emptyst);
		}else if(index>=7&&index<=9){
			sectors.add(emptyst);
			sectors.add(emptyst);
		}
		//3扇区N块
		SectorTransaction st = new SectorTransaction();
		sdf.applyPattern(DATE_PATTERN1);
		st.setTransactionTime(sdf.format(now));
		st.setBalanceBefore(beforeBalance);
		st.setTransactionAmount(StringUtil.leftContact(Codec.num2hex(chargeAmountNumber.toString()), 6, '0'));
		st.setTransactionType("88");//充值
		st.setTerminalNumber(terminalNumber);
		st.setIndex(index);	
		
		st.buildBlocks();
		sectors.add(st);
		
		if(index>=4&&index<=6){
			sectors.add(emptyst);
		}else if(index>=1&&index<=3){
			sectors.add(emptyst);
			sectors.add(emptyst);
		}
		
		//6扇区
		SectorInformation si = new SectorInformation();
		si.setTransactionIndex1(index);//交易记录指针
		si.setTransactionCount1(trxnCount++);//钱包累计交易次数
		si.setTransactionCourseCount1(2);//交易过程次数
		si.setMonthlyTicket1("FFFF");//月票累计交易测试
		si.setBlackFlag1("00");//黑名单标识
		si.setFileFlag1("10");//文件标识
		
		si.setTransactionIndex2(si.getTransactionIndex1());//交易记录指针
		si.setTransactionCount2(si.getTransactionCount1());//钱包累计交易次数
		si.setTransactionCourseCount2(2);//交易过程次数
		si.setMonthlyTicket2("FFFF");//月票累计交易测试
		si.setBlackFlag2("00");//黑名单标识
		si.setFileFlag2("10");//文件标识

		si.buildBlocks();
		sectors.add(si);
		
		return sectors;
	}
	
	
	public List<Sector> resetCard(String cardNumber,Map<String,String> keyMap){
		
		List<Sector> sectors = new ArrayList<Sector>();
		SectorReleas sr = new SectorReleas();
		//1扇区0块
		sr.setBlock0(DEFAULTVAL);
		sr.setBlock1(DEFAULTVAL);
		sr.setBlock2(DEFAULTVAL);
		sr.setBlock3(DEFAULTVAL);
		sr.setKeyA(DEFAULTKEY);
		sr.setKeyB(DEFAULTKEY);
		sr.setController(CONTROLLER);
		sr.buildBlock3();
		sectors.add(sr);
		
		//2扇区0块
		SectorWallet sw = new SectorWallet();
		sw.setBlock0(DEFAULTVAL);
		sw.setBlock1(DEFAULTVAL);
		sw.setBlock2(DEFAULTVAL);
		sw.setBlock3(DEFAULTVAL);
		sw.setKeyA(DEFAULTKEY);
		sw.setKeyB(DEFAULTKEY);
		sw.setController(CONTROLLER);
		sw.buildBlock3();
		sectors.add(sw);
		//3扇区
		SectorTransaction st = new SectorTransaction();
		st.setBlock0(DEFAULTVAL);
		st.setBlock1(DEFAULTVAL);
		st.setBlock2(DEFAULTVAL);
		st.setBlock3(DEFAULTVAL);
		st.setKeyA(DEFAULTKEY);
		st.setKeyB(DEFAULTKEY);
		st.setController(CONTROLLER);
		st.buildBlock3();
		sectors.add(st);
		//4扇区
		sectors.add(st);
		//5扇区
		sectors.add(st);
		
		SectorInformation si = new SectorInformation();
		si.setBlock0(DEFAULTVAL);
		si.setBlock1(DEFAULTVAL);
		si.setBlock2(DEFAULTVAL);
		si.setBlock3(DEFAULTVAL);
		si.setKeyA(DEFAULTKEY);
		si.setKeyB(DEFAULTKEY);
		si.setController(CONTROLLER);
		si.buildBlock3();
		sectors.add(si);
		
		return sectors;
		
	}
}

