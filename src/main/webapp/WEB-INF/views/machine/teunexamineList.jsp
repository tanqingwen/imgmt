<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>综合管理系统 | 终端管理-待复核列表</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
<link rel="stylesheet" href="${assets }/css/siteManagement.css">
<link rel="stylesheet" href="${assets }/css/model.css" />

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
				<h1>终端管理-待复核列表</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
					<li><a href="${ctx }/trmmstgate/mermstlist">终端管理</a></li>
					<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">终端列表列表</a></li>
					<li><a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">终端查询列表</a></li>
					<li class="active">待复核列表</li>
				</ol>
			</section>

			<div class="container-fluid ReviewListC">
				<div class="row outer-wrap">
					<div class="tip-img reviewList">
						<p style="line-height:35px;">待复核列表</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-horizontal"
								action="${ctx}/machine/waunexamineList" method="post">
								<div class="form-group">
									<div class="col-md-6">
										<label>商户号码：</label> <input
											class="form-control formConl line-input" type="text"
											id="tm_merchant_id" name="tm_merchant_id" type="text"
											value="${merchantId }" readonly="readonly" />
									</div>
									<div class="col-md-6">
										<label>终端号码：</label> <input
											class="form-control formConl line-input" type="text"
											id="tm_terminal_id" name="tm_terminal_id" placeholder="终端号码" />

									</div>
								</div>

								<!--<div class="clearfix"></div>-->

								<div class=" submit-group fr">
									<!--	<a href="JavaScript:history.Go(-1)" class="form-a">&lt;返回</a>-->
									<button type="submit" class="btn-size"
										style="width: 110px; margin: 0 25px 0 15px;" id="memberShip">查询</button>
								</div>
							</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">
								终端列表
							</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>选择</th>
												<th>终端编号</th>
												<th>终端类型</th>
												<th>终端状态</th>
												<th>当前状态</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td><input type='checkbox' name='choose' id="choose"
														value="${item.tmTerminalId}"></td>
													<td>${item.tmTerminalId}</td>
													<td>${item.tmModel}</td>
													<td>${item.tmStatus=='1'?'停用':'正常'}</td>
													<td><c:if test="${item.tmApplStatus=='U'}">
															终端更新-录入
														</c:if> <c:if test="${item.tmApplStatus=='A'}">
															终端添加-录入
														</c:if></td>

												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>

								<div class="col-md-12">
									<c:if test="${app:checkPermission('VENUEALLTRMMST_VIEW') }">
										<button id="theIdForSearch" class="btn">查询</button>
									</c:if>
									<c:if test="${app:checkPermission('VENUEALLTRMMST_AUTH') }">
										<button id="theIdexamine" class="btn">复核</button>
									</c:if>
									<c:if test="${app:checkPermission('VENUEALLTRMMST_DELETE') }">
										<button id="theIdForDel" class="btn">删除</button>
									</c:if>								
										
										<a href="javascript:history.back(-1)" style="font-size:18px;color:#333;">&lt;返回</a>								
									<tags:pagination url="${ctx}/machine/trunexamineList"
										queryString="tm_merchant_id=${merchantId }&tm_terminal_id=${tm_terminal_id }"
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
	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/pdata/pdata.js"></script>
	<script src="${assets }/js/datepicker.min.js"></script>


	<script type="text/javascript">
		<!--添加-->
			var currentStaffId = "${currentStaffId}";
			$(document)
					.ready(
							function() {

								$("#theIdForDel")
										.click(
												function() {
													var machineNo = $(
															"input[name=choose]:checked")
															.val();
													if ($("input[name=choose]:checked").length == 0) {
														alert("请选择您要删除的终端！");
														return;
													} else if ($("input[name=choose]:checked").length > 1) {
														alert("一次只能删除一个终端！");
														return;
													}
													if (confirm("您确定要删除该终端？")) {
														location.href = "${ctx}/machine/teunexamineDelete/"
																+ machineNo;
													}

												});

								//待复核列表-查询详情
								$("#theIdForSearch")
										.click(
												function() {
													var machineNo = $(
															"input[name=choose]:checked")
															.val();
													if ($("input[name=choose]:checked").length == 0) {
														alert("请选择您要查询的终端！");
														return;
													} else if ($("input[name=choose]:checked").length > 1) {
														alert("一次只能查询一个终端！");
														return;
													} else {
														location.href = "${ctx}/machine/teunexamineshow/"
																+ machineNo;
													}

												});

								//待复核列表-复核 
								$("#theIdexamine")
										.click(
												function() {
													var machineNo = $(
															"input[name=choose]:checked")
															.val();
													if ($("input[name=choose]:checked").length == 0) {
														alert("请选择您要复核的终端！");
														return;
													} else if ($("input[name=choose]:checked").length > 1) {
														alert("一次只能复核一个终端！");
														return;
													} else {
														$
																.ajax({
																	type : "POST",
																	url : "${ctx}/machine/getMachineSetUser",
																	dataType : "text",
																	data : {
																		machineNo : machineNo
																	},
																	success : function(
																			data) {
																		if (data == currentStaffId) {
																			alert("不能复核自己录入的记录！");
																		} else {
																			if (confirm("确定复核终端  "
																					+ machineNo
																					+ "？")) {
																				location.href = "${ctx}/machine/trexamine/"
																						+ machineNo;
																			}
																		}
																	}
																});
													}

												});

							});
		</script>
</body>

</html>