package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.TicketShoppingCart;

public interface TicketShoppingCartMapper {

	Long insertTicketShoppingCart(TicketShoppingCart ticketShoppingCart);

    Long deleteTicketShoppingCartByShoppingId(Integer shoppingId);

    Long deleteTicketShoppingCartByParams(@Param("map") Map<String, String> map);

    Long deleteTicketShoppingCartAll();
    
    Long updateTicketShoppingCart(TicketShoppingCart ticketShoppingCart);

    Long updateTicketShoppingCartByParams(@Param("map") Map<String, String> map);

	TicketShoppingCart searchTicketShoppingCartByShoppingId(Integer shoppingId);

	List<TicketShoppingCart> searchTicketShoppingCartByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TicketShoppingCart> searchTicketShoppingCartByParams(@Param("map") Map<String, String> map);

} 
