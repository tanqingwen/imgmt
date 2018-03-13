package cn.happyworlds.imgmt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Created by Hugh on 2016/8/20.
 *
 */

public class SysDateFormat {

	public static String getNowDate(String strDateFormat) {
		if (strDateFormat == null)
			return "";
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(strDateFormat);
		java.util.Date currentTime = new java.util.Date();
		return formatter.format(currentTime).toString();
	}
	
	public static String getDateFormat(String time,String beforeDateFormat,String laterDateFormat) {
		try {
			if (time == null)
				return "";
			SimpleDateFormat beforedf = new SimpleDateFormat(beforeDateFormat);
			SimpleDateFormat laterdf = new SimpleDateFormat(laterDateFormat);
			Date date = new Date();
			date = beforedf.parse(time);
			time = laterdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return time;
	}
}
