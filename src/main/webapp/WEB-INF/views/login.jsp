<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
		<title>欢乐大世界 综合管理平台</title>
	    <meta name="keywords" content="欢乐大世界"/>
	    <meta name="description" content="欢乐大世界"/>
	    <meta name="author" content="欢乐大世界">
	    <meta name="copyright" content="欢乐大世界">
		<link rel="stylesheet" href="${resBase}/css/login.css" />
		<link rel="shortcut icon" href="${resBase}/favicon.ico" type="image/x-icon"/>
		<script src="${resBase}/js/jquery.js"></script>
	    <script src="${resBase}/js/jquery-ui/jquery.ui.js" ></script>
	    <script src="${resBase}/js/jquery.validation.min.js" ></script>
	    <script type="text/javascript" src="${resBase}/js/layer/layer.js"></script>
    
	    <link rel="stylesheet" href="${resBase}/css/bootstrap.min.css">
		<link rel="stylesheet" href="${resBase}/css/AdminLTE.min.css">
	</head>
	<script type="text/javascript">
    $(function () {
    	var captchaImg = '${base}/generateImage?t=' + Math.random();
        $("#captcha_img").attr("src", captchaImg);
        
        $("#staffId").focus();
    });
    function changeCaptcha() {
        var captchaImg = '${base}/generateImage?t=' + Math.random();
        $("#captcha_img").attr("src", captchaImg);
    }
</script>
	<body>
		<div class="header">
			
			<div class="logo"><img src="${resBase}/images/login_img/IMG_0436.PNG" id="logo_img"></div>
		</div>
		<div class="main">
			
				<div class="login_form">
				<div class="form-title"><img src="${resBase}/images/login_img/IMG_0434.PNG"></div>
				<div class="nc-login-content" id="demo-form-site">
                <form id="login_form" action="${ctx}/login" class="bg" method="post">
               
                    <dl> 
                        <dd style="min-height:50px;">
                        	<img src="${resBase}/images/login_img/login_name.png" >
                            <input class="iptmarg" type="text" class="text" autocomplete="off"  name="staffId" id="staffId"placeholder="用户名" >
                            <label></label>
                        </dd>
                    </dl>
                    <dl>
                        
                        <dd style="min-height:50px;">
                        	<img src="${resBase}/images/login_img/login_psw.png" style="margin-right: 5px; opacity: 0.85;">
                            <input type="password" class="text" name="passwd" autocomplete="off"  id="passwd" placeholder="请输入密码">
<!--                             <a href="javascript:void(0);" class="forget">忘记密码</a> -->
                            <label></label>
                        </dd>
                    </dl>
                    <dl>
                      
                        <%-- <dd style="min-height:50px;">
                        	<img src="${resBase}/images/login_img/login_yz.png"  style="margin-right: 5px; opacity: 0.85;"/>
                            <input class="text w50 fl" type="text" name="captcha" maxlength="4" size="9" placeholder="验证码"/>
                            <img src="generateImage" title="看不清？点击换张" onclick="changeCaptcha()" border="0" height="30" width="80" id="captcha_img" class="fl ml5"/>
                            <a href="javascript:void(0)" class="ml5" onclick="changeCaptcha()"  id="nosee" style="color:#96caf4;">看不清，换一张</a>
                            <label style="color: red;" id="errors">
                            </label>
                        </dd> --%>
                    </dl>
	                    <dl>
	                        <dt style="color: #f3577c;"><c:if test="${Comment}">&nbsp;</c:if>${Comment }</dt>
	                        <dd>
	                            <a href="JavaScript:void(0);" class="submit" id="submitBtn"><span>登&nbsp;&nbsp;&nbsp;录</span></a>
	                        </dd>                
	                    </dl>
<!-- 	                    <dl>           	 -->
<%-- 	                    	<dt style="text-align: center;" class="dt-last"><img src="${resBase}/images/login_img/line.png" class="line"><a href="JavaScript:void(0);" id="rewrite">注&nbsp;&nbsp; 册</a><img src="${resBase}/images/login_img/line.png" class="line"></dt> --%>
<!-- 	                    </dl> -->
                </form>     
            </div>
			</div>
				
				
		
		</div>
		<footer>
			<div class="shop">
				<ul>
					<li><a href="javascript:void(0);">关于我们</a></li>
					<li><a href="javascript:void(0);">广告合作</a></li>
					<li><a href="javascript:void(0);">B2B2C商城</a></li>
					<li><a href="javascript:void(0);">微商城</a></li>
					<li><a href="javascript:void(0);">安卓APP</a></li>
				</ul>
			</div>
			<div class="bq">
				技术支持service@qimolink.com
			</div>
			<div class="shop_pic">
				<ul>
					<li><a href="javascript:void(0)"><img src="${resBase}/images/login_img/cft_02.png"></a></li>
					<li><a href="javascript:void(0)"><img src="${resBase}/images/login_img/zfb.png"></a></li>
					<li><a href="javascript:void(0)"><img src="${resBase}/images/login_img/jyx.png"></a></li>
					<li><a href="javascript:void(0)"><img src="${resBase}/images/login_img/kxwz.png"></a></li>
					<li><a href="javascript:void(0)"><img src="${resBase}/images/login_img/sm.png"></a></li>
					<li><a href="javascript:void(0)"><img src="${resBase}/images/login_img/360.png"></a></li>
					<li><a href="javascript:void(0)"><img src="${resBase}/images/login_img/aqlm.png"></a></li>
					
				</ul>
			</div>
		</footer>
		<script src="${assets}/crypto/md5.js"></script>
<script>
    $(document).ready(function(){
    	var h=$(document).height();
		var b=$(".main").height(h-180);
		var c=$(".login_form").height(h-180);
        $("#login_form ").validate({
            errorPlacement: function(error, element){
                var error_td = element.parent('dd');
                error_td.find('label').hide();
                error_td.append(error);
            },
             rules: {                 staffId: "required",
                 passwd: "required"

             },
             messages: {
                 staffId: "用户名不能为空",
                 passwd: "密码不能为空"

             } 
        });
        
         $('#submitBtn').click(function(){
		     if($("#login_form").valid()){
		         //加载进度条
	            layer.load(2, {
		               shade: [0.2,'#999999'] //0.1透明度的白色背景
	            });
	            var pwd = $("#passwd");
	            if(pwd.val()!=""){
	            	pwd.val(CryptoJS.MD5(pwd.val()));
	            }
	    		$("#login_form").submit();
				/* $.ajax({
		            type: "post",
		            url: '${ctx}/login',
		            data: $("#login_form").serialize(),
		            dataType: "json",
		            async:false,
		            success:function(data) {
		                if(data.success){
		                    setTimeout("window.location='${base}/index'" ,200);
		                }else{
		                    $("#errors").html(data.message);
		                    layer.closeAll('loading');
		                }
		            } 
		        });  */
		   
		     }
        });   

           //回车登陆事件
           document.onkeydown = function(e){
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
               if($("#login_form").valid()){
                //加载进度条
	            layer.load(2, {
		               shade: [0.2,'#999999'] //0.1透明度的白色背景
	            });
	            var pwd = $("#passwd");
	    		pwd.val(CryptoJS.MD5(pwd.val()));
	    		$("#login_form").submit();
				/* $.ajax({
		            type: "post",
		            url: '${ctx}/login',
		            data: $("#login_form").serialize(),
		            dataType: "json",
		            async:false,
		            success:function(data) {
		                if(data.success){
		                    setTimeout("window.location='${base}/index'" , 200);
		                }else{
		                    $("#errors").html(data.message);
		                    layer.closeAll('loading');
		                }
		            }
		        });  */ 
		      }
             }
        }
    });
</script>
	</body>
</html>
