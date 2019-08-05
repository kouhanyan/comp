package com.wenda.comp.service;

import java.util.List;

import com.wenda.comp.model.SysOperate;

/**
 * <p>
 * Description: 资源操作service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2015-03-03
 */
public interface SysOperateService{

	/**
	 * 资源操作赋权限
	 * @param roleId
	 * @param level
	 * @param resourceNames
	 * @return
	 */
	public List<SysOperate> findAuthorityOperate(Long roleId, Integer level,
			List<String> resourceNames);
	
	/**
	 * 根据资源名和操作名查找对应操作
	 * @param name
	 * @param resourceName
	 * @return
	 */
	public SysOperate findByNameAndResourceName(String name,String resourceName);
	
	/**
	 * 删除限制的操作权限
	 * @param list
	 */
	public void deleteLimitOperation(List<SysOperate> list);
}
