<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>景点信息查看</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="ywvenuelist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>景点信息查看</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">业务管理</a></li>
            <li class="active">景点信息查看</li>
          </ol>
        </section>
	
		<div class="container-fluid RInfoManage ScenicSpotUpdate ">
			<div class="row">
				<div class="tip-img">
					<p>景点信息查看</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看表单</h3>
						<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">

							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>景点ID:</label>
										<input class="form-control formConl line-input" type="text" value="${item.hwVenueId }" readonly="readonly" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>景点名称:</label>
										<input class="form-control formConl line-input" type="text" value="${item.hwVenueName}" readonly="readonly"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>景点说明:</label>
										<input class="form-control formConl line-input" type="text" value="${item.hwVenueNote}" readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>景点介绍:</label>
										<input class="form-control formConl line-input" type="text" value="${item.hwVenueIntroduce}" readonly="readonly" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>景点位置<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" name="" value="${item.hwVenusPos}" readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>闸机ID(多个):</label>
										<input class="form-control formConl line-input" type="text" value="${item.hwGateId}" readonly="readonly" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>负责人:</label>
									<input class="form-control formConl line-input" type="text" value="${item.hwLeader}" readonly="readonly" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>联系电话:</label>
									<input class="form-control formConl line-input" type="text" value="${item.hwContractPhone}" readonly="readonly" />
									</div>
								</div>
							</div>

						</form>
					</div>
					<div class="col-lg-12 submit-group marginBottom marginTop">
						<a href="${ctx }/ywvenue/list" class="form-a">&lt;返回</a>

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
   
		
	</body>

</html>