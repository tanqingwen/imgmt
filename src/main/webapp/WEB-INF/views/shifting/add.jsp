<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>收银交接班</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets }/css/getmoney.css" />
    <style type="text/css">
			.btn-oranges{
				width:320px;
				height:160px;
				background: #f8b00e;
				color:white;
				border:none;
				border-radius: 5px;
				font-size:35px;
				margin:0 auto;
				display: block;
			}
			
			.btn-blues{
				width:320px;
				height:160px;
				background: #55a9e5;
				color:white;
				border:none;
				border-radius: 5px;
				font-size:35px;
				margin:0 auto;
				display: block;
			}
		</style>
		
<object classid="CLSID:76A64158-CB41-11D1-8B02-00600806D9B6" id="locator" style="display:none;visibility:hidden"></object>
<object classid="CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223" id="foo" style="display:none;visibility:hidden"></object>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="role"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>交接班</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
<%--<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li> --%>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">交接班</li>
          </ol>
        </section>

        <!-- Main content -->
        <div class="container">
			<div class="row">
				<div class="col-lg-1 col-md-1 text-center lebelT" style="top:-45px;"><img src="${assets }/app/img/收银交班.png" /></div>
				<div class="col-lg-11 col-md-11">
					<div class="BindContent">
						<div class="contentInner" style="min-height:650px;padding-top:45px;">
							<div class="col-lg-12">
								<div class="col-lg-6" style="margin-bottom:20px;">
									<button class="btn-oranges" type="button" onclick="shift()">结班</button>
								</div>
								<div class="col-lg-6">
									<button class="btn-blues" type="button" onclick="duty()">交班</button>
								</div>
							</div>
						<a type="button"  href="${ctx }/startTreeviewDetail/pwzy" class="form-a" style="margin-left:32px;color:#333;">&lt;返回</a>						
							
							
							
							<input type="hidden" name="ipAddress">
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
        </div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    <!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
    var tip = "${tip_msg}";
	if(tip != '')
	alert(tip);
		function shift(){
			window.location.href="${ctx}/shifting/duty";
		}
		function duty(){
			window.location.href="${ctx}/shifting/shift";
		}
    </script>
    <script language="javascript">

var sIPAddr="";

var service = locator.ConnectServer();
service.Security_.ImpersonationLevel=3;
service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');

function shift(){
	window.location.href="${ctx}/shifting/shift?posIp="+sIPAddr;
}
function duty(){
	window.location.href="${ctx}/shifting/duty?posIp="+sIPAddr;
}
</script>
<script FOR="foo" EVENT="OnObjectReady(objObject,objAsyncContext)" LANGUAGE="JScript">
         if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true){
                           if(objObject.IPEnabled && objObject.IPAddress(0) !=null && objObject.IPAddress(0) != "undefined")
                                         sIPAddr = objObject.IPAddress(0);
                     
          }
		 
</script>
<script FOR="foo" EVENT="OnCompleted(hResult,pErrorObject, pAsyncContext)" LANGUAGE="JScript">
 //alert(sIPAddr);
</script>
  </body>
</html>
