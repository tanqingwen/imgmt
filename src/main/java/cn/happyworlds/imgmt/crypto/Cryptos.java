package cn.happyworlds.imgmt.crypto;

import org.springframework.util.Base64Utils;

public class Cryptos {

    private Cryptos() {
    }

    private static byte[] decode(final String key) {
        return Base64Utils.decodeFromString(key);
    }

    private static String encode(final byte[] bytes) {
        return Base64Utils.encodeToString(bytes);
    }

    public static String generateAesKey() {
        return encode(AES.initSecretKey());
    }

    public static String aesEncrypt(final String key, final String... args) {
        byte[] keyBytes = decode(key);
        StringBuffer plaintext = new StringBuffer(args[0]);
        for (int i = 1; i < args.length; i++) {
            plaintext.append("|").append(args[i]);
        }
        byte[] ciphertext = AES.encrypt(plaintext.toString().getBytes(), keyBytes);
        return encode(ciphertext);
    }

    public static String aesDecrypt(final String key, final String ciphertext) {
        byte[] keyBytes = decode(key);
        byte[] cipherBytes = decode(ciphertext);
        byte[] plaintext = AES.decrypt(cipherBytes, keyBytes);
        return new String(plaintext);
    }

    public static String generatePbeSalt() {
        return encode(PBE.initSalt()).substring(0, 8);
    }

    public static String pbeEncrypt(final String password, final String salt,
                                    final String... args) {
        StringBuffer plaintext = new StringBuffer(args[0]);
        for (int i = 1; i < args.length; i++) {
            plaintext.append("|").append(args[i]);
        }
        byte[] ciphertext = PBE.encrypt(plaintext.toString().getBytes(),
                password, salt.getBytes());
        return encode(ciphertext);
    }

    public static String pbeDecrypt(final String password, final String salt,
                                    final String ciphertext) {
        byte[] plaintext = PBE.decrypt(decode(ciphertext), password,
                salt.getBytes());
        return new String(plaintext);
    }

}
