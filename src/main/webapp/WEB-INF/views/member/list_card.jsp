<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 会员管理</title>
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
					<h1>会员管理</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">会员管理</a></li>
						<li class="active">卡列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <!-- form start -->
		                <form class="form-horizontal">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbCustomerIdno" class="col-sm-3 control-label">身份证号</label>
			                      <div class="col-sm-9">
			                        <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" value="${pageInfo.cbIdno}"/>
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbCardholderName" class="col-sm-3 control-label">持卡人姓名</label>
			                            <div class="col-sm-8">
											<input type="text" class="form-control" value="${pageInfo.cbEmbossname}" />
										</div>
			                    </div>
		                    </div>
		                  </div><!-- /.box-body -->
		                </form>
			        </div><!-- /.box -->
				
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-list"></i> 卡列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <%-- <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
											        <th>序号</th>
				                                    <th>卡号</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}" varStatus="status">
													<tr>
													    <td>第${status.index+1}张卡</td>
													    <td>${item.cbCardholderNo}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body --> --%>
					
								<%-- <div class="box-footer clearfix">
									<tags:pagination url="${ctx}/member/list_card" page="${pageInfo}" cssClass="pull-right"/>
								</div> --%>
								<div class="box-footer">
							       <a type="submit" class="btn btn-default pull-right" href="${ctx }/cpcsttbl/cpcsttblQueryStat"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
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
