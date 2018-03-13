package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.District;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.DistrictMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class PrtickeService {
		@Autowired
		private CpTicketMapper cpTicketMapper;
		@Autowired
		private CpCrdtblMapper cpCrdtblMapper;
		@Autowired
		private CpIndaccMapper cpIndaccMapper;
		@Autowired
		private SequenceMapper sequenceMapper;
		@Autowired
		private CpSysprmMapper cpSysprmMapper;
		@Autowired
		private CpCeptrxMapper cpCeptrxMapper;
		@Autowired
		private CpCsttblMapper cpCsttblMapper;
		@Autowired
		private CpTktypeMapper cpTktypeMapper;
		@Autowired
		private AutomaticGrowthService automaticgrowthService;
		@Autowired
		private DistrictMapper districtMapper;
		
		
		
		/**
		 * 赠票流程
		 * bMobileNo		手机号
		 * tktypeStr		票劵类别
		 * cbIdType			证件类型
		 * cbCustomerName	证件姓名
		 * cbCustomerIdno	证件号码
		 * CbDob			出生日期
		 * 
		 * 
		 */
		
		public	StatusResult<String> activiteCardAndBuy(String data){

			String result = new String();
			System.out.println("---进入赠票开卡方法---");
//			获取json对象
			JSONArray shuju = JSONArray.fromObject(data);
			for(int i=0; i<shuju.size(); i++){
			JSONObject b= JSONObject.fromObject(shuju.getString(i));
				String cbMobileNo = b.getString("mobile");
				String tktypeStr = b.getString("varTk_ticket_type");
				String CbRwdsAccno = b.getString("CbRwdsAccno");
				String cbCardholderNo = b.getString("cbCardholderNo");
				String cbIdType = b.getString("cbIdType");
				String cbCustomerIdno = b.getString("idNo");
				String cbCustomerName = b.getString("uname");
				String CbDob = b.getString("birthday");
				String Address = b.getString("Address");
//				判断手机号是否为空
				if(cbMobileNo.isEmpty()){
					return StatusResult.create("FALSE","手机号输入有误");
				}
				if(cbCustomerIdno.isEmpty()){
					return StatusResult.create("FALSE","身份证号码错误");
				}
				if(cbCardholderNo.length() !=16){
					return StatusResult.create("FALSE","持卡号码错误");
				}
//				通过身份证查询用户表CpCsttbl
				CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cbCustomerIdno);
//				如果没数据
				if(StringUtils.isEmpty(cpcsttbl)){
//					添加一条会员
					CpCsttbl cp_csttbl = cp_csttbladd(cbIdType,cbCustomerIdno,cbCustomerName ,cbMobileNo,CbDob,Address);
//					激活赠卡	
					CpCrdtbl cpcrdtbl = cp_crdtbladd(cp_csttbl,cbCardholderNo);
						long cpticket = cp_ticketadd(tktypeStr,cpcrdtbl,cp_csttbl);
						if(cpticket > 0){
							return StatusResult.create("SUCCESS","激活卡成功");
						}else{
							return StatusResult.create("FALSE","激活卡失败");
						}
				}else{
					CpCrdtbl tbl =cpCrdtblMapper.searchCpCrdtblByCbIdno(cpcsttbl.getCbCustomerIdno());
					if(tbl !=null){
						return StatusResult.create("FALSE","此客户已经有卡");
					}
					CpCrdtbl cpcrdtbl = cp_crdtbladd(cpcsttbl,cbCardholderNo);
					long cpticket = cp_ticketadd(tktypeStr,cpcrdtbl,cpcsttbl);
					if(cpticket > 0){
						return StatusResult.create("SUCCESS","激活卡成功");
					}else{
						return StatusResult.create("FALSE","激活卡失败");
					}
				}
			}
			return StatusResult.create("SUCCESS","增票成功");
		}
		/**
		 * 随机找一条卡数据进行绑定
		 * @param cpctdtbl
		 * @param cpcsttbl
		 * @param cpindacc
		 * @param cpticket
		 * @param cptktype
		 * @return
		 */
		public Long cp_ceptrxadd(CpCrdtbl cpctdtbl,CpCsttbl cpcsttbl,CpIndacc cpindacc,CpTicket cpticket,CpTktype cptktype){
			BigDecimal balance = new BigDecimal(0);
			CpCeptrx cpceptrx1=new CpCeptrx();
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd HHmmss");
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
			cpceptrx1.setCtBranchId(cpctdtbl.getCbCentreCd());
			cpceptrx1.setCtTranId(Long.parseLong(automaticgrowthService.sqlNextVal("APNONSSEQ")));
			cpceptrx1.setCtMessageId(Long.parseLong(automaticgrowthService.nextSerial()));
			cpceptrx1.setCtCustomerId(cpcsttbl.getCbMemberCode());
			cpceptrx1.setCtCardNumber(cpctdtbl.getCbCardholderNo());//卡号
//			cpceptrx1.setCtTranTime(formatter1.format(new Date()));//开卡时间
			cpceptrx1.setCtTranTime(DateTimes.nowDateTime());//开卡时间
			cpceptrx1.setCtDbCr("C");
			cpceptrx1.setCtDescription("赠票");  
			cpceptrx1.setCtApproveTime(formatter1.format(new Date()));
			cpceptrx1.setCtPostTime(automaticgrowthService.getPostTime());
			cpceptrx1.setCtAccountId(cpindacc.getCbIndividualAcctno());//账号id
			cpceptrx1.setCtTranCode("BUYTICKET");
			cpceptrx1.setCtTxrnType("C");
			cpceptrx1.setCtTranAmount(new BigDecimal(0));
			cpceptrx1.setCtUserStatus1(cpticket.getTkTicketId().toString());//票号
			cpceptrx1.setCtUserStatus2(""+cptktype.getTtTypeId());//票类别
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
			cpceptrx1.setCtDisputeDate(formatter2.format(new Date()));
			Long return_cpceptrx2=cpCeptrxMapper.insertCpCeptrx(cpceptrx1);
			
			if(return_cpceptrx2<0){
				System.out.println("GG");;
			}
			return return_cpceptrx2;
		}
		
		/**
		 * 添加数据到流水表
		 * @param cpctdtbl
		 * @param cpcsttbl
		 * @param cpindacc
		 * @return
		 */
		public CpCeptrx cp_ceptrxcrdtbladd(CpCsttbl cpcsttbl,CpCrdtbl cpcrdtbl,CpIndacc cpIndacc,String leibie){
			CpCeptrx cpceptrx=new CpCeptrx();
			cpceptrx.setCtBranchId(cpcrdtbl.getCbCentreCd());
			Long tranId = sequenceMapper.searchNextvalToCtTranId("APNONSSEQ");// 交易tranId
			cpceptrx.setCtTranId(tranId);
			BigDecimal balance = new BigDecimal(0);
			// start 主键流水messageId
			
			BigDecimal seqname = sequenceMapper.searchSerialToName();
			if (seqname.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd"))) != 0) {
				sequenceMapper.truncateSerial();
			}
			BigDecimal messageid1 = sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
			// end
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd HHmmss");
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
			//BigDecimal.longValue() 将对象中的值以长整数返回。
			cpceptrx.setCtMessageId(messageid1.longValue());
			cpceptrx.setCtCustomerId(cpcsttbl.getCbCustomerRefNo());
//			cpceptrx.setCtTranTime(formatter1.format(new Date()));//开卡时间
			cpceptrx.setCtTranTime(DateTimes.nowDateTime());//开卡时间
			cpceptrx.setCtCardNumber(cpcrdtbl.getCbCardholderNo());//卡号
			
			cpceptrx.setCtDbCr("C");
			cpceptrx.setCtTranAmount(BigDecimal.ZERO);
			cpceptrx.setCtCardAmount(cpceptrx.getCtTranAmount());
			cpceptrx.setCtDescription(leibie);  
			cpceptrx.setCtCurrcode("156");
			cpceptrx.setCtApproveTime(formatter1.format(new Date()));
			List<CpSysprm> sysprmList = cpSysprmMapper.searchCpSysprmByParams(null);
			CpSysprm cpSysprm = new CpSysprm();
			if (null != sysprmList) {
				cpSysprm = sysprmList.get(0);
			}
			cpceptrx.setCtPostTime(cpSysprm.getSpNextProcessingDate());
			cpceptrx.setCtAccountId(cpIndacc.getCbIndividualAcctno());//账号id
			cpceptrx.setCtTranCode("OPENCDTK");
			cpceptrx.setCtTxrnType("C");
			cpceptrx.setCtBillCurrCd(Long.valueOf("156"));
			cpceptrx.setCtBillCurrAmt(cpceptrx.getCtTranAmount());
			cpceptrx.setCtAgeCodeB4Post("00");
			cpceptrx.setCtAgeCodeAfterPost("00");
			cpceptrx.setCtReversalFlag("0");
			cpceptrx.setCtOutstdB4Post(balance);
			cpceptrx.setCtOutstdAfterPost(new BigDecimal(0));
			cpceptrx.setCtUserCreate("System");
			cpceptrx.setCtStatus("0");
			cpceptrx.setCtDc("0");
			cpceptrx.setCtTranNum("1");
			cpceptrx.setCtTranZone("0");
			cpceptrx.setCtOpenZone("0");
			cpceptrx.setCtCustomerId(cpIndacc.getCbCustomerId());
			cpceptrx.setCtFeeAmount(new BigDecimal(0));
			Long return_cpceptrx1=cpCeptrxMapper.insertCpCeptrx(cpceptrx);
			if(return_cpceptrx1>0){
				System.out.println("增票开卡写流水成功");
			}
			return cpceptrx;
		}
		
		/**
		 * 卡和票劵绑定
		 * @param tktypeStr		
		 * @param cpcrdtbl
		 * @param cpcsttbl
		 * @return
		 */
		public Long cp_ticketadd(String tktypeStr,CpCrdtbl cpcrdtbl,CpCsttbl cpcsttbl){
			
			long result = 0;
			CpIndacc cpindacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpcrdtbl.getCbIndividualAcctno());
				//通过票劵ID去票劵表中获取票劵详情
				CpTktype cptktype = cpTktypeMapper.searchCpTktypeByTtTypeId(Integer.parseInt(tktypeStr));
				
				System.out.println("-------添加流水信息（CP_TICKET）-----");
				
				//添加流水信息（CP_TICKET）
				//创建卡门票映射表
				CpTicket cpticket=new CpTicket();
				//调用数据库函数，自动增长列
				Long ticketId=sequenceMapper.searchNexttkToTicketId("TICEKTSEQ");
				cpticket.setTkTicketId(ticketId);
				//卡号
				cpticket.setTkCardNo(cpcrdtbl.getCbCardholderNo());
				//票劵ID
				cpticket.setTkTicketType(Long.parseLong(tktypeStr));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				//赠票日期
				cpticket.setTkEffectiveDate(sdf.format(new Date()));//系统日期
				Calendar calendar=Calendar.getInstance();
				try {
					calendar.setTime(sdf.parse(sdf.format(new Date())));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				calendar.add(Calendar.DATE,cptktype.getTtExpirePeriod());
				//赠票日期往后推一个月
				cpticket.setTkExpireDate(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
				//最近入园日期
				cpticket.setTkActiveDate("");
				cpticket.setTkRetriveDate("");
				//插入一条数据
				Long  return_cpticket=cpTicketMapper.insertCpTicket(cpticket);
				System.out.println("ccccc"+return_cpticket);
				if(return_cpticket > 0){
					System.out.println("-------添加流水信息（cp_ceptrx）-----");
					long cpceptrx =cp_ceptrxadd(cpcrdtbl,cpcsttbl,cpindacc,cpticket,cptktype);
					if(cpceptrx>0){
						result = 10;
					}
				}
			return result;
		}
		
		
		
		/**
		 * 根据卡号查询出卡数据和会员绑定
		 * @param bMobileNo			手机号
		 * @param tktypeStr			
		 * @param amount			金额
		 * @param cbIdType			证件类型
		 * @param cbCustomerName	客户姓名
		 * @param cbCustomerIdno	证件号码
		 * @param CbDob				出生日期
		 * @param prProdctGroup		客户等级
		 * @param systemDate		开卡时间
		 * @param deposit			押金
		 * @return
		 */
		public	CpCrdtbl cp_crdtblkaadd(CpCsttbl cpcsttbl,String prProdctGroup,String cbCardholderNo,String cBrwdsAccno){
			String leibei = null;
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbCardholderNo", "333502"+cbCardholderNo);
			params.put("cbRwdsAccno", cBrwdsAccno);
			List<CpCrdtbl> list = cpCrdtblMapper.searchCpCrdtblByParams(params);
			CpCrdtbl cpCrdtbl = list.get(0);
			try {
				//更新卡表
				cpCrdtbl.setCbIdType("1");//由预制卡改为可用卡
				cpCrdtbl.setCbIdno(cpcsttbl.getCbCustomerIdno());	
				cpCrdtbl.setCbBscIdType("1");//由预制卡改为可用卡
				cpCrdtbl.setCbBasicCustomerIdno(cpcsttbl.getCbCustomerIdno());//证件号
				cpCrdtbl.setCbEmbossname(cpcsttbl.getCbCardholderName());		//姓名
				cpCrdtbl.setCbSourceCd(cpcsttbl.getCbMobileNo());//手机号
				cpCrdtbl.setCbSuspendDate(cpcsttbl.getCbDob());//出身日期
				cpCrdtbl.setCbPlasticCd("U");					//状态
				cpCrdtbl.setCbModDate(formatter1.format(new Date()));					//修改日期
				cpCrdtbl.setCbModUser("json");
				Long return_cpCrdtbl=cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
				leibei = "开卡";
				if(return_cpCrdtbl > 0){
					CpIndacc cpindacc=new CpIndacc();
					Map<String, String> params1 = new HashMap<String, String>();
					System.out.println("卡号为："+cpCrdtbl.getCbIndividualAcctno());
					params1.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
					List <CpIndacc> cpindaccList = cpIndaccMapper.searchCpIndaccByParams(params1);			
					cpindacc=cpindaccList.get(0);
					cp_ceptrxcrdtbladd(cpcsttbl,cpCrdtbl,cpindacc,leibei);
					
				}
				//查找对应账户
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return cpCrdtbl;
		}
		
		/**
		 * 
		 * @param bMobileNo			手机号
		 * @param cbIdType			证件类型
		 * @param cbCustomerName	客户姓名
		 * @param cbCustomerIdno	证件号码
		 * @param CbDob				出生日期
		 * @param systemDate		开卡时间
		 * @return
		 */
		public	CpCrdtbl cp_crdtbladd(CpCsttbl cpcsttbl,String cbCardholderNo){
			
			CpCrdtbl cpCrdtbl=cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
			CpIndacc cpIndacc=cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
			try {	
				//更新卡表
				cpCrdtbl.setCbIdType("1");//由预制卡改为可用卡
				cpCrdtbl.setCbIdno(cpcsttbl.getCbCustomerIdno());	
				cpCrdtbl.setCbBscIdType("1");//由预制卡改为可用卡
				cpCrdtbl.setCbBasicCustomerIdno(cpcsttbl.getCbCustomerIdno());//证件号
				cpCrdtbl.setCbSourceCd(cpcsttbl.getCbMobileNo());//手机号
				cpCrdtbl.setCbEmbossname(cpcsttbl.getCbCardholderName());  //姓名
				cpCrdtbl.setCbPlasticCd("U");	//卡状态
				cpCrdtbl.setCbSuspendDate(cpcsttbl.getCbDob()); //出生日期
				cpCrdtblMapper.updateCpCrdtbl(cpCrdtbl);
//				插入流水表
				String leibie="开卡";
				CpCeptrx cpceptrx =cp_ceptrxcrdtbladd(cpcsttbl,cpCrdtbl,cpIndacc,leibie);
				if(cpceptrx != null){
					return cpCrdtbl;
				}
			} catch (Exception e) {

			}
			return cpCrdtbl;
		}
		
		
		
		/**
		 * 会员添加
		 * @param cbIdType			证件类型
		 * @param cbCustomerIdno	证件号码
		 * @param cbCustomerName	证件姓名
		 * @param cbMobileNo			手机号
		 * @param CbDob				出生日期
		 * @return
		 */
		public CpCsttbl cp_csttbladd(String cbIdType,String cbCustomerIdno,String cbCustomerName ,String cbMobileNo,String CbDob,String Address){
			String CbSex = cbCustomerIdno.substring(16, 17);
			CpCsttbl csttbl=new CpCsttbl();
			csttbl.setCbMemberCode(automaticgrowthService.sqlNextHuiyuan("ID"));
			csttbl.setCbIdType(cbIdType);
			csttbl.setCbCustomerIdno(cbCustomerIdno);//身份证号
			csttbl.setCbCardholderName(cbCustomerName);//身份证姓名
			csttbl.setCbDob(CbDob);
			csttbl.setCbMobileNo(cbMobileNo);
			if(Integer.parseInt(CbSex)%2==0 ){
				csttbl.setCbSex("F");
			}else{
				csttbl.setCbSex("M");
			}		
			csttbl.setCbHomePhone(cbMobileNo);
			csttbl.setCbNricIssuIdno("1100");
			csttbl.setCbHomeAddr1(Address);
			String cbHomeCity = cbCustomerIdno.substring(0, 6);
			District district  = districtMapper.searchDistrictByCode(cbHomeCity);
			csttbl.setCbHomeCity(district.getName()+district.getSuffix());
			String cbHomeState = cbCustomerIdno.substring(0, 2);
			cbHomeState = cbHomeState+"0000";
			District district2  = districtMapper.searchDistrictByCode(cbHomeState);
			csttbl.setCbHomeState(district2.getName()+district2.getSuffix());
			Long newcsttbl=cpCsttblMapper.insertCpCsttbl(csttbl);
			if(newcsttbl>0){
				CpCsttbl cpcsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cbCustomerIdno);
				return cpcsttbl;
			}
			
			return csttbl;
		}
		
		/**
		 * 根据卡号获取到卡面号
		 * @param cardNo
		 * @return
		 */
		public StatusResult<String> kamianhaiselect(String cardNo){
			
			CpCrdtbl cpcrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardNo);
			String kaminahao = cpcrdtbl.getCbRwdsAccno();
			return StatusResult.create(kaminahao);
		}
	}
