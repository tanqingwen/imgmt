<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统  | 商户维护</title>
		<tags:head_common_content/>
    	<link rel="stylesheet" href="${assets }/spwh/css/Merchant.css">
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
					<h1>商户维护</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx }/staff/merupdPreserve">商户维护</a></li>
						<li class="active">商户维护</li>
					</ol>
				</section>

				<!-- Main content -->
				<div class="row outer-wrap">
        <div class="tip-img"><p>商户维护</p></div>
        <div class="content">
            <div class="main">
                <form id="defaultForm" name="defaultForm" class="form-horizontal">
							<h3 style="border-bottom: 2px dashed #45a0e0;">商户维护</h3>
							<div class="col-lg-12 col-md-12 clearfix tableContent" style="display: block;">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>商户号码</th>
												<th>商户名称</th>
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
													<td>
														<span class="edit">
															<c:if test="${app:checkPermission('MERUPD_MAINTAIN_SHOW') }">
																<a style="text-decoration: none;" href="${ctx}/staff/mermstPreserve_update/${item.mmMerchantNo}">更新</a>
															</c:if>
														</span>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="box-footer clearfix">
										<tags:pagination url="${ctx}/staff/searchVmermstResultList" page="${pageInfo}" cssClass="pull-right"/>
									</div>
								</div>

							</div>

						</form>
						<div class="col-lg-12 submit-group">
							<a href="JavaScript:;" onclick="javascript :history.back(-1);" class="form-a">&lt;返回</a>

						</div>
		            </div>
		        </div>
		    </div>
		</div>
			</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>
		<script src="${assets}/underscore/underscore.min.js"></script>
		<script src="${assets}/datepicker/datepicker.js"></script>
		<script src="${assets}/datepicker/locales/zh-CN.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
	    <script src="${assets}/moment/moment.min.js"></script>
	    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
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
