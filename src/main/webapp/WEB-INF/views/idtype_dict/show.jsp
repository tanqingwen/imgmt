<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>综合管理系统 | 证件类型查看</title>

	</head>
	<body  class="hold-transition skin-blue-light sidebar-mini">
	
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
          <h1>证件类型查看</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
            <li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
            <li><a href="${ctx }/idtype_dict/list">证件类型管理</a></li>
            <li class="active">证件类型查看</li>
          </ol>
        </section>
	
		<div class="container-fluid RInfoManage DocumentType common">
			<div class="row">
				<div class="tip-img">
					<p>证件类型查看</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看表单</h3>
						<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>证件类型<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" value="${item.idtypeId}" disabled="disabled"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>最大长度:</label>
										<input class="form-control formConl line-input" type="text" value="${item.idtypeLength}" disabled="disabled"/>
									</div>
								</div>
							</div><div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>证件描述:</label>
										<input class="form-control formConl line-input" type="text" value="${item.idtypeDesc}" disabled="disabled"/>
									</div>
								</div>
							</div>

						</form>
						<div class="col-lg-12 submit-group marginTop marginBottom">
							<a href="${ctx }/idtype_dict/list" class="form-a">&lt;返回</a>
						</div>
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
		
	</body>

</html>