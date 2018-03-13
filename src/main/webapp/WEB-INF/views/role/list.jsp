<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<tags:head_common_content />
<!-- Content Header (Page header) -->
<link rel="stylesheet" href="${assets }/css/others.css" />
<title>角色管理</title>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="role" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>

			<section class="content-header">
				<h1>角色管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
					<li class="active">角色管理</li>
				</ol>
			</section>

			<div class="container-fluid RInfoManage Role common">
				<div class="row">
					<div class="tip-img">
						<p>角色管理</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">
								查询表单
								<c:if test="${app:checkPermission('ROLE_ADD')}">
									<a href="${ctx}/role/add"><span class="fr add">+添加</span></a>
								</c:if>
							</h3>
							<form class="form-inline form-horizontal" id="defaultForm"
								name="defaultForm" action="${ctx}/role/list">
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>角色ID:</label> <input
												class="form-control formConl line-input" type="text" id="id"
												name="id" value="${id }" placeholder="角色ID" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>名称:</label> <input
												class="form-control formConl line-input" type="text"
												id="name" value="${name }" name="name" placeholder="名称" />
										</div>
									</div>
								</div>
								<div class="col-lg-12 submit-group marginTop">
									<div class="btn-group fr">
										<button type="submit" class="btn-size" style="width: 110px;"
											id="memberShip">查询</button>

									</div>
								</div>
							</form>

							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">角色列表</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>角色ID</th>
												<th>角色名称</th>
												<th>创建时间</th>
												<th>创建人</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.id}</td>
													<td>${item.name}</td>
													<td><tags:format_string patten="####/##/## ##:##:##"
															value="${item.createdAt}" /></td>
													<td>${item.createdBy}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('ROLE_UPDATE')}">
																	<a href="${ctx}/role/update?id=${item.id}"><span
																		class="edit">更新</span></a>
																</c:if>
																<c:if test="${app:checkPermission('ROLE_SHOW')}">
																	<a href="${ctx}/role/show?id=${item.id}"><span
																		class="check">查看</span></a>
																</c:if>
																<c:if test="${app:checkPermission('ROLE_DELETE')}">
																	<a href="${ctx}/role/delete?id=${item.id}"
																		onclick="return confirm('确认删除?')"><span
																		class="delete">删除</span></a>
																</c:if>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>

							</div>
							<div class="box-footer clearfix">
								<a href="${ctx }/startTreeviewDetail/xtgl" class="form-a">&lt;返回</a>
								<tags:pagination url="${ctx}/role/list" page="${pageInfo}"
									cssClass="pull-right" />
							</div>
						</div>
					</div>
				</div>

			</div>
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