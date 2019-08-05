package com.wenda.comp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.model.School;
import com.wenda.comp.model.SysRole;
import com.wenda.comp.model.SysUser;
import com.wenda.comp.security.PasswordEncoder;
import com.wenda.comp.service.LoginService;

/**
 * <p>
 * Description: 登录验证serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 登录验证
	 * 
	 * @param userName
	 * @param rawPass
	 * @return
	 */
	public boolean isLoginSuccess(String userName, String rawPass,
			Integer schoolType) {
		SysUser sysUser = sysUserDao.findByUserName(userName);
		if (sysUser == null)
			return false;
		School school = sysUser.getSchool();
		if (sysUser != null
				&& PasswordEncoder.isPasswordValid(sysUser.getPassword(),
						userName, rawPass) && school.getType() == schoolType) {
			return true;
		}
		return false;
	}

	/**
	 * 获取登录的组织类型
	 * 
	 * @param userName
	 * @return
	 */
	public Integer getOrgnizeType(String userName) {
		SysUser sysUser = sysUserDao.findByUserName(userName);
		School school = sysUser.getSchool();
		return school.getType();
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public SysRole getSysRoleId(String userName) {
		SysUser sysUser = sysUserDao.findByUserName(userName);
		SysRole sysRole = sysUser.getSysRole();
		return sysRole;
	}
}
