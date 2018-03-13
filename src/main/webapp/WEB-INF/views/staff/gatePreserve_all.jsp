<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统  | 闸机列表</title>
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets}/venue/css/layer.css" />
		<link rel="stylesheet" href="${assets}/venue/css/venueAll.css" />
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="merchant"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>闸机列表</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx}/staff/merchantDataEntering">场馆查询</a></li>
						<li class="active">闸机列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><p>闸机列表</p></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						<form id="defaultForm" name="defaultForm" class="form-horizontal">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6 col-xs-12">
										<div class="form-group ">
											<label for="">场馆号码：</label>
											<input class="form-control formConl line-input" type="text" name="mmPhyState2" id="mmPhyState2" value="${cpMermst.mmMerchantNo }"/>
											<div class="col-sm-9">
						                      	<input type="hidden" id="mmPhyState2" value="${cpMermst.mmPhyState }">
						                    </div>
											
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-xs-12">
										<div class="form-group ">
											<label for="">场馆名称：</label>
											<input class="form-control formConl line-input" type="text" name="" id="" value="${cpMermst.mmBizName }" />
										</div>
									</div>
								</div>
							</div>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表 <span class="fr toggle"></span></h3>

							<div class="col-lg-12 col-md-12 clearfix tableContent" style="display: block;">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>闸机列表</th>
												<th>安装日期</th>
												<th>取消日期</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.tmTerminalId}</td>				                                  
				                                    <td>${item.tmDateInst}</td>
				                                    <td>${item.tmDateCanx}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="box-footer">
									<a href="${ctx}/cpmermst/venuePreserve" class="form-a" id="cancleSubmit">&lt;返回</a>
									<tags:pagination url="${ctx}/merchant/list" page="${pageInfo}" cssClass="pull-right"/>
									 
									<!-- <a type="button" class="btn btn-default" id="cancleSubmit"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> -->
									
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
		<script type="text/javascript">
			$("#cancleSubmit").click(function(){
				location.href="${ctx}/staff/venuePreserve";
			});
			
		</script>
	</body>
</html>
