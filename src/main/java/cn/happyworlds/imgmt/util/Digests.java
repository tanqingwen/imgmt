package cn.happyworlds.imgmt.util;

import org.springframework.util.DigestUtils;

/**
 * Created by jia on 2015/7/25.
 */
public class Digests extends DigestUtils {

    public static String md5DigestAsHex(String string) {
        return md5DigestAsHex(string.getBytes());
    }
}
