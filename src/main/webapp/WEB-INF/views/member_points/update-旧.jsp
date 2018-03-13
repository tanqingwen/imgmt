<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 积分更新</title>
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
				<h1>积分更新</h1>
				<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
						<li><a href="${ctx }/member_ship/list">积分管理</a></li>
						<li class="active">积分更新</li>
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
						<form class="form-horizontal" id="updateForm" method="post" action="${item }/member_points/update">
							<div class="form-group">
								<label for="passwdExpire" class="col-sm-2 control-label">积分编号<font color="red">*</font></label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="poId" value="${memberPoints.poId}" readonly="readonly"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">积分名称</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="poTypeName" value="${memberPoints.poTypeName}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">消费金额</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="poTypeId" value="${memberPoints.poTypeId}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">积分描述</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="poDescription" value="${memberPoints.poDescription}"/>
								</div>
							</div>
							<div class="form-group">
								<label for="firstResetPasswd" class="col-sm-2 control-label">积分数量</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="poNumber" value="${memberPoints.poNumber}"/>
								</div>
							</div>
						</form>
					</div>
	                <div class="box-footer">
	                	<div class="pull-right">
							<button type="button" id="updateButten" class="btn btn-info"><i class="fa fa-save"></i> 更新</button>	
	                    	<a type="button" class="btn btn-default" href="${ctx }/member_points/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
