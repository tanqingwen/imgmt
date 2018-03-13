package cn.happyworlds.imgmt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.mapper.CpCeptrxMapper;

@Service
public class CpCeptrxService {

	@Autowired
	private CpCeptrxMapper ceptrxMapper;
	
	//插入一条数据
	public Long insertCpCeptrx(CpCeptrx ceptrx) {
		Long page = ceptrxMapper.insertCpCeptrx(ceptrx);
		System.out.println("账务流水表添加数据成功");
		return page;
	}
	
}
