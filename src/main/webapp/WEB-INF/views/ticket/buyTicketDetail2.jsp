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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<tags:head_common_content />
<script type="text/javascript"
	src="${assets}/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${assets}/jquery/JsBarcode.all.js"></script>

<title>交易明細</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

html, body {
	/* width: 60mm; */
	/* height: 90mm; */
	margin: 0;
	padding: 0;
	font-family: "宋体", sans-serif;
}

body {
	font-family: "微软雅黑";
	background: #eeeeee;
	padding-top: 20px;
}

li {
	list-style: none;
}

.container {
	max-height: 851px;
}

.skin-blue-light .content-wrapper, .skin-blue-light .main-footer {
	border-left: 1px solid #d2d6de;
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
	width: 100%;
	margin: 0 auto;
}

.main {
	width: 90%;
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
/* #myDiv .innerWrap {
	width: 96%;
	margin: 0 auto;
}

#myDiv .innerWrap h6 span {
	width: 24%;
	text-algin: right;
	display: inline-block;
}
 */
/* #money .styleWid {
	width: 60px;
	text-algin: right;
	display: inline-block;
}
 */
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
		margin-right: 15px;
	}
}

        .ticket_box {
            font-family: "微软雅黑", sans-serif;
            width: 58mm;
            margin: 0 auto;
            font-size: 12px;
            text-align: center;
        }

        .tit {
            font-size: 15px;
            text-align: center;
        }

        table {
            border-collapse: collapse;
        }

        .subtit {
            font-family: "NeoTech";
            text-align: center;
            font-size: 12px;
        }

        #tk_tb {
            margin-top: 25px;
            font-size: 12px;
            text-align: center;
            border-bottom: 1px #000 dashed;
        }

        #tk_tb th {
            font-weight: normal;
            padding-bottom: 8px;
        }

        #tk_tb th div {
            display: inline-block;
            border-bottom: 1px #000 solid;
        }

        #tk_tb table {
            width: 100%;
        }

        #tk_tb td {
            padding-bottom: 8px;
        }

        #tk_tb .tk_td4 {
            text-align: right;
        }

        .tk_allbox {
            padding: 0 10%;
            margin-top: 18px;
        }

        .tk_l {
            float: left;
            text-align: left;
        }

        .tk_r {
            text-align: right;
        }

        .tk_dtbox {
            margin: 20px auto 5px;
            text-align: center;
        }

        .tk_mr {
            margin-right: 2%;
        }

        .wxcode {
            margin: 15px auto;
            padding-bottom: 100px;
        }

        #tk_tb .ta_l {
            text-align: left;
        }

        #tk_tb .ta_r {
            text-align: right;
        }

        .con_tit {
            margin: 0;
            padding: 0;
            font-size: 14px;
            text-align: left;
            margin-bottom: 5px;
            font-weight: normal;
        }
        .con_tit span{border-bottom:1px #000 solid;display:inline-block;}
        .con_subtit {
            margin: 0;
            padding: 0;
            font-size: 14px;
            text-align: left;
            margin-bottom: 5px;
            font-weight: normal;
        }
p, object {
	margin: 0;
	padding: 0;
}

.q_content {
	position: absolute;
	bottom: 95px;
	right: 0mm;
	top: 0;
	left: 0;
	font-family: "微软雅黑";
}

.q_container {
	position: relative;
	overflow: hidden;
	width: 60mm;
	height: 95mm;
}

.q_qrcode {
	position: absolute;
	bottom: 2mm;
	right: 0mm;
}

.noprint {
	margin-top: 20px;
}

.PageNext {
	page-break-after: always;
}

.q_tit {
	font-size: 20px;
	transform: rotate(-90deg);
	position: absolute;
	bottom: -1mm;
	white-space: nowrap;
	transform-origin: 0% 0%;
	left: 37mm;
}

.q_subtit {
	font-size: 16px;
	transform: rotate(-90deg);
	position: absolute;
	bottom: 0;
	white-space: nowrap;
	transform-origin: 0% 0%;
	left: 44mm;
}

.valid_date {
	font-size: 16px;
	transform: rotate(-90deg);
	position: absolute;
	bottom: 0;
	white-space: nowrap;
	transform-origin: 0% 0%;
	left: 54mm;
}

.v_d {
	font-family: "黑体", sans-serif;
}

.valid_date {
	margin-top: 18px;
}


@media print {
	/* body{transform:rotate(-90deg);transform-origin:200% 100%;} */
	.noprint {
		display: none;
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
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="staff" />

		<div class="content-wrapper" style="min-height: 851px;">
			<section class="content-header">
				<h1>现场购票作业</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/pwzy">现场管理</a></li>
					<li><a href="${ctx }/cpticket/tictek">非实名购票</a></li>
					<li class="active">非实名购票交易明细</li>
				</ol>
			</section>
			<div class="container">
				<div class="row">
					<div class="tip-img">
						<p>窗口购票</p>
					</div>
					<div class="content">
						<div class="main">
							<h3>交易明细</h3>
							<div class="form-line">
								<div class="table-left no-border table-responsive">

									<table class="table-left-table">
										<tr>
											<th style="text-algin: right;">票种</th>
											<th style="text-algin: right;">对象</th>
											<th style="text-algin: right;">单价</th>
											<th style="text-algin: right;">数量</th>
											<th style="text-algin: right;">金额</th>
										</tr>
										<c:forEach items="${countitem }" var="item">
											<tr>
												<td style="text-algin: right;">${item.hw_ticketname }</td>
												<td style="text-algin: right;">${item.hw_special_method }</td>
												<td style="text-algin: right;">${item.hw_unit_price }</td>
												<td style="text-algin: right;">${item.hw_ticket_count } </td>
												<td style="text-algin: right;">${item.hw_amount }</td>
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
											<input type="hidden" id="payType" value="${ywOrder.hwPayType}" />
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
										<li><button class="btn-blue" id="redayin">继续打印</button></li>
										<li><a href="${ctx}/cpticket/tictek"><button
													class="btn-orange">继续售票</button></a></li>
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
	<div id="myDiv" style="display: none;">
		<div class="ticket_box" style="font-family:'微软雅黑',sans-serif;width: 48mm;margin: 0 auto;font-size: 10px;text-align: center;">
			<div class="tit" style="font-size: 10px; text-align: center;">感谢光临福建天柱山欢乐大世界</div>
			<div class="subtit" style="font-family: 'NeoTech';text-align: center;font-size: 10px;">THANK YOU FOR VISITING FUJIAN TIANZHU
				MOUNTAIN HAPPYWORLDS</div>
			<c:forEach items="${countitem }" var="item">	
			<div id="tk_tb" style="margin-top: 15px;font-size: 10px;text-align: center;border-bottom: 1px #000 dashed;">
				<h3 class="con_tit">
					<span style="text-align:left;display:block;font-size:10px;font-weight:normal;"><span style="border-bottom:1px #000 solid;">票种TKT</span></span>
				</h3>
				<h3 class="con_subtit" style="display:block;text-align:left;font-weight:600;font-size:10px;"><span>${item.hw_ticketname}</span></h3>
				<table style=" border-collapse: collapse;width: 100%;">
					<tr>
						<th class="tk_td1 ta_l" style="font-weight: normal;padding-bottom: 8px;">
							<div style=" display: block;font-size:10px;text-align:left"><span style="border-bottom: 1px #000 solid;">游客类型OBJ</span></div>
						</th>
						<th class="tk_td2" style="font-weight: normal;padding-bottom: 8px;">
							<div style=" display: block;font-size:10px;text-align:center"><span style="border-bottom: 1px #000 solid;">数量QYT</span></div>
						</th>

						<th class="tk_td3 ta_r" style="font-weight: normal;padding-bottom: 8px;">
							<div style=" display: block;font-size:10px;text-align:right;"><span style="border-bottom: 1px #000 solid;">金额AMT</span></div>
						</th>
					</tr>
					<tbody>
						<tr>
							<td class="tk_td1 ta_l" style="padding-bottom: 8px;font-weight:600;font-size:10px">${item.hw_special_method}</td>
							<td class="tk_td2" style="padding-bottom: 8px;text-align:center;font-size:10px;">${item.hw_ticket_count}</td>
							<td class="tk_td3 ta_r" style="padding-bottom: 8px;text-align:right;font-size:10px">￥${item.hw_amount}</td>
						</tr>
						<!-- <tr>
							<td class="tk_td1 ta_l" style="padding-bottom: 8px;font-weight:600;font-size:10px">成人</td>
							<td class="tk_td2" style="padding-bottom: 8px;text-align:center;font-size:10px;">2</td>
							<td class="tk_td3 ta_r" style="padding-bottom: 8px;text-align:right;font-size:10px">￥1500.00</td>
						</tr> -->
					</tbody>
				</table>
			</div>
			</c:forEach>
			<div class="tk_allbox" style=" padding: 0 10%;margin-top: 18px;">
				<div>
					<div class="tk_l" style=" float: left;text-align: left;">总金额/TOTAL</div>
					<div class="tk_r" style=" text-align: right;">￥${ywOrder.hwMoney}</div>
				</div>
				<div>
					<div class="tk_l" style=" float: left;text-align: left;">实付/PAID</div>
					<div class="tk_r" style=" text-align: right;">￥${ywOrder.hwMoney}</div>
				</div>
				<div id="zl_box" style="display:none;">
					<div class="tk_l" style=" float: left;text-align: left;">找零/CHANGE</div>
					<div class="tk_r" style=" text-align: right;" >￥<span id="zl"></span></div>
				</div>
				<div>
					<div class="tk_l" style=" float: left;text-align: left;">
						<c:if test="${ywOrder.hwPayType eq 'CASH' }">现金</c:if>
						<c:if test="${ywOrder.hwPayType eq 'XC_WX' }">微信支付</c:if>
						<c:if test="${ywOrder.hwPayType eq 'XC_ZFB' }">支付宝支付</c:if>
						<c:if test="${ywOrder.hwPayType eq 'JSAPI' }">公众号微信支付</c:if>
						<c:if test="${ywOrder.hwPayType eq 'APP' }">app微信</c:if>
						<c:if test="${ywOrder.hwPayType eq 'POS' }">pos机刷卡支付</c:if>
						<c:if test="${ywOrder.hwPayType eq 'ZNPOS' }">智能pos刷卡支付</c:if>
						<c:if test="${ywOrder.hwPayType eq 'YLTLH5' }">H5快捷支付</c:if>
						<c:if test="${ywOrder.hwPayType eq 'ZD_POS' }">自助终端POS支付</c:if>/${ywOrder.hwPayType}
					</div>
					<div class="tk_r" style=" text-align: right;">&nbsp;</div>
				</div>
			</div>
			<div class="tk_dtbox" style="margin: 20px auto 5px;text-align: center;">
				<span class="tk_s tk_mr" style="margin-right: 2%;" id="tk_t">07:55</span> <span class="tk_t tk_mr" style="margin-right: 2%;" id="tk_d">07/10/2017</span>
				<input type="hidden" value="${ywOrder.hwOrderPaytime}" id="ticket_t">
				<span class="tk_order">订单号:${ywOrder.hwOrderId}</span>
			</div>
			<div style="white-space: nowrap;">此收据是您购票的重要凭证，请妥善保管</div>
			<div>www.happyworlds.com</div>
			<div class="wxcode" style="margin: 15px auto;padding-bottom: 100px;">
				<img 
					src="data:image/png;base64,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">
				<div>*微信公众号</div>
			</div>	
		</div>
		<div style="width:100%;height:10px;border:1px solid #ccc;"></div> 
	</div>
	<%-- <div id="myDiv" style="display: none;">
		<c:forEach items="${orderItems }" var="item">
			<h3 style="margin-left: 35px;">乐园小票凭条</h3>
			<table class="table table-responsive "
				style="font-size: 14px; margin-left: 5px;">
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
					<td style="text-align: right;">RMB ${item.hwSpecialMethod}</td>
				</tr>
				<tr>
					<td>票劵价格：</td>
					<td style="text-align: right;">RMB ${item.hwAmount }</td>
				</tr>
			</table>
			<h6 style="padding: 0; margin: 40px">
				<div class="code" id="erweima-${item.hwOrderitemId}"
					code-content="${item.hwOrderitemId }"></div>
			</h6>
			<div class="code" id="erweima-${item.hwOrderitemId}" code-content="${item.hwOrderitemId }"></div>
			<svg id="svgcode${item.hwOrderitemId}"></svg>
			<div>
				<h8 style="padding: 0; margin: 7px">.</h8>
			</div>
			<div>
				<h8 style="padding: 0; margin: 7px">.</h8>
			</div>
			<div>
				<h8 style="padding: 0; margin: 7px">.</h8>
			</div>

		</c:forEach>
	</div> --%>

	<div id="paperTicket" style="display: none;">
		 <style>
            html,
            body {
                /* width: 60mm; */
                /* height: 90mm; */
                margin: 0;
                padding: 0;
                font-family: "宋体", sans-serif;
            }

            p,
            object {
                margin: 0;
                padding: 0;
            }

            .q_content {
                position: absolute;
                bottom: 95px;
                right: 0mm;
                top: 0;
                left: 0;
                font-family:"微软雅黑";
            }

            .q_container {
                position: relative;
                overflow: hidden;
                width: 60mm;
                height: 95mm;
            }

            .q_qrcode {
                position: absolute;
                bottom: 2mm;
                right: 0mm;
            }

            .noprint {
                margin-top: 20px;
            }

            .PageNext {
                page-break-after: always;
            }

            .q_tit {
                font-size: 20px;
                transform: rotate(-90deg);
                position: absolute;
                bottom: -1mm;
                white-space: nowrap;
                transform-origin: 0% 0%;
                left: 37mm;
                
            }

            .q_subtit {
                font-size: 16px;
                transform: rotate(-90deg);
                position: absolute;
                bottom: 0;
                white-space: nowrap;
                transform-origin: 0% 0%;
                left: 44mm;
            }

            .valid_date {
                font-size: 16px;
                transform: rotate(-90deg);
                position: absolute;
                bottom: 0;
                white-space: nowrap;
                transform-origin: 0% 0%;
                left: 54mm;
            }

            .v_d {
                font-family: "黑体", sans-serif;
            }

            .valid_date {
                margin-top: 18px;
            }

            @media print {
                /* body{transform:rotate(-90deg);transform-origin:200% 100%;} */
                .noprint {
                    display: none;
                }
            }
        </style>
		<c:forEach items="${orderItems }" var="item" varStatus="status">
			<c:choose>
				<c:when test="${status.index == 0 }">
					<div class="q_container">
						<div id="q__${item.hwOrderitemId}" data-id="${item.hwOrderitemId}"
							class="q_qrcode"></div>
						<div class="q_content">
							<p class="q_tit">
								<span style="margin-right: 8px">${item.hwTicketName}</span>${item.hwSpecialMethod}票</p>
							<p class="q_subtit">1D STANDARD</p>
							<p class="valid_date">
								有效期 <span class="v_d">18/10/17</span>
							</p>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="PageNext"></div>
					<div class="q_container">
						<div id="q__${item.hwOrderitemId}" data-id="${item.hwOrderitemId}"
							class="q_qrcode"></div>
						<div class="q_content">
							<p class="q_tit">
								<span style="margin-right: 8px">${item.hwTicketName}</span>${item.hwSpecialMethod}票</p>
							<p class="q_subtit">1D STANDARD</p>
							<p class="valid_date">
								有效期 <span class="v_d">18/10/17</span>
							</p>
						</div>
					</div>
				</c:otherwise>
			</c:choose>

		</c:forEach>
		<!-- <div class="PageNext"></div>
    <div class="q_container">
        <div id="qrcode_9123" data-id="9123" class="q_qrcode"></div>
        <div class="q_content">
            <p class="q_tit">海洋馆 成人票</p>
            <p class="q_subtit">1D STANDARD</p>
            <p class="valid_date">有效期
                <span class="v_d">18/10/17</span>
            </p>
        </div>
    </div> -->
	</div>
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />

	<br />
	<br />

	<script type="text/javascript"
		src="${assets}/jquery/jquery.qrcode.min.js"></script>
	<script src="${assets}/bootstrap/js/BuyTicket2.js"></script>
	<script>
		var payType = $("#payType").val();
		var receiptsPrice = "${receiptsPrice}";
		var payTotal = "${ywOrder.hwMoney}";
		var zhaoling = parseFloat(receiptsPrice).toFixed(2) - parseFloat(payTotal).toFixed(2);
		var zl = zhaoling.toFixed(2);
		if (payType == 'CASH') {
			$("#zl_box").show();
			$("#zl").text(zhaoling);
			$("#money").append("<li><span class='styleWid'>收银:</span><span>"
									+ receiptsPrice
									+ "</span></li><li><span class='styleWid'>找零:</span><span>"
									+ zl + "</span></li>");
		}
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
			render : "table",
			text : str,
			width : 120, //设置宽度
			height : 120
		});
	});
	$('.q_qrcode').each(function() {
		var qrid = $(this).attr('id');
		var qrnum = $(this).attr('data-id');
		$('#' + qrid).qrcode({
			render : 'table',
			text : qrnum,
			width : 85,
			height : 85
		});
	});
	//解决二维码中文问题
	function utf16to8(str) {
		var out, i, len, c;
		out = "";
		len = str.length;
		for (i = 0; i < len; i++) {
			c = str.charCodeAt(i);
			if ((c >= 0x0001) && (c <= 0x007F)) {
				out += str.charAt(i);
			} else if (c > 0x07FF) {
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

	/* 设置页眉页脚 */
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
	/* 设置页面边距 */
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
			Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "2.465");
		} catch (e) {

		}
	}

	/* 设置页面边距 */
	function pagesetup_default1() {
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
			Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0");
			hkey_key = "margin_bottom";
			//设置下页边距   
			Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0");
		} catch (e) {

		}
	}

	/* 设置默认打印机 */
	// 设置默认打印机
	function getDefault(printObj) {
		var shells = new ActiveXObject("WScript.Shell");
		shells.RegWrite("HKEY_CURRENT_USER\\Software\\Microsoft\\Windows NT\\CurrentVersion\\Windows\\Device",printObj + ",winspool,Ne01:", "REG_SZ");
	}
	/* function doPrint() {
		try {
			pagesetup_null();
			newwin = window.open("", "newwin", "height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
			newwin.document.body.innerHTML = document.getElementById('myDiv').innerHTML + '<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
			//newwin.window.print();
			newwin.document.getElementById("PrintCommandObject").ExecWB(6, 2);
			newwin.window.close();
			pagesetup_default();
		} catch(e) {}
	} */
	function printPaper(obj) {
		try {
			getDefault(obj);
			pagesetup_null();
			newwin = window.open("", "newwin","height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
			pagesetup_default1();
			newwin.document.body.innerHTML = document.getElementById('paperTicket').innerHTML+'<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
			newwin.document.getElementById("PrintCommandObject").ExecWB(6, 2);
			newwin.window.close();

		} catch (e) {
		}
	}
	function printX(obj) {
		try {
			getDefault(obj);
			pagesetup_default();
			newwin = window.open("", "newwin","height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
			newwin.document.body.innerHTML = document.getElementById('myDiv').innerHTML+ '<object ID="printXObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
			newwin.document.getElementById("printXObject").ExecWB(6,2);
			newwin.window.close();
		} catch (e) {
		}
	}
</script>
<script type="text/javascript"> 
	/* window.onload = function doPrint() {
		try {
			pagesetup_null();
			newwin = window.open("", "newwin", "height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
			newwin.document.body.innerHTML = document.getElementById('myDiv').innerHTML + '<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
			//newwin.window.print();
			newwin.document.getElementById("PrintCommandObject").ExecWB(6, 2);
			newwin.window.close();
			pagesetup_default();
		} catch(e) {}
	} */
	window.onload = function() {
		var dt = $("#ticket_t").val();
		var h = dt.substring(9,11);
		var min = dt.substring(11,13);
		var y = dt.substring(0,4);
		var m = dt.substring(4,6);
		var d = dt.substring(6,8);
		var tt = d+"/"+m+"/"+y;
		var dd = h+":"+min;
		$("#tk_d").text(tt);
		$("#tk_t").text(dd);
		printX('BTP-N58II(U)');
		setTimeout(function() {
			printPaper('LENOO K301');
			setTimeout(function(){
				getDefault('BTP-N58II(U)');
			},100)
		}, 1000);
		
		/* 继续打印 */
		$('#redayin').click(function() {
			printX('BTP-N58II(U)');
			setTimeout(function() {
				printPaper('LENOO K301');
				setTimeout(function(){
					getDefault('BTP-N58II(U)');
				},100)
			}, 1000);
		});
	}
</script>

</html>