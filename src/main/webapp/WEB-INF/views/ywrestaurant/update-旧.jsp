<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 餐厅更新</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="ywrestaurantlist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>餐厅更新</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/ywrestaurant/list">餐厅信息管理</a></li>
            <li class="active">餐厅更新</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 更新表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/ywrestaurant/update" enctype="multipart/form-data">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                			    <div class="form-group">
								    <label for="restaurantId" class="col-sm-3 control-label">餐厅ID</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="restaurantId" name="restaurantId" value="${item.restaurantId }"  />
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="restaurantName" class="col-sm-3 control-label">餐厅名</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="restaurantName" name="restaurantName" title="不能为空" value="${item.restaurantName}"/>
								    </div>
								</div>
<!-- 								<div class="form-group"> -->
<!-- 								    <label for="hwVenuePic1" class="col-sm-3 control-label">餐厅图片</label> -->
<!-- 								    <div class="col-sm-8"> -->
<!-- 								      <input type="file" class="form-control" id="restaurantPicturefile" name="restaurantPicturefile" value=""/> -->
<!-- 								    </div> -->
<!-- 								</div> -->
                			</div>
                		</div>
                	</div>
                	<div class="box-footer">
						<div class="pull-right">
<%-- 						<button type="button" class="btn btn-info " onclick="lookPicture('餐厅图片','${item.restaurantPicture}')"><i class="fa fa-search"></i> 查看餐厅图片</button> --%>
                    	<button id="addButton" type="submit" class="btn btn-info"><i class="fa fa-save"></i> 更新</button>	
                    	<a type="button" class="btn btn-default" href="${ctx }/ywrestaurant/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
               			</div>
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
			</section>
        </div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
    <!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" style="overflow: auto;" aria-hidden="true">
	  <div class="modal-dialog modal-lg" id="midal">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel"></h4>
	      </div>
	      <div class="modal-body" id="myModalBody">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
    <tags:load_common_js/>
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script type="text/javascript">
    function lookPicture(label,boby){
    	$.ajax({
    		type:"POST",
    		url:"${ctx}/prdgrp/getPicture",
    		dataType:"json",
    		data:{
    			picname:boby
    		},
    		success:function(data){
				$("#myModalBody").text("");
				$("#myModalLabel").text("");
				$("#myModalLabel").append(label+"<br>"+boby.substring(boby.lastIndexOf("/")+1));
    			if(data){
    				$("#myModalBody").append("<img class=\"img-responsive\" src="+boby+" alt="+label+">");
    			}else{
    				$("#myModalBody").append("图片不存在，请联系管理员更新图片！");
    			}
    			$("#myModal").modal("show");
    		}
    	});
	}
    
    </script>
  </body>
</html>
