var url = window.location;
   function GetQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
                if (r != null){
                     return unescape(r[2]);
                }else{
                return null;
                }
              }
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
var orderId = GetQueryString('orderId');
// var userId = sessionStorage.getItem('userId');
$.ajax({
	url:urlpath +'app/query/order',
	type:'POST',
	datatype:'json',
	data:{'orderId':orderId},
	beforeSend: function(xhr) {
        xhr.setRequestHeader("userId", userId);
    },
	success:function(resultData){
	  if(resultData.status == 'OK'){
	  	$.each(resultData.value,function (index, item){
	  	var finalcount = 0;
	  	$('.order-list').append('<div class="information"><div class="orderid"><span class="order-tip">订单号：</span><span class = "showorderid"></span></div><div class="time"></div></div><div class="tickettable"><table><tbody></tbody></table></div><div class="sum-row clearfix"><div class="sum"><span>共<span class = "ticketnum">4</span>张票</span><span>合计:</span><span class="color-yellow">￥<span class="summoney">540</span></span></div></div><div class="paytype-row"><span class="paytype-tip">支付方式</span><span class="payType"></span></div><div class="btn-group"><button class="ticket-btn">打印票券</button><button class="ticket-btn continue">继续购票</button><button class="ticket-btn refound">退票</button></div>');
		$('.showorderid').text(resultData.value[index].orderId);
		$('.time').text(time(resultData.value[index].createtime));
		$.each(resultData.value[index].items,function(itemindex,item){
			$('.tickettable table tbody').append('<tr><td>'+resultData.value[index].items[itemindex].ticketName+'</td><td>'+resultData.value[index].items[itemindex].typeName+'</td><td>'+resultData.value[index].items[itemindex].money+'</td><td>X'+resultData.value[index].items[itemindex].count+'</td></tr>');
			finalcount += parseInt(resultData.value[index].items[itemindex].count);
		});
        $('.ticketnum').text(finalcount);
        $('.summoney').text(resultData.value[index].money);
        $('.payType').text(payType(resultData.value[index].payType));
	  	});
	  }
	console.log(resultData);
	}
});
$('body').on('click','.continue',function(){
	window.location = 'posbuyticket.html';
});

$('body').on('click','.refound',function(){
	var thisdom = $(this);
	layer.confirm('确定退票？', {
    btn: ['确定','取消'] //按钮
    }, function(){
    	var orderId = thisdom.parent().parent().children().eq(0).children().eq(0).children().eq(1).text();
    	console.log("订单号："+orderId);
    	console.log($(this).parent().parent());
    	// $(this).parent().parent().children().eq(0).children().eq(0).children().eq(1).text()
    	$.ajax({
		url:urlpath+'app/pos/cancel/check',
		data:{'orderId':orderId,'ip':pos_ip},
	    dataType:'JSON',
	    // contentType:'application/x-www-form-urlencoded',
	    type:'POST',
	    beforeSend: function(xhr) {
        xhr.setRequestHeader("userId", userId);
        },
	    success:function(resultData){
         console.log(resultData);
         var payType = getPayType(resultData.value.payType);
         var orderIdback = resultData.value.orderId;
         // console.log(orderId);
         var origOrderId = resultData.value.origOrderId;
         var serialNo = resultData.value.serialNo;
         var money = getPayAmount(resultData.value.money);
         var str = payType + ','+serialNo+',' + money;
         cancelOrderId = orderIdback;
         window.jsObj.sendCancelTicketData(str);
	    },
	    error:function(resultData){
         console.log(resultData);
	    }
	});
},function(){});
});
	function updateOrder(orderId,payType,serialNo){
		var amount = $('.allPrice').text();
		var data = {'orderId':orderId,'transType':'2','payType':payType,'settlePrice':amount,'serialNo':serialNo};
		//console.log(data);
		$.ajax({
	    url:urlpath+'app/update/order/state',
	    data:data,
	    dataType:'JSON',
	    contentType:'application/x-www-form-urlencoded',
	    type:'POST',
	    beforeSend: function(xhr) {
        xhr.setRequestHeader("userId", userId);
        },
	    success:function(resultData){
         console.log("更新订单"+resultData);
         layer.msg("退票成功！");
	    },
	    error:function(resultData){
         console.log('生成订单错误回调');
         console.log(resultData);
	    }
		});
		}
