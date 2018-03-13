<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>综合管理系统 | 闸机绑IP</title>
		<tags:head_common_content/>
		<link rel="stylesheet" type="text/css" href="${assets }/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${assets }/layer/skin/layer.css" />
		<title>闸机绑IP</title>
		<link rel="stylesheet" href="${assets }/gatesManagement/css/bindIp.css" />
	</head>

	<body  class="hold-transition skin-blue-light sidebar-mini">
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
		      	<section class="content-header">
					<h1>闸机绑IP</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
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
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单<span class="bindIPAdd">
							<c:if test="${app:checkPermission('GATE_IP_ADD')}">
		                  		<a  href="${ctx}/gateip/add">+添加</a>
		                  	</c:if>
						</span></h3>
						
						<form id="defaultForm" name="defaultForm" class="form-horizontal" action="${ctx}/gateip/list">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementNum">闸机编号：</label>
											 <input class="form-control formConl line-input" id="gaTm" name="gaTm" value="${gaTm }" placeholder="闸机编号" type="text" >
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="ManagementName">闸机IP：</label>
											<input class="form-control formConl line-input" id="gaIp" name="gaIp" value="${gaIp }" placeholder="闸机IP" type="text">
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">						
								<button class="btn ManagementBtn btn-size btnSty" type="submit" >查询</button>
							</div>
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
												<td class="operationAll" >
															<c:if test="${app:checkPermission('GATE_IP_UPDATE')}">
																<a type="button" class="btn edit" title="修改" href="${ctx}/gateip/update?id=${item.gaId}">更新</a>
															</c:if>
															<c:if test="${app:checkPermission('GATE_IP_SHOW')}">
																<a type="button" class="btn check" title="查看" href="${ctx}/gateip/show?id=${item.gaId}">查看</a>
															</c:if>
															<c:if test="${item.gaState == 1 }">
																<c:if test="${app:checkPermission('GATE_IP_DELETE')}">
																	<a type="button" class="btn delete" title="删除" href="${ctx}/gateip/delete?id=${item.gaId}" onclick="return confirm('确认删除?')">删除</a>
																</c:if>
															</c:if>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
							</div>
							<div class="box-footer clearfix">
								<a href="${ctx }/startTreeviewDetail/cggl"  class="backStyle"><span style="font-size:18px;">&lt;返回</span></a>
									<tags:pagination url="${ctx}/gateip/list" page="${pageInfo}" cssClass="pull-right"/>
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
			<script src="${assets}/validator/js/validator.js"></script>
		
		<input type="hidden" value="3" id="test" />
		<!-- <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script> -->
		<script src="${assets}/layer/layer.js"></script>
         <script>
		$(function() {
				$(".delete").on("click",function(){
					$(this).parents("tr").remove();
				})
			})
		</script>
	</body>

</html>