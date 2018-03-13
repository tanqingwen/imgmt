<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 现场购票作业</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${assets}/datepicker/window-ticket.css" />
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
    <style type="text/css">
    	.stuff-body{
    	width:100%;
    	min-height:800px;
    	height:100%;
    	background:#d9dee1;
    	padding:50px 0; 
    }
      .stuff-add{
      	width:1000px;
      	margin:50px auto;
      }
      .stuff-add .row{
      	margin:30px 0;
      }
      .stuff-add .col-md-2{
      	color:#35353e;
      	font-family: "微软雅黑";
      	line-height: 43px;
      	text-align: right;
      	padding-right:20px;
      	width:110px;
      }
      .stuff-add .col-md-8 input{
      	width:341px;
      	height:40px;
      	line-height:40px;
      	display:inline-block;
      	border-radius:5px;
      }
      .stuff-add .col-md-8 select,option{
      	width:341px;
      	height:43px;
      	text-indent:10px;
      	font-size: 14px;
      	color:#70707a;
      	outline:none;
      	border-radius:5px;
      }
      .add-btn{
      	width:500px;
      	height:40px;
      	margin:100px auto 0;
      }
      .add-btn .col-md-8{
      	width:112px;height:43px;text-align: center;line-height:43px;font-size:18px;color:white;border-radius:5px;cursor: pointer;
      	margin:0 20px;
      }
      .ticket-info i{
      font-style:normal;
      }
    </style>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
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
          <h1>现场购票作业</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">现场购票作业</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
                <form  id="ticketfrom"  class="form-horizontal" method="post" action="${ctx }/staff/add">
                	<div class="stuff-body">
						<div class="stuff-add">
							<div class="row">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		移动电话
							  	</div>
							  	<div class="col-md-8">
							  		<input type="text" class="form-control" id="mobile" name="mobile" placeholder="请输入电话"/>
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2">
							  		预存金额
							  	</div>
							  	<div class="col-md-8">
							  		<input type="text"  id="amount" name="amount" placeholder="请输入预存金额"/>
							  	</div>
							  </div>
							</div>
							
							
							<div class="row">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		票种
							  	</div>
							  	<div class="col-md-8">
							  		<div class="ticket-type" style="width:341px;height:43px;position:relative;left:7px;">
                                		<p class="ticket-type-text" name='varTk_ticket_type' id='varTk_ticket_type'>请选择</p>
                                		<ul class="all-ticket" >
	                                		<c:forEach var="tkType" items="${tkTypeList}">
							      				<li class="ticket-li"><input class="ttt" name="ttt" type="checkbox" value="${tkType.ttTypeId }" style="width:15px;height:15px;"><span class="ticket-info" ><i>${tkType.ttTypeDesc }</i> - 价位:<i>${tkType.ttListPrice }</i>  <fmt:formatNumber value="${tkType.ttListPrice }" pattern="0"/></span></li>
							      			</c:forEach>
                               			</ul>
                            		</div>
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2">
							  		购买数量
							  	</div>
							  	<div class="col-md-8">
                            		<input type="text" readonly value="1" id="varTk_paper_no" name="varTk_paper_no" class="content-ticket"/>
							  	</div>
							  </div>
							</div>
							
							<div class="row" style="display:none;" id="card-lx">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		特殊证件类型
							  	</div>
							  	<div class="col-md-8">
							  		<select>
							  			<option>军人证</option>
							  			<option>残旧证</option>
							  		</select>
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2">
							  		特殊证件号码
							  	</div>
							  	<div class="col-md-8">
                            		<input type="text"  value="1" id="1" name="1" class="content-ticket"/>
							  	</div>
							  </div>
							</div>
							
							
							<div class="row">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		票券形式
							  	</div>
							  	<div class="col-md-8">
							  		<select id="ticketform" name="ticketform" class="card-style">
							  			<option value="1" id="hidecar"  >无卡</option>
							  			<option value="0" id="showcar"  >有卡</option>
							  		</select>
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2">
							  		客户等级
							  	</div>
							  	<div class="col-md-8">
							  		<select  id="varOld_prdgrp"  name="varOld_prdgrp" readonly="readonly" onclick="vena()" >
                                		<c:forEach var="prdGrp" items="${prdGrpList}">
				      	 					<option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
				      					</c:forEach>
                            		</select>
							  	</div>
							  </div>
							</div>
							<!--票券形式切换有卡栏-->
							<div class="row" style="display: none;" id="line-number">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		卡流水号
							  	</div>
							  	<div class="col-md-8">
							  		<input type="text" />
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2">
							  		持卡人号码
							  	</div>
							  	 	<div class="col-md-8"><input type="text" id="cbCardholderNo" name="cbCardholderNo"  style="text-indent:10px;width:220px;height:43px;float:left;display: inline-block;"/></div>
							  	<div class="col-md-1"><span style="background:#64b521;width:80px;height:43px;line-height:43px;text-align:center;color:white;display:inline-block;margin-left:10px;">读证件号码</span></div>
							  </div>
							</div>
							<div class="row">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		证件类型
							  	</div>
							  	<div class="col-md-8">
							  		<select id="cbIdType"  name="cbIdType"> 
								<c:forEach var="idType" items="${idTypeList}">
									<option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
						   		</c:forEach>
							</select>
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2">
							  		证件号码
							  	</div>
							  	
							  		<!--<input type="text" placeholder="请输入证件号码" style="display:inline-block;width:150px; height:43px;float:left;"/>-->
							  	<div class="col-md-8"><input type="text" id="idNo" name="idNo"  style="text-indent:10px;width:220px;height:43px;float:left;display: inline-block;"/></div>
							  	<div class="col-md-1"><span style="background:#64b521;width:80px;height:43px;line-height:43px;text-align:center;color:white;display:inline-block;margin-left:10px;">读身份证</span></div>
							  
							  </div>
							</div>
							
							<div class="row">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		姓名
							  	</div>
							  	<div class="col-md-8">
							  		<input type="text" id="uname" name="uname" placeholder="请输入姓名" />
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2">
							  		出生日期
							  	</div>
							  	<div class="col-md-8">
							  		<input type="text" id="birthday" name="birthday"  placeholder="例：19901231   表示1990年12月31日" />
							  	</div>
							  </div>
							</div>
		
							<div class="row">
							  <div class="col-md-6">
							  	<div class="col-md-2">
							  		票券金额
							  	</div>
							  	<div class="col-md-8">
							  		<input type="text" id="varTk_amount" name="varTk_amount" value=""  />
							  	</div>
							  </div>
							 <div class="col-md-6">
							  	<div class="col-md-2" style="color:Red;font-size:18px;">
							  		支付总金额
							  	</div>
							  	<div class="col-md-8">
							  		<input type="text"  value="0" id="totalAmountPaid" name="totalAmountPaid" readonly class="content-ticket"/>
							  	</div>
							  </div>
							</div>
							<!--提交按钮-->
							<div class="add-btn">
								<div class="col-md-8" style="background:#ed6826;">
									加入购物车
								</div>
								
								<div class="col-md-8" style="background:#64b521;" id="havemoney" onclick="cash_payment()">
         							 现金收款
        						</div>
        
        						<div class="col-md-8" style="background:#64b521;" id="nomoney">
          							非现金收款
        						</div>
							</div>
						</div>
					</div>
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
 					message: '请填写正确的手机号规则',
					validators: {
						notEmpty: {
							message: '手机号不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 11,
							message: '金额不能超过11位'       
						}, 
						regexp: {
	 						regexp:  /^1[34578]\d{9}$/,
	 						message: '请填写正确的手机号规则'
	 					}
					}
 				},
 				amount: {
 					message: '请填写正确的预存金额规则',
					validators: {
						notEmpty: {
							message: '预存金额不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 6,
							message: '金额不能超过6位'       
						}, 
						regexp: {
	 						regexp: /^(0|[1-9][0-9]{0,6})$/,
	 						message: '请填写正确的规则金额'
	 					}
					}
 				}
 					
 			}
   		});
   		
	});
    
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
				parseInt(varTk_amount)+ parseInt(amount) );
	}
	function getTkPrice() {
		chestrflag = false;
		var checkboxes = document.getElementsByName("ttt");
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
				ticketfrom.varTk_amount.value = Math.round(data.value);
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
   	/* $("#varTk_ticket_type").val(chk_value); */
    $("#varTk_ticket_type").text(chk_value);
    	     
  
    	         
    })
    $(".card-style").change(function(){
        if($(".card-style").val()==1){
        	$("#line-number").css("display","none");
        	$("#havemoney").html("现金收款");
       	 	$("#nomoney").html("非现金收款");
        }else{
            $("#line-number").css("display","block");
            $("#havemoney").html("现金收款制卡").css("width","120px");
            $("#nomoney").html("现金收款制卡").css("width","120px");
        }
    });
	$("input[value=1201]").change(function(){
    	if($(this).is(':checked')){
    		$("#card-lx").css('display','block');
    	}else{
    	    $("#card-lx").css('display','none');
    	}
    })     
    });
    function cash_payment() {
		var mobile=$("#mobile").val();
		var idNo = $("#idNo").val();
		var uname = $("#uname").val();
		var amount=$("#amount").val();
		var ticketform=$("#ticketform").val();
		var varTk_paper_no=$("#varTk_paper_no").val();
		var varTk_ticket_type=$("#varTk_ticket_type").val();
		var idType=$("#idType").val();
		var varOld_prdgrp=$("#varOld_prdgrp").val();
		var birthday=$("#birthday").val();
		var varTk_amount=$("#varTk_amount").val();
		var totalAmountPaid=$("#totalAmountPaid").val();
		if("" == mobile){
			alert("移动电话不能为空!");
			return ;
		};
		if(!$("input[type='checkbox']").is(':checked')){
			alert("请选择票劵ID");
			return;
		};
		 
		if("" == uname){
			alert("姓名不能为空!");
			return;
		};
		if("" == idNo){
			alert("证件号不能为空!");
			return;
		};
		if(1 == ticketform){
			if("" == cbCardholderNo){
				alert("持卡人号码不能为空");
				return;
			}
			if(!(/^1[34578]\d{9}$/.test(mobile)).test(cbCardholderNo)){
				alert("持卡人号码有误，请重输");
				return;
			}
		};
		if("" == prProdctGroup){
			alert("客户等级不能为空！");
		};
		if("" == birthday){
			alert("出生日期不能为空！");
			return;
		};
		if("" == varTk_amount){
			alert("票劵金额不能为空！");
			return;
		};
		if(null == totalAmountPaid){
			alert("总金额不能为空!");
			return;
		};
		if(!(/^1[34578]\d{9}$/.test(mobile))){ 
		    alert("手机号码有误，请重填");  
		    return ; 
		}
		if(!(/^[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*$/).test(uname)){
			alert("姓名有误，请重填");
			return ;
		}
		if(!(/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/).test(idNo)){
			alert("证件号有误，请重填");
			return ;
		}
		
		if(!confirm("确认提交?")){
			  return;
		};
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
				totalAmountPaid:totalAmountPaid//总金额
			},
			
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return ;
				}
		
			}
		});
	}
    </script>
  </body>
</html>
