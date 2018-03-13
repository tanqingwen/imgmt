package cn.happyworlds.imgmt.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.function.Pair;

public class StringUtil

{

	/* Jason Add 20060725 */
	public static String trimDoubleQoute(String inStr) {
		if (inStr.startsWith("\"") && inStr.endsWith("\"")) {
			return inStr.substring(1, inStr.length() - 1);
		} else {
			return inStr;
		}
	}

	/**
	 * 
	 * e.g. getPadLeft("123", 5, '0')
	 * 
	 * result = "00123"
	 */

	public static String getPadLeft(String msg, int size, char padChar)

	{


		StringBuffer buf = getInitializedString(padChar, size);

		msg = chkNull(checkMsg(msg, size));

		int strLength = msg.length();

		int startIndex = size - strLength;

		buf.replace(startIndex, size, msg);

		return buf.toString();

	}

	private static StringBuffer getInitializedString(char theChar, int size)

	{

		StringBuffer buf = new StringBuffer();

		buf.setLength(size);

		for (int i = 0; i < buf.length(); i++)

		{

			buf.setCharAt(i, theChar);

		}

		return buf;

	}

	/**
	 * 
	 * e.g. getPadRight("123", 5, '0')
	 * 
	 * result = "12300"
	 */

	public static String getPadRight(String msg, int size, char padChar) {

		// System.out.println("msg : " + msg);

		StringBuffer buf = getInitializedString(padChar, size);

		msg = chkNull(checkMsg(msg, size));

		int strLength = msg.length();

		buf.replace(0, strLength, msg);

		return buf.toString();

	}

	public static String checkMsg(String msg, int size)

	{

		StringBuffer sbuf = new StringBuffer(msg);

		if (sbuf.length() > size)

		{

			try

			{

				int bal = sbuf.length() - size;

				return sbuf.substring(0, size);

			}

			catch (Exception ex)

			{

				ex.printStackTrace();

			}

		}

		return msg;

	}

	public static String chkNull(String msg)

	{

		if (msg == null)
			return "";

		return msg;

	}

	public static Integer chkNull(Integer msg)

	{

		if (msg == null)
			return new Integer("0");

		return msg;

	}

	public static BigDecimal chkNull(BigDecimal msg)

	{

		if (msg == null)

		{

			return new BigDecimal("0");

		}

		return msg;

	}

	public static String chkNullNumber(String msg)

	{

		if (msg == null)

		{

			return "0";

		}

		else if (msg.trim().equals(""))

		{

			return "0";

		}

		return msg;

	}

	public static BigDecimal chkNullNumber(BigDecimal msg)

	{

		if (msg == null)

		{

			return new BigDecimal("0");

		}

		return msg;

	}

	/**
	 * 
	 * takes a string and generate a checkdigit
	 */

	public static int generateCheckDigit(String toCheck)

	{

		long sum = 0;

		byte[] theByte = toCheck.getBytes();

		for (int i = 0; i < theByte.length; i++)

		{

			sum = sum + theByte[i];

		}

		String theSum = (new Long(sum)).toString();

		int startIndex = (theSum.length()) - 2;

		return Integer.parseInt(theSum.substring(startIndex));

	}

	/**
	 * 
	 * validates a check digit based on the string passed in, the checkdigit
	 */

	public static boolean isValidCheckDigit(String theStr, int checkDigit) {

		int generatedCheckDigit = generateCheckDigit(theStr);

		if (checkDigit == generatedCheckDigit) {

			return true;

		}

		return false;

	}

	/**
	 * 
	 * assumes that the last 2 digits in the string is the check digit
	 * 
	 * and perform validation of check digit on that
	 */

	public static boolean isValidCheckDigit(String theStr) {

		String contentString = theStr.substring(0, theStr.length() - 2);

		String theCheckDigit = theStr.substring(theStr.length() - 2);

		return isValidCheckDigit(contentString, Integer.parseInt(theCheckDigit));

	}

	public static String checkValue(double thisValue)

	{

		if (thisValue == 0.0)

		{

			return "";

		}

		else

		{

			return new Double(thisValue).toString();

		}

	}

	public static String checkValue(float thisValue)

	{

		if (thisValue == 0.0)

		{

			return "";

		}

		else

		{

			return new Float(thisValue).toString();

		}

	}

	public static String checkValue(int thisValue)

	{

		if (thisValue == 0)

		{

			return "";

		}

		else

		{

			return new Integer(thisValue).toString();

		}

	}

	public static String checkValue(String thisValue)

	{

		if (thisValue == null || thisValue == "0")

		{

			return "";

		}

		else

		{

			return thisValue.trim();

		}

	}

	public static String checkValue(BigDecimal thisValue)

	{

		String str = "";

		if (thisValue != null
				&& (thisValue.equals(new java.math.BigDecimal(0)) || "0"
						.equals(thisValue.toString())))

		{

			return "";

		}

		else

		{

			str = thisValue.toString();

			return str;

		}

	}

	public static String formatCardNo(String cardNo) {

		String cardNo1 = cardNo.substring(0, 4);

		String cardNo2 = cardNo.substring(4, 8);

		String cardNo3 = cardNo.substring(8, 12);

		String cardNo4 = cardNo.substring(12, 16);

		return cardNo1 + " " + cardNo2 + " " + cardNo3 + " " + cardNo4;

	}

	public static String formatDisplayAmount(String amount, int currExpo) {

		String formatted = null;

		int temp = amount.indexOf(".") + currExpo + 1;

		formatted = amount.substring(0, temp);

		return formatted;

	}

	public static String checkNull(String msg)

	{

		if (msg == null)
			return "";

		return msg;

	}

	public static String checkNull(BigDecimal msg)

	{

		if (msg == null)

		{

			return "";

		}

		return msg.toString();

	}

	public static String checlNull(String msg)

	{

		if (msg == null)
			return "";

		return msg;

	}
	
	public static String checkNull(Object msg)

	{

		if (msg == null)
			return "";

		return msg.toString();

	}
		

	public static String checkNullValue(BigDecimal msg)

	{

		if (msg == null)

		{

			return "";

		}

		return msg.toString();

	}

	public static String checkNullValue(String msg)

	{

		if (msg == null)
			return "";

		return msg;

	}

	public static String convertListToString(List list, String sDelimiter,
			String sQuote) {
		if (list == null || list.size() == 0)
			return "";
		if (sDelimiter == null || sDelimiter.equals(""))
			sDelimiter = " ";
		Iterator ite = list.iterator();
		StringBuffer buffer = new StringBuffer();
		while (ite.hasNext()) {
			Object content = ite.next();
			String sElement = content.toString();
			if (content instanceof Pair)
				sElement = ((Pair) content).getKey().toString();
			if (sQuote != null && !sQuote.equals(""))
				buffer.append(sQuote);
			buffer.append(sElement);
			if (sQuote != null && !sQuote.equals(""))
				buffer.append(sQuote);
			buffer.append(sDelimiter);
		}
		String sReturn = buffer.toString();
		if (sReturn.endsWith(sDelimiter))
			sReturn = sReturn.substring(0, sReturn.lastIndexOf(sDelimiter));
		return sReturn;
	}

	public static Vector splitStr(String str, String ch) {
		int strLen = 0;
		Vector strVector = new Vector();
		try {
			if (str != null) {
				strLen = str.length();
			}
			while (strLen > 0) {
				int ch_pos = str.indexOf(ch);
				if (ch_pos == -1) {
					strVector.addElement(str);
					break;
				} else {
					strVector.addElement(str.substring(0, ch_pos));
					str = str.substring(ch_pos + 1, strLen);
					strLen = str.length();
				}
			}
		} catch (Exception e) {
			System.out.println("splitStr error " + e.getMessage());
		}
		return strVector;
	}// end splitStr()

	public static final String replace(String content, String oldString,
			String newString) {
		if (content.equals("")) {
			return "";
		}
		int i = 0;
		if ((i = content.indexOf(oldString, i)) >= 0) {
			char[] line2 = content.toCharArray(); // �ַ��������
			char[] newString2 = newString.toCharArray(); // Ҫ�滻���ַ�
			int oLength = oldString.length(); // ���滻���ַ�ĳ���
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = content.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			content = buf.toString();
		}
		return content;
	}

	/**
	 * 将用指定符号分隔的数据解析为List
	 * 
	 * @param _str
	 *            需要拆分的字符串
	 * @param _dot
	 *            分隔符
	 * @return List
	 */
	public static List convertStringToList(String _str, String _dot) {
		if (_str == null)
			return null;
		StringTokenizer st = new StringTokenizer(_str, _dot);

		List result = new ArrayList();

		while (st.hasMoreTokens()) {
			result.add(st.nextToken());
		}
		return result;
	}

	public static String getDecimalFormat(String str) {
		// DecimalFormat fmt = new DecimalFormat("##,###,###,###,##0.00000");
		// 000000000100
		DecimalFormat fmt = new DecimalFormat("0.00");
		String outStr = null;
		double d;
		try {
			d = Double.parseDouble(str);
			outStr = fmt.format(d);
		} catch (Exception e) {
		}
		return outStr;
	}
	
	public static String leftContact(String str, int length, char prefix) {
		if (str == null) {
			str = "";
		}
		if (str.indexOf(".") != -1) {
			str = str.replaceAll("\\.", "");
		}

		int strLen = str.length();
		if (strLen > length) {
			str = str.substring(strLen - length);
		}
		for (int i = 0; i < length - strLen; i++) {
			str = prefix + str;
		}
		return str;
	}
	public static boolean hasText(Object str){
		if(str == null){
			return false;
		}else{
			return StringUtils.hasText(str.toString());	
		}
	}
	public static String buildFixedLengthString(String str,int length){
    	int len = str.length();
    	StringBuffer sb = new StringBuffer(str);
    	for(int i=len;i<length;i++){
    		sb.append(" ");
    	}
    	return sb.toString();
    }
}
