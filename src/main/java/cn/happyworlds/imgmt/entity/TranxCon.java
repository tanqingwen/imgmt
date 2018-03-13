/**
 *项目：xmlInterf
 *通联支付网络有限公司
 * 作者：张广海
 * 日期：Jan 2, 2013
 * 功能说明：交易demo测试参数
 */
package cn.happyworlds.imgmt.entity;
/**
 */
public class TranxCon {

	/**
	 * XML交易参数
	 */
	public   String acctName = "张三";
	public   String acctNo = "1234567890123456789";
	public   String amount = "10";//交易金额
	public   String bankcode = "105";//银行代码
	public   String cerPath= "E:\\daifuzhengshu\\allinpay-pds.cer";
	public   String merchantId = "200691900013545";
	public   String password = "111111";
	//商户证书信息
	public   String pfxPassword = "111111";
	public   String pfxPath= "/home/happyworld/happy_world_api/20069190001354504.p12";
	public   String sum = " 20";//交易总金额
	public   String tel = "18696694946";
	public   String tltcerPath= "/home/happyworld/happy_world_api/allinpay-pds.cer";
	public   String userName = "20069190001354504"; 
	public String getAcctName() {
		return acctName;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public String getAmount() {
		return amount;
	}
	public String getBankcode() {
		return bankcode;
	}
	public String getCerPath() {
		return cerPath;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public String getPassword() {
		return password;
	}
	public String getPfxPassword() {
		return pfxPassword;
	}
	public String getPfxPath() {
		return pfxPath;
	}
	public String getSum() {
		return sum;
	}
	public String getTel() {
		return tel;
	}
	public String getTltcerPath() {
		return tltcerPath;
	}
	public String getUserName() {
		return userName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public void setCerPath(String cerPath) {
		this.cerPath = cerPath;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPfxPassword(String pfxPassword) {
		this.pfxPassword = pfxPassword;
	}
	public void setPfxPath(String pfxPath) {
		this.pfxPath = pfxPath;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setTltcerPath(String tltcerPath) {
		this.tltcerPath = tltcerPath;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	
	
}
