package cn.happyworlds.imgmt.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.StringUtil;

@Service
public class IndaccService {

	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;

	// 更新余额
	public Result<TSysStaff> staffUpdate(TSysStaff staff) {
		try {

		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("STAFF_UPDATE_FAILED", "员工更新失败");
		}
		return Result.create(staff);
	}

	// 读卡号，查询卡号,证件类型,证件号码,姓名,卡类型,手机,出生日期,押金,状态
	public Result<CpCrdtbl> IndaccGetById(String cbCardholderNo) {
		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
		if ("L".equals(cpCrdtbl.getCbPlasticCd())) {
			return Result.create("STAFF_NOT_EXISTS", "挂失卡不能充值");
		} else if ("D".equals(cpCrdtbl.getCbPlasticCd())) {
			return Result.create("STAFF_NOT_EXISTS", "已销卡不能充值");
		}
		return Result.create(cpCrdtbl);
	}

	// 跟着账户和账户类型查CP_INDACC账户表数据
	public List<CpIndacc> searchCpCrdtblByParamsToacctnoAndtype(String cbIndividualAcctno,
			String cbIndividualAcctType) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbIndividualAcctno)) {
			params.put("cbIndividualAcctno", cbIndividualAcctno);
		}
		if (StringUtils.hasText(cbIndividualAcctType)) {
			params.put("cbIndividualAcctType", cbIndividualAcctType);
		}
		List<CpIndacc> page = cpIndaccMapper.searchCpIndaccByParams(params);
		return page;
	}

	// 读卡号，查询余额
	public BigDecimal IndaccGetBalance(String cbCardholderNo) {
		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cbCardholderNo);
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbCardholderNo)) {
			params.put("cbIndCardholderNo", cbCardholderNo);
		}
		if (StringUtils.hasText(BigDecimal.ONE + "")) {
			params.put("cbIndividualAcctType", BigDecimal.ONE + "");
		}
		if (StringUtils.hasText(cpCrdtbl.getCbIndividualAcctno())) {
			params.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
		}
		List<CpIndacc> indacc = cpIndaccMapper.searchCpIndaccByParams(params);
		BigDecimal rtn = new BigDecimal("0.000");
		if (indacc.size() == 1) {
			return indacc.get(0).getCbOutstdBal();
		}
		return rtn;
	}

	/**
	 * 余额查询
	 * 
	 * @param cardno
	 * 
	 */
	public StatusResult<String> getBalance(String cardno) {
		if (!StringUtil.hasText(cardno)) {
			return StatusResult.create("FALSE", "卡号不能为空或空格");
		}
		CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbCardholderNo(cardno);
		Map<String, String> params = new HashMap<>();
		if (null != cpCrdtbl) {
			params.put("cbIndCardholderNo", cardno);
			params.put("cbIndividualAcctType", BigDecimal.ONE + "");
			params.put("cbIndividualAcctno", cpCrdtbl.getCbIndividualAcctno());
			List<CpIndacc> indacc = cpIndaccMapper.searchCpIndaccByParams(params);
			if (indacc != null && indacc.size() > 0) {
				return StatusResult.create(indacc.get(0).getCbOutstdBal().toString());
			} else {
				return StatusResult.create("FALSE", "账户不存在");
			}
		} else {
			return StatusResult.create("FALSE", "卡号不存在");
		}
	}

	/**
	 * 柜台购票获取账户记录
	 * 
	 * @param cardNo
	 * 
	 * @author Hugh
	 */
	public List<CpIndacc> indaccList(String cardNo) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cardNo)) {
			params.put("cbCardholderNo", cardNo);
		}
		return cpIndaccMapper.searchCpIndaccByParams(params);
	}
	
	
}
