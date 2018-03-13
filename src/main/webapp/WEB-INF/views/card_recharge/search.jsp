<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
	<title>综合管理系统|充值</title>
	<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	<!-- this "tags" contains all the patterns we need in this page -->
	<tags:head_common_content/>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">

<!-- Main header, top yellow bar -->
<tags:main_header/>

<!-- Left column, contains the logo and sidebar -->
<tags:main_sidebar active="profile"/>

<!-- here use a wrapper so that the content won't be influenced by sidebar -->
<div class="content-wrapper">

	<!-- This class contains tip on the top of wrapper. Ordinarily it's invisible. -->
	<div class="context-tips">
		<tags:action_tip/>
	</div>
	
	<!-- title of the real content -->
	<section class="content-header">
		<h1>充值</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
			<li class="active">充值-卡信息查询</li>
		</ol>
	</section>
	
	<!-- content of the real content -->
	<section class="content">
		<div class="box box-primary" style="height: 400px">
		
			<div class="box-header">
				<h3 class="box-title"><i class="fa fa-search"></i> 卡信息查询（输入后按回车）</h3>
			</div>
			
			<form id="form" class="form-horizontal" action="${ctx}/CardRecharge/searchCard">
				<div class="box-body" style="margin-top: 100px; margin-bottom: 100px" >
			  		<div class="form-group">
					    <label class="col-sm-2 control-label">卡号<font color="red">*</font></label>
					    <div class="col-sm-3">
					    	<input type="text" class="form-control" name="cardNo" onkeyup="this.value=this.value.replace(/\s/g,'')"/>
					    </div>
					</div>
				</div>
				
				<div class="box-footer">
					<div class="col-sm-9">
					</div>
					<div class="col-sm-1">
						<button type="submit" class="btn btn-info" ><i class="fa fa-search"></i> 查询</button>
					</div>
				</div>
			</form>
		</div>
	</section>
</div>

<!-- to make an effect of the right sidebar -->
<tags:control_sidebar/>

<!-- 160809刘立人，该tag文件包含一个js脚本，实现侧边栏的收缩效果。该效果做得非常6！ -->
<tags:load_common_js/>

<!-- 160810刘立人，这个validator是一个非常好用的jQuery表单验证工具，导入之后就可以按照以下格式写代码 -->
<script src="${assets}/validator/js/validator.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#form').bootstrapValidator({
			// 当状态发生变化时，input样式的改变
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				// 对如下name的input标签进行判断
 				cardNo: {
					validators: {
						notEmpty: {
							message: '卡号不能为空'
 						},
 						regexp: {
	                        regexp: /^[0-9]*$/,
	                        message: '卡号只能是数字'
	                    },
			 			stringLength: {
		                    max: 32,
		                    message: '卡号的长度不能超过32位'
		                }
 					}
 				}
 			}									 
		});
	});
</script>

</body>
</html>
