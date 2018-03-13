package cn.happyworlds.imgmt.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.AclUser;
import cn.happyworlds.imgmt.mapper.AclUserMapper;
import cn.happyworlds.imgmt.util.Result;


@Service
public class AutomaticGrowthService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String sqlNextVal(String seqName){
		String sqlStr="select nextval('"+seqName+"') from DUAL";
		String reStr=null;
		try{
			reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return reStr;
	}
	
	public String sqlSelect(String str){
		String sqlStr="select '"+str+"' from DUAL";
		String reStr=null;
		try{
			reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return reStr;
	}
	
	public String sqlNextHuiyuan(String seqName){
		String sqlStr="select nexthuiyuan('"+seqName+"') from DUAL";
		String reStr=null;
		try{
			reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return reStr;
	}
	
	public void sqlExcute(String sqlStr){
		try{
			jdbcTemplate.execute(sqlStr);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String nextSerial(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
	    String date=formatter.format(new Date());
	    String str=sqlSelect("name");
	    String reStr=null;
	    try{
	    	if(!str.equals(date)){
	    		sqlExcute("truncate table serial");
	    	}
	    	String sSql = "select nextserial('"+date+"') from DUAL";
	    	reStr=jdbcTemplate.queryForObject(sSql, java.lang.String.class);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return null;
	    }
		return reStr;
	}
	 public String getPostTime(){
		 String sqlStr="select sp_next_processing_date from cp_sysprm";
		 String reStr=null;
		 try{
			 reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		 }catch(Exception e){
			e.printStackTrace();
			return null;
		 }	 
		 return reStr;
	 }
	 
	 public String nextTicketId(String str){
		 String sqlStr="select nexttkval('"+str+"') from DUAL";
		 String reStr=null;
		 try{
			reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		 }catch(Exception e){
			e.printStackTrace();
			return null;
		 }
		 return reStr;
	 }
	 
	 public String nextliushui(String str){
		 String sqlStr="select nextliushui('"+str+"') from DUAL";
		 String reStr=null;
		 try{
			reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		 }catch(Exception e){
			e.printStackTrace();
			return null;
		 }
		 return reStr;
	 }
	 
	 public String nextdindang(String str){
		 String sqlStr="select nextdindang('"+str+"') from DUAL";
		 String reStr=null;
		 try{
			reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		 }catch(Exception e){
			e.printStackTrace();
			return null;
		 }
		 return reStr;
	 }
	 
	 public String dindangitem(String str){
		 String sqlStr="select dindangitem('"+str+"') from DUAL";
		 String reStr=null;
		 try{
			reStr=jdbcTemplate.queryForObject(sqlStr, java.lang.String.class);
		 }catch(Exception e){
			e.printStackTrace();
			return null;
		 }
		 return reStr;
	 }
	
	
	
}
