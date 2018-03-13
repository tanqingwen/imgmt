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
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>综合管理系统 | 积分详情</title>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="country_dict" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>积分详情</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
						<li><a href="${ctx }/member_points/list">积分管理</a></li>
						<li class="active">积分详情</li>
					</ol>
			</section>
	
		<div class="container-fluid RInfoManage IntegralManage common">
			<div class="row">
				<div class="tip-img">
					<p>积分查看</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看表单</h3>
						<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>积分编号:</label>
										<input class="form-control formConl line-input" type="text" value="${memberPoints.poId}"  disabled="disabled"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>积分名称:</label>
										<input class="form-control formConl line-input" type="text" value="${memberPoints.poTypeName}" disabled="disabled" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>消费金额:</label>
										<input class="form-control formConl line-input" type="text" value="${memberPoints.poTypeId}" disabled="disabled" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>积分描述:</label>
										<input class="form-control formConl line-input" type="text" value="${memberPoints.poDescription}" disabled="disabled" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>积分数量:</label>
										<input class="form-control formConl line-input" type="text" value="${memberPoints.poNumber}" disabled="disabled" />
									</div>
								</div>
								
							</div>
						</form>
						<div class="col-lg-12 submit-group marginTop marginBottom">
							<a href="${ctx }/member_points/list" class="form-a">&lt;返回</a>
							
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