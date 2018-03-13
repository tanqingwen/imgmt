package cn.happyworlds.imgmt.entity;


/**
 * 
 * @author tqw
 */
public class CpMemberShip{


	/**
	 *  会员等级id，唯一
	 */
	private String meGradeId;
	/**
	 *  字母编号
	 */
	private String meGradeCode;
	/**
	 *  会员等级名称
	 */
	private String meGradeDesc;
	/**
	 *  会员等级区域编号
	 */
	private Integer meBin;
	/**
	 *  会员等级描述
	 */
	private String meDescription;
	/**
	 *  会员等级状态
	 */
	private String meGradeStatus;
	/**
	 *  
	 */
	private String meCradBrand;
	/**
	 *  规则
	 */
	private String meRegulation;
	/**
	 * 会员等级id，唯一
	 * @param meGradeId
	 */
	public void setMeGradeId(String meGradeId){
		this.meGradeId = meGradeId;
	}
	
    /**
     * 会员等级id，唯一
     * @return
     */	
    public String getMeGradeId(){
    	return meGradeId;
    }
	/**
	 * 字母编号
	 * @param meGradeCode
	 */
	public void setMeGradeCode(String meGradeCode){
		this.meGradeCode = meGradeCode;
	}
	
    /**
     * 字母编号
     * @return
     */	
    public String getMeGradeCode(){
    	return meGradeCode;
    }
	/**
	 * 会员等级名称
	 * @param meGradeDesc
	 */
	public void setMeGradeDesc(String meGradeDesc){
		this.meGradeDesc = meGradeDesc;
	}
	
    /**
     * 会员等级名称
     * @return
     */	
    public String getMeGradeDesc(){
    	return meGradeDesc;
    }
	/**
	 * 会员等级区域编号
	 * @param meBin
	 */
	public void setMeBin(Integer meBin){
		this.meBin = meBin;
	}
	
    /**
     * 会员等级区域编号
     * @return
     */	
    public Integer getMeBin(){
    	return meBin;
    }
	/**
	 * 会员等级描述
	 * @param meDescription
	 */
	public void setMeDescription(String meDescription){
		this.meDescription = meDescription;
	}
	
    /**
     * 会员等级描述
     * @return
     */	
    public String getMeDescription(){
    	return meDescription;
    }
	/**
	 * 会员等级状态
	 * @param meGradeStatus
	 */
	public void setMeGradeStatus(String meGradeStatus){
		this.meGradeStatus = meGradeStatus;
	}
	
    /**
     * 会员等级状态
     * @return
     */	
    public String getMeGradeStatus(){
    	return meGradeStatus;
    }
	/**
	 * 
	 * @param meCradBrand
	 */
	public void setMeCradBrand(String meCradBrand){
		this.meCradBrand = meCradBrand;
	}
	
    /**
     * 
     * @return
     */	
    public String getMeCradBrand(){
    	return meCradBrand;
    }
	@Override
	public String toString() {
		return "CpMemberShip [meGradeId=" + meGradeId + ", meGradeCode=" + meGradeCode + ", meGradeDesc=" + meGradeDesc
				+ ", meBin=" + meBin + ", meDescription=" + meDescription + ", meGradeStatus=" + meGradeStatus
				+ ", meCradBrand=" + meCradBrand + ", meRegulation=" + meRegulation + "]";
	}

	/**
	 * 规则
	 * @param meRegulation
	 */
	public void setMeRegulation(String meRegulation){
		this.meRegulation = meRegulation;
	}
	
    /**
     * 规则
     * @return
     */	
    public String getMeRegulation(){
    	return meRegulation;
    }
}