<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
	<title>综合管理系统 |更新收费条目</title>
	<tags:head_common_content/>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
<div class="wrapper">
	<tags:main_header/>
	<tags:main_sidebar active="profile"/>
	<div class="content-wrapper">
		<div class="context-tips">
			<tags:action_tip/>
		</div>
		<section class="content-header">
			<h1>更新收费条目</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li><a href="#">机具收费管理</a></li>
				<li class="active">更新收费条目</li>
			</ol>
		</section>
        <section class="content">
      	<div class="box box-primary">

      		<div class="box-header with-border">
	            <h3 class="box-title"><i class="fa fa-plus"></i> 更新表单</h3>
            </div>
            
             <form id="cpPrdtrmUpdatePage" class="form-horizontal" method="post" action = "${ctx }/cpprdtrm/update">
                	<div class="box-body">
                			<div class="form-group">
							    <label for="id" class="col-sm-3 control-label">机具号<font color="red">*</font></label>
							    <div class="col-sm-8">
							    	<input style="width: 400px" readonly="readonly" type="text" class="form-control" name="pt_terminal_id" onkeyup="this.value=this.value.replace(/\s/g,'')" value="${item.pt_terminal_id}"/>
							    </div>
							</div>
							<div class="form-group">
							    <label for="level" class="col-sm-3 control-label">产品组<font color="red">*</font></label>
							    <div class="col-sm-8">
								    <input style="width: 400px" readonly="readonly" type="text" class="form-control" name="pt_prodct_group" onkeyup="this.value=this.value.replace(/\s/g,'')" value="${item.pt_prodct_group}"/>
							    </div>
							</div>
							<div class="form-group">
							    <label for="interval" class="col-sm-3 control-label">时间间隔</label>
							    <div class="col-sm-8">
								     <input style="width: 400px" type="text" class="form-control" name="pt_time_interval" onkeyup="this.value=this.value.replace(/\s/g,'')" value="${item.pt_time_interval}"/>
							    </div>
							</div>
							<div class="form-group">
							    <label for="discount" class="col-sm-3 control-label">折扣</label>
							    <div class="col-sm-8">
								    <input style="width: 400px" type="text" class="form-control" name="pt_discount" onkeyup="this.value=this.value.replace(/\s/g,'')" value="${item.pt_discount}"/>
							    </div>
							</div>
				</div>

				<div class="box-footer" >
					<div class="col-sm-1">	
						<table>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td>
									<button id="addButton" type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 更新</button>	                    	
								</td>
								<td>
			                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/cpprdtrm/mainpage"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
								</td>
							</tr>
						</table>
                    </div>
                </div>
        	</form>
		</div>
		</section>
		
    </div>
</div>
<tags:control_sidebar/>
<tags:load_common_js/>
<script src="${assets}/validator/js/validator.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#cpPrdtrmAddPage').bootstrapValidator({
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				pt_terminal_id: {
					validators: {
						notEmpty: {
							message: '机具号不能为空'
 						},
			 			stringLength: {
		                    max: 8,
		                    message: '机具号的长度不能超过8位'
		                }
 					}
 				},
	 			pt_prodct_group: {
					validators: {
						notEmpty: {
							message: '产品组不能为空'
 						},
		 				regexp: {
	                        regexp: /^[0-9]*$/,
	                        message: '产品组只能是数字'
	                    },
			 			stringLength: {
		                    max: 10,
		                    message: '产品组的长度不能超过10位'
		                }
 					}
 				},
 				pt_time_interval: {
					validators: {
			 			stringLength: {
		                    max: 2,
		                    message: '时间间隔的长度不能超过2位'
		                }
 					}
 				},
 				pt_discount: {
					validators: {
			 			stringLength: {
		                    max: 3,
		                    message: '折扣的长度不能超过3位'
		                }
 					}
 				}
 			}									 
		});
	
		 $("#addButton").click(function(){
		    	var time=document.getElementsByName("pt_time_interval");
				var discount=document.getElementsByName("pt_discount");

		 		if('${item.pt_time_interval}' == time[0].value && '${item.pt_discount}' == discount[0].value){
		 			alert("您未做任何修改！");
			 			return false; 
		 		}else{
					$("#cpPrdtrmUpdatePage").submit();
		 		}
		 
		    });
	});
    </script>
    
</body>
</html>
