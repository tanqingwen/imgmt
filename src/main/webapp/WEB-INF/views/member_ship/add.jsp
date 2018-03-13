<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 等级添加</title>
	<tags:head_common_content />
	<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="country_dict" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>等级添加</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
						<li><a href="${ctx }/member_ship/list">等级管理</a></li>
						<li class="active">等级添加</li>
					</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-plus"></i> 添加表单
						</h3>
					</div>
					<!-- /.box-header -->
					<form id="memberShip" class="form-horizontal" method="post" action="${ctx }/member_ship/add">
						<div class="box-body">
							<div class="form-group">
								<label for="passwdExpire" class="col-sm-2 control-label">等级编号<font color="red">*</font></label>
								<div class="col-sm-4">
									<input maxlength="4" type="text" class="form-control" id="meGradeId" name="meGradeId" value="${item.meGradeId}" />
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">等级名称<font color="red">*</font></label>
								<div class="col-sm-4">
									<input maxlength="10" type="text" class="form-control" id="meGradeDesc" name="meGradeDesc" value="${item.meGradeDesc}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">等级描述<font color="red">*</font></label>
								<div class="col-sm-4">
									<input maxlength="40" type="text" class="form-control" id="meDescription" name="meDescription" value="${item.meDescription}" />
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">等级区域<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="meBin" name="meBin" value="${item.meBin}" />
								</div>
							</div>
						</div>
		                <div class="box-footer">
		                	<div class="pull-right">
								<button type="submit" class="btn btn-info "><i class="fa fa-plus"></i> 添加</button>
								<a type="button" class="btn btn-default " href="${ctx }/country_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
							</div>
<!-- 							 	<div class="col-sm-10 ">						 -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-1 ">	 -->
<!-- 									<button type="submit" class="btn btn-info pull-right"><i class="fa fa-edit"></i> 添加</button>		                    	 -->
<!-- 			                    </div> -->
<!-- 			                    <div class="col-sm-1 "> -->
<%-- 			                    	<a type="button" class="btn btn-info pull-right" href="${ctx }/country_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
<!-- 			                    </div>	                    	 -->
	                	</div><!-- /.box-footer -->
	                </form>
				</div>
			</section>
		</div>
	</div>
	<tags:load_common_js />
	<script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#memberShip').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				
	 				meGradeId: {
						validators: {
							notEmpty: {
								message: '会员等级ID不能为空'
	 						}
	 					}
	 				},
	 				meGradeDesc: {
						validators: {
							notEmpty: {
								message: '会员等级名称不能为空'
	 						}
	 					}
	 				},
	 				meBin: {
						validators: {
							notEmpty: {
								message: '会员等级区域号不能为空'
	 						},
	 						stringLength:{
	 							min: 6,
	 							max: 6,
	 							message: '会员等级区域号为6位'
	 						}
	 					}
	 				},
	 				meDescription: {
						validators: {
							notEmpty: {
								message: '会员等级描述不能为空'
	 						}
	 					}
	 				}
	 			}									 
			});
			
		});
    </script>
</body>
</html>
