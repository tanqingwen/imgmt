<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<title>综合管理系统 |购物车</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/window-ticket.css" />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<!-- this "tags" contains all the patterns we need in this page -->
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<div style="position: absolute;">
			<jsp:include flush="true" page="/WEB-INF/tags/all.jsp"></jsp:include>
			<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
			<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		</div>
		
		<!-- Main header, top yellow bar -->
		<tags:main_header />
	
		<!-- Left column, contains the logo and sidebar -->
		<tags:main_sidebar active="buyticket" />
	
		<!-- here use a wrapper so that the content won't be influenced by sidebar -->
	<div class="content-wrapper">

		<!-- This class contains tip on the top of wrapper. Ordinarily it's invisible. -->
		<div class="context-tips">
			<tags:action_tip />
		</div>

		<!-- title of the real content -->
		<section class="content-header">
			<h1>购物车</h1>
			<ol class="breadcrumb">
				<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
				<li><a href="${ctx }/startTreeviewDetail/ceshi2">现场购票</a></li>
				<li class="active">购物车</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="box box-primary">
				<!-- /.box-header -->
				<form id="ticketfrom" class="form-horizontal" method="post" action="/cpticket/cart_ticket">
					<div class="box-body">
						<div class="row">
							<div class="col-md-12">
								<div class="box box-info">
									<div class="box-header with-border">
										<h3 class="box-title"><i class="fa fa-list"></i> 查询列表</h3>
										<div class="box-tools pull-right">
											<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
										</div>
									</div><!-- /.box-header -->
									<div class="box-body">
										<div class="table-responsive">
											<table class="table table-striped">
												<thead>
													<tr>
														<th>购物车ID</th>
														<th>手机号</th>
														<th>预存金额</th>
														<th>票劵ID</th>
														<th>会员等级</th>
														<th>证件号码</th>
														<th>姓名</th>
														<th>票劵金额</th>
														<th>支付总额</th>
					
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${TicketShoppingCart}">
														<tr>			
															<td>${item.shoppingId}</td>								
															<td>${item.mobile}</td>
															<td>${item.amount}</td>
															<td>${item.ticketType}</td>
															<td>${item.varoldPrdgrp}</td>
															<td>${item.idNo}</td>
															<td>${item.uname}</td>
															<td>${item.vartkAmount}</td>
															<td>${item.totalAmountPaid}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div><!-- /.box-body -->
								</div><!-- /.box -->
							</div><!-- /.col -->
							<div class="box-footer">
								<div class="pull-right">
									<button  type="submit" class="btn btn-info " ><i class="fa fa-plus"></i></i> 结算</a>
								</div>
								<a type="button" class="btn btn-default " href="${ctx }/cpticket/ceshi2"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
			                </div><!-- /.box-footer -->
						</div><!-- /.row -->
					</div>					
				</form>
			</div>
		</section>

		<tags:control_sidebar />

		<tags:load_common_js />
	</div>

</div>
</body>
</html>
