<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${not empty __ACTION_SUCCESS_TIP__ }">
		<div class="alert alert-success" role="alert">
			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
			<span class="sr-only">提示:</span>
			<span>${__ACTION_SUCCESS_TIP__ }</span>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:when>
	<c:when test="${not empty __ACTION_FAILURE_TIP__ }">
		<div class="alert alert-danger clearfix" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">提示:</span>
			<span>${__ACTION_FAILURE_TIP__ }</span>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:when>
</c:choose>