package cn.happyworlds.imgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.record.PageBreakRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpChannels;
import cn.happyworlds.imgmt.entity.CpShift;
import cn.happyworlds.imgmt.mapper.CpChannelsMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.ExcelUtil;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpChannelsService {
	@Autowired
	private CpChannelsMapper channelsMapper;
	
	public Result<PageInfo<CpChannels>> findAllOrder(String date,String startTime,String endTime,PageBounds pageBounds){
		 Map<String, String> map=new HashMap<>();
		 map.put("date", date);
		 map.put("startTime", startTime);
		 map.put("endTime", endTime);
		 List<CpChannels> page=channelsMapper.searchCpChannelsByParams(map, pageBounds);
		 return Result.create(new PageInfo<CpChannels>(page));
	}
	/**
	 * 报表
	 */
	public Result<String> listDownLoadMethod(final String startTime,final String endTime, final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			String amoutstr = "";
			
			List<CpChannels> page = channelsMapper.findAllOrder(startTime,endTime);
		
			String title = "渠道报表"+amoutstr;//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("商户");
					add("票类");
					add("票数");
					add("应收（元）");
					add("实收（元）");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				String s=page.get(i).getCpMercial();
				if(s.equals("1")){
					s="微信公众号";
				}
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
				record.put("ygxm", s);//商户
				record.put("yyme",page.get(i).getCpTicketName());//票类
				record.put("zkje",page.get(i).getCpTicketSum());//票数
				record.put("jybs",page.get(i).getCpAmountsReceivable());//应收金额
				record.put("tpbs",page.get(i).getCpAmount());//实收金额
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
