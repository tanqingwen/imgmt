<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 现场购票</title>
    <tags:head_common_content/>
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
          <h1>现场购票</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">现场购票</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->               
                <form  id="ticketfrom" name="ticketfrom" class="form-horizontal" >
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
							      		<input class="ticket-type-text"  id='ticket_type' name ="ticketType" value="" title="不能为空" style="text-indent:10px;width:100%;height:34px;line-height:40px;display:block; border:1px solid lightblue; margin:0; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
                                		<ul class="all-ticket" >
	                                		<c:forEach var="tkType" items="${tkTypeList}">
							      				<li class="ticket-li"><input class="ttt" id="varTk_ticket_type" name="ttt" type="checkbox" value="${tkType.ttTypeId }" style="width:20px;height:20px;margin-top:8px;"><span class="ticket-info" ><i>${tkType.ttTypeId }--${tkType.ttTypeDesc }</i> - 价位:<i>${tkType.ttListPrice }</i></span></li>
							      			</c:forEach>
                               			</ul>
                            		</div>
								</div>
								<div class="form-group" style="display:none;" id="card-lx">
								    <label for="specialCertificate" class="col-sm-3 control-label">特殊证件<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="specialCertificate" name="specialCertificate">
							  				<option>军人证</option>
							  				<option>残旧证</option>
							  			</select>
								    </div>
								</div>
								<div class="form-group" >
								    <label for="ticketform" class="col-sm-3 control-label">票劵形式<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="ticketform" name="ticketform" class="card-style">
							  				<option value="11" id="hidecar"  >无卡</option>
							  				<option value="12" id="showcar"  >有卡</option>
							  			</select>
								    </div>
								</div>
								<div class="form-group" style="display: none;" id="line-number3">
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
								<div class="form-group">
								    <label for="vartkAmount" class="col-sm-3 control-label">票劵金额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="vartkAmount" name="vartkAmount" value="0" />
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="amount" class="col-sm-3 control-label">预存金额<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="amount" name="amount" title="不能为空" value="" onblur="changetotalAmountPaid()"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="varTkPaperNo" class="col-sm-3 control-label">购买数量<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="varTkPaperNo" name="varTkPaperNo" value="1" />
								    </div>
								</div>
								<div class="form-group" style="display:none;" id="card-lx2">
								    <label for="specialCertificateNumber" class="col-sm-3 control-label">特殊证件号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="specialCertificateNumber" name="specialCertificateNumber" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="varoldPrdgrp" class="col-sm-3 control-label">客户等级<font color="red">*</font></label>
								    <div class="col-sm-8">
							  			<select class="form-control"  id="varoldPrdgrp"  name="varoldPrdgrp" >
	                                		<c:forEach var="prdGrp" items="${prdGrpList}">
					      	 					<option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
					      					</c:forEach>
                            			</select>
								    </div>
								</div>
								<div class="form-group" style="display: none;" id="line-number4">
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
								<div class="form-group">
								    <label for="totalAmountPaid" class="col-sm-3 control-label">支付总额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="totalAmountPaid" name="totalAmountPaid" value="" />
								    <input type="hidden" name="funcReturn"/>
								    <input type="hidden" name="rejcode"/>
								    <input type="hidden" name="rejcodeExplain"/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="btn-group">
  							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   							 	结算 <span class="caret"></span>
  							</button>
 								 <ul class="dropdown-menu">
								    <li><a href="javascript:void(0);" onclick = "xianjin()">现金结算</a></li>
								    <li><a href="javascript:void(0);" onclick = "tonglianpay()">微信，支付宝</a></li>
								    <li><a href="javascript:void(0);" onclick = "demo()">刷卡支付</a></li>
								  </ul>
							</div>
						<a type="button" class="btn btn-default " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
							<c:if test="${app:checkPermission('CART_SHOW')}">
								<a type="button" class="btn btn-default " href="${ctx }/cpticket/cart_show"><i class="glyphicon glyphicon-chevron-left" ></i> 查看购物车</a>
							</c:if>
						<div class="pull-right">
							<button  class="btn btn-info "  onclick = "tianjiagouwuche()"><i class="fa fa-plus"></i></i> 添加购物车</a>	
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
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	$(document).ready(function(){
		
		$('#ticketfrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
   				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh' 
 			},
 			fields: {
 				 mobile: {
					validators: {
						notEmpty: {
							message: '手机号不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 11,
							message: '手机号无效不能超过11个字符'       
							},
						regexp: {
	 						regexp: /^1[34578]\d{9}$/,
	 						message: '请输入正确的手机号码'
	 					},
					}
 				}, 
 				amount: {
 					validators: {
 						notEmpty: {
							message: '预存金额不能为空'                  
						},
 						stringLength: {
 							min: 0,
 							max: 6,
 							message: '预存金额错误不能超过6个字符'       
 							},
 						regexp: {
 	 						regexp: /^[0-9]\d*$/,
 	 						message: '请输入正确的预存金额'
 	 					},
 					}
 					
 				},
 				ticketType: {
 					validators: {
 						notEmpty: {
							message: '票劵种类不能为空'
							}
 					}
 				},
 				varTkPaperNo: {
 					validators: {
 						notEmpty: {
							message: '购买数量不能为空'
							}
 					}
 				},
 				specialCertificate: {
 					validators: {
 						notEmpty: {
							message: '特殊证件不能为空'
							}
 					}
 				},
 				specialCertificateNumber: {
 					validators:{
 						notEmpty: {
							message: '特殊证件号不能为空'
							}
 					}
 				},
 				
 				varoldPrdgrp: {
 					validators: {
 						notEmpty: {
							message: '客户等级不能为空'
							}
 					}
 				},
 				CbRwdsAccno: {
 					validators: {
 						notEmpty: {
							message: '卡流水号不能为空'
						}
 					}
 				},
 				cbCardholderNo: {
 					validators: {
 						notEmpty: {
							message: '持卡号码不能为空'
						}
 					}
 				},
 				cbIdType: {
 					validators: {
 						notEmpty: {
							message: '证件类型不能为空'
						}
 					}
 				},
 				idNo: {
 					validators:{
 						notEmpty: {
							message: '证件号不能为空'
						},
 						regexp: {
	 						regexp: /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/,
	 						message: '请输入正确的身份证号码'
	 					}
 					}
 				},
 				uname: {
 					validators:{
 						notEmpty: {
							message: '证件姓名不能为空'
						},
 						regexp: {
	 						regexp: /^[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*$/,
	 						message: '请输入正确姓名'
	 					}
 					}
 				},
 				birthday: {
 					validators:{
 						notEmpty: {
							message: '出生日期不能为空'
						},
						stringLength: {
 							min: 0,
 							max: 8,
 							message: '出生日期不能超过8个字符'       
 							},
 						regexp: {
	 						regexp: /\d{8}$/,
	 						message: '请输入正确的出生日期'
	 					}
 					}
 				},
 				vartkAmount: {
 					validators:{
 						notEmpty: {
							message: '票劵金额不能为空'
						},
 						
 					}
 				},
 				totalAmountPaid: {
 					validators:{
 						notEmpty: {
							message: '支付金额不能为空'
						},
 					}
 				}
 			}
   		});
   		
	});
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
					kamianhao(cardNo);
					key2str=p[0];
					key3str=p[1];
					key6str=p[2];
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
				$("#CbRwdsAccno").val(data.value);
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
	//票劵金额计算
	function changetotalAmountPaid() {
		var amount = $("#amount").val()
		var vartkAmount = $("#vartkAmount").val()
		if (amount == "") {
			$("#amount").val(0);
		}
		if (vartkAmount == "") {
			$("#vartkAmount").val(0);
		}
		$("#totalAmountPaid").val(parseInt(vartkAmount)+ parseInt(amount));
	}
	//票劵金额计算
	function getTkPrice() {
		var checkboxes = document.getElementsByName("ttt");
		var chestr = "";
		for (i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				chestr += checkboxes[i].value + ",";
				if ("" == chestr) {
					$("#vartkAmount").val(0);
					$("#vartkAmount").html('');
					changetotalAmountPaid();
					return;
				}
			}
		}
		

		var old_prdgrp = $("#varoldPrdgrp").val();
		if (null == old_prdgrp || old_prdgrp == "") {
			for (i = 0; i < checkboxes.length; i++) {
				checkboxes[i].checked = false;
			}
			return;
		}
		TkpriceInf(chestr, $("#varoldPrdgrp").val(),$("#varTkPaperNo").val());
	}
    
    
    //票劵类别计算公式
	function TkpriceInf(chestr, prodct, num) {
		$.ajax({
			type : "POST",
			url : "${ctx}/cpticket/tkpriceInf",
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
				
				$("#vartkAmount").val(Math.round(data.value));
				changetotalAmountPaid();
			}
		});

	}
    //获取选择票劵ID

    
    $(function(){
    	var chk_value =[];     	  
    	$(".ticket-li").on('click',function(){
    	chk_value=[];
    	$('input[name="ttt"]:checked').each(function(){
    	chk_value.push($(this).siblings('.ticket-info').find('i').html()); 
    	getTkPrice();
    });
    	chkvalue=[];
    	$('input[name="ttt"]:checked').each(function(){
    	chkvalue.push($(this).val()); 
    	/* console.log(chkvalue); */
    });
    $(".ticket-type-text").text(chk_value);
    $(".ticket-type-text").val(chkvalue); 
   	console.log( $(".ticket-type-text").val());
    })
    $("#ticketform").change(function(){
        if($("#ticketform").val()==12){
        	$("#line-number3").css("display","block");
        	$("#line-number4").css("display","block");
        	/* $("#havemoney").html("现金收款");
       	 	$("#nomoney").html("非现金收款"); */
        }else{
            $("#line-number3").css("display","none");
            $("#line-number4").css("display","none");
            /* $("#havemoney").html("现金收款制卡").css("width","120px");
            $("#nomoney").html("现金收款制卡").css("width","120px"); */
        }
    });
    	
	$("input[value=1201]").change(function(){
    	if($(this).is(':checked')){
    		$("#card-lx").css('display','block');
    		$("#card-lx2").css('display','block');
    	}else{
    	    $("#card-lx").css('display','none');
    	    $("#card-lx2").css('display','none');
    	}
    })     
    });
    $('.dropdown-toggle').dropdown()
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
		
		$("#ticket-p").hover(function(){
			$(".all-ticket").show();
		},function(){
			$(".all-ticket").hide();
		}
		)
	});
	function cash_payment(){
		var mobile = $("#mobile").val();	//手机号
		var amount = $("#amount").val();	//预存金额
		var ticketType =$(".ticket-type-text").val();	//票劵ID
		var varTkPaperNo = $("#varTkPaperNo").val();		//购买数量
		var ticketform = $("#ticketform").val();				//票劵形式
		var varoldPrdgrp = $("#varoldPrdgrp").val();			//客户等级
		var CbRwdsAccno = $("#CbRwdsAccno").val();				//卡流水号
		var cbCardholderNo = $("#cbCardholderNo").val();		//持卡号码
		var cbIdType = $("#cbIdType").val();					//证件类型
		var idNo = $("#idNo").val();							//证件号
		var uname = $("#uname").val();							//证件名
		var birthday = $("#birthday").val();					//出生日期
		var Address = $("#Address").val();						//出生日期
		var vartkAmount = $("#vartkAmount").val();				//票劵金额
		var totalAmountPaid = $("#totalAmountPaid").val();		//支付总额
		
		var json ='[{"mobile":"'+mobile+'","amount":"'+amount+'","ticketType":"'+ticketType+'","varTkPaperNo":"'+varTkPaperNo+'"';
		json +=',"ticketform":"'+ticketform+'","varoldPrdgrp":"'+varoldPrdgrp+'","CbRwdsAccno":"'+CbRwdsAccno+'","cbCardholderNo":"'+cbCardholderNo+'","cbIdType":"'+cbIdType+'"'
		json +=',"idNo":"'+idNo+'","uname":"'+uname+'","birthday":"'+birthday+'","Address":"'+Address+'","vartkAmount":"'+vartkAmount+'","totalAmountPaid":"'+totalAmountPaid+'"}]'
		console.log(json);
		if(!confirm("确认提交?")){
			  return;
		};
		$.ajax({
			type : "POST",
			url : "${ctx}/cpticket/Cash_ticket",
			dataType : "json",
			data : {
				data : json,
			},
			
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return ;
				}
		
			}
		});
	}
	
	function demo(){
		var request = new   ActiveXObject("ALLINPAY.RequestData");
		var response = new ActiveXObject("ALLINPAY.ResponseData");
		var mis = new ActiveXObject("ALLINPAY.MisPos");
		request.PutValue("CardType","01");
		request.PutValue("TransType","02");
		request.PutValue("Amount","0.01");

		var result = mis.TransProcess(request,response);
		ticketfrom.funcReturn.value = result;
		ticketfrom.rejcode.value=response.GetValue("Rejcode");
		ticketfrom.rejcodeExplain.value=response.GetValue("RejCodeExplain"); 
		delete request;
		delete response;
		delete mis;
		CollectGarbage();
		if(ticketfrom.funcReturn.value==0 && ticketfrom.rejcodeExplain.value=="交易成功"){
			xianjin();
		}else{
			alert(ticketfrom.rejcodeExplain.value);
		}
		
	}
	
	function xianjin(){
		document.ticketfrom.action="/cpticket/Cash_ticket"; 
      	document.ticketfrom.submit();
	}
	function tianjiagouwuche(){
		document.ticketfrom.action="/cpticket/cart_add"; 
      	document.ticketfrom.submit();
	}
	function tonglianpay(){
		document.ticketfrom.action="/cpticket/shuaka"; 
      	document.ticketfrom.submit();
	}
	
    </script>
  </body>
</html>
