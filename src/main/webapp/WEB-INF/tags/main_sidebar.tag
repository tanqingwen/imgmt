<%@ tag language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ attribute name="active" type="java.lang.String" required="true"%>
<aside class="main-sidebar">

	<!-- sidebar: style can be found in sidebar.less -->
	<!-- sidebar appears in the header of bodys, so it should be written in "section" label. -->
	<section class="sidebar">

		<!-- Sidebar user panel (optional) -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${assets}/app/img/logo-76x761.png" class="img-circle"
					alt="用户图像">
			</div>
			<div class="pull-left info">
				<p>${currentStaff.id}</p>
				<!-- A green circle, which represents status. -->
				<i class="fa fa-circle text-success"></i>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header">操作菜单</li>
			<c:if test="${app:checkPermission('ROOT_INDEX')}">
				<li class="${active eq 'dashboard' ? 'active' : ''}"><a
					href="${ctx }/"><i class="fa fa-dashboard"></i> <span>仪表盘</span></a></li>
			</c:if>

			<c:if test="${app:checkPermission('SITE_MANAGEMENT')}">
				<li class="treeview"><a href="#"><i class="fa fa-car"></i><i
						class="fa fa-angle-left pull-right"></i><span>现场管理</span></a>
					<ul class="treeview-menu">
						<c:if test="${app:checkPermission('VENUE_ENTRY_LIST')}">
							<li class="${active eq 'venue' ? 'active' : ''}"><a
								href="${ctx }/cpmeracc/venueDataEntering"><i
									class="fa fa-circle-o"></i> <span>场馆录入</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('VENUE_LIST')}">
							<li class="${active eq 'venuemermst' ? 'active' : ''}"><a
								href="${ctx }/cpmermst/venuePreserve"><i class="fa fa-circle-o"></i>
									<span>场馆查询</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('VENUE_MAINTAIN_LIST')}">
							<li class="${active eq 'vmerupd' ? 'active' : ''}"><a
								href="${ctx }/cpmermst/vmerupdPreserve"><i
									class="fa fa-circle-o"></i> <span>场馆维护</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('MERACC_ENTRY_LIST')}">
							<li class="${active eq 'meracc' ? 'active' : ''}"><a
								href="${ctx }/cpmeracc/merchantDataEntering"><i
									class="fa fa-circle-o"></i> <span>商户录入</span></a></li>
						</c:if>
						
						<c:if test="${app:checkPermission('MERMST_LIST')}">
							<li class="${active eq 'mermst' ? 'active' : ''}"><a
								href="${ctx }/cpmermst/merchantPreserve"><i
									class="fa fa-circle-o"></i> <span>商户查询</span></a></li>
						</c:if>
						
						<c:if test="${app:checkPermission('MERUPD_MAINTAIN_LIST')}">
							<li class="${active eq 'merupd' ? 'active' : ''}"><a
								href="${ctx }/cpmermst/merupdPreserve"><i
									class="fa fa-circle-o"></i> <span>商户维护</span></a></li>
						</c:if>
						<li><a href="${ctx }/startTreeviewDetail/cggl"><i class="fa fa-circle-o"></i><i
								class="fa fa-angle-left pull-right"></i> <span>场馆管理</span></a>
							<ul class="treeview-menu">
								<c:if test="${app:checkPermission('TRMMST_GATE_LIST')}">
									<li class="${active eq 'trmmstgate' ? 'active' : ''}"><a
										href="${ctx }/trmmstgate/list"><i class="fa fa-circle-o"></i>
											<span>闸机管理</span></a></li>
								</c:if>
								<c:if test="${app:checkPermission('GATE_IP_LIST')}">
									<li class="${active eq 'gateip' ? 'active' : ''}"><a
										href="${ctx }/gateip/list"><i class="fa fa-circle-o"></i>
											<span>闸机绑IP</span></a></li>
								</c:if>
								<%-- <c:if test="${app:checkPermission('VENUEGROUP_LIST')}">
							<li class="${active eq 'venuegroup' ? 'active' : ''}"><a href="${ctx }/cpacqgrp/list"><i class="fa fa-circle-o"></i> <span>场馆分组</span></a></li>
						</c:if> --%>
								<c:if test="${app:checkPermission('VENUE_GROUP_LIST')}">
									<li class="${active eq 'venue_list' ? 'active' : ''}"><a
										href="${ctx }/cpacqmer/list"><i class="fa fa-circle-o"></i>
											<span>场馆组配置</span></a></li>
								</c:if>
								
								<c:if test="${app:checkPermission('VENUEALL_MERMST_LIST')}">
									<li class="${active eq 'trmmstgate' ? 'active' : ''}"><a
										href="${ctx }/trmmstgate/mermstlist"><i
											class="fa fa-circle-o"></i> <span>终端管理</span></a></li>
								</c:if>
							</ul></li>
					</ul></li>
			</c:if>
			<c:if test="${app:checkPermission('TICKET_OPERATION')}">
				<li class="treeview"><a href="#"><i
						class="glyphicon glyphicon-lock"></i><i
						class="fa fa-angle-left pull-right"></i><span>票务作业</span></a>
					<ul class="treeview-menu">
						 
				<c:if test="${app:checkPermission('BATCHCARD_ADD')}">
					<li class="${active eq 'batchcard' ? 'active' : ''}"><a href="${ctx }/batchcrdtbl/add"><i class="fa fa-circle-o"></i> <span>批量制卡作业</span></a></li>
				</c:if>
			
						<c:if test="${app:checkPermission('CRDTBL_LIST')}">
							<li class="${active eq 'crdtbl' ? 'active' : ''}"><a
								href="${ctx }/crdtbl/activeCard"><i class="fa fa-circle-o"></i>
									<span>实卡激活</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('BUYTICKET_ADD')}">
							<li class="${active eq 'merchant' ? 'active' : ''}"><a
								href="${ctx }/cpticket/ceshi2"><i class="fa fa-circle-o"></i>
									<span>实名购票</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('INTCARD_ADD')}">
							<li class="${active eq 'intcard' ? 'active' : ''}"><a
								href="${ctx }/intcrdtbl/add"><i class="fa fa-circle-o"></i>
									<span>实名订单取票</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('NON_BUYTICKET_ADD')}">
							<li class="${active eq 'merchant' ? 'active' : ''}"><a
								href="${ctx }/cpticket/tictek"><i class="fa fa-circle-o"></i>
									<span>非实名购票</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('NON_REAL_NAME_VOTING')}">
							<li class="${active eq 'intcard' ? 'active' : ''}"><a
								href="${ctx }/intcrdtbl/nonAdd"><i class="fa fa-circle-o"></i>
									<span>非实名订单取票</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('CPTICKET_BACK')}">
							<li class="${active eq 'cpticketback' ? 'active' : ''}"><a
								href="${ctx }/cpticket/back"><i class="fa fa-circle-o"></i>
									<span>实名退票</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('ORDER_REFUND_LIST')}">
							<li class="${active eq 'prticke' ? 'active' : ''}"><a
								href="${ctx }/yworder/orderrefund"><i class="fa fa-circle-o"></i> <span>非实名退票</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('PRTICKET_ADD')}">
							<li class="${active eq 'prticke' ? 'active' : ''}"><a
								href="${ctx }/prticke/add"><i class="fa fa-circle-o"></i> <span>公关赠票</span></a></li>
						</c:if>
						
						
						
						<%-- <c:if test="${app:checkPermission('BUYTICKET_ADD')}">
					<li class="${active eq 'buyticket2' ? 'active' : ''}"><a href="${ctx }/ticket/add2"><i class="fa fa-circle-o"></i> <span>现场购票作业2</span></a></li>
				</c:if>
	 			<c:if test="${app:checkPermission('BUYTICKET_ADD')}"> 
	 				<li class="${active eq 'buyticket3' ? 'active' : ''}"><a href="${ctx }/cpticket/ceshi"><i class="fa fa-circle-o"></i> <span>测试选项</span></a></li> 
	 			</c:if>
	 			<c:if test="${app:checkPermission('BUYTICKET_ADD')}"> 
	 				<li class="${active eq 'buyticket3' ? 'active' : ''}"><a href="${ctx }/ticket/add"><i class="fa fa-circle-o"></i> <span>测试选项2</span></a></li> 
	 			</c:if>  
				<c:if test="${app:checkPermission('CARD_ADD')}">
					<li class="${active eq 'card_add' ? 'active' : ''}"><a href="${ctx }/crdtbl/add"><i class="fa fa-circle-o"></i> <span>窗口开卡作业</span></a></li>
				</c:if>
				--%>
						<!-- 
				<c:if test="${app:checkPermission('BATCHCARD_ADD')}">
					<li class="${active eq 'batchcard' ? 'active' : ''}"><a href="${ctx }/batchcrdtbl/add"><i class="fa fa-circle-o"></i> <span>批量制卡作业</span></a></li>
				</c:if>
				-->
						
						
						<!--  
				<c:if test="${app:checkPermission('CPTICKET_LIST')}">
					<li class="${active eq 'cpticketlist' ? 'active' : ''}"><a href="${ctx }/cpticket/list"><i class="fa fa-circle-o"></i> <span>订单转票作业</span></a></li>
				</c:if>
				-->
						

						<c:if test="${app:checkPermission('STAFF_SHIFT')}">
							<li class="${active eq 'ywrestaurantlist' ? 'active' : ''}"><a
								href="${ctx }/shifting/add"><i class="fa fa-circle-o"></i> <span>员工交接班</span></a></li>
						</c:if>
					</ul></li>
			</c:if>
			<c:if test="${app:checkPermission('MEMBERSHIP_CARD_OPERATION')}">
				<li class="treeview"><a href="#"><i
						class="fa fa-credit-card"></i><i
						class="fa fa-angle-left pull-right"></i><span>会员卡作业</span></a>
					<ul class="treeview-menu">
						<%--  
				<c:if test="${app:checkPermission('STAFF_LIST')}">
					<li class="${active eq 'staff' ? 'active' : ''}"><a href="${ctx }/crdtbl/crdlist"><i class="fa fa-circle-o"></i> <span>乐园卡查询</span></a></li>
				</c:if>--%>
						<c:if test="${app:checkPermission('AMOUNT_ADD')}">
							<li class="${active eq 'amount' ? 'active' : ''}"><a
								href="${ctx }/CardRecharge/add"><i class="fa fa-circle-o"></i>
									<span>会员卡充值</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('LOSS_ADD')}">
							<li class="${active eq 'loss' ? 'active' : ''}"><a
								href="${ctx }/blkmlc/add"><i class="fa fa-circle-o"></i> <span>会员卡挂失</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('LOSS_OPENADD')}">
							<li class="${active eq 'openadd' ? 'active' : ''}"><a
								href="${ctx }/blkmlc/openadd"><i class="fa fa-circle-o"></i>
									<span>会员卡解挂</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('OPENLOSS_ADD')}">
							<li class="${active eq 'openloss' ? 'active' : ''}"><a
								href="${ctx }/CardSupplement/add"><i class="fa fa-circle-o"></i>
									<span>会员卡补办</span></a></li>
						</c:if>

						<%-- <c:if test="${app:checkPermission('CARD_BACK')}">
					<li class="${active eq 'card' ? 'active' : ''}"><a href="${ctx }/CardDestroy/add"><i class="fa fa-circle-o"></i> <span>会员卡退卡</span></a></li>
				</c:if> --%>
						<c:if test="${app:checkPermission('MEMBER_WITHDRAWALS')}">
							<li class="${active eq 'card' ? 'active' : ''}"><a
								href="${ctx }/cpticket/tixian"><i class="fa fa-circle-o"></i>
									<span>会员卡提现</span></a></li>
						</c:if>
					</ul></li>
			</c:if>
			<c:if test="${app:checkPermission('MEMBER_MANAGEMENT')}">
				<li class="treeview"><a href="#"><i class="fa fa-fax"></i><i
						class="fa fa-angle-left pull-right"></i><span>会员管理</span></a>
					<ul class="treeview-menu">
						<!--
				<c:if test="${app:checkPermission('YWMEMBER_LIST')}">
					<li class="${active eq 'ywmember' ? 'active' : ''}"><a href="${ctx }/member/list"><i class="fa fa-circle-o"></i> <span>会员列表</span></a></li>
				</c:if>
				-->
						<%-- 			<c:if test="${app:checkPermission('STAFF_LIST')}"> --%>
						<%-- 				<li class="${active eq 'staff' ? 'active' : ''}"><a href="${ctx }/cpcsttbl/cpcsttblQueryStat"><i class="fa fa-circle-o"></i> <span>会员管理</span></a></li> --%>
						<%-- 			</c:if> --%>
						<%-- 			<c:if test="${app:checkPermission('STAFF_LIST')}"> --%>
						<%-- 				<li class="${active eq 'staff' ? 'active' : ''}"><a href="${ctx }/associator/add"><i class="fa fa-circle-o"></i> <span>会员注册</span></a></li> --%>
						<%-- 			</c:if> --%>
						<!--  
				<c:if test="${app:checkPermission('STAFF_LIST')}">
					<li class="${active eq 'staff' ? 'active' : ''}"><a href="${ctx }/exchange/list"><i class="fa fa-circle-o"></i> <span>会员折扣</span></a></li>
				</c:if>
				<c:if test="${app:checkPermission('STAFF_LIST')}">
					<li class="${active eq 'staff' ? 'active' : ''}"><a href="${ctx }/integral/list"><i class="fa fa-circle-o"></i> <span>积分管理</span></a></li>
				</c:if>
				<c:if test="${app:checkPermission('STAFF_LIST')}">
					<li class="${active eq 'staff' ? 'active' : ''}"><a href="${ctx }/exchange/list"><i class="fa fa-circle-o"></i> <span>积分兑换</span></a></li>
				</c:if>
				-->
						<c:if test="${app:checkPermission('PRDGRP_LIST')}">
							<li class="${active eq 'prdgrp' ? 'active' : ''}"><a
								href="${ctx }/prdgrp/list"><i class="fa fa-circle-o"></i> <span>会员等级</span></a></li>
						</c:if>
						<!--  
				<c:if test="${app:checkPermission('BLACKLIST_LIST')}">
					<li class="${active eq 'blacklist' ? 'active' : ''}"><a href="${ctx }/blacklist/list"><i class="fa fa-circle-o"></i> <span>会员黑名单设定</span></a></li>
				</c:if>
				-->
					</ul></li>
			</c:if>

			<c:if test="${app:checkPermission('SERVICE_MANAGEMENT')}">
				<li class="treeview"><a href="#"><i class="fa fa-life-ring"></i><i
						class="fa fa-angle-left pull-right"></i><span>业务管理</span></a>
					<ul class="treeview-menu">
						<c:if test="${app:checkPermission('CPTKTYPE_LIST')}">
							<li class="${active eq 'cptktypelist' ? 'active' : ''}"><a
								href="${ctx }/cptktype/list"><i class="fa fa-circle-o"></i>
									<span>票务信息管理</span></a></li>
						</c:if>

						<c:if test="${app:checkPermission('CPCOMMODITY_LIST')}">
							<li class="${active eq 'cptktypelist' ? 'active' : ''}"><a
								href="${ctx }/cpCommodity/list"><i class="fa fa-circle-o"></i>
									<span>商品信息管理</span></a></li>
						</c:if>

						<c:if test="${app:checkPermission('CPDISCOUNT_LIST')}">
							<li class="${active eq 'cpDiscount' ? 'active' : ''}"><a
								href="${ctx }/cpDiscount/list"><i class="fa fa-circle-o"></i>
									<span>优惠券信息管理</span></a></li>
						</c:if>
						<!-- 
				<c:if test="${app:checkPermission('CPVERKEY_LIST')}">
					<li class="${active eq 'cpverkeylist' ? 'active' : ''}"><a href="${ctx }/cpverkey/list"><i class="fa fa-circle-o"></i> <span>校验密钥表管理</span></a></li>
				</c:if>
				-->
					</ul></li>
			</c:if>

			<c:if test="${app:checkPermission('SERVICE_QUERY')}">
				<li class="treeview"><a href="#"><i
						class="glyphicon glyphicon-search"></i><i
						class="fa fa-angle-left pull-right"></i><span>业务查询</span></a>
					<ul class="treeview-menu">
						<c:if
							test="${app:checkPermission('ORDER_QUERY')}">
							<li class="${active eq 'ywpayrecordQueryStat' ? 'active' : ''}"><a
								href="${ctx }/yworder/yworderQueryStat"><i
									class="fa fa-circle-o"></i> <span>订单查询</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('CPCEPTRX_BUYTICKETSTAT')}">
							<li class="${active eq 'buyTicketStat' ? 'active' : ''}"><a
								href="${ctx }/cpceptrx/buyTicketStat"><i
									class="fa fa-circle-o"></i> <span>购票信息查询</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('VIPCARDSTAT_VIPINFOSTAT')}">
							<li class="${active eq 'vipInfoStat' ? 'active' : ''}"><a
								href="${ctx }/vipcardStat/vipInfoStat"><i
									class="fa fa-circle-o"></i> <span>会员卡信息查询</span></a></li>
						</c:if>
						<c:if
							test="${app:checkPermission('VIPCARDSTAT_LISTCARDSALEINFO')}">
							<li class="${active eq 'listCardSaleInfo' ? 'active' : ''}"><a
								href="${ctx }/vipcardStat/listCardSaleInfo"><i
									class="fa fa-circle-o"></i> <span>卡片交易详情</span></a></li>
						</c:if>
					</ul></li>
			</c:if>

			<c:if test="${app:checkPermission('STATISTICAL_REPORT')}">
				<li class="treeview"><a href="#"><i class="fa fa-bar-chart"></i><i
						class="fa fa-angle-left pull-right"></i><span>统计报表</span></a>
					<ul class="treeview-menu">
						<%-- 			<c:if test="${app:checkPermission('STAFF_LIST')}"> --%>
						<%-- 				<li class="${active eq 'opeartion' ? 'active' : ''}"><a href="${ctx }/opeartion/list"><i class="fa fa-circle-o"></i> <span>票务操作统计</span></a></li> --%>
						<%-- 			</c:if> --%>
						<%-- <c:if test="${app:checkPermission('BUY_TICKET')}">
				<li class="${active eq 'buy_ticket' ? 'active' : ''}"><a href="#"><i class="fa fa-circle-o"></i> <span>购票统计</span></a></li>
			</c:if> --%>
						<%-- <c:if test="${app:checkPermission('OPEN_CARD')}">
				<li class="${active eq 'open_card' ? 'active' : ''}"><a href="#"><i class="fa fa-circle-o"></i> <span>开卡统计</span></a></li>
			</c:if> --%>
						<c:if test="${app:checkPermission('CPCEPTRX_RETURNTICKETSTAT')}">
							<li class="${active eq 'returnTicketStat' ? 'active' : ''}"><a
								href="${ctx }/cpceptrx/returnTicketStat"><i
									class="fa fa-circle-o"></i> <span>退票统计</span></a></li>
						</c:if>
						<!--  
			<c:if test="${app:checkPermission('CPCEPTRX_CONVERTTICKETSTAT')}">
				<li class="${active eq 'convertTicketStat' ? 'active' : ''}"><a href="${ctx }/cpceptrx/convertTicketStat"><i class="fa fa-circle-o"></i> <span>转票统计</span></a></li>
			</c:if>
			-->
						<c:if test="${app:checkPermission('OPEARTION_EXPENSE')}">
							<li class="${active eq 'expense' ? 'active' : ''}"><a
								href="${ctx }/opeartion/expense"><i class="fa fa-circle-o"></i>
									<span>会员卡消费统计</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('RECHARGE_LIST')}">
							<li class="${active eq 'rechargelist' ? 'active' : ''}"><a
								href="${ctx }/recharge/list"><i class="fa fa-circle-o"></i>
									<span>会员卡充值统计</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('VIPCARDSTAT_VIPCHANGESTAT')}">
							<li class="${active eq 'vipChangeStat' ? 'active' : ''}"><a
								href="${ctx }/vipcardStat/vipChangeStat"><i
									class="fa fa-circle-o"></i> <span>会员卡换卡统计</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('VIPCARDSTAT_VIPCASESTAT')}">
							<li class="${active eq 'vipCaseStat' ? 'active' : ''}"><a
								href="${ctx }/vipcardStat/vipCaseStat"><i
									class="fa fa-circle-o"></i> <span>会员卡情况统计</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('OPEARTION_LIST')}">
							<li class="${active eq 'opeartionlist' ? 'active' : ''}"><a
								href="${ctx }/opeartion/list"><i class="fa fa-circle-o"></i>
									<span>会员卡操作统计</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('FINANCIAL_WATER')}">
							<li class="${active eq 'financialwater' ? 'active' : ''}"><a
								href="${ctx }/financial/water"><i class="fa fa-circle-o"></i>
									<span>流水报表下载</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('FINANCIAL_LIST')}">
							<li class="${active eq 'financiallist' ? 'active' : ''}"><a
								href="${ctx }/financial/list"><i class="fa fa-circle-o"></i>
									<span>财务报表下载</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('FINANCIAL_LIST')}">
							<li class="${active eq 'financiallist' ? 'active' : ''}"><a
								href="${ctx }/shift/list"><i class="fa fa-circle-o"></i>
									<span>交接班报表查询</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('FINANCIAL_LIST')}">
							<li class="${active eq 'financiallist' ? 'active' : ''}"><a
								href="${ctx }/qudao/list"><i class="fa fa-circle-o"></i>
									<span>渠道报表查询</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('FINANCIAL_LIST')}">
							<li class="${active eq 'financiallist' ? 'active' : ''}"><a
								href="${ctx }/qudao/listtp"><i class="fa fa-circle-o"></i>
									<span>退票报表查询</span></a></li>
						</c:if>
						<!--  
			<c:if test="${app:checkPermission('STAFF_LIST')}">
				<li class="${active eq 'opeartion' ? 'active' : ''}"><a href="${ctx }/opeartion/suppl"><i class="fa fa-circle-o"></i> <span>会员卡补卡统计</span></a></li>
			</c:if>
			-->
						<%-- 			<c:if test="${app:checkPermission('STAFF_LIST')}"> --%>
						<%-- 				<li class="${active eq 'staff' ? 'active' : ''}"><a href="#"><i class="fa fa-circle-o"></i> <span>押金统计</span></a></li> --%>
						<%-- 			</c:if> --%>
						<!--  
			<c:if test="${app:checkPermission('STAFF_LIST')}">
				<li class="${active eq 'staff' ? 'active' : ''}"><a href="#"><i class="fa fa-circle-o"></i> <span>场馆流量统计</span></a></li>
			</c:if>
			-->
					</ul></li>
			</c:if>

			<c:if test="${app:checkPermission('WEB_MAINTENANCE')}">
				<li class="treeview"><a href="#"><i
						class="glyphicon glyphicon-search"></i><i
						class="fa fa-angle-left pull-right"></i><span>web维护</span></a>
					<ul class="treeview-menu">
						<c:if test="${app:checkPermission('YWVENUE_LIST')}">
							<li class="${active eq 'ywvenuelist' ? 'active' : ''}"><a
								href="${ctx }/ywvenue/list"><i class="fa fa-circle-o"></i> <span>景点信息管理</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('YWRESTAURANT_LIST')}">
							<li class="${active eq 'ywrestaurantlist' ? 'active' : ''}"><a
								href="${ctx }/ywrestaurant/list"><i class="fa fa-circle-o"></i>
									<span>餐厅信息管理</span></a></li>
						</c:if>

					</ul></li>
			</c:if>

			<c:if test="${app:checkPermission('SYSTEM_MANAGEMENT')}">
				<li class="treeview"><a href="#"><i class="fa fa-cog"></i><i
						class="fa fa-angle-left pull-right"></i><span>系统管理</span></a>
					<ul class="treeview-menu">
						<c:if test="${app:checkPermission('STAFF_LIST')}">
							<li class="${active eq 'staff' ? 'active' : ''}"><a
								href="${ctx }/staff/list"><i class="fa fa-circle-o"></i> <span>员工管理</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('ROLE_LIST')}">
							<li class="${active eq 'role' ? 'active' : ''}"><a
								href="${ctx }/role/list"><i class="fa fa-circle-o"></i> <span>角色管理</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('DEPARTMENT_LIST')}">
							<li class="${active eq 'department' ? 'active' : ''}"><a
								href="${ctx }/department/depttree"><i class="fa fa-circle-o"></i>
									<span>部门管理</span></a></li>
						</c:if>
						<c:if test="${app:checkPermission('PERMISSION_MANAGEMENT_LIST')}">
							<li class="${active eq 'department' ? 'active' : ''}"><a
								href="${ctx }/function/funttree"><i class="fa fa-circle-o"></i>
									<span>权限管理</span></a></li>
						</c:if>			
						<c:if test="${app:checkPermission('OPTION_LOGIN_CONFIG_SHOW')}">
							<li class="${active eq 'option' ? 'active' : ''}"><a
								href="${ctx }/option/login_config_show"><i
									class="fa fa-circle-o"></i> <span>登录参数</span></a></li>
						</c:if>
						
						
						<c:if test="${app:checkPermission('BASIC_PARAMETER_MANAGEMENT')}">
						<li><a href="${ctx }/startTreeviewDetail/jbcsgl"><i class="fa fa-circle-o"></i><i
								class="fa fa-angle-left pull-right"></i> <span>基本参数管理</span></a>
							<ul class="treeview-menu">
						
							
								<!--  
				    <c:if test="${app:checkPermission('COUNTRY_LIST')}">
					<li class="${active eq 'country_dict' ? 'active' : ''}"><a href="${ctx }/country_dict/list"><i class="fa fa-circle-o"></i> <span>国家管理</span></a></li>
					</c:if>
					<c:if test="${app:checkPermission('PROVINCE_LIST')}">
						<li class="${active eq 'province' ? 'active' : ''}"><a href="${ctx }/province_dict/list"><i class="fa fa-circle-o"></i> <span>省份代码表</span></a></li>
					</c:if>
					<c:if test="${app:checkPermission('CITYDICTATIONDICT_LIST')}">
						<li class="${active eq 'city' ? 'active' : ''}"><a href="${ctx }/city_dict/list"><i class="fa fa-circle-o"></i> <span>城市管理</span></a></li>
					</c:if>
					-->
								<c:if test="${app:checkPermission('IDTYPE_LIST')}">
									<li class="${active eq 'midtype' ? 'active' : ''}"><a
										href="${ctx }/idtype_dict/list"><i class="fa fa-circle-o"></i>
											<span>证件类型管理</span></a></li>
								</c:if>
								</ul>
						</c:if>
								<%-- <c:if test="${app:checkPermission('MEMBERSHIP_LIST')}">
						<li class="${active eq 'member_ship' ? 'active' : ''}"><a href="${ctx }/member_ship/list"><i class="fa fa-circle-o"></i> <span>等级管理</span></a></li>
					</c:if> --%>
								<%-- <c:if test="${app:checkPermission('MEMBERPOINTS_LIST')}">
						<li class="${active eq 'member_points' ? 'active' : ''}"><a href="${ctx }/member_points/list"><i class="fa fa-circle-o"></i> <span>积分管理</span></a></li>
					</c:if> --%>
								<!--  
					<c:if test="${app:checkPermission('MUSERRELATIONDICT_LIST')}">	 
						<li class="${active eq 'userRelation' ? 'active' : ''}"><a href="${ctx }/user_relation_dict/list"><i class="fa fa-circle-o"></i> <span>人际关系管理</span></a></li>
					</c:if>
					-->
							</ul></li>
					</ul></li>
			</c:if>
		</ul>

	</section>

</aside>