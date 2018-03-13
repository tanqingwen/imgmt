package cn.happyworlds.imgmt.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpBlkmlc;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.mapper.CpPrdgrpMapper;
import cn.happyworlds.imgmt.mapper.CpBlkmlcMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;

@Service
public class BlacklistService {

	@Autowired
	private CpPrdgrpMapper cPPrdgrpMapper;
	
	@Autowired
	private CpBlkmlcMapper cpblkmlcMapper;
	
	public List<CpBlkmlc> blackList() {
		return cpblkmlcMapper.searchCpBlkmlcByParams(null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<CpBlkmlc>> blackList(final String bmCardNo, final String bmCardName, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(bmCardNo)) {
			params.put("bmCardNo", bmCardNo);
		}
		if (StringUtils.hasText(bmCardName)) {
			params.put("bmCardName", bmCardName);
		}
		List<CpBlkmlc> page = cpblkmlcMapper.searchCpBlkmlcByParams(params, pageBounds);
		return Result.create(new PageInfo(page));
	}
	
	public Result<CpBlkmlc> blkmlcAdd(CpBlkmlc blkmlc) {
		CpBlkmlc dblkmlc = cpblkmlcMapper.searchCpBlkmlcByBmCardNo(blkmlc.getBmCardNo());
		if (null != dblkmlc) {
			return Result.create("STAFF_ID_EXISTS", "黑名单已经存在");
		}
		try {
			//blkmlc.setBmCardNo(Ids.uuidAsHex());
			blkmlc.setBmInTime(DateTimes.date(LocalDate.now()));
			cpblkmlcMapper.insertCpBlkmlc(blkmlc);
			return Result.create(blkmlc);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("STAFF_ADD_FAILED", "黑名单添加失败");
		}
	}
	
	public Result<CpPrdgrp> prdgrpGetById(Integer prProdctGroup) {
		CpPrdgrp cpPrdgrp = cPPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(prProdctGroup);
		if (null == cpPrdgrp) {
			return Result.create("PRDGRP_NOT_EXISTS", "票种不存在");
		}
		return Result.create(cpPrdgrp);
	}
	
	public Result<CpBlkmlc> blkmlcGetBmCardNo(final String bmCardNo) {
//		CpBlkmlc blkmlc = cpblkmlcMapper.deleteCpBlkmlcByBmCardNo(bmCardNo);
//		if (null == blkmlc) {
//			return Result.create("OUTLET_NOT_EXISTS", "黑名单代码没有找到");
//		}
		try {
			cpblkmlcMapper.deleteCpBlkmlcByBmCardNo(bmCardNo);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("OUTLET_NOT_EXISTS", "黑名单代码没有找到");
		}
		return Result.create(null);
	}
}
