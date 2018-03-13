package cn.happyworlds.imgmt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Created by jia on 2015/7/25.
 */
public class DateTimes {

	public static final String TIMESTAMP_PATTERN = "yyyyMMddHHmmssSSS";
	public static final String DATE_PATTERN = "yyyyMMdd";
	public static final String TIME_PATTERN = "HHmmss";
	public static final String TIME_STYLE = "yyyyMMdd HHmmss";
	public static final String TIME_STYLE2 = "yyyyMMdd HHmmss";
	public static final String TIMESTR = "yyyyMMddHHmmssSSS";
	public static final String DATE_PATTERN2 = "yyyy-MM-dd";
	public static final String[] DATE_PATTERN_ARY = new String[]{TIMESTAMP_PATTERN,
			DATE_PATTERN,
    		DATE_PATTERN2};

	public static final String getDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_STYLE);
		return sdf.format(date);
	}

	public static final String getTimeStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTR);
		return sdf.format(date);
	}

	public static final String timestamp(LocalDateTime dateTime) {
		return dateTime.format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN));
	}

	public static final String nowTimestamp() {
		return timestamp(LocalDateTime.now());
	}

	public static final String date(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
	}
	
	public static final String nowDateTime(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(TIME_STYLE));
	}
	
	public static final String nowDateTime() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern(TIME_STYLE));
	}

	public static final String nowDate() {
		return date(LocalDate.now());
	}

	public static final String time(LocalTime time) {
		return time.format(DateTimeFormatter.ofPattern(TIME_PATTERN));
	}

	public static final String nowTime() {
		return time(LocalTime.now());
	}

	public static final Date localDateToDate(LocalDate localDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(localDate.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static final String newDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
		return sdf.format(new Date());
	}

	public static int getAge(Date birthDate) {

		if (birthDate == null)
			throw new RuntimeException("出生日期不能为null");

		int age = 0;

		Date now = new Date();

		SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
		SimpleDateFormat format_M = new SimpleDateFormat("MM");

		String birth_year = format_y.format(birthDate);
		String this_year = format_y.format(now);

		String birth_month = format_M.format(birthDate);
		String this_month = format_M.format(now);

		// 初步，估算
		age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);

		// 如果未到出生月份，则age - 1
		if (this_month.compareTo(birth_month) < 0)
			age -= 1;
		if (age < 0)
			age = 0;
		return age;
	}
	public static final Date parse(String dateStr, String[] pattern) {
		try {
			return DateUtils.parseDateStrictly(dateStr, pattern);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
    }
	public static final String format(String dateStr, String pattern){
    	return DateFormatUtils.format(parse(dateStr, DATE_PATTERN_ARY), pattern);
    }
}
