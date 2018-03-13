<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 员工详情</title>
    <tags:head_common_content/>
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

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-eye"></i> 查看表单</h3>
                </div><!-- /.box-header -->
                <form class="form-horizontal">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">员工ID</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="id" name="id" value="${item.id}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label">员工部门</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="organizations" name="organizations" value="${item.organizations}-${item.orgName} "  disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">员工姓名</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="name" name="name" value="${item.name}"  disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">员工邮箱</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="email" name="email" value="${item.email}"  disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="gender" class="col-sm-3 control-label">员工姓别</label>
								    <div class="col-sm-9">
								      	<label class="radio-inline">
										  	<input type="radio" name="gender" id="gender" value="Male" ${item.gender eq 'Male' ? 'checked':'' } disabled="disabled"> 男
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="gender" id="gender" value="Female" ${item.gender eq 'Female' ? 'checked':'' } disabled="disabled"> 女
										</label>
								    </div>
								</div>
								<div class="form-group">
								    <label for="phoneNumber" class="col-sm-3 control-label">电话号码</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${item.phoneNumber}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">状态</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="status" name="status" value="${item.status}" disabled="disabled"/>
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="roles" class="col-sm-3 control-label">角色列表</label>
								    <div class="col-sm-9">
								    	<div class="row">
									    	<c:forEach var="role" items="${roles }">
						                    <div class="col-lg-6">
												<div class="input-group">
													<span class="input-group-addon">
														<input type="checkbox" disabled="disabled" ${app:stringContains(item.roles, role.id) ? 'checked':'' }/>
													</span>
													<span class="form-control" >${role.name }</span>
												</div><!-- /input-group -->
						                    </div><!-- /.col-lg-6 -->
						                    </c:forEach>
					                    </div>
								    </div>
								</div>
                			</div>
                		</div>
                	</div>
               		<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/staff/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                    </div>	                 	
                	</div><!-- /.box-footer -->
	        	</form>
			</div>
			</section>
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
