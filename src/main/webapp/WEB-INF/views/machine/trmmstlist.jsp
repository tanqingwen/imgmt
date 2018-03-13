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
<title>终端查询列表</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/css/model.css" />
<link rel="stylesheet" href="${assets }/css/siteManagement.css">
<link rel="stylesheet" href="${assets }/css/datepicker.min.css">
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
				<h1>终端查询列表</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
					<li><a href="${ctx }/trmmstgate/mermstlist">终端管理</a></li>
					<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">终端列表</a></li>
					<li class="active">终端查询列表</li>
				</ol>
			</section>


			<div class="container-fluid venue-entry">
				<div class="row outer-wrap">
					<div class="tip-img reviewList">
						<p>终端查询列表</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">
								查询表单列表
								<c:if test="${app:checkPermission('VENUEALL_TRMMST_ADD') }">
									<a href="${ctx}/machine/addTeUI/${merchantId }"><span
										class="fr">+添加</span></a>
								</c:if>
							</h3>
							<form class="form-horizontal"
								action="${ctx}/trmmstgate/findTrmmstlist" method="post">
								<div class="form-group">
									<div class="col-md-6">
										<label style="width: 100px;">终端编号：</label> <input
											class="form-control formConl" type="text" id="tm_terminal_id"
											name="tm_terminal_id" placeholder="终端编号"
											value="${tm_terminal_id }" /> <input id="tm_merchant_id"
											name="tm_merchant_id" value="${merchantId }" type="hidden">
									</div>

								</div>
								<!--<div class="clearfix"></div>-->
								<div class="col-lg-12 submit-group text-right">

									<button type="submit" class="btn-size"
										style="width: 110px; margin: 0 25px 0 15px;" id="memberShip">查询</button>
								</div>
							</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">
								查询列表
								<c:if test="${app:checkPermission('VENUEALL_TRMMST_LIST') }">
									<a href="${ctx}/machine/trunexamineList/${merchantId }"><span
										class="fr">待复核列表</span></a>
								</c:if>
							</h3>
							<div class="col-lg-12 col-md-12 clearfix">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>终端编号</th>
												<th>终端状态</th>
												<th class="textRight" style="margin-right: 40px;">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.tmTerminalId}</td>
													<!--  
											<td>${item.tmModel}</td>
											-->
													<td>${item.tmStatus=='1'?'停用':'正常'}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if
																	test="${app:checkPermission('VENUEALL_TRMMST_UPDATE')}">
																	<a
																		href="${ctx}/machine/updateTrUI/${item.tmTerminalId}"><span
																		class="edit">编辑</span></a>
																</c:if>
																<c:if
																	test="${app:checkPermission('VENUEALL_TRMMST_SHOW')}">
																	<a href="${ctx}/machine/showTe/${item.tmTerminalId}"
																		title="查看"><span class="edit">查看</span></a>
																</c:if>
																<c:if
																	test="${app:checkPermission('VENUEALL_TRMMST_DELETE')}">
																	<a href="${ctx}/machine/deleteTr/${item.tmTerminalId}"
																		onclick="return confirm('确认删除?')"><span
																		class="edit">删除</span></a>
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
								<a href="javascript:history.back(-1)" class="form-a">&lt;返回</a>
								<tags:pagination url="${ctx}/machine/trmmstlist"
									queryString="tm_merchant_id=${tm_merchant_id }&tm_terminal_id=${tm_terminal_id }"
									page="${pageInfo}" cssClass="pull-right" />
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
	<script language="javascript">
		$(function() {
			var dataPickerOp = {
				format : 'yyyy-mm-dd',
				weekStart : 1,
				days : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
				daysShort : [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
				daysMin : [ '日', '一', '二', '三', '四', '五', '六' ],
				months : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				monthsShort : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
						'9月', '10月', '11月', '12月' ],
				autoHide : true
			};
			$('[data-toggle="datepicker"]').datepicker(dataPickerOp)
		});
		$(function() {
			$(".delete").on("click", function() {
				$(this).parents("tr").remove();
			})
		})
	</script>
</body>

</html>