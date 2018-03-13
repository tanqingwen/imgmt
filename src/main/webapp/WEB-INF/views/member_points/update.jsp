<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>综合管理系统 | 积分更新</title>
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
				<h1>积分更新</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
						<li><a href="${ctx }/member_ship/list">积分管理</a></li>
						<li class="active">积分更新</li>
					</ol>
			</section>
	
		<div class="container-fluid RInfoManage IntegralManage common">
			<div class="row">
				<div class="tip-img">
					<p>积分更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">更新表单</h3>
						<form class="form-inline form-horizontal" id="updateForm" method="post" action="${item }/member_points/update">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>积分编号<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" name="poId" value="${memberPoints.poId}" readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>积分名称<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" name="poTypeName" value="${memberPoints.poTypeName}" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>消费金额<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" name="poTypeId" value="${memberPoints.poTypeId}" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>积分描述<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" name="poDescription" value="${memberPoints.poDescription}" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>积分数量<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" name="poNumber" value="${memberPoints.poNumber}" />
									</div>
								</div>
								
							</div>
						</form>
						<div class="col-lg-12 submit-group marginTop marginBottom">
							<a href="${ctx }/member_points/list" class="form-a">&lt;返回</a>
							<div class="btn-group fr">
								<button type="button" class="btn-size" style="width:110px;" id="updateButten">更新</button>
							</div>
						</div>
						

					</div>
				</div>
			</div>
		</div>
</div>
	</div>
	<tags:load_common_js />
		<script src="${assets}/validator/js/validator.js"></script>
	<script type="text/javascript">
		$('#updateForm').bootstrapValidator({
			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				poTypeName: {
					validators: {
						notEmpty: {
							message: '积分名称不能为空'
 						}
 					}
 				},
 				poNumber: {
					validators: {
						notEmpty: {
							message: '积分倍数不能为空'
 						},
 						regexp: {
 							regexp:	"^[1-9][0-9]*$",
 							message: '积分倍数必须为大于0的正整数'
 						}
 					}
 				},
 				poDescription: {
					validators: {
						notEmpty: {
							message: '积分描述不能为空'
 						}
 					}
 				}
 			}									 
		});
		
		$("#updateButten").on("click",function() {
			//获取表单对象
			var bootstrapValidator = $("#updateForm").data('bootstrapValidator');
			//手动触发验证
			bootstrapValidator.validate();
			if(bootstrapValidator.isValid()){
			document.getElementById("updateForm").submit();
			} 
		});
		
	</script>
		
	</body>

</html>