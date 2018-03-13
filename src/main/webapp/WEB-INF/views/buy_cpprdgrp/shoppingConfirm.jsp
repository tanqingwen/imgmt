<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 确认订单</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
    <style type="text/css">
    	th{
     		text-align:center;
    	}
	</style>
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
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">售票管理</a></li>
            <li>我的订单</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"> 我的订单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/buy_cpprdgrp/order">
                	<section class="content">
                	<input type="hidden" id="hwCategorysListNum" value="${fn:length(ywOrderitems)+1}"/>
                	<div class="box-body">
                		<div class="table-responsive">
			                <table id="thistableQuery" class="table" >
			                	<thead>
								    <tr style="border:1px solid #DCDCDC;background: #eff8ff">
								    	<th>名称</th>
					                    <th>数量</th>
					                    <th>价格</th>
					                    <th>优惠</th>
					                    <th>小计</th>
					                    <th></th>
								    </tr>
								</thead>
								<tbody id="tbobyInfo">
									<c:forEach var="item" varStatus="status" items="${ywOrderitems}">
									<tr>
										<th>
											<font>${item.hwCategory}</font><br>
											<font color="#ACA899" style="font-weight:normal;">${item.prGroupDesc}</font><br><br>
											<font>游玩日期：${item.hwAdmissionTime}</font>
										</th>
										<th style="width: 10%;text-align:center;">${item.hwTicketCount}</th>
	                                    <th>￥<fmt:formatNumber value="${item.hwUnitPrice}" pattern="0.00"/>
	                                    	<input type="hidden" value="${item.hwUnitPrice}" id="hwPrice${item.hwProdctGroup}"/>
	                                    </th>
	                                    <th>￥0.00</th>
	                                    <th style="width: 15%;"><font color="red">￥<span id="subtotal"><fmt:formatNumber value="${item.hwAmount}" pattern="0.00"/></span></font></th>
	                                    <th><font color="red">自取</font></th>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="box" style="float:50">
						<div class="table-responsive">
							<div class="box-header with-border">
			                  <h3 class="box-title" style="color: blue"> 购买人信息</h3>
			                </div><!-- /.box-header -->
						</div>
						<div class="box-body">
							<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="phone" class="col-sm-3 control-label">手机<font color="red">*</font></label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="hwMobilePhone" name="hwMobilePhone" type="text">
			                      </div>
			                    </div>
		                    </div>
						</div>
						<div style="text-align: right;">
							<table style="width: 90%;">
								<tr>
									<td style="width: 80%;"><p>订单金额</p></td>
									<td>${ywOrderitems[0].ticketAmount}</td>
								</tr>
								<tr>
									<td style="width: 80%;"><p>优惠</p></td>
									<td>-￥0.00</td>
								</tr>
								<tr>
									<td style="width: 80%;"><p>实际金额</p></td>
									<td><font color="red" size="6">${ywOrderitems[0].ticketAmount}</font></td>
								</tr>
							</table>
						</div>
					</div>
					
					<div class="box-footer">
						<div class="col-sm-10"></div>
						<div class="col-sm-1 "><a type="button" class="btn btn-default" href="${ctx }/buy_cpprdgrp/orderOff"><i class="glyphicon glyphicon-chevron-left" ></i> 取消订单</a></div>
	                    <div class="col-sm-1 ">
	                    	<button type="submit"  class="btn btn-success">确认支付</button>
	                    </div>	                 	
	                </div><!-- /.box-footer -->
					
					</section>
	        	</form>
			</div>
			</section>
			<!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
      
      <tags:main_footer/>

      <!-- 右边控制栏Control Sidebar -->
      <tags:control_sidebar/>
  		
  	</div><!-- ./wrapper -->
	
    <tags:load_common_js/>
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script type="text/javascript">
    
    function ticketCount(val,num){
    	$.ajax({
    		type:"GET",
    		url:"${ctx}/buy_cpprdgrp/changeTCount",
    		dataType:"json",
    		data:{
    			val:val,
    			prProdctGroup:num,
    			hwUnitPrice:$("#hwPrice"+num).val()
    		},
    		success:function(data){
    			$("#shoppend").text(data[0]);
    			$("#total").text(data[1]);
    			$("#subtotal").text(data[3]);
    			$("#tCount"+num).text(data[4]);
    		}
    	});
    }
	$(document).ready(function(){
		
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				hwMobilePhone: {
 					message: '手机号码无效',
					validators: {
						notEmpty: {
							message: '手机号码不能为空'                  
						},
						regexp: {
	 						regexp: /^1[34578][0-9]{9}$/,
	 						message: '请输入正确的手机号码'
	 					}
					}
 				}
 			}
   		});
   		
	});
    </script>
  </body>
</html>