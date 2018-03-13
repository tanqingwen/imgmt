<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 修改密码</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/icheck/square/blue.css">
  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
      	<img alt="综合管理系统" src="${assets }/app/img/logo-247x51.jpg"/>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
      	<tags:action_tip/>
        <p class="login-box-msg">--- 修改密码 ---</p>
        <form id="loginForm" action="${ctx}/staff/change_password" method="post">
          <div class="form-group has-feedback">
          	<input type="hidden"  id="id" name="id" value="${currentStaff.id }"/>
            <input type="password" class="form-control" placeholder="新密码" id="newPassword" name="newPassword" required="required">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="确认新密码"  required="required" id="renewPassword">
            <p class="help-block"></p>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-4 pull-right">
              <button id="loginButton" type="button" class="btn btn-primary btn-block btn-flat">修改</button>
            </div><!-- /.col -->
          </div>
        </form>
      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <script src="${assets}/jquery/jquery.min.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script type="text/javascript">
	$(function () {
		$("#loginButton").click(function(){
			var newPassword =$("#newPassword");
			var renewPassword =$("#renewPassword");
			if(newPassword.val() !== renewPassword.val()){
				renewPassword.parent().addClass("has-error").find('.help-block').html("两次密码输入不一致");
				return false;
			}else{
				newPassword.val(CryptoJS.MD5(newPassword.val()));
				$("#loginForm").submit();
			}
		});
	});
    </script>
  </body>
</html>
