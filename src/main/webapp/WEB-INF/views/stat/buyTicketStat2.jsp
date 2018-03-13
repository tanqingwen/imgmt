<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统  | 购票信息查询</title>
		<tags:head_common_content/>		
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="buyTicketStat"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>购票信息查询</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywcx">业务查询</a></li>
						<li class="active">购票信息查询</li>
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
			                	<div class="form-group date firstCommission">
									<label for="tkEffectiveDateStart" class="col-sm-3 control-label">生效日期 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" id="tkEffectiveDateStart" name="tkEffectiveDateStart" value="${tkEffectiveDateStart }" onchange="buttonds()" style="width: 133.5%"/>
	                                	</div>
	                                </div>
								</div>
							</div>
							<div class="col-sm-6">								
								<div class="form-group date firstCommission">
									<label for="tkEffectiveDateEnd" class="col-sm-3 control-label">失效日期 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
	                                    	<input readonly class="form-control" id="tkEffectiveDateEnd" name="tkEffectiveDateEnd" value="${tkEffectiveDateEnd }" onchange="buttonds()" style="width: 133.5%"/>
	                                    </div>
	                                </div>
								</div>
							</div>
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="tkCardNo" class="col-sm-3 control-label">卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="tkCardNo" name="tkCardNo" placeholder="卡号" value="${tkCardNo }" oninput="buttonds()" type="text">
			                      </div>
			                    </div>
		                    </div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                  	<div class="pull-right">
			                    <button type="submit" class="btn btn-info " id="theIdForSubmit"><i class="fa fa-search"></i> 查询</button>
			                    <a type="button" class="btn btn-info" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
<!-- 			                    <button type="submit" class="btn btn-info " id="downLoad"><i class="fa fa-search"></i> 下载</button> -->
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
											        <th>票号</th>
				                                    <th>卡号</th>
				                                    <th>票劵类别</th>
				                                    <th>生效日期</th>
				                                    <th>失效日期</th>
				                                    <th>最近入园日期</th>
				                                    <th>最近离园日期</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>											
													<td>${item.tkTicketId}</td>
													<td>${item.tkCardNo}</td>
													<td>${item.ticketName}</td>
				                                    <td>${item.tkEffectiveDate}</td>
				                                    <td>${item.tkExpireDate}</td>
				                                    <td>${item.tkActiveDate}</td>
				                                    <td>${item.tkRetriveDate}</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/cpceptrx/buyTicketStat" queryString="tkCardNo=${tkCardNo }&tkEffectiveDateStart=${tkEffectiveDateStart }&tkEffectiveDateEnd=${tkEffectiveDateEnd }" page="${pageInfo}" cssClass="pull-right"/>
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
					var tkEffectiveDateStart = $("#tkEffectiveDateStart").val();
					var tkEffectiveDateEnd = $("#tkEffectiveDateEnd").val();
					if(tkEffectiveDateStart != "" && tkEffectiveDateEnd != ""){
						if(Number(tkEffectiveDateStart)>Number(tkEffectiveDateEnd)){
							alert("失效日期不可以大于生效日期！");
							return false;
						}
					}
					$("#thisform").attr("action", "${ctx}/cpceptrx/buyTicketStat");
					$("#downLoad").attr("disabled",false);
				});
				
				$("#downLoad").click(function(){
					$("#thisform").attr("action", "${ctx}/cpceptrx/buyTicketDownLoad");
// 					$.ajax({
// 						type : "POST",
// 						url : "${ctx}/cpceptrx/buyTicketDownLoad",
// 						dataType : "json",
// 						data : {
// 							tkCardNo : $("#tkCardNo").val(),
// 							tkEffectiveDateStart : $("#tkEffectiveDateStart").val(),  
// 							tkEffectiveDateEnd : $("#tkEffectiveDateEnd").val()
// 						},
// 						success : function(data) {
// 							if (failureProcess("${ctx}", data)) {
// 								return;
// 							}
// 							alert("下载成功！");
// 						}
// 					 });
				});
			});			
	    </script>
	</body>
</html>
