<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 |城市详情</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="city"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>城市详情看</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
			<li><a href="${ctx }/city_dict/list">城市管理</a></li>
            <li class="active">城市详情</li>
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
								    <label for="id" class="col-sm-3 control-label">城市ID </label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="cityId" name="cityId" value="${city.cityId}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">省份ID </label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="provinceId" name="provinceId" value="${city.provinceId}" disabled="disabled"/>
								    </div>
								</div>
						   </div>
					  </div>
                	  <div class="col-sm-6">
                		 <div class="row">
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label">城市名称 </label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cityName" name="cityName" value="${city.cityName}" disabled="disabled"/>
								    </div>
								</div>
						 </div>
					  </div>
                	  <div class="col-sm-6">
                		 <div class="row">
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">区域代码 </label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="regionCd" name="regionCd" value="${city.regionCd}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="gender" class="col-sm-3 control-label">邮编 </label>
								 	<div class="col-sm-8">
								      <input type="text" class="form-control" id="zipCode" name="zipCode" value="${city.zipCode}" disabled="disabled"/>
								    </div>
								</div>
						 </div>
					  </div>
					</div>
					<div class="box-footer">
	                    <button type="submit" class="btn btn-default pull-right"><i class="glyphicon glyphicon-chevron-left"></i> 返回</button>
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
