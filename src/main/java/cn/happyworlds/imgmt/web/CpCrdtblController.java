package cn.happyworlds.imgmt.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.service.CpCrdtblService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/cpcrdtbl")
public class CpCrdtblController {
	
	
	@Autowired
	private CpCrdtblService cpcrdtblService;
	
	/**
	 * 会员ID，会员姓名，会员手机号，会员证件号
	 */
	
	//订单查询，返回查询字段订单号，会员号，手机号，通道，支付列表号，金额，订单状态，凭据，添加时间，支付时间，完成时间，详情
	@RequestMapping("/cpcrdtblCbIdno")
	public String CpCrdtblCbIdno(HttpServletRequest  request,Model m) {

		String cbCustomerIdno=request.getParameter("cbCustomerIdno");
			
		Result<CpCrdtbl> result = cpcrdtblService.searchCpCsttblCbIdno(cbCustomerIdno);  
		try {
			if (result.isError()) {
				m.addAttribute(WebContext.ACTION_FAILURE_TIP, "没有绑定会员卡");
				return "member/list";
			} else {
				m.addAttribute("pageInfo", result.getValue());
			}
		} catch (Exception e) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			// TODO: handle exception
			e.printStackTrace();
		}	
		return "member/list_card";
	}
	
	
	
}
