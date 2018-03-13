package cn.happyworlds.imgmt.service;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpGateip;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpPosprm;
import cn.happyworlds.imgmt.entity.CpTrmacc;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.mapper.CpGateipMapper;
import cn.happyworlds.imgmt.mapper.CpMermstMapper;
import cn.happyworlds.imgmt.mapper.CpPosprmMapper;
import cn.happyworlds.imgmt.mapper.CpTrmaccMapper;
import cn.happyworlds.imgmt.mapper.CpTrmmstMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class MachineService {

	@Autowired
	private CpMermstMapper cpMermstMapper;
	@Autowired
	private CpTrmmstMapper  cpTrmmstMapper;
	@Autowired
	private CpPosprmMapper cpPosprmMapper;
	@Autowired
	private CpTrmaccMapper cpTrmaccMapper;
	@Autowired
	private CpGateipMapper cpGateipMapper;
	@Autowired
	private CpGateipMapper gateipMapper;
	
	public List<CpTrmmst> machineList(){
		return cpTrmmstMapper.searchCpTrmmstByParams(null);
	}
	
	
	/**
	 * 场馆列表获取 
	 * @param mm_merchant_no 场馆号
	 * @param mm_biz_name    场馆名称
	 * @param mm_dba_name    场馆别名
	 * @param pageBounds
	 * @return
	 */
	public Result<PageInfo<CpMermst>> machineList(final String mm_merchant_no,final String mm_stmt_name,final String mm_dba_name,String mm_phy_state,String mm_pmt_mode,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		
		if (StringUtils.hasText(mm_merchant_no)) {
			params.put("mmMerchantNo", mm_merchant_no);
		}
		if (StringUtils.hasText(mm_stmt_name)) {
			params.put("mmStmtName", mm_stmt_name);
		}
		if (StringUtils.hasText(mm_dba_name)) {
			params.put("mmDbaName", mm_dba_name);
		}
		if(!"0".equals(mm_pmt_mode)){
			params.put("mmPmtMode", mm_pmt_mode);
		}
		params.put("mmPhyState", "0");
		params.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	
	/**
	 * 场馆下对应闸机 
	 * @param tm_merchant_id 场馆ID
	 * @param pageBounds
	 * @return
	 */
	public Result<PageInfo<CpTrmmst>> trmList(final String tm_merchant_id,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		
		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		params.put("tmEdcSerial", "0");
		params.put("tmUseState", "1");
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	/**
	 * 复核跳转对应闸机
	 *  
	 * 
	 * @author Hugh
	 */
	public Result<PageInfo<CpTrmmst>> trmAllList(PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		
		params.put("tmEdcSerial", "0");
		params.put("tmUseState", "1");
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	/**
	 * 闸机列表获取 
	 * @param tm_merchant_id 商户号
	 * @param tm_model 园区类型
	 * @param pageBounds
	 * @return
	 */
	public Result<PageInfo<CpTrmmst>> trmOneList(final String tm_merchant_id,final String tm_terminal_id,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		
		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		
		if (StringUtils.hasText(tm_terminal_id)) {
			params.put("tmTerminalId", tm_terminal_id);
		}
//		if (StringUtils.hasText(tm_model)) {
//			params.put("tmModel", tm_model);
//		}
		//闸机0
		params.put("tmEdcSerial", "0");
		params.put("tmUseState", "1");
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	
	/**
	 * 机具列表获取 
	 * @param tm_terminal_id 终端ID
	 * @param tm_merchant_id 商户ID
	 * @param pageBounds
	 * @return
	 */
	
	public Result<PageInfo<CpTrmmst>> trmList(final String tm_merchant_id,final String tm_terminal_id,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		
		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		if (StringUtils.hasText(tm_terminal_id)) {
			params.put("tmTerminalId", tm_terminal_id);
		}
		
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	/**
	 * id查询闸机
	 * @param id 闸机编号
	 * @return
	 */
	public Result<CpTrmmst> cpTrmmstGetById(String id) {
		CpTrmmst ObCpTrmmst = cpTrmmstMapper.searchCpTrmmstByTmTerminalId(id);
		if (null == ObCpTrmmst) {
			return Result.create("ROLE_NOT_EXISTS", "闸机不存在");
		}
		return Result.create(ObCpTrmmst);
	}
  
	/**
	 * 机具品牌
	 * @return
	 */
	public List<CpPosprm> cpPosprmToppBrand(){
		List<CpPosprm> cpPosprmList=cpPosprmMapper.findAllCpPosprmPpBrand();
		return cpPosprmList;
	}
	
	
	/**
	 * 添加机具
	 */
	public Long insertCpTrmacc(CpTrmacc cpTrmacc){
		cpTrmacc.setTmDownload("Y");
		cpTrmacc.setTmModeType(3L);
		cpTrmacc.setTmVersionNo("1.0");
		cpTrmacc.setTmInstType(0L);
		
		Long row = cpTrmaccMapper.insertCpTrmacc(cpTrmacc);
		return row;
	}
	
	
	/**
	 * 更新机具
	 */
	public Result<CpTrmacc> update(CpTrmacc cpTrmacc){
		try {
			cpTrmacc.setTmApplStatus("U");
			cpTrmaccMapper.insertCpTrmacc(cpTrmacc);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpTrmacc_UPDATE_FAILED", "机具更新失败");
		}
		return Result.create(cpTrmacc);
	}
	
	
	
	/**
	 * 闸机修改处理cp_trmacc
	 * 
	 * @author Hugh
	 */
	public Result<CpTrmacc> updateGate(CpTrmacc cpTrmacc){

		try {
			cpTrmacc.setTmApplStatus("U");
			cpTrmacc.setTmUseState("1"); //闸机修改：1
			cpTrmaccMapper.updateCpTrmacc(cpTrmacc);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpTrmacc_UPDATE_FAILED", "闸机更新失败");
		}
		return Result.create(cpTrmacc);
	}
	
	
	/**
	 * 闸机修改处理cp_trmmst
	 * 
	 * @author Hugh
	 */
	public Result<CpTrmmst> updateGateTrmmst(CpTrmmst cpTrmmst) {

		try {
			cpTrmmst.setTmUseState("0"); // 闸机修改假删除
			cpTrmmstMapper.updateCpTrmmst(cpTrmmst);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpTrmacc_UPDATE_FAILED", "闸机更新失败");
		}
		return Result.create(cpTrmmst);
	}
	
	
	/**
	 * 闸机删除
	 * 
	 * @author Hugh
	 */
	public Long delete(String tmTerminalId){
		
		CpTrmmst oldTrmmst = cpTrmmstMapper.searchCpTrmmstByTmTerminalId(tmTerminalId);
		oldTrmmst.setTmUseState("0");
		Long row = cpTrmmstMapper.updateCpTrmmst(oldTrmmst);
		if(row <= 0){
			return row;
		}		
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(oldTrmmst.getTmHostSerial())) {
			params.put("gaIp", oldTrmmst.getTmHostSerial());
		}
		List<CpGateip> gateIpList = gateipMapper.searchCpGateipByParams(params);
		CpGateip cpgateip = gateIpList.get(0);
		cpgateip.setGaTm("999");
		cpgateip.setGaState(1);
		Long row1 = gateipMapper.updateCpGateip(cpgateip);
		if(row1 <= 0){
			return row1;
		}
		return row1;
	}
	
	
	/**
	 * 待复核列表
	 * 
	 * @author Hugh
	 */
	public Result<PageInfo<CpTrmacc>> cpTrmaccList(final String tm_merchant_id, final String tm_terminal_id,
			PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();

		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		if (StringUtils.hasText(tm_terminal_id)) {
			params.put("tmTerminalId", tm_terminal_id);
		}
		// 闸机
		params.put("tmUseState", "1"); // 新插入或者修改记录动作
		params.put("tmEdcSerial", "0");
		List<CpTrmacc> page = cpTrmaccMapper.searchCpTrmaccByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmacc>(page));
	}
	
	
	/**
	 * 待复核机具查看
	 */
	public Result<CpTrmacc> cpTrmaccGetById(String id) {
		CpTrmacc ObCpTrmacc = cpTrmaccMapper.searchCpTrmaccByTmTerminalId(id);
		if (null == ObCpTrmacc) {
			return Result.create("ROLE_NOT_EXISTS", "机具不存在");
		}
		return Result.create(ObCpTrmacc);
	}

	
	/**
	 * 待复核机具删除
	 * 
	 */
	public Long unexamineDelete(String tmTerminalId) {
		CpTrmacc trmacc = cpTrmaccMapper.searchCpTrmaccByTmTerminalId(tmTerminalId);
		trmacc.setTmUseState("0"); // 删除
		Long row = cpTrmaccMapper.updateCpTrmacc(trmacc);
		return row;
	}
	
	
	/**
	 * 闸机复核
	 * 考虑添加记录、修改记录两种情况
	 * 
	 * @author Hugh
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public Long examine(String tmTerminalId, String currentStaffId) throws IllegalAccessException, InvocationTargetException {

		Long updateRow = 0L;
		Long addrow = 0L;
		Long deleterow = 0L;

		Date sysDate = new Date();
		SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyyMMdd hhdd");

		//待复核数据记录
		CpTrmacc oldTrmacc = cpTrmaccMapper.searchCpTrmaccByTmTerminalId(tmTerminalId);
		// 复核数据记录
		CpTrmmst ObCpTrm = cpTrmmstMapper.searchCpTrmmstByTmTerminalId(tmTerminalId);
		
		if (null != ObCpTrm) {
			// 表中已有记录，此时只需要修改cpTrmmst中的记录

			BeanUtils.copyProperties(ObCpTrm, oldTrmacc);
			ObCpTrm.setTmUseState("1");
			ObCpTrm.setTmAuthUser(currentStaffId);
			ObCpTrm.setTmAuthTimestamp(formatSysDate.format(sysDate));
			
			updateRow = cpTrmmstMapper.updateCpTrmmst(ObCpTrm);
		} else {
			// 之前无记录
			
			BeanUtils.copyProperties(oldTrmacc, oldTrmacc);
			oldTrmacc.setTmUseState("1");
			oldTrmacc.setTmAuthUser(currentStaffId);
			oldTrmacc.setTmAuthTimestamp(formatSysDate.format(sysDate));
			addrow = cpTrmmstMapper.insertCpTrmmst(oldTrmacc);
		}
		if (updateRow > 0 || addrow > 0) {
			CpTrmacc obTrmacc = cpTrmaccMapper.searchCpTrmaccByTmTerminalId(tmTerminalId);
			obTrmacc.setTmUseState("2");
			deleterow = cpTrmaccMapper.updateCpTrmacc(obTrmacc);
		}
		return deleterow;
	}
	
	
	
	/**
	 * 待复核机具查询
	 * 
	 * @author Hugh
	 */
	public CpTrmacc getCpTrmaccGetById(String id) {
		CpTrmacc ObCpTrmacc = cpTrmaccMapper.searchCpTrmaccByTmTerminalId(id);
		return ObCpTrmacc;
	} 
	
	
	/**
	 * 添加机具验证
	 */
	public String addMachineValidate(String id){
		CpTrmmst ObCpTrmmst = cpTrmmstMapper.searchCpTrmmstByTmTerminalId(id);
		CpTrmacc obCpTrmacc = cpTrmaccMapper.searchCpTrmaccByTmTerminalId(id);
		if((null==ObCpTrmmst || "".equals(ObCpTrmmst))&&(null ==obCpTrmacc ||"".equals(obCpTrmacc))){
			return"non-existent";
		}else {
			return "existent";
		}
	}
	
	
	/**
	 * 闸机ID自动生成
	 * 
	 * @author Hugh
	 */
	public CpTrmacc searchMaxGateTrmaccTerminalId(){
		
		CpTrmacc trmacc = cpTrmaccMapper.searchMaxGateTrmaccTerminalId();
		return trmacc;
	}
	
	
	/**
	 * 闸机ID自动生成
	 * 
	 * @author Hugh
	 */
	public CpTrmmst searchMaxGateTrmmstTerminalId(){
		
		CpTrmmst trmmst = cpTrmmstMapper.searchMaxGateTrmmstTerminalId();
		return trmmst;
	}
	
	
	
	/**
	 * 根据场馆号查询场馆名称
	 * 
	 * @param mm_merchant_no
	 * @author Hugh
	 * 
	 */
	public CpMermst searchCpMermstByMmMerchantNo(String mm_merchant_no){
		CpMermst mermst = cpMermstMapper.searchCpMermstByMmMerchantNo(mm_merchant_no);
		return mermst;
	}
	
	
	/**
	 * 可用闸机IP列表
	 * @return
	 * @author Hugh
	 */
	public List<CpGateip> cpGateIpList(){
		
		Map<String, String> params = new HashMap<>();
		params.put("gaState", "1");
		
		List<CpGateip> gateIpList = cpGateipMapper.searchCpGateipByParams(params);
		return gateIpList;
		
	}
	
	
	/**
	 * 根据分配闸机IP查询然后更新闸机IP记录表
	 * 
	 * @param gateIp 
	 * @return
	 * @author Hugh
	 * 
	 */
	public CpGateip getGateIpDto(String gateIp){
		
		Map<String, String> params = new HashMap<>();
		params.put("gaIp", gateIp);
		
		List<CpGateip> gateIpList = cpGateipMapper.searchCpGateipByParams(params);
		return gateIpList.get(0);
	}
	
	
	/**
	 * 更新闸机IP
	 * 
	 * @author Hugh
	 */
	public Result<CpGateip> update(CpGateip gateip){
		try {
			cpGateipMapper.updateCpGateip(gateip);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpGateip_UPDATE_FAILED", "闸机IP记录更新失败");
		}
		return Result.create(gateip);
	}
	
	
	/**
	 * 场馆下对应商户列表 
	 * @param mm_merchant_no 场馆编号
	 * @param pageBounds
	 * @return
	 */
	public Result<PageInfo<CpMermst>> mermList(final String mm_merchant_no, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();

		// 场馆编号
		if (StringUtils.hasText(mm_merchant_no)) {
			params.put("mmChainAccno", mm_merchant_no);
		}

		params.put("mmPhyState", "1");
		params.put("mmRiskStatus", "1");

		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	
	/**
	 * 场馆下对应商户,商户下对应终端
	 *  
	 * 
	 */
	public Result<PageInfo<CpTrmmst>> merTrmList(final String tm_merchant_id,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		
		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		params.put("tmEdcSerial", "1");
		params.put("tmUseState", "1");
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	/**
	 * 场馆下对应商户,商户下对应终端列表查询按妞
	 *  
	 * 
	 */
	public Result<PageInfo<CpTrmmst>> findTrmList(final String tm_terminal_id,final String tm_merchant_id,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		
		if (StringUtils.hasText(tm_terminal_id)) {
			params.put("tm_terminal_id", tm_terminal_id);
		}
		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		params.put("tmEdcSerial", "1");
		params.put("tmUseState", "1");
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	/**
	 * 商户列表获取 
	 * @param tm_merchant_id 商户号
	 * @param 
	 * @param pageBounds
	 * @return
	 */
	public Result<PageInfo<CpMermst>> merOneList(final String tm_merchant_id, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();

		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("mmChainAccno", tm_merchant_id);
		}
		
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	
	/**
	 * 终端ID自动生成
	 * 
	 * @author Hugh
	 */
	public CpTrmacc searchMaxTrmaccTerminalId(){
		
		CpTrmacc trmacc = cpTrmaccMapper.searchMaxTrmaccTerminalId();
		return trmacc;
	}
	
	
	/**
	 * 终端ID自动生成
	 * 
	 * @author Hugh
	 */
	public CpTrmmst searchMaxTrmmstTerminalId(){
		
		CpTrmmst trmmst = cpTrmmstMapper.searchMaxTrmmstTerminalId();
		return trmmst;
	}
	
	
	/**
	 * 终端待复核列表
	 * 
	 * @author Hugh
	 */
	public Result<PageInfo<CpTrmacc>> cpTeTrmaccList(final String tm_merchant_id, final String tm_terminal_id,
			PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();

		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		if (StringUtils.hasText(tm_terminal_id)) {
			params.put("tmTerminalId", tm_terminal_id);
		}
		// 闸机
		params.put("tmUseState", "1"); // 新插入或者修改记录动作
		params.put("tmEdcSerial", "1");//终端
		List<CpTrmacc> page = cpTrmaccMapper.searchCpTrmaccByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmacc>(page));
	}
	
	
	/**
	 * 待复核终端列表
	 * 
	 * @author Hugh
	 */
	public Result<PageInfo<CpTrmacc>> cpWaTrmaccList(final String tm_merchant_id, final String tm_terminal_id,
			PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();

		if (StringUtils.hasText(tm_merchant_id)) {
			params.put("tmMerchantId", tm_merchant_id);
		}
		if (StringUtils.hasText(tm_terminal_id)) {
			params.put("tmTerminalId", tm_terminal_id);
		}
		// 终端
		params.put("tmUseState", "1"); // 新插入或者修改记录动作
		params.put("tmEdcSerial", "1");
		List<CpTrmacc> page = cpTrmaccMapper.searchCpTrmaccByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmacc>(page));
	}
	
	
	/**
	 * 终端修改处理cp_trmacc
	 * 
	 * @author Hugh
	 */
	public Result<CpTrmacc> updateTrmmst(CpTrmacc cpTrmacc){

		try {
			cpTrmacc.setTmApplStatus("U");
			cpTrmacc.setTmUseState("1"); //闸机修改：1
			cpTrmaccMapper.updateCpTrmacc(cpTrmacc);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpTrmacc_UPDATE_FAILED", "终端更新失败");
		}
		return Result.create(cpTrmacc);
	}
	
	
	/**
	 * 终端处理cp_trmmst
	 * 
	 * @author Hugh
	 */
	public Result<CpTrmmst> updateTrmmst(CpTrmmst cpTrmmst) {

		try {
			cpTrmmst.setTmUseState("0"); // 终端修改假删除
			cpTrmmstMapper.updateCpTrmmst(cpTrmmst);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpTrmacc_UPDATE_FAILED", " 终端更新失败");
		}
		return Result.create(cpTrmmst);
	}
	
	
	/**
	 * 授权后的所有终端,商户下对应终端 
	 * @param 
	 * @param pageBounds
	 * @return
	 */
	public Result<PageInfo<CpTrmmst>> merTrmAllList(PageBounds pageBounds){

		Map<String, String> params = new HashMap<>();
		
		params.put("tmEdcSerial", "1");
		params.put("tmUseState", "1");
		List<CpTrmmst> page = cpTrmmstMapper.searchCpTrmmstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTrmmst>(page));
	}
	
	
	/**
	 * 查询闸机|终端对象
	 * 
	 * @author Hugh
	 */
	public CpTrmmst trmmstDto(String terminalNo) {

		CpTrmmst trmmstDto = cpTrmmstMapper.searchCpTrmmstByTmTerminalId(terminalNo);
		return trmmstDto;
	}
	
	//场馆对象
	public CpMermst getMermstDto(String mm_merchant_no){
		Map<String,String> map = new HashMap<>();
		map.put("mmMerchantNo", mm_merchant_no);
		map.put("mmPhyState","0");
		List<CpMermst> mermstList = cpMermstMapper.searchCpMermstByParams(map);
		return mermstList.get(0);
	}
	
	
}
