<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>综合管理系统 | 现场购票</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/css.css" />
<link rel="stylesheet" href="${assets}/layer/skin/layer.css"/>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">

	<div style="position: absolute;">
		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="staff" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
 				<h1>实名购票</h1> 
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
					<li class="active">实名购票</li>
				</ol>
			</section>
			<div class="container-fluid">
				<div class="row">
					<div class="tip-img">
						<p>实名购票</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
							<div class="form-line clearfix">
								<div class="col-lg-12">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
												<label>移动电话：</label>
													<input type="text" class="line-input" id="mobile" name="mobile" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
												<label>充值金额：</label>
													<input type="text" class="line-input"  id="Recharge"
														name="amount" value="0"/>
										</div>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<h3 style="border-bottom: 2px dashed #f7ab00;">点击选择</h3>
							<div class="form-line clearfix">
								<div class="col-lg-12 mag">							
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label>票券种类：</label>									
											<select id="ticketKind"  class="line-input" ></select>
									    </div>
								</div>
									<div class="col-lg-6 col-md-6">									
									<div class="form-group">
									    <label>对象：</label>
										<select id="ticketBody"  class="line-input">
										</select>
									</div>
								</div>
								</div>
							</div>

							<div class="col-lg-12 mag ticketStatus form-line">
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label>特殊证件：</label>									
										<select id="specialCertificate" name="specialCertificate" class="line-input">										
										</select>
									</div>

								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label>特殊证件号：</label>									
										<input type="text" id="specialCertificateNumber"
											name="specialCertificateNumber" value="" class="line-input" />
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							<h3 style="border-bottom: 2px dashed #6fba2c;">硬件录入</h3>
							<div class="form-line clearfix">
								<div class="col-lg-12 mag">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">	
											<label>卡流水号：</label>
											<input type="text" id="CbRwdsAccno" name="CbRwdsAccno" 
													value="" class="line-input" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group">	
											<label>持卡人号码：</label>
											
												<input type="text" id="cbCardholderNo" name="cbCardholderNo"      
													value="" class="line-input" 
													style="width: 220px; " />
												<button type="button" class="btn-size" onclick="findCard()">读卡信息</button>
										</div>
									</div>
								</div>
								<div id="hr">aa</div>
								<div class="clearfix"></div>
								<div class="col-lg-12 mag">
				                    <div class="col-lg-6 col-md-6">
				                      <div class="form-group">
				                        <label for="cbIdType" class="" >证件类型：</label>
				                        <select class="DocumentType form-control line-input" id="cbIdType" name="cbIdType" style="width:290px;" >
				                         		<c:forEach var="idType" items="${idTypeList}">
														<option value="${idType.idtypeId }">${idType.idtypeId }--${idType.idtypeDesc }</option>
												</c:forEach>
				                        </select>
				                      </div>
				                    </div>
				                    <div class="col-lg-6 col-md-6">
					                      <div class="form-group readID" style="display: block;">
					                        <label for="idText"  class="">身份证号：&nbsp;&nbsp;</label><input type="text" name="idNo" id="idNo"  class="line-input" style="width:220px;" />
					                        <button type="button" class="btn-size" onclick="readCard()" id="readIdno" style="bcakground-color:#00a65a;">读身份证</button>
					                      </div>
					                      <div class="form-group otherDocuments" style="display: none;">
					                        <label for="otherDocuments" class="DocumentNo ">证件号码：&nbsp;&nbsp;</label><input type="text" id="otherDocuments" class="line-input"  />
					                      </div>
					                      <div class="form-group authCode" style="display: none;">
					                        <label for="authCode" class="noDocumentsLabel "  >授权码：&nbsp;&nbsp;</label><input type="text" name="authCode" id="authCode" class="line-input" />
					                      </div>
				                      
				                    </div>
				                  </div>
								<div class="form-line form-line1 clearfix">
									<div class="col-lg-12 mag">
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label>姓名：</label>
												<input type="text" id="username" name="username"   class="line-input">
												<input type="hidden" id="address" name="address" value=""  >
												<input type="hidden" id="birthday" name="birthday" value=""  >
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
											<div class="form-group">
												<label>票劵金额：</label>
												<input type="text"  id="ticketMoney" disabled="disabled" class="line-input">
											</div>
										</div>
									</div>

								</div>
							</div>
							<div class="clearfix"></div>
							<div class="col-lg-12" style="margin: 50px 0 20px 0">
								<div class="col-lg-12 mag">								
									<div style="float: right;">
										<span style="color: red; margin-right: 45px; font-size: 18px;">支付总额：<strong id="countPrice" class="">￥0.00
												</strong></span>
										<button type="button" class="btn-orang">加到购物车</button>
										<button type="button" class="btn-size"
											style="width: 110px; margin: 0 25px 0 15px;" id="resale">结算</button>
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
										<th class="text-center">姓名</th>
										<th class="text-center">票价</th>
										<th class="text-center">充值</th>
										<th class="text-center">操作</th>
									</tr>
									
								</table>
							</div>
						    <div class="col-lg-12 ">	
						    	<div style="float: left;margin-bottom:20px;">
										<a href="${ctx }/startTreeviewDetail/pwzy" class="form-a">&lt;返回</a>
										 <a href="javascript:void(0)" id="refresh" style="font-size:18px; color:#333;">刷新</a> <span
											style="margin: 0 15px; display: inline-block;"> </span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
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
						</li> --%> 
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
				<div class="all text-center"><label for="">总计</label><input type="text" id="allPrice" readonly /></div>
				<div class="receipts text-center"><label for="">实收</label><input type="text" id="receiptsPrice" /></div>
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
						<div class=" text-center"><label for="">付款码</label><input type="text"  id="payCode" name="payCode"/></div>
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
						<div class="form-group form-line text-center"><label for="">乐园卡号</label><input type="text"  id="payCode" name="payCode"/> <button class="btn payCardBtn">刷卡</button></div>
					</div>
			</div>
		
		</div>
	</div>
	<object classid="CLSID:76A64158-CB41-11D1-8B02-00600806D9B6" id="locator" style="display:none;visibility:hidden"></object>
	<object classid="CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223" id="foo" style="display:none;visibility:hidden"></object> 
	<input type="hidden" name="ipAddress">
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/layer/layer.js"></script>
	<script src="${assets}/bootstrap/js/BuyTicket(1).js"></script>
	<script language="javascript">
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
		
/* 	var o;
	function zhinengpos(orderId,amount){
		$.ajax({
			type:'POST',
			data: {"orderId":orderId,"amount":amount,"ip":sIPAddr,"business_id":"100100001"},
			url:'${ctx}/cpticket/tonglian/pos',
			dataType:'json',
			success:function(data){
				if(data.status=='SUCCESS'){
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
							window.location = "${ctx}/cpticket/queryItemsByOrderId?orderId="+orderId;
						}
						$("#successBtn").html(' 确定'+ second + 's');
						second--;
					}
					 $("#successBtn").click(function(){	  
							$(".markbox").hide();
							$(".mark7").hide();
							clearInterval(time);
						 	window.location.href="${ctx}/cpticket/queryItemsByOrderId?orderId="+orderId;
	                      })
				}else{
					clearInterval(time);
					$(".markbox").show();
					$(".mark4").show();
					$("#ErrorBtn").click(function(){
						
						$(".mark4").hide();
						$(".mark5").show();
					});
				}
			}
		});
	} */
	//读卡号
	function findCard(){
		readCardNo("cbCardholderNo");
		var cardNo=$("#cbCardholderNo").val();
//		alert(cardNo);
		if(cardNo=="undefined" || cardNo==""){
			$("#cbCardholderNo").val("");
			return;
		}
		cardNo="<%=Constants.baseBIN%>" + cardNo;
//		alert(cardNo);
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getKey",
			dataType : "json",
			data : {
				cardNumber : cardNo,
				type : 0
			},
			success : function(data) {
				/* if (failureProcess("${ctx}", data)) {
					document.getElementById(document.getElementsByName("cbCardholderNo")[0]).value = "";
//					alert(e.message);
					return;
				} */
				var p = data.value;
				kamianhao(cardNo);
				key2str = p[0];
				key3str = p[1];
				key6str = p[2];
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
					/* if (failureProcess("${ctx}", data)) {
						return;
					} */
					var map = data.value;
					if(map.status=='D'){
						layer.msg('此卡无效');
						$("#cbCardholderNo").val("");
						return ;
					}
					$("#CbRwdsAccno").val(map.cardNo.substr(6));
					var idType = map.idType;
					if(idType){
						$("#cdIdType").val(idType);
						if(idType==1){
							$('.readID').css('display', 'block');
							$('.otherDocuments').css('display', 'none');
							$('.authCode').css('display', 'none');
							$("#idNo").val(map.idNo);
							$("#username").val(map.name);
							$("#address").val(map.address);
							$("#birthday").val(map.birthday);
							$("#readIdno").css("background","gray");
							$("#readIdno").attr("disabled","disabled");
							$("#cbIdType").find("option[value="+idType+"]").prop("selected",true);
							var age = map.age;
							var price =$("#ticketKind").val();
							if(age<=12){
								$("#ticketBody").find("option[aa='儿童']").prop("selected",true);
								price = price * $("#ticketBody option:selected").val();
							}else if(age<65){
								$("#ticketBody").find("option[aa='成人']").prop("selected",true);
								price = price * $("#ticketBody option:selected").val();
							}else if(age <70){
								$("#ticketBody").find("option[aa='老人']").prop("selected",true);
								price = price * $("#ticketBody option:selected").val();
							}else {
								$("#ticketBody").find("option[aa='老人']").prop("selected",true);
								price =0;
							}
							$("#ticketMoney").val(price);
						}else if(idType==2 ||idType==3){
							$('.readID').css('display', 'none');
						    $('.otherDocuments').css('display', 'block');
						    $('.authCode').css('display', 'none');
						    $("#username").val(map.name);
						    $("#otherDocuments").val(map.idNo);
						    $("#cbIdType").find("option[value="+idType+"]").prop("selected",true);
						}
						
					}
				}
				
			});
		}
	//获取身份证信息
	function readCard() {
		try{
			var idNo = $("#cbIdType").val();
			if (idNo != "1") {
				layer.msg("选择证件类型为身份证");
				return;
			}
			var strReadResult = CVR_IDCard.ReadCard();
			if (strReadResult == "0") {
				$("#idNo").val(CVR_IDCard.CardNo);
				//证件类型1-身份证（自动获取身份证）
				if ($("#cbIdType").val() == "1") {
					$("#username").val(CVR_IDCard.Name);
					$("#address").val(CVR_IDCard.Address);
					//alert(CVR_IDCard.Birthday);
					$("#birthday").val(CVR_IDCard.Born);
	
					sfzyz(CVR_IDCard.CardNo);
				}
				
			} else if(strReadResult == "找不到设备"){
				layer.msg(strReadResult+",请插入读身份证设备");
			}else if(strReadResult == "读居民身份证操作失败"){
				layer.msg(strReadResult+",请将居民身份证放在读身份证控件上！");
			}
		}catch(e){
			
			/* alert("请连接读卡设备"); */
			
		}	
		

		var year = $("#idNo").val().substring(6,10);
		var month = $("#idNo").val().substring(10,12);
		var day = $("#idNo").val().substring(12,14);
		var birth = new Date(year+"/"+month+"/"+day).getTime();
		var age = (new Date().getTime() - birth) / (1000*60*60*24*365)
		
		if (age >= 70) {
			$("#ticketBody").find("option[aa='老人']").prop("selected",true);
			 $("#ticketMoney").val(0)
		
			
		} else if (age >= 60 && age < 70) {
			console.log('大于60小于70')
			$("#ticketBody").find("option[aa='老人']").prop("selected",true);
			 var ticketPrice = $("#ticketKind").val() * 0.5;
			 $("#ticketMoney").val(ticketPrice)
			
		
			
		} else if (age > 12 && age < 60){
			$("#ticketBody").find("option[aa='成人']").prop("selected",true);
			$("#ticketBody").change()
		} else if (age <= 12) {
			
			$("#ticketBody").find("option[aa='儿童']").prop("selected",true);
			$("#ticketBody").change()
		}
	}	
	
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
											window.location = "${ctx}/cpticket/queryItemsByOrderId?orderId="+orderId;
											
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

	</script>
	
</body>
</html>
