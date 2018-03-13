<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统| 商户更新</title>
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			<tags:main_sidebar active="venuemerent"/>
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<section class="content-header">
					<h1>商户更新</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx}/staff/merchantDataEntering">商户录入</a></li>
						<li class="active">商户更新</li>
					</ol>
				</section>
				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
					<div class="row">
						<div class="col-md-12">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-edit"></i> 更新表单</h3>
								</div>

        <!-- Main content -->
                <form:form id="thisForm" name="thisForm" class="form-horizontal" action="${ctx}/staff/submitForMerchantEnteringUpdate" modelAttribute="cpMeracc" method="post">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">商户号码</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px" id="mmMerchantNo" readonly="true" class="form-control" path="mmMerchantNo"/></th>
								     	<input type="hidden" id="mmPhyState" name="mmPhyState" value="1"> 
								    </div>
								</div>
								
								<!--  
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">商户别名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px" id="mmDbaName" class="form-control" path="mmDbaName"/></th>
								    </div>
								</div>
								-->
	                			
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">归属场馆等级<font color="red">*</font></label>
								    <div class="col-sm-3">
								     	<form:select style="width: 160px"  path="mmPmtMode" id="mmPmtMode" class="form-control">
								     		<form:option value="0">请选择级别...</form:option>
		 									<form:option value="1">一级-欢乐大世界</form:option>
		 									<form:option value="2">二级-场馆</form:option>
		 									<form:option value="3">三级-子场馆</form:option>
		 								</form:select>
								    </div>
								    <form:select style="width: 160px"  class="form-control" id="mmChainAccno" path="mmChainAccno"></form:select>
								</div>
								
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">联系人名称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="60" style="width: 353px"  class="form-control" path="mmContactName"/></th>
								    </div>
								</div>
	                			
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">商户地址<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" id="mmPhyLine1" class="form-control" path="mmPhyLine1"/></th>
								    </div>
								</div>
	                		
	                			<!--  
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户地址2</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" path="mmPhyLine2"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">联系人名称</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" path="mmContactName"/></th>
								    </div>
								</div>
								-->
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">合约开始时间<font color="red">*</font></label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input id="mmAgreementStartDate" readonly="true" class="form-control" path="mmAgreementStartDate" style="width: 240px"/></th>
									    </div>
								    </div>
								</div>
								
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">合约到期时间<font color="red">*</font></label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input id="mmAgreementEndDate" readonly="true" class="form-control" path="mmAgreementEndDate" style="width: 240px"/></th>
									    </div>
								    </div>
								</div>
								<div class="form-group">
								    <label class="col-sm-4 control-label">营业执照号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px" maxlength="18" class="form-control" path="mmBussinessLicense"/></th>
								    </div>
								</div>
								
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">营业执照有效期起始时间<font color="red">*</font></label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input readonly="true" class="form-control" path="mmLicenseExpireBeginDate" style="width: 240px"/></th>
									    </div>
								    </div>
								</div>
								
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">营业执照有效期终止时间<font color="red">*</font></label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input readonly="true" class="form-control" path="mmLicenseExpireEndDate" style="width: 240px"/></th>
									    </div>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">法人姓名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" path="mmPrincipal"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">法人身份证号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" path="mmPrincipalIdNo"/></th>
								    </div>
								</div>		
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
<!--     第二列		 -->
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户名称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  id="mmBizName" class="form-control" path="mmBizName"/></th>
								    </div>
								</div>
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户简称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  id="mmStmtName" class="form-control" path="mmStmtName"/></th>
								    </div>
								</div>								
								<div class="form-group">
								    <label class="col-sm-4 control-label">英文名称<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px" class="form-control" path="mmSmellName"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户电话<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" path="mmPhyTelno"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户电邮<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" path="mmEmailAddress" id="mmEmailAddress"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">收单单位<font color="red">*</font></label>
								    <div class="col-sm-8">
								     	<form:select style="width: 353px"  path="mmServicingCentre" class="form-control">
			 								<c:forEach var="item" items="${cpBrchIdList}">
			 									<form:option value="${item.brBranchId }">${item.brBranchName }</form:option>
			 								</c:forEach>
		 								</form:select>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">付款类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								       <form:select style="width: 353px"  class="form-control" path="mmPmtFtyp">
											<form:option value="D">D-每日</form:option>
											<form:option value="W">W-每周</form:option>
											<form:option value="M">M-每月</form:option>
										</form:select>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户持卡人姓名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" path="mmPmtName"/></th>
								    </div>
								</div>
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户银行帐号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input maxlength="40" style="width: 353px"  class="form-control" path="mmBankAccno" onkeyup="this.value=this.value.replace(/\D/g,'').replace(/....(?!$)/g,'$& ')"/></th>
								    </div> 
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户收款银行<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" path="mmBankName"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">法人户籍地址<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" path="mmPrincipalAddress"/></th>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					
					<div class="box-footer">
						<div class="pull-right">
							<button  type="submit" id="theIdForSubmit" class="btn btn-info"><i class="fa fa-save"></i> 更新</button>
	                    	<a type="button" class="btn btn-default" id="cancleSubmit"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
                		</div>
					</div>
			</form:form>
					
			</div>
			</div>
			</div>
			</section>
			</div>
			</div>
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
		<tags:load_common_js/>
		<script src="${assets}/datepicker/datepicker.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
	    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
	    $(function() {
	        var dataPickerOp = {
	            format: 'yyyy-mm-dd',
	            weekStart: 1,
	            startDate: new Date(),
	            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
	            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
	            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
	            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
	            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
	            autoHide: true
	        };
	        var dataPickerOp2 = {
		            format: 'yyyy-mm-dd',
		            weekStart: 1,
		            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
		            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
		            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
		            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
		            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
		            autoHide: true,
		           
		        };
	        //营业执照时间
	        $('#mmLicenseExpireBeginDate').datepicker(dataPickerOp);
	        $('#mmLicenseExpireEndDate').datepicker(dataPickerOp2);
	        $('#mmLicenseExpireBeginDate').change(function(){
	        	$('#mmLicenseExpireEndDate').datepicker('setStartDate', $(this).val());
	        })
	        $('#mmLicenseExpireEndDate').change(function(){
	        	$('#mmLicenseExpireBeginDate').datepicker('setEndDate', $(this).val());
	        })
	        
	        
	        $('#mmAgreementStartDate').datepicker(dataPickerOp);
	        $('#mmAgreementEndDate').datepicker(dataPickerOp2);
	        $('#mmAgreementStartDate').change(function(){
	        	$('#mmAgreementEndDate').datepicker('setStartDate', $(this).val());
	        })
	        $('#mmAgreementEndDate').change(function(){
	        	$('#mmAgreementStartDate').datepicker('setEndDate', $(this).val());
	        })
	    });
		validatorFields();
		function validatorFields(){
			$('#thisForm').bootstrapValidator({
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
								message: '商户名称不能为空！'                  
							},
						}
	 				}, 
	 				mmStmtName: {
						validators: {
							notEmpty: {
								message: '商户简称不能为空！'                  
							},
						}
	 				},
	 				mmContactName: {
						validators: {
							notEmpty: {
								message: '联系人名称不能为空！'                  
							},
						}
	 				}, 
	 				mmSmellName: {
						validators: {
							notEmpty: {
								message: '英文名称不能为空！'                  
							},
						}
	 				}, 
	 				mmPhyLine1: {
						validators: {
							notEmpty: {
								message: '商户地址不能为空！'                  
							},
						}
	 				}, 
	 				mmPhyTelno: {
						validators: {
							notEmpty: {
								message: '商户电话不能为空！'                  
							},
						}
	 				}, 
	 				mmAgreementStartDate: {
						validators: {
							notEmpty: {
								message: '合约开始时间不能为空！'                  
							},
						}
	 				}, 
	 				mmEmailAddress: {
						validators: {
							notEmpty: {
								message: '商户电邮不能为空！'                  
							},
						}
	 				}, 
	 				mmAgreementEndDate: {
						validators: {
							notEmpty: {
								message: '合约到期时间不能为空！'                  
							},
						}
	 				}, 
	 				mmServicingCentre: {
						validators: {
							notEmpty: {
								message: '收单单位不能为空！'                  
							},
						}
	 				}, 
	 				mmBussinessLicense: {
						validators: {
							notEmpty: {
								message: '营业执照号码不能为空!'                  
							},
						}
	 				}, 
	 				mmPmtFtyp: {
						validators: {
							notEmpty: {
								message: '付款类型不能为空！'                  
							},
						}
	 				},
	 				mmLicenseExpireBeginDate: {
						validators: {
							notEmpty: {
								message: '营业执照有效期起始时间不能为空！'                  
							},
						}
	 				},
	 				mmPmtName: {
						validators: {
							notEmpty: {
								message: '商户持卡人姓名不能为空！'                  
							},
						}
	 				},
	 				mmLicenseExpireEndDate: {
						validators: {
							notEmpty: {
								message: '营业执照有效期终止时间不能为空！'                  
							},
						}
	 				},
	 				mmBankAccno: {
						validators: {
							notEmpty: {
								message: '商户银行账号不能为空！'                  
							},
						}
	 				},
	 				mmPrincipal: {
						validators: {
							notEmpty: {
								message: '法人姓名不能为空！'                  
							},
						}
	 				},
	 				mmBankName: {
						validators: {
							notEmpty: {
								message: '商户收款银行不能为空！'                  
							},
						}
	 				},
	 				mmPrincipalIdNo: {
						validators: {
							notEmpty: {
								message: '法人身份证号码不能为空！'                  
							},
						}
	 				},
	 				mmPrincipalAddress: {
						validators: {
							notEmpty: {
								message: '法人户籍地址不能为空！'                  
							},
						}
	 				},
	 			}
	    	});
		}
		
			$(document).ready(function(){
				_.templateSettings = {
						interpolate: /\<\@\=(.+?)\@\>/gim,
					    evaluate: /\<\@(.+?)\@\>/gim,
					    escape: /\<\@\-(.+?)\@\>/gim
				};
				var mmPmtMode = $("#mmPmtMode").val();
		 		$.ajax({
		 			async: false,
					type : "POST",
					url : "${ctx}/staff/search_mermst_Data1",
					dataType : "json",
					data : {
						mmPmtMode : mmPmtMode
					},
					success : function(data) {
						if (data.status == "OK") {
							mmChainAccno = data.value;
							$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));
						}else{
							alert("归属场馆错误");
						}
					}
				});
			    //返回
				$("#cancleSubmit").click(function(){
					location.href="${ctx}/staff/merchantDataEntering";
				});
				// 更新
				$("#theIdForSubmit").click(function(){
					
					var mmChainAccno = $("#mmChainAccno").val();
					if(mmChainAccno==null){
						alert("归属场馆不存在,请添加归属场馆!");
						return false;
					}
					//商户电邮
					var mmEmailAddress=$("#mmEmailAddress").val();
					var fal = email(mmEmailAddress);
					if(fal==false){
						alert("商户电邮有误，请重新输入!");
						return false;
					}
					
					//法人身份证号码
					var mmPrincipalIdNo=$("#mmPrincipalIdNo").val();
					var flag = idno(mmPrincipalIdNo);
					if(flag==false){
						alert("法人身份证号码有误，请重新输入！");
						return false;
					}
					
				});
				
				 //选择场馆等级 - 跳动归属场馆
				 $("#mmPmtMode").change(function(){
					 var mmPmtMode = $("#mmPmtMode").val();
			 		 $.ajax({
						type : "POST",
						url : "${ctx}/staff/search_mermst_Data1",
						dataType : "json",
						data : {
							mmPmtMode : mmPmtMode
						},
						success : function(data) {
							if (data.status == "OK") {
								mmChainAccno = data.value;
								$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(), mmChainAccno));
							}else{
								alert("归属场馆错误");
							}
						}
					});
				});
				 
			});	 
		</script>
		
		<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmBizName@></option>
			<@ }); @>
		</script>
	</body>
</html>
