package cn.happyworlds.imgmt.web;


import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpAcqgrp;
import cn.happyworlds.imgmt.entity.CpAcqmer;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpAcqgrpService;
import cn.happyworlds.imgmt.service.CpAcqmerService;
import cn.happyworlds.imgmt.service.CpMermstService;
import cn.happyworlds.imgmt.util.FileUploadUtils;
import cn.happyworlds.imgmt.util.FileUploadUtilsInter;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.StringUtil;

@Controller
@RequestMapping("/cpacqmer")
public class CpAcqmerController {

	@Autowired
	private CpAcqgrpService cpAcqgrpService;
	@Autowired
	private CpAcqmerService cpAcqmerService;
	@Autowired
	private CpMermstService cpMermstService;
	@Value("${china-flame.ip}")
	private String chinaFlameIp;
	
	private static final Logger logger=LoggerFactory.getLogger(CpAcqmerController.class);
	
	@WebAction(Permission.VENUE_GROUP_LIST)
	@RequestMapping("/list")
	public String list(String amGroupId, String amMerchantId, Integer p, Model m) {
		Result<PageInfo<CpAcqmer>> r = cpAcqmerService.CpAcqmerAll(amGroupId,amMerchantId,new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("amGroupId", amGroupId);
			m.addAttribute("amMerchantId", amMerchantId);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "cpacqmer/list";
	}
	
	
	@WebAction(Permission.VENUE_ENTRY_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		
		CpAcqmer cpAcqmer = cpAcqmerService.maxAmGroupId();
		// List<CpMermst> cpMermsts = cpMermstService.CpMermstList();
		List<CpMermst> cpMermsts = cpMermstService.cpVenueList();
		m.addAttribute("cpAcqmer", cpAcqmer);
		m.addAttribute("cpMermsts", cpMermsts);
		return "cpacqmer/add";
	}
	

	
	@WebAction(Permission.VENUE_ENTRY_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpAcqmer cpAcqmer,RedirectAttributes ra,@RequestParam("file") MultipartFile file,HttpServletRequest request){
		//System.out.println("-------------:"+request.getRequestURL());
		System.out.println("------filess---:"+file.getOriginalFilename());
		if(file.isEmpty()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "场馆主图不能为空");
			return "redirect:/cpacqmer/add";
		}
//		数据库存储路径
		String temp ="changguan"+File.separator+"images"+File.separator;
//		获取图片名称
		String fileName=file.getOriginalFilename();
//		获取图片后缀名
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
//		新图片名称当前的时间戳
		String newFileName=String.valueOf(System.currentTimeMillis())+suffixName;
//		上传的文件名称为
		logger.info("上传的图片名为：" + newFileName);
//		获取根目录 图片上传后的路径
		//String rootPath=request.getServletContext().getRealPath("/")+"assets/yanwu/images/";
		// 方法2 路径写死
		String rootPath= "/home/happyworld/tomcat-8.0.35/webapps/assets/changguan/images/"; //for linux
		
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
					return "redirect:/cpacqmer/add";
				}
			}else{
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "图片详细上传失败");
				return "redirect:/cpacqmer/add";
			}
		}
		System.out.println("所有图片："+dataPath);
		cpAcqmer.setAmUserDefine0(newFileName);
		cpAcqmer.setAmUserDefine2(dataPath.substring(0,dataPath.length()-1));
		Result<CpAcqmer> r = cpAcqmerService.insertCpAcqmer(cpAcqmer);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpacqmer/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆配置添加成功");
		return  "redirect:/cpacqmer/list";
	}
	/**
	 * 查看场馆页面 图片
	 * @param amGroupId
	 * @param amMerchantId
	 * @param m
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(String amGroupId, String amMerchantId, Model m) {
		
		CpAcqmer cpAcqmer = cpAcqmerService.searchCpAcqmerByParams(amGroupId, amMerchantId);
		List<CpAcqgrp> cpAcqgrps = cpAcqgrpService.CpAcqgrpList();
		List<CpMermst> cpMermsts = cpMermstService.CpMermstList();
		List<String> list=new ArrayList<>();
		if(cpAcqmer.getAmUserDefine2()!=null){
			StringTokenizer st=new StringTokenizer(cpAcqmer.getAmUserDefine2(), ",");
			while (st.hasMoreElements()) {
				list.add(st.nextToken());
			}
		}
		
		
		m.addAttribute("cpAcqgrps", cpAcqgrps);
		m.addAttribute("cpMermsts", cpMermsts);
		m.addAttribute("cpAcqmer", cpAcqmer);
		m.addAttribute("list", list);
		return "cpacqmer/show";
	}
	/**
	 * get到场馆更新场馆图片
	 * @param amGroupId
	 * @param amMerchantId
	 * @param m
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String amGroupId, String amMerchantId, Model m) {
		CpAcqmer cpAcqmer = cpAcqmerService.searchCpAcqmerByParams(amGroupId, amMerchantId);
		List<CpAcqgrp> cpAcqgrps = cpAcqgrpService.CpAcqgrpList();
		List<CpMermst> cpMermsts = cpMermstService.cpVenueList();
		
		List<String> list=new ArrayList<>();
		if(cpAcqmer.getAmUserDefine2()!=null){
			StringTokenizer st=new StringTokenizer(cpAcqmer.getAmUserDefine2(), ",");
			while (st.hasMoreElements()) {
				list.add(st.nextToken());
			}
		}
		
		m.addAttribute("cpAcqgrps", cpAcqgrps);
		m.addAttribute("cpMermsts", cpMermsts);
		m.addAttribute("cpAcqmer", cpAcqmer);
		m.addAttribute("list", list);
		if(list!=null&&list.size()!=0){
			m.addAttribute("listSize",list.size());
		}
		return "cpacqmer/update";
	}
	
	/**
	 * 更新场馆信息和图片
	 * @param cpAcqmer
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_UPDATE)
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@RequestBody CpAcqmer cpAcqmer,RedirectAttributes ra){
		Result<CpAcqmer> r = cpAcqmerService.update(cpAcqmer);
		System.out.println("======="+cpAcqmer.getAmMerchantId());
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpacqmer/update?amGroupId=" + cpAcqmer.getAmGroupId()+"&amMerchantId="+cpAcqmer.getAmMerchantId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆配置更新成功");
		return Result.create("success");
	}
	/**
	 * 修改主图
	 * @param request
	 * @param file
	 * @param amGroupId
	 * @param amUserDefine0
	 * @return
	 */
	@RequestMapping(value="/updateImg",method= RequestMethod.POST)
	@ResponseBody
	public StatusResult<String> updateImg(HttpServletRequest request, @RequestParam("file0") MultipartFile file){
		if(Objects.isNull(file) || file.getSize()==0){
			return StatusResult.create("FALSE", "请选择图片");
		}
//		获取文件名
		String fileName = file.getOriginalFilename();
//		获取后缀名
		String fuxName = fileName.substring(fileName.lastIndexOf(".")+1);
//		获取图片后缀名 带"."
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
//		新图片名称    当前的时间戳
		String newFileName=String.valueOf(System.currentTimeMillis())+suffixName;
		
		
//      图片类型
		String fuxAry = "png||jpg";
		if(!fuxAry.contains(fuxName)){
			return StatusResult.create("FALSE", "图片类型错误，只支持"+fuxAry);
		}
		Long fileSize=(file.getSize())/1024/1024;
		System.out.println(fileSize);
		if(fileSize>=5){
			return StatusResult.create("FALSE", "图片大小不能超过5M");
		}
		//String shortPath = "yanwu/images/"+newFileName;
		String shortPath = "http://"+chinaFlameIp+"/assets/changguan/images/"+newFileName;
		
		//File desFile = new File(request.getServletContext().getRealPath("/")+"assets/yanwu/images",newFileName);
		//2
		String rootPath= "/home/happyworld/tomcat-8.0.35/webapps/assets/changguan/images/"; //for linux
		File desFile = new File(rootPath,newFileName);
		try {
			if(!desFile.exists()){
				desFile.createNewFile();
			}
			file.transferTo(desFile);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return StatusResult.create("SUCCESS",shortPath);
		
	}
	/**
	 * 修改详细图
	 * @param request
	 * @param file
	 * @param amUserDefine
	 * @return
	 */
	@RequestMapping(value="/updateImgs",method= RequestMethod.POST)
	@ResponseBody
	public StatusResult<String> updateImgs(HttpServletRequest request, @RequestParam("files") MultipartFile file){
		//System.out.println(amUserDefine);
		if(Objects.isNull(file) || file.getSize() == 0){
			return StatusResult.create("FALSE", "请选择图片");
		}
//		获取文件名
		String fileName = file.getOriginalFilename();
//		获取后缀名不带点
		String fuxName = fileName.substring(fileName.lastIndexOf(".")+1);
//		获取文件后缀名 带.
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
//		新图片名称    当前的时间戳
		String newFileName=String.valueOf(System.currentTimeMillis())+suffixName;
		
		//验证图片格式
		String fuxAry = "png||jpg";
		if(!fuxAry.contains(fuxName)){
			return StatusResult.create("FALSE", "图片类型错误，只支持"+fuxAry);
		}
		//验证图片
		Long fileSize=file.getSize() / 1024 / 1024;
		System.out.println(fileSize);
		if(fileSize>=5){
			return StatusResult.create("FALSE", "图片大小不能超过5M");
		}
		//yanwu/images文件夹下+文件名字
		//String shortPath = "yanwu/images/"+newFileName;
		String shotPath = "http://"+chinaFlameIp+"/assets/changguan/images/"+newFileName;
		
		//文件绝对路径
		//File desFile = new File(request.getServletContext().getRealPath("/")+"assets/yanwu/images",newFileName);
		// 方法2 路径写死
		String rootPath= "/home/happyworld/tomcat-8.0.35/webapps/assets/changguan/images/"; //for linux
		File desFile = new File(rootPath,newFileName);
		if(!desFile.getParentFile().exists()){
			desFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(desFile);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(shotPath+"路径++++++++++++++++");
		return StatusResult.create("SUCCESS", shotPath);
		
	}
	
	@WebAction(Permission.VENUE_ENTRY_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String amGroupId,String amMerchantId,RedirectAttributes ra){
		Result<CpAcqmer> r = cpAcqmerService.delete(amGroupId,amMerchantId);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpacqmer/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆配置删除成功");
		return "redirect:/cpacqmer/list";
	}
}
