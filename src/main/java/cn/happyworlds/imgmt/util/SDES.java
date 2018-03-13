package cn.happyworlds.imgmt.util;

import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class SDES {

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String key, String data) {
		Hex hex = new Hex();
		try {
			byte[] bt = encrypt(hex.decode(key.getBytes()), hex.decode(data.getBytes()));
			return new String(Hex.encodeHex(bt, false));
		} catch (DecoderException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static String decrypt(String key, String data) {
		Hex hex = new Hex();
		try {
			byte[] bt = decrypt(hex.decode(key.getBytes()), hex.decode(data.getBytes()));
			return new String(Hex.encodeHex(bt, false));
		} catch (DecoderException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] key, byte[] data) {
		return des(key, data, Cipher.ENCRYPT_MODE);
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] key, byte[] data) {
		return des(key, data, Cipher.DECRYPT_MODE);
	}
	
	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static byte[] des(byte[] key, byte[] data, int mode) {
		try {
			// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(new DESKeySpec(key));
			// Cipher对象实际完成解密操作
			Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
			// 用密钥初始化Cipher对象
			cipher.init(mode, securekey, new SecureRandom());
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
