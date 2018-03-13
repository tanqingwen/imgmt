<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<link rel="stylesheet" type="text/css" href="${assets}/venuePreserve/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${assets}/venuePreserve/css/layer.css" />
		<link rel="stylesheet" href="${assets}/venuePreserve/css/all.css" />
		<title>商户查询</title>
	</head>

	<body>
		<div class="wrapper">
		<div class="container-fluid">
		<tags:main_header/>
		<tags:main_sidebar active="pressmv"/>
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>商户查询</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li class="active">商户查询</li>
					</ol>
				</section>
			<div class="row">
				<div class="tip-img"><p>商户查询</p></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						<form id="defaultForm" name="defaultForm" class="form-horizontal">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="MerchantNum">商户号码：</label><input class="form-control formConl line-input" type="text" name="MerchantNum" id="MerchantNum" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="MerchantName">商户名称：</label><input class="form-control formConl line-input" type="text" name="MerchantName" id="MerchantName" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="MerchantAbb">商户简称：</label><input class="form-control formConl line-input" type="text" name="MerchantAbb" id="MerchantAbb" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="MerchantGrade">归属场馆：</label><!--<input class="form-control formConl line-input" type="text" name="MerchantGrade" id="MerchantGrade" />-->                       
											<select  class="MerchantGrade">
												<option value="">请选择场馆</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<button class="btn MerchantBtn btn-size btnSty">查询</button>
							</div>
						
							<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
							
					

							<div class="col-lg-12 col-md-12 clearfix" >
								<div class="checkList">
								<table class="table table-responsive">
									<thead>
										<tr>
											<th>商户号码</th>
											<th>商户商户名称</th>
											<th>商户简称</th>
											<th>操作</th>
										</tr>
									</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.mmMerchantNo}</td>				                                  
				                                    <td>${item.mmBizName}</td>
				                                    <td>${item.mmStmtName}</td>
				                                    <!-- <td class="operationAll"><span class="check"><a href="MerchantDetail.html" class="">查看</a>
				                                    </span><span class=""><a href="">编辑</a></span></td> -->
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('MERMST_VIEW') }">
																	<a type="button" class="btn btn-default btn-xs" title="商户详情" href="${ctx}/staff/merchantPreserve_view/${item.mmMerchantNo}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
																</c:if>
																<c:if test="${app:checkPermission('VENUEMERMST_GLIST') }">
																	<a type="button" class="btn btn-default btn-xs" title="终端列表" href="${ctx}/staff/trmmstPreserve_view/${item.mmMerchantNo}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
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
						</form>
					</div>
				</div>
			</div>
			<tags:main_footer/><!-- Main footer -->
			<tags:control_sidebar/><!-- Control Sidebar -->
			</div>
		</div>
		</div>	
		<tags:load_common_js/>
	
		<input type="hidden" value="3" id="test" />、
		<script type="text/javascript" src="${assets}/venuePreserve/js/jquery-3.1.1.min.js"></script>
		<script src="${assets}/venuePreserve/js/layer.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
			
			$('.firstCommission').datepicker({
	   			format: 'yyyymmdd',
				autoclose: true
	   		});
			
			var mmPmtMode = "0"; //默认0等级
	 		$.ajax({
	 			async: false,
				type : "POST",
				url : "${ctx}/staff/search_mermst_Data1",
				dataType : "json",
				data : {
					mmPmtMode : mmPmtMode
				},
				success : function(data) {
					if (data.status == "OK") {
						mmChainAccno = data.value;
						var obj=document.getElementById('mmChainAccno');
						$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));
					}else{
						alert("归属场馆错误");
					}
				}
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