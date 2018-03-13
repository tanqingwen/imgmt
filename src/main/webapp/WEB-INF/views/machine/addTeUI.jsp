<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>终端新增</title>
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/model.css" />
		<link rel="stylesheet" href="${assets }/css/siteManagement.css">
		<link rel="stylesheet" href="${assets }/css/datepicker.min.css">
		<style>
	
			.has-feedback label~.form-control-feedback{
				top:4px;
			}
			.form-horizontal .has-feedback .form-control-feedback{
			  	right:50px;
			}
			
		</style>
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
	
	
		<div class="container-fluid venue-entry">
			<div class="row outer-wrap">
				<div class="tip-img">
					<p>终端新增</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">添加列表</h3>
						<form:form action="${ctx}/machine/addTe" modelAttribute="cpPosprm" method="post" id="machinefrom" name="machinefrom" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-6">
									<label>终端编号：</label>
									<input class="form-control formConl" type="text" readonly="readonly" id="tmTerminalId" name="tmTerminalId" value="${tmTerminalId}"/>
									<input type="hidden" class="form-control" id="tmEdcSerial" name="tmEdcSerial" value="1"/>
									<input type="hidden" class="form-control" id="tmUseState" name="tmUseState" value="1"/>
								</div>
								<div class="col-md-6">
									<label>商户号码：</label>
									<input class="form-control formConl" type="text"id="tmMerchantId" name="tmMerchantId"  readonly="readonly"	value="${merchantId}"  />

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>终端品牌<i class="color-red">*</i>：</label>
									<select id="tmBrand"  name="tmBrand">
										<option value="">-----请选择品牌------</option>
										     	 <c:forEach var="cpPosprm" items="${cpPosprmList}" >
										      	 	<option value="${cpPosprm.ppBrand}" >${cpPosprm.ppBrand}</option>
										      	</c:forEach>
									</select>
								</div>
								<div class="col-md-6">
									<label>安装日期<i class="color-red">*</i>：</label>
									<div class="input-group groupDis">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input type="text" class="form-control" id="tmDateInst" name="tmDateInst" data-toggle="datepicker">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>终端版本<i class="color-red">*</i>：</label>
									<select id="tmVersionNo"  name="tmVersionNo">
										<option value="" >-----请选择版本------</option>
								      	<option value="1.0" >-----1.0-----</option>
								      	<option value="2.0">-----2.0-----</option>
									</select>

								</div>
								<div class="col-md-6">
									<label>设备序号：</label>
									<input class="form-control formConl" type="text" id="tmEdcPrinterNo" name="tmEdcPrinterNo"/>

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>终端名称：<i class="color-red">*</i>：</label>
									<input class="form-control formConl" type="text" id="tmDateCanx" name="tmDateCanx"/>
								</div>
								<div class="col-md-6">
									<label>终端IP：</label>
									<input class="form-control formConl" type="text" id="tmHostSerial" name="tmHostSerial"/>
								</div>
							</div>
							

							<!--<div class="clearfix"></div>-->

							<div class="col-lg-12 submit-group">
								<a href="javascript:window.history.back(-1)" class="form-a">&lt;返回</a>
								<button  type="submit" class="btn-size fr" style="width:110px;margin:0 25px 0 15px;color:#fff;" id="memberShip">添加</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
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
		<script src="${assets }/js/datepicker.min.js"></script>
		<script language="javascript">
			$(function() {
				var dataPickerOp = {
					format: 'yyyy/mm/dd',
					weekStart: 1,
					days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
					daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
					daysMin: ['日', '一', '二', '三', '四', '五', '六'],
					months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
					monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
					autoHide: true
				};
				$('[data-toggle="datepicker"]').datepicker(dataPickerOp)
			});
		</script>
	</body>

</html>