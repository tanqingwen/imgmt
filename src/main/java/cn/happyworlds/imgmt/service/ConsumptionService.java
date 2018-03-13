package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.Consumption;
import cn.happyworlds.imgmt.entity.FillCard;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.ConsumptionMapper;
import cn.happyworlds.imgmt.mapper.FillCardMapper;
import cn.happyworlds.imgmt.mapper.TSysStaffMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;


@Service
public class ConsumptionService {
	
	@Autowired
	private ConsumptionMapper consumptionMapper;
	
	@Autowired
	private FillCardMapper fillcardMapper;
	
	@Autowired
	private TSysStaffMapper tSysStaffMapper;
	
	public Result<PageInfo<Consumption>> ConsumptionList(final String cbEmbossname,final String tmDbaName,final String ctCardNumber,final String prProdctGroup,final String ctDisputeDateStart,final String ctDisputeDateEnd,final String ctDisputeDateStatus,PageBounds pageBounds){
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
		List<Consumption> page =  consumptionMapper.searchConsumptionByParams(params, pageBounds);
		for (int i = 0; i < page.size(); i++) {
			page.get(i).setCtCardNumber(page.get(i).getCtCardNumber().substring(page.get(i).getCtCardNumber().length() - 6, page.get(i).getCtCardNumber().length()));
			BigDecimal CtTranAmount = new BigDecimal(page.get(i).getCtTranAmount());
			BigDecimal CtCardAmount = new BigDecimal(page.get(i).getCtCardAmount());
			page.get(i).setCtCardAmount(CtTranAmount.subtract(CtCardAmount).toString());
		}
		return Result.create(new PageInfo<Consumption>(page));		
	}
	
	
	
	public Result<PageInfo<FillCard>> FillCardList(final String cl_old_card,final String cl_new_card,final String cl_timestampStart,final String cl_timestampEnd,final String cl_auth_user_id,PageBounds pageBounds){
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
		if (StringUtils.hasText(cl_auth_user_id)) {
			params.put("cl_auth_user_id", cl_auth_user_id);
		}
		List<FillCard> page =  fillcardMapper.searchFillCardByParams(params, pageBounds);
		return Result.create(new PageInfo<FillCard>(page));		
	}
	public Result<PageInfo<FillCard>> FillCardChangeList(final String cl_old_card,final String cl_new_card,final String cl_timestampStart,final String cl_timestampEnd,PageBounds pageBounds){
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
		List<FillCard> page =  fillcardMapper.searchFillChangeCardByParams(params, pageBounds);
		return Result.create(new PageInfo<FillCard>(page));
	}
	
	
	public Result<List<TSysStaff>> TSysStaffListAll() {
		List<TSysStaff> page = tSysStaffMapper.searchTSysStaffByParams(null);
		return Result.create(page);
	}
	
	
	
}
