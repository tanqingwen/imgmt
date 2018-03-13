package cn.happyworlds.imgmt.util;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.happyworlds.imgmt.entity.Serial;
import cn.happyworlds.imgmt.mapper.SerialMapper;

public class CodeUtil
{
	
	public final static int MAKE_CHECK_MODEL1=1;
	public final static int MAKE_CHECK_MODEL2=2;
	public final static int MAKE_CHECK_MODEL3=3;
	
	@Autowired
	private SerialMapper serialMapper;
	
	public BigDecimal nextSerial(){
		
		String date = SysDateFormat.getNowDate("yyMMdd");
		List<Serial> serialList=serialMapper.searchSerialByParams(null);
		if(null!=serialList && serialList.size()>0){
			if(serialList.get(0).getName().compareTo(date)!=0){
				serialMapper.deleteSerialByParams(null);
			}
		}
		//没DUAL表
		return null;
	}
	
}
