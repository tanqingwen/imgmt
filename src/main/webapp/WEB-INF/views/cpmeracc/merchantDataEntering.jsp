<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统| 商户录入</title>
<tags:head_common_content />

<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets}/validator/css/css.css" />
<link rel="stylesheet" href="${assets}/gatesManagement/css/gatesManagement.css" />

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

.btn-default{
	  background-color: transparent;
}
.btn{
	border:none;
	border-radius:0px;
}
.btn:hover{
	background-color:transparent;
}
.table-striped>tbody>tr:nth-of-type(odd){
	background-color:#fff;
}
</style>
</head>
<body class="hold-transition skin-blue-light sidebar-mini sidebar-open">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />
<tags:main_sidebar active="merent" /> 
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<section class="content-header">
				<h1>商户录入</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li class="active">商户录入</li>
				</ol>
			</section>
			<div class="row outer-wrap">
			<div class="tip-img"><p>商户录入</p></div>
			
			<section class="content">
				<div class="main">
					<div class="col-md-12">
						<!-- <div class="box box-info"> -->
							<div class="box-header with-border">
								 <h3 class="site-manage-title" style="border-bottom: 2px dashed #45a0e0;">商户待授权列表
								 <c:if test="${app:checkPermission('MERACC_ENTRY_ADD') }">	
								 	<a href="${ctx}/cpmeracc/merchantDataEntering_add" class="btn add-btn">+添加</a>
								 	</c:if></h3>
								
								<!-- <h3 class="box-title">
									<i class="fa fa-list"></i> 查询列表
								</h3> -->
								<%-- 									<h3 class="box-title"><i class="fa fa-list"></i>场馆资料列表:  &nbsp;&nbsp;共&nbsp;<font color="red">${CpMeraccSize}</font>&nbsp;条数据</h3> --%>
								<%-- <div class="box-tools pull-right">
									<c:if test="${app:checkPermission('MERACC_ADD') }">
										<a class="btn pull-right"
											href="${ctx}/staff/merchantDataEntering_add"><i
											class="fa fa-plus"></i> 添加</a>
									</c:if>
								</div> --%>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>商户号码</th>
												<th>商户名称</th>
												<th>商户简称</th>
												<th class="text-right">操作</th>
												<!--  
											        <th>区域代码</th>
											        -->
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.mmMerchantNo}</td>
													<td>${item.mmBizName}</td>
													<td>${item.mmStmtName}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('MERACC_ENTRY_UPDATE') }">
																	<a type="button" class=""
																		title="修改"
																		href="${ctx}/cpmeracc/merchantDataEntering_update/${item.mmMerchantNo}"><span
																		class="" aria-hidden="true">更新</span></a>
																</c:if>
																<c:if test="${app:checkPermission('MERACC_ENTRY_SHOW') }">
																	<a type="button" class=""
																		title="查看"
																		href="${ctx}/cpmeracc/merchantDataEntering_search/${item.mmMerchantNo}"><span
																		class="" aria-hidden="true">查看</span></a>
																</c:if>
																<c:if test="${app:checkPermission('MERACC_ENTRY_DELETE')}">
																	<a type="button" class=""
																		title="删除"
																		href="${ctx}/cpmeracc/merchantDataEntering_del/${item.mmMerchantNo}"
																		onclick="return confirm('确认删除?')"><!-- <i
																		class="" aria-hidden="true"> -->删除<!-- </i> --></a>
																</c:if>
																<c:if test="${app:checkPermission('MERACC_ENTRY_AUTH')}">
																	<a type="button" class=""
																		title="授权"
																		onclick="theIdForImpower('${item.mmMerchantNo}')"><span
																		class="" aria-hidden="true">授权</span></a>
																</c:if>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-12">
								 <a type="button"  href="${ctx }/startTreeviewDetail/xcgl" class="form-a">&lt;返回</a>
									<tags:pagination url="${ctx}/cpmeracc/merchantDataEntering"
										page="${pageInfo}" cssClass="pull-right" />
								</div>
							</div>
							<!-- /.box-body -->
							<%--  <div class="box-footer clearfix">
									<tags:pagination url="${ctx}/staff/merchantDataEntering" page="${pageInfo}" cssClass="pull-right" />
								</div>  --%>
						<!-- </div> -->
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main footer -->
		<tags:main_footer />

		<!-- Control Sidebar -->
		<tags:control_sidebar />

	</div>
	<!-- ./wrapper -->
	<tags:load_common_js />
	<script type="text/javascript">
		var currentStaffId = "${currentStaffId}";
			$(document).ready(function(){
                
				$("#theIdForAdd").click(function(){
					location.href = "${ctx}/cpmeracc/merchantDataEntering_add";
				});
				
				$("#theIdForUpdate").click(function(){
					var merchantNo = $("input[name=choose]:checked").val();
					if ($("input[name=choose]:checked").length == 0) {
						alert("请选择您要更新的商户！");
						return;
					}else if($("input[name=choose]:checked").length > 1) {
						alert("一次只能更新一个商户！");
						return;
					}else{
						location.href = "${ctx}/cpmeracc/merchantDataEntering_update/"+merchantNo;
					}
							
					});
				$("#theIdForDel").click(function(){
					var merchantNo = $("input[name=choose]:checked").val();
					if ($("input[name=choose]:checked").length == 0) {
						alert("请选择您要删除的商户！");
						return;
					}else if($("input[name=choose]:checked").length > 1) {
						alert("一次只能删除一个商户！");
						return;
					}else{
						if(confirm("您确定要删除该商户？")){
							location.href = "${ctx}/cpmeracc/merchantDataEntering_del/"+merchantNo;
						}
					}
							
				});
					
				$("#theIdForSearch").click(function(){
					var merchantNo = $("input[name=choose]:checked").val();
					if ($("input[name=choose]:checked").length == 0) {
						alert("请选择您要查询的商户！");
						return;
					}else if($("input[name=choose]:checked").length > 1) {
						alert("一次只能查询一个商户！");
						return;
					}else{
						location.href = "${ctx}/cpmeracc/merchantDataEntering_search/"+merchantNo;
					}
					});
				
				$("#theIdForImpower").click(function(){
					var merchantNo = $("input[name=choose]:checked").val();
					if ($("input[name=choose]:checked").length == 0) {
						alert("请选择您要复核的商户！");
						return;
					}else if($("input[name=choose]:checked").length > 1) {
						alert("一次只能复核一个商户！");
						return;
					}else{
						$.ajax({
							type : "POST",
							url : "${ctx}/cpmeracc/getCurrentStaffId",
							dataType : "text",
							data : {
								merchantNo : merchantNo
							},
							success : function(data) {
								if(data == currentStaffId){
									alert("不能复核自己录入的记录！");
								}else{
									if(confirm("确定复核？")){
										location.href = "${ctx}/cpmeracc/merchantDataEntering_authorize/"+merchantNo;
									}
								}
							}
						});
					}
				});
			});
			function theIdForImpower(merchantNo){
				$.ajax({
					type : "POST",
					url : "${ctx}/cpmeracc/getCurrentStaffId",
					dataType : "text",
					data : {
						merchantNo : merchantNo
					},
					success : function(data) {
						if(data == currentStaffId){
							alert("不能复核自己录入的记录！");
						}else{
							if(confirm("确定授权？")){
								location.href = "${ctx}/cpmeracc/merchantDataEntering_authorize/"+merchantNo;
							}
						}
					}
				});
			}
			$(document).ready(function(){
				if($('body').hasClass('sidebar-collapse')){
					$('body').removeClass('sidebar-collapse');
				}
				
			});
			
		</script>
</body>
</html>



