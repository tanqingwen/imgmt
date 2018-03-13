package cn.happyworlds.imgmt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.mapper.CpIdtypeMapper;
import cn.happyworlds.imgmt.util.Result;

@Service
public class IdtypeService {

	@Autowired
	private CpIdtypeMapper CpIdtypeMapper;
	
	public Result<List<CpIdtype>> idTypeListAll() {
		List<CpIdtype> page = CpIdtypeMapper.searchCpIdtypeByParams(null);
		return Result.create(page);
	}
	
}