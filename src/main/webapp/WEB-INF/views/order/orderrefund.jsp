<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 订单多方式退票</title>
<tags:head_common_content />
<style type="text/css">
.refoundbtn:hover {
	color: #70C8F3;
	cursor: pointer;
}
</style>
<link rel="stylesheet" href="${assets }/css/datepicker.min.css" />
<link rel="stylesheet" href="${assets}/yewuchaxun/css/model.css" />
<link rel="stylesheet"
	href="${assets}/yewuchaxun/css/businessManagement.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="recharge" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>订单多方式退票</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业 </a></li>
					<li class="active">订单多方式退票</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid orderBack">
				<div class="row outer-wrap">
					<div class="tip-img">
						<p>订单多方式退票</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-inline form-horizontal" id="defaultForm"
								name="defaultForm" action="${ctx}/yworder/yworderbuyID"
								method="POST">
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>订单号：</label> <input
												class="form-control formConl line-input" id="orderId"
												name="orderId" placeholder="订单号"
												value="${yworder.hwOrderId}" type="text" />
										</div>
									</div>
								</div>
								<!-- </div> -->

								<div class="col-lg-12 col-md-12 marginTop">
									<div class=" submit-group fr">
										<button type="submit" class="btn-size"
											style="width: 110px; margin: 0 25px 0 15px;"
											id="theIdForSubmit">查询</button>
									</div>
								</div>
								<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">
									订单列表<span class="fr toggle"></span>
								</h3>
							</form>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>订单号</th>
												<th>手机号</th>
												<th>订单来源</th>
												<th>支付方式</th>
												<th>金额</th>
												<th>支付时间</th>
												<th>操作</th>
												<th style="display: none">
												<th>
											</tr>
										</thead>

										<tbody>

											<%-- <c:forEach var="item" items="${yworder}"> --%>
											<tr>

												<c:forEach var="yworder" items="${YwOrder.list}">
													<tr>

														<td>${yworder.hwOrderId}</td>
														<td>${yworder.hwMobilePhone}</td>
														<td><c:if test="${yworder.hwChannel eq 1}">微信公众号</c:if>
															<c:if test="${yworder.hwChannel eq 2}">APP</c:if> <c:if
																test="${yworder.hwChannel eq 3}">现场</c:if> <c:if
																test="${yworder.hwChannel eq 4}">官网</c:if> <c:if
																test="${yworder.hwChannel eq 5}">驴妈妈</c:if> <c:if
																test="${yworder.hwChannel eq 10}">自助终端</c:if></td>
														<td><c:if test="${yworder.hwPayType eq 'JSAPI' }">公众号微信支付</c:if>
															<c:if
																test="${yworder.hwPayType eq 'CASH' or yworder.hwPayType eq 'cash' }">现金支付</c:if>
															<c:if test="${yworder.hwPayType eq 'APP' }">APP微信支付</c:if>
															<c:if test="${yworder.hwPayType eq 'YLTLH5' }">H5银行卡快捷支付</c:if>
															<c:if test="${yworder.hwPayType eq 'XC_WX' }">现场微信扫码支付</c:if>
															<c:if test="${yworder.hwPayType eq 'XC_ZFB' }">现场支付宝扫码支付</c:if>
															<c:if test="${yworder.hwPayType eq 'POS' }">POS机刷卡支付	</c:if>
															<c:if test="${yworder.hwPayType eq 'TLWG' }">官网网银支付</c:if>
															<c:if test="${yworder.hwPayType eq 'TLKJ' }">官网银行卡支付</c:if>
															<c:if test="${yworder.hwPayType eq 'WEB_WX_TL' }">官网微信扫码支付</c:if>
															<c:if test="${yworder.hwPayType eq 'WEB_ZFB_TL' }">官网支付宝扫码支付</c:if>
															<c:if test="${yworder.hwPayType eq 'ZD_POS' }">自助终端pos支付</c:if>
														</td>
														<td>${yworder.hwMoney}</td>
														<td><fmt:parseDate value="${yworder.hwOrderPaytime}"
																pattern="yyyyMMdd HHmmss" var="receiveDate"></fmt:parseDate>
															<fmt:formatDate value="${receiveDate}"
																pattern="MMdd HH:mm"></fmt:formatDate></td>
														<td><c:if
																test="${app:checkPermission('ORDER_REFUND_LIST')}">
																<!-- 																	<a href="#" onclick="refundticket()">退票</a> -->
																<div class="refoundbtn" onclick="refound(this)">退票</div>
															</c:if></td>
														<td style="display: none">${yworder.hwPayType}</td>
														<td style="display: none">${yworder.hwPaymentListid}</td>
													</tr>

													<%-- </c:forEach> --%>

												</c:forEach>
										</tbody>
									</table>
									<div class="box-footer clearfix">
										<a type="button" href="${ctx }/startTreeviewDetail/ywcx"
											class="form-a">&lt;返回</a>
										<tags:pagination url="${ctx}/yworder/orderrefund"
											page="${YwOrder}" cssClass="pull-right" />
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
/* 	  console.log('${YwOrder.list}'); */
		function refound(obj) {
			var r = confirm("确定退票？");
			if (r == true) {
				var PaymentListid = '';
				console.log("obj" + obj);
				console.log($(obj).parent());
				var orderId = $(obj).parent().parent().children().eq(0).text();
				var paytype = $(obj).parent().parent().children().eq(7).text();
				console.log(orderId);
				console.log(paytype);
				/* 	       var orderId = $("#orderId").val(); */
				if (paytype == 'POS') {
					var Amount = $(obj).parent().parent().children().eq(4)
							.text();
					var OldTraceNumber = $(obj).parent().parent().children()
							.eq(8).text();
					PaymentListid = demo(Amount, OldTraceNumber);
					if (PaymentListid == "" || PaymentListid == undefined
							|| PaymentListid == null) {
						alert('POS退款失败');
						return false;
					}
				}
				if (paytype == 'ZNPOS') {
					alert("此订单为智能pos支付，只能在智能pos机退票哦");
					return false;
				}
				if (paytype == 'JSAPI') {
					$
							.ajax({
								async : false,
								type : "POST",
								url : 'http://58.246.52.102:2015/openapi/ticket/refund',
								dataType : 'JSON',
								data : {
									'data' : '{orderId:' + orderId + '}'
								},
								success : function(data) {
									console.log(data);
									if (data.status == 'success') {
										alert('退票成功');

									} else {
										alert(data.error);
									}
								}
							});
				} else {
					$.ajax({
						async : false,
						type : "POST",
						url : "${ctx}/cpticket/tonglian/refund/order",
						dataType : "json",
						data : {
							orderId : orderId,
							PaymentListid : PaymentListid
						},
						success : function(data) {
							console.log(data);
							if (data.status == "OK") {
								alert("退票成功");
							} else {
								alert(data.comment);
							}
						},
						error : function(data) {
							console.log(data)
						}
					});
				}
				location.reload();
				return false;
			}
		}

		function demo(Amount, OldTraceNumber) {
			try {
				var request = new ActiveXObject("ALLINPAY.RequestData");
				var response = new ActiveXObject("ALLINPAY.ResponseData");
				var mis = new ActiveXObject("ALLINPAY.MisPos");
				request.PutValue("CardType", "01");
				request.PutValue("TransType", "03");
				request.PutValue("Amount", Amount);
				request.PutValue("OldTraceNumber", OldTraceNumber);
				var result = mis.TransProcess(request, response);
				var rejcode = response.GetValue("Rejcode");
				var OldTraceNumber = response.GetValue("OldTraceNumber");
				delete request;
				delete response;
				delete mis;
				CollectGarbage();
				return OldTraceNumber;
			} catch (e) {
				alert(e);
			}

		}
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
			$('#hwOrderAddtimeStart').datepicker(dataPickerOp);
			$('#hwOrderAddtimeEnd').datepicker(dataPickerOp2);
			$('#hwOrderAddtimeStart').change(
					function() {
						$('#hwOrderAddtimeEnd').datepicker('setStartDate',
								$(this).val());
					})
			$('#hwOrderAddtimeEnd').change(
					function() {
						$('#hwOrderAddtimeStart').datepicker('setEndDate',
								$(this).val());
					})

		});
	</script>
</body>
</html>
