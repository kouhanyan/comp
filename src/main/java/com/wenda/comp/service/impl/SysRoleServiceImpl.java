package com.wenda.comp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wenda.comp.dao.SysRoleDao;
import com.wenda.comp.model.SysRole;
import com.wenda.comp.service.SysRoleService;

/**
 * <p>
 * Description: ϵͳ��ɫserviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service

public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;
	
	/**
	 * ͨ��Id��ȡ��ɫ
	 * @param id
	 * @return
	 */
	public SysRole findRoleById(Long id){	
		return sysRoleDao.findOne(id);
	}
}
