package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.FinancialStatement;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface FinancialStatementMapper {

	Long insertFinancialStatement(FinancialStatement financialStatement);

    Long deleteFinancialStatementBySubjectCode(String subjectCode);

    Long deleteFinancialStatementByParams(@Param("map") Map<String, String> map);

    Long updateFinancialStatement(FinancialStatement financialStatement);

    Long updateFinancialStatementByParams(@Param("map") Map<String, String> map);

	FinancialStatement searchFinancialStatementBySubjectCode(String subjectCode);

	List<FinancialStatement> searchFinancialStatementByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<FinancialStatement> searchFinancialStatementByParams(@Param("map") Map<String, String> map);

} 
