package cn.happyworlds.imgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.happyworlds.imgmt.entity.CpVerkey;
import cn.happyworlds.imgmt.mapper.CpVerkeyMapper;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpVerkeyService {

	@Autowired
	private CpVerkeyMapper cpVerkeyMapper;
	
	public Result<List<CpVerkey>> cpverkeyList() {
		List<CpVerkey> r = cpVerkeyMapper.searchCpVerkeyByParams(null);
		return Result.create(r);
	}
	
	public Result<CpVerkey> cpVerkeyGetById(String id) {
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
	}

	
}
