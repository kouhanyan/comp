package com.wenda.comp.service;

import java.util.List;
import java.util.Map;
import com.wenda.comp.model.SysRole;
import com.wenda.comp.model.SysRoleResource;

/**
 * <p>
 * Description: 系统角色资源关系service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysRoleResourceService {
	/**
	 *系统角色赋权限 
	 * @param sysRole
	 * @param sysResources
	 */
	public void endueAuthority(SysRole sysRole,Long[] checks);
	
	/**
	 * 获取桌面资源
	 * @param roleId
	 * @param level
	 * @param nameList
	 * @return
	 */
	public List<SysRoleResource> getDeskRoleResource(Long roleId,Integer level,List<String> nameList);
	
	/**
	 * 获取对应角色的一级资源
	 * @param roleId
	 * @return
	 */
	public List<SysRoleResource> getOneRoleResource(Long roleId);
	
	/**
	 * 获取已经赋予权限的二级和三级资源
	 * @param roleId
	 * @param parentId
	 * @return
	 */
	public Map<String,List<SysRoleResource>> getTwoAndThreeRoleResource(Long roleId,Long parentId);

}
