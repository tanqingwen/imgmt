<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 订单管理</title>
		<tags:head_common_content/>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="staff"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>订单管理</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">订单管理</a></li>
						<li class="active">订单列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" action="${ctx}/yworder/list"  method="GET">
		                  <div class="box-body">
		                  	<div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="staffId" class="col-sm-3 control-label">手机号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwMobilePhone"  name="hwMobilePhone" placeholder="手机号" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="staffId" class="col-sm-3 control-label">订单编号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwOrderId"  name="hwOrderId"  type="text">
			                      </div>
			                    </div>
		                    </div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                    <button type="submit" class="btn btn-info pull-right"><i class="fa fa-search"></i> 查询</button>
		                  </div><!-- /.box-footer -->
		                </form>
			        </div><!-- /.box -->
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-list"></i> 票种列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                 <table class="table table-striped">
											<thead>
											    <tr>
				                                    <th>订单编号</th>
				                                    <th>购票渠道</th>
				                                    <th>手机号</th>
				                                    <th>订单金额</th>
				                                    <th>状态</th>
				                                    <th>购票日期</th>
											        <th class="text-right">操作</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.hwOrderId}</td>
													<td>${item.hwChannel =='1'?'微信公众号':'APP'}</td>
				                                    <td>${item.hwMobilePhone}</td>
				                                    <td>${item.hwMoney}</td>
				                                    <td>${item.hwOrderState =='W'?'未取票':''}</td>
				                                    <td><tags:format_string patten="####/##/## ##:##:##" value="${item.hwOrderAddtime}"/></td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a type="button" class="btn btn-default btn-xs" title="删除"  href="${ctx}/yworder/delete?hwOrderId=${item.hwOrderId}" onclick="return confirm('确认删除?')" ><i class="glyphicon glyphicon-trash" aria-hidden="true"  ></i></a>
																</c:if>
																<%-- 订单明细查看弹框 --%>
																<%-- <c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<button class="btn btn-default btn-xs" title="查看" data-toggle="modal" data-target="#myModal"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></button>
																</c:if> 
																<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
																	<div class="modal-dialog">
																		<div class="modal-content">
																			<div class="modal-header">
																				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																					<h4 class="modal-title" id="myModalLabel">订单详情列表</h4>
																			</div>
																				<div class="modal-body">
																					<div class="box-body">
																						<div class="form-group">
																							<label for="cbCustomerIdno" class="col-sm-3 control-label">单票编号<font color="red">*</font></label>
																								<div class="col-sm-8">
																								  <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="不能为空" value="${item.hwOrderId}"/>
																								 </div>
																						</div>
																				</div>
																				<div class="modal-body">
																					<div class="box-body">
																						<div class="form-group">
																							<label for="cbCustomerIdno" class="col-sm-3 control-label">订单编号<font color="red">*</font></label>
																								<div class="col-sm-8">
																								  <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="不能为空" value="${item.hwOrderId}"/>
																								 </div>
																						</div>
																						<div class="form-group">
																							<label for="cbCustomerIdno" class="col-sm-3 control-label">票种类型<font color="red">*</font></label>
																								<div class="col-sm-8">
																								  <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="不能为空" value="${item.hwOrderId}"/>
																								 </div>
																						</div>
																						<div class="form-group">
																							<label for="cbCustomerIdno" class="col-sm-3 control-label">入园时间<font color="red">*</font></label>
																								<div class="col-sm-8">
																								  <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="不能为空" value="${item.hwOrderId}"/>
																								 </div>
																						</div>
																						<div class="form-group">
																							<label for="cbCustomerIdno" class="col-sm-3 control-label">票券单价<font color="red">*</font></label>
																								<div class="col-sm-8">
																								  <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="不能为空" value="${item.hwOrderId}"/>
																								 </div>
																						</div>
																						<div class="form-group">
																							<label for="cbCustomerIdno" class="col-sm-3 control-label">订单状态<font color="red">*</font></label>
																								<div class="col-sm-8">
																								  <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="不能为空" value="${item.hwOrderId}"/>
																								 </div>
																						</div>
																					</div>
																
																				</div>
																			<div class="modal-footer">
																			<button type="button" class="btn btn-primary">确定</button>
																			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
																			</div>
																		</div>
																	</div> 
																</div>
															</div>
														</div>--%>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>									
									</div>
				                </div><!-- /.box-body -->
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/yworder/list" page="${pageInfo}" cssClass="pull-right"/>
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
	</body>
</html>
