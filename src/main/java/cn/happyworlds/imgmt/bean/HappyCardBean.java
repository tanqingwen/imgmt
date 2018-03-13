package cn.happyworlds.imgmt.bean;

import java.util.List;
import java.util.Map;

import cn.happyworlds.imgmt.tools.happypass.Codec;
import cn.happyworlds.imgmt.util.DES;
import cn.happyworlds.imgmt.util.StringUtil;

import cn.happyworlds.imgmt.tools.happypass.HappyCardforActiveX;

public class HappyCardBean extends BaseSessionBean{

	/**
	 * @param cardNumber
	 * @param staffId
	 * @param block0str
	 *  
	 * @return
	 */
	public List<String> newCard1(String cardNumber,String staffId,String block0str,Map<String,String> keyMap){
		HappyCardforActiveX bcax = new HappyCardforActiveX();
		return bcax.openCard1(cardNumber,staffId,"00000001",  block0str,keyMap);
	}
	
	/**
	 * 
	 * 
	 * @param cardNumber		客户卡
	 * @param customerName		客户姓名
	 * @param block0str			扇区块号
	 * @param cardtype			卡类型
	 * @param birthday			生日
	 * @return
	 */
	public List<String> newCard(String cardNumber,String customerName,String block0str,String cardtype,String birthday){
		HappyCardforActiveX bcax = new HappyCardforActiveX();
		return bcax.openCard(cardNumber, customerName, user,"00000001", block0str, cardtype,birthday);
	}
	
	public List<List<String>> doCharge(String chargeAmount, String blocks[]){
		HappyCardforActiveX bcax = new HappyCardforActiveX();
		return bcax.doCharge(user,"00000001",chargeAmount, blocks);
	}
	
	public List<String> getKey(String cardNumber,int type,String cardtype){
		HappyCardforActiveX bcax = new HappyCardforActiveX();
		return bcax.genKey(cardNumber,type, new int[]{2,3,6},cardtype);
	}
	
	public String readBalance(String str,String block0,String cardno,String balance) throws Exception{
		Double cbalance = Double.valueOf(getBlockBalance(block0,cardno,str)); 
		//Double sbalance = Double.valueOf(getCardBalance(cardno));
		Double sbalance = Double.valueOf(balance);
		System.out.println(cardno +"卡片余额"+cbalance+" , 数据库余额"+sbalance);
		return cbalance > sbalance ? sbalance.toString() : cbalance.toString();
	}
	
	public String getBlockBalance(String block0,String cardNumber,String str)throws Exception{
		if(!StringUtil.hasText(str)){
			return "-1";
		}
		System.out.println("block"+block0);
		System.out.println(cardNumber);
		System.out.println(str);
		String checkmac = DES.mac(block0.substring(0,8)+cardNumber.substring(8), Codec.bcdDecode(str.substring(0,24)));
		checkmac = Codec.hexEncode(checkmac.substring(0,4).getBytes());
		if(str.substring(24,32).equals(checkmac)){
			String b = str.substring(0,8);
			return Double.toString(Double.valueOf(Integer.parseInt(b, 16)).doubleValue()/100d);
		}else{
			throw new Exception("卡片钱包校验不符");
		}
	}
	
	public List<List<String>> doReset(String cardNumber){
		HappyCardforActiveX bcax = new HappyCardforActiveX();
		return bcax.doResetCard(cardNumber);
	}
}
