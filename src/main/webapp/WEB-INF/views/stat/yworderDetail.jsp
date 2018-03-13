<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 订单详情</title>
    <tags:head_common_content/>
    <%-- <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/> --%>
    <link rel="stylesheet" type="text/css" href="${assets}/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${assets}/css/layer.css" />
	<link rel="stylesheet" href="${assets}/css/order.css" />
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="profile"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>订单详情</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywcx">业务管理</a></li>
            <li><a href="${ctx }/yworder/yworderQueryStat">订单查询</a></li>            
            <li class="active">订单详情</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
			<div class="container-fluid RInfoManage DocumentType ">
				<div class="row clearfix">
					<div class="tip-img col-md-2">
						<p>订单查询</p>
					</div>
					<div class="content col-md-10">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询列表</h3>
							<h4 class="" style="">购票详情</h4>						
							<div class="col-lg-12 col-md-12 clearfix tableContent" style="padding: 0;">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr class="trBorder">
												<th>票号</th>
												<th>姓名</th>
												<th>身份证号</th>
												<th>会员卡号</th>
												<th>对象</th>
												<th>票种</th>
												<th>售价</th>
												<th>票券状态</th>
												<th>允许入园时间</th>
											</tr>
										</thead>
										<c:forEach var="item" items="${ywOrderitem.list}">
										<tbody>
											<tr>
												<td>${item.hwOrderitemId}</td>
												<td>${item.hwCredentyname}</td>
												<td>${item.hwMemberId}</td>
												<td>${item.hwCardserialno}</td>
												<td>${item.hwSpecialMethod}</td>
												<td>${item.hwTicketName }</td>
												<td>${item.hwUnitPrice}</td>
												<td>
			                                    	<c:if test="${item.hwStatus eq 'W'}">${item.hwStatus}-未入园</c:if>
			                                    	<c:if test="${item.hwStatus eq 'T'}">${item.hwStatus}-未入闸</c:if>
			                                    	<c:if test="${item.hwStatus eq 'U'}">${item.hwStatus}-已入闸</c:if>
			                                    	<c:if test="${item.hwStatus eq 'R'}">${item.hwStatus}-已退票</c:if>
			                                    	<c:if test="${item.hwStatus eq 'E'}">${item.hwStatus}-已过期</c:if>
		                                    	</td>
												<td>${item.hwAdmissionTime}</td>											
											</tr>
										</tbody>
										</c:forEach>
									</table>									
								</div>
							</div>
							<h4>充值详情</h4>	
							<div class="col-lg-12 col-md-12 clearfix tableContent" style="padding: 0;">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr class="trBorder">
												<th>会员卡号</th>
												<th>充值金额</th>
												<th>充值前金额</th>
												<th>充值后金额</th>
											</tr>
										</thead>
										<c:forEach var="order" items="${orders}">
											<tr>
												<td>${order.card}</td>
												<td>${order.amount}</td>
												<td>${order.oramount}</td>
												<td>${order.CbOutstdBal}</td>										
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
							<script src="js/layer.js"></script>
							<div class="box-footer">
								<div class="pull-left">
		                    		<a type="button"  style="font-size:18px;color:#333;" href="${ctx }/yworder/yworderQueryStat">&lt; 返回</a>
		               			</div>
		                	</div><!-- /.box-footer -->
						</div>
					</div>
				</div>
			</div>
							<%-- <h3 class="box-title"><i class="fa fa-list"></i> 查询列表</h3>
							<div class="box-tools pull-right">
						        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
						    </div>
						</div><!-- /.box-header -->
		                <div class="box-body">
			                <div class="table-responsive">
				                <table class="table table-striped">
									<thead>
									    <tr>
									        <th>订单项号</th>
		                                    <th>订单号</th>
		                                    <th>票券名称</th>
		                                   <!--  <th>商品组</th> -->
		                                    <th>准许进入时间</th>
		                                    <th>单价</th>
		                                    <th>票数</th>
		                                    <th>数量</th>
		                                    <th>特别方法</th>
		                                    <th>状态</th>
									    </tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${ywOrderitem.list}">
										<tr>											
											<td>${item.hwOrderitemId}</td>
											<td>${item.hwOrderId}</td>
											<td>${item.hwTicketName }</td>
		                                    <td>${item.hwProdctGroup}</td>
		                                    <td>${item.hwAdmissionTime}</td>
		                                    <td>${item.hwUnitPrice}</td>
		                                    <td>${item.hwTicketCount}</td>
		                                    <td>${item.hwAmount}</td>
		                                    <td>${item.hwSpecialMethod}</td>
		                                    <td>
		                                    	<c:if test="${item.hwStatus eq 'W'}">${item.hwStatus}-未支付</c:if>
		                                    	<c:if test="${item.hwStatus eq 'T'}">${item.hwStatus}-未入闸</c:if>
		                                    	<c:if test="${item.hwStatus eq 'U'}">${item.hwStatus}-已入闸</c:if>
		                                    	<c:if test="${item.hwStatus eq 'R'}">${item.hwStatus}-已退票</c:if>
		                                    	<c:if test="${item.hwStatus eq 'E'}">${item.hwStatus}-已过期</c:if>
		                                    </td>
										</tr>
									</c:forEach>
									  <tr>
									        <th>订单号</th>
		                                    <th>身份证号</th>
		                                    <th>姓名</th>
		                                    <th>充值会员卡号</th>
		                                    <th>订单类型</th>
		                                    <th>充值金额</th>
		                                    <th>支付时间</th>
		                                    <th>支付方式</th>
		                                    <th>支付状态</th>
		                                  
									    </tr>
									<c:forEach var="order" items="${orders }">
										<tr>
											<td>${order.hwOrderId }</td>
											<td>${order.hwMemberId }</td>
											<td>${order.hwCustomerName }</td>
											<td>${order.hwCredential }</td>
											<td>
												<c:if test="${order.hwType eq '1' }">购票</c:if>
												<c:if test="${order.hwType eq '2' }">充值</c:if>
												<c:if test="${order.hwType eq '3' }">消费</c:if>
												<c:if test="${order.hwType eq '4' }">退票</c:if>
												<c:if test="${order.hwType eq '5' }">提现</c:if>
											</td>
											<td>${order.hwMoney }</td>
											<td>${order.hwOrderPaytime }</td>
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
											<td>
												<c:if test="${order.hwPaymentStatus eq 'Y' }">已支付</c:if>
												<c:if test="${order.hwPaymentStatus eq 'N' }">未支付</c:if>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
		                </div><!-- /.box-body -->
		                <div class="box-footer clearfix">
							<tags:pagination url="${ctx}/yworder/yworderDetail" page="${ywOrderitem}" cssClass="pull-right"/>
						</div>
		                <div class="box-footer">
							<div class="pull-right">
	                    		<a type="button" class="btn btn-default" href="${ctx }/yworder/yworderQueryStat"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	               			</div>
		                </div><!-- /.box-footer -->
					</div><!-- /.box -->
				</div><!-- /.col -->
			</div><!-- /.row --> --%>
			</section>
        </div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
  		
    <tags:load_common_js/>
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
  </body>
</html>
