<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统| 商户详情</title>
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
					<h1>商户详情</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx}/staff/merchantDataEntering">商户查询</a></li>
						<li class="active">商户详情</li>
					</ol>
				</section>
				<!-- Main content -->
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>
								</div>

        <!-- Main content -->
<!--         <section class="content"> -->
<!--           	<div class="box box-primary"> -->
                <form:form class="form-horizontal" id="theFormId"  name="theFormId"  modelAttribute="cpMermst" method="post">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">商户号码</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  id="mmMerchantNo" readonly="true" class="form-control" onkeyup="this.value=this.value.replace(/\s/g,'')" path="mmMerchantNo"/>
								      <form:hidden style="width: 353px"  id="mmPhyState" readonly="true" class="form-control"  path="mmPhyState"/></th>
								    </div>
								</div>
								<!--  
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">商户别名</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  id="mmDbaName"  readonly="true"  class="form-control" path="mmDbaName"/></th>
								    </div>
								</div>
								-->
								
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">归属场馆等级</label>
								    <div class="col-sm-3">
								     	<form:select style="width: 160px;"  path="mmPmtMode" id="mmPmtMode" readonly="true"  class="form-control">
								     		<form:option value="0">请选择级别...</form:option>
		 									<form:option value="1">一级-欢乐大世界</form:option>
		 									<form:option value="2">二级-场馆</form:option>
		 									<form:option value="3">三级-子场馆</form:option>
		 								</form:select>
								    </div>
								    <form:select style="width: 160px;"  class="form-control" readonly="true" id="mmChainAccno" path="mmChainAccno"></form:select>
								</div>
	                			
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">联系人名称</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmContactName"/></th>
								    </div>
								</div>
								
	                			
	                			<div class="form-group">
								    <label class="col-sm-4 control-label">商户地址</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  id="mmPhyLine1"  readonly="true"  class="form-control" path="mmPhyLine1"/></th>
								    </div>
								</div>
								<!-- 
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户地址2</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control"  readonly="true" path="mmPhyLine2"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">联系人名称</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmContactName"/></th>
								    </div>
								</div>
								-->
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">合约开始时间</label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input id="mmAgreementStartDate" readonly="true" class="form-control" path="mmAgreementStartDate" style="width: 313px"/></th>
									    </div>
								    </div>
								</div>
								
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">合约到期时间</label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input id="mmAgreementEndDate" readonly="true" class="form-control" path="mmAgreementEndDate" style="width: 313px"/></th>
									    </div>
								    </div>
								</div>
								
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">营业执照号码</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" readonly="true"  path="mmBussinessLicense"/></th>
								    </div>
								</div>
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">营业执照有效期起始时间</label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input readonly="true" class="form-control" path="mmLicenseExpireBeginDate" style="width: 313px"/></th>
									    </div>
								    </div>
								</div>
								
								<div class="form-group date firstCommission">
								    <label class="col-sm-4 control-label">营业执照有效期终止时间</label>
									  <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
									       <form:input readonly="true" class="form-control" path="mmLicenseExpireEndDate" style="width: 313px"/></th>
									    </div>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">法人姓名</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmPrincipal"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">法人身份证号码</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control"  readonly="true" path="mmPrincipalIdNo"/></th>
								    </div>
								</div>
								
								<!-- 
								<div class="form-group">
								    <label class="col-sm-4 control-label">通知标志</label>
								    <div class="col-sm-8">
										<form:select style="width: 353px"  class="form-control"  readonly="true" path="mmGlInd3">
											<form:option value="0">是</form:option>
											<form:option value="1">否</form:option>
										</form:select>
								    </div>
								</div>
								
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">费用账号</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control"  readonly="true" path="mmFeeAccno"/></th>
								    </div>
								</div>
								<div class="form-group">
								    <label class="col-sm-4 control-label">风险保证金帐号</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmCorrLine4"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">回佣折扣代码(MCC)</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmDiscCode"/></th>
								    </div>
								</div>
								
								-->
								
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
<!--     第二列		 -->
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户名称</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  id="mmBizName" readonly="true"  class="form-control" path="mmBizName"/></th>
								    </div>
								</div>
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户简称</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  id="mmStmtName" readonly="true"  class="form-control" path="mmStmtName"/></th>
								    </div>
								</div>
								<!-- 
								<div class="form-group">
								    <label class="col-sm-4 control-label">路由</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmPhyPostalCd"/></th>
								    </div>
								</div>
								-->
								
								<!--  
								<div class="form-group">
								    <label for="mmChainAccno" class="col-sm-4 control-label">归属场馆</label>
								    <div class="col-sm-8">
								    	<form:select style="width: 353px"  class="form-control" readonly="true" id="mmChainAccno" path="mmChainAccno"></form:select>
								    </div>
								</div>
								-->
								<div class="form-group">
								    <label class="col-sm-4 control-label">英文名称</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control"  readonly="true" path="mmSmellName"/></th>
								    </div>
								</div>
								
								
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户电话</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" readonly="true"  path="mmPhyTelno"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户电邮</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" readonly="true"  path="mmEmailAddress"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">收单单位</label>
								    <div class="col-sm-8">
								     	<form:select style="width: 353px"  path="mmServicingCentre"  readonly="true" class="form-control">
			 								<c:forEach var="item" items="${cpBrchIdList}">
			 									<form:option value="${item.brBranchId }">${item.brBranchName }</form:option>
			 								</c:forEach>
		 								</form:select>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">付款类型</label>
								    <div class="col-sm-8">
								       <form:select style="width: 353px"  class="form-control" readonly="true"  path="mmPmtFtyp">
											<form:option value="D">D-每日</form:option>
											<form:option value="W">W-每周</form:option>
											<form:option value="M">M-每月</form:option>
										</form:select>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户持卡人姓名</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" readonly="true"  path="mmPmtName"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户银行帐号</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmBankAccno"/></th>
								    </div>
								</div>
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">商户收款银行</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmBankName"/></th>
								    </div>
								</div>
								
								
								
								<!--  
								<div class="form-group">
								    <label class="col-sm-4 control-label">组织机构代码证编号</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true"  path="mmOrganiCodeNumber"/></th>
								    </div>
								</div>
								
								
								<div class="form-group">
								    <label class="col-sm-4 control-label">付款频率</label>
								    <div class="col-sm-8">
								      <form:input  style="width: 353px" class="form-control" readonly="true" path="mmPmtFreq"/></th>
								    </div>
								</div>
								-->
								
								<!-- 
								<div class="form-group">
								    <label class="col-sm-4 control-label">税务登记证号码</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control" readonly="true"  path="mmTaxNumber"/></th>
								    </div>
								</div>
								-->
								
								 <div class="form-group">
								    <label class="col-sm-4 control-label">法人户籍地址</label>
								    <div class="col-sm-8">
								      <form:input style="width: 353px"  class="form-control"  readonly="true" path="mmPrincipalAddress"/></th>
								    </div>
								</div>
								
                			</div>
                		</div>
					</div>
					
					<div class="box-footer">
						<a  class="btn  btn-default  pull-right" href="${ctx}/staff/merchantPreserve"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
		<script src="${assets}/underscore/underscore.min.js"></script>
		<script src="${assets}/datepicker/datepicker.js"></script>
		<script src="${assets}/datepicker/locales/zh-CN.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
	    <script src="${assets}/moment/moment.min.js"></script>
	    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
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
		</script>
		
		<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
			<@ }); @>
		</script>
		
	</body>
</html>
