<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 场馆配置添加</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
    
    <style>
		.ticket-type {
    position:relative;
    float:right;
    width:100%;
    height:38px;
    line-height:38px;
   	text-indent:10px;
    border:1px solid #b3b3b3;
    background-color:#fff;
}
.ticket-type:hover .all-ticket {
    display: block;
}
.all-ticket {
    display: none;
    position:absolute;
    top:33px;
    left:13px;
    z-index: 1;
    width:94%;
    height:152px;
    overflow-y:auto;
    background-color:#fff;
    border:1px solid #b3b3b3;
    list-style: none;
    padding:0;
}
.all-ticket li {
    height:30px;
    display:inline-block;
    width:100%;
    text-indent:10px;
}
.all-ticket li i{
font-style:normal;
}
.ttt{
    width:15px;
    height:15px;
    verticla-align:middle;
}
.ticket-info{
height:20px;
margin:0 10px;
position:Relative;
bottom:5px;
}
    </style>
    
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
          <h1>场馆配置添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
			<li><a href="${ctx }/cpacqmer/list">场馆配置</a></li>
            <li class="active">场馆配置添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" enctype="multipart/form-data"  method="post" action="${ctx }/cpacqmer/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="" class="col-sm-3 control-label">场馆组编号<font color="red">*</font></label>
								    <div class="col-sm-8">
								    	<input type="text" readonly="readonly" class="form-control" id="amGroupId" name="amGroupId" value="${cpAcqmer.amGroupId}"/>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="" class="col-sm-3 control-label">场馆组名称:<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="amUserDefine1" name="amUserDefine1"/>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="ticket_type" class="col-sm-3 control-label">场馆编号<font color="red">*</font></label>
								    <div class="col-sm-8" id="ticket-p">
							      		<input class="ticket-type-text"  id='amMerchantId' name ="amMerchantId" value="" title="不能为空" style="text-indent:10px;width:100%;height:34px;line-height:40px;display:block; border:1px solid lightblue; margin:0; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
                                		<ul class="all-ticket" >
	                                		<c:forEach var="item" items="${cpMermsts}">
							      				<li class="ticket-li"><input class="ttt" id="varTk_ticket_type" name="ttt" type="checkbox" value="${item.mmMerchantNo }" style="width:20px;height:20px;margin-top:8px;"><span class="ticket-info" ><i>${item.mmMerchantNo }-${item.mmBizName }</i></span></li>
							      			</c:forEach>
                               			</ul>
                            		</div>
								</div>
								
								<div class="form-group">
								    <label for="" class="col-sm-3 control-label">场馆主图:<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="file" name="file" value=""/>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="" class="col-sm-3 control-label">场馆详细图:<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="file" name="files"/>
								      <input type="file" name="files"/>
								    </div>
								</div>
								
								<div class="form-group">
								    <label for="amRecycleType" class="col-sm-3 control-label">重复入园标志<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select class="form-control" id="amRecycleType" name="amRecycleType">
								     	 	<!--  
								     	 	<option value='N'>N-否</option>
	          							    -->
	          							    <option value='Y'>Y-是</option>
								      </select>
								    </div>
								</div>
								<!--  
								<div class="form-group">
								    <label for="amRecycleDate" class="col-sm-3 control-label">重复使用次数<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="amRecycleDate" name="amRecycleDate" value=""/>
								    </div>
								</div>
								-->
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button  type="submit" id="addButton" class="btn btn-info"><i class="fa fa-plus"></i> 添加</button>
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
    $(document).ready(function(){
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
   		});
	}); 
    

    $("#ticket-p").hover(function(){
		$(".all-ticket").show();
	},function(){
		$(".all-ticket").hide();
	}
	);
    
    $(function(){
    	var chk_value =[];     	  
    	$(".ticket-li").on('click',function(){
    	chk_value=[];
    	$('input[name="ttt"]:checked').each(function(){
    		chk_value.push($(this).siblings('.ticket-info').find('i').html()); 
    	});
    	
    	chkvalue=[];
    	$('input[name="ttt"]:checked').each(function(){
    		chkvalue.push($(this).val()); 
    	/* console.log(chkvalue); */
    	});
    	
	    $(".ticket-type-text").text(chk_value);
	    $(".ticket-type-text").val(chkvalue); 
	   	console.log( $(".ticket-type-text").val());
    	})
    });
    </script>
  </body>
</html>
