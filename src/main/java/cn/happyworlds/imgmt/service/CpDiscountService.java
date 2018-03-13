package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ser.PropertyBuilder.EmptyArrayChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpDiscount;
import cn.happyworlds.imgmt.mapper.CpDiscountMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpDiscountService {
	
	@Autowired
	private CpDiscountMapper cpDiscountMapper;
	
	public List<CpDiscount> discountList(){
		return cpDiscountMapper.searchCpDiscountByParams(null);
	}
	
	@SuppressWarnings({"rawtypes","unchecked"})
	public Result<PageInfo<CpDiscount>> discountList(final String disId,final String disName,PageBounds pageBounds){
		Map<String, String> map=new HashMap<String, String>();
		if(StringUtils.hasText(disId)){
			map.put("disId", disId);
		}
		if(StringUtils.hasText(disName)){
			map.put("disDesc", disName);
		}
		List<CpDiscount> list=cpDiscountMapper.searchCpDiscountByParams(map,pageBounds);
		return Result.create(new PageInfo(list));
	}
	
	public CpDiscount discountById(final String disId){
		
		CpDiscount dis=cpDiscountMapper.searchCpDiscountByDisId(disId);
		
		return dis;
	}
	
	public Result<CpDiscount> discountAdd(CpDiscount discount){
		CpDiscount discountId =cpDiscountMapper.searchCpDiscountByDisId(discount.getDisId());
		if(discountId != null){
			return Result.create("DISCOUNT_DICT_NOT_FOUND","此优惠券id已存在");
		}
		cpDiscountMapper.insertCpDiscount(discount);
		return Result.create(discount);
	}
	
	public Result<CpDiscount> discountUpdate(CpDiscount discount){
		Map<String, String> map =new HashMap<String,String>();
		map.put("disDesc", discount.getDisDesc());
		List<CpDiscount> list = cpDiscountMapper.searchCpDiscountByParams(map);
		if(list.size() > 0){
			map.put("disId", discount.getDisId());
			map.put("disDesc", discount.getDisDesc());
			List<CpDiscount> co=cpDiscountMapper.searchCpDiscountByParams(map);
			if(co.size()>0){
				cpDiscountMapper.updateCpDiscount(discount);
				return Result.create(discount);
			}else{
			return Result.create("DISCOUNT_DICT_NOT_FOUND", "此票券名称已存在");
			}
		}
		cpDiscountMapper.updateCpDiscount(discount);
		return Result.create(discount);
	}
	
	public Result<CpDiscount> discountDelete(String id){
		try {
			cpDiscountMapper.deleteCpDiscountByDisId(id);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("TKTYPE_DELETE_FAILED", "优惠券删除失败");
		}
		return Result.create(null);
	}
	
	public String seachMax(){
		CpDiscount dis =cpDiscountMapper.searchCpDiscountByMaxId();
		return dis.getDisId();
	}
}
