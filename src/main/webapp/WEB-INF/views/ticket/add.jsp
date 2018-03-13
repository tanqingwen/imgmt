<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
	<title>综合管理系统 |现场购票</title>
	<tags:head_common_content/>
	<link rel="stylesheet" href="${assets}/datepicker/window-ticket.css" />
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
	<!-- this "tags" contains all the patterns we need in this page -->
	<style>
        .register-btn {
            float:none;
            width:100px;
            background-color: #00a1e9;
        }
        .collection-state{
            line-height:40px;
            color:#ee5353;
        }
        .collection-file {
            position: relative;
            display: inline-block;
            width: 194px;
            height: 38px;
            line-height: 38px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .collection-file input {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            opacity: 0;
            filter: alpha(opacity=0);
        }
        .browse-file {
            width:68px;
        }
        .collection-submit {
            width:68px;
            background-color: #666;
        }
    </style>
</head>

<body onload="load()" class="hold-transition skin-blue-light sidebar-mini">
<div style="position:absolute;">
	<jsp:include flush="true" page="/WEB-INF/tags/all.jsp"></jsp:include>
	<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
</div>
<!-- Main header, top yellow bar -->
<tags:main_header/>

<!-- Left column, contains the logo and sidebar -->
<tags:main_sidebar active="buyticket"/>

<!-- here use a wrapper so that the content won't be influenced by sidebar -->
<div class="content-wrapper">

<!-- This class contains tip on the top of wrapper. Ordinarily it's invisible. -->
<div class="context-tips">
	<tags:action_tip/>
</div>

<!-- title of the real content -->
<section class="content-header">
	<h1>现场购票</h1>
	<ol class="breadcrumb">
		<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
		<li class="active">现场购票</li>
	</ol>
</section>

<!-- content of the real content -->
<section class="content">
<div class="box box-primary">
	<form id="ticketfrom" name="ticketfrom" class="form-horizontal" method="post" action="" enctype="multipart/form-data">
	<div class="main-box">
    <div class="main-head"></div>
    <div class="main-content clearfix">
    	<div class="main-left">
	    	<div class="main-left-bg01"></div>
	        <div class="main-left-bg02"></div>
	        <div class="main-left-bg03"></div>
	        <div class="main-left-content">
	            <p>窗</p>
	            <p>口</p>
	            <p>购</p>
	            <p>票</p>
	        </div>
	    </div>
        <input type = "hidden" name="funcReturn"/>
		<input type = "hidden" name="rejcode"/>
		<input type = "hidden" name="rejcodeExplain"/>
        <div class="main-right">
            <div class="main-list">
                <div class="main-list-title">
                    <p class="main-title-box">手动确认</p>
                </div>
                <div class="content-box clearfix">
                	<div class="row">
                 		<div class="col-md-2">
                            <div class="content-title">移动电话：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <input id="mobile" name="mobile" type="text" value="" />
                        </div>
                 		<div class="col-md-2">
                            <div class="content-title">预存金额：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <input id="amount" name="amount" type="text" placeholder="0" value="" onchange="changetotalAmountPaid()"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main-list main-second">
                <div class="main-list-title">
                    <p class="main-title-box">点击选择</p>
                </div>
                <div class="content-box clearfix">
                	<div class="row">
                 		<div class="col-md-2">
                            <div class="content-title">票券形式：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <select id="ticketform" name="ticketform" onchange="changeDeposit()">
                                <option value="0">无卡</option>
                                <option value="1">有卡</option>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <div class="content-title">证件类型：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <select id="cbIdType"  name="cbIdType"> 
								<c:forEach var="idType" items="${idTypeList}">
									<option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
						   		</c:forEach>
							</select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <div class="content-title">购买数量：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <select id="varTk_paper_no" name="varTk_paper_no">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <div class="content-title">客户等级：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <select  id="prProdctGroup"  name="prProdctGroup" readonly="readonly" onclick="vena()" >
                                <c:forEach var="prdGrp" items="${prdGrpList}">
				      	 			<option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
				      			</c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <div class="content-title">票券类别：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <div class="ticket-type">
                                <p class="ticket-type-text">请选择</p>
                                <ul class="all-ticket">
	                                <c:forEach var="tkType" items="${tkTypeList}">
							      		<li><input class="ticket-checkbox" name='varTk_ticket_type' id='varTk_ticket_type' type="checkbox" value="${tkType.ttTypeId }"/><span>${tkType.ttTypeDesc } - 价位:  <fmt:formatNumber value="${tkType.ttListPrice }" pattern="0"/></span></li>
							      	</c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="content-title">数据采集：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <button class="id-btn register-btn"  type="button">登记掌静脉</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"></div>
                        <div class="col-md-2">
                            <div class="content-title">数据采集：</div>
                        </div>
                        <div class="col-md-4 collection-state">采集成功并结束</div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"></div>
                        <div class="col-md-2">
                            <div class="content-title">数据采集：</div>
                        </div>
                        <div class="col-md-4 collection-state">
                            <a class="collection-file" href="javascript:void(0)">
                                <span>请上传文件</span>
                                <input  type="file" value="" />
                            </a>
                            <button class="collection-submit id-btn"  type="button">上传</button>
                            <button class="browse-file id-btn"  type="button">浏览</button>
                        </div>
                    </div>
<!--                     <div class="content-right"> -->
                       
						<!-- 掌静脉：目前定位-客户等级-1105-金卡会员	必须登记掌静脉	add by Hugh start  -->
						<div class="form-group" id="signData">
							<label for="prProdctGroup" class="col-sm-3 control-label"><font color="red">*</font>数据采集</label>
							<button type="button" class="btn  btn-primary " id="diaoyong" name="diaoyong"  class="btn btn-info pull-right">登记掌静脉</button>
						</div>
						<div class="form-group" id="viewVena">
							<label for="prProdctGroup" class="col-sm-3 control-label"><font color="red">*</font>采集状态</label>
							<div class="col-sm-8" id="viewVena1"><font color="red">准备采集...</font></div>
						</div>
						<div class="form-group" id="uploadFile">
							<label for="upload" class="col-sm-3 control-label"><font color="red">*</font>采集文件上传</label>
							<div class="col-sm-8" id="viewVena1">
								<!--  
								<input type="file" name="upload" id="upload" value="上传">
								<img src="wait.gif" style="display:none" id="imgWait" /> 
								-->
								<input type="file" id="file1"/>
								<input type="button" id="upload" value="上传" />
								<img src="wait.gif" style="display:none" id="imgWait" /> 
							</div>
						</div>
                        <div style="display:none;">
                        <div class="content-list">
                            <span class="content-right-title">数据采集：</span>
                            <button class="register-btn">登记掌静脉</button>
                        </div>
                        <div class="content-list">
                            <span class="content-right-title">采集状态：</span>
                            <span class="collection-state">采集成功并结束</span>
                        </div>
                        <div class="content-list">
                             <span class="content-right-title">采集文件上传：</span>
                            <a class="collection-file" href="javascript:void(0)">
                                <span>请上传文件</span>
                                <input  type="file" value="" />
                            </a>
                            <button class="collection-submit id-btn">上传</button>
                            <button class="browse-file id-btn">浏览</button>
                        </div>
                        </div>
<!--                     </div> -->
                </div>
            </div>
            <div class="main-list main-third">
                <div class="main-list-title">
                    <p class="main-title-box">硬件录入</p>
                </div>
                <div class="content-box clearfix">
                	<div class="row">
                        <div class="col-md-2">
                            <div class="content-title">姓名：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <input type="text" readonly="readonly" value="" id="uname" name="uname" class="content-ticket"/>
                        </div>
                        <div class="col-md-2">
                            <div class="content-title">身份证号码：</div>
                        </div>
                        <div class="col-md-4 form-group">
                        	<input class="special-input content-ticket" type="text" id="idNo" name="idNo"  value="" />
                        	<button type="button" class="id-btn" id="idcard" name="idcard" onclick="readCard()">读身份证</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <div class="content-title">卡流水号：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <input type="text" readonly value="" class="content-ticket"/>
                        </div>
                        <div class="col-md-2">
                            <div class="content-title">持卡人号码：</div>
                        </div>
                        <div class="col-md-4 form-group">
                        	<input class="special-input content-ticket" type="text" id="cbCardholderNo" name="cbCardholderNo" value="" readonly />
                        	<button type="button" class="id-btn">读卡号</button>
                        </div>
                    </div>
                    <div class="row" id="cardstatu" style="display:none;"><!-- 默认inline-block,不会被显示none -->
                        <div class="col-md-6"></div>
                        <div class="col-md-2">
                            <div class="content-title">卡状态：</div>
                        </div>
                        <div class="col-md-4 collection-state" style="color:blue;" id="cardstatus">挂失</div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <div class="content-title">出生日期：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <input type="text" readonly="readonly" value="" id="birthday" name="birthday" class="content-ticket"/>
                        </div>
                        <div class="col-md-2">
                            <div class="content-title">押金：</div>
                        </div>
                        <div class="col-md-4 form-group">
                        	<select id="deposit" name="deposit" disabled="disabled" class="content-ticket"> 
                            	<option value="0" >0</option>
						      	<option value="20" >20</option>
					      	</select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <div class="content-title">票券金额：</div>
                        </div>
                        <div class="col-md-4 form-group">
                            <input class="content-ticket" type="text" value="0" id="varTk_amount" name="varTk_amount" readonly/>
                        </div>
                        <div class="col-md-2">
                            <div class="content-title content-all-money">支付总金额：</div>
                        </div>
                        <div class="col-md-4 form-group">
                        	<input type="text" value="0" id="totalAmountPaid" name="totalAmountPaid" readonly class="content-ticket"/>
                        </div>
                    </div>
                </div>
                <div class="content-btn-box">
                    <button type="button" class="content-btn" onclick="cash_payment()">现金收款</button>
                    <!-- <button class="content-btn content-right-btn" name="Button1" onclick="demo(this.form)">收款</button> -->
                     <input type="button" name="Button1" value="Push me" onclick="demo(this.form)"><br/>
                  
                   
                </div>
            </div>
        </div>
    </div>
	</div>
	</form>
</div>
</section>

<tags:control_sidebar/>

<tags:load_common_js/>
</div>
<script src="${assets}/underscore/underscore.min.js"></script>
<script src="${assets}/datepicker/datepicker.js"></script>
<script src="${assets}/datepicker/locales/zh-CN.js"></script>
<script src="${assets}/validator/js/validator.js"></script>
<script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
<script src="${assets}/crypto/md5.js"></script>
<script type="text/javascript">
var key1str;
var key2str;
var key3str;
var key6str;
var chestrflag = false;
	
	function findCard(){
		
		readCardNo("cbCardholderNo");
		var cardNo=document.getElementsByName("cbCardholderNo")[0].value+"";
		if(cardNo=="undefined" || cardNo==""){
			return; 
		}
		
		cardNo="<%=Constants.baseBIN%>"+cardNo;
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getKey",
			dataType : "json",
			data : {
				cardNumber : cardNo,
				type: 0
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					document.getElementById(document.getElementsByName("cbCardholderNo")[0]).value = "";
					alert(e.message);
					return;
				}
				var p=data.value;
					key2str=p[0];
					key3str=p[1];
					key6str=p[2];
					getCardMess(cardNo);
			}
		});
	}
	function getCardMess(cardNo) {
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getCardMess",
			dataType : "json",
			data : {
				cardNumber : cardNo
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var res=data.value;
				ticketfrom.varCb_nric_no.value = res[1];
				ticketfrom.varOld_name.value = res[2];
				ticketfrom.varOld_prdgrp.value = res[3];
				ticketfrom.varOld_mobile.value = res[4];
				ticketfrom.varRn_balance.value=res[8];
				document.getElementById("cardstatus").innerHTML=res[7];
			}
		});
	}
	function changeDeposit() {
		if ($("#ticketform").val() == 1) {
			$("#deposit").val("20");
		} else {
			$("#deposit").val("0");
		}
		changetotalAmountPaid();
	}
	function changetotalAmountPaid() {
		var amount = ticketfrom.amount.value;
		var varTk_amount = $("#varTk_amount").val()
		if (amount == "") {
			amount = 0;
		}
		if (chestrflag) {
			varTk_amount = 0;
		}
		$("#totalAmountPaid").val(
				parseInt(varTk_amount) + parseInt($("#deposit").val())
						+ parseInt(amount));
	}
	function getTkPrice() {
		chestrflag = false;
		var checkboxes = document.getElementsByName("varTk_ticket_type");
		var chestr = "";
		for (i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				chestr += checkboxes[i].value + ",";
			}
		}
		if ("" == chestr) {
			ticketfrom.varTk_amount.value = "0";
// 			ticketfrom.varTk_paper_no.value = '1';
			chestrflag = true;
			changetotalAmountPaid();
			return;
		}

		var old_prdgrp = ticketfrom.varOld_prdgrp.value;
		if (null == old_prdgrp || old_prdgrp == "") {
			for (i = 0; i < checkboxes.length; i++) {
				checkboxes[i].checked = false;
			}
			alert("客户等级不能为空!");
			return;
		}
		TkpriceInf(chestr, ticketfrom.varOld_prdgrp.value,
				ticketfrom.varTk_paper_no.value);
	}
	function TkpriceInf(chestr, prodct, num) {
		$.ajax({
			type : "POST",
			url : "${ctx}/ticket/tkpriceInf",
			dataType : "json",
			data : {
				ttTypeId : chestr, //票券类别
				prodct : prodct, //客户等级
				num : num
			//数量
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				ticketfrom.varTk_amount.value = Math.round(data.value);
				changetotalAmountPaid();
			}
		});

	}
	//读取身份证:获取身份证号码、出生日期
	function readCard() {
		var idNo = ticketfrom.cbIdType.value;
		if (idNo != "1") {
			alert("选择证件类型为身份证");
			return;
		}
		var strReadResult = CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
			$("#idNo").val(CVR_IDCard.CardNo);
			//证件类型1-身份证（自动获取身份证）
			if (ticketfrom.cbIdType.value == "1") {
				$("#birthday").val($("#idNo").val().substr(6, 8));
				$("#uname").val(CVR_IDCard.Name);
			}
		} else {
			alert("读取身份证失败," + strReadResult);
		}
	}
	function cash_payment() {
		
		var mobile=$("#mobile").val();
		var idNo = $("#idNo").val();
		var uname = $("#uname").val();
		var uname = $("#uname").val();
		var amount=$("#amount").val();
		var ticketform=$("#ticketform").val();
		var varTk_paper_no=$("#varTk_paper_no").val();
		var varTk_ticket_type=$("#varTk_ticket_type").val();
		var idType=$("#idType").val();
		var varOld_prdgrp=$("#varOld_prdgrp").val();
		var birthday=$("#birthday").val();
		var varTk_amount=$("#varTk_amount").val();
		var deposit=$("#deposit").val();
		var totalAmountPaid=$("#totalAmountPaid").val();
		
		$.ajax({
			type : "POST",
			url : "${ctx}/cpticket/Cash_ticket",
			dataType : "json",
			data : {
				bMobileNo:mobile,//手机号
				cbCustomerIdno:idNo, //证件号
				cbCustomerName:uname, //客户姓名
				amount:amount,//预存金额
				ticketform:ticketform,//票劵形式
				varTk_paper_no:varTk_paper_no,//购买数量
				tktypeStr:varTk_ticket_type,//票劵ID
				cbIdType:idType,//证件类型
				prProdctGroup:varOld_prdgrp,//客户等级
				CbDob:birthday,//出身日期
				varTk_amount:varTk_amount,//票劵金额
				deposit:deposit,//押金
				totalAmountPaid:totalAmountPaid//总金额
			},
			
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return ;
				}
		
			}
		});
	}
	function demo(objform) {
		var request = new ActiveXObject("ALLINPAY.RequestData");
		var response = new ActiveXObject("ALLINPAY.ResponseData");
		var mis = new ActiveXObject("ALLINPAY.MisPos");

		request.PutValue("CardType", "01");
		request.PutValue("TransType", "02");
		request.PutValue("Amount", objform.totalAmountPaid.value);

		var result = mis.TransProcess(request, response);
		objform.funcReturn.value = result;
		objform.rejcode.value = response.GetValue("Rejcode");
		objform.rejcodeExplain.value = response.GetValue("RejCodeExplain");
		
		delete request;
		delete response;
		delete mis;
		CollectGarbage();
	    if (objform.rejcode.value==00 &objform.rejcodeExplain.value=='交易成功'){
	    	alert(objform.rejcode.value);
	    	cash_payment();
		} 
	}

	
	 //登记掌静脉
	   $("#diaoyong").click(function(){
			var cardNo=document.ticketfrom.cbCardholderNo.value;
	    	cardNo="<%=Constants.baseBIN%>"+cardNo; 
	    	document.getElementById('viewVena1').style.color = "red";
			$.ajax({
				type : "POST",
				url : "${ctx}/crdtbl/register",
				dataType : "json",
				data : {
					barcode : cardNo
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					//采集返回结果处理
					var reResult = data.value;
					reResult[0]+="";
					if(reResult[0]=='success'){
						document.getElementById('viewVena1').innerHTML=reResult[1];
						getCancel(barcode);
					}
					//循环执行running
					if(reResult[0]=='running'){
						document.getElementById('viewVena1').innerHTML=reResult[1];
						getSign(cardNo);
					}
					if(reResult[0]=='retry'){
						getSign(barcode);
					}
					if(reResult[0]=='fail'){
						document.getElementById('viewVena1').innerHTML=reResult[1];
					}
				}
			});
		});
	
	//采集事件：登记
    function getSign(barcode){
    	$.ajax({
			type : "POST",
			url : "${ctx}/crdtbl/sign",
			dataType : "json",
			data : {
				barcode : barcode
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				//采集返回结果处理
				var siResult = data.value;
				siResult[0]+="";
				var i=0;
				if(siResult[0]=='running'){
					document.getElementById('viewVena1').innerHTML=siResult[1];
					getSign(barcode);
				}
				if(siResult[0]=='success'){
					getCancel(barcode);
					document.getElementById('viewVena1').innerHTML=siResult[1];
				}
				if(reResult[0]=='retry'){
					getSign(barcode);
				}
				if(reResult[0]=='fail'){
					document.getElementById('viewVena1').innerHTML=reResult[1];
				}
			}
		});
    }
    
    
    //采集事件：取消
     function getCancel(barcode){
    	$.ajax({
			type : "POST",
			url : "${ctx}/crdtbl/cancel",
			dataType : "json",
			data : {
				barcode : barcode
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				//采集返回结果处理
				var caResult = data.value;
				document.getElementById('viewVena1').innerHTML=caResult[1];
				document.getElementById('viewVena1').innerHTML="采集成功并结束";
				document.getElementById('uploadFile').style.display='';
			}
		});
    }
    
    //加载
    function load(){
    	document.getElementById('signData').style.display='none';
		document.getElementById('viewVena').style.display='none';	
		document.getElementById('uploadFile').style.display='none';	
	}
    
    //客户等级决定是否显示掌静脉
	function vena(){
		var cslevel = document.ticketfrom.prProdctGroup.value;
		if(cslevel=="1105"){ //金卡会员
			document.getElementById('signData').style.display='';
			document.getElementById('viewVena').style.display='';
		
		}else{
			document.getElementById('signData').style.display='none';
			document.getElementById('viewVena').style.display='none';
		}
	}
    
	// ajax异步文件上传
	$(function () {
            $("#upload").click(function () {
                $("#imgWait").show();
            	var cardNo=document.ticketfrom.cbCardholderNo.value;
            	cardNo="<%=Constants.baseBIN%>"+cardNo;
                var formData = new FormData();
                formData.append("barcode",cardNo);
                formData.append("myfile", document.getElementById("file1").files[0]);
                $.ajax({
                	url : "${ctx}/crdtbl/upload",
                    type: "POST",
                    data: formData,
                    /**
                    *必须false才会自动加上正确的Content-Type
                    */
                    contentType: false,
                    /**
                    * 必须false才会避开jQuery对 formdata 的默认处理
                    * XMLHttpRequest会对 formdata 进行正确的处理
                    */
                    processData: false,
                    success: function (data) {
                        if (data.value == "true") {
                            alert("上传成功！");
                        }
                        if (data.value == "false") {
                            alert("上传失败，文件和卡号绑定不匹配！");
                        }
                        $("#imgWait").hide();
                    },
                    error: function () {
                        alert("上传失败！");
                        $("#imgWait").hide();
                    }
                });
            });
        });
	function getWviBalance(cardno) {
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getWviBalance",
			dataType : "json",
			data : {
				cardNumber : cardno
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var res=data.value;
				ticketfrom.varRn_inbalance.value = res;
			}
		});
	}
	function getBalance(cardno){
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getBalance",
			dataType : "json",
			data : {
				cardNumber : cardno
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var p=data.value;
				if(p==null){
					alert("余额查询异常");
					return;
				}else{
					ticketfrom.varRn_balance.value=p;
				}
			}
		});
	}
	function evtFocus(){
		ticketfrom.ticketSub.disabled='true';
		getTkPrice();
	}

	function evtBlur(){
		ticketfrom.ticketSub.disabled='';
		getTkPrice();
	}
	$('.ticket-checkbox').click(function() {
		var data = [];
		$('.ticket-checkbox').each(function() {
			if ($(this).is(':checked')) {
				data.push($(this).siblings('span').text().split('-')[0]);
				
			}
		});
		$('.ticket-type-text').text(data.join(','));
		getTkPrice();
	});
	$("#ticketSub").click(function(){
		  var cardNo=document.ticketfrom.cbCardholderNo.value;
		  if(null==cardNo){
			  alert("卡号不能为空!");
			  return;
		  }
		  if(cardNo!=""){
			  if(cardNo.length!=6){
				  alert("持卡人号码为6位!");
				  return;
			  }
		  }
		  cardNo="<%=Constants.baseBIN%>"+cardNo;
		  var varRn_balance=document.ticketfrom.varRn_balance.value;
		  if(null==varRn_balance || ""==varRn_balance){
			  alert("会员卡余额不能为空!");
			  return;
		  }
		  var checkboxes = document.getElementsByName("varTk_ticket_type");
		  var chestr="";
		  for(i=0;i<checkboxes.length;i++){
			  if(checkboxes[i].checked){
				  chestr+=checkboxes[i].value+",";
			  }
		  }
		  if(""==chestr){
			  alert("请选择票券类别!");
			  return;
		  }
		  var amount=document.ticketfrom.varTk_amount.value;
		  if(null==amount){
			  alert("金额不能为空!");
			  return;
		  }
		  if(parseInt(amount)==0){
			  alert("请选择票劵!");
			  return;
		  }
		  if(parseFloat(ticketfrom.varTk_amount.value)>parseFloat(ticketfrom.varRn_balance.value)){
			  alert("账号余额不足");
			  return;
		  }
		  var paperNo=ticketfrom.varTk_paper_no.value;
		  var idNo=ticketfrom.varCb_nric_no.value;
		  if(!confirm("确认提交?")){
			  return;
		  }
		  $.ajax({
			type : "POST",
			url : "${ctx}/ticket/addTicket",
			dataType : "json",
			data : {
				cardNo : cardNo,
				idNo : idNo,
				ticketType : chestr,// 票券类型
				paperNo: paperNo,  //购买数量 
				amount : amount // 金额
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if(data.value>"0"){
					alert("购票成功!");
				}
			}
		 });
	});
</script>
</body>
</html>
