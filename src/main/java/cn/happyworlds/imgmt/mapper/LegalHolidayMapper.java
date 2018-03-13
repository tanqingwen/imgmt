package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.LegalHoliday;

public interface LegalHolidayMapper {

	Long insertLegalHoliday(LegalHoliday legalHoliday);

    Long deleteLegalHolidayByHoliday(String holiday);

    Long deleteLegalHolidayByParams(@Param("map") Map<String, String> map);

    Long updateLegalHoliday(LegalHoliday legalHoliday);

    Long updateLegalHolidayByParams(@Param("map") Map<String, String> map);

	LegalHoliday searchLegalHolidayByHoliday(String holiday);

	List<LegalHoliday> searchLegalHolidayByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<LegalHoliday> searchLegalHolidayByParams(@Param("map") Map<String, String> map);

} 
