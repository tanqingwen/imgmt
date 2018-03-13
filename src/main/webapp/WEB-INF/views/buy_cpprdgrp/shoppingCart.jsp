<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 购物车</title>
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
          <h1>购物车</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">售票管理</a></li>
            <li>购物车</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"> 购物车</h3><br>
                </div><!-- /.box-header -->
                <section class="content">
                <input type="hidden" id="ywOrderitemsListNum" value="${fn:length(ywOrderitems)}"/>
                <div id="noCount">
                	<div class="box-body">
                		<div class="table-responsive">
                			<form id="thisform" class="form-horizontal" action="">
			                <table id="thistableQuery" class="table" >
			                	<thead>
								    <tr style="border:1px solid #DCDCDC;background: #eff8ff">
<!-- 								    	<th> -->
<!-- 								    		<label class="checkbox-inline" style="font-weight:bold;"> -->
<!-- 											  <input type="checkbox" id="inlineCheckbox1" checked="checked"/>全选 -->
<!-- 											</label> -->
<!-- 								    	</th> -->
	                                    <th>项目</th>
					                    <th>价格</th>
					                    <th>数量</th>
					                    <th>优惠</th>
					                    <th>小计</th>
					                    <th>操作</th>
								    </tr>
								</thead>
								<tbody id="tbobyInfo">
									<c:forEach var="item" varStatus="status" items="${ywOrderitems}">
									<tr>
<!-- 										<th style="width: 5%;"> -->
<!-- 								    		<label class="checkbox-inline"> -->
<!-- 											  <input type="checkbox" id="inlineCheckbox1" checked="checked" value="option1"/> -->
<!-- 											</label> -->
<!-- 								    	</th> -->
										<th>
											<font color="blue">${item.hwCategory}</font><br>
											<font size="4">${item.prGroupDesc}</font><br>
											<font color="#ACA899" style="font-weight:normal;">游玩日期：${item.hwAdmissionTime}</font>
										</th>
	                                    <th>￥<fmt:formatNumber value="${item.hwUnitPrice}" pattern="0.00"/>
	                                    	<input type="hidden" value="${item.hwUnitPrice}" id="hwPrice${item.hwProdctGroup}"/>
	                                    </th>
	                                    <th style="width: 10%;text-align:center;">
	                                    	<div>
	                                			<span class="glyphicon glyphicon-minus" onclick="changeTCount('-','${item.hwProdctGroup}')"></span>
	                               				<input readonly id="tCount${item.hwProdctGroup}" style="width:50px; padding-right:10px;text-align:center;" type="text" value="${item.hwTicketCount}">
	                                			<span class="glyphicon glyphicon-plus" onclick="changeTCount('+','${item.hwProdctGroup}')"></span>
                            				</div>
	                                    </th>
	                                    <th>￥0.00</th>
	                                    <th style="width: 15%;"><font color="red">￥<span id="subtotal${item.hwProdctGroup}"><fmt:formatNumber value="${item.hwAmount}" pattern="0"/></span></font></th>
	                                    <th>
	                                    	<button type="submit" id="thisIdForDel" onclick="deteleTCount('${item.hwProdctGroup}')" class="btn btn-link"><font color="red">删除</font></button>
	                                    </th>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							</form>
						</div>
					</div>
					<form class="form-horizontal" method="post" action="${ctx }/buy_cpprdgrp/shoppingConfirm">
						<div class="box-footer">
							<div class="col-sm-10" style="text-align:center;font-weight:bold;">合计：<font color="red" size="6"><span id="total">${ywOrderitems[0].ticketAmount}</span></font></div>
							<div class="col-sm-1 ">	
								<button type="submit"  class="btn btn-success"><span id="shoppend">结算(${ywOrderitems[0].ticketCount})</span></button>
		                    </div>
		                    <div class="col-sm-1 ">
		                    	<a type="button" class="btn btn-warning" href="${ctx }/buy_cpprdgrp/ticketList">继续购买</a>
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
    function deteleTCount(prProdctGroup){
    	$("#thisform").attr("action", "${ctx }/buy_cpprdgrp/deteleTCounts/"+prProdctGroup);
	}
    
    function changeTCount(val,num){
    	if("-"==val){
    		if($("#tCount"+num).val()==1){return false;}
    	}
    	$.ajax({
    		type:"GET",
    		url:"${ctx}/buy_cpprdgrp/changeTCount",
    		dataType:"json",
    		data:{
    			val:val,
    			prProdctGroup:num
    		},
    		success:function(data){
    			$("#shoppend").text("结算("+data.ticketCount+")");//结算
    			$("#total").text(data.ticketAmount);//合计
    			$("#subtotal"+num).text(data.hwAmount);//小计
    			$("#tCount"+num).val(data.hwTicketCount);//数量
    		}
    	});
    }
    $(function () {
		if($("#ywOrderitemsListNum").val()==0){
			$("#noCount").text("");
			$("#noCount").css("text-align","center");
			$("#noCount").append("购物车还空着呢~快去<a href=\"${ctx }/buy_cpprdgrp/ticketList\"><font color=\"red\" size=\"6\">选购</font></a>吧~");
		}
	});
    </script>
  </body>
</html>