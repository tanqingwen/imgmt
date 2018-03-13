<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 会员卡充值统计</title>
		<tags:head_common_content/>		
	<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="rechargelist"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>会员卡充值统计</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
						<li class="active">会员卡充值统计</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>		                  
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" id="thisform" action="" method="post">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="rechargeName" class="col-sm-3 control-label">姓名</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cbEmbossname" name="cbEmbossname" placeholder="姓名" value="${cbEmbossname }" oninput="buttonds()" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
				                      <label for="rechargeFlag" class="col-sm-3 control-label">状态</label>
				                      <div class="col-sm-9">
				                        <select class="form-control" id="ctReversalFlag" name="ctReversalFlag" onchange="buttonds()">
									    	<option value="0" ${ ctReversalFlag eq '0' ? 'selected' :''}>正常</option>
	    									<option value="1" ${ ctReversalFlag eq '1' ? 'selected' :''}>已撤销</option>
									    </select>
				                      </div>
				                </div>
			                </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="rechargeNo" class="col-sm-3 control-label">卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="ctCardNumber" name="ctCardNumber" value="${ctCardNumber }" placeholder="卡号" oninput="buttonds()" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
				                      <label for="rechargeType" class="col-sm-3 control-label">卡种</label>
				                      <div class="col-sm-9">
				                      	<input type="hidden" id="prProdctGrouptext" value="${prProdctGroup }"/>
				                        <select class="form-control" id="prProdctGroup" name="prProdctGroup" onchange="buttonds()">
									    	<option value="">===请选择===</option>
									    	<c:forEach var="item" items="${prdgrp}" >
									    		<option value="${item.prProdctGroup}" >${item.prProdctGroup}-${item.prGroupDesc }</option>
									    	 </c:forEach>
									    </select>
				                      </div>
				                </div>
			                </div>
			                <div class="col-sm-6">
			                	<div class="form-group date firstCommission">
									<label for="rechargeStart" class="col-sm-3 control-label">充值起始时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" id="ctApproveTimeStart" name="ctApproveTimeStart" value="${ctApproveTimeStart }" onchange="buttonds()" style="width: 133.5%"/>
	                                	</div>
	                                </div>
								</div>
							</div>
							<div class="col-sm-6">								
								<div class="form-group date firstCommission">
									<label for="rechargeEnd" class="col-sm-3 control-label">充值结束时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
	                                    	<input readonly="readonly" type="text" size="18" class="form-control" id="ctApproveTimeEnd" value="${ctApproveTimeEnd }" name="ctApproveTimeEnd" onchange="buttonds()" style="width: 133.5%"/>
	                                    </div>
	                                </div>
								</div>
							</div>
							<div class="col-sm-6">
			                    <div class="form-group">
				                      <label for="rechargeUser" class="col-sm-3 control-label">操作员</label>
				                      <div class="col-sm-9">
				                      	<input type="hidden" id="ctUserCreatetext" value="${ctUserCreate }"/>
				                        <select class="form-control" id="ctUserCreate" name="ctUserCreate" onchange="buttonds()">
									    	<option value="">===请选择===</option>
									    	<c:forEach var="item" items="${aclUsers}" varStatus="status">
									    		<option value="${item.userId}">${item.userId}-${item.userName }</option>
									    	</c:forEach>
									    </select>
				                      </div>
				                </div>
			                </div>
			                <div class="col-sm-6">
				                <div class="form-group">
				                      <label for="rechargeUserNull" class="col-sm-3 control-label">排除操作员</label>
				                      <div class="col-sm-9">
				                      	<input type="hidden" id="ctUserCreateNulltext" value="${ctUserCreateNull }"/>
				                        <select class="form-control" id="ctUserCreateNull" name="ctUserCreateNull" onchange="buttonds()">
									    	<option value="">===请选择===</option>
									    	<c:forEach var="item" items="${aclUsers}" varStatus="status">
									    		<option value="${item.userId}">${item.userId}-${item.userName }</option>
									    	</c:forEach>
									    </select>
				                      </div>
				                </div>
			                </div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                  	<div class="pull-right">
			                    <button type="submit" class="btn btn-info " id="theIdForSubmit"><i class="fa fa-search"></i> 查询</button>
			                    <a type="button" class="btn btn-info" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
			                    <c:if test="${app:checkPermission('RECHARGE_LIST_DOWNLOAD') }">
			                    	<button type="submit" class="btn btn-info " id="downLoad"><i class="fa fa-search"></i> 下载</button>
			                    </c:if>
		                    </div>
		                  </div><!-- /.box-footer -->
		                </form>
			        </div><!-- /.box -->
				
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-list"></i> 查询列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
				                                    <th>卡号</th>
				                                    <th>卡产品</th>
				                                    <th>姓名</th>
				                                    <th>充值时间</th>
				                                    <th>充值金额</th>
				                                    <th>操作员</th>
											    </tr>
											</thead>
											<tbody>
											<c:forEach var="item" items="${pageInfo.list}" varStatus="status">
												<tr>											
													<td>${item.ctCardNumber}</td>
				                                    <td>${item.prGroupDesc}</td>	
				                                    <td>${item.cbEmbossname}</td>			                                   
				                                    <td><tags:format_string patten="####/##/## ##:##:##" value="${item.ctApproveTime}"/></td>
				                                    <td>${item.ctBillCurrAmt}</td>
				                                    <td>${item.ctUserCreate}</td>
													
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/recharge/list" queryString="cbEmbossname=${cbEmbossname }&ctReversalFlag=${ctReversalFlag }&ctCardNumber=${ctCardNumber }&prProdctGroup=${prProdctGroup }&ctApproveTimeStart=${ctApproveTimeStart }&ctApproveTimeEnd=${ctApproveTimeEnd }&ctUserCreate=${ctUserCreate }&ctUserCreateNull=${ctUserCreateNull }" page="${pageInfo}" cssClass="pull-right"/>
								</div>
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
		<script src="${assets}/datepicker/locales/date.js"></script>
		<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	    <script src="${assets}/validator/js/validator.js"></script>
	    <script src="${assets}/pdata/pdata.js"></script>
	    <script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	    <script type="text/javascript">
	    function buttonds (){
	    	$("#downLoad").attr("disabled",true);
	    }
		    $(document).ready(function(){
				$('.firstCommission').datepicker({
		   			format: 'yyyymmdd',
					autoclose: true,
					todayBtn : "linked",  
			        autoclose : true,  
			        todayHighlight : true,  
			    });
				
				$("#theIdForSubmit").click(function(){
					var ctApproveTimeStart = $("#ctApproveTimeStart").val();
					var ctApproveTimeEnd = $("#ctApproveTimeEnd").val();
					if(ctApproveTimeStart != "" && ctApproveTimeEnd != ""){
						if(Number(ctApproveTimeStart)>Number(ctApproveTimeEnd)){
							alert("充值起始时间不可以大于充值结束时间！");
							return false;
						}
					}
					$("#thisform").attr("action", "${ctx}/recharge/list");
					$("#downLoad").attr("disabled",false);
				});
				$("#downLoad").click(function(){
					$("#thisform").attr("action", "${ctx}/recharge/rechargeDownLoad");
				});
			});	
		    $(function () {
		    	if($("#prProdctGrouptext").val()==""){
		    		$("#prProdctGroup").val($("#prProdctGroup option:first").val());
		    	}else{
		    		$("#prProdctGroup").val($("#prProdctGrouptext").val());
		    	}
		    	if($("#ctUserCreatetext").val()==""){
		    		$("#ctUserCreate").val($("#ctUserCreate option:first").val());
		    	}else{
		    		$("#ctUserCreate").val($("#ctUserCreatetext").val());
		    	}
		    	if($("#ctUserCreateNulltext").val()==""){
		    		$("#ctUserCreateNull").val($("#ctUserCreateNull option:first").val());
		    	}else{
		    		$("#ctUserCreateNull").val($("#ctUserCreateNulltext").val());
		    	}
		    });
	    </script>
	</body>
</html>
