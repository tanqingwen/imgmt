package cn.happyworlds.imgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpShift;
import cn.happyworlds.imgmt.entity.FinancialStatement;
import cn.happyworlds.imgmt.mapper.CpShiftMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.ExcelUtil;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpShiftService {
	@Autowired
	private CpShiftMapper cpShiftMapper;
	
	
	public Result<PageInfo<CpShift>> findAll(String id,String shiftType,String venueId,String cpShiftDate, PageBounds pageBounds){
	   Map<String, String> map=new HashMap<>();
	   map.put("id", id);
	   map.put("cpShiftType", shiftType);
	   map.put("cpShiftDate", cpShiftDate);
	   
	   List<CpShift> page=cpShiftMapper.searchCpShiftByParams(map, pageBounds);
	   return Result.create(new PageInfo<CpShift>(page));
	}


	public CpShift getShiftById(Integer id) {
		 return cpShiftMapper.searchCpShiftByCpShiftId(id);
	}
	
	
	/**
	 * 报表
	 */
	public Result<String> listDownLoadMethod(final String cpShiftDate,final String shiftType, final String userid, HttpServletResponse resp){
		try {
			Map<String, String> params = new HashMap<>();
			String amoutstr = "";
			if (StringUtils.hasText(cpShiftDate)) {
				params.put("cpShiftDate", cpShiftDate);
			}
			if(StringUtils.hasText(shiftType)){
				params.put("cpShiftType", shiftType);
			}
			
			/*if (StringUtils.hasText(classes)) {
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
			}*/
			List<CpShift> page = cpShiftMapper.searchCpShiftByParams(params);
		
			String title = "交结班报表"+amoutstr;//大标题，左下角的东西
			//查询列表号
			List header = new ArrayList<String>() {
				{
					add("员工");
					add("营业毛额");
					add("折扣");
					add("交易笔数");
					add("退票笔数");
					add("退票总额");
					//add("微信金额");
					add("交班小计");
					add("交结班时间");
				}
			};
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < page.size(); i++) {
				Map<String, String> record = new LinkedHashMap<String, String>();
				record.put("ygxm", page.get(i).getCpShiftUser());//员工姓名
				record.put("yyme",page.get(i).getCpShiftYyme());//营业毛额
				record.put("zkje",page.get(i).getCpShiftZhekou());//折扣金额
				record.put("jybs",page.get(i).getCpShiftJybs());//交易笔数
				record.put("tpbs",page.get(i).getCpShiftTpbs());//退票笔数
				record.put("tpze",page.get(i).getCpShiftTpze());//退票总额
				record.put("jbze","");//交班总额
				record.put("tjsj", page.get(i).getCpShiftDate());//交结班时间
				resultList.add(record);
			}
			
			Map headExtra = new LinkedHashMap<String, String>();
			Map footExtra = new LinkedHashMap<String, String>();
			headExtra.put("开始时间", cpShiftDate);
			footExtra.put("数量", String.valueOf(resultList.size()));
			ExcelUtil.downList(title, header, resultList, null, footExtra, userid,resp);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.create("DOWNLOAD_ERROR", "下载失败");
		}
		
		return null;		
	}
	
	
	
}
