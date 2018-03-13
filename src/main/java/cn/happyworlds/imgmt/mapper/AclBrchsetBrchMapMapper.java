package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.AclBrchsetBrchMap;

public interface AclBrchsetBrchMapMapper {

	Long insertAclBrchsetBrchMap(AclBrchsetBrchMap aclBrchsetBrchMap);

    //Long deleteAclBrchsetBrchMapBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

    Long deleteAclBrchsetBrchMapByParams(@Param("map") Map<String, String> map);

    Long updateAclBrchsetBrchMap(AclBrchsetBrchMap aclBrchsetBrchMap);

    Long updateAclBrchsetBrchMapByParams(@Param("map") Map<String, String> map);

	//AclBrchsetBrchMap searchAclBrchsetBrchMapBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

	List<AclBrchsetBrchMap> searchAclBrchsetBrchMapByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<AclBrchsetBrchMap> searchAclBrchsetBrchMapByParams(@Param("map") Map<String, String> map);
	
	/*@Select("select * from mybatis_Student where id=#{id}")  
	public Student getStudent(int id);  */

} 
