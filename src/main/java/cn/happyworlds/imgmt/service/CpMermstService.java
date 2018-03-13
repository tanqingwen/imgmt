package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpActpcd;
import cn.happyworlds.imgmt.entity.CpBrchid;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpMerupd;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.mapper.CpActpcdMapper;
import cn.happyworlds.imgmt.mapper.CpBrchidMapper;
import cn.happyworlds.imgmt.mapper.CpMermstMapper;
import cn.happyworlds.imgmt.mapper.CpMerupdMapper;
import cn.happyworlds.imgmt.mapper.CpTrmmstMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpMermstService {

	@Autowired
	private CpMermstMapper cpMermstMapper;
	@Autowired
	private CpBrchidMapper cpBrchidMapper;
	@Autowired
	private CpActpcdMapper cpActpcdMapper;
	@Autowired
	private CpMerupdMapper cpMerupdMapper;
	@Autowired
	private CpTrmmstMapper cpTrmmstMapper;
	
	//商户录入机构
	public List<CpBrchid> getCpBrchIdList(){
		Map<String, String> map = null;
		List<CpBrchid> cpBrchIdList = cpBrchidMapper.searchCpBrchidByParams(map);
		return cpBrchIdList;
	}
	
	//商户场馆授权后清算账户
	public List<CpActpcd> getCpActpcdList() {
		Map<String,String> map = null;
		List<CpActpcd> cpActpcdList = cpActpcdMapper.searchCpActpcdByParams(map);
		return cpActpcdList;
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
	
	//场馆授权后查询
	public Result<PageInfo<CpMermst>> venueList( String mmMerchantNo, String mmDbaName, String mmBizName,
			String mmPmtMode, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmDbaName)) {
			params.put("mmDbaName", mmDbaName);
		}
		/*if(StringUtils.hasText(mmStmtName)){
			params.put("mmStmtName", mmStmtName);
		}*/
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		if(!"0".equals(mmPmtMode)){
			if (StringUtils.hasText(mmPmtMode)) {
				params.put("mmPmtMode", mmPmtMode);
			}
		}
		params.put("mmPhyState", "0");
		params.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	//商户授权后查询列表
	public Result<PageInfo<CpMermst>> merchantList1(String mmMerchantNo,String mmDbaName,String mmBizName, String mmChainAccno,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmDbaName)) {
			params.put("mmDbaName", mmDbaName);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		//商户必输条件
		params.put("mmPhyState", "1");
		//归属场馆
		if (StringUtils.hasText(mmChainAccno)){
			params.put("mmChainAccno", mmChainAccno);
		}
		
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	//场馆维护后查询列表
	public Result<PageInfo<CpMermst>> venueMermstList(String mmMerchantNo,String mmBizName, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		//场馆必输条件
		params.put("mmPhyState", "0");
		params.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	//商户授权后查看
	public CpMermst getCpMermstById(String merchantNo){
		CpMermst cpMermst = cpMermstMapper.searchCpMermstByMmMerchantNo(merchantNo);
		if(cpMermst == null){
			cpMermst = new CpMermst();
		}
		return cpMermst;
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
	
	//场馆维护后查询等待授权列表数据
	public Result<PageInfo<CpMerupd>> venueMerupdAuthList(String mmMerchantNo, String mmBizName,
			PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		// 场馆必输条件
		params.put("mmPhyState", "0");
		params.put("mmRiskStatus", "1");
		List<CpMerupd> page = cpMerupdMapper.searchCpMerupdByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMerupd>(page));
	}
	
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
	
	/**
	 * 查询场馆
	 * 
	 * @author Hugh
	 */
	public List<CpMermst> CpMermstList() {
		
		Map<String,String> map = new HashMap<>();
		map.put("mmPhyState", "0");
		map.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(map);
		return page;
	}
	
	
	/**
	 * 归属场馆
	 * 
	 * @author 
	 */
	public List<CpMermst> cpVenueList() {

		Map<String, String> map = new HashMap<>();
		map.put("mmPhyState", "0");
		map.put("mmPmtMode", "2"); // 目前没有一级场馆、只查询二级场馆
		map.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(map);
		return page;
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
	
	//商户下所有场馆
	public Result<PageInfo<CpTrmmst>> getTrmmstList(String tmMerchantId,PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		params.put("tmMerchantId", tmMerchantId);
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params,pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	//商户维护后查询列表
	public Result<PageInfo<CpMermst>> mermstList(String mmMerchantNo,String mmBizName, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		//商户必输条件
		params.put("mmPhyState", "1");
		params.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	//商户维护后查询等待授权列表数据
	public Result<PageInfo<CpMerupd>> merupdAuthList(String mmMerchantNo, String mmBizName,
			PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		// 商户必输条件
		params.put("mmPhyState", "1");
		params.put("mmRiskStatus", "1");
		List<CpMerupd> page = cpMerupdMapper.searchCpMerupdByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMerupd>(page));
	}
}
