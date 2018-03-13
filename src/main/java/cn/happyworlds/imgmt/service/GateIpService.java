package cn.happyworlds.imgmt.service;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpGateip;
import cn.happyworlds.imgmt.mapper.CpGateipMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class GateIpService {

	@Autowired
	private CpGateipMapper gateipMapper;
	
	//闸机IP列表 by Hugh
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<CpGateip>> gateIpList(final String gaTm, final String gaIp, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(gaTm)) {
			params.put("gaTm", gaTm);
		}
		if (StringUtils.hasText(gaIp)) {
			params.put("gaIp", gaIp);
		}
		List<CpGateip> page = gateipMapper.searchCpGateipByParams(params, pageBounds);
		return Result.create(new PageInfo(page));
	}
	
	//闸机IP添加 by Hugh
	public Result<String> gateIpAdd(CpGateip gateIp) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(gateIp.getGaIp())) {
			params.put("gaIp", gateIp.getGaIp());
		}
		
		List<CpGateip> gateIpList = gateipMapper.searchCpGateipByParams(params);
		if (null != gateIpList && gateIpList.size()>0) {
			return Result.create("GATEIP_NOT_FOUND", "此闸机IP已存在");
		}
		gateipMapper.insertCpGateip(gateIp);
		return Result.create(gateIp.getGaIp());
	}
	
	//闸机IP编号自动累加获取
	public CpGateip maxGateIpId(){
		CpGateip gateIp = gateipMapper.searchMaxGateIpId();
		return gateIp;
	}
	
	//闸机IP查询
	public Result<CpGateip> gateIpGetById(final String id) {
		if(StringUtils.isEmpty(id)){
			return Result.create("GATE_IP_ID_IS_EMPTY", "闸机编号不能为空");
		}
		CpGateip gateIp = gateipMapper.searchCpGateipByGaId(Integer.parseInt(id));
		if (null == gateIp) {
			return Result.create("GATE_IP_ID_NOT_FOUND", "闸机记录没有找到");
		}
		return Result.create(gateIp);
	}
	
	//闸机IP更新
	public Result<String> gateIpUpdate(CpGateip gateIp) {
		gateipMapper.updateCpGateip(gateIp);
		return Result.create(String.valueOf(gateIp.getGaId()));
	}

	//闸机IP删除
	public Result<String> gateIpDelete(String gateId) {
		gateipMapper.deleteCpGateipByGaId(Integer.parseInt(gateId));
		return Result.create(gateId);
	}



}