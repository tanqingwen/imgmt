// var getcookie = document.cookie;
// var userId = getcookie.split('=')[1];
// var userId = getUserId(getcookie);
// var user
// var getcookie = document.cookie;
// var userId = getcookie.split('=')[1];
 // alert(userId);
// function getUserId(str){
// 	var finalstr = str.split('=')[1];
// 	console.log(finalstr);
// 	return finalstr;
// }
function InitAjax(url,data,type,fun){
	$.ajax({
		url:url,
		type:type,
		dataType:'JSON',
		data:data,
		contentType:'application/json;charset=utf-8',
		beforeSend: function(xhr) {
        xhr.setRequestHeader("userId",userId);
        },
		success:function(resultdata){
			if(fun){
				fun(resultdata);
			}
		},
		error:function(resultdata){
		// if(resultdata.comment == ''){
        layer.msg(resultdata.statusText);
	       // }else{
        // layer.msg(resultdata.comment);	       	
	       // }	
        console.log(resultdata);		
		}
	});
}
// var userId = sessionStorage.getItem("userId");
var item = [];//定义商品数组
var itemdom =[];
var ticketprice = 0;//定义全局变量
var ticketdiscount = 0;
setTimeout(function(){
 perprice(ticketprice,ticketdiscount);
},500);
 //计算票券价格
function perprice(ticketprice,ticketdiscount){
   var perprice = ((ticketprice*ticketdiscount)/100).toFixed(2);
   $('.perprice').text(perprice);
}
// 获取票券列表
InitAjax(urlpath+'app/ticketType/list','','GET',function(resultdata){
       console.log(resultdata);
       if(resultdata.status=='SUCCESS'){
       	$.each(resultdata.value, function (index, item) {
       	$('.ticket').append('<option value = "'+resultdata.value[index].ttListPrice+'" id = "'+resultdata.value[index].ttTypeId+'">'+resultdata.value[index].ttTypeDesc+'</option>');
       	ticketprice =parseFloat($('.ticket').val()).toFixed(3);
       });
       }
});
//获取对象列表
InitAjax(urlpath+'app/objGrade/list','','GET',function(resultdata){
	console.log(resultdata);
	if(resultdata.status=='SUCCESS'){
	 	$.each(resultdata.value, function (index, item) {
	 		$('.passenger').append('<option value = "'+resultdata.value[index].prCurr4dbc+'" id="'+resultdata.value[index].prProdctGroup+'">'+resultdata.value[index].prGroupDesc+'</option>');
	 		ticketdiscount = parseFloat($('.passenger').val()).toFixed(3);
	 	});		
	}
});
totalprice(item);
//监听票券类型下拉变化计算金额
$('.ticket').on('change',function(){
     var ticketprice =parseFloat($(this).val()).toFixed(3);
     var ticketdiscount = parseFloat($('.passenger').val()).toFixed(3);
     console.log(ticketprice);
     perprice(ticketprice,ticketdiscount);    
});
//监听游客对象下拉变化计算金额
$('.passenger').on('change',function(){
     var ticketprice =parseFloat($('.ticket').val()).toFixed(3);
     var ticketdiscount = parseFloat($(this).val()).toFixed(3);
     console.log(ticketprice);
     perprice(ticketprice,ticketdiscount);    
});
//加入购物车
$('.cart-btn').on('click',function(){
	var ticketid = $('.ticket option:selected').attr('id');
	var passengerid = $('.passenger option:selected').attr('id');
	var ticketname = $(".ticket option:selected").text();
	var objgrade = $(".passenger option:selected").text();
	var ticketdiscount = $('.passenger option:selected').val();
	var itemamount = $(".perprice").text();
    var arrele = ticketid+passengerid;
    if(item.length>5){
    	layer.msg("最多只能选择6张票！");
    	return false;
    }
	if(itemdom.length>0){
			if(itemdom.indexOf(arrele) == -1){
			 itemdom.push(arrele);
	         $('tbody').append('<tr id="'+arrele+'"><td class="ticketname">'+ticketname+'</td><td class="objgrade">'+objgrade+'</td><td class="discount hide">'+ticketdiscount+'</td><td class="itemamount">'+itemamount+'</td><td><div class="num"><div class="minus">-</div><div class="amount'+itemdom.length+'">1</div><div class="plus">+</div></div></td></tr>');		
			}else{
			  var selectstr = 'amount'+(itemdom.indexOf(arrele)+1);
			  var amount= parseInt($('.'+selectstr).text());
              amount++;
              $('.'+selectstr).text(amount);
	        }
     }else{
	 itemdom.push(arrele);
	 $('tbody').append('<tr id="'+arrele+'"><td class="ticketname">'+ticketname+'</td><td class="objgrade">'+objgrade+'</td><td class="discount hide">'+ticketdiscount+'</td><td class="itemamount">'+itemamount+'</td><td><div class="num"><div class="minus">-</div><div class="amount'+itemdom.length+'">1</div><div class="plus">+</div></div></td></tr>');		
	}
	console.log(itemdom);
	item.push({
		"ticketType": ticketid,
		"ticketNumber": 1,
		"passengerType"	:passengerid,		
		"itemAmount": itemamount,				
		"discount": ticketdiscount,
		"ticketName": ticketname,
		"objGrade": objgrade
	});
	console.log(item);
	totalprice(item);
});
//删除购物车
$('body').on('click','.minus',function(){
	var amount = parseInt($(this).parent().children().eq(1).text());
	amount--;
	if(amount<0){
		return false;
	}
	$(this).parent().children().eq(1).text(amount);
	var domid = $(this).parent().parent().parent().attr('id');
	deletedata(domid,item);
	totalprice(item);
});
//增加数量
$('body').on('click','.plus',function(){
	var amount = parseInt($(this).parent().children().eq(1).text());
	amount++;
	if(item.length>5){
		layer.msg("最多只能选择6张票！");
		return false;
	}
	$(this).parent().children().eq(1).text(amount);
	var domid = $(this).parent().parent().parent().attr('id');
	insert(domid,item);
	totalprice(item);

});
//计算金额
function totalprice(arr){
	var totalprice = 0;
	for(var i=0;i<arr.length;i++){
		var actualprice = parseFloat(item[i].itemAmount);
		totalprice =parseFloat((totalprice+actualprice).toFixed(2));
	}
		$('.allPrice').text(totalprice);
}
//从数组中删除一条数据
function deletedata(str,arr){
	var ticketid = str.substring(0,4);
	var passengerid = str.substring(4,8);
	for(var i = 0;i<=arr.length-1;i++){
	if(ticketid==arr[i].ticketType&&passengerid==arr[i].passengerType){
        arr.splice(i,1);
        console.log(arr);
        return false;
	}
}
}
//增加数量
function insert(str,arr){
	var ticketid = str.substring(0,4);
	var passengerid = str.substring(4,8);
	var ticketname = $('#'+str).children().eq(0).text();
	var objgrade = $('#'+str+' .objgrade').text();
	var itemamount = $('#'+str+' .itemamount').text();
	var ticketdiscount = $('#'+str).children().eq(2).text();
		item.push({
		"ticketType": ticketid,
		"ticketNumber": 1,
		"passengerType"	:passengerid,		
		"itemAmount": itemamount,				
		"discount": ticketdiscount,
		"ticketName": ticketname,
		"objGrade": objgrade
	});
		console.log(item);
}
//结算
$('#payBtn').click(function(){
	if(item.length > 0){
		 generateOrder('',item);
		$('.mask').removeClass('hide');
		$('.paymask').removeClass('hide');
	}else{
		layer.msg("请先添加购物车！");
		return false;
	}
});
//支付弹框显示
$('body').on('click','.mask', function(){
	$('.mask').addClass('hide');
	$('.paymask').addClass('hide');
	$('.cashpaymask').addClass('hide');
});
$('.close').click(function(){
	$('.mask').addClass('hide');
	$('.paymask').addClass('hide');
	$('.cashpaymask').addClass('hide');
});
//选择支付方式
//现金支付
$('.cashpay').click(function(){
	var payType = 'ZNPOS_CASH';
	var total = $('.allPrice').text();
	$('.paymask').addClass('hide');
	$('.cashpaymask').removeClass('hide');
	$('.totalprice input').val(total);
});
$('.payamount input').bind('input porpertychange',function(){
	var payamount = parseFloat($(this).val()).toFixed(3);
	var total = parseFloat($('.totalprice input').val()).toFixed(3);
	console.log(payamount);
	console.log(total);	
	if(total - payamount >0){
		layer.msg("实付金额不够！");
		$(this).val("");
	}else{
		var change = payamount-total;
		$('.change input').val(change);
	}
});
$('.cashpayconfirm').click(function(){
   var payType = 'ZNPOS_CASH';
   updateOrder(orderId,payType,'');
});
//微信支付
var orderId = '';
$('.wxpay').click(function(){
	var payType = 'ZNPOS_WX';
    post('100300001',payType);
});
//支付宝支付
$('.alipay').click(function(){
   var payType = 'ZNPOS_ZFB';
   post('100300001',payType);
});
//银行卡支付
$('.pospay').click(function(){
   var payType = 'ZNPOS_CARD';
   post('100100001',payType);
});
//生成订单
	function generateOrder(payType,item) {
		amount = parseFloat($('.allPrice').text()).toFixed(2);
		console.log(amount);
		var data = JSON.stringify({'hwIp':pos_ip,'phoneNumber':'','orderAmount':amount,'payType':payType,'chargeAmount':1,'items':item});
		InitAjax(urlpath+'app/buy/start',data,'POST',function(resultdata){
        console.log(resultdata);
         orderId = resultdata.value.orderId;
         // sessionStorage.setItem("orderId",orderid);
		});
	}
	//更新订单
	function updateOrder(orderId,payType,serialNo){
		var amount = $('.allPrice').text();
		var data = {'orderId':orderId,'transType':'1','payType':payType,'settlePrice':amount,'serialNo':serialNo};
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
         window.location = 'orderdetail.html?orderId='+orderId;
	    },
	    error:function(resultData){
         console.log('生成订单错误回调');
         console.log(resultData);
	    }
		});
		}

	//pos机扫码支付
    function post(business_id,payType) {
    	var amount = parseFloat($('.allPrice').text()).toFixed(2);
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
        xhr.open("POST", "http://192.168.1.41:9801/trans", true);
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.onreadystatechange = function(){
            var XMLHttpReq = xhr;
            if (XMLHttpReq.readyState == 4) {
                if (XMLHttpReq.status == 200) {
                    var text = XMLHttpReq.responseText;
                    // objform.response.value=text;
                     var finaltext = JSON.parse(text);
                     if(finaltext.rejcode=="00"){
                     	console.log(finaltext);
                     	var serialNo = finaltext.trace_no; 
                      updateOrder(orderId,payType,serialNo);
                     }
                }
            }
        };
        xhr.send(postData);
    }
	$('.manage').click(function(){
		window.location = 'manage.html';
	});