package com.wenda.comp.service.impl;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wenda.comp.dao.SysOperateDao;
import com.wenda.comp.model.SysOperate;
import com.wenda.comp.model.SysRoleResource;
import com.wenda.comp.service.SysOperateService;
import com.wenda.comp.service.SysRoleResourceService;

/**
 * <p>
 * Description: 资源操作serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2015-03-03
 */
@Service
public class SysOperateServiceImpl implements SysOperateService {

	@Autowired
	private SysOperateDao sysOperateDao;

	@Autowired
	private SysRoleResourceService sysRoleResourceService;

	/**
	 * 资源操作赋权限
	 * 
	 * @param roleId
	 * @param level
	 * @param resourceNames
	 * @return
	 */
	public List<SysOperate> findAuthorityOperate(Long roleId, Integer level,
			List<String> resourceNames) {
		List<String> list = new LinkedList<String>();
		List<SysRoleResource> sysRoleResources = sysRoleResourceService
				.getDeskRoleResource(roleId, level, resourceNames);
		for (SysRoleResource srr : sysRoleResources)
			list.add(srr.getSysResource().getName());
		if (list != null && list.size() > 0)
			return sysOperateDao.findByResourceName(list);
		return null;
	}
	
	/**
	 * 根据资源名和操作名查找对应操作
	 * @param name
	 * @param resourceName
	 * @return
	 */
	public SysOperate findByNameAndResourceName(String name,String resourceName){	
		return sysOperateDao.findByNameAndResourceName(name, resourceName);
	}
	
	/**
	 * 删除限制的操作权限
	 * @param list
	 */
	public void deleteLimitOperation(List<SysOperate> list){	
		sysOperateDao.save(list);
	}
}
