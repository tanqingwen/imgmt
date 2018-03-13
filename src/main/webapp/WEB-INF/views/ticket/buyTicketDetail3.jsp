<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<%-- 	<tags:head_common_content /> --%>
		<link rel="stylesheet" href="${assets}/bootstrap/css/bootstrap.min.css" />
		<script type="text/javascript" src="${assets}/jquery/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="${assets}/jquery/JsBarcode.all.js"></script>

		<title>交易明細</title>
		<style type="text/css">
			* {
				margin: 0;
				padding: 0;
			}
			
			li {
				list-style: none;
			}
			
			.container {
				max-height: auto;
			}
			.skin-blue-light .content-wrapper,
			.skin-blue-light .main-footer {
				border-left: 1px solid #d2d6de;
			}
			
			body {
				font-family: "微软雅黑";
				background: #eeeeee;
				padding-top: 20px;
			}
			
			.container-fluid {
				width: 100%;
				margin: 0 auto;
			}
			
			.row {
				width: 98%;
				margin: 20px auto;
				position: Relative;
				background: white;
			}
			
			.tip-img {
				position: absolute;
				left: -80px;
				top: -12px;
			}
			
			.content {
				width: 100%;
				margin: 0 auto;
			}
			
			.main {
				width: 90%;
				margin: 0 auto 50px;
			}
			
			 h3 {
				width: 100%;
				height: 60px;
				margin-top: 0;
				line-height: 60px;
				font-family: "微软雅黑";
				background-color:#3c8dbc;
			}
			
			.form-line {
				margin: 25px auto 10px 0;
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
				width: 100px;
				height: 46px;
				border: none;
				border-radius: 5px;
				-webkit-border-radius: 5px;
			}
			
			.btn-blue {
				background-image: url(${assets }/app/img/蓝色.png);
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
			
			@media screen and (max-width: 767px) {
				.table-responsive {
					border: none;
				}
				.table-left {
					width: 100%;
				}
				.table-right {
					float: left;
					width: 100%;
				}
				.table-right ul li {
					float: left;
				}
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
<%-- 			<tags:main_header /> --%>
			
			<!-- Left side column. contains the logo and sidebar -->
<%-- 			<tags:main_sidebar active="staff" /> --%>
			
			<div class="content-wrapper" style="min-height: 851px;">
<%-- 				<section class="content-header">
		          <h1>现场购票作业</h1>
		          <ol class="breadcrumb">
		            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
		            <li><a href="${ctx }/startTreeviewDetail/pwzy">现场管理</a></li>
		            <li><a href="${ctx }/cpticket/tictek">非实名购票</a></li>
		            <li class="active">非实名购票交易明细</li>
		          </ol>
		        </section> --%>
				<div class="container-fulid">
				<h3 class="text-center" >交易明细</h3>
					<div class="row" style="margin:0 auto;width:100%;">
					<!-- 	<div class="tip-img">
							<p>窗口购票</p>
						</div> -->
						<div class="content">
							<div class="main">
								
								<div class="form-line">
									<div class="table-left no-border table-responsive">

										<table class="table-left-table">
											<tr>
												<th style="text-algin:right;">票种</th>
												<th style="text-algin:right;">对象</th>
												<th style="text-algin:right;">单价</th>
												<th style="text-algin:right;">数量</th>
												<th style="text-algin:right;">金额</th>
											</tr>
											<c:forEach items="${orderItems }" var="item">
												<tr>
													<td style="text-algin:right;">${item.hwTicketName }</td>
													<td style="text-algin:right;">${item.hwSpecialMethod }</td>
													<td style="text-algin:right;">${item.hwAmount }</td>
													<td style="text-algin:right;">${item.hwTicketCount } </td>
													<td style="text-algin:right;">${item.hwTicketCount * item.hwAmount +item.hwChargeAmount }</td>
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
												<input type="hidden" id="payType" value="${ywOrder.hwPayType }" />
											</div>
											<div class="table-bottom-box-right">
												<ul id="money">
													<li><span class='styleWid'>总金额:</span><span>${ywOrder.hwMoney }</span></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="table-right" style="margin-top:50px;">
										<ul class="col-md-12">
											<li class="col-md-6 text-center"><button class="btn-blue" id="redayin">打印</button></li>
											<li  class="col-md-6 text-center"><a href="${ctx}/cpticket/feishiming"><button class="btn-orange">继续售票</button></a>
											</li>
										</ul>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--mark-->
			<div class="markbox" style="display:none;"></div>
			<!--ä»æ¬¾å¼¹åºæ¡-->
			<div class="mark1" style="display:none;">
				<div class="close">
					<span><img src="${assets }/app/img/窗口购票.png" id="closedimg"/></span>
				</div>
				<div class="clearfix"></div>
				<div class="mark1-main">
					<h2>打印中...</h2>
				</div>
			</div>
		</div>
		<div id="myDiv" style="display:none;">
			<c:forEach items="${orderItems }" var="item">
				<h3 style="margin-left:35px;">乐园小票凭条</h3>
				<table class="table table-responsive " style="font-size:14px;margin-left:5px;">
					<tr>
						<td>订单编号：</td>
						<td style="text-align: right;">${ywOrder.hwOrderId }</td>
					</tr>
					<tr>
						<td>交易时间：</td>
						<td style="text-align: right;">${ywOrder.hwOrderPaytime }</td>
					</tr>
					<tr>
						<td>票劵名称：</td>
						<td style="text-align: right;">RMB ${item.hwTicketName}</td>
					</tr>
					<tr>
						<td>票劵类型：</td>
						<td style="text-align: right;">RMB ${item.hwSpecialMethod }</td>
					</tr>
					<tr>
						<td>票劵价格：</td>
						<td style="text-align: right;">RMB ${item.hwAmount }</td>
					</tr>
				</table>
				<h6 style="padding:0;margin:40px"><div class="code" id="erweima-${item.hwOrderitemId}" code-content="${item.hwOrderitemId }"></div></h6>
				<%-- <div class="code" id="erweima-${item.hwOrderitemId}" code-content="${item.hwOrderitemId }"></div> --%>
				<%-- <svg id="svgcode${item.hwOrderitemId}"></svg> --%>

			</c:forEach>
		</div>
		<tags:main_footer />

		<!-- Control Sidebar -->
	<%-- 	<tags:control_sidebar /> --%>
		<!-- ./wrapper -->

<%-- 		<tags:load_common_js /> --%>

		<br /><br />

		<script type="text/javascript" src="${assets}/jquery/jquery.qrcode.min.js"></script>
		<script src="${assets}/bootstrap/js/BuyTicket2.js"></script>
		<script>
		 console.log('${ywOrder.hwOrderId }');
       var array = new Array();
       var str='';
      <c:forEach items="${orderItems }" var="item" varStatus="status" >  
        array.push("${item}"); 
        var orderid= '${ywOrder.hwOrderId }';
        var itemid = '${item.hwOrderitemId}';
        var tobj = '${item.hwTicketName }';
        var ttype='${item.hwSpecialMethod }';
        var tamount = '${item.hwAmount }';
        console.log('${ywOrder.hwOrderId }');
        var perstr = itemid+','+orderid+','+tobj+','+ttype+','+tamount+';';
        str +=  perstr;
        console.log(str);
        console.log('${item.hwOrderitemId}');
   //         alert("${status.count}");   //获得其下标,加引号 
        var temp = "${item}";  
    </c:forEach>  
    var tpaytype = '${ywOrder.hwPayType }';
    console.log(tpaytype);
    var typeflag =1;
    if(tpaytype == 'CASH'){
    	console.log("现金支付");
    	 typeflag = 2;
    }
    console.log(typeflag);
    str = typeflag +';'+str;
  //  window.jsObj.sendData(str);
    for(var i=0;i<array.length;i++){  
     //  alert(array[i]);   
    }   
			var payType = $("#payType").val();
			var receiptsPrice = '${receiptsPrice}';
			var payTotal = '${ywOrder.hwMoney}';
			var zhaoling = parseInt(receiptsPrice).toFixed(2) - parseInt(payTotal).toFixed(2);
			var zl = zhaoling.toFixed(2);
			if(payType == 'CASH') {
				$("#money").append("<li><span class='styleWid'>收银:</span><span>" + receiptsPrice + "</span></li><li><span class='styleWid'>找零:</span><span>" + zl + "</span></li>");
			}
	
			$('#redayin').click(function(){
				 $(this).text("重复打印"); 
			       var str='';
			       <c:forEach items="${orderItems }" var="item" varStatus="status" >  
			         array.push("${item}"); 
			         var orderid= '${ywOrder.hwOrderId }';
			         var itemid = '${item.hwOrderitemId}';
			         var tobj = '${item.hwTicketName }';
			         var ttype='${item.hwSpecialMethod }';
			         var tamount = '${item.hwAmount }';
			         console.log('${ywOrder.hwOrderId }');
			         var perstr = itemid+','+orderid+','+tobj+','+ttype+','+tamount+';';
			         str +=  perstr;
			         console.log(str);
			         console.log('${item.hwOrderitemId}');
			         /*         alert("${status.count}");   //获得其下标,加引号 */
			         //var temp = "${item}";  
			     </c:forEach>  
			     var tpaytype = '${ywOrder.hwPayType }';
			     console.log(tpaytype);
			     var typeflag =1;
			     if(tpaytype == 'CASH'){
			     	console.log("现金支付");
			     	 typeflag = 2;
			     }
			     console.log(typeflag);
			 /*     alert(tyepflag); */
			     str = typeflag +';'+str;
			     window.jsObj.sendData(str);
			});
		</script>
	</body>
	<script type="text/javascript">
		$(".code").each(function() {
			var id = $(this).attr("id");
			var str = $(this).attr("code-content");
			var svg = 'svgcode';
			var itrmid = svg + str;
			/* JsBarcode("#"+itrmid, str); */
			jQuery("#" + id).qrcode({
				render: "table",
				text: str,
				width: 120, //设置宽度
				height: 120
			});
		})
		//解决二维码中文问题
		function utf16to8(str) {
			var out, i, len, c;
			out = "";
			len = str.length;
			for(i = 0; i < len; i++) {
				c = str.charCodeAt(i);
				if((c >= 0x0001) && (c <= 0x007F)) {
					out += str.charAt(i);
				} else if(c > 0x07FF) {
					out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
					out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
					out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
				} else {
					out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
					out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
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
			} catch(e) {}
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
			} catch(e) {

			}
		}

		function doPrint() {
			try {
				pagesetup_null();
				newwin = window.open("", "newwin", "height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
				newwin.document.body.innerHTML = document.getElementById('myDiv').innerHTML + '<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
				//newwin.window.print();
				newwin.document.getElementById("PrintCommandObject").ExecWB(6, 2);
				newwin.window.close();
				pagesetup_default();
			} catch(e) {}
			console.log(orderId);
	/* 		window.jsObj.HtmlcallJava(orderId); */
		}
	</script>
	<script type="text/javascript">
		window.onload = function doPrint() {
			try {
				pagesetup_null();
				newwin = window.open("", "newwin", "height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
				newwin.document.body.innerHTML = document.getElementById('myDiv').innerHTML + '<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
				//newwin.window.print();
				newwin.document.getElementById("PrintCommandObject").ExecWB(6, 2);
				newwin.window.close();
				pagesetup_default();
			} catch(e) {}
		}
	</script>

</html>