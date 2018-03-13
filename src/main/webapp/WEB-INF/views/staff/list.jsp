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
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>员工管理</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="staff"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>员工管理</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li class="active">员工管理</li>
					</ol>
				</section>
	
		<div class="container-fluid RInfoManage staff common">
			<div class="row">
				<div class="tip-img">
					<p>员工管理</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单
						<c:if test="${app:checkPermission('STAFF_ADD') }">
							<a href="${ctx}/staff/add"><span class="fr add">+添加</span></a>
						</c:if></h3>
						<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工ID:</label>
										<input class="form-control formConl line-input" id="staffId" name="staffId" placeholder="员工ID" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>员工姓名:</label>
										<input class="form-control formConl line-input" type="text" id="staffName" name="staffName" placeholder="员工姓名" />
									</div>
								</div>
							</div>
							<div class="col-lg-12 submit-group marginTop">
							<div class="btn-group fr">
								<button  type="submit" class="btn-size" style="width:110px;" id="memberShip">查询</button>

							</div>
						</div>
						</form>
						
						<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">员工列表</h3>
						<div class="col-lg-12 col-md-12 clearfix tableContent">
							<div class="checkList">
								<table class="table table-responsive">
									<thead>
										<tr>
											<th>员工ID</th>
											<th>员工姓名</th>
											<th>员工邮箱</th>
											<th>电话号码</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.id}</td>
				                                   <%--  <td>
				                                    	<c:choose>
				                                    		<c:when test="${item.status eq 'NORMAL'}">${item.status}--正常</c:when>
				                                    		<c:when test="${item.status eq 'LOCK'}">${item.status}--锁定</c:when>
				                                    		<c:when test="${item.status eq 'CANCEL'}">${item.status}--注销</c:when>
				                                    		<c:otherwise>状态异常</c:otherwise>
				                                    	</c:choose>
				                                    </td> --%>
				                                    <td>${item.name}</td>
				                                    <td>${item.email}</td>
				                                    <td>${item.phoneNumber}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('STAFF_UPDATE') }">
																	<a href="${ctx}/staff/update?id=${item.id}"><span class="edit">更新</span></a>
																</c:if>
																<c:if test="${app:checkPermission('STAFF_RESET_PASSWORD') }">
																	<a href="${ctx}/staff/reset_password?id=${item.id}"><span class="check">重置密码</span></a>
																</c:if>
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a href="${ctx}/staff/show?id=${item.id}"><span class="check">查看</span></a>
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
									<a href="${ctx }/startTreeviewDetail/xtgl" class="form-a">&lt;返回</a>								
									<tags:pagination url="${ctx}/staff/list" page="${pageInfo}" cssClass="pull-right"/>
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
	</body>

</html>