package com.wenda.comp.service;

import java.util.List;

import com.wenda.comp.model.SysResource;

/**
 * <p>
 * Description: 系统资源service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysResourceService {

	/**
	 * 通过角色id资源等级以及父id查找
	 * 
	 * @param roleId
	 * @param level
	 * @param parentId
	 * @return
	 */
	public List<SysResource> findByRoleIdAndLevelAndParentId(Long roleId,
			Integer level, Long parentId);
	
	/**
	 * 通过父id查找父资源
	 * 
	 * @param parentId
	 * @return
	 */
	public SysResource findParentResource(Long parentId);
	
	/**
	 * 通过id查找资源
	 * @param id
	 * @return
	 */
	public SysResource findById(Long id);
	
	/**
	 * 获取桌面显示资源
	 * @param deskResourceNames
	 * @param roleId
	 * @return
	 */
	public List<SysResource> findDeskResources(List<String> deskResourceNames,Long roleId);
	
	/**
	 * 通过资源名和等级查找
	 * @param name
	 * @param level
	 * @return
	 */
	public SysResource findByNameAndLevel(String name,Integer level);
}
