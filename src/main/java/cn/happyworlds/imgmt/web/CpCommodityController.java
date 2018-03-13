package cn.happyworlds.imgmt.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;


import cn.happyworlds.imgmt.entity.CpCommodity;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.MIdtypeDict;
import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpAcqmerService;
import cn.happyworlds.imgmt.service.CpCommodityService;
import cn.happyworlds.imgmt.service.CpTktypeService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Controller
@RequestMapping("/cpCommodity")
public class CpCommodityController {

	@Autowired
	private CpCommodityService cpCommodityService;
	
	private static final Logger logger=LoggerFactory.getLogger(CpCommodityController.class);
	
	@WebAction(Permission.CPCOMMODITY_LIST)
	@RequestMapping("/list")
	public String list(String ttTypeId, String ttTypeDesc, Integer p, Model m) {
		Result<PageInfo<CpCommodity>> r =cpCommodityService.cpCommodityList(ttTypeId, ttTypeDesc, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("ccTypeId", ttTypeId);
			m.addAttribute("ccTypeDesc", ttTypeDesc);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "goods/list";
	}
	
	@WebAction(Permission.CPCOMMODITY_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUi(Model m, Integer p) {
		
		//类型id自动生成
		CpCommodity tktypeDto = cpCommodityService.searchMaxTktype();
		String nowTime = SysDateFormat.getNowDate("yyyyMMdd");
		
		m.addAttribute("ccTypeId", tktypeDto.getCcTypeId());
		m.addAttribute("nowTime", nowTime);
		
		return "goods/add";
	}
	
	/**
	 * 平台商品添加
	 * @throws ParseException 
	 */
	
	@WebAction(Permission.CPCOMMODITY_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpCommodity cpTktype,RedirectAttributes ra) throws ParseException{
		Result<CpCommodity> r = cpCommodityService.insertCpTktype(cpTktype);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpCommodity/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "商品添加成功");
		return  "redirect:/cpCommodity/list";
	}
	
	
	@WebAction(Permission.CPCOMMODITY_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Integer ccTypeId, Model m) {
		//List<CpAcqgrp> cpAcqgrps = cpAcqgrpService.CpAcqgrpList();
		CpCommodity cpTktype = cpCommodityService.searchCpTktypeByTtTypeId(ccTypeId);
		m.addAttribute("item", cpTktype);
		return "goods/update";
	}
	
	
	/**
	 * 更新
	 */
	@WebAction(Permission.CPCOMMODITY_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(CpCommodity cpTktype,RedirectAttributes ra){
		Result<CpCommodity> r = cpCommodityService.update(cpTktype);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpCommodity/update?ttTypeId=" + cpTktype.getCcTypeId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "商品更新成功");
		return "redirect:/cpCommodity/list";
	}
	
	//查看
	@WebAction(Permission.CPCOMMODITY_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(Integer ccTypeId, Model m) {
		CpCommodity cpTktype = cpCommodityService.searchCpTktypeByTtTypeId(ccTypeId);
		m.addAttribute("item", cpTktype);
		return "goods/show";
	}
	
	
	@WebAction(Permission.CPCOMMODITY_DELETE)
	@RequestMapping("/delete")
	public String delect(Integer ccTypeId, RedirectAttributes ra){
		CpCommodity cpTktype = cpCommodityService.searchCpTktypeByTtTypeId(ccTypeId);
		Result<CpCommodity> r=cpCommodityService.delect(cpTktype);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "商品删除成功");
		
		return "redirect:/cpCommodity/list";
	}
	/**
	 * 添加商品接口
	 * @param cpTktype
	 * @param ra
	 * @param file
	 * @param request
	 * @return
	 */
	
	//@WebAction(Permission.VENUE_ADD)
	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public String add(CpCommodity cpTktype,RedirectAttributes ra,@RequestParam("file") MultipartFile file,HttpServletRequest request){
		System.out.println("------filess---:"+file.getOriginalFilename());
		if(file.isEmpty()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "商品主图不能为空");
			return "redirect:/cpCommodity/add";
		}
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
		//String rootPath=request.getServletContext().getRealPath("/")+"assets/shangpin/images/";
		// 方法2 路径写死
		String rootPath= "/home/happyworld/tomcat-8.0.35/webapps/assets/shangpin/images/"; //for linux
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
		
//		场馆详细图添加
		List<MultipartFile> files=((MultipartHttpServletRequest) request).getFiles("files");
		System.out.println("files:"+files.size());
		MultipartFile fileDetailed=null;
		BufferedOutputStream stream=null;
		String dataPath="";
//		String newfileDetailedName="";
		for (int i = 0; i < files.size(); ++i) {
			fileDetailed=files.get(i);
			if(!files.isEmpty()){
				try {
					byte[] bytes=fileDetailed.getBytes();
//					获取图片名称
					String fileDetailedName=fileDetailed.getOriginalFilename();
//					获取图片后缀名
					String sufName=fileDetailedName.substring(fileDetailedName.lastIndexOf("."));
//					新图片名称
					String newfileDetailedName=i+String.valueOf(System.currentTimeMillis())+sufName;
					stream=new BufferedOutputStream(new FileOutputStream(new File(rootPath+newfileDetailedName)));
					dataPath+=newfileDetailedName+",";
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {
					stream = null;
					ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "图片详细上传失败");
					return "redirect:/cpCommodity/add";
				}
			}else{
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "图片详细上传失败");
				return "redirect:/cpCommodity/add";
			}
		}
		System.out.println("所有图片："+dataPath);
		cpTktype.setCcTicketPic(newFileName);
		cpTktype.setCcTicketPic2(dataPath.substring(0,dataPath.length()-1));
		Result<CpCommodity> r = cpCommodityService.insertCpTktype(cpTktype);   
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpCommodity/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "商品配置添加成功");
		return  "redirect:/cpCommodity/list";
	}
}
