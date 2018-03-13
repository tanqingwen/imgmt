package cn.happyworlds.imgmt.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 

public class LastCalendar {

	/**
	 * @param args
	 */ 
	public static int year = 0;
	public static int month = 0;
	public static int day = 0;
	public static String years = "";
	public static String months = "";
	public static String days = "";
	public static boolean flag = false;

	public static String getLastDay(String datestr) {
	String dateString = null;
	year = Integer.valueOf(datestr.substring(0, 4));
	month = Integer.valueOf(datestr.substring(4, 6));
	day = Integer.valueOf(datestr.substring(6, 8));
	day = day - 1;
	if (day == 0) {
	month = month - 1;
	if (month == 0) {
	year = year - 1;
	}
	}
	if (month == 0) {
	month = 12;
	}
	if (day == 0) {
	day = getDayByMonth(year, month);
	} 
	years=String.valueOf(year).length()<4?"0"+String.valueOf(year):String.valueOf(year);
	years=String.valueOf(year).length()<3?"00"+String.valueOf(year):String.valueOf(year);
	years=String.valueOf(year).length()<2?"000"+String.valueOf(year):String.valueOf(year);
	months=String.valueOf(month).length()<2?"0"+String.valueOf(month):String.valueOf(month);
	days=String.valueOf(day).length()<2?"0"+String.valueOf(day):String.valueOf(day);
	dateString = years +""+ months +""+ days;
	return dateString;
	}
	
	public static boolean isLeapYear(int year) {
	flag = false;
	if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
	flag = true;
	}
	return flag;
	}

	public static int getDayByMonth(int year, int month) {
	int day = 0;
	int[] daybymonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	if (month == 2) {
	if (isLeapYear(year)) {
	day = 29;
	} else {
	day = 28;
	}
	} else {
	day = daybymonth[month - 1];
	}
	return day;

	}


	/** 
	* 获得指定日期的后一天 
	* @param specifiedDay 
	* @return 
	*/ 
	public static String getSpecifiedDayAfter(String specifiedDay){ 
	Calendar c = Calendar.getInstance(); 
	Date date=null; 
	try { 
	date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay); 
	} catch (Exception e) { 
	e.printStackTrace(); 
	} 
	c.setTime(date); 
	int day=c.get(Calendar.DATE); 
	c.set(Calendar.DATE,day+1); 

	String dayAfter=new SimpleDateFormat("yyyyMMdd").format(c.getTime()); 
	return dayAfter; 
	} 
	
	
	/** 
	* 获得指定日期的  前/后 num天   num为负数向前递减  反之
	* @param specifiedDay 
	* @param num 
	* @return 
	*/ 
	public static String getSpecifiedDayAfterBynum(String specifiedDay,int num){ 
	Calendar c = Calendar.getInstance(); 
	Date date=null; 
	try { 
		date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay); 
	} catch (Exception e) { 
	e.printStackTrace(); 
	} 
	c.setTime(date); 
	int day=c.get(Calendar.DATE); 
	c.set(Calendar.DATE,day+num); 
	String dayAfter=new SimpleDateFormat("yyyyMMdd").format(c.getTime()); 
	return dayAfter; 
	} 

	//public static void main(String[] args) {
	//	System.out.println(getSpecifiedDayAfterBynum("20161029",-1));
	//}
}
