<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>综合管理系统 |会员卡充值</title>
		
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	<!-- this "tags" contains all the patterns we need in this page -->
	<tags:head_common_content/>
	
	<style type="text/css">
			*{
				margin:0;
				padding:0;
			}
			li{
				list-style: none;
			}
			body{
				font-family: "微软雅黑";
				background:#eeeeee;
			}
			.row{
				width:1000px;
				margin:20px auto;
				position:Relative;
				background:white;
				-webkit-box-shadow:0 0px 20px 3px #bcdccd;  
				 -moz-box-shadow:0 0px 20px 3px #bcdccd;  
				 box-shadow:0 0px 20px 3px #bcdccd;  
			}
			.tip-img{
				position:absolute;
				left:-100px;
				top:-12px;
			}
			.content{
				width:1000px;
				margin:0 auto;

			}
			.main{
				width:921px;
				margin:0 auto;
			}
			.main h3{
				width:100%;
				height:70px;
				line-height:70px;
				font-family: "微软雅黑";
			}
			.form-line{
				margin:25px auto 10px 0 ;
			}
			.labels .line-input{
				width:310px;
				height:40px;
				border:lightblue 1px solid;
				border-radius: 5px;
				outline:none;
				color:lightslategray;
				text-indent:5px;
				margin:0 10px;
				display: inline-block;
				font-size:14px;
			}
			.labels select{
				width:310px;
				height:40px;
				border:lightblue 1px solid;
				border-radius: 5px;
				outline:none;
				color:lightslategray;
				text-indent:5px;
				margin:0 10px;
				display: inline-block;
				font-size:14px;
			}
			.labels  select option{
				width:310px;
				font-size:14px;
				height:40px;
				border:lightblue 1px solid;
				border-radius: 5px;
				outline:none;
				color:lightslategray;
				text-indent:10px;
				margin:0 10px;
				display: inline-block;
			}
			.form-a{
				display: inline-block;
				color:black;
				width:80px;
				height:40px;
				line-height:40px;
				text-align: center;
			}
			.line-input:focus{
				border-color:lightskyblue;
			}
			.labels{
				color:#35353e;
				font-size: 16px;
				font-family: "微软雅黑";
				display: inline-block;
			}
			.labels:last-child{
				margin-left:25px;
			}
			.labels i{
				font-style: normal;
				display: inline-block;
				width:90px;
				line-height:40px;
				height:40px;
				text-align: right;
			}
			.labels span{
				color:#e94027;
			}
			.labels span strong{
				color:black;
				margin:0 5px;
				font-weight: 400;
			}
			.mag{
				margin:8px 0;
			}
			.btn-size{
				width:77px;
				height:40px;
				background:#6db921;
				color:white;
				border:none;
				border-radius: 4px;
				outline:none;
			}
			.btn-orang{
				width:132px;
				height:40px;
				background:#ed6826;
				color:white;
				border:none;
				border-radius: 4px;
				outline:none;
			}
			.more-ul{
				width:310px;border:lightblue 1px solid;position:absolute;left:105px;top:40px;
				z-index:2;
				background:white;
			}
			.more-ul li{
				width:100%;
				height:40px;
				display: block;
				line-height:40px;
				font-size:14px;
				border-bottom: 1px solid lightblue;
			}
			.more-ul li:last-child{
				border:none;
			}
			.more-ul li input{
				width:18px;
				height:18px;
				margin:2px 5px 0;
			}
		</style>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div style="position:absolute;">
  		<jsp:include flush="true" page="/WEB-INF/tags/all.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
	
	<!-- Main header, top yellow bar -->
<tags:main_header/>

<!-- Left column, contains the logo and sidebar -->
<tags:main_sidebar active="amount"/>

<!-- here use a wrapper so that the content won't be influenced by sidebar -->
<div class="content-wrapper">

<!-- This class contains tip on the top of wrapper. Ordinarily it's invisible. -->
<div class="context-tips">
	<tags:action_tip/>
</div>
	
	<!-- title of the real content -->
<section class="content-header">
	<h1>会员卡充值</h1>
	<ol class="breadcrumb">
		<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li><a href="${ctx }/startTreeviewDetail/hykzy">会员卡作业</a></li>
		<li class="active">会员卡充值</li>
	</ol>
</section>
	<form id="form1" name="form1" class="form-horizontal">
	<div class="container-fluid"> 
		<div class="row">
			<div class="tip-img"><img src="${assets}/app/img/会员卡充值.png"></div>
			<div class="content">
				
				<div class="main">
					<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
					 <div class="form-line">
					 	<div class="col-lg-12 mag">
					 		<div class="labels" >
					   			<i>充值金额:</i>
					   			<input type="text" maxlength="10" name="varAc_amount" id="varAc_amount" value="" class="line-input" onkeyup="yangshi()"/>
						   	</div>
						   	<div class="labels" >
					   			
						   	</div>
					 	</div>
					 </div>
					<div class="clearfix"></div>
					
					<h3 style="border-bottom: 2px dashed #f7ab00;">点击选择</h3>
					 <div class="form-line">
					 	<div class="col-lg-12 mag">
					 		<div class="labels" >
					   		<i>支付方式:</i>
					   		<select id="payMent" onchange="pay()">
					   			<option value="0">---请选择---</option>
					   			<option value="1">现金支付</option>
					   			<option value="2">微信</option>
					   		</select>
					   	</div>
					   	<div class="labels">
					   		
					   	</div>
					 	</div>
					   	
					   
					   	
					   	<div class="col-lg-12 mag" id="showdiv1" style="display:none">
					   		<div class="labels">
					   			<i>实收金额:</i>
					   			<input id="moneyReceived" name="moneyReceived" value="" type="text" placeholder="" class="line-input" disabled="disabled" onkeyup="jisuan()"/>
					   		</div>
						   	<div class="labels">
						   		<i>现金找零:</i>
						   		<input id="cashChange" name="cashChange" value="" type="text" placeholder="" class="line-input" disabled="disabled"/>
						   	</div>
					   	</div>
					 </div>
					<div class="clearfix"></div>
					
					<h3 style="border-bottom: 2px dashed #6fba2c;">硬件录入</h3>
					 <div class="form-line">
						 	<div class="col-lg-12 mag">
						 		<div class="labels">
						   			<i>会员卡余额:</i>
						   		<input type="text" disabled="disabled" id="varRn_balance" name="varRn_balance" value="" class="line-input" />
							   	</div>
							   	<div class="labels">
							   		<i>持卡人号码:</i>
							   	<input type="text" disabled="disabled"	id="cbCardholderNo" name="cbCardholderNo" value="" class="line-input" style="width: 160px;" />
							   	<button type="button" class="btn-size" onclick="findCard()">读卡信息</button><span style="color:blue;font-weight:bold" id="cardstatus"></span>
							   	</div>
						 	</div>
						 	
						 	<div class="col-lg-12 mag">
					 		<div class="labels">
					   			<i>移动电话:</i>
					   			<input type="text" disabled="disabled" id="varOld_mobile" name="varOld_mobile" value="" class="line-input" />
						   	</div>
						   	<div class="labels">
						   		<i>身份证号码:</i>
						   	<input type="text" disabled="disabled"	id="idNo" name="idNo" value="" class="line-input"  />
						   	</div>
					 	</div>
					 	
					 	<div class="col-lg-12 mag">
					 		<div class="labels">
					   			<i>会员卡姓名:</i>
					   		<input type="text" disabled="disabled"	name="varOld_name" value="" class="line-input">
						   	</div>
						   	<div class="labels">
						   		<i>出生日期:</i>
						   	<input type="text" disabled="disabled"	name="varCb_birthday" value="" class="line-input" placeholder="" />
				
						   	</div>
					 	</div>
					 	
					 </div>
					 <div class="clearfix"></div>
					 
					  <div class="form-line" style="margin:50px 0 20px 0">
					  		<div class="col-lg-12 mag">
					 		<div class="labels" style="float:left;">
					   			<a href="${ctx }/" class="form-a">《返回</a>					   			
						   </div>
						   	<div class="labels" style="float:right;">
						   		
						   		<button id="account" type="button" class="btn-size" style="width:110px;margin:0 20px;">结算</button>
						   	</div>
					 	</div>
					 	<div class="clearfix"></div>
					  </div>
				</div>
			</div>
		</div>
	</div>
	</form>
	<tags:control_sidebar/>

	<tags:load_common_js/>
	</div>
	
	<script type="text/javascript">
	function pay(){
		var value= $("#payMent").val();
		if(value==1){
			$("#showdiv1").css("display","block");
			
		}else{
			$("#showdiv1").css("display","none");
			$("#moneyReceived").val("");
			$("#cashChange").val("");
		}
	};
	
	function yangshi(){
		var chongzhi=$("#varAc_amount").val();
		/* //金额验证
		var money = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
		if(!money.test(chongzhi)){
			alert("金额输入有误，请重新输入！");
			$("#varAc_amount").val("");
		} */
		if(chongzhi.trim() ==""){
			$("#moneyReceived").attr("disabled",true);
			$("#moneyReceived").val("");
			$("#cashChange").val("");
		}else if(chongzhi.trim() != null){
			$("#moneyReceived").attr("disabled",false);
		}
	}
	
	function jisuan(){
		var shishou=$("#moneyReceived").val();
		
		var chongzhi=$("#varAc_amount").val();
		$("#cashChange").val(shishou-chongzhi);
		
	};
	
	var key1str;
	var key2str;
	var key3str;
	var key6str;

	//读卡号
	function findCard(){
		
		//读卡前先清空文本框
		form1.idNo.value = "";
		form1.varOld_name.value = "";
		form1.varOld_mobile.value = "";
		form1.varCb_birthday.value = "";
		form1.varRn_balance.value = "";
		readCardNo("cbCardholderNo");
		var cardNo=document.getElementsByName("cbCardholderNo")[0].value;
		if(cardNo=="undefined" || cardNo==""){
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
					document.getElementById(document.getElementsByName("cbCardholderNo")[0]).value = "";
					alert(e.message);
					return;
				}
				var p=data.value;
					key2str=p[0];
					key3str=p[1];
					key6str=p[2];
					getCardMess(cardNo);
					getBalance(cardNo);
			}
		});
	 }	


	function getCardMess(cardNo) {
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
				form1.idNo.value = res[1];
				form1.varOld_name.value = res[2];
				form1.varOld_mobile.value = res[4];
				form1.varCb_birthday.value = res[5];
				document.getElementById("cardstatus").innerHTML=res[7];
			}
		});
	 }	
	
	//会员卡余额
	function getBalance(cardno){
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getBalance",
			dataType : "json",
			data : {
				cardNumber : cardno
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var p=data.value;
				if(p==null){
					alert("余额查询异常");
					return;
				}else{
					form1.varRn_balance.value=p;
				}
			}
		});
	}
	
	
	function checkValidation(){
		var varCardNo=form1.cbCardholderNo.value;
		var varAc_amount=form1.varAc_amount.value; //交易金额
		var money=/^[0-9]*(\.[0-9]{1,2})?$/;
		if(varCardNo == ""){
			alert("请读取卡信息！");
			return false;
		}
		if(!money.test(varAc_amount)){
			alert("请输入正确交易金额！");
			return false;
		}
		
		var pay= $("#payMent").val();
		if(pay == 0){
			alert("请选择交易方式");
			return false;
		}
		return true;	
	}


	$("#account").click(function(){
			
		if(checkValidation()){
			if(confirm("确定要提交该笔交易")){
				if(isNull(form1.cbCardholderNo)) return false;
				//省略了一些暂时
				try{
			    	var b = new Array();
			    	b.push(mt_block0);
			    	b.push(mt_block4);
			    	var cardNo=document.getElementsByName("cbCardholderNo")[0].value;
			    	cardNo="<%=Constants.baseBIN%>"+cardNo;
			    	var amount=document.getElementsByName("varAc_amount")[0].value;
			    	var k = new Array();
		    		var key1 = mt_block0.substr(0,6);
		    		k.push(key1+""+key1);
		    		k.push(key2str);
		    		k.push(key3str);
		    		k.push(key6str);
		    		doCoreTran(cardNo,amount,b,k);
				}catch(e){
					alert("充值失败");
				}
			}
		}
	});


	function doCoreTran(cardno,amount,b,k){
		b+="";
		k+="";
		var pay= $("#payMent").val();
		
		var moneyReceived=$("#moneyReceived").val();
		var cashChange=$("#cashChange").val();
		if(pay==1){
			$.ajax({
				type : "POST",
				url : "${ctx}/CardRecharge/doCoreTran",
				dataType : "json",
				data : {
					pay : pay,						//支付方式
					moneyReceived : moneyReceived,	//实收金额
					cashChange : cashChange,		//找零
					cardNumber : cardno,
					blocks : b,
					amount : amount
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					var p=data.value;
					if(p!=null){
						alert("充值成功!");
					}
				}
			});
		}else if(pay==2){
			
			document.form1.action="/CardRecharge/weChatCard"; 
	      	document.form1.submit();
	      	
	      	/*  $.ajax({
	      		type : "GET",
	      		url : "${ctx}/CardRecharge/weChatCard",
	      		dataType : "json",
	      		data : {
	      			cbCardholderNo : cardno
	      		},
	      		success : function(data){
	      			
	      		}
	      	}); */
		}
	}
	</script>
		
	</body>
</html>

	