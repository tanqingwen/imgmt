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
		<title>闸机IP详情</title>
		<link rel="stylesheet" href="${assets }/css/GateDetail.css" />
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
				<h1>闸机IP详情</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
						<li><a href="${ctx }/gateip/list">闸机绑IP</a></li>
						<li class="active">闸机IP详情</li>
					</ol>
			</section>
		
		<div class="container-fluid gateDetail">
			<div class="row">
				<div class="tip-img"><p>闸机IP详情</p></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">添加表单</h3>

							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="GateDetailNum" style="width:100px; text-align:right;">闸机IP序号：</label>
											<input class="form-control formConl line-input" type="text" value="${gateIPDto.gaId}" disabled="disabled"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="Initial number"  style="width:100px; text-align:right;">初始闸机编号：</label>
											<input class="form-control formConl line-input" type="text" value="${gateIPDto.gaTm}" disabled="disabled"/>
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="GateDetailIP"  style="width:100px; text-align:right;">闸机IP地址：</label>
											<input class="form-control formConl line-input" type="text" value="${gateIPDto.gaIp}" disabled="disabled" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="MerchantGrade"  style="width:100px; text-align:right;">闸机IP状态：</label>
										   <input class="form-control formConl line-input" type="text" value="${gateIPDto.gaState == '1' ? '未使用' :  '已占用'}" disabled="disabled"/>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<a  href="javascript:history.go(-1)"  class="backStyle"><span style="font-size:18px;color:#333;">&lt;返回</span></a>
							</div>

					</div>

				</div>
			</div>
		</div>
		</div>
		</div>
	</div>
	<tags:load_common_js />
	</body>
</html>