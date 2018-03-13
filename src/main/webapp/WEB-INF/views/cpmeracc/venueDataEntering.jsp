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
<title>综合管理系统| 场馆录入</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets}/validator/css/css.css" />
<link rel="stylesheet" href="${assets}/gatesManagement/css/gatesManagement.css"/>
<style>
.form-group .col-md-6:last-of-type label{
	width:13em;
}
.form-group .col-md-6:first-of-type label{
	width: 8em;
}
.col-lg-6{
	padding: 0 15px;
}
.checkList table tr td:last-of-type {
	text-align: right;
}
.checkList table th:last-of-type {
	text-align: right;
}
table td a{
	color: #333;
}
</style>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">

	
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="cpmeracc" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
					<h1>场馆录入</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li class="active">场馆录入</li>
					</ol>
				</section>
			<div class="row outer-wrap">
        <div class="tip-img"><p>场馆录入</p></div>
        <div class="content">
            <div class="main">
            	<c:if test="${app:checkPermission('VENUE_ENTRY_ADD') }">
               		<h3 class="site-manage-title" style="border-bottom: 2px dashed #45a0e0;">场馆待授权列表 <a href="${ctx}/cpmeracc/venueDataEntering_add" class="btn add-btn"><span class="font36 icon-add">+</span>添加</a></h3>
                </c:if>
                <table class="table">
                    <thead>
                    <tr>
                        <th>场馆号码</th>
                        <th>场馆名称</th>
                        <th>场馆别名</th>
                        <th style="text-align:right;">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${pageInfo.list}">
                    	<tr>
                    		<td>${item.mmMerchantNo}</td>
					        <td>${item.mmBizName}</td>
					        <td>${item.mmStmtName}</td>
					        <td style="text-align:right;">		
								<c:if test="${app:checkPermission('VENUE_ENTRY_UPDATE') }">
									<a href="${ctx}/cpmeracc/venueDataEntering_update/${item.mmMerchantNo}">更新<!-- <i class="fa fa-fw fa-edit" aria-hidden="true"></i> --></a>
								</c:if>
								<c:if test="${app:checkPermission('VENUE_ENTRY_SHOW') }">
									<a href="${ctx}/cpmeracc/venueDataEntering_search/${item.mmMerchantNo}">查看<!-- <i class="fa fa-fw fa-eye" aria-hidden="true"></i> --></a>
								</c:if>
								<c:if test="${app:checkPermission('VENUE_ENTRY_DELETE')}">
									<a href="${ctx}/cpmeracc/venueDataEntering_del/${item.mmMerchantNo}" onclick="return confirm('确认删除?')">删除<!-- <i class="glyphicon glyphicon-trash" aria-hidden="true"></i> --></a>
								</c:if>
								<c:if test="${app:checkPermission('VENUE_ENTRY_AUTH')}">
									<a onclick="theIdForImpower('${item.mmMerchantNo}')" >授权<!-- <i class="fa fa-fw fa-user" aria-hidden="true"></i> --></a>
								</c:if>
					 		</td>
                    </c:forEach>
                    </tbody>
                </table>
                <a type="button"  href="${ctx }/startTreeviewDetail/xcgl" class="form-a">&lt;返回</a>
            </div>
        </div>
    </div>
    	</div>
    </div>
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->
	<tags:load_common_js />
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/layer/layer.js"></script>
	<script language="javascript">
	var sIPAddr="";
	var service = locator.ConnectServer();
	service.Security_.ImpersonationLevel=3;
	service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
	</script>
	<script FOR="foo" EVENT="OnObjectReady(objObject,objAsyncContext)" LANGUAGE="JScript">
        if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true){
                 if(objObject.IPEnabled && objObject.IPAddress(0) !=null && objObject.IPAddress(0) != "undefined")
                               sIPAddr = objObject.IPAddress(0);
                      
         }
	</script>
	<script type="text/javascript">
		var currentcpmeraccId = "${currentStaffId}";
			function theIdForImpower(merchantNo){
				
				$.ajax({
					type : "POST",
					url : "${ctx}/cpmeracc/getCurrentStaffId1",
					dataType : "text",
					data : {
						merchantNo : merchantNo
					},
					success : function(data) {
						if(data == currentcpmeraccId){
							alert("不能复核自己录入的记录！");
						}else{
							if(confirm("确定授权？")){
								location.href = "${ctx}/cpmeracc/venueDataEntering_authorize/"+merchantNo;
							}
						}
					}
				});
			}
		</script>
</body>
</html>