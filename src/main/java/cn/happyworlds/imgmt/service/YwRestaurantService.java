package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.YwRestaurant;
import cn.happyworlds.imgmt.mapper.YwRestaurantMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class YwRestaurantService {

	@Autowired
	private YwRestaurantMapper ywRestaurantMapper;
	
	public Result<PageInfo<YwRestaurant>> list(String restaurantId,String restaurantName,PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(restaurantId)) {
			params.put("restaurantId", restaurantId);
		}
		if (StringUtils.hasText(restaurantName)) {
			params.put("restaurantName", restaurantName);
		}
		List<YwRestaurant> page = ywRestaurantMapper.searchYwRestaurantByParams(params, pageBounds);
		return Result.create(new PageInfo<YwRestaurant>(page));
	}
	public Result<YwRestaurant> add(YwRestaurant ywRestaurant) {
		YwRestaurant ywRestaurants = ywRestaurantMapper.searchYwRestaurantByRestaurantId(ywRestaurant.getRestaurantId());
		if (ywRestaurants!=null) {
			return Result.create("DUPLICATING", "同样的餐厅ID已经存在于列表中！");
		}
		ywRestaurantMapper.insertYwRestaurant(ywRestaurant);
		return Result.create(ywRestaurants);
	}
	
	public Long delete(final String restaurantId) {
		Long r = ywRestaurantMapper.deleteYwRestaurantByRestaurantId(restaurantId);
		return r;
	}
	
	public Result<YwRestaurant> searchYwRestaurantByRestaurantId(String restaurantId) {
		YwRestaurant ywRestaurant = ywRestaurantMapper.searchYwRestaurantByRestaurantId(restaurantId);
		if (null == ywRestaurant) {
			return Result.create("YWRESTAURANT_NOT_EXISTS", "餐厅不存在");
		}
		return Result.create(ywRestaurant);
	}
	
	public Result<YwRestaurant> update(YwRestaurant ywRestaurant){
		try {
			ywRestaurantMapper.updateYwRestaurant(ywRestaurant);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("YWRESTAURANT_UPDATE_FAILED", "餐厅更新失败");
		}
		return Result.create(ywRestaurant);
	}
}
