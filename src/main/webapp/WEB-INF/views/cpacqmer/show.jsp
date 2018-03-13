<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		 <link rel="stylesheet" href="${assets }/css/index.css" />
		<link rel="stylesheet" href="${assets }/css/venueAllocation.css" />		
		<title>综合管理系统 | 场馆配置查看</title>	
	</head>
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
          <h1>场馆配置查看</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            <li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            <li><a href="${ctx }/cpacqmer/list">场馆配置</a></li>
            <li class="active">场馆配置查看</li>
          </ol>
        </section>	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img">
					<p style="line-height:32px;">场馆配置查看</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看表单</h3>
						<form id="defaultForm" name="defaultForm" class="form-horizontal">
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venuesNum">场馆组编号：</label>
											<input class="form-control formConl line-input" type="text" disabled="disabled" name="amGroupId" value="${cpAcqmer.amGroupId }"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNum">场馆组名称：</label>
											<input class="form-control formConl line-input" type="text" disabled="disabled" name="amGroupId" value="${cpAcqmer.amUserDefine1 }" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venuesNum">场馆开馆时间<span class="star">*</span>：</label>
											<input class="form-control formConl line-input" type="text" disabled="disabled" name="amUserDefine3" value="${cpAcqmer.amUserDefine3 }"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNum">场馆闭馆时间<span class="star">*</span>：</label>
											<input class="form-control formConl line-input" type="text" disabled="disabled" name="amUserDefine4" value="${cpAcqmer.amUserDefine4 }"/>
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="venuesNum">场馆编号：</label>
											<input class="form-control formConl line-input" type="text" disabled="disabled" name="amMerchantId" value="${cpAcqmer.amMerchantId }" />
										</div>
									</div>
									<%-- <div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="DuplicateEntry">重复入园标志：</label>
											<select class="DuplicateEntry" id="amRecycleType" name="amRecycleType" disabled="disabled">
												<option value='Y' ${cpAcqmer.amRecycleType eq 'Y' ? 'selected' : ''}>Y-是</option>
											</select>
										</div>
									</div> --%>
								</div>
							</div>
							<div class="VenueMaster clearfix">
								<div class="col-md-12">
									<div class="col-md-2 text-right" style="width: 120px;">场馆主图：</div>
									<div class="col-md-10">
										<div class="z_photo upimg-div clear up1">
												<img alt="${cpAcqmer.amUserDefine1 }" src="http://58.246.52.102:3551/assets/changguan/images/${cpAcqmer.amUserDefine0 }" class="add-img">
										</div>
									</div>
								</div>
							</div>
							<div class="VenueMaster clearfix">
								<div class="col-md-12">
									<div class="col-md-3 text-right" style="width: 120px;">场馆详细图：</div>
									<div class="col-md-10">
										<div class="z_photo upimg-div clear up2">
										<c:forEach var="item" items="${list}">
												<img src="http://58.246.52.102:3551/assets/changguan/images/${item}" class="add-img">
										</c:forEach>	
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-12 AddBottom" style="margin-bottom:20px;">
								<a href="javascript:history.go(-1)"><span class="" style="font-size:18px;">&lt;返回</span></a>
							
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
    
	$(function () {
		$("#updateButten").click(function(){
			var role=document.getElementsByName("roles"); 
			var m=0; var n=false; 
			for(var i=0;i<role.length;i++){ 
				if(role[i].checked){ 
					n=true; m++;
				}
			}
			if(!n){
				alert("请至少选择一个用户角色");
				//role[0].checked = true;
				return false;
			}
		});
	});
    
	
	
    </script>
	
	</body>

</html>