<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 会员等级</title>
<tags:head_common_content />
<link rel="stylesheet" type="${assets }/huiyuan/text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="${assets }/huiyuan/css/layer.css" />
<link rel="stylesheet" href="${assets }/huiyuan/css/model.css" />
<link rel="stylesheet" href="${assets }/huiyuan/css/memberManagement.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="prdgrp" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>会员等级</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/hygl">会员管理</a></li>
					<li class="active">会员等级</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid  memberGrade">
				<div class="row outer-wrap">
					<div class="tip-img reviewList">
						<p>会员等级</p>
					</div>
					<div class="content">
						<div class="main">
						
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单<c:if test="${app:checkPermission('PRDGRP_ADD') }">
									<a class="" href="${ctx}/prdgrp/add"><span
										class="fr ">+添加</span></a>
								</c:if>
							</h3>
							<form id="defaultForm" name="defaultForm" class="form-horizontal form-inline">
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>客户等级：</label> <input
												class="form-control formConl line-input" id="prProdctGroup"
												name="prProdctGroup" placeholder="客户等级"
												value="${prProdctGroup }" type="text" />
										</div>
									</div>
										<div class="col-md-6">
										<div class="form-group">
											<label>描述：</label> <input
												class="form-control formConl line-input" id="prGroupDesc"
												name="prGroupDesc" placeholder="描述" value="${prGroupDesc }"
												type="text" />
										</div>
									</div>
								</div>
							

								<!--<div class="clearfix"></div>-->
								<!-- <a id="fanhui" href="JavaScript:history.Go(-1)">&lt;返回</a> -->

								
								<div class=" submit-group marginTop clearfix col-md-12">
									
									<!--	<a href="JavaScript:history.Go(-1)" class="form-a">&lt;返回</a>-->
									<div class="fr">
										<button type="submit" class="btn-size" style="width: 110px; margin: 0 25px 0 15px;" id="memberShip">查询</button>
									</div>
								</div>
							</form>
								<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">
									折扣列表<span class="fr toggle"></span>
								</h3>
								<div class="checkList">
									<table class="table table-responsive" style="font-size:14px;">
										<thead>
											<tr>
												<th>客户等级</th>
												<th>描述</th>
												<th>折扣</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.prProdctGroup}</td>
													<td>${item.prGroupDesc}</td>
													<td>${item.prCurr4dbc}%</td>
													<td>
														<!-- <div class="btn-toolbar pull-right" role="toolbar"> -->
														<!-- <div class="btn-group"> --> <c:if
															test="${app:checkPermission('PRDGRP_UPDATE') }">
															<a
																href="${ctx}/prdgrp/update?prProdctGroup=${item.prProdctGroup}">更新</a>
														</c:if> <c:if test="${app:checkPermission('PRDGRP_SHOW') }">
															<a href="${ctx}/prdgrp/show?prProdctGroup=${item.prProdctGroup}">查看</a>
																
														</c:if> <!-- </div> --> <!-- </div> -->
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="box-footer clearfix">
										<a type="button" href="${ctx }/startTreeviewDetail/hygl" class="form-a">&lt;返回</a>
										<tags:pagination url="${ctx}/prdgrp/list" page="${pageInfo}"
											cssClass="pull-right" />
									</div>
								</div>
							
						</div>
					</div>
				</div>
			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main footer -->
		<tags:main_footer />

		<!-- Control Sidebar -->
		<tags:control_sidebar />

	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>
</html>
