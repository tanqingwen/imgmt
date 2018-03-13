package cn.happyworlds.imgmt.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.bean.cpm.PlasticCdStat;
import cn.happyworlds.imgmt.context.VenaProperties;
import cn.happyworlds.imgmt.entity.AclBrchsetBrchMap;
import cn.happyworlds.imgmt.entity.AclUserBrchsetMap;
import cn.happyworlds.imgmt.entity.CpBlkmlc;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCopmst;
import cn.happyworlds.imgmt.entity.CpCrdmtn;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpMemberPoint;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpSeckey;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.CpVerkey;
import cn.happyworlds.imgmt.entity.District;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.mapper.AclBrchsetBrchMapMapper;
import cn.happyworlds.imgmt.mapper.AclUserBrchsetMapMapper;
import cn.happyworlds.imgmt.mapper.CpBlkmlcMapper;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCopmstMapper;
import cn.happyworlds.imgmt.mapper.CpCrdmtnMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpMemberPointMapper;
import cn.happyworlds.imgmt.mapper.CpPrdgrpMapper;
import cn.happyworlds.imgmt.mapper.CpSeckeyMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.CpVerkeyMapper;
import cn.happyworlds.imgmt.mapper.DistrictMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.to.Constants;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.HttpPostUtil;
import cn.happyworlds.imgmt.util.JsonPalmView;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.StringUtil;
import cn.happyworlds.imgmt.util.SysDateFormat;


@Service
public class CrdtblService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CrdtblService.class);
	
	private String rtnResult;
	private String rtnState;
	private String barcode;
	private static final String STR_FORMAT = "00000000000000000000";
	private static final String ACCT_REF_NO = "000000000000";
	
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpPrdgrpMapper cpPrdgrpMapper;
	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpCrdmtnMapper cpCrdmtnMapper;
	@Autowired
	private CpCeptrxMapper cpCeptrxMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpBlkmlcMapper cpblkmlcMapper;
	@Autowired
	private CpCopmstMapper cpCopmstMapper;
	@Autowired
	private AclUserBrchsetMapMapper aclUserBrchsetMapMapper;
	@Autowired
	private AclBrchsetBrchMapMapper aclBrchsetBrchMapMapper;
	@Autowired
	private VenaProperties venaProperties;
	@Autowired
	private CpVerkeyMapper verkeyMapper;
	@Autowired
	private CpSeckeyMapper seckeyMapper;
	@Autowired
	private DistrictMapper districtMapper;
	@Autowired
	private CpMemberPointMapper cpMemberPointMapper;
	@Autowired
	private CpTicketMapper cpTicketMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private YwOrderitemMapper yworderitemMapper;
	
	public Result<CpCrdtbl> crdtblAdd(CpCrdtbl crdtbl) {

		return null;
	}
	
	/**
	 * 跟着证件类型和身份证号码查名下卡号
	 * 
	 * 
	 * @author yanjy
	 */
	public List<CpCrdtbl> curTblListGetByIdCbIdTypeAndCbIdno(String cbIdType,String cbIdno) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbIdType)) {
			params.put("cbIdType", cbIdType);
		}
		if (StringUtils.hasText(cbIdno)) {
			params.put("cbIdno", cbIdno);
		}
		List<CpCrdtbl> page = cpCrdtblMapper.searchCpCrdtblByParams(params);
		return page;
	}
	
	/**
	 * 跟着一个卡号找数据
	 * 
	 * 
	 * @author yanjy
	 */
	public CpCrdtbl curTblListGetById(String cbCardholderNo) {
		CpCrdtbl page = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
		return page;
	}
	
	
	public CpCrdtbl byCbRecommenderNo(String cbRecommenderNo) {
		CpCrdtbl page = cpCrdtblMapper.searchCpCrdtblByCbRecommenderNo(cbRecommenderNo);
		return page;
	}
	
	/**
	 * 生成卡号
	 * 
	 * @author Hugh
	 */
	public StatusResult<List<String>> genCardNo() {
		
		try{
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbCardPrdctGroup", "1100");
			params.put("cbIdType", "P");
			params.put("cbIdno", "99999");
			
			List<CpCrdtbl> crdtblList=cpCrdtblMapper.searchCpCrdtblByParams(params);
			List<String> list = new ArrayList<String>();
			String cardNo="";
			if(null!=crdtblList && crdtblList.size()>0){
				cardNo=crdtblList.get(0).getCbCardholderNo();
				list.add(cardNo);
				return StatusResult.create(list);
			}else{
				return StatusResult.create("FALSE", "预制卡已用完,请申请制卡");
			}
		}catch (Throwable e) {
			LOG.warn("生成卡号异常", e);
			return StatusResult.create("FALSE", "生成卡号异常，请稍后再试！");
		}
		
	}
	
	
	/**
	 * 柜台开卡
	 * @param deposit			押金
	 * @param cbCardholderNo	持卡人号码
	 * @param cbIdType			证件类型
	 * @param idNo				证件号码
	 * @param name				姓名
	 * @param mobile			手机号
	 * @param prProdctGroup		产品组代码
	 * @param birthday			出生日期
	 * @param staffId
	 * 
	 * @author Hugh
	 */
	public StatusResult<List<String>> openHCard(String deposit, String cbCardholderNo, String cbIdType, String idNo,
			String name, String mobile, String prProdctGroup, String birthday, String staffId) throws ParseException {
		BigDecimal messageid = null;
		List<String> list = new ArrayList<String>();
		System.out.println("制卡程序");
		String NDACC_RULE = "0";
		String validDate = "";

		String custNo = "P" + cbCardholderNo;

		if (this.checkcardno(cbCardholderNo)) {
			// 卡表
			CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
			// 查询cp_sysprm
			List<CpSysprm> sysprmList = cpSysprmMapper.searchCpSysprmByParams(null);
			CpSysprm cpSysprm = new CpSysprm();
			if (null != sysprmList) {
				cpSysprm = sysprmList.get(0);
			}
			String oldAnnivDate = "";// 激活日期
			String accountType = "";// 账号规则
			if (null != cpCrdtbl) {
				oldAnnivDate = cpCrdtbl.getCbAnnivDate();
				accountType = cpCrdtbl.getCbIndaccRule().toString();
			}
			int length = accountType.length();
			if (length < 4) {
				accountType = "0";
			} else if (length == 4) {
				accountType = accountType.substring(0, 1);
			}

			// 更新cp_indacc表
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
			params.put("cbIndividualAcctType", "1");
			List<CpIndacc> indaccList = cpIndaccMapper.searchCpIndaccByParams(params);
			CpIndacc cpIndacc = new CpIndacc();
			if (null != indaccList && indaccList.size() > 0) {
				cpIndacc = indaccList.get(0);
				cpIndacc.setCbProductCd(Integer.parseInt(prProdctGroup));
				cpIndacc.setCbIndCardholderNo(cbCardholderNo);
				cpIndacc.setCbCustomerId(custNo);
				cpIndaccMapper.updateCpIndacc(cpIndacc);
			}

			String account = cpIndacc.getCbExternalAcct();
			if (null != account && !"".equals(account)) {
				if (account.length() > 19) {
					account = account.substring(account.length() - 19, account.length());
				}
			}
			account = "0" + accountType + account;

			if (!cpCrdtbl.getCbIdType().equals("P")) {
				return StatusResult.create("FALSE", "非预制卡");
			}

			cpCrdtbl.setCbIdType(cbIdType);
			cpCrdtbl.setCbIdno(idNo);
			cpCrdtbl.setCbBscIdType(cbIdType);
			cpCrdtbl.setCbBasicCustomerIdno(idNo);
			cpCrdtbl.setCbAnnivDate(cpSysprm.getSpNextProcessingDate());
			cpCrdtbl.setCbBillCycle(Integer.parseInt(cpSysprm.getSpNextProcessingDate().substring(6)));
			cpCrdtbl.setCbSuspendDate(birthday);
			cpCrdtbl.setCbCardPrdctGroup(Integer.parseInt(prProdctGroup));
			cpCrdtbl.setCbIndaccRule(Integer.parseInt(NDACC_RULE));
			cpCrdtbl.setCbEmbossname(name);
			cpCrdtbl.setCbSourceCd(mobile);
			cpCrdtbl.setCbCvki(Integer.parseInt(deposit));
			cpCrdtbl.setCbExpiryCcyymm(validDate);
			cpCrdtbl.setCbModUser(staffId);
			cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);

			BigDecimal balance = BigDecimal.ZERO;
			// 客户信息表CpCsttbl
			CpCsttbl cpCsttbl = new CpCsttbl();

			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("cbIdType", cbIdType);
			params1.put("cbCustomerIdno", idNo);
			List<CpCsttbl> csttblList = cpCsttblMapper.searchCpCsttblByParams(params1);

			if (null != csttblList && csttblList.size() > 0) {
				cpCsttbl = csttblList.get(0);
				cpCsttbl.setCbHomePhone(mobile);
				cpCsttbl.setCbCardholderName(name);
				cpCsttbl.setCbDob(birthday);
				cpCsttblMapper.updateCpCsttbl(cpCsttbl);
			} else {
				cpCsttbl.setCbHomePhone(mobile);
				cpCsttbl.setCbCardholderName(name);
				cpCsttbl.setCbDob(birthday);
				cpCsttbl.setCbIdType(cbIdType);
				cpCsttbl.setCbCustomerIdno(idNo);
				Long memberCode = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");// 交易tranId
				cpCsttbl.setCbMemberCode(memberCode.toString());
				cpCsttblMapper.insertCpCsttbl(cpCsttbl);
			}

			// 卡维护历史表:cp_crdmtn
			CpCrdmtn cpCrdmtn = new CpCrdmtn();

			Map<String, String> params2 = new HashMap<String, String>();
			params2.put("cmCardholderNo", cbCardholderNo);
			params2.put("cmModDate", cpSysprm.getSpNextProcessingDate());
			params2.put("cmCustomerIdno", idNo);
			params2.put("cmIdType", cbIdType);

			// 排序
			List<CpCrdmtn> crdMtnList = cpCrdmtnMapper.searchCpCrdmtnByParams(params2);
			int intSeqNo = 0;
			int tmpIndex = 0;
			if (null == crdMtnList || crdMtnList.size() == 0) {
				intSeqNo = 0;
			} else {
				CpCrdmtn tmpCrdmtn = new CpCrdmtn();
				tmpIndex = crdMtnList.size() - 1;
				tmpCrdmtn = (CpCrdmtn) crdMtnList.get(tmpIndex);
				intSeqNo = tmpCrdmtn.getCmMtnSeq().intValue();
			}
			cpCrdmtn.setCmCardholderNo(cbCardholderNo);
			cpCrdmtn.setCmModDate(cpSysprm.getSpProcessingDate());
			cpCrdmtn.setCmCustomerIdno(cpCsttbl.getCbCustomerIdno());
			cpCrdmtn.setCmIdType(cpCsttbl.getCbIdType());
			cpCrdmtn.setCmMtnSeq((long) intSeqNo + 1);
			cpCrdmtn.setCmOffId(staffId);
			Date sysDate = new Date();
			SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
			cpCrdmtn.setCmTimestamp(formatSysDate.format(sysDate));
			cpCrdmtn.setCmDesc("CB_ANNIV_DATE");
			cpCrdmtn.setCmMtnSeq((long) intSeqNo + 1);
			cpCrdmtn.setCmOldContents(oldAnnivDate);
			cpCrdmtn.setCmNewContents(cpSysprm.getSpNextProcessingDate());

			intSeqNo = intSeqNo + 1;

			cpCrdmtnMapper.insertCpCrdmtn(cpCrdmtn);

			// cp_ceptrx
			CpCeptrx cpCeptrx = new CpCeptrx();
			cpCeptrx.setCtBranchId(cpCrdtbl.getCbCentreCd());
			Long tranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");// 交易tranId
			cpCeptrx.setCtTranId(tranId);

			// start 主键流水messageId
			/*BigDecimal seqname = sequenceMapper.searchSerialToName();
			if (seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd"))) != 0) {
				sequenceMapper.truncateSerial();
			}*/
			messageid = sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
			// end

			cpCeptrx.setCtMessageId(messageid.longValue());
			cpCeptrx.setCtCardNumber(cbCardholderNo);
//			cpCeptrx.setCtTranTime(getNowDate("HHmmss"));
			cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
			cpCeptrx.setCtDbCr("C");
			cpCeptrx.setCtTranAmount(BigDecimal.ZERO);
			cpCeptrx.setCtCardAmount(cpCeptrx.getCtTranAmount());
			cpCeptrx.setCtDescription("开卡");
			cpCeptrx.setCtCurrcode("156");
			cpCeptrx.setCtApproveTime(getNowDate("yyyyMMddHHmmss"));
			cpCeptrx.setCtPostTime(cpSysprm.getSpNextProcessingDate());
			cpCeptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
			cpCeptrx.setCtTranCode("OPENCARD");
			cpCeptrx.setCtTranCode("OPENCARD");
			cpCeptrx.setCtTxrnType("C");
			cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
			cpCeptrx.setCtBillCurrAmt(cpCeptrx.getCtTranAmount());
			cpCeptrx.setCtAgeCodeB4Post("00");
			cpCeptrx.setCtAgeCodeAfterPost("00");
			cpCeptrx.setCtReversalFlag("0");
			cpCeptrx.setCtOutstdB4Post(balance);
			cpCeptrx.setCtOutstdAfterPost(cpIndacc.getCbOutstdBal());
			cpCeptrx.setCtUserCreate(staffId);
			cpCeptrx.setCtStatus("0");
			cpCeptrx.setCtDc("0");
			cpCeptrx.setCtTranNum("1");
			cpCeptrx.setCtTranZone("0");
			cpCeptrx.setCtOpenZone("0");
			cpCeptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
			cpCeptrx.setCtFeeAmount(new BigDecimal(deposit));
			cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
		} else {
			return StatusResult.create("FALSE", "无效卡号");
		}
			list.add(messageid + "");
		return StatusResult.create(list);
	}
	
	
	/**
	 * 预售开卡绑卡
	 * 
	 * @param cbCardholderNo 卡号
	 * @param idNo 身份证号码
	 * @param uname	客户姓名
	 * @pamam orderId 订单详情id
	 * @param birthday 出生日期
	 * @param staffId 操作员
	 *  
	 * @author whb
	 */
	public StatusResult<String> openHCardInt(String cbCardholderNo,String idNo,String name,String birthday,String orderId,String staffId) throws ParseException{
		String validDate = "";
		
		String custNo="P"+cbCardholderNo;
		//end
		if(this.checkcardnoInter(cbCardholderNo)){
//			判断客户是否有卡
			if(!this.seachCpCrd(idNo)){
				return StatusResult.create("FALSE","此客户已经有卡");
			}
//			判断客户是否存在，如果不存在，添加用户
			CpCsttbl cpCsttbl = new CpCsttbl();
			if(!this.seachCpCsttbl(idNo)){
				cpCsttbl.setCbMemberCode(automaticgrowthService.sqlNextHuiyuan("ID"));
				String CbSex = idNo.substring(16, 17);
				cpCsttbl.setCbIdType("1");
				cpCsttbl.setCbCustomerIdno(idNo);
				cpCsttbl.setCbCardholderName(name);
				if(Integer.parseInt(CbSex)%2==0 ){
					cpCsttbl.setCbSex("F");
				}else{
					cpCsttbl.setCbSex("M");
				}
				cpCsttbl.setCbDob(birthday);
				//获取身份证前6位来判断是属于什么省
				String cbHomeState = idNo.substring(0, 2);
				cbHomeState = cbHomeState+"0000";
				District district2  = districtMapper.searchDistrictByCode(cbHomeState);
				if(StringUtils.isEmpty(district2)){
					return StatusResult.create("FALSE","身份证号码没有找到对应的省");
				}
				cpCsttbl.setCbHomeState(district2.getName()+district2.getSuffix());
				cpCsttbl.setCbAlt2billAddr1("0");
				cpCsttbl.setCbAlt2billAddr2("0");
				cpCsttblMapper.insertCpCsttbl(cpCsttbl);
			}else{
				cpCsttbl=cpCsttblMapper.searchCpCsttblByCbCustomerIdno(idNo);
			}
			//卡表
			CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
			//查询cp_sysprm
			List<CpSysprm> sysprmList=cpSysprmMapper.searchCpSysprmByParams(null);
			CpSysprm cpSysprm=new CpSysprm();
			if(null!=sysprmList){
				cpSysprm=sysprmList.get(0);
			}
			String oldAnnivDate="";//激活日期
			if(null!=cpCrdtbl){
				oldAnnivDate=cpCrdtbl.getCbAnnivDate();
			}
			cpCrdtbl.setCbIdType("1");
			cpCrdtbl.setCbIdno(idNo);
			cpCrdtbl.setCbBscIdType("1");
			cpCrdtbl.setCbBasicCustomerIdno(idNo);
			cpCrdtbl.setCbAnnivDate(cpSysprm.getSpNextProcessingDate());
			cpCrdtbl.setCbBillCycle(Integer.parseInt(cpSysprm.getSpNextProcessingDate().substring(6)));
			cpCrdtbl.setCbPlasticCd("U");
			cpCrdtbl.setCbSuspendDate(birthday);
			cpCrdtbl.setCbCardPrdctGroup(1100);
			cpCrdtbl.setCbIndaccRule(0);
			cpCrdtbl.setCbEmbossname(name);
			cpCrdtbl.setCbExpiryCcyymm(validDate);
			cpCrdtbl.setCbModUser(staffId);
			cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
			
//			网络购票更新账户表积分信息
			this.pointAdd(cpCrdtbl, orderId);
			
//			用户等级更新
			cardGrp(cpCrdtbl, cpCsttbl, orderId);
			//卡维护历史表:cp_crdmtn
			CpCrdmtn cpCrdmtn=new CpCrdmtn();
			
			Map<String, String> params2 = new HashMap<String, String>();
			params2.put("cmCardholderNo", cbCardholderNo);
			params2.put("cmModDate", cpSysprm.getSpNextProcessingDate());
			params2.put("cmCustomerIdno",idNo);
			params2.put("cmIdType","1");
			
			//排序
			List<CpCrdmtn> crdMtnList=cpCrdmtnMapper.searchCpCrdmtnByParams(params2);
			int intSeqNo=0;
			int tmpIndex=0;
			if(null==crdMtnList || crdMtnList.size()==0){
				intSeqNo=0;
			}else{
				CpCrdmtn tmpCrdmtn = new CpCrdmtn();
				tmpIndex = crdMtnList.size()-1;
				tmpCrdmtn=(CpCrdmtn)crdMtnList.get(tmpIndex);
				intSeqNo=tmpCrdmtn.getCmMtnSeq().intValue();
			}	
			cpCrdmtn.setCmCardholderNo(cbCardholderNo);
			cpCrdmtn.setCmModDate(cpSysprm.getSpProcessingDate());
//			cpCrdmtn.setCmCustomerIdno(cpCsttbl.getCbCustomerIdno());
			cpCrdmtn.setCmCustomerIdno(idNo);
//			cpCrdmtn.setCmIdType(cpCsttbl.getCbIdType());
			cpCrdmtn.setCmIdType("1");
			cpCrdmtn.setCmMtnSeq((long)intSeqNo + 1);
			cpCrdmtn.setCmOffId(staffId);
			Date sysDate = new Date();
			SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
			cpCrdmtn.setCmTimestamp(formatSysDate.format(sysDate));
			cpCrdmtn.setCmDesc("CB_ANNIV_DATE");
			cpCrdmtn.setCmMtnSeq((long)intSeqNo+1);
			cpCrdmtn.setCmOldContents(oldAnnivDate);
			cpCrdmtn.setCmNewContents(cpSysprm.getSpNextProcessingDate());
			
			intSeqNo =intSeqNo+1;
			
			cpCrdmtnMapper.insertCpCrdmtn(cpCrdmtn);
			
			//cp_ceptrx
			CpCeptrx cpCeptrx=new CpCeptrx();
			cpCeptrx.setCtBranchId(cpCrdtbl.getCbCentreCd());
			Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
			cpCeptrx.setCtTranId(tranId);

			//start 主键流水messageId
			/*BigDecimal seqname = sequenceMapper.searchSerialToName();
			if(seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
				sequenceMapper.truncateSerial();
			}*/
			BigDecimal messageid;
			messageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
			cpCeptrx.setCtMessageId(messageid.longValue());
			cpCeptrx.setCtCardNumber(cbCardholderNo);
//			cpCeptrx.setCtTranTime(getNowDate("HHmmss"));
			cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
			cpCeptrx.setCtDbCr("C");
			cpCeptrx.setCtTranAmount(BigDecimal.ZERO);
			cpCeptrx.setCtCardAmount(cpCeptrx.getCtTranAmount());
			cpCeptrx.setCtDescription("互联网取卡");
			cpCeptrx.setCtCurrcode("156");
			cpCeptrx.setCtApproveTime(getNowDate("yyyyMMddHHmmss"));
			cpCeptrx.setCtPostTime(cpSysprm.getSpNextProcessingDate());
//			cpCeptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
			cpCeptrx.setCtAccountId(cpCrdtbl.getCbIndividualAcctno());
			cpCeptrx.setCtTranCode("SPOTCARD");
			cpCeptrx.setCtTxrnType("C");
			cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
			cpCeptrx.setCtBillCurrAmt(cpCeptrx.getCtTranAmount());
			cpCeptrx.setCtAgeCodeB4Post("00");
			cpCeptrx.setCtAgeCodeAfterPost("00");
			cpCeptrx.setCtReversalFlag("0");
			cpCeptrx.setCtOutstdB4Post(new BigDecimal(0));
//			cpCeptrx.setCtOutstdAfterPost(cpIndacc.getCbOutstdBal());
			cpCeptrx.setCtOutstdAfterPost(new BigDecimal(0));
			cpCeptrx.setCtUserCreate(staffId);
			cpCeptrx.setCtStatus("0");
			cpCeptrx.setCtDc("0");
			cpCeptrx.setCtTranNum("1");
			cpCeptrx.setCtTranZone("0");
			cpCeptrx.setCtOpenZone("0");
//			cpCeptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
			cpCeptrx.setCtCustomerId(custNo);
			cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
			
			this.cpticketdanrenadd(cpCrdtbl,cpCsttbl,orderId);
			
			return StatusResult.create(messageid+"");
		}else{
			return StatusResult.create("FALSE","无效卡号");
		}
		
	}
	
	public StatusResult<String> openHCardInt2(String cbCardholderNo,String idNo,String name,String orderId,String staffId) throws ParseException{
		String validDate = "";
		
		String custNo="P"+cbCardholderNo;
		//end
		if(this.checkcardnoInter(cbCardholderNo)){
//			判断客户是否有卡
			if(!this.seachCpCrd(idNo)){
				return StatusResult.create("FALSE","此客户已经有卡");
			}
//			判断客户是否存在，如果不存在，添加用户
			CpCsttbl cpCsttbl = new CpCsttbl();
			if(!this.seachCpCsttbl(idNo)){
				cpCsttbl.setCbMemberCode(automaticgrowthService.sqlNextHuiyuan("ID"));
				cpCsttbl.setCbCustomerIdno(idNo);
				cpCsttbl.setCbIdType("3");
				cpCsttbl.setCbCardholderName(name);
				cpCsttbl.setCbAlt2billAddr1("0");
				cpCsttbl.setCbAlt2billAddr2("0");
				cpCsttblMapper.insertCpCsttbl(cpCsttbl);
			}else{
				cpCsttbl=cpCsttblMapper.searchCpCsttblByCbCustomerIdno(idNo);
			}
			//卡表
			CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
			//查询cp_sysprm
			List<CpSysprm> sysprmList=cpSysprmMapper.searchCpSysprmByParams(null);
			CpSysprm cpSysprm=new CpSysprm();
			if(null!=sysprmList){
				cpSysprm=sysprmList.get(0);
			}
			String oldAnnivDate="";//激活日期
			if(null!=cpCrdtbl){
				oldAnnivDate=cpCrdtbl.getCbAnnivDate();
			}
			cpCrdtbl.setCbIdType("3");
			cpCrdtbl.setCbIdno(idNo);
			cpCrdtbl.setCbBscIdType("3");
			cpCrdtbl.setCbBasicCustomerIdno(idNo);
			cpCrdtbl.setCbAnnivDate(cpSysprm.getSpNextProcessingDate());
			cpCrdtbl.setCbBillCycle(Integer.parseInt(cpSysprm.getSpNextProcessingDate().substring(6)));
			cpCrdtbl.setCbPlasticCd("U");
			cpCrdtbl.setCbCardPrdctGroup(1100);
			cpCrdtbl.setCbIndaccRule(0);
			cpCrdtbl.setCbEmbossname(name);
			cpCrdtbl.setCbExpiryCcyymm(validDate);
			cpCrdtbl.setCbModUser(staffId);
			cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
			
//			网络购票更新账户表积分信息
			this.pointAdd(cpCrdtbl, orderId);
			
//			用户等级更新
			cardGrp(cpCrdtbl, cpCsttbl, orderId);
			//卡维护历史表:cp_crdmtn
			CpCrdmtn cpCrdmtn=new CpCrdmtn();
			
			Map<String, String> params2 = new HashMap<String, String>();
			params2.put("cmCardholderNo", cbCardholderNo);
			params2.put("cmModDate", cpSysprm.getSpNextProcessingDate());
			params2.put("cmCustomerIdno",idNo);
			params2.put("cmIdType","3");
			//排序
			List<CpCrdmtn> crdMtnList=cpCrdmtnMapper.searchCpCrdmtnByParams(params2);
			int intSeqNo=0;
			int tmpIndex=0;
			if(null==crdMtnList || crdMtnList.size()==0){
				intSeqNo=0;
			}else{
				CpCrdmtn tmpCrdmtn = new CpCrdmtn();
				tmpIndex = crdMtnList.size()-1;
				tmpCrdmtn=(CpCrdmtn)crdMtnList.get(tmpIndex);
				intSeqNo=tmpCrdmtn.getCmMtnSeq().intValue();
			}	
			cpCrdmtn.setCmCardholderNo(cbCardholderNo);
			cpCrdmtn.setCmModDate(cpSysprm.getSpProcessingDate());
//			cpCrdmtn.setCmCustomerIdno(cpCsttbl.getCbCustomerIdno());
			cpCrdmtn.setCmCustomerIdno(idNo);
//			cpCrdmtn.setCmIdType(cpCsttbl.getCbIdType());
			cpCrdmtn.setCmIdType("1");
			cpCrdmtn.setCmMtnSeq((long)intSeqNo + 1);
			cpCrdmtn.setCmOffId(staffId);
			Date sysDate = new Date();
			SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyy-MM-dd.hh.mm.ss.SSSSSS");
			cpCrdmtn.setCmTimestamp(formatSysDate.format(sysDate));
			cpCrdmtn.setCmDesc("CB_ANNIV_DATE");
			cpCrdmtn.setCmMtnSeq((long)intSeqNo+1);
			cpCrdmtn.setCmOldContents(oldAnnivDate);
			cpCrdmtn.setCmNewContents(cpSysprm.getSpNextProcessingDate());
			
			intSeqNo =intSeqNo+1;
			
			cpCrdmtnMapper.insertCpCrdmtn(cpCrdmtn);
			
			//cp_ceptrx
			CpCeptrx cpCeptrx=new CpCeptrx();
			cpCeptrx.setCtBranchId(cpCrdtbl.getCbCentreCd());
			Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
			cpCeptrx.setCtTranId(tranId);

			//start 主键流水messageId
			/*BigDecimal seqname = sequenceMapper.searchSerialToName();
			if(seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
				sequenceMapper.truncateSerial();
			}*/
			BigDecimal messageid;
			messageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
			cpCeptrx.setCtMessageId(messageid.longValue());
			cpCeptrx.setCtCardNumber(cbCardholderNo);
//			cpCeptrx.setCtTranTime(getNowDate("HHmmss"));
			cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
			cpCeptrx.setCtDbCr("C");
			cpCeptrx.setCtTranAmount(BigDecimal.ZERO);
			cpCeptrx.setCtCardAmount(cpCeptrx.getCtTranAmount());
			cpCeptrx.setCtDescription("互联网取卡");
			cpCeptrx.setCtCurrcode("156");
			cpCeptrx.setCtApproveTime(getNowDate("yyyyMMddHHmmss"));
			cpCeptrx.setCtPostTime(cpSysprm.getSpNextProcessingDate());
//			cpCeptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
			cpCeptrx.setCtAccountId(cpCrdtbl.getCbIndividualAcctno());
			cpCeptrx.setCtTranCode("SPOTCARD");
			cpCeptrx.setCtTxrnType("C");
			cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
			cpCeptrx.setCtBillCurrAmt(cpCeptrx.getCtTranAmount());
			cpCeptrx.setCtAgeCodeB4Post("00");
			cpCeptrx.setCtAgeCodeAfterPost("00");
			cpCeptrx.setCtReversalFlag("0");
			cpCeptrx.setCtOutstdB4Post(new BigDecimal(0));
//			cpCeptrx.setCtOutstdAfterPost(cpIndacc.getCbOutstdBal());
			cpCeptrx.setCtOutstdAfterPost(new BigDecimal(0));
			cpCeptrx.setCtUserCreate(staffId);
			cpCeptrx.setCtStatus("0");
			cpCeptrx.setCtDc("0");
			cpCeptrx.setCtTranNum("1");
			cpCeptrx.setCtTranZone("0");
			cpCeptrx.setCtOpenZone("0");
//			cpCeptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
			cpCeptrx.setCtCustomerId(custNo);
			cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
			
			this.cpticketdanrenadd(cpCrdtbl,cpCsttbl,orderId);
			
			return StatusResult.create(messageid+"");
		}else{
			return StatusResult.create("FALSE","无效卡号");
		}
		
	}
	
	
	/**
	 * 互联网检查卡号
	 * @param cardno 卡号
	 * 
	 * @param  cardno
	 * @author Hugh
	 */
	public boolean checkcardnoInter(String cardno){
		boolean exist = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("cbCardholderNo", cardno);
		params.put("cbPlasticCd", "P");
		List<CpCrdtbl> cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByParams(params);
		int i=0;
		if(null!=cpCrdtbl){
			i=cpCrdtbl.size();
		}
		if(i>0)
			exist=true;
			return exist;
	}
	
	public boolean seachCpCrd(String idNo){
		boolean falg=false;
		Map<String, String> map=new HashMap<>();
		map.put("cbIdno", idNo);
		map.put("cbPlasticCd", "U");
		List<CpCrdtbl> crd=cpCrdtblMapper.searchCpCrdtblByParams(map);
		System.out.println("crd:"+crd);
		if(crd.size()<=0){
			falg = true;
		}
		return falg; 
	}
	
	/**
	 * 预售开卡检查用户
	 * @param idNo
	 * @return
	 */
	public boolean seachCpCsttbl(String idNo){
		boolean flag=false;
		CpCsttbl csttbl=cpCsttblMapper.searchCpCsttblByCbCustomerIdno(idNo);
		if(null != csttbl){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 卡和票劵绑定
	 * @param tktypeStr				票劵ID
	 * @param cpcrdtbl				会员对象
	 * @param cpcsttbl				卡对象
	 * @return
	 */
	@Transactional
	public StatusResult<String> cpticketdanrenadd(CpCrdtbl cpcrdtbl,CpCsttbl cpcsttbl,String orderId){
		System.out.println("_______________________进人会员票劵绑卡方法_______________________");
		Long return_cpticket = 0L;
		Long return_cpceptrx =0L;
		if(StringUtils.isEmpty(orderId)){
			return StatusResult.create("FALSE", "票劵ID为空");
		}
		CpIndacc cpindacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpcrdtbl.getCbIndividualAcctno());
		if(StringUtils.isEmpty(cpindacc)){
			return StatusResult.create("FALSE", "没有找到对应的账户");
		}
		YwOrderitem orderitem =yworderitemMapper.searchYwOrderitemByHwOrderitemId(orderId);
		if(StringUtils.isEmpty(orderitem)){
			return StatusResult.create("FALSE", "票劵ID未找到,请查看是否有误");
		}
		CpTicket cpticket=new CpTicket();
		//添加流水信息（CP_TICKET）
		cpticket.setTkTicketId(Long.valueOf(orderId));
		//卡号
		cpticket.setTkCardNo(cpcrdtbl.getCbCardholderNo());
		cpticket.setTkTicketType(Long.valueOf(orderitem.getHwProdctGroup()));
		cpticket.setTkEffectiveDate(orderitem.getHwAdmissionTime());
		cpticket.setTkExpireDate(orderitem.getHwEndTime());
		cpticket.setTkStatus("T");
		//票和卡绑定
		return_cpticket = cpTicketMapper.insertCpTicket(cpticket);
		orderitem.setHwStatus("U");
		yworderitemMapper.updateYwOrderitem(orderitem);
		if(return_cpticket <= 0){
			return StatusResult.create("FALSE", "票劵和会员绑定失败");				
		}
		
		BigDecimal balance = new BigDecimal(0);

		CpCeptrx cpceptrx1=new CpCeptrx();
		cpceptrx1.setCtBranchId(cpcrdtbl.getCbCentreCd());
		cpceptrx1.setCtTranId(Long.parseLong(automaticgrowthService.sqlNextVal("APNONSSEQ")));
		cpceptrx1.setCtMessageId(Long.parseLong(automaticgrowthService.nextSerial()));
		cpceptrx1.setCtCustomerId(cpcsttbl.getCbMemberCode());
		cpceptrx1.setCtCardNumber(cpcrdtbl.getCbCardholderNo());//卡号
//		cpceptrx1.setCtTranTime(DateTimes.nowTimestamp());//开卡时间
		cpceptrx1.setCtTranTime(DateTimes.nowDateTime());//开卡时间
		cpceptrx1.setCtDbCr("C");
		cpceptrx1.setCtDescription("绑票");  
		cpceptrx1.setCtTranAmount(BigDecimal.ZERO);
		cpceptrx1.setCtApproveTime(DateTimes.nowTimestamp());
		cpceptrx1.setCtPostTime(automaticgrowthService.getPostTime());
		cpceptrx1.setCtAccountId(cpindacc.getCbIndividualAcctno());//账号id
		cpceptrx1.setCtTranCode("KIDTICKET");
		cpceptrx1.setCtTxrnType("C");
		cpceptrx1.setCtUserStatus1(cpticket.getTkTicketId().toString());//票号
		cpceptrx1.setCtUserStatus2(""+cpticket.getTkTicketType().toString());//票类别
		cpceptrx1.setCtUserStatus3("I");
		cpceptrx1.setCtBillCurrCd(Long.parseLong("156"));
		cpceptrx1.setCtAgeCodeB4Post("00");
		cpceptrx1.setCtAgeCodeAfterPost("00");
		cpceptrx1.setCtReversalFlag("0");
		cpceptrx1.setCtOutstdB4Post(balance);
		cpceptrx1.setCtOutstdAfterPost(cpindacc.getCbOutstdBal());
		cpceptrx1.setCtUserCreate("System");
		cpceptrx1.setCtStatus("0");
		cpceptrx1.setCtDc("0");
		cpceptrx1.setCtTranNum("1");
		cpceptrx1.setCtTranZone("0");
		cpceptrx1.setCtOpenZone("0");
		cpceptrx1.setCtCustomerId(cpindacc.getCbCustomerId());
		cpceptrx1.setCtDisputeDate(DateTimes.nowDate());
		
		return_cpceptrx = cpCeptrxMapper.insertCpCeptrx(cpceptrx1);	
		if(return_cpceptrx <=0){
			return StatusResult.create("FALSE", "添加购票流水记录失败");
		}
		return StatusResult.create("OK","卡和票劵绑定成功");
	}
	
	
	/**
	 * 柜台充值
	 * 
	 * @param cardNo 卡号
	 * @param amount
	 * @param type
	 * @param desc
	 * @param staffId
	 * 
	 * @author Hugh
	 */
	public StatusResult<List<String>> doCharge(String moneyReceived,String cashChange,String cardNo,String amount,String type,String desc,String staffId) throws Exception{

		BigDecimal ac_amount = new BigDecimal(amount);
		List<String> list = new ArrayList<String>();
		BigDecimal messageid = null;
		
		
		CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
		if(null==cpCrdtbl){
			return StatusResult.create("FALSE", "卡号不存在");
		}
		if("L".equals(cpCrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "挂失卡不能充值");
		}else if("D".equals(cpCrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "已销卡不能充值");
		}

		
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("cbIdType", cpCrdtbl.getCbIdType());
//		params.put("cbCustomerIdno", cpCrdtbl.getCbIdno());
//		List<CpCsttbl> cpCsttbl=cpCsttblMapper.searchCpCsttblByParams(params);
		
//		if(null==cpCsttbl || cpCsttbl.size()<=0){
//			return StatusResult.create("FALSE", "客户不存在");
//		}
		
		if(!"U".equals(cpCrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "该卡未绑定用户");
		}
		
		CpIndacc cpIndacc=cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
		if(null==cpIndacc){
			return StatusResult.create("FALSE", "账户不存在");
		}	
		BigDecimal balance = BigDecimal.ZERO;
		balance = cpIndacc.getCbOutstdBal();
		if(null==cpIndacc.getCbOutstdBal()){
			cpIndacc.setCbOutstdBal(ac_amount);
		}else{
			cpIndacc.setCbOutstdBal(cpIndacc.getCbOutstdBal().add(ac_amount));
		}
		// cpIndacc.setCbFeeWaiverSpend(cpIndacc.getCbFeeWaiverSpend().add(ac_amount));
		cpIndaccMapper.updateCpIndacc(cpIndacc);
		

		CpCeptrx cpCeptrx = new CpCeptrx();
		cpCeptrx.setCtBranchId(cpCrdtbl.getCbCentreCd());
		
		Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
		cpCeptrx.setCtTranId(tranId);
		
		//start 主键流水messageId
		/*BigDecimal seqname = sequenceMapper.searchSerialToName();
		if(seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
			sequenceMapper.truncateSerial();
		}*/
		messageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
		//end
				
		cpCeptrx.setCtMessageId(messageid.longValue());
		cpCeptrx.setCtCardNumber(cardNo);
//		cpCeptrx.setCtTranTime(getNowDate("HHmmss"));
		cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
		cpCeptrx.setCtDbCr("C");
		cpCeptrx.setCtTranAmount(ac_amount.negate());
		cpCeptrx.setCtCardAmount(ac_amount);
		
//		实收金额
		cpCeptrx.setCtFeeAmount(new BigDecimal(moneyReceived));
//		找零
		cpCeptrx.setCtVatAmount(new BigDecimal(cashChange));
		cpCeptrx.setCtDescription(desc);
		cpCeptrx.setCtCurrcode("156");
		cpCeptrx.setCtApproveTime(getNowDate("yyyyMMddHHmmss"));
		//cpCeptrx.setCtPostTime(null);
		cpCeptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
		cpCeptrx.setCtTranCode(type);
		cpCeptrx.setCtTxrnType("C");
		cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
		cpCeptrx.setCtBillCurrAmt(ac_amount);
		cpCeptrx.setCtAgeCodeB4Post("00");
		cpCeptrx.setCtAgeCodeAfterPost("00");
		cpCeptrx.setCtReversalFlag("0");
		cpCeptrx.setCtOutstdB4Post(balance);
		cpCeptrx.setCtOutstdAfterPost(cpIndacc.getCbOutstdBal());
		cpCeptrx.setCtUserCreate(staffId);
		cpCeptrx.setCtStatus("0");
		cpCeptrx.setCtDc("0");
		cpCeptrx.setCtTranNum("1");
		cpCeptrx.setCtTranZone("0");
		cpCeptrx.setCtOpenZone("0");
		cpCeptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
		cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
		
		list.add(messageid+"");
		return StatusResult.create(list);
	}
	public StatusResult<List<String>> doCharge(String cardNo,String amount,String type,String desc,String staffId) throws Exception{

		BigDecimal ac_amount = new BigDecimal(amount);
		List<String> list = new ArrayList<String>();
		BigDecimal messageid = null;
		
		
		CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
		if(null==cpCrdtbl){
			return StatusResult.create("FALSE", "卡号不存在");
		}
		if("L".equals(cpCrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "挂失卡不能充值");
		}else if("D".equals(cpCrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "已销卡不能充值");
		}

		
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("cbIdType", cpCrdtbl.getCbIdType());
//		params.put("cbCustomerIdno", cpCrdtbl.getCbIdno());
//		List<CpCsttbl> cpCsttbl=cpCsttblMapper.searchCpCsttblByParams(params);
		
//		if(null==cpCsttbl || cpCsttbl.size()<=0){
//			return StatusResult.create("FALSE", "客户不存在");
//		}
		
		if(!"U".equals(cpCrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "该卡未绑定用户");
		}
		
		CpIndacc cpIndacc=cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
		if(null==cpIndacc){
			return StatusResult.create("FALSE", "账户不存在");
		}	
		BigDecimal balance = BigDecimal.ZERO;
		balance = cpIndacc.getCbOutstdBal();
		if(null==cpIndacc.getCbOutstdBal()){
			cpIndacc.setCbOutstdBal(ac_amount);
		}else{
			cpIndacc.setCbOutstdBal(cpIndacc.getCbOutstdBal().add(ac_amount));
		}
		// cpIndacc.setCbFeeWaiverSpend(cpIndacc.getCbFeeWaiverSpend().add(ac_amount));
		cpIndaccMapper.updateCpIndacc(cpIndacc);
		

		CpCeptrx cpCeptrx = new CpCeptrx();
		cpCeptrx.setCtBranchId(cpCrdtbl.getCbCentreCd());
		
		Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
		cpCeptrx.setCtTranId(tranId);
		
		//start 主键流水messageId
		/*BigDecimal seqname = sequenceMapper.searchSerialToName();
		if(seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
			sequenceMapper.truncateSerial();
		}*/
		messageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
		//end
				
		cpCeptrx.setCtMessageId(messageid.longValue());
		cpCeptrx.setCtCardNumber(cardNo);
//		cpCeptrx.setCtTranTime(getNowDate("HHmmss"));
		cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
		cpCeptrx.setCtDbCr("C");
		cpCeptrx.setCtTranAmount(ac_amount.negate());
		cpCeptrx.setCtCardAmount(ac_amount);
		

		cpCeptrx.setCtDescription(desc);
		cpCeptrx.setCtCurrcode("156");
		cpCeptrx.setCtApproveTime(getNowDate("yyyyMMddHHmmss"));
		//cpCeptrx.setCtPostTime(null);
		cpCeptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
		cpCeptrx.setCtTranCode(type);
		cpCeptrx.setCtTxrnType("C");
		cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
		cpCeptrx.setCtBillCurrAmt(ac_amount);
		cpCeptrx.setCtAgeCodeB4Post("00");
		cpCeptrx.setCtAgeCodeAfterPost("00");
		cpCeptrx.setCtReversalFlag("0");
		cpCeptrx.setCtOutstdB4Post(balance);
		cpCeptrx.setCtOutstdAfterPost(cpIndacc.getCbOutstdBal());
		cpCeptrx.setCtUserCreate(staffId);
		cpCeptrx.setCtStatus("0");
		cpCeptrx.setCtDc("0");
		cpCeptrx.setCtTranNum("1");
		cpCeptrx.setCtTranZone("0");
		cpCeptrx.setCtOpenZone("0");
		cpCeptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
		cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
		
		list.add(messageid+"");
		return StatusResult.create(list);
	}
	
	/**
	 * 补卡
	 * 
	 * 
	 * @author yanjy
	 */
	public StatusResult<String> doCheckerApprove(String cbIdType,String cbIdno,String oldCbCardholderNo,String cbOutstdBal,String cbEmbossname,String cbSuspendDate,String cbSourceCd,String cbCardPrdctGroup,String newCbCardholderNo,String newCbCardPrdctGroup,String cbCvki,TSysStaff currentStaff){
		StatusResult<String> rtn = null;
		
		rtn = onMakerSave(oldCbCardholderNo,newCbCardholderNo,currentStaff);
		if(rtn!=null)	return rtn;
		//String trxnCode = "SUPPL";trxnCode为SUPPL时执行checkAllowCards方法
		
		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCbCardholderNo);
		
		Map<String, String> cpCsttblParams = new HashMap<>();
		cpCsttblParams.put("cbIdType", cbIdType);
		cpCsttblParams.put("cbCustomerIdno", cbIdno);
		List<CpCsttbl> cpCsttbls = cpCsttblMapper.searchCpCsttblByParams(cpCsttblParams);
		
		//判断账户是否存在
		CpIndacc cpIndacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
		if(cpIndacc==null){
			return StatusResult.create("ACCOUNT_DOES_NOT_EXIST", "账户不存在");
		}
		
		rtn = chkCardNumLength(newCbCardholderNo);
		if(rtn!=null)return rtn;
		rtn = chkValid(oldCbCardholderNo, newCbCardholderNo);
		if(rtn!=null)return rtn;
		rtn = checkPlasticCd(oldCbCardholderNo, newCbCardholderNo);
		if(rtn!=null)return rtn;
//			rtn = openHCard("0", newCbCardholderNo, cbIdType, cbIdno, "", cbEmbossname, cbSourceCd, newCbCardPrdctGroup, cbSuspendDate, currentStaff.getId());
//			if(rtn.isError())return rtn;
//			messageid = rtn.getValue();
		
		//newCard
		
		//换卡时激活新卡
//			CpCrdtbl newCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(newCbCardholderNo);
//			if(newCrdtbl!=null){
//				//doCardActivate控件
//			}
		//为了修复挂失换卡时的押金字段不取原来卡上的押金 实际为页面输入的押金
		updateCRDTBL(oldCbCardholderNo, newCbCardholderNo,cbCardPrdctGroup, newCbCardPrdctGroup,cbCvki,currentStaff);
		
		//跟着“APNONSSEQ”查函数nextval，set账务流水表里的CT_TRAN_ID
		Long ctTranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");
		
		//查询serial表，nextserial函数，set账务流水表里的CT_MESSAGE_ID
		BigDecimal name = sequenceMapper.searchSerialToName();
		if(name.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
			sequenceMapper.truncateSerial();
		}
		BigDecimal bmessageid = sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
		
		List<CpSysprm> cpSysprms = cpSysprmMapper.searchCpSysprmByParams(null);
		
		CpCeptrx ceptrx = new CpCeptrx();
		ceptrx.setCtBranchId(cpCrdtbl.getCbCentreCd());
		ceptrx.setCtTranId(ctTranId);
		ceptrx.setCtMessageId(Long.parseLong(bmessageid.toString()));
		ceptrx.setCtCustomerId(cpCsttbls.get(0).getCbCustomerRefNo());
		ceptrx.setCtCardNumber(oldCbCardholderNo);
//		ceptrx.setCtTranTime(SysDateFormat.getNowDate("HHmmss"));
		ceptrx.setCtTranTime(DateTimes.nowDateTime());
		ceptrx.setCtDbCr("C");
		ceptrx.setCtTranAmount(BigDecimal.ZERO);
		ceptrx.setCtCardAmount(ceptrx.getCtTranAmount());
		ceptrx.setCtDescription("挂失补卡");
		ceptrx.setCtCurrcode("156");
		ceptrx.setCtApproveTime(SysDateFormat.getNowDate("yyyyMMddHHmmss"));
		ceptrx.setCtPostTime(cpSysprms.get(0).getSpNextProcessingDate());
		ceptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
		ceptrx.setCtTranCode("SUPPL");
		ceptrx.setCtTxrnType("C");
		ceptrx.setCtBillCurrCd(new BigDecimal("156").longValue());
		ceptrx.setCtBillCurrAmt(BigDecimal.ZERO);
		ceptrx.setCtAgeCodeB4Post("00");
		ceptrx.setCtAgeCodeAfterPost("00");
		ceptrx.setCtReversalFlag("0");
		ceptrx.setCtOutstdB4Post(cpIndacc.getCbOutstdBal());
		ceptrx.setCtOutstdAfterPost(BigDecimal.ZERO);
		ceptrx.setCtUserCreate(currentStaff.getId());
		ceptrx.setCtStatus("0");
		ceptrx.setCtDc("0");
		ceptrx.setCtTranNum("1");
		ceptrx.setCtTranZone("0");
		ceptrx.setCtOpenZone("0");
		ceptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
		cpCeptrxMapper.insertCpCeptrx(ceptrx);
		
		return rtn;
	}
	
	
	/**
	 * 补卡判断旧卡类型，卡的长度，判断持卡人号码是否在公司帐单帐户中,判断新卡类型，补卡判断分支机构对照表，用户机构对照表,访问权限，判断卡片状态
	 * 
	 * 
	 * @author yanjy
	 */
	public StatusResult<String> onMakerSave(String oldCbCardholderNo,String newCbCardholderNo,TSysStaff currentStaff){
		StatusResult<String> r = null;
		//判断旧卡类型
		r = checkPreCardType(oldCbCardholderNo);
		if(r!=null)	return r;
		
		if(newCbCardholderNo != null && !newCbCardholderNo.trim().equals("")){
			//卡的长度，判断持卡人号码是否在公司帐单帐户中
			r = chkCardNumLength(newCbCardholderNo);
			if(r!=null)	return r;
			r = chkValid(oldCbCardholderNo,newCbCardholderNo);
			if(r!=null)	return r;
			//补卡判断分支机构对照表，用户机构对照表,访问权限
			CpCrdtbl oldcpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCbCardholderNo);
			if(oldcpCrdtbl!=null){
				String strBranchId = oldcpCrdtbl.getCbCentreCd();
				if(!checkBranchAccess(currentStaff.getId(),strBranchId)){
					return StatusResult.create("ERRUNAUTHOLD","用户无旧卡数据访问权限");
				}
			}
			CpCrdtbl newcpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(newCbCardholderNo);
			if(newcpCrdtbl!=null){
				String strBranchId = newcpCrdtbl.getCbCentreCd();
				if(!checkBranchAccess(currentStaff.getId(),strBranchId)){
					return StatusResult.create("ERRUNAUTHOLD","用户无新卡数据访问权限");
				}
			}
		}else{
			newCbCardholderNo = "";
		}
		//判断卡片状态
		r = checkPlasticCd(oldCbCardholderNo, newCbCardholderNo);
		if(r!=null)	return r;
		return r;
	}
	
	
	/**
	 * 卡的长度
	 * 
	 * 
	 * @author yanjy
	 */
	public StatusResult<String> chkCardNumLength(String newCbCardholderNo){
		Map<String, String> cpPrdgrpParams = new HashMap<>();
		cpPrdgrpParams.put("prBin", newCbCardholderNo.substring(0,6));
		List<CpPrdgrp> cpPrdgrps = cpPrdgrpMapper.searchCpPrdgrpByParams(cpPrdgrpParams);
		if(cpPrdgrps.size()!=0){
			if(cpPrdgrps.get(0).getPrCardholderNoLen().intValue() != newCbCardholderNo.length()){
				return StatusResult.create("ERRCRDNUMLENGTH","持卡人号码长度与产品组中的不匹配");
			}
		}else{return StatusResult.create("ERRCRDNUMLENGTH","未找到该产品代码！");}
		return null;
	}
	
	
	/**
	 * 判断持卡人号码是否在公司帐单帐户中
	 * 
	 * 
	 * @author yanjy
	 */
	public StatusResult<String> chkValid(String oldCbCardholderNo,String newCbCardholderNo){
		Map<String, String> cpCopmstParams = new HashMap<>();
		cpCopmstParams.put("coBillCardholderNo", newCbCardholderNo);
		List<CpCopmst> cpCopmsts = cpCopmstMapper.searchCpCopmstByParams(cpCopmstParams);
		if(cpCopmsts.size()!=0){
			return StatusResult.create("CHKVALID","持卡人号码已在公司帐单帐户中");
		}
		/*String rnReason = "AR";
		if(rnReason!=null&&(!rnReason.equals(""))){
			if (rnReason.equals("LC") || rnReason.equals("SC")
					|| rnReason.equals("FC") || rnReason.equals("UC")
					|| rnReason.equals("RI") || rnReason.equals("NR")
					|| rnReason.equals("DC")) {
				if(oldCbCardholderNo.equals(newCbCardholderNo)){
					return "换卡原因为LC, SC, FC, UC, RI, NR, DC不允许补卡";
				}
			}
		}*/
		return null;
	}
	
	
	/**
	 * 判断卡片状态
	 * 
	 * 
	 * @author yanjy
	 */
	public StatusResult<String> checkPlasticCd(String oldCbCardholderNo,String newCbCardholderNo){
		CpCrdtbl oldcpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCbCardholderNo);
		String plasticCd = oldcpCrdtbl.getCbPlasticCd();
		if (plasticCd == null)
			plasticCd = "";
		if("D".equals(plasticCd)){
			return StatusResult.create("PRECARDREPLACE_D","已销卡不能换卡");
		}
		if(oldCbCardholderNo.equals(newCbCardholderNo)){
			if(!"".equals(plasticCd.trim())){
				return StatusResult.create("CANNOTREISSUE","不能续卡");
			}
		}
		return null;
	}
	
	
	/**
	 * 为了修复挂失换卡时的押金字段不取原来卡上的押金 实际为页面输入的押金
	 * 
	 * 
	 * @author yanjy
	 */
	public void updateCRDTBL(String oldCbCardholderNo,String newCbCardholderNo,String cbCardPrdctGroup,String newCbCardPrdctGroup,String cbCvki,TSysStaff currentStaff){
		String strRnThruYY = "00";
		
		CpPrdgrp cpPrdgrp = new CpPrdgrp();
		//CpCrdtbl newcpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(newCbCardholderNo);
		String strExpireDate = "";
		//cpCrdtblMapper.deleteCpCrdtblByCbCardholderNo(newCbCardholderNo);
		
		CpCrdtbl oldcpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCbCardholderNo);
		System.out.println(oldCbCardholderNo+"换"+newCbCardholderNo);
		
		//cp_crdtbl 旧卡不要删除 ， 设置cb_plastic_date =当日 且 cp_plastic_cd ='D'
		CpCrdtbl cpCrdtbl = new CpCrdtbl();
		cpCrdtbl.setCbPlasticDate(SysDateFormat.getNowDate("yyyyMMdd"));
		cpCrdtbl.setCbPlasticCd("D");
		cpCrdtbl.setCbCvki(Integer.parseInt(cbCvki));
		cpCrdtbl.setCbCardholderNo(oldCbCardholderNo);
		cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
		
		CpBlkmlc cpBlkmlc = new CpBlkmlc();
		cpBlkmlc.setBmCardNo(oldCbCardholderNo.substring(10));
		cpBlkmlc.setBmReasonCode("D");
		cpBlkmlc.setBmOrgId(currentStaff.getId());
		cpBlkmlc.setBmInTime(SysDateFormat.getNowDate("yyyyMMdd"));
		cpBlkmlc.setBmCardName(oldcpCrdtbl.getCbEmbossname());
		cpBlkmlc.setBmProductCode(BigDecimal.ZERO.longValue());
		cpBlkmlc.setBmBlack("Y");
		CpBlkmlc cpBlkmlcs = cpblkmlcMapper.searchCpBlkmlcByBmCardNo(cpBlkmlc.getBmCardNo());
		if(cpBlkmlcs==null){
			cpblkmlcMapper.insertCpBlkmlc(cpBlkmlc);
		}
		
		//产品组用新卡的
		oldcpCrdtbl.setCbCardPrdctGroup(Integer.parseInt(newCbCardPrdctGroup));
		oldcpCrdtbl.setCbCifFlag("C");
		oldcpCrdtbl.setCbDcmsFlag("C");;
		oldcpCrdtbl.setCbCafRefreshFlag("Y");
		
		cpPrdgrp = cpPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(newCbCardPrdctGroup));
		String sActivationFg = cpPrdgrp.getPrReplcCardActivation();
		if(sActivationFg != null && sActivationFg.equalsIgnoreCase("Y")){
			oldcpCrdtbl.setCbNewPlasticCd("U");
			oldcpCrdtbl.setCbNewExpiryCcyymm("20"+strRnThruYY+oldcpCrdtbl.getCbExpiryCcyymm().substring(4, 6));
		}else{
			oldcpCrdtbl.setCbPlasticCd(" ");
			oldcpCrdtbl.setCbNewPlasticCd(" ");
			oldcpCrdtbl.setCbPlasticDate(" ");
			oldcpCrdtbl.setCbExpiryCcyymm(strExpireDate);
			oldcpCrdtbl.setCbNewExpiryCcyymm(" ");
		}
		oldcpCrdtbl.setCbNewPlasticDate(" ");
		oldcpCrdtbl.setCbFirstUseInd(" ");
		oldcpCrdtbl.setCbFirstUseDate(" ");
		oldcpCrdtbl.setCbFirstUseTime(" ");
		oldcpCrdtbl.setCbCardholderNo(newCbCardholderNo);
		oldcpCrdtbl.setCbPinOffset("000000FFFFFF");
		cpCrdtblMapper.insertCpCrdtbl(oldcpCrdtbl);

		Map<String, String> ucpIndaccParams = new HashMap<>();
		ucpIndaccParams.put("cbIndCardholderNoCondition", oldCbCardholderNo);
		ucpIndaccParams.put("cbProductCdCondition", cbCardPrdctGroup);
		ucpIndaccParams.put("cbIndCardholderNo", newCbCardholderNo);
		ucpIndaccParams.put("cbProductCd", newCbCardPrdctGroup);
		
		cpIndaccMapper.updateCpIndaccByParams(ucpIndaccParams);
	}
	/**
	 * 判断旧卡类型
	 * 
	 * 
	 * @author yanjy
	 */
	public StatusResult<String> checkPreCardType(String oldCbCardholderNo){
		CpCrdtbl oldCcpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(oldCbCardholderNo);
		if(oldCcpCrdtbl!=null){
			if(oldCcpCrdtbl.getCbIdType().equals("P")){
				return StatusResult.create("PRECARD","预制卡不允许做该交易");
			}
		}else{return StatusResult.create("NOCARD","旧卡不存在");}
		return null;
	}
	
	
	/**
	 * 卡类型(获取秘钥)
	 * 
	 * @param  cpCrdtbl
	 * 
	 * @author Hugh
	 */
	public StatusResult<List<String>> getCardtype(CpCrdtbl cpCrdtbl){
		String cardtype="";
		List<String> list = new ArrayList<String>();
		if(null!=cpCrdtbl){
			cardtype = cpCrdtbl.getCbCardPrdctGroup().toString();
			list.add(cardtype);
		}else{
			return StatusResult.create("FALSE","系统中未找到卡号");
		}
		return StatusResult.create(list);
	}
	
	
	
	/**
	 * 卡片上送余额查询
	 * @param cardno
	 * @return
	 */
	public StatusResult<String> getWviBalance(CpCrdtbl cpCrdtbl) {
		
		if(null!=cpCrdtbl){
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbIndCardholderNo", cpCrdtbl.getCbCardholderNo());
			params.put("cbIndividualAcctType", BigDecimal.ONE+"");
			params.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
			List<CpIndacc> list=cpIndaccMapper.searchCpIndaccByParams(params);
			if(null!=list && list.size()>0){
				return StatusResult.create(list.get(0).getCbFeeWaiverSpend().toString());
			}else{
				return StatusResult.create("FAILE","帐号不存在");
			}
		}else{
			return StatusResult.create("FAILE","帐号不存在");
		}
	}
	
	
	/**
	 * 
	 * 余额查询
	 * @param cardno
	 * @return
	 */
	public StatusResult<String> getBalance(CpCrdtbl cpCrdtbl){
		
		if(null!=cpCrdtbl){
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbIndCardholderNo", cpCrdtbl.getCbCardholderNo());
			params.put("cbIndividualAcctType", BigDecimal.ONE+"");
			params.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
			List<CpIndacc> list=cpIndaccMapper.searchCpIndaccByParams(params);
			if(null!=list && list.size()>0){
				return StatusResult.create(list.get(0).getCbOutstdBal().toString());
			}else{
				return StatusResult.create("FAILE","账号不存在");
			}
		}else{
			return StatusResult.create("FAILE","卡号不存在");
		}
	}
	
	
	/**
	 * 补卡判断分支机构对照表，用户机构对照表
	 * 
	 * 
	 * @author yanjy
	 */
	public boolean checkBranchAccess(String userID, String toAccessBranchID){
		AclUserBrchsetMap aclUserBrchsetMap = new AclUserBrchsetMap();
		if(toAccessBranchID==null||toAccessBranchID.matches("")){
			return false;
		}
		if(userID==null||userID.matches("")){
			return false;
		}
		aclUserBrchsetMap = aclUserBrchsetMapMapper.searchAclUserBrchsetMapByUserId(userID);
		if (aclUserBrchsetMap==null) {
			return false;
		}

		if (aclUserBrchsetMap.getBranchSetId() == null) {
			return false;
		}
		
		Map<String, String> aclBrchsetBrchMapParams = new HashMap<>();
		aclBrchsetBrchMapParams.put("branchSetId", aclUserBrchsetMap.getBranchSetId());
		aclBrchsetBrchMapParams.put("branchId", toAccessBranchID);
		List<AclBrchsetBrchMap> aclBrchsetBrchMap = aclBrchsetBrchMapMapper.searchAclBrchsetBrchMapByParams(aclBrchsetBrchMapParams);
		if(aclBrchsetBrchMap!=null){
			return true;
		}
		return false;
	}
	
	/**
	 * 显示所有卡信息
	 * 
	 * @author mason
	 */
	public Result<PageInfo<CpCrdtbl>> lists(final String id, final String name, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(id)) {
			params.put("cbCardholderNo", id);
		}
		if (StringUtils.hasText(name)) {
			params.put("cbEmbossname", name);
		}
		params.put("cbPlasticCd", "U");
		System.out.println("-----param:"+params);
		List<CpCrdtbl> page = cpCrdtblMapper.searchCpCrdtblByParams(params, pageBounds);
		return Result.create(new PageInfo<CpCrdtbl>(page));
	}
	
	public List<CpCrdtbl> crdtblList() {
        return cpCrdtblMapper.searchCpCrdtblByParams(null);
    }
	
	
	/**
	 * 柜台购票获取卡获取记录
	 * 
	 * @param cardNo
	 * @param idNo
	 * @return List<CpCrdtbl>
	 * 
	 * @author Hugh
	 */
	public List<CpCrdtbl> crdtblAllList(String cardNo, String idNo) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cardNo)) {
			params.put("cbCardholderNo", cardNo);
		}
		if (StringUtils.hasText(idNo)) {
			params.put("cbIdno", cardNo);
		}
		return cpCrdtblMapper.searchCpCrdtblByParams(params);
	}
	
	
	/**
	 * 柜台购票读卡获取卡记录
	 * 
	 * @param cardNumber
	 * 
	 * @author Hugh
	 */
	public CpCrdtbl getCrdtbl(String cardNumber){
		CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNumber);
		return cpCrdtbl;
	}
	
	public CpCrdtbl getCrdtblByRwdsAccnoAndUsing(String rwdsAccno){
		Map<String, String> param = new HashMap<>();
		param.put("cbRwdsAccno", rwdsAccno);
		param.put("cbPlasticCd", "U");
		List<CpCrdtbl> list = cpCrdtblMapper.searchCpCrdtblByParams(param);
		if(list.size() <= 0){
			 throw new RuntimeException("查询数据为空!");
		}
		if(list.size() > 1)
			throw new RuntimeException("在用物理卡号重复!");
		return list.get(0);
	}
	
	
	/**
	 * 柜台挂失获取卡记录
	 * 
	 * @param idType
	 * @param idNo
	 * 
	 * @author Hugh
	 */
	public List getCrdtblList(String idType, String idNo,String cbPlasticCd) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(idType)) {
			params.put("cbIdType", idType);
		}
		if (StringUtils.hasText(idNo)) {
			params.put("cbIdno", idNo);
		}
		if (StringUtils.hasText(idNo)) {
			params.put("cbPlasticCd", cbPlasticCd);
		}
		
		List<CpCrdtbl> crdtblList = cpCrdtblMapper.searchCpCrdtblByParams(params);
		return crdtblList;
	}
	
	/**
	 * 会员提现获取卡面号
	 * 
	 * @param idType
	 * @param idNo
	 * 
	 * @author tanqingwen
	 */
	public List<CpCrdtbl> getCbRecommenderNo(String idType, String idNo) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(idType)) {
			params.put("cbIdType", idType);
		}
		if (StringUtils.hasText(idNo)) {
			params.put("cbIdno", idNo);
		}
		params.put("cbPlasticCd", "U");
		List<CpCrdtbl> crdtblList = cpCrdtblMapper.searchCpCrdtblByParams(params);
		return crdtblList;
	}
	
	
	/**
	 * 柜台购票获取卡信息记录
	 * 
	 * 证件类型,证件号码,姓名,卡类型,手机,出生日期,押金,状态
	 *
	 * @param cpCrdtbl
	 * 
	 * @author Hugh
	 */
	public String[] getCardInfo(CpCrdtbl cpCrdtbl) {
		
		if(null!=cpCrdtbl){
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
			List<CpIndacc> list=cpIndaccMapper.searchCpIndaccByParams(params);
			String cb_outstd_bal="";
			if(null!=list &&  list.size()>0){
				cb_outstd_bal=list.get(0).getCbOutstdBal()+"";
				if("null".equals(cb_outstd_bal)){
					cb_outstd_bal="";
				}
			}
			return new String[]{
					cpCrdtbl.getCbIdType(),
					cpCrdtbl.getCbIdno(),
					cpCrdtbl.getCbEmbossname(),
					cpCrdtbl.getCbCardPrdctGroup().toString(),
					cpCrdtbl.getCbSourceCd(),
					cpCrdtbl.getCbSuspendDate(),
					cpCrdtbl.getCbCvki().toString(),
					cpCrdtbl.getCbPlasticCd()+"-"+StringUtil.checkNull(PlasticCdStat.cardStatus.get(cpCrdtbl.getCbPlasticCd()))+"卡",
					cb_outstd_bal
			};
		}else{
			return null;
		}
	}
	
	public static String getNowDate(String strDateFormat){
	    if (strDateFormat==null) 
	    	return "";
         	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(strDateFormat);
            java.util.Date currentTime = new java.util.Date();
            return formatter.format(currentTime).toString();
    }
	
	
	public String[] getCardInfo1(String cardNo) {
		
		CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
		if(null!=cpCrdtbl){
			CpIndacc indacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
			return new String[]{
				cpCrdtbl.getCbIdType(),
				cpCrdtbl.getCbIdno(),
				cpCrdtbl.getCbEmbossname(),
				cpCrdtbl.getCbCardPrdctGroup().toString(),
				cpCrdtbl.getCbSourceCd(),
				cpCrdtbl.getCbSuspendDate(),
				cpCrdtbl.getCbCvki().toString(),
				cpCrdtbl.getCbPlasticCd()+"-"+StringUtil.checkNull(PlasticCdStat.cardStatus.get(cpCrdtbl.getCbPlasticCd()))+"卡",
				indacc.getCbOutstdBal().toString()
			};
		}else{
			return null;
		}
	}
	public String[] getCardInfo2(String mobile,String cbPlasticCd){
		Map<String, String> params=new HashMap<>();
		params.put("cbSourceCd", mobile);
		params.put("cbPlasticCd", cbPlasticCd);
		CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbSourceCd(params);
		if(null != cpCrdtbl){
			CpIndacc indacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
			return new String[]{
					cpCrdtbl.getCbIdType(),
					cpCrdtbl.getCbIdno(),
					cpCrdtbl.getCbEmbossname(),
					cpCrdtbl.getCbCardPrdctGroup().toString(),
					cpCrdtbl.getCbSourceCd(),
					cpCrdtbl.getCbSuspendDate(),
					cpCrdtbl.getCbCvki().toString(),
					cpCrdtbl.getCbPlasticCd()+"-"+StringUtil.checkNull(PlasticCdStat.cardStatus.get(cpCrdtbl.getCbPlasticCd()))+"卡",
					cpCrdtbl.getCbCardholderNo(),
					indacc.getCbOutstdBal().toString()
			};
		}else{
			return null;
		}
	}
	
	/**
	 * 进入登记掌静脉
	 * 
	 * @param barcode1 卡号
     * @return 登记提示信息
	 * @author Hugh
	 */
	public String[] RtnResult(String clientIp,String barcode1) {
		String []stateString = new String[2];
		barcode = barcode1;
		createDir();
		cancelEvent(clientIp);
		gatherEvent(clientIp);
		stateString[0] = rtnState;
		stateString[1] = rtnResult;
		return stateString;
	}
	
	
	/**
	 * 采集事件 写入磁盘
	 * @author Hugh
	 */
	public void createDir() {
		File dir = new File(venaProperties.getFilePath());
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
	
	
	
	/**
	 * 继续调用登记处理
	 * 
	 * @param barcode1 卡号
     * @return 继续调用处理
	 * @author Hugh
	 */
	public String[] RtnSign(String clientIp,String barcode) {
		String []stateString = new String[2];
		gatherEvent(clientIp);
		stateString[0] = rtnState;
		stateString[1] = rtnResult;
		return stateString;
	}
	
	
    
	/**
	 * 继续调用取消处理
	 * 
	 * @param barcode1 卡号
     * @return 继续调用处理
	 * @author Hugh
	 */
	public String[] RtnCancel(String clientIp,String barcode) {
		String []stateString = new String[2];
		cancelEvent(clientIp);
		stateString[0] = rtnState;
		stateString[1] = rtnResult;
		return stateString;
	}
	
	
	/**
	 * 采集事件：登记
	 * @author Hugh
	 */
	public void gatherEvent(String clientIp) {
		
		try {
			
			System.out.println("gather");
			String url = venaProperties.getSignUrl();
			url=url.replace("*.*.*.*", clientIp);
			System.out.println("获取动态IP： " + url);
			String message = String.format("{\"cardNo\":\"%s\"}", barcode);
			System.out.println(message);
			String receive = HttpPostUtil.doPost(url, message);
			ObjectMapper mapper = new ObjectMapper();
			JsonPalmView view = mapper.readValue(receive, JsonPalmView.class);
			Map<String, Object> dataMap = (Map<String, Object>) view.getCb_state();// 获取到map
			if (dataMap == null) {
				gatherEvent(clientIp);
				return;
			}
			String state = String.valueOf(view.getState());
			if (state == null || state.equals("null")) {
				gatherEvent(clientIp);
				return;
			}
			if(state.equals("success")){
				rtnResult="采集成功";
				rtnState=state;
			}
			if (state.equals("running")) {
				// TODO 正在采集的流程
				rtnResult=String.valueOf(dataMap.get("PvsMessage"));
				rtnState=state;
			}
			if(state.equals("retry")){
				rtnState=state;
			}
			if(state.equals("fail")){
				rtnState=state;
				rtnResult="采集失败";
			}
		} catch (IOException ex) {
		}
	}
	
	
	/**
	 * 采集事件：取消
	 * @author Hugh
	 */
	public void cancelEvent(String clientIp) {
		
		try {
			System.out.println("cancel");
			String url = venaProperties.getCancelUrl(); //请求url
			url=url.replace("*.*.*.*", clientIp);
			System.out.println("获取动态IP： " + url);
			String receive = HttpPostUtil.doPost(url, "{'PvsGuiState':0, 'PvsMessage':0}");
			//if (!StringUtils.isNotEmpty(receive)) {
			if(null==receive || "".equals(receive)){
				throw new Exception("网络异常，接收信息为空");
			}
			ObjectMapper mapper = new ObjectMapper();
			JsonPalmView view = mapper.readValue(receive, JsonPalmView.class);
			String state = String.valueOf(view.getState());
			if (state == null || state.equals("null")) {
				return;
			}
			if (state.equals("stop")) {
				rtnState=state;
				rtnResult="正在取消";
			}
		} catch (Exception ex) {
		}
	}
	
	
	/**
	 * 文件上传【PC-LINUX】
	 *
	 * @param myfile
	 * 
	 * @ Hugh
	 */
	public String getUploadFile(String barcode,MultipartFile myfile) {

		File target = null;
		String fileResult = "";
		try {
			if (null != myfile && !"".equals(myfile)) {
				if(!barcode.equals(myfile.getOriginalFilename())){
					return fileResult = "false";
				}	
				File file = new File(venaProperties.getUploadPath(), "");
				if (!file.exists()) {
					file.mkdirs();
				}
				target = new File(venaProperties.getUploadPath() + myfile.getOriginalFilename());
				myfile.transferTo(target);
			}
			fileResult = "true";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileResult;
	}
	
	
	/**
	 * 释放卡记录
	 * 
	 * @author Hugh
	 */
	public StatusResult<String> genCardNo1() {
		
		try{
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbCardPrdctGroup", "1100"); //一般游客
			params.put("cbIdType", "P");
			params.put("cbIdno", "99999");
			
			List<CpCrdtbl> crdtblList=cpCrdtblMapper.searchCpCrdtblByParams(params);
			String cardNo="";
			if(null!=crdtblList && crdtblList.size()>0){
				cardNo=crdtblList.get(0).getCbCardholderNo();
				return StatusResult.create(cardNo);
			}else{
				return StatusResult.create("FALSE", "预制卡已用完,请申请制卡");
			}
		}catch (Throwable e) {
			LOG.warn("生成卡号异常", e);
			return StatusResult.create("FALSE", "生成卡号异常，请稍后再试！");
		}
	}
	
	
	/**
	 * 实卡激活
	 * 
	 * @param activeCardNo		持卡人号码
	 * @param cbRecommenderNo	卡面流水号
	 * @param cbRwdsAccno		卡序列号
	 * @param staffId			操作员ID
	 * 
	 * @author Hugh
	 */
	public StatusResult<List<String>> activeHCard(String activeCardNo,String cbRecommenderNo,String cbRwdsAccno,String staffId) throws ParseException {
		
		System.out.println("...进入卡激活方法...");
		BigDecimal messageid = null;
		List<String> list = new ArrayList<String>();
		
		//当前系统日期
		Date sysDate = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		String nowDate = formatDate.format(sysDate);

		if (this.checkcardno(activeCardNo)) {
			// 更新卡表
			CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(activeCardNo);
			//cpCrdtbl.setCbIdType("A");
			//cpCrdtbl.setCbIdno("88888");
			//cpCrdtbl.setCbBscIdType("A");
			//cpCrdtbl.setCbBasicCustomerIdno("88888");
			cpCrdtbl.setCbAnnivDate(nowDate);
			cpCrdtbl.setCbModUser(staffId);
			cpCrdtbl.setCbIndaccRule(0);
			cpCrdtbl.setCbRecommenderNo(Constants.serialBIN+cbRecommenderNo); //卡面流水号
			cpCrdtbl.setCbRwdsAccno(cbRwdsAccno);//卡序列号
			//cpCrdtbl.setCbPlasticCd("A"); //卡状态
			cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
			
		} else {
			return StatusResult.create("FALSE", "无效卡号");
		}
		list.add(messageid + "");
		return StatusResult.create(list);
	}
	
	
	/**
	 * 检查卡记录
	 * 
	 * @param  activeCardNo
	 * @author Hugh
	 */
	public boolean checkcardno(String activeCardNo){
		boolean exist = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("cbCardholderNo", activeCardNo);
		params.put("cbPlasticCd", "P");
		List<CpCrdtbl> cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByParams(params);
		int i=0;
		if(null!=cpCrdtbl){
			i=cpCrdtbl.size();
		}
		if(i>0) exist=true; return exist;
	}
	
	
	
	//秘钥
	public Map<String,String> getkeyMap(){
		
		Map<String,String> keyMap = new HashMap<String,String>();
		//查询cp_verkey
		CpVerkey verkeyDto = verkeyMapper.searchCpVerkeyByVkValue("CVK");
		//查询cp_seckey
		Map<String, String> params = new HashMap<String, String>();
		params.put("skProdctGroup", "1100"); //默认：一般游客
		List<CpSeckey> seckeyList = seckeyMapper.searchCpSeckeyByParams(params);
		keyMap.put(verkeyDto.getVkValue(), verkeyDto.getVkKey());
		for(int i=0;i<seckeyList.size();i++){
			keyMap.put(seckeyList.get(i).getSkValue(), seckeyList.get(i).getSkKey());
		}
		return keyMap;
	}
	
	
	//炎武制卡作业操作
	public StatusResult<String> insertDate(String custLevel, String startCardNo) {
		DecimalFormat df = new DecimalFormat(STR_FORMAT);
		DecimalFormat arn = new DecimalFormat(ACCT_REF_NO);
		DecimalFormat dfCard=new DecimalFormat("00000000");

		String time = SysDateFormat.getNowDate("yyyyMMdd");

		CpCrdtbl newCrdtbl = new CpCrdtbl();
		
		//String str2=dfCard.format(startCardNo);
		//String cardNo = Constants.baseBIN + str2; // 16位卡号
		
		
		Long AcctNoTmp = sequenceMapper.searchIndaccseq("ACCTNOSEQ");
		String AcctNo = df.format(AcctNoTmp); // 账号
		String AcctRefNo = arn.format(AcctNoTmp); // 对照账号

		
		//String cardNo = CardDigit(cardNoTmp);// 校验卡号

		newCrdtbl.setCbCardholderNo(startCardNo);
		newCrdtbl.setCbBasicSuppInd("B");
		newCrdtbl.setCbIdType("P");
		newCrdtbl.setCbIdno("99999");
		newCrdtbl.setCbBscIdType("P");
		newCrdtbl.setCbBasicCustomerIdno("99999");
		newCrdtbl.setCbBasicCardholderNo(startCardNo);
		newCrdtbl.setCbIndividualAcctno(AcctNo);
		newCrdtbl.setCbSeparateStmtInd("");
		newCrdtbl.setCbEmbossname("U.N.K.N.O.W");
		newCrdtbl.setCbBillCycle(10);
		newCrdtbl.setCbAutopayInd(0);
		newCrdtbl.setCbAutopayBankBranch("");
		newCrdtbl.setCbAutopayBankAccno("");
		newCrdtbl.setCbAutopayAccname("");
		newCrdtbl.setCbFrgnAutopayInd(0);
		newCrdtbl.setCbAutopayFrgnBankBranch("");
		newCrdtbl.setCbAutopayFrgnBankAccno("");
		newCrdtbl.setCbAutopayFrgnAccname("");
		newCrdtbl.setCbPinGenInd("0");
		newCrdtbl.setCbCurrBankRel("0");
		newCrdtbl.setCbCentreCd("000001");
		newCrdtbl.setCbSourceCd("");
		newCrdtbl.setCbRecommenderNo("");
		newCrdtbl.setCbRecommenderName("");
		newCrdtbl.setCbMicrofilmNo("");
		newCrdtbl.setCbAnnivDate(time);
		newCrdtbl.setCbCardPrdctGroup(Integer.parseInt(custLevel));
		newCrdtbl.setCbFeeCd(1);
		newCrdtbl.setCbCreditGuarantee("");
		newCrdtbl.setCbRenewalFlag("");
		newCrdtbl.setCbSuspendDate("");
		newCrdtbl.setCbBankruptcyDate("");
		newCrdtbl.setCbBankruptcyDate("");
		newCrdtbl.setCbCancelDate("");
		newCrdtbl.setCbLegalDate("");
		newCrdtbl.setCbFraudDate("");
		newCrdtbl.setCbReserveDate("");
		newCrdtbl.setCbReserveDate("");
		newCrdtbl.setCbReinstateDate("");
		newCrdtbl.setCbExpiryCcyymm("211401");
		newCrdtbl.setCbPlasticCd("P");
		newCrdtbl.setCbPlasticDate("");
		newCrdtbl.setCb4dbc("100");
		newCrdtbl.setCbNewExpiryCcyymm("");
		newCrdtbl.setCbNewPlasticCd("");
		newCrdtbl.setCbNewPlasticDate("");
		newCrdtbl.setCbNew4dbc("100");
		newCrdtbl.setCbXrefInd("");
		newCrdtbl.setCbXrefAccno("");
		newCrdtbl.setCbUserFieldNum1(null);
		newCrdtbl.setCbUserFieldNum2(null);
		newCrdtbl.setCbUserFieldNum3(null);
		newCrdtbl.setCbUserFieldNum4(null);
		newCrdtbl.setCbUserCode1("");
		newCrdtbl.setCbUserCode2("");
		newCrdtbl.setCbUserCode3("");
		newCrdtbl.setCbUserCode4("");
		newCrdtbl.setCbUserDate1(time);
		newCrdtbl.setCbUserDate2("");
		newCrdtbl.setCbUserAmt1(null);
		newCrdtbl.setCbUserAmt2(null);
		newCrdtbl.setCbUserField1("");
		newCrdtbl.setCbUserField2("");
		newCrdtbl.setCbUserField3("");
		newCrdtbl.setCbModDate(time);
		newCrdtbl.setCbModUser("0001");
		newCrdtbl.setCbPinOffset("0000FFFFFFFF");
		newCrdtbl.setCbPvki(5);
		newCrdtbl.setCbCicCancel("0");
		newCrdtbl.setCbCrshldInd("N");
		newCrdtbl.setCbCrshldEnrolDate("");
		newCrdtbl.setCbCrshldTerminateDate("");
		newCrdtbl.setCbCorporateId("");
		newCrdtbl.setCbSic("");
		newCrdtbl.setCbRelationship("");
		newCrdtbl.setCbFraudFlag1(0);
		newCrdtbl.setCbFraudFlag2("");
		newCrdtbl.setCbFirstUseDate("");
		newCrdtbl.setCbFirstUseTime("");
		newCrdtbl.setCbFirstUseInd("");
		newCrdtbl.setCbOldIdType("");
		newCrdtbl.setCbOldCustomerIdno("");
		newCrdtbl.setCbCifFlag("");
		newCrdtbl.setCbDcmsFlag("");
		newCrdtbl.setCbCafRefreshFlag("");
		newCrdtbl.setCbCafUpdateFlag("");
		newCrdtbl.setCbCafPinFlag("");
		newCrdtbl.setCbCafTagFlag("");
		newCrdtbl.setCbCardCollMethod("B");
		newCrdtbl.setCbCardDeliveryAddr("");
		newCrdtbl.setCbBillAddrCd("H");
		newCrdtbl.setCbRwdsAccno("");
		newCrdtbl.setCbLegalAddrCd("H");
		newCrdtbl.setCbLastRenewFeeYear(time.substring(0, 4));
		newCrdtbl.setCbStatusCd("");
		newCrdtbl.setCbMonitorCd("");
		newCrdtbl.setCbCollectCd("600000");
		newCrdtbl.setCbEmployeeId("");
		newCrdtbl.setCbIndaccRule(156);
		newCrdtbl.setCbIndaccNo1("");
		newCrdtbl.setCbIndaccRule1(0);
		newCrdtbl.setCbIndaccNo2("");
		newCrdtbl.setCbIndaccRule2(0);
		newCrdtbl.setCbIndaccNo3("");
		newCrdtbl.setCbIndaccRule3(0);

		newCrdtbl.setCbIndaccNo4("");
		newCrdtbl.setCbIndaccRule4(0);

		newCrdtbl.setCbIndaccNo5("");
		newCrdtbl.setCbIndaccRule5(0);

		newCrdtbl.setCbIndaccNo6("");
		newCrdtbl.setCbIndaccRule6(0);

		newCrdtbl.setCbIndaccNo7("");
		newCrdtbl.setCbIndaccRule7(0);

		newCrdtbl.setCbIndaccNo8("");
		newCrdtbl.setCbIndaccRule8(0);

		newCrdtbl.setCbIndaccNo9("");
		newCrdtbl.setCbIndaccRule9(0);
		newCrdtbl.setCbPvv(0);
		newCrdtbl.setCbPvvOffset(0);
		newCrdtbl.setCbCvki(0);
		newCrdtbl.setChecksum("");

		// 检查卡记录
		CpCrdtbl crdtblDto = cpCrdtblMapper.searchCpCrdtblByCbIdno(startCardNo);
		if (null != crdtblDto) {
			return StatusResult.create("FALSE", "起始卡号记录已存在");
		}

		cpCrdtblMapper.insertCpCrdtbl(newCrdtbl);

		// 账户表
		CpIndacc indaccDto = new CpIndacc();
		indaccDto.setCbIndividualAcctno(AcctNo);
		indaccDto.setCbIndividualAcctType(BigDecimal.ONE.intValue());
		indaccDto.setCbProductCd(new BigDecimal(custLevel).intValue());
		indaccDto.setCbFinAcctno("");
		indaccDto.setCbLineLimit(null);
		indaccDto.setCbTempLineLimit(null);
		indaccDto.setCbTempStartDate("");
		indaccDto.setCbTempEndDate("");
		indaccDto.setCbOutstdBal(BigDecimal.ZERO);
		indaccDto.setCbFeeWaiverSpend(null);
		indaccDto.setCbIndCardholderNo(startCardNo);
		indaccDto.setCbAcctClass(1);
		indaccDto.setCbCustomerId("P" + startCardNo);
		indaccDto.setCbBranchId("600000");
		indaccDto.setCbAcctRefNo(AcctRefNo);
		indaccDto.setCbOpenDate(time);
		indaccDto.setCbCloseDate("");
		indaccDto.setCbAcruInterest(null);
		indaccDto.setCbLastIntDate(time);
		indaccDto.setCbAcctStatus("");
		indaccDto.setCbAcctAgeCd("0");
		indaccDto.setCbFatherIndacc(startCardNo);
		indaccDto.setCbExternalAcct(null);
		indaccDto.setCbIntRule(1);
		indaccDto.setCbMngfeeRule(null);
		indaccDto.setCbStatementRule(101);
		indaccDto.setCbMngfeeRule(null);
		indaccDto.setCbStatementRule(new BigDecimal(101).intValue());
		indaccDto.setCbNextStmDate("");
		indaccDto.setCbBlockBal(null);
		indaccDto.setCbCurrencyCode(new BigDecimal(156).intValue());
		indaccDto.setCbOdintRule(null);
		indaccDto.setCbPenaltyRule(0);

		indaccDto.setCbOdStartDate("");
		indaccDto.setCbBillCycle(null);
		indaccDto.setCbLastFinhstSeq(null);
		indaccDto.setCbPenaltyInd("N");
		indaccDto.setCbOdGroupid(null);
		indaccDto.setCbExternalBranch("0"); //积分初始值默认为0
		cpIndaccMapper.insertCpIndacc(indaccDto);

		// 财务账户表(Cp_fintbl)省略
		return StatusResult.create("OK","开"+ startCardNo + "成功");
	}
	
	
	/**
	 * 查询出最大卡号
	 * @return
	 */
	public String searchMaxCrdNo(){
		return cpCrdtblMapper.searchMaxCrdNo();
	}
	
	
	public StatusResult<String> pointAdd(CpCrdtbl crdtbl,String orderId){
		System.out.println("----------网络购票将积分存入账户表indacc中--------");
		if(StringUtils.isEmpty(orderId)){
			return StatusResult.create("FALSE", "票劵ID为空");
		}
		YwOrderitem orderitem =yworderitemMapper.searchYwOrderitemByHwOrderitemId(orderId);
		if(StringUtils.isEmpty(orderitem)){
			return StatusResult.create("FALSE", "票劵ID未找到,请查看是否有误");
		}
		Integer vartkAmount=orderitem.getHwUnitPrice().intValue();
		CpMemberPoint point=cpMemberPointMapper.searchCpMemberPointByPoId("1002");
		Integer result=null;
		if(vartkAmount>0){
			result= vartkAmount/Integer.parseInt(point.getPoTypeId())*point.getPoNumber();
//			查询用户的账户
			CpIndacc indacc=cpIndaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
			if(Integer.parseInt(indacc.getCbExternalBranch()) <= 0){
				result=0+result;
			}else{
				result=result+Integer.parseInt(indacc.getCbExternalBranch());
			}
//			更新积分
			indacc.setCbExternalBranch(result.toString());
			cpIndaccMapper.updateCpIndacc(indacc);
		}
		return StatusResult.create("OK", "积分添加成功");
	}
	
//	有卡时，会员等级更新
	public StatusResult<String> cardGrp(CpCrdtbl cpCrdtbl,CpCsttbl cp_csttbl,String orderId){
		System.out.println("---------------网络购票会员等级处理-------------");
		if(StringUtils.isEmpty(orderId)){
			return StatusResult.create("FALSE", "票劵ID为空");
		}
		YwOrderitem orderitem =yworderitemMapper.searchYwOrderitemByHwOrderitemId(orderId);
		if(StringUtils.isEmpty(orderitem)){
			return StatusResult.create("FALSE", "票劵ID未找到,请查看是否有误");
		}
		Integer vartkAmount=orderitem.getHwUnitPrice().intValue();
//			消费金额
			Integer money=0;
			if(Integer.parseInt(cp_csttbl.getCbAlt2billAddr1()) ==0){
				money=vartkAmount;
			}else{
				money=Integer.parseInt(cp_csttbl.getCbAlt2billAddr1())+vartkAmount;
			}
			cp_csttbl.setCbAlt2BillAddr1(money.toString());
//			购买次数
			Integer count=0;
			if(Integer.parseInt(cp_csttbl.getCbAlt2billAddr2()) == 0){
				count=1;
			}else{
				count=Integer.parseInt(cp_csttbl.getCbAlt2billAddr2())+1;
			}
			cp_csttbl.setCbAlt2BillAddr2(count.toString());
			if(money<5000 && money>0){
				cp_csttbl.setCbNricIssuIdno("1101");
				cpCrdtbl.setCbCardPrdctGroup(1101);
			}else if(money<=10000 && money>5000){
				cp_csttbl.setCbNricIssuIdno("1102");
				cpCrdtbl.setCbCardPrdctGroup(1102);
			}else if(money<=20000 && money>10000){
				cp_csttbl.setCbNricIssuIdno("1103");
				cpCrdtbl.setCbCardPrdctGroup(1103);
			}else if(money>20000){
				cp_csttbl.setCbNricIssuIdno("1104");
				cpCrdtbl.setCbCardPrdctGroup(1104);
			}
			
			cpCsttblMapper.updateCpCsttbl(cp_csttbl);
			cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
		
		return StatusResult.create("OK", "会员等级更新成功");
	}
	
}
