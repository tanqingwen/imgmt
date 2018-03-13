<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统  | 场馆查询</title>
		<tags:head_common_content/>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="merchant"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>场馆查询</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywcx">业务查询</a></li>
						<li class="active">场馆查询</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" action="${ctx}/merchant/list" method = "post">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="merchantID" class="col-sm-3 control-label">场馆号码</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="mmMerchantNo" name="mmMerchantNo" value="${mmMerchantNo }" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="merchantTName" class="col-sm-3 control-label">场馆名称</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="mmBizName" name="mmBizName" value="${mmBizName }" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="merchantFName" class="col-sm-3 control-label">场馆别名</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="mmDbaName" name="mmDbaName" value="${mmDbaName }" type="text">
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
											        <th>场馆号码</th>
				                                    <th>场馆名称</th>
				                                    <th>场馆别名</th>
				                                    <th>区域代码</th>
											        <th class="text-right">操作</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.mmMerchantNo}</td>				                                  
				                                    <td>${item.mmBizName}</td>
				                                    <td>${item.mmDbaName}</td>
				                                    <td>${item.mmGuiCode}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">	
															    <c:if test="${app:checkPermission('MERCHANT_TERMINALLIST') }">
																	<a type="button" class="btn btn-default btn-xs" title="场馆终端查询" href="${ctx}/merchant/merchant_terminallist?id=${item.mmMerchantNo}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
																</c:if>
																<%-- <c:if test="${app:checkPermission('MERCHANT_HISDEALDATA') }">
																	<a type="button" class="btn btn-default btn-xs" title="历史交易记录" href="${ctx}/merchant/merchant_hisdealdata?id=${item.mmMerchantNo}"><i class="fa fa-fw fa-star" aria-hidden="true"></i></a>
																</c:if> --%>												
																<c:if test="${app:checkPermission('MERCHANT_INQUIRELIST') }">
																	<a type="button" class="btn btn-default btn-xs" title="场馆信息详情" href="${ctx}/merchant/merchant_inquirelist?id=${item.mmMerchantNo}"><i class="fa fa-fw fa-user" aria-hidden="true"></i></a>
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
									<tags:pagination url="${ctx}/merchant/list" page="${pageInfo}" cssClass="pull-right"/>
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
