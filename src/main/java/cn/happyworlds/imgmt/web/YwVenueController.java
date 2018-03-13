package cn.happyworlds.imgmt.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.YwGate;
import cn.happyworlds.imgmt.entity.YwVenue;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.YwVenueService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/ywvenue")
public class YwVenueController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private YwVenueService ywVenueService;
	@Autowired
	private PrdgrpService prdgrpService;

	@RequestMapping(value = "/toAddPage")
	public String toAddPage() {
		return "venue/add";
	}
	
	/**
	 * 景点信息列表
	 * @param hwVenueId
	 * @param hwVenueName
	 * @param p
	 * @param m
	 * @return
	 */
	@WebAction(Permission.YWVENUE_LIST)
	@RequestMapping(value="/list")
	public String list(String hwVenueId, String hwVenueName, Integer p,Model m) {
		Result<PageInfo<YwVenue>> r = ywVenueService.list(hwVenueId, hwVenueName, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("hwVenueId", hwVenueId);
			m.addAttribute("hwVenueName", hwVenueName);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "venue/list";
	}
	
	/**
	 * 景点信息添加
	 * @param ywVenue
	 * @param ra
	 * @param request
	 * @return
	 */
	@WebAction(Permission.YWVENUE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(YwVenue ywVenue, RedirectAttributes ra,HttpServletRequest request) {
		try {
			MultipartFile uploadfile1 = ywVenue.getHwVenuePicfile1();
			MultipartFile uploadfile2 = ywVenue.getHwVenuePicfile2();
			if(uploadfile1!=null&&!uploadfile1.isEmpty()){
				String filename1 = uploadfile1.getOriginalFilename();
				ywVenue.setHwVenuePic1("http://58.246.77.26:3551/imgmt/assets/app/img/upload/"+filename1);
				prdgrpService.upPicture(request, uploadfile1);
			}
			if(uploadfile2!=null&&!uploadfile2.isEmpty()){
				String filename2 = uploadfile2.getOriginalFilename();
				ywVenue.setHwVenuePic2("http://58.246.77.26:3551/imgmt/assets/app/img/upload/"+filename2);
				prdgrpService.upPicture(request, uploadfile2);
			}
			
			Date data=new Date();
			SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ywVenue.setHwAddtime(d.parse(d.format(data)));	
			Result<YwVenue> r = ywVenueService.add(ywVenue);
			if (r.isError()) {
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
				return "redirect:/ywvenue/toAddPage";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆添加成功");
		return "redirect:/ywvenue/list";
	}
	
	/**
	 * 景点信息查询
	 * @param hwVenueId
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.YWVENUE_DELETE)
	@RequestMapping("/delete")
	public String delete(String hwVenueId, RedirectAttributes ra) {
		ywVenueService.deleteYwVenueByHwVenueId(hwVenueId);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆信息删除成功");
		return "redirect:/ywvenue/list";
	}
	
	/**
	 * 景点信息修改页面
	 * @param hwVenueId
	 * @param m
	 * @return
	 */
	@WebAction(Permission.YWVENUE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String hwVenueId, Model m) {
		Result<YwVenue> r = ywVenueService.ywVenueGetById(hwVenueId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywvenue/list";
		}
		m.addAttribute("item", r.getValue());
		return "venue/update";
	}
	
	/**
	 * 景点信息修改方法
	 * @param ywVenue
	 * @param ra
	 * @param request
	 * @return
	 */
	@WebAction(Permission.YWVENUE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(YwVenue ywVenue, RedirectAttributes ra,HttpServletRequest request){
		MultipartFile uploadfile1 = ywVenue.getHwVenuePicfile1();
		MultipartFile uploadfile2 = ywVenue.getHwVenuePicfile2();
		String filename1 = ywVenue.getHwVenuePic1();
		String filename2 = ywVenue.getHwVenuePic2();
		if(uploadfile1!=null&&!uploadfile1.isEmpty()){
			filename1 = uploadfile1.getOriginalFilename();
			ywVenue.setHwVenuePic1("http://58.246.77.26:3551/imgmt/assets/app/img/upload/"+filename1);
			prdgrpService.upPicture(request, uploadfile1);
		}
		if(uploadfile2!=null&&!uploadfile2.isEmpty()){
			filename2 = uploadfile2.getOriginalFilename();
			ywVenue.setHwVenuePic2("http://58.246.77.26:3551/imgmt/assets/app/img/upload/"+filename2);
			prdgrpService.upPicture(request, uploadfile2);
		}
			
		Result<YwVenue> r = ywVenueService.update(ywVenue);
		System.out.println(ywVenue+"......."+ywVenue.getHwVenueId()+"");
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywvenue/update?id" + ywVenue.getHwVenueId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆信息更新成功");
		return "redirect:/ywvenue/list";
	}
	
	/**
	 * 景点信息查看
	 * @param m
	 * @param p
	 * @return
	 */
	@WebAction(Permission.YWVENUE_SHOW)
	@RequestMapping("/show")
	public String showUi(Model m, Integer p) {
		Result<PageInfo<YwGate>> r = ywVenueService.searchYwGateByParams(new PageBounds(p, 10));
		m.addAttribute("pageInfo", r.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "venue/show";
	}
	
	/**
	 * 景点信息查看
	 * @param m
	 * @param p
	 * @return
	 */
	@WebAction(Permission.YWVENUE_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(String hwVenueId, Model m) {
		Result<YwVenue> r = ywVenueService.ywVenueGetById(hwVenueId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywvenue/list";
		}
		m.addAttribute("item", r.getValue());
		return "venue/show";
	}


}
