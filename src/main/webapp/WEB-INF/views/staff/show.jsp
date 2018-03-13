<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>综合管理系统 | 员工详情</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="staff"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>员工详情</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
            <li><a href="${ctx }/staff/list">员工管理</a></li>
            <li class="active">员工详情</li>
          </ol>
        </section>
	
		<div class="container-fluid common staffAdd">
			<div class="row">
				<div class="tip-img">
					<p>员工详情</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看表单</h3>
						<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工ID<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" value="${item.id}" disabled="disabled"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>员工部门<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" value="${item.organizations}-${item.orgName} "  disabled="disabled"/>
									</div>
								</div>
							</div>

							<div class="col-md-12">
								
								<div class="col-md-6">
									<div class="form-group">
										<label>员工姓名<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" value="${item.name}" disabled="disabled"/>
									</div>
								</div>
								
								<div class="col-md-6">
									<div class="form-group">
										<label>员工邮箱:</label>
										<input class="form-control formConl line-input" type="text" value="${item.email}" disabled="disabled"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								
								<div class="col-md-6">
									<div class="form-group">
										<label class="radio-inline" for="inlineRadioOptions">员工性别:</label>
										<label class="radio-inline">
  											<input type="radio" name="gender" id="gender" value="Male" ${item.gender eq 'Male' ? 'checked':'' }> 男
										</label>
										<label class="radio-inline">
  											<input type="radio" name="gender" id="gender" value="Female" ${item.gender eq 'Female' ? 'checked':'' }> 女
										</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>电话号码:</label>
										<input class="form-control formConl line-input" type="text" value="${item.phoneNumber}"  disabled="disabled"/>
									</div>
								</div>
								
							</div>
								
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工状态:</label>
										<input class="form-control formConl line-input" type="text" value="${item.status}"  disabled="disabled"/>
									</div>
								</div>
							</div>
						</form>

						<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">角色列表</h3>
						<div class="clearfix tableContent roleContent">
							<div class="roleList col-md-12">
							<c:forEach var="role" items="${roles }">
								<div class="col-md-6">
									<div class="listBox">
										<span class="listBoxLeft col-md-1 text-center">
											<input type="checkbox" disabled="disabled" ${app:stringContains(item.roles, role.id) ? 'checked':'' }/>
										</span>
										<span class="col-md-8">${role.name }</span></div>
								</div>
							</c:forEach>
								
							</div>
							
							

						</div>
						<div class="col-lg-12 submit-group marginBottom">
							<a href="${ctx }/staff/list" class="form-a">&lt;返回</a>
						</div>
					</div>
				</div>

			</div>
		</div>
</div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    <!-- ./wrapper -->
    
    <tags:load_common_js/>
	</body>

</html>