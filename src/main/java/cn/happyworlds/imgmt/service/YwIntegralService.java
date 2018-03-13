package cn.happyworlds.imgmt.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
 
import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.YwIntegral;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.YwIntegralMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Filenames;
import cn.happyworlds.imgmt.util.Ids;
import cn.happyworlds.imgmt.util.Result;
 
 
@Service
public class YwIntegralService {
    
    @Autowired
    private YwIntegralMapper integralmapper;
    
    @Autowired
    private CpCsttblMapper csttblmapper;
    
    Calendar cal = Calendar.getInstance();
    Date date=cal.getTime();
    
    public List<YwIntegral> integralList() {
        return integralmapper.searchYwIntegralByParams(null);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Result<PageInfo<YwIntegral>> integralList(final String hwIntegralId, final String hwMemberId, final String hwPeriodDate, final String hwIntegralStatus, PageBounds pageBounds) {
        Map<String, String> params = new HashMap<>();
        if (StringUtils.hasText(hwIntegralId)) {
            params.put("hwIntegralId", hwIntegralId);
        }
        if (StringUtils.hasText(hwMemberId)) {
            params.put("hwMemberId", hwMemberId);
        }
        if (StringUtils.hasText(hwPeriodDate)) {
            params.put("hwPeriodDate", hwPeriodDate);
        }
        if (StringUtils.hasText(hwIntegralStatus)) {
            params.put("hwIntegralStatus", hwIntegralStatus);
        }
        //params.put("ORDER_BY", "hw_integral_id");
        List<YwIntegral> page = integralmapper.searchYwIntegralByParams(params, pageBounds);
        return Result.create(new PageInfo(page));
    }
    
//    public Result<YwIntegral> integralAdd(YwIntegral ywIntegral, CpCsttbl csttbl) {
//    	YwIntegral dbintegral = integralmapper.searchYwIntegralByHwIntegralId(ywIntegral.getHwIntegralId());
//    	if (null != dbintegral) {
//			return Result.create("STAFF_ID_CITY", "积分ID已经存在");
//		}
//        try {
//        	ywIntegral.setHwIntegralId(Ids.uuidAsHex());
//        	ywIntegral.setHwMemberId(csttbl.getHwMemberId());
//        	ywIntegral.setHwExchangeDate(DateTimes.date(LocalDate.now()));
//        	integralmapper.insertYwIntegral(ywIntegral);
//        	
//            return Result.create(ywIntegral);
//        } catch (Throwable t) {
//            t.printStackTrace();
//            return Result.create("STAFF_ADD_FAILED", "积分ID添加失败");
//        }
//    }
    
//    public Result<YwIntegral> integralGetById(final String hwIntegralId) {
//		if (StringUtils.isEmpty(hwIntegralId)) {
//			return Result.create("COUNTRY_DICT_ID_IS_EMPTY", "会员ID不能为空");
//		}
//		YwIntegral integral = integralmapper.searchYwIntegralByHwIntegralId(hwIntegralId);
//		if (null == integral) {
//			return Result.create("COUNTRY_DICT_NOT_FOUND", "会员代码没有找到");
//		}
//		return Result.create(integral);
//	}
    
   
    public Result<YwIntegral> integralGetById(String hwIntegralId) {
    	YwIntegral dbintegral = integralmapper.searchYwIntegralByHwIntegralId(hwIntegralId);
		if (null == dbintegral) {
			return Result.create("APRDGRP_NOT_EXISTS", "积分ID不存在");
			
		}
		return Result.create(dbintegral);
	}
    
    public Result<YwIntegral> integralUpdate(YwIntegral integral) {
		try {
			integralmapper.updateYwIntegral(integral);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ASSISTANT_UPDATE_FAILED", "积分更新失败");
		}
		return Result.create(integral);
	}

//    public Result<CpCsttbl> csttblAdd(String hwMemberId) {
//    	CpCsttbl dbcsttbl = csttblmapper.searchCpCsttblByIdNo(hwMemberId);
//		if (null == dbcsttbl) {
//			return Result.create("ASSISTANT_NOT_EXISTS", "会员不存在");
//			
//		}
//		return Result.create(dbcsttbl);
//	}
    
    public Result<YwIntegral> integralDelete(String hwIntegralId) {
		try {
			integralmapper.deleteYwIntegralByHwIntegralId(hwIntegralId);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ASSISTANT_DELETE_FAILED", "积分ID删除失败");
		}
		return Result.create(null);
	}
	
}