<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 票劵信息添加</title>
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
          <h1>票务信息添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/cptktype/list">票劵信息管理</a></li>
            <li class="active">票劵信息添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/cptktype/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="ttTypeId" class="col-sm-3 control-label">票种ID<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttTypeId" name="ttTypeId" readonly="readonly" value="${ttTypeIdd}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttTypeDesc" class="col-sm-3 control-label">票种描述<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttTypeDesc" name="ttTypeDesc" value=""/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttStartDate" class="col-sm-3 control-label">允许售票起始时间<font color="red">*</font></label>
								    <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" type="text" id="ttStartDate" name="ttStartDate" value="${nowTime}" onchange="countttExpirePeriod()" style="width: 116.5%"/>
	                                	</div>
	                                </div>
								</div>
								<div class="form-group">
								    <label for="ttEndDate" class="col-sm-3 control-label">允许售票结束时间<font color="red">*</font></label>
								    <div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" type="text" id="ttEndDate" name="ttEndDate" value="${nowTime}" onchange="countttExpirePeriod()" style="width: 116.5%"/>
	                                	</div>
	                                </div>
								</div>
								<div class="form-group uploadbox">
								    <label for="ttExpirePeriod" class="col-sm-3 control-label">票劵有效周期(天)<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttExpirePeriod" name="ttExpirePeriod" value="1" readonly="readonly"/>
								    </div>
								</div>
								<!-- 
								<div class="form-group uploadbox">
								    <label for="ttUserType" class="col-sm-3 control-label">用户类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttUserType" name="ttUserType">
								     	 	<option value="0">儿童</option>
					    					<option value="1">成人</option>
								      </select>
								    </div>
								</div>
								-->
								<div class="form-group">
								    <label for="ttAcqListsId" class="col-sm-3 control-label">场馆组<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttAcqListsId" name="ttAcqListsId">
								      	<c:forEach var="item" items="${cpAcqmer}">
								     		<option value="${item.amGroupId }">${item.amGroupId }-${item.amUserDefine1 }</option>
								     	</c:forEach>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttListPrice" class="col-sm-3 control-label">常规价格</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttListPrice" name="ttListPrice" title="不能为空" onchange="changettListPrice()" value=""/>
								    </div>
								</div>
								<%--   
								<div class="form-group date">
									<label for="ttDiscountRate1" class="col-sm-3 control-label">普通折扣率 </label>
									<div class="col-sm-8">
								      <select class="form-control" id="ttDiscountRate1" name="ttDiscountRate1" onchange="countttDiscountPrice1()">
								      	 <option value="0">不打折</option>
					    				 <option value="0.95">9.5折</option>
					    				 <option value="0.9">9折</option>
					    				 <option value="0.85">8.5折</option>
					    				 <option value="0.8">8折</option>
					    				 <option value="0.75">7.5折</option>
					    				 <option value="0.7">7折</option>
					    				 <option value="0.65">6.5折</option>
					    				 <option value="0.6">6折</option>
					    				 <option value="0.55">5.5折</option>
					    				 <option value="0.5">5折</option>
					    				 <option value="0.45">4.5折</option>
					    				 <option value="0.4">4折</option>
					    				 <option value="0.35">3.5折</option>
					    				 <option value="0.3">3折</option>
					    				 <option value="0.25">2.5折</option>
					    				 <option value="0.2">2折</option>
					    				 <option value="0.15">1.5折</option>
					    				 <option value="0.1">1折</option>
								      </select>
								    </div>
								</div>
								<div class="form-group date">
									<label for="ttDiscountPrice1" class="col-sm-3 control-label">普通折扣价 </label>
									<div class="col-sm-8">
								      <input type="text" class="form-control" id="ttDiscountPrice1" name="ttDiscountPrice1" title="不能为空" value="0" readonly="readonly"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttDiscountRate2" class="col-sm-3 control-label">特别折扣率</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttDiscountRate2" name="ttDiscountRate2"  disabled="disabled" onchange="countttDiscountPrice2()">
								      	 <option value="0">不打折</option>
								     	 <option value="0.95">9.5折</option>
					    				 <option value="0.9">9折</option>
					    				 <option value="0.85">8.5折</option>
					    				 <option value="0.8">8折</option>
					    				 <option value="0.75">7.5折</option>
					    				 <option value="0.7">7折</option>
					    				 <option value="0.65">6.5折</option>
					    				 <option value="0.6">6折</option>
					    				 <option value="0.55">5.5折</option>
					    				 <option value="0.5">5折</option>
					    				 <option value="0.45">4.5折</option>
					    				 <option value="0.4">4折</option>
					    				 <option value="0.35">3.5折</option>
					    				 <option value="0.3">3折</option>
					    				 <option value="0.25">2.5折</option>
					    				 <option value="0.2">2折</option>
					    				 <option value="0.15">1.5折</option>
					    				 <option value="0.1">1折</option>
								      </select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="ttDiscountPrice2" class="col-sm-3 control-label" >特别折扣价</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="ttDiscountPrice2" name="ttDiscountPrice2" disabled="disabled" value="0"/>
								    </div>
								</div>
								--%>
								<div class="form-group">
							    	<label for="ttTypeUser" class="col-sm-3 control-label">使用者</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttTypeUser" name="ttTypeUser">
								     	 <option value="">本系统</option>
					    				 <option value="V">V-外围</option>
								      </select>
								    </div>
								</div>
								<!-- 
								<div class="form-group">
							    	<label for="ttTypeStatus" class="col-sm-3 control-label">是否节假日显示</label>
								    <div class="col-sm-8">
								      <select class="form-control" id="ttTypeStatus" name="ttTypeStatus">
								     	 <option value="">否</option>
								     	 <option value="Y">是</option>
								      </select>
								    </div>
								</div> -->
                			</div>
                		</div>
					</div>
					<div class="box-footer">
						<div class="pull-right">
							<button id="addButton" type="submit" class="btn btn-info " onclick="return isnull()"><i class="fa fa-plus"></i> 添加</button>
							<a type="button" class="btn btn-default " href="${ctx }/cptktype/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
						</div>
<!-- 					 	<div class="col-sm-10 ">						 -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-1 ">	 -->
<!-- 							<button  type="submit" id="addButton" class="btn btn-info pull-right" onclick="return isnull()"><i class="fa fa-plus"></i> 添加</button>	                    	 -->
<!-- 	                    </div> -->
<!-- 	                    <div class="col-sm-1 "> -->
<%-- 	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/cptktype/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> --%>
<!-- 	                    </div>	                 	 -->
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
			  }
		}
		var formatStart=ttStartdate.replace(/^(\d{4})(\d{2})(\d{2})$/, "$1-$2-$3");
		var formatEnd=ttEnddate.replace(/^(\d{4})(\d{2})(\d{2})$/, "$1-$2-$3");
		var days = DateDiff(formatStart,formatEnd);
		// 票劵有效周期
		$("#ttExpirePeriod").val(days);
    }
    
  	//票券周期
    function  DateDiff(sDate1,  sDate2){    //sDate1和sDate2是2006-12-18格式  
        var  aDate,  oDate1,  oDate2,  iDays;  
        aDate  =  sDate1.split("-");  
        oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2006格式  
        aDate  =  sDate2.split("-");  
        oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0]);  
        iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24);    //把相差的毫秒数转换为天数  
        return  iDays;  
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
    	$('.firstCommission').datepicker({
   			format: 'yyyymmdd',
			autoclose: true,
			todayBtn : "linked",  
	        todayHighlight : true,  
	    }).on('hide',function(e){
	    	$('#stafffrom').data('bootstrapValidator').updateStatus('ttStartDate','NOT_VALIDATED',null).validateField('ttStartDate');
	    	$('#stafffrom').data('bootstrapValidator').updateStatus('ttEndDate','NOT_VALIDATED',null).validateField('ttEndDate');
	    });
    	$('#ttDiscountRate1').change(function(event){
    		
    		if($(this).val()!=0){
        		$('#ttDiscountRate2').attr('disabled','disabled');
        	}else{
        		$('#ttDiscountRate2').removeAttr('disabled','disabled');
        	}
    	})
    	
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
    </script>
  </body>
</html>
