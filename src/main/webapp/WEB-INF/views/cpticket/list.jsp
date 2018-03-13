<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 |订单转票</title>
		<tags:head_common_content/>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="cpticketlist"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>订单转票</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
						<li class="active">订单转票</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" action="${ctx}/cpticket/list"  method="POST">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="tkCardNo" class="col-sm-3 control-label">卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="tkCardNo"  name="tkCardNo" placeholder="卡号" value="${tkCardNo }" type="text">
			                      </div>
			                    </div>
			                </div>
			                <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="tkCardNo1" class="col-sm-3 control-label">待转入卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="tkCardNo1"  name="tkCardNo1" placeholder="待转入卡号，不计入查询" type="text">
			                      </div>
			                    </div>
		                    </div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                  	<div class="pull-right" style="width:60%">
		                    <button type="submit" class="btn btn-info pull-left "><i class="fa fa-search"></i> 读取卡号</button>
		                    <button type="submit" class="btn btn-info pull-left "><i class="fa fa-search"></i> 查询</button>
			                <a type="button" class="btn btn-info pull-right" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
		                    <button type="submit" class="btn btn-info pull-right "><i class="fa fa-search"></i> 读取待转入卡号</button>
		                    </div>
		                    <!-- 
		                    <button type="submit" class="btn btn-info  center-block"><i class="fa fa-search"></i> 查询</button>
		                    -->
		                  </div><!-- /.box-footer -->
		                </form>
			        </div><!-- /.box -->
				
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-search"></i> 查询列表</h3>
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
											        <th class="text-right">选择</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
				                                    <td>${item.tkTicketId}</td>
				                                    <td>${item.tkCardNo}</td>
				                                    <td>${item.tkTicketType}</td>
				                                    <td>${item.tkEffectiveDate}</td>
				                                    <td>${item.tkExpireDate}</td>
				                                    <td>${item.tkActiveDate}</td>
				                                    <td>${item.tkRetriveDate}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<input type="checkbox" value="${item.tkTicketId}" name="rsManagement">
<%-- 																<c:if test="${app:checkPermission('STAFF_UPDATE') }"> --%>
<%-- 																	<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/cpticket/update?tkCardNo=${item.tkCardNo}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a> --%>
<%-- 																</c:if> --%>
<%-- 																<c:if test="${app:checkPermission('STAFF_SHOW') }"> --%>
<%-- 																	<a type="button" class="btn btn-default btn-xs" title="删除"  href="${ctx}/cpticket/delete?tkCardNo=${item.tkCardNo}" onclick="return confirm('确认删除?')" ><i class="glyphicon glyphicon-trash" aria-hidden="true"  ></i></a> --%>
<%-- 																</c:if> --%>
<%-- 																<c:if test="${app:checkPermission('STAFF_SHOW') }"> --%>
<%-- 																	<a type="button" class="btn btn-default btn-xs" title="查看" href="${ctx}/cpticket/show?tkCardNo=${item.tkCardNo}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a> --%>
<%-- 																</c:if> --%>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								<div class="box-footer clearfix">
								    <tags:pagination url="${ctx}/cpticket/list" page="${pageInfo}" cssClass="pull-left"/>
									<div class="pull-right" style="width: 60%">
										<a type="button" class="btn btn-info pull-left" id="selectAll" title="全选">全选</a>
										<a type="button" class="btn btn-info pull-left" id="selectNone" title="重置">重置</a>
										<a type="button" class="btn btn-info pull-left" id="selectInvert" title="反向选择">反向选择</a>
										<c:if test="${app:checkPermission('STAFF_SHOW') }">
											<a type="button" class="btn btn-info pull-right" title="转出" id="doChange">转出</a>
										</c:if>
									</div>
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
		<script type="text/javascript">
		$(function () {
			$("#selectAll").click(function(){
				var ids = document.getElementsByName("rsManagement");                           
			    for(var i=0;i<ids.length;i++){
			        ids[i].checked=true;
			    }
			});
			$("#selectNone").click(function(){
			    var ids = document.getElementsByName("rsManagement");                           
			    for(var i=0;i<ids.length;i++){
			        ids[i].checked=false;
			    }
			});

			$("#selectInvert").click(function(){
			    var ids = document.getElementsByName("rsManagement");                           
			    for(var i=0;i<ids.length;i++){
			        if(ids[i].checked)
			            ids[i].checked=false ;
			        else
			            ids[i].checked=true ;
			    }
			});
			$("#doChange").click(function(){
				var rsManagementStr='';
				var ck = document.getElementsByName("rsManagement");               
		        var flag = false ;   
		        for(var i=0;i<ck.length;i++){
		            if(ck[i].checked){
		                flag = true ;
		                rsManagementStr += ck[i].value+',';
		            }
		        }
		        
		        if(!flag){
		            alert("请选择一个记录,再进行下一步的操作!");
		            return false ;
		        }
		        var tkCardNo1 = $("#tkCardNo1").val();
		        tkCardNo1 = $.trim(tkCardNo1);
		        if(tkCardNo1==""){
		        	alert("请输入待转入卡号");
		        	return false;
		        }
		        if(!confirm("确认提交？")){
					return false;
				}
		        $.ajax({
		    		type:"POST",
		    		url:"${ctx}/cpticket/doChange",
		    		dataType:"json",
		    		data:{
		    			tkCardNo1 : tkCardNo1,
	    				rsManagement : rsManagementStr
		    		},
		    		success:function(data){
		    			if (failureProcess("${ctx}", data)) {
		    				location.href = "${ctx}/cpticket/list";
							return;
						}
		    		}
		    	});
			});
		});
		</script>
	</body>
</html>
