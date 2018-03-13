package cn.happyworlds.imgmt.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.Consumption;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.FillCard;
import cn.happyworlds.imgmt.entity.ListCardSaleInfo;
import cn.happyworlds.imgmt.entity.Opeartion;
import cn.happyworlds.imgmt.entity.Recharge;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.VipCardStat;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwPayrecord;
import cn.happyworlds.imgmt.mapper.BuyTicketStatMapper;
import cn.happyworlds.imgmt.mapper.ConsumptionMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.FillCardMapper;
import cn.happyworlds.imgmt.mapper.ListCardSaleInfoMapper;
import cn.happyworlds.imgmt.mapper.OpeartionMapper;
import cn.happyworlds.imgmt.mapper.ReCpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.ReYwOrderMapper;
import cn.happyworlds.imgmt.mapper.ReYwPayrecordMapper;
import cn.happyworlds.imgmt.mapper.RechargeMapper;
import cn.happyworlds.imgmt.mapper.VipCardStatMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.ExcelUtil;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class StatService {

	@Autowired
	private ReCpCeptrxMapper reCeptrxMapper;
	@Autowired
	private BuyTicketStatMapper buyTicketStatMapper;
	@Autowired
	private ReYwPayrecordMapper reYwPayrecordMapper;
	@Autowired
	private ReYwOrderMapper reYwOrderMapper;
	@Autowired
	private VipCardStatMapper vipCardStatMapper;
	@Autowired
	private ListCardSaleInfoMapper listCardSaleInfoMapper;
	@Autowired
	private ConsumptionMapper consumptionMapper;
	@Autowired
	private OpeartionMapper opeartionMapper;
	@Autowired
	private RechargeMapper rechargeMapper;
	@Autowired
	private FillCardMapper fillcardMapper;
	@Autowired
	private CpTktypeMapper cpTktypeMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	
	//退票,转票统计查询
	public Result<PageInfo<CpCeptrx>> returnTicketStatMethod(final String ctUserCreate, final String ctApproveTimeStart,final String ctApproveTimeEnd, final String ctCardNumber,final String ctTranCode,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(ctUserCreate)) {
			params.put("ctUserCreate", ctUserCreate);
		}
		if (StringUtils.hasText(ctApproveTimeStart)) {
			params.put("ctApproveTimeStart", ctApproveTimeStart);
		}
		if (StringUtils.hasText(ctApproveTimeEnd)) {
			params.put("ctApproveTimeEnd", ctApproveTimeEnd);
		}
		if (StringUtils.hasText(ctCardNumber)) {
			params.put("ctCardNumber", ctCardNumber);
		}
		if (StringUtils.hasText(ctTranCode)) {
			params.put("ctTranCode", ctTranCode);
		}
		List<CpCeptrx> page =  reCeptrxMapper.searchReturnTicketStat(params, pageBounds);
		return Result.create(new PageInfo<CpCeptrx>(page));		
	}
	
	//退票，转票下载
	public Result<String> returnTicketDownLoadMethod(final String ctUserCreate, final String ctApproveTimeStart,final String ctApproveTimeEnd, final String ctCardNumber,final String ctTranCode,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			if (StringUtils.hasText(ctUserCreate)) {
				params.put("ctUserCreate", ctUserCreate);
			}
			if (StringUtils.hasText(ctApproveTimeStart)) {
				params.put("ctApproveTimeStart", ctApproveTimeStart);
			}
			if (StringUtils.hasText(ctApproveTimeEnd)) {
				params.put("ctApproveTimeEnd", ctApproveTimeEnd);
			}
			if (StringUtils.hasText(ctCardNumber)) {
				params.put("ctCardNumber", ctCardNumber);
			}
			if (StringUtils.hasText(ctTranCode)) {
				params.put("ctTranCode", ctTranCode);
			}
			List<CpCeptrx> page =  reCeptrxMapper.searchReturnTicketStat(params);
		
			String title = "转票统计报表";//大标题，左下角的东西
			if(ctTranCode.equals("UNTICKET")){
				title = "退票统计报表";//大标题，左下角的东西
			}
			if(ctTranCode.equals("TRANTKIN")){
				title = "转入--"+title;
			}
			if(ctTranCode.equals("TRANTKOUT")){
				title = "转出--"+title;
			}	
			
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("票号");
					add("卡号");
					add("姓名");
					add("卡类型");
					add("日期");
					add("时间");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("ctUserStatus1",page.get(i).getCtUserStatus1());
				record.put("ctCardNumber",page.get(i).getCtCardNumber());
				record.put("ctUserCreate",page.get(i).getCtUserCreate());
				record.put("ctUserStatus2",page.get(i).getCtUserStatus2());
				String ctApproveDate = SysDateFormat.getDateFormat(page.get(i).getCtApproveTime(), "yyyyMMddHHmmss", "yyyy-MM-dd");
				String ctApproveTime = SysDateFormat.getDateFormat(page.get(i).getCtApproveTime(), "yyyyMMddHHmmss", "HH:mm:ss");
				record.put("ctApproveDate",ctApproveDate);
				record.put("ctApproveTime",ctApproveTime);
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", ctApproveTimeStart);
			headExtra.put("结束时间", ctApproveTimeEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, headExtra, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}
	
	
	//购票信息查询
	public Result<PageInfo<CpTicket>> buyTicketStatMethod(final String tkCardNo1, final String tkEffectiveDateStart,final String tkEffectiveDateEnd, PageBounds pageBounds){
		String tkCardNo = "";
		if(tkCardNo1 != null && !"".equals(tkCardNo1)) {
			CpCrdtbl card = cpCrdtblMapper.searchCpCrdtblByCbRecommenderNo("HWCARD" + tkCardNo1);
			tkCardNo = card.getCbCardholderNo();
		}
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(tkCardNo)) {
			params.put("tkCardNo", tkCardNo);
		}
		if (StringUtils.hasText(tkEffectiveDateStart)) {
			params.put("tkEffectiveDateStart", tkEffectiveDateStart);
		}
		if (StringUtils.hasText(tkEffectiveDateEnd)) {
			params.put("tkEffectiveDateEnd", tkEffectiveDateEnd);
		}
		List<CpTicket> page = new ArrayList<CpTicket>();
		page =  buyTicketStatMapper.searchCpTicketAndCpTktypeStat(params, pageBounds);
		for(CpTicket ct:page){
			CpCrdtbl cpCrdtbl =cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(ct.getTkCardNo());
			System.out.println(ct.getTkCardNo());
			ct.setCbRemmenderNo(cpCrdtbl.getCbRecommenderNo().substring(6));
			ct.setTicketName(cpTktypeMapper.searchCpTktypeByTtTypeId(ct.getTkTicketType().intValue()).getTtTypeDesc());
		}
		//获取卡号后8位
		for(int i=0;i<page.size();i++){
			page.get(i).setTkCardNo(page.get(i).getTkCardNo().substring(page.get(i).getTkCardNo().length() - 10, page.get(i).getTkCardNo().length()));	
		}
		
		return Result.create(new PageInfo<CpTicket>(page));		
	}
	
	
	
	//购票信息下载
	public Result<String> buyTicketDownLoadMethod(final String tkCardNo, final String tkEffectiveDateStart,final String tkEffectiveDateEnd,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			if (StringUtils.hasText(tkCardNo)) {
				params.put("tkCardNo", tkCardNo);
			}
			if (StringUtils.hasText(tkEffectiveDateStart)) {
				params.put("tkEffectiveDateStart", tkEffectiveDateStart);
			}
			if (StringUtils.hasText(tkEffectiveDateEnd)) {
				params.put("tkEffectiveDateEnd", tkEffectiveDateEnd);
			}
			List<CpTicket> page = new ArrayList<CpTicket>();
			page =  buyTicketStatMapper.searchCpTicketAndCpTktypeStat(params);
		
			String title = "购票信息统计报表";//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("票号");
					add("卡号");
					add("票卷类别");
					add("生效日期");
					add("失效日期");
					add("最近入园日期");
					add("最近离园日期");
					
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("tkTicketId",page.get(i).getTkTicketId().toString());
				record.put("tkCardNo",page.get(i).getTkCardNo());
				record.put("tkTicketType",page.get(i).getTkTicketType().toString());
				record.put("tkEffectiveDate",page.get(i).getTkEffectiveDate());
				record.put("tkExpireDate",page.get(i).getTkExpireDate());
				record.put("tkActiveDate",page.get(i).getTkActiveDate());
				record.put("tkRetriveDate",page.get(i).getTkRetriveDate());
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", tkEffectiveDateStart);
			headExtra.put("结束时间", tkEffectiveDateEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, headExtra, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}
	
	//订单查询
	public Result<PageInfo<YwPayrecord>> ywpayrecordQueryStatMethod(final String hwOrderId, final String hwMobilePhone,final String hwMemberId, final String hwPayStatus,final String hwPayTimeStart,final String hwPayTimeEnd, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(hwOrderId)) {
			params.put("hwOrderId", hwOrderId);
		}
		if (StringUtils.hasText(hwMobilePhone)) {
			params.put("hwMobilePhone", hwMobilePhone);
		}
		if (StringUtils.hasText(hwMemberId)) {
			params.put("hwMemberId", hwMemberId);
		}
		if (StringUtils.hasText(hwPayStatus)) {
			params.put("hwPayStatus", hwPayStatus);
		}
		if (StringUtils.hasText(hwPayTimeStart)) {
			params.put("hwPayTimeStart", hwPayTimeStart);
		}
		if (StringUtils.hasText(hwPayTimeEnd)) {
			params.put("hwPayTimeEnd", hwPayTimeEnd);
		}
		List<YwPayrecord> page =  reYwPayrecordMapper.searchYwPayrecordByParams(params, pageBounds);
		return Result.create(new PageInfo<YwPayrecord>(page));		
	}
	public Result<PageInfo<YwOrder>> yworderQueryStatMethod(final String hwOrderId, final String hwMobilePhone,final String hwOrderAddtimeStart,final String hwOrderAddtimeEnd, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(hwOrderId)) {
			params.put("hwOrderId", hwOrderId);
		}
		if (StringUtils.hasText(hwMobilePhone)) {
			params.put("hwMobilePhone", hwMobilePhone);
		}
		if (StringUtils.hasText(hwOrderAddtimeStart)) {
			params.put("hwOrderAddtimeStart", hwOrderAddtimeStart);
		}
		if (StringUtils.hasText(hwOrderAddtimeEnd)) {
			params.put("hwOrderAddtimeEnd", hwOrderAddtimeEnd);
		}
		params.put("hwPaymentStatus", "Y");
		List<YwOrder> page =  reYwOrderMapper.searchYwOrderStat(params, pageBounds);
		return Result.create(new PageInfo<YwOrder>(page));		
	}
	//会员卡信息查询
	public Result<PageInfo<VipCardStat>> vipcardInfoStatMethod(final String cbCardholderNo, final String cbEmbossname,final String cbSourceCd,final String cbIdno, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbCardholderNo)) {
			params.put("cbCardholderNo", cbCardholderNo);
		}
		if (StringUtils.hasText(cbEmbossname)) {
			params.put("cbEmbossname", cbEmbossname);
		}
		if (StringUtils.hasText(cbSourceCd)) {
			params.put("cbSourceCd", cbSourceCd);
		}
		if (StringUtils.hasText(cbIdno)) {
			params.put("cbIdno", cbIdno);
		}
		List<VipCardStat> page =  vipCardStatMapper.searchVipCardInfoStat(params, pageBounds);
		for (int i = 0; i < page.size(); i++) {
			page.get(i).setCbCardholderNo(page.get(i).getCbCardholderNo().substring(page.get(i).getCbCardholderNo().length() - 10, page.get(i).getCbCardholderNo().length()));
			String type=null;
			if("1".equals(page.get(i).getCbIdType())){
				type="身份证";
			}
			if("2".equals(page.get(i).getCbIdType())){
				type="户口簿";
			}
			if("3".equals(page.get(i).getCbIdType())){
				type="国外证件";
			}
			page.get(i).setCbIdType(type);
			
			String flag=null;
			if("P".equals(page.get(i).getCbPlasticCd())){
				flag="预售卡";
			}
			if("A".equals(page.get(i).getCbPlasticCd())){
				flag="激活卡";
			}
			if("U".equals(page.get(i).getCbPlasticCd())){
				flag="绑票";
			}
			if("L".equals(page.get(i).getCbPlasticCd())){
				flag="挂失";
			}
			if("D".equals(page.get(i).getCbPlasticCd())){
				flag="退卡";
			}
			if("F".equals(page.get(i).getCbPlasticCd())){
				flag="互联网取卡";
			}
			page.get(i).setCbPlasticCd(flag);
		}
		return Result.create(new PageInfo<VipCardStat>(page));		
	}
	
	//会员卡换卡查询
	public Result<PageInfo<VipCardStat>> vipcardChangeStatMethod(final String cbCardholderNo, final String cbEmbossname,final String cbSourceCd,final String cbIdno, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbCardholderNo)) {
			params.put("cbCardholderNo", cbCardholderNo);
		}
		if (StringUtils.hasText(cbEmbossname)) {
			params.put("cbEmbossname", cbEmbossname);
		}
		if (StringUtils.hasText(cbSourceCd)) {
			params.put("cbSourceCd", cbSourceCd);
		}
		if (StringUtils.hasText(cbIdno)) {
			params.put("cbIdno", cbIdno);
		}
		List<VipCardStat> page =  vipCardStatMapper.searchVipCardInfoStat(params, pageBounds);
		for (int i = 0; i < page.size(); i++) {
			page.get(i).setCbCardholderNo(page.get(i).getCbCardholderNo().substring(page.get(i).getCbCardholderNo().length() - 10, page.get(i).getCbCardholderNo().length()));
			String type=null;
			if("1".equals(page.get(i).getCbIdType())){
				type="身份证";
			}
			if("2".equals(page.get(i).getCbIdType())){
				type="户口簿";
			}
			if("3".equals(page.get(i).getCbIdType())){
				type="国外证件";
			}
			page.get(i).setCbIdType(type);
			
			String flag=null;
			if("".equals(page.get(i).getCbPlasticCd())){
				flag="正常";
			}
			if("L".equals(page.get(i).getCbPlasticCd())){
				flag="挂失";
			}
			if("D".equals(page.get(i).getCbPlasticCd())){
				flag="退卡";
			}
			page.get(i).setCbPlasticCd(flag);
		}
		return Result.create(new PageInfo<VipCardStat>(page));		
	}
		
	//会员卡信息查询
	public Result<PageInfo<VipCardStat>> vipcardCaseStatMethod(final String cbAnnivDateStart, final String cbAnnivDateEnd,final String cbCardholderNo,final String prGroupDesc,final String cbPlasticCd,final String cbIdno, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbAnnivDateStart)) {
			params.put("cbAnnivDateStart", cbAnnivDateStart);
		}
		if (StringUtils.hasText(cbAnnivDateEnd)) {
			params.put("cbAnnivDateEnd", cbAnnivDateEnd);
		}
		if (StringUtils.hasText(cbCardholderNo)) {
			params.put("cbCardholderNo", cbCardholderNo);
		}
		if (StringUtils.hasText(prGroupDesc)) {
			params.put("prGroupDesc", prGroupDesc);
		}
		if (StringUtils.hasText(cbPlasticCd)) {
			params.put("cbPlasticCd", cbPlasticCd);
		}
		if (StringUtils.hasText(cbIdno)) {
			params.put("cbIdno", cbIdno);
		}
		List<VipCardStat> page = new ArrayList<VipCardStat>();
		
		if(cbPlasticCd.equals(" ")){
			page =  vipCardStatMapper.searchVipCardCaseNormalStat(params, pageBounds);
			page = forStat(page);
		}else if(cbPlasticCd.equals("L")){
			page =  vipCardStatMapper.searchVipCardCaseLossStat(params, pageBounds);
			page = forStat(page);
		}else if(cbPlasticCd.equals("D")){
			page =  vipCardStatMapper.searchVipCardCaseRecedeStat(params, pageBounds);
			page = recedeStat(page);
		}else{
			page =  vipCardStatMapper.searchVipCardCaseNullStat(params, pageBounds);
			page = forStat(page);
		}
		
		return Result.create(new PageInfo<VipCardStat>(page));		
	}
	
	//卡片交易详细信息查询
	public Result<PageInfo<ListCardSaleInfo>> ListCardSaleInfoMethod(final String ctCardNumber, PageBounds pageBounds){
		List<ListCardSaleInfo> page = new ArrayList<>();
		if(ctCardNumber!=null&&ctCardNumber!=""){
			page = listCardSaleInfoMapper.searchListCardSaleInfo(ctCardNumber, pageBounds);
		}else{
			page = listCardSaleInfoMapper.searchListCardSaleInfoNumnull(pageBounds);
		}
		
		return Result.create(new PageInfo<ListCardSaleInfo>(page));
	}
	
	public List<VipCardStat> forStat(List<VipCardStat> page){
		for (int i = 0; i < page.size(); i++) {
			page.get(i).setCbCardholderNo(page.get(i).getCbCardholderNo().substring(page.get(i).getCbCardholderNo().length() - 10, page.get(i).getCbCardholderNo().length()));
			
			String flag=null;
			if("".equals(page.get(i).getCbPlasticCd())||" ".equals(page.get(i).getCbPlasticCd())){
				flag="正常";
			}
			if("L".equals(page.get(i).getCbPlasticCd())){
				flag="挂失";
			}
			if("D".equals(page.get(i).getCbPlasticCd())){
				flag="退卡";
			}
			if("P".equals(page.get(i).getCbPlasticCd())){
				flag="预制卡";
			}
			if("F".equals(page.get(i).getCbPlasticCd())){
				flag="待制卡";
			}
			page.get(i).setCbPlasticCd(flag);
		}
		return page;
	}
	public List<VipCardStat> recedeStat(List<VipCardStat> page){
		for (int i = 0; i < page.size(); i++) {
			page.get(i).setCbCardholderNo(page.get(i).getCbCardholderNo().substring(page.get(i).getCbCardholderNo().length() - 10, page.get(i).getCbCardholderNo().length()));
			page.get(i).setCbOutstdBal(new BigDecimal(0.0));
			String flag="".equals(page.get(i).getCbCifFlag())?" 挂失":"";
			if("".equals(page.get(i).getCbPlasticCd()+flag)||" ".equals(page.get(i).getCbPlasticCd()+flag)){
				flag="正常";
			}
			if("L".equals(page.get(i).getCbPlasticCd()+flag)){
				flag="挂失";
			}
			if("D".equals(page.get(i).getCbPlasticCd()+flag)){
				flag="退卡";
			}
			if("P".equals(page.get(i).getCbPlasticCd()+flag)){
				flag="预制卡";
			}
			if("F".equals(page.get(i).getCbPlasticCd()+flag)){
				flag="待制卡";
			}
			page.get(i).setCbPlasticCd(flag);
		}
		return page;
	}
	
	//会员卡消费统计下载
	public Result<String> expenseDownLoadMethod(final String cbEmbossname,final String tmDbaName,final String ctCardNumber,final String prProdctGroup,final String ctDisputeDateStart,final String ctDisputeDateEnd,final String ctDisputeDateStatus,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			if (StringUtils.hasText(cbEmbossname)) {
				params.put("cbEmbossname", cbEmbossname);
			}
			if (StringUtils.hasText(tmDbaName)) {
				params.put("tmDbaName", tmDbaName);
			}
			if (StringUtils.hasText(ctCardNumber)) {
				params.put("ctCardNumber", ctCardNumber);
			}
			if (StringUtils.hasText(prProdctGroup)) {
				params.put("prProdctGroup", prProdctGroup);
			}
			if (StringUtils.hasText(ctDisputeDateStart)) {
				params.put("ctDisputeDateStart", ctDisputeDateStart);
			}
			if (StringUtils.hasText(ctDisputeDateEnd)) {
				params.put("ctDisputeDateEnd", ctDisputeDateEnd);
			}
			if(StringUtils.hasText(ctDisputeDateStatus)){
				if(ctDisputeDateStatus.equals("UPM")){
					params.put("ctDisputeDateStatusUPM", ctDisputeDateStatus);
				}
				if(ctDisputeDateStatus.equals("INM")){
					params.put("ctDisputeDateStatusINM", ctDisputeDateStatus);
				}
			}
			List<Consumption> page =  consumptionMapper.searchConsumptionByParams(params);
		
			String title = "会员卡消费统计报表";//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("卡号");
					add("卡种");
					add("姓名");
					add("终端号");
					add("场馆号");
					add("交易时间");
					add("上送时间");
					add("交易金额");
					add("余额");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("ctCardNumber",page.get(i).getCtCardNumber());
				record.put("prGroupDesc",page.get(i).getPrGroupDesc());
				record.put("cbEmbossname",page.get(i).getCbEmbossname());
				record.put("ctTerminalId",page.get(i).getCtTerminalId());
				record.put("ctMerchantId",page.get(i).getCtMerchantId());
				String ctDisputeDateAndctTranZone = SysDateFormat.getDateFormat(page.get(i).getCtDisputeDate()+page.get(i).getCtTranZone(), "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
				String ctApproveTime = SysDateFormat.getDateFormat(page.get(i).getCtApproveTime(), "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
				record.put("ctDisputeDateAndctTranZone",ctDisputeDateAndctTranZone);
				record.put("ctApproveTime",ctApproveTime);
				record.put("ctBillCurrAmt",page.get(i).getCtBillCurrAmt());
				record.put("ctCardAmount",page.get(i).getCtCardAmount());
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", ctDisputeDateStart);
			headExtra.put("结束时间", ctDisputeDateEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, headExtra, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}	
	
	//会员卡操作统计下载
	public Result<String> listDownLoadMethod(final String ctApproveTimeStart, final String ctApproveTimeEnd, final String ctCardNumber, final String ctTranCode, final String ctUserCreate,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			String amout=null;
			String amoutstr = "";
			if (StringUtils.hasText(ctApproveTimeStart)) {
				params.put("ctApproveTimeStart", ctApproveTimeStart);
			}
			if (StringUtils.hasText(ctApproveTimeEnd)) {
				params.put("ctApproveTimeEnd", ctApproveTimeEnd);
			}
			if (StringUtils.hasText(ctCardNumber)) {
				params.put("ctCardNumber", ctCardNumber);
			}
			if (StringUtils.hasText(ctTranCode)) {
				if(ctTranCode.equals("OPENCARD")){
					amout = "a";
					amoutstr="开卡";
				}
				if(ctTranCode.equals("LOSS")){
					amout = "a";
					amoutstr="挂失";
					params.put("ctTranCode", "LOSS");
				}
				if(ctTranCode.equals("DESTORY")){
					amout = "c";
					amoutstr="退款";
					params.put("ctTranCode", "DESTORY");
				}
				if(ctTranCode.equals("UNLOSS")){
					amout = "a";
					amoutstr="解挂";
					params.put("ctTranCode", "UNLOSS");
				}
				if(ctTranCode.equals("VDEPOSIT")){
					amout = "c";
					amoutstr="撤销";
					params.put("ctTranCode", "VDEPOSIT");
				}
				if(ctTranCode.equals("FEEBACK")){
					amout = "d";
					amoutstr="退押金";
					params.put("ctTranCode", "FEEBACK");
				}
				
			}
			if (StringUtils.hasText(ctUserCreate)) {
				params.put("ctUserCreate", ctUserCreate);
			}
			List<Opeartion> page = new ArrayList<Opeartion>();
			if(ctTranCode.equals("OPENCARD")){
				page = opeartionMapper.searchOpeartionStatWhereK(params);
			}else{
				page = opeartionMapper.searchOpeartionStatWhereOther(params);
			}
		
			String title = "会员卡操作统计报表--"+amoutstr;//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("卡号");
					add("姓名");
					add("卡类型");
					add("日期");
					add("时间");
					add("金额");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("ctCardNumber",page.get(i).getCtCardNumber());
				record.put("cbEmbossname",page.get(i).getCbEmbossname());
				record.put("prGroupDesc",page.get(i).getPrGroupDesc());
				String ctApproveDate = SysDateFormat.getDateFormat(page.get(i).getCtApproveTime(), "yyyyMMddHHmmss", "yyyy-MM-dd");
				String ctApproveTime = SysDateFormat.getDateFormat(page.get(i).getCtApproveTime(), "yyyyMMddHHmmss", "HH:mm:ss");
				record.put("ctApproveDate",ctApproveDate);
				record.put("ctApproveTime",ctApproveTime);
				String ctCardAmount = "";
				if(amout.equals("a")){
					ctCardAmount=page.get(i).getCtFeeAmount();
				}else if(amout.equals("c")){
					ctCardAmount=page.get(i).getCtTranAmount();
				}else if(amout.equals("d")){
					ctCardAmount=page.get(i).getCtBillCurrAmt();
				}
				record.put("ctCardAmount",ctCardAmount);
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", ctApproveTimeStart);
			headExtra.put("结束时间", ctApproveTimeEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, headExtra, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}	
	//会员卡充值统计下载
	public Result<String> rechargeDownLoadMethod(final String cbEmbossname, final String ctReversalFlag,final String ctCardNumber, final String prProdctGroup,final String ctApproveTimeStart, final String ctApproveTimeEnd,final String ctUserCreate, final String ctUserCreateNull,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			if (StringUtils.hasText(cbEmbossname)) {
				params.put("cbEmbossname", cbEmbossname);
			}
			if (StringUtils.hasText(ctReversalFlag)) {
				params.put("ctReversalFlag", ctReversalFlag);
			}
			if (StringUtils.hasText(ctCardNumber)) {
				params.put("ctCardNumber", ctCardNumber);
			}
			if (StringUtils.hasText(prProdctGroup)) {
				params.put("prProdctGroup", prProdctGroup);
			}
			if (StringUtils.hasText(ctApproveTimeStart+"")) {
				params.put("ctApproveTimeStart", ctApproveTimeStart);
			}
			if (StringUtils.hasText(ctApproveTimeEnd+"")) {
				params.put("ctApproveTimeEnd", ctApproveTimeEnd);
			}
			if (StringUtils.hasText(ctUserCreate)) {
				params.put("ctUserCreate", ctUserCreate);
			}
			if (StringUtils.hasText(ctUserCreateNull)) {
				params.put("ctUserCreateNull", ctUserCreateNull);
			}
			List<Recharge> page =  rechargeMapper.searchRechargeByParams(params);
		
			String title = "会员卡充值统计报表";//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("卡号");
					add("卡产品");
					add("姓名");
					add("充值时间");
					add("充值金额");
					add("操作员");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("ctCardNumber",page.get(i).getCtCardNumber());
				record.put("prGroupDesc",page.get(i).getPrGroupDesc());
				record.put("cbEmbossname",page.get(i).getCbEmbossname());
				String ctApproveTime = SysDateFormat.getDateFormat(page.get(i).getCtApproveTime(), "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss");
				record.put("ctApproveTime",ctApproveTime);
				record.put("ctBillCurrAmt",page.get(i).getCtBillCurrAmt().toString());
				record.put("ctUserCreate",page.get(i).getCtUserCreate());
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", ctApproveTimeStart);
			headExtra.put("结束时间", ctApproveTimeEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, headExtra, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}	

	//会员卡换卡统计下载
	public Result<String> vipChangeStatDownLoadMethod(final String cl_old_card,final String cl_new_card,final String cl_timestampStart,final String cl_timestampEnd,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			if (StringUtils.hasText(cl_old_card)) {
				params.put("cl_old_card", cl_old_card);
			}
			if (StringUtils.hasText(cl_new_card)) {
				params.put("cl_new_card", cl_new_card);
			}
			if (StringUtils.hasText(cl_timestampStart)) {
				params.put("cl_timestampStart", cl_timestampStart);
			}
			if (StringUtils.hasText(cl_timestampEnd)) {
				params.put("cl_timestampEnd", cl_timestampEnd);
			}
			List<FillCard> page =  fillcardMapper.searchFillChangeCardByParams(params);
		
			String title = "会员卡换卡统计报表";//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("旧卡号");
					add("新卡号");
					add("姓名");
					add("身份证号");
					add("换卡日期");
					add("换卡时间");
					add("换卡费");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("cl_old_card",page.get(i).getCl_old_card());
				record.put("cl_new_card",page.get(i).getCl_new_card());
				record.put("CB_EMBOSSNAME",page.get(i).getCB_EMBOSSNAME());
				record.put("CB_IDNO",page.get(i).getCB_IDNO());
				record.put("cl_timestamp",page.get(i).getCl_timestamp());
				record.put("cl_timestamp",page.get(i).getCl_timestamp());
				record.put("CT_FEE_AMOUNT",page.get(i).getCT_FEE_AMOUNT());
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", cl_timestampStart);
			headExtra.put("结束时间", cl_timestampEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, headExtra, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}	

	//会员卡情况统计下载
	public Result<String> vipCaseStatDownLoadMethod(final String cbAnnivDateStart, final String cbAnnivDateEnd,final String cbCardholderNo,final String prGroupDesc,final String cbPlasticCd,final String cbIdno,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			if (StringUtils.hasText(cbAnnivDateStart)) {
				params.put("cbAnnivDateStart", cbAnnivDateStart);
			}
			if (StringUtils.hasText(cbAnnivDateEnd)) {
				params.put("cbAnnivDateEnd", cbAnnivDateEnd);
			}
			if (StringUtils.hasText(cbCardholderNo)) {
				params.put("cbCardholderNo", cbCardholderNo);
			}
			if (StringUtils.hasText(prGroupDesc)) {
				params.put("prGroupDesc", prGroupDesc);
			}
			if (StringUtils.hasText(cbPlasticCd)) {
				params.put("cbPlasticCd", cbPlasticCd);
			}
			if (StringUtils.hasText(cbIdno)) {
				params.put("cbIdno", cbIdno);
			}
			List<VipCardStat> page = new ArrayList<VipCardStat>();
			String cbPlasticCdstr = "";
			if(cbPlasticCd.equals(" ")){
				page =  vipCardStatMapper.searchVipCardCaseNormalStat(params);
				page = forStat(page);
				cbPlasticCdstr = "正常";
			}else if(cbPlasticCd.equals("L")){
				page =  vipCardStatMapper.searchVipCardCaseLossStat(params);
				page = forStat(page);
				cbPlasticCdstr = "挂失";
			}else if(cbPlasticCd.equals("D")){
				page =  vipCardStatMapper.searchVipCardCaseRecedeStat(params);
				page = recedeStat(page);
				cbPlasticCdstr = "退卡";
			}else{
				page =  vipCardStatMapper.searchVipCardCaseNullStat(params);
				page = forStat(page);
			}
		
			String title = "会员卡情况统计报表";//大标题，左下角的东西
			if(!cbPlasticCdstr.equals("")){
				title+="--卡状态"+cbPlasticCdstr;
			}
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("卡号");
					add("卡类型");
					add("卡状态");
					add("余额");
					add("日期");
					add("卡有效期");
					add("卡主证件类型");
					add("卡主证件号");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("cbCardholderNo",page.get(i).getCbCardholderNo());
				record.put("prGroupDesc",page.get(i).getPrGroupDesc());
				record.put("cbPlasticCd",page.get(i).getCbPlasticCd());
				record.put("cbOutstdBal",page.get(i).getCbOutstdBal().toString());
				record.put("cbAnnivDate",page.get(i).getCbAnnivDate());
				record.put("cbExpiryCcyymm",page.get(i).getCbExpiryCcyymm());
				record.put("cbIdDesc",page.get(i).getCbIdDesc());
				record.put("cbIdno",page.get(i).getCbIdno());
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", cbAnnivDateStart);
			headExtra.put("结束时间", cbAnnivDateEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, headExtra, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}	

}
