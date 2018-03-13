<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 会员卡情况统计</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" type="text/css" href="${assets }/tongji/css/manage.css">
<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>

</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="vipCaseStat" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>会员卡情况统计</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">会员卡情况统计</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid MembershipCard">
				<div class="row outer-wrap">
					<div class="cardinfo-tip-img">
						<!-- <p>会员等级</p> -->
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-inline form-horizontal" id="thisform" action="" method="post">		
										<div class="col-md-12 marginTop">
											<div class="col-md-6" style="padding-left:0;">	
												<label for="cbAnnivDateStart" class="labelWidth">换卡开始时间：</label>											
												<div class="input-group  ">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly class="form-control dateWidth  line-input"  id="cbAnnivDateStart" name="cbAnnivDateStart" value="${cbAnnivDateStart }" onchange="buttonds()">
												</div>
											</div>
											<div class="col-lg-6 col-md-6">	
												<label class="labelWidth">换卡结束时间：</label>										
												<div class="input-group  ">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input class="form-control dateWidth line-input" readonly  id="cbAnnivDateEnd" name="cbAnnivDateEnd" value="${cbAnnivDateEnd }" onchange="buttonds()" >
												</div>
											</div>
									   </div>						
									<div class="col-md-12 marginTop">
										<div class="col-md-6">
										
											<div class="form-group">
												<label for="cbCardholderNo" class="label-holder">卡号：</label> 
												
												<input class="form-control formConl line-input" id="cbCardholderNo" name="cbCardholderNo" placeholder="卡号" value="${cbCardholderNo }" oninput="buttonds()" type="text">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="label-holder">卡种：</label> <input type="hidden"
													id="prGroupDesctext" value="${prGroupDesc }" /> <select
													class="cardinfo-select line-input" id="prGroupDesc" name="prGroupDesc"
													onchange="buttonds()">
													<option value="">===请选择===</option>
													<c:forEach var="prdGrp" items="${prdGrpList}">
														<option value="${prdGrp.prGroupDesc }">${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-12 marginTop"  style="margin-bottom:20px;">
										<div class="col-md-6">
											<div class="form-group">
												<label class="label-holder">卡状态：</label> <select
													class="cardinfo-select line-input" id="cbPlasticCd" name="cbPlasticCd"
													onchange="buttonds()">
													<option value="" ${cbPlasticCd eq '' ? 'selected' : ''}>===请选择===</option>
													<option value="NOP"
														${cbPlasticCd eq 'NOP' ? 'selected' : ''}>正常</option>
													<option value="L" ${cbPlasticCd eq 'L' ? 'selected' : ''}>挂失</option>
													<option value="D" ${cbPlasticCd eq 'D' ? 'selected' : ''}>退卡</option>
												</select>
											 </div>
										</div>
										<div class="col-md-6">
											 <div class="form-group">
												<label for="cbIdno" class="label-holder">卡主证件号：</label> <input
													class="form-control formConl line-input" id="cbIdno" name="cbIdno" placeholder="卡号" value="${cbIdno }" oninput="buttonds()" type="text" />
											</div>
										</div>
									

								</div>
							

								<div class=" submit-group marginTop clearfix">								
									<div class="fr">
										<c:if
											test="${app:checkPermission('VIPCARDSTAT_VIPCASESTAT_DOWNLOAD') }">
											<button type="submit" class="btn-size"
												style="width: 110px; margin: 0 25px 0 15px;" id="downLoad">下载</button>
										</c:if>
										<button type="submit" class="btn-size"
											style="width: 110px; margin: 0 25px 0 15px;"
											id="theIdForSubmit">查询</button>
									</div>
								</div>
							</form>
						</div>
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
										<th>卡类型</th>
										<th>卡状态</th>
										<th>余额</th>
										<th>日期</th>
										<th>卡有效期</th>
										<th>卡主证件类型</th>
										<th>卡主证件号</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}"
										varStatus="status">
										<tr>
											<td>${item.cbCardholderNo}</td>
											<td>${item.prGroupDesc}</td>
											<td>${item.cbPlasticCd}</td>
											<td>${item.cbOutstdBal}</td>
											<td>${item.cbAnnivDate}</td>
											<td>${item.cbExpiryCcyymm}</td>
											<td>${item.cbIdDesc}</td>
											<td>${item.cbIdno}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="box-footer clearfix">
								<a type="button" href="${ctx }/startTreeviewDetail/tjbb" class="form-a"
										style="margin-left: 25px;">&lt;返回</a>
								<tags:pagination url="${ctx}/vipcardStat/vipCaseStat" queryString="cbAnnivDateStart=${cbAnnivDateStart }&cbAnnivDateEnd=${cbAnnivDateEnd }&cbCardholderNo=${cbCardholderNo }&prGroupDesc=${prGroupDesc }&cbPlasticCd=${cbPlasticCd }&cbIdno=${cbIdno }" page="${pageInfo}" cssClass="pull-right"/>
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

	<!-- ./wrapper -->

	<tags:load_common_js />
	<%-- <script src="${assets}/datepicker/locales/date.js"></script> --%>
	<%-- <script src="${assets}/datepicker/locales/zh-CN.js"></script> --%>
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
        $('#cbAnnivDateStart').datepicker(dataPickerOp);
        $('#cbAnnivDateEnd').datepicker(dataPickerOp2);
        $('#cbAnnivDateStart').change(function(){
        	$('#cbAnnivDateEnd').datepicker('setStartDate', $(this).val());
        })
        $('#cbAnnivDateEnd').change(function(){
        	$('#cbAnnivDateStart').datepicker('setEndDate', $(this).val());
        })
    });
		function buttonds() {
			//$("#downLoad").attr("disabled", true);
		}
		$(document)
				.ready(
						function() {
							

							$("#theIdForSubmit")
									.click(
											function() {
												var cbAnnivDateStart = $(
														"#cbAnnivDateStart")
														.val();
												var cbAnnivDateEnd = $(
														"#cbAnnivDateEnd")
														.val();
												if (cbAnnivDateStart != ""
														&& cbAnnivDateEnd != "") {
													if (Number(cbAnnivDateStart) > Number(cbAnnivDateEnd)) {
														alert("开始时间不可以大于结束时间！");
														return false;
													}
												}
												$("#thisform")
														.attr("action",
																"${ctx}/vipcardStat/vipCaseStat");
												$("#downLoad").attr("disabled",
														false);
											});
							$("#downLoad")
									.click(
											function() {
												$("#thisform")
														.attr("action",
																"${ctx}/vipcardStat/vipCaseStatDownLoad");
											});
						});
		$(function() {
			if ($("#prGroupDesctext").val() == "") {
				$("#prGroupDesc").val($("#prGroupDesc option:first").val());
			} else {
				$("#prGroupDesc").val($("#prGroupDesctext").val());
			}
		});
	</script>
</body>
</html>
