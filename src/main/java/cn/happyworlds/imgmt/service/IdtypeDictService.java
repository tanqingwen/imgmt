package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import cn.happyworlds.imgmt.entity.MIdtypeDict;
import cn.happyworlds.imgmt.mapper.MIdtypeDictMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.StatusResult;

@Service
public class IdtypeDictService {

	@Autowired
	private MIdtypeDictMapper idtypeDictMapper;
	

	public List<MIdtypeDict> midTypeDictList() {
		return idtypeDictMapper.searchMIdtypeDictByParams(null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StatusResult<PageInfo<MIdtypeDict>> midTypeDictList(final String idtypeId,final String idtypeDesc, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(idtypeId)) {
			params.put("idtypeId", idtypeId);
		}
		if (StringUtils.hasText(idtypeDesc)){
			params.put("idtypeDesc", idtypeDesc);
		}
		List<MIdtypeDict> page =  idtypeDictMapper.searchMIdtypeDictByParams(params, pageBounds);
		return StatusResult.create(new PageInfo(page));		
	} 

	public StatusResult<MIdtypeDict> midTypeDictAdd(MIdtypeDict dict) {
		MIdtypeDict mIdtypeDict = idtypeDictMapper.searchMIdtypeDictByIdtypeId(dict.getIdtypeId());
		if (null != mIdtypeDict) {
			return StatusResult.create("IDTYPE_DICT_ID_EXISTS", "证件类型已经存在");
		}
		try {
			idtypeDictMapper.insertMIdtypeDict(dict);
			return StatusResult.create(dict);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("IDTYPE_DICT_ADD_FAILED", "证件类型添加失败");
		}
	}

	public StatusResult<MIdtypeDict> midTypeDictGetById(String id) {
		MIdtypeDict mIdtypeDict = idtypeDictMapper.searchMIdtypeDictByIdtypeId(id);
		if (null == mIdtypeDict) {
			return StatusResult.create("IDTYPE_DICT_NOT_EXISTS", "证件类型不存在");
		}
		return StatusResult.create(mIdtypeDict);
	}

	public StatusResult<MIdtypeDict> midTypeDictUpdate(MIdtypeDict midTypeDict) {
		try {
			idtypeDictMapper.updateMIdtypeDict(midTypeDict);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("IDTYPE_DICT_UPDATE_FAILED", "证件类型更新失败");
		}
		return StatusResult.create(midTypeDict);
	}
	
	public StatusResult<MIdtypeDict> midTypeDictDelete(String idtypeId) {
		try {
			idtypeDictMapper.deleteMIdtypeDictByIdtypeId(idtypeId);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("IDTYPE_DICT_UPDATE_FAILED", "证件类型删除失败");
		}
		return StatusResult.create(null);
	}
	
	

	

	
	
	
}
