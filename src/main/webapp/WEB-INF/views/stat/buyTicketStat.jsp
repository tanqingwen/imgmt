<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 购票信息查询</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/css/datepicker.min.css" />
<link rel="stylesheet" href="${assets}/yewuchaxun/css/model.css" />
<link rel="stylesheet"
	href="${assets}/yewuchaxun/css/ticketinfoManagement.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="buyTicketStat" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>购票信息查询</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/ywcx">业务查询</a></li>
					<li class="active">购票信息查询</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid gateReviewList buyTicketStat">
				<div class="row outer-wrap">
					<div class="tip-img ">
						<!-- 	<p>会员等级</p> -->
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-inline form-horizontal" name="thisform"
								id="thisform">
								<div class="col-md-12">
									<div class="col-md-6" style="padding-left: 0;">
										<label for="tkEffectiveDateStart" class="labelWidth">生效日期：</label>
										<div class="input-group date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span> <input readonly
												class="form-control" id="tkEffectiveDateStart"
												name="tkEffectiveDateStart" value="${tkEffectiveDateStart }"
												onchange="buttonds()"
												class="form-control dateWidth  line-input">
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<label for="tkEffectiveDateEnd" class="labelWidth">失效日期：</label>
										<div class="input-group date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span> <input readonly
												class="form-control" id="tkEffectiveDateEnd"
												name="tkEffectiveDateEnd" value="${tkEffectiveDateEnd }"
												onchange="buttonds()"
												class="form-control dateWidth line-input">
										</div>
									</div>
								</div>
								<div class="col-md-12 marginTop">
									<div class="col-md-6">
										<div class="form-group">
											<label for="tkCardNo">卡号：</label> <input
												class="form-control formConl line-input tkCardNo"
												id="tkCardNo" name="tkCardNo" placeholder="卡号"
												value="${tkCardNo }" oninput="buttonds()" type="text" />
										</div>
									</div>
								</div>

								<div class=" submit-group marginTop">

									<div class="fr">
										<button type="submit" class="btn-size"
											style="width: 110px; margin: 0 25px 0 15px;"
											id="theIdForSubmit">查询</button>
									</div>
								</div>
							</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>票号</th>
												<th>卡号</th>
												<th>票券类别</th>
												<th>生效日期</th>
												<th>失效日期</th>
												<th>最近入园日期</th>
												<th>最近离园日期</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.tkTicketId}</td>
													<td>${item.cbRemmenderNo}</td>
													<td>${item.ticketName}</td>
													<td>${item.tkEffectiveDate}</td>
													<td>${item.tkExpireDate}</td>
													<td>${item.tkActiveDate}</td>
													<td>${item.tkRetriveDate}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="box-footer clearfix">
										<a type="button" href="${ctx }/startTreeviewDetail/ywcx"
											class="form-a">&lt;返回</a>
										<tags:pagination url="${ctx}/cpceptrx/buyTicketStat"
											queryString="tkCardNo=${tkCardNo }&tkEffectiveDateStart=${tkEffectiveDateStart }&tkEffectiveDateEnd=${tkEffectiveDateEnd }"
											page="${pageInfo}" cssClass="pull-right" />
									</div>
								</div>
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
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script type="text/javascript">
	/* 初始化时间格式 */
		var formatDate = function(date) {
			var date = new Date();
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			m = m < 10 ? '0' + m : m;
			var d = date.getDate();
			d = d < 10 ? ('0' + d) : d;
			return y + '-' + m + '-' + d;
		};
		$('#tkEffectiveDateStart').val(formatDate);
		$("#tkEffectiveDateEnd").val(formatDate);
		/* 初始化时间格式-ed */
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
			var dataPickerOp2 = {
				format : 'yyyy-mm-dd',
				weekStart : 1,
				days : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
				daysShort : [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
				daysMin : [ '日', '一', '二', '三', '四', '五', '六' ],
				months : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				monthsShort : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
						'9月', '10月', '11月', '12月' ],
				autoHide : true,

			};
			$('#tkEffectiveDateStart').datepicker(dataPickerOp);
			$('#tkEffectiveDateEnd').datepicker(dataPickerOp2);
			$('#tkEffectiveDateStart').change(
					function() {
						$('#tkEffectiveDateEnd').datepicker('setStartDate',
								$(this).val());
					})
			$('#tkEffectiveDateEnd').change(
					function() {
						$('#tkEffectiveDateStart').datepicker('setEndDate',
								$(this).val());
					})
		});

		function buttonds() {
			$("#downLoad").attr("disabled", true);
		}
		$(document).ready(function() {
			$("#thisform").attr("action", "${ctx}/cpceptrx/buyTicketStat");
			$("#downLoad").attr("disabled", false);
		});

		$("#downLoad").click(function() {
			$("#thisform").attr("action", "${ctx}/cpceptrx/buyTicketDownLoad");
		});
	</script>
</body>
</html>
