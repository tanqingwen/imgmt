//生成订单
	function generateOrder(payType) {
		amount = parseFloat($("#countPrice").text()).toFixed(2);
		$.ajax({
			url: cmPath + '/buy/start/',
			type: 'POST',
			contentType: 'application/json;charset=utf-8',
			dataType: "json",
			data: JSON.stringify({
				"hwIp": '',
				"phoneNumber":'',
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