package cn.happyworlds.imgmt.entity;

import java.io.Serializable;

/**
 * 
 * @author yanjy
 */
public class LegalHoliday implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 *  èŠ‚æ—¥
	 */
	private String holiday;
	/**
	 *  èŠ‚å�‡å¼€å§‹æ—¥æœŸ
	 */
	private String holidayStart;
	/**
	 *  èŠ‚å�‡ç»“æ�Ÿæ—¥æœŸ
	 */
	private String holidayEnd;
	/**
	 * èŠ‚æ—¥
	 * @param holiday
	 */
	public void setHoliday(String holiday){
		this.holiday = holiday;
	}
	
    /**
     * èŠ‚æ—¥
     * @return
     */	
    public String getHoliday(){
    	return holiday;
    }
	/**
	 * èŠ‚å�‡å¼€å§‹æ—¥æœŸ
	 * @param holidayStart
	 */
	public void setHolidayStart(String holidayStart){
		this.holidayStart = holidayStart;
	}
	
    /**
     * èŠ‚å�‡å¼€å§‹æ—¥æœŸ
     * @return
     */	
    public String getHolidayStart(){
    	return holidayStart;
    }
	/**
	 * èŠ‚å�‡ç»“æ�Ÿæ—¥æœŸ
	 * @param holidayEnd
	 */
	public void setHolidayEnd(String holidayEnd){
		this.holidayEnd = holidayEnd;
	}
	
    /**
     * èŠ‚å�‡ç»“æ�Ÿæ—¥æœŸ
     * @return
     */	
    public String getHolidayEnd(){
    	return holidayEnd;
    }
}