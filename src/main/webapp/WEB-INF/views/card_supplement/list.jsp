<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 挂失补票</title>
    <!-- 
    	补卡操作需要在服务窗由工作人员完成
		会员申请补卡时，需出示身份证件，与原卡证件相符时，才可进行补卡。
		补卡操作首先生成新卡，然后用新卡号更新卡-会员对照表和门票表中挂失卡的卡号。
     -->
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="profile"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>挂失补票</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">票务管理</a></li>
            <li class="active">挂失补票</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form id="thisfrom" class="form-horizontal" method="post" >
                	<div class="box-body">
                		<div class="col-sm-8">
                			<div class="row">
	                			<div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label">证件类型</label>
								    <div class="col-sm-8">
								      <select class="form-control getCard" id="cbIdType"  name="cbIdType" style="width: 500px" > 
									      <c:forEach var="idType" items="${idTypeList}">
									      	 <option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
									      </c:forEach>
								    	</select>	
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">身份证号码</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control getCard" id="cbIdno" name="cbIdno" value="" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label">旧持卡人号码<font color="red">*</font></label>
								    <table>
										<tr>
											<td>
												 <div class="col-sm-8">
											      <select class="form-control" id="cbCardholderNo"  name="cbCardholderNo" style="width: 500px"> 
											      </select>
											    </div>
											</td>
											<td>
										   	 	<span style="color:blue;" id="cardstatus"></span>
											</td>
										</tr>
									</table>
								    <input type="hidden" name="PlasticCd" id="PlasticCd"/>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">会员卡余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbOutstdBal" readonly="readonly" name="cbOutstdBal" value="" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="gender" class="col-sm-3 control-label">姓名</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbEmbossname" readonly="readonly" name="cbEmbossname" value="" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">出生日期</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbSuspendDate" readonly="readonly" name="cbSuspendDate" value="" style="width: 500px"/>例:19001231表示1900年12月31日
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">移动电话</label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="cbSourceCd" readonly="readonly" name="cbSourceCd" value="" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">产品组</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="cbCardPrdctGroup" disabled="disabled" name="cbCardPrdctGroup" style="width: 500px"> 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	<option value="">请选择</option>
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								<!-- 添加一条横线 -->
<!-- 								<hr style="height:1px;border:none;border-top:1px solid #555555;" /> -->
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">新持卡人号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="newCbCardholderNo" name="newCbCardholderNo" value="" style="width: 500px"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">产品组<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="newCbCardPrdctGroup"  name="newCbCardPrdctGroup" style="width: 500px" > 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">押金<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<input type="text" class="form-control" id="cbCvki" name="cbCvki" value="" style="width: 500px"/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
							<button id="addButton" type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 提交</button>	                    	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    $(".getCard").change(function(){    	
    	var cbIdType =$("#cbIdType").val();
    	var cbIdno =$("#cbIdno").val();
    	cbIdType = $.trim(cbIdType);
    	cbIdno = $.trim(cbIdno);
    	if(cbIdType==""||cbIdno==""){
    		return;
    	}
    	$.ajax({
    		type:"POST",
    		url:"${ctx}/blkmlc/show",
    		dataType:"json",
    		data:{
    			cbIdType:cbIdType,
    			cbIdno:cbIdno
    		},
    		success:function(data){
    			$("#cbCardholderNo option").remove();
    			if(data.length>1){
    				alert("这个客户有多张卡");
    			}else if (data.length==0){
    				alert("使用证件信息没有找到对应数据");
    				$("#cbOutstdBal").val("");
    				$("#cbEmbossname").val("");
    				$("#cbSuspendDate").val("");
    				$("#cbSourceCd").val("");
    				$("#cbCardPrdctGroup").val($("#cbCardPrdctGroup option:first").val());
    				$("#newCbCardholderNo").val("");
    				$("#newCbCardPrdctGroup").val($("#newCbCardPrdctGroup option:first").val());
    				$("#cbCvki").val("");
    				$("#cardstatus").css("color","red");
    				$("span#cardstatus").text("请重新输入身份证号码查证!");
    				return false;
    			}
    			for(i in data){
    				$("#cbCardholderNo").append("<option id="+data[i].cbCardholderNo+">" + data[i].cbCardholderNo + "</option>");
    			}
    			getInfo(data[0].cbCardholderNo);
    			getBalance(cbIdno);
    			$("#addButton").attr({"disabled":false});
    		}
    	});
    });
    $("#cbCardholderNo").change(function(){    	
    	var cbIdno =$("#cbIdno").val();
    	cbIdno = $.trim(cbIdno);
    	var cbCardholderNo =$("#cbCardholderNo").val();
    	getInfo(cbCardholderNo);
    	getBalance(cbIdno);
    });
    
	$(document).ready(function(){
		$('#thisfrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'
 			},
 			fields: {
 				newCbCardholderNo: {
 					validators: {
 						notEmpty: {
							message: '新持卡人号码不能为空'
						},
						regexp: {
	                        regexp: /^[0-9]*$/,
	                        message: '新持卡人号码只能是数字'
	                    },
			 			stringLength: {
		                    min: 16,
		                    max: 16,
		                    message: '新持卡人号码长度必须是16位!'
		                }
 					}
 				},
 				cbCvki: {
 					validators: {
 						notEmpty: {
							message: '押金不能为空'
						},
						regexp: {
	                        regexp: /^[0-9]*$/,
	                        message: '押金只能是数字'
	                    }
 					}
 				}
 			}
   		});
	});
	$(function () {
		$("#addButton").attr({"disabled":true});
		$("#addButton").click(function(){
			if($("#PlasticCd").val()!="L"){
			    alert("请检查卡片状态,不能进行此操作!");
			    return false;
			}
			if($("#newCbCardholderNo").val()==""){
			    alert("新持卡人号码不能为空");
			    return false;
			}
			if($("#cbCvki").val()==""){
			    alert("押金不能为空");
			    return false;
			}
			if(!confirm("确认要补卡？")){
				return false;
			}
			$.ajax({
				type : "POST",
				url : "${ctx}/CardSupplement/add",
				dataType : "text",
				data : {
					cbIdType : $("#cbIdType").val(),
					cbIdno : $("#cbIdno").val(),
					oldCbCardholderNo : $("#cbCardholderNo").val(),
					cbOutstdBal : $("#cbOutstdBal").val(),
					cbEmbossname : $("#cbEmbossname").val(),
					cbSuspendDate : $("#cbSuspendDate").val(),
					cbSourceCd : $("#cbSourceCd").val(),
					cbCardPrdctGroup : $("#cbCardPrdctGroup").val(),
					newCbCardholderNo : $("#newCbCardholderNo").val(),
					newCbCardPrdctGroup : $("#newCbCardPrdctGroup").val(),
					cbCvki : $("#cbCvki").val()
				},
				success : function(data) {
					alert(data);
					$("#cbOutstdBal").val("");
					$("#cbEmbossname").val("");
					$("#cbSuspendDate").val("");
					$("#cbSourceCd").val("");
					$("#cbCardPrdctGroup").val($("#cbCardPrdctGroup option:first").val());
					$("#newCbCardholderNo").val("");
					$("#cbCvki").val("");
					$("#newCbCardPrdctGroup").val($("#newCbCardPrdctGroup option:first").val());
					//window.location.reload();
				}
			});
			return false;
		});
	});
	function getInfo(val){
		$.ajax({
			type:"POST",
			url:"/blkmlc/getInfo",
			dataType:"json",
			data:{
				cbCardholderNo:val
			},
			success:function(data){
				$("#cbEmbossname").val(data.cbEmbossname);
				$("#cbCardPrdctGroup").val(data.cbCardPrdctGroup);
				$("#cbSourceCd").val(data.cbSourceCd);
				$("#cbSuspendDate").val(data.cbSuspendDate);
				$("#cbPlasticCd").val(data.cbPlasticCd);
				$("#PlasticCd").val(data.cbPlasticCd);
				$("#cardstatus").css("color","blue");
				if(data.cbPlasticCd==" "){
					$("span#cardstatus").text(data.cbPlasticCd+"-正常卡");
				}else if(data.cbPlasticCd==""){
					$("span#cardstatus").text(data.cbPlasticCd+"-正常卡");
				}else if(data.cbPlasticCd=="A"){
					$("span#cardstatus").text(data.cbPlasticCd+"-正常卡");
				}else if(data.cbPlasticCd=="L"){
					$("span#cardstatus").text(data.cbPlasticCd+"-挂失卡");
				}else if(data.cbPlasticCd=="D"){
					$("span#cardstatus").text(data.cbPlasticCd+"-已退卡");
				}else if(data.cbPlasticCd=="P"){
					$("span#cardstatus").text(data.cbPlasticCd+"-预制卡");
				}
			}
		});
	}
	function getBalance(val){
		$.ajax({
			type:"POST",
			url:"/blkmlc/getBalance",
			dataType:"json",
			data:{
				cbCustomerIdno:val
			},
			success:function(data){
				if(data.hwBalance.toString().indexOf(".")<0){
    				data.hwBalance = data.hwBalance+".000";
    			}
    			$("#cbOutstdBal").val(data.hwBalance);
			}
		});
	}
	
  </script>
  </body>
</html>
