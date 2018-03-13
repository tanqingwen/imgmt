<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 公关赠票</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>

    <style>
		.ticket-type {
    position:relative;
    float:right;
    width:100%;
    height:38px;
    line-height:38px;
   	text-indent:10px;
    border:1px solid #b3b3b3;
    background-color:#fff;
}
.ticket-type:hover .all-ticket {
    display: block;
}
.all-ticket {
    display: none;
    position:absolute;
    top:33px;
    left:13px;
    z-index: 1;
    width:94%;
    height:152px;
    overflow-y:auto;
    background-color:#fff;
    border:1px solid #b3b3b3;
    list-style: none;
    padding:0;
}
.all-ticket li {
    height:30px;
    display:inline-block;
    width:100%;
    text-indent:10px;
}
.all-ticket li i{
font-style:normal;
}
.ttt{
    width:15px;
    height:15px;
    verticla-align:middle;
}
.ticket-info{
height:20px;
margin:0 10px;
position:Relative;
bottom:5px;
}
    </style>
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
          <h1>公关赠票</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">公关赠票</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="ticketfrom"  class="form-horizontal" method="post" action="cash_payment()">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="mobile" class="col-sm-3 control-label">移动号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="mobile" name="mobile" title="不能为空" value="${item.id}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ticket_type" class="col-sm-3 control-label">票劵种类<font color="red">*</font></label>
								    <div class="col-sm-8" id="ticket-p">
							      		<%-- <p class="ticket-type-text"  id='ticket_type' style="text-indent:10px;width:100%;height:34px;line-height:40px;border:1px solid lightblue; margin:0; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">请选择</p>
                                		<ul class="all-ticket" >
	                                		<c:forEach var="tkType" items="${tkTypeList}">
							      				<li class="ticket-li"><input class="ttt" id="varTk_ticket_type" name="ttt" type="checkbox" value="${tkType.ttTypeId }" style="width:20px;height:20px;margin-top:8px;"><span class="ticket-info" ><i>${tkType.ttTypeId }--${tkType.ttTypeDesc }</i> - 价位:<i>${tkType.ttListPrice }</i></span></li>
							      			</c:forEach>
                               			</ul> --%>
                               			<select id="tkTypeId">
                               				<option>请选择</option>
                               				<c:forEach var="tkType" items="${tkTypeList}">
                               					<option value="${tkType.ttTypeId }"><i>${tkType.ttTypeId }--${tkType.ttTypeDesc }</i> - 价位:<i>${tkType.ttListPrice }</i></option>
                               				</c:forEach>
                               			</select>
                            		</div>
								</div>
								<div class="form-group" style="display:none;" id="card-lx">
								    <label for="Special_certificate" class="col-sm-3 control-label">特殊证件<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="Special_certificate" name="Special_certificate">
							  				<option>军人证</option>
							  				<option>残旧证</option>
							  			</select>
								    </div>
								</div>
								
								<div class="form-group" id="line-number3">
								    <label for="CbRwdsAccno" class="col-sm-3 control-label">卡流水号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="CbRwdsAccno" name="CbRwdsAccno" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label">证件类型<font color="red">*</font></label>
								    <div class="col-sm-8">
							  			<select class="form-control" id="cbIdType"  name="cbIdType"> 
											<c:forEach var="idType" items="${idTypeList}">
												<option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
						   					</c:forEach>
										</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="uname" class="col-sm-3 control-label">证件姓名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="uname" name="uname" value=""/>
								    </div>
								</div>
								
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
	                			
							
								<div class="form-group" style="display:none;" id="card-lx2">
								    <label for="Special_certificate_number" class="col-sm-3 control-label">特殊证件号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="Special_certificate_number" name="Special_certificate_number" value=""/>
								    </div>
								</div>
								
								<div class="form-group"  id="line-number4">
								    <label for="cbCardholderNo" class="col-sm-3 control-label">持卡号码<font color="red">*</font></label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control" id="cbCardholderNo" name="cbCardholderNo" value=""/>
								    </div>
								    <div class="col-sm-2">
								      <input class="btn btn-default" type="button" onclick="findCard()" value="读卡信息">
								    </div> 
								</div>
								<div class="form-group">
								    <label for="idNo" class="col-sm-3 control-label">证件号码<font color="red">*</font></label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control" id="idNo" name="idNo" value=""/>
								    </div>
								    <input type = "hidden" id ="Address" name="Address" value="">
								    <div class="col-sm-2">
								      <input class="btn btn-default" type="button" id="idcard" name="idcard" onclick="readCard()" value="读身份证">
								    </div> 
								</div>
								<div class="form-group">
								    <label for="birthday" class="col-sm-3 control-label">出生日期<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="birthday" name="birthday" value=""/>
								    </div>
								</div>
							
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button id="addButton" type="button" class="btn btn-info "  onclick="cash_payment()"><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default " href="${ctx }/staff/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
			</section>
        </div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
    <tags:load_common_js/>
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

	//读卡号
	function findCard(){
		readCardNo("cbCardholderNo");
		var cardNo=$("input[name='cbCardholderNo']")[0].value;
		if(cardNo=="undefined" || cardNo==""){
			return;
		}
		cardNo="<%=Constants.baseBIN%>"+cardNo;
		$.ajax({
			type : "POST",
			url : "${ctx}/CardRecharge/getCardMess",
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
					kamianhao(cardNo);
					key2str=p[0];
					key3str=p[1];
					key6str=p[2];
					if("P-预制卡" !=p[7]){
						alert("请选择预制卡");
						$("input[name='cbCardholderNo']")[0].value="";
						return false;
					}
					getCardMess(cardNo);
					getBalance(cardNo);
			}
		});
	 }
	function kamianhao(cardNo){
		$.ajax({
			type : "POST",
			url : "${ctx}/cpticket/kamianhao",
			dataType : "json",
			data : {
				cardNo : cardNo
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				$("#CbRwdsAccno").val(data);
			}
			
		});
	}
	//读取身份证:获取身份证号码、出生日期
	function readCard() {
		var idNo = $("#cbIdType").val();
		if (idNo != "1") {
			alert("选择证件类型为身份证");
			return;
		}
		var strReadResult = CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
			$("#idNo").val(CVR_IDCard.CardNo);
			//证件类型1-身份证（自动获取身份证）
			if ($("#cbIdType").val() == "1") {
				$("#birthday").val($("#idNo").val().substr(6, 8));
				$("#uname").val(CVR_IDCard.Name);
				$("#Address").val(CVR_IDCard.Address);
			}
		} else {
			alert("读取身份证失败," + strReadResult);
		}
	}
	$(function () {
		$("#ticketfrom").click(function(){
			var role=document.getElementsByName("roles"); 
			var m=0; var n=false; 
			for(var i=0;i<role.length;i++){ 
				if(role[i].checked){ 
					n=true; m++;
				}
			}		 	
		});
		
	});
	function cash_payment(){
		var mobile = $("#mobile").val();	//手机号
			//预存金额
		var varTk_ticket_type=$("#tkTypeId").val();	//票劵ID
						//票劵形式
		var varOld_prdgrp = "1100";			//客户等级
		var CbRwdsAccno = $("#CbRwdsAccno").val();				//卡流水号
		var cbCardholderNo = $("#cbCardholderNo").val();		//持卡号码
		cbCardholderNo="<%=Constants.baseBIN %>"+cbCardholderNo;
		var cbIdType = $("#cbIdType").val();					//证件类型
		var idNo = $("#idNo").val();							//证件号
		var uname = $("#uname").val();							//证件名
		var birthday = $("#birthday").val();					//出生日期
		var Address = $("#Address").val();	//出生地址
		var json ='[{"mobile":"'+mobile+'","varTk_ticket_type":"'+varTk_ticket_type+'"';
		json +=',"varOld_prdgrp":"'+varOld_prdgrp+'","CbRwdsAccno":"'+CbRwdsAccno+'","cbCardholderNo":"'+cbCardholderNo+'","cbIdType":"'+cbIdType+'"'
		json +=',"idNo":"'+idNo+'","uname":"'+uname+'","birthday":"'+birthday+'","Address":"'+Address+'"}]'
		alert(json);
		if(!confirm("确认提交?")){
			  return;
		};
		$.ajax({
			type : "POST",
			url : "${ctx}/prticke/Cash_ticket",
			dataType : "json",
			data : {
				data : json,
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					alert("增票失败！");
					return ;
				}
			alert("增票成功！");
			}
		});
	}
	
    </script>
  </body>
</html>
