package cn.happyworlds.imgmt.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aipg.common.AipgReq;
import com.aipg.common.InfoReq;
import com.aipg.payreq.Body;
import com.aipg.payreq.Trans_Detail;
import com.aipg.payreq.Trans_Sum;
import com.allinpay.XmlTools;


/*import com.aipg.common.AipgReq;
import com.aipg.common.InfoReq;
import com.aipg.payreq.Body;
import com.aipg.payreq.Trans_Detail;
import com.aipg.payreq.Trans_Sum;
import com.allinpay.XmlTools;*/

import cn.happyworlds.imgmt.entity.TranxCon;
import cn.happyworlds.imgmt.tlpay.HttpConnectionUtil;
import cn.happyworlds.imgmt.tlpay.PoolHttpConnections;
import cn.happyworlds.imgmt.tlpay.SybConstants;
import cn.happyworlds.imgmt.tlpay.SybUtil;
import cn.happyworlds.imgmt.util.HttpPostUtil;
import cn.happyworlds.imgmt.util.JsonPalmView;
import cn.happyworlds.imgmt.util.StatusResult;

@Service
public class SybWxPayService {
	
	TranxCon tranxContants=new TranxCon();
	private static final Logger LOG = LoggerFactory.getLogger(SybWxPayService.class);
	/**
	 * 通联统一支付接口
	 * @param trxamt		支付金额，单位分
	 * @param reqsn			商户交易订单号，保证唯一
	 * @param paytype		交易方式，W04-微信扫码；A04-支付宝扫码； 其他待补充
	 * @param body			订单标题
	 * @param remark		备注
	 * @param acct			支付平台用户标识，JS支付时使用  微信支付-用户的微信openid  支付宝支付-用户user_id  微信公众号及支付宝服务窗不可为空
	 * @param authcode		扫码获得的字符串
	 * @param notify_url	交易结果通知地址  接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
	 * @param limit_pay		支付限制  no_credit--指定不能使用信用卡支付
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> pay(long trxamt,String reqsn,String paytype,String body,String remark,String acct,String authcode,String notify_url,String limit_pay) throws Exception{
		HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL+"/pay");
		System.out.println("扫码枪调通联支付域名："+SybConstants.SYB_APIURL+"/pay");
		http.init();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("cusid", SybConstants.SYB_CUSID);
		params.put("appid", SybConstants.SYB_APPID);
		params.put("version", "11");
		params.put("trxamt", String.valueOf(trxamt));
		params.put("reqsn", reqsn);
		params.put("paytype", paytype);
		params.put("randomstr", SybUtil.getValidatecode(8));
		params.put("body", body);
		params.put("remark", remark);
		params.put("acct", acct);
		params.put("authcode", authcode);
		params.put("notify_url", notify_url);
//		params.put("limit_pay", limit_pay);
		params.put("sign", SybUtil.sign(params,SybConstants.SYB_APPKEY));
		System.out.println(params);
		
		Map<String, Object> headers = new HashMap<>();
		long start = System.currentTimeMillis();
//		PoolHttpConnections poolConnections = new PoolHttpConnections();
		String result = PoolHttpConnections.httpPostByMap(SybConstants.SYB_APIURL+"/pay", headers, params);
		long end = System.currentTimeMillis();
		LOG.info("支付耗时time:{}", (end - start));
		
//		long start1 = System.currentTimeMillis();
//		byte[] bys = http.postParams(params, true);
//		long end1 = System.currentTimeMillis();
//		LOG.info("支付耗时time:{}", (end1 - start1));
//		String result = new String(bys,"UTF-8");
		
		System.out.println("result:" + result);
		Map<String,String> map = handleResult(result);
		return map;
	}
	/**
	 * 通联统一支付接口
	 * @param trxamt		支付金额，单位分
	 * @param reqsn			商户交易订单号，保证唯一
	 * @param paytype		交易方式，W04-微信扫码；A04-支付宝扫码； 其他待补充
	 * @param body			订单标题
	 * @param remark		备注
	 * @param acct			支付平台用户标识，JS支付时使用  微信支付-用户的微信openid  支付宝支付-用户user_id  微信公众号及支付宝服务窗不可为空
	 * @param authcode		扫码获得的字符串
	 * @param notify_url	交易结果通知地址  接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
	 * @param limit_pay		支付限制  no_credit--指定不能使用信用卡支付
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> pay_old(long trxamt,String reqsn,String paytype,String body,String remark,String acct,String authcode,String notify_url,String limit_pay) throws Exception{
		HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL+"/pay");
		System.out.println("扫码枪调通联支付域名："+SybConstants.SYB_APIURL+"/pay");
		http.init();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("cusid", SybConstants.SYB_CUSID);
		params.put("appid", SybConstants.SYB_APPID);
		params.put("version", "11");
		params.put("trxamt", String.valueOf(trxamt));
		params.put("reqsn", reqsn);
		params.put("paytype", paytype);
		params.put("randomstr", SybUtil.getValidatecode(8));
		params.put("body", body);
		params.put("remark", remark);
		params.put("acct", acct);
		params.put("authcode", authcode);
		params.put("notify_url", notify_url);
		params.put("limit_pay", limit_pay);
		params.put("sign", SybUtil.sign(params,SybConstants.SYB_APPKEY));
		System.out.println(params);
		
//		Map<String, Object> headers = new HashMap<>();
//		long start = System.currentTimeMillis();
//		PoolHttpConnections poolConnections = new PoolHttpConnections();
//		String result = poolConnections.httpPostByMap(SybConstants.SYB_APIURL+"/pay", headers, params);
//		long end = System.currentTimeMillis();
//		LOG.info("支付耗时time:{}", (end - start));
		
		long start1 = System.currentTimeMillis();
		byte[] bys = http.postParams(params, true);
		long end1 = System.currentTimeMillis();
		LOG.info("老接口支付耗时time:{}", (end1 - start1));
		String result = new String(bys,"UTF-8");
		
		System.out.println("result:" + result);
		Map<String,String> map = handleResult(result);
		return map;
	}
	/**
	 * 撤销交易
	 * @param trxamt		原订单金额
	 * @param reqsn			商户的退款交易订单号
	 * @param oldtrxid		原交易的收银宝平台流水
	 * @param oldreqsn		原交易的商户交易单号
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> cancel(long trxamt,String reqsn,String oldtrxid,String oldreqsn) throws Exception{
		HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL+"/cancel");
		http.init();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("cusid", SybConstants.SYB_CUSID);
		params.put("appid", SybConstants.SYB_APPID);
		params.put("version", "11");
		params.put("trxamt", String.valueOf(trxamt));
		params.put("reqsn", reqsn);
		params.put("oldtrxid", oldtrxid);
		params.put("oldreqsn", oldreqsn);
		params.put("randomstr", SybUtil.getValidatecode(8));
		params.put("sign", SybUtil.sign(params,SybConstants.SYB_APPKEY));
		byte[] bys = http.postParams(params, true);
		String result = new String(bys,"UTF-8");
		Map<String,String> map = handleResult(result);
		return map;
	}
	/**
	 * 现场微信支付宝退货交易
	 * @param trxamt		退款金额
	 * @param reqsn			商户的退款交易订单号
	 * @param oldtrxid		原交易的收银宝平台流水
	 * @param oldreqsn		原交易的商户订单号
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> refund(long trxamt,String reqsn,String oldtrxid,String oldreqsn) throws Exception{
		HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL+"/refund");
		http.init();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("cusid", SybConstants.SYB_CUSID);
		params.put("appid", SybConstants.SYB_APPID);
		params.put("version", "11");
		params.put("trxamt", String.valueOf(trxamt));
		params.put("reqsn", reqsn);
		params.put("oldreqsn", oldreqsn);
		params.put("oldtrxid", oldtrxid);
		params.put("randomstr", SybUtil.getValidatecode(8));
		params.put("sign", SybUtil.sign(params,SybConstants.SYB_APPKEY));
		byte[] bys = http.postParams(params, true);
		String result = new String(bys,"UTF-8");
		Map<String,String> map = handleResult(result);
		return map;
	}
	
	public Map<String,String> query(String reqsn,String trxid) throws Exception{
		HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL+"/query");
		http.init();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("cusid", SybConstants.SYB_CUSID);
		params.put("appid", SybConstants.SYB_APPID);
		params.put("version", "11");
		params.put("reqsn", reqsn);
		params.put("trxid", trxid);
		params.put("randomstr", SybUtil.getValidatecode(8));
		params.put("sign", SybUtil.sign(params,SybConstants.SYB_APPKEY));
		byte[] bys = http.postParams(params, true);
		String result = new String(bys,"UTF-8");
		Map<String,String> map = handleResult(result);
		return map;
	}
	
	
	public static Map<String,String> handleResult(String result) throws Exception{
		Map map = SybUtil.json2Obj(result, Map.class);
		if(map == null){
			throw new Exception("返回数据错误");
		}
		if("SUCCESS".equals(map.get("retcode"))){
			TreeMap tmap = new TreeMap();
			tmap.putAll(map);
			String sign = tmap.remove("sign").toString();
			String sign1 = SybUtil.sign(tmap,SybConstants.SYB_APPKEY);
			if(sign1.toLowerCase().equals(sign.toLowerCase())){
				System.out.println(map);
				return map;
			}else{
				throw new Exception("验证签名失败");
			}
			
		}else{
			throw new Exception(map.get("retmsg").toString());
		}
	}
	/**
	 * 移动POS支付接口
	 * @param ip		移动POS IP地址（测试地址为192.168.1.79）
	 * @param business_id	业务类型（100100001）银行卡收款		业务类型（100300001）扫码支付收款
	 * @param amount		金额（分为单位）
	 * @param trans_check	交易唯一标识
	 * @return
	 * @throws Exception
	 */
	public StatusResult<String> batchzhinengPOS(String ip,String business_id,String amount,String trans_check) throws Exception{
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
        JsonPalmView jp = new JsonPalmView();
        jp.setCb_state(params);
        data =jp.getCb_state().toString();		
		data = data.replace("{", "");
        data = data.replace("}", "");
        data = data.replace(",", "&");
        data = data.replace(" ", "");
		String receive = HttpPostUtil.doPost(url, data);
		return StatusResult.create(receive);
	}
	/**
	 * 移动POS撤销接口
	 * @param ip		移动POS IP地址（测试地址为192.168.1.79）
	 * @param business_id	业务类型（200100001）银行卡撤销		业务类型（200300001）扫码撤销
	 * @param amount		金额（分为单位）
	 * @param origTransNo	原始流水号
	 * @param trans_check	交易唯一标识
	 * @return
	 * @throws Exception
	 */
	public StatusResult<String> batchzhinengPOSCancel(String ip,String business_id,String amount,String origTransNo, String trans_check) throws Exception{
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
        params.put("ORIG_TRANS_NO", origTransNo);
        JsonPalmView jp = new JsonPalmView();
        jp.setCb_state(params);
        data =jp.getCb_state().toString();		
		data = data.replace("{", "");
        data = data.replace("}", "");
        data = data.replace(",", "&");
        data = data.replace(" ", "");
		String receive = HttpPostUtil.doPost(url, data);
		return StatusResult.create(receive);
	}
	/**
	 * 移动POS退款接口
	 * @param ip		移动POS IP地址（测试地址为192.168.1.79）
	 * @param business_id	业务类型（300100001）银行卡撤销		业务类型（300300001）扫码撤销
	 * @param amount		金额（分为单位）
	 * @param origRefNo		原系统参考号
	 * @param origDate		原交易日期
	 * @param trans_check	交易唯一标识
	 * @return
	 * @throws Exception
	 */
	public StatusResult<String> batchzhinengPOSRefund(String ip,String business_id,String amount,String origRefNo,String origDate, String trans_check) throws Exception{
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
        params.put("ORIG_REF_NO", origRefNo);
        params.put("ORIG_DATE", origDate);
        JsonPalmView jp = new JsonPalmView();
        jp.setCb_state(params);
        data =jp.getCb_state().toString();		
		data = data.replace("{", "");
        data = data.replace("}", "");
        data = data.replace(",", "&");
        data = data.replace(" ", "");
		String receive = HttpPostUtil.doPost(url, data);
		return StatusResult.create(receive);
	}
	
	/**
	 * 
	 * @param AMOUNT		金额
	 * @param ACCOUNT_NO	银行卡号
	 * @param ACCOUNT_NAME	用户名
	 * @return
	 * @throws DocumentException 
	 * @throws Exception
	 */
	public StatusResult<String> batchDaiShou(String AMOUNT,String ACCOUNT_NO,String ACCOUNT_NAME) throws DocumentException {	
		String REQ_SN = null;
		String a = null;
		try {
			String url = "https://tlt.allinpay.com/aipg/ProcessServlet";
			boolean isTLTFront = false;
			String xml="";
			Double db = Double.parseDouble(AMOUNT);
			int i =(new Double(db*100).intValue());
			AMOUNT = String.valueOf(i);
			AipgReq aipg=new AipgReq();
			InfoReq info=makeReq("100002");
			aipg.setINFO(info);
			Body body = new Body() ;
			Trans_Sum trans_sum = new Trans_Sum() ;
			trans_sum.setBUSINESS_CODE("09900") ;
			trans_sum.setMERCHANT_ID(tranxContants.merchantId) ;
			trans_sum.setTOTAL_ITEM("1") ;
			trans_sum.setTOTAL_SUM(AMOUNT) ;
			body.setTRANS_SUM(trans_sum) ;
			List <Trans_Detail>transList = new ArrayList<Trans_Detail>() ;
			Trans_Detail trans_detail = new Trans_Detail() ;
			trans_detail.setSN("0001") ;
	    	trans_detail.setACCOUNT_NAME(ACCOUNT_NAME) ;
	 		trans_detail.setACCOUNT_PROP("0") ;
			trans_detail.setACCOUNT_NO(ACCOUNT_NO) ;
			trans_detail.setAMOUNT(AMOUNT) ;
			trans_detail.setCURRENCY("CNY");
			transList.add(trans_detail) ;
	        body.setDetails(transList) ;
	        aipg.addTrx(body) ;		
	        xml=XmlTools.buildXml(aipg,true);//.replaceAll("</INFO>", "</INFO><BODY>").replaceAll("</AIPG>", "</BODY></AIPG>"););
	        a = isFront(xml,isTLTFront,url);
		} finally {
			if(a == null){
	        	StatusResult.create("通联代付接口异常"); 
	        }
	        Document doc = DocumentHelper.parseText(a);
			//指向根节点
	        Element root = doc.getRootElement();        
	        List<Element> elements = root.elements();
	        String RET_CODE = elements.get(0).element("RET_CODE").getStringValue();
	        String ERR_MSG = elements.get(0).element("ERR_MSG").getStringValue();
	        REQ_SN = elements.get(0).element("REQ_SN").getStringValue();
	        
	        if(!"0000".equals(RET_CODE) && "受理成功".equals(ERR_MSG)){
	        	StatusResult.create("FAIL","返回码："+RET_CODE+"返回信息："+ERR_MSG);
	        }
		}
		       
		return StatusResult.create(REQ_SN); 
	}

	/**
	 * 组装报文头部
	 * @param trxcod
	 * @return
	 *日期：Sep 9, 2012
	 */
	private InfoReq makeReq(String trxcod)
	{
		  
		InfoReq info=new InfoReq();
		info.setTRX_CODE(trxcod);
		info.setREQ_SN(tranxContants.merchantId+"-"+String.valueOf(System.currentTimeMillis()));
		info.setUSER_NAME(tranxContants.userName);
		info.setUSER_PASS(tranxContants.password);
		info.setMERCHANT_ID(tranxContants.merchantId);
		info.setLEVEL("5");
		info.setDATA_TYPE("2");
		info.setVERSION("03");
		return info;
	}
	
	public String isFront(String xml,boolean flag,String url) {
		try{
			if(!flag){
				xml=this.signMsg(xml);
			}else{
				xml=xml.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
			}
			return sendXml(xml,url,flag);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 报文签名
	 * @param msg
	 * @return
	 *日期：Sep 9, 2012
	 * @throws Exception 
	 */
	public String signMsg(String xml) throws Exception{
		xml=XmlTools.signMsg(xml, tranxContants.pfxPath,tranxContants.pfxPassword, false);
		return xml;
	}
	
	public String sendXml(String xml,String url,boolean isFront) throws UnsupportedEncodingException, Exception{
		System.out.println("======================发送报文======================：\n"+xml);
//		String resp=XmlTools.send(url,new String(xml.getBytes(),"GBK"));
		String resp=XmlTools.send(url,xml);
		System.out.println("======================响应内容======================") ;
		//System.out.println(new String(resp.getBytes(),"GBK")) ;
		boolean flag= this.verifyMsg(resp, tranxContants.tltcerPath,isFront);
		if(flag){
			System.out.println("响应内容验证通过") ;
		}else{
			System.out.println("响应内容验证不通过") ;
		}
		return resp;
	}
	
	/**
	 * 验证签名
	 * @param msg
	 * @return
	 *日期：Sep 9, 2012
	 * @throws Exception 
	 */
	public boolean verifyMsg(String msg,String cer,boolean isFront) throws Exception{
		 boolean flag=XmlTools.verifySign(msg, cer, false,isFront);
		System.out.println("验签结果["+flag+"]") ;
		return flag;
	}
	
	
	
	
	
}
