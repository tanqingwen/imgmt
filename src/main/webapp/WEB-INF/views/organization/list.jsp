<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 机构管理</title>
		<tags:head_common_content/>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="organization"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>机构管理</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">机构管理</a></li>
						<li class="active">机构列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                  <div class="box-tools">
			                  <c:if test="${app:checkPermission('ORGANIZATION_ADD')}">
							  	<a class="btn pull-right" href="${ctx}/organization/add"><i class="fa fa-plus"></i> 添加</a>
							 </c:if>		                  	
		                  </div>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" action="${ctx}/organization/list">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="organizationId" class="col-sm-3 control-label">机构ID</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="id" name="id" placeholder="机构ID" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="roleName" class="col-sm-3 control-label">机构名称</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="name" name="name" placeholder="机构名称" type="text">
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
									<h3 class="box-title"><i class="fa fa-list"></i> 机构列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
											        <th>机构ID</th>
				                                    <th>机构名称</th>
				                                    <th>机构描述</th>
				                                    <th>创建时间</th>
				                                    <th>创建人</th>
											        <th class="text-right">操作</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.id}</td>
				                                    <td>${item.name}</td>	
				                                    <td>${item.remark}</td>			                                   
				                                    <td><tags:format_string patten="####/##/## ##:##:##" value="${item.createdAt}"/></td>
				                                    <td>${item.createdBy}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
															<c:if test="${app:checkPermission('ORGANIZATION_UPDATE')}">
																<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/organization/update?id=${item.id}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
															</c:if>	
															<c:if test="${app:checkPermission('ORGANIZATION_SHOW')}">	
																<a type="button" class="btn btn-default btn-xs" title="查看" href="${ctx}/organization/show?id=${item.id}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
															</c:if>	
															<c:if test="${app:checkPermission('ORGANIZATION_DELETE')}">	
																<a type="button" class="btn btn-default btn-xs" title="删除" href="${ctx}/organization/delete?id=${item.id}" onclick="return confirm('确认删除?')"><i class="glyphicon glyphicon-trash" aria-hidden="true"></i></a>
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
									<tags:pagination url="${ctx}/role/list" page="${pageInfo}" cssClass="pull-right"/>
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
