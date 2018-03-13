package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author yanjy
 */
public class YwRestaurant implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  é¤�åŽ…ID
	 */
	private String restaurantId;
	/**
	 *  é¤�åŽ…å��ç§°
	 */
	private String restaurantName;
	/**
	 *  é¤�åŽ…å›¾ç‰‡
	 */
	private String restaurantPicture;
	private MultipartFile restaurantPicturefile;//餐厅图片
	
	public MultipartFile getRestaurantPicturefile() {
		return restaurantPicturefile;
	}

	public void setRestaurantPicturefile(MultipartFile restaurantPicturefile) {
		this.restaurantPicturefile = restaurantPicturefile;
	}

	/**
	 * é¤�åŽ…ID
	 * @param restaurantId
	 */
	public void setRestaurantId(String restaurantId){
		this.restaurantId = restaurantId;
	}
	
    /**
     * é¤�åŽ…ID
     * @return
     */	
    public String getRestaurantId(){
    	return restaurantId;
    }
	/**
	 * é¤�åŽ…å��ç§°
	 * @param restaurantName
	 */
	public void setRestaurantName(String restaurantName){
		this.restaurantName = restaurantName;
	}
	
    /**
     * é¤�åŽ…å��ç§°
     * @return
     */	
    public String getRestaurantName(){
    	return restaurantName;
    }
	/**
	 * é¤�åŽ…å›¾ç‰‡
	 * @param restaurantPicture
	 */
	public void setRestaurantPicture(String restaurantPicture){
		this.restaurantPicture = restaurantPicture;
	}
	
    /**
     * é¤�åŽ…å›¾ç‰‡
     * @return
     */	
    public String getRestaurantPicture(){
    	return restaurantPicture;
    }
}