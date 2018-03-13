package cn.happyworlds.imgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.CpCrdmtn;
import cn.happyworlds.imgmt.mapper.CpCrdmtnMapper;

@Service
public class CpCrdmtnService {

	@Autowired
	private CpCrdmtnMapper cpCrdmtnMapper;

	//添加数据
	public void insertCpCrdmtn(CpCrdmtn crdmtn) {
		try {
			cpCrdmtnMapper.insertCpCrdmtn(crdmtn);
			System.out.println("卡维护表添加成功");
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("卡维护表添加失败");
		}
	}
}
