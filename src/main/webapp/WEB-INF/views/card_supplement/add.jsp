<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<title>综合管理系统|会员卡补办</title>
		<link rel="stylesheet" href="${assets }/layer/shin/layer.css" />
		<link rel="stylesheet" href="${assets }/css/CardReissue.css" />
		
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
			<h1>会员卡补办</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/hykzy">会员卡作业</a></li>
					<li class="active">会员卡补办</li>
				</ol>
		</section>
	
		<div class="container-fluid CardReissue">
			<div class="row">
				<div class="tip-img">
					<p>会员卡补办</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
						<form id="CLOSS" name="CLOSS"  class="form-horizontal">
							<div class="form-line clearfix">

								<div class="col-lg-12 col-md-12 ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="balance">证件类型：</label>
											<select id="dcumentType" name="idType">
												<c:forEach var="idType" items="${idTypeList}">
										      	 <option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
										      </c:forEach>
											</select>

										</div>
									</div>
									
								</div>
								<div class="col-lg-12 col-md-12 mag">
									<div class="col-lg-6 col-md-6">
										<div class="form-group holderNo">
											<label for="idNo">身份证号码：</label>
											<input type="text" id="nric" name="nric" value="" disabled="disabled" class="line-input" style="width:205px;margin-right:2px;" />
											<button type="button" id="idcard" name="idcard" onclick="readCard()" class="btn-size">读身份证</button>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group holderNo">
											<label for="idNo">新持卡人号码：</label>
											<input type="text" id="cbCardholderNo" name="cbCardholderNo" disabled="disabled" class="line-input" style="width:205px;margin-right:2px;" />
											<input type="hidden" class="form-control" id="varBlock0str" name="varBlock0str" value=""/>
								    		<input type="hidden" id="trxnCode" name="trxnCode" value="SUPPL">
								    		<input type=hidden name="varRn_reason" value="AR">
								    		<input type=hidden name="varNC_EMERGENCY" value="R">
											<button type="button" id="MagCard3" name="idcard" onclick="findCard()" class="btn-size">读卡信息</button>
										</div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12 mag">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="userName">姓名：</label>
											<input type="text" id="varOld_name" name="varOld_name" type="text" value="" disabled="disabled" class="line-input">
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label>旧持卡人号码：</label>
											<input type="text" id="oldcbCardholderNo"  name="oldcbCardholderNo" disabled="disabled" class="line-input">
										</div>

									</div>

								</div>
								<div class="col-lg-12 col-md-12 mag">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label>客户等级：</label>
											<select id="dcumentType" disabled="disabled" name="cbCardPrdctGroup">
												<c:forEach var="prdGrp" items="${prdGrpList}">
									      			 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									     		 </c:forEach>
											</select>

										</div>
									</div>
									<div class="col-lg-6 col-md-6">

										<div class="form-group">
											<label for="birth">出生日期：</label>
											<input type="text" id="varCb_birthday" name="varCb_birthday" disabled="disabled" value="" class="line-input">
										</div>

									</div>

								</div>
								<div class="col-lg-12 col-md-12 mag">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="userName">会员卡余额：</label>
											<input type="text" id="varbalance" name="varbalance" value="" disabled="disabled" class="line-input">
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label >移动电话：</label>
											<input type="text"  id="varOld_mobile" name="varOld_mobile" value="" disabled="disabled" class="line-input">
										</div>
										
									</div>

								</div>
							</div>
							<div class="clearfix"></div>

							<div class="col-lg-12 col-md-12" style="margin:50px 0 20px 0">
								<div class="col-lg-12 col-md-12 mag">
									<div style="float:left;">
										<a href="${ctx }/startTreeviewDetail/hykzy" class="form-a">
											&lt;返回</a>

												<span style="margin:0 15px;display: inline-block;">
					   			</span>
									</div>
									<div style="float:right;">
										<input type="hidden" value="" id="hidden" />
										<button id="addButton" name="addButton" type="button" class="btn-size" style="width:110px;margin:0 25px 0 15px;">办理</button>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</form>

					</div>
				</div>
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
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script src="${assets }/layer/layer.js"></script>
    
    

   <script type="text/javascript">

	//读取身份证:获取身份证号码、出生日期
	function readCard(){
		var idNo=CLOSS.idType.value;
		if(idNo!="1"){
			layer.msg("选择证件类型为身份证");
			return;
		}
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
					layer.msg("使用证件信息没有找到对应数据");
					return;
				}else{
					var res=data.value;
					/* for(var i=0;i<res.length;i++){
						s.options.add(new Option(cardview(res[i]),res[i]));
					} */
					CLOSS.oldcbCardholderNo.value=res[0].substring(6);
					
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
					var res=data.value;
					if(res[7] != "L-挂失卡"){
						layer.msg("此卡不能补办，请先挂失！");
						CLOSS.oldcbCardholderNo.value="";
						CLOSS.nric.value="";
						return;
					}else
						document.getElementById("cardstatus").innerHTML=res[7];
						document.getElementById("cardstatus").style.display="inline-block";
						CLOSS.varbalance.value = res[8];
						CLOSS.varOld_name.value = res[2];
						CLOSS.varOld_name.value = res[2];
						CLOSS.varCb_birthday.value = res[5];
						CLOSS.varOld_mobile.value = res[4];
						CLOSS.cbCardPrdctGroup.value = res[3];
					}
				}
		 });
	}
	
	// 卡号处理
	/* function cardview(cardno){
		if(cardno!=null&&cardno.length==16){
			return cardno.substr(10);
		}else {
			return cardno;
		}
	} */
	
	
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
					layer.msg(e.message);
					return;
				}
				var p=data.value;
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
				
			}
		});
	 }	
	
	
	//提交
	$("#addButton").click(function(){
	  var newCardNo=CLOSS.cbCardholderNo.value;
	  newCardNo="<%=Constants.baseBIN %>"+newCardNo
	  var oldCardNo=CLOSS.oldcbCardholderNo.value;
	  var trxnCode=CLOSS.trxnCode.value;
	  var cbPrdct1=CLOSS.cbCardPrdctGroup.value;
	  var idNo=CLOSS.nric.value;
	  if(idNo==null||idNo==""){
		  layer.msg("请读取身份证号信息！");
		  return false;
	  }
	//0块
	   if(mt_block0==null || mt_block0==""){
		  if(readBlock0()==null){
				return;
		  }
	  } 
	
	  var varBlock0str=document.getElementById("varBlock0str").value=mt_block0;
	  $.ajax({
		type : "POST",
		url : "${ctx}/CardSupplement/doCheckerApprove",
		dataType : "json",
		data : {
			newCardNo : newCardNo,
			oldCardNo : oldCardNo,
			trxnCode  : trxnCode,
			varBlock0str : varBlock0str,
			cbPrdct1  : cbPrdct1
		},
		success : function(data) {
			if (failureProcess("${ctx}", data)) {
				return;
			}
			var res = data.value;
			if(null!=res){
				layer.msg("补卡成功！");	
			}
		}
	 });
	}); 
	
	
	
	
	$("#returnButton").click(function(){
		$("#CLOSS").attr("action", "${ctx }/");
	});
	
	function phone(){
		var value=$("#mobile").val();
		if(value == null){
			layer.msg("请输入手机号");
		}else{
			$.ajax({
				type : "POST",
				url : "${ctx}/blkmlc/getCardInfo2",
				dataTypa : "json",
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
						var res=data.value;
						if(res[7] != "L-挂失卡"){
							layer.msg("此卡不能补办，请先挂失！");
							return;
						}else{
							CLOSS.nric.value = res[1];
							CLOSS.varbalance.value = res[9];
							CLOSS.varOld_name.value = res[2];
							CLOSS.varCb_birthday.value = res[5];
							CLOSS.varOld_mobile.value = res[4];
							CLOSS.cbCardPrdctGroup.value = res[3];
							CLOSS.oldcbCardholderNo.value=res[8];
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