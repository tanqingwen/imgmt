<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<title>闸机绑IP</title>
		<link rel="stylesheet" href="${assets }/css/bindIp.css" />
	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
		
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="gateip"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>闸机绑IP</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
						<li class="active">闸机绑IP</li>
					</ol>
				</section>
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><p>闸机绑IP</p></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单
						<c:if test="${app:checkPermission('GATEIP_ADD')}">
							<a href="${ctx}/gateip/add"><span class="bindAdd">+添加</span>
						</a>
						</c:if>
						</h3>
						
						<form class="form-horizontal" action="${ctx}/gateip/list" method="POST">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementNum">闸机编号：</label><input class="form-control formConl line-input" type="text"id="gaTm" name="gaTm" value="${gaTm }" placeholder="闸机编号" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementName">闸机IP：</label><input class="form-control formConl line-input" type="text"  id="gaIp" name="gaIp" value="${gaIp }" placeholder="闸机IP" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
							
								<button type="submit" class="btn ManagementBtn btn-size btnSty">查询</button>
							</div>
						</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">闸机IP列表</h3>
							
					

							<div class="col-lg-12 col-md-12 clearfix" >
								<div class="checkList">
								<table class="table table-responsive">
									<thead>
										<tr>
											<th>闸机序号</th>
											<th>闸机编号</th>
											<th>闸机IP</th>
											<th>闸机IP状态</th>
											<th>操作</th>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.gaId}</td>
				                                    <td>${item.gaTm}</td>
				                                    <td>${item.gaIp}</td>
				                                    <td>${item.gaState == '1' ? '未使用' :  '已占用'}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('GATEIP_UPDATE')}">
																	<a href="${ctx}/gateip/update?id=${item.gaId}"><span class="edit">更新</span></a>
																</c:if>
																<c:if test="${app:checkPermission('GATEIP_VIEW')}">
																	<a href="${ctx}/gateip/show?id=${item.gaId}"><span class="check">查看</span></a>
																</c:if>
																<c:if test="${app:checkPermission('GATEIP_DELETE')}">
																	<a href="${ctx}/gateip/delete?id=${item.gaId}" onclick="return confirm('确认删除?')"><span class="delete">删除</span></a>
																</c:if>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
									</tbody>
								</table>
							</div>
							
							</div>
						
							<div class="box-footer clearfix">
								<a href="javascript:history.go(-1)"  class="backStyle"><span>&lt;返回</span></a>
									<tags:pagination url="${ctx}/gateip/list" page="${pageInfo}" cssClass="pull-right"/>
								</div>
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
			<script src="${assets}/validator/js/validator.js"></script>
         <script>
		$(function() {
				$(".delete").on("click",function(){
					$(this).parents("tr").remove();
				})
			})
		</script>
	</body>

</html>