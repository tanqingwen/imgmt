<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>综合管理系统 | 餐厅信息管理</title>
		<tags:head_common_content/>
		<style type="text/css">
			*{
				margin:0;
				padding:0;
			}
			body{
				font-family: "微软雅黑";
				background:#eeeeee;
			}
			.container-fluid{
				width:1000px;
				margin:0 auto;
				background:white;
				-webkit-box-shadow:0 0px 20px 3px #bcdccd;  
				 -moz-box-shadow:0 0px 20px 3px #bcdccd;  
				 box-shadow:0 0px 20px 3px #bcdccd;  
			}
			
			.row{
				width:921px;margin:0 auto;
			}
			.row table{
				font-family: "微软雅黑";
				color:rgb(112,112,112);
			}
			
			.row h3{
				font-size:24px;
				height:40px;
			}
			.labels{
				color:#35353e;
				font-family: "微软雅黑";
				display: inline-block;
			}
			.mag{
				margin:8px 0;
			}
			.labels span{
				margin:0 10px;
				font-size:18px;
			}
			.labels strong{
				color:black;
				margin:0 5px;
				font-weight: 400;
			}
			.labels select option{
				text-align: center;
			}
			.form-line{
				margin:20px auto 20px 0 ;
			}
			.form-group{
				margin:24px 0;
			}
			.form-search{
				width:600px;
				display: block;
				position:relative;
				float:left;
			}
			.sear-input{
				width:565px;
				height:48px;
				border-radius: 5px;
				border:1px solid lightgray;
				outline: auto;
				outline-color: lightblue;
				text-indent:10px;
				font-size: 20px;
				color:rgb(98,98,98);
			}
			.sear-btn{
				width:100px;
				height:48px;
				background:white;
				border:1px solid lightblue;
				border-radius: 0 5px 5px 0;
				position:absolute;
				right:0;
				top:0;
				font-family: "微软雅黑";
				outline: none;
				font-size: 20px;
				color:rgb(98,98,98);
			}
			.form-add{
				width:100px;
				height:50px;
				line-height:50px;
				float:right;
				font-size:24px;
				color:rgb(69,160,224)
			}
			.form-add:hover{
				cursor: pointer;
			}
			.form-table th{
				font-size:18px;
				font-weight:500;
				color:rgb(49,49,49);
			}
			.form-table tr{
				border-bottom: 1px solid lightgray;
				height:125px;
			}
			.form-table tr td{
				font-size:18px;
				color:#898989;
			}
			.form-table tr td:last-child span{
				margin:0 6px;
			}
			.form-table tr td:nth-child(3){
				padding-right:10px;
			}
			.form-table tr td:last-child span:hover{
				cursor: pointer;
			}
		</style>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		
	<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="ywrestaurantlist"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>餐厅信息管理</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
						<li class="active">餐厅信息管理</li>
					</ol>
				</section>
	
		<div class="container-fluid" style="width:1000px;margin:0 auto"> 
			<div class="row" >
					<h3 style="border-bottom: #7ecef4 2px dashed;">查询表单</h3>
				
					<div class="form-group">
					<form class="form-horizontal">
						<div class="form-search">
							<input type="text" style="width:200px;" class="sear-input" id="restaurantId" name="restaurantId" value="${restaurantId }" placeholder="餐厅ID"/>
							<input type="text" style="width:300px;" class="sear-input" id="restaurantName" name="restaurantName" value="${restaurantName }" placeholder="餐厅名称"/>
					   		<button type="submit" class="sear-btn">查询</button>
						</div>
					</form>
						<div class="form-add">
						<c:if test="${app:checkPermission('YWRESTAURANT_ADD') }">
							<a href="${ctx}/ywrestaurant/add"><span class="glyphicon glyphicon-plus" style="margin-right:20px;"></span>添加</a>
						</c:if>
						</div>
					</div>	
					<div class="clearfix"></div>
					<h3 style="border-bottom: #f7ab00 2px dashed; margin:50px 0 10px 0;height:40px;">查询列表</h3>
					<div class="form-table">
						<table class="table-striped" style="border-top:none;width: 100%;">
							<tr class="text-left" >
								<th style="width:15%;">餐厅ID</th>
								<th style="width:20%;">餐厅名</th>
								
								<th class="text-right" style="width:20%;">操作</th>
							</tr>
						<c:forEach var="item" items="${pageInfo.list}">	
							<tr>
								<td>${item.restaurantId}</td>
				                <td>${item.restaurantName}</td>
								
								<td class="text-right">
									<c:if test="${app:checkPermission('YWRESTAURANT_UPDATE') }">
										<a href="${ctx}/ywrestaurant/update?restaurantId=${item.restaurantId}"><span>编辑</span></a>
									</c:if>
									<c:if test="${app:checkPermission('YWRESTAURANT_SHOW') }">
										<a href="${ctx}/ywrestaurant/show?restaurantId=${item.restaurantId}"><span>查看</span></a>
									</c:if>
									<c:if test="${app:checkPermission('YWRESTAURANT_DELETE')}">
										<a href="${ctx}/ywrestaurant/delete?restaurantId=${item.restaurantId}" onclick="return confirm('确认删除?')"><span>删除</span></a>
									</c:if>
								</td>
							</tr>
						</c:forEach>	
							
						</table>
					</div>
			</div>
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/ywrestaurant/list" page="${pageInfo}" cssClass="pull-right"/>
								</div>		
		</div>
		
		</div>
		<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>
	</body>
</html>
