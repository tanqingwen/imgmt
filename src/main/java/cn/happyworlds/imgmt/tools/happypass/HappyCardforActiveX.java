package cn.happyworlds.imgmt.tools.happypass;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.happyworlds.imgmt.util.DES;
import cn.happyworlds.imgmt.util.StringUtil;

public class HappyCardforActiveX {
	
	public List<String> openCard1(String cardNumber, String user, String terminalNumber,String block0str,Map<String,String> keyMap) {
		
		HappyCard bc = new HappyCard();
		List<String> res = new ArrayList<String>();
		try {
			cardNumber = cardNumber.substring(6);
			List<Sector> li = bc.genCard1(cardNumber, block0str,keyMap);
			res.add(null);
			res.add("00011003030306FFFFFFFFFFFFFFFFFF");
			res.add(null);
			res.add("A0A1A2A3A4A5" + HappyCard.getController() + HappyCard.getDefaultkey());
			for (int i = 0; i < li.size(); i++) {
				Sector sc = (Sector) li.get(i);
				res.add(sc.getBlock0Str());
				res.add(sc.getBlock1Str());
				res.add(sc.getBlock2Str());
				res.add(sc.getBlock3Str());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("激活卡失败:" + e.getMessage());
		}
		System.out.println(res);
		return res;
	}
	
	public List<String> openCard(String cardNumber, String customerName, String user, String terminalNumber,
			String block0str, String cardtype, String birthday) {
		HappyCard bc = new HappyCard();
		Map<String,String> keyMap = new HashMap<String,String>();
		keyMap.put("CVK", "b8bb17f1de3fc2a325870683e2001c05");
		keyMap.put("01", "3FE24CA54D9287D3062FB5AAEF33F195");
		keyMap.put("02", "3FE24CA54D9287D3062FB5AAEF33F195");
		keyMap.put("03", "08D07B8D66B8D924141F8C27B7FFBBF4");
		keyMap.put("06", "38A5E46C349C729C86D5919778DDB451");
		//Map keyMap = getKeyMap(cardtype);
		List<String> res = new ArrayList<String>();
		try {
			cardNumber = cardNumber.substring(8);
			String operator = "";
//			if (user.getBytes("GBK").length > 12) {
//				operator = user.substring(0, 6);
//			} else {
//				operator = (user + "      ").substring(0, 6);
//			}
			Calendar cld = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat vsdf = new SimpleDateFormat("yyMMdd");
			String validDate = "";
			
			cardtype = "0" + cardtype;
			cardtype = cardtype.substring(cardtype.length() - 2, cardtype.length());
			List li = bc.genCard(cardNumber, customerName, operator, terminalNumber, block0str, cardtype,
					validDate, keyMap);
			res.add(null);
			res.add("00011003030306FFFFFFFFFFFFFFFFFF");
			res.add(null);
			res.add("A0A1A2A3A4A5" + HappyCard.getController() + HappyCard.getDefaultkey());
			for (int i = 0; i < li.size(); i++) {
				Sector sc = (Sector) li.get(i);
				res.add(sc.getBlock0Str());
				res.add(sc.getBlock1Str());
				res.add(sc.getBlock2Str());
				res.add(sc.getBlock3Str());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("开卡失败:" + e.getMessage());
		}
		System.out.println("----:"+res);
		return res;
	}
	
	
	public List<List<String>> doCharge(String user,String terminalNumber,String chargeAmount,String []blocks){
		try{
		HappyCard bc = new HappyCard();
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> sector = null;
		List<Sector> li = bc.genCharge(blocks,  user,terminalNumber, formatMoney(chargeAmount));
		res.add(null);
		for (int i = 0; i < li.size(); i++) {
			Sector sc = (Sector)li.get(i);
			if(sc!=null){
				sector = new ArrayList<String>();
				sector.add(sc.getBlock0Str());
				sector.add(sc.getBlock1Str());
				sector.add(sc.getBlock2Str());
				sector.add(sc.getBlock3Str());
			}else{
				sector = null;
			}
			res.add(sector);
		}
		System.out.println(res);
		return res;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	public String formatMoney(String amount){
		if(amount == null){
			return "00000000";
		}else{
			DecimalFormat formater = new DecimalFormat("00000000");
			BigDecimal d =  new BigDecimal(amount.toString()).multiply(BigDecimal.valueOf(100));
			return formater.format(d);
		}
	}
	
	public List<String> genKey(String cardNumber,int type,int[] sector,String cardtype){
		if(!StringUtil.hasText(cardNumber)){
			throw new RuntimeException("卡号不能为空");
		}
		List<String> res = new ArrayList<String>();
		
		try {

			//Map<String,String> keyMap = getKeyMap(cardtype);
			Map<String,String> keyMap = new HashMap<String,String>();
			keyMap.put("CVK", "b8bb17f1de3fc2a325870683e2001c05");
			keyMap.put("01", "3FE24CA54D9287D3062FB5AAEF33F195");
			keyMap.put("02", "3FE24CA54D9287D3062FB5AAEF33F195");
			keyMap.put("03", "08D07B8D66B8D924141F8C27B7FFBBF4");
			keyMap.put("06", "38A5E46C349C729C86D5919778DDB451");
			cardNumber = cardNumber.substring(8);
			for (int i = 0; i < sector.length; i++) {
				String mkey = "0"+sector[i];
				if(mkey.length()>2){
					mkey = mkey.substring(mkey.length()-2,mkey.length());
				}
				String r = DES.dataDistributed(Codec.hexEncode(cardNumber.getBytes()), keyMap.get(mkey));
				if(type==0){
					String keyA = r.substring(0,12);
					res.add(keyA);	
				}else{
					String keyB = r.substring(r.length()-12,r.length());
					res.add(keyB);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return res;
	}
	
	public List<List<String>> doResetCard(String cardNumber){
		try{
			HappyCard bc = new HappyCard();
			List<List<String>> res = new ArrayList<List<String>>();
			List<String> sector = null;
			List<Sector> li = bc.resetCard(cardNumber,null);
			List<String> tmpblck0=new ArrayList<String>();
			tmpblck0.add(null);
			tmpblck0.add(HappyCard.getDefaultval());
			tmpblck0.add(HappyCard.getDefaultval());
			tmpblck0.add(HappyCard.getDefaultkey()+HappyCard.getController()+HappyCard.getDefaultkey());
			res.add(tmpblck0);
			for (int i = 0; i < li.size(); i++) {
				Sector sc = (Sector)li.get(i);
				if(sc!=null){
					sector = new ArrayList<String>();
					sector.add(sc.getBlock0Str());
					sector.add(sc.getBlock1Str());
					sector.add(sc.getBlock2Str());
					sector.add(sc.getBlock3Str());
				}else{
					sector = null;
				}
				res.add(sector);
			}
			System.out.println(res);
			return res;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
