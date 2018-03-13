package cn.happyworlds.imgmt.service;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.context.InitProperties;
import cn.happyworlds.imgmt.entity.CpBrchid;
import cn.happyworlds.imgmt.entity.CpMeracc;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.mapper.CpBrchidMapper;
import cn.happyworlds.imgmt.mapper.CpMeraccMapper;
import cn.happyworlds.imgmt.mapper.CpMermstMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpMeraccService {

	@Autowired
	private CpMeraccMapper cpMeraccMapper;	
	@Autowired
	private CpMermstMapper cpMermstMapper;	
	@Autowired
	private YwOrderitemMapper ywOrderitemMapper;	
	@Autowired
	private CpBrchidMapper cpBrchidMapper;	
	@Autowired
	private InitProperties initProperties;
	
	/**
	 * 查询全部未授权数据
	 * @return
	 */
	public List<CpMeracc> getCpMeraccList(){
		Map<String, String> map = new HashMap<>();
		map.put("mmRiskStatus", "1");
		return cpMeraccMapper.searchCpMeraccByParams(map);
	}
	
	/**
	 * 商户录入机构查询
	 * @return
	 */
	public List<CpBrchid> getCpBrchIdList(){
		Map<String, String> map = null;
		List<CpBrchid> cpBrchIdList = cpBrchidMapper.searchCpBrchidByParams(map);
		return cpBrchIdList;
	}
	
	/**
	 * 场馆录入列表
	 * @param p
	 * @param session
	 * @return
	 */
	public PageInfo<CpMeracc> getPageForCurrent1(Integer p,HttpSession session){
		PageBounds pageBounds = null;
		Integer session_p = (Integer) session.getAttribute("session_p");
		if(p == null){
			pageBounds = new PageBounds(session_p, 10);
		}else{
			pageBounds = new PageBounds(p, 10);
		}
		Map<String, String> map = new HashMap<>();
		//mmPhyState为0区分为场馆，为1区分为商户
		map.put("mmPhyState", "0");
		//mmRiskStatus为1区分为未授权，为2区分为授权
		map.put("mmRiskStatus", "1");
		List<CpMeracc> list = cpMeraccMapper.searchCpMeraccByParams(map, pageBounds);
		PageInfo<CpMeracc> pageInfo = new PageInfo<>(list);
		Integer page_size = pageInfo.getSize();
		if(!(page_size>0)){
			if(null!=session_p){ //空记录情况
				pageBounds = new PageBounds(session_p-1, 10);
				list = cpMeraccMapper.searchCpMeraccByParams(map, pageBounds);
				pageInfo = new PageInfo<>(list);
			}
		}
		session.setAttribute("session_p", pageBounds.getOffset());
		return pageInfo;
	}
	/**
	 * 商户录入列表
	 * @param p
	 * @param session
	 * @return
	 */
	public PageInfo<CpMeracc> getPageForCurrent(Integer p,HttpSession session){
		PageBounds pageBounds = null;
		Integer session_p = (Integer) session.getAttribute("session_p");
		if(p == null){
			pageBounds = new PageBounds(session_p, 10);
		}else{
			pageBounds = new PageBounds(p, 10);
		}
		Map<String, String> map = new HashMap<>();
		//mmPhyState为0区分为场馆，为1区分为商户
		map.put("mmPhyState", "1");
		//mmRiskStatus为1区分为未授权，为2区分为授权
		map.put("mmRiskStatus", "1");
		List<CpMeracc> list = cpMeraccMapper.searchCpMeraccByParams(map, pageBounds);		
		PageInfo<CpMeracc> pageInfo = new PageInfo<>(list);
		Integer page_size = pageInfo.getSize();
		if(!(page_size>0)){
			if(null!=session_p){ //空记录情况
				pageBounds = new PageBounds(session_p-1, 10);
				list = cpMeraccMapper.searchCpMeraccByParams(map, pageBounds);
				pageInfo = new PageInfo<>(list);
			}
		}
		session.setAttribute("session_p", pageBounds.getOffset());
		return pageInfo;
	}
	
	
	/**
	 * 场馆录入添加提交
	 * @param cpMeracc
	 * @return
	 */
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
	
	/**
	 * 商户录入添加提交
	 * @param cpMeracc
	 * @return
	 */
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
	
	/**
	 * 场馆最大值max
	 * @param mmPmtMode
	 * @return
	 */
	public String getVenueMax(String mmPmtMode){		
		String venueMax="";
		Map<String,String> map = new HashMap<>();
		map.put("mmPhyState", "0");
//		map.put("mmPmtMode", "1");
//		List<CpMeracc> meraccList = cpMeraccMapper.searchCpMeraccByParams(map);
//		List<CpMermst> mermstList = cpMermstMapper.searchCpMermstByParams(map);		
		//特殊处理：把[欢乐大世界]当做最大的场馆看
		//场馆等级：一级场馆时
//		if("1".equals(mmPmtMode)){
//			if(meraccList.size()>0 || mermstList.size()>0) {
//				// venueMax
//				return "1";
//			}
//		}		
		CpMeracc meraccDto = cpMeraccMapper.searchMaxVeneId();
		CpMermst mermstDto = cpMermstMapper.searchMaxVeneId();		
//		if(meraccList.size()>0 && mermstList.size()==0){
//			venueMax = meraccDto.getMmMerchantNo();
//		}		
//		if(0==meraccList.size() && 0==mermstList.size()){
//				venueMax=initProperties.getVenueNo();
//		}		
//		if(meraccList.size()==0 && mermstList.size()>0){
//			venueMax = mermstDto.getMmMerchantNo();
//		}
//		if(meraccList.size()>0 && mermstList.size()>0){
//			String meraccMax = meraccDto.getMmMerchantNo();
//			String mermstMax = mermstDto.getMmMerchantNo();
//			int result = meraccMax.compareTo(mermstMax);
//			if(result>0){
//				venueMax=meraccDto.getMmMerchantNo();
//			}else{
//				venueMax=mermstDto.getMmMerchantNo();
//			}
//		}
		venueMax = meraccDto.getMmMerchantNo().compareTo(mermstDto.getMmMerchantNo())>0?
				meraccDto.getMmMerchantNo():mermstDto.getMmMerchantNo();
		return venueMax;
	} 
	
	/**
	 * 商户最大值max
	 * @return
	 */
	public String getMerchantMax(){
		
		String merchantMax="";
//		Map<String,String> map = new HashMap<>();
//		map.put("mmPhyState", "1");
//		
//		List<CpMeracc> meraccList = cpMeraccMapper.searchCpMeraccByParams(map);
//		List<CpMermst> mermstList = cpMermstMapper.searchCpMermstByParams(map);
		
		CpMeracc meraccDto = cpMeraccMapper.searchMaxMeraccId();
		CpMermst mermstDto = cpMermstMapper.searchMaxMermstId();
		
//		if(meraccList.size()>0 && mermstList.size()==0){
//			merchantMax = meraccDto.getMmMerchantNo();
//		}
//		if(0==meraccList.size() && 0==mermstList.size()){
//			merchantMax=initProperties.getMerchantNo();
//		}
//		if(meraccList.size()==0 && mermstList.size()>0){
//			merchantMax = mermstDto.getMmMerchantNo();
//		}
//		if(meraccList.size()>0 && mermstList.size()>0){
//			String meraccMax = meraccDto.getMmMerchantNo();
//			String mermstMax = mermstDto.getMmMerchantNo();
//			int result = meraccMax.compareTo(mermstMax);
//			if(result>0){
//				merchantMax=meraccDto.getMmMerchantNo();
//			}else{
//				merchantMax=mermstDto.getMmMerchantNo();
//			}
//		}
		merchantMax = meraccDto.getMmMerchantNo().compareTo(mermstDto.getMmMerchantNo())>0?
				meraccDto.getMmMerchantNo():mermstDto.getMmMerchantNo();
		return merchantMax;
	}
	
	/**
	 * 场馆查询
	 * @param merchantNo
	 * @return
	 */
	public CpMeracc getMerchantById(String merchantNo){
		CpMeracc cpMeracc = cpMeraccMapper.searchCpMeraccByMmMerchantNo(merchantNo);
		if(cpMeracc == null){
			cpMeracc = new CpMeracc();
		}
		return cpMeracc;
	}
	
	/**
	 * 场馆录入删除
	 * @param cpMeracc
	 * @return
	 */
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
	
	/**
	 * 商户录入删除
	 * @param cpMeracc
	 * @return
	 */
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
	
	/**
	 * 场馆录入授权
	 * @param merchantNo
	 * @param meracc
	 * @return
	 */
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
	
	/**
	 * 商户录入授权 
	 * @param merchantNo
	 * @param meracc
	 * @return
	 */
	public Result<CpMeracc> doAuthorize(String merchantNo, CpMeracc meracc) {
		try {
			insertMerchantForAuthorize(meracc);
			CpMeracc newMeracc = getMerchantById(merchantNo);
			newMeracc.setMmRiskStatus("2");
			cpMeraccMapper.updateCpMeracc(newMeracc);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.create("DOAUTHORIZE_FALSE", "商户复合失败");
		}
		return Result.create("OK", "商户复合成功");
	}
	
	public Long insertMerchantForAuthorize(CpMermst cpMermst)throws Exception {
		Long long1 = cpMermstMapper.insertCpMermst(cpMermst);
		return long1;
	}
	
	/**
	 * 场馆列表
	 * @param mmPmtMode
	 * @return
	 */
	public List<CpMermst> getCpMermstList(String mmPmtMode) {
		Map<String, String> map = new HashMap<>();
		if("".equals(mmPmtMode)){
			map.put("mmPhyState", "99");
		}
			
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
	
	/**
	 * 根据场馆等级查询场馆列表
	 * @param mmPmtMode
	 * @return
	 */
	public List<CpMermst> getCpMermstListByMode(String mmPmtMode) {
		Map<String, String> map = new HashMap<>();
		if(StringUtils.isEmpty(mmPmtMode)){
			map.put("mmPhyState", "99");
		}
		map.put("mmPmtMode", mmPmtMode);
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
	
	/**
	 * 商户录入更新
	 * @param cpMeracc
	 * @return
	 */
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
	

}
