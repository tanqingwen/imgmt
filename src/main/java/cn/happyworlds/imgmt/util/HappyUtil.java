package cn.happyworlds.imgmt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HappyUtil {
	
	public static int getAge(String birthday) throws ParseException{
		Calendar now = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		b.setTime(sdf.parse(birthday));
		now.add(Calendar.YEAR, -(b.get(Calendar.YEAR)));
		now.add(Calendar.MONTH, -(b.get(Calendar.MONTH)));
		now.add(Calendar.DATE, -(b.get(Calendar.DATE)));
		return now.get(Calendar.YEAR);
	}
	
	
	
}
