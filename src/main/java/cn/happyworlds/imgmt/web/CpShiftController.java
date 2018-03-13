package cn.happyworlds.imgmt.web;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpShift;
import cn.happyworlds.imgmt.entity.Shifting;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.ShiftingMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpShiftService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping(value="/shift")
public class CpShiftController {
	//private static final Logger log = LoggerFactory.getLogger(CpShiftController.class);
	@Autowired
	private CpShiftService  cpShiftService; 
	
	@Autowired
	private ShiftingMapper shiftingMapper;
	
	/**
	 * 条件查询 所有交班 接班数据
	 * @param id
	 * @param xx
	 * @param XXX
	 * @param p
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/list")
	public String getAllShift(HttpServletRequest request, String id,String venueId, Integer p,Map<String,Object> map,Model m){
		
		String shiftType = request.getParameter("shiftType");
		String cpShiftDate=request.getParameter("submitTime");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		Result<PageInfo<CpShift>> result=cpShiftService.findAll(id, shiftType, venueId,cpShiftDate, new PageBounds(p, 10));
		map.put("cpShift",result.getValue());
		if(cpShiftDate!=null){
			m.addAttribute("ctApproveTimeEnd",ctApproveTimeEnd);
			m.addAttribute("cpShiftDate",cpShiftDate);
			m.addAttribute("shiftType", shiftType);
		}
		
	 return "shift/list";
	}
	/**
	 * 查看页面交班与结班
	 * @param id
	 * @param type
	 * @param map1
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value="/view/{cpShiftId}/{cpShiftType}")
	public String getShiftById(@PathVariable("cpShiftId") Integer id,@PathVariable("cpShiftType") String type,  Map<String,Object> map1,Model m) throws UnknownHostException {
		CpShift shift= cpShiftService.getShiftById(id);
		String posIp= shift.getCpShiftPosno();
		if(!StringUtils.isEmpty(shift)){
			Map<String, String> map=new HashMap<>();
			shift.getCpShiftUserno();
			shift.getCpShiftDate();
			String jbzqsj= shift.getCpShiftXykcz();
			map.put("userId", shift.getCpShiftUserno());
			map.put("day", shift.getCpShiftDate());
			map.put("ip", posIp);
			map.put("jbzqsj", jbzqsj);//交结班准确时间
			List<Shifting> list=shiftingMapper.searchShifting2(map);//查询票种
			m.addAttribute("list",list);
		}
		
		map1.put("shift", shift);
		
		
		if(type.equals("1")){ //交班
			return "shift/view";
		}
		if(type.equals("2")){ //结班
			return "shift/viewes";
		}
		return "error";
	}
	/**
	 * 导出excel接口
	 */
	@RequestMapping(value="/isDownLoad",method = RequestMethod.POST )
	public String listDownLoad(HttpServletRequest request,HttpServletResponse resp,RedirectAttributes ra){
		TSysStaff staff=WebContext.getCurrentStaff();
		String cpShiftDate=request.getParameter("submitTime");
		String shiftType=request.getParameter("shiftType");
		System.out.println(shiftType);
		Result<String> result=cpShiftService.listDownLoadMethod(cpShiftDate,shiftType, staff.getId(), resp);
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/shift/list";
		}
		return null;
	}
}























