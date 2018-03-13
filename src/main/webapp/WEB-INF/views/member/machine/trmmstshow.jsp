<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 终端详情</title>
<tags:head_common_content />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
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

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-plus"></i> 查看列表
						</h3>
					</div>
					 <!-- /.box-header -->
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="id" class="col-sm-3 control-label">终端编号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="id" name="id" value="${item.tmTerminalId}" disabled="disabled" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">商户号码</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmMerchantId}" disabled="disabled" />
										</div>
									</div>
									
									<!-- 
									<div class="form-group">
								    	<label class="col-sm-3 control-label">场馆等级</label>
								    	<div class="col-sm-8">
									     	<select class="form-control" id="tmIswatch" name="tmIswatch" >
									     		<option value="0">请选择级别...</option>
			 									<option value="1">一级-欢乐大世界</option>
			 									<option value="2">二级-场馆</option>
			 									<option value="3">三级-子场馆</option>
			 								<select>
								    	</div>
									</div>
									-->
									<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">场馆号码</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmMerchantId}" disabled="disabled" />
										</div>
									</div>
									-->
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">终端品牌</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmBrand}" disabled="disabled" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">终端版本</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmVersionNo}" disabled="disabled" />
										</div>
									</div>
									
									<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">票价</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmGeog}" disabled="disabled" />
										</div>
									</div>
									-->
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">安装日期</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmDateInst}" disabled="disabled" />
										</div>
									</div>
									
									<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">园区类型</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmModel}" disabled="disabled" />
										</div>
									</div>
									-->
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">设备序号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmEdcPrinterNo}" disabled="disabled" />
										</div>
									</div>
								
									<!-- 
									<div class="form-group" id="gateIpdiv">
										<label for="gateip" class="col-sm-3 control-label">闸机IP</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="tmHostSerial" name="tmHostSerial" value="${item.tmHostSerial}" disabled="disabled" />
										</div>
									</div>
									-->
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">终端状态</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmStatus=='1'?'停用':'正常'}" disabled="disabled" />
											</div>
										</div>
										
										<!-- 
										<div class="form-group">
				    						<label class="col-sm-3 control-label">归属场馆</label>
				    						<div class="col-sm-8">
												<select class="form-control" id="tmMerchantId" name="tmMerchantId"></select>
				    						</div>
										</div>
										-->
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">录入人</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmSetupUser}" disabled="disabled" />
											</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">录入时间</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmSetupTimestamp}" disabled="disabled" />
											</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">授权人</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmAuthUser}" disabled="disabled" />
											</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">授权时间</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmAuthTimestamp}" disabled="disabled" />
											</div>
										</div>
										
									</div>
										
									</div>
								</div>
							</div>
							<div class="box-footer">
		                  		<a type="button" class="btn btn-default pull-right" href="${ctx }/trmmstgate/viewTrmmstlist/${item.tmMerchantId }"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
		              		</div>
	              		</div>
	              	</section>
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
 