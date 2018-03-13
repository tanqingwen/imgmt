<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 黑名单票查看</title>
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
          <h1>黑名单票查看</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">黑名单票管理</a></li>
            <li class="active">黑名单票查看</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title">表单查看</h3>
                </div><!-- /.box-header -->
                <form class="form-horizontal" method="post">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
								<div class="form-group">
								    <label for="bmCardNo" class="col-sm-3 control-label">卡号</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmCardNo" name="bmCardNo" title="不能为空" value="${item.bmCardNo}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="bmInTime" class="col-sm-3 control-label">加入日期</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmInTime" name="bmInTime" value="${item.bmInTime}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="bmOrgId" class="col-sm-3 control-label">用户ID</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmOrgId" name="bmOrgId" value="${item.bmOrgId}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="bmProductCode" class="col-sm-3 control-label">产品ID</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmProductCode" name="bmProductCode" value="${item.bmProductCode}" disabled/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="bmReasonCode" class="col-sm-3 control-label">理由</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmReasonCode" name="bmReasonCode" value="${item.bmReasonCode}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="bmCardName" class="col-sm-3 control-label">持卡人姓名</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="bmCardName" name="bmCardName" value="${item.bmCardName}" disabled/>
								    </div>
								</div>
                			</div>
                		</div>
					</div>					 
	                <div class="box-footer">
	                	<div class="pull-right">
	                    	<a type="button" class="btn btn-default" href="${ctx }/cpblkmlc/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    <!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" style="overflow: auto;" aria-hidden="true">
	  <div class="modal-dialog modal-lg" id="midal">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel"></h4>
	      </div>
	      <div class="modal-body" id="myModalBody">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
    <tags:load_common_js/>
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
  </body>
</html>
