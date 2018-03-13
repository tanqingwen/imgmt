package cn.happyworlds.imgmt.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.happyworlds.imgmt.codec.HexCodec;

public class CUPS {
	
	public static final String CUPS_ENCODING = "GBK";
	public static final int CUPSENC = 1;
	public static final int ZHENC = 2;
	
	private static final Logger LOG = LoggerFactory.getLogger(CUPS.class);
	
	public static String calcMac(String mak, byte[] data){
		//做异或
		byte[] b1 = xor(data, 8);
		//转16进制
		String h1 = HexCodec.hexEncode(b1);
		//取前8个字节用MAK加密
		String r1 = DES.DES_1(DES.ASC_2_HEX(h1.substring(0,8)), mak, 0);
		//加密后的结果与后8个字节异或
		byte[] b2 = Bitwises.xor(HexCodec.hexDecode(r1), h1.substring(8).getBytes());
		//将异或后的结果再用MAK加密
		String r2 = DES.DES_1(HexCodec.hexEncode(b2), mak, 0);
		//将加密后的结果转换成16进制取前8个字节作为MAC值
		return r2.substring(0, 8);
	}
	
	public static byte[] xor(byte[] bytes, int stepSize){
		try {
			int modulo = bytes.length % stepSize;
			if(modulo > 0){
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				bout.write(bytes);
				for(int i=0; i<modulo; i++){
					bout.write(0X00);
				}
				bytes = bout.toByteArray();
			}
			int loopCount = bytes.length / stepSize;
			ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
			byte[] a1 = new byte[stepSize];
			byte[] a2 = new byte[stepSize];
			bin.read(a1);
			for(int j=0; j<loopCount; j++){
				bin.read(a2);
				LOG.debug("{} ^ {}", format(a1), format(a2));
				a1 = Bitwises.xor(a1, a2, stepSize);
				a2 = new byte[stepSize];
			}
			LOG.debug(format(a1));
			return a1;
		} catch (IOException e) {
			return null;
		}
	}
	
	private static String format(byte[] a1){
		return String.format("[%02X,%02X,%02X,%02X,%02X,%02X,%02X,%02X]", a1[0], a1[1], a1[2], a1[3], a1[4], a1[5], a1[6], a1[7]);
	}
	
	public static String  fillFormat(String oldchar,String fillchar,int pos,int len){
		
		StringBuffer sb = new StringBuffer();
		sb.delete(0, sb.length());
			
		if(null==oldchar){
			return null;
		}
		
		if(null==fillchar){
			fillchar=" ";
		}
		
		if(oldchar.length()>len || oldchar.length()==len){
			return oldchar;
		}
		
		for(int i=0;i<len-oldchar.length();i++){
			sb.append(fillchar);
		}
		String tmp=sb.toString();
		if(fillchar.length()>1){
			tmp=sb.toString().substring(0, len-oldchar.length());
		}
	
		if(pos==0){		
			oldchar=oldchar+tmp;	
		}else{
			oldchar=tmp+oldchar;	
		}
		
		return oldchar;	
	}
	
	
	// add by huof
	
	public static String calcHexLength(String str){
		if(str == null){
			return "00";
		}
		int intLen = str.trim().length()/2;
		String strLen = Integer.toHexString(intLen);
		if(intLen>128){
			return "81"+strLen;
		}else if(intLen>256){
			return "82"+strLen;
		}
		return fillFormat(strLen, "0", -1, 2);
	}
}
