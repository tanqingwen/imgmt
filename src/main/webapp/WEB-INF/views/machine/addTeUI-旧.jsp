<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 终端新增</title>
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">

<tags:head_common_content />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="profile" />

		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>终端新增</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">商户管理</a></li>
            		<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">商户列表</a></li>
            		<li><a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">终端列表</a></li>
					<li class="active">终端新增</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
			<form:form action="${ctx}/machine/addTe" modelAttribute="cpPosprm" method="post" id="machinefrom" name="machinefrom" class="form-horizontal">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-plus"></i> 添加列表
						</h3>
					</div>
					 <!-- /.box-header -->
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="tmTerminalId" class="col-sm-3 control-label">终端编号<font color="red">*</font></label>
										<div class="col-sm-8">
											<input type="text" class="form-control" readonly="readonly" id="tmTerminalId" name="tmTerminalId" value="${tmTerminalId}"/>
											<input type="hidden" class="form-control" id="tmEdcSerial" name="tmEdcSerial" value="1"/>
											<input type="hidden" class="form-control" id="tmUseState" name="tmUseState" value="1"/>
										</div>
									</div>
									
									<!--  
									<div class="form-group">
								    	<label class="col-sm-3 control-label">场馆等级</label>
								    	<div class="col-sm-8">
									     	<select class="form-control" id="tmIswatch" name="tmIswatch" >
									     		<option value="0">请选择级别...</option>
			 									<option value="1">一级-欢乐大世界</option>
			 									<option value="2">二级-场馆</option>
			 									<option value="3">三级-子场馆</option>
			 								<select>
								    	</div>
									</div>
									-->
									
									<div class="form-group">
										<label class="col-sm-3 control-label">终端品牌<font color="red">*</font></label>
										<div class="col-sm-8">
											<select class="form-control" id="tmBrand"  name="tmBrand" > 
										       <option value="">-----请选择品牌------</option>
										     	 <c:forEach var="cpPosprm" items="${cpPosprmList}" >
										      	 	<option value="${cpPosprm.ppBrand}" >${cpPosprm.ppBrand}</option>
										      	</c:forEach>
									      	</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">终端版本<font color="red">*</font></label>
										<div class="col-sm-8">
										<select class="form-control" id="tmVersionNo"  name="tmVersionNo" > 
										     <option value="" >-----请选择版本------</option>
									      	 <option value="1.0" >-----1.0-----</option>
									      	 <option value="2.0">-----2.0-----</option>
								      	</select>
									</div>
									</div>
									
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<!--  	
										<div class="form-group" id="gateIp">
											<label for="gateIp" class="col-sm-3 control-label">闸机IP</label>
											<div class="col-sm-8">
												<select class="form-control" id="tmHostSerial"  name="tmHostSerial" > 
										     		<option value="" >-----请选择闸机IP------</option>
										     	 		<c:forEach var="cpGateip" items="${gateIpList}" >
												      	 	<option value="${cpGateip.gaIp}" >${cpGateip.gaIp}</option>
												      	</c:forEach>
										      	</select>
											</div>
										</div>
										-->
										
										<div class="form-group">
				    						<label class="col-sm-3 control-label">商户号码</label>
				    						<div class="col-sm-8">
												<input type="text" id="tmMerchantId" name="tmMerchantId"  readonly="readonly"	value="${merchantId}" class="form-control"/>
				    						</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">安装日期<font color="red">*</font></label>
                                        	<div class="col-sm-8">
									    		<div class="input-group col-sm-12 date firstCommission">
													<span class="input-group-addon">
													<span class="glyphicon glyphicon-calendar"></span>
													</span>
									       			<input type="text" id="tmDateInst" name="tmDateInst"  class="form-control"/>
									   			</div>
									    	</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">设备序号</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="tmEdcPrinterNo" name="tmEdcPrinterNo"/>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="box-footer">
							<div class="pull-right">
								<button  type="submit" id="addButton" class="btn btn-info"><i class="fa fa-plus"></i> 添加</button>
		                    	<a type="button" class="btn btn-default" href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                		</div>
	              		</div><!-- /.box-footer -->
					</div>
				</form:form>
				</section>
			</div>
		</div><!-- /.box -->
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/pdata/pdata.js"></script>
    
    <script type="text/javascript">
	    $(document).ready(function(){
	    	_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
	    	
	 		
	    	$("#tmDateInst").datepicker({ 
	    		 format : 'yyyy-mm-dd',
			        todayBtn : "linked",  
			        autoclose : true,  
			        todayHighlight : true,  
			 }).on('hide',function(e) {  
			     $('#machinefrom').data('bootstrapValidator').updateStatus('tmDateInst', 'NOT_VALIDATED',null).validateField('tmDateInst');  
			 }); 

    		$('#machinefrom').bootstrapValidator({
    			message: 'This value is not valid',   
   				feedbackIcons: {
 					valid: 'glyphicon glyphicon-ok',         
 					invalid: 'glyphicon glyphicon-remove',         
 					validating: 'glyphicon glyphicon-refresh'    
 				},
 				fields: {
 				tmTerminalId: {
					validators: {
						notEmpty: {
							message: '终端编号不能为空'                  
						},
				
						callback: {
							message: '终端编号已存在',
							callback: function () {
							var machineNo = $("#CpTrmmst").val();
							var res = true;
						    $.ajax({
								url: "${ctx}/machine/getMachineByNo",
								type: 'post',
								dataType: 'text',
								async: false,
								data: {machineNo: machineNo},
							 	success: function (data) {
									if (data == "existent") {
											res = false;
									}
								}
							});
								return res;
							}
				   		},
						
						stringLength: {
							min: 0,
							max: 8,
							message: '终端号码不能超过8位'       
						},
					}
 				}, 
 				
 				tmBrand: {
					validators: {
						notEmpty: {
							message: '品牌不能为空'
						}
					}
 				},
 				tmVersionNo: {
 					validators: {
 						notEmpty: {
							message: '版本不能为空'
						}
 					}
 				},
 				
 				tmDateInst: {
 					validators: {
 						notEmpty: {
							message: '安装日期不能为空'
						}
 					}
 				},
 			}
    	});
 			
    });
	    
	</script>
	
</body>
</html>
 