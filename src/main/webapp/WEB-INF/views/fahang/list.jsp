<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 校验密钥表管理</title>
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
					<h1>校验密钥表管理</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
						<li class="active">校验密钥表管理</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
<!-- 					<div class="box box-primary"> -->
		                <div class="box box-info">
    						<div class="box-header with-border">
       							<h3 class="box-title"><i class="fa fa-list"></i> 查询列表</h3>
        							<div class="box-tools pull-right">
            							<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            							
        							</div>
    						</div><!-- /.box-header -->
	    					<div class="box-body">
		        				<div class="table-responsive">
		            				<table class="table no-margin">
		                				<thead>
		                    				<tr>
		                                   		<td colspan="4" class="center info">CUP Card</td>
		                                    </tr>
		                				</thead>
		                				<tbody>
		                					<c:forEach var="item" items="${items}">
		                						<c:if test="${item.vkValue=='CUPPVK1A'||item.vkValue=='CUPPVK1B'||item.vkValue=='CUPCVK1A'||item.vkValue=='CUPCVK1B'||item.vkValue=='CUPCVK2A'||item.vkValue=='CUPCVK2B'||item.vkValue=='CUPIWK'||item.vkValue=='CUPAWK'}">
			                    					<tr>
			                                            <td>${item.vkValue}</td>
			                                            <td>${item.vkKey}</td>
			                                            <td>${item.vkDesc}</td>
			                                            <td>
															<div class="btn-toolbar pull-right" role="toolbar">
																<div class="btn-group">
																	<c:if test="${app:checkPermission('CPVERKEY_UPDATE') }">
																		<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/cpverkey/update?id=${item.vkValue}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
																	</c:if>
																</div>
															</div>
														</td>
			                                        </tr>
		                                        </c:if>
		                					</c:forEach>
		                				</tbody>
		                				<thead>
		                    				<tr>
		                                   		<td colspan="4" class="center info">卡片密匙</td>
		                                    </tr>
		                				</thead>
		                				<tbody>
		                					<c:forEach var="item" items="${items}">
		                						<c:if test="${item.vkValue=='COMKEY'||item.vkValue=='LOADKEY'||item.vkValue=='TRXNKEY'||item.vkValue=='	WALLET'}">
			                    					<tr>
			                                            <td>${item.vkValue}</td>
			                                            <td>${item.vkDesc}</td>
			                                            <td></td>
			                                            <td>
															<div class="btn-toolbar pull-right" role="toolbar">
																<div class="btn-group">
																	<c:if test="${app:checkPermission('CPVERKEY_UPDATE') }">
																		<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/cpverkey/update?id=${item.vkValue}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
																	</c:if>
																</div>
															</div>
														</td>
			                                        </tr>
		                                        </c:if>
		                					</c:forEach>
		                				</tbody>
		                				<thead>
		                    				<tr>
		                                   		<td colspan="4" class="center info">公共密匙</td>
		                                    </tr>
		                				</thead>
		                				<tbody>
		                					<c:forEach var="item" items="${items}">
		                						<c:if test="${item.vkValue=='TWK'||item.vkValue=='TAK'||item.vkValue=='ZEK'||item.vkValue=='TMK'||item.vkValue=='ZMK'||item.vkValue=='ZAK'}">
			                    					<tr>
			                                            <td>${item.vkValue}</td>
			                                            <td>${item.vkKey}</td>
			                                            <td>${item.vkDesc}</td>
			                                            <td>
															<div class="btn-toolbar pull-right" role="toolbar">
																<div class="btn-group">
																	<c:if test="${app:checkPermission('CPVERKEY_UPDATE') }">
																		<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/cpverkey/update?id=${item.vkValue}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
																	</c:if>
																</div>
															</div>
														</td>
			                                        </tr>
		                                        </c:if>
		                					</c:forEach>
		                				</tbody>
		            				</table>
	        					</div><!-- /.table-responsive -->
	    					</div><!-- /.box-body -->
    					<div class="box-footer clearfix">
        				<a href="${ctx }/" class="btn  btn-info  pull-right"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
</html>