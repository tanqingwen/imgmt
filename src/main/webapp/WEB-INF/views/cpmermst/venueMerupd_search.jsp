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
		<link rel="stylesheet" type="text/css" href="${assets }/weihu/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${assets }/weihu/css/layer.css" />
		<title>场馆详情</title>
		<link rel="stylesheet" href="${assets }/weihu/css/datepicker.min.css" />
		<link rel="stylesheet" href="${assets }/weihu/css/venueMaintenance5.css" />
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
		<style type="text/css">
		#mmPmtMode{
		height: 40px;
    	border: lightblue 1px solid;
    	border-radius: 5px;
    	outline: none;
    	color: lightslategray;
    	text-indent: 5px;
    	font-weight: 500;
    	display: inline-block;
    	font-size: 14px;
    	padding: 1px 0;
    	margin-left: 8px;
		}
		</style>
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
						<li><a href="${ctx }/cpmermst/vmerupdPreserve">场馆维护</a></li>
						<li><a href="${ctx }/cpmermst/searchVmermstWaitAuth">场馆维护</a></li>
						<li class="active">场馆详情</li>
					</ol>
				</section>
				<!-- Main content -->
				<div class="container-fluid venueMaintenance">
				<div class="row">
					<div class="tip-img venueMaintenance">
						 <p>场馆详情</p>  
					</div>
					<div class="content">
						<div class="main venueContent">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form:form id="theFormId2"  name="theFormId2"  modelAttribute="cpMerupd" method="post" class="form-horizontal">
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueNum">场馆号码：</label>
												<form:input id="mmMerchantNo" readonly="true" 
													class="form-control line-input" path="mmMerchantNo" />
												<input type="hidden" id="mmServicingCentre"
													name="mmServicingCentre" value="${cpBrchId}"> <input
													type="hidden" id="mmPhyState" name="mmPhyState" value="0">
												<input type="hidden" id="mmOldAccNumber"
													name="mmOldAccNumber" value="${mmOldAccNumber}">
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueName">场馆名称<i class="color-red">*</i>：
												</label>
												<form:input id="mmBizName" class="form-control line-input"
													path="mmBizName" readonly="true"/>
												
											</div>
										</div>
									</div>
								</div>
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="venueGrade">场馆归属等级<i class="color-red">*</i>：
											</label>
											<!-- <select style="width: 140px;" path="mmPmtMode" 
												id="mmPmtMode" class="venueGrade" disabled="disabled">
												<option value="0">请选择级别...</option>
												<option value="1">一级--欢乐大世界</option>
												<option value="2">二级--场馆</option>
												<option value="3">三级--子场馆</option>
											</select> -->
<%-- 											<form:select style="width: 140px;" path="mmPmtMode" readonly="true"
												id="mmPmtMode" disabled="disabled" class="venueGrade">
												<form:option value="0">请选择级别...</form:option>
												<form:option value="1">一级--欢乐大世界</form:option>
												<form:option value="2">二级--场馆</form:option>
												<form:option value="3">三级--子场馆</form:option>
											</form:select> --%>
											<form:input style="width: 140px;" path="mmPmtMode" readonly="true"
												id="mmPmtMode" disabled="disabled" class="venueGrade"></form:input>
											<select style="width: 140px;" class="venueGrade" id="mmChainAccno" path="mmChainAccno"   disabled="disabled"></select>
										</div>
									</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueAbb">场馆简称<i class="color-red">*</i>：
												</label>
												<form:input id="mmStmtName" class="form-control formConl line-input"
													path="mmStmtName" readonly="true"/>
												
											</div>
										</div>

									</div>
								</div>
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="">联系人名称<i class="color-red">*</i>：
												</label>
												<form:input class="form-control line-input"
													path="mmContactName" readonly="true"/>
												
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueNameE">英文名称<i class="color-red">*</i>：
												</label>

												<form:input class="form-control line-input"
													path="mmSmellName" readonly="true"/>
												
											</div>
										</div>
									</div>
								</div>
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueAdress">场馆地址<i class="color-red">*</i>：
												</label>
												<form:input id="mmPhyLine1" class="form-control line-input"
													path="mmPhyLine1" readonly="true"/>
												
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueTel">场馆电话<i class="color-red">*</i>：
												</label>
												<form:input class="form-control line-input"
													path="mmPhyTelno" readonly="true"/>
												
											</div>
										</div>
									</div>
								</div>
								<%-- <div class="form-group">
									<div class="col-md-6">
										<label class="labelWidth" style="margin-left: 15px;">合约开始时间<i
											class="color-red">*</i>：
										</label>
										<div class="input-group groupDis groupDis1">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											<form:input id="mmAgreementStartDate" readonly="true"
												class="form-control" path="mmAgreementStartDate"  />
										</div>
									</div>
									<div class="col-md-6">
										<label class="labelWidth" style="margin-left: -10px;">合约到期时间<i
											class="color-red">*</i>：
										</label>
										<div class="input-group groupDis groupDis2">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											<form:input id="mmAgreementEndDate" readonly="true"
												class="form-control" path="mmAgreementEndDate" />
											
										</div>
									</div>
								</div> --%>
								<div class="col-md-12  marginBottom">
									<a href="${ctx }/cpmermst/searchVmermstWaitAuth" class="form-a" onclick="cancleSubmit()">&lt;返回</a>
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
		<script src="${assets}/datepicker/datepicker.js"></script>
		<script src="${assets}/underscore/underscore.min.js"></script>
		<script type="text/javascript">
		$("#cancelBack").click(function(){
			var mmMerchantNo1 = document.theFormId2.mmMerchantNo1.value;
			//location.href="${ctx}/staff/searchVmermstWaitAuth?mmMerchantNo="+mmMerchantNo1;
			location.href="${ctx}/cpmermst/searchVmermstWaitAuth";
		});
		/* $("#mmPmtMode").attr({disabled:true,respondly:true}); */
		
		$(document).ready(function(){
			_.templateSettings = {
					interpolate: /\<\@\=(.+?)\@\>/gim,
				    evaluate: /\<\@(.+?)\@\>/gim,
				    escape: /\<\@\-(.+?)\@\>/gim
			};
			
	/* 	$("#mmChainAccno").attr('disabled','true'); */
		
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
		function cancleSubmit() {
			location.href = "${ctx}/cpmermst/searchVmermstWaitAuth";
		}
		$("#mmPmtMode").val(Venuelevel($('#mmPmtMode').val()));
	 	function Venuelevel(str){
	 		if(str=='1'){
	 			return '一级--欢乐大世界';
	 		}else if(str=='2'){
	 			return '二级--场馆';
	 		}else if(str=='3'){
	 			return '三级--子场馆';
	 		}
	 	}	
		</script>
		
		
		<script type="text/template" id="tplMmChainAccno0">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="1">默认--欢乐大世界</option>
			<@ }); @>
		</script>
		
		<script type="text/template" id="tplMmChainAccno">
	 		<@ _.each(mmChainAccno, function (evt) { @>
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmLevelName @>--<@= evt.mmMerchantNo @>--<@= evt.mmBizName@></option>
			<@ }); @>
		</script>
	</body>
</html>
