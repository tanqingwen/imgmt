package cn.happyworlds.imgmt.service.rest;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import cn.happyworlds.imgmt.context.YanwuProperties;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpTktypeService;
import cn.happyworlds.imgmt.util.Result;

@Service
public class RestTktypeService {

	@Autowired
	private CpTktypeMapper cpTktypeMapper;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private YanwuProperties yanwuProperties;
	
	@Autowired
	private CpTktypeService cpTktypeService;
	
	/**
	 * 获得日历ID
	 * @return
	 */
	public Integer id() {
		CpTktype tktype = cpTktypeMapper.searchMaxTktypeId();
		return tktype.getTtTypeId();
	}
	
	/**
	 * 票券种类列表  1001
	 * @param ttTypeId
	 * @param ttTypeDesc
	 * @param p
	 * @param size
	 * @return
	 */
	public Result<List<CpTktype>> list(String ttTypeId, String ttTypeDesc, Integer p, Integer size) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(ttTypeId)) {
			params.put("ttTypeId", ttTypeId);
		}
		if (StringUtils.hasText(ttTypeDesc)) {
			params.put("ttTypeDesc", ttTypeDesc);
		}
		List<CpTktype> page = cpTktypeMapper.searchCpTktypeByParams(params, new PageBounds(p, size));
		return Result.create(page);
	}
	/**
	 * 票券更新  1002
	 * @param cpTktype
	 * @param ra
	 * @return
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Transactional(rollbackFor = Exception.class)
	public Object add(CpTktype cpTktype) throws Exception {
		
		cpTktype.setTtStartDate(cpTktype.getTtStartDate().replaceAll("-", "").replaceAll(":", ""));
		cpTktype.setTtEndDate(cpTktype.getTtEndDate().replaceAll("-", "").replaceAll(":", ""));
		CpTktype tktype = cpTktypeMapper.searchCpTktypeByTtTypeId(cpTktype.getTtTypeId());
		if(tktype!=null){
			return Result.create("DUPLICATING", "同样的票劵ID已经存在于列表中！");
		}
		cpTktypeMapper.insertCpTktype(cpTktype);
		
		String startDate = StringUtils.trimAllWhitespace(cpTktype.getTtStartDate());
		String endDate = StringUtils.trimAllWhitespace(cpTktype.getTtEndDate());
		String url = yanwuProperties.getMicroservice() + "calendar";
		String data = "{\"id\":\""+cpTktype.getTtTypeId()+"\",\"type\":\"ticket\",\"year\":"
				+ "[],"
				+ "\"years\":[\""+startDate+","+endDate+"\"]";
		@SuppressWarnings("unchecked")
		Result<String> resp = restTemplate.postForObject(url + "?data={data}", null, Result.class, data);
		System.out.println(resp.getStatus());
		System.out.println(resp.getComment());
		System.out.println(resp.getValue());
		return resp;
	}

	/**
	 * 票券查看  1003
	 * @param ttTypeId
	 * @param m
	 * @return
	 */
	public Object obtain(Integer ttTypeId) {
		try {
			CpTktype cpTktype = cpTktypeService.searchCpTktypeByTtTypeId(ttTypeId);
			if(Objects.isNull(cpTktype))
				return Result.create("error", "未查到票券");
			return Result.create(cpTktype);
		}catch(Exception e) {
			return Result.create("error", "系统异常");
		}
	}
	
	/**
	 * 票券删除  1004
	 * @param ttTypeId
	 * @param m
	 * @return
	 */
	public Object delete(Integer ttTypeId) {
		try {
			CpTktype cpTktype = cpTktypeService.searchCpTktypeByTtTypeId(ttTypeId);
			Result<CpTktype> r=cpTktypeService.delect(cpTktype);
			String url = yanwuProperties.getMicroservice() + "calendar/deleteByIdAndType";
			String typeId = "ticket";
			String id = cpTktype.getTtTypeId().toString();
			@SuppressWarnings("unchecked")
			Result<String> resp = restTemplate.postForObject(url+"?id={id}&type={typeId}", null, Result.class, id, typeId);
			System.out.println(resp.getStatus());
			System.out.println(resp.getComment());
			System.out.println(resp.getValue());
			return resp;
		}catch(Exception e) {
			return Result.create("error", "系统异常");
		}
	}
}
