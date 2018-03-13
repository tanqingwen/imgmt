<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>综合管理系统 | 登录参数更新</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="option" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>登录参数更新</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">系统管理</a></li>
					<li><a href="#">登录参数</a></li>
					<li class="active">登录参数更新</li>
				</ol>
			</section>
	
		<div class="container-fluid common logonParameter">
			<div class="row">
				<div class="tip-img">
					<p>登录参数更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">参数表单</h3>
						<form class="form-inline form-horizontal" id="updateForm" method="post" action="${item }/option/login_config_update">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>口令是否会过期:</label>
										<select id="passwdExpire" name="LOGIN_CONFIG.passwdExpire" class="line-input" >
											<option value="true" ${loginOptions.passwdExpire eq 'true' ? 'selected':''}>永不过期</option>
											<option value="false" ${loginOptions.passwdExpire eq 'false' ? 'selected':''}>周期过期</option>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>首次登陆口令更改:</label>
										<select id="firstLoginResetPasswd" name="LOGIN_CONFIG.firstResetPasswd" class="line-input" >
											<option value="true" ${loginOptions.firstResetPasswd eq 'true' ? 'selected':''}>强制更改</option>
											<option value="false" ${loginOptions.firstResetPasswd eq 'false' ? 'selected':''}>不需要</option>
										</select>
									</div>
								</div>
							</div>

							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>允许尝试失败的次数:</label>
										<select id="allowPasswdErrorCount" name="LOGIN_CONFIG.allowPasswdErrorCount" class="line-input" >
												<option value="3" ${loginOptions.allowPasswdErrorCount eq '3' ? 'selected':''}>三次</option>
												<option value="4" ${loginOptions.allowPasswdErrorCount eq '4' ? 'selected':''}>四次</option>
												<option value="5" ${loginOptions.allowPasswdErrorCount eq '5' ? 'selected':''}>五次</option>
												<option value="6" ${loginOptions.allowPasswdErrorCount eq '6' ? 'selected':''}>六次</option>
												<option value="7" ${loginOptions.allowPasswdErrorCount eq '7' ? 'selected':''}>七次</option>
												<option value="8" ${loginOptions.allowPasswdErrorCount eq '8' ? 'selected':''}>八次</option>
												<option value="9" ${loginOptions.allowPasswdErrorCount eq '9' ? 'selected':''}>九次</option>
												<option value="10" ${loginOptions.allowPasswdErrorCount eq '10' ? 'selected':''}>十次</option>	
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>口令过期周期:</label>
										<select id="passwdExpireDays" name="LOGIN_CONFIG.passwdExpireDays" class="line-input" >
											<option value="week" ${loginOptions.passwdExpireDays eq 'week' ? 'selected':''}>一周</option>
											<option value="month" ${loginOptions.passwdExpireDays eq 'month' ? 'selected':''}>一月</option>
											<option value="year" ${loginOptions.passwdExpireDays eq 'year' ? 'selected':''}>一年</option>
										</select>
									</div>
								</div>
							</div>

							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>口令最大长度:</label>
										<input class="form-control line-input" type="text" id="passwdMaxSize" name="LOGIN_CONFIG.passwdMaxSize" value="${loginOptions.passwdMaxSize }"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>口令最大小度:</label>
										<input class="form-control line-input" type="text" id="passwdMinSize" name="LOGIN_CONFIG.passwdMinSize" value="${loginOptions.passwdMinSize }"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>口令历史循环数:</label>
										<input class="form-control line-input" type="text" id="passwdLoopCount" name="LOGIN_CONFIG.passwdLoopCount" value="${loginOptions.passwdLoopCount }"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>是否强制复杂口令:</label>
										<select id="forceComplexPasswd" name="LOGIN_CONFIG.forceComplexPasswd" class="line-input">
											<option value="true" ${loginOptions.forceComplexPasswd eq 'true' ? 'selected':''}>是</option>
											<option value="false" ${loginOptions.forceComplexPasswd eq 'false' ? 'selected':''}>否</option>
										</select>

									</div>
								</div>
							</div>
							<div class="col-lg-12 submit-group marginBottom marginTop">
						<a href="${ctx }/option/login_config_update" class="form-a">&lt;返回</a>
						<div class="btn-group fr">
							<button type="submit" class="btn-size" style="width:110px;" id="addButton" name="submitButton">更新</button>

						</div>
					</div>
						</form>
					</div>

					
				</div>
			</div>
		</div>

	</div>
	</div>
	<tags:load_common_js />
	<script type="text/javascript">
	$(document).ready(function(){
		$("#submitButton").click(function(){
			$("#updateForm").submit();
		});
	});
	</script>
	</body>

</html>