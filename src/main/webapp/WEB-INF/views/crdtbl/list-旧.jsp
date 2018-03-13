<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 实卡激活</title>
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
      <tags:main_sidebar active="card_add"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>实卡激活</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
            <li class="active">实卡激活</li>
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
								    <label for="cbRecommenderNo" class="col-sm-3 control-label"><font color="red">*</font>实卡流水号</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbRecommenderNo" name="cbRecommenderNo" value=""/>
								      <input type="hidden" class="form-control" id="varBlock0str" name="varBlock0str" value=""/>
								      <input type="hidden" class="form-control" id="serialCard" name="serialCard" value=""/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					
					<div class="box-footer">
						<div class="pull-right">
							<button type="button" class="btn  btn-primary " id="addActive" name="addActive" ><i class="fa fa-plus"></i> 实卡激活</button>
							<a type="button" class="btn  btn-primary " href="${ctx }/"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
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
    
	$(document).ready(function(){
		
		$('#crdtblfrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				cbRecommenderNo: {
 					message: '卡流水号无效',
					validators: {
						notEmpty: {
							message: '实卡流水号无效'                  
						},
						stringLength: {
							min: 10,
							max: 10,
							message: '实卡流水号不能小于或超过10个字符'       
						},
					}
 				}
 			}
   		});
	});
    
    
    $("#addActive").click(function(){
    	
    	 var cbRecommenderNo = document.crdtblfrom.cbRecommenderNo.value; // M1卡面流水号
    	 //0块 
    	 mt_block0=null;
    	 //if(mt_block0==null || mt_block0==""){
 			if(readBlock0()==null){
 				return;
 		  	}
 	     //}
    	 blankCheck();
    	 document.getElementById("varBlock0str").value=mt_block0;
    	 document.getElementById("serialCard").value=serialCard;
    	 $.ajax({
    	 		type : "POST",
    			url : "${ctx}/crdtbl/activeCard",
    			dataType : "json",
    			data : {
    				cbRecommenderNo : cbRecommenderNo,
    				cbRwdsAccno : $("#serialCard").val(), //实卡序列号
    				block0str:$("#varBlock0str").val()  // 0扇区0块
    			},
    			success : function(data) {
    				if (failureProcess("${ctx}", data)) {
    					return;
    				}
    			    firstWrite(data.value);
    				alert("激活成功！");
    				
    			}
    	 }); 
    	 
    });	
    
    </script>
    
  </body>
</html>