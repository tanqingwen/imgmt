<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 财务报表下载</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" type="text/css"  href="${assets }/tongji/css/manage.css">
	<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>

</head>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="financiallist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>财务报表下载</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">财务报表下载</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid financialList">
				<div class="row outer-wrap">
					<div class="finacialchart-tip-img">
						<!-- 	<p>会员等级</p> -->
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form id="thisform" class="form-inline form-horizontal" action=""
								method="post">
								<div class="col-md-12 marginTop">
									<div class="col-md-6">
										<div class="form-group date firstCommission">
											<label for="ctApproveTimeStart" class="labelWidth">起始时间：</label>
											<div class="input-group">
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-calendar"></i></span> <input readonly
													class="form-control dateWidth  line-input"
													id="ctApproveTimeStart" name="ctApproveTimeStart"
													value="${ctApproveTimeStart }" onchange="buttonds()">
													<input type="hidden" id="Startsubmit">
											</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group date ">
											<label for="ctApproveTimeEnd" class="labelWidth">结束时间：</label>
											<div class="input-group">
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-calendar"></i></span> <input readonly
													class="form-control dateWidth line-input"
													id="ctApproveTimeEnd" name="ctApproveTimeEnd"
													value="${ctApproveTimeEnd }" onchange="buttonds()">
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12 marginTop">
									<div class="col-md-6">
										<div class="form-group">
											<label for="ctTranCode" class="label-holder">操作类型：</label> 
											<select
												class="finacialchart-select" id="classes"
												onchange="buttonds()" name="classes">
												<option value="" ${classes eq '' ? 'selected' : ''}>全部</option>
												<option value="zc" ${classes eq 'zc' ? 'selected' : ''}>资产</option>
												<option value="fz" ${classes eq 'fz' ? 'selected' : ''}>负债</option>
												<option value="gtong"
													${classes eq 'gtong' ? 'selected' : ''}>共同</option>
												<option value="qy" ${classes eq 'qy' ? 'selected' : ''}>权益</option>
												<option value="cb" ${classes eq 'cb' ? 'selected' : ''}>成本</option>
												<option value="sy" ${classes eq 'sy' ? 'selected' : ''}>损益</option>
											</select>
										</div>
									</div>
								</div>



								<div class=" submit-group marginTop">
									<div class="fr">
										<c:if test="${app:checkPermission('FINANCIAL_LIST_DOWNLOAD') }">
											<button type="submit" class="btn-size"
												style="width: 110px; margin: 0 25px 0 15px;" id="downLoad">下载
											</button>
										</c:if>
										<button type="submit" class="btn-size"
											style="width: 110px; margin: 0 25px 0 15px;"
											id="theIdForSubmit">查询</button>
									</div>
								</div>
							</form>
							<h3
								style="border-bottom: 2px dashed #DACA99; margin: 15px 15px; line-height: 50px;"
								class="clearfix">查询列表</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>级次</th>
												<th>科目编码</th>
												<th>科目名称</th>
												<th>币种</th>
												<th>金额</th>
												<th>批注</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}"
												varStatus="status">
												<tr>
													<%-- 													<td>${(pageInfo.pageNum-1)*pageInfo.pageSize+(status.index+1)}</td> --%>
													<td>${item.level}</td>
													<td>${item.subjectCode}</td>
													<td>${item.subjectName}</td>
													<%-- 				                                    <td>${item.classes}</td> --%>
													<td>${item.currency}</td>
													<td>${item.money}</td>
													<td>${item.postil}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<div class="box-footer clearfix">
									<a href="${ctx }/startTreeviewDetail/tjbb" class="form-a" style="margin-left: 25px;">&lt;返回</a>							
									<tags:pagination url="${ctx }/financial/list" page="${pageInfo}"
									queryString="ctApproveTimeStart=${ ctApproveTimeStart}&ctApproveTimeEnd=${ctApproveTimeEnd }&classes=${classes }"
									cssClass="pull-right" />
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
	</div>
	<tags:load_common_js />
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/pdata/pdata.js"></script>
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
																"${ctx }/financial/list");
												$("#downLoad").attr("disabled",
														false);
											});
							$("#downLoad")
									.click(
											function() {
												$("#thisform")
														.attr("action",
																"${ctx}/financial/listDownLoad");
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
