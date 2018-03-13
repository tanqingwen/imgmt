<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 证件类型添加</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="midtype"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>证件类型添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
            <li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
            <li><a href="${ctx }/idtype_dict/list">证件类型管理</a></li>
            <li class="active">证件类型添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form id="idtype" class="form-horizontal" method="post" action="${ctx }/idtype_dict/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">证件类型<font color="red">*</font></label>
								    <div class="col-sm-9">
								      <input maxlength="10" type="text" class="form-control" id="idtypeId" name="idtypeId" />
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">证件描述</label>
								    <div class="col-sm-9">
								      <input maxlength="40" type="text" class="form-control" id="idtypeDesc" name="idtypeDesc"/>
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
								<!-- <div class="form-group">
								    <label for="id" class="col-sm-3 control-label">起始位置</label>
								    <div class="col-sm-9">
								      <input maxlength="1" type="text" class="form-control" id="idtypeForm" name="idtypeForm" />
								    </div>
								</div> -->
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">最大长度</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="idtypeLength" name="idtypeLength" />
								    </div>
								</div>								
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button type="submit" class="btn btn-info" style="margin-left: 10px;"><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default" href="${ctx }/idtype_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
			$('#idtype').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				idtypeId: {
						validators: {
							notEmpty: {
								message: '证件类型不能为空'
	 						}
	 					}
	 				}	 				
	 			}									 
			});
		});
    </script>
  </body>
</html>
