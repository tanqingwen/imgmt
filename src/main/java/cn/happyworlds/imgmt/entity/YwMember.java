package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author json
 */
public class YwMember implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  会员ID
	 */
	private Integer userId;
	/**
	 *  1为身份证，2为护照，3为港澳台
	 */
	private Byte idType;
	/**
	 *  证件号
	 */
	private String idNo;
	/**
	 *  与证件上的姓名一致
	 */
	private String username;
	/**
	 *  用户手机号
	 */
	private String mobile;
	/**
	 *  用户密码
	 */
	private String password;
	/**
	 *  邮箱
	 */
	private String email;
	/**
	 *  1为男，2为女
	 */
	private Byte sex;
	/**
	 *  常住地址
	 */
	private String address;
	/**
	 *  微信ID
	 */
	private String weixinId;
	/**
	 *  微博ID
	 */
	private String weiboId;
	/**
	 *  支付宝ID
	 */
	private String zhifubaoId;
	/**
	 *  昵称
	 */
	private String nickname;
	/**
	 *  用户头像保存地址
	 */
	private String userpic;
	/**
	 *  用户生日
	 */
	private String birthday;
	/**
	 *  所属会员ID
	 */
	private Integer pid;
	/**
	 *  会员类型
	 */
	private String userType;
	/**
	 *  会员等级
	 */
	private String userGrade;
	/**
	 *  积分
	 */
	private Long integral;
	/**
	 *  余额
	 */
	private java.math.BigDecimal balance;
	/**
	 *  被冻结的余额
	 */
	private java.math.BigDecimal frozenBalance;
	/**
	 *  押金余额
	 */
	private java.math.BigDecimal depositBalance;
	/**
	 *  被冻结的押金余额
	 */
	private java.math.BigDecimal frozenDepositBalance;
	/**
	 *  限额
	 */
	private java.math.BigDecimal limitBalance;
	/**
	 *  1正常,2被冻结，3黑名单
	 */
	private Byte status;
	/**
	 *  记录登录IP
	 */
	private String loginIp;
	/**
	 *  绑定的时间
	 */
	private String bundTime;
	/**
	 *  更新时间
	 */
	private String updateTime;
	/**
	 * 会员ID
	 * @param userId
	 */
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	
    /**
     * 会员ID
     * @return
     */	
    public Integer getUserId(){
    	return userId;
    }
	/**
	 * 1为身份证，2为护照，3为港澳台
	 * @param idType
	 */
	public void setIdType(Byte idType){
		this.idType = idType;
	}
	
    /**
     * 1为身份证，2为护照，3为港澳台
     * @return
     */	
    public Byte getIdType(){
    	return idType;
    }
	/**
	 * 证件号
	 * @param idNo
	 */
	public void setIdNo(String idNo){
		this.idNo = idNo;
	}
	
    /**
     * 证件号
     * @return
     */	
    public String getIdNo(){
    	return idNo;
    }
	/**
	 * 与证件上的姓名一致
	 * @param username
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
    /**
     * 与证件上的姓名一致
     * @return
     */	
    public String getUsername(){
    	return username;
    }
	/**
	 * 用户手机号
	 * @param mobile
	 */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
    /**
     * 用户手机号
     * @return
     */	
    public String getMobile(){
    	return mobile;
    }
	/**
	 * 用户密码
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
    /**
     * 用户密码
     * @return
     */	
    public String getPassword(){
    	return password;
    }
	/**
	 * 邮箱
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
    /**
     * 邮箱
     * @return
     */	
    public String getEmail(){
    	return email;
    }
	/**
	 * 1为男，2为女
	 * @param sex
	 */
	public void setSex(Byte sex){
		this.sex = sex;
	}
	
    /**
     * 1为男，2为女
     * @return
     */	
    public Byte getSex(){
    	return sex;
    }
	/**
	 * 常住地址
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}
	
    /**
     * 常住地址
     * @return
     */	
    public String getAddress(){
    	return address;
    }
	/**
	 * 微信ID
	 * @param weixinId
	 */
	public void setWeixinId(String weixinId){
		this.weixinId = weixinId;
	}
	
    /**
     * 微信ID
     * @return
     */	
    public String getWeixinId(){
    	return weixinId;
    }
	/**
	 * 微博ID
	 * @param weiboId
	 */
	public void setWeiboId(String weiboId){
		this.weiboId = weiboId;
	}
	
    /**
     * 微博ID
     * @return
     */	
    public String getWeiboId(){
    	return weiboId;
    }
	/**
	 * 支付宝ID
	 * @param zhifubaoId
	 */
	public void setZhifubaoId(String zhifubaoId){
		this.zhifubaoId = zhifubaoId;
	}
	
    /**
     * 支付宝ID
     * @return
     */	
    public String getZhifubaoId(){
    	return zhifubaoId;
    }
	/**
	 * 昵称
	 * @param nickname
	 */
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	
    /**
     * 昵称
     * @return
     */	
    public String getNickname(){
    	return nickname;
    }
	/**
	 * 用户头像保存地址
	 * @param userpic
	 */
	public void setUserpic(String userpic){
		this.userpic = userpic;
	}
	
    /**
     * 用户头像保存地址
     * @return
     */	
    public String getUserpic(){
    	return userpic;
    }
	/**
	 * 用户生日
	 * @param birthday
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	
    /**
     * 用户生日
     * @return
     */	
    public String getBirthday(){
    	return birthday;
    }
	/**
	 * 所属会员ID
	 * @param pid
	 */
	public void setPid(Integer pid){
		this.pid = pid;
	}
	
    /**
     * 所属会员ID
     * @return
     */	
    public Integer getPid(){
    	return pid;
    }
	/**
	 * 会员类型
	 * @param userType
	 */
	public void setUserType(String userType){
		this.userType = userType;
	}
	
    /**
     * 会员类型
     * @return
     */	
    public String getUserType(){
    	return userType;
    }
	/**
	 * 会员等级
	 * @param userGrade
	 */
	public void setUserGrade(String userGrade){
		this.userGrade = userGrade;
	}
	
    /**
     * 会员等级
     * @return
     */	
    public String getUserGrade(){
    	return userGrade;
    }
	/**
	 * 积分
	 * @param integral
	 */
	public void setIntegral(Long integral){
		this.integral = integral;
	}
	
    /**
     * 积分
     * @return
     */	
    public Long getIntegral(){
    	return integral;
    }
	/**
	 * 余额
	 * @param balance
	 */
	public void setBalance(java.math.BigDecimal balance){
		this.balance = balance;
	}
	
    /**
     * 余额
     * @return
     */	
    public java.math.BigDecimal getBalance(){
    	return balance;
    }
	/**
	 * 被冻结的余额
	 * @param frozenBalance
	 */
	public void setFrozenBalance(java.math.BigDecimal frozenBalance){
		this.frozenBalance = frozenBalance;
	}
	
    /**
     * 被冻结的余额
     * @return
     */	
    public java.math.BigDecimal getFrozenBalance(){
    	return frozenBalance;
    }
	/**
	 * 押金余额
	 * @param depositBalance
	 */
	public void setDepositBalance(java.math.BigDecimal depositBalance){
		this.depositBalance = depositBalance;
	}
	
    /**
     * 押金余额
     * @return
     */	
    public java.math.BigDecimal getDepositBalance(){
    	return depositBalance;
    }
	/**
	 * 被冻结的押金余额
	 * @param frozenDepositBalance
	 */
	public void setFrozenDepositBalance(java.math.BigDecimal frozenDepositBalance){
		this.frozenDepositBalance = frozenDepositBalance;
	}
	
    /**
     * 被冻结的押金余额
     * @return
     */	
    public java.math.BigDecimal getFrozenDepositBalance(){
    	return frozenDepositBalance;
    }
	/**
	 * 限额
	 * @param limitBalance
	 */
	public void setLimitBalance(java.math.BigDecimal limitBalance){
		this.limitBalance = limitBalance;
	}
	
    /**
     * 限额
     * @return
     */	
    public java.math.BigDecimal getLimitBalance(){
    	return limitBalance;
    }
	/**
	 * 1正常,2被冻结，3黑名单
	 * @param status
	 */
	public void setStatus(Byte status){
		this.status = status;
	}
	
    /**
     * 1正常,2被冻结，3黑名单
     * @return
     */	
    public Byte getStatus(){
    	return status;
    }
	/**
	 * 记录登录IP
	 * @param loginIp
	 */
	public void setLoginIp(String loginIp){
		this.loginIp = loginIp;
	}
	
    /**
     * 记录登录IP
     * @return
     */	
    public String getLoginIp(){
    	return loginIp;
    }
	/**
	 * 绑定的时间
	 * @param bundTime
	 */
	public void setBundTime(String bundTime){
		this.bundTime = bundTime;
	}
	
    /**
     * 绑定的时间
     * @return
     */	
    public String getBundTime(){
    	return bundTime;
    }
	/**
	 * 更新时间
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}
	
    /**
     * 更新时间
     * @return
     */	
    public String getUpdateTime(){
    	return updateTime;
    }
}