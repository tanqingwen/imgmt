<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>收银结班</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets }/css/getmoney.css" />
   	<style>
   	.btn-green {
    background: #00a65a;
    width: 110px;
    height: 40px;
    color: white;
    border: none;
    border-radius: 5px;
    margin: 10px 30px 10px 0;
    float: right;
}
   	</style>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="role"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>结班</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li><a href="${ctx }/shifting/add">收银交班</a></li>
            <li class="active">结班</li>
          </ol>
        </section>

        <!-- Main content -->
        <div class="container">
			<div class="row clearfix">
				<div class="col-lg-1 col-md-1 text-center lebelT"><img src="${assets }/app/img/收银结班.png" /></div>
				<div class="col-lg-11 col-md-11">
					<div class="BindContent text-center">
						<div class="contentInner clearfix">
							<h3>收银结班报表</h3>
							<div class="col-lg-12 clearfix">
								<div class="col-lg-6 banbiehao">
									<dl>
										<dd>班别号: <span id="year"></span></dd>
										<!-- <dd>打印时间: <span id="printTime"></span></dd> -->
										<dd>结班员工工号: <span>${userId }</span></dd>
										<dd>结班员工: <span>${userName }</span></dd>
									</dl>
								</div>
								<div class="col-lg-6 banbiehao">
									<dl>
										<dd>结班时间: <span id="jbTime"></span></dd>
										<dd>设备名称: <span>${posIp }</span></dd>
										
									</dl>
								</div>
							</div>
							
							<div class="col-lg-12">
								<div class="col-lg-6 banbiehao">
									<h4>当班营业明细</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="width:90%;text-align: left;">
										<!-- <tr>
											<td style="width: 12%;">1.</td>
											<td style="width: 38%;">海洋馆全票</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;">2 张</td>
											<td style="width: 20%;text-align:right;">500</td>
										</tr>
										<tr>
											<td style="width: 12%;">2.</td>
											<td style="width: 38%;">动物馆儿童票 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;">4 张</td>
											<td style="width: 20%;text-align:right;">400</td>
										</tr>
										<tr>
											<td style="width: 12%;">3.</td>
											<td style="width: 38%;">全馆通票 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;">2 张</td>
											<td style="width: 20%;text-align:right;">1000</td>
										</tr> -->
										<c:forEach items="${list}" var="shift" varStatus="status">
											<tr>
												<td style="width: 38%;">${shift.ticketName}</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;">${shift.ticketCount}张</td>
												<td style="width: 20%;text-align:right;">${shift.ticketSum}</td>
											</tr>
										</c:forEach>
										<tr>
											<td style="width: 38%;">营业额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${payMoney}</td>
										</tr>
										<tr>
											<td style="width: 38%;">折扣</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${disCount }</td>
										</tr>
										<tr>
											<td style="width: 38%;">交易笔数</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${payY }</td>
										</tr>
										<tr>
											<td style="width: 38%;">退票笔数</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">
												${tickRefund}
											</td>
										</tr>
										<tr>
											<td style="width: 38%;">退票总额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${tickRefundSum }</td>
										</tr>
										<tr>
											<td style="width: 38%;">结班小计</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${subtotal}</td>
										</tr>
									</table>
									
								</div>
								<div class="col-lg-6 banbiehao">
									<h4>当日支付分类</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="width:90%;text-align: left;">
										<!-- <tr>
											<td style="width: 12%;">1.</td>
											<td style="width: 38%;">支付宝</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">1350</td>
										</tr>
										<tr>
											<td style="width: 12%;">2.</td>
											<td style="width: 38%;">微信 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">630</td>
										</tr>
										<tr>
											<td style="width: 12%;">3.</td>
											<td style="width: 38%;">信用卡 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">1350</td>
										</tr>
										<tr>
											<td style="width: 12%;">4.</td>
											<td style="width: 38%;">公关卡</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">1500</td>
										</tr>
										<tr>
											<td style="width: 12%;">5.</td>
											<td style="width: 38%;">充值卡</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">90</td>
										</tr>
										<tr>
											<td style="width: 12%;">6.</td>
											<td style="width: 38%;">现金</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">90</td>
										</tr> -->
										
										<c:forEach items="${list2 }" var="map">
										<tr>
											<td style="width: 38%;">
												<c:if test="${map.key =='XC_ZFB' }">支付宝</c:if>
												<c:if test="${map.key =='XC_WX' }">微信</c:if>
												<c:if test="${map.key =='POS' }">信用卡</c:if>
												<c:if test="${map.key =='CASH' }">现金</c:if>
												<c:if test="${map.key =='PUBLIC' }">公关卡</c:if>
												<c:if test="${map.key =='RECHARGE' }">充值卡</c:if>		
											</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">
												<c:out value="${map.value }"></c:out>
											</td>
										</tr>
										</c:forEach>
										
										<tr>
											<td style="width: 38%;">支付小计</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${subtotal}</td>
										</tr>
									</table>
								</div>
							</div>
							<div class="col-lg-12">
								<%-- <div class="col-lg-6 banbiehao">
									<h4>会员卡充值</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="width:90%;text-align: left;">
										<!-- <tr>
											<td style="width: 12%;">1.</td>
											<td style="width: 38%;">信用卡</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">1000</td>
										</tr>
										<tr>
											<td style="width: 12%;">2.</td>
											<td style="width: 38%;">现金 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">1000</td>
										</tr>
										<tr>
											<td style="width: 12%;">3.</td>
											<td style="width: 38%;">微信 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">0</td>
										</tr>
										<tr>
											<td style="width: 12%;">4.</td>
											<td style="width: 38%;">支付宝</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">0</td>
										</tr> -->
										<c:forEach items="${recharge }" var="re">
											<tr>
												<td style="width: 38%;">
													<c:if test="${re.key == 'POS' }">信用卡</c:if>
													<c:if test="${re.key == 'CASH' }">现金</c:if>
													<c:if test="${re.key == 'XC_WX' }">微信</c:if>
													<c:if test="${re.key == 'XC_ZFB' }">支付宝</c:if>
												</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%;text-align:right;">
													<c:out value="${re.value }"></c:out>
												</td>
											</tr>
										</c:forEach>
										<tr>
											<td style="width: 38%;">充值次数</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${payCount}</td>
										</tr>
										<tr>
											<td style="width: 38%;">充值总额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${cardSum }</td>
										</tr>
									</table>
									
								</div> --%>
								
								<div class="col-lg-6 banbiehao">
									<h4>柜台现金明细</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="width:90%;text-align: left;">
										<!-- <tr>
											<td style="width: 38%;">前班交接现金</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">90</td>
										</tr>
										<tr>
											<td style="width: 38%;">前班交接总额 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">2000</td>
										</tr> -->
										<c:if test="${empty totalRefund}">
											<tr>
													<td style="width: 38%;">前班交接现金</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%;text-align:right;">0.0</td>
											</tr>
										</c:if>
											<c:forEach items="${totalRefund }" var="total">
												<tr>
													<td style="width: 38%;">前班交接现金</td>
													<td style="width: 10%;">:</td>
													<td style="width: 30%;"></td>
													<td style="width: 20%;text-align:right;">
													${total.operatorMoney }
													</td>
												</tr>
											
											</c:forEach>
										<tr>
											<td style="width: 38%;">前班交接总额 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${totalSum }</td>
										</tr>
										<tr>
											<td style="width: 38%;">现金收入</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${ticketCash }</td>
										</tr>
										<tr>
											<td style="width: 38%;">充值现金</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${cardCash }</td>
										</tr>
										<tr>
											<td style="width: 38%;">交班总额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${overMoney }</td>
										</tr>
									</table>
									
								</div>
							</div>
							<div class="col-lg-12" style="margin-top:10%">
								<div class="col-lg-8">
									<div class="col-lg-6">
										当班收银: <span>${userName }</span>
									</div>
									<div class="col-lg-6">
										下班收银: <span></span>
									</div>
								</div>
								<div class="col-lg-4">
									值班主管:
								</div>
								
							</div>
							<div class="freebtn clearfix col-md-12 text-right" style="margin-bottom:20px;">
								<button type="button" id="bt" onclick="javascript:doPrint('myDiv')"  class="btn-green" style="background:#">打印</button>
							</div>
							<!-- <div class="clearfix"></div> -->
						</div>
					<!-- 	<div class="clearfix"></div> -->
					</div>
					<!-- <div class="clearfix"></div> -->
				</div>
				<!-- <div class="clearfix"></div> -->
			</div>
		</div>
        </div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    <!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){ 
   			var d=new Date();
   	    	$("#year").html(d.toLocaleDateString());
   	    	$("#printTime").html(d.toLocaleString());
   	    	$("#jbTime").html(d.toLocaleString());
   	    	$("#dyear").html(d.toLocaleDateString());
   	    	$("#dprintTime").html(d.toLocaleString());
   	    	$("#djbTime").html(d.toLocaleString());
   		});
    	
    </script>
    <script language="javascript" type="text/javascript"> 
		var hkey_root, hkey_path, hkey_key;
	    hkey_root = "HKEY_CURRENT_USER";
	    hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	    function pagesetup_null() {
            try {
                var RegWsh = new ActiveXObject("WScript.Shell")
                hkey_key = "header"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
                hkey_key = "footer"
                RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
            } catch (e) {
            }
        }
	    function pagesetup_default() {
            try {
            	var Wsh = new ActiveXObject("WScript.Shell");
            	hkey_key = "margin_left";
                //设置左页边距
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0");
                hkey_key = "margin_right";
                //设置右页边距
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0");
                hkey_key = "margin_top";
                //设置上页边距
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "0.405");
                hkey_key = "margin_bottom";
                //设置下页边距   
                Wsh.RegWrite(hkey_root + hkey_path + hkey_key, "1.405");
            } catch (e) {
        	
        	}     
        }
	    function doPrint(printDiv) {
            try {
                pagesetup_null();
                newwin = window.open("", "newwin", "height=900,width=700,toolbar=no,scrollbars=auto,menubar=no");
                newwin.document.body.innerHTML = document.getElementById(printDiv).innerHTML+'<object ID="PrintCommandObject" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>';
                //newwin.window.print();
				newwin.document.getElementById("PrintCommandObject").ExecWB(6,1); 
                newwin.window.close();
                pagesetup_default();
            } catch (e) { }
        }
	    
	</script>
	
	<div id="myDiv" style="display:none;">
		<div class="container">
			<div class="row">
				
				<div class="col-lg-12 col-md-12" >
					<div class="BindContent">
						<div class="contentInner" style="padding:10px 20px;">
							<h3>收银结班报表</h3>
							<div class="col-lg-12" style="width:100%;margin:20px 0;">
								<div class="col-lg-6 banbiehao" style="width:49%;display:inline-block;float:left;">
									<dl>
										<dd>班别号: <span id="dyear"></span></dd>
										<dd>打印时间: <span id="dprintTime"></span></dd>
										<dd>结班员工工号: <span>${userId }</span></dd>
									</dl>
								</div>
								<div class="col-lg-6 banbiehao" style="width:49%;display:inline-block;float:left;">
									<dl>
										<dd>交班时间: <span id="djbTime"></span></dd>
										<dd>POS机号: <span>${posIp }</span></dd>
										<dd>结班员工: <span>${userName }</span></dd>
									</dl>
								</div>
							</div>
							<div class="clearfix" style="contet:'';clear:both;display:block;"></div>
							<div class="col-lg-12" style="width:100%;margin:20px 0;" >
								<div class="col-lg-6 banbiehao" style="width:49%;display:inline-block;float:left;">
									<h4>当班营业明细</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="width:90%;text-align: left;">
										<c:forEach items="${list}" var="shift" varStatus="status">
											<tr>
												<td style="width: 38%;">${shift.ticketName}</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;">${shift.ticketCount}张</td>
												<td style="width: 20%;text-align:right;">${shift.ticketSum}</td>
											</tr>
										</c:forEach>
										<tr>
											<td style="width: 38%;">营业毛额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${payMoney}</td>
										</tr>
										<tr>
											<td style="width: 38%;">折扣</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${disCount }</td>
										</tr>
										<tr>
											<td style="width: 38%;">交易笔数</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${payY }</td>
										</tr>
										<tr>
											<td style="width: 38%;">退票笔数</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${tickRefund}</td>
										</tr>
										<tr>
											<td style="width: 38%;">退票总额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${tickRefundSum }</td>
										</tr>
										<tr>
											<td style="width: 38%;">交班小计</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${subtotal}</td>
										</tr>
									</table>
									
								</div>
								
								<div class="col-lg-6 banbiehao" style="width:49%;display:inline-block;float:left;">
									<h4>当日支付分类</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="width:90%;text-align: left;">
										<c:forEach items="${list2 }" var="map">
										<tr>
											<td style="width: 38%;">
												<c:if test="${map.key =='XC_ZFB' }">支付宝</c:if>
												<c:if test="${map.key =='XC_WX' }">微信</c:if>
												<c:if test="${map.key =='POS' }">信用卡</c:if>
												<c:if test="${map.key =='CASH' }">现金</c:if>
												<c:if test="${map.key =='PUBLIC' }">公关卡</c:if>
												<c:if test="${map.key =='RECHARGE' }">充值卡</c:if>		
											</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">
												<c:out value="${map.value }"></c:out>
											</td>
										</tr>
									</c:forEach>	
										<tr>
											<td style="width: 38%;">支付小计</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${paySum }</td>
										</tr>
									</table>
								</div>
								
							</div>
							<div class="clearfix" style="contet:'';clear:both;display:block;"></div>
							<div class="col-lg-12" style="width:100%;margin:20px 0;">
								<div class="col-lg-6 banbiehao" style="width:49%;display:inline-block;float:left;">
									<h4>会员卡充值</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="text-align: left;">
										<c:forEach items="${recharge }" var="re">
											<tr>
												<td style="width: 38%;">
													<c:if test="${re.key == 'POS' }">信用卡</c:if>
													<c:if test="${re.key == 'CASH' }">现金</c:if>
													<c:if test="${re.key == 'XC_WX' }">微信</c:if>
													<c:if test="${re.key == 'XC_ZFB' }">支付宝</c:if>
												</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%;text-align:right;">
													<c:out value="${re.value }"></c:out>
												</td>
											</tr>
										</c:forEach>
										<tr>
											<td style="width: 38%;">充值次数</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${payCount}</td>
										</tr>
										<tr>
											<td style="width: 38%;">充值总额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${cardSum }</td>
										</tr>
									</table>
									
								</div>
								
								<div class="col-lg-6 banbiehao" style="width:49%;display:inline-block;float:right;">
									<h4>柜台现金明细</h4>
									<table border="0" cellspacing="0" cellpadding="0" style="text-align: left;">
											<tr>
												<td style="width: 38%;">前班交接现金</td>
												<td style="width: 10%;">:</td>
												<td style="width: 30%;"></td>
												<td style="width: 20%; text-align: right;">${QBJbXJ }</td>
											</tr>
										<tr>
											<td style="width: 38%;">前班交班总额 </td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${totalSum }</td>
										</tr>
										<tr>
											<td style="width: 38%;">现金收入</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${ticketCash }</td>
										</tr>
										<tr>
											<td style="width: 38%;">充值现金</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${cardCash }</td>
										</tr>
										<tr>
											<td style="width: 38%;">交班总额</td>
											<td style="width: 10%;">:</td>
											<td style="width: 30%;"></td>
											<td style="width: 20%;text-align:right;">${overMoney }</td>
										</tr>
									</table>
									
								</div>
								<div class="clearfix" style="contet:'';clear:both;display:block;"></div>
							</div>
							<div class="col-lg-12" style="margin-top:10%;width:100%;margin:20px 0;">
								<div class="col-lg-6" style="width:49%;display:inline-block;float:left;">
									<div class="col-lg-6" style="margin:0 auto;width:49%;float:left;">
										当班收银: <span>${userName }</span>
									</div>
									<div class="col-lg-6" style="margin:0 auto;width:49%;float:left;">
										<span></span>
									</div>
									<div style="content:'';clear:both;display:block;"></div>	
								</div>
								<div class="col-lg-6" style="width:49%;display:inline-block;float:left;">
									<div class="col-lg-6" style="margin:0 auto;">
										<span></span>
									</div>
								</div>
								<div class="clearfix" style="contet:'';clear:both;display:block;"></div>
							</div>
							
							<div class="clearfix" style="contet:'';clear:both;display:block;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
