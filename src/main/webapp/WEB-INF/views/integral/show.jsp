<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 |积分管理</title>
<tags:head_common_content />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="profile" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>积分查看</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">积分管理</a></li>
					<li class="active">积分查看</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<form id="assistantForm" class="form-horizontal" method="" action="">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">
								<i class="box-title"></i> 查看积分
							</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="hwIntegralId" class="col-sm-3 control-label">积分ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwIntegralId}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwMemberId}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwIntegralType" class="col-sm-3 control-label">积分类型</label>
										<div class="col-sm-8">
											<select id="hwIntegralType" name="hwIntegralType" class="form-control" disabled="disabled">
									    		<option value="1" ${item.hwIntegralType eq '01' ? 'selected':''}>购票</option>
									    		<option value="2" ${item.hwIntegralType eq '02' ? 'selected':''}>消费</option>
									    		<option value="3" ${item.hwIntegralType eq '03' ? 'selected':''}>充值</option>
									    		<option value="4" ${item.hwIntegralType eq '04' ? 'selected':''}>奖励</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="hwProductFraction" class="col-sm-3 control-label">积分数</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwProductFraction}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwAvailableIntegral" class="col-sm-3 control-label">可用积分</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwAvailableIntegral}" readonly="readonly" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="hwExchangeIntegral" class="col-sm-3 control-label">已兑换积分</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwExchangeIntegral}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwExchangeDate" class="col-sm-3 control-label">兑换日期</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwExchangeDate}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwExchangeRecord" class="col-sm-3 control-label">兑换记录ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwExchangeRecord}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwPeriodDate" class="col-sm-3 control-label">有效期</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwPeriodDate}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwStatus" class="col-sm-3 control-label">状况</label>
										<div class="col-sm-8">
											<select id="hwIntegralStatus" name="hwIntegralStatus" class="form-control" disabled="disabled">
									    		<option value="1" ${item.hwIntegralStatus eq '01' ? 'selected':''}>可用</option>
									    		<option value="2" ${item.hwIntegralStatus eq '02' ? 'selected':''}>部分兑换</option>
									    		<option value="3" ${item.hwIntegralStatus eq '03' ? 'selected':''}>已兑换</option>
									    	</select>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<a type="submit" class="btn btn-default pull-right" href="${ctx }/integral/list"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
						</div>
						<!-- /.box-footer -->
					</div>
				</form>
			</section>


		</div>
	</div>
	<!-- /.box -->
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>
</html>
