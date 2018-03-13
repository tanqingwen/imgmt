<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 开卡</title>
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
          <h1>开卡</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">票务管理</a></li>
            <li class="active">开卡</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                 
                <form id="crdtblfrom"  class="form-horizontal">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="cbCardholderNo" class="col-sm-3 control-label">持卡人号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbCardholderNo" name="cbCardholderNo" value=""/>
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label">证件类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select class="form-control" id="cbIdType"  name="cbIdType" > 
									      <c:forEach var="idType" items="${idTypeList}">
									      	 <option value="${idType.cbIdType }" >${idType.cbIdType }--${idType.cbIdDesc }</option>
									      </c:forEach>
								    	</select>	
								    </div>
								</div>
								<div class="form-group">
								    <label for="idNo" class="col-sm-3 control-label">身份证号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="idCard" class="form-control" id="idNo" name="idNo" value=""/>
								      <input type="button" id="idcard" name="idcard" onclick="readCard()" value="读卡"/> 
								    </div>
								</div>
								<div class="form-group">
								    <label for="birthday" class="col-sm-3 control-label">出生日期<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="birthday" name="birthday" value=""/>例:19001231表示1900年12月31日
								      <input type="hidden" class="form-control" id="varCb_cust_class" name="varCb_cust_class" value=""/>
								      <input type="hidden" class="form-control" id="varBlock0str" name="varBlock0str" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="mobile" class="col-sm-3 control-label">移动电话<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="mobile" name="mobile" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="amount" class="col-sm-3 control-label">预存金额<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="amount" name="amount" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="uname" class="col-sm-3 control-label">姓名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="uname" name="uname" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="prProdctGroup" class="col-sm-3 control-label">产品组<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="prProdctGroup"  name="prProdctGroup" > 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="deposit" class="col-sm-3 control-label">押金<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="deposit" name="deposit" value=""/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
							<button type="button" class="btn btn-sm btn-default btn-flat" id="addButton">提交</button>
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<!--  
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/staff/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                    	-->
	                    	<a type="button" class="btn btn-default" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
	
	$("#addButton").click(function(){
	 // if(mt_block0==null || mt_block0==""){
	//		if(readBlock0()==null){
		//		return;
		  //	}
	 // }
		//blankCheck();
		document.getElementById("varBlock0str").value="3";
		$.ajax({
			type : "POST",
			url : "${ctx}/crdtbl/openCard",
			dataType : "json",
			data : {
				cbCardholderNo : $("#cbCardholderNo").val(),
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
				alert("换卡成功！");
				//firstWrite(data.value);
			}
		});
	});
	

	//
	$("#birthday").change(function(){
		$.ajax({
			type: "POST",
			url : "${ctx}/crdtbl/getAge",
			dataType:"json",
			data : {
				birthday : $("#birthday").val()
			},
			success : function(data){
				var age=data.value;
				if(age<=13){
					$("#varCb_cust_class").val("1105");
				}else if(age>13&&age<=18){
					$("#varCb_cust_class").val("1103");
				}else{
					$("#varCb_cust_class").val("1104");
				}
			}
		});
	});
	
	
	//读取身份证:获取身份证号码、出生日期
	function readCard(){
  		var strReadResult=CVR_IDCard.ReadCard();
		if (strReadResult == "0") {
				$("#idNo").val(CVR_IDCard.CardNo);
				//证件类型1-身份证（自动获取身份证）
				if(crdtblfrom.cbIdType.value=="1"){
					$("#birthday").val($("#idNo").val().substr(6,8));
				}
		}else {
			alert("读卡失败,"+strReadResult);
		}
	}
	
	
    </script>
    
  </body>
</html>
