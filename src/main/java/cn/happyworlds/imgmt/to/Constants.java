/**
 * 
 */
package cn.happyworlds.imgmt.to;

/**
 * @author
 *
 */
public class Constants {

	/**
	 * 
	 */
	public Constants() {
		super();
	}

	public static final String UTPServiceName_MailinhTaxi="Mailinh";
	public static final String UTPServiceName_Manulife ="Manulife";
	public static final String UTPBatchRegTxnCode="11111111";
	public static final String PageCharset="gb2312";
	public static final String DBCharset="GBK";
	
	public static final String UTPBatchRegTxnCode_PRD="1111";
	
	public static final String ENDCMDSTR_PRD="11111111111111111111";
	
	public static final String JOINTLY_CARD_YES = "1";
	public static final String JOINTLY_CARD_NO = "0";	
	
	
	public static final int NET_TRANS_TYPE_NET_PAY = 1; 
	public static final int NET_TRANS_TYPE_NET_CHARGE = 2;	
	public static final int NET_TRANS_TYPE_CARD2CARD = 3;
	
	public static final String MERCHANT_UNSPAY = "999999999999998"; 
	public static final String MERCHANT_UNCARD = "999999999999999"; 
	
	//public static final String baseBIN ="35010001"; //卡号前缀
	public static final String baseBIN ="333502"; //卡号前缀
	public static final String serialBIN ="HWCARD"; //卡流水号前缀
	public static final Integer MAX_SERIALNO =99999999;
	
}
