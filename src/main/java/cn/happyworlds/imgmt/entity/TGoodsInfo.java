package cn.happyworlds.imgmt.entity;

/**
 * 
 * @author json
 */
public class TGoodsInfo {
	/**
	 *  产品id
	 */
	private Long goodsId;
	/**
	 *  品牌
	 */
	private String brand;
	/**
	 *  型号
	 */
	private String modelNum;
	/**
	 *  商品名称
	 */
	private String title;
	/**
	 *  商品价格
	 */
	private java.math.BigDecimal goodsAmount;
	/**
	 *  首付比例
	 */
	private Byte defaultPayPercent;
	/**
	 *  首付金额
	 */
	private java.math.BigDecimal defaultPayAmount;
	/**
	 *  默认每期还款金额
	 */
	private java.math.BigDecimal defaultPhaseAmount;
	/**
	 *  默认分期数
	 */
	private Byte defaultLoanTerm;
	/**
	 *  商品描述，以
	 */
	private String description;
	/**
	 *  创建时间
	 */
	private java.util.Date createTime;
	/**
	 *  更新时间
	 */
	private java.util.Date updateTime;
	/**
	 *  逻辑删除状态 0 正常 1 删除 2 初始化 3 编辑中
	 */
	private Byte status;
	/**
	 *  商品类型：0手机
	 */
	private Byte type;
	/**
	 *  所属产品中心id
	 */
	private Long productInfoId;
	/**
	 *  排序权重，从小到达
	 */
	private Integer rankWeight;
	/**
	 *  是否需要首付：0不需要，1需要
	 */
	private Byte downPaymentFlag;
	/**
	 * 产品id
	 * @param goodsId
	 */
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	
    /**
     * 产品id
     * @return
     */	
    public Long getGoodsId(){
    	return goodsId;
    }
	/**
	 * 品牌
	 * @param brand
	 */
	public void setBrand(String brand){
		this.brand = brand;
	}
	
    /**
     * 品牌
     * @return
     */	
    public String getBrand(){
    	return brand;
    }
	/**
	 * 型号
	 * @param modelNum
	 */
	public void setModelNum(String modelNum){
		this.modelNum = modelNum;
	}
	
    /**
     * 型号
     * @return
     */	
    public String getModelNum(){
    	return modelNum;
    }
	/**
	 * 商品名称
	 * @param title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
    /**
     * 商品名称
     * @return
     */	
    public String getTitle(){
    	return title;
    }
	/**
	 * 商品价格
	 * @param goodsAmount
	 */
	public void setGoodsAmount(java.math.BigDecimal goodsAmount){
		this.goodsAmount = goodsAmount;
	}
	
    /**
     * 商品价格
     * @return
     */	
    public java.math.BigDecimal getGoodsAmount(){
    	return goodsAmount;
    }
	/**
	 * 首付比例
	 * @param defaultPayPercent
	 */
	public void setDefaultPayPercent(Byte defaultPayPercent){
		this.defaultPayPercent = defaultPayPercent;
	}
	
    /**
     * 首付比例
     * @return
     */	
    public Byte getDefaultPayPercent(){
    	return defaultPayPercent;
    }
	/**
	 * 首付金额
	 * @param defaultPayAmount
	 */
	public void setDefaultPayAmount(java.math.BigDecimal defaultPayAmount){
		this.defaultPayAmount = defaultPayAmount;
	}
	
    /**
     * 首付金额
     * @return
     */	
    public java.math.BigDecimal getDefaultPayAmount(){
    	return defaultPayAmount;
    }
	/**
	 * 默认每期还款金额
	 * @param defaultPhaseAmount
	 */
	public void setDefaultPhaseAmount(java.math.BigDecimal defaultPhaseAmount){
		this.defaultPhaseAmount = defaultPhaseAmount;
	}
	
    /**
     * 默认每期还款金额
     * @return
     */	
    public java.math.BigDecimal getDefaultPhaseAmount(){
    	return defaultPhaseAmount;
    }
	/**
	 * 默认分期数
	 * @param defaultLoanTerm
	 */
	public void setDefaultLoanTerm(Byte defaultLoanTerm){
		this.defaultLoanTerm = defaultLoanTerm;
	}
	
    /**
     * 默认分期数
     * @return
     */	
    public Byte getDefaultLoanTerm(){
    	return defaultLoanTerm;
    }
	/**
	 * 商品描述，以
	 * @param description
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
    /**
     * 商品描述，以
     * @return
     */	
    public String getDescription(){
    	return description;
    }
	/**
	 * 创建时间
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
    /**
     * 创建时间
     * @return
     */	
    public java.util.Date getCreateTime(){
    	return createTime;
    }
	/**
	 * 更新时间
	 * @param updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	
    /**
     * 更新时间
     * @return
     */	
    public java.util.Date getUpdateTime(){
    	return updateTime;
    }
	/**
	 * 逻辑删除状态 0 正常 1 删除 2 初始化 3 编辑中
	 * @param status
	 */
	public void setStatus(Byte status){
		this.status = status;
	}
	
    /**
     * 逻辑删除状态 0 正常 1 删除 2 初始化 3 编辑中
     * @return
     */	
    public Byte getStatus(){
    	return status;
    }
	/**
	 * 商品类型：0手机
	 * @param type
	 */
	public void setType(Byte type){
		this.type = type;
	}
	
    /**
     * 商品类型：0手机
     * @return
     */	
    public Byte getType(){
    	return type;
    }
	/**
	 * 所属产品中心id
	 * @param productInfoId
	 */
	public void setProductInfoId(Long productInfoId){
		this.productInfoId = productInfoId;
	}
	
    /**
     * 所属产品中心id
     * @return
     */	
    public Long getProductInfoId(){
    	return productInfoId;
    }
	/**
	 * 排序权重，从小到达
	 * @param rankWeight
	 */
	public void setRankWeight(Integer rankWeight){
		this.rankWeight = rankWeight;
	}
	
    /**
     * 排序权重，从小到达
     * @return
     */	
    public Integer getRankWeight(){
    	return rankWeight;
    }
	/**
	 * 是否需要首付：0不需要，1需要
	 * @param downPaymentFlag
	 */
	public void setDownPaymentFlag(Byte downPaymentFlag){
		this.downPaymentFlag = downPaymentFlag;
	}
	
    /**
     * 是否需要首付：0不需要，1需要
     * @return
     */	
    public Byte getDownPaymentFlag(){
    	return downPaymentFlag;
    }
}