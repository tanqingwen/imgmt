<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/css/others.css" />
<title>餐厅信息管理</title>

</head>

<body class="hold-transition skin-blue-light sidebar-mini">

	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="ywrestaurantlist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>餐厅信息管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/webwh">web维护</a></li>
					<li class="active">餐厅信息管理</li>
				</ol>
			</section>

			<div class="container-fluid RInfoManage restaurantList">
				<div class="row">
					<div class="tip-img">
						<p>餐厅信息管理</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">
								查询表单
								<c:if test="${app:checkPermission('YWRESTAURANT_ADD') }">
									<a href="${ctx}/ywrestaurant/add" class="fr"><span
										class="RInfoManageAdd ">+添加</span></a>
								</c:if>
							</h3>
							<form class="form-inline clearfix">
								<div class="col-md-12 clearfix">
									<div class="form-group">
										<div class="input-group RestaurantCheck">
											<input type="text" class="form-control " style="width: 200px"
												id="restaurantId" name="restaurantId"
												value="${restaurantId }" placeholder="输入餐厅ID"> <input
												type="text" class="form-control "
												style="width: 200px; border-radius: 5px;"
												id="restaurantName" name="restaurantName"
												value="${restaurantName }" placeholder="餐厅名称查询">
											<div class="input-group-addon">
												<button type="submit" class="RInfoManageBtn">查询</button>
											</div>

										</div>
									</div>
								</div>
							</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>餐厅ID</th>
												<th>餐厅名</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.restaurantId}</td>
													<td>${item.restaurantName}</td>

													<td class="text-right"><c:if
															test="${app:checkPermission('YWRESTAURANT_UPDATE') }">
															<a
																href="${ctx}/ywrestaurant/update?restaurantId=${item.restaurantId}"><span>更新</span></a>
														</c:if> <c:if test="${app:checkPermission('YWRESTAURANT_SHOW') }">
															<a
																href="${ctx}/ywrestaurant/show?restaurantId=${item.restaurantId}"><span>查看</span></a>
														</c:if> <c:if
															test="${app:checkPermission('YWRESTAURANT_DELETE')}">
															<a
																href="${ctx}/ywrestaurant/delete?restaurantId=${item.restaurantId}"
																onclick="return confirm('确认删除?')"><span>删除</span></a>
														</c:if></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>

							</div>
						</div>
					</div>
					<div class="box-footer clearfix">
						<a type="button" href="${ctx }/startTreeviewDetail/webwh"
							class="form-a">&lt;返回</a>
						<tags:pagination url="${ctx}/ywrestaurant/list" page="${pageInfo}"
							cssClass="pull-right" />
					</div>
				</div>

			</div>
		</div>
		<tags:main_footer />

		<!-- Control Sidebar -->
		<tags:control_sidebar />

	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>

</html>