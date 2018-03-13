<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>

	<head>
		<title>综合管理系统 | 公关赠票</title>
   		<tags:head_common_content/>
    	<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    	<link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
    	<link rel="stylesheet" href="${assets}/css/css.css"/>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<style>
		#ticketKind,#phone{border-radius:5px;}
		
		</style>
	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
		
		<div style="position:absolute;">
			<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
			<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
		</div>		
		 <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="staff"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>公关赠票</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">公关赠票</li>
          </ol>
        </section>
		
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><img src="${assets }/app/img/increaseTicket.png"></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
						<form id="defaultForm" name="defaultForm" class="form-horizontal">
							<div class="form-line clearfix">
								<div class="col-lg-12 ">
									<div class="col-lg-6">
										<div class="form-group ">
											<label for="phone">移动电话：</label><input class="form-control formConl" type="text" name="phone" id="phone" />
										</div>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<h3 style="border-bottom: 2px dashed #f7ab00;">点击选择</h3>
							<div class="form-line clearfix">
								<div class="col-lg-12 mag">
									<div class="col-lg-6">
										<div class="form-group">
											<label for="ticketKind">票券种类：</label>
											<select class="form-control" id='ticketKind' name="ticketKind">
												
                               					<c:forEach var="tkType" items="${tkTypeList}">
                               						<option value="${tkType.ttTypeId }"><i>${tkType.ttTypeId }--${tkType.ttTypeDesc }</i> - 价位:<i>${tkType.ttListPrice }</i></option>
                               					</c:forEach>
											</select>
										</div>

									</div>
								</div>
								<div class="clearfix"></div>
								<h3 style="border-bottom: 2px dashed #6fba2c;">硬件录入</h3>
								<div class="form-line clearfix">
									<div class="col-lg-12 mag">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="CbRwdsAccno">卡流水号：</label><input type="text" class="line-input" id="CbRwdsAccno" name="CbRwdsAccno" disabled="disabled"/>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group holderNo">
												<label for="cbCardholderNo" >持卡号码：</label><input type="text" id="cbCardholderNo" name="cbCardholderNo" disabled="disabled" class="line-input" style="width:205px;margin-right:2px;" />
												<button type="button" type="button" onclick="findCard()" class="btn-size">读卡信息</button>
											</div>
										</div>
									</div>
									<div id="hr">aa</div>
									<div class="clearfix"></div>
									<div class="col-lg-12 mag">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="cbIdType">证件类型：</label>
												<select class="DocumentType form-control" id="cbIdType" name="cbIdType">
													<option value="1">身份证</option>
													<!-- <option value="2">授权码</option> -->
												</select>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group readID" style="display: block;">
												<label for="idText" >身份证号：</label>
												<input type="text" name="idNo" id="idNo" class="line-input" style="width:205px;" />
												<input type = "hidden" id ="Address" name="Address" value="">
												<button type="button" class="btn-size" type="button" onclick="readCard()">读身份证</button>
											</div>

										</div>
									</div>

									<div class="col-lg-12 mag">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="uname" >姓名：</label><input type="text" name="uname" id="uname" value="" class="line-input">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group">
												<label for="CbRwdsAccno" >出生日期：</label><input type="text" id="birthday" name="birthday" value="" class="line-input">
											</div>
										</div>

									</div>
								</div>
								<div class="clearfix"></div>

								<div class="col-lg-12" style="margin:50px 0 20px 0">
									<div class="col-lg-12 mag">
										<div style="float:left;">
											<a href="${ctx }/startTreeviewDetail/pwzy" class="form-a">
												&lt;返回</a>

													<span style="margin:0 15px;display: inline-block;">
					   				
					   			</span>
										</div>
										<div style="float:right;">
											<input type="hidden" value="" id="hidden" />
											<button type="button" class="btn-size" style="width:110px;margin:0 25px 0 15px;" id="increaseSure" onclick="cash_payment()">确定</button>
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
		</div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/layer/skin/layer.css"></script>
    <script src="${assets}/layer/layer.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
			<input type="hidden" value="3" id="test" />
			<script type="text/javascript">
				

			//校验手机号方法
			function validateMobile(phoneNumber) {
				var flag = true;
				if(phoneNumber == "") {
					layer.msg("请输入手机号码");
					flag = false;
					return false;
				}
				if(phoneNumber.length != 11) {
					layer.msg("请输入有效的手机号码");
					flag = false;
					return false;
				}
				var regmoblie = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
				if(!regmoblie.test(phoneNumber)) {
					layer.msg("请输入有效的手机号码");
					flag = false;
					return false;
				}

				return true;
			}

			function validateIdNo(idNo) {
				isIDCard1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
				isIDCard2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
				if(!idNo) {
					layer.msg("身份证号码不能为空");
					return false;
				}
				if(!isIDCard1.test(idNo) && !isIDCard2.test(idNo)) {
					layer.msg("请输入正确的身份证号码");
					return false;
				}
				return true;
			}

			function validateCart() {

				var cbCardholderNo = $.trim($("#cbCardholderNo").val()); //持卡人号码
				var idNo = $.trim($("#idNo").val()); //身份证号码
				var phone = $.trim($("#phone").val()); //手机号码
				var CbRwdsAccno = $.trim($("#CbRwdsAccno").val());				//卡流水号
				var uname = $.trim($("#uname").val()); //证件姓名
				var birth = $.trim($("#birth").val); //出生日期
				if(!validateMobile(phone)) {
					return;
				}
				if(!CbRwdsAccno){
					layer.msg("卡流水号不能为空")
					return ;
				}
				if(!cbCardholderNo) {
					layer.msg("持卡号码不能为空");
					return false;
				}
				
				if(!validateIdNo(idNo)) {
					layer.msg("请输入正确的身份证号码");
					return false;
				}
                if(!uname){
                	layer.msg("姓名不能为空");
					return;
                }
				if(!birth) {
					layer.msg("出生日期不能为空");
					return;
				}
				return true;
			}
			//确定
			$("#lostCard").click(function() {
				if(!validateCart()) {
					return;
				}

			});
				
				
			var key1str;
			var key2str;
			var key3str;
			var key6str;

	//读卡号
	function findCard(){
		readCardNo("cbCardholderNo");
		var cardNo=$("input[name='cbCardholderNo']")[0].value;
		if(cardNo=="undefined" || cardNo==""){
			$("#cbCardholderNo").val("");
			return;
		}
		cardNo="<%=Constants.baseBIN%>"+cardNo;
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getCardMess",
			dataType : "json",
			data : {
				cardNumber : cardNo,
				type: 0
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					document.getElementById(document.getElementsByName("cbCardholderNo")[0]).value = "";
					/* layer.msg(e.message); */
					return;
				}
				var p=data.value;
					kamianhao(cardNo);
					key2str=p[0];
					key3str=p[1];
					key6str=p[2];
					if("P-预制卡" !=p[7]){
						layer.msg("请选择预制卡");
						$("input[name='cbCardholderNo']")[0].value="";
						return false;
					}
					getCardMess(cardNo);
					getBalance(cardNo);
			}
		});
	 }
	function kamianhao(cardNo){
		$.ajax({
			type : "POST",
			url : "${ctx}/cpticket/kamianhao",
			dataType : "json",
			data : {
				cardNo : cardNo
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				$("#CbRwdsAccno").val(data.value.substr(6));
			}
			
		});
	}
	//读取身份证:获取身份证号码、出生日期
	function readCard() {
		var idNo = $("#cbIdType").val();
		if (idNo != "1") {
			layer.msg("选择证件类型为身份证");
			return;
		}
		var strReadResult = CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
			$("#idNo").val(CVR_IDCard.CardNo);
			//证件类型1-身份证（自动获取身份证）
			if ($("#cbIdType").val() == "1") {
				$("#birthday").val(CVR_IDCard.Born);
				$("#uname").val(CVR_IDCard.Name);
				$("#Address").val(CVR_IDCard.Address);
			}
		} else {
			layer.msg("读取身份证失败," + strReadResult);
		}
	}
	
	function cash_payment(){
		var mobile = $("#phone").val();	//手机号
			//预存金额
		var varTk_ticket_type=$("#ticketKind").val();	//票劵ID
						//票劵形式
		var varOld_prdgrp = "1100";			//客户等级
		var CbRwdsAccno = $("#CbRwdsAccno").val();				//卡流水号
		var cbCardholderNo = $("#cbCardholderNo").val();		//持卡号码
		cbCardholderNo="<%=Constants.baseBIN %>"+cbCardholderNo;
		var cbIdType = $("#cbIdType").val();					//证件类型
		var idNo = $("#idNo").val();							//证件号
		var uname = $("#uname").val();							//证件名
		var birthday = $("#birthday").val();					//出生日期
		var Address = $("#Address").val();	//出生地址
	 	var json ='[{"mobile":"'+mobile+'","varTk_ticket_type":"'+varTk_ticket_type+'"';
		json +=',"varOld_prdgrp":"'+varOld_prdgrp+'","CbRwdsAccno":"'+CbRwdsAccno+'","cbCardholderNo":"'+cbCardholderNo+'","cbIdType":"'+cbIdType+'"'
		json +=',"idNo":"'+idNo+'","uname":"'+uname+'","birthday":"'+birthday+'","Address":"'+Address+'"}]'
	/* 	layer.msg(json); */
	/* 	if(!confirm("确认提交?")){
			  return;
		};  */
		if(!validateCart()) {
			return;
		}
		$.ajax({
			type : "POST",
			url : "${ctx}/prticke/Cash_ticket",
			dataType : "json",
			data : {
				data : json,
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return ;
				}
				 /* layer.msg("data:"+data); */ 
				if(data == null){
					layer.msg("增票失败！");
				}else{
					layer.msg("增票成功！");
				}
			
			}
		});
	}
	
	</script>

		
	</body>

</html>