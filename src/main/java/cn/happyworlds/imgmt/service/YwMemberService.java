package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.YwMember;
import cn.happyworlds.imgmt.mapper.YwMemberMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class YwMemberService {

	@Autowired
	private YwMemberMapper ywMemberMapper;
	
	public Result<PageInfo<YwMember>> YwMemberList(final String userId,final String username,final String mobile,final String idNo,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(userId)) {
			params.put("userId", userId);
		}
		if (StringUtils.hasText(username)) {
			params.put("username", username);
		}
		if (StringUtils.hasText(mobile)) {
			params.put("mobile", mobile);
		}
		if (StringUtils.hasText(idNo)) {
			params.put("idNo", idNo);
		}
		List<YwMember> page = ywMemberMapper.searchYwMemberByParams(params, pageBounds);
		return Result.create(new PageInfo<YwMember>(page));
	}
	
	
	
	
}
