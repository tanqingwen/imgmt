<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统  | 场馆维护</title>
		<tags:head_common_content/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/venueMaintenance5.css">
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
					<h1>场馆维护</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx }/staff/vmerupdPreserve">场馆维护</a></li>
						<li class="active">场馆维护</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
						<%--  
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                </div><!-- /.box-header -->
		                --%>
		                <!-- form start -->
		                <%--  
		                <form class="form-horizontal" action="${ctx}/staff/searchResultList" method = "post">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="merchantID" class="col-sm-3 control-label">商户号码</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="mmMerchantNo" name="mmMerchantNo" value="${mmMerchantNo }" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="merchantTName" class="col-sm-3 control-label">商户名称</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="mmBizName" name="mmBizName" value="${mmBizName }" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="merchantFName" class="col-sm-3 control-label">商户别名</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="mmDbaName" name="mmDbaName" value="${mmDbaName }" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    
		                    <div class="col-sm-6">
								<div class="form-group">
							    <label for="mmChainAccno" class="col-sm-3 control-label">归属场馆</label>
							    <div class="col-sm-9">
							    	<select class="form-control" id="mmChainAccno" name="mmChainAccno">
							    	</select>
							    </div>
								</div>
							</div>	
		                    
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                  	<div class="pull-right">
		                    	<button type="submit" class="btn btn-info "><i class="fa fa-search"></i> 查询</button>
			                    <a type="button" class="btn btn-info" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
		                    </div>
		                  </div><!-- /.box-footer -->
		                </form>
			        </div><!-- /.box -->
				
					--%>
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<%--  
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-list"></i> 查询列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
								--%>
								<div class="box-tools pull-right"> 
					                 <a type="button" class="btn btn-default" href="${ctx}/staff/vmerupdPreserve"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
								</div>
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
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
															    <c:if test="${app:checkPermission('VMERUPD_UPDARE') }">
																	<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/staff/vmermstPreserve_update/${item.mmMerchantNo}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
																</c:if>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								
							</div><!-- /.box -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</section><!-- /.content -->
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
