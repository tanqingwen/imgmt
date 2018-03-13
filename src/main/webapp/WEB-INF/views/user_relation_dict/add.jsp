<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 人际关系添加</title>
    <tags:head_common_content/>
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
          <h1>人际关系添加</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">商户管理</a></li>
            <li class="active">人际关系添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form id="user_relationForm" class="form-horizontal" method="post" action="${ctx }/user_relation_dict/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="userRelationId" class="col-sm-3 control-label">人际关系ID</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="userRelationId" name="userRelationId" value="${item.userRelationId}"/>
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
								<div class="form-group">
								    <label for="userRelationDesc" class="col-sm-3 control-label">人际关系描述</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="userRelationDesc" name="userRelationDesc" value="${item.userRelationDesc}"/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>					
	                <div class="box-footer">
	                	<div class="pull-right">
	                    	<button type="submit" class="btn btn-info"><i class="fa fa-plus"></i> 添加</button>
	                    	<a type="button" class="btn btn-default" href="${ctx }/user_relation_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                	</div>
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
        </div><!-- /.box -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    </div><!-- ./wrapper -->
    <tags:load_common_js/>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){
			$('#user_relationForm').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	   				userRelationId: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {	 		 				
	 				userRelationId:{
						validators: {
							notEmpty: {
								message: '关系ID不能为空'
	 						}
	 					}
	 				}
	 			}									 
			});
		});
    </script>
  </body>
</html>
