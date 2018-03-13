<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 商户维护</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/ShWeihu/css/Merchant.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="pressmv" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>商户维护</h1> 
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/cpmermst/merupdPreserve">商户维护</a></li>
					<li class="active">商户维护</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid venue-entry">
				<div class="row outer-wrap">
					<div class="tip-img">
						<p>商户维护</p>
					</div>
					<div class="content">
						<div class="main">
							<form id="defaultForm" name="defaultForm" class="form-horizontal">
								<h3 style="border-bottom: 2px dashed #45a0e0;">商品维护</h3>
								 <!-- <div class="table-responsive"> -->
							<div class="col-lg-12 col-md-12 clearfix tableContent" style="display: block;">
								<div class="checkList">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>商户号码</th>
				                                <th>商户名称</th>
				                                <th>商户简称</th>
											    <th class="text-right">操作</th>
											</tr>
										</thead>
										<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.mmMerchantNo}</td>				                                  
				                                    <td>${item.mmBizName}</td>
				                                    <td>${item.mmStmtName}</td>
													<td>
														<div class="" role="toolbar">
															 <div class="btn-group"> 
															    <c:if test="${app:checkPermission('MERUPD_MAINTAIN_SHOW') }">
																	<a type="button" class="btn-xs" title="查看" href="${ctx}/cpmermst/merupdPreserve_search/${item.mmMerchantNo}"><span class="" style="color:#333;" aria-hidden="true">查看</span></a>
																</c:if>
															    <c:if test="${app:checkPermission('MERUPD_MAINTAIN_AUTHOH') }">
																	<a type="button" class="btn-xs" title="授权" onclick="theIdForImpower('${item.mmMerchantNo}')" ><span class="" style="color:#333;" aria-hidden="true">授权</span></a>
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
								<div class="col-md-12  marginBottom">
									<a id="fanhui" href="${ctx}/cpmermst/merupdPreserve" class="form-a" >&lt;返回</a>
								</div>
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/merchant/list" page="${pageInfo}" cssClass="pull-right"/>
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
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/moment/moment.min.js"></script>
	<script type="text/javascript">
		var currentStaffId = "${currentStaffId}";
		function theIdForImpower(merchantNo) {
			$
					.ajax({
						type : "POST",
						url : "${ctx}/staff/getCurrentVenueStaffId",
						dataType : "text",
						data : {
							merchantNo : merchantNo
						},
						success : function(data) {
							if (data == currentStaffId) {
								alert("不能复核自己录入的记录！");
							} else {
								if (confirm("确定授权？")) {
									location.href = "${ctx}/staff/dataMerupdEntering_authorize/"
											+ merchantNo;
								}
							}
						}
					});
		}

		$(document).ready(
				function() {
					_.templateSettings = {
						interpolate : /\<\@\=(.+?)\@\>/gim,
						evaluate : /\<\@(.+?)\@\>/gim,
						escape : /\<\@\-(.+?)\@\>/gim
					};

					$('.firstCommission').datepicker({
						format : 'yyyymmdd',
						autoclose : true
					});

					var mmPmtMode = "0"; //默认0等级
					$.ajax({
						async : false,
						type : "POST",
						url : "${ctx}/cpmermst/search_mermst_Data1",
						dataType : "json",
						data : {
							mmPmtMode : mmPmtMode
						},
						success : function(data) {
							if (data.status == "OK") {
								mmChainAccno = data.value;
								var obj = document
										.getElementById('mmChainAccno');
								$("#mmChainAccno").html(
										_.template(
												$("#tplMmChainAccno").html(),
												mmChainAccno));
							} else {
								alert("归属场馆错误");
							}
						}
					});
				});
		$("#fanhui").click(function(){
			location.href="${ctx}/cpmermst/merupdPreserve";
		});
	</script>

	<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
			<@ }); @>
		</script>

</body>
</html>
