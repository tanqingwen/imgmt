package cn.happyworlds.imgmt.util;


public class Bitwises {
	
	public static byte[] xor(byte[] a1, byte[] a2){
		if(a1.length != a2.length){
			return null;
		}
		return xor(a1, a2, a1.length);
	}

	public static byte[] xor(byte[] a1, byte[] a2, int stepSize){
		byte[] result = new byte[stepSize];
		for(int i=0; i<stepSize; i++){
			result[i] = (byte)(a1[i] ^ a2[i]);
		}
		return result;
	}
	
	
}
