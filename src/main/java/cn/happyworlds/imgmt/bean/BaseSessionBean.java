package cn.happyworlds.imgmt.bean;


public class BaseSessionBean implements  java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String language=null;
	protected boolean escapeQuote=false;//�ṩ��ʾ���ݵķ��������ص������Ƿ�Ҫ�� "����"��ת������
	protected String user=null;

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(BaseSessionBean.class);	
	
	public void setUser(String u){
		this.user=u;
	}
	public void setLanguage(String lang){
		language=lang;
	}
	public void setEscapeQuote(boolean needEscape)
	{
		escapeQuote=needEscape;
		log.debug("escapeQuote : "+escapeQuote);
	}
	public boolean isEscapeQuote()
	{
		return escapeQuote;
	}
	
}
