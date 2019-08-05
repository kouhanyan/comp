package com.wenda.comp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.SysUserDao;
import com.wenda.comp.model.SysUser;
import com.wenda.comp.service.SysUserService;

/**
 * <p>
 * Description: ϵͳ�û�serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service

public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;
	
	/**
	 * �û������޸�
	 * @param sysUser
	 */
	@Transactional
	public void editPassward(SysUser sysUser){	
		sysUserDao.save(sysUser);
	}
	
	/**
	 * ���ҵ�ǰ�û�
	 * @param userName
	 * @return
	 */
	public SysUser findByUserName(String userName){	
		SysUser sysUser=sysUserDao.findByUserName(userName);
		return sysUser;
	}
}
