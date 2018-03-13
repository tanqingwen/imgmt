package cn.happyworlds.imgmt.web;

import java.text.ParseException;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpTktypeService;
import cn.happyworlds.imgmt.service.rest.RestTktypeService;
import cn.happyworlds.imgmt.util.Result;

@CrossOrigin
@Controller
@RequestMapping("/rest/tktype")
public class RestTktypeController {

	private static final Logger log = LoggerFactory.getLogger(RestTktypeController.class);

	@Autowired
	private CpTktypeService cpTktypeService;
	
	@Autowired
	private RestTktypeService restTktypeService;
	
	/**
	 * 票券信息管理页面
	 * @return
	 */
	@RequestMapping("/manager.htm")
	public String manager() {
		log.info("票券信息管理页面");
		return "rest/tktype/manager";
	}
	/**
	 * 票券信息添加
	 * @return
	 */
	@RequestMapping("/add.htm")
	public Object add() {
		log.info("票券信息添加页面");
		return "rest/tktype/add";
	}
	/**
	 * 票券信息查看
	 * @return
	 */
	@RequestMapping("/view.htm")
	public String view() {
		log.info("票券信息查看页面");
		return "rest/tktype/view";
	}
	/**
	 * 票券信息删除
	 * @return
	 */
	@RequestMapping("/delete.htm")
	public String delete() {
		log.info("票券信息删除页面-待用");
		return "rest/tktype/delete";
	}
	/**
	 * 获得票券ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ID", method = RequestMethod.GET)
	public Object id() {
		log.info("获得票券ID");
		try {
			Integer id = restTktypeService.id();
			return Result.create(id);
		}catch(Exception e) {
			e.printStackTrace();
			return Result.create("error", "获取ID失败");
		}
	}
	/**
	 * 票券种类列表  1001
	 * @param ttTypeId
	 * @param ttTypeDesc
	 * @param p
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list(String ttTypeId, String ttTypeDesc, Integer p, Integer size) {
		log.info("票券信息列表功能ttTypeId:{},ttTypeDesc:{},p:{},size:{}", ttTypeId, ttTypeDesc,p,size);
		Result<PageInfo<CpTktype>> r = cpTktypeService.cpTktypeList(ttTypeId,ttTypeDesc,new PageBounds(p, 10));
		return r;
	}
	/**
	 * 票券更新  1002
	 * @param cpTktype
	 * @param ra
	 * @return
	 * @throws ParseException
	 */
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@RequestBody CpTktype cpTktype) {
		log.info("票券信息列表功能cpTktype:{}", ToStringBuilder.reflectionToString(cpTktype, ToStringStyle.SHORT_PREFIX_STYLE));
		try {
			return restTktypeService.add(cpTktype);
		}catch(Exception e) {
			log.error("系统异常", e);
			return Result.create("error", e.getMessage());
		}
	}
	@ResponseBody
	@RequestMapping(value = "/add/test", method = RequestMethod.GET)
	public Object add1() {
//		log.info("票券信息列表功能cpTktype:{}", ToStringBuilder.reflectionToString(cpTktype, ToStringStyle.SHORT_PREFIX_STYLE));
		try {
			return restTktypeService.add(new CpTktype());
		}catch(Exception e) {
			log.error("系统异常", e);
			return Result.create("error", e.getMessage());
		}
	}

	/**
	 * 票券查看  1003
	 * @param ttTypeId
	 * @param m
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/obtain", method = RequestMethod.GET)
	public Object obtain(Integer ttTypeId) {
		log.info("票券信息查询功能ttTypeId:{}", ttTypeId);
		try {
			CpTktype cpTktype = cpTktypeService.searchCpTktypeByTtTypeId(ttTypeId);
			if(Objects.isNull(cpTktype))
				return Result.create("error", "未查到票券");
			return Result.create(cpTktype);
		}catch(Exception e) {
			return Result.create("error", "系统异常");
		}
	}
	
	/**
	 * 票券删除  1004
	 * @param ttTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Object delete(Integer ttTypeId) {
		log.info("票券信息删除功能ttTypeId:{}", ttTypeId);
		try {
			return restTktypeService.delete(ttTypeId);
		}catch(Exception e) {
			return Result.create("error", "系统异常");
		}
	}
	
}
