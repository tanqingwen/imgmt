package cn.happyworlds.imgmt.mapper;
 
import java.util.List;
import java.util.Map;
 
import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
 
public interface CpCsttblMapper {

	Long insertCpCsttbl(CpCsttbl cpCsttbl);

    Long deleteCpCsttblByCbMemberCode(String cbMemberCode);

    Long deleteCpCsttblByParams(@Param("map") Map<String, String> map);

    Long updateCpCsttbl(CpCsttbl cpCsttbl);
    
    //互联网购票更新(手机号变身份证)
    Long updateCpCsttblPri(CpCsttbl cpCsttbl);

    Long updateCpCsttblByParams(@Param("map") Map<String, String> map);

	CpCsttbl searchCpCsttblByCbMobileNo(String cbMobileNo);
	
	CpCsttbl searchCpCsttblByCbCustomerIdno(String cbCustomerIdno);

	List<CpCsttbl> searchCpCsttblByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCsttbl> searchCpCsttblByParams(@Param("map") Map<String, String> map);
	
	CpCsttbl searchCpCsttblOpenId(String cbUserCode1);
	
	List<Map<String, String>> searchCpcsttblByDiscount(@Param("disId")String disId);
} 
