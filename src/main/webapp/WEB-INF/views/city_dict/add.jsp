<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
	<title>综合管理系统 | 城市添加</title>
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
			<h1>城市添加</h1>
			<ol class="breadcrumb">
				<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
				<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
				<li><a href="${ctx }/city_dict/list">城市管理</a></li>
				<li class="active">城市添加</li>
			</ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                	<h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form id="city" class="form-horizontal" method="post" action="${ctx }/city_dict/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="cityId" class="col-sm-3 control-label">城市ID<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<input maxlength="20" type="text" class="form-control" id="cityId" name="cityId" value="${city.cityId}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="provinceId" class="col-sm-3 control-label">省份ID<font color="red">*</font></label>
								    <div class="col-sm-8">
									    <select class="form-control" name="provinceId" id="provinceId">
											<c:forEach var="mProvinces" items="${mProvince }">
												<option value="${mProvinces.provinceId }">${mProvinces.provinceId } - ${mProvinces.provinceName }</option>
											</c:forEach>
									    </select>
								    </div>
								</div>
								<div class="form-group">
								    <label maxlength="20" for="cityName" class="col-sm-3 control-label">城市名称<font color="red">*</font></label>
								    <div class="col-sm-8">
										<input type="text" class="form-control" id="cityName" name="cityName" value="${city.cityName}"/>
								    </div>
								</div>
						   </div>
					  </div>
                	  <div class="col-sm-6">
                		 <div class="row">								
							<div class="form-group">
							    <label for="regionCd" class="col-sm-3 control-label">区域代码</label>
							    <div class="col-sm-8">
									<input type="text" class="form-control" id="regionCd" name="regionCd" value="${city.regionCd}"/>
							    </div>
							</div>
							<div class="form-group">
							    <label for="zipCode" class="col-sm-3 control-label">邮编</label>
							 	<div class="col-sm-8">
									<input type="text" class="form-control" id="zipCode" name="zipCode" value="${city.zipCode}"/>
							    </div>
							</div>
						 </div>
					  </div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info "><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default " href="${ctx }/city_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
<!-- 							 	<div class="col-sm-10 ">						 -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-1 ">	 -->
<!-- 									<button type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 添加</button>		                    	 -->
<!-- 			                    </div> -->
<!-- 			                    <div class="col-sm-1 "> -->
<%-- 			                    	<a type="button" class="btn btn-info pull-right" href="${ctx }/city_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
<!-- 			                    </div>	                    	 -->
	                </div><!-- /.box-footer -->
	            </form>
        	</div><!-- /.box -->
		</section><!-- /.content -->
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
			$('#city').bootstrapValidator({
				message: 'This value is not valid',   
	   			feedbackIcons: {
	 				valid: 'glyphicon glyphicon-ok',         
	 				invalid: 'glyphicon glyphicon-remove',         
	 				validating: 'glyphicon glyphicon-refresh'    
	 			},
	 			fields: {
	 				cityId: {
						validators: {
							notEmpty: {
								message: '城市ID不能为空'
	 						}
	 					}
	 				},
	 				cityName: {
						validators: {
							notEmpty: {
								message: '城市名称不能为空'
	 						}
	 					}
	 				}
	 			}									 
			});
		});
    </script>
  </body>
</html>
