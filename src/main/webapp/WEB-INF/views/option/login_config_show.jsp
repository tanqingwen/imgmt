<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>登录参数</title>
    <style>
    	.logonParameter .tip-img p{
    		 font-size: 20px;
   			 line-height: 30px;
    	}
    </style>
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
				<h1>登录参数</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
					<li class="active">登录参数</li>
				</ol>
			</section>
	
		<div class="container-fluid common logonParameter">
			<div class="row">
				<div class="tip-img">
					<p>登录参数</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">参数表单</h3>
						<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>口令是否会过期:</label>
										<select  id="passwdExpire" disabled="disabled" class="line-input" disabled="disabled">
											<option value="true" ${loginOptions.passwdExpire eq 'true' ? 'selected':''}>永不过期</option>
											<option value="false" ${loginOptions.passwdExpire eq 'false' ? 'selected':''}>周期过期</option>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>首次登陆口令更改:</label>
										<select name="" id="firstResetPasswd" class="line-input" disabled="disabled">
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
										<select name="" id="allowPasswdErrorCount" class="line-input" disabled="disabled">
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
										<select name="" id="" class="line-input" disabled="disabled">
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
										<input class="form-control line-input" type="text" value="${loginOptions.passwdMaxSize}" disabled="disabled"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>口令最小长度:</label>
										<input class="form-control line-input" type="text" value="${loginOptions.passwdMinSize}" disabled="disabled"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>口令历史循环数:</label>
										<input class="form-control line-input" type="text" value="${loginOptions.passwdLoopCount}" disabled="disabled"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>是否强制复杂口令:</label>
										<select name="" id="" class="line-input" disabled="disabled">
											<option value="true" ${loginOptions.forceComplexPasswd eq 'true' ? 'selected':''}>是</option>
											<option value="false" ${loginOptions.forceComplexPasswd eq 'false' ? 'selected':''}>否</option>
										</select>

									</div>
								</div>
							</div>
						</form>
					</div>

					<div class="col-lg-12 submit-group marginBottom marginTop">
						<a href="${ctx }/startTreeviewDetail/xtgl" class="form-a">&lt;返回</a>
						<div class="btn-group fr">
						<c:if test="${app:checkPermission('OPTION_LOGIN_CONFIG_UPDATE')}">
							<a href="${ctx }/option/login_config_update"><button type="button" class="btn-size" style="width:110px;" id="memberShip">更新</button></a>
						</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>

		</div>
	</div>
	<tags:load_common_js />

		
	</body>

</html>