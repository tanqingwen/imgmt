<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 校验密钥表更新</title>
		<tags:head_common_content/>
		<style type="text/css">
	 		.center{text-align:center;}
		</style>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="cpverkeylist"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>校验密钥表更新</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
						<li><a href="${ctx}/cpverkey/list">校验密钥表管理</a></li>
						<li class="active">校验密钥表更新</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content" method = "post">
					<div class="box box-primary">
<!-- 		                <div class="box box-info"> -->
    						<div class="box-header with-border">
       							<h3 class="box-title"><i class="fa fa-edit"></i> Latest Orders</h3>
        							<div class="box-tools pull-right">
            							<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            							
        							</div>
    						</div><!-- /.box-header -->
	    					<div class="box-body">
		        				<div class="table-responsive">
		        					<form action="${ctx}/cpverkey/update" method="post">
		            					<table class="table no-margin">
			            				  	<tr>
			            				  		<td colspan="2" class="center info">密匙值</td>
			            				  		<td colspan="2" ><input type="text" name="vkValue" value="${item.vkValue}" readonly></td>
			            				  	</tr>
			            				  	<tr>
			            				  		<td colspan="2" class="center info">描述</td>
			            				  		<td colspan="2" ><input type="text" name="vkKey" value="${item.vkKey}" readonly></td>
			            				  	</tr>
			            				  	<tr>
			            				  		<td colspan="2" class="center info">旧密匙值</td>
			            				  		<td colspan="2" ><input type="text" name="vkDesc" value="${item.vkDesc}" readonly></td>
			            				  	</tr>
			            				  	<tr>
			            				  		<td colspan="2" class="center info">新密匙值</td>
			            				  		<td colspan="2" ><input type="text" name="newvkDesc" value=""></td>
			            				  	</tr>
		            				     </table>
		            				     
		            				     
		            				 </form> 
		            				  
	        					</div><!-- /.table-responsive -->
	    					</div><!-- /.box-body -->
    					<div class="box-footer clearfix">
    						<div class="pull-right">
								<button id="addButton" type="submit" class="btn btn-info "><i class="fa fa-save"></i> 更新</button>
								<a type="button" class="btn btn-default " href="${ctx }/cpverkey/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
							</div>
    					<%-- <a href="${ctx}/cpverkey/update"  class="btn btn-sm btn-default btn-flat pull-left">更新</a> --%>
<%--         				<a href="${ctx }/cpverkey/list" class="btn btn-sm btn-default btn-flat pull-right">返回</a> --%>
    					</div><!-- /.box-footer -->
					</div>
		        </div><!-- /.row -->
				</section><!-- /.content -->
			</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
   
		</div><!-- ./wrapper -->
		<tags:load_common_js/>
	</body>
	<script type="text/javascript">
		function update (url){
			var newvkDesc = document.getElementByname("newvkDesc");
			
			
		}
	</script>
</html>