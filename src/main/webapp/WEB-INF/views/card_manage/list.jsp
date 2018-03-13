<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 卡管理</title>
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
<tags:head_common_content />
</head>
<body class="sidebar-mini"> <!-- class="hold-transition skin-blue-light sidebar-mini" -->
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />
		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="machine" />


		<div class="content-wrapper">
			<section class="content-header">
				<h1>卡管理</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">乐园卡管理</a></li>
					<li class="active">卡管理</li>
				</ol>
			</section>
			<div class="box box-primary">
				<section class="content">		
					<button id="#" class="btn btn-sm btn-default btn-flat">取卡</button>&nbsp;&nbsp;
					<button id="#" class="btn btn-sm btn-default btn-flat">充值</button>&nbsp;&nbsp;
					<button id="#" class="btn btn-sm btn-default btn-flat">挂失</button>&nbsp;&nbsp;
					<button id="#" class="btn btn-sm btn-default btn-flat">补卡</button>&nbsp;&nbsp;
					<button id="#" class="btn btn-sm btn-default btn-flat">退卡</button>&nbsp;&nbsp;
					<button id="#" class="btn btn-sm btn-default btn-flat">导出</button>
					<div style="height: 3px;"></div>
					<div class="box" style="background-color:#f7f7f7;">
						<!-- 查询 header -->
						<div class="box-header with-border">
							<h3 class="box-title">查询</h3>
							<div class="box-tools pull-right">
								<button type="button" class="btn btn-box-tool" data-widget="collapse">
									<i class="fa fa-minus"></i>
								</button>
							</div>
						</div>
						<!-- 查询的 body -->
						<div class="box-body">
							<table class="table">
								<tbody>
									<tr>
										<td style="width:60px;height:5px;">卡种类</td>
										<td style="width:270px;height:5px;">
											<select class="form-control" style="height:30px;">
												<option value="0">选择种类</option>
												<option value="0">儿童卡</option>
												<option value="0">老年卡</option>
											</select>
										</td>
										
										<td style="width:60px;">会员ID</td>
										<td style="width:270px;">
											<input class="form-control" style="height:30px;"/>
										</td>
										
										<td style="width:80px">卡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</td>
										<td style="width:270px"><input class="form-control" style="height:30px;"/></td>
										
										<td></td>
									</tr>
									<tr>
										<td style="width:60px">状&nbsp;&nbsp;&nbsp;&nbsp;态</td>
										<td style="width:270px;">
										<select class="form-control" style="height:30px;">
												<option value="0">选择状态</option>
												<option value="0">正常</option>
												<option value="0">异常</option>
										</select></td>
										
										<td style="width:60px">日&nbsp;&nbsp;&nbsp;&nbsp;期</td>
										<td style="width:270px">
										      <div class="input-group col-sm-12 date firstCommission">
													<span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"></span>
													</span>
											       <input type="text" id="tmDateInst" name="tmDateInst"  class="form-control" style="height:30px;"/>
										    	</div>
										</td>
										<td style="width:80px">取卡员工</td>
										<td style="width:270px"><input class="form-control" style="height:30px;"/></td>
										<td rowspan=$rowspan style="vertical-align: middle;text-align: center;">
											<button type="submit" class="btn btn-info" style="height:30px;">
												<i class="fa fa-search"></i>查询
											</button>		
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
						<!-- 查询div---end -->
						<!-- 列表div---start -->
						<div class="box"style="float:50">
						<div class="box-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered">
								<thead>
									<tr style="text-align: center;">
									    <td>卡号</td>
										<td>会员</td>
										<td>订单</td>
										<td>押金</td>
										<td>支付流水</td>
										<td>日期</td>
										<td>状态</td>
										<td>操作</td>
									</tr>
								</thead>
								<tbody>
									<tr style="text-align: center;">
									    <td>323232132321</td>
										<td>张三李</td>
										<td>2113223423</td>
										<td>100.00</td>
										<td>54566577565</td>
										<td>2016-03-15</td>
										<td>正常</td>
										<td><a href="#">充值</a>&nbsp;&nbsp;<a href="#">挂失</a>&nbsp;&nbsp;<a href="#">退卡</a></td>
									</tr>
									<tr style="text-align: center;">
									    <td>323232132321</td>
										<td>张三李</td>
										<td>2113223423</td>
										<td>100.00</td>
										<td>54566577565</td>
										<td>2016-03-15</td>
										<td>正常</td>
										<td><a href="#">充值</a>&nbsp;&nbsp;<a href="#">挂失</a>&nbsp;&nbsp;<a href="#">退卡</a></td>
									</tr>
									<tr style="text-align: center;">
									    <td>323232132321</td>
										<td>张三李</td>
										<td>2113223423</td>
										<td>100.00</td>
										<td>54566577565</td>
										<td>2016-03-15</td>
										<td>正常</td>
										<td><a href="#">充值</a>&nbsp;&nbsp;<a href="#">挂失</a>&nbsp;&nbsp;<a href="#">退卡</a></td>
									</tr>
									<tr style="text-align: center;">
									    <td>323232132321</td>
										<td>张三李</td>
										<td>2113223423</td>
										<td>100.00</td>
										<td>54566577565</td>
										<td>2016-03-15</td>
										<td>正常</td>
										<td><a href="#">充值</a>&nbsp;&nbsp;<a href="#">挂失</a>&nbsp;&nbsp;<a href="#">退卡</a></td>
									</tr>
								</tbody>
							</table>
							<tags:pagination url="${ctx}/staff/list" page="${pageInfo}" cssClass="pull-right"/>
						</div>
						
							
					</div>
				</div>
					<!-- /.box-body -->
				</section> 
			</div>
		</div>
	<!-- Main footer -->
	<tags:main_footer />
	<!-- Control Sidebar -->
	<tags:control_sidebar />
	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/pdata/pdata.js"></script>
    
    <script type="text/javascript">
		    $('#tmDateInst').datepicker({
				format : 'yyyy-mm-dd',
				todayBtn: 'linked',
				todayHighlight:true,
				autoclose : true
			});
    </script>
</body>
</html>
