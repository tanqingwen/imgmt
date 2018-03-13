<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 现场购票</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
	<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
	<link rel="stylesheet" href="${assets}/validator/css/css.css" />
	<link rel="stylesheet" href="${assets}/layer/skin/layer.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
  	<div style="position:absolute;">
		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="staff"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>非实名制购票</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">非实名制购票</li>
          </ol>
        </section>

        <!-- Main content -->
   			<div class="container-fluid noName">
				<div class="row">
 					<div class="tip-img">
 						<p>非实名制购票</p>
					<%-- 	<img src="${assets }/app/img/非实名制购票.png"> --%>
					</div>
					<div class="content">

						<div class="main">
							<h3 style="border-bottom: 2px dashed #f7ab00;">点击选择</h3>
							<div class="form-line clearfix">
								<div class="col-lg-12 mag col-md-12 col-sm-12">							
									<div class=" col-md-6 col-sm-12">
										<div class="form-group">
											<label class="">票券种类：</label>									
											<select id="ticketKind"  class="line-input" ></select>
									    </div>
								</div>
									<div class=" col-md-6  col-sm-12">									
									<div class="form-group">
									    <label>对象：</label>
										<select id="ticketBody"  class="line-input">
										</select>
									</div>
								</div>
								
							    <div class="col-lg-6 col-md-6">
								<div class="form-group">
												<label>票劵金额：</label>
												<input type="text"  id="ticketMoney" disabled="disabled" class="line-input">
											</div>
								</div>
								<div class="col-lg-6 col-md-6">	
									<label for="ctApproveTimeEnd" class="labelWidth">游玩时间：</label>										
										<div class="input-group date firstCommission" style="display:inline-table;vertical-align:middle;width:290px;">
											<span class="input-group-addon" style="border-radius:5px 0 0 5px;border:1px lightblue solid;border-right:none;"><i class="glyphicon glyphicon-calendar"></i></span>
											<input readonly="" class="form-control line-input" id="visitTime" name="visitTime" value="" style="width:250px;">
										</div>
									</div>
								</div>
							</div>
							</div>
							<div class="col-lg-12" style="margin: 50px 0 20px 0">
								<div class="col-lg-12 mag">
									<div style="float: right;" class="regro">
										<span class="allpay" >支付总额：<strong id="countPrice" class="">￥0.00
												</strong></span>
									  <div class="btnGro">	
										<button type="button" class="btn-orang">加到购物车</button>
										<button type="button" class="btn-size"
											style="" id="resale">结算</button>
									</div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="form-table">
								<table class="table table-striped buyCar">
									<tr class="text-center">
										<!-- <th class="text-center"><input type="checkbox" name=""
											id="allcheck" value=""
											style="margin-right: 5px; width: 16px; height: 16px; vertical-align: text-bottom; margin-bottom: 2px; margin-bottom: -2px;" /><label
											for="Checkbox1"
											style="vertical-align: text-bottom; margin-bottom: -3px;">全选</label></th> -->
										<th class="text-center">门票名称</th>
										<th class="text-center">票价</th>
										<th class="text-center">操作</th>
									</tr>
									
								</table>
							</div>
							<div class="col-lg-12 mag">
									<div style="float: left;" class="regro">
										<a href="${ctx }/startTreeviewDetail/pwzy" class="form-a">&lt;返回</a> 
										<a href="javascript:void(0)" id="refresh" style="color:#333;font-size:18px !important;">刷新</a> 
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
        </div><!-- /.box -->
        <!-- /.content -->
       <!-- /.content-wrapper -->
      			<!--mark-->
			<div class="markbox" style="display: none;"></div>
			<!--支付方式选择弹框-->
			<div class="mark2" style="display: none;">
				<div class="close">
					<span><img src="${assets }/app/img/关闭.png" class="closedimg"/></span>
				</div>
				<div class="innerMark2">
					<ul class="payType">
						<li class="wechat">
							<img src="${assets }/app/img/pay1.png" />微信支付
						</li>
						<li class="Alipay">
							<img src="${assets }/app/img/pay2.png" />支付宝支付
						</li>
						<li class="UnionPay" onclick="demo()">
							<img src="${assets }/app/img/pay3.png" />银联支付
						</li>
						<li class="ZhiNengPos">
							<img src="${assets }/app/img/pay7.jpg" />智能pos
						</li>
					    <%-- <li class="happyWorld">
							<img src="${assets }/app/img/pay4.png" />乐园卡支付
						</li>  --%> 
						<li class="CashPayment">
							<img src="${assets }/app/img/pay6.png" />现金支付
						</li>
					</ul>
				</div>
			</div>
			<!--现金支付弹框-->
			<div class="mark3" style="display:none;">
			<div class="close">
					<span><img src="${assets }/app/img/关闭.png"class="closedimg"/></span>
				</div>
				<div class="all text-center"><label for="">总计</label><input type="text" id="allPrice"  readonly/></div>
				<div class="receipts text-center"><label for="">实收</label><input type="text" id="receiptsPrice"  /></div>
				<div class="change text-center"><label for="">找零</label><input type="text" id="changePrice" readonly/></div>
				<div class="sureOrder text-center">
					<a href="javascript:void(0)" id="cashPay" style="height:54px;line-height:54px;"><input type="button" id="cashPayBtn" value="确定" /></a>
				</div>
			</div>
			<!--支付超时-->
			<div class="mark4" style="display: none;">
				<div class="close">
					<span><img src="${assets }/app/img/关闭.png"class="closedimg"/></span>
				</div>
				<div class="mark4Content">
					<h1 class="text-center">支付超时</h1>
					<h2 class="overtime text-center">错误码：交易超时</h2>
					<div class="repayment text-center"><button id="ErrorBtn">重新支付</button></div>
				</div>
			</div>
			<!--等待付款弹框-->
			<div class="mark5" style="display: none;">
					<div class="close">
						<span><img src="${assets }/app/img/关闭.png" /></span>
					</div>
					<div class="mark5Content">
						<h1 class="text-center">等待付款...</h1>
						<h4 class="text-center">请使用扫码枪扫描付款码</h4>
						<input type="hidden" id="formOrderId" name="formOrderId"  >
						<input type="hidden" id="formAmount" name="formAmount"  value="0.01">
						<div class="text-center"><label for="">付款码</label><input type="text"  id="payCode" name="payCode"/></div>
					</div>
			</div>
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
			<div class="mark8" style="display: none;">
					<div class="close">
						<span><img src="${assets }/app/img/关闭.png" /></span>
					</div>
					<div class="mark5Content">
						<h1 class="text-center">等待付款...</h1>
						<h4 class="text-center">请使用乐园卡刷卡支付</h4>
						<input type="hidden" id="formOrderId" name="formOrderId"  >
						<input type="hidden" id="formAmount" name="formAmount"  value="0.01">
						<input type="hidden" id="cbCardholderNo" name="cbCardholderNo"  value="">
						<div class="form-group form-line text-center"><label for="">乐园卡号</label><input type="text"  id="payCode2" name="payCode2"/> <button class="btn payCardBtn" onclick="leyuanka()">刷卡</button><button class="btn readCardBtn" onclick="findCard()">读卡</button></div>
					</div>
			</div>
	<object classid="CLSID:76A64158-CB41-11D1-8B02-00600806D9B6" id="locator" style="display:none;visibility:hidden"></object>
	<object classid="CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223" id="foo" style="display:none;visibility:hidden"></object> 
	<input type="hidden" name="ipAddress">
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
    <tags:load_common_js/>
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/layer/layer.js"></script>
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
    <script src="${assets}/bootstrap/js/BuyTicket2.js"></script> 
    <script type="text/javascript">
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
	<script type="text/javascript">
	//票劵金额计算
	function changetotalAmountPaid() {
		var amount = $("#amount").val()
		var vartkAmount = $("#vartkAmount").val()
		
		if (amount == "") {
			$("#amount").val(0);
		}
		console.log(vartkAmount);
		if (vartkAmount == "") {
			$("#vartkAmount").val(0);
		}
	  $('#allMoney').text(parseInt(vartkAmount)+ parseInt(amount));
	}  
	
 	function findCard(){
 		readCardNo("cbCardholderNo");
		var cardNo=$("#cbCardholderNo").val();
		if(cardNo=="undefined" || cardNo==""){
			$("#cbCardholderNo").val("");
			return;
		}
		cardNo="<%=Constants.baseBIN%>" + cardNo;
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getKey",
			dataType : "json",
			data : {
				cardNumber : cardNo,
				type : 0
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					document
							.getElementById(document
									.getElementsByName("cbCardholderNo")[0]).value = "";
					alert(e.message);
					return;
				}
				var p = data.value;
				kamianhao(cardNo);
			}
		});
 	}
 	
 	function kamianhao(cardNo){
		$.ajax({
			type : "POST",
			url : "${ctx}/cpticket/getMemberMsgByCardNo",
			dataType : "json",
			data : {
				cardNo : cardNo
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var map = data.value;
				if(map.status=='D'){
					layer.msg('此卡无效');
					$("#cbCardholderNo").val("");
					return ;
				}
				$("#payCode2").val(map.cardNo.substr(6));				
			}			
		});
	}
 	
 	function demo() {
		generateOrder("POS");
		var request = new   ActiveXObject("ALLINPAY.RequestData");
		var response = new ActiveXObject("ALLINPAY.ResponseData");
		var mis = new ActiveXObject("ALLINPAY.MisPos");
		request.PutValue("CardType", "01");
		request.PutValue("TransType", "02");
		request.PutValue("Amount", amount);
		var result = mis.TransProcess(request, response);
		var PosTraceNumber=response.GetValue("PosTraceNumber");
		if(response.GetValue("Rejcode")=='00'){
			$.ajax({
				type:'POST',
				data: {"orderId":orderId,"payType":"POS","receiptsPrice":"","hwPaymentListid":PosTraceNumber},
				url:'${ctx}/cpticket/updateOrderStatus',
				dataType:'json',
				success:function(data){
					if(data.status='SUCCESS'){
						//alert("支付成功");
						//清空购物车
						arrInfo.splice(0,arrInfo.length);
						
						setTimeout(function() {
							$(".markbox").hide();
							$(".mark7").hide();
						}, 3000)
						
						var time = setInterval(showTime, 1000);
						var second = 3;
						function showTime() {
							if(second == 0) {
								clearInterval(time);
								window.location = "${ctx}/cpticket/queryItemsByOrderId2?orderId="+orderId;
								
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
							$(".markbox").hide();
							$(".mark4").hide();
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
 	
 	$(document).ready(function(){
 		var dt = new Date();
 		var y = (dt.getFullYear()).toString();
 		var m = ((dt.getMonth() + 1) < 10?"0"+(dt.getMonth() + 1):(dt.getMonth() + 1)).toString();
 		var d = (dt.getDate() < 10?("0"+dt.getDate()):dt.getDate()).toString();
 		$('#visitTime').val(y+"-"+m+"-"+d);
 		var dataPickerOp2 = {
	            format: 'yyyy-mm-dd',
	            weekStart: 1,
	            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
	            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
	            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
	            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
	            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
	            autoHide: true,
	            startDate:new Date()
	        };
        $('#visitTime').datepicker(dataPickerOp2);
        /* $('#visitTime').change(function(){
        	var val = $(this).val();
        		val = val.split('-').join('');
        	$(this).val(val);
        }); */
 	});
    </script>
  </body>
</html>
