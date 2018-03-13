<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 交接班报表</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" type="text/css"  href="${assets }/tongji/css/manage.css">
<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
<link rel="stylesheet" type="text/css" href="${assets}/shift/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assets}/shift/css/all.css" />

</head> 
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<style>
body{
font-size:18px;
}

</style>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper" >	
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
				<h1>交班报表查看</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">交班报表下载</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid financialList">
				<div class="row outer-wrap">
					<div class="tip-img">
						<p>交班报表查看</p>
						<!-- 	<p>会员等级</p> -->
					</div>
					<style>
						.banbiehao{margin-bottom:30px;}
					</style>
					<div class="content">
						<div class="main">
							<div class="contentInner clearfix">
								<h3>收银交班报表</h3>
								<div class="col-lg-12">
									<div class="col-lg-6 banbiehao">
										<dl>
										
											<dd>
												班别号: <span id="year">${shift.cpShiftDate }</span>
											</dd>
											<%-- <dd>
												打印时间: <span id="printTime">${shift.cpShiftDate }</span>
											</dd> --%>
											<dd>
												交班员工工号: <span>${shift.cpShiftUserno}</span>
											</dd>
											<dd>
												交班员工: <span>${shift.cpShiftUser }</span>
											</dd>
										</dl>
									</div>
									<div class="col-lg-6 banbiehao">
										<dl>
											<dd>
												交班时间: <span id="jbTime">${shift.cpShiftDate }</span>
											</dd>
											<dd>
												设备名称: <span>${shift.cpShiftXbsy }</span>
											</dd>
											
										</dl>
									</div>
								</div>

								<div class="col-lg-12">
									<div class="col-lg-6 banbiehao">
										<h4>当班营业明细</h4>
										<table border="0" cellspacing="0" cellpadding="0"
											style="width: 90%; text-align: left;">
											
											<c:forEach items="${list}" var="shift" varStatus="status">
												<tr>
													<td style="width: 38%;">${shift.ticketName}</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;">${shift.ticketCount}张</td>
													<td style="width: 20%; text-align: right;">${shift.ticketSum}</td>
												</tr>
											</c:forEach>
											<tr>
												<td style="width: 38%;">营业额</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftYyme}</td>
											</tr>
											<tr>
												<td style="width: 38%;">折扣</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftZhekou }</td>
											</tr>
											<tr>
												<td style="width: 38%;">交易笔数</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftJybs }</td>
											</tr>
											<tr>
												<td style="width: 38%;">退票笔数</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftTpbs}</td>
											</tr>
											<tr>
												<td style="width: 38%;">退票总额</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftTpze }</td>
											</tr>
											<tr>
												<td style="width: 38%;">交班小计</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftZfxj }</td>
											</tr>
										</table>

									</div>
									<div class="col-lg-6 banbiehao">
										<h4>当日支付分类</h4>
										<table border="0" cellspacing="0" cellpadding="0"
											style="width: 90%; text-align: left;">
												<tr>
													<td style="width: 38%;">微信</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;"><c:out
															value="${shift.cpShiftWxje }"></c:out></td>
												</tr>
													<tr>
													<td style="width: 38%;">支付宝</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;"><c:out
															value="${shift.cpShiftZfbje }"></c:out></td>
												</tr>
													<tr>
													<td style="width: 38%;">信用卡</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;"><c:out
															value="${shift.cpShiftXykje }"></c:out></td>
												</tr>
													<tr>
													<td style="width: 38%;">公关卡</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;"><c:out
															value="${shift.cpShiftGgkje }"></c:out></td>
												</tr>
												<tr>
													<td style="width: 38%;">现金</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;">
													<c:out value="${shift.cpShiftXj }"></c:out></td>
												</tr>
												<tr>
													<td style="width: 38%;">充值卡</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;">
													<c:out value="${shift.cpShiftCzkje}"></c:out></td>
												</tr>
												<tr>
													<td style="width: 38%;">支付小计</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;">
													<c:out value="${shift.cpShiftZfxj }"></c:out></td>
												</tr>
										</table>
									</div>
								</div>
								<div class="col-lg-12">
									<%-- <div class="col-lg-6 banbiehao">
										<h4>会员卡充值</h4>
										<table border="0" cellspacing="0" cellpadding="0" style="width: 90%; text-align: left;">
												<tr>
													<td style="width: 38%;">微信													
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;">
													<c:out value="${shift.cpShiftWxcz }"></c:out></td>
												</tr>
												<tr>
													<td style="width: 38%;">信用卡													
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;">
													<c:out value="${shift.cpShiftXykcz }"></c:out></td>
												</tr>
												<tr>
													<td style="width: 38%;">支付宝													
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;">
													<c:out value="${shift.cpShiftXykcz }"></c:out></td>
												</tr>
												<tr>
													<td style="width: 38%;">现金													
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%; text-align: right;">${shift.cpShiftXjcz }</td>
												</tr>
											<tr>
												<td style="width: 38%;">充值次数</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftCzcs}</td>
											</tr>
											<tr>
												<td style="width: 38%;">充值总额</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftCzze }</td>
											</tr>
										</table>

									</div> --%>

									<div class="col-lg-6 banbiehao">
										<h4>柜台现金明细</h4>
										<table border="0" cellspacing="0" cellpadding="0"
											style="width: 90%; text-align: left;">
											<tr>
												<td style="width: 38%;">现金收入</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftXj }</td>
											</tr>
											<tr>
												<td style="width: 38%;">充值现金</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">0.0</td>
											</tr>
											<tr>
												<td style="width: 38%;">交班现金</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftXj }</td>
											</tr>
										</table>
									<%-- <div class="col-lg-6 banbiehao">
										<h4>总额</h4>
										<table border="0" cellspacing="0" cellpadding="0" style="width: 90%; text-align: left;">
											<tr>
												<td style="width: 38%;">前班交班总额</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpBeiyongTwo }</td>
											</tr>
											<tr>
												<td style="width: 38%;">当日结班总额</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${shift.cpShiftZbzg }</td>
											</tr>
										</table>
									</div> --%>
									</div>
								</div>
								<div class="col-md-12  marginBottom">
									<a href="javascript:history.go(-1)" class="form-a">&lt;返回</a>
								</div>
								<%-- <div class="col-lg-12" style="margin-top: 10%">
									<div class="col-lg-8">
										<div class="col-lg-6">
											当班收银: <span>${userName }</span>
										</div>
										<div class="col-lg-6">
											下班收银: <span></span>
										</div>
									</div>
									<div class="col-lg-4">值班主管:</div>
									
								</div>
								<div class="freebtn text-right col-md-12 clearfix" style="margin-bottom:20px;">
										<button type="button" id="bt" onclick="javascript:doPrint('myDiv')" class="btn-green" >打印</button>
								</div> --%>
			<tags:main_footer />

		</div>
	</div>
	<tags:load_common_js />
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/pdata/pdata.js"></script>
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script type="text/javascript">
	</script>
</body>
</html>
