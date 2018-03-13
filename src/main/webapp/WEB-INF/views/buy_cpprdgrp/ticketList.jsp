<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 售票</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
	<style type="text/css">
    	.thClass{
    		border:1px solid #DCDCDC;
    	}
    	th{
    		text-align:center;
    	}
    	.active {background:#fff;color:#1996f9;border-color:#dcdcdc;border-top:2px solid #1996f9;top:1px;}
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
          <h1>售票</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">售票管理</a></li>
            <li>售票</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"> 售票信息</h3>
                </div><!-- /.box-header -->
                
               	<section class="content">
               	<input type="hidden" id="hwCategorysListNum" value="${fn:length(hwCategorysList)+1}"/>
               	<div class="box-body">
               		<div class="table-responsive">
                		<form class="form-horizontal" method="get" id="thisform" action="${ctx }/buy_cpprdgrp/ticketList">
			                <table id="thistableQuery" class="table" >
			                	<thead>
								    <tr style="border:1px solid #DCDCDC;">
								    
								    	<c:forEach var="item" varStatus="status" items="${hwCategorysList}">
									        <th class="thClass" id="show${status.index+1}" onclick="TtypeChange('${item.prCardBrand}','${item.prCardType}','${status.index+1}','${item.hwCategory}')">${item.hwCategory}</th>
								        </c:forEach>
								    </tr>
								</thead>
								<tbody>
								    <tr>
										<td colspan="${fn:length(hwCategorysList)}">
											<table class="table">
												<tr>
													<td>
														<label for="rechargeStart" class="col-sm-2 control-label">游玩时间：</label>
														<div class="input-group date firstCommission">
															<span class="input-group-addon">
																<span class="glyphicon glyphicon-calendar"></span>
															</span>
															<input class="form-control" id="ctApproveTime" value="${getNowTime }" style="width: 300px;" readonly="readonly" name="ctApproveTime" />
															<input type="hidden" id="prCardBrand" value="${hwCategorysList[0].prCardBrand}"/>
															<input type="hidden" id="prCardType" value="${hwCategorysList[0].prCardType}"/>
															<input type="hidden" id="hwCategory" value="${cpPrdgrps[0].hwCategory}"/>
														</div>
													</td>
													<td><button type="submit" id="ticketShow" class="btn btn-info pull-right" style="width: 200px;"> 查询 </button></td>
												</tr>
											</table>
											<input type="hidden" id="Time" value="${getNowTime }"/>
										</td>
								    </tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
				
				<!-- 列表div---start -->
				<div class="box"style="float:50">
					<div class="box-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr style="text-align: center;background: #eff8ff">
									    <th><font size="4">名称</font></th>
	                                    <th><font size="4">门市价 / 优惠价</font></th>
	                                    <th></th>
									</tr>
								</thead>
								<tbody id="tbobyInfo">
<!-- 									<input class="form-control" id="Tnumber" type="text" placeholder="请填写票数"/> -->
									<c:forEach var="item" varStatus="status" items="${cpPrdgrps}">
									<tr>
										<th style="width: 35%">${item.prGroupDesc}
											<input type="hidden" value="${item.prGroupDesc}" id="prGroupDesc${item.prProdctGroup}"/>
										</th>
	                                    <th style="color: red;width: 35%">￥<fmt:formatNumber value="${item.hwPrice}" pattern="0"/>
	                                    	<input type="hidden" value="${item.hwPrice}" id="hwPrice${item.prProdctGroup}"/>
	                                    </th>
	                                    <th style="width: 20%"><button type="button" id="ticketAdd${item.prProdctGroup}" onclick="ticketAdd('${item.prProdctGroup}')" class="btn btn-warning" style="width: 200px;"> 添加</button></th>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							<tags:pagination url="${ctx}/staff/list" page="${pageInfo}" cssClass="pull-right"/>
						</div>
					</div>
					<form action="${ctx }/buy_cpprdgrp/shoppingCart" method="post">
						<div class="box-footer">
							<div class="col-sm-10 "></div>
							<div class="col-sm-1 ">	
								<button id="Tshopping" type="submit" class="btn btn-link"><i class="glyphicon glyphicon-shopping-cart" ></i><span id="shopping">购物车结账(${TicketCount})</span></button>
								<input type="hidden" value="${TicketCount}" id="TicketCount"/>
		                    </div>
		                    <div class="col-sm-1 ">
		                    	<a type="button" class="btn btn-default  " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
		                    </div>	                 	
		                </div><!-- /.box-footer -->
					</form>
				</div>
				</section>
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
    $("#show1").addClass("active");
    
    function TtypeChange(prCardBrand,prCardType,showNum,hwCategory){
     	for(var j=1;j<$("#hwCategorysListNum").val();j++){
     		$("#show"+j).removeClass("active");
     	}
     	$("#show"+showNum).addClass("active");
     	$("#prCardBrand").val(prCardBrand);
     	$("#prCardType").val(prCardType);
     	$("#hwCategory").val(hwCategory);
    	$.ajax({
    		type:"GET",
    		url:"${ctx}/buy_cpprdgrp/TtypeChange",
    		dataType:"json",
    		data:{
    			time:$("#ctApproveTime").val(),
    			prCardBrand:prCardBrand,
    			prCardType:prCardType
    		},
    		success:function(data){
    			$("#tbobyInfo").text("");
    			for(i in data){
    				$("#tbobyInfo").append("<tr><th style='width: 35%'>"+data[i].prGroupDesc+
											"<input type='hidden' value='"+data[i].prGroupDesc+"' id='prGroupDesc"+data[i].prProdctGroup+"'/>"+
											"</th>"+
                                			"<th style='color: red;width: 35%'>￥"+data[i].hwPrice+
                                			"<input type='hidden' value='"+data[i].hwPrice+"' id='hwPrice"+data[i].prProdctGroup+"'/>"+
                                			"</th>"+
    										/* "<th style='width: 10%;text-align:center;'><div>"+
	                                			"<span class='glyphicon glyphicon-minus' onclick=\"changeTCount('-','"+data[i].prProdctGroup+"')\"></span>"+
	                               				"<input readonly id='tCount"+data[i].prProdctGroup+"' style='width:50px; padding-right:10px;text-align:center;' type='text' value='1'>"+
	                                			"<span class='glyphicon glyphicon-plus' onclick=\"changeTCount('+','"+data[i].prProdctGroup+"')\"></span>"+
	                        				"</div></th>"+ */
    										"<th style='width: 20%'><button type='button' id='ticketAdd"+data[i].prProdctGroup+"' onclick=\"ticketAdd('"+data[i].prProdctGroup+"')\" class='btn btn-warning' style='width: 200px;'> 添加</button></th>"+"</tr>");
    			}
    		}
    	});
    }
    $("#ticketShow").click(function(){
    	$("#Time").val($("#ctApproveTime").val());
    });
    
    function ticketAdd(num){
    	if($("#Time").val()!=$("#ctApproveTime").val()){
    		$("#thisform").submit();
    		return false;
    	}
    	$.ajax({
    		type:"GET",
    		url:"${ctx}/buy_cpprdgrp/ticketAdd",
    		dataType:"json",
    		data:{
    			prProdctGroup:num,
    			hwAdmissionTime:$("#ctApproveTime").val(),
    			hwUnitPrice:$("#hwPrice"+num).val(),
    			prGroupDesc:$("#prGroupDesc"+num).val(),
    			hwCategory:$("#hwCategory").val()
    		},
    		success:function(data){
    			$("#shopping").text("购物车结账("+data+")");
    			$("#TicketCount").val(data);
    		}
    	});
    }
    
	$(function () {
		$('.firstCommission').datepicker({
   			format: 'yyyy-mm-dd',
			autoclose: true,
			todayBtn : "linked",  
	        todayHighlight : true, 
	        startDate: 'd',
	    });
		$("#Tshopping").click(function(){
			if(parseInt($("#TicketCount").val())==0){
				alert("购物车还没有商品，赶紧选购吧");
				return false;
			}
		});
	});
    </script>
  </body>
</html>