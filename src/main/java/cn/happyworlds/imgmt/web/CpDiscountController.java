package cn.happyworlds.imgmt.web;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpDiscount;
import cn.happyworlds.imgmt.entity.DisUser;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.DisUserMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpCsttblService;
import cn.happyworlds.imgmt.service.CpDiscountService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("cpDiscount")
public class CpDiscountController {
	
	@Autowired
	private CpDiscountService cpDiscountService;
	
	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	
	@Autowired
	private DisUserMapper disUserMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(CpDiscountController.class);
	
	@WebAction(Permission.CPDISCOUNT_LIST)
	@RequestMapping("/list")
	public String list(String disId,String disDesc,Integer p,Model m){
		Result<PageInfo<CpDiscount>> r=cpDiscountService.discountList(disId, disDesc,new PageBounds(p,10));
		if(r.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		}else{
			m.addAttribute("disId", disId);
			m.addAttribute("disDesc", disDesc);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "coupon/list";
	}
	
	@WebAction(Permission.CPDISCOUNT_ADD)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model m){
		String maxDisId=cpDiscountService.seachMax();
		m.addAttribute("disId", maxDisId);
		return "coupon/add";
	}
	
	@WebAction(Permission.CPDISCOUNT_ADD)
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(RedirectAttributes ra,CpDiscount cpDiscount,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws ParseException{
		System.out.println("------filess---:"+file.getOriginalFilename());
		if(file.isEmpty()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "优惠券图片不能为空");
			return "redirect:/cpDiscount/add";
		}
		if(!StringUtils.isEmpty(cpDiscount.getDisService()))
			cpDiscount.setDisService(cpDiscount.getDisService().trim());
//		数据库存储路径
		String temp ="yanwu"+File.separator+"images"+File.separator;
//		获取图片名称
		String fileName=file.getOriginalFilename();
//		获取图片后缀名
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
//		新图片名称
		String newFileName=String.valueOf(System.currentTimeMillis())+suffixName;
//		上传的文件名称为
		logger.info("上传的图片名为：" + newFileName);
//		获取根目录 图片上传后的路径
		String rootPath=request.getServletContext().getRealPath("/")+"assets/yanwu/images/";
		File dest=new File(rootPath+newFileName);
//		检测是否存在目录
		if(!dest.getParentFile().exists()){
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
		} catch (IllegalStateException  e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		cpDiscount.setDisUrl(temp.concat(newFileName));
		Result<CpDiscount> r=cpDiscountService.discountAdd(cpDiscount);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpDiscount/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "优惠券添加成功");
		return  "redirect:/cpDiscount/list";
	}
	
	@WebAction(Permission.CPDISCOUNT_UPDATE)
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String disId,Model m){
		CpDiscount discount= cpDiscountService.discountById(disId);
		m.addAttribute("discount", discount);
		return "coupon/update";
	}
	
	@WebAction(Permission.CPDISCOUNT_UPDATE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(CpDiscount discount,RedirectAttributes ra){
		Result<CpDiscount> r=cpDiscountService.discountUpdate(discount);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpDiscount/update?disId=" + discount.getDisId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "优惠券更新成功");
		return "redirect:/cpDiscount/list";
	}
	
	@WebAction(Permission.CPDISCOUNT_SHOW)
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String show(String disId,Model m){
		CpDiscount discount = cpDiscountService.discountById(disId);
		List<Map<String, String>> cpCst= cpCsttblMapper.searchCpcsttblByDiscount(disId);
		for(int i=0;i<cpCst.size();i++) {
			if("N".equals(cpCst.get(i).get("disStatus")))
				cpCst.get(i).put("selectedIf", "selected");
		}
		Map<String, String> map = new HashMap<>();
		List<DisUser> disUsers = null;
		if(!StringUtils.isEmpty(disId)) {
			map.put("disId", disId);
			disUsers = disUserMapper.searchDisUserByParams(map);
		}
		StringBuilder sb = new StringBuilder();
		if(disUsers != null && disUsers.size() > 0) {
			discount.setHasUsed("Y");
			for(DisUser disUser : disUsers) {
				sb.append(",").append(disUser.getUserId());
			}
			m.addAttribute("readonlyIf", "readonly");
			m.addAttribute("disabledIf", "disabled");
			if(sb.length() > 0)
				discount.setUsersId(sb.substring(1).toString());
		}
		m.addAttribute("users", cpCst);
		m.addAttribute("item", discount);
		return "coupon/show";
	}
	
	@WebAction(Permission.CPDISCOUNT_UPDATE)
	@RequestMapping(value="/updateShow",method=RequestMethod.POST)
	public String updateShow(CpDiscount discount,RedirectAttributes ra){
		System.out.println(ReflectionToStringBuilder.toString(discount, ToStringStyle.SHORT_PREFIX_STYLE));
		Result<CpDiscount> r=cpDiscountService.discountUpdate(discount);
		String disId = discount.getDisId();
		Map<String, String> map1=new HashMap<String,String>();
		map1.put("disId", disId);
		map1.put("disStatus", "N");
		disUserMapper.deleteDisUserByParams(map1);
		if(StringUtils.isNotEmpty(discount.getUsersId())) {
			String[] ids = discount.getUsersId().split(",");
			if(StringUtils.isNotEmpty(disId)) {
				for(int i=0;i<ids.length;i++){
					DisUser user=new DisUser();
					user.setUserId(ids[i]);
					user.setDisId(disId);
					user.setDisStatus("N");
					disUserMapper.insertDisUser(user);
				}
			}
		}
		
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpDiscount/update?disId=" + discount.getDisId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "优惠券更新成功");
		return "redirect:/cpDiscount/list";
	}
	
	@WebAction(Permission.CPDISCOUNT_DELETE)
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(String disId,RedirectAttributes ra){
		Result<CpDiscount> r=cpDiscountService.discountDelete(disId);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpDiscount/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "优惠券删除成功");
		return "redirect:/cpDiscount/list";
	}
	
	@WebAction(Permission.CPDISCOUNT_SHOW)
	@RequestMapping(value="/addUsers")
	public String addUsers(String disId,String usersId,RedirectAttributes ra){
		String[] ids = usersId.split(",");
		if(ids.length<=0){
			ra.addAttribute(WebContext.ACTION_FAILURE_TIP, "请至少选择一个用户");
			return "redirect:/cpDiscount/show";
		}
		System.out.println(ids.length);
		DisUser user=new DisUser();
		for(int i=0;i<ids.length;i++){
			Map<String, String> map=new HashMap<String,String>();
			map.put("userId", ids[i]);
			map.put("disId", disId);
			List<DisUser> dis=disUserMapper.searchDisUserByParams(map);
			if(dis.size()<=0){
				user.setUserId(ids[i]);
				user.setDisId(disId);
				user.setDisStatus("N");
				disUserMapper.insertDisUser(user);
			}
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "优惠券成功绑定用户!");
		return "redirect:/cpDiscount/list";
	}
}
