package cn.happyworlds.imgmt.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.service.CpTicketService;
import cn.happyworlds.imgmt.service.CpTktypeService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PrtickeService;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/prticke")
public class PrtickeController {
	
	@Autowired
	private CpTicketService cpTicketService;
	@Autowired
	private IdtypeService IdtypeService;
	
	@Autowired
	private PrtickeService PrtickeService;
	@Autowired
	private CpTktypeService cpTktypeService;
	
	@WebAction(Permission.BUYTICKET_ADD)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model m){
		/*Result<List<CpTktype>> tkTypeList = tktypeService.tktypeListAll();
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		String nowDate = SysDateFormat.getNowDate("yyyyMMdd");
		tkTypeList=ticketService.getTkTypeList(nowDate,tkTypeList);
		if(buyCpprdgrpService.ifLegalHoliday(nowDate)){
			List<CpTktype> tkTypeAll = tkTypeList.getValue();
			for (int i = 0; i < tkTypeAll.size(); i++) {
				BigDecimal Price = tkTypeAll.get(i).getTtListPrice().multiply(new BigDecimal(0.8));
				tkTypeAll.get(i).setTtListPrice(Price);
			}
		}
		
		m.addAttribute("tkTypeList", tkTypeList.getValue());
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("nowDate", nowDate);
		m.addAttribute("roles", roleService.roleList());*/
		
		Map<String,String> params = new HashMap<String, String>();
		params.put("ttStartDate", DateTimes.date(LocalDate.now()));
		params.put("ttEndDate", DateTimes.date(LocalDate.now()));
		params.put("ttTypeStatus", "Y");
		
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		m.addAttribute("idTypeList", idTypeList.getValue());
		List<CpTktype> list= cpTktypeService.findAllUsefulTktypeList(params);
		m.addAttribute("tkTypeList", list);
		return "prticke/add";
	}
	
	/**
	 * 
	 * 赠票逻辑处理
	 * 
	 * @param bMobileNo	手机号
	 * @param tktypeStr	票劵类别
	 * @param cbIdType		证件类型
	 * @param cbCustomerName	证件姓名
	 * @param cbCustomerIdno	证件号码
	 * @param CbDob		出生日期
	 * @param ticketform		票劵形式
	 * @return
	 */
	@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/Cash_ticket", method = RequestMethod.POST)
	public StatusResult<String> buy_ticket(String data){
		System.out.println("----:"+data.toString());
		
		return PrtickeService.activiteCardAndBuy(data);	
	}
	
	
	//查询出卡面号
	@ResponseBody
	@RequestMapping(value = "/kamianhao", method = RequestMethod.POST)
	public StatusResult<String> kamianhao(String cardNo) {
		return cpTicketService.kamianhaiselect(cardNo);
	}
}
