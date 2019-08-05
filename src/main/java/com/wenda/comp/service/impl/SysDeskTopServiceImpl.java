package com.wenda.comp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.SysDesktopDao;
import com.wenda.comp.model.SysDesktop;
import com.wenda.comp.service.SysDeskTopService;

/**
 * <p>
 * Description: ϵͳ����serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service

public class SysDeskTopServiceImpl implements SysDeskTopService{

	@Autowired
	private SysDesktopDao sysDesktopDao;
	
	/**
	 * ��������ϵͳ����
	 * @return
	 */
	public List<SysDesktop> findAllDeskTop(){	
		return sysDesktopDao.findAll();
	}
	
	/**
	 * ����һ��ϵͳ����
	 * @param id
	 * @return
	 */
	public SysDesktop findOne(Long id){	
		return sysDesktopDao.findOne(id);
	}
}
