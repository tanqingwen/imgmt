package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpMemberShip;
import cn.happyworlds.imgmt.mapper.CpMemberShipMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpMemberShipService {
	
	@Autowired
	private CpMemberShipMapper cpMemberShipMapper;
	
	public List<CpMemberShip> cpMemberShipList(){
		return cpMemberShipMapper.searchCpMemberShipByParams(null);
		}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<CpMemberShip>> cpMemberShipList(final String memberShipId,final String memberShipDesc,PageBounds pageBounds){
		Map<String, String> params=new HashMap<>();
		if(StringUtils.hasText(memberShipId)){
			params.put("meGradeId", memberShipId);
			}
		if(StringUtils.hasText(memberShipDesc)){
			params.put("meGradeDesc", memberShipDesc);
		}
		List<CpMemberShip> page=cpMemberShipMapper.searchCpMemberShipByParams(params,pageBounds);
		return Result.create(new PageInfo(page));
	}
	
	public Result<CpMemberShip> cpMemberShipById(final String memberShipId){
		if(StringUtils.isEmpty(memberShipId)){
			return Result.create("CPMEMBERSHIP_DICT_ID_IS_EMPTY","会员等级代码id不能为空");
		}
		CpMemberShip ship=cpMemberShipMapper.searchCpMemberShipByMeGradeId(memberShipId);
		if(ship == null){
			return Result.create("CPMEMBERSHIP_DICT_NOT_FOUND", "会员等级没有找到");
		}
		return Result.create(ship);
	}
	
	public Result<String> cpMemberShipAdd(CpMemberShip cpMemberShip){
		CpMemberShip shipId=cpMemberShipMapper.searchCpMemberShipByMeGradeId(cpMemberShip.getMeGradeId());
		CpMemberShip shipName=cpMemberShipMapper.searchCpMemberShipByMeGradeDesc(cpMemberShip.getMeGradeDesc());
		if(null !=shipId){
			return Result.create("CPMEMBERSHIP_DICT_NOT_FOUND", "此会员等级代码已存在");
		}else if(null !=shipName){
			return Result.create("CPMEMBERSHIP_DICT_NOT_FOUND", "此会员等级名称已存在");
		}
		cpMemberShipMapper.insertCpMemberShip(cpMemberShip);
			return Result.create(cpMemberShip.getMeGradeId());
	}
	
	public Result<String> cpMemberShipDelete(String memberShipId){
		cpMemberShipMapper.deleteCpMemberShipByMeGradeId(memberShipId);
		return Result.create(memberShipId);
	}
	
	public Result<String> cpMemberShipUpdate(CpMemberShip cpMemberShip){
		CpMemberShip ship=cpMemberShipMapper.searchCpMemberShipByMeGradeDesc(cpMemberShip.getMeGradeDesc());
		Map<String, String> params=new HashMap<>();
		params.put("meGradeId", cpMemberShip.getMeGradeId());
		params.put("meGradeDesc", cpMemberShip.getMeGradeDesc());
		List<CpMemberShip> shipName=cpMemberShipMapper.searchCpMemberShipByParams(params);
		if(null !=ship){
			if(shipName.size()>0){
				cpMemberShipMapper.updateCpMemberShip(cpMemberShip);
				return Result.create(cpMemberShip.getMeGradeId());
			}else{
				return Result.create("CPMEMBERSHIP_DICT_NOT_FOUND","此会员等级名称已存在");
			}
		}
		cpMemberShipMapper.updateCpMemberShip(cpMemberShip);
		return Result.create(cpMemberShip.getMeGradeId());
	}
}
