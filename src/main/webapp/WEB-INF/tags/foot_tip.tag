<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${not empty __ACTION_SUCCESS_TIP__ }">
		<script type="text/javascript">
			alert("${__ACTION_SUCCESS_TIP__ }");
		</script>
	</c:when>
	
	<c:when test="${not empty __ACTION_FAILURE_TIP__ }">
		<script type="text/javascript">
			alert("${__ACTION_FAILURE_TIP__ }");
		</script>
	</c:when>
</c:choose>