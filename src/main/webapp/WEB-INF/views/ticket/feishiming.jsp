<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>非实名制购票</title>
<link rel="stylesheet" href="${assets}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assets}/layer/skin/layer.css" />
<link rel="stylesheet" href="${assets}/css/buyticketPos.css" />
<style>
.mark3 .form-group {
	margin-left: 6px;
}

.buyticketPos .closedimg {
	margin-top: 10px;
	margin-right: -5px;
}

.buyticketPos .mark3 img {
	margin-right: -10%;
}
</style>
</head>
<body>
	<div class="buyticketPos">
		<header>
		<h3 class="text-center">非实名制购票</h3>
		</header>
		<div class="container">
			<h3 style="border-bottom: 2px dashed #f7ab00;">点击选择</h3>
			<form>
				<div class="form-group">
					<label>票券种类：</label> <select id="ticketKind"
						class="line-input form-control"></select>
				</div>
				<div class="form-group">
					<label>对象：</label> <select id="ticketBody"
						class="line-input form-control"></select>
				</div>
				<div class="form-group">
					<label>票劵金额：</label> <input type="text" id="ticketMoney"
						disabled="disabled" class="line-input form-control">
				</div>
			</form>
			<div class="col-xs-12 clearfix activeBtn">
				<div class="col-xs-6">
<%-- 					<a href="${ctx }/startTreeviewDetail/pwzy" class="form-a">&lt;返回</a> --%>
				</div>
				<div class="col-xs-6 text-right">
					<a href="javascript:void(0)" id="refresh">刷新</a>
				</div>
			</div>
			<div class="col-xs-12 text-right paymoney clearfix">
				<div class="">
					<span class="allpay">支付总额：￥<strong id="countPrice" class="">0.00</strong></span>
				</div>
			</div>
			<div class="col-xs-12 clearfix btnGro">
				<div class="col-xs-6">
					<button type="button" class="btn-orang btnAll btnCart">加到购物车</button>
				</div>
				<div class="col-xs-6 text-right">
					<button type="button" class="btn-size  btnAll" id="resale">结算</button>
				</div>
			</div>
			<table class="table table-striped buyCar">
				<tr class="text-center">
					<th class="text-center">门票名称</th>
					<th class="text-center">票价</th>
					<th class="text-center">操作</th>
				</tr>

			</table>
			<!--mark-->
			<div class="markbox" style="display: none;"></div>

			<!--支付方式选择弹框-->
			<div class="mark2" style="display: none;">
				<div class="close">
					<span><img src="${assets}/ticket/images/close.png"
						class="closedimg" /></span>
				</div>
				<div class="innerMark2 text-center">
					<ul class="payType text-center">
						<li class="wechat"><img src="${assets }/app/img/pay1.png" />微信支付
						</li>
						<li class="Alipay"><img src="${assets }/app/img/pay2.png" />支付宝支付
						</li>
						<%-- <li class="UnionPay" onclick="demo()">
								<img src="${assets }/app/img/pay3.png" />银联支付
							</li> --%>
						<li class="ZhiNengPos"><img src="${assets }/app/img/pay7.jpg" />智能pos
						</li>
						<!--<li class="happyWorld">
								<img src="${assets }/app/img/pay4.png" />乐园卡支付
							</li>-->
						<li class="CashPayment"><img
							src="${assets }/app/img/pay6.png" />现金支付</li>
					</ul>
				</div>
			</div>
			<!--现金支付弹框-->
			<div class="mark3" style="display: none;">
				<div class="row">
					<div class="close col-sm-12  clearfix ">
						<img src="${assets}/ticket/images/close.png"
							class="closedimg text-right" />
					</div>
				</div>
				<div class="Mark3Inner">
					<div class="row text-center">
						<div class="form-group all clearfix">
							<div class="col-xs-12">
								<label class="col-xs-4">总计</label> <input class="col-xs-8"
									type="text" id="allPrice" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group receipts clearfix">
							<div class=" col-xs-12">
								<label class="col-xs-4">实收</label> <input type="text"
									id="receiptsPrice" class="col-xs-8" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group change clearfix">
							<div class="col-xs-12">
								<label class="col-xs-4">找零</label> 
								<input class="col-xs-8"
									type="text" id="changePrice" />
							</div>
						</div>
					</div>

				</div>
				<div class="sureOrder col-sm-12 text-center">
					<a href="javascript:void(0)" id="cashPay"
						style="height: 54px; line-height: 54px;"><input type="button"
						id="cashPayBtn" value="确定" /></a>
				</div>
			</div>
		</div>
		<!--支付超时-->
		<div class="mark4" style="display: none;">
			<div class="close">
				<span><img src="${assets}/ticket/images/close.png"
					class="closedimg" /></span>
			</div>
			<div class="mark4Content">
				<h2 class="text-center">支付超时</h2>
				<h4 class="overtime text-center">错误码：交易超时</h4>
				<div class="repayment text-center">
					<button id="ErrorBtn">重新支付</button>
				</div>
			</div>
		</div>
<%-- 		<!--等待付款弹框-->
		<div class="mark5" style="display: none;">
			<div class="close">
				<span><img src="${assets}/ticket/images/close.png" /></span>
			</div>
			<div class="mark5Content">
				<h2 class="text-center">等待付款...</h2>
				<h4 class="text-center">请使用扫码枪扫描付款码</h4>
				<input type="hidden" id="formOrderId" name="formOrderId"> <input
					type="hidden" id="formAmount" name="formAmount" value="0.01">
				<div class="text-center">
					<label for="payCode">付款码</label><input type="text" id="payCode"
						name="payCode" class="form-control" />
				</div>
			</div>
		</div> --%>
		<!--支付成功弹框-->
		<div class="mark7" style="display: none;">
			<div class="mark7Content">
				<h1 class="text-center">支付成功</h1>
				<div class="text-center">
					<a href="javascript:void(0)"><button id="successBtn">确定</button></a>
				</div>
			</div>
		</div>
		<!--乐园卡支付弹框 -->
		<!--<div class="mark8" style="display: none;">
				<div class="close">
					<span><img src="${assets }/app/img/关闭.png" /></span>
				</div>
				<div class="mark5Content">
					<h1 class="text-center">等待付款...</h1>
					<h4 class="text-center">请使用乐园卡刷卡支付</h4>
					<input type="hidden" id="formOrderId" name="formOrderId">
					<input type="hidden" id="formAmount" name="formAmount" value="0.01">
					<div class="form-group form-line"><label for="">乐园卡号</label><input type="text" id="payCode2" name="payCode2" /> <button class="btn payCardBtn" onclick="leyuanka()">刷卡</button></div>
				</div>
			</div>-->
	</div>

	<script src="${assets}/huiyuan/js/jquery-3.1.1.min.js"></script>
	<script src="${assets}/layer/layer.js"></script>
	<script src="${assets}/yanwu/js/buyticketPos3.js"></script>
	<script type="text/javascript">
				var sIPAddr = "";
				var service = locator.ConnectServer();
				service.Security_.ImpersonationLevel = 3;
				service.InstancesOfAsync(foo,
						'Win32_NetworkAdapterConfiguration');
			</script>
	<script FOR="foo" EVENT="OnObjectReady(objObject,objAsyncContext)"
		LANGUAGE="JScript">
				
		
		
			if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true) {
				if(objObject.IPEnabled && objObject.IPAddress(0) != null && objObject.IPAddress(0) != "undefined")
					sIPAddr = objObject.IPAddress(0);

			}
			
/* 	$('.btnCart').click(function(){
		this.css('background','#fff');
		alert(123);
	});	 */
	
	
			</script>
</body>
</html>