<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 |景点信息添加</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
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
          <h1>景点信息添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/ywvenue/list">景点信息管理</a></li>
            <li class="active">景点信息添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/ywvenue/add" enctype="multipart/form-data">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                			    <div class="form-group">
								    <label for="hwVenueId" class="col-sm-3 control-label">场馆ID<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwVenueId" name="hwVenueId" value="${item.hwVenueId }"  />
								    </div>
								</div>
	                			<div class="form-group">
								    <label for="hwVenueName" class="col-sm-3 control-label">场馆名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwVenueName" name="hwVenueName" title="不能为空" value="${item.hwVenueName}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwVenueNote" class="col-sm-3 control-label">场馆说明<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwVenueNote" name="hwVenueNote" title="不能为空" value="${item.hwVenueNote}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwVenueIntroduce" class="col-sm-3 control-label">场馆介绍</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwVenueIntroduce" name="hwVenueIntroduce" value="${item.hwVenueIntroduce}"/>
								    </div>
								</div>
<!-- 								<div class="form-group"> -->
<!-- 								    <label for="hwVenuePic1" class="col-sm-3 control-label">场馆图片1</label> -->
<!-- 								    <div class="col-sm-8"> -->
<%-- 								      <input type="file" class="form-control" id="hwVenuePic1" name="hwVenuePicfile1" value="${item.hwVenuePic1}"/> --%>
<!-- 								    </div> -->
<!-- 								</div> -->
<!-- 								<div class="form-group"> -->
<!-- 								    <label for="hwVenuePic2" class="col-sm-3 control-label">场馆图片2</label> -->
<!-- 								    <div class="col-sm-8"> -->
<%-- 								      <input type="file" class="form-control" id="hwVenuePic2" name="hwVenuePicfile2" value="${item.hwVenuePic2}"/> --%>
<!-- 								    </div> -->
<!-- 								</div> -->
								<div class="form-group">
								    <label for="hwVenusPos" class="col-sm-3 control-label">场馆位置</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwVenusPos" name="hwVenusPos" value="${item.hwVenusPos}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwLeader" class="col-sm-3 control-label">负责人</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwLeader" name="hwLeader" value="${item.hwLeader}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwContractPhone" class="col-sm-3 control-label">联系电话</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwContractPhone" name="hwContractPhone" value="${item.hwContractPhone}"/>
								    </div>
								</div>
								<%-- <div class="form-group">
									    <label for="hwAddtime" class="col-sm-3 control-label">添加时间<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwAddtime" name="hwAddtime" value="${item.hwAddtime}" readonly="readonly"/>
								    </div>
								</div> --%>
                			</div>
                		</div>
                	</div>
					<div class="box-footer">
						<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info"><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default" href="${ctx }/ywvenue/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
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
 				hwVenueId: {
					validators: {
						notEmpty: {
							message: '场馆Id不能为空'
							},
						regexp: {
		                    regexp: /^[0-9]*$/,
		                    message: 'Id只能是数字'
		                },
					}
 				},
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
