<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 国家添加</title>
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
				<h1>国家添加</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
						<li><a href="${ctx }/country_dict/list">国家管理</a></li>
						<li class="active">国家添加</li>
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
					<form id="country" class="form-horizontal" method="post" action="${ctx }/country_dict/add">
						<div class="box-body">
							<div class="form-group">
								<label for="passwdExpire" class="col-sm-2 control-label">国家字母编号<font color="red">*</font></label>
								<div class="col-sm-4">
									<input maxlength="3" type="text" class="form-control" id="alphaCtryCd" name="alphaCtryCd" value="${item.alphaCtryCd}" />
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">国家数字编号</label>
								<div class="col-sm-4">
									<input maxlength="10" type="text" class="form-control" name="numericCtryCd" value="${item.numericCtryCd}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">国家名称</label>
								<div class="col-sm-4">
									<input maxlength="40" type="text" class="form-control" name="ctryDescription" value="${item.ctryDescription}" />
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
			
			$('#country').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				alphaCtryCd: {
						validators: {
							notEmpty: {
								message: '国家字母ID不能为空'
	 						}
	 					}
	 				}
	 			}									 
			});
			
		});
    </script>
</body>
</html>
