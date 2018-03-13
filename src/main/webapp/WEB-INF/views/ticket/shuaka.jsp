<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 现场购票</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>

    <style>
		.ticket-type {
    position:relative;
    float:right;
    width:100%;
    height:38px;
    line-height:38px;
   	text-indent:10px;
    border:1px solid #b3b3b3;
    background-color:#fff;
}
.ticket-type:hover .all-ticket {
    display: block;
}
.all-ticket {
    display: none;
    position:absolute;
    top:33px;
    left:13px;
    z-index: 1;
    width:94%;
    height:152px;
    overflow-y:auto;
    background-color:#fff;
    border:1px solid #b3b3b3;
    list-style: none;
    padding:0;
}
.all-ticket li {
    height:30px;
    display:inline-block;
    width:100%;
    text-indent:10px;
}
.all-ticket li i{
font-style:normal;
}
.ttt{
    width:15px;
    height:15px;
    verticla-align:middle;
}
.ticket-info{
height:20px;
margin:0 10px;
position:Relative;
bottom:5px;
}
    </style>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
  	<div style="position:absolute;">
		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="staff"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>现场购票</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">现场购票</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->               
                <form  id="ticketfrom" name="ticketfrom" class="form-horizontal" action="${ctx }/tonglian/pay" method="post">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="amount" class="col-sm-3 control-label">付款金额<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="amount" name="amount" title="不能为空" value="${tsc.totalAmountPaid}" />
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
                					<label for="mobile" class="col-sm-3 control-label">付款ID<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="mobile" name="mobile" title="不能为空" value=""/>
								    </div>
                				</div>
                			</div>
                		</div>
                	</div>
                	<div class="box-footer">
                		<div class="btn-group">
                			<button type="submit" value="">啊啊啊啊</button>
                		</div>
                	</div>
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
		$('#ticketfrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
   				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh' 
 			},
 			fields: {
 				 mobile: {
					validators: {
						notEmpty: {
							message: '付款ID不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 18,
							message: '付款ID无效不能超过18个字符'       
							},
						regexp: {
	 						regexp: /^[1-9]\d*$/,
	 						message: '请输入正确的手机号码'
	 					},
					}
 				},
 				amount: {
 					validators: {
 						notEmpty: {
							message: '预存金额不能为空'                  
						},
 						stringLength: {
 							min: 0,
 							max: 6,
 							message: '预存金额错误不能超过6个字符'       
 							},
 						regexp: {
 	 						regexp: /^[1-9]\d*$/,
 	 						message: '请输入正确的预存金额'
 	 					},
 					}
 					
 				}
 			}
   		});
   		
	});
    </script>
  </body>
</html>
