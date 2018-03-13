package cn.happyworlds.imgmt.mapper;

import java.util.List;

import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.entity.ListCardSaleInfo;

public interface ListCardSaleInfoMapper {
	
	List<ListCardSaleInfo> searchListCardSaleInfoNumnull(PageBounds pageBounds);
	
	List<ListCardSaleInfo> searchListCardSaleInfo(String ctCardNumber, PageBounds pageBounds);
	
} 
