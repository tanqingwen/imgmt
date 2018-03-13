<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 流水报表下载</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
<link rel="stylesheet" type="text/css"
	href="${assets }/tongji/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" type="text/css"
	href="${assets }/tongji/css/manage.css">
	<style>
		a{
			color:#333;
		}
		a:hover{
			text-decoration:none;
		}
	</style>
</head>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<body class="hold-transition skin-blue-light sidebar-mini"
	onload="getNowFormatDate()">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="financialwater" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>流水报表下载</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">流水报表下载</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid">
				<div class="row outer-wrap">
					<div class="chartdownload-tip-img"></div>
					<div class="content">
						<div class="main"></div>
						<!-- h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">折扣列表<span class="fr toggle">+</span></h3> -->
						<h3
							style="border-bottom: 2px dashed #DACA99; margin: 15px 15px; line-height: 50px;"
							class="clearfix">流水报表下载</h3>
						<form class="form-horizontal" id="thisform2"
							action="${ctx}/financial/waterDownLoad" method="post">
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>文件名</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
			                                    <td>乐园经营总表</td>
												<td><a class="pull-right" title="下载" href="${ctx}/financial/waterDownLoad/paradise">下载</a></td>
											</tr>
											<tr>
			                                    <td>票务销售表</td>
												<td><a class="pull-right" title="下载" href="${ctx}/financial/waterDownLoad/ticket">下载</a></td>
											</tr>
											<tr>
			                                    <td>餐饮销售表</td>
												<td><a class="pull-right" title="下载" href="${ctx}/financial/waterDownLoad/food">下载</a></td>
											</tr>
											<tr>
			                                    <td>零售销售表</td>
												<td><a class="pull-right" title="下载" href="${ctx}/financial/waterDownLoad/retail">下载</a></td>
											</tr>
											<tr>
			                                    <td>酒店营业报表</td>
												<td><a class="pull-right" title="下载" href="${ctx}/financial/waterDownLoad/grogshop">下载</a></td>
											</tr>
										</tbody>
									</table>
									<a type="button"  href="${ctx }/startTreeviewDetail/tjbb" class="form-a marginBottom">&lt;返回</a>
								</div>
							</div>
						</form>
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
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/pdata/pdata.js"></script>
	<script type="text/javascript">
		function filesclick() {
			var checkboxes = document.getElementsByName("fileslist");
			var chestr = "";
			for (i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					chestr += checkboxes[i].value + ",";
				}
			}
			$("#filesstr").val(chestr);
		}
	</script>

</body>
</html>
