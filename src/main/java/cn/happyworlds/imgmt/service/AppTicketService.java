package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.AppTicket;
import cn.happyworlds.imgmt.entity.CpVerkey;
import cn.happyworlds.imgmt.entity.Opeartion;
import cn.happyworlds.imgmt.entity.TSysFunction;
import cn.happyworlds.imgmt.mapper.AppTicketMapper;
import cn.happyworlds.imgmt.mapper.CpVerkeyMapper;
import cn.happyworlds.imgmt.mapper.TSysFunctionMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class AppTicketService {

	@Autowired
	private AppTicketMapper appticketMapper;
	
	public Result<PageInfo<AppTicket>> appticketList(String mobileNumber,String ticketId,PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mobileNumber)) {
			params.put("mobileNumber", mobileNumber);
		}if (StringUtils.hasText(ticketId)) {
			params.put("ticketId", ticketId);
		}
		List<AppTicket> page = appticketMapper.searchAppTicketByParams(null,pageBounds);
//		List<AppTicket> page = appticketMapper.searchAppTicketByParams(null);
		return Result.create(new PageInfo<AppTicket>(page));
	}
	
	public Long deleteAppTicketByTicketId(final String ticketId) {
		Long r = appticketMapper.deleteAppTicketByTicketId(ticketId);
		return r;
	}
	
	/*public Result<CpVerkey> cpVerkeyGetById(String id) {
		CpVerkey dbRole = cpVerkeyMapper.searchCpVerkeyByVkValue(id);
		if (null == dbRole) {
			return Result.create("ROLE_NOT_EXISTS", "角色不存在");
		}
		return Result.create(dbRole);
		
	}
	
	public CpVerkey cpVerkeyGetByVKValue(String id) {
		CpVerkey dbRole = cpVerkeyMapper.searchCpVerkeyByVkValue(id);
		
		return dbRole;
		
	}
	
	public Result<CpVerkey> cpVerkeyUpdate(CpVerkey cpVerkey) {
		try {
			cpVerkeyMapper.updateCpVerkey(cpVerkey);
			
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ROLE_UPDATE_FAILED", "密匙更新失败");
		}
		return Result.create(cpVerkey);
	}*/

	
}
