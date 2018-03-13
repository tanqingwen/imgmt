<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>

<head>
	<title>综合管理系统|会员卡补办</title>
	<!-- This "tags" contains all the patterns we need in this page. 
	Because CSS has higher priority than HTML, we can put it in head tag. -->
	<tags:head_common_content/>
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
	<tags:main_sidebar active="openloss"/>
	
	<!-- Content Wrapper, contains real page contents. -->
	<div class="content-wrapper">
		
		<!-- This class contains tip on the top of wrapper. Ordinarily it's invisible. -->
		<div class="context-tips">
			<tags:action_tip/>
		</div>
        
        <!-- The header of the content, which always written in "section" tag. -->
		<section class="content-header">
			<h1>会员卡补办</h1>
			<ol class="breadcrumb">
				<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li><a href="${ctx }/startTreeviewDetail/hykzy">会员卡作业</a></li>
				<li class="active">会员卡补办</li>
			</ol>
		</section>

        <!-- Main content -->
        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="CLOSS" name="CLOSS" class="form-horizontal">
                	<div class="box-body">
                		<div class="col-sm-8">
                			<div class="row">
	                			<div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label">证件类型</label>
								    <div class="col-sm-8">
								      <select class="form-control getCard" id="idType" name="idType" readonly="readonly" style="width: 500px"> 
									      <c:forEach var="idType" items="${idTypeList}">
									      	 <option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
									      </c:forEach>
								    	</select>	
								    </div>
								</div>
								<div class="form-group">
								    <label for="idCard" class="col-sm-3 control-label">身份证号码</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="nric" name="nric" style="width: 500px"/><input type="button" id="idcard" name="idcard" onclick="readCard()" value="读身份证"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label"><font color="red">*</font>旧持卡人号码</label>
								    <table>
										<tr>
											<td>
												 <div class="col-sm-8">
												      <select class="form-control" id="oldcbCardholderNo"  name="oldcbCardholderNo" readonly="readonly" style="width: 500px"></select>
											    </div>
											</td>
											<td>
										   	 	<span style="color:blue;" id="cardstatus"></span>
											</td>
										</tr>
									</table>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">会员卡余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varbalance" name="varbalance"  readonly="readonly" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="gender" class="col-sm-3 control-label">姓名</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varOld_name" name="varOld_name" readonly="readonly" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">出生日期</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varCb_birthday" name="varCb_birthday" readonly="readonly" style="width: 500px"/>例:19001231表示1900年12月31日
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">移动电话</label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="varOld_mobile" name="varOld_mobile" readonly="readonly" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">客户等级</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="cbCardPrdctGroup" disabled="disabled" name="cbCardPrdctGroup" style="width: 500px" > 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label"><font color="red">*</font>新持卡人号码</label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="cbCardholderNo" name="cbCardholderNo" style="width: 500px"/>
								    	 <input type="hidden" class="form-control" id="varBlock0str" name="varBlock0str" value=""/>
								    	 <input type="hidden" name="trxnCode" value="SUPPL">
								    	 <input type=hidden name="varRn_reason" value="AR">
								    	 <input type=hidden name="varNC_EMERGENCY" value="R">
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label"><font color="red">*</font>客户等级</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="cbCardPrdctGroup1" name="cbCardPrdctGroup1" style="width: 500px" disabled="disabled"> 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label"><font color="red">*</font>押金</label>
								    <div class="col-sm-8">
								   		<select class="form-control" id="yajin" name="yajin" style="width: 500px" > 
									      	 <option value="20" >20</option>
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
	                    	<a type="button" class="btn  btn-primary " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
	                    </div>	                 	
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
			</section>
		
    </div>
</div>

<!-- 160809刘立人，该tag文件实现右上角侧边栏的收缩效果 -->
<tags:control_sidebar/>
      
<!-- 160809刘立人，该tag文件包含一个js脚本，实现侧边栏的收缩效果。该效果做得非常6！ -->
<tags:load_common_js/>
<script type="text/javascript">
	
// 读取身份证:获取身份证、出生日期
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
	var s=CLOSS.oldcbCardholderNo;
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
				changeCardNo(CLOSS.oldcbCardholderNo.value); // 旧持卡人号码
			}
		}
	 });
}
	
//挂失卡片信息
function changeCardNo(val){
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
				alert("没有找到卡号记录！");
				return;
			}else{
				var res=data.value;
				document.getElementById("cardstatus").innerHTML=res[7];
				CLOSS.varbalance.value = res[8];
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
		return cardno.substr(10);
	}else {
		return cardno;
	}
}


//提交
$("#addButton").click(function(){
  // 旧持卡号码
  var cardNo=document.CLOSS.oldcbCardholderNo.value;
  if(cardNo==""){
	 alert("旧持卡人号码不能为空!"); 
	 return;
  }
  //押金
  var yajin=document.CLOSS.yajin.value;
  if(null==yajin|| yajin==""){
	  alert("押金不能为空!");
	  return;
  }
  //0块
  if(mt_block0==null || mt_block0==""){
	  if(readBlock0()==null){
			return;
	  }
  }
  
  var oldCardNo=document.getElementsByName("oldcbCardholderNo")[0].value;
  var newCardNo=document.getElementsByName("cbCardholderNo")[0].value;
  alert("读出1: " + oldCardNo);
  alert("读出2: " + newCardNo);
  //挂失补卡前先检查是否有挂失操作
  $.ajax({
	type : "POST",
	url : "${ctx}/CardSupplement/doCheck",
	dataType : "json",
	data : {
		cardNo : oldCardNo
	},
	success : function(data) {
		if (failureProcess("${ctx}", data)) {
			return;
		}
		if(data.value=="1"){
			if(newCardNo!=""){
				newCardNo="<%=Constants.baseBIN%>"+newCardNo;	
			}else{
				newCardNo="";
			}
			//checkCardReplace(oldCardNo,newCardNo); //好像没啥用
			if(confirm("确定提交吗")){
				blankCheck(); //验证卡密码
				document.getElementById("varBlock0str").value=mt_block0;
				doCheckerApprove(oldCardNo,newCardNo);
			}
		}
	}
 });
});


//检查可否挂失补卡
function checkCardReplace(oldCardNo,newCardNo){
	$.ajax({
		type : "POST",
		url : "${ctx}/CardSupplement/checkCardReplace",
		dataType : "json",
		data : {
			oldCardNo : oldCardNo,
			newCardNo : newCardNo
		},
		success : function(data) {
			if (failureProcess("${ctx}", data)) {
				return;
			}
		}
	 });	
}

//挂失补卡提交
function doCheckerApprove(oldCardNo,newCardNo){
	alert("oldCardNo: " + oldCardNo);
	alert("newCardNo: " + newCardNo);
	//新卡客户等级
	var cbPrdct1=document.CLOSS.cbCardPrdctGroup1.value;
	//押金
	var yajin=document.CLOSS.yajin.value;
	//varBlock0str
	var varBlock0str=document.CLOSS.varBlock0str.value;
	//trxnCode
	var trxnCode=document.CLOSS.trxnCode.value;
	//varRn_reason
	var varRn_reason=document.CLOSS.varRn_reason.value;
	//varNC_EMERGENCY
	var varNC_EMERGENCY=document.CLOSS.varNC_EMERGENCY.value;
	
	$.ajax({
		type : "POST",
		url : "${ctx}/CardSupplement/doCheckerApprove",
		dataType : "json",
		data : {
			oldCardNo : oldCardNo,
			newCardNo : newCardNo,
			cbPrdct1  : cbPrdct1,
			yajin : yajin,
			varBlock0str : varBlock0str, 
			trxnCode : trxnCode,
			varRn_reason : varRn_reason,
			varNC_EMERGENCY : varNC_EMERGENCY
		},
		success : function(data) {
			if (failureProcess("${ctx}", data)) {
				return;
			}
			if (data.status == "OK") {
				firstWrite(data.value);
				alert("挂失补卡成功");
			}
		}
	 });
}

</script>
    
</body>
</html>
