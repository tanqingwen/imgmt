package cn.happyworlds.imgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.CpCurtbl;
import cn.happyworlds.imgmt.mapper.CpCurtblMapper;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CurtblService {

	@Autowired
	private CpCurtblMapper cpCurtblMapper;
 
	public Result<List<CpCurtbl>> curTblListAll() {
		List<CpCurtbl> page = cpCurtblMapper.searchCpCurtblByParams(null);
		return Result.create(page);
	}

}
