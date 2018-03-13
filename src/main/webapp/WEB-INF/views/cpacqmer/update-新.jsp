<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/layer/skin/layer.css" />
		<title>综合管理系统 | 场馆配置更新</title>
		<link rel="stylesheet" href="${assets }/css/venueAllocationAdd.css" />
		<link rel="stylesheet" href="${assets }/css/index.css" />
		<link rel="stylesheet" href="${assets }/css/multiple-select.css" />
	</head>
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
	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="venue_list"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>场馆配置更新</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
			<li><a href="${ctx }/cpacqmer/list">场馆配置</a></li>
            <li class="active">场馆配置更新</li>
          </ol>
        </section>
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img">
					<p>场馆配置更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">更新表单</h3>
						<form  id="stafffrom"  class="form-horizontal" enctype="multipart/form-data"  method="post" action="${ctx }/cpacqmer/add">
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venuesNum">场馆组编号<span class="star">*</span></label>
											<input class="form-control formConl line-input" type="text" readonly="readonly" id="amGroupId" name="amGroupId" value="${cpAcqmer.amGroupId}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNum">场馆组名称<span class="star">*</span></label>
											<input class="form-control formConl line-input" type="text" name="amUserDefine1" value="${cpAcqmer.amUserDefine1 }" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="ticket_type" class="col-sm-3 control-label">场馆编号<font color="red">*</font></label>
								    <div class="col-sm-9" id="ticket-p">
							      		<input class="form-control formConl line-input ticket-type-text"  id='amMerchantId' name ="amMerchantId" value="${cpAcqmer.amMerchantId }" value="" title="不能为空" style="text-indent:10px;width:100%;height:34px;line-height:40px;display:block; border:1px solid lightblue; margin:0; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
                                		<ul class="all-ticket" >
	                                		<c:forEach var="item" items="${cpMermsts}">
							      				<li class="ticket-li"><input class="ttt" id="varTk_ticket_type" name="ttt" type="checkbox" value="${item.mmMerchantNo }" style="width:20px;height:20px;margin-top:8px;"><span class="ticket-info" ><i>${item.mmMerchantNo }-${item.mmBizName }</i></span></li>
							      			</c:forEach>
                               			</ul>
                            		</div>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="DuplicateEntry">重复入园标志<span class="star">*</span></label>
											<select class="DuplicateEntry" id="amRecycleType" name="amRecycleType">
												<option value='Y'>Y-是</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="VenueMaster clearfix">
								<div class="col-md-12">
									<div class="col-md-2 text-right" style="width: 110px;">场馆主图<span class="star">*</span></div>
									<div class="col-md-10">
										<div class="z_photo upimg-div clear">
											<img alt="${cpAcqmer.amUserDefine1 }" src="${assets }/${cpAcqmer.amUserDefine0}" class="add-img">
										</div>
									</div>
								</div>
							</div>
							<div class="VenueMaster clearfix">
								<div class="col-md-12">
									<div class="col-md-2 text-right" style="width: 110px;">场馆详细图<span class="star">*</span></div>
									<div class="col-md-10">
										<div class="z_photo upimg-div clear">
											<c:forEach var="item" items="${list}">
												<img src="${assets }/yanwu/images/${item}" class="add-img">
										</c:forEach>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" name="tag" id="tag" value="">
                             <input type="hidden" name="tags" id="tags" value="">
							<div class="col-md-12 AddBottom">
								<a href="javascript:history.go(-1)"><span class="">&lt;返回</span></a>
								<button type="submit" id="addButton" class="btn btnAdd btn-size">添加</button>
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
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script type="text/javascript">
    
    $("#ticket-p").hover(function(){
		$(".all-ticket").show();
 	},function(){
		$(".all-ticket").hide();
 	}
 	);
    
	$(function(){
	
		var chk_value =[];     	  
		$(".ticket-li").on('click',function(){
		chk_value=[];
		$('input[name="ttt"]:checked').each(function(){
			chk_value.push($(this).siblings('.ticket-info').find('i').html()); 
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
		
		var amMerchantId = $("#amMerchantId").val();
		var amspilt = new Array();
		amspilt=amMerchantId.split(",");
		var r = document.getElementsByName("ttt");
		for(var i=0;i<r.length;i++){
			for(var j=0;j<amspilt.length;j++){
				if(r[i].value == amspilt[j]){
					r[i].checked=true;  
				}
			}
		}
	});

   	
	 function openFile(){
    	 document.getElementById("file0").click(); 
    	 $("#file0").change(function(){
    		var objUrl = getObjectURL(this.files[0]) ;
    		console.log("objUrl = "+objUrl) ;
    		if (objUrl) 
    		{
    		    $("#img0").attr("src", objUrl);
    		    $("#img0").removeClass("hide");
    		}
    	 });
    	//建立一個可存取到該file的url
    	function getObjectURL(file) 
    	{
    	var url = null ;
    	if (window.createObjectURL!=undefined) 
    	{ // basic
    	    url = window.createObjectURL(file) ;
    	}
    	else if (window.URL!=undefined) 
    	{
    	    // mozilla(firefox)
    	    url = window.URL.createObjectURL(file) ;
    	} 
    	else if (window.webkitURL!=undefined) {
    	    // webkit or chrome
    	    url = window.webkitURL.createObjectURL(file) ;
    	}
    	return url ;
    	}
    	}
	
	
    </script>

	</body>

</html>