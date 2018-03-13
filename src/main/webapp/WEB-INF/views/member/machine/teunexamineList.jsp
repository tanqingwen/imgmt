<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 终端管理-待复核列表</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="machine" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>终端管理-待复核列表</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">商户管理</a></li>
            		<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">商户列表</a></li>
            		<li><a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">终端列表</a></li>	
					<li class="active">待复核列表</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-search"></i> 查询表单
						</h3>
						<div class="box-tools">
						</div>
					</div>
					<!-- /.box-header -->
				<!-- form start -->
				<form class="form-horizontal" action="${ctx}/machine/waunexamineList" method="post">
					<div class="box-body">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="organizationId" class="col-sm-3 control-label">商户号码</label>
								<div class="col-sm-9">
									<input class="form-control" id="tm_merchant_id" name="tm_merchant_id"
										type="text" value="${merchantId }" readonly="readonly">
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="roleName" class="col-sm-3 control-label">终端号码</label>
								<div class="col-sm-9">
									<input class="form-control" id="tm_terminal_id" name="tm_terminal_id"
										placeholder="终端号码" type="text">
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-info pull-right">
							<i class="fa fa-search"></i> 查询
						</button>
					</div>
					<!-- /.box-footer -->
				</form>
		</div>
		<!-- /.box -->
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-list"></i> 终端列表
						</h3>
						<div class="box-tools pull-right">
							<button class="btn btn-box-tool" data-widget="collapse">
								<i class="fa fa-minus"></i>
							</button>
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
									    <th>选择</th>
										<th>终端编号</th>
										<th>终端类型</th>
										<th>终端状态</th>
										<th>当前状态</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}">
										<tr>
										    <td><input type='checkbox' name='choose' id="choose" value="${item.tmTerminalId}"></td>
											<td>${item.tmTerminalId}</td>
											<td>${item.tmModel}</td>
											<td>${item.tmStatus=='1'?'停用':'正常'}</td>
											<td>
												<c:if test="${item.tmApplStatus=='U'}">
													终端更新-录入
												</c:if>
												<c:if test="${item.tmApplStatus=='A'}">
													终端添加-录入
												</c:if>
											</td>
											
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /.box-body -->
					
					<div class="box-footer clearfix">
									<div class="pull-left">
										<table>
											<tr>
												<c:if test="${app:checkPermission('VENUEALLTRMMST_VIEW') }">
													<button id="theIdForSearch" class="btn btn-sm btn-default btn-flat" >查询</button>
												</c:if>
												<c:if test="${app:checkPermission('VENUEALLTRMMST_AUTH') }">
													<button id="theIdexamine" class="btn btn-sm btn-default btn-flat">复核</button>
												</c:if>
												<c:if test="${app:checkPermission('VENUEALLTRMMST_DELETE') }">	
													<button id="theIdForDel" class="btn btn-sm btn-default btn-flat">删除</button>
												</c:if>
												<a type="button" class="btn btn-sm btn-default btn-flat" href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
											</tr>
											<tr>
												<tags:pagination url="${ctx}/machine/trunexamineList"  queryString="tm_merchant_id=${merchantId }&tm_terminal_id=${tm_terminal_id }" page="${pageInfo}" cssClass="pull-right" />
											</tr>
										</table>
									</div>
								</div>

					<div class="box-footer clearfix">
					
					</div>
				</div>
				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
		</section>
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
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/pdata/pdata.js"></script>
	<script type="text/javascript">
	$('#datepicker').datepicker({
		format: 'yyyy/mm/dd',
		startDate: '-3d',
		autoclose: true
	});
	
	
	<!--添加-->
	var currentStaffId = "${currentStaffId}";
		$(document).ready(function(){
			
			$("#theIdForDel").click(function(){
				var machineNo = $("input[name=choose]:checked").val();
				if ($("input[name=choose]:checked").length == 0) {
					alert("请选择您要删除的终端！");
					return;
				}else if($("input[name=choose]:checked").length > 1) {
					alert("一次只能删除一个终端！");
					return;
				}
				if(confirm("您确定要删除该终端？")){
						location.href = "${ctx}/machine/teunexamineDelete/"+machineNo;
					}
						
			});
				
			
			//待复核列表-查询详情
			$("#theIdForSearch").click(function(){
				var machineNo = $("input[name=choose]:checked").val();
				if ($("input[name=choose]:checked").length == 0) {
					alert("请选择您要查询的终端！");
					return;
				}else if($("input[name=choose]:checked").length > 1) {
					alert("一次只能查询一个终端！");
					return;
				}else{
					location.href = "${ctx}/machine/teunexamineshow/"+machineNo;
				}
						
			});
			
			
			//待复核列表-复核 
			$("#theIdexamine").click(function(){
				var machineNo = $("input[name=choose]:checked").val();
				if ($("input[name=choose]:checked").length == 0) {
					alert("请选择您要复核的终端！");
					return;
				}else if($("input[name=choose]:checked").length > 1) {
					alert("一次只能复核一个终端！");
					return;
				}else{
					$.ajax({
						type : "POST",
						url : "${ctx}/machine/getMachineSetUser",
						dataType : "text",
						data : {
							machineNo : machineNo
						},
						success : function(data) {
							if(data == currentStaffId){
								alert("不能复核自己录入的记录！");
							}else{
								if(confirm("确定复核终端  "+machineNo+"？")){
									location.href = "${ctx}/machine/trexamine/"+machineNo;
								}
							}
						}
					});
				}
						
			});
			
		}); 
	</script>
	

</body>
</html>
