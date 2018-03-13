package cn.happyworlds.imgmt.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

public class PBE {

    public static final String ALGORITHM = "PBEWITHMD5andDES";
    public static final int ITERATION_COUNT = 100;

    private PBE() {
    }

    /**
     * 初始盐<br/>
     * 盐的长度必须为8位
     *
     * @return byte[] 盐
     * @throws Exception
     */
    public static byte[] initSalt() {
        try {
            // 实例化安全随机数
            SecureRandom random = new SecureRandom();
            // 产出盐
            return random.generateSeed(8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密
     *
     * @param data     待加密数据
     * @param password 密钥
     * @param salt     盐
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String password, byte[] salt) {
        try {
            // 转换密钥
            Key key = parseKey(password);
            // 实例化PBE参数材料
            PBEParameterSpec paramSpec = new PBEParameterSpec(salt,
                    ITERATION_COUNT);
            // 实例化
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            // 执行操作
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     *
     * @param data     待机密数据
     * @param password 密钥
     * @param salt     盐
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String password, byte[] salt) {
        try {
            // 转换密钥
            Key key = parseKey(password);
            // 实例化PBE参数材料
            PBEParameterSpec paramSpec = new PBEParameterSpec(salt,
                    ITERATION_COUNT);
            // 实例化
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            // 执行操作
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 转换密钥
     *
     * @param password 密码
     * @return Key 密钥
     */
    private static Key parseKey(String password) {
        try {
            // 密钥材料
            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
            // 实例化
            SecretKeyFactory keyFactory = SecretKeyFactory
                    .getInstance(ALGORITHM);
            // 生成密钥
            return keyFactory.generateSecret(keySpec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
