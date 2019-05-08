package com.brcc.business.home.service.Impl;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.home.entity.LoginUpLogEntity;
import com.brcc.business.home.entity.MenuRoleNewEntity;
import com.brcc.business.home.entity.MenuUserNewEntity;
import com.brcc.business.home.entity.RegisterEntity;
import com.brcc.business.home.repository.*;
import com.brcc.business.home.service.RegisterService;
import com.brcc.business.home.vo.RegisterCommonVo;
import com.brcc.business.home.vo.RegisterQueryVo;
import com.brcc.business.home.vo.RegisterVo;
import com.brcc.business.transorder.entity.LoginverifyEntity;
import com.brcc.business.transorder.entity.ShortmessageEntity;
import com.brcc.business.transorder.repository.ShortMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class RegisterServiceImpl implements RegisterService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RegisterRepository registerRopository;

	@Autowired
	LoginUpLogRepository loginUpLogRepository;

	@Autowired
	LoginVerifyRepositorys loginVerifyRepository;

	@Autowired
	CompanyRepositorys companyRepository;

	@Autowired
	MenuUserRepository menuUserRepository;

	@Autowired
	ShortMessageRepository shortMessageRepository;

	@Override
	public HashMap registerName(RegisterQueryVo queryVo) {
		HashMap map = new HashMap();
		HashMap map1 = getPlatformId(queryVo);
		if (map1.get("outResult").toString().equals("1")) {
			queryVo.setPlatformId(map1.get("platformId").toString());
			List<RegisterVo> list = registerRopository.registerName(queryVo);
			if (list.size() > 0) {
				map.put("outResult", "0");
				map.put("outResultReason", "当前用户名称已存在");
			} else {
				map.put("outResult", "1");
				map.put("outResultReason", "");
			}
			return map;
		}
		return map1;
	}

	@Override
	public HashMap registerCompany(RegisterQueryVo queryVo) {
		HashMap map = new HashMap();
		HashMap map1 = getPlatformId(queryVo);
		if (map1.get("outResult").toString().equals("1")) {
			queryVo.setPlatformId(map1.get("platformId").toString());
			List<RegisterVo> list = registerRopository.registerCompany(queryVo);
			if (list.size() > 0) {
				map.put("outResult", "0");
				map.put("outResultReason", "当前公司名称已存在");
			} else {
				map.put("outResult", "1");
				map.put("outResultReason", "");
			}
			return map;
		}
		return map1;

	}

	@Override
	public HashMap registerInfo(RegisterQueryVo queryVo) {
		HashMap map = new HashMap();
		HashMap map1 = getPlatformId(queryVo);
		if (map1.get("outResult").toString().equals("1")) {
			queryVo.setPlatformId(map1.get("platformId").toString());
			List<RegisterVo> list = registerRopository.registerCompany(queryVo);
			if (list.size() > 0) {
				map.put("outResult", "0");
				map.put("outResultReason", "公司名称已存在,请重新输入");
				return map;
			}
			/*
			 * else { map.put("outResult", "1"); map.put("outResultReason", ""); }
			 */

			// 验证用户名并插入LoginUpLog
			List<RegisterVo> list1 = registerRopository.registerName(queryVo);

			for (int i = 0; i < list1.size(); i++) {
				if ("APP".equals(list1.get(i).getLoginType())) {
					Long num = registerRopository.queryLoginLogIsHas(queryVo.getLoginName(), queryVo.getPlatformId());
					if (num == 0) {
						LoginUpLogEntity entity = new LoginUpLogEntity();
						entity.setLoginName(queryVo.getLoginName());
						entity.setUserId(Long.valueOf(list1.get(i).getUserId()));
						entity.setPlatformId(list1.get(i).getPlatformId());
						entity.setStatus("10");
						entity.setCreateDate(new Date());
						loginUpLogRepository.save(entity);
					}
				} else {
					map.put("outResult", "0");
					map.put("outResultReason", "该登录帐号已存在。");
					return map;
				}
			}
			// 插入注册表
			insertRegister(queryVo);

			// 插入登录表
			Integer regId = insertLoginVerify(queryVo);

			// 返回修改注册表的userId

			Long maxUserId = loginVerifyRepository.getMaxUserId(queryVo.getLoginName());
			updateRegisterByRegId(maxUserId, regId);

			// 插入公司表
			insertCompany(queryVo, regId, maxUserId);

			// 根据userId 获取最大的companyId,返回修改LoginVerify表中的companyId
			upadteLoginVerifyByUserId(maxUserId);

			// 插入menuuser_new表
			insertMenuuser_new(queryVo.getBrokerPeopleFlag(), maxUserId.toString());

			// 生成短信，在LoginVerify中查询号码
			insertLoginVerifyMsg(queryVo.getPlatformId(), queryVo.getCompanyName());
			map.put("outResult", "1");
			map.put("outResultReason", "注册成功，将为您跳转至登录页面！");
			return map;
		}
		return map1;
	}

	private void updateRegisterByRegId(Long maxUserId, Integer regId) {

		RegisterEntity oldRegisterEntity = registerRopository.findBySeqId(regId);
		oldRegisterEntity.setUserId(maxUserId);
		registerRopository.save(oldRegisterEntity);

	}

	private void upadteLoginVerifyByUserId(Long maxUserId) {
		Long maxCompanyId = companyRepository.getMaxCompanyId(maxUserId);
		LoginverifyEntity oldLoginverifyEntity = loginVerifyRepository.findByUserId(maxUserId);
		oldLoginverifyEntity.setUpUserId(Integer.valueOf(maxUserId.toString()));
		oldLoginverifyEntity.setCompanyId(maxCompanyId.toString());
		loginVerifyRepository.save(oldLoginverifyEntity);
	}

	private void insertLoginVerifyMsg(String platformId, String companyName) {
		List<LoginverifyEntity> list = loginVerifyRepository.getMobile(platformId);
		for (int i = 0; i < list.size(); i++) {
			ShortmessageEntity entity = new ShortmessageEntity();
			entity.setReceiver(list.get(i).getMobile());
			entity.setMessage("用户" + companyName + "已在您的平台上注册，请尽快审核。");
			entity.setSendType("01");
			entity.setPlatformId(platformId);
			entity.setCreateTime(new Date());
			shortMessageRepository.save(entity);
		}

	}

	private void insertMenuuser_new(String brokerPeopleFlag, String maxUserId) {
		MenuUserNewEntity menuUserNewEntity = new MenuUserNewEntity();
		MenuRoleNewEntity menuRoleNewEntity = new MenuRoleNewEntity();
		if (brokerPeopleFlag.equals("Y")) {
			menuRoleNewEntity.setRoleId("8");
		} else {
			menuRoleNewEntity.setRoleId("2");
		}
//		MenuRoleNewEntity oldMenuRoleNewEntity = menuUserRepository
//				.getMenuRoleNewEntityByRoleId(menuRoleNewEntity.getRoleId());
//		menuUserNewEntity.setUserId(maxUserId);
//		menuUserNewEntity.setMenuId(oldMenuRoleNewEntity.getMenuId());
//		menuUserNewEntity.setCreateDate((Timestamp) new Date());
//		menuUserRepository.save(menuUserNewEntity);

		RegisterCommonVo vo=new RegisterCommonVo();
		vo.setUserId(Long.parseLong(maxUserId));
		vo.setRoleId(Long.parseLong(menuRoleNewEntity.getRoleId()));
		registerRopository.menuSetNew(vo);

	}

	private void insertCompany(RegisterQueryVo queryVo, Integer regId, Long maxUserId) {
		CompanyEntity entity = new CompanyEntity();
		entity.setCompanyName(queryVo.getCompanyName());
		entity.setContactName(queryVo.getCompanyPerson());
		entity.setContactMobile(queryVo.getCompanyMobile());
		entity.setPlatformId(queryVo.getPlatformId());
		entity.setTaxNum(queryVo.getTaxNum());
		entity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		entity.setModiDate(new Timestamp(System.currentTimeMillis()));
		entity.setRegId(Long.valueOf(regId.toString()));
		entity.setUserId(maxUserId);
		entity.setStatus("10");
		entity.setImageLocal1(queryVo.getLocalPath1());
		entity.setImageLocal2(queryVo.getLocalPath2());
		entity.setImageLocal3(queryVo.getLocalPath3());
		entity.setIfBrokerPeopleFlag(queryVo.getBrokerPeopleFlag());
		entity.setIfTransport("Y");
		companyRepository.save(entity);
	}

	private Integer insertLoginVerify(RegisterQueryVo queryVo) {

		Integer regId = registerRopository.getMaxSeqId(queryVo.getLoginName());
		LoginverifyEntity loginverifyEntity = new LoginverifyEntity();
		loginverifyEntity.setLoginName(queryVo.getLoginName());
		loginverifyEntity.setUserPasswd(queryVo.getPassword());
		loginverifyEntity.setUserName(queryVo.getCompanyPerson());
		loginverifyEntity.setPlatformId(queryVo.getPlatformId());
		loginverifyEntity.setStatus("20");
		loginverifyEntity.setUserType("GS");
		loginverifyEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		loginverifyEntity.setUserPart("ZH");
		loginverifyEntity.setIfAdmin("Y");
		loginverifyEntity.setRegId(regId);
		loginverifyEntity.setMobile(queryVo.getCompanyMobile());
		loginverifyEntity.setLoginType("WEB");
		loginverifyEntity.setRoleType("CYR");
		loginVerifyRepository.save(loginverifyEntity);
		return regId;
	}

	public HashMap getPlatformId(RegisterQueryVo queryVo) {
		HashMap map = new HashMap();
		String platformId = registerRopository.getPlatformId(queryVo.getPlatformFlag());
		if (platformId == null || platformId == "") {
			map.put("outResult", "0");
			map.put("outResultReason", "当前地址物流平台未启用");
			return map;
		} else {
			map.put("platformId", platformId);
			map.put("outResult", "1");
		}
		return map;
	}

	public void insertRegister(RegisterQueryVo queryVo) {
		RegisterEntity entity = new RegisterEntity();
		entity.setContactName(queryVo.getCompanyPerson());
		entity.setContactMobile(queryVo.getCompanyMobile());
		entity.setContactCype("GS");
		entity.setFromPlatId(queryVo.getPlatformId());
		entity.setFromType("web");
		entity.setTaxNum(queryVo.getTaxNum());
		entity.setUserType("GS");
		entity.setUserPart("ZH");
		entity.setPassword(queryVo.getPassword());
		entity.setLoginName(queryVo.getLoginName());
		entity.setCompany(queryVo.getCompanyName());
		entity.setStatus("20");
		entity.setApprove(new Date());
		entity.setCreateDate(new Date());
		entity.setLocalPath1(queryVo.getLocalPath1());
		entity.setLocalPath2(queryVo.getLocalPath2());
		entity.setLocalPath3(queryVo.getLocalPath3());
		registerRopository.save(entity);
	}

	@Override
	public HashMap getVerifCode(RegisterQueryVo queryVo) {
		HashMap map = new HashMap();
		try {
			List<LoginverifyEntity> list = loginVerifyRepository.updateVerifCodeAndRemark(queryVo.getLoginName(),
					queryVo.getCompanyMobile());
			if (list.size() > 0) {
				LoginverifyEntity entity = new LoginverifyEntity();
				BeanUtils.copyProperties(list.get(0), entity);
				entity.setVerifCode(queryVo.getVerifCode());
				entity.setRemark(queryVo.getRemark());
				loginVerifyRepository.save(entity);
				// 获取platformId
				HashMap map1 = getPlatformId(queryVo);
				/*if (map1.get("outResult").toString().equals("1")) {
					ShortmessageEntity shortmessageEntity = new ShortmessageEntity();
					shortmessageEntity.setReceiver(queryVo.getCompanyMobile());
					shortmessageEntity.setMessage("您的验证码是：" + queryVo.getVerifCode() + "，请勿泄露给他人。");
					shortmessageEntity.setSendType("01");
					shortmessageEntity.setPlatformId(map1.get("platformId").toString());
					shortmessageEntity.setCreateTime(new Date());
					shortMessageRepository.save(shortmessageEntity);
					
					// msg = "验证码已发送，请稍等片刻！";
					map.put("outResult", "1");
					map.put("outResultReason", "验证码已发送，请稍等片刻！");
				} else {*/
					return map1;
				//}
			} else {
				map.put("outResult", "0");
				map.put("outResultReason", "账号或者手机号错误！");

			}
		} catch (Exception e) {
			map.put("outResult", "0");
			map.put("outResultReason", "验证码发送失败,请稍后重试");
		}
		return map;

	}

	@Override
	public HashMap restPassword(RegisterQueryVo queryVo) {
		HashMap map = new HashMap();
		try {
			// 获取验证码

			List<LoginverifyEntity> list = loginVerifyRepository.updateVerifCodeAndRemark(queryVo.getLoginName(),
					queryVo.getCompanyMobile());
			logger.info("查询的验证码是" + list.get(0).getVerifCode() + ">>>" + queryVo.getVerifCode());
			if (list.size() == 0) {
				map.put("outResult", "0");
				map.put("outResultReason", "验证码错误或已过期！");
				return map;
				// return msg = "验证码错误或已过期！";
			} else if (list.get(0).getVerifCode().equals(queryVo.getVerifCode())) {
				LoginverifyEntity oldLoginverifyEntity = loginVerifyRepository.getDetailInfo(queryVo.getLoginName(),
						queryVo.getCompanyMobile(), queryVo.getVerifCode());
				oldLoginverifyEntity.setUserPasswd(queryVo.getNewPassword());
				loginVerifyRepository.save(oldLoginverifyEntity);
				// msg= "密码修改成功！";
				map.put("outResult", "1");
				map.put("outResultReason", "密码修改成功！");
			} else {
				map.put("outResult", "0");
				map.put("outResultReason", "验证码错误！");
				return map;
			}

		} catch (Exception e) {
			map.put("outResult", "0");
			map.put("outResultReason", "密码修改失败！请稍后重试");
		}
		return map;
	}
}
