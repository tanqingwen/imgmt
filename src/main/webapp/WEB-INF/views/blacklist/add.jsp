<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 黑名单添加</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="blacklist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>黑名单添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/hygl">会员管理</a></li>
            <li><a href="${ctx }/blacklist/list">会员黑名单设定</a></li>
            <li class="active">黑名单添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/blacklist/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                		<input type="hidden" value="${bmOrgId }" id="bmOrgId" name="bmOrgId"/>
                			<div class="row">
	                			<div class="form-group">
								    <label for="bmCardNo" class="col-sm-3 control-label">卡号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmCardNo" name="bmCardNo" title="不能为空" value="${item.bmCardNo}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="bmProductCode" class="col-sm-3 control-label">持卡类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmProductCode" name="bmProductCode" value="${item.bmProductCode}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="bmReasonCode" class="col-sm-3 control-label">证件号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmReasonCode" name="bmReasonCode" value="${item.bmReasonCode}"/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info "><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default " href="${ctx }/blacklist/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
<!-- 					 	<div class="col-sm-10 ">						 -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-1 ">	 -->
<!-- 							<button id="addButton" type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 添加</button>	                    	 -->
<!-- 	                    </div> -->
<!-- 	                    <div class="col-sm-1 "> -->
<%-- 	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/blacklist/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
<!-- 	                    </div>	                 	 -->
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
 				 id: {
 					message: '员工ID无效',
					validators: {
						notEmpty: {
							message: '员工ID无效'                  
						},
						stringLength: {
							min: 0,
							max: 20,
							message: '员工ID无效不能超过20个字符'       
							},
					}
 				}, 
 				password: {
					validators: {
						notEmpty: {
							message: '登陆密码不能为空'
							}
					}
 				},
 				organizations: {
 					validators: {
 						notEmpty: {
							message: '员工机构不能为空'
							}
 					}
 				},
 				name: {
 					validators: {
 						notEmpty: {
							message: '员工姓名不能为空'
							}
 					}
 				},
 				email: {
 					validators:{
 						regexp: {
 							regexp: /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+.+[a-z]{2,4}$/,
 							message: '请输入正确邮箱地址'
 						}
 					}
 				},
 				phoneNumber: {
 					validators:{
 						regexp: {
	 						regexp: /^[0-9]{1,20}$/,
	 						message: '请输入正确的电话号码'
	 					}
 					}
 				}
 			}
   		});
   		
	});
    
    </script>
  </body>
</html>
