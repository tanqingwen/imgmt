<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 挂失补票</title>
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
          <h1>挂失补票</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">票务管理</a></li>
            <li class="active">挂失补票</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/indacc/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label">证件类型</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="cbIdType"  name="cbIdType" > 
									      <c:forEach var="idType" items="${idTypeList}">
									      	 <option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
									      </c:forEach>
								    	</select>	
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">身份证号码</label>
								    <div class="col-sm-8">
								      <input type="password" class="form-control" id="password" name="password" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label">旧持卡人号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="password" class="form-control" id="password" name="password" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">卡片内余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="name" name="name" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">服务器金额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="email" name="email" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="gender" class="col-sm-3 control-label">姓名</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="email" name="email" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">出生日期</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value=""/>例:19001231表示1900年12月31日
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">移动电话</label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">产品组</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="prProdctGroup"  name="prProdctGroup" > 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">新持卡人号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">产品组<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="prProdctGroup"  name="prProdctGroup" > 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">押金<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value=""/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
							<button id="addButton" type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 提交</button>	                    	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/staff/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    
	$(function () {
		$("#addButton").click(function(){
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
			var password =$("#password");		 
			password.val(CryptoJS.MD5(password.val()));			 	
		});
	});
    </script>
  </body>
</html>
