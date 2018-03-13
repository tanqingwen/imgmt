<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>综合管理系统 |会员卡解除挂失</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
    <link rel="stylesheet" href="${assets }/layer/skin/layer.css" />
    <link rel="stylesheet" href="${assets }/css/memberShip.css" />
	</head>
	<body  class="hold-transition skin-blue-light sidebar-mini">
	<div style="position:absolute;">
  		<jsp:include flush="true" page="/WEB-INF/tags/all.jsp"></jsp:include>
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
			<h1>会员卡解挂</h1>
	          <ol class="breadcrumb">
	            <li><a href="${ctx }"><i class="fa fa-dashboard"></i> 主页</a></li>
	            <li><a href="${ctx }/startTreeviewDetail/hykzy">会员卡作业</a></li>
	            <li class="active">会员卡解挂</li>
	          </ol>
		</section>
	
	<div class="container-fluid"> 
		<div class="row cardAbandon">
			<div class="tip-img"><img src="${assets }/app/img/会员卡解挂.png"></div>
			<div class="content">
				
				<div class="main">
					<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
					 <div class="form-line">
					 	<div class="col-lg-12 mag" style="text-align:left;">
					 		<div class="labels" >
					   			<i>手机号码:</i>
					   			<input type="text" name="mobile" id="mobile" value="" class="line-input" />
						   	</div>
						   	<div class="labels">
						   	<button type="button" class="btn-size" style="width:110px;margin:0 20px;" onclick="phone()">查询</button>
						   		<span style="color:red;font-size:18px;font-weight:bold">温馨提示:可根据手机号查询</span>
						   		
						   	</div>
					 	</div>
					 </div>
					<div class="clearfix"></div>
					
				<form  id="CLOSS"  class="form-horizontal">
					<h3 style="border-bottom: 2px dashed #6fba2c;">硬件录入</h3>
					 <div class="form-line">
						 	<div class="col-lg-12 mag">
						 		<div class="labels">
						   			<i>会员卡余额:</i>
						   		<input type="text" id="varbalance" name="varbalance" value="" class="line-input" disabled="disabled"/>
							   	</div>
							   	<div class="labels">
							   		<i>身份证号码:</i>
							   	<input type="text" id="nric" name="nric" value="" class="line-input" style="width: 200px;" disabled="disabled" />
							   	<button type="button" onclick="readCard()"  class="btn-size">读身份证</button>
							   	</div>
						 	</div>
						 	
						 	<div class="col-lg-12 mag">
						 		<div class="labels">
						   			<i>持卡人姓名:</i>
						   			<input type="text" id="varOld_name" name="varOld_name" value="" class="line-input" disabled="disabled" />
							   	</div>
							   	<div class="labels">
							   		<i>持卡人号码:</i>
						   			<input type="text" id="cbCardholderNo"  name="cbCardholderNo" value="" class="line-input" disabled="disabled" style="width:290px;" />
						   			<span style="color:blue;font-size:20px;" id="cardstatus"></span>
							   	</div>
					 		</div>
					 		<div class="col-lg-12 mag">
						 		<div class="labels" >
						   			
						   			<i>出生日期:</i>
							   		<input type="text" id="varCb_birthday" name="varCb_birthday" value="" class="line-input" disabled="disabled" />
						   			<input type="hidden" name="newPlasticCode" value="" />
							   	</div>
							   	<div class="labels">
							   		<i>移动号码:</i>
							   	<input type="text" id="varOld_mobile" name="varOld_mobile" value="" class="line-input" disabled="disabled" />
							   	</div>
					 		</div>
					 	
					 </div>
					 <div class="clearfix"></div>
					 
					  <div class="form-line" style="margin-top:140px;">
					  		<div class="col-lg-12 mag">
					  		
					  		<div class="labels" style="float:left;">
					   			<a href="${ctx }/startTreeviewDetail/hykzy" class="form-a">&lt;返回</a>					   			
						   </div>
					  		
						   	<div class="labels" style="float:right;">
						   		<button  id="addButton" name="addButton" type="button" class="btn-size" style="width:110px;margin:0 20px;">解挂</button>
						   	</div>
					 	</div>
					 	<div class="clearfix"></div>
					  </div>
					 </form>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	
	<tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/validator/js/validator.js"></script>	
	<script src="${assets}/layer/layer.js"></script>
	<script type="text/javascript">
	//读取身份证:获取身份证号码、出生日期
	function readCard(){
		var strReadResult=CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
			$("#nric").val(CVR_IDCard.CardNo);
			getCard();
		}else {
			layer.msg("读卡失败,"+strReadResult);
		}
	}
	
	//获取卡号
	function getCard(){
		var idType="1";
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
				idNo: idNo,
				cbPlasticCd : "L"
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if(data==null){
					layer.msg("使用证件信息没有找到对应数据");
					return;
				}else{
					var res=data.value;
					/* for(var i=0;i<res.length;i++){
						s.options.add(new Option(cardview(res[i]),res[i]));
					} */
					CLOSS.cbCardholderNo.value=res[0].substr(6);
					getInfo(res[0]);
				}
			}
		 });
	}
	
	//挂失卡片信息
	function getInfo(val){
		$.ajax({
			type : "POST",
			url : "${ctx}/blkmlc/getCardInfo1",
			dataType : "json",
			data : {
				cardNo: val
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				if(data==null){
					layer.msg("没有找到卡号记录！");
					return;
				}else{
					var res=data.value;
					if(res[7] !="L-挂失卡"){
						layer.msg("此卡不能解挂");
						CLOSS.cbCardholderNo.value="";
						CLOSS.nric.value="";
					}else{
						
						CLOSS.varbalance.value = res[8];
						CLOSS.varOld_name.value = res[2];
						CLOSS.varCb_birthday.value = res[5];
						CLOSS.varOld_mobile.value = res[4];
						document.getElementById("cardstatus").innerHTML=res[7];
						document.getElementById("cardstatus").style.display="inline-block";
					}
				}
			}
		 });
	}
	
	// 卡号处理
	function cardview(cardno){
		if(cardno!=null&&cardno.length==16){
			return cardno.substr(10);
		}else {
			return cardno;
		}
	}
	
	
	//提交
	$("#addButton").click(function(){
	  var cardNo=CLOSS.cbCardholderNo.value;
	  var newPlasticCode=CLOSS.newPlasticCode.value;
	  var idNo=CLOSS.nric.value;
	  if(idNo==""){
		  layer.msg("请读取身份证号信息");
		  return false;
	  }
	  if(cardNo==""){
			return;
	  }
	  $.ajax({
		type : "POST",
		url : "${ctx}/blkmlc/loseCard",
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
			if(null!=res){
				layer.msg("解挂成功！");	
			}
		}
	 });
	});
	$("#returnButton").click(function(){
		$("#CLOSS").attr("action", "${ctx }/");
	});
	
	function phone(){
		
		var value=$("#mobile").val();
		if(value == null || value.trim()==""){
			layer.msg("请输入手机号");
			return false;
		}else{
			$.ajax({
				type : "POST",
				url : "${ctx}/blkmlc/getCardInfo2",
				dataType : "json",
				data : {
					mobile : value,
					cbPlasticCd : 'L'
				},
				success : function(data){
					if(failureProcess("${ctx}",data)){
						return;
					}
					if(data == null){
						layer.msg("没有找到卡记录");
						
						return;
					}else{
						var res= data.value;
						if(res[7] !="L-挂失卡"){
							layer.msg("此卡不能解挂");
							$("input").val("");
							document.getElementById("cardstatus").style.display="none";
							return;
						}else{
							CLOSS.nric.value = res[1];
							CLOSS.varbalance.value = res[9];
							CLOSS.varOld_name.value = res[2];
							CLOSS.varCb_birthday.value = res[5];
							CLOSS.varOld_mobile.value = res[4];
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

	