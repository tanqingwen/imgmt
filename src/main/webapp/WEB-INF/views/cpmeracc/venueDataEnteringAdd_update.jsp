<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/layer/skin/layer.css" />
<title>场馆更新</title>
<link rel="stylesheet" href="${assets}/validator/css/css.css" />
<link rel="stylesheet"
	href="${assets}/gatesManagement/css/gatesManagement.css" />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />
		<tags:main_sidebar active="venuemerent" />
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<section class="content-header">
				<h1>场馆更新</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx}/cpmeracc/venueDataEntering">场馆录入</a></li>
					<li class="active">场馆更新</li>
				</ol>
			</section>
			<div class="container-fluid venueAddNew">
				<div class="row">
					<div class="tip-img">
						<p>场馆更新</p>
					</div>
					<div class="content">
						<div class="main venueContent public">
							<h3 style="border-bottom: 2px dashed #45a0e0;">更新表单</h3>
							<form:form id="thisForm" name="thisForm" class="form-horizontal "
								action="${ctx}/cpmeracc/submitForVenueEnteringUpdate"
								modelAttribute="cpMeracc" method="post">

								<div class="col-md-12 clearfix ">
									<div class="col-md-6 col-sm-6">
										<div class="form-group ">
											<label for="venueNum" class="">场馆号码：</label>
											<form:input class="form-control formConl line-input"
												id="mmMerchantNo" readonly="true" path="mmMerchantNo" />
											<input type="hidden" id="mmPhyState" name="mmPhyState"
												value="0"> <input type="hidden"
												id="mmServicingCentre" name="mmServicingCentre"
												value="${cpBrchId}"> <input type="hidden"
												id="mmOldAccNumber" name="mmOldAccNumber"
												value="${mmOldAccNumber}">
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueName">场馆名称：</label>
											<form:input class="form-control formConl line-input "
												id="mmBizName" path="mmBizName" />
										</div>
									</div>
								</div>


								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueGrade">归属场馆等级：</label>
											<!--<input class="form-control formConl line-input" type="text" name="venueGrade" id="venueGrade" />-->
											<form:select class="venueGrade" style="width: 140px;"
												path="mmPmtMode" id="mmPmtMode" disabled="disabled">
												<form:option value="">请选择级别...</form:option>
												<%-- <form:option value="1">一级--欢乐大世界</form:option> --%>
												<form:option value="2">二级--场馆</form:option>
												<form:option value="3">三级--子场馆</form:option>
											</form:select>
											<form:select style="width: 140px; margin-left:10px;"
												class="venueGrade" id="mmChainAccno" path="mmChainAccno"></form:select>

										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueAbb">场馆简称：</label>
											<form:input class="form-control formConl line-input"
												id="mmStmtName" path="mmStmtName" />
										</div>
									</div>

								</div>


								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="">联系人名称：</label>
											<form:input class="form-control formConl line-input"
												path="mmContactName" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNameE">英文名称：</label>
											<form:input class="form-control formConl line-input"
												path="mmSmellName" />
										</div>
									</div>
								</div>


								<div class="col-lg-12 col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueAdress">场馆地址：</label>
											<form:input class="form-control formConl line-input"
												id="mmPhyLine1" path="mmPhyLine1" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueTel">场馆电话：</label>
											<form:input class="form-control formConl line-input"
												path="mmPhyTelno" />
										</div>
									</div>
								</div>

								<%-- <div class="col-md-12">
								 <div class="col-md-6">
									   <div class="form-group">
				                            <label>合约开始时间：</label>
					                            <div class="input-group">
					                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					                                <form:input id="mmAgreementStartDate"  path="mmAgreementStartDate" class="form-control line-input" data-toggle="datepicker" style="width:240px;" />
					                            </div>
				                        </div>
                        		 </div>
								<div class="col-md-6">
								 	<div class="form-group">
			                            <label>合约到期时间：</label>
				                            <div class="input-group line-input" >
				                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                                <form:input  id="mmAgreementEndDate" path="mmAgreementEndDate" class="form-control line-input" data-toggle="datepicker" style="width:240px;"/>
				                            </div>
                        			</div>
								</div>
							</div> --%>
								<div class="col-md-12  marginBottom">
									<a href="${ctx }/cpmeracc/venueDataEntering" id="cancleSubmit1"
										class="form-a">&lt;返回</a>
									<button type="submit" id="theIdForSubmit"
										class="btn venueBtn btn-size fr">更新</button>
								</div>
							</form:form>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->
	<tags:load_common_js />
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/layer/layer.js"></script>
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script type="text/javascript">
		validatorFields();
		function validatorFields() {
			$('#thisForm')
					.bootstrapValidator(
							{
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									mmBizName : {
										validators : {
											notEmpty : {
												message : '场馆名称不能为空！'
											},

										}
									},
									mmPmtMode : {
										validators : {
											notEmpty : {
												message : '归属场馆等级不能为空！'
											},

										}
									},
									mmStmtName : {
										validators : {
											notEmpty : {
												message : '场馆简称不能为空！'
											},

										}
									},
									mmSmellName : {
										validators : {
											notEmpty : {
												message : '英文名称不能为空！'
											},
											regexp: {
					                            regexp: /^[A-Za-z ]+$/,
					                            message: '请输入正确的英文名称'
					                        }

										}
									},
									mmContactName : {
										validators : {
											notEmpty : {
												message : '联系人名称不能为空！'
											},

										}
									},

									mmPhyLine1 : {
										validators : {
											notEmpty : {
												message : '场馆地址不能为空！'
											},

										}
									},
									mmPhyTelno : {
										validators : {
											notEmpty : {
												message : '场馆电话不能为空！'
											},
											regexp : {
												regexp : "^(0\\d{2,3}-\\d{7,8}(-\\d{3,5}){0,1})|(((13[0-9])|(17[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})$",
												message : '电话格式错误，例如：0371-/021-'
											}

										}
									},
									mmAgreementStartDate : {
										validators : {
											notEmpty : {
												message : '合约开始时间不能为空!'
											},
										}
									},
									mmAgreementEndDate : {
										validators : {
											notEmpty : {
												message : '合约到期时间不能为空！'
											},

										}
									},
								}
							});
		}

		$(document)
				.ready(
						function() {
							_.templateSettings = {
								interpolate : /\<\@\=(.+?)\@\>/gim,
								evaluate : /\<\@(.+?)\@\>/gim,
								escape : /\<\@\-(.+?)\@\>/gim
							};

							var mmPmtMode = $("#mmPmtMode").val();
							$
									.ajax({
										async : false,
										type : "POST",
										url : "${ctx}/cpmeracc/search_mermst_Data",
										dataType : "json",
										data : {
											mmPmtMode : mmPmtMode
										},
										success : function(data) {
											if (data.status == "OK") {
												
												mmChainAccno = data.value;
												if (mmChainAccno == "") {
													mmChainAccno = "1";
													if (mmPmtMode == "0"
															|| mmPmtMode == "1" || mmPmtMode == "2") {
														$("#mmChainAccno")
																.html(_.template($("#tplMmChainAccno0").html(),mmChainAccno));
													} else {
														$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(),mmChainAccno));
													}
												} else {
													$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(),mmChainAccno));
												}

											} else {
												alert("归属场馆错误");
											}
										}
									});

							//上级场馆编号
							var mmOldAccNumber = $("#mmOldAccNumber").val();
							for (var i = 0; i < document
									.getElementById("mmChainAccno").options.length; i++) {
								var trimab1 = document
										.getElementById("mmChainAccno").options[i].value;
								if (trimab1 == mmOldAccNumber) {
									document.getElementById("mmChainAccno").options[i].selected = 'selected';
									break;
								}
							}

							$("#cancleSubmit1")
									.click(
											function() {
												location.href = "${ctx}/cpmeracc/venueDataEntering";
											});
							$("#theIdForSubmit").click(
									function() {
										//场馆等级
										/* var mmPmtMode = $("#mmPmtMode").val();
										if (mmPmtMode == "0") {
											alert("请选择场馆等级!");
											return false;
										}
										var mmChainAccno = $("#mmChainAccno")
												.val();
										if (mmChainAccno == "") {
											alert("上级场馆不存在,请添加上级场馆!");
											return false;
										} */

										//上级场馆号获取
										var trimab = $("#mmChainAccno").find(
												"option:selected").val();
										var str2 = trimab.substring(trimab
												.indexOf("--") + 2, trimab
												.lastIndexOf("--"));
										$("#mmOldAccNumber").val(trimab);
									});

						});

		//选择场馆等级 - 跳动归属场馆
		$("#mmPmtMode")
				.change(
						function() {
							var mmPmtMode = $("#mmPmtMode").val();
							$
									.ajax({
										type : "POST",
										url : "${ctx}/cpmeracc/search_mermst_Data",
										dataType : "json",
										data : {
											mmPmtMode : mmPmtMode
										},
										success : function(data) {
											if (data.status == "OK") {
												mmChainAccno = data.value;
												if (mmChainAccno == "") {
													mmChainAccno = "1";
													if (mmPmtMode == "0"
															|| mmPmtMode == "1") {
														$("#mmChainAccno").html(_.template($("#tplMmChainAccno0").html(),mmChainAccno));
													} else {
														$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(),mmChainAccno));
													}
												} else {
													$("#mmChainAccno").html(_.template($("#tplMmChainAccno").html(),mmChainAccno));
												}
											} else {
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
					<option value="<@= evt.mmMerchantNo @>"><@= evt.mmLevelName @>--<@= evt.mmBizName@></option>
					<%--
					<option value="<@= evt.mmPmtMode @>" <@= (ac === evt.mmMerchantNo ? 'selected="selected"' : null) @>>evt.mmLevelName @>--<@= evt.mmMerchantNo @>--<@= evt.mmBizName@></option>
				--%>	
			<@ }); @>
		</script>

</body>

</html>