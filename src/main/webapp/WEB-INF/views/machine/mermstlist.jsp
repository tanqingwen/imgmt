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
		<title>终端列表</title>
		
		<link rel="stylesheet" href="${assets }/layer/shin/layer.css" />
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/MerchantList.css" />
	</head>

	<body  class="hold-transition skin-blue-light sidebar-mini">
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
				<h1>终端列表</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">终端管理</a></li>	
					<li class="active">终端列表</li>
				</ol>
			</section>
	
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><p>终端列表</p></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						
						<form class="form-horizontal" action="${ctx}/trmmstgate/venmerlist" method="post">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ListNum">商户编号：</label>
											<input class="form-control formConl line-input" type="text" id="tm_terminal_id" name="tm_terminal_id"
										placeholder="商户编号" value="${tm_terminal_id }" />
										<input  id="tm_merchant_id" name="tm_merchant_id"
										value="${merchantId }" type="hidden">
										</div>
									</div>
									
								</div>
							</div>
							
							<div class="col-lg-12 col-md-12">								
								<button type="submit" class="btn ListBtn btn-size btnSty">查询</button>
							</div>
						</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
							<div class="col-lg-12 col-md-12 clearfix" >
								<div class="checkList">
								<table class="table table-responsive">
									<thead>
										<tr>
											<th>商户编号</th>
											<th>商户名称</th>
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
															<a href="${ctx}/trmmstgate/viewTrmmstlist/${item.mmMerchantNo}" title="终端列表查看"  ><span class="check" style="margin:0;color:#333;">查看</span></a>
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
								<a href="javascript:history.go(-1)"  class="backStyle" style="font-size:18px;"><span>&lt;返回</span></a>
								<tags:pagination url="${ctx}/trmmstgate/venmerlist"  queryString="tm_merchant_id=${tm_merchant_id }&tm_terminal_id=${tm_terminal_id }" page="${pageInfo}" cssClass="pull-right" />
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
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/pdata/pdata.js"></script>
		<input type="hidden" value="3" id="test" />
         <script>
		$(function() {
				$(".delete").on("click",function(){
					$(this).parents("tr").remove();
				})
			})
		</script>
	</body>

</html>