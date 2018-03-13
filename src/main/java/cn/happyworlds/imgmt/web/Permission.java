package cn.happyworlds.imgmt.web;

public enum Permission {
		
	
	ROOT_INDEX("系统首页"),
	ROOT_LOCKSCREEN("系统锁屏页"),
	
	SITE_MANAGEMENT("现场管理"),
	TICKET_OPERATION("票务作业"),	
	MEMBERSHIP_CARD_OPERATION("会员卡作业"),	
	MEMBER_MANAGEMENT("会员管理"),	
	SERVICE_MANAGEMENT("业务管理"),	
	SERVICE_QUERY("业务查询"),	
	STATISTICAL_REPORT("统计报表"),	
	WEB_MAINTENANCE("web维护"),	
	SYSTEM_MANAGEMENT("系统管理"),
	HOTEL_SYSTEM("酒店系统"),
	INTELLIGENT_PARKING_LOG("智能停车场"),
	VIDER_SURVEILLANCE("视频监控"),
	
	//场馆录入
	VENUE_ENTRY_LIST("场馆录入"),
	VENUE_ENTRY_ADD("场馆录入增加"),
	VENUE_ENTRY_UPDATE("场馆录入更新"),
	VENUE_ENTRY_SHOW("场馆录入查看"),
	VENUE_ENTRY_DELETE("场馆录入删除"),
	VENUE_ENTRY_AUTH("场馆录入授权"),
	
	//场馆查询
	VENUE_LIST("场馆查询列表"),
	VENUE_VIEW("场馆查询详情"),
	VENUE_MLIST("场馆查询商户列表"),
	VENUE_TLIST("场馆查询终端列表"),
	VENUE_GLIST("场馆查询闸机列表"),
	
	//场馆维护
	VENUE_MAINTAIN_LIST("场馆维护列表"),
	VENUE_MAINTAIN_UPDATE("场馆维护更新"),
	VENUE_MAINTAIN_SHOW("场馆维护查看"),
	VENUE_MAINTAIN_AUTH("场馆维护授权"),
	
	//商户录入
	MERACC_ENTRY_LIST("商户录入列表"),
	MERACC_ENTRY_ADD("商户录入增加"),
	MERACC_ENTRY_UPDATE("商户录入更新"),
	MERACC_ENTRY_SHOW("商户录入查看"),
	MERACC_ENTRY_DELETE("商户录入删除"),
	MERACC_ENTRY_AUTH("商户录入授权"),
	
	
	
	//商户查询
	MERMST_LIST("商户查询列表"),
	MERMST_SHOW("商户查询详情"),
	MERMST_TERMINAL_LIST("商户查询终端列表"),
	
	
	
	//商户维护
	MERUPD_MAINTAIN_LIST("商户维护列表"),
	MERUPD_MAINTAIN_UPDARE("商户维护修改"),
	MERUPD_MAINTAIN_SHOW("商户维护查看"),
	MERUPD_MAINTAIN_AUTHOH("商户维护授权"),
	
	//场馆管理
	VENUE_MANAGEMENT("场馆管理"),
	
	//闸机绑IP
	GATE_IP_LIST("闸机IP列表"),
	GATE_IP_ADD("闸机IP添加"),
	GATE_IP_SHOW("闸机IP查看"),
	GATE_IP_UPDATE("闸机IP修改"),
	GATE_IP_DELETE("闸机IP删除"),
	
	//场馆配置
	VENUE_GROUP_LIST("场馆组配置列表"),
	VENUE_GROUP_UPDATE("场馆组配置更新"),
	VENUE_GROUP_ADD("场馆组配置添加"),
	VENUE_GROUP_DELETE("场馆组配置删除"),
	VENUE_GROUP_SHOW("场馆组配置查看"),
	VENUE_GROUP_AUTHOH("场馆组配置授权"),
	
	//闸机管理  
	TRMMST_GATE_LIST("闸机管理列表"),
	TRMMST_GATE_ADD("闸机管理添加"),
	TRMMST_GATE_UPDATE("闸机管理修改"),
	TRMMST_GATE_SHOW("闸机管理详情"),
	TRMMST_GATE_DELETE("闸机管理删除"),
	TRMMST_GATE_VIEW("闸机管理待复核列表"),
	
	//商户管理
	VENUEALL_MERMST_LIST("商戶管理列表"),
	VENUEALL_TRMMST_LIST("商户管理终端列表"),
	VENUEALL_TRMMST_ADD("商户管理终端添加"),
	VENUEALL_TRMMST_SHOW("商户管理终端详情"),
	VENUEALL_TRMMST_DELETE("商户管理删除终端"),
	VENUEALL_TRMMST_AUTH("商户管理终端授权"),
	VENUEALL_TRMMST_UPDATE("商户管理终端更新"),
	
	
	//票务作业
	BATCHCARD_ADD("批量制卡"),
	CRDTBL_LIST("实卡激活作业"),
	BUYTICKET_ADD("现场购票作业"),
	NON_BUYTICKET_ADD("非实名购票作业"),
	CART_ADD("添加购物车"),
	CART_SHOW("查看购物车"),
	PRTICKET_ADD("公关赠票"),
	INTCARD_ADD("预售开卡作业"),
	NON_REAL_NAME_VOTING("非实名取票作业"),
	CPTICKET_BACK("订单退票作业"),
	ORDER_REFUND_LIST("订单多支付退票列表"),
	STAFF_SHIFT("员工交接班"),
	
	
	
	//会员卡作业
	AMOUNT_ADD("会员卡充值"),
	LOSS_ADD("会员卡挂失"),
	LOSS_OPENADD("会员卡解挂"),
	OPENLOSS_ADD("会员卡补办"),
	CARD_BACK("会员卡退卡"),
	MEMBER_WITHDRAWALS("会员卡提现"),
	
	//业务管理
	
	
	//会员管理
	PRDGRP_LIST("会员等级列表"),
	PRDGRP_ADD("会员等级添加"),
	PRDGRP_SHOW("会员等级详情"),
	PRDGRP_UPDATE("会员等级修改"),
	
	
	//票务信息管理
	CPTKTYPE_LIST("票务信息列表"),
	CPTKTYPE_ADD("票务信息添加"),
	CPTKTYPE_UPDATE("票务信息修改"),
	CPTKTYPE_SHOW("票务信息查看"),
	CPTKTYPE_DELETE("票务信息删除"),
	
	//商品信息管理
	CPCOMMODITY_LIST("商品信息列表"),
	CPCOMMODITY_ADD("商品信息添加"),
	CPCOMMODITY_UPDATE("商品信息修改"),
	CPCOMMODITY_SHOW("商品信息查看"),
	CPCOMMODITY_DELETE("商品信息删除"),
	
	//优惠券信息管理
	CPDISCOUNT_LIST("优惠券信息列表"),
	CPDISCOUNT_ADD("优惠券信息添加"),
	CPDISCOUNT_UPDATE("优惠券信息更新"),
	CPDISCOUNT_SHOW("优惠券信息查看"),
	CPDISCOUNT_DELETE("优惠券信息删除"),
	
	//业务查询
	ORDER_QUERY("订单查询"),
	CPCEPTRX_BUYTICKETSTAT("购票信息查询"),
	VIPCARDSTAT_VIPINFOSTAT("会员卡信息查询"),
	VIPCARDSTAT_LISTCARDSALEINFO("卡片交易详情"),
	
	
	//统计报表
	BUY_TICKET("购票统计"),
	OPEN_CARD("开卡统计"),
	CPCEPTRX_RETURNTICKETSTAT("退票统计"),
	CPCEPTRX_RETURNTICKETSTAT_DOWNLOAD("退票统计下载"),
	CPCEPTRX_CONVERTTICKETSTAT("转票统计"),
	CPCEPTRX_CONVERTTICKETSTAT_DOWNLOAD("转票统计下载"),
	OPEARTION_EXPENSE("会员卡消费统计"),
	OPEARTION_EXPENSE_DOWNLOAD("会员卡消费统计下载"),
	RECHARGE_LIST("会员卡充值统计"),
	RECHARGE_LIST_DOWNLOAD("会员卡充值统计下载"),
	VIPCARDSTAT_VIPCHANGESTAT("会员卡换卡统计"),
	VIPCARDSTAT_VIPCHANGESTAT_DOWNLOAD("会员卡换卡统计下载"),
	VIPCARDSTAT_VIPCASESTAT("会员卡情况统计"),
	VIPCARDSTAT_VIPCASESTAT_DOWNLOAD("会员卡情况统计下载"),
	OPEARTION_LIST("会员卡操作统计"),
	OPEARTION_LIST_DOWNLOAD("会员卡操作统计下载"),
	FINANCIAL_WATER("流水报表下载"),
	FINANCIAL_LIST("财务报表下载"),
	FINANCIAL_LIST_DOWNLOAD("财务报表下载功能"),
	

	//web维护
	YWVENUE_LIST("景点信息列表"),
	YWVENUE_ADD("景点信息添加"),
	YWVENUE_UPDATE("景点信息修改"),
	YWVENUE_SHOW("景点信息查看"),
	YWVENUE_DELETE("景点信息删除"),
	YWRESTAURANT_LIST("餐厅信息列表"),
	YWRESTAURANT_ADD("餐厅信息添加"),
	YWRESTAURANT_UPDATE("餐厅信息修改"),
	YWRESTAURANT_SHOW("餐厅信息查看"),
	YWRESTAURANT_DELETE("餐厅信息删除"),
	
	
	//系统管理
	STAFF_LIST("员工列表"),
	STAFF_ADD("员工添加"),	
	STAFF_SHOW("员工查看"),
	STAFF_UPDATE("员工更新"),
	STAFF_CHANGE_PASSWORD("员工修改密码"),
	STAFF_RESET_PASSWORD("重置员工密码"),
	ROOT_LOGIN("员工安全登录"), 
	ROOT_LOGOUT("员工安全退出"),
	ROOT_AUTH_FAIL("操作授权失败"),
	
	ROLE_LIST("角色列表"),
	ROLE_ADD("角色添加"),
	ROLE_SHOW("角色查看"),
	ROLE_UPDATE("角色更新"),
	ROLE_DELETE("角色删除"),
	
	DEPARTMENT_LIST("部门列表"),
	DEPARTMENT_ADD("部门添加"),
	DEPARTMENT_SHOW("部门查看"),
	DEPARTMENT_UPDATE("部门更新"),
	DEPARTMENT_DELETE("部门删除"),
	
	//权限管理
	PERMISSION_MANAGEMENT_LIST("权限管理"),
	PERMISSION_MANAGEMENT_ADD("权限增加"),
	PERMISSION_MANAGEMENT_DELETE("权限删除"),
	PERMISSION_MANAGEMENT_UPDATE("权限更新"),
	PERMISSION_MANAGEMENT_SHOW("权限查看"),
	
	//登录参数
	OPTION_LOGIN_CONFIG_SHOW("登录参数"),
	OPTION_LOGIN_CONFIG_UPDATE("登录参数更新"),
	
	//基本参数管理
	BASIC_PARAMETER_MANAGEMENT("基本参数管理"),
	IDTYPE_LIST("证件类型列表"),
	IDTYPE_ADD("证件类型添加"),
	IDTYPE_SHOW("证件类型查看"),
	IDTYPE_UPDATE("证件类型更新"),
	IDTYPE_DELETE("证件类型删除"), 
	
	
	//会员积分管理
	MEMBERPOINTS_LIST("积分管理列表"),
	MEMBERPOINTS_SHOW("积分管理查看"),
	MEMBERPOINTS_ADD("积分管理添加"),
	//MEMBERPOINTS_DELETE("积分规则删除"),
	MEMBERPOINTS_UPDATE("积分管理更新"),
	
	
	
	//遗留
	PROVINCE_LIST("省份列表"),
	PROVINCE_ADD("省份添加"),
	PROVINCE_SHOW("省份查看"),
	PROVINCE_UPDATE("省份修改"),
	PROVINCE_DELETE("省份删除"),
	
	CITYDICTATIONDICT_LIST("城市管理列表"),
	CITYDICTATIONDICT_ADD("城市管理添加"),
	CITYDICTATIONDICT_SHOW("城市管理查看"),
	CITYDICTATIONDICT_UPDATE("城市管理更新"),
	CITYDICTATIONDICT_DELETE("城市管理删除"),

	
	COUNTRY_LIST("国家列表"),
	COUNTRY_ADD("国家添加"),
	COUNTRY_SHOW("国家查看"),
	COUNTRY_UPDATE("国家更新"),
	COUNTRY_DELETE("国家删除"),
	
	USER_RELATION_DICT_LIST("人际关系列表"),
	USER_RELATION_DICT_SHOW("人际关系查看"),
	USER_RELATION_DICT_ADD("人际关系添加"),
	USER_RELATION_DICT_DELETE("人际关系删除"),
	USER_RELATION_DICT_UPDATE("人际关系更新"),
	
	;//TODO THE END
 
	private String description;

	Permission(String description) {
		this.description = description;
	}
	
	public String description() {
		return description;
	}
}
