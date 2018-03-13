<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 场馆维护更新</title>
<tags:head_common_content />
<link rel="stylesheet" type="text/css"
	href="${assets }/weihu/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assets }/weihu/css/layer.css" />
<link rel="stylesheet" href="${assets }/weihu/css/venueMaintenance5.css" />
<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />
		<tags:main_sidebar active="staff" />
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<section class="content-header">
				<h1>场馆维护更新</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li><a href="${ctx }/staff/vmerupdPreserve">场馆维护</a></li>
					<li><a href="${ctx }/staff/searchVmermstResultList">场馆维护</a></li>
					<li class="active">场馆维护更新</li>
				</ol>
			</section>
			<!-- Main content -->
			<div class="container-fluid venueMaintenanceUpdate">
				<div class="row">
					<div class="tip-img ">
						<p>场馆维护更新</p>
					</div>
					<div class="content">
						<div class="main venueContent">
							<h3 style="border-bottom: 2px dashed #45a0e0;">场馆维护更新</h3>
							<form:form id="defaultForm" modelAttribute="cpMermst"
								method="post" name="defaultForm" class="form-horizontal"
								action="${ctx}/staff/submitForVenuePreserver_update">
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
													path="mmBizName" />
												
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
											<form:select style="width: 140px;" path="mmPmtMode"
												id="mmPmtMode" disabled="disabled" class="venueGrade">
												<form:option value="0">请选择级别...</form:option>
												<form:option value="1">一级--欢乐大世界</form:option>
												<form:option value="2">二级--场馆</form:option>
												<form:option value="3">三级--子场馆</form:option>
											</form:select>
											<form:select style="width: 140px;"
												class="venueGrade" id="mmChainAccno"
												path="mmChainAccno"></form:select>
										</div>
									</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueAbb">场馆简称<i class="color-red">*</i>：
												</label>
												<form:input id="mmStmtName" class="form-control formConl line-input"
													path="mmStmtName" />
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
													path="mmContactName" />
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueNameE">英文名称<i class="color-red">*</i>：
												</label>
												<form:input class="form-control line-input"
													path="mmSmellName" />
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
													path="mmPhyLine1" />
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="venueTel">场馆电话<i class="color-red">*</i>：
												</label>
												<form:input class="form-control line-input"
													path="mmPhyTelno" />
											</div>
										</div>
									</div>
								</div>
								<%-- <div class="form-group">
									<div class="col-md-6">
										<label class="labelWidth" style="margin-left: 15px;">合约开始时间<i
											class="color-red">*</i>：
										</label>
										<div class="input-group groupDis groupDis1 date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											<form:input id="mmAgreementStartDate" readonly="true"
												class="form-control" path="mmAgreementStartDate"  data-toggle="datepicker"/>
										</div>
									</div>
									<div class="col-md-6">
										<label class="labelWidth" style="margin-left: -10px;">合约到期时间<i
											class="color-red">*</i>：
										</label>
										<div class="input-group groupDis groupDis2 date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											<form:input id="mmAgreementEndDate" readonly="true"
												class="form-control" path="mmAgreementEndDate" data-toggle="datepicker"/>
										</div>
									</div>
								</div> --%>
								<div class="col-md-12  marginBottom">
									<a href="${ctx}/staff/vmerupd_page" class="form-a" onclick="cancleSubmit()">&lt;返回</a>
									<button class="btn btn-size fr" id="theIdForSubmit" type="submit">更新</button>
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
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
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
		function validatorFields() {
			$('#thisForm').bootstrapValidator({
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
								message : '场馆等级不能为空！'
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
					mmContactName : {
						validators : {
							notEmpty : {
								message : '联系人名称不能为空！'
							},

						}
					},
					mmSmellName : {
						validators : {
							notEmpty : {
								message : '英文名称不能为空！'
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
										url : "${ctx}/staff/search_mermst_Data",
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
														$("#mmChainAccno")
																.html(
																		_
																				.template(
																						$(
																								"#tplMmChainAccno0")
																								.html(),
																						mmChainAccno));
													} else {
														$("#mmChainAccno")
																.html(
																		_
																				.template(
																						$(
																								"#tplMmChainAccno")
																								.html(),
																						mmChainAccno));
													}
												} else {
													$("#mmChainAccno")
															.html(
																	_
																			.template(
																					$(
																							"#tplMmChainAccno")
																							.html(),
																					mmChainAccno));
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
										.getElementById("mmChainAccno").options[i].text;
								var str2 = trimab1.substring(trimab1
										.indexOf("--") + 2, trimab1
										.lastIndexOf("--"));
								if (str2 == mmOldAccNumber) {
									document.getElementById("mmChainAccno").options[i].selected = 'selected';
									break;
								}
							}

							$("#theIdForSubmit")
									.click(
											function() {

												//上级场馆号获取
												var trimab = $("#mmChainAccno")
														.find("option:selected")
														.text();
												var str2 = trimab
														.substring(
																trimab
																		.indexOf("--") + 2,
																trimab
																		.lastIndexOf("--"));
												$("#mmOldAccNumber").val(str2);

												var mmAgreementStartDate = $(
														"#mmAgreementStartDate")
														.val();
												var mmAgreementEndDate = $(
														"#mmAgreementEndDate")
														.val();
												if (mmAgreementStartDate != ""
														&& mmAgreementEndDate != "") {
													if (Number(mmAgreementStartDate) > Number(mmAgreementEndDate)) {
														alert("合约开始时间不可以大于合约结束时间！");
														return false;
													}
												}

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
										url : "${ctx}/staff/search_mermst_Data",
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
														$("#mmChainAccno")
																.html(
																		_
																				.template(
																						$(
																								"#tplMmChainAccno0")
																								.html(),
																						mmChainAccno));
													} else {
														$("#mmChainAccno")
																.html(
																		_
																				.template(
																						$(
																								"#tplMmChainAccno")
																								.html(),
																						mmChainAccno));
													}
												} else {
													$("#mmChainAccno")
															.html(
																	_
																			.template(
																					$(
																							"#tplMmChainAccno")
																							.html(),
																					mmChainAccno));
												}
											} else {
												alert("归属场馆错误");
											}
										}
									});
						});

		function cancleSubmit() {
			location.href = "${ctx}/staff/searchVmermstResultList";
		}
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
