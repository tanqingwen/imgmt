<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/layer/skin/layer.css" />
		<title>场馆详情</title>
		<link rel="stylesheet" href="${assets }/css/venueAll.css" />
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
					<h1>场馆详情</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
						<li><a href="${ctx}/cpmeracc/merchantDataEntering">场馆录入</a></li>
						<li class="active"> 场馆详情</li>
					</ol>
				</section>
	
		<div class="container-fluid venueDataDetail">
			<div class="row">
				<div class="tip-img">
				<p>场馆详情</p>
				</div>
				<div class="content">
					<div class="main venueContent">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
						<form:form class="form-horizontal" id="theFormId2"  name="theFormId2"  modelAttribute="cpMeracc" method="post">
							<div class="form-line clearfix marginTop">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="venueNum">场馆号码：</label>
											<form:input class="form-control formConl line-input" id="mmMerchantNo" path="mmMerchantNo" disabled="true" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueName">场馆名称：</label>
											<form:input class="form-control formConl line-input" path="mmBizName" disabled="true" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix ">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="venueGrade">归属场馆等级：</label>
											<!--<input class="form-control formConl line-input" type="text" name="venueGrade" id="venueGrade" />-->
											<form:select class="venueGrade" path="mmPmtMode" id="mmPmtMode" disabled="true" style="width: 140px;">
												<form:option value="">请选择级别...</form:option>
		 									<%-- <form:option value="1">一级--欢乐大世界</form:option> --%>
		 									<form:option value="2">二级--场馆</form:option>
		 									<form:option value="3">三级 --子场馆</form:option>
											</form:select>
											<form:select style="width: 144px;"  class="venueGrade" id="mmChainAccno" disabled="true" path="mmChainAccno">
											</form:select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueAbb">场馆简称：</label>
											<form:input class="form-control formConl line-input" id="mmStmtName" path="mmStmtName" disabled="true"/>
										</div>
									</div>

								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">联系人名称：</label>
											<form:input class="form-control formConl line-input"  path="mmContactName" disabled="true" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNameE">英文名称：</label>
											<form:input class="form-control formConl line-input" path="mmSmellName" disabled="true" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueAdress">场馆地址：</label>
											<form:input class="form-control formConl line-input" path="mmPhyLine1" disabled="true"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueTel">场馆电话：</label>
											<form:input class="form-control formConl line-input" path="mmPhyTelno" disabled="true" />
										</div>
									</div>
								</div>
							</div>
							<%-- <div class="col-md-12">
								<div class="col-md-6 col-lg-6">
									<div class="form-group">
										<label class="labelWidth" >合约开始时间：</label>
										<div class="input-group groupDis groupDis1">
											<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
											<form:input  path="mmAgreementStartDate" class="form-control" disabled="true" />
										</div>
									</div>
								</div>
								<div class="col-md-6 col-lg-6">
									<div class="form-group">
										<label class="labelWidth" >合约到期时间：</label>
										<div class="input-group groupDis groupDis2">
											<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
											<form:input  class="form-control dateWidth" path="mmAgreementEndDate"  disabled="true" />
										</div>
									</div>
								</div>
							</div> --%>
							<div class="col-md-12  marginBottom">
								<a href="${ctx}/cpmeracc/venueDataEntering" class="form-a">&lt;返回</a>
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
		<script type="text/javascript">
		 
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
				url : "${ctx}/cpmeracc/search_mermst_Data",
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
	 		var mmOldAccNumber= "${mmOldAccNumber}";
	 		for(var i=0;i<document.getElementById("mmChainAccno").options.length;i++){
	 			var trimab1 = document.getElementById("mmChainAccno").options[i].value;
	 			if(trimab1==mmOldAccNumber){
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
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmLevelName @>--<@= evt.mmBizName@></option>
			<@ }); @>
		</script>
		<script src="${assets }/layer/layer.js"></script>
		
	</body>

</html>