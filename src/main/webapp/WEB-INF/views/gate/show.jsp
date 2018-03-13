<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 闸机查看</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
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
          <h1>闸机信息查看</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">业务管理</a></li>
            <li class="active">闸机信息查看</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 查看表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/ywgate/show">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                				<div class="form-group">
								    <label for="hwGateId" class="col-sm-3 control-label">闸机ID</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwGateId" name="hwGateId"  title="不能为空"  value="${item.hwGateId}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwGateName" class="col-sm-3 control-label">闸机名称</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwGateName" name="hwGateName"  value="${item.hwGateName}"/>
								    </div>
								</div>
                			    <div class="form-group">
								    <label for="hwGateNote" class="col-sm-3 control-label">闸机说明</label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwGateNote" name="hwGateNote"  value="${item.hwGateNote}"/>
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="hwVenueId" class="col-sm-3 control-label">所属场馆<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwVenueId" name="hwVenueId" value="${item.hwVenueId}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwGateLoc" class="col-sm-3 control-label">闸机位置<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwGateLoc" name="hwGateLoc" value="${item.hwGateLoc}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwGateIp" class="col-sm-3 control-label">闸机IP地址<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwGateIp" name="hwGateIp" value="${item.hwGateIp}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwOpenTime" class="col-sm-3 control-label">开放时间<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" readonly="readonly" class="form-control" id="hwOpenTime" name="hwOpenTime" value="${item.hwOpenTime}"/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/ywgate/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
