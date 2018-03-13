<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 等级更新</title>
	<tags:head_common_content />
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
				<h1>等级更新</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
						<li><a href="${ctx }/member_ship/list">等级管理</a></li>
						<li class="active">等级更新</li>
					</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-edit"></i> 更新表单
						</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<form class="form-horizontal" id="updateForm" method="post" action="${item }/member_ship/update">
							<div class="form-group">
								<label for="passwdExpire" class="col-sm-2 control-label">等级编号<font color="red">*</font></label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="meGradeId" value="${memberShip.meGradeId}" readonly="readonly"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">等级名称</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="meGradeDesc" value="${memberShip.meGradeDesc}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">等级描述</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="meDescription" value="${memberShip.meDescription}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">区域编号</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="meBin" value="${memberShip.meBin}"/>
								</div>
							</div>
						</form>
					</div>
	                <div class="box-footer">
	                	<div class="pull-right">
							<button type="button" id="updateButten" class="btn btn-info"><i class="fa fa-save"></i> 更新</button>	
	                    	<a type="button" class="btn btn-default" href="${ctx }/member_ship/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
                		</div>
<!-- 							 	<div class="col-sm-10 ">						 -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-1 ">	 -->
<!-- 									<button type="button" class="btn btn-info pull-right" id="submitButton"><i class="fa fa-save"></i> 保存</button>	                    	 -->
<!-- 			                    </div> -->
<!-- 			                    <div class="col-sm-1 "> -->
<%-- 			                    	<a type="button" class="btn btn-info pull-right" href="${ctx }/country_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
<!-- 			                    </div>	                    	 -->
	                </div><!-- /.box-footer -->
				</div>
			</section>
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
 						stringLength: {
 							min: 6,
 							max: 6,
 							message: '会员等级区域号长度为6'
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
