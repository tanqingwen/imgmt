<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 闸机IP更新</title>
	<tags:head_common_content />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="gateip" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>闸机IP更新</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
						<li><a href="${ctx }/gateip/list">闸机绑IP</a></li>
						<li class="active">闸机IP更新</li>
					</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-edit"></i> 更新表单
						</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<form class="form-horizontal" id="updateForm" method="post" action="${item }/gateip/update">
							<div class="form-group">
								<label for="passwdExpire" class="col-sm-2 control-label">闸机序号<font color="red">*</font></label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="gaId" value="${gateIpDto.gaId}" readonly="readonly"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">闸机编号</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="gaTm" value="${gateIpDto.gaTm}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">闸机绑IP</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="gaIp" value="${gateIpDto.gaIp}"/>
								</div>
							</div>
							<!--  
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">闸机IP状态</label>
								<div class="col-sm-6"> 
									<input type="text" class="form-control" name="gaState" value="${gateIpDto.gaState}"/>
								</div>
							</div>
							-->
						</form>
					</div>
	                <div class="box-footer">
	                	<div class="pull-right">
							<button id="submitButton" type="submit" class="btn btn-info "><i class="fa fa-save"></i> 更新</button>
							<a type="button" class="btn btn-default " href="${ctx }/gateip/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
<!-- 							 	<div class="col-sm-10 ">						 -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-1 ">	 -->
<!-- 									<button type="button" class="btn btn-info pull-right" id="submitButton"><i class="fa fa-save"></i> 保存</button>	                    	 -->
<!-- 			                    </div> -->
<!-- 			                    <div class="col-sm-1 "> -->
<%-- 			                    	<a type="button" class="btn btn-info pull-right" href="${ctx }/gateip/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
<!-- 			                    </div>	                    	 -->
	                </div><!-- /.box-footer -->
				</div>
			</section>
		</div>
	</div>
	<tags:load_common_js />
		<script src="${assets}/validator/js/validator.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#submitButton").click(function(){
			$("#updateForm").submit();
		});
	});
	</script>
</body>
</html>
