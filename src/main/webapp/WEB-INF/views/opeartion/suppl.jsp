<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 会员卡补卡统计</title>
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	</head>
	<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<body class="hold-transition skin-blue-light sidebar-mini" onload="getNowFormatDate()">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="opeartion"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>会员卡补卡统计</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">业务统计</a></li>
						<li class="active">会员卡补卡统计</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                  
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" action="${ctx}/opeartion/suppl" method="post">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="rechargeName" class="col-sm-3 control-label">旧卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cl_old_card" name="cl_old_card" value="${cl_old_card }" placeholder="旧卡号">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="rechargeName" class="col-sm-3 control-label">新卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cl_new_card" name="cl_new_card" value="${cl_new_card }" type="text" placeholder="新卡号">
			                      </div>
			                    </div>
		                    </div>
		                  	<div class="col-sm-6">		                  		
			                    <div class="form-group date firstCommission">
									<label for="rechargeStart" class="col-sm-3 control-label">补卡开始时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
	                                    	<input readonly="readonly" type="text" size="18" class="form-control" id="cl_timestampStart" name="cl_timestampStart" value="${cl_timestampStart }" style="width: 133.5%"/>
	                                    </div>
	                                </div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group date firstCommission">
									<label for="rechargeEnd" class="col-sm-3 control-label">补卡结束时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
	                                    	<input readonly="readonly" type="text" size="18" class="form-control" id="cl_timestampEnd" name="cl_timestampEnd" value="${ cl_timestampEnd}" style="width: 133.5%"/>
	                                    </div>
	                                </div>
								</div>
							</div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
				                      <label for="rechargeFlag" class="col-sm-3 control-label">操作员</label>
				                      <div class="col-sm-9">
				                      	<input type="hidden" id="ctUserCreatetext" value="${cl_auth_user_id }"/>
				                        <select class="form-control" id="cl_auth_user_id" name="cl_auth_user_id">
									    	<option value="">===请选择===</option>
									    	<c:forEach var="item" items="${aclUsers}">
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
			                    <button type="submit" class="btn btn-info "><i class="fa fa-search"></i> 下载</button>
		                    </div>
		                  </div><!-- /.box-footer -->
		                </form>
			        </div><!-- /.box -->
				
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-list"></i> 操作列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
				                                    <th>旧卡号</th>
				                                    <th>新卡号</th>
				                                    <th>姓名</th>
				                                    <th>身份证号</th>
				                                    <th>补卡日期</th>
				                                    <th>补卡时间</th>
				                                    <th>补卡费</th>
											        <!-- <th class="text-right">操作</th> -->
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}" varStatus="status">
												<tr>
													<td>${item.cl_old_card}</td>
				                                    <td>${item.cl_new_card}</td>	
				                                    <td>${item.CB_EMBOSSNAME}</td>			                                   
				                                    <td>${item.CB_IDNO}</td>
				                                    <td>${item.cl_timestamp}</td>
				                                    <td>${item.cl_timestamp}</td>
				                                    <td>${item.CT_FEE_AMOUNT }</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/opeartion/suppl" page="${pageInfo}" queryString="cl_old_card=${cl_old_card }&cl_new_card=${cl_new_card }&cl_timestampStart=${cl_timestampStart }&cl_timestampEnd=${cl_timestampEnd }&cl_auth_user_id=${cl_auth_user_id }" cssClass="pull-right"/>
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
	    <script type="text/javascript">
		    /* $('#ctApproveTimeStart').datepicker({
				format: 'yyyymmdd',
				autoclose: true
			});
		    $('#ctApproveTimeEnd').datepicker({
				format: 'yyyymmdd',
				autoclose: true
			}); */
			$(document).ready(function(){
				$('.firstCommission').datepicker({
		   			format: 'yyyymmdd',
					autoclose: true
		   		});
				$("#theIdForSubmit").click(function(){
					var mmAgreementStartDate = $("#ctApproveTimeStart").val();
					var mmAgreementEndDate = $("#ctApproveTimeEnd").val();
					if(mmAgreementStartDate != "" && mmAgreementEndDate != ""){
						if(Number(mmAgreementStartDate)>Number(mmAgreementEndDate)){
							alert("交易起始时间不可以大于交易结束时间！");
							return false;
						}
					}
					
				});
			});	
			$(function () {
		    	if($("#ctUserCreatetext").val()==""){
		    		$("#cl_auth_user_id").val($("#cl_auth_user_id option:first").val());
		    	}else{
		    		$("#cl_auth_user_id").val($("#ctUserCreatetext").val());
		    	}
		    });
	    </script>
	</body>
</html>
