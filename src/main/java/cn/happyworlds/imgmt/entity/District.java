package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class District implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  编号
	 */
	private Integer id;
	/**
	 *  名称
	 */
	private String name;
	/**
	 *  母编号
	 */
	private Short parentId;
	/**
	 *  拼音首字母
	 */
	private String initial;
	/**
	 *  简拼
	 */
	private String initials;
	/**
	 *  拼音
	 */
	private String pinyin;
	/**
	 *  类别
	 */
	private String suffix;
	/**
	 *  身份证号码
	 */
	private String code;
	/**
	 *  省ID
	 */
	private Byte ordera;
	/**
	 * 编号
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 编号
     * @return
     */	
    public Integer getId(){
    	return id;
    }
	/**
	 * 名称
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 名称
     * @return
     */	
    public String getName(){
    	return name;
    }
	/**
	 * 母编号
	 * @param parentId
	 */
	public void setParentId(Short parentId){
		this.parentId = parentId;
	}
	
    /**
     * 母编号
     * @return
     */	
    public Short getParentId(){
    	return parentId;
    }
	/**
	 * 拼音首字母
	 * @param initial
	 */
	public void setInitial(String initial){
		this.initial = initial;
	}
	
    /**
     * 拼音首字母
     * @return
     */	
    public String getInitial(){
    	return initial;
    }
	/**
	 * 简拼
	 * @param initials
	 */
	public void setInitials(String initials){
		this.initials = initials;
	}
	
    /**
     * 简拼
     * @return
     */	
    public String getInitials(){
    	return initials;
    }
	/**
	 * 拼音
	 * @param pinyin
	 */
	public void setPinyin(String pinyin){
		this.pinyin = pinyin;
	}
	
    /**
     * 拼音
     * @return
     */	
    public String getPinyin(){
    	return pinyin;
    }
	/**
	 * 类别
	 * @param suffix
	 */
	public void setSuffix(String suffix){
		this.suffix = suffix;
	}
	
    /**
     * 类别
     * @return
     */	
    public String getSuffix(){
    	return suffix;
    }
	/**
	 * 身份证号码
	 * @param code
	 */
	public void setCode(String code){
		this.code = code;
	}
	
    /**
     * 身份证号码
     * @return
     */	
    public String getCode(){
    	return code;
    }
	/**
	 * 省ID
	 * @param ordera
	 */
	public void setordera(Byte ordera){
		this.ordera = ordera;
	}
	
    /**
     * 省ID
     * @return
     */	
    public Byte getordera(){
    	return ordera;
    }
}