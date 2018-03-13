package cn.happyworlds.imgmt.service;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
 
import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Digests;
import cn.happyworlds.imgmt.util.Result;
 
 
@Service
public class AssociatorService {
    
    @Autowired
    private CpCsttblMapper csttblmapper;
    
    public List<CpCsttbl> csttblList() {
        return csttblmapper.searchCpCsttblByParams(null);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Result<PageInfo<CpCsttbl>> csttblList(final String hwMemberId, final String cbCustomerIdno, final String cbCardholderName, final String cbMobileNo, PageBounds pageBounds) {
        Map<String, String> params = new HashMap<>();
        if (StringUtils.hasText(hwMemberId)) {
            params.put("hwMemberId", hwMemberId);
        }
        if (StringUtils.hasText(cbCustomerIdno)) {
            params.put("cbCustomerIdno", cbCustomerIdno);
        }
        if (StringUtils.hasText(cbCardholderName)) {
            params.put("cbCardholderName", cbCardholderName);
        }
        if (StringUtils.hasText(cbMobileNo)) {
            params.put("cbMobileNo", cbMobileNo);
        }
        params.put("ORDER_BY", "HW_MEMBER_ID");
        List<CpCsttbl> page = csttblmapper.searchCpCsttblByParams(params, pageBounds);
        return Result.create(new PageInfo(page));
    }
    
    public Result<CpCsttbl> csttblcAdd(CpCsttbl csttbl) {
    	//csttbl.setCbHomeAddr1(Digests.md5DigestAsHex(csttbl.getHwMemberId() + csttbl.getCbHomeAddr1()));
    	CpCsttbl dbcsttbl = csttblmapper.searchCpCsttblByCbCustomerIdno(csttbl.getCbCustomerIdno());
    	if (null != dbcsttbl) {
			return Result.create("STAFF_DICT_ID_EXISTS", "身份证号已经存在");
		}
        try {
        	//csttbl.setHwMemberId(DateTimes.timestamp(LocalDateTime.now()));
            //csttbl.setHwRegistTime(DateTimes.date(LocalDate.now()));
            //csttbl.setPwdFailCnt(0);
            csttblmapper.insertCpCsttbl(csttbl);
            return Result.create(csttbl);
        } catch (Throwable t) {
            t.printStackTrace();
            return Result.create("STAFF_ADD_FAILED", "会员注册失败");
        }
    }
    
//    public Result<CpCsttbl> csttblGetById(String hwMemberId) {
//    	CpCsttbl dbcsttbl = csttblmapper.searchCpCsttblByIdNo(hwMemberId);
//		if (null == dbcsttbl) {
//			return Result.create("APRDGRP_NOT_EXISTS", "会员不存在");
//			
//		}
//		return Result.create(dbcsttbl);
//	}
    
    public Result<CpCsttbl> csttblUpdate(CpCsttbl csttbl) {
		try {
			csttblmapper.updateCpCsttbl(csttbl);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ASSISTANT_UPDATE_FAILED", "会员更新失败");
		}
		return Result.create(csttbl);
	}

//    public Result<CpCsttbl> csttblAdd(String hwMemberId) {
//    	CpCsttbl dbcsttbl = csttblmapper.searchCpCsttblByIdNo(hwMemberId);
//		if (null == dbcsttbl) {
//			return Result.create("ASSISTANT_NOT_EXISTS", "会员不存在");
//			
//		}
//		return Result.create(dbcsttbl);
//	}
    
//    public Result<CpCsttbl> csttblDelete(String hwMemberId) {
//		try {
//			csttblmapper.deleteCpCsttblByMemberId(hwMemberId);
//		} catch (Throwable t) {
//			t.printStackTrace();
//			return Result.create("ASSISTANT_DELETE_FAILED", "会员删除失败");
//		}
//		return Result.create(null);
//	}

}