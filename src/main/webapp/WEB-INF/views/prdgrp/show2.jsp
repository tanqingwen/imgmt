<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 折扣查看</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="prdgrp"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>折扣查看</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/hygl">会员管理</a></li>
            <li><a href="${ctx }/prdgrp/list">会员折扣</a></li>
            <li class="active">折扣查看</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-eye"></i> 会员折扣</h3>
                </div><!-- /.box-header -->
                <form class="form-horizontal" method="" action="">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
								<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">客户等级</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="prProdctGroup" name="prProdctGroup" value="${item.prProdctGroup}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">描述</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="prGroupDesc" name="prGroupDesc" value="${item.prGroupDesc}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">折扣率</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="prCurr4dbc" name="prCurr4dbc" disabled>
								     	 <option value="100" ${item.prCurr4dbc eq '100' ? 'selected' : ''}>没有折扣</option>
								     	 <option value="95" ${item.prCurr4dbc eq '95' ? 'selected' : ''}>95折</option>
								     	 <option value="90" ${item.prCurr4dbc eq '90' ? 'selected' : ''}>90折</option>
								     	 <option value="80" ${item.prCurr4dbc eq '80' ? 'selected' : ''}>80折</option>
								     	 <option value="70" ${item.prCurr4dbc eq '70' ? 'selected' : ''}>70折</option>
								     	 <option value="60" ${item.prCurr4dbc eq '60' ? 'selected' : ''}>60折</option>
								     	 <option value="50" ${item.prCurr4dbc eq '50' ? 'selected' : ''}>50折</option>
								     	 <option value="40" ${item.prCurr4dbc eq '40' ? 'selected' : ''}>40折</option>
								     	 <option value="30" ${item.prCurr4dbc eq '30' ? 'selected' : ''}>30折</option>
								     	 <option value="20" ${item.prCurr4dbc eq '20' ? 'selected' : ''}>20折</option>
								     	 <option value="10" ${item.prCurr4dbc eq '10' ? 'selected' : ''}>10折</option>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">卡行业</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="prCardBrand" name="prCardBrand" disabled>
								     	 <option value="P" ${item.prCardBrand eq 'P' ? 'selected' : ''}>住建标准</option>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">卡类型</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="prCardType" name="prCardType" disabled>
								     	 <option value="S" ${item.prCardType eq 'S' ? 'selected' : ''}>逻辑加密卡</option>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">货币指示</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="prCardnumRule" name="prCardnumRule" disabled>
								     	 <option value="L" ${item.prCardnumRule eq 'L' ? 'selected' : ''}>本币结算</option>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">当前序列号</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="prPinerrNumber" name="prPinerrNumber" value="${item.prPinerrNumber}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">年龄限制</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="prCurrInd" name="prCurrInd" value="${item.prCurrInd}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">押金</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="prNext4dbc" name="prNext4dbc" value="${item.prNext4dbc}" disabled/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<a type="submit" class="btn btn-default pull-right" href="${ctx }/prdgrp/list"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
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
 					message: '票种ID无效',
					validators: {
						notEmpty: {
							message: '票种ID无效'                  
						},
						stringLength: {
							min: 0,
							max: 20,
							message: '票种ID无效不能超过20个字符'       
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
							message: '票种机构不能为空'
							}
 					}
 				},
 				name: {
 					validators: {
 						notEmpty: {
							message: '票种姓名不能为空'
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
