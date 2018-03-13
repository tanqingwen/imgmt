<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 场馆配置查看</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="venue_list"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>场馆配置查看</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            <li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            <li><a href="${ctx }/cpacqmer/list">场馆配置</a></li>
            <li class="active">场馆配置查看</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-edit"></i> 查看表单</h3>
                </div><!-- /.box-header -->
                <form id="stafffrom" class="form-horizontal" method="post" action="${ctx }/cpacqmer/update">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
								<div class="form-group">
								    <label for="amGroupId" class="col-sm-3 control-label">场馆组编号</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" disabled="disabled" name="amGroupId" value="${cpAcqmer.amGroupId }">
								    </div>
								</div>
								<div class="form-group">
								    <label for="amGroupId" class="col-sm-3 control-label">场馆组名称</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" disabled="disabled" name="amGroupId" value="${cpAcqmer.amUserDefine1 }">
								    </div>
								</div>
								<div class="form-group">
								    <label for="amGroupId" class="col-sm-3 control-label">场馆主图</label>
								    <div class="col-sm-8">
								      <img alt="${cpAcqmer.amUserDefine1 }" src="${assets }/${cpAcqmer.amUserDefine0}">
								    </div>
								</div>
								<div class="form-group">
								    <label for="amMerchantId" class="col-sm-3 control-label">场馆编号</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control"  disabled="disabled" name="amMerchantId" value="${cpAcqmer.amMerchantId }">
								     <%--  <select class="form-control" id="amMerchantId" disabled="disabled">
								      	<c:forEach var="item" items="${cpMermsts}">
								     		<option value="${item.mmMerchantNo }" ${item.mmMerchantNo eq cpAcqmer.amMerchantId ? 'selected' : ''}>${item.mmMerchantNo }-${item.mmBizName }</option>
								     	</c:forEach>
								      </select> --%>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="amGroupId" class="col-sm-3 control-label">场馆详细图</label>
								    <div class="col-sm-8">
										<c:forEach var="item" items="${list}">
								     		<img alt="" src="${assets }/yanwu/images/${item}">
								     	</c:forEach>	
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="amRecycleType" class="col-sm-3 control-label">重复入园标志</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="amRecycleType" name="amRecycleType">
								     	 	<!--  
								     	 	<option value='N' ${cpAcqmer.amRecycleType eq 'N' ? 'selected' : ''}>N-否</option>
	          							    -->
	          							    <option value='Y' ${cpAcqmer.amRecycleType eq 'Y' ? 'selected' : ''}>Y-是</option>
								      </select>
								    </div>
								</div>
								<!--  
								<div class="form-group">
								    <label for="amRecycleDate" class="col-sm-3 control-label">重复使用次数<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="amRecycleDate" name="amRecycleDate" value="${cpAcqmer.amRecycleDate}"/>
								    </div>
								</div>
								-->
                			</div>
                		</div>
					</div>					 
	                <div class="box-footer">
	                	<div class="pull-right">
	                    	<a type="button" class="btn btn-default" href="${ctx }/cpacqmer/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    
	$(function () {
		$("#updateButten").click(function(){
			var role=document.getElementsByName("roles"); 
			var m=0; var n=false; 
			for(var i=0;i<role.length;i++){ 
				if(role[i].checked){ 
					n=true; m++;
				}
			}
			if(!n){
				alert("请至少选择一个用户角色");
				//role[0].checked = true;
				return false;
			}
		});
	});
    
	
	
    </script>
    
  </body>
</html>
