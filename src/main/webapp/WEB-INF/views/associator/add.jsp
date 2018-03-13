<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 会员注册</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
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
          <h1>会员注册</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/hygl">会员管理</a></li>
            <li class="active">会员注册</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/associator/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                			     <div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label">证件类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select id="cbIdType" name="cbIdType" class="form-control" >
								                <option value="">请选择</option>
									    		<option value="1" ${item.cbIdType eq '1' ? 'selected':''}>身份证</option>
									    		<option value="2" ${item.cbIdType eq '2' ? 'selected':''}>军官证</option>
									    		<option value="3" ${item.cbIdType eq '3' ? 'selected':''}>护照</option>
									    	</select>
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="cbCustomerIdno" class="col-sm-3 control-label">证件号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="证件号" value="${item.cbCustomerIdno}"/>
								    </div>
								</div>
								<!-- <div class="form-group">
								    <label for="cbHomeAddr1" class="col-sm-3 control-label">登录密码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="cbHomeAddr1" class="form-control" id="cbHomeAddr1" name="cbHomeAddr1" value="${item.cbHomeAddr1}"/>
								    </div>
								</div> -->
								<div class="form-group">
								    <label for="cbCardholderName" class="col-sm-3 control-label">姓名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbCardholderName" name="cbCardholderName" value="${item.cbCardholderName}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbEmail" class="col-sm-3 control-label">邮箱<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbEmail" name="cbEmail" value="${item.cbEmail}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbSex" class="col-sm-3 control-label">性别</label>
								    <div class="col-sm-8">
								      	<label class="radio-inline">
										  	<input type="radio" name="cbSex" id="cbSex" value="1" checked="checked">男
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="cbSex" id="cbSex" value="2">女
										</label>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbMobileNo" class="col-sm-3 control-label">电话号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbMobileNo" name="cbMobileNo" value="${item.cbMobileNo}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwStatus" class="col-sm-3 control-label">状态<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<select id="hwStatus" name="hwStatus" class="form-control" >
								                <option value="">请选择</option>
									    		<option value="1" ${item.hwStatus eq '1' ? 'selected':''}>正常</option>
									    		<option value="2" ${item.hwStatus eq '2' ? 'selected':''}>冻结</option>
									    	</select>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
							<button id="addButton" type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 添加</button>	                    	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/associator/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
 				cbCustomerIdno: {
 					message: '证件号码无效',
					validators: {
						notEmpty: {
							message: '证件不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 18,
							message: '证件号码不能超过18个字符'       
							},
						regexp:{
							regexp: /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/,
							message: '请输入正确的证件号码，身份证号码为15或18个字符' 
						},
					}
 				}, 
 				cbHomeAddr1: {
					validators: {
						notEmpty: {
							message: '登陆密码不能为空'
							}
					}
 				},
 				cbIdType: {
 					validators: {
 						notEmpty: {
							message: '证件类型不能为空'
							}
 					}
 				},
 				cbCardholderName: {
 					validators: {
 						notEmpty: {
							message: '会员姓名不能为空'
							}
 					}
 				},
 				hwStatus: {
 					validators: {
 						notEmpty: {
							message: '状况不能为空'
							}
 					}
 				},
 				cbEmail: {
 					validators:{
 						notEmpty: {
							message: '邮箱不能为空'                  
						},
 						regexp: {
 							regexp: /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+.+[a-z]{2,4}$/,
 							message: '您输入的邮箱地址不正确，请重新输入！'
 						}
 					}
 				},
 				cbMobileNo: {
 					validators:{
 						notEmpty: {
							message: '手机号码不能为空'                  
						},
 						regexp: {
	 						regexp: /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/,
	 						message: '您输入的手机号码不正确，请重新输入！'
	 					}
 					}
 				}
 			}
   		});
   		
	});
    
	$(function () {
		$("#addButton").click(function(){
			var role=document.getElementsByName("roles"); 
			var m=0; var n=false; 
			for(var i=0;i<role.length;i++){ 
				if(role[i].checked){ 
					n=true; m++;
				}
			}
			var cbHomeAddr1 =$("#cbHomeAddr1");		 
			cbHomeAddr1.val(CryptoJS.MD5(cbHomeAddr1.val()));			 	
		});
	});
	$(document).ready(function(){
		if($('body').hasClass('sidebar-collapse')){
			$('body').removeClass('sidebar-collapse');
		}
		
	});
    </script>
  </body>
</html>
