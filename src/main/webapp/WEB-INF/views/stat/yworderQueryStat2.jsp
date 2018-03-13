<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 订单查询</title>
		<tags:head_common_content/>		
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="recharge"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>订单查询</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">业务统计</a></li>
						<li class="active">订单查询</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>		                  
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" id="thisform" action="${ctx}/yworder/yworderQueryStat" method="post">
		                  <div class="box-body">
	                  		<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="hwOrderId" class="col-sm-3 control-label">订单号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwOrderId" name="hwOrderId" placeholder="订单号" value="${hwOrderId }" type="text">
			                      </div>
			                    </div>
		                    </div>
		                    <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="hwMobilePhone" class="col-sm-3 control-label">手机号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwMobilePhone" name="hwMobilePhone" placeholder="手机号" value="${hwMobilePhone }" type="text">
			                      </div>
			                    </div>
		                    </div>
			                <div class="col-sm-6">
			                	<div class="form-group date firstCommission">
									<label for="hwOrderAddtimeStart" class="col-sm-3 control-label">起始添加时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" id="hwOrderAddtimeStart" name="hwOrderAddtimeStart" value="${hwOrderAddtimeStart }" style="width: 133.5%"/>
	                                	</div>
	                                </div>
								</div>
							</div>
							<div class="col-sm-6">								
								<div class="form-group date firstCommission">
									<label for="hwOrderAddtimeEnd" class="col-sm-3 control-label">结束添加时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
	                                    	<input readonly class="form-control" id="hwOrderAddtimeEnd" name="hwOrderAddtimeEnd" value="${hwOrderAddtimeEnd }" style="width: 133.5%"/>
	                                    </div>
	                                </div>
								</div>
							</div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                  	<div class="pull-right">
			                    <button type="submit" class="btn btn-info " id="theIdForSubmit"><i class="fa fa-search"></i> 查询</button>
			                    <a type="button" class="btn btn-info" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
			                    <button type="submit" class="btn btn-info "><i class="fa fa-search"></i> 下载</button>
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
											        <th>订单号</th>
				                                    <th>会员号</th>
				                                    <th>手机号</th>
				                                    <th>订单来源</th>
				                                    <th>订单类型</th>
				                                    <th>支付方式</th>
				                                    <th>第三方支付流水</th>
				                                    <th>金额</th>
				                                    <th>支付时间</th>
				                                    <th>支付状态</th>
				                                    <th>详情</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<tr>											
													<td>${item.hwOrderId}</td>
													<td>${item.hwMemberId}</td>
				                                    <td>${item.hwMobilePhone}</td>
				                                    <td>
				                                    	<c:if test="${item.hwChannel eq 1}">${item.hwChannel}-微信公众号</c:if>
				                                    	<c:if test="${item.hwChannel eq 2}">${item.hwChannel}-APP</c:if>
				                                    	<c:if test="${item.hwChannel eq 3}">${item.hwChannel}-现场</c:if>
				                                    	<c:if test="${item.hwChannel eq 4}">${item.hwChannel}-官网</c:if>
				                                    	<c:if test="${item.hwChannel eq 5}">${item.hwChannel}-驴妈妈</c:if>
				                                    	<c:if test="${item.hwChannel eq 10}">${item.hwChannel}-自助终端</c:if>
				                                    </td>
				                                    <td>
				                                    	<c:if test="${item.hwType==1 }">购票</c:if>
				                                    	<c:if test="${item.hwType==2 }">充值</c:if>
				                                    	<c:if test="${item.hwType==3 }">消费</c:if>
				                                    	<c:if test="${item.hwType==4 }">退票</c:if>
				                                    	<c:if test="${item.hwType==5 }">提现</c:if>
				                                    </td>
				                                    <td>
				                                    	<c:if test="${item.hwPayType eq 'JSAPI' }">公众号微信支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'CASH' or item.hwPayType eq 'cash' }">现金支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'APP' }">APP微信支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'YLTLH5' }">H5银行卡快捷支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'XC_WX' }">现场微信扫码支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'XC_ZFB' }">现场支付宝扫码支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'TLWG' }">官网网银支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'TLKJ' }">官网银行卡支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'WEB_WX_TL' }">官网微信扫码支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'WEB_ZFB_TL' }">官网支付宝扫码支付</c:if>
				                                    </td>
				                                    <td>${item.hwPaymentListid}</td>
				                                    <td>${item.hwMoney}</td>
				                                    <td>${item.hwOrderPaytime}</td>
				                                    <td>
				                                    	<c:if test="${item.hwPaymentStatus eq 'Y' }">已支付</c:if>
				                                    	<c:if test="${item.hwPaymentStatus eq 'N' }">未支付</c:if>
				                                    </td>
				                                    <td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<%-- <c:if test="${app:checkPermission('VENUE_SHOW') }"> --%>
																	<a type="button" class="btn btn-default btn-xs" title="查看" href="${ctx}/yworder/yworderDetail?hwOrderId=${item.hwOrderId}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
																<%-- </c:if> --%>
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
									<tags:pagination url="${ctx}/yworder/yworderQueryStat" queryString="hwOrderId=${hwOrderId }&hwMobilePhone=${hwMobilePhone }&hwOrderAddtimeStart=${hwOrderAddtimeStart }&hwOrderAddtimeEnd=${hwOrderAddtimeEnd }" page="${pageInfo}" cssClass="pull-right"/>
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
		    $(document).ready(function(){
				$('.firstCommission').datepicker({
		   			format: 'yyyymmdd',
					autoclose: true,
					todayBtn : "linked",  
			        autoclose : true,  
			        todayHighlight : true,  
			    });
				
				$("#theIdForSubmit").click(function(){
					var Start = $("#hwOrderAddtimeStart").val();
					var End = $("#hwOrderAddtimeEnd").val();
					if(Start != "" && End != ""){
						if(Number(Start)>Number(End)){
							alert("开始添加时间不可以大于结束添加时间！");
							return false;
						}
					}
					
				});
			});			
	    </script>
	</body>
</html>
