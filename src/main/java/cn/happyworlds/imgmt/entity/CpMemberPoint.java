package cn.happyworlds.imgmt.entity;


/**
 * 
 * @author tqw
 */
public class CpMemberPoint{

 

	/**
	 *  分积主键
	 */
	private String poId;
	/**
	 *  分积类型id
	 */
	private String poTypeId;
	/**
	 *  积分类型名称
	 */
	private String poTypeName;
	/**
	 *  积分数量
	 */
	private Integer poNumber;
	/**
	 *  积分描述
	 */
	private String poDescription;
	/**
	 *  
	 */
	private String poTextOne;
	/**
	 *  
	 */
	private String poTextTwo;
	/**
	 *  
	 */
	private String poTextThree;
	/**
	 * 分积主键
	 * @param poId
	 */
	public void setPoId(String poId){
		this.poId = poId;
	}
	
    /**
     * 分积主键
     * @return
     */	
    public String getPoId(){
    	return poId;
    }
	/**
	 * 分积类型id
	 * @param poTypeId
	 */
	public void setPoTypeId(String poTypeId){
		this.poTypeId = poTypeId;
	}
	
    /**
     * 分积类型id
     * @return
     */	
    public String getPoTypeId(){
    	return poTypeId;
    }
	/**
	 * 积分类型名称
	 * @param poTypeName
	 */
	public void setPoTypeName(String poTypeName){
		this.poTypeName = poTypeName;
	}
	
    /**
     * 积分类型名称
     * @return
     */	
    public String getPoTypeName(){
    	return poTypeName;
    }
	/**
	 * 积分数量
	 * @param poNumber
	 */
	public void setPoNumber(Integer poNumber){
		this.poNumber = poNumber;
	}
	
    /**
     * 积分数量
     * @return
     */	
    public Integer getPoNumber(){
    	return poNumber;
    }
	/**
	 * 积分描述
	 * @param poDescription
	 */
	public void setPoDescription(String poDescription){
		this.poDescription = poDescription;
	}
	
    /**
     * 积分描述
     * @return
     */	
    public String getPoDescription(){
    	return poDescription;
    }
	/**
	 * 
	 * @param poTextOne
	 */
	public void setPoTextOne(String poTextOne){
		this.poTextOne = poTextOne;
	}
	
    /**
     * 
     * @return
     */	
    public String getPoTextOne(){
    	return poTextOne;
    }
	/**
	 * 
	 * @param poTextTwo
	 */
	public void setPoTextTwo(String poTextTwo){
		this.poTextTwo = poTextTwo;
	}
	
    /**
     * 
     * @return
     */	
    public String getPoTextTwo(){
    	return poTextTwo;
    }
	/**
	 * 
	 * @param poTextThree
	 */
	public void setPoTextThree(String poTextThree){
		this.poTextThree = poTextThree;
	}
	
    /**
     * 
     * @return
     */	
    public String getPoTextThree(){
    	return poTextThree;
    }
}