<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 商品信息管理</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/ticket/css/model.css" />
<link rel="stylesheet" href="${assets }/ticket/css/ticketManagement.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="cptktypelist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>商品信息管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
					<li class="active">商品信息管理</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid gateReviewList goods">
				<div class="row outer-wrap">
					<div class="tip-img">
					<p>商品信息管理</p> 
				</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;margin-bottom:25px;">查询表单
						
								<c:if test="${app:checkPermission('CPCOMMODITY_ADD') }">
									<a class="" href="${ctx}/cpCommodity/add"><span class="fr" style="float:right;color:rgb(71,159,222);">+添加</span></a>
								</c:if>
							</h3>
							<form id="defaultForm" action="${ctx}/cpCommodity/list"  method="POST">
								<div class="form-group">
									<div class="col-md-6">
										<label>商品ID：</label> <input
											class="form-control formConl line-input" id="ttTypeId"  name="ttTypeId" placeholder="商品ID" value="${ccTypeId }" type="text" />
									</div>
									<div class="col-md-6">
										<label>商品标题：</label> <input
											class="form-control formConl line-input" id="ttTypeDesc"  name="ttTypeDesc" placeholder="商品标题" value="${ccTypeDesc }" type="text">

									</div>
								</div>

								<!--<div class="clearfix"></div>-->

								<div class="col-md-12 " style=" margin-top: 20px;">
									
									<div class=" text-right">
										<button type="submit" class="btn-size"
											style="width: 110px;"
											id="memberShip">查询</button>

									</div>
								</div>
								<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表<span class="fr toggle"></span></h3>
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>商品ID</th>
												<th>商品标题</th>
												<th>商品描述</th>
												<th>商品类型</th>
												<th>商品价格</th>
												<th>是否上架</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
				                                    <td>${item.ccTypeId}</td>
				                                    <td>${item.ccTypeDesc}</td>
				                                    <td>${item.ccTicketDes}</td>
				                                    <td>${item.ccTicketType}</td>
				                                    <td>${item.ccListPrice}</td>
				                                    <td>${item.ccTypeStatus eq "Y" ? '是' : '否' }</td>
				                                    <%-- <td>${item.ccTypeUser eq "" ? '本系统' : 'V-外围'}</td>
				                                    <td>${item.ccTypeStatus eq "Y" ? '有效' : '无效'}</td> --%>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
															<c:if test="${app:checkPermission('CPCOMMODITY_UPDATE') }">
																<a href="${ctx}/cpCommodity/update?ccTypeId=${item.ccTypeId}">更新</a>
															</c:if>
															<c:if test="${app:checkPermission('CPCOMMODITY_SHOW') }">
 																	<a  href="${ctx}/cpCommodity/show?ccTypeId=${item.ccTypeId}">查看</a>
 															</c:if>
 															<c:if test="${app:checkPermission('CPCOMMODITY_DELETE') }">
																	<a   href="${ctx}/cpCommodity/delete?ccTypeId=${item.ccTypeId}" onclick="return confirm('确认删除?')" >删除</a>
 															</c:if> 
 															
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
											</tbody>
									</table>
									<div class="box-footer clearfix">
										<a type="button" href="${ctx }/startTreeviewDetail/ywgl" class="form-a"
											style="float: left;">&lt;返回</a>
									<tags:pagination url="${ctx}/cpCommodity/list" page="${pageInfo}" cssClass="pull-right"/>
									</div>
								</div>
							</form>
						</div>
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
</body>
</html>
