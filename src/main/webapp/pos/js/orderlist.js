function time(str){
        var year = str.substr(0,4);
        var month = str.substr(4,2);
        var day = str.substr(6,2);
        var hour = str.substr(9,2);
        var minute = str.substr(11,2);
        var second = str.substr(13,2);
        var date =  year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
        return date;
}
function payType(str){
	var finalstr ='';
	if(str === 'ZNPOS_WX'){
     finalstr = '微信支付';
	}
	if(str === 'ZNPOS_ZFB'){
	 finalstr = '支付宝支付';
	}
	if(str === 'ZNPOS_CARD'){
	finalstr = '银行卡支付'	;
	}
	if(str === 'ZNPOS_CASH'){
	finalstr= '现金支付';	
	}
	return finalstr;
}
function getPayType(str){
	var obj = new Object();
	obj["ZNPOS_CARD"] = 2;
	obj["ZNPOS_WX"] = 1;
	obj["ZNPOS_ZFB"] = 1;
	return obj[str];
}
var cancelOrderId = "";
function showInfoFromJava(resp){

//	订单号   orderId   ; transType  交易类型 1支付 2退款  ;payType  支付方式 ，那几种方式； settlePrice  支付金额  ； serialNo  交易流水号  
	
	alert(resp);
	var payType = resp.split(',')[0];
	var status = resp.split(',')[1];
	var comment = resp.split(',')[2];
	var serialNo = resp.split(',')[3];
	if(status === '00'){
        updateOrder(cancelOrderId,payType,serialNo);
	}else{
		layer.msg(comment);
	}
}

function getPayAmount(str){
	var tmp = parseFloat(str)*100;
	var tmp2 = tmp.toString();
	while(tmp2.length < 12){
		tmp2 = '0' + tmp2;
	}
	return tmp2;
}
//var orderId = ''; 
$.ajax({
	url:urlpath+'app/query/order',
	type:'POST',
	datatype:'json',
//	data:{'orderId':""},
	beforeSend: function(xhr) {
        xhr.setRequestHeader("userId", userId);
    },
	success:function(resultData){
	  if(resultData.status == 'OK'){
	  	$.each(resultData.value, function (index, item){
	  	var finalcount = 0;
	  	$('.content').append('<div class = "order-list"><div class="information"><div class="orderid"><span class="order-tip">订单号：</span><span id = "showorderid'+index+'" class="showorderid"></span></div><div class="time"></div></div><div class="tickettable'+index+'"><table><tbody></tbody></table></div><div class="sum-row clearfix"><div class="sum"><span>共<span class = "ticketnum">4</span>张票</span><span>合计:</span><span class="color-yellow">￥<span class="summoney">540</span></span></div></div><div class="concel hide"><img src="image/concel.png"></div></div>');
		$('#showorderid'+index).text(resultData.value[index].orderId);
		$('.time').text(time(resultData.value[index].createtime));
		$.each(resultData.value[index].items,function(itemindex,item){
			$('.tickettable'+index+' table tbody').append('<tr><td>'+resultData.value[index].items[itemindex].ticketName+'</td><td>'+resultData.value[index].items[itemindex].typeName+'</td><td>'+resultData.value[index].items[itemindex].money+'</td><td>X'+resultData.value[index].items[itemindex].count+'</td><td class="putpaytype hide">'+resultData.value[index].payType+'</td></tr>');
			finalcount += parseInt(resultData.value[index].items[itemindex].count);
		});
        $('.ticketnum').text(finalcount);
        $('.summoney').text(resultData.value[index].money);
        payState(resultData.value[index].status);
	  	});
	  }
	console.log(resultData);
	}
});
function payState(str){
	// if(str == 'Y'){      
	// }
	// if(str == 'X'){
	// }
	if(str == 'R'){
     $('.order-list').addClass('useless');
     $('.concel').removeClass('hide');
	}
}
$('body').on('click','.order-list',function(){
	var orderId = $(this).find('.showorderid').text();
	window.location = 'orderdetail.html?orderId='+orderId;
});