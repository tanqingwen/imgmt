<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 订单查询</title>
		<tags:head_common_content/>		
		<link rel="stylesheet" href="${assets }/css/datepicker.min.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/model.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/businessManagement.css">
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
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywcx">业务查询 </a></li>
						<li class="active">订单查询</li>
					</ol>
				</section>

				<!-- Main content -->
				<div class="container-fluid gateReviewList orderCheck">
				<div class="row outer-wrap">
					<div class="tip-img reviewList">
				</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;margin-bottom:25px;">查询表单</h3>
							<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">
							             <div class="col-md-12">
											<div class="col-md-6">
												<div class="form-group">
													<label>订单号：</label>
													<input class="form-control formConl line-input" id="hwOrderId" name="hwOrderId" placeholder="订单号" value="${hwOrderId }" type="text" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>手机号：</label>
													<input class="form-control formConl line-input" id="hwMobilePhone" name="hwMobilePhone" placeholder="手机号" value="${hwMobilePhone }" type="text" />
											    </div>
											</div>
										</div>
										
										<div class="col-md-12 marginTop">
											<div class="col-md-6" style="padding-left:0;">
												<label class="labelWidth">起始添加时间：</label>
												<div class="input-group date ">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly id="hwOrderAddtimeStart" name="hwOrderAddtimeStart" class="form-control dateWidth" value="${hwOrderAddtimeStart }">
													
												</div>
											</div>
											<div class="col-lg-6 col-md-6">
												<label class="labelWidth ">结束添加时间：</label>
												<div class="input-group date ">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly id="hwOrderAddtimeEnd" name="hwOrderAddtimeEnd" class="form-control dateWidth" value="${hwOrderAddtimeEnd }" >
												</div>
											</div>
										</div>
								<!-- </div> -->
							
                       			 <div class="col-lg-12 col-md-12 marginTop">
										
										<div class=" submit-group fr">
											<button type="submit" class="btn-size" style="width: 110px; margin: 0 25px 0 15px;" id="theIdForSubmit">查询</button>
										</div>
								</div>
								<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">
									订单列表<span class="fr toggle"></span>
								</h3>
								<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
											<thead>
											    <tr>
											        <th>订单号</th>
				                                    <!-- <th>会员号</th> -->
				                                    <th>手机号</th>
				                                    <th>订单来源</th>
				                                    <th>订单类型</th>
				                                    <th>支付方式</th>
				                                    <!-- <th>第三方支付流水</th> -->
				                                    <th>金额</th>
				                                    <th>支付时间</th>
				                                    <th>支付状态</th>
				                                    <th>详情</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
												<%-- <!--  -->var a = ${pageInfo.list} --%>
												<tr>											
													<td>${item.hwOrderId}</td>
													<%-- <td>${item.hwMemberId}</td> --%>
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
				                                    	<c:if test="${item.hwPayType eq 'POS' }">POS机刷卡支付	</c:if>
				                                    	<c:if test="${item.hwPayType eq 'TLWG' }">官网网银支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'TLKJ' }">官网银行卡支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'WEB_WX_TL' }">官网微信扫码支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'WEB_ZFB_TL' }">官网支付宝扫码支付</c:if>
				                                    	<c:if test="${item.hwPayType eq 'ZD_POS' }">自助终端pos支付</c:if>
				                                    </td>
				                                    <%-- <td>${item.hwPaymentListid}</td> --%>
				                                    <td>${item.hwMoney}</td>
				                                    <%-- <td>${item.hwOrderPaytime}</td> --%>
				                                    <td>
				                                     <fmt:parseDate value="${item.hwOrderPaytime}" pattern="yyyyMMdd HHmmss" var="receiveDate"></fmt:parseDate>
          											 <fmt:formatDate value="${receiveDate}" pattern="yyMMdd HH:mm" ></fmt:formatDate>
				                                     
				                                     </td><%-- <fmt:formatDate value='${item.hwOrderPaytime}' pattern='yyyy-MM-dd HH:mm:ss' dateStyle="default"/>  --%>
				                                    <td>
				                                    	<c:if test="${item.hwPaymentStatus eq 'Y' }">已支付</c:if>
				                                    	<c:if test="${item.hwPaymentStatus eq 'N' }">未支付</c:if>
				                                    </td>
				                                    <td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																	<a href="${ctx}/yworder/yworderDetail?hwOrderId=${item.hwOrderId}">查看</a>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									<div class="box-footer clearfix">
										<a type="button" href="${ctx }/startTreeviewDetail/ywcx" class="form-a">&lt;返回</a>
										<tags:pagination url="${ctx}/yworder/yworderQueryStat" queryString="hwOrderId=${hwOrderId }&hwMobilePhone=${hwMobilePhone }&hwOrderAddtimeStart=${hwOrderAddtimeStart }&hwOrderAddtimeEnd=${hwOrderAddtimeEnd }" page="${pageInfo}" cssClass="pull-right"/>
								</div>
								</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>
		<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	    <script src="${assets}/validator/js/validator.js"></script>
	    <script type="text/javascript">
	    $(function() {
			 var dataPickerOp = {
				        format: 'yyyy-mm-dd',
				        weekStart: 1,
				        days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
				        daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
				        daysMin: ['日', '一', '二', '三', '四', '五', '六'],
				        months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
				        monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
				        autoHide: true
				    };
				    var dataPickerOp2 = {
				            format: 'yyyy-mm-dd',
				            weekStart: 1,
				            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
				            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
				            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
				            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
				            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
				            autoHide: true,
				           
				        };
				    $('#hwOrderAddtimeStart').datepicker(dataPickerOp);
				    $('#hwOrderAddtimeEnd').datepicker(dataPickerOp2);
				    $('#hwOrderAddtimeStart').change(function(){
				    	$('#hwOrderAddtimeEnd').datepicker('setStartDate', $(this).val());
				    })
				    $('#hwOrderAddtimeEnd').change(function(){
				    	$('#hwOrderAddtimeStart').datepicker('setEndDate', $(this).val());
				    })
				
		});
	  
	    </script>
	</body>
</html>
