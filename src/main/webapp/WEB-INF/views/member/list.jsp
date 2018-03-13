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
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/hygl">会员管理</a></li>
						<li class="active">会员管理</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
		                  <div class="box-tools">
		                  	<c:if test="${app:checkPermission('STAFF_ADD') }">
		                  		<a class="btn pull-right" href="${ctx}/member/add"><i class="fa fa-plus"></i> 添加</a>
		                  	</c:if>
		                  </div>
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal">
		                  <div class="box-body">
		                  <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbMemberCode" class="col-sm-3 control-label">会员ID</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cbMemberCode" name="cbMemberCode" placeholder="会员ID" type="text">
			                      </div>
			                    </div>
		                    </div>
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbCustomerIdno" class="col-sm-3 control-label">身份证号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" placeholder="身份证号" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbCardholderName" class="col-sm-3 control-label">持卡人姓名</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cbCardholderName" name="cbCardholderName" placeholder="持卡人姓名" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbMobileNo" class="col-sm-3 control-label">手机号码</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cbMobileNo" name="cbMobileNo" placeholder="手机号码" type="text">
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
									<h3 class="box-title"><i class="fa fa-list"></i> 会员单列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
											        <th>会员ID</th>
				                                    <th>身份证号</th>
				                                    <th>持卡人姓名</th>
				                                    <th>证件类型</th>
				                                    <th>手机号码</th>
				                                    <th>注册时间</th>
											        <th class="text-right">操作</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>
												    <td>${item.cbMemberCode}</td>
													<td>${item.cbCustomerIdno}</td>
				                                    <td>${item.cbCardholderName}</td>
				                                    <td>
				                                       <c:choose>
					                                   		<c:when test="${item.cbIdType == '1'}">身份证</c:when>
				                                    		<c:when test="${item.cbIdType == '2'}">军官证</c:when>
				                                    		<c:when test="${item.cbIdType == '3'}">护照</c:when>
				                                   		</c:choose>
				                                   	</td>
				                                    <td>${item.cbMobileNo}</td>
				                                    <td>${item.cbModTime}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
															    <c:if test="${app:checkPermission('STAFF_UPDATE') }">
																	<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/member/update?cbMemberCode=${item.cbMemberCode}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
																</c:if>
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a type="button" class="btn btn-default btn-xs" title="查看" href="${ctx}/member/show?cbMemberCode=${item.cbMemberCode}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
																</c:if> 
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a type="button" class="btn btn-default btn-xs" title="卡" href="${ctx}/cpcsttbl/cpcrdtblCbIdno?cbCustomerIdno=${item.cbCustomerIdno}"><i class="fa fa-fw fa-credit-card" aria-hidden="true"></i></a>
																</c:if>
																<!--<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<button type="button" class="btn btn-default btn-xs" title="查看卡" onclick="showMemberModal('${item.cbMemberCode}');"><i class="fa fa-fw fa-credit-card" aria-hidden="true"></i></button>
																</c:if>--> 
																<c:if test="${app:checkPermission('ORGANIZATION_DELETE')}">	
																    <a type="button" class="btn btn-default btn-xs" title="删除" href="#" onclick="return confirm('确认删除?')"><i class="glyphicon glyphicon-trash" aria-hidden="true"></i></a>
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
									<tags:pagination url="${ctx}/member/list" page="${pageInfo}" cssClass="pull-right"/>
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
		
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			        <h4 class="modal-title" id="myModalLabel">会员卡查看</h4>
			      </div>
			  <div class="form-horizontal">
			   <div class="col-sm-6">
			    <div class="row">
			      <div class="modal-body">
			        <div class="form-group">
						<label for="cbMemberCode" class="col-sm-4 control-label">身份证号:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="modalIdno" name="cbMemberCode" readonly="readonly" />
							</div>
					</div>
				 </div>
				</div>
			  </div>
			  <div class="col-sm-6">
			    <div class="row">
			      <div class="modal-body">
					<div class="form-group">
						<label for="cbMemberCode" class="col-sm-4 control-label">姓名:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="modalCardName" name="cbMemberCode" readonly="readonly" />
							</div>
					</div>
			      </div>
			    </div>
			  </div>
			  
			  
			  <%-- <div class="box-body">
			     <h4>全部卡</h4>
			     <input type="text" class="form-control" id="modalCardholderNo" name="cbMemberCode" readonly="readonly" />
					 <div class="table-responsive">
						  <table class="table table-striped">
							<thead>
							  <tr>
				                  <th>卡号</th>
							  </tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${pageInfo.list}">
								  <tr>
				                     <td>${item.cbCardholderNo}</td>
				                     <input type="text" class="form-control" id="modalCardholderNo" name="cbMemberCode" readonly="readonly" />
								  </tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			 </div><!-- /.box-body --> --%>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			      </div>
			    </div>
			  </div>
			</div>
		 </div>
			
		<tags:load_common_js/>
		<script type="text/javascript">
		function (cbMemberCode) {
			if("" == cbMemberCode) {
				alert("会员号不能为空！！！");
				return false;
			}
			$.ajax({
				type: "GET",
				url:"${ctx}/associator/query_member_by_id",
				data: {
					memberId: cbMemberCode
				},
				dataType:'json',
				success:function(data){
					$("#modalMemberId").val(data.cbMemberCode);
					$("#modalCardName").val(data.cbCardholderName);
					$("#modalIdno").val(data.cbCustomerIdno);
					$("#modalIdType").val(data.cbIdType);
					$("#modalMobileNo").val(data.cbMobileNo);
					$("#modalCardholderNo").val(data.cbCardholderNo);
			        $("#myModal").modal('show');
				}
			});
		};
</script>
	</body>
</html>
