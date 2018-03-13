package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author ${author}
 */
public class Sequence implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  
	 */
	private Long id;
	/**
	 *  
	 */
	private String name;
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
    /**
     * 
     * @return
     */	
    public Long getId(){
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