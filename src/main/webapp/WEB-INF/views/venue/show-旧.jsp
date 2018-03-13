<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 场馆景点查看</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="ywvenuelist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>场馆查看</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">业务管理</a></li>
            <li class="active">场馆查看</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-eye"></i> 查看表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/ywvenue/show">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                			    <div class="form-group">
								    <label for="hwVenueId" class="col-sm-3 control-label">场馆ID</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwVenueId" name="hwVenueId" value="${item.hwVenueId }"  />
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="hwVenueName" class="col-sm-3 control-label">场馆名</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwVenueName" name="hwVenueName" title="不能为空" value="${item.hwVenueName}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwVenueNote" class="col-sm-3 control-label">场馆说明</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwVenueNote" name="hwVenueNote" title="不能为空" value="${item.hwVenueNote}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwVenueIntroduce" class="col-sm-3 control-label">场馆介绍</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwVenueIntroduce" name="hwVenueIntroduce" title="不能为空" value="${item.hwVenueIntroduce}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwVenusPos" class="col-sm-3 control-label">场馆位置<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwVenusPos" name="hwVenusPos" value="${item.hwVenusPos}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwGateId" class="col-sm-3 control-label">闸机ID(多个)</label>
								    <div class="col-sm-8">
								     	<input type="text" readonly="readonly" class="form-control" id="hwGateId" name="hwGateId"  value="${item.hwGateId}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwLeader" class="col-sm-3 control-label">负责人</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwLeader" name="hwLeader" value="${item.hwLeader}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwContractPhone" class="col-sm-3 control-label">联系电话</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwContractPhone" name="hwContractPhone" value="${item.hwContractPhone}"/>
								    </div>
								</div>
                			</div>
                		</div>
                	</div>
					<div class="box-footer">
						<div class="pull-right">
<%-- 						<button type="button" class="btn btn-info " onclick="lookPicture('场馆图片1','${item.hwVenuePic1}')"><i class="fa fa-search"></i> 查看场馆图片1</button> --%>
<%-- 						<button type="button" class="btn btn-info " onclick="lookPicture('场馆图片2','${item.hwVenuePic2}')"><i class="fa fa-search"></i> 查看场馆图片2</button> --%>
                    	<a type="button" class="btn btn-default" href="${ctx }/ywvenue/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
