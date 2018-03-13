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
		<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
		<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
		<link rel="stylesheet" href="${assets}/validator/css/css.css" />
		<link rel="stylesheet" href="${assets}/layer/skin/layer.css"/>
		<link rel="stylesheet" href="${assets}/gatesManagement/css/gatesManagement.css"/>
		<style>
.form-group .col-md-6:last-of-type label{
	width:13em;
}
.form-group .col-md-6:first-of-type label{
	width: 12em;
}
.col-lg-6{
	padding: 0 15px;
}
.form-group select{
	width:220px;
}
label{
	 height:40px;
    line-height:40px;
    vertical-align:top;
}
.input-group .input-group-addon{
	display:inline-block;
	background-color: rgb(238,238,238);
    border-radius: 4px 0 0 4px;
    border: lightblue 1px solid;
    border-right:none;
    float:left;
}
.form-group .input-group{
	display:inline-block;
}

</style>
		
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
						<li><a href="${ctx}/cpmermst/merchantPreserve">商户查询</a></li>
						<li class="active">商户详情</li>
					</ol>
				</section>
				<div class="container-fluid">
			<div class="row">
				<div class="tip-img">
					<p>商户详情</p>
				</div>
				<div class="content">
            <div class="main">
                <form:form id="thisForm" class="form-horizontal" action="${ctx}/cpmermst/merchantPreserve_view" modelAttribute="cpMermst" method="post">
                    <h3 style="border-bottom: 2px dashed #45a0e0;">商户信息</h3>
                   <div class="col-md-12">                 
                        <div class="col-md-6">
	                          <div class="form-group">
	                            <label>公司名称<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl"  id="mmBizName" path="mmBizName" disabled="true" />
	                         </div>
                         </div>
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>法人姓名<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl" path="mmPrincipal" id="mmPrincipal" disabled="true" />
	                        </div>
                         </div>
                    </div>
                    <div class="col-md-12">                   
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>品牌名称<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl" id="mmStmtName" path="mmStmtName" disabled="true" />
	                        </div>
                        </div>
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>法人身份证号<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl" path="mmPrincipalIdNo" id="mmPrincipalIdNo" disabled="true" />
	                        </div>
                        </div>
                    </div>
                    <div class="col-md-12">                   
                        <div class="col-md-6">
	                         <div class="form-group">
	                            <label>英文品牌：</label>
	                            <form:input class="form-control formConl" path="mmSmellName" id="mmSmellName" disabled="true" />
	                        </div>
                        </div>
                        <div class="col-md-6">
	                         <div class="form-group">
	                            <label>法人户籍地址<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl" path="mmPrincipalAddress" id="mmPrincipalAddress" disabled="true" />
	                        </div>
                        </div>
                    </div>
                     <div class="col-md-12">           
                        <div class="col-md-6">
	                         <div class="form-group">
	                            <label>营业执照有效期起始时间<i class="color-red">*</i>：</label>
	                            <div class="input-group">
		                             <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
		                            <form:input class="form-control formConl" disabled="true"  path="mmLicenseExpireBeginDate" id="mmLicenseExpireBeginDate" data-toggle="datepicker" style="width:170px;"/>
	                            </div>
	                          </div>
                        </div>
                        <div class="col-md-6 ">
	                         <div class="form-group">
	                            <label>营业执照有效期终止时间<i class="color-red">*</i>：</label>
	                            <div class="input-group ">
		                             <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
		                            <form:input class="form-control formConl" disabled="true" path="mmLicenseExpireEndDate" id="mmLicenseExpireEndDate" data-toggle="datepicker" style="width:170px;"/>
	                            </div>
	                        </div>
                        </div>
                    </div>
                    <div class="col-md-12">                
                    	<div class="col-md-6">
	                    	  <div class="form-group">
	                            <label>营业执照号<i class="color-red">*</i>：</label> 
	                            <form:input class="form-control formConl" path="mmBussinessLicense" id="mmBussinessLicense" disabled="true" />
	                        </div>
                        </div>
                        <div class="col-md-6">
	                          <div class="form-group">
	                            <label>联系人<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl" path="mmContactName" id="mmContactName" disabled="true" />
	                        </div>
                        </div>                       
                    </div>
                     <div class="col-md-12">                   
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>店长电话<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl"  path="mmMobTelno" id="mmMobTelno" disabled="true" />
	                        </div>
                        </div>
                    </div>
                    <!--<div class="clearfix"></div>-->
                    <h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">园区信息</h3>
                        <div class="col-md-12">                   
                        <div class="col-md-6">
	                         <div class="form-group">
	                            <label>商户号码：</label>
	                            <form:input class="form-control formConl" disabled="true"  id="mmMerchantNo"  path="mmMerchantNo" value="系统自动生成"/>
	                        </div>
                        </div>
                        <div class="col-md-6">
	                          <div class="form-group">
	                            <label>商户地址<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl"  disabled="true"  id="mmPhyLine1" path="mmPhyLine1" size="15" />
	                          </div>
                        </div>                   
                    </div>
                    <div class="col-md-12">                   
                   		 <div class="col-md-6">
	                   		 <div class="form-group">
	                            <label>合约开始时间：</label>
	                            <div class="input-group ">
	                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	                            <form:input type="text" path="mmAgreementStartDate" disabled="true"  id="mmAgreementStartDate" class="form-control" data-toggle="datepicker" style="width:170px;"/>
	                            </div>
	                        </div>
                         </div>
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>合约到期时间：</label>
	                            <div class="input-group ">
	                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	                                <form:input id="mmAgreementEndDate"  path="mmAgreementEndDate" class="form-control" disabled="true"  data-toggle="datepicker" style="width:170px;"/>
	                            </div>
	                        </div>
                        </div>
                    </div>
                  <div class="col-md-12">            
                        <div class="col-md-6">
	                         <div class="form-group">
	                            <label>归属场馆<i class="color-red">*</i>：</label>
	                            <form:select path="mmPmtMode" id="mmPmtMode" style="width:220px;" disabled="true" >
	                                <form:option value="0">请选择级别...</form:option>
			 						<form:option value="1">一级-欢乐大世界</form:option>
			 						<form:option value="2">二级-场馆</form:option>
			 						<form:option value="3">三级-子场馆</form:option>
	                            </form:select>
	                          	
	                         </div>
                        </div>
                        <div class="col-md-6">
	                         <div class="form-group">
	                        	 <label>归属场馆名称<i class="color-red">*</i>：</label>
	                        	<form:select id="mmChainAccno" path="mmChainAccno" style="width:220px;" disabled="true" ></form:select>
	                        </div>
                        </div>
                    </div>
                    <h3 style="border-bottom: 2px dashed #f7ab00;" class="clearfix">支付信息</h3>
                    <div class="col-md-12">                    
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>收款单位<i class="color-red">*</i>：</label>
	                             <form:select path="mmServicingCentre" id="mmServicingCentre" class="form-control" style="width:220px;" disabled="true" >
	                                <c:forEach var="item" items="${cpBrchIdList}">
	 									<form:option value="${item.brBranchId }">${item.brBranchName }</form:option>
	 								</c:forEach>
	                            </form:select>
	                         </div>
                        </div>
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>账户名称<i class="color-red">*</i>：</label>
	                           <form:input class="form-control formConl" type="text" path="mmRegName" id="mmRegName" disabled="true" />
	                        </div>
                        </div>
                    </div>
                    <div class="col-md-12">                   
                        <div class="col-md-6">
	                         <div class="form-group">
	                            <label>付款类型<i class="color-red">*</i>：</label>
	                            <form:select path="mmPmtFtyp" id="mmPmtFtyp" style="width:220px;" disabled="true" >
	                                <form:option value="D">D-每日</form:option>
									<form:option value="W">W-每周</form:option>
									<form:option value="M">M-每月</form:option>
	                            </form:select>
	                         </div>
                         </div>
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>收款账户所属地区<i class="color-red">*</i>：</label> 
	                            <form:input class="form-control formConl" type="text" path="mmPayBankCode" id="mmPayBankCode" disabled="true" />
	                        </div>
                        </div>
                    </div>
                    <div class="col-md-12">                  
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>公司银行账号<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl" id="mmBankAccno" path="mmBankAccno"  disabled="true" />
	                        </div>
                        </div>
                        <div class="col-md-6">
	                        <div class="form-group">
	                            <label>收款账户开户网点<i class="color-red">*</i>：</label>
	                            <form:input  class="form-control formConl" type="text" path="mmPayBranch" id="mmPayBranch" disabled="true"  />
	                        </div>
                        </div>
                    </div>
                     <div class="col-md-12">                   
                        <div class="col-md-6">
	                         <div class="form-group">
	                            <label>公司收款银行<i class="color-red">*</i>：</label>
	                            <form:input class="form-control formConl" path="mmBankName" id="mmBankName" disabled="true"  />
	                        </div>
                        </div>
                          <div class="col-md-6">
	                         <div class="form-group">
	                            <label>商户性质<i class="color-red">*</i>：</label>
	                          <%--   <form:input class="form-control formConl" path="mmBankName" id="mmBankName"/> --%>
		                          <form:select id="mmRegCapital" path="mmRegCapital" class="form-control formConl" style="width:220px;" disabled="true">
		                         		<form:option value="">请选择商户性质</form:option>
			                          	<form:option value="1">自营</form:option>
			                          	<form:option value="2">租赁</form:option>
		                          </form:select>
	                        </div>
                        </div>
                    </div>
                    <div class="submit-group col-md-12 marginBottom">
                        <a href="${ctx}/cpmermst/merchantPreserve" class="form-a">&lt;返回</a>
                    </div>
                </form:form>

            </div>
        </div>
		</div>
		</div>

		<input type="hidden" value="3" id="test" />
		<script type="text/javascript" src="${assets}/venuePreserve/js/jquery-3.1.1.min.js"></script>
		<script src="${assets}/venuePreserve/js/layer.js"></script>
			</div>
			</div>
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  	  <!-- ./wrapper -->
    
		<tags:load_common_js/>
		<script src="${assets}/underscore/underscore.min.js"></script>
	    <script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
		<script src="${assets}/validator/js/validator.js"></script>
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
		$(document).ready(function(){
			_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
			/* 
			$('.firstCommission').datepicker({
	   			format: 'yyyymmdd',
				autoclose: true
	   		}); */
			
			var mmPmtMode = $("#mmPmtMode").val();
	 		$.ajax({
	 			async: false,
				type : "POST",
				url : "${ctx}/cpmermst/search_mermst_Data1",
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
	 		//上级场馆编号
	 		var mmOldAccNumber= "${mmChainAccno}";
	 		for(var i=0;i<document.getElementById("mmChainAccno").options.length;i++){
	 			var trimab1 = document.getElementById("mmChainAccno").options[i].value;
	 			if(trimab1==mmOldAccNumber){
	 				document.getElementById("mmChainAccno").options[i].selected='selected';
	 				break;
	 			}
	 		}
		});
		</script>
		
		<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmMerchantNo @> -- <@= evt.mmBizName@></option>
			<@ }); @>
		</script>
		
	</body>
</html>
