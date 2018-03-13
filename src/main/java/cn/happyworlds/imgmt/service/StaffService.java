package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.context.InitProperties;
import cn.happyworlds.imgmt.entity.CpActpcd;
import cn.happyworlds.imgmt.entity.CpBrchid;
import cn.happyworlds.imgmt.entity.CpMeracc;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpMerupd;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.entity.TSysDepartment;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.CpActpcdMapper;
import cn.happyworlds.imgmt.mapper.CpBrchidMapper;
import cn.happyworlds.imgmt.mapper.CpMeraccMapper;
import cn.happyworlds.imgmt.mapper.CpMermstMapper;
import cn.happyworlds.imgmt.mapper.CpMerupdMapper;
import cn.happyworlds.imgmt.mapper.CpTrmmstMapper;
import cn.happyworlds.imgmt.mapper.TSysDepartmentMapper;
import cn.happyworlds.imgmt.mapper.TSysStaffMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Digests;
import cn.happyworlds.imgmt.util.Result;

import com.github.pagehelper.PageInfo;

@Service
public class StaffService {

	@Autowired
	private TSysStaffMapper tSysStaffMapper;
	@Autowired
	private CpMeraccMapper cpMeraccMapper;
	@Autowired
	private CpMermstMapper cpMermstMapper; 
	@Autowired
	private CpTrmmstMapper cpTrmmstMapper;
	@Autowired
	private CpBrchidMapper cpBrchidMapper;
	@Autowired
	private CpActpcdMapper cpActpcdMapper;
	@Autowired
	private InitProperties initProperties;
	@Autowired
	private CpMerupdMapper cpMerupdMapper;
	@Autowired
	private TSysDepartmentMapper tSysDepartmentMapper;

	public Result<TSysStaff> staffLogin(final String staffId, final String passwd) {
		if (StringUtils.isEmpty(staffId)) {
			return Result.create("STAFFID_CANNOT_BE_EMPTY", "员工ID不能为空");
		}
		if (StringUtils.isEmpty(passwd)) {
			return Result.create("PASSWORD_CANNOT_BE_EMPTY", "登录密码不能为空");
		}
		TSysStaff staff = tSysStaffMapper.searchTSysStaffById(staffId);
		if (staff == null) {
			return Result.create("STAFF_NOT_EXISTS", "员工账号找不到");
		}
		if("LOCK".equals(staff.getStatus())){
			return Result.create("STAFF_STATUS_ERROR", "员工账号已锁定，请联系管理员");
		}
		if("CANCEL".equals(staff.getStatus())){
			return Result.create("STAFF_STATUS_ERROR", "员工账号已注销");
		}
		String pwd = Digests.md5DigestAsHex(staffId + passwd.toLowerCase());
		if (!pwd.equals(staff.getPassword())) {
			int failCount = staff.getPwdFailCnt() + 1;
			if(failCount > 3) {
				staff.setStatus("LOCK");
				tSysStaffMapper.updateTSysStaff(staff);
				return Result.create("STAFF_STATUS_ERROR", "输错密码超过3次，账号被锁，请联系管理员");
			}
			staff.setPwdFailCnt(failCount);
			tSysStaffMapper.updateTSysStaff(staff);
			return Result.create("STAFF_PASSWORD_ERROR", "员工号或密码错误");
		}
		staff.setPwdFailCnt(0);
		tSysStaffMapper.updateTSysStaff(staff);
		return Result.create(staff);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<TSysStaff>> staffList(final String staffId, final String staffName, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(staffId)) {
			params.put("id", staffId);
		}
		if (StringUtils.hasText(staffName)) {
			params.put("name", staffName);
		}
		List<TSysStaff> page = tSysStaffMapper.searchTSysStaffByParams(params, pageBounds);
		return Result.create(new PageInfo(page));
	}
	
	public Result<List<TSysStaff>> staffListAll() {
		List<TSysStaff> page = tSysStaffMapper.searchTSysStaffByParams(null);
		return Result.create(page);
	}
	
	public Result<TSysStaff> staffAdd(TSysStaff staff) {
		TSysStaff dbStaff = tSysStaffMapper.searchTSysStaffById(staff.getId());
		
//		查询邮箱
		TSysStaff emailStaff = tSysStaffMapper.searchTSysStaffByEmail(staff.getEmail());
		
//		查询手机号码
		TSysStaff phoneStaff = tSysStaffMapper.searchTSysStaffByPhone(staff.getPhoneNumber());
		staff.setPassword(Digests.md5DigestAsHex(staff.getId() + staff.getPassword()));
		if (null != dbStaff) {
			return Result.create("STAFF_ID_EXISTS", "员工id已经存在");
		}else if(null != emailStaff){
			return Result.create("STAFF_EMAIL_EXISTS", "员工邮箱号已存在");
		}else if(null != phoneStaff){
			return Result.create("STAFF_PHONE_EXISTS", "员工手机号已存在");
		}
		try {
			oneTotpkeyOneStaff(staff);
			staff.setCreatedAt(DateTimes.nowTimestamp());
			staff.setPwdFailCnt(0);
			tSysStaffMapper.insertTSysStaff(staff);
		
			return Result.create(staff);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("STAFF_ADD_FAILED", "员工添加失败");
		}
	}
	private void oneTotpkeyOneStaff(TSysStaff staff){
		Map<String,String> map = new HashMap<String, String>();
		map.put("totp_key", staff.getTotpKey());
		List<TSysStaff> staffs=tSysStaffMapper.searchTSysStaffByParams(map);
		if(staffs!=null && staffs.size()>0){
			for(TSysStaff sta:staffs){
				sta.setTotpKey("");
				tSysStaffMapper.updateTSysStaff(sta);
			}
		}
	}

	public Result<TSysStaff> staffGetById(String id) {
		TSysStaff dbStaff = tSysStaffMapper.searchTSysStaffById(id);
		if (null == dbStaff) {
			return Result.create("STAFF_NOT_EXISTS", "员工不存在");
		}
		TSysDepartment tSysDepartment = tSysDepartmentMapper.searchTSysDepartmentByDeptId(dbStaff.getOrganizations());
		if(tSysDepartment!=null){
			dbStaff.setOrgName(tSysDepartment.getDeptName());
		}
		return Result.create(dbStaff);
	}

	public Result<TSysStaff> staffUpdate(TSysStaff staff) {
		try {
			oneTotpkeyOneStaff(staff);
			tSysStaffMapper.updateTSysStaff(staff);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("STAFF_UPDATE_FAILED", "员工更新失败");
		}
		return Result.create(staff);
	}

	public Result<TSysStaff> staffChangePassword(String userId, String newPassword) {
		// 参数检查
		if (StringUtils.isEmpty(userId)) {
			Result.create("USERID_CANNOT_BE_EMPTY", "用户ID不能为空");
		}
		if (StringUtils.isEmpty(newPassword)) {
			Result.create("NEWPASSWORD_CANNOT_BE_EMPTY", "新密码不能为空");
		}
		TSysStaff staff = tSysStaffMapper.searchTSysStaffById(userId);
		if (staff == null) {
			Result.create("STAFF_NOT_FOUND", "用户没有找到");
		}
		// 更新数据库
		staff.setPassword(Digests.md5DigestAsHex(userId + newPassword));
		staff.setUpdatedAt(DateTimes.nowTimestamp());
		staff.setUpdatedBy(userId);
		tSysStaffMapper.updateTSysStaff(staff);
		// 组织返回
		return Result.create(staff);
	}
	
	
	//场馆录入列表
	public Result<PageInfo<CpMeracc>> getMerchantList1(PageBounds pageBounds) {
		Map<String, String> map = new HashMap<>();
		map.put("mmPhyState", "0");
		map.put("mmRiskStatus", "1");
		List<CpMeracc> list = cpMeraccMapper.searchCpMeraccByParams(map, pageBounds);
		return Result.create(new PageInfo<>(list));
	}
	
	
	//场馆录入添加提交
	public Result<CpMeracc> insertVenue(CpMeracc cpMeracc) {

		String merchantMax = this.getVenueMax(cpMeracc.getMmPmtMode());
		if("1".equals(merchantMax)){
			return Result.create("MERCHANT_EXISTS", "一级场馆已经存在");
		}
		
		
		CpMeracc meracc = cpMeraccMapper.searchCpMeraccByMmMerchantNo(merchantMax);
		CpMermst mermst = cpMermstMapper.searchCpMermstByMmMerchantNo(merchantMax);

		
		if (meracc != null) {
			return Result.create("MERCHANT_EXISTS", "该场馆已经存在");
		} else {
			if (mermst != null) {
				return Result.create("MERCHANT_EXISTS", "该场馆已经存在");
			} else {
				try {
					cpMeracc.setMmMerchantNo(merchantMax);
					cpMeraccMapper.insertCpMeracc(cpMeracc);
				} catch (Exception e) {
					e.printStackTrace();
					return Result.create("ADD_FALSE", "场馆添加失败");
				}
				return Result.create("OK", "场馆添加成功");
			}
		}
	}
		
	//场馆最大值max
	public String getVenueMax(String mmPmtMode){
		
		String venueMax="";

		Map<String,String> map = new HashMap<>();
		map.put("mmPhyState", "0");
		map.put("mmPmtMode", "1");
		List<CpMeracc> meraccList = cpMeraccMapper.searchCpMeraccByParams(map);
		List<CpMermst> mermstList = cpMermstMapper.searchCpMermstByParams(map);
		
		//特殊处理：把[欢乐大世界]当做最大的场馆看
		//场馆等级：一级场馆时
		if("1".equals(mmPmtMode)){
			if(meraccList.size()>0 || mermstList.size()>0) {
				// venueMax
				return "1";
			}
		}
		
		CpMeracc meraccDto = cpMeraccMapper.searchMaxVeneId();
		CpMermst mermstDto = cpMermstMapper.searchMaxVeneId();
		
		if(meraccList.size()>0 && mermstList.size()==0){
			venueMax = meraccDto.getMmMerchantNo();
		}
		
		if(0==meraccList.size() && 0==mermstList.size()){
				venueMax=initProperties.getVenueNo();
		}
		
		if(meraccList.size()==0 && mermstList.size()>0){
			venueMax = mermstDto.getMmMerchantNo();
		}
		if(meraccList.size()>0 && mermstList.size()>0){
			String meraccMax = meraccDto.getMmMerchantNo();
			String mermstMax = mermstDto.getMmMerchantNo();
			int result = meraccMax.compareTo(mermstMax);
			if(result>0){
				venueMax=meraccDto.getMmMerchantNo();
			}else{
				venueMax=mermstDto.getMmMerchantNo();
			}
		}
		return venueMax;
	} 
	
	//商户录入列表
	public Result<PageInfo<CpMeracc>> getMerchantList(PageBounds pageBounds) {
		Map<String, String> map = new HashMap<>();
		map.put("mmPhyState", "1");
		map.put("mmRiskStatus", "1");
		List<CpMeracc> list = cpMeraccMapper.searchCpMeraccByParams(map, pageBounds);
		return Result.create(new PageInfo<>(list));
	}
	
	//商户录入添加提交
	public Result<CpMeracc> insertMerchant(CpMeracc cpMeracc) {

		String merchantMax = this.getMerchantMax();
		CpMeracc meracc = cpMeraccMapper.searchCpMeraccByMmMerchantNo(merchantMax);
		CpMermst mermst = cpMermstMapper.searchCpMermstByMmMerchantNo(merchantMax);

		if (meracc != null) {
			return Result.create("MERCHANT_EXISTS", "该商户已经存在");
		} else {
			if (mermst != null) {
				return Result.create("MERCHANT_EXISTS", "该商户已经存在");
			} else {
				try {
					cpMeracc.setMmMerchantNo(merchantMax);
					cpMeracc.setMmPhyState("1");
					cpMeracc.setMmRiskStatus("1");//录入
					cpMeraccMapper.insertCpMeracc(cpMeracc);
				} catch (Exception e) {
					e.printStackTrace();
					return Result.create("ADD_FALSE", "商户添加失败");
				}
				return Result.create("OK", "商户添加成功");
			}
		}
	}
	
	//商户最大值max
	public String getMerchantMax(){
		
		String merchantMax="";
		Map<String,String> map = new HashMap<>();
		map.put("mmPhyState", "1");
		
		List<CpMeracc> meraccList = cpMeraccMapper.searchCpMeraccByParams(map);
		List<CpMermst> mermstList = cpMermstMapper.searchCpMermstByParams(map);
		
		CpMeracc meraccDto = cpMeraccMapper.searchMaxMeraccId();
		CpMermst mermstDto = cpMermstMapper.searchMaxMermstId();
		
		if(meraccList.size()>0 && mermstList.size()==0){
			merchantMax = meraccDto.getMmMerchantNo();
		}
		if(0==meraccList.size() && 0==mermstList.size()){
			merchantMax=initProperties.getMerchantNo();
		}
		if(meraccList.size()==0 && mermstList.size()>0){
			merchantMax = mermstDto.getMmMerchantNo();
		}
		if(meraccList.size()>0 && mermstList.size()>0){
			String meraccMax = meraccDto.getMmMerchantNo();
			String mermstMax = mermstDto.getMmMerchantNo();
			int result = meraccMax.compareTo(mermstMax);
			if(result>0){
				merchantMax=meraccDto.getMmMerchantNo();
			}else{
				merchantMax=mermstDto.getMmMerchantNo();
			}
		}
		return merchantMax;
	} 
	
	
	//场馆查询
	public CpMeracc getMerchantById(String merchantNo){
		CpMeracc cpMeracc = cpMeraccMapper.searchCpMeraccByMmMerchantNo(merchantNo);
		if(cpMeracc == null){
			cpMeracc = new CpMeracc();
		}
		return cpMeracc;
	}
	
	
	/*********************场馆维护查看start****************************************************/
	//场馆维护查询
	public CpMerupd getMerupdById(String merchantNo){
		CpMerupd merupdDto = cpMerupdMapper.searchCpMerupdByMmMerchantNo(merchantNo);
		if(merupdDto == null){
			merupdDto = new CpMerupd();
		}
		return merupdDto;
	}
	
	// 场馆维护授权
	public Result<CpMerupd> doAuthorizeVenue(String merchantNo, CpMerupd merupd) {

		try {

			// 更新merupd表数据状态
			
			CpMerupd oldMerupd = getMerupdDtoById(merchantNo);
			
			// 更新mermst表数据为修改后的数据1:先删除 2: 再克隆
			cpMermstMapper.deleteCpMermstByMmMerchantNo(merchantNo);
			CpMermst newMermst = new CpMermst();
			BeanUtils.copyProperties(newMermst, oldMerupd);
			cpMermstMapper.insertCpMermst(newMermst);
			oldMerupd.setMmRiskStatus("2");
			cpMerupdMapper.updateCpMerupd(oldMerupd);
		} catch (Exception e) {
			return Result.create("DOAUTHORIZE_FALSE", "场馆复核失败");
		}
		return Result.create("OK", "场馆复核成功");
	}	
	
	
	//场馆维护查询
	public CpMerupd getMerupdDtoById(String merchantNo){
		CpMerupd cpMerupd = cpMerupdMapper.searchCpMerupdByMmMerchantNo(merchantNo);
		if(cpMerupd == null){
			cpMerupd = new CpMerupd();
		}
		return cpMerupd;
	}
	/*********************场馆维护查看end****************************************************/
	
	
	//场馆更新
	public Result<CpMeracc> updateMerchant(CpMeracc cpMeracc){
		try {
			String mmMerchantNo = cpMeracc.getMmMerchantNo();
			CpMeracc cpMeracc2 = getMerchantById(mmMerchantNo);
			if(cpMeracc2.equals(cpMeracc)){
				return Result.create("NO_CHANGES", "您没有做任何修改！");
			}
			cpMeraccMapper.updateCpMeracc(cpMeracc);
		} catch (Exception e) {
			return Result.create("UPDATE_FALSE", "场馆更新失败");
		}
		return Result.create("OK", "场馆更新成功");
	}
	
	
	//场馆删除
	public Result<CpMeracc> deleteMerchant(CpMeracc cpMeracc){
		try {
			String mmMerchantNo = cpMeracc.getMmMerchantNo();
			CpMeracc cpMeracc2 = getMerchantById(mmMerchantNo);
			if(cpMeracc2.equals(cpMeracc)){
				return Result.create("NO_CHANGES", "您没有做任何修改！");
			}
			cpMeraccMapper.updateCpMeracc(cpMeracc);
		} catch (Exception e) {
			return Result.create("UPDATE_FALSE", "场馆删除失败");
		}
		return Result.create("OK", "场馆删除成功");
	}
	
	//场馆授权
	public Result<CpMeracc> doAuthorize1(String merchantNo, CpMeracc meracc) {
		try {
			//delMerchantById(merchantNo);
			insertMerchantForAuthorize(meracc);
			CpMeracc newMeracc = getMerchantById(merchantNo);
			newMeracc.setMmRiskStatus("2");
			cpMeraccMapper.updateCpMeracc(newMeracc);
		} catch (Exception e) {
			return Result.create("DOAUTHORIZE_FALSE", "场馆复合失败");
		}
		return Result.create("OK", "场馆复合成功");
	}	
	
	
	/**************************商户录入start**********************************************/
	
	// 商户录入删除
	public Result<CpMeracc> deleteMerchant1(CpMeracc cpMeracc) {
		try {
			String mmMerchantNo = cpMeracc.getMmMerchantNo();
			CpMeracc cpMeracc2 = getMerchantById(mmMerchantNo);
			if (cpMeracc2.equals(cpMeracc)) {
				return Result.create("NO_CHANGES", "您没有做任何修改！");
			}
			cpMeraccMapper.updateCpMeracc(cpMeracc);
		} catch (Exception e) {
			return Result.create("UPDATE_FALSE", "商户删除失败");
		}
		return Result.create("OK", "商户删除成功");
	}
		
	// 商户录入授权
	public Result<CpMeracc> doAuthorize(String merchantNo, CpMeracc meracc) {

		try {
			insertMerchantForAuthorize(meracc);
			CpMeracc newMeracc = getMerchantById(merchantNo);
			newMeracc.setMmRiskStatus("2");
			cpMeraccMapper.updateCpMeracc(newMeracc);
		} catch (Exception e) {
			return Result.create("DOAUTHORIZE_FALSE", "商户复合失败");
		}
		return Result.create("OK", "商户复合成功");
	}
		
	/*************************商户录入end**********************************************/
	
	
	/*************************场馆查询 start**********************************************/
	//场馆下商户列表
	public Result<PageInfo<CpMermst>> getMermstList(String venueNo,PageBounds pageBounds){
	
		Map<String,String> map = new HashMap<>();
		map.put("mmChainAccno",venueNo);
		map.put("mmRiskStatus", "1");
		map.put("mmPhyState", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(map,pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	//终端返回商户
	public Result<PageInfo<CpMermst>> getMermstList1(String venueNo,PageBounds pageBounds){
	
		Map<String,String> map = new HashMap<>();
		map.put("mmMerchantNo",venueNo);
		map.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(map,pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	// 场馆下场馆对象
	public CpMermst getMermstById(String merchantNo) {
		CpMermst cpMermst = cpMermstMapper.searchCpMermstByMmMerchantNo(merchantNo);
		if (cpMermst == null) {
			cpMermst = new CpMeracc();
		}
		return cpMermst;
	}
		
	/*************************场馆查询 end**********************************************/	

	
	/*************************商户维护 start**********************************************/
	
	// 商户维护授权
	public Result<CpMerupd> doAuthorizeMerupd(String merchantNo, CpMerupd merupd) {

		try {

			// 更新merupd表数据状态
			
			CpMerupd oldMerupd = getMerupdDtoById(merchantNo);
			
			// 更新mermst表数据为修改后的数据1:先删除 2: 再克隆
			cpMermstMapper.deleteCpMermstByMmMerchantNo(merchantNo);
			CpMermst newMermst = new CpMermst();
			BeanUtils.copyProperties(newMermst, oldMerupd);
			cpMermstMapper.insertCpMermst(newMermst);
			oldMerupd.setMmRiskStatus("2");
			cpMerupdMapper.updateCpMerupd(oldMerupd);
		} catch (Exception e) {
			return Result.create("DOAUTHORIZE_FALSE", "商户复核失败");
		}
		return Result.create("OK", "商户复核成功");
	}
	
	/*************************商户维护 end**********************************************/
	
	//商户下终端列表
	public Result<PageInfo<CpTrmmst>> getMTrmmstList(String tmMerchantId,PageBounds pageBounds) {

		Map<String, String> params = new HashMap<>();
		params.put("tmMerchantId", tmMerchantId);
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params,pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}

		
	//场馆下闸机列表
	public Result<PageInfo<CpTrmmst>> getTrmmstList1(String tmMerchantId,PageBounds pageBounds) {

		Map<String, String> params = new HashMap<>();
		params.put("tmMerchantId", tmMerchantId);
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params,pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	//商户录入机构
	public List<CpBrchid> getCpBrchIdList(){
		Map<String, String> map = null;
		List<CpBrchid> cpBrchIdList = cpBrchidMapper.searchCpBrchidByParams(map);
		return cpBrchIdList;
	}
	
	//商户授权后查看
	public CpMermst getCpMermstById(String merchantNo){
		CpMermst cpMermst = cpMermstMapper.searchCpMermstByMmMerchantNo(merchantNo);
		if(cpMermst == null){
			cpMermst = new CpMermst();
		}
		return cpMermst;
	}
	
	//商户场馆授权后清算账户
	public List<CpActpcd> getCpActpcdList() {
		Map<String,String> map = null;
		List<CpActpcd> cpActpcdList = cpActpcdMapper.searchCpActpcdByParams(map);
		return cpActpcdList;
	}
	

	
	//商户下所有场馆
	public Result<PageInfo<CpTrmmst>> getTrmmstList(String tmMerchantId,PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		params.put("tmMerchantId", tmMerchantId);
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params,pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	public Result<CpMermst> updateMermst(CpMermst cpMermst){
		try {
			cpMermstMapper.updateCpMermst(cpMermst);
		} catch (Exception e) {
			return Result.create("UPDATE_FALSE", "场馆更新失败");
		}
		return Result.create("OK", "场馆更新成功");
	}
	
	//场馆维护更新或者插入merupd表
	public Result<CpMerupd> updateMerupd(CpMerupd merupd){
		try{
			cpMerupdMapper.updateCpMerupd(merupd);
		}catch(Exception e){
			return Result.create("UPDATE_FALSE", "场馆更新失败");
		}
		return Result.create("OK","场馆维护更新成功");
	}

	
	//场馆数据查询
	public CpMerupd findMerupd(String mmMerchantno) {
		CpMerupd merupd = cpMerupdMapper.searchCpMerupdByMmMerchantNo(mmMerchantno);
		return merupd;
	}
	
	//场馆数据插入
	public Long insertMerupd(CpMerupd merupd) {
		return cpMerupdMapper.insertCpMerupd(merupd);
	}
	
	//商户场馆授权后列表Hugh
	public Result<PageInfo<CpMermst>> getMerchantListPass(PageBounds pageBounds) {
		Map<String, String> map = new HashMap<>();
		List<CpMermst> list = cpMermstMapper.searchCpMermstByParams(map, pageBounds);
		return Result.create(new PageInfo<>(list));
	}
	
	
	public List<CpMeracc> getCpMeraccList(){
		Map<String, String> map = new HashMap<>();
		map.put("mmRiskStatus", "1");
		return cpMeraccMapper.searchCpMeraccByParams(map);
	}
	
	
	public Long insertMerchantForAuthorize(CpMermst cpMermst)throws Exception {
		Long long1 = cpMermstMapper.insertCpMermst(cpMermst);
		return long1;
	}
	
	
	// 场馆列表
	public List<CpMermst> getCpMermstList(String mmPmtMode) {
		Map<String, String> map = new HashMap<>();
		map.put("mmPhyState", "0");
		if("1".equals(mmPmtMode) || "2".equals(mmPmtMode)){
			map.put("mmPmtMode", "1");
		}
		//3级场馆
		if("3".equals(mmPmtMode)){
			map.put("mmPmtMode", "2");
		}
		List<CpMermst> mermstList = cpMermstMapper.searchCpMermstByParams(map);
		for(int i=0;i<mermstList.size();i++){
			CpMermst newMermst = (CpMermst)mermstList.get(i);
			if("1".equals(newMermst.getMmPmtMode())){
				newMermst.setMmLevelName("一级");
			}
			if("2".equals(newMermst.getMmPmtMode())){
				newMermst.setMmLevelName("二级");
			}
			if("3".equals(newMermst.getMmPmtMode())){
				newMermst.setMmLevelName("三级");
			}
		}
		return mermstList;
	}
	
	
	// 商户对应场馆列表
	public List<CpMermst> getCpMermstList1(String mmPmtMode) {
		Map<String, String> map = new HashMap<>();
		map.put("mmPhyState", "0");
		if(!"0".equals(mmPmtMode)){
			map.put("mmPmtMode", mmPmtMode);
		}
		List<CpMermst> mermstList = cpMermstMapper.searchCpMermstByParams(map);
		return mermstList;
	}
	
}
