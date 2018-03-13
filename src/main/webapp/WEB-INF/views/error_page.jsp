<%@ page contentType="text/html;charset=UTF-8" language="java"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>综合管理系统 | 500错误</title>
	<tags:head_common_content />
</head>
<body style="padding: 0 20px;">
	<h1>服务器错误</h1>
	<ul>
		<li>错误: ${error}</li>
		<li>装态: ${status}</li>
		<li>时间: ${timestamp}</li>
		<li>信息: ${message}</li>
	</ul>
</body>
</html>
