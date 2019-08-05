package com.wenda.comp.service.impl;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.wenda.comp.dao.SysResourceDao;
import com.wenda.comp.dao.SysRoleResourceDao;
import com.wenda.comp.dao.jdbc.SysResourceDaoJdbc;
import com.wenda.comp.model.SysResource;
import com.wenda.comp.model.SysRoleResource;
import com.wenda.comp.service.SysResourceService;

/**
 * <p>
 * Description: 系统资源serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service

public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;

	@Autowired
	private SysResourceDaoJdbc sysResourceDaoJdbc;

	@Autowired
	private SysResourceDao sysResourceDao;

	/**
	 * 通过角色id资源等级以及父id查找
	 * 
	 * @param roleId
	 * @param level
	 * @param parentId
	 * @return
	 */
	public List<SysResource> findByRoleIdAndLevelAndParentId(Long roleId,
			Integer level, Long parentId) {
		List<SysRoleResource> sysRoleResources = null;
		List<SysResource> sysResources = new LinkedList<SysResource>();
		if (parentId == null) {
			sysRoleResources = sysRoleResourceDao.findByRoleId(roleId, level);
		} else {
			sysRoleResources = sysRoleResourceDao
					.findByRoleIdAndLevelAndParentId(roleId, level, parentId);
		}
		for (SysRoleResource srr : sysRoleResources) {
			sysResources.add(srr.getSysResource());
		}
		return sysResources;
	}

	/**
	 * 通过父id查找父资源
	 * 
	 * @param parentId
	 * @return
	 */
	public SysResource findParentResource(Long parentId) {
		SysResource sysResource = sysResourceDao.findParentResource(parentId);
		return sysResource;
	}

	/**
	 * 通过id查找资源
	 * 
	 * @param id
	 * @return
	 */
	public SysResource findById(Long id) {
		SysResource sysResource = sysResourceDao.findOne(id);
		return sysResource;
	}

	/**
	 * 获取桌面显示资源
	 * 
	 * @param deskResourceNames
	 * @param roleId
	 * @return
	 */
	public List<SysResource> findDeskResources(List<String> deskResourceNames,
			Long schoolId) {
		return sysResourceDaoJdbc
				.findDeskResources(deskResourceNames, schoolId);
	}

	/**
	 * 通过资源名和等级查找
	 * 
	 * @param name
	 * @param level
	 * @return
	 */
	public SysResource findByNameAndLevel(String name, Integer level) {
		return sysResourceDao.findByNameAndLevel(name, level);
	}
}
