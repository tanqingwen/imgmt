<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="true"%>
<%@ attribute name="patten" type="java.lang.String" required="true"%>
<%
	if (value == null || value.length() == 0) {
		out.write("");
	} else {
		StringBuilder buf = new StringBuilder();
		char[] valueChars = value.toCharArray();
		char[] pattenChars = patten.toCharArray();
		int pos = 0;
		for (char pc : pattenChars) {
			if (pos > valueChars.length) {
				buf.append(patten.substring(pos));
			}
			if (pc == '#') {
				buf.append(valueChars[pos]);
				pos++;
			} else {
				buf.append(pc);
			}
		}
		out.write(buf.toString());
	}
%>
