<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>

<html>
  <head>
    <title>综合管理系统 | ${item }</title>
    <tags:head_common_content/>
    <script> 
		if (window != top) {
			top.location.href = location.href;
		}
	</script>
	<style>
	 	h3{
	 		font-size:35px;
	 	}
	</style>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="venue"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
		      	<section class="content-header">
		          <h1>${item }</h1>
		          <ol class="breadcrumb">
		            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
		            <li class="active">${item }</li>
		          </ol>
		        </section>
		
		        <!-- Main content -->
		        <section class="content">
				    <div class="row" style="text-align: center;">
				    	<c:if test="${item eq '现场管理' }">
					    	<c:if test="${app:checkPermission('VENUE_ENTRY_LIST')}">
						        <div class="col-lg-3 col-xs-6">
						          <!-- small box -->
						          <div class="small-box bg-aqua">
						            <div class="inner">
						              <h3>场馆录入</h3>
						              <p>-------------------------------</p>
						            </div>
						            <div class="icon">
						              <i class="ion ion-person-add"></i>
						            </div>
						            	<a onclick="skip('${ctx }/cpmeracc/venueDataEntering')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            </a>
						          </div>
						        </div>
					        </c:if>
					        
					        <c:if test="${app:checkPermission('VENUE_LIST')}">
						        <div class="col-lg-3 col-xs-6">
						          <!-- small box -->
						          <div class="small-box bg-aqua">
						            <div class="inner">
						              <h3>场馆查询</h3>
						              <p>-------------------------------</p>
						            </div>
						            <div class="icon">
						              <i class="ion ion-person-add"></i>
						            </div>
						            	<a onclick="skip('${ctx }/cpmermst/venuePreserve')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            </a>
						          </div>
						        </div>
					        </c:if>
					        					        
					        <c:if test="${app:checkPermission('VENUE_MAINTAIN_LIST')}">
						        <div class="col-lg-3 col-xs-6">
						          <!-- small box -->
						          <div class="small-box bg-aqua">
						            <div class="inner">
						              <h3>场馆维护</h3>
						              <p>-------------------------------</p>
						            </div>
						            <div class="icon">
						              <i class="ion ion-person-add"></i>
						            </div>
						            	<a onclick="skip('${ctx }/cpmermst/vmerupdPreserve')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            </a>
						          </div>
						        </div>
					        </c:if>
					        
					        <c:if test="${app:checkPermission('MERACC_ENTRY_LIST')}">
						        <div class="col-lg-3 col-xs-6">
						          <!-- small box -->
						          <div class="small-box bg-aqua">
						            <div class="inner">
						              <h3>商户录入</h3>
						              <p>-------------------------------</p>
						            </div>
						            <div class="icon">
						              <i class="ion ion-person-add"></i>
						            </div>
						            	<a onclick="skip('${ctx }/cpmeracc/merchantDataEntering')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            </a>
						          </div>
						        </div>
					        </c:if>					     				        
					        
					        <c:if test="${app:checkPermission('MERMST_LIST')}">
						        <div class="col-lg-3 col-xs-6">
						          <!-- small box -->
						          <div class="small-box bg-aqua">
						            <div class="inner">
						              <h3>商户查询</h3>
						              <p>-------------------------------</p>
						            </div>
						            <div class="icon">
						              <i class="ion ion-person-add"></i>
						            </div>
						            	<a onclick="skip('${ctx }/cpmermst/merchantPreserve')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            </a>
						          </div>
						        </div>
					        </c:if>					        
					        
					        <c:if test="${app:checkPermission('MERUPD_MAINTAIN_LIST')}">
						        <div class="col-lg-3 col-xs-6">
						          <!-- small box -->
						          <div class="small-box bg-aqua">
						            <div class="inner">
						              <h3>商户维护</h3>
						              <p>-------------------------------</p>
						            </div>
						            <div class="icon">
						              <i class="ion ion-person-add"></i>
						            </div>
						            	<a onclick="skip('${ctx }/staff/merupdPreserve')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            </a>
						          </div>
						        </div>
					        </c:if>
					        
					        <div class="col-lg-3 col-xs-6">
					          <!-- small box -->
					          <div class="small-box bg-aqua">
					            <div class="inner">
					              <h3>场馆管理</h3>
					              <p>-------------------------------</p>
					            </div>
					            <div class="icon">
					              <i class="ion ion-person-add"></i>
					            </div>
					            	<a onclick="skip('${ctx }/startTreeviewDetail/cggl')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
					            </a>
					          </div>
					        </div>
					    </c:if> 
	
						<c:if test="${item eq '票务作业' }">						
							<c:if test="${app:checkPermission('CRDTBL_LIST')}">
								<div class="col-lg-3 col-xs-6">
					          	<!-- small box -->
						          	<div class="small-box bg-aqua">
						            	<div class="inner">
						              		<h3>实卡激活</h3>
						              			<p>-------------------------------</p>
						            	</div>
						            	<div class="icon">
						             		<i class="ion ion-person-add"></i>
						           		</div>
						            	<a onclick="skip('${ctx }/crdtbl/activeCard')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            	</a>
						          	</div>
					        	</div>
					        </c:if>
							<c:if test="${app:checkPermission('BUYTICKET_ADD')}">
								<div class="col-lg-3 col-xs-6">
					          	<!-- small box -->
						          	<div class="small-box bg-aqua">
						            	<div class="inner">
						              		<h3>实名购票</h3>
						              			<p>-------------------------------</p>
						            	</div>
						            	<div class="icon">
						             		<i class="ion ion-person-add"></i>
						           		</div>
						            	<a onclick="skip('${ctx }/cpticket/ceshi2')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            	</a>
						          	</div>
					        	</div>
					        </c:if>
					        <c:if test="${app:checkPermission('INTCARD_ADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>实名订单取票</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/intcrdtbl/add')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
					        <c:if test="${app:checkPermission('NON_BUYTICKET_ADD')}">
								<div class="col-lg-3 col-xs-6">
					          	<!-- small box -->
						          	<div class="small-box bg-aqua">
						            	<div class="inner">
						              		<h3>非实名购票</h3>
						              			<p>-------------------------------</p>
						            	</div>
						            	<div class="icon">
						             		<i class="ion ion-person-add"></i>
						           		</div>
						            	<a onclick="skip('${ctx }/cpticket/tictek')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            	</a>
						          	</div>
					        	</div>
					        </c:if>
					        <c:if test="${app:checkPermission('NON_REAL_NAME_VOTING')}">
								<div class="col-lg-3 col-xs-6">
					          	<!-- small box -->
					          	
						          	<div class="small-box bg-aqua">
						            	<div class="inner">
						              		<h3>非实名订单取票</h3>
						              			<p>-------------------------------</p>
						            	</div>
						            	<div class="icon">
						             		<i class="ion ion-person-add"></i>
						           		</div>
						            	<a onclick="skip('${ctx }/intcrdtbl/nonAdd')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            	</a>
						          	</div>
					        	</div>
					        </c:if>
					        		
							<%-- <c:if test="${app:checkPermission('STAFF_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>订单退票作业</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cpticket/back')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if> --%>
					        <c:if test="${app:checkPermission('CPTICKET_BACK')}">
								<div class="col-lg-3 col-xs-6">
					          	<!-- small box -->
					          	
						          	<div class="small-box bg-aqua">
						            	<div class="inner">
						              		<h3>订单退票作业</h3>
						              			<p>-------------------------------</p>
						            	</div>
						            	<div class="icon">
						             		<i class="ion ion-person-add"></i>
						           		</div>
						            	<a onclick="skip('${ctx }/cpticket/back')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            	</a>
						          	</div>
					        	</div>
					        </c:if>
					        <c:if test="${app:checkPermission('ORDER_REFUND_LIST')}">
								<div class="col-lg-3 col-xs-6">
					          	<!-- small box -->
					          	
						          	<div class="small-box bg-aqua">
						            	<div class="inner">
						              		<h3>订单多方式退票</h3>
						              			<p>-------------------------------</p>
						            	</div>
						            	<div class="icon">
						             		<i class="ion ion-person-add"></i>
						           		</div>
						            	<a onclick="skip('${ctx }/yworder/orderrefund')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            	</a>
						           	</div>
					        	</div>
					        </c:if>
					        <%-- <c:if test="${app:checkPermission('CARD_ADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>窗口开卡作业</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/crdtbl/add')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if> --%>
							<%-- <c:if test="${app:checkPermission('BATCHCARD_ADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>批量制卡作业</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/batchcrdtbl/add')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if> --%>
							<c:if test="${app:checkPermission('PRTICKET_ADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>公关赠票</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/prticke/add')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							
					
							<c:if test="${app:checkPermission('STAFF_SHIFT')}">
								<div class="col-lg-3 col-xs-6">
					          	<!-- small box -->
						          	<div class="small-box bg-aqua">
						            	<div class="inner">
						              		<h3>员工交接班</h3>
						              			<p>-------------------------------</p>
						            	</div>
						            	<div class="icon">
						             		<i class="ion ion-person-add"></i>
						           		</div>
						            	<a onclick="skip('${ctx }/shifting/add')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
						            	</a>
						          	</div>
					        	</div>
					        </c:if>
						</c:if>
						<c:if test="${item eq '会员卡作业' }">
							<c:if test="${app:checkPermission('AMOUNT_ADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡充值</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/CardRecharge/add')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('LOSS_ADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡挂失</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/blkmlc/add')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('LOSS_OPENADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡解挂</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/blkmlc/openadd')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('OPENLOSS_ADD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡补办</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/CardSupplement/add')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('MEMBER_WITHDRAWALS')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡提现</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cpticket/tixian')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
						</c:if>
						<c:if test="${item eq '会员管理' }">
							<c:if test="${app:checkPermission('PRDGRP_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员等级</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/prdgrp/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
						</c:if>
						<c:if test="${item eq '业务管理' }">
							<c:if test="${app:checkPermission('CPTKTYPE_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>票务信息管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cptktype/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('CPCOMMODITY_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>商品信息管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cpCommodity/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('CPDISCOUNT_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>优惠券信息管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cpDiscount/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>							
						</c:if>
						<c:if test="${item eq '业务查询' }">
							<c:if
								test="${app:checkPermission('ORDER_QUERY')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>订单查询</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/yworder/yworderQueryStat')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('CPCEPTRX_BUYTICKETSTAT')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>购票信息查询</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cpceptrx/buyTicketStat')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('VIPCARDSTAT_VIPINFOSTAT')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡信息查询</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/vipcardStat/vipInfoStat')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if
								test="${app:checkPermission('VIPCARDSTAT_LISTCARDSALEINFO')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>卡片交易详情</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/vipcardStat/listCardSaleInfo')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
						</c:if>
						<c:if test="${item eq '统计报表' }">
							<%-- <c:if test="${app:checkPermission('BUY_TICKET')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>购票统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a href="#" class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if> --%>
							<%-- <c:if test="${app:checkPermission('OPEN_CARD')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>开卡统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a href="#" class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if> --%>
							<c:if test="${app:checkPermission('CPCEPTRX_RETURNTICKETSTAT')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>退票统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cpceptrx/returnTicketStat')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
						<%-- 	<c:if test="${app:checkPermission('CPCEPTRX_CONVERTTICKETSTAT')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>转票统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/cpceptrx/convertTicketStat')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if> --%>
							<c:if test="${app:checkPermission('OPEARTION_EXPENSE')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡消费统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/opeartion/expense')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('RECHARGE_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡充值统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/recharge/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('VIPCARDSTAT_VIPCHANGESTAT')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡换卡统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/vipcardStat/vipChangeStat')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('VIPCARDSTAT_VIPCASESTAT')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡情况统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/vipcardStat/vipCaseStat')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('OPEARTION_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>会员卡操作统计</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/opeartion/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('FINANCIAL_WATER')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>流水报表下载</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/financial/water')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('FINANCIAL_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>财务报表下载</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/financial/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
						</c:if>
						<c:if test="${item eq 'web维护' }">
							<c:if test="${app:checkPermission('YWVENUE_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>景点信息管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/ywvenue/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('YWRESTAURANT_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>餐厅信息管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/ywrestaurant/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
						</c:if>
						<c:if test="${item eq '系统管理' }">
							<c:if test="${app:checkPermission('STAFF_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>员工管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/staff/list')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('ROLE_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>角色管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/role/list')" class="small-box-footer">进入管理
											<i class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('DEPARTMENT_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>部门管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/department/depttree')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('PERMISSION_MANAGEMENT_LIST')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>权限管理</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/function/funttree')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('OPTION_LOGIN_CONFIG_SHOW')}">
								<div class="col-lg-3 col-xs-6">
									<!-- small box -->
									<div class="small-box bg-aqua">
										<div class="inner">
											<h3>登录参数</h3>
											<p>-------------------------------</p>
										</div>
										<div class="icon">
											<i class="ion ion-person-add"></i>
										</div>
										<a onclick="skip('${ctx }/option/login_config_show')"
											class="small-box-footer">进入管理 <i
											class="fa fa-arrow-circle-right"></i>
										</a>
									</div>
								</div>
							</c:if>
							<c:if test="${app:checkPermission('BASIC_PARAMETER_MANAGEMENT')}">
							<div class="col-lg-3 col-xs-6">
								<!-- small box -->
								<div class="small-box bg-aqua">
									<div class="inner">
										<h3>基本参数管理</h3>
										<p>-------------------------------</p>
									</div>
									<div class="icon">
										<i class="ion ion-person-add"></i>
									</div>
									<a onclick="skip('${ctx }/startTreeviewDetail/jbcsgl')"
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
					            	<a onclick="skip('${ctx }/idtype_dict/list')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
					            </a>
					          </div>
					        </div>
					        </c:if>
						</c:if>
		
						<%-- <c:if test="${item eq '基本参数管理' }">
						
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
					            	<a onclick="skip('${ctx }/province_dict/list')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
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
					            	<a onclick="skip('${ctx }/city_dict/list')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
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
					            	<a onclick="skip('${ctx }/idtype_dict/list')" class="small-box-footer">进入管理 <i class="fa fa-arrow-circle-right"></i>
					            </a>
					          </div>
					        </div>
					        </c:if>
						</c:if> --%>
				    </div><!-- /.row -->
		        </section><!-- /.content -->
		    </div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

    <tags:load_common_js/>
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