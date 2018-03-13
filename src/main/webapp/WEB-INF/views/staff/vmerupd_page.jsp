<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>综合管理系统 | 场馆维护</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<%-- <link rel="stylesheet" href="${assets}/validator/css/css.css" /> --%>
<link rel="stylesheet" href="${assets}/layer/skin/layer.css" />
 <link rel="stylesheet" href="${assets}/gatesManagement/css/gatesManagement.css"/> 
<link rel="stylesheet" href="${assets}/venue/css/venueAll.css" />
<style>
label {
	width: 6em;
}

.col-lg-6 {
	padding: 0 15px;
}
</style>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">

	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="staff" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>场馆维护</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li class="active">场馆维护</li>
				</ol>
			</section>
			<div class="row outer-wrap">
				<div class="tip-img">
					<p>场馆维护</p>
				</div>
				<div class="content">
					<div class="main">
						<form name="form1" id="form1" class="form-horizontal"
							action="${ctx}/staff/searchVmermstResultList" method="post">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<div class="form-group">
								<div class="col-lg-6 col-md-6">
									<label>场馆号码</label> <input class="form-control formConl line-input"
										type="text" id="mmMerchantNo" name="mmMerchantNo"
										value="${mmMerchantNo }" />
								</div>
								<div class="col-lg-6  col-md-6">
									<label>场馆名称</label> <input class="form-control formConl line-input"
										type="text" id="mmBizName" name="mmBizName"
										value="${mmBizName }" />
								</div>
							</div>
							<div class="submit-group">
								<a href="${ctx }/startTreeviewDetail/xcgl" class="form-a">&lt;返回</a>
								<div class="btn-group">
									<button type="submit" class="btn-size" style="width: 110px;"
										id="memberShip">查询</button>
									<button type="button" class="btn-size"
										style="width: 110px; margin-left: 40px;" id="venueAuth">待授权</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->
	<tags:load_common_js />
	<script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/layer/layer.js"></script>
	<script language="javascript">
	var sIPAddr="";
	var service = locator.ConnectServer();
	service.Security_.ImpersonationLevel=3;
	service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
	</script>
	<script FOR="foo" EVENT="OnObjectReady(objObject,objAsyncContext)"
		LANGUAGE="JScript">
        if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true){
                 if(objObject.IPEnabled && objObject.IPAddress(0) !=null && objObject.IPAddress(0) != "undefined")
                               sIPAddr = objObject.IPAddress(0);
                      
         }
	</script>
	<script type="text/javascript">
		$("#venueAuth").click(function(){
			var mmMerchantNo = document.form1.mmMerchantNo.value;
			var mmBizName = document.form1.mmBizName.value;
			location.href="${ctx}/staff/searchVmermstWaitAuth?mmMerchantNo="+mmMerchantNo+"&mmBizName="+mmBizName;
		});
		
		
		$(document).ready(function(){
			_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
			
			
			
			var mmPmtMode = "0"; //默认0等级
	 		$.ajax({
	 			async: false,
				type : "POST",
				url : "${ctx}/staff/search_mermst_Data1",
				dataType : "json",
				data : {
					mmPmtMode : mmPmtMode
				},
				success : function(data) {
					if (data.status == "OK") {
						mmChainAccno = data.value;
						var obj=document.getElementById('mmChainAccno');
						$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));
					}else{
						alert("归属场馆错误");
					}
				}
			});
		});
			
		</script>

	<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
			<@ }); @>
		</script>
</body>
</html>