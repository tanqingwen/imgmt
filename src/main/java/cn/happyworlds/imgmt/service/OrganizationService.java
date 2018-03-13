package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.TSysOrganization;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.OrganizationServiceMapper;
import cn.happyworlds.imgmt.mapper.TSysOrganizationMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;

@Service
public class OrganizationService {
	
	@Autowired
	private TSysOrganizationMapper organizationMapper;
	
	@Autowired
	private OrganizationServiceMapper organizationServiceMapper;
	
	public List<TSysOrganization> organizationList() {
		return organizationMapper.searchTSysOrganizationByParams(null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<TSysOrganization>> organizationList(final String id, final String name, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(id)) {
			params.put("id", id);
		}
		if (StringUtils.hasText(name)) {
			params.put("name", name);
		}
		List<TSysOrganization> page =  organizationMapper.searchTSysOrganizationByParams(params, pageBounds);
		return Result.create(new PageInfo(page));		
	} 

	public Result<TSysOrganization> organizationAdd(TSysOrganization organization) {
		if(organization.getId()==null || organization.getId().equals("")){
			return Result.create("ORGANIZATION_ID_EXISTS", "机构ID不允许为空");
		} 
		if(organization.getParentId()==null || organization.getParentId().equals("")){
			return Result.create("ORGANIZATION_ID_EXISTS", "机构父级ID不允许为空");
		}
		TSysOrganization dbOrganization = organizationMapper.searchTSysOrganizationById(organization.getId());
		if (null != dbOrganization) {
			return Result.create("ORGANIZATION_ID_EXISTS", "机构已经存在");
		}
		try {
			organization.setCreatedAt(DateTimes.nowTimestamp());
			organizationMapper.insertTSysOrganization(organization);;
			return Result.create(organization);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ORGANIZATION_ADD_FAILED", "机构添加失败");
		}
	}
	
	public Result<TSysOrganization> organizationGetById(String id) {
		TSysOrganization dbOrganization = organizationMapper.searchTSysOrganizationById(id);
		if (null == dbOrganization) {
			return Result.create("ORGANIZATION_NOT_EXISTS", "机构不存在");
		}
		return Result.create(dbOrganization);
	}

	public Result<TSysOrganization> organizationUpdate(TSysOrganization organization) {
		try {
			organizationMapper.updateTSysOrganization(organization);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ORGANIZATION_UPDATE_FAILED", "角色更新失败");
		}
		return Result.create(organization);
	}
	
	public Result<TSysOrganization> searchOrganizationById(String id) {
		TSysOrganization dbOrganization = organizationMapper.searchTSysOrganizationById(id);
		if (null == dbOrganization) {
			return Result.create("ORGANIZATION_NOT_EXISTS", "机构不存在");
		}
		return Result.create(dbOrganization);
	}

	public Result<TSysOrganization> organizationDelete(String id) {
		try {
			organizationMapper.deleteTSysOrganizationById(id);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("IDTYPE_DICT_UPDATE_FAILED", "机构删除失败");
		}
		return Result.create(null);
	}
	
	public Result<List<TSysOrganization>> searchOrganizationByParentId(String parentId) {
		if (StringUtils.isEmpty(parentId)) {
			return Result.create("PARENT_ID_IS_EMPTY", "父级ID不能为空");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("parentId", parentId);
		List<TSysOrganization> childrens = organizationMapper.searchTSysOrganizationByParams(params);
		if (null == childrens || childrens.isEmpty()) {
			return Result.create("CHILDRENS_ORGANIZATION_NOT_EXISTS", "子级机构不存在");
		}
		return Result.create(childrens);
	}
	
	
	
	public String addOrUpdateOrg(TSysOrganization organization,TSysStaff staff){
        if (StringUtils.isEmpty(organization.getId())) {  
             return "error";  
        }  
        TSysOrganization dbOrganization = organizationMapper.searchTSysOrganizationById(organization.getId());
        if (null != dbOrganization) {//更新信息  
        	 //organization.setId(DateTimes.nowTimestamp());
        	 dbOrganization.setParentId(organization.getParentId());
        	 dbOrganization.setUpdatedAt(DateTimes.nowTimestamp());
        	 dbOrganization.setUpdatedBy(staff.getId());
        	 dbOrganization.setName(organization.getName());
        	 dbOrganization.setLevelId(organization.getLevelId());
        	 dbOrganization.setRemark(organization.getRemark());
        	 dbOrganization.setStatus("NORMAL");
        	 organizationMapper.updateTSysOrganization(dbOrganization);  
        }else{//插入信息  
             if("".equals(organization.getParentId())){  
            	 organization.setParentId("0000");  
             }
             organization.setCreatedAt(DateTimes.nowTimestamp());
             organization.setCreatedBy(staff.getId());
             organization.setStatus("NORMAL");
             organizationMapper.insertTSysOrganization(organization);   
        }
        return  "success"; 
	}
	
	 public String deleteOrg(String id){
		organizationMapper.deleteTSysOrganizationById(id);  
        return  "success";  
	 }
	 
	 public Map<String, String> getOrgIdByparentId(String parentId){
		 return organizationServiceMapper.searchOrgIdByparentId(parentId);
	 }
	 
	 public Map<String, String> getOrgIdBylevelId(String levelId){
		 return organizationServiceMapper.searchOrgIdBylevelId(levelId);
	 }

}
