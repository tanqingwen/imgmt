package cn.happyworlds.imgmt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import cn.happyworlds.imgmt.entity.TSysOption;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.mapper.TSysOptionMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;

@Service
public class OptionService {

	@Autowired
	private TSysOptionMapper tSysOptionMapper;

	public Result<Map<String, String>> optionGetById(final String id) {
		TSysOption option = tSysOptionMapper.searchTSysOptionById(id);
		if (null == option) {
			return Result.create("OPTION_NOT_FOUND", "参数项没有找到");
		}
		Map<String, String> dataMap = Jackson.readJson(option.getData(), new TypeReference<Map<String, String>>() {
		});
		return Result.create(dataMap);
	}

	public Result<String> optionSaveById(final String id, final String data) {
		TSysOption option = tSysOptionMapper.searchTSysOptionById(id);
		if (null == option) {
			option = new TSysOption();
			option.setId(id);
			option.setData(data);
			option.setUpdatedAt(DateTimes.nowTimestamp());
			tSysOptionMapper.insertTSysOption(option);
		} else {
			option.setData(data);
			option.setUpdatedAt(DateTimes.nowTimestamp());
			tSysOptionMapper.updateTSysOption(option);
		}
		return Result.create(option.getId());
	}
}
