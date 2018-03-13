<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 |会员退卡</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
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
      <tags:main_sidebar active="card"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>会员退卡</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/hykzy">会员卡作业</a></li>
            <li class="active">会员退卡</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                 
                <form id="crdtblfrom" name="crdtblfrom" class="form-horizontal">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="cbCardholderNo1" class="col-sm-3 control-label">持卡人号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input class="form-control" id="cbCardholderNo" name="cbCardholderNo" />
								      <input type="button" id="idcard" name="idcard" onclick="findCard()" value="读卡号"/>&nbsp;&nbsp;&nbsp;<span style="color:blue;" id="cardstatus"></span> 
								      <input type="hidden" id="cbPlasticCd" name="cbPlasticCd" value=""/>
								      <input type="hidden" id="newPlasticCode" name="newPlasticCode" value="D" >
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
								    <label for="idNo" class="col-sm-3 control-label">身份证号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbIdno" name="cbIdno" value=""/>
								      <input type="button" id="idcard" name="idcard" onclick="readCard()" value="读身份证"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">会员卡余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varbalance" name="varbalance"  readonly="readonly"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="deposit" class="col-sm-3 control-label">押金</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varServerFee" name="varServerFee" readonly value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="uname" class="col-sm-3 control-label">姓名</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varOld_name" name="varOld_name" readonly="readonly" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="birthday" class="col-sm-3 control-label">出生日期</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varCb_birthday" readonly="readonly" name="varCb_birthday" value=""/>例:19001231表示1900年12月31日
								    </div>
								</div>
								<div class="form-group">
								    <label for="mobile" class="col-sm-3 control-label">移动电话</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varOld_mobile" name="varOld_mobile" readonly="readonly" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="prProdctGroup" class="col-sm-3 control-label">客户等级</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="varOld_prdgrp" disabled="disabled" name="varOld_prdgrp" > 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								<div class="form-group">
									<label for="deposit" class="col-sm-3 control-label">退款方式</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="varDestype" name="varDestype" > 
									      	 <option value="N">现金</option>
									      	 <option value="Y">客户账户</option>
								      	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="deposit" class="col-sm-3 control-label">退卡原因</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="varDesc" name="varDesc" > 
									      	 <option value="reason">客户不在使用</option>
								      	</select>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
							<button type="button" class="btn  btn-primary " id="addButton" name="addButton"  class="btn btn-info pull-right">提交</button>	                    	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-primary " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    <script src="${assets}/yanwu/js/jfunction1.js"></script>
    
    <script type="text/javascript">
    var key2str;
    var key3str;
    var key6str;
    
	//读取身份证:获取身份证号码、出生日期
	function readCard(){
		var idType=crdtblfrom.cbIdType.value;
		if(idType!="1"){
			alert("选择证件类型为身份证");
			return;
		}
  		var strReadResult=CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
				$("#cbIdno").val(CVR_IDCard.CardNo);
		}else {
			alert("读卡失败,"+strReadResult);
		}
	}
    
    //读卡号
    function findCard(){
    	readCardNo("cbCardholderNo")
   		if(document.getElementById("cbCardholderNo").value==""){
       		alert("卡号不能为空!");
       		return;
       	} 
       	var cardNo=document.getElementsByName("cbCardholderNo")[0].value;
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
       			if(null!=p){
       				key2str=p[0];
       				key3str=p[1];
       				key6str=p[2];
       				getCardInfo(cardNo);
       				getBalance(cardNo);
       			}else{
       				alert("卡秘钥错误!");
       			}
       		}
       	});
    }
    
    
    //卡信息
	function getCardInfo(cardNo){
    	$.ajax({
    		type : "POST",
    		url : "${ctx}/CardDestroy/getCardInfo",
    		dataType : "json",
    		data : {
    			cardNumber : cardNo
    		},
    		success : function(data) {
    			if (failureProcess("${ctx}", data)) {
    				return;
    			}
    			var res=data.value;
    			document.getElementsByName("varOld_name")[0].value = res[2];
    			document.getElementsByName("varOld_prdgrp")[0].value = res[3];
    			document.getElementsByName("varOld_mobile")[0].value = res[4];
    			document.getElementsByName("varCb_birthday")[0].value = res[5];
    			document.getElementsByName("varServerFee")[0].value = res[6];
    			document.getElementById("cardstatus").innerHTML=res[7];
    		}
    	});
    }
    
    //会员卡余额
	function getBalance(cardNo){
    	
    	$.ajax({
    		type : "POST",
    		url : "${ctx}/CardDestroy/readBalance",
    		dataType : "json",
    		data : {
    			cardNo:cardNo
    		},
    		success : function(data) {
    			if (failureProcess("${ctx}", data)) {
    				alert(e.message);
    				return;
    			}
    			var p=data.value;
    			document.getElementsByName("varbalance")[0].value=p;
    		}
    	});
    }
	
	
	$("#addButton").click(function(){
		
		  var cardNo=document.crdtblfrom.cbCardholderNo.value;
		  cardNo="<%=Constants.baseBIN%>"+cardNo;
		  
		  var cbIdType=document.crdtblfrom.cbIdType.value;
		  var cbIdno=document.crdtblfrom.cbIdno.value;
		  var varDesc=document.crdtblfrom.varDesc.value;
		  if(!validation())return false;
		  var ret;
		  
		    //1： 检查卡号是否存在
			$.ajax({
				type : "POST",
				url : "${ctx}/CardDestroy/checkCardNo",
				dataType : "json",
				data : {
					cardNumber : cardNo
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					ret=data.value;
					if(ret==''){
						alert("卡号不存在!");
						return false;
					}else{
						//2: 检查卡状态
						checkState();
						var result;
						var statu = confirm("是否提交?");
						var submitBun = document.getElementById("addButton");
				        if(!statu){
				        	submitBun.disabled=false;
				        	return false;
				       	}
				       	//3: 检查更新对应表
				       	var result = doCheckerApprove(cardNo,cbIdType,cbIdno,varDesc);
				       	if(result!="FALSE"){
					    	wirteCard();
					    	alert("退卡成功!");
					    }
					}
				}
			});
		});
	
	
	//检查状态
	function checkState(){
		var cardNo=document.crdtblfrom.cbCardholderNo.value;
		cardNo="<%=Constants.baseBIN%>"+cardNo;
		$.ajax({
    		type : "POST",
    		url : "${ctx}/CardDestroy/checkState",
    		dataType : "json",
    		data : {
    			cardNumber : cardNo
    		},
    		success : function(data) {
    			if (failureProcess("${ctx}", data)) {
    				return;
    			}
    			var oldState=data.value;
    			if(oldState=='D'){
    				alert("此卡已销卡，不能再销！");
    				return false;
    			}
    		}
    	});
	}
	
	
	//检查更新对应表 
	function doCheckerApprove(cardNo,cbIdType,cbIdno,varDesc){
		var varDestype = document.crdtblfrom.varDestype.value; 
		$.ajax({
    		type : "POST",
    		url : "${ctx}/CardDestroy/doCheckerApprove",
    		dataType : "json",
    		data : {
    			cardNumber : cardNo,
    			cbIdType:cbIdType,
    			cbIdno:cbIdno,
    			varDesc:varDesc,
    			varDestype:varDestype
    		},
    		success : function(data) {
    			if (failureProcess("${ctx}", data)) {
    				return;
    			}
    		}
    	});
	}
	
	
	//提交校验
	function validation(){

		var cardNo = document.crdtblfrom.cbCardholderNo.value;
		 if(cardNo.indexOf(" ") != -1) {
		  		alert("出错");
		  		document.crdtblfrom.cbCardholderNo.focus();
			return false;	
		 }
		if(cardNo.length== 0){
			alert("出错");
			document.crdtblfrom.cbCardholderNo.focus();
			return false;	
		}
		
		if(isNaN(cardNo)){
			alert("请输入整数的持卡人号码!");
			document.crdtblfrom.cbCardholderNo.focus();
			return false;
		}
		
		var Nric = document.crdtblfrom.cbIdno.value;
		
		if(Nric == null || Nric.length == 0 || Nric==''){
			alert("身份证号码不能为空格!");
			document.crdtblfrom.cbIdno.focus();
		    return false;
		}
		
		return true;
	}
	
	
	function wirteCard(){
		var cardNo=document.crdtblfrom.cbCardholderNo.value;
		cardNo="<%=Constants.baseBIN%>"+cardNo;
		try{
			var k = new Array();
			var key1 = mt_block0.substr(0,6);
			
			k.push("A0A1A2A3A4A5");
			k.push(key1+""+key1);
			k.push(key2str);
			k.push(key3str);
			k.push(key3str);
			k.push(key3str);
			k.push(key6str);
			
			$.ajax({
	    		type : "POST",
	    		url : "${ctx}/CardDestroy/doReset",
	    		dataType : "json",
	    		data : {
	    			cardNumber : cardNo
	    		},
	    		success : function(data) {
	    			if (failureProcess("${ctx}", data)) {
	    				return;
	    			}
	    			var p=data.value;
	    			var kn = 0;
	    			for(var i=0;i<p.length;i++){
	    				if(writeSector(p[i],i,k[kn])){
	    					kn++;
	    				}else{
	    					break;
	    				}
	    			}
	    		}
	    	});
		}catch(e){
			alert(e.message);
		}
	}
    </script>
    
  </body>
</html>
