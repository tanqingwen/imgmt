package cn.happyworlds.imgmt.util;

import org.springframework.util.ObjectUtils;

public class Objects extends ObjectUtils {

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}
