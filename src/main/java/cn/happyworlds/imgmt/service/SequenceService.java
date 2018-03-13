package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class SequenceService {

	private static final Logger LOG = LoggerFactory.getLogger(SequenceService.class);
	@Autowired
	private SequenceMapper sequenceMapper;

	/**
	 * 柜台购票获取票券ID
	 * 
	 * @param seqName
	 * @author Hugh
	 */
	public Long getTicketId(String seqName) {
		Long ticketId = sequenceMapper.searchNexttkToTicketId(seqName);
		return ticketId;
	}
	
	
	/**
	 * 柜台购票获取流水交易ID
	 * 
	 * @param seqName
	 * @author Hugh
	 */
	public Long getTranId(String seqName) {
		Long tranId = sequenceMapper.searchNextvalToCtTranId(seqName);
		return tranId;
	}
	
	/**
	 * 柜台购票获取流水主键ID
	 * 
	 * @param seqName
	 * @author Hugh
	 */
	public BigDecimal getMessageId() {
		BigDecimal name = sequenceMapper.searchSerialToName();
		if(name.compareTo(new BigDecimal(SysDateFormat.getNowDate("yyyyMMdd")))!=0){
			sequenceMapper.truncateSerial();
		}
		return sequenceMapper.searchNextserialToCtMessageId(SysDateFormat.getNowDate("yyyyMMdd"));
	}
	
}
