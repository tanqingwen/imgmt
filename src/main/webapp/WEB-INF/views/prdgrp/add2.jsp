<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 折扣添加</title>
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
          <h1>会员添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/hygl">会员管理</a></li>
            <li><a href="${ctx }/prdgrp/list">会员管理</a></li>
            <li class="active">会员添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/prdgrp/add" enctype="multipart/form-data">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">客户等级<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="prProdctGroup" name="prProdctGroup" title="不能为空" value="${grp.prProdctGroup}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">描述<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="prGroupDesc" name="prGroupDesc" value="${item.prGroupDesc}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">折扣率<font color="red">*</font></label>
								    <div class="col-sm-8">
								           <select id="prCurr4dbc" name="prCurr4dbc" class="form-control" >
								                <option value="">请选择</option>
									    		<option value="100" ${item.prCurr4dbc eq '100' ? 'selected':''}>没有折扣</option>
									    		<option value="95" ${item.prCurr4dbc eq '95' ? 'selected':''}>95折</option>
									    		<option value="90" ${item.prCurr4dbc eq '90' ? 'selected':''}>9折</option>
									    		<option value="80" ${item.prCurr4dbc eq '80' ? 'selected':''}>8折</option>
									    		<option value="70" ${item.prCurr4dbc eq '70' ? 'selected':''}>7折</option>
									    		<option value="60" ${item.prCurr4dbc eq '60' ? 'selected':''}>6折</option>
									    		<option value="50" ${item.prCurr4dbc eq '50' ? 'selected':''}>5折</option>
									    		<option value="40" ${item.prCurr4dbc eq '40' ? 'selected':''}>4折</option>
									    		<option value="30" ${item.prCurr4dbc eq '30' ? 'selected':''}>3折</option>
									    		<option value="20" ${item.prCurr4dbc eq '20' ? 'selected':''}>2折</option>
									    		<option value="10" ${item.prCurr4dbc eq '10' ? 'selected':''}>1折</option>
									    	</select>
								    </div>
								</div>
								<div class="form-group">
									<label for="rechargeStart" class="col-sm-3 control-label">规则范围<font color="red">*</font></label>
									     <div class="col-sm-8">
											<input type="text" class="form-control" id="prPlasticType" name="prPlasticType" value="${item.prPlasticType}"/>
	                                     </div>
								</div>
								
								<%-- <div class="form-group">
								    <label for="password" class="col-sm-3 control-label">卡行业<font color="red">*</font></label>
								    <div class="col-sm-8">
									      <select id="prCardBrand" name="prCardBrand" class="form-control" >
									      		<option value="P" ${item.prCardBrand eq 'P' ? 'selected':''}>住建标准</option>
									      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">卡类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								          <select id="prCardType" name="prCardType" class="form-control" >
									      		<option value="S" ${item.prCardType eq 'S' ? 'selected':''}>逻辑加密卡</option>
									      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">货币指示<font color="red">*</font></label>
								    <div class="col-sm-8">
								          <select id="prCardnumRule" name="prCardnumRule" class="form-control" >
									      		<option value="L" ${item.prCardnumRule eq 'L' ? 'selected':''}>本币结算</option>
									      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">当前顺序卡号</label>
								    <div class="col-sm-8">
								          <input type="text" class="form-control" id="prPinerrNumber" name="prPinerrNumber" value="${item.prPinerrNumber}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">年龄限制</label>
								        <div class="col-sm-8">
								             <input type="text" class="form-control" id="prCurrInd" name="prCurrInd" value="${item.prCurrInd}"/>
								        </div>
								</div>  
								<div class="form-group">
									<label for="rechargeStart" class="col-sm-3 control-label">押金<font color="red">*</font></label>
									     <div class="col-sm-8">
											<input type="text" class="form-control" id="prNext4dbc" name="prNext4dbc" value="${item.prNext4dbc}"/>
	                                     </div>
								</div> --%>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info "><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default " href="${ctx }/prdgrp/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
<!-- 					 	<div class="col-sm-10 ">						 -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-1 ">	 -->
<!-- 							<button  type="submit" id="addButton" class="btn btn-info pull-right" ><i class="fa fa-plus"></i> 添加</button>	                    	 -->
<!-- 	                    </div> -->
<!-- 	                    <div class="col-sm-1 "> -->
<%-- 	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/prdgrp/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
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
   /*  function isnull(){
    	var prProdctGroup = document.getElementById(prProdctGroup); 
    	var re = /^\d{5}$/;
    	if(prProdctGroup==""){
    		alert("产品组不能为空，只能为数字，长度不能超过5位");
    		return false;
    	}
    } */
    $(document).ready(function(){
    	$('.firstCommission').datepicker({
   			format: 'yyyymmdd',
			autoclose: true,
			todayBtn : "linked",  
	        todayHighlight : true,  
	    }).on('hide',function(e){
	    	$('#stafffrom').data('bootstrapValidator').updateStatus('hwStartdate','NOT_VALIDATED',null).validateField('hwStartdate');
	    	$('#stafffrom').data('bootstrapValidator').updateStatus('hwEnddate','NOT_VALIDATED',null).validateField('hwEnddate');
	    });
    	
    	$("#addButton").click(function(){
			var hwStartdate = $("#hwStartdate").val();
			var hwEnddate = $("#hwEnddate").val();
			if(hwStartdate != "" && hwEnddate != ""){
				if(Number(hwStartdate)>Number(hwEnddate)){
					alert("门票起始时间不可以大于门票截止时间！");
					return false;
				}
			}
			
		});
		
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				hwStartdate: {
					validators: {
						notEmpty: {
							message: '请选择门票起始日期'
							}
					}
 				},
 				hwEnddate: {
					validators: {
						notEmpty: {
							message: '请选择门票截止日期'
							}
					}
 				},
 				hwTicketDes: {
					validators: {
						notEmpty: {
							message: '介绍不能为空'
							}
					}
 				},
 				hwTicketPicfile: {
					validators: {
						notEmpty: {
							message: '请上传门票图片'
							}
					}
 				},
 				prProdctGroup: {
 					message: '产品组不能为空',
					validators: {
						notEmpty: {
							message: '产品组不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 5,
							message: '产品组不能超过5个字符'       
							},
					}
 				}, 
 				prGroupDesc: {
					validators: {
						notEmpty: {
							message: '描述不能为空'
							}
					}
 				},
 				hwCategory: {
					validators: {
						notEmpty: {
							message: '票券类型不能为空'
							}
					}
 				},
 				hwPrice: {
					validators: {
						notEmpty: {
							message: '票券价格不能为空'
							},
							regexp: {
			                    regexp: /^(([1-9]\d*)|\d)(\.\d{1,3})?$/,
			                    message: '请输入正确价格'
			                },
					}
 				}
 			}
   		}); 	
	}); 
    </script>
  </body>
</html>
