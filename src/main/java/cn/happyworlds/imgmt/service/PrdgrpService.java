package cn.happyworlds.imgmt.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.YwVenue;
import cn.happyworlds.imgmt.mapper.CpPrdgrpMapper;
import cn.happyworlds.imgmt.mapper.YwVenueMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class PrdgrpService {

	@Autowired
	private CpPrdgrpMapper cPPrdgrpMapper;
	
	@Autowired
	private YwVenueMapper ywVenueMapper;
	
	/**
	 * 查询票种
	 */
	public Result<PageInfo<CpPrdgrp>> prdgrpList(final String prProdctGroup, final String hwCategory, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(prProdctGroup)) {
			params.put("prProdctGroup", prProdctGroup);
		}
		if (StringUtils.hasText(hwCategory)) {
			params.put("hwCategory", hwCategory);
		}
		List<CpPrdgrp> page = cPPrdgrpMapper.searchCpPrdgrpByParams(params, pageBounds);
		return Result.create(new PageInfo<CpPrdgrp>(page));
	}
	
	/**
	 * 查询所有的场馆ID
	 */
	public Result<PageInfo<YwVenue>> searchYwVenueByParams(PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		List<YwVenue> page = ywVenueMapper.searchYwVenueByParams(params,pageBounds);
		
		return Result.create(new PageInfo<YwVenue>(page));
	}
	
	/**
	 * 查询所有的场馆ID
	 */
	public YwVenue searchYwVenueByHwVenueId(String  hwVenueId){
		YwVenue page = ywVenueMapper.searchYwVenueByHwVenueId(hwVenueId);	
		return page;
	}
	
	/**
	 * 添加票种
	 */
	public Long insertCpTrmmst(CpPrdgrp cpPrdgrp){
		
		Long row = cPPrdgrpMapper.insertCpPrdgrp(cpPrdgrp);
		
		return row;
	}
	
	/**
	 * 查询单个票种
	 */
	public Result<CpPrdgrp> prdgrpGetById(Integer prProdctGroup) {
		CpPrdgrp cpPrdgrp = cPPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(prProdctGroup);
		if (null == cpPrdgrp) {
			return Result.create("PRDGRP_NOT_EXISTS", "票种不存在");
		}
		return Result.create(cpPrdgrp);
	}
	
	/**
	 * 更新票种
	 */
	public Result<CpPrdgrp> update(CpPrdgrp cpprdgrp){
		try {
			cPPrdgrpMapper.updateCpPrdgrp(cpprdgrp);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpPrdgrp_UPDATE_FAILED", "票种更新失败");
		}
		return Result.create(cpprdgrp);
	}
	
	/**
	 * 删除票种
	 */
	public Long delect(Integer prProdctGroup){
		Long r = cPPrdgrpMapper.deleteCpPrdgrpByPrProdctGroup(prProdctGroup);
		return r;
	}

	
	public Result<List<CpPrdgrp>> prdGrpListAll() {
		List<CpPrdgrp> page = cPPrdgrpMapper.searchCpPrdgrpByParams(null);
		return Result.create(page);
	}
	
//	public void loadPicture(HttpServletRequest request,CpPrdgrp cpPrdgrp) {
//		try {
//			String savePath = request.getServletContext().getRealPath("/assets/app/img/upload");
//			File file = new File(savePath);
//			if (!file.exists() && !file.isDirectory()) {
//				 file.mkdir();
//			}
//			String filename = cpPrdgrp.getHwTicketPic();
//			filename= filename.substring(filename.lastIndexOf("/")+1);
//			cpPrdgrp.setHwTicketPic(filename);
//			FileOutputStream fos = new FileOutputStream(file+"/"+filename);
//			fos.write(cpPrdgrp.getHwTicketPicdata());
//			fos.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	
	public CpPrdgrp getProdct(String prodctGroup) {
		CpPrdgrp cpPrdgrp = cPPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(Integer.parseInt(prodctGroup));
		return cpPrdgrp;

	}	
		public void upPicture(HttpServletRequest request,MultipartFile uploadfile) {
		try {
			String filename = uploadfile.getOriginalFilename();
			InputStream fis = uploadfile.getInputStream();
			
			String savePath = request.getServletContext().getRealPath("/assets/app/img/upload");
			File file = new File(savePath);
			if (!file.exists() && !file.isDirectory()) {
				 file.mkdir();
			}
			
			FileOutputStream fos = new FileOutputStream(file+"/"+filename);
			byte[] bytes = new byte[(int) uploadfile.getSize()];
			fis.read(bytes);
			fos.write(bytes);
			fis.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
