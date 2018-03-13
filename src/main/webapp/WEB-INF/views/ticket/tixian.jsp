<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 员工添加</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets }/css/memberShip.css" />
<%--  <link rel="stylesheet" href="${assets}/bootstrap/css/bootstrap.css"/> --%>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div style="position: absolute;">
		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="staff" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>会员卡提现</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/hykzy">会员卡作业</a></li>
					<li class="active">会员卡提现</li>
				</ol>
			</section>
			<!-- Main content -->
		<!-- 	<section class="content"> -->
				<div class="container-fluid">
					<div class="row rowWidth">
						<div class="tip-img hidden-xs hidden-sm">
							<img src="${assets}/app/img/Withdrawal.png">
						</div>
						<div class="content">
							<div class="main">
								<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
								<form id="defaultForm" name="defaultForm"
									class="form-horizontal">
									<div class="form-line clearfix">
										<div class="col-lg-12 col-md-12 mag">
											<div class="col-lg-6 col-md-6">
												<div class="form-group ">
													<label for="cbCardholderNo" class="fs">卡面号：</label><input
														type="text" name="cbRecommenderNo" id="cbRecommenderNo"
														value="" class="line-input mobileWidth">
												</div>
											</div>
											<div class="col-lg-6 col-md-6">
												<div class="form-group ">
													<label for="bankNum">银行账户：</label><input type="text"
														name="bankNum" id="bankNum" value=""
														class="line-input mobileWidth">
												</div>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<h3 style="border-bottom: 2px dashed #6fba2c;">硬件录入</h3>
									<div class="form-line clearfix">
										<div class="col-lg-12 col-md-12 mag">
											<div class="col-lg-6 col-md-6">
												<div class="form-group">
													<label for="balance">证件类型：</label> <select
														class="DocumentType form-control" id="cbIdType"
														name="cbIdType" style="width: 290px; margin-left: 8px;">
														<c:forEach var="idType" items="${idTypeList}">
															<option value="${idType.idtypeId }">${idType.idtypeId }--${idType.idtypeDesc }</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-lg-6 col-md-6">
												<div class="form-group holderNo">
													<label for="idNo">身份证号码：</label><input type="text"
														id="idNo" name="idNo" class="line-input idWidth"
														style="width: 205px;" />
													<!-- <button type="button" onclick="readCard()" class="btn-size">查询</button> -->
													<button type="button" onclick="yue()" class="btn-size">查询</button>
												</div>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-lg-12 col-md-12 mag">
											<div class="col-lg-6 col-md-6">
												<div class="form-group">
													<label for="userName">持卡人姓名：</label><input type="text"
														name="userName" id="userName" value=""
														class="line-input mobileWidth" disabled="disabled">
												</div>
											</div>
											<div class="col-lg-6 col-md-6">
												<div class="form-group">
													<label for="birth">出生日期：</label><input type="text"
														name="birth" id="birth" value=""
														class="line-input mobileWidth" disabled="disabled">
												</div>
											</div>
										</div>
										<div class="col-lg-12 col-md-12 mag">
											<div class="col-lg-6 col-md-6">
												<div class="form-group">
													<label for="balance">会员卡余额：</label><input type="text"
														class="line-input mobileWidth" id="balance" name="balance"
														disabled="disabled" />
												</div>
											</div>
											<div class="col-lg-6 col-md-6">
												<div class="form-group">
													<label for="Withdrawal">提出现金：</label><input type="text"
														class="line-input mobileWidth" id="Withdrawal"
														name="Withdrawal" />
												</div>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>

									<div class="col-lg-12 col-md-12" style="margin: 50px 0 20px 0">
										<div class="col-lg-12 col-md-12 mag">
											<div style="float: left;">
												<a href="${ctx }/startTreeviewDetail/hykzy" class="form-a">
													&lt; 返回</a> <span
													style="margin: 0 15px; display: inline-block;"> </span>
											</div>
											<div style="float: right;">
												<input type="hidden" value="" id="hidden" />
												<button type="button" class="btn-size"
													style="width: 110px; margin: 0 25px 0 15px;"
													id="WithdrawalBtn1">提现</button>

											</div>
										</div>
										<div class="clearfix"></div>
									</div>
								</form>

							</div>
						</div>
					</div>
				</div>
		</div>
		<input type="hidden" value="3" id="test" />
	<!-- 	</section> -->
	</div>
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />

</body>
<script src="${assets}/layer/layer.js"></script>
<script type="text/javascript">
	function validateIdNo(idNo) {

		var idNo = $("#idNo").val();
		isIDCard1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
		isIDCard2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
		if (!idNo) {
			layer.msg("身份证号码不能为空");
			return false;
		}
		if (!isIDCard1.test(idNo) && !isIDCard2.test(idNo)) {
			layer.msg("请输入正确的身份证号码");
			return false;
		}
		return true;
	}

	function validateCart() {
		var cbRecommenderNo = $.trim($("#cbRecommenderNo").val()); //卡面号
		var idNo = $.trim($("#idNo").val()); //身份证号码
		var username = $.trim($("#userName").val()); //证件姓名
		var birth = $.trim($("#birth").val); //出生日期
		var bankNum = $.trim($("#bankNum").val()); //银行账户
		var documentType = $.trim($("#cbIdType").val()); //证件类型
		var Withdrawl = $.trim($("#Withdrawal").val()); //提出现金
		var userName = $.trim($("#userName").val()); //持卡人姓名
		if (!cbRecommenderNo) {
			layer.msg("卡面号不能为空");
			return false;
		}
		if (!bankNum) {
			layer.msg("银行账户不能为空");
			return false;
		}
		if (!documentType) {
			layer.msg("请选择证件类型");
			return false;
		}
		if (documentType == 0) {
			if (!validateIdNo(idNo)) {
				layer.msg("请输入正确的身份证号码");
				return false;
			}
		}
		if (!validateIdNo(idNo)) {
			layer.msg("请输入正确的身份证号码");
			return false;
		}
		if (!userName) {
			layer.msg("请输入持卡人姓名");
			return false;
		}
		if (!birth) {
			layer.msg("出生日期不能为空");
			return false;
		}
		return true;
	}
	//确定

	$("#WithdrawalBtn1").click(function() {
		if (!validateCart()) {
			return;
		}
		console.log('click event')
		var cbRecommenderNo = $("#cbRecommenderNo").val();
		var balance = $("#balance").val();
		var Withdrawal = $("#Withdrawal").val();
		var bankNum = $("#bankNum").val();
		var userName = $("#userName").val();
		if (Withdrawal >= balance) {
			layer.msg("卡内余额不足");
			return;
		}
		$.ajax({
			url : "${ctx}/CardRecharge/CardWithdrawals",
			type : 'post',
			data : {
				'CardId' : cbRecommenderNo,
				'AMOUNT' : Withdrawal,
				'ACCOUNT_NO' : bankNum,
				'ACCOUNT_NAME' : userName
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "FALSE") {
					layer.msg(data.comment);
				} else {
					layer.msg("提现成功");
					setTimeout("window.location.reload()", 4000);

				}

			}
		});

	});
	//获取身份证信息
	function readCard() {
		try {
			var cbIdType = $("#cbIdType").val();
			if (cbIdType != "1") {
				alert("选择证件类型为身份证");
				return;
			}
			var strReadResult = CVR_IDCard.ReadCard();
			if (strReadResult == "0") {
				$("#idNo").val(CVR_IDCard.CardNo);
				//证件类型1-身份证（自动获取身份证）
				if ($("#cbIdType").val() == "1") {
					$("#userName").val(CVR_IDCard.Name);
					$("#birth").val(CVR_IDCard.Born);
					getCard();
				}

			} else if (strReadResult == "找不到设备") {
				alert(strReadResult + ",请插入读身份证设备");
			} else if (strReadResult == "读居民身份证操作失败") {
				alert(strReadResult + ",请将居民身份证放在读身份证控件上！");
			}
		} catch (e) {

		}
	}

	//获取卡号
	function getCard() {
		var idType = $("#cbIdType").val();
		var idNo = $("#idNo").val();
		if (idType == null || idType == "" || idNo == null || idNo == "") {
			return;
		}
		$.ajax({
			type : "POST",
			url : "${ctx}/blkmlc/getCardInfo",
			dataType : "json",
			data : {
				idType : idType,
				idNo : idNo
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if (data == null) {
					alert("使用证件信息没有找到对应数据");
					return;
				} else {
					var res = data.value;
					$("#cbCardholderNo").val(res[0].substr(6)); //持卡人号码
					//getInfo(CLOSS.cbCardholderNo.value);
					getInfo(res[0]);
				}
			}
		});
	}

	//挂失卡片信息
	function getInfo(val) {
		$.ajax({
			type : "POST",
			url : "${ctx}/blkmlc/getCardInfo1",
			dataType : "json",
			data : {
				cardNo : val
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if (data == null) {
					alert("没有找到卡号记录！");
					return;
				} else {
					var res = data.value;

					$("#balance").val(res[8]);
				}
			}
		});
	}

	function yue() {
		var idType = $("#cbIdType").val();
		var idNo = $("#idNo").val();
		var cbRecommenderNo = $('#cbRecommenderNo').val();
		if (cbRecommenderNo == null || cbRecommenderNo == "" || idNo == null
				|| idNo == "") {
			alert('卡面号和身份证号码不能为空');
			return;
		}
		$.ajax({
			type : "POST",
			url : "${ctx}/blkmlc/getRecommInfo",
			dataType : "json",
			data : {
				idType : idType,
				idNo : idNo,
				cbRecommenderNo : cbRecommenderNo
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if (data == null) {
					alert("使用证件信息没有找到对应数据");
					return;
				} else {
					var res = data.value;
					//$("#cbCardholderNo").val(res[0].substr(6)); //持卡人号码
					//var cbRecommenderNo = $("#cbRecommenderNo").val();					
					//getInfo(CLOSS.cbCardholderNo.value);
					$("#userName").val(res.cbEmbossname);
					$("#birth").val(res.cbSuspendDate);
					getInfo(res.cbCardholderNo);
				}
			}
		});
	}
</script>

</html>
