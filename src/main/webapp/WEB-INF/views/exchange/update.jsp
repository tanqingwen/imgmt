<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 积分更新</title>
	<tags:head_common_content/>
	<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	<link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

		<!-- Main header -->
		<tags:main_header/>
		
		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="assistant"/>
      
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip/>
			</div>
			
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>积分更新</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">积分管理</a></li>
					<li class="active">积分更新</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<form id="assistantForm" class="form-horizontal" method="post" action="${ctx }/integral/update">
					<div class="box box-primary">
			 			<div class="box-header with-border">
			       			<h3 class="box-title">积分信息</h3>
						</div><!-- /.box-header -->
						<div class="box-body">
						<input type="hidden" value="${item.hwIntegralId }" id="hwIntegralId" name="hwIntegralId"/>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="hwIntegralId" class="col-sm-3 control-label">积分ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwIntegralId}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwMemberId}" readonly="readonly"/>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="hwIntegralType" class="col-sm-3 control-label">积分类型</label>
										<div class="col-sm-8">
											<select id="hwIntegralType" name="hwIntegralType" class="form-control">
									    		<option value="01" ${item.hwIntegralType eq '01' ? 'selected':'' }>购票</option>
									    		<option value="02" ${item.hwIntegralType eq '02' ? 'selected':'' }>消费</option>
									    		<option value="03" ${item.hwIntegralType eq '03' ? 'selected':'' }>充值</option>
									    		<option value="04" ${item.hwIntegralType eq '04' ? 'selected':'' }>奖励</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="hwProductFraction" class="col-sm-3 control-label">积分数</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwProductFraction}" readonly="readonly"/>
										</div>
									</div>
								</div>
							</div>
						</div><!-- /.box-body -->
					</div>
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">积分更新</h3>
						</div><!-- /.box-header -->
						<div class="box-body">            
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="hwAvailableIntegral" class="col-sm-3 control-label">可用积分<font color="red">*</font></label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="hwAvailableIntegral" name="hwAvailableIntegral" value="${item.hwAvailableIntegral}"/>
										</div>
									</div>
									<div class="form-group">
									    <label for="hwExchangeIntegral" class="col-sm-3 control-label">已兑换积分<font color="red">*</font></label>
									    <div class="col-sm-8">
									    	<input type="text" class="form-control" id="hwExchangeIntegral" name="hwExchangeIntegral" value="${item.hwExchangeIntegral}"/>
									    </div>
									</div>
									<div class="form-group">
			   							<label for="hwExchangeDate" class="col-sm-3 control-label">兑换日期</label>
			   							<div class="col-sm-8">
			     							<input type="text" class="form-control" id="hwExchangeDate" name="hwExchangeDate" value="${item.hwExchangeDate}"/>
			    						</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
			   							<label for="hwExchangeRecord" class="col-sm-3 control-label">兑换记录ID</label>
			   							<div class="col-sm-8">
			     							<input type="text" class="form-control" id="hwExchangeRecord" name="hwExchangeRecord" value="${item.hwExchangeRecord}"/>
			    						</div>
									</div>
									<div class="form-group">
			   							<label for="hwPeriodDate" class="col-sm-3 control-label">有效期</label>
			   							<div class="col-sm-8">
			     							<input type="text" class="form-control" id="hwPeriodDate" name="hwPeriodDate" value="${item.hwPeriodDate}"/>
			    						</div>
									</div>
									<div class="form-group">
									    <label for="hwIntegralStatus" class="col-sm-3 control-label">状况<font color="red">*</font></label>
									    <div class="col-sm-8">
									    	<select id="hwIntegralStatus" name="hwIntegralStatus" class="form-control">
									    		<option value="01" ${item.hwIntegralStatus eq '01' ? 'selected':'' }>可用</option>
									    		<option value="02" ${item.hwIntegralStatus eq '02' ? 'selected':'' }>部分兑换</option>
									    		<option value="03" ${item.hwIntegralStatus eq '03' ? 'selected':'' }>已兑换</option>
									    	</select>
								    	</div>
									</div>
								</div>
							</div>
						</div>
			
						<div class="box-footer">
				            <div class="pull-right">
								<button type="submit" class="btn btn-info btn-flat"><i class="fa fa-plus"></i> 更新</button>	                    	
				                <a type="button" class="btn btn-default btn-flat" href="${ctx }/integral/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
							</div>
						</div><!-- /.box-footer -->
					</div>
				</form>
			</section><!-- /.content -->
		</div><!-- /.content-wrapper -->
		
		<!-- Footer Sidebar -->
		<tags:main_footer/>
	
		<!-- Control Sidebar -->
		<tags:control_sidebar/>
		
	</div><!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
</body>
</html>
