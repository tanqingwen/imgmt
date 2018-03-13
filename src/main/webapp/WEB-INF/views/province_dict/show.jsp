<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 省份详情</title>
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
          <h1>省份详情</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/jbcsgl">基本参数管理</a></li>
            <li><a href="${ctx }/province_dict/list">省份代码表</a></li>
            <li class="active">省份详情</li>
          </ol>
        </section>

       
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
								    <label for="id" class="col-sm-3 control-label">省份ID</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="provinceId" name="provinceId" value="${item.provinceId}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="password" class="col-sm-3 control-label">国家名称</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="ctryDescription" name="ctryDescription" value="${country.ctryDescription}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="organizations" class="col-sm-3 control-label">省份名称</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="provinceName" name="provinceName" value="${item.provinceName}" disabled="disabled"/>
								    </div>
								</div>
								<%-- <div class="form-group">
								    <label for="name" class="col-sm-3 control-label">位置ID</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="locationId" name="locationId" value="${item.locationId}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="email" class="col-sm-3 control-label">区域代码</label>
								    <div class="col-sm-9">
								      <input type="text" class="form-control" id="regionCd" name="regionCd" value="${item.regionCd}" disabled="disabled"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="gender" class="col-sm-3 control-label">邮编</label>
								    <div class="col-sm-9">							      	 
										<input type="text" class="form-control" id="zipCode" name="zipCode" value="${item.zipCode}" disabled="disabled"/>							
								    </div>
								</div>	 --%>							 
	               			</div>	               			
	               		</div>  
               		</div>
               		<div class="box-footer">
						 	<div class="col-sm-10 ">						
							</div>
							<div class="col-sm-1 ">			                    	
		                    </div>
		                    <div class="col-sm-1 ">
		                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/province_dict/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
		                    </div>	                    	
                	</div><!-- /.box-footer -->          
				</form>
			</div>
		</section>
		
        </div><!-- /.box -->
        
      </div><!-- /.content-wrapper -->
      
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
     
    
    <tags:load_common_js/>
  </body>
</html>
