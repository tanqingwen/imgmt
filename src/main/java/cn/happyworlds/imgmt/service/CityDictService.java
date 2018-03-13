package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import cn.happyworlds.imgmt.entity.MCityDict;
import cn.happyworlds.imgmt.mapper.MCityDictMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.StatusResult;

@Service
public class CityDictService {

	@Autowired
	private MCityDictMapper cityDictMapper;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StatusResult<PageInfo<MCityDict>> cityList(final String cityId, final String cityName, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cityId)) {
			params.put("cityId", cityId);
		}
		if (StringUtils.hasText(cityName)) {
			params.put("cityName", cityName);
		}
		List<MCityDict> city = cityDictMapper.searchMCityDictByParams(params, pageBounds);
		return StatusResult.create(new PageInfo(city));
	}
	
	public StatusResult<List<MCityDict>> cityListByProvinceId(final String provinceId) {
		if (!StringUtils.hasText(provinceId)) {
			return StatusResult.create("PROVINCE_ID_IS_EMPTY", "省份ID不能为空");
		}
		Map<String, String> params = new HashMap<>();
		params.put("provinceId", provinceId);
		List<MCityDict> cities = cityDictMapper.searchMCityDictByParams(params);
		return StatusResult.create(cities);
	}
	
	public StatusResult<List<MCityDict>> cityListByRegionCd(final String regionCode) {
		if (!StringUtils.hasText(regionCode)) {
			return StatusResult.create("REGION_CODE_IS_EMPTY", "区域代码不能为空");
		}
		Map<String, String> params = new HashMap<>();
		params.put("regionCd", regionCode);
		List<MCityDict> cities = cityDictMapper.searchMCityDictByParams(params);
		return StatusResult.create(cities);
	}

	public StatusResult<MCityDict> mcityId(String cityId) {
		MCityDict mcitydict = cityDictMapper.searchMCityDictByCityId(cityId);
		if (null == mcitydict) {
			return StatusResult.create("STAFF_NOT_CITY", "城市不存在");
		}
		return StatusResult.create(mcitydict);
	}

	public StatusResult<MCityDict> mcityAdd(MCityDict mcitydict) {
		MCityDict mcitydictt = cityDictMapper.searchMCityDictByCityId(mcitydict.getCityId());
		if (null != mcitydictt) {
			return StatusResult.create("STAFF_ID_CITY", "城市已经存在");
		}
		try {
			cityDictMapper.insertMCityDict(mcitydict);
			return StatusResult.create(mcitydict);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("STAFF_ADD_CITY", "城市添加失败");
		}

	}

	public StatusResult<MCityDict> mcityUpdate(MCityDict mcitydict) {
		try {
			cityDictMapper.updateMCityDict(mcitydict);

		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("STAFF_UPDATE_CITY", "城市更新失败");
		}
		return StatusResult.create(mcitydict);
	}

	public StatusResult<MCityDict> mcitydelete(String cityId) {
		try {
			cityDictMapper.deleteMCityDictByCityId(cityId);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("STAFF_UPDATE_CITY", "城市删除失败");
		}
		return StatusResult.create(null);
	}
}
