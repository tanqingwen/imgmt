<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 闸机列表</title>
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
				<h1>闸机列表</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
		            <li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
		            <li><a href="${ctx }/trmmstgate/list">闸机管理</a></li>
					<li class="active">闸机列表</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-search"></i> 查询表单
						</h3>
						<div class="box-tools pull-right">
						        <c:if test="${app:checkPermission('TRMMSTGATE_ADD') }">
			                  		<a class="btn pull-right" href="${ctx}/machine/addUI/${merchantId }"><i class="fa fa-plus"></i> 添加</a>
			                  	</c:if>
						</div>
					</div>
					<!-- /.box-header -->
				<!-- form start -->
				<form class="form-horizontal" action="${ctx}/machine/list" method="post">
					<div class="box-body">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="roleName" class="col-sm-3 control-label">闸机编号</label>
								<div class="col-sm-9">
									<input class="form-control" id="tm_terminal_id" name="tm_terminal_id"
										placeholder="闸机编号" value="${tm_terminal_id }" type="text">
										<input  id="tm_merchant_id" name="tm_merchant_id"
										value="${merchantId }" type="hidden">
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<div class="pull-right">
							<button type="submit" class="btn btn-info ">
								<i class="fa fa-search"></i> 查询
							</button>
							<a type="button" class="btn btn-info" href="${ctx }/trmmstgate/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
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
							<i class="fa fa-list"></i> 查询列表
						</h3>
						<div class="box-tools pull-right">
							<div class="box-tools pull-right">
						        <c:if test="${app:checkPermission('TRMMSTGATE_LIST') }">
			                  		<a class="btn pull-right" href="${ctx}/machine/unexamineList/${merchantId }"><i class="fa fa-user"></i> 待复核列表</a>
			                  	</c:if>
						    </div>
						</div>
					</div>
					<!-- /.box-header -->
					<div id="terminal" class="box-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
<!-- 									    <th>选择</th> -->
										<th>闸机编号</th>
										<th>闸机品牌</th>
										<th>闸机绑IP</th>
										<th>闸机状态</th>
										<th class="text-right">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}">
										<tr>
											<td>${item.tmTerminalId}</td>
											<td>${item.tmBrand}</td>
											<td>${item.tmHostSerial}</td>
											<td>${item.tmStatus=='1'?'停用':'正常'}</td>
											<td>
												<div class="btn-toolbar pull-right" role="toolbar">
													<div class="btn-group">
														<c:if test="${app:checkPermission('TRMMSTGATE_UPDATE')}">
															<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/machine/updateUI/${item.tmTerminalId}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
														</c:if>	
														<c:if test="${app:checkPermission('TRMMSTGATE1_VIEW')}">
															<a type="button" class="btn btn-default btn-xs" href="${ctx}/machine/show/${item.tmTerminalId}" title="查看"  ><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
														</c:if>
														<c:if test="${app:checkPermission('TRMMSTGATE_DELETE')}">	
															<a type="button" class="btn btn-default btn-xs" title="删除" href="${ctx}/machine/delete/${item.tmTerminalId}" onclick="return confirm('确认删除?')"><i class="glyphicon glyphicon-trash" aria-hidden="true"></i></a>
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
					
					<!-- /.box-body -->
					
					<div class="box-footer clearfix">
						<tags:pagination url="${ctx}/machine/list"  queryString="tm_merchant_id=${tm_merchant_id }&tm_terminal_id=${tm_terminal_id }" page="${pageInfo}" cssClass="pull-right" />
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
	
	$(function () {
		var html = "<option value=''>--- 请选择 ---</option>"; $("#input_city").append(html); $("#input_area").append(html);
		$.each(pdata,function(idx,item){
			if (parseInt(item.level) == 0) {
   				html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
   			}
		});
		$("#input_province").append(html);

		$("#input_province").change(function(){
			if ($(this).val() == "") return;
			$("#input_city option").remove(); $("#input_area option").remove();
			var code = $(this).find("option:selected").attr("exid"); code = code.substring(0,2);
			var html = "<option value=''>--- 请选择 ---</option>"; $("#input_area").append(html);
			$.each(pdata,function(idx,item){
				if (parseInt(item.level) == 1 && code == item.code.substring(0,2)) {
	   				html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
	   			}
			});
			$("#input_city").append(html);		
		});

		$("#input_city").change(function(){
			if ($(this).val() == "") return;
			$("#input_area option").remove();
			var code = $(this).find("option:selected").attr("exid"); code = code.substring(0,4);
			var html = "<option value=''>--- 请选择 ---</option>";
			$.each(pdata,function(idx,item){
				if (parseInt(item.level) == 2 && code == item.code.substring(0,4)) {
	   				html += "<option value='" + item.names + "' exid='" + item.code + "'>" + item.names + "</option>";
	   			}
			});
			$("#input_area").append(html);		
		});
		//默认绑定
		$("#input_province").val("上海市");$("#input_province").change();
		$("#input_city").val("市辖区");$("#input_city").change();
		$("#input_area").val("浦东新区");

	});
	
	
	
	
	var currentStaffId = "${currentStaffId}";
		$(document).ready(function(){
			
			//添加
			$("#theIdForAdd").click(function(){
				location.href = "${ctx}/machine/addUI";
			});
			
			
			<!--更新-->
			$("#theIdForUpdate").click(function(){
				var machineNo = $("input[name=choose]:checked").val();
				if ($("input[name=choose]:checked").length == 0) {
					alert("请选择您要更新的闸机！");
					return;
				}else if($("input[name=choose]:checked").length > 1) {
					alert("一次只能更新一个闸机！");
					return;
				}else{
					location.href = "${ctx}/machine/updateUI/"+machineNo;
				}
						
				});
			$("#theIdForDel").click(function(){
				var machineNo = $("input[name=choose]:checked").val();
				if ($("input[name=choose]:checked").length == 0) {
					alert("请选择您要删除的闸机！");
					return;
				}else if($("input[name=choose]:checked").length > 1) {
					alert("一次只能删除一个闸机！");
					//return;
				}
				if(confirm("您确定要删除该闸机？")){
						location.href = "${ctx}/machine/delete/"+machineNo;
					}
						
				});
				
			$("#theIdForSearch").click(function(){
				var machineNo = $("input[name=choose]:checked").val();
				if ($("input[name=choose]:checked").length == 0) {
					alert("请选择您要查询的闸机！");
					return;
				}else if($("input[name=choose]:checked").length > 1) {
					alert("一次只能查询一个闸机！");
					return;
				}else{
					location.href = "${ctx}/machine/show/"+machineNo;
				}
						
				});
			
			//未复核列表
			$("#theIdForImpower").click(function(){
				location.href = "${ctx}/machine/unexamineList";
			});
		}); 
	</script>

</body>
</html>
