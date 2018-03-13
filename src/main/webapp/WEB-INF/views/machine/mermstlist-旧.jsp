<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 商户列表</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="machine" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>商户列表</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">商户管理</a></li>	
					<li class="active">商户列表</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-search"></i> 查询表单
						</h3>
					</div>
					<!-- /.box-header -->
				<!-- form start -->
				<form class="form-horizontal" action="${ctx}/trmmstgate/venmerlist" method="post">
					<div class="box-body">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="roleName" class="col-sm-3 control-label">商户编号</label>
								<div class="col-sm-9">
									<input class="form-control" id="tm_terminal_id" name="tm_terminal_id"
										placeholder="商户编号" value="${tm_terminal_id }" type="text">
										<input  id="tm_merchant_id" name="tm_merchant_id"
										value="${merchantId }" type="hidden">
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<div class="pull-right">
							<button type="submit" class="btn btn-info ">
								<i class="fa fa-search"></i> 查询
							</button>
							<a type="button" class="btn btn-info" href="${ctx }/trmmstgate/mermstlist"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
					</div>
					<!-- /.box-footer -->
				</form>
		</div>
		<!-- /.box -->
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-list"></i> 查询列表
						</h3>
					</div>
					<!-- /.box-header -->
					<div id="terminal" class="box-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
<!-- 									    <th>选择</th> -->
										<th>商户编号</th>
										<th>商户名称</th>
										<th>商户简称</th>
										<th class="text-right">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}">
										<tr>
											<td>${item.mmMerchantNo}</td>
											<td>${item.mmBizName}</td>
											<td>${item.mmStmtName}</td>
											<td>
												<div class="btn-toolbar pull-right" role="toolbar">
													<div class="btn-group">
														<c:if test="${app:checkPermission('VENUEALLTRMMST_LIST')}">
															<a type="button" class="btn btn-default btn-xs" href="${ctx}/trmmstgate/viewTrmmstlist/${item.mmMerchantNo}" title="终端列表查看"  ><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
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
					
					<!-- /.box-body -->
					
					<div class="box-footer clearfix">
						<tags:pagination url="${ctx}/trmmstgate/venmerlist"  queryString="tm_merchant_id=${tm_merchant_id }&tm_terminal_id=${tm_terminal_id }" page="${pageInfo}" cssClass="pull-right" />
					</div>
					<!-- /.box -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</section>
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
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/pdata/pdata.js"></script>
	<script type="text/javascript">
	$('#datepicker').datepicker({
		format: 'yyyy/mm/dd',
		startDate: '-3d',
		autoclose: true
	});
	
	</script>

</body>
</html>
