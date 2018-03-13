<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 |机构查看</title>
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
				<h1>机构查看</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">用户管理</a></li>
					<li class="active">机构查看</li>
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
					<form class="form-horizontal" >
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="id" class="col-sm-3 control-label">机构ID</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="id" name="id"
												value="${item.id}" disabled="disabled" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">父级机构</label>
										<div class="col-sm-9">
											<select id="parentId" name="parentId" class="form-control" disabled="disabled">
									    		<c:forEach var="org" items="${organizations }">
									    			<option value="${org.id }" ${org.id eq item.parentId ? 'checked' : '' }>${org.id } - ${org.name }</option>
									    		</c:forEach>
									    	</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="id" class="col-sm-3 control-label">机构名称</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="id" name="id"
												value="${item.name}" disabled="disabled" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">机构描述</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name"
												value="${item.remark}" disabled="disabled" />
										</div>
									</div>
								</div>
							</div>
							<div class="box-footer">
							 	<div class="col-sm-10 ">				
								</div>
								<div class="col-sm-1 ">	                    	
			                    </div>
			                    <div class="col-sm-1 ">
			                    	<a type="button" class="btn btn-default pull-right" href="${ctx}/organization/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
			                    </div>	                    	
	                		</div><!-- /.box-footer -->
						</div>
					</form>
				</div>
				</section>
		</div>
		<!-- /.box -->
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>
</html>
