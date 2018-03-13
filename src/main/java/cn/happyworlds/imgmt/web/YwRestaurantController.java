package cn.happyworlds.imgmt.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.YwRestaurant;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.YwRestaurantService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/ywrestaurant")
public class YwRestaurantController {

	@Autowired
	private YwRestaurantService ywRestaurantService;
	@Autowired
	private PrdgrpService prdgrpService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "ywrestaurant/add";
	}

	@WebAction(Permission.YWRESTAURANT_LIST)
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(String restaurantId,String restaurantName,Integer p,Model m) {
		Result<PageInfo<YwRestaurant>> r = ywRestaurantService.list(restaurantId,restaurantName,new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("restaurantId", restaurantId);
			m.addAttribute("restaurantName", restaurantName);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "ywrestaurant/list";
	}

	@WebAction(Permission.YWRESTAURANT_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(YwRestaurant ywRestaurant, RedirectAttributes ra,HttpServletRequest request) {
		try {
			MultipartFile uploadfile = ywRestaurant.getRestaurantPicturefile();
			if(uploadfile!=null&&!uploadfile.isEmpty()){
				String filename = uploadfile.getOriginalFilename();
				ywRestaurant.setRestaurantPicture("http://58.246.77.26:3551/imgmt/assets/app/img/upload/"+filename);
				prdgrpService.upPicture(request, uploadfile);
			}
			
			Result<YwRestaurant> r = ywRestaurantService.add(ywRestaurant);
			if (r.isError()) {
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
				return "redirect:/ywrestaurant/add";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "餐厅添加成功");
		return "redirect:/ywrestaurant/list";
	}

	@WebAction(Permission.YWRESTAURANT_DELETE)
	@RequestMapping("/delete")
	public String delete(String restaurantId, RedirectAttributes ra) {
		ywRestaurantService.delete(restaurantId);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "餐厅信息删除成功");
		return "redirect:/ywrestaurant/list";
	}

	@WebAction(Permission.YWRESTAURANT_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String restaurantId, Model m) {
		Result<YwRestaurant> r = ywRestaurantService.searchYwRestaurantByRestaurantId(restaurantId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywrestaurant/list";
		}
		m.addAttribute("item", r.getValue());
		return "ywrestaurant/update";
	}

	@WebAction(Permission.YWRESTAURANT_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(YwRestaurant ywRestaurant, RedirectAttributes ra,HttpServletRequest request){
		MultipartFile uploadfile1 = ywRestaurant.getRestaurantPicturefile();
		String filename1 = ywRestaurant.getRestaurantPicture();
		if(uploadfile1!=null&&!uploadfile1.isEmpty()){
			filename1 = uploadfile1.getOriginalFilename();
			prdgrpService.upPicture(request, uploadfile1);
			ywRestaurant.setRestaurantPicture("http://58.246.77.26:3551/imgmt/assets/app/img/upload/"+filename1);
		}
			
		Result<YwRestaurant> r = ywRestaurantService.update(ywRestaurant);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywrestaurant/update?id" + ywRestaurant.getRestaurantId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "餐厅信息更新成功");
		return "redirect:/ywrestaurant/list";
	}

	@WebAction(Permission.YWRESTAURANT_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(String restaurantId, Model m) {
		Result<YwRestaurant> r = ywRestaurantService.searchYwRestaurantByRestaurantId(restaurantId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywrestaurant/list";
		}
		m.addAttribute("item", r.getValue());
		return "ywrestaurant/show";
	}


}
