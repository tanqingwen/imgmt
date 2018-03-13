package cn.happyworlds.imgmt.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.happyworlds.imgmt.entity.CpSysprm;
import cn.happyworlds.imgmt.mapper.CpSysprmMapper;
import cn.happyworlds.imgmt.service.CrdtblService;

/**
 * 工具类
 * 
 * 
 * @author Hugh
 *
 */
public class ProcessDate {
	
	private static final Logger LOG = LoggerFactory.getLogger(CrdtblService.class);

	@Autowired
	private CpSysprmMapper cpSysprmMapper;
	
	// 获取当前系统日期
	public String SP_NEXT_PROCESSING_DATE() {
		
		String processDate="";
		try{
			//cp_sysprm:系统参数表
			List<CpSysprm> sysprmList=cpSysprmMapper.searchCpSysprmByParams(null);
			CpSysprm cpSysprm=new CpSysprm();
			if(null!=sysprmList && sysprmList.size()>0){
				cpSysprm=sysprmList.get(0);
				processDate=cpSysprm.getSpNextProcessingDate();
			}
		}catch (Throwable e) {
			LOG.warn("检查开卡异常", e);
		}
		return processDate;
	}
}
