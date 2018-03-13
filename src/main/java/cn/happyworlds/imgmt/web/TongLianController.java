package cn.happyworlds.imgmt.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.json.TypeRef;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.YwChargeMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwPayrecordMapper;
import cn.happyworlds.imgmt.service.AutomaticGrowthService;
import cn.happyworlds.imgmt.service.CpTicketService;
import cn.happyworlds.imgmt.service.SybWxPayService;
import cn.happyworlds.imgmt.util.HttpPostUtil;
import cn.happyworlds.imgmt.util.JsonPalmView;
import cn.happyworlds.imgmt.util.StatusResult;
//import cn.happyworlds.imgmt.service.SybWxPayService;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/tonglian")
public class TongLianController {

	@Autowired
	private SybWxPayService sybwxpayservice;
	@Autowired
	private CpTicketService cpTicketService;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private YwPayrecordMapper ywpayrecordMapper;
	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private YwChargeMapper ywChargeMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Value("${china-flame.ip}")
	private String chinaFlameIp;
	@Value("${china-flame.apiip}")
	private String chinaFlameApiIp;

	public String api = "http://"+chinaFlameApiIp;
	public String imgmt = "http://"+chinaFlameIp+"/imgmt";
	
	
	/**
	 * 现场支付 ---微信扫码，支付宝扫码退货
	 * @param formAmount
	 * @param payCode
	 * @param ra
	 * @param request
	 * @param formOrderId
	 * @param payType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/refund", method = RequestMethod.POST,produces = "application/json")
	public StatusResult<String> testrefund(@RequestParam("formAmount") BigDecimal formAmount,@RequestParam("reqsn") String reqsn,@RequestParam("oldtrxid")String oldtrxid,@RequestParam("oldreqsn")String oldreqsn) throws Exception{
		//http://127.0.0.1:8078/tonglian/refund?formAmount=0.01&reqsn=20171019201310105&oldtrxid=111769150000031404&oldreqsn=11117322
		long trxamt = formAmount.multiply(new BigDecimal("100")).longValue();
		Map<String, String> map =new HashMap<String, String>();
		try{
				map= sybwxpayservice.refund(trxamt,reqsn,oldtrxid,oldreqsn);
				System.out.println("++++++++:"+map);
				if("0000".equals(map.get("trxstatus"))){
					return StatusResult.create(map.toString());
				}		
			
		}catch (Exception e) {
				for(String key:map.keySet()){
					System.out.println(key+":"+map.get(key));
				}
		}
		return StatusResult.create("FAIL", "退款失败");
	}
	
	/**
	 * 智能POS银行卡退货
	 * @param business_id
	 * @param amount
	 * @param trans_check
	 * @param orig_data
	 * @param orig_ref_no
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/pos/refund", method = RequestMethod.POST,produces = "application/json")
	public StatusResult<?> posrefund(@RequestParam("business_id") String business_id,@RequestParam("amount") String amount,@RequestParam("trans_check")String trans_check,@RequestParam("orig_data")String orig_data,@RequestParam("orig_ref_no")String orig_ref_no) throws Exception{
		String ip = "192.168.1.41";
		//http://127.0.0.1:8078/tonglian/pos/refund?business_id=100300001&amount=000000000001&trans_check=111796050000034582&orig_data=1019&orig_ref_no=9072523945
		try{
			String data= null;
			Double db = Double.parseDouble(amount);
			int i =(new Double(db*100).intValue());
			amount = String.valueOf(i);
			amount = StringUtils.leftPad(amount,12, "0");
			String url = "http://"+ip+":9801/trans";
			Map<String,String> params = new HashMap<String,String>();
	        params.put("business_id", business_id);
	        params.put("amount", amount);
	        params.put("trans_check", trans_check);
	        params.put("orig_data", orig_data);
	        params.put("orig_ref_no", orig_ref_no);
	        JsonPalmView jp = new JsonPalmView();
	        jp.setCb_state(params);
	        data =jp.getCb_state().toString();		
			data = data.replace("{", "");
	        data = data.replace("}", "");
	        data = data.replace(",", "&");
	        data = data.replace(" ", "");
			String receive = HttpPostUtil.doPost(url, data);
			return StatusResult.create(receive);
				
		}catch (Exception e) {
				
		}
		return StatusResult.create("FAIL", "退款失败");
	}
	
	@RequestMapping(value = "/pos/ScanCoderefund", method = RequestMethod.POST,produces = "application/json")
	public StatusResult<?> ZNPosScanCoderefund(@RequestParam("business_id") String business_id,@RequestParam("amount") String amount,@RequestParam("trans_check")String trans_check,@RequestParam("orig_ref_no")String orig_ref_no){
		String ip = "192.168.1.40";
		//http://127.0.0.1:8078/tonglian/pos/refund?business_id=100300001&amount=000000000001&trans_check=111796050000034582&orig_data=1019&orig_ref_no=9072523945
		try{
			String data= null;
			Double db = Double.parseDouble(amount);
			int i =(new Double(db*100).intValue());
			amount = String.valueOf(i);
			amount = StringUtils.leftPad(amount,12, "0");
			String url = "http://"+ip+":9801/trans";
			Map<String,String> params = new HashMap<String,String>();
	        params.put("business_id", business_id);
	        params.put("amount", amount);
	        params.put("trans_check", trans_check);
	        params.put("orig_ref_no", orig_ref_no);
	        JsonPalmView jp = new JsonPalmView();
	        jp.setCb_state(params);
	        data =jp.getCb_state().toString();		
			data = data.replace("{", "");
	        data = data.replace("}", "");
	        data = data.replace(",", "&");
	        data = data.replace(" ", "");
			String receive = HttpPostUtil.doPost(url, data);
			return StatusResult.create(receive);
				
		}catch (Exception e) {
				
		}
		return StatusResult.create("FAIL", "退款失败");
	}

	//
	@WebAction(Permission.BUYTICKET_ADD)
	@RequestMapping(value = "/daifu", method = RequestMethod.POST,produces = "application/json")
	public StatusResult<String> pay(String data)throws Exception{
		Map<String, String> val = Jackson.readJson(data, new TypeRef<Map<String, String>>());
		String orderId = val.get("orderId");
		
		YwOrder ywOrder =ywOrderMapper.searchYwOrderByHwOrderId(orderId);
		if(ywOrder == null){
			return StatusResult.create("FAIL", "找不到该订单号:"+orderId);
		}
		if("Y".equals(ywOrder.getHwPaymentStatus())){
			return StatusResult.create("FAIL", "该订单号已支付:"+orderId);
		}

		return null;
	}
}