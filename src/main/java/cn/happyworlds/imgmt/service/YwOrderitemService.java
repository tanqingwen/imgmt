package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class YwOrderitemService {

	@Autowired
	private YwOrderitemMapper ywOrderitemMapper;
	@Autowired
	private CpTktypeMapper cpTktypeMapper;
	
	public Result<PageInfo<YwOrderitem>> searchYwOrderitemByhwOrderId(String hwOrderId, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(hwOrderId)) {
			params.put("hwOrderId", hwOrderId);
		}
		List<YwOrderitem> page = ywOrderitemMapper.searchYwOrderitemByParams(params, pageBounds);
		for(YwOrderitem orderItem:page){
			orderItem.setHwTicketName(cpTktypeMapper.searchCpTktypeByTtTypeId(Integer.parseInt(orderItem.getHwProdctGroup())).getTtTypeDesc());
		}
		return Result.create(new PageInfo<YwOrderitem>(page));
	}
	
}
