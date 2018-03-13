<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 省份添加</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="province"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>省份添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
            <li><a href="${ctx }/province_dict/list">省份代码表</a></li>
            <li class="active">省份添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form id="provinceForm" class="form-horizontal" method="post" action="${ctx }/province_dict/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">省份ID<font color="red">*</font></label>
								    <div class="col-sm-9">
								      <input maxlength="20" type="text" class="form-control" id="provinceId" name="provinceId" value="${item.provinceId}"/>
								    </div>
								</div>
								<div class="form-group">
									 <label for="password" class="col-sm-3 control-label">国家名称</label>				
									 <div class="col-sm-9">					                     
										<select id="alphaCtryCd" name="alphaCtryCd" class="form-control">
											<c:forEach var="country" items="${countrys }">
												<option value="${country.alphaCtryCd }">${country.ctryDescription }-${country.alphaCtryCd }</option>																					 				
											</c:forEach>																									 							    
										</select>																					
			 						</div> 							    								    
								</div>
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label">省份名称<font color="red">*</font></label>
								    <div class="col-sm-9">
								      <input maxlength="20" type="text" class="form-control" id="provinceName" name="provinceName" value="${item.provinceName}"/>
								    </div>
								</div>
								<%-- <div class="form-group">
								    <label for="name" class="col-sm-3 control-label">位置ID</label>
								    <div class="col-sm-9">
								      <input maxlength="4" type="text" class="form-control" id="locationId" name="locationId" value="${item.locationId}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">区域代码</label>
								    <div class="col-sm-9">
								      <input maxlength="6" type="text" class="form-control" id="regionCd" name="regionCd" value="${item.regionCd}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="gender" class="col-sm-3 control-label">邮编</label>
								    <div class="col-sm-9">							      	 
										<input maxlength="6" type="text" class="form-control" id="zipCode" name="zipCode" value="${item.zipCode}"/>							
								    </div>
								</div>	 --%>							 
                			</div>
                		</div>               
					</div>
	               <div class="box-footer">
	               		<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info "><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default " href="${ctx }/province_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
<!-- 					 	<div class="col-sm-10 ">						 -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-1 "> -->
<!-- 	                    	<button type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 添加</button> -->
<!-- 	                    </div> -->
<!-- 	                    <div class="col-sm-1 "> -->
<%-- 	                    	<a type="button" class="btn btn-info pull-right" href="${ctx }/province_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
<!-- 	                    </div>	                    	 -->
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
		</section><!-- /.content -->
        </div><!-- /.box -->
        
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    
    <tags:load_common_js/>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){
			$('#provinceForm').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				provinceId: {
						validators: {
							notEmpty: {
								message: '省份ID不能为空'
	 						}
	 					}
	 				},
	 				provinceName: {
						validators: {
							notEmpty: {
								message: '省份名称不能为空'
	 						}
	 					}
	 				}
	 			}									 
			});
		});
    </script>
  </body>
</html>
