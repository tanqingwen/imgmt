<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 票劵信息查看</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="cptktypelist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>票劵信息查看</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/cptktype/list">票劵信息管理</a></li>
            <li class="active">票劵信息查看</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-edit"></i> 查看表单</h3>
                </div><!-- /.box-header -->
                <form id="stafffrom" class="form-horizontal" method="post" action="${ctx }/cptktype/view">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
								<div class="form-group">
								    <label for="ttTypeId" class="col-sm-3 control-label">票种ID<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttTypeId" name="ttTypeId" title="不能为空" disabled="disabled" value="${item.ttTypeId}" readonly="readonly"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttTypeDesc" class="col-sm-3 control-label">票种描述<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttTypeDesc" name="ttTypeDesc" disabled="disabled" value="${item.ttTypeDesc}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttStartDate" class="col-sm-3 control-label">允许售票起始时间<font color="red">*</font></label>
								    <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" type="text" id="ttStartDate" name="ttStartDate" disabled="disabled" value="${item.ttStartDate}" onchange="countttExpirePeriod()" style="width: 116.5%"/>
	                                	</div>
	                                </div>
								</div>
								<div class="form-group uploadbox">
								    <label for="ttEndDate" class="col-sm-3 control-label">允许售票结束时间<font color="red">*</font></label>
								    <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" type="text" id="ttEndDate" name="ttEndDate" disabled="disabled" value="${item.ttEndDate}" onchange="countttExpirePeriod()" style="width: 116.5%"/>
	                                	</div>
	                                </div>
								</div>
								<div class="form-group uploadbox">
								    <label for="ttExpirePeriod" class="col-sm-3 control-label">票劵有效周期(天)<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttExpirePeriod" name="ttExpirePeriod" disabled="disabled" value="${item.ttExpirePeriod}" readonly="readonly"/>
								    </div>
								</div>
								<!--  
								<div class="form-group uploadbox">
								    <label for="ttUserType" class="col-sm-3 control-label">用户类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttUserType" name="ttUserType">
								     	 	<option value="0" ${item.ttUserType eq '0' ? 'selected' : ''}>儿童</option>
					    					<option value="1" ${item.ttUserType eq '1' ? 'selected' : ''}>成人</option>
								      </select>
								    </div>
								</div>
								-->
								<div class="form-group">
								    <label for="ttAcqListsId" class="col-sm-3 control-label">场馆组<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttAcqListsId" name="ttAcqListsId" disabled="disabled">
								      	<c:forEach var="items" items="${cpAcqmer}">
								     		<option value="${items.amGroupId }" ${items.amGroupId eq item.ttAcqListsId ? 'selected' : ''}>${items.amGroupId }-${items.amUserDefine1 }</option>
								     	</c:forEach>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttListPrice" class="col-sm-3 control-label">常规价格</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttListPrice" name="ttListPrice" title="不能为空" disabled="disabled" value="${item.ttListPrice}" onchange="changettListPrice()"/>
								    </div>
								</div> 
								<%--   
								<div class="form-group date">
									<label for="ttDiscountRate1" class="col-sm-3 control-label">普通折扣率 </label>
									<div class="col-sm-8">
								      <select class="form-control" id="ttDiscountRate1" name="ttDiscountRate1" onchange="countttDiscountPrice1()">
								      	 <option value="0" ${item.ttDiscountRate1 eq '0.000' ? 'selected' : ''}>不打折</option>
					    				 <option value="0.95" ${item.ttDiscountRate1 eq '0.950' ? 'selected' : ''}>9.5折</option>
					    				 <option value="0.9" ${item.ttDiscountRate1 eq '0.900' ? 'selected' : ''}>9折</option>
					    				 <option value="0.85" ${item.ttDiscountRate1 eq '0.850' ? 'selected' : ''}>8.5折</option>
					    				 <option value="0.8" ${item.ttDiscountRate1 eq '0.800' ? 'selected' : ''}>8折</option>
					    				 <option value="0.75" ${item.ttDiscountRate1 eq '0.750' ? 'selected' : ''}>7.5折</option>
					    				 <option value="0.7" ${item.ttDiscountRate1 eq '0.700' ? 'selected' : ''}>7折</option>
					    				 <option value="0.65" ${item.ttDiscountRate1 eq '0.650' ? 'selected' : ''}>6.5折</option>
					    				 <option value="0.6" ${item.ttDiscountRate1 eq '0.600' ? 'selected' : ''}>6折</option>
					    				 <option value="0.55" ${item.ttDiscountRate1 eq '0.550' ? 'selected' : ''}>5.5折</option>
					    				 <option value="0.5" ${item.ttDiscountRate1 eq '0.500' ? 'selected' : ''}>5折</option>
					    				 <option value="0.45" ${item.ttDiscountRate1 eq '0.450' ? 'selected' : ''}>4.5折</option>
					    				 <option value="0.4" ${item.ttDiscountRate1 eq '0.400' ? 'selected' : ''}>4折</option>
					    				 <option value="0.35" ${item.ttDiscountRate1 eq '0.350' ? 'selected' : ''}>3.5折</option>
					    				 <option value="0.3" ${item.ttDiscountRate1 eq '0.300' ? 'selected' : ''}>3折</option>
					    				 <option value="0.25" ${item.ttDiscountRate1 eq '0.250' ? 'selected' : ''}>2.5折</option>
					    				 <option value="0.2" ${item.ttDiscountRate1 eq '0.200' ? 'selected' : ''}>2折</option>
					    				 <option value="0.15" ${item.ttDiscountRate1 eq '0.150' ? 'selected' : ''}>1.5折</option>
					    				 <option value="0.1" ${item.ttDiscountRate1 eq '0.100' ? 'selected' : ''}>1折</option>
								      </select>
								    </div>
								</div>
								<div class="form-group date">
									<label for="ttDiscountPrice1" class="col-sm-3 control-label">普通折扣价 </label>
									<div class="col-sm-8">
								      <input type="text" class="form-control" id="ttDiscountPrice1" name="ttDiscountPrice1" title="不能为空" value="${item.ttDiscountPrice1}" readonly/>
								    </div>
								</div>
								--%>
								<%--  
								<div class="form-group">
								    <label for="ttDiscountRate2" class="col-sm-3 control-label">特别折扣率</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttDiscountRate2" name="ttDiscountRate2" onchange="countttDiscountPrice1()">
								      	 <option value="0" ${item.ttDiscountRate2 eq '0.000' ? 'selected' : ''}>不打折</option>
					    				 <option value="0.95" ${item.ttDiscountRate2 eq '0.950' ? 'selected' : ''}>9.5折</option>
					    				 <option value="0.9" ${item.ttDiscountRate2 eq '0.900' ? 'selected' : ''}>9折</option>
					    				 <option value="0.85" ${item.ttDiscountRate2 eq '0.850' ? 'selected' : ''}>8.5折</option>
					    				 <option value="0.8" ${item.ttDiscountRate2 eq '0.800' ? 'selected' : ''}>8折</option>
					    				 <option value="0.75" ${item.ttDiscountRate2 eq '0.750' ? 'selected' : ''}>7.5折</option>
					    				 <option value="0.7" ${item.ttDiscountRate2 eq '0.700' ? 'selected' : ''}>7折</option>
					    				 <option value="0.65" ${item.ttDiscountRate2 eq '0.650' ? 'selected' : ''}>6.5折</option>
					    				 <option value="0.6" ${item.ttDiscountRate2 eq '0.600' ? 'selected' : ''}>6折</option>
					    				 <option value="0.55" ${item.ttDiscountRate2 eq '0.550' ? 'selected' : ''}>5.5折</option>
					    				 <option value="0.5" ${item.ttDiscountRate2 eq '0.500' ? 'selected' : ''}>5折</option>
					    				 <option value="0.45" ${item.ttDiscountRate2 eq '0.450' ? 'selected' : ''}>4.5折</option>
					    				 <option value="0.4" ${item.ttDiscountRate2 eq '0.400' ? 'selected' : ''}>4折</option>
					    				 <option value="0.35" ${item.ttDiscountRate2 eq '0.350' ? 'selected' : ''}>3.5折</option>
					    				 <option value="0.3" ${item.ttDiscountRate2 eq '0.300' ? 'selected' : ''}>3折</option>
					    				 <option value="0.25" ${item.ttDiscountRate2 eq '0.250' ? 'selected' : ''}>2.5折</option>
					    				 <option value="0.2" ${item.ttDiscountRate2 eq '0.200' ? 'selected' : ''}>2折</option>
					    				 <option value="0.15" ${item.ttDiscountRate2 eq '0.150' ? 'selected' : ''}>1.5折</option>
					    				 <option value="0.1" ${item.ttDiscountRate2 eq '0.100' ? 'selected' : ''}>1折</option>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttDiscountPrice2" class="col-sm-3 control-label">特别折扣价</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttDiscountPrice2" name="ttDiscountPrice2" value="${item.ttDiscountPrice2}" readonly/>
								    </div>
								</div>
								--%>
								<div class="form-group">
							    	<label for="ttTypeUser" class="col-sm-3 control-label">使用者</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttTypeUser" name="ttTypeUser" disabled="disabled">
								     	 <option value=" " ${item.ttTypeUser eq '' ? 'selected' : ''}>本系统</option>
					    				 <option value="V" ${item.ttTypeUser eq 'V' ? 'selected' : ''}>V-外围</option>
								      </select>
								    </div>
								</div>
								<div class="form-group">
							    	<label for="ttTypeUser" class="col-sm-3 control-label">是否有效</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttTypeStatus" name="ttTypeStatus" disabled="disabled">
								     	 <option value="Y" ${item.ttTypeStatus eq 'Y' ? 'selected' : ''}>有效</option>
					    				 <option value="N" ${item.ttTypeStatus eq 'N' ? 'selected' : ''}>无效</option>
								      </select>
								    </div>
								</div>
								<%-- 
								<div class="form-group">
							    	<label for="ttTypeStatus" class="col-sm-3 control-label">是否节假日显示</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttTypeStatus" name="ttTypeStatus">
								     	 <option value=" " ${item.ttTypeStatus eq '' ? 'selected' : ''}>否</option>
								     	 <option value="Y" ${item.ttTypeStatus eq 'Y' ? 'selected' : ''}>是</option>
								      </select>
								    </div>
								</div>
								--%>
                			</div>
                		</div>
					</div>					 
	                <div class="box-footer">
	                	<div class="pull-right">
	                		<!--  
	                    	<button type="submit" class="btn btn-info" id="addButton"><i class="fa fa-save"></i> 更新</button>	
	                    	-->
	                    	<a type="button" class="btn btn-default" href="${ctx }/cptktype/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
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
    function countttExpirePeriod(){
    	var ttStartdate = $("#ttStartDate").val();
		var ttEnddate = $("#ttEndDate").val();
		if(ttStartdate != "" && ttEnddate != ""){
			if(Number(ttStartdate)>Number(ttEnddate)){
				$("#ttExpirePeriod").val("无效");
				return false;
			}else{
//		     	票劵有效周期
				$("#ttExpirePeriod").val($("#ttEndDate").val()-$("#ttStartDate").val()+1);
			}
		}
    }
    function changettListPrice(){
    	countttDiscountPrice1();
    	countttDiscountPrice2();
    }
    //普通折扣价
    function countttDiscountPrice1(){
    	var ttListPrice = $("#ttListPrice").val();//常规价格
		var ttDiscountRate1 = $("#ttDiscountRate1").val();//普通折扣率
		$("#ttDiscountPrice1").val(ttListPrice*ttDiscountRate1);//普通折扣价
    }
    //特别折扣价
    function countttDiscountPrice2(){
    	var ttListPrice = $("#ttListPrice").val();//常规价格
		var ttDiscountRate2 = $("#ttDiscountRate2").val();//特别折扣率
		$("#ttDiscountPrice2").val(ttListPrice*ttDiscountRate2);//特别折扣价
    }
    
	$(document).ready(function(){
		
		$('.firstCommission').datepicker({
   			format: 'yyyymmdd',
			autoclose: true,
			todayBtn : "linked",  
	        todayHighlight : true,  
	    }).on('hide',function(e){
	    	$('#stafffrom').data('bootstrapValidator').updateStatus('ttStartDate','NOT_VALIDATED',null).validateField('ttStartDate');
	    	$('#stafffrom').data('bootstrapValidator').updateStatus('ttEndDate','NOT_VALIDATED',null).validateField('ttEndDate');
	    });
		
		$("#addButton").click(function(){
		    var ttStartdate = $("#ttStartDate").val();
			var ttEnddate = $("#ttEndDate").val();
			if(ttStartdate != "" && ttEnddate != ""){
				if(Number(ttStartdate)>Number(ttEnddate)){
					alert("售票起始时间不可以大于售票结束时间！");
					return false;
				}
			}
		});
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				ttTypeDesc: {
					validators: {
						notEmpty: {
							message: '类型描述不能为空'
							}
					}
 				},
 				ttStartDate: {
					validators: {
						notEmpty: {
							message: '请选择允许售票起始时间'
							}
					}
 				},
 				ttEndDate: {
					validators: {
						notEmpty: {
							message: '请选择允许售票结束时间'
							}
					}
 				},
 				ttListPrice: {
					validators: {
						notEmpty: {
							message: '常规价格不能为空'
							}
					}
 				}
 			}
   		}); 	
   		
	});
	
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
