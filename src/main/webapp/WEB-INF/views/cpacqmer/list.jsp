<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<title>场馆配组置</title>
		<link rel="stylesheet" href="${assets }/css/venueAllocation.css" />
	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="venue_list"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>场馆组配置</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
						<li class="active">场馆组配置</li>
					</ol>
				</section>
	
		<div class="container-fluid">
			<div class="row">
					<div class="tip-img">
						<p>场馆组配置</p>
					</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单
							<c:if test="${app:checkPermission('VENUE_GROUP_ADD') }">
								<a  href="${ctx}/cpacqmer/add"><span  class="add"><img src=""/>+添加</span></a>
							</c:if>
						</h3>
						 <form class="form-horizontal" action="${ctx}/cpacqmer/list"  method="POST">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venuesNum">场馆组编号：</label>
											<input class="form-control formConl line-input" type="text" id="amGroupId"  name="amGroupId" placeholder="场馆组编号" value="${amGroupId }"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNum">场馆编号：</label>
											<input class="form-control formConl line-input" type="text" id="amMerchantId"  name="amMerchantId" placeholder="场馆编号" value="${amMerchantId }"/>
										</div>
									</div>
								</div>
							</div>

							<div class="col-lg-12 col-md-12 ">	
								<button type="submit" class="btn venueBtn btn-size  btnSty">查询</button>
							</div>
						</form>
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>

							<div class="col-lg-12 col-md-12 clearfix">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>场馆组编号</th>
												<th>场馆组名称</th>
												<th>场馆编号</th>
											<!-- 	<th>重复入园标志</th> -->
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.amGroupId}</td>
													<td>${item.amUserDefine1}</td>
													<td>${item.amMerchantId}</td>			
				                                    <%-- <td>${item.amRecycleType}</td> --%>
				                                    <!-- 
				                                    <td>${item.amRecycleDate}</td>
													-->
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('VENUE_GROUP_UPDATE') }">
																	<a href="${ctx}/cpacqmer/update?amGroupId=${item.amGroupId}&amMerchantId=${item.amMerchantId}"><span class="edit">更新</span></a>
																</c:if> 
																<c:if test="${app:checkPermission('VENUE_GROUP_SHOW') }">
																	<a href="${ctx}/cpacqmer/show?amGroupId=${item.amGroupId}&amMerchantId=${item.amMerchantId}"><span class="edit">查看</span></a>
 																</c:if>
																<c:if test="${app:checkPermission('VENUE_GROUP_DELETE') }">
																	<a href="${ctx}/cpacqmer/delete?amGroupId=${item.amGroupId}&amMerchantId=${item.amMerchantId}" onclick="return confirm('确认删除?')" ><span class="edit">删除</span></a>
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
									<a href="${ctx }/startTreeviewDetail/cggl" style="font-size:18px;"><span class="">&lt;返回</span></a>
									<tags:pagination url="${ctx}/cpacqmer/list" page="${pageInfo}" cssClass="pull-right"/>
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
		<input type="hidden" value="3" id="test" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<script src="js/layer.js"></script>
		<script>
			$(function() {
				$(".delete").on("click",function(){
					$(this).parents("tr").remove();
				})
			})
		</script>

	</body>

</html>