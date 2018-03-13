package cn.happyworlds.imgmt.web;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.service.CrdtblService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/intcrdtbl")
public class IntCrdtblController {
	
	
	@Autowired
	private CrdtblService crdtblService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private RoleService roleService;
	

	@WebAction(Permission.INTCARD_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("roles", roleService.roleList());
		return "intcrdtbl/add";
	}
	
//	非实现预售开票作业
	@WebAction(Permission.NON_REAL_NAME_VOTING)
	@RequestMapping(value = "/nonAdd",method = RequestMethod.GET)
	public String nonAdd(Model m){
		m.addAttribute("roles", roleService.roleList());
		return "intcrdtbl/nonAdd";
	}
	
	//柜台购票提交
	@WebAction(Permission.INTCARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	public StatusResult<String> addTicket(String cardNo,String idNo,String ticketType,String paperNo,String amount,String status) {
		String staffId = WebContext.getCurrentStaff().getId();
		return ticketService.addTicket(cardNo, idNo, ticketType, paperNo, amount, status, staffId);
	}

	
	// 选中票券类别时计算折扣
	@WebAction(Permission.INTCARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/tkpriceInf", method = RequestMethod.POST)
	public StatusResult<BigDecimal> tkpriceInf(String ttTypeId, String prodct, String num) {
		
		return ticketService.tkpriceInf(ttTypeId, prodct,false);
	}	
	
	
	//根据手机号定位信息
	@WebAction(Permission.INTCARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/cardInfoByMobile", method = RequestMethod.POST)
	public StatusResult<String[]> cardInfoByMobile(String mobileNo) {
		
		return ticketService.cardInfoByMobile(mobileNo);
	}
	
	//预售开卡 绑卡动作
	@WebAction(Permission.INTCARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/openCard", method = RequestMethod.POST)
	public StatusResult<String> openCard(String cbCardholderNo,String idNo,String orderid,String uname) throws Exception{
		//身份证
		String staffId = WebContext.getCurrentStaff().getId();
		if(idNo.length()==18){
			String birthday = idNo.substring(6, 14);
			return crdtblService.openHCardInt(cbCardholderNo, idNo, uname, birthday, orderid, staffId);
		}else{
			return crdtblService.openHCardInt2(cbCardholderNo, idNo, uname, orderid, staffId);
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryTkticket", method=RequestMethod.POST)
	public StatusResult<CpTicket> queryTkTicket(String tkTicketId){
		System.out.println("orderId------"+tkTicketId);
		return ticketService.queryTkTicketId(tkTicketId);
	}
	
/*	public StatusResult<List<String>> genCardNo(String mobile,String prProdctGroup) {	
		try{
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("cbCardPrdctGroup", prProdctGroup);
			params.put("cbIdno", mobile);
			
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
		
	}*/
}
