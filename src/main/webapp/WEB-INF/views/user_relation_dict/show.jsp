<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 |人际关系查看</title>
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
				<h1>人际关系查看</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">人际关系管理</a></li>
					<li class="active">人际关系查看</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-plus"></i> 查看表单
						</h3>
					</div>
					<!-- /.box-header -->
					<form class="form-horizontal" method="post" action="${item }/user_relation_dict/show">
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="id" class="col-sm-3 control-label">人际关系ID</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="id" name="id" value="${item.userRelationId }" disabled="disabled" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">人际关系描述</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.userRelationDesc }" disabled="disabled" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
					<div class="box-footer">
                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/user_relation_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                </div><!-- /.box-footer -->
				</div>
			</div><!-- /.box -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>
</html>
