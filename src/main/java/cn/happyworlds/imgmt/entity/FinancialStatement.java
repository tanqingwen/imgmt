package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author wyb
 */
public class FinancialStatement implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  çº§æ¬¡
	 */
	private Integer level;
	/**
	 *  ç§ç®ç¼ç 
	 */
	private String subjectCode;
	/**
	 *  ç§ç®åç§°
	 */
	private String subjectName;
	/**
	 *  ç±»å«
	 */
	private String classes;
	/**
	 *  å¸ç§
	 */
	private String currency;
	/**
	 *  éé¢
	 */
	private String money;
	/**
	 *  æ¹æ³¨
	 */
	private String postil;
	/**
	 * çº§æ¬¡
	 * @param level
	 */
	public void setLevel(Integer level){
		this.level = level;
	}
	
    /**
     * çº§æ¬¡
     * @return
     */	
    public Integer getLevel(){
    	return level;
    }
	/**
	 * ç§ç®ç¼ç 
	 * @param subjectCode
	 */
	public void setSubjectCode(String subjectCode){
		this.subjectCode = subjectCode;
	}
	
    /**
     * ç§ç®ç¼ç 
     * @return
     */	
    public String getSubjectCode(){
    	return subjectCode;
    }
	/**
	 * ç§ç®åç§°
	 * @param subjectName
	 */
	public void setSubjectName(String subjectName){
		this.subjectName = subjectName;
	}
	
    /**
     * ç§ç®åç§°
     * @return
     */	
    public String getSubjectName(){
    	return subjectName;
    }
	/**
	 * ç±»å«
	 * @param classes
	 */
	public void setClasses(String classes){
		this.classes = classes;
	}
	
    /**
     * ç±»å«
     * @return
     */	
    public String getClasses(){
    	return classes;
    }
	/**
	 * å¸ç§
	 * @param currency
	 */
	public void setCurrency(String currency){
		this.currency = currency;
	}
	
    /**
     * å¸ç§
     * @return
     */	
    public String getCurrency(){
    	return currency;
    }
	/**
	 * éé¢
	 * @param money
	 */
	public void setMoney(String money){
		this.money = money;
	}
	
    /**
     * éé¢
     * @return
     */	
    public String getMoney(){
    	return money;
    }
	/**
	 * æ¹æ³¨
	 * @param postil
	 */
	public void setPostil(String postil){
		this.postil = postil;
	}
	
    /**
     * æ¹æ³¨
     * @return
     */	
    public String getPostil(){
    	return postil;
    }
}