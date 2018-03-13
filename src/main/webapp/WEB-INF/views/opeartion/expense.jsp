<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 会员卡消费统计</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" type="text/css" href="${assets }/tongji/css/manage.css">
</head>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<body class="hold-transition skin-blue-light sidebar-mini"
	onload="getNowFormatDate()">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="expense" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>会员卡消费统计</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">会员卡消费统计</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid consumption">
				<div class="row outer-wrap">
					<div class="consumecount-tip-img">
						<!-- 	<p>会员等级</p> -->
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-inline form-horizontal" id="thisform" action="" method="post"> 
								<div class="col-md-12 marginTop">
									<div class="col-md-6">
										<div class="form-group">
											<label>姓名：</label> <input
												class="form-control formConl line-input" id="cbEmbossname"
												name="cbEmbossname" placeholder="姓名"
												value="${cbEmbossname }" oninput="buttonds()" type="text" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>场馆号：</label> <input
												class="form-control formConl line-input" id="tmDbaName"
												name="tmDbaName" placeholder="场馆号" value="${tmDbaName }"
												oninput="buttonds()" type="text" />
										</div>
									</div>
								</div>
								<div class="col-md-12 marginTop">
									<div class="col-md-6">
										<div class="form-group">
											<label>卡号：</label> <input
												class="form-control formConl line-input" id="ctCardNumber"
												name="ctCardNumber" placeholder="卡号"
												value="${ctCardNumber }" oninput="buttonds()" type="text">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>卡种：</label> <select class="consume-select line-input">
												<option>====请选择====</option>
												<c:forEach var="item" items="${prdgrp}">
													<option value="${item.prProdctGroup}"
														${ prProdctGroup eq 'item.prProdctGroup' ? 'selected' :''}>${item.prProdctGroup}-${item.prGroupDesc }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-12 marginTop">
									<div class="col-md-6" style="padding-left: 0;">
										<label for="rechargeStart" class="labelWidth ">交易起始时间：</label>
										<div class="input-group date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span> 
												<input  class="form-control dateWidth  line-input" id="ctDisputeDateStart"
												name="ctDisputeDateStart" value="${ctDisputeDateStart }"
												 onchange="buttonds()">
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<label for="rechargeEnd" class="labelWidth">交易结束时间：</label>
										<div class="input-group date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span> 
												<input class="form-control dateWidth line-input" type="text" size="18" id="ctDisputeDateEnd" name="ctDisputeDateEnd" value="${ctDisputeDateEnd }" onchange="buttonds()">
										</div>
									</div>
								</div>
								<div class="col-md-12 marginTop">
									<div class="col-md-6">
										<div class="form-group">
											<label>数据上传时间：</label> <select class="line-input">
												<option>所选交易开始时间前</option>
												<option>所选交易开始时间前</option>
											</select>
										</div>
									</div>
								</div>
								<div class=" submit-group col-md-12">								
									<div class="fr marginTop">
										<c:if
											test="${app:checkPermission('OPEARTION_EXPENSE_DOWNLOAD') }">
											<button type="submit"
												style="width: 110px; margin: 0 25px 0 15px;"
												class="btn-size" id="downLoad">下载</button>
										</c:if>
										<button type="submit" class="btn-size"
											style="width: 110px; margin: 0 25px 0 15px;" id="memberShip">查询</button>
									</div>
								</div>
								
							</form>
						</div>

						<h3
							style="border-bottom: 2px dashed #DACA99; margin: 15px 15px; line-height: 50px;"
							class="clearfix">查询列表</h3>
						<div class="col-lg-12 col-md-12 clearfix tableContent">
							<div class="checkList">
								<table class="table table-responsive">
									<thead>
										<tr>
											<th>卡号</th>
											<th>卡种</th>
											<th>姓名</th>
											<th>终端号</th>
											<th>场馆号</th>
											<th>交易时间</th>
											<th>上送时间</th>
											<th>交易金额</th>
											<th>余额</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${pageInfo.list}"
											varStatus="status">
											<tr>
												<td>${item.ctCardNumber}</td>
												<td>${item.prGroupDesc}</td>
												<td>${item.cbEmbossname}</td>
												<td>${item.ctTerminalId}</td>
												<td>${item.ctMerchantId}</td>
												<td><tags:format_string patten="####-##-## ##:##:##"
														value="${item.ctDisputeDate}${item.ctTranZone}" /></td>
												<td><tags:format_string patten="####-##-## ##:##:##"
														value="${item.ctApproveTime}" /></td>
												<td>${item.ctBillCurrAmt}</td>
												<td>${item.ctCardAmount}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
			<a type="button" href="${ctx }/startTreeviewDetail/tjbb" class="form-a" style="margin-left: 25px;">&lt;返回</a>
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
        $('#ctDisputeDateStart').datepicker(dataPickerOp);
        $('#ctDisputeDateEnd').datepicker(dataPickerOp2);
        $('#ctDisputeDateStart').change(function(){
        	$('#ctDisputeDateEnd').datepicker('setStartDate', $(this).val());
        })
        $('#ctDisputeDateEnd').change(function(){
        	$('#ctDisputeDateStart').datepicker('setEndDate', $(this).val());
        })
    });
		 function buttonds() { 
			//$("#downLoad").attr("disabled", true);
		}
		/* $('#ctApproveTimeStart').datepicker({
			format: 'yyyymmdd',
			autoclose: true
		});
		$('#ctApproveTimeEnd').datepicker({
			format: 'yyyymmdd',
			autoclose: true
		}); */
		$(document)
				.ready(
						function() {
						
							$("#theIdForSubmit").click(
											function() {
												
												$("#thisform")
														.attr("action",
																"${ctx}/opeartion/expense");
												$("#downLoad").attr("disabled",
														false);
											});
							$("#downLoad")
									.click(
											function() {
												$("#thisform")
														.attr("action",
																"${ctx}/opeartion/expenseDownLoad");
											});
						});
		$(function() {
			if ($("#ctUserCreatetext").val() == "") {
				$("#prProdctGroup").val($("#prProdctGroup option:first").val());
			} else {
				$("#prProdctGroup").val($("#ctUserCreatetext").val());
			}
		});
	</script>
</body>
</html>
