<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/css/others.css" />
<title>景点信息管理</title>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />
		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="ywvenuelist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>景点信息管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/webwh">web维护</a></li>
					<li class="active">景点信息管理</li>
				</ol>
			</section>
			<div class="container-fluid ScenicSpot" id="ScenicSpot">
				<div class="row">
					<div class="tip-img">
						<p>景点信息管理</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单 <c:if test="${app:checkPermission('YWVENUE_ADD') }">
										<a href="${ctx}/ywvenue/toAddPage" class="fr lHeight"><span
											class="RInfoManageAdd">+添加</span></a>
									</c:if></h3>
							<form class="form-inline">
								<div class="col-md-12">
									<div class="form-group">
										<!--	<label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>-->
										<div class="input-group RestaurantCheck">
											<input type="text" class="form-control line-input"
												style="width: 200px;" id="hwVenueId" name="hwVenueId"
												placeholder="场馆ID" value="${hwVenueId }"> <input
												type="text" class="form-control line-input"
												style="width: 200px;" id="hwVenueName" name="hwVenueName"
												placeholder="场馆名" value="${hwVenueName }">
											<div class="input-group-addon">
												<button type="submit" class=" btn-size" style="margin-left:10px;">查询</button>
											</div>
										</div>
									</div>
									
								</div>
							</form>						
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>场馆ID</th>
												<th>场馆名</th>
												<th style="width: 40%;">场馆说明</th>
												<th>场馆位置</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.hwVenueId}</td>
													<td>${item.hwVenueName}</td>
													<td>${item.hwVenueNote}</td>
													<td>${item.hwVenusPos}</td>
													<td class="text-right">
														<c:if test="${app:checkPermission('YWVENUE_UPDATE') }">
															<a href="${ctx}/ywvenue/update?hwVenueId=${item.hwVenueId}"><span>更新</span></a>
														</c:if> 
														<c:if test="${app:checkPermission('YWVENUE_SHOW') }">
															<a href="${ctx}/ywvenue/show?hwVenueId=${item.hwVenueId}"><span>查看</span></a>
														</c:if> 
														<c:if test="${app:checkPermission('YWVENUE_DELETE')}">
															<a href="${ctx}/ywvenue/delete?hwVenueId=${item.hwVenueId}"
																onclick="return confirm('确认删除?')"><span>删除</span></a>
														</c:if></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

							</div>

						</div>
					</div>
					<div class="box-footer clearfix">
						<a type="button" href="${ctx }/startTreeviewDetail/webwh"
								class="form-a">&lt;返回</a>
						<tags:pagination url="${ctx}/ywvenue/list" page="${pageInfo}"
							cssClass="pull-right" />
					</div>
				</div>

			</div>
		</div>
		<!-- Main footer -->
		<tags:main_footer />

		<!-- Control Sidebar -->
		<tags:control_sidebar />
	</div>
	<tags:load_common_js />
</body>

</html>