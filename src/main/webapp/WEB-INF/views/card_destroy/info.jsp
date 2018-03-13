<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
	<title>综合管理系统|退卡</title>
	<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	<!-- this "tags" contains all the patterns we need in this page -->
	<tags:head_common_content/>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">

<!-- Main header, top yellow bar -->
<tags:main_header/>

<!-- Left column, contains the logo and sidebar -->
<tags:main_sidebar active="profile"/>

<!-- here use a wrapper so that the content won't be influenced by sidebar -->
<div class="content-wrapper">

<!-- This class contains tip on the top of wrapper. Ordinarily it's invisible. -->
<div class="context-tips">
	<tags:action_tip/>
</div>

<!-- title of the real content -->
<section class="content-header">
	<h1>退卡</h1>
	<ol class="breadcrumb">
		<li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li><a href="${ctx}/CardDestroy/list">退卡-卡信息查询</a></li>
		<li class="active">退卡</li>
	</ol>
</section>

<!-- content of the real content -->
<section class="content">
<div class="box box-body">
	<form class="form-horizontal" action="${ctx}/CardDestroy/destroy">
		<div class="box-body">
	  		<div class="form-group">
			    <label class="col-sm-2 control-label">卡号</label>
			    <div class="col-sm-3">
			    	<input class="form-control" readonly="readonly" name="cbCardholderNo" value="${cpCrdtbl.cbCardholderNo}"/>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">会员ID</label>
			    <div class="col-sm-3">
			    	<input class="form-control" readonly="readonly" name="cbIdno" value="${cpCrdtbl.cbIdno}"/>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">卡状态</label>
			    <div class="col-sm-3">
			    	<input class="form-control" readonly="readonly" value="${cpCrdtbl.cbPlasticCd}"/>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">开卡日期</label>
			    <div class="col-sm-3">
			    	<input class="form-control" readonly="readonly" value="${cpCrdtbl.cbPlasticDate}"/>
			    </div>
			</div>
			<div class="form-group">
			    <label class="col-sm-2 control-label">押金</label>
			    <div class="col-sm-3">
			    	<input class="form-control" readonly="readonly" name="cbCvki" value="${cpCrdtbl.cbCvki}"/>
			    </div>
			</div>
		</div>
		
		<div class="box box-footer">
			<div class="col-sm-9">
			</div>
			<div class="col-sm-1">
				<button type="submit" class="btn btn-info"><i class="fa fa-plus"></i> 退卡</button>
            </div>
            <div class="col-sm-1">
               	<a type="button" class="btn btn-default" href="${ctx}/CardDestroy/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
            </div>
		</div>
	</form>
</div>
</section>

<!-- to make an effect of the right sidebar -->
<tags:control_sidebar/>

<!-- 160809刘立人，该tag文件包含一个js脚本，实现侧边栏的收缩效果。该效果做得非常6！ -->
<tags:load_common_js/>

</div>
</body>
</html>
