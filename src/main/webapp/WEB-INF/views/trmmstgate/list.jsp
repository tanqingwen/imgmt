<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>综合管理系统 | 闸机管理</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets}/validator/css/css.css" />
<link rel="stylesheet" href="${assets}/layer/skin/layer.css" />
<link rel="stylesheet"
	href="${assets}/gatesManagement/css/gatesManagement.css" />
<style>
/* label{
	width:6em;
}
.col-lg-6{
	padding: 0 15px;
} */
a {
	color: #333;
}

a:hover {
	color: #333;
}

.form-control {
	width: 290px;
}
</style>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="staff" />
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>闸机管理<!-- -场馆列表 --></h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
					<li class="active">闸机管理</li>
				</ol>
			</section>
			<div class="row outer-wrap">
				<div class="tip-img">
					<p>闸机管理</p>
				</div>
				<div class="content">
					<div class="main">
						<form class="form-horizontal form-line"
							action="${ctx}/trmmstgate/list" method="POST">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<div class="col-lg-12">
								<div class="col-lg-6">
									<div class="form-group">
										<label>场馆号码：</label> <input class="form-control formConl"
											type="text" id="mm_merchant_no" name="mm_merchant_no"
											placeholder="场馆号码" value="${mm_merchant_no }" />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label>场馆名称：</label> <input class="form-control formConl"
											type="text" id="mm_biz_name" name="mm_biz_name"
											placeholder="场馆名称" value="${mm_biz_name}" />
									</div>
								</div>
							</div>
							<div class="col-lg-12">

								<div class="col-lg-6">
									<div class="form-group">
										<label>场馆简称：</label> <input class="form-control formConl"
											type="text" id="mm_dba_name" name="mm_dba_name"
											placeholder="场馆简称" value="${mm_dba_name}" />
									</div>
								</div>
								<%-- <div class="col-lg-6">
									<div class="form-group">
										<label>场馆等级：</label> <select id="mm_phy_state"
											name="mm_phy_state" path="mm_phy_state">
											<option value="" selected>全部</option>
											<option value="1" ${ mm_phy_state eq '1' ? 'selected' :''}>商户</option>
											<option value="0" ${ mm_phy_state eq '0' ? 'selected' :''}>场馆</option>
										</select>
									</div>
								</div> --%>
							</div>
							<div class="col-md-12" >
								<div style="text-align:right;display:block;width:100%;">
								
									<c:if test="${app:checkPermission('TRMMST_GATE_SHOW')}">
										<button type="submit" class="btn-size" style="width: 110px; float:right;" id="memberShip">查询</button>
									</c:if>
								</div>
							</div>
						</form>
						<h3 class="clearfix" style="border-bottom: 2px dashed #f7ab00;">查询列表</h3>
						<div class="checkList">
							<table class="table">
								<thead>
									<tr>
										<th>场馆号码</th>
										<th>场馆名称</th>
										<!-- <th>场馆简称</th> -->
										<!-- <th>商户&nbsp;|&nbsp;场馆</th> -->
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}">
										<tr>
											<td>${item.mmMerchantNo}</td>
											<td>${item.mmBizName}</td>
											<%-- <td>${item.mmDbaName}</td> --%>
											<%-- <td>${item.mmPhyState == '1' ? '商户' :  '场馆'}</td> --%>
											<td>
												<div class="btn-toolbar pull-right" role="toolbar">
													<div class="btn-group">
														<c:if test="${app:checkPermission('TRMMST_GATE_SHOW')}">
															<a href="${ctx}/trmmstgate/viewlist/${item.mmMerchantNo}"><span
																class="check">查看</span></a>
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
				</div>
				<div class="box-footer clearfix">
					<a href="${ctx }/startTreeviewDetail/cggl" class="backStyle" style="font-size:18px;"><span>&lt;返回</span></a>
					<tags:pagination url="${ctx}/trmmstgate/list"
						queryString="mm_merchant_no=${mm_merchant_no }&mm_biz_name=${mm_biz_name }&mm_dba_name=${mm_dba_name }&mm_phy_state=${mm_phy_state }"
						page="${pageInfo}" cssClass="pull-right" />
				</div>
			</div>
		</div>
	</div>
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->
	<tags:load_common_js />
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/datepicker/datepicker.js"></script>
<%-- 	<script src="${assets}/datepicker/locales/zh-CN.js"></script> --%>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/layer/layer.js"></script>
<%-- 	<script src="${assets}/crypto/md5.js"></script> --%>
	<script language="javascript">
	var sIPAddr="";
	var service = locator.ConnectServer();
	service.Security_.ImpersonationLevel=3;
	service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
	</script>
	<script FOR="foo" EVENT="OnObjectReady(objObject,objAsyncContext)"
		LANGUAGE="JScript">
        if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true){
                 if(objObject.IPEnabled && objObject.IPAddress(0) !=null && objObject.IPAddress(0) != "undefined")
                               sIPAddr = objObject.IPAddress(0);
                      
         }
	</script>
</body>
</html>