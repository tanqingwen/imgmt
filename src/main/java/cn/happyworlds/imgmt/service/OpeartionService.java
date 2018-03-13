package cn.happyworlds.imgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.Opeartion;
import cn.happyworlds.imgmt.mapper.OpeartionMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;


@Service
public class OpeartionService {
	
	@Autowired
	private OpeartionMapper opeartionMapper;
	
	public Result<PageInfo<Opeartion>> OpeartionList(final String ctApproveTimeStart, final String ctApproveTimeEnd, final String ctCardNumber, final String ctTranCode, final String ctUserCreate,HttpServletRequest request, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		String amout=null;
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
				request.setAttribute("amout", amout);
			}
			if(ctTranCode.equals("LOSS")){
				amout = "a";
				params.put("ctTranCode", "LOSS");
				request.setAttribute("amout", amout);
			}
			if(ctTranCode.equals("DESTORY")){
				amout = "c";
				params.put("ctTranCode", "DESTORY");
				request.setAttribute("amout", amout);
			}
			if(ctTranCode.equals("UNLOSS")){
				amout = "a";
				params.put("ctTranCode", "UNLOSS");
				request.setAttribute("amout", amout);
			}
			if(ctTranCode.equals("VDEPOSIT")){
				amout = "c";
				params.put("ctTranCode", "VDEPOSIT");
				request.setAttribute("amout", amout);
			}
			if(ctTranCode.equals("FEEBACK")){
				amout = "d";
				params.put("ctTranCode", "FEEBACK");
				request.setAttribute("amout", amout);
			}
			
		}
		if (StringUtils.hasText(ctUserCreate)) {
			params.put("ctUserCreate", ctUserCreate);
		}
		List<Opeartion> page = new ArrayList<Opeartion>();
		if(ctTranCode.equals("OPENCARD")){
			page = opeartionMapper.searchOpeartionStatWhereK(params, pageBounds);
		}else{
			page = opeartionMapper.searchOpeartionStatWhereOther(params, pageBounds);
		}
		for (int i = 0; i < page.size(); i++) {
			page.get(i).setCtCardNumber(page.get(i).getCtCardNumber().substring(page.get(i).getCtCardNumber().length() - 6, page.get(i).getCtCardNumber().length()));
		}
		return Result.create(new PageInfo<Opeartion>(page));		
	} 


}
