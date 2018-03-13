<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 终端更新</title>
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
<tags:head_common_content />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="profile" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>终端更新</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">商户管理</a></li>
            		<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">商户列表</a></li>
            		<li><a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">终端列表</a></li>
					<li class="active">终端更新</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-plus"></i> 更新列表
						</h3>
					</div>
					 <!-- /.box-header -->
						<form:form action="${ctx}/machine/updateTe" modelAttribute="cpTrmacc" method="post" id="machinefrom" name="machinefrom" class="form-horizontal">
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="id" class="col-sm-3 control-label">终端编号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control"id="updateCpTrmmst" name="tmTerminalId" value="${item.tmTerminalId}" readonly="readonly" />
										</div>
									</div>
									 
									<div class="form-group">
											<label for="tmMerchantId" class="col-sm-3 control-label">商户号码</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="tmMerchantId" name="tmMerchantId" readonly="readonly" value="${item.tmMerchantId}"/>
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
									<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">场馆号码<font color="red">*</font></label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="tmMerchantId" name="tmMerchantId" value="${item.tmMerchantId}" disabled="disabled"/>
										</div>
									</div>
									-->
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">终端品牌<font color="red">*</font></label>
										<%-- <div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmBrand}"   />
										</div> --%>
										<div class="col-xs-8">
											<select class="form-control" id="tmBrand"  name="tmBrand" > 
										       <option value="" >-----请选择品牌------</option>
										      <c:forEach var="cpPosprm" items="${cpPosprmList}" >
										      	 <option value="${cpPosprm.ppBrand}" ${item.tmBrand == cpPosprm.ppBrand ? 'selected':''}>${cpPosprm.ppBrand}</option>
										      </c:forEach>
									      	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">终端版本<font color="red">*</font></label>
										<div class="col-xs-8">
										<select class="form-control" id="tmVersionNo"  name="tmVersionNo" > 
									       <option value="" >-----请选择版本------</option>
									      	 <option value="${item.tmVersionNo }" ${item.tmVersionNo == "1.0"? 'selected':'' }>-----1.0-----</option>
									      	 <option value="${item.tmVersionNo }" ${item.tmVersionNo == "2.0"? 'selected':'' }>-----2.0-----</option>
								      	</select>
								      	</div>
									</div>
									
									<!-- 
									<div class="form-group" id="gateIpdiv">
											<label for="gateIp1" class="col-sm-3 control-label">闸机IP</label>
											<div class="col-sm-8">
												 <input type="text" class="form-control" id="tmHostSerial" name="tmHostSerial" value="${item.tmHostSerial}" />
											</div>
									</div>
									-->
									<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">票价</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="tmGeog" name="tmGeog" value="${item.tmGeog}"   />
										</div>
									</div>
									-->
									
										<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">园区类型</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="tmModel" name="tmModel" value="${item.tmModel}"   />
										</div>
									</div>
									
									-->
	
									<!--  									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">闸机类型</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="tmDbaName" name="tmDbaName" value="${item.tmDbaName}"   />
										</div>
									</div>
									-->
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
									
									<!--  
									<div class="form-group">
										<label for="sKnot" class="col-xs-3 control-label">省份<font color="red">*</font></label>
										<div class="col-xs-8">
											<select  id="input_province" name="tmPhyState"  class="form-control">
												<option value="${item.tmPhyState}">${item.tmPhyState}</option>
											</select>
										</div>
									</div>
									
										<div class="form-group">
											<label for="sKnot" class="col-xs-3 control-label">城市<font color="red">*</font></label>
											<div class="col-xs-8">
												<select  id="input_city" name="tmPhyCity" class="form-control">
												<option value="${item.tmPhyCity}">${item.tmPhyCity}</option>
												</select>	
											</div>
								 		</div>
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">区域代码</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmRegionCd}"   />
											</div>
										</div>
										
										-->
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">终端状态</label>
											<div class="col-sm-8">
												<select class="form-control" id="tmStatus"  name="tmStatus" > 
											      	 <option value="1" ${item.tmStatus == '1' ? 'selected':''}>停用</option>
											      	 <option value="" ${item.tmStatus == "" ? 'selected':''}>正常 </option>
								      	 		</select>
											</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">安装日期<font color="red">*</font></label>
                                        	<div class="col-sm-8">
									    	<div class="input-group col-sm-12 date firstCommission">
												<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
												</span>
									       		<input type="text" id="tmDateInst" name="tmDateInst"  value="${item.tmDateInst}"  class="form-control"/>
									    	</div>
									   		</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">设备序号</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" id="tmEdcPrinterNo" name="tmEdcPrinterNo" value="${item.tmEdcPrinterNo}"/>
											</div>
										</div>
									
									</div>
									</div>
								</div>
							</div>
						<div class="box-footer">
							<div class="pull-right">
								<button  type="submit" id="addButton" class="btn btn-info"><i class="fa fa-save"></i> 更新</button>
		                    	<a type="button" class="btn btn-default" href="${ctx }/trmmstgate/viewTrmmstlist/${item.tmMerchantId}"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                		</div>
						</div>
	              	</form:form>
				</div>
	           </section>
             </div><!-- /.box-footer -->
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
    	 
    	 var tmIswatch = ${item.tmIswatch};
		 obj = document.getElementById("tmIswatch");
		 for(i=0;i<obj.length;i++){
		   if(obj[i].value == tmIswatch)
		     obj[i].selected = true;
		 } 
		 
		 
    	_.templateSettings = {
				interpolate: /\<\@\=(.+?)\@\>/gim,
			    evaluate: /\<\@(.+?)\@\>/gim,
			    escape: /\<\@\-(.+?)\@\>/gim
		};
    	
 		$.ajax({
 			async: false,
			type : "POST",
			url : "${ctx}/staff/search_mermst_Data1",
			dataType : "json",
			data : {
				tmIswatch : tmIswatch
			},
			success : function(data) {
				if (data.status == "OK") {
					tmMerchantId = data.value;
					$("#tmMerchantId").html(_.template($("#tplMmChainAccno").html(), tmMerchantId));
				}else{
					alert("归属场馆错误");
				}
			}
		});
    	
    	 $("#tmDateInst").datepicker({  
    		 format : 'yyyy-mm-dd',
				todayBtn: 'linked',
				todayHighlight:true,
				autoclose : true 
		    }).on('hide',function(e) {  
		                $('#machinefrom').data('bootstrapValidator')
		                .updateStatus('tmDateInst', 'NOT_VALIDATED',null)
		                .validateField('tmDateInst');  
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
							message: '终端ID不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 8,
							message: '商户号码不能超过8位'       
							},
					}
 				}, 
 				tmMerchantId: {
 					message: '商户号码无效',
					validators: {
						notEmpty: {
							message: '商户号码不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 15,
							message: '商户号码不能超过15位'       
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
    
    <script type="text/template" id="tplMmChainAccno">
	 	<@ _.each(tmMerchantId, function (evt) { @>
				<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
		<@ }); @>
	</script>
</body>
</html>
 