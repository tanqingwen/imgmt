<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>综合管理系统 | 实名订单取票</title>
    <tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/validator/css/bindcard.css" />
	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div style="position:absolute;">
  		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU011.jsp"></jsp:include>
	</div>
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="intcard"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>实名订单取票</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">实名订单取票</li>
          </ol>
        </section>
	
		<div class="container" style="margin-top:20px;">
			<div class="row positionAd">
				<div class="col-lg-1 col-md-1 text-center lebelT">
					<div class="tip-img">
						<p style="line-height:30px;">实名订单取票</p>
					</div>
				</div>
				<div class="col-lg-11 col-md-11">
					<div class="BindContent clearfix">
						<div class="contentInner clearfix">	
							<div class="BindHeader row BindCardH" style="margin-bottom:20px;">
								<div class="headPad">
									<div class="col-lg-6 col-md-4 choseRadio" style="padding: 0;">
										<span class="choice">  
                                         <label class="radio radio2"><input type="radio" name="radio" value="2" id="radio2" checked="checked"><i></i>订单号</label>  
                                         <label class="radio radio1"><input type="radio" name="radio" value="1" id="radio1" ><i></i>扫码</label>  
                                   </span>
									</div>
									<div class="col-lg-2 col-md-2" style="float:right">
										<span id="bindOk">
                                    	<button class="btn bCardEd" onclick="refresh()" style="display:none;">绑卡完成</button>
                                    </span>
									</div>
								</div>
							</div>
							
							<div class="row orderCotent orderNumContent" style="display: none;">
								<img src="${assets }/app/img/scanCode.png">
								<label class="order ">扫码：</label><input type="text" id="orderId" class="line-input"  style="height:35px;"/>
								<button class="btn orderSure" type="button" onclick="queryTick()">确定</button>
							</div>
							
							<div class="row orderCotent TelNumContent" >
								<label class="order order2">订单号:</label><input type="text" id="orderId2" class="line-input" style="height:35px !important" />
								<button class="btn orderSure" type="button" onclick="queryTick2()" >确定</button>
							</div>
						
							<div class="cardBind">
								<ul class="bindcard clearfix">
									<!-- <li class="col-lg-6 binded">
										<div class=" bindContentInner">
										<form action="">
											<ul class=" ">
												<li class="">姓名：<span class="bindName" id="bindName">王二小</span></li>
												<li class="">身份证号：<span class="bindID" id="bindID">110103197611130034</span></li>
												<li class="">票券种类：<span class="bindKind">海洋馆</span> 单日 <span class="bindtype">成人票</span></li>
												<li class="">
												<button class="btn btnStyle readBtn" type="button" onclick="findCard()">读卡</button><input id="cbCardholderNo" name="cbCardholderNo" type="text" class="readId" style="width: 150px;" />
												<button class="btn btnStyle bindBtn" type="button" id="tieCard">绑卡</button></li>
											</ul>
										</form>
										</div>
									</li> -->
								</ul>
								
							</div>
						   <div class="col-md-12 clearfix "style="margin-bottom:20px;">
						    	<a type="button"  href="${ctx }/startTreeviewDetail/pwzy" class="form-a" style="font-size:18px;color:#333;">&lt;返回</a>	
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
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/app/js/app.js"></script>
	</div>
	</div>
	</body>
	<script type="text/javascript">
	function change(){
		
		if($("#scanCode").val().length==8){
			alert(111);
		}
			
	}
		
	/* 	$(document).ready(function(){
			$("#scanCode").focus();
		}); */
	
		$(function() {
			$('.radio1 input').click(function() {
				$(".orderNumContent").show();
				$(".TelNumContent").hide();
				$(".bindcard").empty();
				$("#orderId").focus();
				$("#orderId2").val("");
		        $(".bCardEd").hide();
				
			})
			$('.radio2 input').click(function() {
				$("#orderId").val("");
				$("#orderId2").val("");
				$(".orderNumContent").hide();
				$(".TelNumContent").show();
				$(".bindcard").empty();
				$(".bCardEd").hide();
			})
		});
		
		//读卡号
	function findCard(i){
		readCardNo("cbCardholderNo"+i+"",i);
		var cardNo=document.getElementsByName("cbCardholderNo"+i+"")[0].value;
		if(cardNo=="undefined" || cardNo==""){
			$("#cbCardholderNo"+i+"").val("");
			return;
		}
		cardNo="<%=Constants.baseBIN%>"+cardNo;
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getKey",
			dataType : "json",
			data : {
				cardNumber : cardNo,
				type: 0
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					document.getElementsByName("cbCardholderNo"+i+"")[0].value = "";
					return;
				}
				var p=data.value;
					getCardMess(cardNo,i);
			}
		});
	 }	
	
	function getCardMess(cardNo,i) {
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getCardMess",
			dataType : "json",
			data : {
				cardNumber : cardNo
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var res=data.value;
				if(res[7] !="P-预制卡"){
					$("#cbCardholderNo"+i+"").val("");
					alert("请选择预制卡");
					return false;
				}
			}
		});
	 }	
	
	function tieCard(i){
		var cardNo=$("#cbCardholderNo"+i+"").val();
		var uname=$("#bindName"+i+"").html();
		var idNo =$("#bindID"+i+"").html();
		var orderId=$("#orderId"+i+"").html();

		 if(cardNo=="undefined" || cardNo==""){
			alert("请读取卡信息");
			return;
		} 
		cardNo="<%=Constants.baseBIN%>"+cardNo; 
		 $.ajax({
			type : "POST",
			url : "${ctx}/intcrdtbl/openCard",
			dataType : "json",
			data : {
				cbCardholderNo : cardNo,
				idNo : idNo,
				orderid : orderId,
				uname : uname
			},
			success : function(data){
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var li =$(".bbb").eq(i);
				li.removeClass('active').addClass('binded');
				$(".bbb").eq(i+1).addClass('active').removeClass("noBind");
				alert("开卡成功！");
		 	}
		});
	};
	
	
	function queryTick2(){
		$(".bindcard").empty();
			var orderId= $("#orderId2").val();
			//var phoneNumber=$("#phoneNumber").val();
			$.ajax({
				type : "POST",
				url : "${ctx}/cpticket/ticket/query",
				dataType : "json",
				data : {
					orderId : orderId,
					//phoneNumber : phoneNumber
				},
				success : function(data){
					if(data.status=='SUCCESS'){
						if(data.value == ""){
							alert("没有订单信息！");
						}else{
							
							console.log(data.value);
							for (var i = 0; i < data.value.length; i++) {
								var obj = data.value[i];
								var name=obj.hwCredentyname;
								var hwTicketName=obj.hwTicketName;
								var hwSpecialMethod =obj.hwSpecialMethod;
								var idNo=obj.hwMemberId;
								var ticketId=obj.hwProdctGroup;
								var orderId=obj.hwOrderitemId;
									 if(obj.isBind){

										//alert("aaa");
										$('.bindcard').append('<li class="col-lg-6 col-md-6 binded bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">'+hwTicketName+'</span> 单日 <span class="bindtype">'+hwSpecialMethod+'票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
										//$(".bindcard li:first").addClass('active').removeClass("noBind");
										$(".binded .readId").attr("disabled","true");
										$(".binded .readBtn").attr("disabled","true");
										$(".binded .bindBtn").attr("disabled","true");
									}else{
										$('.bindcard').append('<li class="col-lg-6 col-md-6 active bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">'+hwTicketName+'</span> 单日 <span class="bindtype">'+hwSpecialMethod+'票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
										/* $(".active .readId").attr("disabled","true");
										$(".binded .readBtn").attr("disabled","true");
										$(".binded .bindBtn").attr("disabled","true"); */
									} 
								/* $.ajax({
									type : "POST",
									url : "${ctx}/intcrdtbl/queryTkticket",
									dataType : "json",
									data : {
										tkTicketId : obj.hwOrderitemId
									},
									success : function(data){
										alert("accc");
										if(data.status == 'SUCCESS'){
											 if(data.value ==null){
												//alert("aaa");
												$('.bindcard').append('<li class="col-lg-6 noBind bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">海洋馆</span> 单日 <span class="bindtype">成人票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
												//$(".bindcard li:first").addClass('active').removeClass("noBind");
											}else{
												//alert("aa");
												$('.bindcard').append('<li class="col-lg-6 binded bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">海洋馆</span> 单日 <span class="bindtype">成人票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
												//return;
											} 
										}
									}
								}); */
								//$('.bindcard').append('<li class="col-lg-6 bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">海洋馆</span> 单日 <span class="bindtype">成人票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
								//$(".bindcard li:first").addClass('active').removeClass("noBind");
							 if(i==5){
								 return;
							 }
							 $(".bCardEd").show();
							}
						}
					}
				}
			});
		}
	
	function queryTick(){
		$(".bindcard").empty();
			var orderId= $("#orderId").val();
			//var phoneNumber=$("#phoneNumber").val();
			$.ajax({
				type : "POST",
				url : "${ctx}/cpticket/ticket/query",
				dataType : "json",
				data : {
					orderId : orderId,
					//phoneNumber : phoneNumber
				},
				success : function(data){
					if(data.status=='SUCCESS'){
						if(data.value == ""){
							alert("没有订单信息！");
						}else{
							console.log(data.value);
							for (var i = 0; i < data.value.length; i++) {
								var obj = data.value[i];
								var name=obj.hwCredentyname;
								var hwTicketName=obj.hwTicketName;
								var hwSpecialMethod =obj.hwSpecialMethod;
								var idNo=obj.hwMemberId;
								var ticketId=obj.hwProdctGroup;
								var orderId=obj.hwOrderitemId;
									 if(obj.isBind){                                      
										//alert("aaa");
										$('.bindcard').append('<li class="col-lg-6 col-md-6 binded bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">'+hwTicketName+'</span> 单日 <span class="bindtype">'+hwSpecialMethod+'票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
										//$(".bindcard li:first").addClass('active').removeClass("noBind");
										$(".binded .readId").attr("disabled","true");
										$(".binded .readBtn").attr("disabled","true");
										$(".binded .bindBtn").attr("disabled","true");
									}else{
										$('.bindcard').append('<li class="col-lg-6 col-md-6 active bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">'+hwTicketName+'</span> 单日 <span class="bindtype">'+hwSpecialMethod+'票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
										/* $(".active .readId").attr("disabled","true");
										$(".binded .readBtn").attr("disabled","true");
										$(".binded .bindBtn").attr("disabled","true"); */
									} 
								/* $.ajax({
									type : "POST",
									url : "${ctx}/intcrdtbl/queryTkticket",
									dataType : "json",
									data : {
										tkTicketId : obj.hwOrderitemId
									},
									success : function(data){
										alert("accc");
										if(data.status == 'SUCCESS'){
											 if(data.value ==null){
												//alert("aaa");
												$('.bindcard').append('<li class="col-lg-6 noBind bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">海洋馆</span> 单日 <span class="bindtype">成人票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
												//$(".bindcard li:first").addClass('active').removeClass("noBind");
											}else{
												//alert("aa");
												$('.bindcard').append('<li class="col-lg-6 binded bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">海洋馆</span> 单日 <span class="bindtype">成人票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
												//return;
											} 
										}
									}
								}); */
								//$('.bindcard').append('<li class="col-lg-6 bbb"><div class=" bindContentInner"><ul class=" "><li class="">姓名：<span class="bindName'+i+'" id="bindName'+i+'">'+name+'</span><span hidden="hidden" id="orderId'+i+'">'+orderId+'</span></li><li class="">身份证号：<span class="bindID'+i+'" id="bindID'+i+'">'+idNo+'</span></li><li class="">票券种类：<span class="bindKind'+i+'">海洋馆</span> 单日 <span class="bindtype">成人票</span></li><li class=""><button class="btn btnStyle readBtn" type="button" onclick="findCard('+i+')">读卡</button><input id="cbCardholderNo'+i+'" name="cbCardholderNo'+i+'" type="text" class="readId" style="width: 150px;" /><button class="btn btnStyle bindBtn" type="button" onclick="tieCard('+i+')">绑卡</button></li></ul></div></li>');
								//$(".bindcard li:first").addClass('active').removeClass("noBind");
							 if(i==5){
								 return;
							 }
							}
							 $(".bCardEd").show();
						}
					}
				}
			});
		}
	
	</script>
	
	
	<script type="text/javascript">
		function refresh(){
			window.location.href="${ctx }/intcrdtbl/add";
		}	
	</script>
</html>