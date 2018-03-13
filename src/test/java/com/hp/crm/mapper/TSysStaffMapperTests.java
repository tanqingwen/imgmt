package com.hp.crm.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.happyworlds.imgmt.ImgmtApplication;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.TSysStaffMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ImgmtApplication.class)
@DirtiesContext
public class TSysStaffMapperTests {

	@Autowired
	TSysStaffMapper tSysStaffMapper;
	
	@Test
	public void test() {
		List<TSysStaff> list = tSysStaffMapper.searchTSysStaffByParams(null);
		System.out.println("list:" + list);
	}
}
