<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 机构更新</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="profile"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>机构更新</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">机构管理</a></li>
            <li class="active">机构更新</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 更新表单</h3>
                </div><!-- /.box-header -->
                <form id="organizationForm" class="form-horizontal" method="post" action="${ctx }/organization/update">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">机构ID</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="id" name="id" value="${item.id}" readonly="readonly"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">父级机构</label>
								    <div class="col-sm-9">
								    	<select id="parentId" name="parentId" class="form-control">
								    		<c:forEach var="org" items="${organizations }">
								    			<option value="${org.id }" ${org.id eq item.parentId ? 'checked' : '' }>${org.id } - ${org.name }</option>
								    		</c:forEach>
								    	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">机构名称</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="name" name="name" value="${item.name}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">机构描述</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="remark" name="remark" value="${item.remark}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="status" class="col-sm-3 control-label">状态</label>
								    <div class="col-sm-9">
								    	<select class="form-control" id="status" name="status">
								    		<option value="NORMAL">正常</option>
								    		<option value="LOCK">锁定</option>
								    		<option value="CANCEL">注销</option>
								    	</select>
								    </div>
								</div>
                			</div>
                		</div>                		 
					</div>
	                <div class="box-footer">
					 	<div class="col-sm-10 ">				
						</div>
						<div class="col-sm-1 ">	
							<button type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 更新</button>                    	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx}/organization/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
