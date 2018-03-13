<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>综合管理系统 |闸机查看</title>
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/model.css" />
		<link rel="stylesheet" href="${assets }/css/siteManagement.css">
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
				<h1>闸机查看</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
		            <li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
		            <li><a href="${ctx }/trmmstgate/list">闸机管理</a></li>
		            <li><a href="${ctx }/trmmstgate/viewlist/${merchantId }">闸机列表</a></li>
		            <li><a href="${ctx }/machine/unexamineList/${merchantId }">待复核列表</a></li>
					<li class="active">闸机查看</li>
				</ol>
			</section>
	
		<div class="container-fluid venue-entry">
			<div class="row outer-wrap">
				<div class="tip-img">
					<p>闸机详情</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看列表</h3>
						<form id="defaultForm" name="defaultForm" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-6">
									<label>闸机编号：</label>
									<input class="form-control formConl" type="text" value="${item.tmTerminalId}" disabled="disabled" />
								</div>
								<div class="col-md-6">
									<label>闸机名称：</label>
									<input class="form-control formConl" type="text" name=""  value="${item.tmDateCanx}" disabled="disabled" />
								</div>
								
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>场馆号码：</label>
									<input class="form-control formConl" type="text" name=""  value="${item.tmMerchantId}" disabled="disabled" />
								</div>
								<div class="col-md-6">
									<label>闸机状态：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmStatus=='1'?'停用':'正常'}"  disabled="disabled" />

								</div>
								
								<!--<div class="col-md-6">
									<label>安装日期：</label>
									<div class="input-group groupDis">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input type="text" class="form-control" data-toggle="datepicker">
									</div>
								</div>-->
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>录入人：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmSetupUser}" disabled="disabled" />

								</div>
								
								<div class="col-md-6">
									<label>录入时间：</label>
									<input class="form-control formConl" type="text" name=""id="tmSetupTimestamp" disabled="disabled"/>

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>闸机品牌：</label>
									<input class="form-control formConl" type="text" value="${item.tmBrand}" name="" disabled="disabled" />

								</div>
								<div class="col-md-6">
									<label>闸机版本：</label>
									<input class="form-control formConl" type="text" value="${item.tmVersionNo}" name="" disabled="disabled" />

								</div>
								
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>安装日期：</label>
									<input class="form-control formConl" type="text" name="" value="${item.tmDateInst}" disabled="disabled" />
								</div>
								<div class="col-md-6">
									<label>设备序号：</label>
									<input class="form-control formConl" type="text" value="${item.tmEdcPrinterNo}" name="" disabled="disabled" />
								</div>
								
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>闸机IP：</label>
									<input class="form-control formConl" type="text" value="${item.tmHostSerial}"  name="" disabled="disabled" />
								</div>
								<div class="col-md-6">
									<label>授权人：</label>
									<input class="form-control formConl" type="text" value="${item.tmAuthUser}" name="" disabled="disabled"/>

								</div>
							</div>
							<div class="form-group">
								
								<div class="col-md-6">
									<label>授权时间：</label>
									<input class="form-control formConl" type="text" id="tmAuthTimestamp" value="${item.tmAuthTimestamp}" name="" disabled="disabled" />

								</div>
								
							</div>

							<!--<div class="clearfix"></div>-->

							<div class="col-lg-12 submit-group">
								<a href="${ctx }/machine/unexamineList/${merchantId }" class="form-a">&lt;返回</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		</div>
		
		<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	</body>
<script type="text/javascript">
$('#tmSetupTimestamp').val(dateformat('${item.tmSetupTimestamp}'));
$('#tmAuthTimestamp').val(dateformat('${item.tmAuthTimestamp}'));

function dateformat(str){
	var year = str.substring(0,4);
	var month = str.substring(4,6);
	var day = str.substring(6,8)
	return year+'-'+month+'-'+day;
 }
</script>
</html>