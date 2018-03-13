package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.entity.CpTktype;

public interface CpTktypeMapper {

	Long insertCpTktype(CpTktype cpTktype);

    Long deleteCpTktypeByTtTypeId(Integer ttTypeId);

    Long deleteCpTktypeByParams(@Param("map") Map<String, String> map);

    Long updateCpTktype(CpTktype cpTktype);

    Long updateCpTktypeByParams(@Param("map") Map<String, String> map);

	CpTktype searchCpTktypeByTtTypeId(Integer ttTypeId);

	List<CpTktype> searchCpTktypeByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpTktype> searchCpTktypeByParams(@Param("map") Map<String, String> map);
    CpTktype searchCpTktype(String menpiao);
	//id:max
	//新增商户获取商户最大值叠加1
	CpTktype searchMaxTktypeId();
} 
