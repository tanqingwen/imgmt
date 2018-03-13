<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 票务信息添加</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets }/css/datepicker.min.css" />
<link rel="stylesheet" href="${assets }/ticketoo/css/layer.css" />
<link rel="stylesheet" href="${assets }/ticketoo/css/ticketUpdate2.css" />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="cptktypelist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>票务信息添加</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
					<li><a href="${ctx }/cptktype/list">票务信息管理</a></li>
					<li class="active">票务信息添加</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid ticketUpdate  ticketAdd">
				<div class="row">
					<div class="tip-img">
						<p style="line-height:30px; font-size:20px;">票务信息添加</p>
					</div>
					<div class="content">
						 <div class="main">
                            <h3 style="border-bottom: 2px dashed #45a0e0;">设置</h3>
                            <div class="form-inline form-horizontal">
                                <div class="col-md-12 ticket-first">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>票种ID
                                                <span class="color-red">*</span>:
                                            </label>
                                            <input class="form-control formConl line-input" type="text" id="ttTypeId" name="ttTypeId" readonly="readonly" value="" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="ttName">票券名称
                                                <span class="color-red">*</span>:
                                            </label>
                                            <input class="form-control formConl line-input" type="text" id="ttName" name="ttName" value="" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12 ticket-first">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="ttTypeList">票券种类
                                                <span class="color-red">*</span>:
                                            </label>
                                            <select name="ttTypeList" id="ttTypeList" class="line-input">
                                                <option value="O">普通票券</option>
                                                <option value="Y">年票</option>
                                                <option value="Q">季票</option>
                                                <option value="M">月票</option>
                                                <option value="H">小时票</option>
                                                <option value="P">促销票</option>
                                            </select>

                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="ttVunueList">场馆组
                                                <span class="color-red">*</span>:
                                            </label>
                                            <select name="ttVunueList" id="ttVunueList" class="line-input">
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12" style="margin-top: 20px;">
                                    <div class="col-md-6">
                                        <label for="ttStartDate" class="labelWidth">允许售票起始时间<span class="color-red">*</span>：</label>
                                        <div class="input-group groupDis groupDis2 date ">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-calendar"></i>
                                            </span>
                                            <input readonly class="form-control dateWidth" type="text" id="ttStartDate" name="ttStartDate" value="">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6">
                                        <label for="ttEndDate" class="labelWidth">允许售票终止时间<span class="color-red">*</span>：</label>
                                        <div class="input-group groupDis groupDis2 date ">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-calendar"></i>
                                            </span>
                                            <input readonly class="form-control dateWidth" type="text" id="ttEndDate" name="ttEndDate" value="">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="validity">票务有效周期(天)
                                                <span class="color-red">*</span>:
                                            </label>
                                            <input class="form-control formConl line-input" type="text" id="validity" name="validity" value="" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="ttListPrice">常规价格
                                                <span class="color-red">*</span>:
                                            </label>
                                            <input class="form-control formConl line-input" id="ttListPrice" name="ttListPrice" title="不能为空" value="" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12 discount">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="ttDiscount">票券折扣
                                                <span class="color-red">*</span>:
                                            </label>
                                            <input class="form-control formConl line-input" type="text" id="ttDiscount" name="ttDiscount" value="" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 submit-group marginTop marginBottom">
                                    <a href="/rest/tktype/manager.htm" class="form-a" type="button">&lt;返回</a>
                                    <div class="btn-group fr">
                                        <button type="button" class="btn-size" style="width: 110px;" id="addButton">添加</button>
                                    </div>
                                </div>
                            </div>

                        </div>
					</div>
				</div>

			</div>
		</div>
		<!-- /.box -->
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/rest/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	$(document).ready(function () {
	    // 初始化
	    getTicketID();
	    getVunue();
	    // 票券种类
	    $('#ttAcqListsId').change(function () {
	        $(this).val() == 'P' ? $('.discount').show() : $('.discount').hide();
	    });


	    // 允许售票起始时间
	    $('#ttStartDate').click(function () {
	        var d = new Date();
	        var y = d.getFullYear();
	        var m = d.getMonth()+1 < 10?"0"+(d.getMonth()+1):(d.getMonth()+1);
	        var t = d.getDate();
	        var dt =y+"-"+m+"-"+t; 
	        var maxD = $('#ttEndDate').val().split(" ")[0];
	        WdatePicker({ el: this, dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:dt,maxDate:maxD,});
	    });

	    // 允许售票终止时间
	    $('#ttEndDate').click(function () {
	        var d = $('#ttStartDate').val();
	        WdatePicker({ el: this, dateFmt: 'yyyy-MM-dd HH:mm:ss', minDate:d,});
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
	                        message: '票券名称不能为空'
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
	                    },
	                    regexp: {
	                        regexp: /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/,
	                        message: '请输入正确的价格'
	                    }
	                }
	            },
	            validity: {
	                validators: {
	                    notEmpty: {
	                        message: '有效天数不能为空'
	                    },
	                    regexp: {
	                        regexp: /^([1-9]\d*|[0]{1,1})$/,
	                        message: '请输入正确的有效天数'
	                    }
	                }
	            }
	        }
	    });


	    // 增加
	    $('#addButton').click(function () {
	        var ttTypeId = $('#ttTypeId').val();
	        var ttName = $('#ttName').val();
	        var ttTypeList = $('#ttTypeList').val();
	        var ttVunueList = $('#ttVunueList').val();
	        var ttStartDate = $('#ttStartDate').val();
	        console.log(typeof ttStartDate );
	        var ttEndDate = $('#ttEndDate').val();
	        var validity = $('#validity').val();
	        var ttListPrice = parseFloat($('#ttListPrice').val());
	        var ttDiscount = parseInt($('#ttDiscount').val());
	        console.log(ttDiscount);
	        var info = {
	            "ticketId": ttTypeId,
	            "ticketName": ttName,
	            "price": ttListPrice,
	            "ticketType": ttTypeList,
	            "discount": ttDiscount,
	            "validity": validity,
	            "allowNonReal": 0,
	            "venuGroupId":ttVunueList,
	            "year": [],
	            "years": [ttStartDate+","+ttEndDate]
	        };
	        $.ajax({
	            url: "http://192.168.1.50:3551/rest/tktype/add",
	            type: "POST",
	            dataType: "json",
	            data: {'data':JSON.stringify(info)},
	            success: function (data) {
	                console.log(data);
	                if (data.status == "OK") {
	                    $("#ttTypeId").val(data.value);
	                } else {
	                    alert("提交数据失败");
	                }
	            },
	            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                alert("error");
	                console.log(XMLHttpRequest + textStatus + errorThrown);
	            }
	        });
	    });

	});

	// 获取票种ID
	function getTicketID() {
	    $.ajax({
	        url: "http://192.168.1.50:2017/yanwu/service/primiary/ID?idType=tkType",
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	            if (data.status == "OK") {
	                $("#ttTypeId").val(data.value);
	            } else {
	                alert("获取票种ID失败");
	            }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            alert("error");
	            console.log(XMLHttpRequest + textStatus + errorThrown);
	        }
	    });
	}


	// 获取场馆组
	function getVunue() {
	    $.ajax({
	        url: "http://localhost:3551/rest/venueGroup/list",
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	            if (data.status == "OK") {
	                var list = data.value;
	                var op = '';
	                for (var i in list) {
	                    op += '<option value=' + list[i].amGroupId + '>' + list[i].amUserDefine1 + '</option>';
	                }
	                $("#ttVunueList").append(op);
	            } else {
	                alert("获取场馆组失败");
	            }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            alert("error");
	            console.log(XMLHttpRequest + textStatus + errorThrown);
	        }
	    });
	}
	</script>
</body>
</html>
