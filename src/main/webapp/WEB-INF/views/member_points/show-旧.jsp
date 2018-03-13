<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 积分详情</title>
	<tags:head_common_content />
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

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-eye"></i> 查看表单
						</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<form class="form-horizontal">
							<div class="box-body">
								<div class="form-group">
									<label for="passwdExpire" class="col-sm-2 control-label">积分编号:</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" value="${memberPoints.poId}" disabled="disabled"/>
									</div>
								</div>
								<div class="form-group">
									<label for="firstResetPasswd" class="col-sm-2 control-label">积分名称:</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" value="${memberPoints.poTypeName}" disabled="disabled"/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="firstResetPasswd" class="col-sm-2 control-label">消费金额:</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" value="${memberPoints.poTypeId}" disabled="disabled"/>
									</div>
								</div>
								<div class="form-group">
									<label for="firstResetPasswd" class="col-sm-2 control-label">积分描述:</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" value="${memberPoints.poDescription}" disabled="disabled"/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="firstResetPasswd" class="col-sm-2 control-label">积分数量:</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" value="${memberPoints.poNumber}" disabled="disabled"/>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="box-footer">
						<div class="col-sm-10 ">						
							</div>
							<div class="col-sm-1 ">	
		                    </div>
		                    <div class="col-sm-1 ">
		                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/member_points/list"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
		                    </div>	 
	                </div><!-- /.box-footer -->
				</div>
			</section>
		</div>
	</div>
	<tags:load_common_js />
</body>
</html>
