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
<link rel="stylesheet" href="${assets}/venue/css/layer.css" />
<link rel="stylesheet" href="${assets}/venue/css/venueAll.css" />

<title>综合管理系统 | 场馆查询</title>

</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="pressmv" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>场馆查询</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li class="active">场馆查询</li>
				</ol>
			</section>

			<div class="container-fluid">
				<div class="row clearMar" >
					<div class="tip-img">
						<img src="${assets}/venue/images/venue.png">
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form  action="${ctx}/cpmermst/searchVenueResultList" class="form-horizontal" method="post">
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueNum">场馆号码：</label>
												<input class="form-control formConl line-input" id="mmMerchantNo" name="mmMerchantNo" value="${mmMerchantNo }" type="text" />
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueName">场馆名称：</label><input
													class="form-control formConl line-input" type="text" id="mmBizName" name="mmBizName" value="${mmBizName }" />
											</div>
										</div>
									</div>
								</div>
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												 <label for="venueAbb">场馆简称：</label><input
													class="form-control formConl line-input" type="text" id="mmStmtName" name="mmStmtName" value="${mmStmtName }"  /> 
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueGrade">场馆等级：</label>
												<!--<input class="form-control formConl line-input" type="text" name="venueGrade" id="venueGrade" />-->
												<select name="mmPmtMode" id="mmPmtMode" class="venueGrade" >
				 						  			<option value="0">请选择级别...</option>
				 									<%-- <option value="1"  <c:if test="${mmPmtMode eq 1 }">selected="selected"</c:if>>一级 - 欢乐大世界</option> --%>
				 									<option value="2"  <c:if test="${mmPmtMode eq 2 }">selected="selected"</c:if>>二级 - 场馆</option>
				 									<option value="3"  <c:if test="${mmPmtMode eq 3 }">selected="selected"</c:if>>三级 - 子场馆</option>
				 								</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<button class="btn venueBtn btn-size fr" type="submit">查询</button>
								</div>
								</form>

								<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>

								<div class="col-lg-12 col-md-12 clearfix">
									<div class="checkList">
										<table class="table table-responsive">
											<thead>
												<tr>
													<th>场馆号码</th>
													<th>场馆名称</th>
													<th>场馆简称</th>
													<th>操作</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.mmMerchantNo}</td>				                                  
				                                    <td>${item.mmBizName}</td>
				                                    <td>${item.mmStmtName}</td>
				                                    
				                                    <td class="operationAll">
				                                    	<c:if test="${app:checkPermission('VENUE_VIEW') }">
				                   	                 		<a href="${ctx}/cpmermst/venuePreserve_view/${item.mmMerchantNo}" ><span class="edit">场馆详情</span></a>
				                                    	</c:if>
				                                    	<c:if test="${app:checkPermission('VENUE_MLIST') }">
				                                    		<a href="${ctx}/cpmermst/venuePreserve_list/${item.mmMerchantNo}"><span class="check">商户列表</span></a>
				                                    	</c:if>
				                                    	<c:if test="${app:checkPermission('VENUE_GLIST') }">
				                                    		<a href="${ctx}/cpmermst/gatePreserve_list/${item.mmMerchantNo}"> <span class="delete">闸机列表</span> </a>
				                                    	</c:if>
				                                    </td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
										<div class="box-footer clearfix">										
											<a type="button"  href="${ctx }/startTreeviewDetail/xcgl" class="form-a" style="height:0;line-height:0;">&lt;返回</a>									
											<tags:pagination url="${ctx}/cpmermst/searchVenueResultList"   page="${pageInfo}" cssClass="pull-right"/>
										</div>
									</div>
								</div>
								<%-- <div class="box-footer clearfix">
									<tags:pagination url="${ctx}/cpmermst/searchVenueResultList" 
									queryString="mmMerchantNo=${mmMerchantNo }&mmBizName=${mmBizName }&mmStmtName=${mmStmtName }&mmPmtMode=${mmPmtMode }" 
									page="${pageInfo}" cssClass="pull-right"/>
								</div> --%>
								
						</div>
					</div>
				</div>
			</div>

			<input type="hidden" value="3" id="test" />
			<script type="text/javascript" src="${assets}/venue/js/jquery-3.1.1.min.js"></script>		
			<script src="${assets}/venue/js/layer.js"></script>
			<!-- Main content -->

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
