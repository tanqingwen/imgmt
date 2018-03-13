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
<link rel="stylesheet" href="${assets }/css/others.css" />
<title>证件类型管理</title>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="midtype" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>证件类型管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
					<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
					<li class="active">证件类型管理</li>
				</ol>
			</section>

			<div class="container-fluid RInfoManage DocumentType">
				<div class="row">
					<div class="tip-img">
						<p>证件类型管理</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">
								查询表单
								<c:if test="${app:checkPermission('IDTYPE_ADD')}">
									<a href="${ctx}/idtype_dict/add"><span class="fr add">+添加</span></a>
								</c:if>
							</h3>
							<form class="form-inline" method="post"
								action="${ctx }/idtype_dict/list">

								<div class="form-group">
									<div class="col-md-6">
										<label>证件类型:</label> <input
											class="form-control formConl line-input" type="text"
											value="${idtypeId }" id="idtypeId" name="idtypeId"
											placeholder="证件类型" />
									</div>
									<div class="col-md-6">
										<label>证件描述:</label> <input
											class="form-control formConl line-input" type="text"
											value="${idtypeDesc }" id="idtypeDesc" name="idtypeDesc"
											placeholder="证件描述" />
									</div>
								</div>
								<div class="col-lg-12 submit-group marginTop">
									<div class="btn-group fr">
										<button type="submit" class="btn-size" style="width: 110px;"
											id="memberShip">查询</button>
									</div>
								</div>
							</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">证件类型列表</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>证件类型</th>
												<th>证件描述</th>
												<th>最大长度</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.idtypeId}</td>
													<td>${item.idtypeDesc}</td>
													<td>${item.idtypeLength}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('IDTYPE_UPDATE')}">
																	<a href="${ctx}/idtype_dict/update?id=${item.idtypeId}"><span
																		class="edit">更新</span></a>
																</c:if>
																<c:if test="${app:checkPermission('IDTYPE_SHOW')}">
																	<a href="${ctx}/idtype_dict/show?id=${item.idtypeId}"><span
																		class="check">查看</span></a>
																</c:if>
																<c:if test="${app:checkPermission('IDTYPE_DELETE')}">
																	<a href="${ctx}/idtype_dict/delete?id=${item.idtypeId}"
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
								<a href="${ctx }/startTreeviewDetail/jbcsgl" class="form-a">&lt;返回</a>
								<tags:pagination url="${ctx}/idtype_dict/list"
									page="${pageInfo}" cssClass="pull-right" />
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
	<script src="${assets}/validator/js/validator.js"></script>
</body>

</html>