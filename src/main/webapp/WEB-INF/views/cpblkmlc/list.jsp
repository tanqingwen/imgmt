<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 黑名单票</title>
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
					<h1>黑名单票</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">售票管理</a></li>
						<li class="active">黑名单票列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                  <div class="box-tools">
		                  	<c:if test="${app:checkPermission('STAFF_ADD') }">
		                  		<a class="btn pull-right" href="${ctx}/cpblkmlc/add"><i class="fa fa-plus"></i> 添加</a>
		                  	</c:if>
		                  </div>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" action="${ctx}/cpblkmlc/list"  method="POST">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="bmCardNo" class="col-sm-3 control-label">卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="bmCardNo"  name="bmCardNo" value="${bmCardNo }" placeholder="卡号" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="bmCardName" class="col-sm-3 control-label">持卡人姓名</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="bmCardName"  name="bmCardName" value="${bmCardName }" placeholder="持卡人姓名" type="text">
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
				                                    <th>卡号</th>
				                                    <th>持卡人姓名</th>
				                                    <th>加入日期</th>
											        <th class="text-right">操作</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
				                                    <td>${item.bmCardNo}</td>
				                                    <td>${item.bmCardName}</td>
				                                    <td>${item.bmInTime}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
<%-- 																<c:if test="${app:checkPermission('STAFF_UPDATE') }"> --%>
<%-- 																	<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/cpblkmlc/update?ttTypeId=${item.ttTypeId}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a> --%>
<%-- 																</c:if> --%>
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a type="button" class="btn btn-default btn-xs" title="删除"  href="${ctx}/cpblkmlc/delete?bmCardNo=${item.bmCardNo}" onclick="return confirm('确认删除?')" ><i class="glyphicon glyphicon-trash" aria-hidden="true"  ></i></a>
																</c:if>
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a type="button" class="btn btn-default btn-xs" title="查看" href="${ctx}/cpblkmlc/show?bmCardNo=${item.bmCardNo}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
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
					
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/cpblkmlc/list" page="${pageInfo}" cssClass="pull-right"/>
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
