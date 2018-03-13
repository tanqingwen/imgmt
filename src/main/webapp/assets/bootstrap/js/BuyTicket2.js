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
$("#allcheck").click(function() {
	if (this.checked) {
		$(".form-table input:checkbox").prop("checked", true);
	} else {
		$(".form-table input:checkbox").prop("checked", false);
	}
});

$("#refresh").on('click', function() {
	window.location.reload();
});

//支付方式弹框
var strFullPath=window.document.location.href;
var strPath=window.document.location.pathname;
var prePath=strFullPath.split("/");
var basePath = strPath.split("/");
var webPath = "/"+basePath[1];
prePath.pop();
var cmPath =prePath.join("/");
var closeimg = $('.close');
var arrInfo=[];
var orderId = "";
var amount= 0;

$("#resale").on('click', function() {
	if(arrInfo.length <=0){ layer.msg('购物车不能为空');return;}
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
$("#cashPayBtn").on('click',function(){
	if(flag){
		flag=false;
		/*console.log('cash pay')*/
		var allPrice = $("#allPrice").val();
		var receiptsPrice =$("#receiptsPrice").val();
		if (!receiptsPrice) { 
			/*调用弹框   实收不能为空*/
			layer.msg("实收不能为空");
			receiptsPrice ="";
			flag=true;
			return false;
		}
		if (parseFloat(receiptsPrice) < parseFloat(allPrice)) {
			/*调用弹框    实收不能小于应收*/
			console.log(allPrice);
			console.log(receiptsPrice);
			layer.msg("实收不能小于应收");
			receiptsPrice ="";
			flag=true;
			return false;
		}
		//现金支付
		$.ajax({
			url:cmPath+'/updateOrderStatus',
			type:'post',
			data:{'orderId':orderId,'payType':'CASH','receiptsPrice':receiptsPrice,"hwPaymentListid":""},
			dataType:'json',
			success:function(data){			
				if(data.status='SUCCESS'){
					console.log(data);    
					arrInfo.splice(0,arrInfo.length);
					setTimeout(function(){
						$(".markbox").show();
						$(".mark7").show();
					},1000);
					var time = setInterval(showTime, 1000);
					var second = 3;
					function showTime() {
						if(second == 0) {
							flag=true;
							clearInterval(time);
							window.location.href = cmPath+"/queryItemsByOrderId2?orderId="+orderId+"&receiptsPrice="+receiptsPrice;
						}
						$("#successBtn").html(' 确定'+ second + 's');
						second--;
					}
					$("#successBtn").click(function(){	  
						$(".markbox").hide();
						$(".mark7").hide();
						flag=true;
						window.location.href=cmPath+"/queryItemsByOrderId2?orderId="+orderId+"&receiptsPrice="+receiptsPrice;
					})

				}else if(data.status =='PAYED'){
					layer.msg(data.comment);
				}else{
					setTimeout(function(){
						$(".markbox").css("height", $(document).height());
						$(".markbox").css("width", $(document).width());
						$(".markbox").show();
						$(".mark7").show();
					},3000)
				}
			}
		});
	}
});
//支付宝或者微信支付弹框
var timer1 ;
var payType ;
//支付宝或者微信支付弹框
$('.Alipay').click(function() {
	generateOrder("XC_ZFB");
	$(".markbox").css("height", $(document).height());
	$(".markbox").css("width", $(document).width());
	$(".markbox").show();
	$(".mark5").show();
	payType = 'A04';
	$("#payCode").focus();
//	timer1 = setInterval("tonglianpay('A04')", 200);
})
$('.wechat').click(function() {
	generateOrder("XC_WX");
	$(".markbox").css("height", $(document).height());
	$(".markbox").css("width", $(document).width());
	$(".markbox").show();
	$(".mark5").show();
	payType = 'W04';
	$("#payCode").focus();
//	timer1 = setInterval("tonglianpay('W04')", 200);
})
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
$(".close").click(function(){
	$(this).parents(".mark8").hide();
	$(this).parents(".markbox").hide();		
})
$(".markbox").click(function(){
	$(this).siblings(".mark8").hide();
})
$(".close").click(function(){
	$(this).parents(".mark4").hide();
	$(this).parents(".markbox").hide();		
})
$(".markbox").click(function(){
	$(this).siblings(".mark4").hide();
})

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
								$(".mark5").show();
								$(".mark4").hide();
							});
						},500);	
					}
				}
			})
		}
	}
});

//聚焦
window.onload=function(){
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
$('.ZhiNengPos').click(function() {
	generateOrder('ZNPOS');
})

$(".close").click(function() {
	$(".markbox").css("display", "none");
	$(".mark5").css("display", "none");
})
$(".markbox").click(function() {
	$(".markbox").css("display", "none");
	$(".mark5").css("display", "none");
})
//支付成功弹框
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

//找零计算
$(function() {
	$("#receiptsPrice").bind('input porpertychange', function() {
		var all = $("#allPrice").val();
		var receipts = $("#receiptsPrice").val();
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
//function init() {

//获取对象列表
(function(){
	$.ajax({
		type : "get",
		url :  cmPath+"/objGrade/list",
		success : function(data) {
			var len = data.value.length;
			var ticketBody = $("#ticketBody");
			var html = "";
			for (var i = 0; i < len; i++) {
				var identityKind = data.value[i].prGroupDesc; //对象
				var identityDiscount = data.value[i].prCurr4dbc; //对象折扣
				var discount = identityDiscount / 100; //机损后的对象折扣
				html += "<option value=" + discount + " aa="+identityKind+" >" + identityKind
				+ "</option>"
			}
			ticketBody.html(html);
		}
	})
})();	

//获取票券列表
(function(){
	$.ajax({
		type : "get",
		url :  cmPath+"/ticketType/list",
		success : function(result) {
			var a = [];
			var len = result.value.length;
			var ticketKind = $('#ticketKind');
			var html = "";
			for (var i = 0; i < len; i++) {
				var ticketName = result.value[i].ttTypeDesc;
				var ticketPrice = result.value[i].ttListPrice;
				var ttTypeId  = result.value[i].ttTypeId;
				html += "<option value=" + ticketPrice + " id='"+ttTypeId+"'  >" + ticketName
				+ "</option>"
			}
			ticketKind.html(html);
		}
	})
})();	

$(function() {
	//票券金额计算
	setTimeout(function(){
		var ttPrize = ($("#ticketKind").val() * $("#ticketBody").val()).toFixed(2);
		$("#ticketMoney").val(ttPrize);
	},200);
	
	//添加刪除事件			
	$("#ticketKind").on("change", function() {
		/*console.log('kind   show');*/
		var a = $("#ticketKind").val();
		var b = $("#ticketBody").val()
/*		var c = $("#Recharge").val();*/
//		if (c == null || c == '') {
//			c = 0;
//		}
//		var d = parseFloat(c);
	});

	$("#ticketBody").on("change", function() {
		var a = $("#ticketKind").val();
		var b = $("#ticketBody").val()
		var c = $("#Recharge").val();
		if (c == null || c == '') {
			c = 0
		}
		var d = parseFloat(c);
		$("#ticketMoney").val((a * b).toFixed(2));
	});

	$("#ticketKind").on("change", function() {
		var a = $("#ticketKind").val();
		var b = $("#ticketBody").val()
		var c = $("#Recharge").val();
		if (c == null || c == '') {
			c = 0
		}
		var d = parseFloat(c);
		$("#ticketMoney").val((a * b).toFixed(2));
	});

	$('.btn-orang').click(
		function() {
			$("#readIdno").removeAttr("disabled"); 
			$("#readIdno").css("background","#6DB921");
			var chargeAmount=$("#Recharge").val();
			if(arrInfo.length>=6){layer.msg("一次最多购买6张票");return;}
			var credentyType =$("#cbIdType option:selected").val();
			var credentyNumber ='';
			arrInfo.push({
				"ticketType": $("#ticketKind option:selected").attr("id"),
				"ticketNumber": 1,

				"itemAmount": $("#ticketMoney").val(),
				"discount": $("#ticketBody").val(),
				"ticketName":$("#ticketKind option:selected").text(),
				"objGrade":$("#ticketBody option:selected").attr("aa")
			});
			var html=0;
			var len = $('.isAppend').length+1;
			for(var i = 0; i < len; i++) {
				html += parseFloat(arrInfo[i]['itemAmount']);
			}
			html = html.toFixed(2);
			$("#countPrice").html(html);
			var username = $('#username').val();
			var Recharge = $('#Recharge').val();
			var kind = $('#ticketKind option:selected').text();
			var price = $("#ticketMoney").val();
			$('.buyCar').append(
					"<tr class='text-center isAppend'><td>"
					+ kind
					+ "</td><td>￥<span value='0'>"
					+ price
					+ "</span></td><td><button class='btn' style='outline:none;'>删除</button></td></tr>");
			//清空不可重复数据
			$("#CbRwdsAccno").val(""); //卡流水号
			$("#cbCardholderNo").val(""); //持卡人号码
			$("#idNo").val(""); //身份证号码
			$("#username").val(""); //证件姓名
			$("#otherDocuments").val(""); //证件号码
			$("#authCode").val(""); //授权码
			$("#specialCertificateNumber").val(""); //授权码
			$("#Recharge").val(0); //授权码
			$('body').on('click','.btn',function() {
				var index = $(".buyCar .btn").index($(this));
				var html =$('#countPrice').text();
				console.log(arrInfo);
				html -= parseFloat(arrInfo[index]['itemAmount']);
				$(this).parents('tr').remove();
				arrInfo.splice(index,1);
				html = html.toFixed(2);
				$('#countPrice').text(html);
			});				
		});
	

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
//生成订单
function generateOrder(payType){
	amount =  parseFloat($("#countPrice").text()).toFixed(2);
	var visitTime = $("#visitTime").val(); //游玩时间
	$.ajax({
		url: cmPath+'/buy/start/',
		type: 'POST',
		contentType:'application/json;charset=utf-8',
		dataType:"json",
		data: JSON.stringify({
			"hwIp":sIPAddr,
			"phoneNumber": $("#mobile").val(),
			"orderAmount":amount,
			"payType": payType,
			"chargeAmount":1,
			"items": arrInfo,
			"visitTime":visitTime

		}),
		success: function(data) {
			if(data.status=="SUCCESS"){
				var id=data.value.orderId;
				/*console.log("订单:"+id);*/
				var Amount=data.value.amount;
				$("#formOrderId").val(id);
				$("#formAmount").val(Amount);
				orderId = id;
				amount = Amount;
				if('ZNPOS'==payType){
					zhinengpos(orderId,amount);
				}
			}
		}
	})
}

//乐园卡
function leyuanka (){
	var payCode=$.trim($('#payCode2').val());
	var formAmount = $("#formAmount").val();
	var formOrderId = $("#formOrderId").val();
	var payType = 'LYK';
	if(payCode!=null && payCode!='' && payCode.length>5){
		$.ajax({
			url:cmPath+'/tonglian/pay',
			type:'POST',
			data:{"payCode":payCode,"formAmount":formAmount,"formOrderId":formOrderId,"payType":payType},
			success:function(msg){
				console.log(msg);
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
					alert('失败');
					setTimeout(function(){
						$(".markbox").show();
						$(".mark5").hide();
						$(".mark4").show(function(){
							$("#payCode").val("");
						},0);

						$("#ErrorBtn").click(function(){
							$(".mark5").show();
							$(".mark4").hide();
						});
					},500);	
				}
			}

		})
	}
}

function zhinengpos(orderId,amount){
	$.ajax({
		type:'POST',
		data: {"orderId":orderId,"amount":amount,"ip":sIPAddr,"business_id":"100100001"},
		url:cmPath+'/tonglian/pos',
		dataType:'json',
		success:function(data){
			if(data.status=='SUCCESS'){
				arrInfo.splice(0,arrInfo.length);
				setTimeout(function() {
					$(".markbox").hide();
					$(".mark7").hide();
				}, 10000)

				var time = setInterval(showTime, 1000);
				var second = 3;
				function showTime() {
					if(second == 0) {
						clearInterval(time);
						window.location = cmPath+"/queryItemsByOrderId2?orderId="+orderId;
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
				$(".markbox").show();
				$(".mark4").show();
				$("#ErrorBtn").click(function(){
					$(".mark4").hide();
					$(".mark5").show();

				});
			}
		}
	});
}

