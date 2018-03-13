<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统| 场馆添加</title>
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			<tags:main_sidebar active="staff"/>
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<section class="content-header">
					<h1>场馆添加</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx}/staff/merchantDataEntering">场馆录入</a></li>
						<li class="active">场馆添加</li>
					</ol>
				</section>
				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
					<div class="row">
						<div class="col-md-12">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
									<div align="center">
										<c:if test="${errorMessage != null}">
											<h4><span style="color:red">${errorMessage}</span></h4>
										</c:if>
									</div>
								</div>

       			<!-- Main content -->
          	
			 <form:form id="thisForm2" name="thisForm2" class="form-horizontal" action="${ctx}/staff/submitForVenueEnteringAdd" modelAttribute="cpMeracc" method="post">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">场馆号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="15" style="width: 353px" id="mmMerchantNo" class="form-control" readonly="true" path="mmMerchantNo" value="系统自动生成" /></th>
								       <input type="hidden" id="mmPhyState" name="mmPhyState" value="0">
								       <input type="hidden" id="mmServicingCentre" name="mmServicingCentre" value="${cpBrchId}">
								       <input type="hidden" id="mmOldAccNumber" name="mmOldAccNumber" value="">
								    </div>
								</div>
								
								<!--  
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">场馆别名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="150" style="width: 353px" id="mmDbaName" class="form-control" path="mmDbaName"/></th>
								    </div>
								</div>
								-->
	                			
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">归属场馆等级<font color="red">*</font></label>
								    <div class="col-sm-3">
								     	<form:select style="width: 160px;"  path="mmPmtMode" id="mmPmtMode" class="form-control">
		 									<form:option value="0">请选择级别...</form:option>
		 									<form:option value="1">一级--欢乐大世界</form:option>
		 									<form:option value="2">二级--场馆</form:option>
		 									<form:option value="3">三级--子场馆</form:option>
		 								</form:select>
								    </div>
								    <form:select style="width: 160px;"  class="form-control" id="mmChainAccno" path="mmChainAccno"></form:select>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">联系人名称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="60" style="width: 353px"  class="form-control" path="mmContactName"/></th>
								    </div>
								</div>
	                			
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">场馆地址<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input  maxlength="40"  style="width: 353px" id="mmPhyLine1" class="form-control" path="mmPhyLine1"/></th>
								    </div>
								</div>
								
								<!--  
								<div class="form-group">
								    <label class="col-sm-4 control-label">场馆地址2</label>
								    <div class="col-sm-8">
								      <form:input maxlength="40" style="width: 353px"  class="form-control" path="mmPhyLine2"/></th>
								    </div>
								</div>
								-->
								
								
								<div class="form-group date ">
								    <label class="col-sm-4 control-label">合约开始时间<font color="red">*</font></label>
									  <div class="col-sm-7">
									    <div class="input-group date ">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input id="mmAgreementStartDate2" readonly="true" class="form-control" path="mmAgreementStartDate" style="width: 313px"/></th>
									    </div>
								    </div>
								</div>
								
								
								<!--  
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">合约续签日期</label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input readonly="true" class="form-control" path="mmAgreemPreSubsDate" style="width: 313px"/></th>
									    </div>
								    </div>
								</div>
								-->
								
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
<!--     第二列		 -->
								<div class="form-group">
								    <label class="col-sm-4 control-label">场馆名称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="150" style="width: 353px"  id="mmBizName" class="form-control" path="mmBizName"/></th>
								    </div>
								</div>
								<div class="form-group">
								    <label class="col-sm-4 control-label">场馆简称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="30" style="width: 353px"  id="mmStmtName" class="form-control" path="mmStmtName"/></th>
								    </div>
								</div>
								
								<!--  
								<div class="form-group">
								    <label for="mmChainAccno" class="col-sm-4 control-label">上级场馆<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<form:select style="width: 353px"  class="form-control" id="mmChainAccno" path="mmChainAccno"></form:select>
								    </div>
								</div>
								-->
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">英文名称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="80" style="width: 353px" class="form-control" path="mmSmellName"/></th>
								    </div>
								</div>
								
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">场馆电话<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="25" style="width: 353px"  class="form-control" path="mmPhyTelno" id="mmPhyTelno" /></th>
								    </div>
								</div>
								
								<!--  
								<div class="form-group">
								    <label class="col-sm-4 control-label">场馆电邮<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="60" style="width: 353px"  class="form-control" path="mmEmailAddress" id="mmEmailAddress" /></th>
								    </div>
								</div>
								-->
								
								<div class="form-group date">
								    <label class="col-sm-4 control-label">合约到期时间<font color="red">*</font></label>
									  <div class="col-sm-7">
									    <div class="input-group date">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input id="mmAgreementEndDate2" readonly="true" class="form-control" path="mmAgreementEndDate" style="width: 313px"/></th>
									    </div>
								    </div>
								</div>
								
                			</div>
                		</div>
					</div>
					
					<div class="box-footer">
						<div class="pull-right">
							<button  type="submit" id="addButton" class="btn btn-info"><i class="fa fa-plus"></i> 添加</button>
	                    	<a type="button" class="btn btn-default" href="${ctx}/staff/venueDataEntering"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
                		</div>
					</div>
					
			</form:form>
			</div>
			</div>
			</div><!-- box box-primary -->
			</section><!-- content -->
			</div><!-- content-wrapper -->
			</div><!-- wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
		<tags:load_common_js/>
		<script src="${assets}/underscore/underscore.min.js"></script>
		<script src="${assets}/datepicker/datepicker.js"></script>
		<script src="${assets}/datepicker/locales/zh-CN.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
		<script type="text/javascript">
		validatorFields();
		function validatorFields(){
			$('#thisForm2').bootstrapValidator({
	    		message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				mmBizName: {
						validators: {
							notEmpty: {
								message: '场馆名称不能为空！'                  
							},
							
						}
	 				}, 
	 				mmPmtMode: {
						validators: {
							notEmpty: {
								message: '归属场馆等级不能为空！'                  
							},
							
						}
	 				}, 
	 				mmStmtName: {
						validators: {
							notEmpty: {
								message: '场馆简称不能为空！'                  
							},
						}
	 				},
	 				mmStmtName: {
						validators: {
							notEmpty: {
								message: '联系人名称不能为空！'                  
							},
						}
	 				},
	 				mmStmtName: {
						validators: {
							notEmpty: {
								message: '英文名称不能为空！'                  
							},
						}
	 				},
	 				mmStmtName: {
						validators: {
							notEmpty: {
								message: '场馆地址不能为空！'                  
							},
						}
	 				},
	 				mmPhyLine1: {
						validators: {
							notEmpty: {
								message: '场馆电话不能为空！'                  
							},
							
						}
	 				},
	 				mmAgreementStartDate2: {
						validators: {
							notEmpty: {
								message: '合约开始时间不能为空!'                  
							},
						}
	 				}, 
	 				mmAgreementEndDate2: {
						validators: {
							notEmpty: {
								message: '合约到期时间不能为空！'                  
							},
							
						}
	 				},
	 			}
	    	});
		}
			
		function validateInput(){
			$("#mmSmellName").keyup(function(){
				if($("#mmSmellName").val().length > 3){
				}
					
			});
		}
		
		$(document).ready(function(){
			_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
			
			
			$('.firstCommission').datepicker({
	   			format: 'yyyymmdd',
				autoclose: true
	   		});
			
			
			var mmPmtMode = $("#mmPmtMode").val();
	 		$.ajax({
	 			async: false,
				type : "POST",
				url : "${ctx}/staff/search_mermst_Data",
				dataType : "json",
				data : {
					mmPmtMode : mmPmtMode
				},
				success : function(data) {
					if (data.status == "OK") {
						mmChainAccno = data.value;
						if(mmChainAccno==""){
							mmChainAccno="1";
							if(mmPmtMode=="0" || mmPmtMode=="1"){
								$("#mmChainAccno").html(_.template($("#tplMmChainAccno0").html(), mmChainAccno));
							}else{
								$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));	
							}
						}else{
							$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));
						}
							
					}else{
						alert("归属场馆错误");
					}
				}
			});
	 		
	 		 //合约开始时间
			 $("#mmAgreementStartDate2").datepicker({  
			        todayBtn : "linked",  
			        autoclose : true,  
			        todayHighlight : true,  
			    }).on('hide',function(e) {  
			                $('#thisForm2').data('bootstrapValidator')  
			                    .updateStatus('mmAgreementStartDate2', 'NOT_VALIDATED',null)  
			                    .validateField('mmAgreementStartDate2');
			 });  
			 
		    $("#mmAgreementStartDate").datepicker({  
		        todayBtn : "linked",  
		        autoclose : true,  
		        todayHighlight : true,  
		    }).on('hide',function(e) {  
		                $('#thisForm2').data('bootstrapValidator')  
		                    .updateStatus('mmAgreementStartDate', 'NOT_VALIDATED',null)  
		                    .validateField('mmAgreementStartDate');
		    });
		    
		    //合约到期时间
		    $("#mmAgreementEndDate2").datepicker({  
		        todayBtn : "linked",  
		        autoclose : true,  
		        todayHighlight : true,  
		    }).on('hide',function(e) {  
		                $('#thisForm2').data('bootstrapValidator')  
		                    .updateStatus('mmAgreementEndDate2', 'NOT_VALIDATED',null)  
		                    .validateField('mmAgreementEndDate2');  
		    });
		    
		    $("#mmAgreementEndDate").datepicker({  
		        todayBtn : "linked",  
		        autoclose : true,  
		        todayHighlight : true,  
		    }).on('hide',function(e) {  
		                $('#thisForm2').data('bootstrapValidator')  
		                    .updateStatus('mmAgreementEndDate', 'NOT_VALIDATED',null)  
		                    .validateField('mmAgreementEndDate');  
		    });  
			
			
			$("#mmAgreementStartDate").change(function(){
				if($("#mmAgreementStartDate").val() != ""){
					var arr = new Array();
					arr = $("#mmAgreementStartDate").val().split("/");
					var newDate = arr[2]+arr[0]+arr[1];
					$("#mmAgreementStartDate").val(newDate);
				}
			});
			
			$("#mmAgreementStartDate2").change(function(){
				if($("#mmAgreementStartDate2").val() != ""){
					var arr = new Array();
					arr = $("#mmAgreementStartDate2").val().split("/");
					var newDate = arr[2]+arr[0]+arr[1];
					$("#mmAgreementStartDate2").val(newDate);
				}
			});
		
			$("#mmAgreementEndDate").change(function(){
				if($("#mmAgreementEndDate").val() != ""){
					var arr = new Array();
					arr = $("#mmAgreementEndDate").val().split("/");
					var newDate = arr[2]+arr[0]+arr[1];
					$("#mmAgreementEndDate").val(newDate);
				}
			});
			
			$("#mmAgreementEndDate2").change(function(){
				if($("#mmAgreementEndDate2").val() != ""){
					var arr = new Array();
					arr = $("#mmAgreementEndDate2").val().split("/");
					var newDate = arr[2]+arr[0]+arr[1];
					$("#mmAgreementEndDate2").val(newDate);
				}
			});
				
			
			//添加校验
			$("#addButton").click(function(){
				//场馆等级
				var mmPmtMode = $("#mmPmtMode").val();
				if(mmPmtMode=="0"){
					alert("请选择场馆等级!");
					return false;
				}
				var mmChainAccno= $("#mmChainAccno").val();
				if(mmChainAccno==""){
					alert("上级场馆不存在,请添加上级场馆!");
					return false;
				}

				//上级场馆号获取
				var trimab = $("#mmChainAccno").find("option:selected").text();
				var str2=trimab.substring(trimab.indexOf("--")+2,trimab.lastIndexOf("--"));
				$("#mmOldAccNumber").val(str2);
				
				var mmAgreementStartDate = $("#mmAgreementStartDate").val();
				var mmAgreementEndDate = $("#mmAgreementEndDate").val();
				if(mmAgreementStartDate != "" && mmAgreementEndDate != ""){
					if(Number(mmAgreementStartDate)>Number(mmAgreementEndDate)){
						alert("合约开始时间不可以大于合约结束时间！");
						return false;
					}
				}
			});
			
			validateInput();
		});		
		
		
		 //选择场馆等级 - 跳动归属场馆
		 $("#mmPmtMode").change(function(){
			 var mmPmtMode = $("#mmPmtMode").val();
			 
	 		 $.ajax({
				type : "POST",
				url : "${ctx}/staff/search_mermst_Data",
				dataType : "json",
				data : {
					mmPmtMode : mmPmtMode
				},
				success : function(data) {
					if (data.status == "OK") {
						mmChainAccno = data.value;
						if(mmChainAccno==""){
							mmChainAccno="1";
							if(mmPmtMode=="0" || mmPmtMode=="1"){
								$("#mmChainAccno").html(_.template($("#tplMmChainAccno0").html(), mmChainAccno));
							}else{
								$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));	
							}
						}else{
							$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));
						}
						
					}else{
						alert("归属场馆错误");
					}
				}
			});
	 		 
		 });
		 
		</script>
		
		<script type="text/template" id="tplMmChainAccno0">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="1">默认--欢乐大世界</option>
			<@ }); @>
		</script>
		
		<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmPmtMode @>"><@= evt.mmLevelName @>--<@= evt.mmMerchantNo @>--<@= evt.mmBizName@></option>
			<@ }); @>
		</script>
		
		
	</body>
</html>