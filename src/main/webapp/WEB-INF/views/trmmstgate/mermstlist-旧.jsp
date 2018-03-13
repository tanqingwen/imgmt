<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 商户管理</title>
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
				<h1>商户管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
					<li class="active">商户管理</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-search"></i> 查询表单
						</h3>
					</div>
					<!-- /.box-header -->
				<!-- form start -->
				<form class="form-horizontal" action="${ctx}/trmmstgate/mermstlist" method="POST">
					<div class="box-body">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="organizationId" class="col-sm-3 control-label">场馆号码</label>
								<div class="col-sm-6">
									<input class="form-control" id="mm_merchant_no" name="mm_merchant_no"
										placeholder="场馆号码" value="${mm_merchant_no }" type="text">
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="roleName" class="col-sm-3 control-label">场馆名称</label>
								<div class="col-sm-6">
									<input class="form-control" id="mm_biz_name" name="mm_biz_name"
										placeholder="场馆名称" value="${mm_biz_name}" type="text">
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="roleName" class="col-sm-3 control-label">场馆简称</label>
								<div class="col-sm-6">
									<input class="form-control" id="mm_stmt_name" name="mm_stmt_name"
										placeholder="场馆简称" value="${mm_stmt_name}" type="text">
								</div>
							</div>
						</div>
						
						<div class="col-sm-6">
	                    	<div class="form-group">
							  <label for="mmPmtMode" class="col-sm-3 control-label">场馆等级</label>
							    <div class="col-sm-6">
							     	<select name="mmPmtMode" id="mmPmtMode" class="form-control">
	 						  			<option value="0">请选择级别...</option>
	 									<option value="1">一级 - 欢乐大世界</option>
	 									<option value="2">二级 - 场馆</option>
	 									<option value="3">三级 - 子场馆</option>
	 								</select>
							    </div>
							  </div>  
						  </div>
							
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<div class="pull-right">
	                    	<button type="submit" class="btn btn-info "><i class="fa fa-search"></i> 查询</button>
		                    <a type="button" class="btn btn-info" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
<!-- 									    <th>选择</th> -->
										<th>场馆号码</th>
										<th>场馆名称</th>
										<th>场馆简称</th>
										<th class="text-right">操作</th>
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
														<c:if test="${app:checkPermission('VENUEALLMERMST_LIST')}">
															<!--  
															<a type="button" class="btn btn-default btn-xs" href="${ctx}/trmmstgate/viewlist/${item.mmMerchantNo}" title="查看"  ><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
															-->
															<a type="button" class="btn btn-default btn-xs" href="${ctx}/trmmstgate/viewmermstlist/${item.mmMerchantNo}" title="商户列表查看"  ><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
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
						<tags:pagination url="${ctx}/trmmstgate/mermstlist"  queryString="mm_merchant_no=${mm_merchant_no }&mm_biz_name=${mm_biz_name }&mm_stmt_name=${mm_stmt_name }&mm_phy_state=${mm_phy_state }" page="${pageInfo}" cssClass="pull-right" />
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
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/datepicker/datepicker.js"></script>
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
	
	
	<!--添加-->
	var currentStaffId = "${currentStaffId}";
		$(document).ready(function(){
			
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
	
	<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
			<@ }); @>
		</script>

</body>
</html>
