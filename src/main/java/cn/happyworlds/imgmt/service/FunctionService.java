package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.TSysFunction;
import cn.happyworlds.imgmt.entity.TSysFunction2;
import cn.happyworlds.imgmt.mapper.TSysFunction2Mapper;
import cn.happyworlds.imgmt.mapper.TSysFunctionMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class FunctionService {

	@Autowired
	private TSysFunctionMapper tSysFunctionMapper;
	
	@Autowired
	private TSysFunction2Mapper tSysFunction2Mapper;
	
	public List<TSysFunction> functionList() {
		return tSysFunctionMapper.searchTSysFunctionByParams(null);
	}
	
	public List<TSysFunction2> functionList2() {
		return tSysFunction2Mapper.searchTSysFunction2ByParams(null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<TSysFunction>> functionList(final String functionId, final String functionName, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (!StringUtils.hasText(functionId)) {
			params.put("id", functionId);
		}
		if (!StringUtils.hasText(functionName)) {
			params.put("name", functionName);
		}
		List<TSysFunction> page = tSysFunctionMapper.searchTSysFunctionByParams(params, pageBounds);
		return Result.create(new PageInfo(page));
	}

	public Result<TSysFunction> functionAdd(TSysFunction function) {
		TSysFunction dbRole = tSysFunctionMapper.searchTSysFunctionById(function.getId());
		if (null != dbRole) {
			return Result.create("ROLE_ID_EXISTS", "角色已经存在");
		}
		try {
			tSysFunctionMapper.insertTSysFunction(function);
			return Result.create(function);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ROLE_ADD_FAILED", "角色添加失败");
		}
	}

	public Result<TSysFunction> functionGetById(String id) {
		TSysFunction dbRole = tSysFunctionMapper.searchTSysFunctionById(id);
		if (null == dbRole) {
			return Result.create("ROLE_NOT_EXISTS", "角色不存在");
		}
		return Result.create(dbRole);
	}

	public Result<TSysFunction> functionUpdate(TSysFunction function) {
		try {
			tSysFunctionMapper.updateTSysFunction(function);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ROLE_UPDATE_FAILED", "角色更新失败");
		}
		return Result.create(function);
	}
}
