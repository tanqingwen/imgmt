package cn.happyworlds.imgmt.util;

public class Filenames {

	public static String suffix(String fileName) {
		int idx = fileName.lastIndexOf(".");
		return fileName.substring(idx + 1);
	}
}
