<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 场馆配置更新</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets }/css/newChange.css" />

<style>
</style>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="venue_list" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
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

			<!-- Main content -->
			<section class="content">
				<div class="innerContent">
					<div class="tip-img">
						<p>场馆配置更新</p>
					</div>
					<div class="box box-primary">
						<div class="box-header with-border">
							<h1 class="box-title"
								style="border-bottom: 2px dashed #45a0e0; height: 70px; line-height: 70px; display: block;">更新表单</h1>
						</div>
						<!-- /.box-header -->
						<form id="stafffrom" class="form-horizontal" method="post"
							action="${ctx }/cpacqmer/update">
							<div class="box-body">
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label for="amGroupId" class="col-sm-4 control-label">场馆组编号<font
												color="red">*</font>:
											</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" readonly="readonly"
													id="amGroupId" name="amGroupId"
													value="${cpAcqmer.amGroupId }">
												<%-- <select class="form-control" id="amGroupId"  disabled="disabled">
								      	<c:forEach var="item" items="${cpAcqgrps}">
								     		<option value="${item.alGroupId }" ${item.alGroupId eq cpAcqmer.amGroupId ? 'selected' : ''}>${item.alGroupId }-${item.alDesc }</option>
								     	</c:forEach>
								      </select> --%>
											</div>
										</div>
									</div>

									<%--
								<div class="form-group">
								    <label for="amMerchantId" class="col-sm-3 control-label">场馆编号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" name="amMerchantId" value="${cpAcqmer.amMerchantId }">
								    </div>
								</div>
								--%>
									<div class="col-md-6">
										<div class="form-group">
											<label for="ticket_type" class="col-sm-4 control-label">场馆编号<font
												color="red">*</font>:
											</label>
											<div class="col-sm-8" id="ticket-p">
												<input class="ticket-type-text" id='amMerchantId'
													name="amMerchantId" value="${cpAcqmer.amMerchantId }"
													value=""
													style="text-indent: 10px; width: 100%; height: 34px; line-height: 40px; display: block; border: 1px solid lightblue; margin: 0; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
												<ul class="all-ticket">
													<c:forEach var="item" items="${cpMermsts}">
														<li class="ticket-li" style="white-space: nowrap;"><input
															class="ttt" id="varTk_ticket_type" name="ttt"
															type="checkbox" value="${item.mmMerchantNo }"
															style="width: 20px; height: 20px; margin-top: 8px;"><span
															class="ticket-info"><i>${item.mmMerchantNo }-${item.mmBizName }</i></span></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class=" col-md-12 ">
									<div class="col-md-6">
										<div class="form-group ">
											<label for="amMerchantId" class="col-sm-4 control-label">场馆开馆时间<font
												color="red">*</font>：
											</label>
											<div class="col-sm-8">
												<input class="form-control" type="text" name="amUserDefine3"
													value="${cpAcqmer.amUserDefine3 }" />
											</div>

										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="amMerchantId" class="col-sm-4 control-label">场馆闭馆时间<font
												color="red">*</font>：
											</label>
											<div class="col-sm-8">
												<input class="form-control" type="text" name="amUserDefine4"
													value="${cpAcqmer.amUserDefine4 }" />
											</div>

										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label for="amMerchantId" class="col-sm-4 control-label">场馆组名称<font
												color="red">*</font>:
											</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="amUserDefine1"
													value="${cpAcqmer.amUserDefine1 }">
											</div>
										</div>
									</div>
								</div>
						</form>
						<form method="post" id="form1" enctype="multipart/form-data">
							<div class="col-md-12">
								<!-- <div class="col-md-6"> -->
								<div class="form-group">
									<label for="amMerchantId"
										class="col-md-2 control-label text-left">场馆主图<font
										color="red">*</font></label>
									<div class="col-md-9">
										<%-- <input type="text" class="form-control" name="amUserDefine0" value="${cpAcqmer.amUserDefine0 }"> --%>
										<input type="hidden" name="amGroupId"
											value="${cpAcqmer.amGroupId }">
										<!-- 成功后回显的图片 -->
										<input type="hidden" id="mainFileHidden" name="amUserDefine0"
											value="${cpAcqmer.amUserDefine0 }"> <input
											type="file" value="" name="file0" id="file0"
											multiple="multiple" style="display: none;"
											onchange="updateMainFile('form1')"> <img id="img0"
											alt=""
											src="http://58.246.52.102:3551/assets/changguan/images/${cpAcqmer.amUserDefine0 }"
											onclick="openFile('form1')">
									</div>
								</div>
								<!-- 	</div> -->
							</div>
						</form>
						<input type="hidden" value="${listSize }" id="listSize">
						<div class="col-md-12">
							<div class="form-group" id="fm_detail">
								<label for="amGroupId" class="col-sm-2 control-label">场馆详细图<font
									color="red">*</font></label>
								<div class="col-md-9">
									<c:forEach var="item" items="${list}" varStatus="status">
										<form method="post" id="forms${status.index }"
											enctype="multipart/form-data">
											<input type="hidden" name="amUserDefine"
												value="yanwu/images/${item}">
											<!-- 成功后回显的图片 -->
											<input type="hidden" class="detailFilesPath"
												id="detailFiles${status.index }"
												name="detailFile${status.index }" value="${item }">
											<input type="file" value="" name="files"
												id="files${status.index }" multiple="multiple"
												style="display: none;"
												onchange="updateMainFiles(${status.index })">
											<!--<img id="imgs${status.index}" alt="" src="${assets }/yanwu/images/${item}" onclick="openFiles('forms${status.index }',${status.index })">-->
											<img id="imgs${status.index}" alt=""
												src="http://58.246.52.102:3551/assets/changguan/images/${item}"
												onclick="openFiles('forms${status.index }',${status.index })">

										</form>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-6">
								<%-- <div class="form-group">
									<label for="amRecycleType" class="col-sm-4 control-label">重复入园标志<font
										color="red">*</font></label>
									<div class="col-sm-8">
										<select class="form-control" id="amRecycleType"
											name="amRecycleType">
											<!--
								     	 	<option value='N' ${cpAcqmer.amRecycleType eq 'N' ? 'selected' : ''}>N-否</option>
	          							    -->
											<option value='Y'
												${cpAcqmer.amRecycleType eq 'Y' ? 'selected' : ''}>Y-是</option>
										</select>
									</div>
								</div> --%>
							</div>
						</div>
						<div class="box-footer col-md-12" style="border: none;">
							<div class="col-md-6 text-left">
								<a type="button" class="back"
									style="font-size: 18px; color: #333;"
									href="${ctx }/cpacqmer/list">&lt;返回</a>
							</div>
							<div class="col-md-6 text-right">
								<!--onclick="updateFinal()"  -->
								<button type="button" class="btn btn-info" id="addButton"
									onclick="updateFinal()">更新</button>
							</div>
						</div>
					</div>
					<!-- /.box-footer -->
				</div>
		</div>
	</div>



	<!-- /.box -->
	<!-- /.content -->

	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />

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

    </script>
	<script type="text/javascript">
	//确认是否更换图片
    function openFile(formname){
    	var msg = "是否确认更改场馆主图?"
			if(confirm(msg)== true){
   	 	document.getElementById("file0").click();
    		return true;
		}else{
			return false;
		}
   	 }
	//更换图片后提交到后台
	function updateMainFile(formname){
		var formData = new FormData($("#"+formname)[0]);
 		$.ajax({
			type : "POST",
			url : "${ctx}/cpacqmer/updateImg",
			data : formData,
			async: false,
	        cache: false,
	        contentType: false,
	        processData: false,
			success : function(data){
				if(data.status == 'SUCCESS'){
					//成功之后回显
					$("#img0").attr("src",data.comment+'?'+new Date());
					$("#mainFileHidden").val(data.comment);
				}else{
					console.log(data);
					alert(data.comment);
				}
			}
		});
	}

    function openFiles(formname,index){
    	var msg = "是否确认更改场馆详细图?"
			if(confirm(msg)== true){
    	var file = "files"+index;
    	document.getElementById(file).click();
   			return true;
		}else{
			return false;
		}
   	 }
    //更新图片后提交到后台
    function updateMainFiles(index){
    	var formData = new FormData($("#forms"+index)[0]);
   		$.ajax({
  			type : "POST",
  			url : "${ctx}/cpacqmer/updateImgs",
  			data : formData,
  			async: false,
	        cache: false,
	        contentType: false,
	        processData: false,
  			success : function(data){
  				if(data.status == 'SUCCESS'){
  					$("#imgs"+index).attr("src",data.comment+'?'+new Date());
  					//返回成功后图片回显
  					$("#detailFiles"+index).val(data.comment);
  				}else{
  					alert(data.comment);
  				}
  			}
  		});
    }

    function updateFinal(){
    	//在这个地方把所有需要提交的东西全部取出来  使用ajax提交
    	//取参数
    	//固定参数，场馆参数和主图参数
    	var params={};//上面的都是固定的用jquery去取  key的名字对应你后对象
    	//详细图参数
		params.amGroupId  = $("input[name=amGroupId]").val();
		params.amMerchantId = $("input[name=amMerchantId]").val();
		params.amUserDefine1 = $("input[name=amUserDefine1]").val();
		params.amUserDefine3 = $("input[name=amUserDefine3]").val();
		params.amUserDefine4 = $("input[name=amUserDefine4]").val();
		params.amUserDefine0 = $("input[name=amUserDefine0]").val().split("/").pop();//主图
		console.log($("input[name=amUserDefine0]").val());
		var dtPathStr = "";
		var len = $(".detailFilesPath").length;
		$(".detailFilesPath").each(function(i,dom){
			var val = $(this).val().split("/").pop();
			if(val == undefined){
				val = $(this).val();
			}
			val = (i == len - 1) ? val : (val + ",");
			dtPathStr+=val;
		});

		params.amUserDefine2 = dtPathStr;

    	/* var detailFilesPaths = $(".detailFilesPath").val( );
    	console.log(detailFilesPaths);
    	var detailPath ="";//详细图参数  对应后台放详细图的属性
    	for(var i = 0;i<detailFilesPaths.length;i++){
    		if(detailPath!=""){
    		detailPath +=( detailFilesPaths[i].val()+",");
    		}else{
    			detailPath+=detailFilesPaths[i].val()
    		}

    	} */
    	//提交
    	 $.ajax({
			type : "POST",
			url : "${ctx}/cpacqmer/update",   //路径
			data : JSON.stringify(params),
			async: false,
	        cache: false,
	        contentType: "application/json",
	        processData: false,
			success : function(data){
				if(data.status == 'OK'){
					//成功之后回显
					$("#img0").attr("src",'${assets}'+'/'+data.comment+'?'+new Date());
					$("#mainFileHidden").val("/"+data.comment);
					window.location.href="${ctx}/cpacqmer/list";
				}else{
					console.log(data);
					//alert("");
				}
			},
			error:function(data){
				alert("error");
			}
		});
    }

    </script>
</body>
</html>
