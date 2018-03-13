<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统222 | 仪表盘</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>仪表盘</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li class="active">仪表盘</li>
          </ol>
        </section>

		<!-- add by Hugh start -->
		<form class="form-horizontal" action="http://192.168.1.252:8080/happyworld/LoginController" method="POST" target="_blank">
			<input id="user_id" name="user_id" type="hidden" value="0081">
			<input id="passwd" name="passwd" type="hidden" value="0081">
		</form>
		<!-- add by Hugh end -->
		
        <!-- Main content -->
        <section class="content">
		    <div class="row">
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-aqua">
		            <div class="inner">
		              <h3>现场管理</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-person-add"></i>
		            </div>
		            	<a href="${ctx }/startTreeviewDetail/xcgl" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        <!-- ./col -->
		        
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-purple">
		            <div class="inner">
		              <h3>票务作业</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-card"></i>
		            </div>
		            	<!--  
		           		<a href="javascript:void(0);" class="small-box-footer" onclick="javascript:document.forms[0].submit();">进入管理<i class="fa fa-users"></i></a>
		           		-->
		           		<a href="${ctx }/startTreeviewDetail/pwzy" class="small-box-footer">进入管理<i class="fa fa-users"></i></a>
		           </div>
		        </div>
		        <!-- ./col -->
		        
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-green">
		            <div class="inner">
		              <h3>会员卡作业</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-social-android-outline"></i>
		            </div>
		            <a href="${ctx }/startTreeviewDetail/hykzy" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i></a>
		          </div>
		        </div>
		        <!-- ./col -->
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-blue">
		            <div class="inner">
		              <h3>会员管理</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-chatbubbles"></i>
		            </div>
		            <a href="${ctx }/startTreeviewDetail/hygl" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        <!-- ./col -->
		        
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-red">
		            <div class="inner">
		              <h3>业务管理</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-arrow-expand"></i>
		            </div>
		            <a href="${ctx }/startTreeviewDetail/ywgl" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        <!-- ./col -->
		        
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-yellow">
		            <div class="inner">
		              <h3>业务查询</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="fa fa-shopping-cart"></i>
		            </div>
		            <a href="${ctx }/startTreeviewDetail/ywcx" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <!-- ./col -->
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-maroon">
		            <div class="inner">
		              <h3>统计报表</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-stats-bars"></i>
		            </div>
		            <a href="${ctx }/startTreeviewDetail/tjbb" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        <!-- ./col -->
		        
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-fuchsia">
		            <div class="inner">
		              <h3>web维护</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-document-text"></i>
		            </div>
		            <a href="${ctx }/startTreeviewDetail/webwh" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        <!-- ./col -->
		        
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-orange">
		            <div class="inner">
		              <h3>系统管理</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-gear-b"></i>
		            </div>
		            <a href="${ctx }/startTreeviewDetail/xtgl" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        <!-- ./col -->
				
				<div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-light-blue">
		            <div class="inner">
		              <h3>酒店系统</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-plane"></i>
		            </div>
		            <a href="#" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i></a>
		          </div>
		        </div>
		        <!-- ./col -->
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-navy">
		            <div class="inner">
		              <h3>智能停车场</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-social-pinterest"></i>
		            </div>
		            	<a href="#" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        <!-- ./col -->
		        <div class="col-lg-3 col-xs-6">
		          <!-- small box -->
		          <div class="small-box bg-olive">
		            <div class="inner">
		              <h3>视频监控</h3>
		              <p>-------------------------------</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-videocamera"></i>
		            </div>
		           		<a href="javascript:void(0);" class="small-box-footer" onclick="javascript:document.forms[0].submit();"><i class="fa fa-users"></i><span>进入管理</span></a>
		           </div>
		        </div>
		        <!-- ./col -->
		        
		        
		      </div>
		      <!-- /.row -->
        </section><!-- /.content -->
    <!-- common js -->
    <tags:load_common_js/>
    <script src="${assets }/fastclick/fastclick.min.js"></script>
    <script src="${assets }/sparkline/sparkline.min.js"></script>
    <script src="${assets }/slimscroll/slimscroll.min.js"></script>
    <script src="${assets }/chartjs/chart.min.js"></script>
    <script type="text/javascript">
	    function skip(parameter){
	    	window.parent.frames.location.href=parameter;
	    }
    	$(document).ready(function(){
	    	
		});
	</script>
  </body>
</html>