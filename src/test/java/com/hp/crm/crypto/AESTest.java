package com.hp.crm.crypto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import cn.happyworlds.imgmt.codec.HexCodec;
import cn.happyworlds.imgmt.crypto.AES;
import cn.happyworlds.imgmt.json.Jackson;

public class AESTest {

//	@Test
	public void testEncrypt() {
//		String authToken = "ca51468631c0c48ef559be8384ea14d6";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("imageType", "avatar");
//		String data = Jackson.writeJson(params);
//		// 加密
//		byte[] encrypted = AES.encrypt(data.getBytes(), HexCodec.hexDecode(authToken));
//		System.out.println(Hex.encodeHexString(encrypted));
//		System.out.println(Base64.encodeBase64String(encrypted));
//		// 解密
//		byte[] decrypted = AES.decrypt(encrypted, HexCodec.hexDecode(authToken));
//		System.out.println(new String(decrypted));
	}
	public static void main(String[] args) {
		String identity = "130625198801161636";
		System.out.println("birthday:" + identity.substring(6, 14));
	}
}
