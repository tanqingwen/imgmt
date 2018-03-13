<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 会员卡换卡统计</title>
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
		<tags:main_sidebar active="vipChangeStat" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>会员卡换卡统计</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">会员卡换卡统计</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid changeCard">
				<div class="row outer-wrap">
					<div class="changecard-tip-img">
						<!-- 	<p>会员等级</p> -->
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-inline form-horizontal" id="thisform" action="" method="post">							
									<div class="col-md-12">
										<div class="col-md-6">
											<div class="form-group">
												<label>旧卡号：</label> <input
													class="form-control formConl line-input" type="text"
													placeholder="旧卡号" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>新卡号：</label> 
												<input class="form-control formConl line-input" type="text" placeholder="新卡号"  />
											</div>
										</div>
									</div>
										<div class="col-md-12 marginTop ">
											<div class="col-md-6 date " style="padding-left:0;">	
												<label for="rechargeStart" class="labelWidth">换卡开始时间：</label>											
												<div class="input-group date ">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly="readonly" type="text" size="18" id="cl_timestampStart" name="cl_timestampStart" value="${cl_timestampStart }" onchange="buttonds()" class="form-control dateWidth  line-input">
												</div>
											</div>
											<div class="date firstCommissio col-lg-6 col-md-6">	
												<label for="rechargeEnd"  class="labelWidth">换卡结束时间：</label>										
												<div class="input-group date firstCommission">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly="readonly" type="text" size="18" id="cl_timestampEnd" name="cl_timestampEnd" value="${ cl_timestampEnd}" onchange="buttonds()" class="form-control dateWidth line-input" >
												</div>
											</div>
									   </div>						
								<div class=" submit-group  marginTop">
									<div class="box-footer"></div>								
									<div class="fr">
									
										 <c:if test="${app:checkPermission('VIPCARDSTAT_VIPCHANGESTAT_DOWNLOAD') }">
											<button type="submit" class="btn-size" style="width: 110px; margin: 0 25px 0 15px;" id="downLoad">下载</button>
										 </c:if>
											<button type="submit" class="btn-size" style="width: 110px; margin: 0 25px 0 15px;" id="theIdForSubmit">查询</button>
									</div>
								</div>
							</form>
						</div>
					</div>			
					<h3
						style="border-bottom: 2px dashed #DACA99; margin: 15px 30px; line-height: 80px;"
						class="clearfix">查询列表</h3> 
					<div class="col-lg-12 col-md-12 clearfix tableContent">
						<div class="checkList">
							<table class="table table-responsive">
								<thead>
									<tr>
										<th>旧卡号</th>
										<th>新卡号</th>
										<th>姓名</th>
										<th>身份证号</th>
										<th>换卡日期</th>
										<th>换卡时间</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}"
										varStatus="status">
										<tr>
											<td>${item.cl_old_card}</td>
											<td>${item.cl_new_card}</td>
											<td>${item.CB_EMBOSSNAME}</td>
											<td>${item.CB_IDNO}</td>
											<td>${item.cl_timestamp}</td>
											<td>${item.cl_timestamp}</td>
											<td>${item.CT_FEE_AMOUNT }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<a type="button" href="${ctx }/startTreeviewDetail/tjbb" class="form-a" style="margin-left: 25px;">&lt;返回</a>
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
        $('#cl_timestampStart').datepicker(dataPickerOp);
        $('#cl_timestampEnd').datepicker(dataPickerOp2);
        $('#cl_timestampStart').change(function(){
        	$('#cl_timestampEnd').datepicker('setStartDate', $(this).val());
        })
        $('#cl_timestampEnd').change(function(){
        	$('#cl_timestampStart').datepicker('setEndDate', $(this).val());
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
												var mmAgreementStartDate = $(
														"#ctApproveTimeStart")
														.val();
												var mmAgreementEndDate = $(
														"#ctApproveTimeEnd")
														.val();
												if (mmAgreementStartDate != ""
														&& mmAgreementEndDate != "") {
													if (Number(mmAgreementStartDate) > Number(mmAgreementEndDate)) {
														alert("交易起始时间不可以大于交易结束时间！");
														return false;
													}
												}
												$("#thisform")
														.attr("action",
																"${ctx}/vipcardStat/vipChangeStat");
												$("#downLoad").attr("disabled",
														false);
											});
							$("#downLoad")
									.click(
											function() {
												$("#thisform")
														.attr("action",
																"${ctx}/vipcardStat/vipChangeStatDownLoad");
											});
						});
		$(function() {
			if ($("#ctUserCreatetext").val() == "") {
				$("#cl_auth_user_id").val(
						$("#cl_auth_user_id option:first").val());
			} else {
				$("#cl_auth_user_id").val($("#ctUserCreatetext").val());
			}
		});
	</script>
</body>
</html>
