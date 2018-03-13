package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.LegalHoliday;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.entity.YwOrderitemAndPrdgrp;
import cn.happyworlds.imgmt.entity.YwPayrecord;
import cn.happyworlds.imgmt.mapper.LegalHolidayMapper;
import cn.happyworlds.imgmt.mapper.PrdgrpMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mapper.YwPayrecordMapper;

@Service
public class BuyCpprdgrpService {
	
	@Autowired
	private PrdgrpMapper prdgrpMapper;
	@Autowired
	private LegalHolidayMapper legalHolidayMapper;
	@Autowired
	private YwOrderitemMapper ywOrderitemMapper;
	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private YwPayrecordMapper ywPayrecordMapper;
	
	/**
	 * 查询票务类别，distinct查询所有hw_category类别,PR_CARD_BRAND大类别,PR_CARD_TYPE小类别，返回票务类别
	 * @author yanjy
	 */
	public List<CpPrdgrp> searchCpPrdgrpByParamsHwCategory(boolean timeflag) {
		List<CpPrdgrp> list = new ArrayList<CpPrdgrp>();
		if (timeflag) {
			list = prdgrpMapper.searchCpPrdgrpByParamsHwCategory("特定");
		} else {
			list = prdgrpMapper.searchCpPrdgrpByParamsHwCategoryALL();
		}
		return list;
	}
	
	/**
	 * 确认支付，传入手机号，订单信息
	 * 现金支付，支付类型与渠道id暂定是3
	 * @author yanjy
	 */
	public void buyCpPrdgrp(String hwMobilePhone,List<YwOrderitemAndPrdgrp> ywOrderitems) {
		String ticketCount = ywOrderitems.get(0).getTicketCount();//购票总数量
		String ticketAmount = ywOrderitems.get(0).getTicketAmount();//购票总金额
		String hwType = "3";//支付类型
		String hwChannel ="3";//渠道ID
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HHmmss");
		//支付流水表
		YwPayrecord ywpayrecord = new YwPayrecord();
		ywpayrecord.setHwSn(getStringRandom());			//流水ID		随机生成32位字母加数字
		YwOrder yworder = new YwOrder();				//订单对象
		yworder.setHwOrderId(getStringRandom()); 		//订单ID		随机生成32位字母加数字
		ywpayrecord.setHwOrderId(yworder.getHwOrderId());//订单ID
		ywpayrecord.setHwMobilePhone(hwMobilePhone);	//手机号
		ywpayrecord.setHwType(hwType);					//支付类型	订单、押金、充值
		ywpayrecord.setHwAmount(new BigDecimal(ticketAmount)); 		//总金额		
		ywpayrecord.setHwAmountTicket(new BigDecimal(ticketAmount));//门票总金额
		ywpayrecord.setHwPayType(hwChannel);			//支付方式
		ywpayrecord.setHwPayTime(df.format(new Date()));//支付时间	获取当前时间
		
		yworder.setHwMobilePhone(hwMobilePhone);		//手机号					 
		yworder.setHwChannel(hwChannel);				//渠道ID		1为微信，2为APP，3为官网现金，4为OTA
		yworder.setHwPaymentListid(ywpayrecord.getHwSn());//支付流水ID	从支付流水表获取
		yworder.setHwMoney(new BigDecimal(ticketAmount));//总金额		
		yworder.setHwOrderState("W");					//状态		Y为已支付，N为未支付

		yworder.setHwOrderAddtime(df.format(new Date()));//订单生成时间	获取当前时间
		yworder.setHwOrderPaytime(ywpayrecord.getHwPayTime());//订单支付时间	从订单流水表获取
		
		for (int i = 0; i < ywOrderitems.size(); i++) {
			String prProdctGroup = ywOrderitems.get(i).getHwProdctGroup();		 //门票id
			String hwUnitPrice = ywOrderitems.get(i).getHwUnitPrice().toString();//单价
			int hwTicketCount = Integer.parseInt(ywOrderitems.get(i).getHwTicketCount());//单张票的订票数量
			String hwAdmissionTime = ywOrderitems.get(i).getHwAdmissionTime();	 //用户入园时间
			//转换入园时间格式
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-ddHHmmss");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss") ;
			Date d = null ;
			try{    
	            d = sdf1.parse(hwAdmissionTime+"093000") ;   // 将给定的字符串中的日期提取出来    
	        }catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理    
	            e.printStackTrace() ;       // 打印异常信息    
	        } 
			hwAdmissionTime = sdf2.format(d);
			
			for (int j = 0; j < hwTicketCount; j++) {
				YwOrderitem yworderitem = new YwOrderitem();
				yworderitem.setHwOrderitemId(getStringRandom());		//订单详情ID 随机生成32位字母加数字
				yworderitem.setHwOrderId(yworder.getHwOrderId());	    //订单详情ID	从订单表获取
			    yworderitem.setHwProdctGroup(prProdctGroup);			//票劵详情ID	
				yworderitem.setHwAdmissionTime(hwAdmissionTime);		//入园时间	
				yworderitem.setHwUnitPrice(new BigDecimal(hwUnitPrice));//单价		
				yworderitem.setHwTicketCount(Integer.parseInt(ticketCount));//总数量		
				yworderitem.setHwAmount(new BigDecimal(ticketAmount));		//总价		
				ywOrderitemMapper.insertYwOrderitem(yworderitem);			//添加到订单详情表
			}
		}
		
		yworder.setHwOrderFinishtime(df.format(new Date()));	//订单完成时间	获取当前时间,[从订单流水表获取]
		ywPayrecordMapper.insertYwPayrecord(ywpayrecord);		//添加到支付流水表
		ywOrderMapper.insertYwOrder(yworder);					//添加到订单表	
		
	}
	
	/**
	 * 随机生成32位小写字母加数字
	 * @author yanjy
	 */
	public String getStringRandom() {  
        
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < 32; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                //int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + 97);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }
	
	/**
	 * 查询票务信息，是否在假期内
	 * @author yanjy
	 */
	public List<CpPrdgrp> searchCpPrdgrpByIfHoliday(boolean timeflag,String prCardBrand,String prCardType) {
		List<CpPrdgrp> list = new ArrayList<CpPrdgrp>();
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(prCardBrand)) {
			params.put("prCardBrand", prCardBrand);
		}
		if (StringUtils.hasText(prCardType)) {
			params.put("prCardType", prCardType);
		}
		params.put("prGroupDesc", "特定");
		if (timeflag) {
			list = prdgrpMapper.searchCpPrdgrpByHoliday(params);
		} else {
			list = prdgrpMapper.searchCpPrdgrpByNotHoliday(params);
		}
		return list;
	}
	
	/**
	 * 判断是否在星期六星期天里,判断日期是否在假期内
	 * @author yanjy
	 */
	public boolean ifLegalHoliday(String time) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Calendar cal = Calendar.getInstance();
			time = time.replace("-", "");
			Date d = format.parse(time);
			cal.setTime(d);
			String hdate = format.format(cal.getTime());
			//判断是否在星期六星期天里
			if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
				return true;
			}else{
				int datesplit = Integer.parseInt(hdate.substring(4, hdate.length()));
				List<LegalHoliday> holiday = legalHolidayMapper.searchLegalHolidayByParams(null);
				//判断日期是否是假期里
				for (int i = 0; i < holiday.size(); i++) {
					LegalHoliday day = holiday.get(i);
					int Start = Integer.parseInt(day.getHolidayStart());
					int End = Integer.parseInt(day.getHolidayEnd());
					if(Start <= datesplit&&End >= datesplit){
						return true;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
