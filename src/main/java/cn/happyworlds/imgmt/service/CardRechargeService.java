package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;   // allow Spring injection
import org.springframework.stereotype.Service;   // allow service

import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwPayrecord;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwPayrecordMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class CardRechargeService {

	// Spring will inject the container only after using this annotation
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private YwPayrecordMapper ywPayrecordMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private CpCeptrxMapper cpCeptrxMapper;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private YwOrderMapper ywOrderMappey;
	
	
	/**
	 * step 1: search idNo in cp_crdtbl by params
	 */
	public List<CpCrdtbl> searchCpCrdtblByParams(Map<String, String> map) {
		List<CpCrdtbl> list = cpCrdtblMapper.searchCpCrdtblByParams(map);
		return list;
	}
	
	/**
	 * step 2: search balance in cp_csttbl by hwMemberId
	 */
	public List<CpCsttbl> searchCpCsttblByParams(Map<String, String> map) {
		List<CpCsttbl> list = cpCsttblMapper.searchCpCsttblByParams(map);
		return list;
	}
	
	/**
	 * step 3: update hw_balance
	 */
	public void updateCpCsttblByHwMemberId(CpCsttbl cpCsttbl) {
		cpCsttblMapper.updateCpCsttbl(cpCsttbl);
	}
	
	/**
	 * step 4: generate a serial number
	 * temperately set 200100+now
	 */
	public String generateSerialNo() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = dateFormat.format(date);
		String serialNoStr = "200100"+time;
		return serialNoStr;
	}

	/**
	 * step 5: insert an item in yw_payrecord
	 */
	public void insertYwPayrecord(String serialNoStr, BigDecimal charge) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String time = dateFormat.format(date);
		
		YwPayrecord ywPayrecord = new YwPayrecord();
		ywPayrecord.setHwSn(serialNoStr);
		ywPayrecord.setHwOrderId("007");
		ywPayrecord.setHwMobilePhone("13800138000");
		ywPayrecord.setHwType("R");
		ywPayrecord.setHwAmount(charge);
		ywPayrecord.setHwPayType("6");
		ywPayrecord.setHwPayTime(time);
		ywPayrecordMapper.insertYwPayrecord(ywPayrecord);
	}
	
	/**
	 * 会员提现订单
	 * @param cpcsttbl
	 * @param AMOUNT
	 * @return
	 */
	public StatusResult<String> Carddindang(CpCsttbl cpcsttbl, String AMOUNT,String staffId){
		Long return_order = null;
		BigDecimal ac_amount = new BigDecimal(AMOUNT);
		YwOrder ywOrder = new YwOrder();
		String orderID = automaticgrowthService.nextdindang("name");
		ywOrder.setHwOrderId(orderID);
		ywOrder.setHwMemberId(cpcsttbl.getCbCustomerIdno());
		ywOrder.setHwCustomerName(cpcsttbl.getCbCardholderName());
		ywOrder.setHwMobilePhone(cpcsttbl.getCbMobileNo());
		ywOrder.setHwChannel("3");
		ywOrder.setHwMoney(ac_amount);
		ywOrder.setHwOrderState("R");
		ywOrder.setHwType("5");				
		ywOrder.setHwOrderAddtime(DateTimes.newDateTime());
		ywOrder.setHwOperatorId(staffId);
		ywOrder.setHwPaymentStatus("N");
		ywOrder.setHwPayType("银联"); 
		
		try {
			return_order =ywOrderMappey.insertYwOrder(ywOrder);
		} finally {
			if(return_order <= 0){
				return StatusResult.create("FALSE", "会员提现添加订单失败");
			}
		}
		return StatusResult.create(ywOrder.getHwOrderId());
	}
	
	/**
	 * 会员提现订单
	 * @param cpcsttbl
	 * @param AMOUNT
	 * @return
	 */
	public StatusResult<String> CardYwPayrecode(CpCsttbl cpcsttbl, String AMOUNT,String staffId,String orderid, String REQ_SN){
		Long return_order = null;
		BigDecimal ac_amount = new BigDecimal(AMOUNT);
		
		YwPayrecord ywpayrecord = new YwPayrecord();
		String liushuiID = automaticgrowthService.nextliushui("name");
		ywpayrecord.setHwSn(liushuiID);
		ywpayrecord.setHwPayId(REQ_SN);
		ywpayrecord.setHwOrderId(orderid);
		ywpayrecord.setHwMemberId(cpcsttbl.getCbMemberCode());
		ywpayrecord.setHwMobilePhone(cpcsttbl.getCbMobileNo());
		ywpayrecord.setHwMobilePhone(cpcsttbl.getCbCardholderName());
		ywpayrecord.setHwType("提现");
		ywpayrecord.setHwAmount(ac_amount);
		ywpayrecord.setHwPayType("银联");
		ywpayrecord.setHwPayStatus("Y");
		ywpayrecord.setHwGenerationTime(DateTimes.newDateTime());
		ywpayrecord.setHwPayTime(DateTimes.newDateTime());
		ywpayrecord.setHwOperatorId(staffId);	
		try {
			return_order =ywPayrecordMapper.insertYwPayrecord(ywpayrecord);
		} finally {
			if(return_order <= 0){
				return StatusResult.create("FALSE", "会员提现添加支付流水失败");
			}
		}
		YwOrder yo = ywOrderMappey.searchYwOrderByHwOrderId(ywpayrecord.getHwOrderId());
		yo.setHwPaymentStatus("Y");
		ywOrderMappey.updateYwOrder(yo);
		return StatusResult.create(ywpayrecord.getHwOrderId());
	}
	
	/**
	 * 会员提现
	 * @param CardId		卡号	
	 * @param AMOUNT		提现金额
	 * @param staffId		操作员账号
	 * @return
	 */
	public StatusResult<String> CardWithdrawals(String CardId,String AMOUNT,String staffId) {
		//金额转换
		BigDecimal ac_amount = new BigDecimal(AMOUNT);
		Long return_cpindacc = null;
		Long return_cpceptrx = null;		
		BigDecimal messageid = null;
		if(!StringUtils.isNotEmpty(CardId)){
			return StatusResult.create("FALSE", "卡号不能为空");
		}
		CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(CardId);
		if(null==cpcrdtbl){
			return StatusResult.create("FALSE", "卡号不存在");
		}
		if("L".equals(cpcrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "挂失卡不能充值");
		}else if("D".equals(cpcrdtbl.getCbPlasticCd())){
			return StatusResult.create("FALSE", "已销卡不能充值");
		}
		CpIndacc cpIndacc=cpIndaccMapper.searchCpIndaccByAcctNo(cpcrdtbl.getCbIndividualAcctno());
		if(null==cpIndacc){
			return StatusResult.create("FALSE", "账户不存在");
		}
		BigDecimal balance = BigDecimal.ZERO;
		balance = cpIndacc.getCbOutstdBal();
		int size = balance.compareTo(ac_amount);
		if(size == -1){
			return StatusResult.create("FALSE", "账户余额不足");
		}else{
			cpIndacc.setCbOutstdBal(cpIndacc.getCbOutstdBal().subtract(ac_amount));
		}		
		try {
			return_cpindacc =cpIndaccMapper.updateCpIndacc(cpIndacc);
		} finally {
			if(return_cpindacc <= 0){
				return StatusResult.create("FALSE", "会员提现失败");
			}
		}
		CpCeptrx cpCeptrx = new CpCeptrx();
		cpCeptrx.setCtBranchId(cpcrdtbl.getCbCentreCd());		
		Long tranId=sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");//交易tranId
		cpCeptrx.setCtTranId(tranId);		
		messageid=sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));			
		cpCeptrx.setCtMessageId(messageid.longValue());
		//P加卡号
		cpCeptrx.setCtCustomerId("P"+cpcrdtbl.getCbBasicCardholderNo());
		//卡号
		cpCeptrx.setCtCardNumber(cpcrdtbl.getCbBasicCardholderNo());
		cpCeptrx.setCtOpenZone("0");
		cpCeptrx.setCtTranZone("0");
		cpCeptrx.setCtTranNum("1");
//		cpCeptrx.setCtTranTime(DateTimes.nowTime());
		cpCeptrx.setCtTranTime(DateTimes.nowDateTime());
		//卡类型
		cpCeptrx.setCtDbCr("C");
		//消费金额
		cpCeptrx.setCtTranAmount(ac_amount);
		//账户原始余额
		cpCeptrx.setCtCardAmount(cpIndacc.getCbOutstdBal());
		//明细类型
		cpCeptrx.setCtDescription("提现");
		cpCeptrx.setCtCurrcode("156");
		//系统当前操作员
		cpCeptrx.setCtUserCreate(staffId);
		//yyyyMMdd HHmmss
		cpCeptrx.setCtApproveTime(DateTimes.newDateTime());
		//yyyyMMdd
		cpCeptrx.setCtPostTime(DateTimes.nowDate());
		//账户号
		cpCeptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());
		cpCeptrx.setCtTranCode("消费");
		cpCeptrx.setCtTxrnType("C");
		cpCeptrx.setCtBillCurrCd(Long.valueOf("156"));
		cpCeptrx.setCtBillCurrAmt(ac_amount);
		//yyyyMMdd
		cpCeptrx.setCtDisputeDate(DateTimes.nowDate());		
		cpCeptrx.setCtAgeCodeB4Post("00");
		//交易前账户余额
		cpCeptrx.setCtOutstdB4Post(cpIndacc.getCbOutstdBal());
		cpCeptrx.setCtAgeCodeAfterPost("00");
		//交易后账户余额
		cpCeptrx.setCtOutstdAfterPost(cpIndacc.getCbOutstdBal().subtract(ac_amount));
		cpCeptrx.setCtReversalFlag("0");
		try {
			return_cpceptrx =cpCeptrxMapper.insertCpCeptrx(cpCeptrx);
		} finally {
			if(return_cpceptrx <= 0){
				return StatusResult.create("FALSE", "会员提现添加流水失败");
			}
		}		
		return StatusResult.create("OK","会员提现成功");
	}
	
}
