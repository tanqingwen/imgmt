<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 登录参数</title>
	<tags:head_common_content />
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

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-eye"></i> 参数表单
						</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="passwdExpire" class="col-sm-2 control-label">口令是否会过期</label>
								<div class="col-sm-6">
									<select class="form-control" id="passwdExpire" disabled="disabled">
										<option value="true" ${loginOptions.passwdExpire eq 'true' ? 'selected':''}>永不过期</option>
										<option value="false" ${loginOptions.passwdExpire eq 'false' ? 'selected':''}>周期过期</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">首次登陆口令更改</label>
								<div class="col-sm-6">
									<select class="form-control" id="firstResetPasswd" disabled="disabled">
										<option value="true" ${loginOptions.firstResetPasswd eq 'true' ? 'selected':''}>强制更改</option>
										<option value="false" ${loginOptions.firstResetPasswd eq 'false' ? 'selected':''}>不需要</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="allowPasswdErrorCount" class="col-sm-2 control-label">允许尝试失败的次数</label>
								<div class="col-sm-6">
									<select class="form-control" id="allowPasswdErrorCount" disabled="disabled">
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
							<div class="form-group">
								<label for="passwdExpireDays" class="col-sm-2 control-label">口令过期周期</label>
								<div class="col-sm-6">
									<select class="form-control" id="passwdExpireDays" disabled="disabled">
										<option value="week" ${loginOptions.passwdExpireDays eq 'week' ? 'selected':''}>一周</option>
										<option value="month" ${loginOptions.passwdExpireDays eq 'month' ? 'selected':''}>一月</option>
										<option value="year" ${loginOptions.passwdExpireDays eq 'year' ? 'selected':''}>一年</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="passwdMaxSize" class="col-sm-2 control-label">口令最大长度</label>
								<div class="col-sm-6">
									<input class="form-control" id="passwdMaxSize" value="${loginOptions.passwdMaxSize}" disabled="disabled"/>
								</div>
							</div>
							<div class="form-group">
								<label for="passwdMinSize" class="col-sm-2 control-label">口令最小长度</label>
								<div class="col-sm-6">
									<input class="form-control" id="passwdMinSize" value="${loginOptions.passwdMinSize}" disabled="disabled"/>
								</div>
							</div>
							<div class="form-group">
								<label for="passwdLoopCount" class="col-sm-2 control-label">口令历史循环数</label>
								<div class="col-sm-6">
									<input class="form-control" id="passwdLoopCount" value="${loginOptions.passwdLoopCount}" disabled="disabled"/>
								</div>
							</div>
							<div class="form-group">
								<label for="forceComplexPasswd" class="col-sm-2 control-label">是否强制复杂口令</label>
								<div class="col-sm-6">
									<select class="form-control" id="forceComplexPasswd" disabled="disabled">
										<option value="true" ${loginOptions.forceComplexPasswd eq 'true' ? 'selected':''}>是</option>
										<option value="false" ${loginOptions.forceComplexPasswd eq 'false' ? 'selected':''}>否</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<c:if test="${app:checkPermission('OPTION_LOGIN_CONFIG_UPDATE')}">
			                    <a type="submit" class="btn btn-info " href="${ctx }/option/login_config_update"><i class="fa fa-edit"></i>更新</a>
			                </c:if>
							<a type="button" class="btn  btn-info " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
						</div>
	                </div><!-- /.box-footer -->
				</div>
			</section>
		</div>
	</div>
	<tags:load_common_js />
</body>
</html>
