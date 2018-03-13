package cn.happyworlds.imgmt.tools.happypass;

public class Codec {
	
	private static final char[] HEX = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String hexEncode(int integer){
		return hexEncode(new byte[]{(byte)integer});
	}
	
	public static String hexEncode(byte[] buffer){
		if(buffer==null){
			return "";
		}
		return hexEncode(buffer, 0, buffer.length);
	}
	
	public static String hexEncode(byte[] buffer, int start, int length) {
		if (buffer == null || buffer.length == 0) {
			return "";
		}
		int holder = 0;
		char[] chars = new char[length * 2];
        int pos = -1;
		for (int i = start; i < start+length; i++) {
			holder = (buffer[i] & 0xf0) >> 4;
			chars[++pos * 2] = HEX[holder];
			holder = buffer[i] & 0x0f;
			chars[(pos * 2) + 1] = HEX[holder];
		}
		return new String(chars);
	}

	public static byte[] hexDecode(String hex) {
		//A null string returns an empty array
		if (hex == null || hex.length() == 0) {
			return new byte[0];
		} else if (hex.length() < 3) {
			return new byte[]{ (byte)(Integer.parseInt(hex, 16) & 0xff) };
		}
		//Adjust accordingly for odd-length strings
		int count = hex.length();
		int nibble = 0;
		if (count % 2 != 0) {
			count++;
			nibble = 1;
		}
		byte[] buf = new byte[count / 2];
		char c = 0;
		int holder = 0;
		int pos = 0;
		for (int i = 0; i < buf.length; i++) {
		    for (int z = 0; z < 2 && pos<hex.length(); z++) {
		        c = hex.charAt(pos++);
		        if (c >= 'A' && c <= 'F') {
		            c -= 55;
		        } else if (c >= '0' && c <= '9') {
		            c -= 48;
		        } else if (c >= 'a' && c <= 'f') {
		            c -= 87;
		        }
		        if (nibble == 0) {
		            holder = c << 4;
		        } else {
		            holder |= c;
		            buf[i] = (byte)holder;
		        }
		        nibble = 1 - nibble;
		    }
		}
		return buf;
	}
	
	public static byte[] bcdDecode(String str) {
		return bcdDecode(str, str.length());
	}

	public static byte[] bcdDecode(String str, int numlen) {
		if (numlen % 2 != 0)
			numlen++;

		while (str.length() < numlen) {
			str = "0" + str;
		}

		byte[] bStr = new byte[str.length() / 2];
		char[] cs = str.toCharArray();
		int i = 0;
		int iNum = 0;
		for (i = 0; i < cs.length; i += 2) {

			int iTemp = 0;
			if (cs[i] >= '0' && cs[i] <= '9') {
				iTemp = (cs[i] - '0') << 4;
			} else {
				
				if (cs[i] >= 'a' && cs[i] <= 'f') {
					cs[i] -= 32;
				}
				iTemp = (cs[i] - '0' - 7) << 4;
			}
			// 
			if (cs[i + 1] >= '0' && cs[i + 1] <= '9') {
				iTemp += cs[i + 1] - '0';
			} else {
				// 
				if (cs[i + 1] >= 'a' && cs[i + 1] <= 'f') {
					cs[i + 1] -= 32;
				}
				iTemp += cs[i + 1] - '0' - 7;
			}
			bStr[iNum] = (byte) iTemp;
			iNum++;
		}
		return bStr;

	}

	public static String bcdEncode(byte[] bcdNum, int offset, int numlen) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < numlen; i++) {
			buf.append(Integer.toHexString((bcdNum[i + offset] & 0xf0) >> 4));
			buf.append(Integer.toHexString(bcdNum[i + offset] & 0xf));
		}
		return buf.toString();
	}
	public static String int2hex (int i){
		String r = Integer.toHexString(i);
		if(r.length()%2!=0){
			return "0"+r;
		}else {
			return r;
		}
	}
	public static int hex2int(String str){
		return Integer.parseInt(str, 16);
	}
	public static String num2hex (String num){
		String r = Long.toHexString(Long.valueOf(num));
		if(r.length()%2!=0){
			return "0"+r;
		}else {
			return r;
		}
	}

}
