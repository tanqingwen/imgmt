<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 重置密码</title>
		<tags:head_common_content/>
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

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                	<h3 class="box-title"><i class="fa fa-edit"></i> 重置密码</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form id="resetForm" class="form-horizontal" method="post" action="${ctx }/staff/reset_password">
							<div class="box-body">
								<div class="col-sm-6">
									<div class="form-group">
										<label for="staffId" class="col-sm-3 control-label">员工ID</label>
										<div class="col-sm-9">
											<input class="form-control" id="userId" name="userId" value="${user.id}" type="text" readonly="readonly">
										</div>
									</div>		                    
									<div class="form-group">
										<label for="staffName" class="col-sm-3 control-label">新密码</label>
										<div class="col-sm-9">
											<input class="form-control" id="newPassword" name="newPassword" type="password">
										</div>
									</div>
									<div class="form-group">
										<label for="staffName" class="col-sm-3 control-label">确认新密码</label>
										<div class="col-sm-9">
											<input class="form-control" id="renewPassword" type="password">
											<p class="help-block"></p>
										</div>
									</div>
								</div>
							</div><!-- /.box-body -->
							<div class="box-footer">
								<div class="pull-right">
									<button id="resetButton" type="button" class="btn btn-info "><i class="fa fa-save"></i> 更新</button>
									<a type="button" class="btn btn-default" href="${ctx }/staff/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
								</div>
							</div><!-- /.box-footer -->
		                </form>
			        </div><!-- /.box -->
				</section><!-- /.content -->
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
