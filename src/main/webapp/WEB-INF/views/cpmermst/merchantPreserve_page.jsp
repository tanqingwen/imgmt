<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>综合管理系统  | 商户查询</title>
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets}/venuePreserve/css/layer.css" />
		<title>商户查询</title>
		<link rel="stylesheet" href="${assets}/venuePreserve/css/all.css" />
		
		<style>
		.line-input{
			width:290px;
		}
		a{
			color:#333;	
		}
		.btn-toolbar{
			float:right;
			
		}
		</style>
    </head>
	
	<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="pressmv"/>
			
			<!-- Content Wrapper. Contains page content -->
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
				
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><p>商户查询</p></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						<!-- form start -->
						<form id="defaultForm" name="defaultForm" class="form-horizontal" action="${ctx}/cpmermst/searchResultList" method = "post">
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="merchantID">商户号码：</label>
											<input class="form-control formConl line-input" value="${mmMerchantNo }" type="text"  id="mmMerchantNo" name="mmMerchantNo"  />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="merchantTName">商户名称：</label>
											<input class="form-control formConl line-input" id="mmBizName" name="mmBizName" value="${mmBizName }" type="text" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="merchantFName">商户简称：</label>
											<input class="form-control formConl line-input" id="mmStmtName" name="mmStmtName" value="${mmStmtName }" type="text" />
											
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="mmChainAccno">归属场馆：</label>  <!--<input class="form-control formConl line-input" type="text" name="MerchantGrade" id="MerchantGrade" />-->                       
											<select  class="MerchantGrade line-input" id="mmChainAccno" name="mmChainAccno">
												<option value="">请选择场馆</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								
									<button class="btn venueBtn btn-size fr" type="submit">查询</button>
								<!-- <button class="btn MerchantBtn btn-size btnSty" type="submit">查询</button> -->
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
													<td >
														<div class="btn-toolbar"  role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('MERMST_SHOW') }">
																	<span class="check"><a href="${ctx}/cpmermst/merchantPreserve_view/${item.mmMerchantNo}" class="">商户详情</a></span>
<%-- 																	<a type="button" class="" title="查看" href="${ctx}/staff/merchantPreserve_view/${item.mmMerchantNo}"><i class="" ></i></a>
 --%>															</c:if>
																<c:if test="${app:checkPermission('MERMST_TERMINAL_LIST') }">
																	<%-- <a type="button" class="" title="编辑" href="${ctx}/staff/trmmstPreserve_view/${item.mmMerchantNo}"><i class="" ></i></a> --%>
																	<span class=""><a href="${ctx}/cpmermst/trmmstPreserve_view/${item.mmMerchantNo}">终端列表</a></span></td>
																</c:if>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
								</table>
							</div>
								<div class="box-footer clearfix">
								<a type="button"  href="${ctx }/startTreeviewDetail/xcgl" class="form-a">&lt;返回</a>
									<tags:pagination url="${ctx}/merchant/list" page="${pageInfo}" cssClass="pull-right"/>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
		
		</div><!-- ./wrapper -->
		<tags:load_common_js/>
		<input type="hidden" value="3" id="test" />
		<script src="${assets}/underscore/underscore.min.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
	    <script src="${assets}/moment/moment.min.js"></script>
		<script src="${assets}/layer/layer.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
			var mmPmtMode = "0"; //默认0等级
	 		$.ajax({
	 			async: false,
				type : "POST",
				url : "${ctx}/cpmermst/search_mermst_Data1",
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
						layer.msg("归属场馆错误");
					}
				}
			});
	 		//上级场馆编号
	 		var mmOldAccNumber= "${mmChainAccno}";
	 		for(var i=0;i<document.getElementById("mmChainAccno").options.length;i++){
	 			var trimab1 = document.getElementById("mmChainAccno").options[i].value;
	 			if(trimab1==mmOldAccNumber){
	 				document.getElementById("mmChainAccno").options[i].selected='selected';
	 				break;
	 			}
	 		}
		});
			
		</script>
		
		<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
			<@ }); @>
		</script>

	</body>

</html>