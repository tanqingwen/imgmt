<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 |角色详情</title>
<tags:head_common_content />
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
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>角色详情</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
					<li><a href="${ctx }/role/list">角色管理</a></li>
					<li class="active">角色详情</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-eye"></i> 详情表单
						</h3>
					</div>
					<!-- /.box-header -->
					<form class="form-horizontal" method="post" action="${item }/role/show">
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="id" class="col-sm-3 control-label">角色ID</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="id" name="id" value="${item.id}" disabled="disabled" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">角色名称</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.name}" disabled="disabled" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="roles" class="col-sm-3 control-label">权限列表</label>
										<div class="col-sm-9">
											<div class="row">
												<c:forEach var="function" items="${functions }">
													<div class="col-lg-6">
														<div class="input-group">
															<span class="input-group-addon"> <input	type="checkbox" disabled="disabled"	${app:stringContains(item.functions, function.id) ? 'checked':'' } /></span>
															<span class="form-control" >${function.name }</span>
														</div>
														<!-- /input-group -->
													</div>
													<!-- /.col-lg-6 -->
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="box-footer">
	                  		<a type="submit" class="btn btn-default pull-right" href="${ctx }/role/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	              		</div><!-- /.box-footer -->
					</form>
				</div>
			</section><!-- /.content -->
		</div><!-- /.box -->
	</div>
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>
</html>
 