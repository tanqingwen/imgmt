'<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 批量制卡</title>
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
      <tags:main_sidebar active="batchcard"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>批量制卡</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">批量制卡</li>
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
								    <label for="cbCardholderNo" class="col-sm-3 control-label"><font color="red">*</font>起始卡号</label>
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="startCardNo" name="startCardNo" value="${startCardNo}"/>
								    </div>
								    <font color="red">温馨提示：卡号为35010001+自动生成后8位</font>
								</div>
								<div class="form-group">
								    <label for="idNo" class="col-sm-3 control-label"><font color="red">*</font>制卡数量</label>
								    <div class="col-sm-4">
								      <input type="text" class="form-control" id="number" name="number" value=""/>
								    </div>
								</div>
								<!--  
								<div class="form-group">
								    <label for="prProdctGroup" class="col-sm-3 control-label"><font color="red">*</font>客户等级</label>
								    <div class="col-sm-8">
								    	<select class="form-control" id="prProdctGroup"  name="prProdctGroup" readonly="readonly"> 
									      <c:forEach var="prdGrp" items="${prdGrpList}">
									      	 <option value="${prdGrp.prProdctGroup }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      </c:forEach>
								      	</select>
								    </div>
								</div>
								-->
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
	                </div>
	                <input type="hidden" name="remainingNumber" value="${remainingNumber }" /> 
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
	  var startCardNo=document.crdtblfrom.startCardNo.value;
	  var number=document.crdtblfrom.number.value;
	  var remainingNumber=document.crdtblfrom.remainingNumber.value;
	  if(number==""){
		  alert("制卡数量不能为空!");
		  return;
	  }
	  var prProdctGroup= "1100"; // 默认1100 一般游客
	  if(startCardNo!=""){
		  if(startCardNo.length!=8){
			  alert("持卡人号码为8位!");
			  return;
		  }
	  }
	  if(number!=""){
		  if(number>remainingNumber){
			  alert("制卡数量不能超过："+remainingNumber);
			  return;
		  }
	  }
	  
	  $.ajax({
		type : "POST",
		url : "${ctx}/batchcrdtbl/makeCard",
		dataType : "json",
		data : {
			startCardNo : startCardNo,
			number : number,
			custLevel:prProdctGroup
		},
		success : function(data) {
			if (failureProcess("${ctx}", data)) {
				return;
			}
			if(data.value="OK"){
				alert("批量制卡成功!");
				document.crdtblfrom.startCardNo.value = parseInt(startCardNo)+parseInt(number);
			}
		}
	 });
	});

    </script>
    
  </body>
</html>
