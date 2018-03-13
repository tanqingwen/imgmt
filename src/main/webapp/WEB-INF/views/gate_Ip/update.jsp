<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content />
		<title>闸机绑IP</title>
		<link rel="stylesheet" href="${assets }/css/gateIPUpdate.css" />
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
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img">
					<p>闸机IP更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">更新表单</h3>

						<form class="form-horizontal" id="updateForm" method="post" action="${ctx }/gateip/update">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="GateSerialNum">闸机序号：</label>
											<input class="form-control formConl GateSerialNum line-input"  name="gaId" value="${gateIpDto.gaId}" readonly="readonly" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="gateNum">闸机编号：</label>
											<input class="form-control formConl line-input gateNum" type="text" name="gaTm" value="${gateIpDto.gaTm}"/>
										</div>
									</div>
								</div>
									<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="GateBind">闸机绑IP：</label>
											<input class="form-control formConl line-input GateBind" type="text" name="gaIp" value="${gateIpDto.gaIp}"/>
										</div>
									</div>
									
								</div>
							</div>
							<div class="col-lg-12 col-md-12 marginBottom">
								<a href="javascript:history.go(-1)" class="backStyle" style="font-size:18px;"><span>&lt;返回</span></a>
								<button class="btn update btn-size btnSty"  id="submitButton" type="submit">更新</button>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<tags:load_common_js />
		<script type="text/javascript">
		$(document).ready(function(){
			$("#submitButton").click(function(){
				$("#updateForm").submit();
			});
		});
		
		</script>
		
	</body>

</html>