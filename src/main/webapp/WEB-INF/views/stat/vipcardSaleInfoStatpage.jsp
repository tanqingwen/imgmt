<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 卡片交易详情</title>
		<tags:head_common_content/>		
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
		<link rel="stylesheet" type="text/css" href="${assets}/yewuchaxun/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/layer.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/model.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/cardBusinessInfo.css">
		<style>
		.gateReviewList .form-control{
			width:290px;
		}
		.pagination>li>a, .pagination>li>span{
			color:#333;
		}
		</style>
</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="listCardSaleInfo"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>卡片交易详情</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywcx">业务查询</a></li>
						<li class="active">卡片交易详情</li>
					</ol>
				</section>

				<!-- Main content -->
				<div class="container-fluid gateReviewList">
			<div class="row outer-wrap">
				<div class="tip-img reviewList">
				<!-- 	<p>会员等级</p> -->
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						<form id="thisform" action="${ctx}/vipcardStat/listCardSaleInfo"  class="form-horizontal">
							<div class="form-group">
							<label for="ctCardNumber">卡号：</label>
								<input class="form-control formConl line-input timepicker" id="ctCardNumber" name="ctCardNumber" placeholder="卡号" value="${ctCardNumber }" type="text"/>
							</div>							
							<div class=" submit-group fr">
								<button  type="submit" id="theIdForSubmit"   class="btn-size" style="width:110px;margin:0 25px 0 15px;" id="memberShip">查询</button>
							</div>
						</form>
							</div>
							<h3 style="border-bottom: 2px dashed #6fba2c;height:40px;" class="clearfix">查询列表<span class="fr toggle"></span></h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList ">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th>姓名</th>
												<th>卡号</th>
												<th>身份证号</th>
												<th>交易时间</th>
												<th>交易码</th>
												<th>交易描述</th>
												<th>交易金额</th>
												<th>交易卡金额</th>
												<th>交易前金额</th>
												<th>交易后金额</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>											
													<td>${item.cbEmbossname}</td>
				                                    <td>${item.recommerderNo}</td>
				                                    <td>${item.cbIdno}</td>
				                                    <td>${item.ctPostTime}</td>
				                                    <td>${item.ctTranCode}</td>
				                                    <td>${item.sysTrxnDesc}</td>
				                                    <td>${item.ctTranAmount}</td>
				                                    <td>${item.ctCardAmount}</td>
				                                    <td>${item.ctOutstdB4Post}</td>
				                                    <td>${item.ctOutstdAfterPost}</td>
												</tr>
											</c:forEach>
											</tbody>
									</table>
									<div class="box-footer clearfix">
										<a type="button" href="${ctx }/startTreeviewDetail/ywcx" class="form-a">&lt;返回</a>
										<tags:pagination url="${ctx}/vipcardStat/listCardSaleInfo" queryString="ctCardNumber=${ctCardNumber }" page="${pageInfo}" cssClass="pull-right"/>
									</div>
								</div>
						</form>
						</div>
					</div>
				</div>
			</div>
			</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>
		<script src="${assets}/datepicker/locales/date.js"></script>
		<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	    <script src="${assets}/validator/js/validator.js"></script>
	    <script src="${assets}/pdata/pdata.js"></script>
	</body>
</html>
