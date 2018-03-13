<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 场馆组设定</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="venuegroup"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>场馆组设定</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
			<li><a href="${ctx }/cpacqgrp/list">场馆分组</a></li>
            <li class="active">场馆组设定</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-edit"></i> 更新表单</h3>
                </div><!-- /.box-header -->
                <form id="stafffrom" class="form-horizontal" method="post" action="${ctx }/cpacqgrp/update">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
								<div class="form-group">
								    <label for="alGroupId" class="col-sm-3 control-label">分组号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="alGroupId" name="alGroupId" title="不能为空" value="${cpAcqgrp.alGroupId}" readonly="readonly"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="alDesc" class="col-sm-3 control-label">描述<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="alDesc" name="alDesc" value="${cpAcqgrp.alDesc}"/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>					 
	                <div class="box-footer">
	                	<div class="pull-right">
	                    	<button type="submit" class="btn btn-info" id="addButton"><i class="fa fa-save"></i> 更新</button>	
	                    	<a type="button" class="btn btn-default" href="${ctx }/cpacqgrp/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    
    <tags:load_common_js/>
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script type="text/javascript">
    
	$(document).ready(function(){
		
		
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				alGroupId: {
					validators: {
						notEmpty: {
							message: '场馆号不能为空'
							}
					}
 				},
 				alDesc: {
					validators: {
						notEmpty: {
							message: '描述不能为空'
							}
					}
 				}
 			}
   		}); 	
   		
	});
	
	$(function () {
		$("#updateButten").click(function(){
			var role=document.getElementsByName("roles"); 
			var m=0; var n=false; 
			for(var i=0;i<role.length;i++){ 
				if(role[i].checked){ 
					n=true; m++;
				}
			}
			if(!n){
				alert("请至少选择一个用户角色");
				//role[0].checked = true;
				return false;
			}
		});
	});
    
    </script>
    
  </body>
</html>
