<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
	<title>综合管理系统 |现场购票</title>
	<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	<!-- this "tags" contains all the patterns we need in this page -->
	<tags:head_common_content/>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
<div style="position:absolute;">
	<jsp:include flush="true" page="/WEB-INF/tags/all.jsp"></jsp:include>
	<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
</div>
<!-- Main header, top yellow bar -->
<tags:main_header/>

<!-- Left column, contains the logo and sidebar -->
<tags:main_sidebar active="buyticket2"/>

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
<div class="box box-body">

	<div class="box-header">
		<h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
	</div>
	
	<form id="ticketfrom" name="ticketfrom" class="form-horizontal">
		<div class="box-body">
	  		<div class="form-group">
			    <label class="col-sm-2 control-label"><font color="red">*</font>卡号</label>
			    <div class="col-sm-3">
			    	<input class="form-control" id="cbCardholderNo" name="cbCardholderNo" disabled="disabled"/>
			    	<input type="button" id="MagCard3" readonly="readonly" name="idcard" onclick="findCard()" value="读卡号"/><span id="cardstatus"></span>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">会员卡余额</label>
			    <div class="col-sm-3">				  
			    	<input class="form-control" name="varRn_balance" disabled="disabled" value=""/>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-3">
			    	<input class="form-control" name="varOld_name" disabled="disabled" value=""/>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">身份证号码</label>
			    <div class="col-sm-3">
			    	<input class="form-control" name="varCb_nric_no" disabled="disabled" value=""/>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">移动电话</label>
			    <div class="col-sm-3">
			    	<input class="form-control" name="varOld_mobile" disabled="disabled" value=""/>
			    </div>
			</div>

			<div class="form-group">
			    <label class="col-sm-2 control-label">客户等级</label>
			     <div class="col-sm-3">
			    	<select class="form-control" id="varOld_prdgrp"  name="varOld_prdgrp"  readonly="readonly"> 
				      <c:forEach var="prdGrp" items="${prdGrpList}">
				      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
				      </c:forEach>
			      	</select>
 				 </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label"><font color="red">*</font>票券类别</label>
		         <div class="col-sm-8" style="display:none;">
			         <c:forEach var="tkType" items="${tkTypeList}">
			        	<input type='checkbox' onclick='getTkPrice(this)' name='varTk_ticket_type' id='varTk_ticket_type' value='${tkType.ttTypeId }' > 
			        	${tkType.ttTypeId } -  ${tkType.ttTypeDesc } - 价位:  <fmt:formatNumber value="${tkType.ttListPrice }" pattern="0"/> - 生效日: ${tkType.valid_date } - 失效日: ${tkType.lose_date } <br>
			      	 </c:forEach>
		         </div>
			     <div class="col-sm-3">
			     	<select class="form-control" readonly="readonly" id="ticketbox"> 
			     		<option value="">===请选择===</option>
			     		<c:forEach var="tkType" items="${tkTypeList}">
			     			<option value="${tkType.ttTypeId }">${tkType.ttTypeDesc } - 价位:  <fmt:formatNumber value="${tkType.ttListPrice }" pattern="0"/></option>
				      	 </c:forEach>
				  	</select> 
			     </div> 
			     <div class="col-sm-7" style="background:#ccc; height:34px;" id="ticketarea">
			     	
			     </div>   
			        
			</div>	
			<div class="form-group">
			    <label class="col-sm-2 control-label"><font color="red">*</font>购买数量</label>
			    <div class="col-sm-3">
			    	<input class="form-control"  name="varTk_paper_no" value="1" size="4" onfocus="evtFocus()" onblur="evtBlur()" />
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label"><font color="red">*</font>金额</label>
			    <div class="col-sm-3">
			    	<input class="form-control"  name="varTk_amount" readonly="readonly" value="0"/>
			    </div>
			</div>
		</div>
	
		<div class="box-footer">
			<div class="col-sm-10">
			</div>
			<div class="col-sm-1">
				<button type="button" class="btn  btn-primary " id="ticketSub" name="ticketSub"  class="btn btn-info pull-right">提交</button>
            </div>
            <div class="col-sm-1">
               <a type="button" class="btn  btn-primary " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>	
            </div>
		</div>
	</form>
</div>
</section>

<tags:control_sidebar/>

<tags:load_common_js/>
</div>
<script type="text/javascript">
var key1str;
var key2str;
var key3str;
var key6str;
var chestr="";

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
	
function getTkPrice(){
	if(""==chestr){
		ticketfrom.varTk_amount.value="0";
		ticketfrom.varTk_paper_no.value='1';
		return;
	}
	
	var old_prdgrp=ticketfrom.varOld_prdgrp.value;
	if(null==old_prdgrp || old_prdgrp==""){
		for(i=0;i<checkboxes.length;i++){
			checkboxes[i].checked=false;
		}
		alert("客户等级不能为空!");
	    return;
	}
	TkpriceInf(chestr,ticketfrom.varOld_prdgrp.value,ticketfrom.varTk_paper_no.value);
}
	
function getTkPricebefore(){
	var checkboxes = document.getElementsByName("varTk_ticket_type");
	var chestr="";
	for(i=0;i<checkboxes.length;i++){
		if(checkboxes[i].checked){
			chestr+=checkboxes[i].value+",";
		}
	}
	if(""==chestr){
		ticketfrom.varTk_amount.value="0";
		ticketfrom.varTk_paper_no.value='1';
		return;
	}
	
	var old_prdgrp=ticketfrom.varOld_prdgrp.value;
	if(null==old_prdgrp || old_prdgrp==""){
		for(i=0;i<checkboxes.length;i++){
			checkboxes[i].checked=false;
		}
		alert("客户等级不能为空!");
	    return;
	}
	TkpriceInf(chestr,ticketfrom.varOld_prdgrp.value,ticketfrom.varTk_paper_no.value);
}


function TkpriceInf(chestr,prodct,num){
	$.ajax({
		type : "POST",
		url : "${ctx}/ticket/tkpriceInf",
		dataType : "json",
		data : {
			ttTypeId : chestr, //票券类别
			prodct : prodct, //客户等级
			num : num	//数量
		},
		success : function(data) {
			if (failureProcess("${ctx}", data)) {
				return;
			}
			ticketfrom.varTk_amount.value=Math.round(data.value);
		}
    });
}

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
<script>
	var oTicketbox = document.getElementById('ticketbox');		//选择框
	var oTicketarea = document.getElementById('ticketarea');	//显示所选部分框
	var aClose = oTicketarea.getElementsByClassName('item-close');//删除按钮
	//改变下拉选项
	oTicketbox.onchange = function(){
		var oOption_item = oTicketbox.options[oTicketbox.selectedIndex].innerHTML;
		var oOption_value = oTicketbox.options[oTicketbox.selectedIndex].value;
		if(oOption_value==""){
			return false;
		}
		if(chestr.indexOf(oOption_value)>=0){
			return false;
		}
		chestr+=oOption_value+",";
		var option_list = oOption_item.split("-");
		oOption_item = option_list[0];
		var item_node = document.createElement("div");	
		item_node.setAttribute("class",oOption_value);
		item_node.style.float='left';
		item_node.style.marginRight=10+'px';
		item_node.style.lineHeight=34+'px';
		item_node.innerHTML = oOption_item + '<a href="javascript:;">删除</a>';	
		oTicketarea.appendChild(item_node);   			
		var aClose = item_node.children[0];
		// 删除
		aClose.onclick=function(){
			oTicketarea.removeChild(this.parentNode);
			chestr = chestr.replace(oOption_value+",","");
			getTkPrice();
		}
		getTkPrice();
	}
</script>
</body>
</html>
