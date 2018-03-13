package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author Hugh
 */
public class Serial implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Integer id;
	/**
	 *  
	 */
	private String name;
	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 
     * @return
     */	
    public Integer getId(){
    	return id;
    }
	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 
     * @return
     */	
    public String getName(){
    	return name;
    }
}