<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
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
      <tags:main_sidebar active="staff"/>
      
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
                <form  id="CLOSS" name="CLOSS" class="form-horizontal">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">退款方式<font color="red">*</font></label>
								    <div class="col-sm-8">
								     	 <select id="varDestype" name="varDestype" class="form-control">
				                                <option value="N">现金</option>
												<option value="Y">客户账户</option>
				                            </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">退卡原因<font color="red">*</font></label>
								    <div class="col-sm-8">
								     	 <select id="varDesc" name="varDesc" class="form-control">
				                                <option value="reason">客户不再使用</option>
				                            </select>
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">证件类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								     	<select id="idType" name="idType" disabled="disabled" class="form-control"> 
									       <c:forEach var="idType" items="${idTypeList}">
										      	 <option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
										      </c:forEach>
								    	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">身份证号码<font color="red">*</font></label>
								    <div class="col-sm-6">
								      <input type="text" class="form-control"  id="nric" name="nric" value="" />
								    </div>
								     <div class="col-sm-2">
								    	<button type="button" id="idcard" name="idcard" onclick="readCard()" >读身份证</button>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">会员卡余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control"  id="varbalance" name="varbalance" value="" disabled="disabled"/>
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">手机号</label>
								    <div class="col-sm-8">
								      <input class="form-control" id="mobile" name="mobile" type="text" value="" onblur="phone()"/>
								    </div>
								</div>
                				<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">姓名</label>
								    <div class="col-sm-8">
								      <input class="form-control" id="varOld_name" name="varOld_name" type="text" value="" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">客户等级<font color="red">*</font></label>
								    <div class="col-sm-8">
								     	<select id="cbCardPrdctGroup" disabled="disabled" name="cbCardPrdctGroup" class="form-control"> 
									     <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								    	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">持卡人号码</label>
								    <div class="col-sm-6">
								    	<input type="text" class="form-control" id="cbCardholderNo" name="cbCardholderNo" />
								    </div>
								    <div class="col-sm-2">
								    	<input type="button"  id="idcard" name="idcard" onclick="findCard()" value="读卡信息" />&nbsp;&nbsp;&nbsp;<span style="color:blue;" id="cardstatus"></span> 
			                            <input type="hidden" id="cbPlasticCd" name="cbPlasticCd" value=""/>
										<input type="hidden" id="newPlasticCode" name="newPlasticCode" value="D" >
								    </div>
								</div>
								<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">出生日期</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varCb_birthday" name="varCb_birthday" placeholder="例：19901231   表示1990年12月31日" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">移动电话</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control"  id="varOld_mobile" name="varOld_mobile" value="" disabled="disabled"/>
								    </div>
								</div>
								
								
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button  id="addButton" name="addButton" type="button" style="background-color: red;" class="btn btn-info "> 办理</button>
							<a type="button" class="btn btn-default " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    <script src="${assets}/app/js/app.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    
  
   <script type="text/javascript">
	//读取身份证:获取身份证号码、出生日期
	function readCard(){
		var idNo=CLOSS.idType.value;
		if(idNo!="1"){
			alert("选择证件类型为身份证");
			return;
		}
			var strReadResult=CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
			$("#nric").val(CVR_IDCard.CardNo);
			getCard();
		}else {
			alert("读卡失败,"+strReadResult);
		}
	}
	
	//获取卡号
	function getCard(){
		var idType=CLOSS.idType.value;
		var idNo=CLOSS.nric.value;
		if(idType==null||idType==""||idNo==null||idNo==""){
			return;
		}
		var s=CLOSS.cbCardholderNo;
		s.length=0;
		$.ajax({
			type : "POST",
			url : "${ctx}/blkmlc/getCardInfo",
			dataType : "json",
			data : {
				idType: idType,
				idNo: idNo	
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if(data==null){
					alert("使用证件信息没有找到对应数据");
					return;
				}else{
					var res=data.value;
					  for(var i=0;i<res.length;i++){
						s.options.add(new Option(cardview(res[i]),res[i]));
					} 
					getInfo(CLOSS.cbCardholderNo.value);
				}
			}
		 });
	}
	
	//挂失卡片信息
	function getInfo(val){
		alert("aaa");
		$.ajax({
			type : "POST",
			url : "${ctx}/CardDestroy/getCardInfo1",
			dataType : "json",
			data : {
				cardNo: val
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if(data==null){
					alert("没有找到卡号记录！");
					return;
				}else{
					var res=data.value;
					//document.getElementById("cardstatus").innerHTML=res[7];
					//document.getElementById("cardstatus").style.display="inline-block";
					CLOSS.varbalance.value = res[8];
					//CLOSS.cbCardholderNo.value = val.substring(8,16);
					CLOSS.varOld_name.value = res[2];
					CLOSS.varCb_birthday.value = res[5];
					CLOSS.varOld_mobile.value = res[4];
					CLOSS.cbCardPrdctGroup.value = res[3];
				}
			}
		 });
	}
	
	// 卡号处理
	function cardview(cardno){
		if(cardno!=null&&cardno.length==16){
			return cardno.substr(8);
		}else {
			return cardno;
		}
	}
	
	
	var key1str;
	var key2str;
	var key3str;
	var key6str;

	//读卡号
	function findCard(){
		
		readCardNo("cbCardholderNo");
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
					key2str=p[0];
					key3str=p[1];
					key6str=p[2];
					getCardMess(cardNo);
					getBalance(cardNo);
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
				if(res[7]=="D-已退卡"){
					alert("此卡不能退卡");
					CLOSS.cbCardholderNo.value="";
					return;
				}
				CLOSS.nric.value = res[1];
				CLOSS.varOld_name.value = res[2];
				CLOSS.cbCardPrdctGroup.value = res[3];
				CLOSS.varOld_mobile.value = res[4];
				CLOSS.varCb_birthday.value = res[5];
				
				//CLOSS.varFee.value = res[6];
				//document.getElementById("cardstatus").innerHTML=res[7];
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
				CLOSS.varbalance.value = res;
			}
		});
	 }	


	//会员卡余额
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
					CLOSS.varbalance.value=p;
				}
			}
		});
	}	
	
	
	 //提交
	/* $("#addButton").click(function(){
	  var cardNo=CLOSS.cbCardholderNo.value;
	  var newPlasticCode=CLOSS.newPlasticCode.value;
	  if(cardNo==""){
		  alert("此用户没有绑定卡号");
			return;
	  }
	  $.ajax({
		type : "POST",
		url : "${ctx}/CardDestroy/doReset",
		dataType : "json",
		data : {
			cardNo : cardNo,
			newPlasticCode : newPlasticCode
		},
		success : function(data) {
			if (failureProcess("${ctx}", data)) {
				return;
			}
			var res = data.value;
			alert("res:"+res);
			if(null!=res){
				alert("退卡成功！");	
			}
		}
	 });
	});
	$("#returnButton").click(function(){
		$("#CLOSS").attr("action", "${ctx }/");
	});  */
	
	$("#addButton").click(function(){
		  var cardNo=CLOSS.cbCardholderNo.value;
		  cardNo="<%=Constants.baseBIN%>"+cardNo;
		  var cbIdType=CLOSS.idType.value;
		  var cbIdno=CLOSS.nric.value;
		  var varDesc=CLOSS.varDesc.value;
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
						//checkState();
				
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
	<%-- function checkState(){
		var cardNo=CLOSS.cbCardholderNo.value;
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
  				return;
  			}
  		}
  	});
	} --%>
	
	
	//检查更新对应表 
	function doCheckerApprove(cardNo,cbIdType,cbIdno,varDesc){
		var varDestype = CLOSS.varDestype.value; 
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

		var cardNo = CLOSS.cbCardholderNo.value;
		 
		if(cardNo.length== 0){
			alert("此身份证未绑定账号");
			return false;	
		}
		return true;
	}
	
	
	function wirteCard(){
		var cardNo=CLOSS.cbCardholderNo.value;
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
	
	function phone(){
		var value=$("#mobile").val();
		if(value == null || value.trim() ==""){
			alert("请输入手机号");
		}else{
			$.ajax({
				type : "POST",
				url : "${ctx}/blkmlc/getCardInfo2",
				dataType : "json",
				data : {
					mobile : value,
					cbPlasticCd : 'U'
				},
				success : function(data){
					if(failureProcess("${ctx}", data)){
						return;
					}
					if(data == null){
						alert("没有找到卡记录");
						return;
					}else{
						var res=data.value;
						if(res[7] != "U-正常卡"){
							alert("此卡不能退！");
							CLOSS.mobile.value= "";
						}else{
						
							CLOSS.nric.value = res[1];
							CLOSS.varbalance.value = res[9];
							CLOSS.varOld_name.value = res[2];
							CLOSS.varCb_birthday.value = res[5];
							CLOSS.varOld_mobile.value = res[4];
							CLOSS.cbCardPrdctGroup.value = res[3];
							CLOSS.cbCardholderNo.value=res[8].substring(6);
							document.getElementById("cardstatus").innerHTML=res[7];
							document.getElementById("cardstatus").style.display="inline-block";
						}
					}
				}
			});
		}
	}
</script>
  </body>
</html>
