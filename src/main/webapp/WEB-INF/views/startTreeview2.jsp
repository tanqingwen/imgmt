<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<!DOCTYPE html>
<html>
<title>综合管理系统 | ${item }</title>
<tags:head_common_content />
<script> 
		if (window != top) {
			top.location.href = location.href;
		}
	</script>
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="venue" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<section class="content-header">
				<h1>${item }</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
					<li class="active">${item }</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row" style="text-align: center;">
					<c:if test="${item eq '场馆管理' }">
						<c:if test="${app:checkPermission('TRMMST_GATE_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>闸机管理</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/trmmstgate/list')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
						<c:if test="${app:checkPermission('GATE_IP_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>闸机绑IP</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/gateip/list')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
						<c:if test="${app:checkPermission('VENUE_GROUP_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>场馆组配置</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/cpacqmer/list')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
						<%-- <c:if test="${app:checkPermission('TRMMST_GATE_LIST')}">
						<div class="col-lg-3 col-xs-6">
							<!-- small box -->
							<div class="small-box bg-aqua">
								<div class="inner">
									<h3>闸机管理</h3>
									<p>-------------------------------</p>
								</div>
								<div class="icon">
									<i class="ion ion-person-add"></i>
								</div>
								<a onclick="skip('${ctx }/trmmstgate/list')" class="small-box-footer">进入管理
									<i class="fa fa-arrow-circle-right"></i>
								</a>
							</div>
						</div>
						</c:if> --%>
						<c:if test="${app:checkPermission('VENUEALL_MERMST_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>终端管理</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/trmmstgate/mermstlist')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
					</c:if>
					<c:if test="${item eq '基本参数管理' }">
						<c:if test="${app:checkPermission('COUNTRY_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>国家管理</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/country_dict/list')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
						<c:if test="${app:checkPermission('PROVINCE_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>省份代码表</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/province_dict/list')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
						<c:if test="${app:checkPermission('CITYDICTATIONDICT_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>城市管理</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/city_dict/list')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
						<c:if test="${app:checkPermission('IDTYPE_LIST')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>证件类型管理</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/idtype_dict/list')"
										class="small-box-footer">进入管理 <i
										class="fa fa-arrow-circle-right"></i>
									</a>
								</div>
							</div>
						</c:if>
					</c:if>
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
			<!-- common js -->
			<tags:load_common_js />
			<script src="${assets }/fastclick/fastclick.min.js"></script>
			<script src="${assets }/sparkline/sparkline.min.js"></script>
			<script src="${assets }/slimscroll/slimscroll.min.js"></script>
			<script src="${assets }/chartjs/chart.min.js"></script>

			<script type="text/javascript">
    function skip(parameter){
    	window.parent.frames.location.href=parameter;
    }
	</script>
</body>
</html>