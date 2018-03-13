package cn.happyworlds.imgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.CpTuiPiao;
import cn.happyworlds.imgmt.mapper.CpTuiPiaoMapper;
import cn.happyworlds.imgmt.util.ExcelUtil;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpTuiPiaoService {
	@Autowired
	private CpTuiPiaoMapper cpTuiPiaoMapper;
	
	/**
	 * 报表
	 */
	public Result<String> listDownLoadMethod(final String startTime,final String endTime,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			String amoutstr = "";
			
			List<CpTuiPiao> page = cpTuiPiaoMapper.getAllReturnTicket(startTime, endTime);
			
			String title = "退票报表"+amoutstr;//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("退票订单号");
					add("退票时间");
					add("退票渠道");
					add("退票金额");
					add("退票支付状态");
					add("退票单号(关联的购票订单号)");
					add("下单时间");
					add("订单完成");
					add("订单支付方式");
					add("支付金额");
					add("售票员姓名");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				String s=page.get(i).getRefundChannels();
				if(s.equals("1")){
					s="微信公众号";
				}
				if(s.equals("2")){
					s="APP";
				}
				if(s.equals("3")){
					s="现场";
				}
				if(s.equals("4")){
					s="官网";
				}
				if(s.equals("5")){
					s="驴妈妈";
				}
				if(s.equals("6")){
					s="携程";
				}
				if(s.equals("7")){
					s="途牛";
				}
				if(s.equals("8")){
					s="同程";
				}
				if(s.equals("9")){
					s="淘宝旅行";
				}
				if(s.equals("10")){
					s="终端";
				}
				if(s.equals("11")){
					s="闸机";
				}
				if(s.equals("12")){
					s="智能pos";
				}
				record.put("tpdd",page.get(i).getTicketno());//退票订单
				record.put("tpsj",page.get(i).getReturnTime());//退票时间
				record.put("tpqd", s);//退票渠道
				record.put("tpje",page.get(i).getRefundAmount());//退票金额
				record.put("tpzfzt", page.get(i).getRefundPayment());//退票支付状态
				record.put("tpdh",page.get(i).getSonorderlist());//退票单号(关联的购票订单号)
				record.put("xdsj",page.get(i).getOrderTime());//下单时间
				record.put("ddwcsj",page.get(i).getOrderFinish());//订单完成时间
				record.put("ddzffs",page.get(i).getOrderPayType());//订单支付方式
				record.put("zfje",page.get(i).getOrderMoney());//支付金额
				record.put("spyxm",page.get(i).getOrderName());//售票员姓名
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", "");
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, null, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}
}
