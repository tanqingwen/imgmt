<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/bootstrap/css/bootstrap.min.css">
<title>交易明細</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

body {
	font-family: "微软雅黑";
	background: #eeeeee;
	padding-top: 20px;
}

.container-fluid {
	width: 960px;
	margin: 0 auto;
}

.row {
	width: 960px;
	margin: 20px auto;
	position: Relative;
	background: white;
	-webkit-box-shadow: 0 0px 20px 3px #bcdccd;
	-moz-box-shadow: 0 0px 20px 3px #bcdccd;
	box-shadow: 0 0px 20px 3px #bcdccd;
}

.tip-img {
	position: absolute;
	left: -80px;
	top: -12px;
}

.content {
	width: 960px;
	margin: 0 auto;
}

.main {
	width: 901px;
	margin: 0 auto 50px;
}

.main h3 {
	width: 100%;
	height: 70px;
	margin-top: 0;
	line-height: 70px;
	font-family: "微软雅黑";
}

.form-line {
	margin: 25px auto 10px 0;
}

.labels .line-input {
	width: 310px;
	height: 40px;
	border: lightblue 1px solid;
	border-radius: 5px;
	outline: none;
	color: lightslategray;
	text-indent: 5px;
	margin: 0 10px;
	display: inline-block;
	font-size: 14px;
}

.labels select {
	width: 310px;
	height: 40px;
	border: lightblue 1px solid;
	border-radius: 5px;
	outline: none;
	color: lightslategray;
	text-indent: 5px;
	margin: 0 10px;
	display: inline-block;
	font-size: 14px;
}

.labels select option {
	width: 310px;
	font-size: 14px;
	height: 40px;
	border: lightblue 1px solid;
	border-radius: 5px;
	outline: none;
	color: lightslategray;
	text-indent: 10px;
	margin: 0 10px;
	display: inline-block;
}

.form-a {
	display: inline-block;
	color: black;
	width: 80px;
	height: 40px;
	line-height: 40px;
	text-align: center;
}

.line-input:focus {
	border-color: lightskyblue;
}

.labels {
	color: #35353e;
	font-size: 16px;
	font-family: "微软雅黑";
	display: inline-block;
}

.labels:last-child {
	margin-left: 25px;
}

.labels i {
	font-style: normal;
	display: inline-block;
	width: 90px;
	line-height: 40px;
	height: 40px;
	text-align: right;
}

.labels span {
	color: #e94027;
}

.labels span strong {
	color: black;
	margin: 0 5px;
	font-weight: 400;
}

.mag {
	margin: 8px 0;
}

.btn-size {
	width: 77px;
	height: 40px;
	color: white;
	border: none;
	border-radius: 4px;
	outline: none;
}

.btn-orange {
	width: 132px;
	height: 40px;
	background-image: url(${assets }/app/img/橙色.png);
	color: white;
	border: none;
	border-radius: 4px;
	outline: none;
}

.table-left {
	width: 600px;
	float: left;
	font-size: 18px;
}

.table-right {
	float: right;
	font-size: 18px;
	color: white;
	width: 122px;
}

.table-left th {
	color: rgb(98, 98, 98);
	font-weight: 500;
}

.table-left tr {
	height: 55px;
}

.table-left td {
	color: rgb(49, 49, 49);
	font-weight: 500;
}

.table-left-table {
	width: 100%;
	border-bottom: 1px solid lightgray;
}

.table-bottom-box {
	width: 100%;
	padding: 15px 0;
}

.table-bottom-box-left {
	float: left;
}

.table-bottom-box-right {
	float: right;
	margin-right: 42px;
}

.table-bottom-box-right li:first-child {
	margin: 0;
}

.table-bottom-box-right li {
	margin: 15px 0;
}

.table-bottom-box-right span {
	margin: 0 10px;
}

.table-right ul li {
	margin: 25px 0 100px 0;
}

.table-right button {
	width: 120px;
	height: 46px;
	border: none;
	border-radius: 5px;
	-webkit-border-radius: 5px;
}

.btn-blue {
	background-image: url(${assets }/app/img/蓝色.png);
}

.mark1 {
	width: 740px;
	height: 480px;
	z-index: 999;
	position: fixed;
	top: 50%;
	left: 50%;
	margin: -250px 0 0 -370px;
	background: white;
	text-align: center;
	border-radius: 5px;
}

.mark1 span {
	float: right;
}

.mark1 h2 {
	margin-top: 100px;
	color: #44a0df;
	font-size: 24px;
}

.markbox {
	display: block;
	position: fixed;
	top: 0px;
	filter: alpha(opacity = 8);
	background-color: rgb(3, 3, 3);
	z-index: 998;
	left: 0px;
	opacity: 0.8;
	-moz-opacity: 0.8;
}

#closedimg {
	cursor: pointer;
	margin: 20px;
}

.close {
	height: 60px;
	width: 60px;
	float: right;
	line-height: 60px;
}

#myDiv .innerWrap {
	width: 96%;
	margin: 0 auto;
}

#myDiv .innerWrap h6 span {
	width: 24%;
	text-algin: right;
	display: inline-block;
}

#money .styleWid {
	width: 60px;
	text-algin: right;
	display: inline-block;
}

.tip-img {
	height: 202px;
	width: 78px;
	background-image: url(${assets }/app/img/content-side-bg.png);
}

.tip-img p {
	width: 20px;
	margin: 0 auto;
	color: #fff;
	font-size: 20px;
	line-height: 30px;
	margin-top: 40px;
}

.wrapper {
	margin-top: -20px;
}
</style>
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

		<div class="container-fluid">
			<section class="content-header">
				<h1>现场购票作业</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/pwzy">现场管理</a></li>
					<li><a href="${ctx }/cpticket/ceshi2">窗口购票</a></li>
					<li class="active">实名购票交易明细</li>
				</ol>
			</section>
			<div class="row">
				<div class="tip-img">
					<p>窗口购票</p>
				</div>
				<div class="content">
					<div class="main">
						<h3>交易明细</h3>
						<div class="form-line">
							<div class="table-left no-border">
								<input style="display: none;" id="orderid"
									value="${ywOrder.hwOrderId }">
								<table class="table-left-table">
									<tr>
										<th style="text-algin: right;">票种</th>
										<th style="text-algin: right;">对象</th>
										<th style="text-algin: right;">充值金额</th>
										<th style="text-algin: right;">单价</th>
										<th style="text-algin: right;">数量</th>
										<th style="text-algin: right;">金额</th>
									</tr>

									<c:forEach items="${orderItems }" var="item">
										<tr>
											<td style="text-algin: right;">${item.hwTicketName }</td>
											<td style="text-algin: right;">${item.hwSpecialMethod }</td>
											<td style="text-algin: right;">${item.hwChargeAmount }</td>
											<td style="text-algin: right;">${item.hwAmount }</td>
											<td style="text-algin: right;">${item.hwTicketCount } </td>
											<td style="text-algin: right;">${item.hwTicketCount * item.hwAmount +item.hwChargeAmount }</td>
										</tr>
									</c:forEach>

								</table>
								<div class="table-bottom-box">
									<div class="table-bottom-box-left">
										<c:if test="${ywOrder.hwPayType eq 'CASH' }">现金</c:if>
										<c:if test="${ywOrder.hwPayType eq 'XC_WX' }">微信支付</c:if>
										<c:if test="${ywOrder.hwPayType eq 'XC_ZFB' }">支付宝支付</c:if>
										<c:if test="${ywOrder.hwPayType eq 'JSAPI' }">公众号微信支付</c:if>
										<c:if test="${ywOrder.hwPayType eq 'APP' }">app微信</c:if>
										<c:if test="${ywOrder.hwPayType eq 'POS' }">pos机刷卡支付</c:if>
										<c:if test="${ywOrder.hwPayType eq 'ZNPOS' }">智能pos刷卡支付</c:if>
										<c:if test="${ywOrder.hwPayType eq 'YLTLH5' }">H5快捷支付</c:if>
										<c:if test="${ywOrder.hwPayType eq 'ZD_POS' }">自助终端POS支付</c:if>
										<input type="hidden" id="payType"
											value="${ywOrder.hwPayType }" />
									</div>
									<div class="table-bottom-box-right">
										<ul id="money">
											<li><span class='styleWid'>总金额:</span><span>${ywOrder.hwMoney }</span></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="table-right">
								<ul>
									<li><button class="btn-blue" id="redayin"
											onclick="javascript:doPrint('myDiv')">继续打印</button></li>
									<li><a href="${ctx}/cpticket/ceshi2"><button
												class="btn-orange">继续售票</button></a></li>
								</ul>
							</div>
						</div>
						<div class="clearfix"></div>

					</div>
				</div>
			</div>
		</div>

		<!--mark-->
		<div class="markbox" style="display: none;"></div>
		<!--ä»æ¬¾å¼¹åºæ¡-->
		<div class="mark1" style="display: none;">
			<div class="close">
				<span><img src="${assets }/app/img/窗口购票.png" id="closedimg" /></span>
			</div>
			<div class="clearfix"></div>
			<div class="mark1-main">
				<h2>打印中...</h2>
			</div>
		</div>
	</div>

	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<%-- <script type="text/javascript" src="${assets}/jquery/jquery.min.js"></script> --%>
	<%--     <script src="${assets}/bootstrap/js/bootstrap.min.js"></script> --%>
	<%--     <script type="text/javascript" src="${assets}/jquery/jquery-1.9.1.min.js"></script> --%>
	<script type="text/javascript"
		src="${assets}/jquery/jquery.qrcode.min.js"></script>
	<script type="text/javascript" src="${assets}/jquery/JsBarcode.all.js"></script>
	<br />
	<br />
	<script>
			var payType =$("#payType").val();
			var receiptsPrice = ${receiptsPrice};
			var payTotal = ${ywOrder.hwMoney};
			var zhaoling = receiptsPrice.toFixed(2)-payTotal.toFixed(2);
			var zl =zhaoling.toFixed( 2 );
			if(payType=='CASH'){
				$("#money").append("<li><span class='styleWid'>收银:</span><span>"+receiptsPrice+"</span></li><li><span class='styleWid'>找零:</span><span>"+zl+"</span></li>");
			}
			/* $("#goBuy").click(function(){
				window.location.href='${ctx}/cpticket/ceshi2';
			}); */
		</script>
</body>
<script language="javascript" type="text/javascript"> 
		
		function erweima() {
			//清空二维码
/* 			$("#erWeiMa").empty();
			$("#current").empty(); */
			//输入内容验证
			if($("#orderid").val() == ""){
				alert("请输入要生成二维码的内容!");
				return;
			}
			
			/**
	        *   参数列表
	        *   render   : "canvas",//设置渲染方式   
	            width       : 256,     //设置宽度   
	            height      : 256,     //设置高度   
	            typeNumber  : -1,      //计算模式   
	            correctLevel    : QRErrorCorrectLevel.H,//纠错等级   
	            background      : "#ffffff",//背景颜色   
	            foreground      : "#000000" //前景颜色  
	        *
	        */
			
			//生成二维码
	        $("#erWeiMa").qrcode({
	            render:"table",  //table canvas
	            text:utf16to8($("#orderid").val()),
	            width:100,
	            height:100
	        });
	        $("#current").append($("#orderid").val());
	        /* $("#inputStr").val(""); */
		}
		
		//解决二维码中文问题
		function utf16to8(str) {   
		    var out, i, len, c;   
		    out = "";   
		    len = str.length;   
		    for(i = 0; i < len; i++) {   
			    c = str.charCodeAt(i);   
			    if ((c >= 0x0001) && (c <= 0x007F)) {   
			        out += str.charAt(i);   
			    } else if (c > 0x07FF) {   
			        out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));   
			        out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));   
			        out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
			    } else {   
			        out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));   
			        out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));   
			    }   
		    }   
		    return out; 
		}		 
		var hkey_root, hkey_path, hkey_key;
	    hkey_root = "HKEY_CURRENT_USER";
	    hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	    function pagesetup_null() {
            try {
                var RegWsh = new ActiveXObject("WScript.Shell")
                hkey_key = "header"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
                hkey_key = "footer"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
            } catch (e) {
            }
        }
	    function pagesetup_default() {
            try {
            	var Wsh = new ActiveXObject("WScript.Shell");
            	hkey_key = "margin_left";
                //设置左页边距
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0");
                hkey_key = "margin_right";
                //设置右页边距
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0");
                hkey_key = "margin_top";
                //设置上页边距
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0.405");
                hkey_key = "margin_bottom";
                //设置下页边距   
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "1.405");
            } catch (e) {
        	
        	}     
        }
	    function doPrint(printDiv) {
            try {
                pagesetup_null();
                erweima();
                newwin = window.open("", "newwin", "height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
                newwin.document.body.innerHTML = document.getElementById(printDiv).innerHTML+'<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
                //newwin.window.print();
				newwin.document.getElementById("PrintCommandObject").ExecWB(6,2); 
                newwin.window.close();
                pagesetup_default();
            } catch (e) { }
        }
	    
	</script>
<div id="myDiv" style="display: none;">
	<div class="row">
		<div class="col-md-12">
			<h4 style="margin-left: 21px;">欢乐大世界购票信息</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h6 style="padding: 0; margin: 8px">下单时间：${ ywOrder.hwOrderPaytime}</h6>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h6 style="padding: 0; margin: 8px">订单编号：${ywOrder.hwOrderId }</h6>
		</div>
	</div>
	<div class="col-lg-12 col-md-12 clearfix">
		<table class="table table-responsive " id="tabstyle"
			style="font-size: 11px; margin-left: 8px;">
			<tr>
				<th>商品名称</th>
				<th>单价</th>
				<th>数量</th>
				<th>充值</th>
				<th>小计</th>
			</tr>
			<c:forEach items="${orderItems }" var="item">
				<tr>
					<td style="text-align: center;">${item.hwTicketName }</td>
					<td style="text-align: center;">${item.hwAmount }</td>
					<td style="text-align: center;">${item.hwTicketCount }</td>
					<td style="text-align: center;">${item.hwChargeAmount }</td>
					<td style="text-align: center;">${item.hwTicketCount * item.hwAmount+item.hwChargeAmount }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h6 style="padding: 0; margin-left: 88px;">合计：${ywOrder.hwMoney }</h6>
			<br>&nbsp;<br>
		</div>
	</div>
	<div class="row">
		<h6 style="padding: 0; margin: 40px">
			<div id="erWeiMa"></div>
		</h6>
	</div>
	<div class="row">
		<h6 style="padding: 0; margin: 8px">
			<svg id="svgcode"></svg>
		</h6>
		<script type="text/javascript">
				$("#svgcode").JsBarcode($("#orderid").val());//or JsBarcode("#imgcode", "I'm huangenai!"); 
			</script>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<h8 style="padding: 0; margin: 7px">.</h8>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h8 style="padding: 0; margin: 7px">.</h8>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h8 style="padding: 0; margin: 7px">.</h8>
		</div>
	</div>

	
	

</div>
<script type="text/javascript">
	window.onload=function doPrint() {
        try {
            pagesetup_null();
            erweima();
            newwin = window.open("", "newwin", "height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
            newwin.document.body.innerHTML = document.getElementById('myDiv').innerHTML+'<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
            //newwin.window.print();
			newwin.document.getElementById("PrintCommandObject").ExecWB(6,2); 
            newwin.window.close();
            pagesetup_default();
        } catch (e) { }
    }
	</script>
</html>