<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>综合管理系统 | 重置密码</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="staff"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>重置密码</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li><a href="${ctx }/staff/list">员工管理</a></li>
						<li class="active">重置密码</li>
					</ol>
				</section>
	
		<div class="container-fluid common resetPassWord">
			<div class="row">
				<div class="tip-img">
					<p>重置密码</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">重置密码</h3>
						<form class="form-inline form-horizontal" id="resetForm" method="post" action="${ctx }/staff/reset_password">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工ID:</label>
										<input class="form-control formConl line-input" type="text" id="userId" name="userId" value="${user.id}" readonly="readonly" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>新密码:</label>
										<input class="form-control formConl line-input" id="newPassword" name="newPassword" type="password"/>
									</div>
								</div>
							</div>

							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>确认新密码:</label>
										<input class="form-control formConl line-input" id="renewPassword" type="password"/>
									</div>
								</div>
								
							</div>
							
						</form>
						<div class="col-lg-12 submit-group marginBottom marginTop">
							<a href="${ctx }/staff/list" class="form-a">&lt;返回</a>
							<div class="btn-group fr">
								<button type="button" class="btn-size" style="width:110px;" id="resetButton">更新</button>

							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>
		<script src="${assets}/crypto/md5.js"></script>
	    <script type="text/javascript">
		$(function () {
			$("#resetButton").click(function(){
				var newPassword =$("#newPassword");
				var renewPassword =$("#renewPassword");
				if(newPassword.val() !== renewPassword.val()){
					renewPassword.parent().addClass("has-error").find('.help-block').html("两次密码输入不一致");
					return false;
				}else{
					newPassword.val(CryptoJS.MD5(newPassword.val()));
					$("#resetForm").submit();
				}
			});
		});
	    </script>
	</body>

</html>