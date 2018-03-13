package cn.happyworlds.imgmt.mapper;


public interface SequenceMapper {
	/**
	 * 获取cp_crdmtn表cm_mth_seq里面的最大值
	 * @return
	 */
	Long searchCpCrdmtnToParamsMax();
	/**
	 * 获取nextval函数的里面当前值的下一个值
	 * @param name		随便输入一个字符串就行
	 * @return
	 */
	Long searchNextvalToCtTranId(String name);
	/**
	 * 获取nexttkval函数的里面当前值的下一个值
	 * @param name		随便输入一个字符串就行
	 * @return
	 */
	Long searchNexttkToTicketId(String name);
	/**
	 * 获取当前时间
	 * @return
	 */
    java.math.BigDecimal searchSerialToName();
    /**
     * 让serial从0开始searchIndaccseq
     */
    void truncateSerial();
    /**
     * 获取nextserial函数的里面当前值的下一个值
     * @param name
     * @return
     */
    java.math.BigDecimal searchNextserialToCtMessageId(String name);
    /**
     * 获取indaccseq函数的里面当前值的下一个值
     * @param name
     * @return
     */
    Long searchIndaccseq(String name);

} 
