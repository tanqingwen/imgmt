<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>综合管理系统 | 实卡激活</title>
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/css/activeCard.css" />
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
	
		<div class="container-fluid">
			<div class="row outer-wrap">
				<div class="tip-img">
					<p>实卡激活</p>
				</div>
				<div class="content">
					<div class="main">
						
						<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
						<form class="form-inline form-horizontal" id="crdtblfrom" name="crdtblfrom" >
							<div class="col-md-12">
							<div class="col-sm-6">
								<div class="form-group">
									<label class="label-holder">实卡流水号:</label>
									<input type="text" id="cbRecommenderNo" name="cbRecommenderNo" value="" class="form-control formConl line-input">
									<input type="hidden" class="form-control" id="varBlock0str" name="varBlock0str" value=""/>
								      <input type="hidden" class="form-control" id="serialCard" name="serialCard" value=""/>
									
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<button type="button" class="btn-size" id="addActive" name="addActive" >实卡激活</button>
								</div>
							</div>
							</div>
							<div class="col-md-12 marginBottom marginTop">							
								<a href="${ctx }/startTreeviewDetail/pwzy" class="form-a" style="margin-left:25px;">&lt;返回</a>
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
    				/* if (failureProcess("${ctx}", data)) {
    					return;
    				} */
    			    firstWrite(data.value);
    				alert("激活成功！");
    				
    			}
    	 }); 
    	 
    });	
    
    </script>
	</body>

</html>