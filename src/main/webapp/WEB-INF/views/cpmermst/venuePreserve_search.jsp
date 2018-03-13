<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统| 场馆详情</title>
		<tags:head_common_content/>
		<link rel="stylesheet" type="text/css" href="${assets}/venue/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${assets}/venue/css/layer.css" />
		<link rel="stylesheet" href="${assets}/venue/css/venueAll.css" />
		<link rel="stylesheet" href="${assets}/venue/css/datepicker.min.css" />
	
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
					<h1>场馆详情</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx}/staff/merchantDataEntering">场馆查询</a></li>
						<li class="active">场馆详情</li>
					</ol>
				</section>
				<!-- Main content -->
				<div class="container-fluid">
				<div class="row">
				<div class="tip-img">
					 <p>场馆详情</p>
				</div>
				<div class="content">
					<div class="main venueContent">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						<form:form class="form-horizontal" id="theFormId2"  name="theFormId2"  modelAttribute="cpMermst" method="post">
							<div class="form-line clearfix marginTop">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNum">场馆号码：</label>
											<form:input id="mmMerchantNo" disabled="true" class="form-control line-input" onkeyup="this.value=this.value.replace(/\s/g,'')" path="mmMerchantNo"/>
								      		<form:hidden  id="mmPhyState2" disabled="true" class="form-control"  path="mmPhyState"/>
								      		<input type="hidden" id="mmOldAccNumber" name="mmOldAccNumber" value="${mmOldAccNumber}" >
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueName">场馆名称：</label>
											<form:input id="mmBizName" disabled="true"  class="form-control line-input" path="mmBizName"/>
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueGrade">归属场馆等级：</label>
											<!--<input class="form-control formConl line-input" type="text" name="venueGrade" id="venueGrade" />-->
											<form:select  path="mmPmtMode" id="mmPmtMode" class="form-control line-input" disabled="true" style="width:140px;">
		 									<form:option value="0">请选择级别...</form:option>
		 									<%-- <form:option value="1">一级--欢乐大世界</form:option> --%>
		 									<form:option value="1">一级--场馆</form:option>
		 									<form:option value="2">二级--场馆</form:option>
		 									<form:option value="3">三级--子场馆</form:option>
		 								</form:select>
		 								<form:select style="width: 140px;"
												class="venueGrade form-control line-input" id="mmChainAccno"
												path="mmChainAccno" disabled="true"></form:select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueAbb">场馆简称：</label>
											<form:input id="mmStmtName" disabled="true"  class="form-control line-input" path="mmStmtName"/>
										</div>
									</div>

								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">联系人名称：</label>
											 <form:input class="form-control line-input" disabled="true"  path="mmContactName"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNameE">英文名称：</label>
											<form:input  class="form-control line-input"  disabled="true" path="mmSmellName"/>
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueAdress">场馆地址：</label>
											<form:input  id="mmPhyLine1"  disabled="true"  class="form-control line-input" path="mmPhyLine1"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueTel">场馆电话：</label>
											<form:input  class="form-control line-input" disabled="true"  path="mmPhyTelno" />
										</div>
									</div>
								</div>
							</div>
							<%-- <div class="form-group">
								<div class="col-md-6">
									<label class="labelWidth" style="margin-left: 15px;">合约开始时间：</label>
									<div class="input-group groupDis groupDis1">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<form:input id="mmAgreementStartDate" disabled="true" class="form-control line-input" path="mmAgreementStartDate"/>
									</div>
								</div>
								<div class="col-md-6">
									<label class="labelWidth" style="margin-left: -10px;">合约到期时间：</label>
									<div class="input-group groupDis groupDis2">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<!-- <input type="text" class="form-control dateWidth" data-toggle="datepicker"> -->
										<form:input id="mmAgreementEndDate" disabled="true" class="form-control dateWidth" path="mmAgreementEndDate" />
									</div>
								</div>
							</div> --%>
							<div class="col-md-12  marginBottom">
								<a href="${ctx}/cpmermst/venuePreserve" class="form-a">&lt;返回</a>
							</div>

					</form:form>
					</div>

				</div>
			</div>
		</div>
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
		<script type="text/javascript">
	/* 	日期  */
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
			
			$('.firstCommission').datepicker({
	   			format: 'yyyymmdd',
				autoclose: true
	   		});
			
			//var mmPmtMode = $("#mmPmtMode").val();
			var mmPmtMode = ${mmPmtMode};
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
							if(mmPmtMode=="0" || mmPmtMode=="1" || mmPmtMode=="2"){
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
	 		
			//上级场馆编号
	 		var mmOldAccNumber= $("#mmOldAccNumber").val();
	 		for(var i=0;i<document.getElementById("mmChainAccno").options.length;i++){
	 			var trimab1 = document.getElementById("mmChainAccno").options[i].text;
	 			var str2=trimab1.substring(trimab1.indexOf("--")+2,trimab1.lastIndexOf("--"));
	 			if(str2==mmOldAccNumber){
	 				document.getElementById("mmChainAccno").options[i].selected='selected';
	 				break;
	 			}
	 		}
	 		
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
