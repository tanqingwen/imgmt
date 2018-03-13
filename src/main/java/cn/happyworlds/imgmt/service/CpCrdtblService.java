package cn.happyworlds.imgmt.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.YwPayrecord;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpCrdtblService {

	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	
	
	//查询会员信息
	public Result<CpCrdtbl> searchCpCsttblCbIdno(final String cbIdno){
		if(StringUtils.isEmpty(cbIdno));
		CpCrdtbl cpcrdtbl =cpCrdtblMapper.searchCpCrdtblByCbIdno(cbIdno);
		if(cpcrdtbl==null){
			return Result.create("error","未找到数据");
		}
		return Result.create(cpcrdtbl);
	}
	
	/**
	 * 查询出最大卡号
	 * @return
	 */
	public String searchMaxCrdNo(){
		return cpCrdtblMapper.searchMaxCrdNo();
	}
	
	/**
	 * 查出可用的卡的数量
	 */
	public Integer searchAvailableNumber(){
		return cpCrdtblMapper.searchAvailableNumber();
	}
	
	
	
}
