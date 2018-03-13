package cn.happyworlds.imgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.FinancialStatement;
import cn.happyworlds.imgmt.mapper.FinancialStatementMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.ExcelUtil;
import cn.happyworlds.imgmt.util.Result;

@Service
public class FinancialService {
	
	@Autowired
	private FinancialStatementMapper financialStatementMapper;
	
	//财务报表
	public Result<PageInfo<FinancialStatement>> list(final String classes, HttpServletRequest request, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(classes)) {
			params.put("classes", classes);
		}
		List<FinancialStatement> page = financialStatementMapper.searchFinancialStatementByParams(params, pageBounds);
		return Result.create(new PageInfo<FinancialStatement>(page));
	} 

	//财务报表下载
	public Result<String> listDownLoadMethod(final String ctApproveTimeStart, final String ctApproveTimeEnd,final String classes,final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			String amoutstr = "";
			if (StringUtils.hasText(ctApproveTimeStart)) {
				params.put("ctApproveTimeStart", ctApproveTimeStart);
			}
			if (StringUtils.hasText(ctApproveTimeEnd)) {
				params.put("ctApproveTimeEnd", ctApproveTimeEnd);
			}
			if (StringUtils.hasText(classes)) {
				if(classes.equals("zc")){
					amoutstr="资产";
				}
				if(classes.equals("fz")){
					amoutstr="负债";
				}
				if(classes.equals("gtong")){
					amoutstr="共同";
				}
				if(classes.equals("qy")){
					amoutstr="权益";
				}
				if(classes.equals("cb")){
					amoutstr="成本";
				}
				if(classes.equals("sy")){
					amoutstr="损益";
				}
				params.put("classes", classes);
				amoutstr = "--"+amoutstr;
			}
			List<FinancialStatement> page = financialStatementMapper.searchFinancialStatementByParams(params);
		
			String title = "财务报表"+amoutstr;//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("级次");
					add("科目编码");
					add("科目名称");
					add("币种");
					add("金额");
					add("批注");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("level",page.get(i).getLevel().toString());
				record.put("subjectCode",page.get(i).getSubjectCode());
				record.put("subjectName",page.get(i).getSubjectName());
				record.put("currency",page.get(i).getCurrency());
				record.put("money",page.get(i).getMoney());
				record.put("postil",page.get(i).getPostil());
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", ctApproveTimeStart);
			headExtra.put("结束时间", ctApproveTimeEnd);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, null, footExtra, userid,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}
	
	public Result<String> grogshop( HttpServletResponse resp,String filename) {
		try {
			String title = "酒店营业报表";
			String headerTitle = "福建天柱山智慧乐园管理系统报表   "+title+" （日）";
			List header = new ArrayList<String>() {
				{
					add("类别");
					add("分项");
					add("类别");
					add("单位");
					add("单位数量");
					add("总营业额");
					add("管理人员备注");
				}
			};
			
			String onecolstr = "零售销售统计";
			
			Map<String,String> one = new LinkedHashMap<String,String>();
			one.put("A房型", "房/（万元）人民币");
			one.put("B房型", "房/（万元）人民币");
			one.put("C房型", "房/（万元）人民币");
			one.put("D房型", "房/（万元）人民币");
			Map<String,String> two = new LinkedHashMap<String,String>();
			two.put("中餐厅", "单/（万元）人民币");
			two.put("西餐厅", "单/（万元）人民币");
			two.put("中庭酒吧", "单/（万元）人民币");
			two.put("泳池烧烤", "单/（万元）人民币");
			Map<String,String> three = new LinkedHashMap<String,String>();
			three.put("SPA", "人/（万元）人民币");
			three.put("露天泳池", "人/（万元）人民币");
			three.put("乾洗服务", "人/（万元）人民币");
			three.put("送餐服务", "人/（万元）人民币");
			
			Map<String, Map<String,String>> categoryList = new LinkedHashMap<String, Map<String,String>>();
			categoryList.put("酒店客房部", one);
			categoryList.put("酒店餐饮部", two);
			categoryList.put("酒店服务部", three);
			
			Map<String,String> foot = new LinkedHashMap<String, String>();
			foot.put("本日营业总额", "");
			foot.put("（万元）人民币", "");
			ExcelUtil.downLoad(title, headerTitle, header, categoryList, onecolstr, foot,filename,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		return null;
	}
	
	public Result<String> retail( HttpServletResponse resp,String filename) {
		try {
			String title = "零售销售表";
			String headerTitle = "福建天柱山智慧乐园管理系统报表   "+title+" （日）";
			List header = new ArrayList<String>() {
				{
					add("类别");
					add("分项");
					add("区域");
					add("单位");
					add("销售额");
					add("管理人员备注");
				}
			};
			
			String onecolstr = "零售销售统计";
			
			Map<String,String> one = new LinkedHashMap<String,String>();
			one.put("动物大世界", "（万元）人民币");
			one.put("海洋大世界", "（万元）人民币");
			one.put("宗教文化馆", "（万元）人民币");
			
			Map<String, Map<String,String>> categoryList = new LinkedHashMap<String, Map<String,String>>();
			categoryList.put("礼品店", one);
			categoryList.put("小商品商铺", one);
			categoryList.put("主题商城", one);
			
			Map<String,String> foot = new LinkedHashMap<String, String>();
			foot.put("本日营业总额", "");
			foot.put("（万元）人民币", "");
			ExcelUtil.downLoad(title, headerTitle, header, categoryList, onecolstr, foot,filename,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		return null;
	}
	
	public Result<String> food( HttpServletResponse resp,String filename) {
		try {
			String title = "餐饮销售表";
			String headerTitle = "福建天柱山智慧乐园管理系统报表   "+title+" （日）";
			List header = new ArrayList<String>() {
				{
					add("类别");
					add("分项");
					add("餐厅");
					add("单位");
					add("用餐（买单）人数");
					add("营业总额");
					add("每单营业额");
					add("管理人员备注");
				}
			};
			
			String onecolstr = "餐饮销售统计";
			
			Map<String,String> one = new LinkedHashMap<String,String>();
			one.put("动物主题餐厅", "人/（万元）人民币");
			one.put("海洋主题餐厅", "人/（万元）人民币");
			one.put("宗教主题餐厅", "人/（万元）人民币");
			Map<String,String> two = new LinkedHashMap<String,String>();
			two.put("动物馆流动餐车", "人/（万元）人民币");
			two.put("动物馆驻园小食部", "人/（万元）人民币");
			two.put("动物馆饮料售货机", "人/（万元）人民币");
			two.put("海洋馆流动餐车", "人/（万元）人民币");
			two.put("海洋馆驻园小食部", "人/（万元）人民币");
			two.put("海洋馆饮料售货机", "人/（万元）人民币");
			two.put("宗教馆流动餐车", "人/（万元）人民币");
			two.put("宗教馆驻园小食部", "人/（万元）人民币");
			two.put("宗教馆饮料售货机", "人/（万元）人民币");
			
			Map<String, Map<String,String>> categoryList = new LinkedHashMap<String, Map<String,String>>();
			categoryList.put("三大主题餐厅（动物/海洋/宗教）", one);
			categoryList.put("速食餐饮（流动餐车/驻园小食部/饮料售货机）", two);
			
			Map<String,String> foot = new LinkedHashMap<String, String>();
			foot.put("本日餐饮营业总额", "");
			foot.put("人/（万元）人民币", "");
			ExcelUtil.downLoad(title, headerTitle, header, categoryList, onecolstr, foot,filename,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		return null;
	}
	
	public Result<String> paradise( HttpServletResponse resp,String filename) {
		try {
			String title = "乐园经营总表";
			String headerTitle = "福建天柱山智慧乐园管理系统报表   "+title+" （日）";
			List header = new ArrayList<String>() {
				{
					add("类别");
					add("分项");
					add("单位");
					add("数值");
					add("管理人员备注");
				}
			};
			Map<String,String> itemizedVisit = new LinkedHashMap<String,String>();
			itemizedVisit.put("总入园人（数）统计", "（数）");
			itemizedVisit.put("总入园人（次）统计", "（次）");
			itemizedVisit.put("动物世界入园人（数）统计", "（数）");
			itemizedVisit.put("动物世界入园人（次）统计", "（次）");
			itemizedVisit.put("海洋世界入园人（数）统计", "（数）");
			itemizedVisit.put("海洋世界入园人（次）统计", "（次）");
			itemizedVisit.put("宗教文化入园人（数）统计", "（数）");
			itemizedVisit.put("宗教文化入园人（次）统计", "（次）");
			Map<String,String> itemizedTicketSales = new LinkedHashMap<String,String>();
			itemizedTicketSales.put("APP售票", "（万元）人民币");
			itemizedTicketSales.put("官网售票", "（万元）人民币");
			itemizedTicketSales.put("微信售票", "（万元）人民币");
			itemizedTicketSales.put("OTA售票", "（万元）人民币");
			Map<String,String> itemizedFoodSales = new LinkedHashMap<String,String>();
			itemizedFoodSales.put("三大主题餐厅（动物/海洋/宗教）", "（万元）人民币");
			itemizedFoodSales.put("速食餐饮（流动餐车/驻园小食部/饮料售货机）", "（万元）人民币");
			Map<String,String> itemizedRetailSales = new LinkedHashMap<String,String>();
			itemizedRetailSales.put("礼品店", "（万元）人民币");
			itemizedRetailSales.put("小商品商铺", "（万元）人民币");
			itemizedRetailSales.put("主题商城", "（万元）人民币");
			Map<String,String> itemizedHotelSales = new LinkedHashMap<String,String>();
			itemizedHotelSales.put("酒店客房部", "（万元）人民币");
			itemizedHotelSales.put("酒店餐饮部", "（万元）人民币");
			itemizedHotelSales.put("酒店服务部", "（万元）人民币");
			Map<String,String> itemizedBonusServices = new LinkedHashMap<String,String>();
			itemizedBonusServices.put("VIP休息室", "（万元）人民币");
			
			Map<String, Map<String,String>> categoryList = new LinkedHashMap<String, Map<String,String>>();
			categoryList.put("参访人数(次)", itemizedVisit);
			categoryList.put("票务销售统计", itemizedTicketSales);
			categoryList.put("餐饮销售统计", itemizedFoodSales);
			categoryList.put("零售销售统计", itemizedRetailSales);
			categoryList.put("酒店销售统计", itemizedHotelSales);
			categoryList.put("加值服务销售", itemizedBonusServices);
			
			Map<String,String> foot = new LinkedHashMap<String, String>();
			foot.put("本日营业总额", "（万元）人民币");
			ExcelUtil.downLoad(title, headerTitle, header, categoryList, null, foot,filename,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		return null;
	}
	
	public Result<String> ticket( HttpServletResponse resp,String filename) {
		try {
			String title = "票务销售表";
			String headerTitle = "福建天柱山智慧乐园管理系统报表   "+title+" （日）";
			List header = new ArrayList<String>() {
				{
					add("类别");
					add("渠道");
					add("票种");
					add("单位");
					add("销售总量");
					add("销售总额");
					add("平均单价(元)");
					add("管理人员备注");
				}
			};
			Map<String,String> threeFourcol = new LinkedHashMap<String,String>();
			threeFourcol.put("动物世界馆（一般票）", "张 /（万元）人民币");
			threeFourcol.put("动物世界馆（特价票）", "张 /（万元）人民币");
			threeFourcol.put("海洋世界馆（一般票）", "张 /（万元）人民币");
			threeFourcol.put("海洋世界馆（特价票）", "张 /（万元）人民币");
			threeFourcol.put("宗教文化馆（一般票）", "张 /（万元）人民币");
			threeFourcol.put("宗教文化馆（特价票）", "张 /（万元）人民币");
			
			Map<String, Map<String,String>> twocol = new LinkedHashMap<String, Map<String,String>>();
			twocol.put("APP售票", threeFourcol);
			twocol.put("官网售票", threeFourcol);
			twocol.put("微信售票", threeFourcol);
			twocol.put("OTA售票", threeFourcol);
			
			String onecolstr = "票务销售统计";
			
			Map<String,String> foot = new LinkedHashMap<String, String>();
			foot.put("本日票务销售统计", "");
			ExcelUtil.downLoad(title, headerTitle, header, twocol, onecolstr, foot,filename,resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		return null;
	}

}
