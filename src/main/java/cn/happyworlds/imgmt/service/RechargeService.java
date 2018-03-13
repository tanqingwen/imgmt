package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.Recharge;
import cn.happyworlds.imgmt.mapper.RechargeMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class RechargeService {
	
	@Autowired
	private RechargeMapper rechargeMapper;
	
	public Result<PageInfo<Recharge>> RechargeList(final String cbEmbossname, final String ctReversalFlag,final String ctCardNumber, final String prProdctGroup,final String ctApproveTimeStart, final String ctApproveTimeEnd,final String ctUserCreate, final String ctUserCreateNull, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbEmbossname)) {
			params.put("cbEmbossname", cbEmbossname);
		}
		if (StringUtils.hasText(ctReversalFlag)) {
			params.put("ctReversalFlag", ctReversalFlag);
		}
		if (StringUtils.hasText(ctCardNumber)) {
			params.put("ctCardNumber", ctCardNumber);
		}
		if (StringUtils.hasText(prProdctGroup)) {
			params.put("prProdctGroup", prProdctGroup);
		}
		if (StringUtils.hasText(ctApproveTimeStart+"")) {
			params.put("ctApproveTimeStart", ctApproveTimeStart);
		}
		if (StringUtils.hasText(ctApproveTimeEnd+"")) {
			params.put("ctApproveTimeEnd", ctApproveTimeEnd);
		}
		if (StringUtils.hasText(ctUserCreate)) {
			params.put("ctUserCreate", ctUserCreate);
		}
		if (StringUtils.hasText(ctUserCreateNull)) {
			params.put("ctUserCreateNull", ctUserCreateNull);
		}
		List<Recharge> page =  rechargeMapper.searchRechargeByParams(params, pageBounds);
		for (int i = 0; i < page.size(); i++) {
			page.get(i).setCtCardNumber(page.get(i).getCtCardNumber().substring(page.get(i).getCtCardNumber().length() - 10, page.get(i).getCtCardNumber().length()));
		}
		return Result.create(new PageInfo<Recharge>(page));		
	} 

	/*public Result<TSysOrganization> organizationAdd(TSysOrganization organization) {
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
	 }*/

}
