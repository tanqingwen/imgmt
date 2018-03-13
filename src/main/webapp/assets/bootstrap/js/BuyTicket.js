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
		if(this.checked) {
			$(".form-table input:checkbox").prop("checked", true);
		} else {
			$(".form-table input:checkbox").prop("checked", false);
		}
	});

	$("#refresh").on('click', function() {
		window.location.reload();
	});
	//等待支付弹框
	//	$("#resale").on('click', function() {
	//		$(".markbox").css("height", $(document).height());
	//		$(".markbox").css("width", $(document).width());
	//		$(".markbox").show();
	//		$(".mark1").show();
	//	});
	//	$(".close").click(function() {
	//		$(".markbox").css("display", "none");
	//		$(".mark1").css("display", "none");
	//	})
	//	$(".markbox").click(function() {
	//		$(".markbox").css("display", "none");
	//		$(".mark1").css("display", "none");
	//	})
	//支付方式弹框
	var closeimg = $('.close');
	$("#resale").on('click', function() {
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
	$('.CashPayment').click(function() {
		$(".markbox").css("height", $(document).height());
		$(".markbox").css("width", $(document).width());
		$(".markbox").show();
		$(".mark3").show();
	})
	$(".close").click(function() {
		$(".markbox").css("display", "none");
		$(".mark3").css("display", "none");
	})
	$(".markbox").click(function() {
		$(".markbox").css("display", "none");
		$(".mark3").css("display", "none");
	})
	//var timer1 ;
	//支付宝或者微信支付弹框
	$('.wechat,.Alipay').click(function() {
		$(".markbox").css("height", $(document).height());
		$(".markbox").css("width", $(document).width());
		$(".markbox").show();
		$(".mark5").show();
		//timer1 = setInterval("tonglianpay()", 300);
	})
/*	function tonglianpay(){
		var payCode =$("#payCode").val();
		if($.trim(payCode)!=null && $.trim(payCode)!=''){
			clearInterval(timer1);
			$("#payForm").submit();
		}
	}*/
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

	//
	//支付超时弹框
	//   $('*').click(function() {
	//		$(".markbox").css("height", $(document).height());
	//		$(".markbox").css("width", $(document).width());
	//		$(".markbox").show();
	//		$(".mark4").show();
	//	})
	//	$(".close").click(function() {
	//		$(".markbox").css("display", "none");
	//		$(".mark4").css("display", "none");
	//	})

	//特殊门票显示特殊证件
	$('#ticketBody').change(function() {
		var val = $(this).attr('obj');
		
		if(val =='军人' || val=='残疾人' || val=='学生' ) {
			$('.ticketStatus').css('display', 'block');
		} else {
			$('.ticketStatus').css('display', 'none');
		}
	});
	//身份证件选择
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
	})

	//找零计算
	$(function() {
		$("#receiptsPrice").bind('input porpertychange', function() {
			var all = $("#allPrice").val();
			//			console.log(all);
			var receipts = $("#receiptsPrice").val();
			//			console.log(receipts);
			var change = parseFloat((receipts - 0) - (all - 0)).toFixed(1);;

			$('#changePrice').val(change);
		});

	});

	//票價計算方法
	//	function countPrice($ticketKind, $ticketBody,$Recharge) {
	//		ck_value = [];
	//		ch_value = [];
	//		rechange=[];
	//		$("#ticketKind").change(function() {
	//			ck_value = [];
	//			ck_value.push($ticketKind);
	//			console.log(ck_value);
	//			$countPrice = ck_value * ch_value;
	//			console.log($countPrice);
	//			var html = $countPrice;
	//			$("#countPrice").html(html);
	//		});
	//		$("#ticketBody").change(function() {
	//			ch_value = [];
	//			$ticketBody = $(this).val();
	//			ch_value.push($ticketBody);
	//			console.log(ch_value);
	//			$countPrice =ck_value * ch_value;
	//			console.log($countPrice);
	//			var html = $countPrice;
	//			$("#countPrice").html(html);
	//		});
	//		$("#Recharge").blur(function(){
	//				rechange=[];
	//				$Recharge=$(this).val();
	//				console.log($Recharge);
	//				rechange.push($Recharge);
	//				$countPrice=ck_value * ch_value;
	//				var html=$countPrice;
	//				$("#countPrice").html(html);
	//				
	//		})
	//	
	//	};

	//ajax请求
	//	init();
	//	countPrice();
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
			url: "http://58.246.52.102:3551/imgmt/cpticket/ticketType/list",
			success: function(result) {
				//console.log(result.value.length);
				var a = [];
				var len = result.value.length;
				var ticketKind = $('#ticketKind');
				var html = "";
				for(var i = 0; i < len; i++) {
					var ticketName = result.value[i].ttTypeDesc;
					var ticketPrice = result.value[i].ttListPrice;
					html += "<option value=" + ticketPrice + ">" + ticketName + "</option>"
					ticketKind.html(html);

				}

			}
		});

		//添加刪除事件

		$('.btn-orang').click(function() {
			var username = $('#username').val();
			var Recharge = $('#Recharge').val();
			var kind = $('#ticketKind').text();
			console.log(kind);
			var price = $("#ticketMoney").val();
			//			console.log($("#ticketMoney").val());			
			$('.buyCar').append("<tr class='text-center '><td><input type='checkbox' /></td><td>" + kind + "</td><td>" + username + "</td><td>￥<span value='0'>" + price + "</span></td><td>￥<span>" + Recharge + "</span></td><td><button class='btn'>删除</button></td></tr>");
			$('.btn').click(function() {
				$(this).parents('tr').remove();
			})
		})
		$("#Recharge").blur(function() {
			$("#ticketKind").on("change", function() {
//				var all = $("#ticketKind").val() * $("#ticketBody").val();
//				$("#ticketMoney").val(all);
//              console.log(all)
//				var racharge = $("#Recharge").val();
//				var a = all + recharge;
//				console.log(a);
//				$("#countPrice").text(a);
           $("#ticketMoney").val($("#ticketKind").val() * $("#ticketBody").val());
           $("#countPrice").text($("#ticketKind").val() * $("#ticketBody").val());
			})

		});
		$("#ticketBody").on("change", function() {
			$("#ticketMoney").val($("#ticketKind").val() * $("#ticketBody").val());
			$("#countPrice").text($("#ticketKind").val() * $("#ticketBody").val());
		});

		//获取对象列表
		$.ajax({
			type: "get",
			url: "http://58.246.52.102:3551/imgmt/cpticket/objGrade/list",
			success: function(data) {
				var len = data.value.length;
				var ticketBody = $("#ticketBody");
				var html = "";
				for(var i = 0; i < len; i++) {
					var identityKind = data.value[i].prGroupDesc; //对象
					var identityDiscount = data.value[i].prCurr4dbc; //对象折扣
					var discount = identityDiscount / 100; //机损后的对象折扣
					html += "<option value=" + discount + "  obj='"+identityKind+"' >" + identityKind + "</option>"
					ticketBody.html(html);
				}
				/*setTimeout(function() {
					$("#ticketMoney").val($("#ticketKind").val() * $("#ticketBody").val());
					$("#countPrice").text($("#ticketKind").val() * $("#ticketBody").val());
				})*/

			}
		});

	})

	//	}