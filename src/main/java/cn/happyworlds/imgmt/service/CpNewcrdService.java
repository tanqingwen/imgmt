package cn.happyworlds.imgmt.service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.CpNewcrd;
import cn.happyworlds.imgmt.mapper.CpNewcrdMapper;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Service
public class CpNewcrdService {
	@Autowired
	private CpNewcrdMapper cpNewcrdMapper;
	
	public Result<CpNewcrd> select(String ncCardNo){
		CpNewcrd cpNewcrd = cpNewcrdMapper.searchCpNewcrdByNcCardNo(ncCardNo);
		if(cpNewcrd==null){
			return Result.create("CPNEWCRD_NOT_EXIST","无此批次号，请查证后再下载");
		}
		return null;
	}
	
	public void upload(String ncCardNo,HttpServletResponse resp) {
		List<CpNewcrd> cpNewcrds = new ArrayList<CpNewcrd>();
		if(ncCardNo!=null && !ncCardNo.equals("")){
			CpNewcrd cpNewcrd  = cpNewcrdMapper.searchCpNewcrdByNcCardNo(ncCardNo);
			cpNewcrds.add(cpNewcrd);
		}else{
			cpNewcrds = cpNewcrdMapper.searchCpNewcrdByParams(null);
		}
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < cpNewcrds.size(); i++) {
			buf.append(cpNewcrds.get(i).getNcCardNo()+"\r\n");
		}
		
		String fileName = "MakeCard_";
		String nowtime = SysDateFormat.getNowDate("MMddHHmm");
		fileName += nowtime;
		fileName += "_"+(int)(Math.random()*100);
		fileName += ".txt";
		
		try {
			resp.setContentType("text/plain");
			resp.setHeader("Content-disposition", "attachment;filename="+fileName);
			OutputStream os = resp.getOutputStream();
			os.write(buf.toString().getBytes("UTF-8"));
			os.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
