<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 角色添加</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="role"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>角色添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
            <li><a href="${ctx }/role/list">角色管理</a></li>
            <li class="active">角色添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form id="roleForm" class="form-horizontal" method="post" action="${ctx }/role/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">角色ID</label>
								    <div class="col-sm-9">
								      <input maxlength="20" type="text" class="form-control" id="id" name="id" value="${item.id}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">角色名称</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="name" name="name" value="${item.name}"/>
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="roles" class="col-sm-3 control-label">功能列表</label>
								     <div class="col-sm-9">
								    	<div class="row">
								    		<c:forEach var="function" items="${functions }">
						                    <div class="col-lg-6">
												<div class="input-group">
													<span class="input-group-addon">
														<input type="checkbox" name="functions" value="${function.id }"/>
													</span>
													<span class="form-control">${function.name }</span>
												</div><!-- /input-group -->
						                    </div><!-- /.col-lg-6 -->
						                    </c:forEach>
					                  	</div><!-- /.row -->
								    </div> 
								</div>
                			</div>
                		</div>
					</div>					 
	                <div class="box-footer">
	                	<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info "><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default " href="${ctx }/role/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){
			$('#roleForm').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				id: {
						validators: {
							notEmpty: {
								message: '角色ID不能为空'
	 						}
	 					}
	 				} 
	 			}									 
			});
		});
		$(function () {
			$("#addButton").click(function(){
				var role=document.getElementsByName("functions"); 
				var m=0; var n=false; 
				for(var i=0;i<role.length;i++){ 
					if(role[i].checked){ 
						n=true; m++;
					}
				}
				if(!n){
					alert("请至少选择一个功能");
					//role[0].checked = true;
					return false;
				}
				var password =$("#password");		 
				password.val(CryptoJS.MD5(password.val()));			 	
			});
		});
    </script>
  </body>
</html>
