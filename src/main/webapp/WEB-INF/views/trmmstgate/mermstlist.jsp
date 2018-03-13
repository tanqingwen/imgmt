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
		<link rel="stylesheet" href="${assets }/layer/shin/layer.css" />
		<title>终端管理</title>
		<link rel="stylesheet" href="${assets }/css/MerchantManagement.css" />
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
				<h1>终端管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
					<li class="active">终端管理</li>
				</ol>
			</section>
	
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><p>终端管理</p></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						
						<form class="form-horizontal" action="${ctx}/trmmstgate/mermstlist" method="POST">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementNum">场馆号码：</label><input class="form-control formConl line-input" id="mm_merchant_no" name="mm_merchant_no"
										placeholder="场馆号码" value="${mm_merchant_no }" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementName">场馆名称：</label><input class="form-control formConl line-input" id="mm_biz_name" name="mm_biz_name"
										placeholder="场馆名称" value="${mm_biz_name}" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementAbb">场馆简称：</label><input class="form-control formConl line-input" type="text" id="mm_stmt_name" name="mm_stmt_name"
										placeholder="场馆简称" value="${mm_stmt_name}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementGrade">场馆等级：</label><!--<input class="form-control formConl line-input" type="text" name="ManagementGrade" id="ManagementGrade" />-->                       
											<select name="mmPmtMode" id="mmPmtMode" class="ManagementGrade">
			 						  			<option value="0">请选择级别...</option>
			 									<!-- <option value="1">一级 - 欢乐大世界</option> -->
			 									<option value="1">二级 - 场馆</option>
			 									<option value="2">三级 - 子场馆</option>
			 								</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">								
								<button class="btn ManagementBtn btn-size btnSty" type="submit">查询</button>
							</div>
						</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
							
					

							<div class="col-lg-12 col-md-12 clearfix" >
								<div class="checkList">
								<table class="table table-responsive">
									<thead>
										<tr>
											<th>商户号码</th>
											<th>商户商户名称</th>
											<th>商户简称</th>
											<th>操作</th>
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
														<c:if test="${app:checkPermission('VENUEALL_TRMMST_LIST')}">
															<!--  
															<a type="button" class="btn btn-default btn-xs" href="${ctx}/trmmstgate/viewlist/${item.mmMerchantNo}" title="查看"  ><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
															-->
															
															<a href="${ctx}/trmmstgate/viewmermstlist/${item.mmMerchantNo}" title="商户列表查看"  ><span class="check">查看</span></a>
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
							<div class="box-footer clearfix" style="border:none;">
								<a href="${ctx }/startTreeviewDetail/cggl"  class="backStyle" style="font-size:18px;"><span>&lt;返回</span></a>
								<tags:pagination url="${ctx}/trmmstgate/mermstlist"  queryString="mm_merchant_no=${mm_merchant_no }&mm_biz_name=${mm_biz_name }&mm_stmt_name=${mm_stmt_name }&mm_phy_state=${mm_phy_state }" page="${pageInfo}" cssClass="pull-right" />
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
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/pdata/pdata.js"></script>
		<input type="hidden" value="3" id="test" />
		<!-- <script src="js/layer.js"></script>
         <script> -->
		$(function() {
				$(".delete").on("click",function(){
					$(this).parents("tr").remove();
				})
			})
		</script>
	</body>

</html>