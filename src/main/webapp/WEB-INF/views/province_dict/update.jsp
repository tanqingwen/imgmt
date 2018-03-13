<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 省份更新</title>
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
          <h1>省份更新</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
            <li><a href="${ctx }/province_dict/list">省份代码表</a></li>
            <li class="active">省份更新</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-edit"></i> 更新表单</h3>
                </div><!-- /.box-header -->
                <form id="provinceForm" class="form-horizontal" method="post" action="${ctx }/province_dict/update">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="id" class="col-sm-3 control-label">省份ID</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="provinceId" name="provinceId" value="${item.provinceId}" readonly="readonly"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ctryDescription" class="col-sm-3 control-label">国家名称</label>
								    <div class="col-sm-9">					                     
										<select class="form-control" id="alphaCtryCd" name="alphaCtryCd">
											<c:forEach var="country" items="${countrys }">		
												<option value="${country.alphaCtryCd }" <c:if test="${country.ctryDescription eq Description }">selected</c:if>>${country.alphaCtryCd }--${country.ctryDescription }</option>					 																																																												
										 </c:forEach>								    
										</select>
									</div>
								</div>
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label">省份名称</label>
								    <div class="col-sm-9">
								      <input maxlength="20" type="text" class="form-control" id="provinceName" name="provinceName" value="${item.provinceName}"/>
								    </div>
								</div>
														 
                			</div>
                		</div>       
					</div>
	                <div class="box-footer">
	                	<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info "><i class="fa fa-save"></i> 更新</button>
							<a type="button" class="btn btn-default " href="${ctx }/province_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
<%-- <!-- 					 	<div class="col-sm-10 ">						 -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-1 "> -->
<!-- 	                    	<button type="submit" class="btn btn-info pull-right"><i class="fa fa-save"></i> 更新</button> -->
<!-- 	                    </div> -->
<!-- 	                    <div class="col-sm-1 "> -->
	                    	<a type="button" class="btn btn-info pull-right" href="${ctx }/province_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
<!-- 	                    </div>	        --%>             	 -->
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
		  </section><!-- /.content -->
        </div><!-- /.box -->        
      </div><!-- /.content-wrapper -->
     
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
    </div><!-- ./wrapper -->
    
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
