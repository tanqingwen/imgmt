<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content />
		<title>闸机详情</title>
		<link rel="stylesheet" href="${assets }/css/gateMar-gateDetail.css" />
	</head>

	<body  class="hold-transition skin-blue-light sidebar-mini">
		
		<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="profile" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>闸机详情</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
		            <li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
		            <li><a href="${ctx }/trmmstgate/list">闸机管理</a></li>
		            <li><a href="${ctx }/trmmstgate/viewlist/${merchantId }">闸机列表</a></li>
					<li class="active">闸机详情</li>
				</ol>
			</section>
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><p>闸机详情</p></div>
				<div class="content">
					<div class="main gateDta">
						<h3 style="border-bottom: 2px dashed #45a0e0;">闸机详情<span class=""></span></h3>
						
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">闸机编号：</label>
											<input class="form-control formConl line-input gateNum" type="text"id="id" name="id" value="${item.tmTerminalId}" disabled="disabled" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">闸机名称：</label>
											<input class="form-control formConl line-input gateStatus" type="text" id="tmDateCanx" name="tmDateCanx" value="${item.tmDateCanx}" disabled="disabled"/>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">场馆等级：</label>
											<select id="tmIswatch" name="tmIswatch" disabled="disabled">
									     		<option value="0">请选择级别...</option>
			 									<option value="1">一级-欢乐大世界</option>
			 									<option value="2">二级-场馆</option>
			 									<option value="3">三级-子场馆</option>
			 								<select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">归属场馆：</label>
											<select id="tmMerchantId" name="tmMerchantId" disabled="disabled"></select>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">闸机品牌：</label>
											<input class="form-control formConl line-input gateBrand"  disabled="disabled" type="text" id="name" name="name" value="${item.tmBrand}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">录入人：</label>
											<input class="form-control formConl line-input entryPeople"  disabled="disabled" type="text" id="name" name="name" value="${item.tmSetupUser}" />
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">闸机版本：</label>
											<input class="form-control formConl line-input gateVersion"  disabled="disabled" type="text" value="${item.tmVersionNo}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">录入时间：</label>
											<input class="form-control formConl line-input entryTime" id="tmSetupTimestamp" disabled="disabled"  type="text"/>
										</div>
									</div>
								</div>
								<%-- <div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">闸机版本：</label>
											<input class="form-control formConl line-input"  disabled="disabled"  type="text" value="${item.tmVersionNo}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">录入时间：</label>
											<input class="form-control formConl line-input"  disabled="disabled" type="text" value="${item.tmSetupTimestamp}" />
										</div>
									</div>
								</div> --%>
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">安装日期：</label>
											<input class="form-control formConl line-input"  disabled="disabled" type="text" value="${item.tmDateInst}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">授权人：</label>
											<input class="form-control formConl line-input"  disabled="disabled" type="text" value="${item.tmAuthUser}"/>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">设备序号：</label>
											<input class="form-control formConl line-input"  disabled="disabled" type="text" value="${item.tmEdcPrinterNo}"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">授权时间：</label>
											<input class="form-control formConl line-input" id="tmAuthTimestamp" disabled="disabled" type="text"/>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 ">
										<div class="form-group ">
											<label for="">闸机IP：</label>
											<input class="form-control formConl line-input"  disabled="disabled" type="text"  value="${item.tmHostSerial}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">闸机状态：</label>
											<input class="form-control formConl line-input gateStatus" disabled="disabled" type="text" id="name" name="name" value="${item.tmStatus=='1'?'停用':'正常'}"/>
										</div>
									</div>
									
								</div>
							</div>
							<div class="col-lg-12 col-md-12 marginBottom">
								<a href="javascript:history.go(-1)"  class="backStyle"><span>&lt;返回</span></a>
							</div>
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
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script type="text/javascript">
	 $(document).ready(function(){
		 $('#tmAuthTimestamp').val(dateformat('${item.tmAuthTimestamp}'));
		 $('#tmSetupTimestamp').val(dateformat('${item.tmSetupTimestamp}'));
		 	 var tmIswatch = ${item.tmIswatch};
			 obj = document.getElementById("tmIswatch");
			 for(i=0;i<obj.length;i++){
			   if(obj[i].value == tmIswatch)
			     obj[i].selected = true;
			 } 
	    	_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
	    	
	 		$.ajax({
	 			async: false,
				type : "POST",
				url : "${ctx}/staff/search_mermst_Data1",
				dataType : "json",
				data : {
					tmIswatch : tmIswatch
				},
				success : function(data) {
					if (data.status == "OK") {
						tmMerchantId = data.value;
						$("#tmMerchantId").html(_.template($("#tplMmChainAccno").html(), tmMerchantId));
					}else{
						alert("归属场馆错误");
					}
				}
			});
	 		//上级场馆编号
	 		var mmOldAccNumber= "${merchantId}";
	 		for(var i=0;i<document.getElementById("tmMerchantId").options.length;i++){
	 			var trimab1 = document.getElementById("tmMerchantId").options[i].value;
	 			if(trimab1==mmOldAccNumber){
	 				document.getElementById("tmMerchantId").options[i].selected='selected';
	 				break;
	 			}
	 		}
	    });
  /* alert(dateformat('${item.tmAuthTimestamp}')); */
	 function dateformat(str){
		var year = str.substring(0,4);
		var month = str.substring(4,6);
		var day = str.substring(6,8)
		return year+'-'+month+'-'+day;
	 }
	
	</script>
	
	<script type="text/template" id="tplMmChainAccno">
	 	<@ _.each(tmMerchantId, function (evt) { @>
				<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
		<@ }); @>
	</script>
	</body>

</html>