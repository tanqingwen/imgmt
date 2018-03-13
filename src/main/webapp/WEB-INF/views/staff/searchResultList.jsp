<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 商户列表</title>
		<tags:head_common_content/>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<tags:main_header/>
			<tags:main_sidebar active="merchant"/>
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<section class="content-header">
					<h1>商户管理</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">商户管理</a></li>
						<li class="active">商户维护</li>
					</ol>
				</section>
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-list"></i> 商品列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
											    	<th>选择</th>
											        <th>商户号码</th>
				                                    <th>商品名称</th>
				                                    <th>商品别名</th>
				                                    <th>区域代码</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td><input type='checkbox' name='choose' id="choose" value="${item.mmMerchantNo}"></td>
													<td>${item.mmMerchantNo}</td>				                                  
				                                    <td>${item.mmDbaName}</td>
				                                    <td>${item.mmBizName}</td>
				                                    <td>${item.mmGuiCode}</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/staff/searchResultList" page="${pageInfo}" cssClass="pull-right"/>
								</div>
								<div class="box-footer clearfix">
									<div class="pull-left">
										<table>
											<tr>
												<button id="theIdForUpdate" class="btn btn-sm btn-default btn-flat">更新</button>
												<button id="theIdForBackPage" class="btn btn-sm btn-default btn-flat">返回</button>
											</tr>
										</table>
									</div>
								</div>
							</div><!-- /.box -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</section><!-- /.content -->
			</div><!-- /.content-wrapper -->
			<tags:main_footer/>
			<tags:control_sidebar/>
		</div><!-- ./wrapper -->
		<tags:load_common_js/>
		<script type="text/javascript">
		$(document).ready(function(){
			$("#theIdForBackPage").click(function(){
				location.href = "${ctx}/staff/merchantPreserve";
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
					location.href = "${ctx}/staff/merchantPreserve_update/"+merchantNo;
				}
			
			});
		});
		</script>
	</body>
</html>
