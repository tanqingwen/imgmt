//票劵金额计算
	function changetotalAmountPaid() {
		var amount = $("#amount").val()
		var vartkAmount = $("#vartkAmount").val()

		if(amount == "") {
			$("#amount").val(0);
		}
		console.log(vartkAmount);
		if(vartkAmount == "") {
			$("#vartkAmount").val(0);
		}
		$('#allMoney').text(parseInt(vartkAmount) + parseInt(amount));
	}
	$("#ticket-input").on('click', function() {
		$(".more-ul").css('display', 'block');
		var chk_value = [];
		$(".more-ul li").on('click', function() {
			chk_value = [];
			$('input[name="test"]:checked').each(function(event) {
				chk_value.push($(this).val());
			});
			$("#ticket-input").val(chk_value);
			//					console.log(chk_value);	
			event.stopPropagation();
		});
		event.stopPropagation();
	});
	$(document).on('click', function() {
		$(".more-ul").css('display', 'none');
	})
	//全选反选

	$("#refresh").on('click', function() {
		window.location.reload();
	});

	function zhinengpos(orderId, amount) {
		$.ajax({
			type: 'POST',
			data: {
				"orderId": orderId,
				"amount": amount,
				"ip": sIPAddr,
				"business_id": "100100001"
			},
			url: cmPath + '/cpticket/tonglian/pos',
			dataType: 'json',
			success: function(data) {
				if(data.status == 'SUCCESS') {
					arrInfo.splice(0, arrInfo.length);
					setTimeout(function() {
						$(".markbox").hide();
						$(".mark7").hide();
					}, 10000)

					var time = setInterval(showTime, 1000);
					var second = 3;

					function showTime() {
						if(second == 0) {
							clearInterval(time);
							window.location = cmPath + "/queryItemsByOrderId3?orderId=" + orderId;
						}
						$("#successBtn").html(' 确定' + second + 's');
						second--;
					}
					$("#successBtn").click(function() {
						$(".markbox").hide();
						$(".mark7").hide();
						window.location.href = cmPath + "/queryItemsByOrderId3?orderId=" + orderId;
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

	function leyuanka() {
		var payCode = $.trim($('#payCode2').val());
		var formAmount = $("#formAmount").val();
		var formOrderId = $("#formOrderId").val();
		if(payCode != null && payCode != '' && payCode.length > 5) {
			$.ajax({
				url: cmPath + '/cpticket/tonglian/pay',
				type: 'POST',
				data: {
					"payCode": payCode,
					"formAmount": formAmount,
					"formOrderId": formOrderId,
					"payType": payType
				},
				success: function(msg) {
					console.log(msg);
					if(msg.status == 'SUCCESS') {
						arrInfo.splice(0, arrInfo.length);
						$(".markbox").hide();
						$(".mark5").hide();
						$(".markbox").show();
						$(".mark7").show();

						var time = setInterval(showTime, 1000);
						var second = 3;

						function showTime() {
							if(second == 0) {
								clearInterval(time);
								window.location.href = cmPath + "/queryItemsByOrderId3?orderId=" + formOrderId;
							}
							$("#successBtn").html(' 确定' + second + 's');
							second--;
						}
						$("#successBtn").click(function() {
							$(".markbox").hide();
							$(".mark7").hide();
							window.location.href = cmPath + "/queryItemsByOrderId3?orderId=" + orderId;
						})
					} else {
						alert('失败');
						setTimeout(function() {
							$(".markbox").show();
							$(".mark5").hide();
							$(".mark4").show(function() {
								$("#payCode").val("");
							}, 0);

							$("#ErrorBtn").click(function() {
								$(".mark5").show();
								$(".mark4").hide();
							});
						}, 500);
					}
				}

			})
		}
	}

	//支付方式弹框
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var prePath = strFullPath.split("/");
	var basePath = strPath.split("/");
	var webPath = "/" + basePath[1];
	prePath.pop();
	var cmPath = prePath.join("/");
	var closeimg = $('.close');
	var arrInfo = [];
	var orderId = "";
	var amount = 0;
	//生成订单
	function generateOrder(payType) {
		amount = parseFloat($("#countPrice").text()).toFixed(2);
		$.ajax({
			url: cmPath + '/buy/start/',
			type: 'POST',
			contentType: 'application/json;charset=utf-8',
			dataType: "json",
			data: JSON.stringify({
				"hwIp": sIPAddr,
				"phoneNumber": $("#mobile").val(),
				"orderAmount": amount,
				"payType": payType,
				"chargeAmount": 1,
				"items": arrInfo

			}),
			success: function(data) {
				if(data.status == "SUCCESS") {
					var id = data.value.orderId;
					/*console.log("订单:"+id);*/
					var Amount = data.value.amount;
					$("#formOrderId").val(id);
					$("#formAmount").val(Amount);
					orderId = id;
					amount = Amount;
					if('ZNPOS' == payType) {
						zhinengpos(orderId, amount);
					}
				}
			}
		})
	}

	$("#resale").on('click', function() {
		if(arrInfo.length <= 0) {
			layer.msg('购物车不能为空');
			return;
		}

		$(".markbox").css("height", $(document).height());
		$(".markbox").css("width", $(document).width());
		$(".markbox").show();
		$(".mark2").show();

	});

	$(".close").click(function() {
		$(".markbox").css("display", "none");
		$(".mark2").css("display", "none");
	})
	$(".markbox").click(function() {
		$(".markbox").css("display", "none");
		$(".mark2").css("display", "none");
	})

	$(".close").click(function() {
		$(".markbox").css("display", "none");
		$(".mark3").css("display", "none");
	})
	$(".markbox").click(function() {
		$(".markbox").css("display", "none");
		$(".mark3").css("display", "none");
	})
	var flag = true;
	$("#cashPayBtn").on('click', function() {
		if(flag) {
			flag = false;
			/*console.log('cash pay')*/
			var allPrice = $("#allPrice").val();
			var receiptsPrice = $("#receiptsPrice").val();
			if(!receiptsPrice) {
				/*调用弹框   实收不能为空*/
				layer.msg("实收不能为空");
				receiptsPrice = "";
				flag = true;
				return false;
			}
			
			if(parseFloat(receiptsPrice) < parseFloat(allPrice)) {
				/*调用弹框    实收不能小于应收*/
				console.log(allPrice);
				console.log(receiptsPrice);
				layer.msg("实收不能小于应收");
				receiptsPrice = "";
				flag = true;
				return false;
			}
			//现金支付
			$.ajax({
				url: cmPath + '/updateOrderStatus',
				type: 'post',
				data: {
					'orderId': orderId,
					'payType': 'CASH',
					'receiptsPrice': receiptsPrice,
					"hwPaymentListid": ""
				},
				dataType: 'json',
				success: function(data) {
					if(data.status = 'SUCCESS') {
						console.log(data);
						//var receiptsPrice = data.value;
						//alert(receiptsPrice);
						arrInfo.splice(0, arrInfo.length);
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
								window.location.href = cmPath + "/queryItemsByOrderId3?orderId=" + orderId + "&receiptsPrice=" + receiptsPrice;
							}
							$("#successBtn").html(' 确定' + second + 's');
							second--;
						}
						$("#successBtn").click(function() {
							$(".markbox").hide();
							$(".mark7").hide();
							flag = true;
							window.location.href = cmPath + "/queryItemsByOrderId3?orderId=" + orderId + "&receiptsPrice=" + receiptsPrice;
						});
					} else if(data.status == 'PAYED') {
						layer.msg(data.comment);
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

	});
	//支付宝或者微信支付弹框
	var timer1;
	var payType;
	//支付宝或者微信支付弹框
	$('.Alipay').click(function() {
		generateOrder("XC_ZFB");
	    post('100300001');
			$.ajax({
				url: cmPath + '/updateOrderStatus',
				type: 'post',
				data: {
					'orderId': orderId,
					'payType': 'CASH',
					'receiptsPrice': receiptsPrice,
					"hwPaymentListid": ""
				},
				dataType: 'json',
				success: function(data) {
					if(data.status = 'SUCCESS') {
                     window.location.href = cmPath + "/queryItemsByOrderId3?orderId=" + orderId;
					}
				},
			});
		payType = 'A04';
		$("#payCode").focus();
		//		timer1 = setInterval("tonglianpay('A04')", 200);
	});
	$('.wechat').click(function() {
		generateOrder("XC_WX");
	    post('100300001');
		payType = 'W04';
//		console.log(pos_ip);
		//		timer1 = setInterval("tonglianpay('W04')", 200);
	});
	
	$('.ZhiNengPos').click(function() {
		generateOrder('ZNPOS');
	    post('100100001');
		payType = 'ZNPOS';		
	});
	
	$('.happyWorld').click(function() {
		generateOrder("LYK");
		$(".markbox").css("height", $(document).height());
		$(".markbox").css("width", $(document).width());
		$(".markbox").show();
		$(".mark8").show();
		payType = 'LYK';
		$("#payCode").focus();

		//	timer1 = setInterval("tonglianpay('LYK')", 200);
	})
	$(".close").click(function() {
		$(this).parents(".mark8").hide();
		$(this).parents(".markbox").hide();
	})
	$(".markbox").click(function() {
		$(this).siblings(".mark8").hide();
	})
	$(".close").click(function() {
		$(this).parents(".mark4").hide();
		$(this).parents(".markbox").hide();
	})
	$(".markbox").click(function() {
		$(this).siblings(".mark4").hide();
	})
	//扫码支付
	//};
	//pos机扫码支付
    function post(business_id) {
        var postData = {
            "business_id":business_id,
            "amount":amount,
            "memo":"00161706070004",
            "trans_check":''
        };

        postData = (function(obj){ // 
            var str = "";

            for(var prop in obj){
                str += prop + "=" + obj[prop] + "&"
            }
            return str;
        })(postData);

        var xhr = new XMLHttpRequest();
       var local = window.localhost;
        console.log("收到的"+pos_ip);
        xhr.open("POST", "http://"+pos_ip+":9801/trans", true);
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.onreadystatechange = function(){
            var XMLHttpReq = xhr;
            if (XMLHttpReq.readyState == 4) {
                if (XMLHttpReq.status == 200) {
                    var text = XMLHttpReq.responseText;
                    // objform.response.value=text;
                     var finaltext = JSON.parse(text);
                     if(finaltext.rejcode=="00"){
                    	alert('交易成功');
                       window.location.href = cmPath + "/queryItemsByOrderId3?orderId=" + orderId;
                     }
/*                    console.log(text);*/
                }
            }
        };
        xhr.send(postData);
    }
	//聚焦
	window.onload = function() {
		$("#focus").focus();
	}
	$("#refresh").on('click', function() {
		window.location.reload();
	});
	//支付方式弹框
	$('.CashPayment').click(function() {
		generateOrder("CASH");
		$(".markbox").css("height", $(document).height());
		$(".markbox").css("width", $(document).width());
		$("#allPrice").val($("#countPrice").html());
		$("#receiptsPrice").val("");
		$("#changePrice").val("");
		$(".markbox").show();
		$(".mark3").show();
	})

	$(".close").click(function() {
		$(".markbox").css("display", "none");
		$(".mark5").css("display", "none");
	})
	$(".markbox").click(function() {
		$(".markbox").css("display", "none");
		$(".mark5").css("display", "none");
	})
	//   支付成功弹框
	$('successPop').click(function() {
		$(".markbox").css("height", $(document).height());
		$(".markbox").css("width", $(document).width());
		$(".markbox").show();
		$(".mark7").show();
	})
	$(".markbox").click(function() {
		$(".markbox").css("display", "none");
		$(".mark7").css("display", "none");
	})
/*	//身份证件选择
	$('#DocumentType').change(function() {
		var val = $(this).val();
			console.log(val);
		if(val == 2 || val == 3) {
			$('.idText').text('证件号码:');
			$('#idDocument').css('display', 'none');
			$('#OtherDocuments').css('display', 'block');

		} else {
			$('.idText').text('身份证号码:');
			$('#idDocument').css('display', 'block');
			$('#OtherDocuments').css('display', 'none');
		}
	})*/

	//找零计算
	$(function() {
		$("#receiptsPrice").bind('input porpertychange', function() {
			var all = $("#allPrice").val();
			//			console.log(all);
			var receipts = $("#receiptsPrice").val();
			//			console.log(receipts);
			var change = parseFloat((receipts - 0) - (all - 0)).toFixed(2);

			$('#changePrice').val(change);
		});

	});

	//ajax请求

	var $countPrice = $("#countPrice").val();
	var $ticketKind = $("#ticketKind").val();
	var $ticketBody = $("#ticketBody").val();
	var $hidden = $("#hidden").val();

	//页面初始化方法
	//	function init() {
	$(function() {
		//获取票券列表
		$.ajax({
			type: "get",
			url: cmPath + "/ticketType/list",
			success: function(result) {
				/*console.log(result.status);*/
				console.log('票券列表长度\n'+result.value.length);
				var a = [];
				var len = result.value.length;
				var ticketKind = $('#ticketKind');
				var html = "";
				for(var i = 0; i < len; i++) {
					console.log('获取的票券列表'+result.value[i].ttTypeDesc);

					var ticketName = result.value[i].ttTypeDesc;
					console.log(ticketName);
					var ticketPrice = result.value[i].ttListPrice;
					var ttTypeId = result.value[i].ttTypeId;
					html += "<option value=" + ticketPrice + " id='" + ttTypeId + "'  >" + ticketName +
						"</option>"
					ticketKind.html(html);

				}
				setTimeout(function() {
					$("#ticketMoney").val(
							$("#ticketKind").val() * $("#ticketBody").val());
//					$("#countPrice").text(
//							$("#ticketKind").val() * $("#ticketBody").val());
				})

			}
		});
		//监听票券种类的变化，并计算票券金额
/*		var a = parseFloat($("#ticketKind").val()).toFixed(2);
		var b = parseFloat($("#ticketBody").val()).toFixed(2);*/
		$("#ticketKind").on("change", function() {
			 var a = parseFloat($("#ticketKind").val()).toFixed(2);
			 var b = parseFloat($("#ticketBody").val()).toFixed(2);
/*			var c = $("#Recharge").val();*/
/*			console.log('ticketkind'+$("#ticketKind").val());
			console.log('ticket'+$("#ticketBody").val());*/
/*			alert($("#ticketKind").val()); 
/*			if (c == null || c == '') {
				c = 0
			}*/
/*			var d = parseFloat(c);*/
			$("#ticketMoney").val((a * b).toFixed(2));
		});
		//监听对象的变化，并计算票券金额
		$("#ticketBody").on("change", function() {
			 var a = parseFloat($("#ticketKind").val()).toFixed(2);
			 var b = parseFloat($("#ticketBody").val()).toFixed(2);
/*			console.log('ticketkind'+$("#ticketKind").val());
			console.log('ticket'+$("#ticketBody").val());*/
/*			var c = $("#Recharge").val();
			if(c == null || c == '') {
				c = 0
			}
			var d = parseFloat(c);*/
			$("#ticketMoney").val((a * b).toFixed(2));
		});

		function validateIdNo(idNo) {
			isIDCard1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
			isIDCard2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
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
		
		//添加加入购物车按钮的监听事件
		$('.btn-orang').click(
			function() {
				//$("#cbIdType").find("option[value=1]").prop("selected",true);
				$("#readIdno").removeAttr("disabled");
				$("#readIdno").css("background", "#6DB921");
				var chargeAmount = $("#Recharge").val();
				/*									if(!validateCart()){return ;}*/
				/*									if(!validateChargeAmount(chargeAmount)){return ;}*/
				if(arrInfo.length >= 6) {
					layer.msg("一次最多购买6张票");
					return;
				}
				var credentyType = $("#cbIdType option:selected").val();
				var credentyNumber = '';	
				arrInfo.push({
					"ticketType": $("#ticketKind option:selected").attr("id"),
					"ticketNumber": 1,			
					"itemAmount": $("#ticketMoney").val(),				
					"discount": $("#ticketBody").val(),
					"ticketName": $("#ticketKind option:selected").text(),
					"objGrade": $("#ticketBody option:selected").attr("aa")
				});
				//支付总额
				var html = 0;
				var len = $('.isAppend').length + 1;
				for(var i = 0; i < len; i++) {
					/*console.log(arrInfo[i]['rechargeAmount']);*/
					/*										if(arrInfo[i]['rechargeAmount'] == null || arrInfo[i]['rechargeAmount'] == '') {
																arrInfo[i]['rechargeAmount'] =0;
															}*/
					html += parseFloat(arrInfo[i]['itemAmount']);
					//										alert(parseFloat(arrInfo[i]['itemAmount']))
				}
				html = html.toFixed(2);
				/*alert(len);*/
				$("#countPrice").html(html);
				var username = $('#username').val();
				var Recharge = $('#Recharge').val();
				var kind = $('#ticketKind option:selected').text();
				var price = parseFloat($("#ticketMoney").val()).toFixed(2);
				/*<td><input type='checkbox' /></td>*/
				$('.buyCar').append(
					"<tr class='text-center isAppend'><td>" +
					kind +
					"</td><td>￥<span value='0'>" +
					price +
					"</span></td><td><button class='btn'>删除</button></td></tr>");
				//清空不可重复数据
				$("#CbRwdsAccno").val(""); //卡流水号
				$("#cbCardholderNo").val(""); //持卡人号码
				$("#idNo").val(""); //身份证号码
				$("#username").val(""); //证件姓名
				//$("#cbIdType").val(""); //证件类型值
				$("#otherDocuments").val(""); //证件号码
				$("#authCode").val(""); //授权码
				//$("#specialCertificate").val(""); //授权码
				$("#specialCertificateNumber").val(""); //授权码
				$("#Recharge").val(0); //授权码

				/*	console.log(arrInfo);*/

				//清空不可重复数
			});

				$('body').on('click', '.btn', function() {
					var index = $(".buyCar .btn").index($(this));
					var html = $('#countPrice').text();
					console.log(arrInfo);
					console.log('index的值'+index);
					html -= parseFloat(arrInfo[index]['itemAmount']);
					$(this).parents('tr').remove();

					arrInfo.splice(index, 1);
					/*alert(arrInfo.length+"nihaoha ");*/
					html = html.toFixed(2);
					$('#countPrice').text(html);
					/*alert($('#countPrice').html());*/


			});
	});
	//获取对象列表
	$.ajax({
		type: "get",
		url: cmPath + "/objGrade/list",
		success: function(data) {
			var len = data.value.length;
			var ticketBody = $("#ticketBody");
			var html = "";
			for(var i = 0; i < len; i++) {
				var identityKind = data.value[i].prGroupDesc; //对象
				//					console.log(identityKind);
				var identityDiscount = data.value[i].prCurr4dbc; //对象折扣
				//				console.log(identityDiscount);
				var discount = identityDiscount / 100; //机损后的对象折扣
				//				console.log(discount);
				html += "<option value=" + discount + " aa=" + identityKind + " >" + identityKind +
					"</option>"
				ticketBody.html(html);
			}
			setTimeout(function() {
				$("#ticketMoney").val(
						$("#ticketKind").val() * $("#ticketBody").val());
//				$("#countPrice").text(
//						$("#ticketKind").val() * $("#ticketBody").val());
			})

		}
	});
	//刷新頁面
	$(function() {
		$("#refresh").click(function() {
			refresh();
		});
	});
	//点击按钮调用的方法
	function refresh() {
		window.location.reload(); //刷新当前页面.
	}
	//获取pos机本机ip
	var pos_ip = "";
	function getIPs(callback){
	    var ip_dups = {};
	    //compatibility for firefox and chrome
	    var RTCPeerConnection = window.RTCPeerConnection
	        || window.mozRTCPeerConnection
	        || window.webkitRTCPeerConnection;
	    //bypass naive webrtc blocking
	    if (!RTCPeerConnection) {
	        var iframe = document.createElement('iframe');
	        //invalidate content script
	        iframe.sandbox = 'allow-same-origin';
	        iframe.style.display = 'none';
	        document.body.appendChild(iframe);
	        var win = iframe.contentWindow;
	        window.RTCPeerConnection = win.RTCPeerConnection;
	        window.mozRTCPeerConnection = win.mozRTCPeerConnection;
	        window.webkitRTCPeerConnection = win.webkitRTCPeerConnection;
	        RTCPeerConnection = window.RTCPeerConnection
	            || window.mozRTCPeerConnection
	            || window.webkitRTCPeerConnection;
	    }
	    //minimal requirements for data connection
	    var mediaConstraints = {
	        optional: [{RtpDataChannels: true}]
	    };
	    //firefox already has a default stun server in about:config
	    //    media.peerconnection.default_iceservers =
	    //    [{"url": "stun:stun.services.mozilla.com"}]
	    var servers = undefined;
	    //add same stun server for chrome
	    if(window.webkitRTCPeerConnection)
	        servers = {iceServers: [{urls: "stun:stun.services.mozilla.com"}]};
	    //construct a new RTCPeerConnection
	    var pc = new RTCPeerConnection(servers, mediaConstraints);
	    //listen for candidate events
	    pc.onicecandidate = function(ice){
	        //skip non-candidate events
	        if(ice.candidate){
	            //match just the IP address
	            var ip_regex = /([0-9]{1,3}(\.[0-9]{1,3}){3})/
	            var ip_addr = ip_regex.exec(ice.candidate.candidate)[1];
	            //remove duplicates
	            if(ip_dups[ip_addr] === undefined)
	                callback(ip_addr);
	            ip_dups[ip_addr] = true;
	        }
	    };
	    //create a bogus data channel
	    pc.createDataChannel("");
	    //create an offer sdp
	    pc.createOffer(function(result){
	        //trigger the stun server request
	        pc.setLocalDescription(result, function(){}, function(){});
	    }, function(){});
	}
	//Test: Print the IP addresses into the console
	getIPs(function(ip){pos_ip = ip;});