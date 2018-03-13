<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 退票统计</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" type="text/css" href="${assets }/tongji/css/manage.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="returnTicketStat" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>退票统计</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">退票统计</li>
				</ol>
			</section>
			<!-- Main content -->
			<div class="container-fluid returnTicket">
				<div class="row outer-wrap">
					<div class="refund-tip-img">
						<!-- 	<p>会员等级</p> -->
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-inline form-horizontal"  name="thisform" id="thisform" action="" method="post">
									<div class="row">
										<div class="col-md-6" style="padding-left:0;">	
										<label for="ctApproveTimeStart" class="labelWidth date ">起始时间：</label>											
												<div class="input-group date ">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly  class="form-control line-input" id="ctApproveTimeStart" name="ctApproveTimeStart" value="${ctApproveTimeStart }" onchange="buttonds()" class="form-control dateWidth  line-input" >
												</div>
											</div>
											<div class="col-lg-6 col-md-6">	
											<label for="ctApproveTimeEnd" class="labelWidth">结束时间：</label>										
												<div class="input-group date firstCommission">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly class="form-control line-input" id="ctApproveTimeEnd" name="ctApproveTimeEnd" value="${ctApproveTimeEnd }" onchange="buttonds()" class="form-control dateWidth line-input">
												</div>
											</div>
									</div>
									<div class="row marginTop">
										<div class="col-md-6">
											<div class="form-group">
												<label>卡号：</label> <input
													class="form-control formConl line-input" id="ctCardNumber"
													name="ctCardNumber" placeholder="卡号"
													value="${ctCardNumber }" oninput="buttonds()" type="text">
											</div>
										</div>
										<%-- <div class="col-md-6">
											<div class="form-group">
												<label>操作员：</label> <select name=""
													class="ticketcount-select">
													<option>====请选择====</option>
													<c:forEach var="item" items="${aclUsers}" varStatus="status">
														<option value="${item.userId}">${item.userId}-${item.userName }</option>
													</c:forEach>
												</select>
											</div>
										</div> --%>
									</div>
								

							

								<div class=" submit-group  marginTop">								
									<!-- 	<a href="JavaScript:history.Go(-1)" class="form-a">&lt;返回</a> -->
									<div class="fr">
										<c:if test="${app:checkPermission('CPCEPTRX_RETURNTICKETSTAT_DOWNLOAD') }">
			                    			<button type="submit" class="btn-size " id="downLoad" style="width: 110px; margin: 0 25px 0 15px;"> 下载</button>
			                    		</c:if>
									
										<button type="submit" class="btn-size"
											style="width: 110px; margin: 0 25px 0 15px;"
											id="theIdForSubmit">查询</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">折扣列表<span class="fr toggle">+</span></h3> -->
					<h3
						style="border-bottom: 2px dashed #DACA99; margin: 15px 15px; line-height: 50px;"
						class="clearfix">查询列表</h3>
					<div class="col-lg-12 col-md-12 clearfix tableContent">
						<div class="checkList">
							<table class="table table-responsive">
								<thead>
									<tr>
										<th>票号</th>
										<th>卡号</th>
										<th>姓名</th>
										<th>卡类型</th>
										<th>日期</th>
										<th>时间</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}"
										varStatus="status">
										<tr>
											<td>${item.ctUserStatus1}</td>
											<td>${item.ctCardNumber}</td>
											<td>${item.ctUserCreate}</td>
											<td>${item.ctUserStatus2}</td>
											<td><tags:format_string patten="####-##-##"
													value="${item.ctApproveTime}" /></td>
											<td><tags:format_string patten="##:##:##"
													value="${fn:substring(item.ctApproveTime, 8, 14)}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="box-footer clearfix">
								<a type="button" href="${ctx }/startTreeviewDetail/tjbb" class="form-a"
									style="margin-left: 25px;">&lt;返回</a>
								<tags:pagination url="${ctx}/cpceptrx/returnTicketStat"
									queryString="ctUserCreate=${ctUserCreate }&ctApproveTimeStart=${ctApproveTimeStart }&ctApproveTimeEnd=${ctApproveTimeEnd }&ctCardNumber=${ctCardNumber }"
									page="${pageInfo}" cssClass="pull-right" />
							</div>
						</div>
						</form>
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

	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script type="text/javascript">
	$(function() {
        var dataPickerOp = {
            format: 'yyyy-mm-dd',
            weekStart: 1,
            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            autoHide: true
        };
        var dataPickerOp2 = {
	            format: 'yyyy-mm-dd',
	            weekStart: 1,
	            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
	            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
	            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
	            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
	            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
	            autoHide: true,
	           
	        };
        $('#ctApproveTimeStart').datepicker(dataPickerOp);
        $('#ctApproveTimeEnd').datepicker(dataPickerOp2);
        $('#ctApproveTimeStart').change(function(){
        	$('#ctApproveTimeEnd').datepicker('setStartDate', $(this).val());
        })
        $('#ctApproveTimeEnd').change(function(){
        	$('#ctApproveTimeStart').datepicker('setEndDate', $(this).val());
        })
    });
		function buttonds() {
			//$("#downLoad").attr("disabled", true);
		}
		$(document)
				.ready(
						function() {
						

							$("#theIdForSubmit").click(
											function() {
												
												$("#thisform")
														.attr("action",
																"${ctx}/cpceptrx/returnTicketStat");
												$("#downLoad").attr("disabled",
														false);
											});
							$("#downLoad").click(
											function() {
												$("#thisform")
														.attr("action",
																"${ctx}/cpceptrx/returnTicketDownLoad");
											});
						});
		$(function() {
			if ($("#ctUserCreatetext").val() == "") {
				$("#ctUserCreate").val($("#ctUserCreate option:first").val());
			} else {
				$("#ctUserCreate").val($("#ctUserCreatetext").val());
			}
		});
	</script>
</body>
</html>
