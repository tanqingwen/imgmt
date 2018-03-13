<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>终端详情</title>
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/model.css" />
		<link rel="stylesheet" href="${assets }/css/siteManagement.css">
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
				<h1>终端详情</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">商户管理</a></li>
            		<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">商户列表</a></li>
            		<li><a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">终端列表</a></li>
					<li class="active">终端详情</li>
				</ol>
			</section>
	
		<div class="container-fluid venue-entry">
			<div class="row outer-wrap">
				<div class="tip-img">
					<p>终端详情</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看列表</h3>
						<form id="defaultForm" name="defaultForm" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-6">
									<label>终端编号：</label>
									<input class="form-control formConl" type="text" id="id" name="id" value="${item.tmTerminalId}" disabled="disabled" />
								</div>
								<div class="col-md-6">
									<label>终端状态：</label>
									<input class="form-control formConl" type="text" id="name" name="name" value="${item.tmStatus=='1'?'停用':'正常'}" disabled="disabled"/>

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>商户号码：</label>
									<input class="form-control formConl" type="text" id="name" name="name" value="${item.tmMerchantId}" disabled="disabled" />
								</div>
								<div class="col-md-6">
									<label>录入人：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmSetupUser}" disabled="disabled" />

								</div>
								<!--<div class="col-md-6">
									<label>安装日期：</label>
									<div class="input-group groupDis">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input type="text" class="form-control" data-toggle="datepicker">
									</div>
								</div>-->
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>终端品牌：：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmBrand}" disabled="disabled" />

								</div>
								<div class="col-md-6">
									<label>录入时间：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmSetupTimestamp}" disabled="disabled"/>

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>终端版本：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmVersionNo}" disabled="disabled" />

								</div>
								<div class="col-md-6">
									<label>授权人：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmAuthUser}"  disabled="disabled"/>

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>安装日期：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmDateInst}" disabled="disabled" />
								</div>
								<div class="col-md-6">
									<label>授权时间：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmAuthTimestamp}" disabled="disabled" />

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>终端名称：<i class="color-red">*</i>：</label>
									<input class="form-control formConl" type="text" id="tmDateCanx" name="tmDateCanx" value="${item.tmDateCanx}" disabled="disabled"/>
								</div>
								<div class="col-md-6">
									<label>终端IP：</label>
									<input class="form-control formConl" type="text" id="tmHostSerial" name="tmHostSerial" value="${item.tmHostSerial}" disabled="disabled"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>设备序号：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmEdcPrinterNo}" disabled="disabled" />
								</div>
							</div>

							<!--<div class="clearfix"></div>-->

							<div class="col-lg-12 submit-group">
								<a href="${ctx }/trmmstgate/viewTrmmstlist/${item.tmMerchantId }" class="form-a">&lt;返回</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		</div><!-- /.box -->
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/underscore/underscore.min.js"></script>
	
	<script type="text/javascript">
	 $(document).ready(function(){
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
	    });
	
	</script>
	
	<script type="text/template" id="tplMmChainAccno">
	 	<@ _.each(tmMerchantId, function (evt) { @>
				<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
		<@ }); @>
	</script>
	
	</body>
	
</html>