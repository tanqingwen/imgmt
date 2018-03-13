package cn.happyworlds.imgmt.web;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.service.BatchCrdtblService;
import cn.happyworlds.imgmt.service.CpCrdtblService;
import cn.happyworlds.imgmt.to.Constants;
import cn.happyworlds.imgmt.util.StatusResult;


@Controller
@RequestMapping("/batchcrdtbl")
public class BatchCrdtblController {
	
	@Autowired
	private BatchCrdtblService batchCrdtblService;
	@Autowired
	private CpCrdtblService cpCrdtblService;

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m,RedirectAttributes ra) {
		String crdNo =cpCrdtblService.searchMaxCrdNo();
		System.out.println("+++"+crdNo);
		Integer number = Integer.parseInt(crdNo)+1;
		m.addAttribute("startCardNo",number);
		m.addAttribute("remainingNumber",Constants.MAX_SERIALNO - number);
		return "batchcard/add";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/makeCard", method = RequestMethod.POST)
	public StatusResult<String> makeCard(String startCardNo,String number,String custLevel) throws ParseException {
		
		int startCardNo1=0;
		int number1=0;
		try { 
		    startCardNo1 = Integer.parseInt(startCardNo); 
		} catch (NumberFormatException e) { 
			return StatusResult.create("FALSE","代码异常"); 
		}
		try { 
			number1=Integer.parseInt(number); 
		} catch (NumberFormatException e) { 
			return StatusResult.create("FALSE","代码异常"); 
		}
		for(int i=startCardNo1; i<startCardNo1+number1;i++){
			StatusResult<String> r = batchCrdtblService.insertDate(custLevel, i);
			if("FALSE".equals(r.getStatus())){
				return StatusResult.create("FALSE","批量制卡失败");
			}
		}
		return StatusResult.create("OK","批量开卡成功"); 
	}
	
}	
