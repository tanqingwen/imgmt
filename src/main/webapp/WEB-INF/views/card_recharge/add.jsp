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
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<link rel="stylesheet" href="${assets }/layer/shin/layer.css" />
		<title>会员卡充值</title>
		<link rel="stylesheet" href="${assets }/css/memberShip.css" />
	</head>

	<body  class="hold-transition skin-blue-light sidebar-mini">
		
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
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img"><img src="${assets }/app/img/membership.png"></div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
						<form id="defaultForm" name="defaultForm" class="form-horizontal">
							<div class="form-line clearfix">
								<div class="col-lg-12 ">
									<div class="col-lg-6">
										<div class="form-group ">
											<label for="rechargeAmount">充值金额：</label><input class="form-control formConl" type="text" name="rechargeAmount" id="rechargeAmount" />
										</div>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<h3 style="border-bottom: 2px dashed #6fba2c;">硬件录入</h3>
							<div class="form-line clearfix">
								<div class="col-lg-12 mag">
									<div class="col-lg-6">
										<div class="form-group">
											<label for="balance">会员卡余额：</label><input type="text" class="line-input" id="balance" name="balance" disabled="disabled"/>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group holderNo">
											<label for="cbCardholderNo">持卡人号码：</label><input type="text" id="cbCardholderNo" name="cbCardholderNo" class="line-input" style="width:202px;margin-right:2px;" disabled="disabled" />
											<button type="button" class="btn-size" onclick="findCard()">读卡信息</button><span style="color:blue;font-weight:bold" id="cardstatus"></span>
										</div>
									</div>
								</div>

								<div class="clearfix"></div>
								<div class="col-lg-12 mag">
									<div class="col-lg-6">
										<div class="form-group">
											<label for="idNo">身份证号码：</label><input type="text" name="idNo" id="idNo" value="" class="line-input" disabled="disabled">
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<label for="userName">会员卡姓名：</label><input type="text" name="username" id="username" value="" class="line-input" disabled="disabled">
										</div>
									</div>

								</div>
								<div class="col-lg-12 mag">
									
									<div class="col-lg-6">
										<div class="form-group">
											<label for="birth">出生日期：</label><input type="text" name="birth" id="birth" value="" class="line-input" disabled="disabled">
										</div>
									</div>

								</div>
							</div>
							<div class="clearfix"></div>

							<div class="col-lg-12" style="margin:50px 0 20px 0">
								<div class="col-lg-12 mag">
									<div style="float:left;">
										<a href="${ctx }/startTreeviewDetail/hykzy"  class="form-a">
											&lt;返回</a>
								<span style="margin:0 15px;display: inline-block;">
					   				
					   			</span>
									</div>
									<div style="float:right;">
										<input type="hidden" value="" id="hidden" />
										<span style="color: red; margin-right: 45px; font-size: 18px;">支付总额：<strong id="Amount" class="">￥0.00
												</strong></span>
										<button type="button" class="btn-size" style="width:110px;margin:0 25px 0 15px;" id="memberShip">确定</button>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</form>

					</div>
				</div>
			</div>
			<div class="markbox" style="display: none;"></div>
			<!--支付方式选择弹框-->
			<div class="mark2" style="display: none;">
				<div class="close">
					<span><img src="${assets }/app/img/close.png" class="closedimg"/></span>
				</div>
				<div class="innerMark2">
					<ul class="payType">
						<li class="wechat">
							<img src="${assets }/app/img/wechat.png" />微信支付
						</li>
						<li class="Alipay">
							<img src="${assets }/app/img/apliy.png" />支付宝支付
						</li>
						<li class="UnionPay" onclick="demo()">
							<img src="${assets }/app/img/UnionPay.png" />银联支付
						</li>
						<li class="ZhiNengPos">
							<img src="${assets }/app/img/pay7.jpg" />智能pos
						</li>
						<!--<li class="happyWorld">
							<img src="" />乐园卡支付
						</li> -->
						<li class="CashPayment">
							<img src="${assets }/app/img/cash.png" />现金支付
						</li>
					</ul>
				</div>
			</div>
			<!--现金支付弹框-->
			<div class="mark3" style="display:none;">
				<div class="all"><label for="">总计</label><input type="text" id="allPrice" disabled="disabled" /></div>
				<div class="receipts"><label for="">实收</label><input type="text" id="receiptsPrice" /></div>
				<div class="change"><label for="">找零</label><input type="text" id="changePrice" /></div>
				<div class="sureOrder">
					<a href="javascript:void(0)" id="cashPay"><input  id="cashPayBtn" value="确定" type="button" /></a>
				</div>
			</div>
			<!--支付超时-->
			<div class="mark4" style="display: none;">
				<div class="close">
					<span><img src="${assets }/app/img/close.png"class="closedimg"/></span>
				</div>
				<div class="mark4Content">
					<h1 class="">支付超时</h1>
					<h2 class="overtime">错误码：交易超时</h2>
					<div class="repayment"><button id="ErrorBtn">重新支付</button></div>
				</div>
			</div>
			<!--等待付款弹框-->
			<div class="mark5" style="display: none;">
				<div class="close">
					<span><img src="${assets }/app/img/close.png" /></span>
				</div>
				<div class="mark5Content">
					<h1 class="">等待付款...</h1>
					<h4 class="">请使用扫码枪扫描付款码</h4>
					<input type="hidden" id="formOrderId" name="formOrderId">
					<input type="hidden" id="formAmount" name="formAmount" value="0.01">
					<div class=""><label for="">付款码</label><input type="text" id="payCode" name="payCode" /></div>
				</div>
			</div>
			<!--支付成功弹框-->
			<div class="mark7" style="display: none;">
				<div class="mark7Content">
					<h1 class="">支付成功</h1>
					<div class="">
						<a href="javascript:void(0)"><button id="successBtn">确定</button></a>
					</div>
				</div>
			</div>

		</div>
		<object classid="CLSID:76A64158-CB41-11D1-8B02-00600806D9B6" id="locator" style="display:none;visibility:hidden"></object>
		<object classid="CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223" id="foo" style="display:none;visibility:hidden"></object> 
		<input type="hidden" name="ipAddress"> 
		<tags:control_sidebar/>

	<tags:load_common_js/>
	</div>
		<input type="hidden" value="3" id="test" />
		<script src="${assets }/layer/layer.js"></script>
		<script language="javascript">
		var sIPAddr="";
		var service = locator.ConnectServer();
		service.Security_.ImpersonationLevel=3;
		service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
		</script>
		<script FOR="foo" EVENT="OnObjectReady(objObject,objAsyncContext)" LANGUAGE="JScript">
	        if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true){
	                 if(objObject.IPEnabled && objObject.IPAddress(0) !=null && objObject.IPAddress(0) != "undefined")
	                               sIPAddr = objObject.IPAddress(0);
	                 
	                      
	         } 
		</script>
		<script language="javascript">
		
		var orderId = "";
		var amount = 0;

		function zhinengpos(orderId, amount) {
			$.ajax({
				type: 'POST',
				data: {
					"orderId": orderId,
					"amount": amount,
					"ip": sIPAddr,
					"business_id": "100100001"
				},
				url: '${ctx}/CardRecharge/tonglian/pos',
				dataType: 'json',
				success: function(data) {
					if(data.status == 'SUCCESS') {
						setTimeout(function() {
							$(".markbox").hide();
							$(".mark7").hide();
						}, 10000)
						var time = setInterval(showTime, 1000);
						var second = 3;

						function showTime() {
							if(second == 0) {
								clearInterval(time);
								window.location = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + orderId;
							}
							$("#successBtn").html(' 确定' + second + 's');
							second--;
						}
						$("#successBtn").click(function() {
							$(".markbox").hide();
							$(".mark7").hide();
							window.location.href = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + orderId;
						})
					} else {
						$(".markbox").show();
						$(".mark4").show();
						$("#ErrorBtn").click(function() {
							$(".mark4").hide();
							$(".mark5").show();
						});
					}
				}
			});
		}
		//生成订单
		function generateOrder(payType) {
			amount = parseFloat($("#rechargeAmount").val()).toFixed(2);
			var cbCardholderNo = $("#cbCardholderNo").val();
			cbCardholderNo = "<%=Constants.baseBIN%>" + cbCardholderNo;
			console.log(sIPAddr);
			$.ajax({
				url: '${ctx}/CardRecharge/charge/start',
				type: 'POST',
				dataType: "json",
				data: {
					"amount": amount,
					"cardNumber": cbCardholderNo,
					"hw_channel":'3',
					"payType": payType,
					"hwIp": sIPAddr
				},
				success: function(data) {
					if(data.status == "OK") {
						var id = data.value;
						console.log("订单:" + id);
						$("#formOrderId").val(id);
						$("#formAmount").val(amount);
						orderId = id;
						if("ZNPOS" == payType) {
							zhinengpos(orderId, amount);
						}
					}
				}
			})
		}

		function demo() {
			generateOrder("pos");
			var request = new ActiveXObject("ALLINPAY.RequestData");
			var response = new ActiveXObject("ALLINPAY.ResponseData");
			var mis = new ActiveXObject("ALLINPAY.MisPos");
			request.PutValue("CardType", "01");
			request.PutValue("TransType", "02");
			request.PutValue("Amount", amount);
			var result = mis.TransProcess(request, response);
			var PosTraceNumber = response.GetValue("PosTraceNumber");
			if(response.GetValue("Rejcode") == '00') {
				$.ajax({
					type: 'POST',
					data: {
						"orderId": orderId,
						"payType": "pos",
						"receiptsPrice": "",
						"hwPaymentListid": PosTraceNumber
					},
					url: '${ctx}/CardRecharge/updateOrderStatus',
					dataType: 'json',
					success: function(data) {
						if(data.status == 'SUCCESS') {
							//清空购物车

							setTimeout(function() {
								$(".markbox").hide();
								$(".mark7").hide();
							}, 3000)

							var time = setInterval(showTime, 1000);
							var second = 3;

							function showTime() {
								if(second == 0) {
									clearInterval(time);
									window.location = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + orderId;

								}
								$("#successBtn").html(' 确定' + second + 's');
								second--;
							}
							$("#successBtn").click(function() {
								$(".markbox").hide();
								$(".mark7").hide();
								window.location.href = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + orderId;
							})
						} else {
							$(".markbox").show();
							$(".mark4").show();
							$("#ErrorBtn").click(function() {
								$(".mark4").hide();
								$(".mar5").show();
							});
						}
					}
				});
			}

			delete request;
			delete response;
			delete mis;
			CollectGarbage();
		}

		$(function() {
			$("#receiptsPrice").bind('input porpertychange', function() {
				var all = $("#allPrice").val();
				var receipts = $("#receiptsPrice").val();
				var change = parseFloat((receipts - 0) - (all - 0));

				$('#changePrice').val(change.toFixed(2));
			});

		});

		$("#rechargeAmount").blur(function() {
			var recharge = $(this).val();
			if(recharge == "") {
				recharge = 0.00;
			} else {
				console.log(recharge);

				$("#Amount").text(parseFloat(recharge).toFixed(2));
			}
		})

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
			var username = $.trim($("#username").val()); //证件姓名
			var birth = $.trim($("#birth").val); //出生日期
			if(!cbCardholderNo) {
				layer.msg("持卡人号码不能为空");
				return false;
			}

			return true;
		}
		//确定
		$("#memberShip").click(function() {
			if(!validateCart()) {
				return;
			}
			$(".markbox").css("height", $(document).height());
			$(".markbox").css("width", $(document).width());
			$(".markbox").show();
			$(".mark2").show();

		});

		$(".close").click(function() {
			$(".markbox").hide();
			$(".mark2").hide();
			$(".mark5").hide();
		})
		$(".markbox").click(function() {
			$(".markbox").css("display", "none");
			$(".mark2").css("display", "none");

		})

		$(".close").click(function(){
		$(this).parents(".mark4").hide();
		$(this).parents(".markbox").hide();		
	})
	$(".markbox").click(function(){
		$(this).siblings(".mark4").hide();
	})

		//现金支付弹框
		$('.CashPayment').click(function() {
			generateOrder("CASH");
			$(".markbox").css("height", $(document).height());
			$(".markbox").css("width", $(document).width());
			$("#allPrice").val(parseFloat($("#rechargeAmount").val()).toFixed(2));
			$("#receiptsPrice").val("");
			$("#changePrice").val("");
			$(".markbox").show();
			$(".mark3").show();
		})
		$('.ZhiNengPos').click(function() {
			generateOrder("ZNPOS");

		})
		$(".close").click(function() {
			$(".markbox").css("display", "none");
			$(".mark3").css("display", "none");
		})
		$(".markbox").click(function() {
			$(".markbox").css("display", "none");
			$(".mark3").css("display", "none");
		})

		//支付宝或者微信支付弹框
		var timer1;
		//支付宝或者微信支付弹框
		$('.Alipay').click(function() {
			generateOrder("XC_ZFB");
			$(".markbox").css("height", $(document).height());
			$(".markbox").css("width", $(document).width());
			$(".markbox").show();
			$(".mark5").show();
			$("#payCode").focus();
			/* timer1 = setInterval("tonglianpay('A04')", 400); */
		})
		$('.wechat').click(function() {
			generateOrder("XC_WX");
			$(".markbox").css("height", $(document).height());
			$(".markbox").css("width", $(document).width());
			$(".markbox").show();
			$(".mark5").show();
			$("#payCode").focus();
		/* 	timer1 = setInterval("tonglianpay('W04')", 400); */
		})
	
			//扫码支付
$('#payCode').keyup(function(event){
	var kcode = event.which || event.keyCode;
	if(kcode == '13'){
		var payCode=$.trim($('#payCode').val());
		var formAmount = $("#formAmount").val();
		var formOrderId = $("#formOrderId").val();
		if(payCode!=null && payCode!='' && payCode.length>5){
			$.ajax({
				url:cmPath+'/tonglian/pay',
				type:'POST',
				data:{"payCode":payCode,"formAmount":formAmount,"formOrderId":formOrderId,"payType":payType},
				success:function(msg){
					console.log(msg);
					alert(cmPath);
					if(msg.status=='SUCCESS'){
						arrInfo.splice(0,arrInfo.length);
						$(".markbox").hide();
						$(".mark5").hide();
						$(".markbox").show();
						$(".mark7").show();
				
						var time = setInterval(showTime, 1000);
				         var second = 3;
				        function showTime() {
						    if(second == 0) {
						    clearInterval(time);
							window.location.href = cmPath+"/queryItemsByOrderId2?orderId="+formOrderId;
						    }
						   $("#successBtn").html(' 确定'+ second + 's');
						   second--;
				        }
	                      $("#successBtn").click(function(){	  
							$(".markbox").hide();
							$(".mark7").hide();
						 	window.location.href=cmPath+"/queryItemsByOrderId2?orderId="+orderId;
	                      })
					}else{
						setTimeout(function(){
							$(".markbox").show();
							$(".mark5").hide();
							$(".mark4").show(function(){
								$("#payCode").val("");
							},0);
							
							$("#ErrorBtn").click(function(){		
								$(".mark4").hide();
								$(".mark5").show();
							});
						},500);	
					}
				}
			
			})
		}
	}
});

		//现金支付弹框
		$('.CashPayment').click(function() {
			generateOrder("CASH");
			$(".markbox").css("height", $(document).height());
			$(".markbox").css("width", $(document).width());
			$("#allPrice").val(parseFloat($("#rechargeAmount").val()).toFixed(2));
			$("#receiptsPrice").val("");
			$("#changePrice").val("");
			$(".markbox").show();
			$(".mark3").show();
		})
		$('.ZhiNengPos').click(function() {
			generateOrder("ZNPOS");

		})
		$(".close").click(function() {
			$(".markbox").css("display", "none");
			$(".mark3").css("display", "none");
		})
		$(".markbox").click(function() {
			$(".markbox").css("display", "none");
			$(".mark3").css("display", "none");
		})

		//支付宝或者微信支付弹框
		var timer1;
		//支付宝或者微信支付弹框
		$('.Alipay').click(function() {
			generateOrder("XC_ZFB");
			$(".markbox").css("height", $(document).height());
			$(".markbox").css("width", $(document).width());
			$(".markbox").show();
			$(".mark5").show();
			$("#payCode").focus();
			timer1 = setInterval("tonglianpay('A04')", 400);
		})
		$('.wechat').click(function() {
			generateOrder("XC_WX");
			$(".markbox").css("height", $(document).height());
			$(".markbox").css("width", $(document).width());
			$(".markbox").show();
			$(".mark5").show();
			$("#payCode").focus();
			timer1 = setInterval("tonglianpay('W04')", 400);
		})

		//通联支付
		function tonglianpay(payType) {
			var payCode = $.trim($("#payCode").val());
			//$("#payCode").val("");
			var formAmount = $("#formAmount").val();
			var formOrderId = $("#formOrderId").val();
			if(payCode != null && payCode != '' && payCode.length > 5) {
				clearInterval(timer1);
				$.ajax({
					url: '${ctx}/CardRecharge/tonglian/charge',
					type: 'POST',
					dataType: 'json',
					data: {
						"payCode": payCode,
						"formAmount": formAmount,
						"formOrderId": formOrderId,
						"payType": payType
					},
					success: function(msg) {
						$("#payCode").val("");
						if(msg.status == 'SUCCESS') {

							$(".markbox").show();
							$(".mark7").show();
							setTimeout(function() {
								$(".markbox").hide();
								$(".mark7").hide();
							}, 3000);
							var time = setInterval(showTime, 1000);
							var second = 3;

							function showTime() {
								if(second == 0) {
									clearInterval(time);
									window.location.href = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + formOrderId;
								}
								$("#successBtn").html(' 确定' + second + 's');
								second--;
							}
							$("#successBtn").click(function() {
								$(".markbox").hide();
								$(".mark7").hide();
								window.location.href = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + orderId;
							})
						} else {
							$("#payCode").val("");
							$(".markbox").show();
							$(".mark4").show();
							$("#ErrorBtn").click(function() {
								$(".mark4").hide();
								$(".mar5").show();
							})

						}
					}
				});
			}
		}

		var key1str;
		var key2str;
		var key3str;
		var key6str;

		//读卡号
		function findCard() {
			//读卡前先清空文本框
			/* defaultForm.idNo.value = "";
			defaultForm.username.value = "";
			defaultForm.phone.value = "";
			defaultForm.birth.value = "";
			defaultForm.balance.value = ""; */
			readCardNo("cbCardholderNo");
			var cardNo = document.getElementsByName("cbCardholderNo")[0].value;
			
			if(cardNo == "undefined" || cardNo == "") {
				return;
			}
			cardNo = "<%=Constants.baseBIN%>" + cardNo;
			$.ajax({
				type: "POST",
				url: "${ctx}/CardRecharge/getKey",
				dataType: "json",
				data: {
					cardNumber: cardNo,
					type: 0
				},
				success: function(data) {
					
					/* if(failureProcess("${ctx}", data)) {
						document.getElementById(document.getElementsByName("cbCardholderNo")[0]).value = "";
						llayer.msg(e.message);
						return;
					} */
					
					var p = data.value;
					key2str = p[0];
					key3str = p[1];
					key6str = p[2];
					
					getCardMess(cardNo);
					getBalance(cardNo);
				}
			});
		}

		function getCardMess(cardNo) {
			$.ajax({
				type: "POST",
				url: "${ctx}/CardRecharge/getCardMess",
				dataType: "json",
				data: {
					cardNumber: cardNo
				},
				success: function(data) {
				/* 	if(failureProcess("${ctx}", data)) {
						return;
					} */
					var res = data.value;
					defaultForm.idNo.value = res[1];
					defaultForm.username.value = res[2];
					defaultForm.phone.value = res[4];
					defaultForm.birth.value = res[5];
					document.getElementById("cardstatus").innerHTML = res[7];
				}
			});
		}

		//会员卡余额
		function getBalance(cardno) {
			$.ajax({
				type: "POST",
				url: "${ctx}/CardRecharge/getBalance",
				dataType: "json",
				data: {
					cardNumber: cardno
				},
				success: function(data) {
					/* if(failureProcess("${ctx}", data)) {
						return;
					} */
					var p = data.value;
					if(p == null) {
						llayer.msg("余额查询异常");
						return;
					} else {
						defaultForm.balance.value = p;
					}
				}
			});
		}
		var flag = true;

		$("#cashPayBtn").click(function() {
		//	console.log('触发按钮点击事件');
			if(flag) {
				flag = false;
				var allPrice = $("#allPrice").val();
				var receiptsPrice = $("#receiptsPrice").val();
				if(!receiptsPrice) {
					console.log('触发按钮点击事件');
					/*调用弹框   实收不能为空*/
					layer.msg("实收不能为空");
					//						receiptsPrice ="";
					$("#receiptsPrice").val("");
					$("#changePrice").val("")
//					receiptsPrice=false;
					flag = true;
						return false;
				}
				if(parseFloat(receiptsPrice) < parseFloat(allPrice)) {
					/*调用弹框    实收不能小于应收*/
					console.log(allPrice);
					console.log(receiptsPrice);
					layer.msg("实收不能小于应收");
					//						receiptsPrice ="";
					$("#receiptsPrice").val("");
					$("#changePrice").val("");
					flag = true;
					return false;
				}
				console.log($("#receiptsPrice").val());
				//				var receiptsPrice =$("#receiptsPrice").val();
				if($("#receiptsPrice").val()!= "") {
					console.log("123");
					$.ajax({
						url: '${ctx}/CardRecharge/updateOrderStatus',
						type: 'post',
						data: {
							'orderId': orderId,
							'payType': 'CASH',
							'receiptsPrice': receiptsPrice,
							'hwPaymentListid': ''
						},
						dataType: 'json',
						success: function(data) {
							if(data.status == 'SUCCESS') {
								console.log(data + "data的值");
								var receiptsPrice = data.value;
								setTimeout(function() {
									$(".markbox").show();
									$(".mark7").show();
								}, 1000);
								var time = setInterval(showTime, 1000);
								var second = 3;

								function showTime() {
									if(second == 0) {
										flag = true;
										clearInterval(time);
										window.location.href = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + orderId + "&receiptsPrice=" + receiptsPrice;
									}
									$("#successBtn").html(' 确定' + second + 's');
									second--;
								}
								$("#successBtn").click(function() {
									flag = true;
									$(".markbox").hide();
									$(".mark7").hide();
									window.location.href = "${ctx}/CardRecharge/queryItemsByOrderId?orderId=" + orderId + "&receiptsPrice=" + receiptsPrice;
								})

							} else {
								setTimeout(function() {
									$(".markbox").css("height", $(document).height());
									$(".markbox").css("width", $(document).width());
									$(".markbox").show();
									$(".mark7").show();
								}, 3000)
							}
						}
					});
				}
		}
		});

			
		</script>

	</body>

</html>