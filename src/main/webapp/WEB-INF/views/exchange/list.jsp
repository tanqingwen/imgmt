<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 积分管理</title>
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
					<h1>积分兑换</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">积分兑换</a></li>
						<li class="active">积分列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal">
		                  <div class="box-body">
		                  <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="hwIntegralId" class="col-sm-3 control-label">积分ID</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwIntegralId" name="hwIntegralId" placeholder="积分ID" type="text">
			                      </div>
			                    </div>
		                    </div>
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwMemberId" name="hwMemberId" placeholder="会员ID" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="hwPeriodDate" class="col-sm-3 control-label">有效期</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwPeriodDate" name="hwPeriodDate" placeholder="有效期" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="hwIntegralStatus" class="col-sm-3 control-label">状况</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwIntegralStatus" name="hwIntegralStatus" placeholder="状况" type="text">
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
									<h3 class="box-title"><i class="fa fa-list"></i> 积分列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
											        <th>积分ID</th>
				                                    <th>会员ID</th>
				                                    <th>积分类型</th>
				                                    <th>积分数</th>
				                                    <th>可用积分</th>
				                                    <th>已兑换积分</th>
				                                    <th>兑换日期</th>
				                                    <th>兑换记录ID</th>
				                                    <th>有效期</th>
				                                    <th>状态</th>
											        <th class="text-right">操作</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
												    <td>${item.hwIntegralId}</td>
													<td>${provinceies[item.hwMemberId]}</td>
				                                    <td>
				                                       <c:choose>
					                                   		<c:when test="${item.hwIntegralType == '01'}">购票</c:when>
				                                    		<c:when test="${item.hwIntegralType == '02'}">消费</c:when>
				                                    		<c:when test="${item.hwIntegralType == '03'}">充值</c:when>
				                                    		<c:when test="${item.hwIntegralType == '04'}">奖励</c:when>
				                                   		</c:choose>
				                                   	</td>
				                                    <td>${item.hwProductFraction}</td>
				                                    <td>${item.hwAvailableIntegral}</td>
				                                    <td>${item.hwExchangeIntegral}</td>
				                                    <td>${item.hwExchangeDate}</td>
				                                    <td>${item.hwExchangeRecord}</td>
				                                    <td>${item.hwPeriodDate}</td>
				                                    <td>
				                                       <c:choose>
					                                   		<c:when test="${item.hwIntegralStatus == '01'}">可用</c:when>
				                                    		<c:when test="${item.hwIntegralStatus == '02'}">部分兑换</c:when>
				                                    		<c:when test="${item.hwIntegralStatus == '03'}">已兑换</c:when>
				                                   		</c:choose>
				                                   	</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
															    <c:if test="${app:checkPermission('STAFF_UPDATE') }">
																	<a type="button" class="btn btn-default btn-xs" title="积分兑换" href="${ctx}/integral/update?hwIntegralId=${item.hwIntegralId}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
																</c:if>
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a type="button" class="btn btn-default btn-xs" title="查看" href="${ctx}/integral/show?hwIntegralId=${item.hwIntegralId}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
																</c:if> 
																<c:if test="${app:checkPermission('ORGANIZATION_DELETE')}">	
																    <a type="button" class="btn btn-default btn-xs" title="删除" href="${ctx}/integral/delete?hwIntegralId=${item.hwIntegralId}" onclick="return confirm('确认删除?')"><i class="glyphicon glyphicon-trash" aria-hidden="true"></i></a>
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
									<tags:pagination url="${ctx}/integral/list" page="${pageInfo}" cssClass="pull-right"/>
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
