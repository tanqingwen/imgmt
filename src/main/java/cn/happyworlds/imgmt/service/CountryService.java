package cn.happyworlds.imgmt.service;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import cn.happyworlds.imgmt.entity.MCountryDict;
import cn.happyworlds.imgmt.mapper.MCountryMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CountryService {

	@Autowired
	private MCountryMapper countryMapper;
	
	public List<MCountryDict> countryList() {
		return  countryMapper.searchMCountryDictByParams(null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<MCountryDict>> countryList(final String countryId, final String countryName, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(countryId)) {
			params.put("alphaCtryCd", countryId);
		}
		if (StringUtils.hasText(countryName)) {
			params.put("ctryDescription", countryName);
		}
		List<MCountryDict> page = countryMapper.searchMCountryDictByParams(params, pageBounds);
		return Result.create(new PageInfo(page));
	}

	public Result<MCountryDict> countryGetById(final String id) {
		if(StringUtils.isEmpty(id)){
			return Result.create("COUNTRY_DICT_ID_IS_EMPTY", "国家代码ID不能为空");
		}
		MCountryDict country = countryMapper.searchMCountryDictByAlphaCtryCd(id);
		if (null == country) {
			return Result.create("COUNTRY_DICT_NOT_FOUND", "国家代码没有找到");
		}
		return Result.create(country);
	}
	
	public Result<String> countryAdd(MCountryDict countryDict) {
		MCountryDict country = countryMapper.searchMCountryDictByAlphaCtryCd(countryDict.getAlphaCtryCd());
		if (null != country) {
			return Result.create("COUNTRY_DICT_NOT_FOUND", "此国家代码已存在");
		}
		countryMapper.insertMCountryDict(countryDict);
		return Result.create(countryDict.getAlphaCtryCd());
	}
	
	public Result<String> countryDelete(String countryId) {
		countryMapper.deleteMCountryDictByAlphaCtryCd(countryId);
		return Result.create(countryId);
	}

	public Result<String> countryUpdate(MCountryDict countryDict) {
		countryMapper.updateMCountryDict(countryDict);
		return Result.create(countryDict.getAlphaCtryCd());
	}

}