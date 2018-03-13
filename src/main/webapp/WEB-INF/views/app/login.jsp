<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="format-detection" content="telephone=yes" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <link rel="stylesheet" type="text/css" href="../../../imgmt/pos/css/reset.css">
	<link rel="stylesheet" type="text/css" href="../../../imgmt/pos/css/login.css">
<!--     <link rel="stylesheet" type="text/css" href="../css/layer.css"> -->
	<title>登录</title>
</head>
<body>
    <div class="header">
    <div class="logo">乐园综合管理平台</div>
    </div>
    <div class="main">
       <div class="row">
            <div class="login_name">
                <img src="../../../imgmt/pos/image/login_name.png">
            </div>
            <input type="text" id="userno" name="userno" placeholder="用户号">
            <div class="user-tip hide"><span class="red">*</span>用户名不能为空</div>
        </div>
        <div class="row">
            <div class="login_psw">
                <img src="../../../imgmt/pos/image/login_psw.png">
            </div>
            <input type="password" id="psd" name="password" placeholder="密码">
            <div class="pwd-tip hide2"><span class="red">*</span>密码不能为空</div>
            <div class="err-tip hide2"><span class="red">*</span>用户名或密码错误</div>
        </div>
            <input type="button" class ="login" name="" value="登录">
    <!--         <a href="">忘记密码</a> -->
    </div>
    <div class="footer"></div>
    <script src="../../../imgmt/pos/js/jquery-3.1.1.min.js"></script>
    <script src="../../../imgmt/pos/js/adapt.js"></script>
    <script src="../../../imgmt/pos/js/login.js"></script>
    <script src="../../../imgmt/pos/js/layer.js"></script> 
	<script src="../../../imgmt/pos/js/url.js"></script>
</body>
</html>