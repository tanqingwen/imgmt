package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import cn.happyworlds.imgmt.entity.MProvinceDict;
import cn.happyworlds.imgmt.mapper.MProvinceDictMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class ProvinceDictService {

	@Autowired
	private  MProvinceDictMapper provinceDictMapper;

	public List<MProvinceDict> mProvinceList() {
		return provinceDictMapper.searchMProvinceDictByParams(null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<MProvinceDict>> mProvinceList(final String provinceId, final String provinceName, PageBounds pageBounds) {		
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(provinceId )) {
			params.put("provinceId", provinceId);
		}
		if (StringUtils.hasText(provinceName)) {
			params.put("provinceName", provinceName);
		}
		List<MProvinceDict> page = provinceDictMapper.searchMProvinceDictByParams(params, pageBounds);
		return Result.create(new PageInfo(page));
	}

	public Result<MProvinceDict> mProvinceAdd(MProvinceDict mProvince) {
		if(mProvince.getProvinceId()==null || mProvince.getProvinceId().equals("")){
			return Result.create("PROVINCE_DICT_ID_EXISTS", "省份ID不能为空");
		}
		if(mProvince.getProvinceName()==null || mProvince.getProvinceName().equals("")){
			return Result.create("PROVINCE_DICT_ID_EXISTS", "省份名称不能为空");
		}
		MProvinceDict dbmProvince = provinceDictMapper.searchMProvinceDictByProvinceId(mProvince.getProvinceId());
		if (null != dbmProvince) {
			return Result.create("PROVINCE_DICT_ID_EXISTS", "省份已经存在");
		}
		try {
			provinceDictMapper.insertMProvinceDict(mProvince);;
			return Result.create(mProvince);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("PROVINCE_DICT_ADD_FAILED", "省份添加失败");
		}
	}

	public Result<MProvinceDict> mProvinceGetById(String provinceId) {
		MProvinceDict dbmProvince = provinceDictMapper.searchMProvinceDictByProvinceId(provinceId);
		if (null == dbmProvince) {
			return Result.create("PROVINCE_DICT_NOT_EXISTS", "省份不存在");
		}
		return Result.create(dbmProvince);
	}

	public Result<MProvinceDict> mProvinceUpdate(MProvinceDict mProvince) {
		try {
			provinceDictMapper.updateMProvinceDict(mProvince);;
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("PROVINCE_DICT_UPDATE_FAILED", "省份更新失败");
		}
		return Result.create(mProvince);
	}
	
	public Result<List<String>> searchCountryById(String alphaCtryCd){
		if (StringUtils.isEmpty(alphaCtryCd)) {
			return Result.create("PROVINCE_DICT_ID_IS_EMPTY", "国家字母ID不能为空");
		}
		List<String> contract= provinceDictMapper.searchCountryById(alphaCtryCd);
		return Result.create(contract);
	}

	public Result<MProvinceDict> midTypeDictDelete(String provinceId) {
		try {
			provinceDictMapper.deleteMProvinceDictByProvinceId(provinceId);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("IDTYPE_DICT_UPDATE_FAILED", "省份删除失败");
		}
		return Result.create(null);
	}
}
