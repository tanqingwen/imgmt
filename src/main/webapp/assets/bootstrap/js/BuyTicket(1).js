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

$("#refresh").on('click', function() {
	window.location.reload();
});
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
						window.location = cmPath+"/queryItemsByOrderId?orderId="+orderId;
					}
					$("#successBtn").html(' 确定'+ second + 's');
					second--;
				}
				$("#successBtn").click(function(){	  
					$(".markbox").hide();
					$(".mark7").hide();
					window.location.href=cmPath+"/queryItemsByOrderId?orderId="+orderId;
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
//校验手机号方法
function validateMobile(phoneNumber) {   
	var flag = true;
	if(phoneNumber=="") 
	{ 
		layer.msg("请输入手机号码");
		flag = false;
		return false; 
	}     
	if(phoneNumber.length!=11) 
	{ 
		layer.msg("请输入有效的手机号码");
		flag = false;
		return false; 
	} 

	var regmoblie = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/; 
	if(!regmoblie.test(phoneNumber)) 
	{ 
		layer.msg("请输入有效的手机号码");
		flag = false;
		return false; 
	} 
	/*if(flag){
    	$("#mobileError").empty();
    }*/
	return true;
}
function validateChargeAmount(chargeAmount){
	var regChargeAmount = /^([1-9]\d*|[0]{1,1})$/;
	if(!regChargeAmount.test(chargeAmount)){
		layer.msg("充值金额为0或正整数");
		return false;
	}
	return true;

}
$("#Recharge").blur(function(){
	var chargeAmount =$.trim($(this).val());
	if(!validateChargeAmount(chargeAmount)){return;}
});

//证件类型选择
$('.DocumentType').change(function() {
	var val = $(this).val();
	/*	  console.log(val);*/
	if(val == 1) {
		$('.readID').css('display', 'block');
		$('.otherDocuments').css('display', 'none');
		$('.authCode').css('display', 'none');
	} else if(val == 9) {
		$('.readID').css('display', 'none');
		$('.otherDocuments').css('display', 'none');
		$('.authCode').css('display', 'block');

	}else if(val==2 ||val==3){
		$('.readID').css('display', 'none');
		$('.otherDocuments').css('display', 'block');
		$('.authCode').css('display', 'none');
	}
})



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
//生成订单
function generateOrder(payType){
	amount =  parseFloat($("#countPrice").text()).toFixed(2);
	$.ajax({
		url: cmPath+'/buy/ticket',
		type: 'POST',
		contentType:'application/json;charset=utf-8',
		dataType:"json",
		data: JSON.stringify({
			"hwIp":sIPAddr,
			"phoneNumber": $("#mobile").val(),
			"orderAmount":amount,
			"payType": payType,
			"chargeAmount":1,
			"realName":"1",
			"items": arrInfo

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

$("#resale").on('click', function() {
	$("#readIdno").css('background-color','#00a65a');
	var mobile = $.trim($("#mobile").val());
	var chargeAmount = $.trim($("#Recharge").val());
	if(!validateMobile(mobile)){return;}
	if(!validateChargeAmount(chargeAmount)){return;}

	if(arrInfo.length <1){ layer.msg('购物车不能为空');return;}
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
//现金支付弹框
/*$('.CashPayment').click(function() {
	generateOrder("cash");
	$(".markbox").css("height", $(document).height());
	$(".markbox").css("width", $(document).width());
	alert($("#countPrice").html());
	console.log("allPrice:"+$("#allPrice"));
	$("#receiptsPrice").val("");
	$("#changePrice").val("");
	$(".markbox").show();
	$(".mark3").show();
	$("#allPrice").val($("#countPrice").html());
	$.ajax({
		url:cmPath+'/openBox',
		type:'GET',
		success:function(){}
	});
})*/
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
			url:cmPath+'/RealNameOrderStatus',
			type:'post',
			data:{'orderId':orderId,'payType':'CASH','receiptsPrice':receiptsPrice,"hwPaymentListid":""},
			dataType:'json',
			success:function(data){			
				if(data.status='SUCCESS'){
					console.log(data);    
					//var receiptsPrice = data.value;
					//alert(receiptsPrice);
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
							window.location.href = cmPath+"/queryItemsByOrderId?orderId="+orderId+"&receiptsPrice="+receiptsPrice;
						}
						$("#successBtn").html(' 确定'+ second + 's');
						second--;
					}
					$("#successBtn").click(function(){	  
						$(".markbox").hide();
						$(".mark7").hide();
						flag=true;
						window.location.href=cmPath+"/queryItemsByOrderId?orderId="+orderId+"&receiptsPrice="+receiptsPrice;
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
	$("#payCode").focus();
	payType = 'W04';
//	timer1 = setInterval("tonglianpay('W04')", 200);
})
$('.happyWorld').click(function() {
	generateOrder("LYK");
	$(".markbox").css("height", $(document).height());
	$(".markbox").css("width", $(document).width());
	$(".markbox").show();
	$(".mark8").show();
//	$("#payCode").focus();

	payType = 'LYK';
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


/*$('#payCode').change(function(){
//	alert("已获取付款码");
	var payCode=$.trim($('#payCode').val());
	var formAmount = $("#formAmount").val();
	var formOrderId = $("#formOrderId").val();
	if(payCode!=null && payCode!='' && payCode.length>5){
		console.log(payCode);
		console.log(payType);
		console.log(formAmount);
		console.log(formOrderId);
//		clearInterval(timer1);
		$.ajax({
			url:cmPath+'/tonglian/pay',
			type:'POST',
			data:{"payCode":payCode,"formAmount":formAmount,"formOrderId":formOrderId,"payType":payType},
			success:function(msg){
				if(msg.status=='SUCCESS'){
					$("#payCode").val("");
//					alert(msg.comment);
//					//清空购物车
					arrInfo.splice(0,arrInfo.length);			
					setTimeout(function(){
						$(".markbox").hide();
						$(".mark5").hide();
						},1000);
						$(".markbox").show();
						$(".mark7").show();
					 var time = setInterval(showTime, 1000);
			         var second = 3;
			         function showTime() {
					    if(second == 0) {
						    clearInterval(time);
							window.location.href = cmPath+"/queryItemsByOrderId?orderId="+formOrderId;
					    }
					   $("#successBtn").html(' 确定'+ second + 's');
					   second--;
			        }
                      $("#successBtn").click(function(){	  
						$(".markbox").hide();
						$(".mark7").hide();
					 	window.location.href=cmPath+"/queryItemsByOrderId?orderId="+orderId;
                      })
				}else{
					$(".markbox").show();
					$("#payCode").val("");
					$(".mark4").show();
					$("#ErrorBtn").click(function(){
						$(".markbox").show();
						$(".mark4").hide();
						$(".mark5").show()
					})

				}
			}
		});
	}
});	*/
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
								window.location.href = cmPath+"/queryItemsByOrderId?orderId="+formOrderId;
							}
							$("#successBtn").html(' 确定'+ second + 's');
							second--;
						}
						$("#successBtn").click(function(){	  
							$(".markbox").hide();
							$(".mark7").hide();
							window.location.href=cmPath+"/queryItemsByOrderId?orderId="+orderId;
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
//证件类型选择

//等待支付弹框
//$("#resale").on('click', function() {
//$(".markbox").css("height", $(document).height());
//$(".markbox").css("width", $(document).width());
//$(".markbox").show();
//$(".mark1").show();
//});
//$(".close").click(function() {
//$(".markbox").css("display", "none");
//$(".mark1").css("display", "none");
//})
//$(".markbox").click(function() {
//$(".markbox").css("display", "none");
//$(".mark1").css("display", "none");
//})
//支付方式弹框
$('.CashPayment').click(function() {
	generateOrder("CASH");
	$(".markbox").css("height", $(document).height());
	$(".markbox").css("width", $(document).width());
	$("#allPrice").val($("#countPrice").html());
	/*$("#receiptsPrice").val("");*/
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



//支付超时弹框
//$('*').click(function() {
//$(".markbox").css("height", $(document).height());
//$(".markbox").css("width", $(document).width());
//$(".markbox").show();
//$(".mark4").show();
//})
//$(".close").click(function() {
//$(".markbox").css("display", "none");
//$(".mark4").css("display", "none");

//})


//特殊门票显示特殊证件
$('#ticketBody').change(function() {
	//    console.log($(this).val());
	var text = $("this").text();
	var ob = $('#ticketBody option:selected').attr('aa');
	/*  console.log('value', $(this).val());*/
	//    || ob == "残疾人" || ob == "学生"
	if(ob == "军人" || ob == "残疾人" || ob == "学生") {
		$('.ticketStatus').css('display', 'block');
		$('#specialCertificate').empty().append("<option selected='selected' >"+ob+"证</option>");

	}else {
		$('.ticketStatus').css('display', 'none');
	}
});
//身份证件选择
$('#DocumentType').change(function() {
	var val = $(this).val();
	/*	console.log(val);*/
	if (val == 2 || val == 3) {
		$('.idText').text('证件号码:');
		$('#idDocument').css('display', 'none');
		$('#OtherDocuments').css('display', 'block');

	} else {
		$('.idText').text('身份证号码:');
		$('#idDocument').css('display', 'block');
		$('#OtherDocuments').css('display', 'none');
	}
})

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
//function init() {
$(function() {
	//获取票券列表
	$.ajax({
		type : "get",
		url :  cmPath+"/ticketType/listReal",
		success : function(result) {
			/*console.log(result.status);
						console.log(result.value.length);*/
			var a = [];
			var len = result.value.length;
			var ticketKind = $('#ticketKind');
			var html = "";
			for (var i = 0; i < len; i++) {
				var ticketName = result.value[i].ttTypeDesc;
				var ticketPrice = result.value[i].ttListPrice;
			console.log(ticketName);
				var ttTypeId  = result.value[i].ttTypeId;
				html += "<option value=" + ticketPrice + " id='"+ttTypeId+"'  >" + ticketName
				+ "</option>"
				ticketKind.html(html);

			}

		}
	});

	//添加刪除事件

	$("#ticketKind").on("change", function() {
		/*console.log('kind   show');*/
		var a = $("#ticketKind").val();
		var b = $("#ticketBody").val()
		var c = $("#Recharge").val();
		if (c == null || c == '') {
			c = 0;
		}
		var d = parseFloat(c);
		var year = $("#idNo").val().substring(6,10);
		var month = $("#idNo").val().substring(10,12);
		var day = $("#idNo").val().substring(12,14);
		var birth = new Date(year+"/"+month+"/"+day).getTime();
		var age = (new Date().getTime() - birth) / (1000*60*60*24*365)

		if (age >= 65) {
			$("#ticketBody").find("option[aa='老人']").prop("selected",true);
			var ticketPrice = $("#ticketKind").val() * 0.6;
			$("#ticketMoney").val(ticketPrice)

		} else {
			$("#ticketMoney").val(a * b);
		}
//		$("#countPrice").text(a * b + d);

	});

	$("#ticketBody").on("change", function() {
		var a = $("#ticketKind").val();
		var b = $("#ticketBody").val()
		var c = $("#Recharge").val();
		if (c == null || c == '') {
			c = 0
		}
		var d = parseFloat(c);
		/*	console.log(d);*/
		$("#ticketMoney").val(a * b);
//		$("#countPrice").text(a * b + d);
	});
	function validateIdNo(idNo){
		isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
		isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
		if(!idNo){layer.msg("身份证号码不能为空");return false;}
		if(!isIDCard1.test(idNo) && !isIDCard2.test(idNo)){ layer.msg("请输入正确的身份证号码"); return false;}
		return true;
	}
	function validateCart(){
		var CbRwdsAccno = $.trim($("#CbRwdsAccno").val()); //卡流水号
		var cbCardholderNo =$.trim($("#cbCardholderNo").val()); //持卡人号码
		var idNo =$.trim($("#idNo").val()); //身份证号码
		var username = $.trim($("#username").val()); //证件姓名
		var cbIdType = $.trim($("#cbIdType").val()); //证件类型值
		var otherDocuments = $.trim($("#otherDocuments").val()); //证件号码
		var authCode = $.trim($("#authCode").val()); //授权码
		var specialCertificateNumber = $.trim($("#specialCertificateNumber").val()); //授权码
		if(!CbRwdsAccno){ layer.msg("卡流水号不能为空");return false;}
		if(!cbCardholderNo){ layer.msg("持卡人号码不能为空");return false;}
		if(cbIdType==1){ 
			if(!validateIdNo(idNo)){layer.msg("请输入正确的身份证号码"); return false ;}
		}else if(cbIdType==9){
			if(!authCode){ layer.msg("授权码不能为空");}
		}
		if(idNo){
			for(var i=0;i<arrInfo.length;i++){
				if(arrInfo[i]['credentyNumber']==idNo){
					layer.msg("票务身份证号不能重复");
					return false;
				}
			}
		}
		if(specialCertificateNumber){
			for(var i=0;i<arrInfo.length;i++){
				if(arrInfo[i]['specialCredentyNumber']==specialCertificateNumber){
					layer.msg("特殊证件号不能重复");
					return false;
				}
			}
		}
		return true;
	}
	$('.btn-orang').click(
			function() {
				//$("#cbIdType").find("option[value=1]").prop("selected",true);
				$("#readIdno").removeAttr("disabled"); 
			/*	$("#readIdno").css("background","#6DB921");*/
				var chargeAmount=$("#Recharge").val();
				if(!validateCart()){return ;}
				if(!validateChargeAmount(chargeAmount)){return ;}
				if(arrInfo.length>=6){layer.msg("一次最多购买6张票");return;}
				var credentyType =$("#cbIdType option:selected").val();
				var credentyNumber ='';
				if(credentyType==1){
					credentyNumber=$("#idNo").val();
				}else if(credentyType==2||credentyType==3){
					credentyNumber =$("#otherDocuments").val();
				}else if(credentyType==9){
					var authCode =$("#authCode").val();
					if(authCode!='123456'){
						alert('请输入正确的授权码，授权码暂时为123456');
						return ;
					}
				}
				arrInfo.push({
					"ticketType": $("#ticketKind option:selected").attr("id"),
					"ticketNumber": 1,
					"specialCredentyType": $("#specialCertificate").text(),
					"specialCredentyNumber": $("#specialCertificateNumber").val(),
					"cardSerialNo": $("#CbRwdsAccno").val(),
					"cardHosterNumber": $("#cbCardholderNo").val(),
					"credentyType": $("#cbIdType option:selected").text(),
					"authCode": $("#authCode")?$("#authCode").val():"",
							"credentyName": $("#username").val(),
							"birthDay": $("#birthday").val(),
							"itemAmount": $("#ticketMoney").val(),
							"credentyNumber":credentyNumber,
							"address":$("#address").val() ,
							"discount": $("#ticketBody").val(),
							"rechargeAmount":$("#Recharge").val(),
							"ticketName":$("#ticketKind option:selected").text(),
							"objGrade":$("#ticketBody option:selected").attr("aa")
				});
				//支付总额
				var len = $('.isAppend').length + 1;		
				var html=0;
				for(var i = 0; i < len; i++) {
					/*console.log(arrInfo[i]['rechargeAmount']);*/
					if(arrInfo[i]['rechargeAmount'] == null || arrInfo[i]['rechargeAmount'] == '') {
						arrInfo[i]['rechargeAmount'] =0;
					}
					html += parseFloat(arrInfo[i]['itemAmount']) + parseFloat(arrInfo[i]['rechargeAmount']);
				}
				html=html.toFixed(2);
				$("#countPrice").html(html);
				var username = $('#username').val();
				var Recharge = $('#Recharge').val();
				var kind = $('#ticketKind option:selected').text();
				var price = $("#ticketMoney").val();
				/*<td><input type='checkbox' /></td>*/
				$('.buyCar').append(
						"<tr class='text-center isAppend'><td>"
						+ kind
						+ "</td><td>"
						+ username
						+ "</td><td>￥<span value='0'>"
						+ price
						+ "</span></td><td>￥<span>"
						+ Recharge
						+ "</span></td><td><button class='btn'>删除</button></td></tr>");
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
				//清空不可重复数据
				/*									$('.btn').click(function() {
										$(this).parents('tr').remove();
										var index = $(this).index();
										arrInfo.splice(index,1);
									});*/
			});
	$('body').on('click','.btn',function() {
		var index = $(".buyCar .btn").index($(this));
		var html =$('#countPrice').text();
		console.log(arrInfo);
		html -= parseFloat(arrInfo[index]['itemAmount']);
		$(this).parents('tr').remove();

		arrInfo.splice(index,1);
		/*alert(arrInfo.length+"nihaoha ");*/
		html = html.toFixed(2);
		$('#countPrice').text(html);
		/*alert($('#countPrice').html());*/
	});
});
//获取对象列表
$.ajax({
	type : "get",
	url :  cmPath+"/objGrade/list",
	success : function(data) {
		var len = data.value.length;
		var ticketBody = $("#ticketBody");
		var html = "";
		for (var i = 0; i < len; i++) {
			var identityKind = data.value[i].prGroupDesc; //对象
			//					console.log(identityKind);
			var identityDiscount = data.value[i].prCurr4dbc; //对象折扣
			//				console.log(identityDiscount);
			var discount = identityDiscount / 100; //机损后的对象折扣
			//				console.log(discount);
			html += "<option value=" + discount + " aa="+identityKind+" >" + identityKind
			+ "</option>"
			ticketBody.html(html);
		}
		setTimeout(function() {
			$("#ticketMoney").val($("#ticketKind").val() * $("#ticketBody").val());
//			$("#countPrice").text(
//			$("#ticketKind").val() * $("#ticketBody").val());
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

