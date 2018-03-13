<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 窗口开卡</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body onload="load()" class="hold-transition skin-blue-light sidebar-mini">
    <div style="position:absolute;">
		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="card_add"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>窗口开卡</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">窗口开卡</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                 
                <form id="crdtblfrom" name="crdtblfrom"  class="form-horizontal">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="cbCardholderNo" class="col-sm-3 control-label"><font color="red">*</font>持卡人号码</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbCardholderNo" name="cbCardholderNo" value=""/>
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label"><font color="red">*</font>证件类型</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="cbIdType"  name="cbIdType" readonly="readonly"> 
									      <c:forEach var="idType" items="${idTypeList}">
									      	 <option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
									      </c:forEach>
								    	</select>	
								    </div>
								</div>
								<div class="form-group">
								    <label for="idNo" class="col-sm-3 control-label"><font color="red">*</font>身份证号码</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="idNo" name="idNo"  value=""/><input type="button" id="idcard" name="idcard" onclick="readCard()" value="读身份证"/> 
								    </div>
								</div>
								<div class="form-group">
								    <label for="uname" class="col-sm-3 control-label"><font color="red">*</font>姓名</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="uname" name="uname" readonly="readonly" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="birthday" class="col-sm-3 control-label"><font color="red">*</font>出生日期</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="birthday" name="birthday" readonly="readonly" value=""/>例:19001231表示1900年12月31日
								      <input type="hidden" class="form-control" id="varCb_cust_class" name="varCb_cust_class" value=""/>
								      <input type="hidden" class="form-control" id="varBlock0str" name="varBlock0str" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="mobile" class="col-sm-3 control-label"><font color="red">*</font>移动电话</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="mobile" name="mobile" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="prProdctGroup" class="col-sm-3 control-label"><font color="red">*</font>客户等级</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="prProdctGroup"  name="prProdctGroup" readonly="readonly" onclick="vena()"> 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
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
								<!-- 掌静脉：目前定位-客户等级-1105-金卡会员	必须登记掌静脉	add by Hugh end  -->
								<div class="form-group">
								    <label for="amount" class="col-sm-3 control-label"><font color="red">*</font>预存金额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="amount" name="amount" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="deposit" class="col-sm-3 control-label"><font color="red">*</font>押金</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="deposit" name="deposit" > 
									      	 <option value="20" >20</option>
								      	</select>
<!-- 								      <input type="text" class="form-control" id="" name="deposit" value=""/> -->
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					
					<div class="box-footer">
						<div class="pull-right">
							<button type="button" class="btn  btn-primary " id="addButton" name="addButton" ><i class="fa fa-plus"></i> 提交</button>
							<a type="button" class="btn  btn-primary " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
						</div>
<!-- 					 	<div class="col-sm-10 ">						 -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-1 ">	 -->
<!-- 							<button type="button" class="btn  btn-primary " id="addButton" name="addButton"  class="btn btn-info pull-right">提交</button> -->
<!-- 	                    </div> -->
<!-- 	                    <div class="col-sm-1 "> -->
<!-- 	                    	 
<!-- 	                    	<a type="button" class="btn btn-default" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> -->
<!-- 	                    	 -->
<%-- 	                    	<a type="button" class="btn  btn-primary " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a> --%>
<!-- 	                    </div>	                 	 -->
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
    
    //登记掌静脉
   $("#diaoyong").click(function(){
		var cardNo=document.crdtblfrom.cbCardholderNo.value;
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
		var cslevel = document.crdtblfrom.prProdctGroup.value;
		if(cslevel=="1105"){ //金卡会员
			document.getElementById('signData').style.display='';
			document.getElementById('viewVena').style.display='';
		
		}else{
			document.getElementById('signData').style.display='none';
			document.getElementById('viewVena').style.display='none';
		}
	}
    
	$("#addButton").click(function(){
	  var cardNo=document.crdtblfrom.cbCardholderNo.value;
	  if(cardNo!=""){
		  if(cardNo.length!=6){
			  alert("持卡人号码为8位!");
			  return;
		  }
	  }
	  var idNo=document.crdtblfrom.idNo.value;
	  if(idNo==null || idNo==""){
		  alert("身份证号码不能为空!");
		  return;
	  }
	  var birthday=document.crdtblfrom.birthday.value;
	  if(birthday==null || birthday==""){
		  alert("移动电话不能为空!");
		  return;
	  }
	  
	  var uname=document.crdtblfrom.uname.value;
	  if(uname==null || uname==""){
		  alert("姓名不能为空!");
		  return;
	  }
	  
	  var deposit=document.crdtblfrom.deposit.value;
	  if(deposit==null || deposit==""){
		  alert("押金不能为空!");
		  return;
	  }
	  if(deposit.length>2){
		  alert("押金只能是两位!");
		  return;
	  }
	  if(cardNo!=""){
		  cardNo="<%=Constants.baseBIN%>"+cardNo;  
	  }else{
		  cardNo="";
	  }
	  if(mt_block0==null || mt_block0==""){
			if(readBlock0()==null){
				return;
		  	}
	  }
	  var amount=document.crdtblfrom.amount.value;//预存金额
	  var deposit=document.crdtblfrom.deposit.value;//押金
	  if(amount==null || amount==""){
		  alert("预存金额不能为空!");
		  return;
	  }
	  if(parseInt(amount)<parseInt(deposit)){
		  alert("预存金额不能小于押金!");
		  return;
	  }
	  if(!confirm("确认提交?")){
		  return;
	  }
	  blankCheck();
	  document.getElementById("varBlock0str").value=mt_block0;
	  $.ajax({
		type : "POST",
		url : "${ctx}/crdtbl/openCard",
		dataType : "json",
		data : {
			cbCardholderNo : cardNo,
			cbIdType : $("#cbIdType").val(),  // 1:证件类型  2:户口本 3:国外证件 
			idNo : $("#idNo").val(), // 身份证号码
			birthday : $("#birthday").val(),
			mobile : $("#mobile").val(),
			preAmount : $("#amount").val(), //预存金额
			uname : $("#uname").val(),  //姓名
			prProdctGroup : $("#prProdctGroup").val(), //产品组
			deposit : $("#deposit").val(),  //押金
			cardtype : $("#prProdctGroup").val(), // prProdctGroup产品组号码
			block0str:$("#varBlock0str").val()  // 0扇区0块
		},
		success : function(data) {
			if (failureProcess("${ctx}", data)) {
				return;
			}
			firstWrite(data.value);
			alert("开卡成功！");
		}
	 });
	});
	

	//读取身份证:获取身份证号码、出生日期
	function readCard(){
		var idNo=crdtblfrom.cbIdType.value;
		if(idNo!="1"){
			alert("选择证件类型为身份证");
			return;
		}
  		var strReadResult=CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
				$("#idNo").val(CVR_IDCard.CardNo);
				//证件类型1-身份证（自动获取身份证）
				if(crdtblfrom.cbIdType.value=="1"){
					$("#birthday").val($("#idNo").val().substr(6,8));
					$("#uname").val(CVR_IDCard.Name);
				}
		}else {
			alert("读取身份证失败,"+strReadResult);
		}
	}
	
	// ajax异步文件上传
	$(function () {
            $("#upload").click(function () {
                $("#imgWait").show();
            	var cardNo=document.crdtblfrom.cbCardholderNo.value;
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

    </script>
    
  </body>
</html>
