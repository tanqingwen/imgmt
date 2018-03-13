package cn.happyworlds.imgmt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.happyworlds.imgmt.entity.CpAcqmer;
import cn.happyworlds.imgmt.service.CpAcqmerService;
import cn.happyworlds.imgmt.util.Result;

@CrossOrigin
@Controller
@RequestMapping("/rest/venueGroup/")
public class RestVenueGroupController {

	@Autowired
	private CpAcqmerService cpAcqmerService;
	
	
	/**
	 * 场馆组管理
	 * @return
	 */
	@RequestMapping("/manager.htm")
	public String manager() {
		return "rest/venueGroup/manager";
	}
	/**
	 * 场馆组列表  1006
	 * @param ttTypeId
	 * @param m
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list() {
		try {
			List<CpAcqmer> cpAcqmer = cpAcqmerService.cpAcqmerList();
			return Result.create(cpAcqmer);
		}catch(Exception e) {
			return Result.create("error", "系统异常");
		}
	}
}
