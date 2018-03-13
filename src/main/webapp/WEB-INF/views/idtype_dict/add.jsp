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
		<title>综合管理系统 | 证件类型添加</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="midtype"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>证件类型添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
            <li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
            <li><a href="${ctx }/idtype_dict/list">证件类型管理</a></li>
            <li class="active">证件类型添加</li>
          </ol>
        </section>
	
		<div class="container-fluid RInfoManage DocumentType common">
			<div class="row">
				<div class="tip-img">
					<p>证件类型添加</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">添加表单</h3>
						<form class="form-inline form-horizontal" id="idtype" method="post" action="${ctx }/idtype_dict/add">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>证件类型<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="idtypeId" name="idtypeId" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>最大长度:</label>
										<input class="form-control formConl line-input" type="text" id="idtypeLength" name="idtypeLength" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>证件描述:</label>
										<input class="form-control formConl line-input" type="text" id="idtypeDesc" name="idtypeDesc" />
									</div>
								</div>
							</div>

						
						<div class="col-lg-12 submit-group marginTop marginBottom">
							<a href="${ctx }/idtype_dict/list" class="form-a">&lt;返回</a>
							<div class="btn-group fr">
								<button type="submit" class="btn-size" style="width:110px;" id="memberShip">添加</button>

							</div>
						</div>
</form>
					</div>
				</div>
			</div>
		</div>

		</div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    </div><!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){
			$('#idtype').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				idtypeId: {
						validators: {
							notEmpty: {
								message: '证件类型不能为空'
	 						}
	 					}
	 				}	 				
	 			}									 
			});
		});
    </script>
	</body>

</html>