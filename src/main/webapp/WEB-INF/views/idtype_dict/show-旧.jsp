<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 证件类型详情</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
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
          <h1>证件类型详情</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
            <li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
            <li><a href="${ctx }/idtype_dict/list">证件类型管理</a></li>
            <li class="active">证件类型详情</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-eye"></i> 查看表单</h3>
                </div><!-- /.box-header -->
                <form class="form-horizontal" method="post" action="${ctx}/idtype_dict/show">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">证件类型</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="idtypeId" name="idtypeId" value="${item.idtypeId}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">证件描述</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="idtypeDesc" name="idtypeDesc" value="${item.idtypeDesc}" disabled="disabled"/>
								    </div>
								</div>
                			</div> 			
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
								<%-- <div class="form-group">
								    <label for="id" class="col-sm-3 control-label">起始位置</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="idtypeForm" name="idtypeForm" value="${item.idtypeForm}" disabled="disabled"/>
								    </div>
								</div> --%>
								<div class="form-group">
								    <label for="name" class="col-sm-3 control-label">最大长度</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="idtypeLength" name="idtypeLength" value="${item.idtypeLength}" disabled="disabled"/>
								    </div>
								</div>
                			</div>                			
                		</div>                		
					</div>
					<div class="box-footer">
	                  	<a type="submit" class="btn btn-default pull-right" href="${ctx }/idtype_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	              	</div><!-- /.box-footer -->
	        	</form>
			</div>
        </div><!-- /.box -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    </div><!-- ./wrapper -->
    
    <tags:load_common_js/>
  </body>
</html>
