<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>景点信息更新</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="ywvenuelist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>景点信息更新</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/ywvenue/list">景点信息管理</a></li>
            <li class="active">景点信息更新</li>
          </ol>
        </section>
	
	
		<div class="container-fluid RInfoManage ScenicSpotUpdate ">
			<div class="row">
				<div class="tip-img">
					<p>景点信息更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">手动确认</h3>
						<form class="form-inline form-horizontal" id="defaultForm" method="post" action="${ctx }/ywvenue/update" name="defaultForm">

							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>场馆ID:</label>
										<input class="form-control formConl line-input" type="text" id="hwVenueId" name="hwVenueId" value="${item.hwVenueId }"  readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>场馆名称:</label>
										<input class="form-control formConl line-input" type="text" id="hwVenueName" name="hwVenueName" value="${item.hwVenueName}" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>场馆说明:</label>
										<input class="form-control formConl line-input" type="text" id="hwVenueNote" name="hwVenueNote" value="${item.hwVenueNote}" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>场馆介绍:</label>
										<input class="form-control formConl line-input" type="text" id="hwVenueIntroduce" name="hwVenueIntroduce" value="${item.hwVenueIntroduce}" />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>场馆位置<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="hwVenusPos" name="hwVenusPos" value="${item.hwVenusPos}" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>闸机ID(多个):</label>
										<input class="form-control formConl line-input" type="text" id="hwGateId" name="hwGateId"  value="${item.hwGateId}"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>负责人:</label>
										<input class="form-control formConl line-input" type="text" id="hwLeader" name="hwLeader" value="${item.hwLeader}" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>联系电话:</label>
										<input class="form-control formConl line-input" type="text" id="hwContractPhone" name="hwContractPhone" value="${item.hwContractPhone}" />
									</div>
								</div>
							</div>
<div class="col-lg-12 submit-group marginBottom marginTop">
						<a href="${ctx }/ywvenue/list" class="form-a">&lt;返回</a>
						<div class="btn-group fr">
							<button id="addButton" type="submit" class="btn-size" style="width:110px;" id="memberShip">更新</button>

						</div>
					</div>
						</form>
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
    <script src="${assets}/crypto/md5.js"></script>
    <script type="text/javascript">
    
	$(document).ready(function(){
		
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				hwVenueName: {
					validators: {
						notEmpty: {
							message: '场馆名不能为空'
							}
					}
 				},
 				hwVenueNote: {
 					validators: {
 						notEmpty: {
							message: '场馆说明不能为空'
							}
 					}
 				}
 			}
   		});
   		
	});
    
    </script>

		
	</body>

</html>