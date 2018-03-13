package cn.happyworlds.imgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.AclUser;
import cn.happyworlds.imgmt.mapper.AclUserMapper;
import cn.happyworlds.imgmt.util.Result;


@Service
public class AclUserService {
	
	@Autowired
	private AclUserMapper aclUserMapper;
	
	public Result<List<AclUser>> AclUserListAll() {
		List<AclUser> page = aclUserMapper.searchAclUserByParams(null);
		return Result.create(page);
	}
	
	
	
}
