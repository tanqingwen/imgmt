<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 卡片交易详情</title>
		<tags:head_common_content/>		
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="listCardSaleInfo"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>卡片交易详情</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywcx">业务查询</a></li>
						<li class="active">卡片交易详情</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>		                  
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" id="thisform" action="${ctx}/vipcardStat/listCardSaleInfo" method="post">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="ctCardNumber" class="col-sm-3 control-label">卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="ctCardNumber" name="ctCardNumber" placeholder="卡号" value="${ctCardNumber }" type="text">
			                      </div>
			                    </div>
		                    </div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                  	<div class="pull-right">
			                    <button type="submit" class="btn btn-info " id="theIdForSubmit"><i class="fa fa-search"></i> 查询</button>
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
				                                    <th>姓名</th>
				                                    <th>卡号</th>
				                                    <th>身份证号</th>
				                                    <th>交易时间</th>
				                                    <th>交易码</th>
				                                    <th>交易描述</th>
				                                    <th>交易金额</th>
				                                    <th>交易金额</th>
				                                    <th>交易前金额</th>
				                                    <th>交易后金额</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>											
													<td>${item.cbEmbossname}</td>
				                                    <td>${item.ctCardNumber}</td>
				                                    <td>${item.cbIdno}</td>
				                                    <td>${item.ctPostTime}</td>
				                                    <td>${item.ctTranCode}</td>
				                                    <td>${item.sysTrxnDesc}</td>
				                                    <td>${item.ctTranAmount}</td>
				                                    <td>${item.ctCardAmount}</td>
				                                    <td>${item.ctOutstdB4Post}</td>
				                                    <td>${item.ctOutstdAfterPost}</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/vipcardStat/listCardSaleInfo" queryString="ctCardNumber=${ctCardNumber }" page="${pageInfo}" cssClass="pull-right"/>
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
	</body>
</html>
