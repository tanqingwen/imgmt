<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>综合管理系统 | 闸机新增</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/layer/skin/layer.css" />
<link rel="stylesheet"
	href="${assets}/gatesManagement/css/datepicker.min.css" />
<link rel="stylesheet" href="${assets }/css/model.css" />
<link rel="stylesheet" href="${assets }/css/siteManagement.css">


<style>
.has-feedback label ~.form-control-feedback {
	top: 4px;
}

.form-horizontal .has-feedback .form-control-feedback {
	right: 50px;
}

.help-block {
	float: right;
	margin-right: 40px;
}
.venue-entry .form-group .input-group {
	display: inline-block;
}
.venue-entry .input-group{
	top:0;
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
				<h1>闸机添加</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
					<li><a href="${ctx }/trmmstgate/list">闸机管理</a></li>
					<li><a href="${ctx }/trmmstgate/viewlist/${merchantId }">闸机列表</a></li>
					<li class="active">闸机添加</li>
				</ol>
			</section>

			<div class="container-fluid venue-entry">
				<div class="row outer-wrap">
					<div class="tip-img">
						<p>闸机添加</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">添加列表</h3>
							<form:form action="${ctx}/machine/add" modelAttribute="cpPosprm"
								method="post" id="machinefrom" name="machinefrom"
								class="form-horizontal">
								<div class="col-md-12">								  
									<div class="col-md-6">
										<div class="form-group">
											<label>闸机编号：</label> <input class="form-control formConl"
												type="text" readonly="readonly" id="tmTerminalId"
												name="tmTerminalId" value="${tmTerminalId}" /> <input
												type="hidden" class="form-control" id="tmEdcSerial"
												name="tmEdcSerial" value="0" /> <input type="hidden"
												class="form-control" id="tmUseState" name="tmUseState"
												value="1" /> <input type="hidden" class="form-control"
												id="tmIswatch" name="tmIswatch" value="${mmPmtMode}" /> <input
												type="hidden" class="form-control" id="tmMerchantId"
												name="tmMerchantId" value="${merchantId}" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>闸机IP：</label> <select id="tmHostSerial"
												name="tmHostSerial">
												<option value="">-----请选择闸机IP------</option>
												<c:forEach var="cpGateip" items="${gateIpList}">
													<option value="${cpGateip.gaIp}">${cpGateip.gaIp}</option>
												</c:forEach>
											</select>
	
										</div>
									</div>
								</div>
								<div class="col-md-12" >
									<div class="col-md-6">
										<div class="form-group">
											<label>闸机品牌<i class="color-red">*</i>：
											</label> <select id="tmBrand" name="tmBrand">
												<option value="">-----请选择品牌------</option>
												<c:forEach var="cpPosprm" items="${cpPosprmList}">
													<option value="${cpPosprm.ppBrand}">${cpPosprm.ppBrand}</option>
												</c:forEach>
											</select>
										</div>
								   </div>
									<div class="col-md-6">
										<div class="form-group">
											<label>闸机名称：</label>
											 <input class="form-control formConl" type="text" id="tmDateCanx" name="tmDateCanx" value="${item.tmDateCanx}"/>
										</div>
										<!-- <label>安装日期<i class="color-red">*</i>：</label>
									<div class="input-group ">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input type="text" id="tmDateInst" name="tmDateInst" class="form-control" data-toggle="datepicker">
									</div> -->
									</div>
								</div>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>闸机版本<i class="color-red">*</i>：
											</label> <select id="tmVersionNo" name="tmVersionNo">
												<option value="">-----请选择版本------</option>
												<option value="1.0">-----1.0-----</option>
												<option value="2.0">-----2.0-----</option>
											</select>
	
										</div>
									</div>	
									<div class="col-md-6">
										<div class="form-group">
											<label>设备序号：</label> <input class="form-control formConl"
												type="text" id="tmEdcPrinterNo" name="tmEdcPrinterNo" />
	
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>闸机进出类型<i class="color-red">*</i>：
											</label> <select id="tmMcTermType" name="tmMcTermType">
												<option value="1">入馆闸机</option>
												<option value="2">出馆闸机</option>
												<option value="0">不限出入类型闸机</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group" style="margin-bottom:0;">
											<label style="height: 40px;line-height: 40px; vertical-align: top;">安装日期<i class="color-red" >*</i>：
											</label>
											<div class="input-group ">
												<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													 <input class="form-control formConl"  id="tmDateInst" name="tmDateInst" path="tmDateInst" data-toggle="datepicker"
													style="width: 200px;" />
											</div>
										</div>
								</div>


								<!--<div class="clearfix"></div>-->

								<div class="col-lg-12 submit-group">
									<a href="${ctx }/trmmstgate/viewlist/${merchantId }"
										class="form-a">&lt;返回</a>
									<button type="submit" class="btn-size fr"
										style="width: 110px; margin: 0 25px 0 15px; color:#fff;" id="addButton">添加</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.box -->
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/underscore/underscore.min.js"></script>
	<%-- 	<script src="${assets}/datepicker/locales/date.js"></script> --%>
	<%-- 	<script src="${assets}/datepicker/locales/zh-CN.js"></script> --%>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/pdata/pdata.js"></script>
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script type="text/javascript">
    var dataPickerOp = {
            format: 'yyyy-mm-dd',
            weekStart: 1,
            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            autoHide: true
        };
   $('#tmDateInst').datepicker(dataPickerOp);
    $('#tmDateInst').change(function(){
    	$('#machinefrom').data('bootstrapValidator')  //时间提示错误后重新输入提示正确
        .updateStatus('tmDateInst', 'NOT_VALIDATED',null)  
        .validateField('tmDateInst'); 
    
    })  
	    $(document).ready(function(){
	    	_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
	    	
	 		
	    	/*  $("#tmDateInst").datepicker({ 
	    		 format : 'yyyy-mm-dd',
			        todayBtn : "linked",  
			        autoclose : true,  
			        todayHighlight : true,  
			 }).on('hide',function(e) {  
			     $('#machinefrom').data('bootstrapValidator').updateStatus('tmDateInst', 'NOT_VALIDATED',null).validateField('tmDateInst');  
			 });  */

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
							message: '闸机编号不能为空'                  
						},
				
						callback: {
							message: '闸机编号已存在',
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
							message: '闸机号码不能超过8位'       
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
 				tmHostSerial: {
 					validators: {
 						notEmpty: {
							message: '闸机IP不能为空'
						}
 					}
 				},
 				tmEdcPrinterNo:{
 					validators: {
 						notEmpty: {
							message: '设备序号不能为空'
						}
 					}
 				},
 				tmMcTermType:{
 					validators: {
 						notEmpty: {
							message: '闸机进出类型不能为空'
						}
 					}
 				}
 				
 			}
    	});
 			
    });
	     
	    
	</script>

	<script language="javascript">
			
		$(function() {
			var dataPickerOp = {
				format : 'yyyy-mm-dd',
				weekStart : 1,
				days : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
				daysShort : [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
				daysMin : [ '日', '一', '二', '三', '四', '五', '六' ],
				months : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				monthsShort : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
						'9月', '10月', '11月', '12月' ],
				autoHide : true
			};
			$('#tmDateInst').datepicker(dataPickerOp);
			$('#tmDateInst').change(
					function() {
						$('#machinefrom').data('bootstrapValidator') //时间提示错误后重新输入提示正确
						.updateStatus('tmDateInst', 'NOT_VALIDATED', null)
								.validateField('tmDateInst');

					})
		})
	</script> 
</body>

</html>