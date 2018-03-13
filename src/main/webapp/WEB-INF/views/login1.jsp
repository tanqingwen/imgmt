<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 登录</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/icheck/square/blue.css">
  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
      	<img alt="综合管理系统" src="${assets }/app/img/logo-304x62.png"/>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
      	<tags:action_tip/>
        <p class="login-box-msg">--- 用户登录 ---</p>
        <form id="loginForm" action="${ctx}/login" method="post">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="员工号" id="staffId" name="staffId" value="${staffId}" required="required">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="密码" id="passwd" name="passwd" required="required">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <!-- <input type="checkbox"> 记住我 -->
                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button id="loginButton" type="button" class="btn btn-primary btn-block btn-flat">登录</button>
            </div><!-- /.col -->
          </div>
        </form>
      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <script src="${assets}/jquery/jquery.min.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/icheck/icheck.min.js"></script>
    <script src="${assets}/keyboard/keyboard.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script type="text/javascript">
    function login() {
    	var pwd = $("#passwd");
		pwd.val(CryptoJS.MD5(pwd.val()));
		$("#loginForm").submit();
    }
	$(function () {
		$("input").iCheck({
			checkboxClass: "icheckbox_square-blue",
			radioClass: "iradio_square-blue",
			increaseArea: "20%" // optional
		});
		$("#loginButton").click(function(){
			login();
		});
		keyboardJS.bind("enter", function(e) {
			login();
		});
	});
    </script>
  </body>
</html>
