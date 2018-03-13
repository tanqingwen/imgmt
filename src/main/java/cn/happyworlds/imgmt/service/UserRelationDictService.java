package cn.happyworlds.imgmt.service;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import cn.happyworlds.imgmt.entity.MUserRelationDict;
import cn.happyworlds.imgmt.mapper.MUserRelationDictMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.StatusResult;

@Service
public class UserRelationDictService {

	@Autowired
	private MUserRelationDictMapper userRelationDictMapper;
	
	public List<MUserRelationDict> mUserRelationDictList() {
		return userRelationDictMapper.searchMUserRelationDictByParams(null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StatusResult<PageInfo<MUserRelationDictMapper>> mUserRelationDictList(final String userRelationId, final String userRelationDesc, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(userRelationId)) {
			params.put("userRelationId", userRelationId);
		}
		if (StringUtils.hasText(userRelationDesc)) {
			params.put("userRelationDesc", userRelationDesc);
		}
		List<MUserRelationDict> page = userRelationDictMapper.searchMUserRelationDictByParams(params, pageBounds);
		return StatusResult.create(new PageInfo(page));
	}

	public StatusResult<MUserRelationDict> muserRelationDictAdd(MUserRelationDict  muserRelation) {
		MUserRelationDict dbuserRelationDict = userRelationDictMapper.searchMUserRelationDictByUserRelationId( muserRelation.getUserRelationId());
		if (null != dbuserRelationDict) {
			return StatusResult.create("USER_RELATION_DICT_ID_EXISTS", "关系已经存在");
		}
		try {		 
			userRelationDictMapper.insertMUserRelationDict(muserRelation);
			return StatusResult.create(muserRelation);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("USER_RELATION_DICT_ADD_FAILED", "关系添加失败");
		}
	}

	public StatusResult<MUserRelationDict> muserRelationDictGetById(String userRelationId) {
		MUserRelationDict dbuserRelationDict = userRelationDictMapper.searchMUserRelationDictByUserRelationId(userRelationId);
		if (null == dbuserRelationDict) {
			return StatusResult.create("USER_RELATION_DICT_NOT_EXISTS", "关系不存在");
		}
		return StatusResult.create(dbuserRelationDict);
	}

	public StatusResult<MUserRelationDict> muserRelationDictUpdate(MUserRelationDict muserRelationDict) {
		try {
			userRelationDictMapper.updateMUserRelationDict(muserRelationDict);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("USER_RELATION_DICT_UPDATE_FAILED", "关系更新失败");
		}
		return StatusResult.create(muserRelationDict);
	}
	
	public StatusResult<MUserRelationDict> midTypeDictDelete(String userRelationId) {
		try {
			userRelationDictMapper.deleteMUserRelationDictByUserRelationId(userRelationId);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("IDTYPE_DICT_UPDATE_FAILED", "人际关系删除失败");
		}
		return StatusResult.create(null);
	}
}

