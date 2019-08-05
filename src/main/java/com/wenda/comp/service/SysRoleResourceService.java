package com.wenda.comp.service;

import java.util.List;
import java.util.Map;
import com.wenda.comp.model.SysRole;
import com.wenda.comp.model.SysRoleResource;

/**
 * <p>
 * Description: ϵͳ��ɫ��Դ��ϵservice
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysRoleResourceService {
	/**
	 *ϵͳ��ɫ��Ȩ�� 
	 * @param sysRole
	 * @param sysResources
	 */
	public void endueAuthority(SysRole sysRole,Long[] checks);
	
	/**
	 * ��ȡ������Դ
	 * @param roleId
	 * @param level
	 * @param nameList
	 * @return
	 */
	public List<SysRoleResource> getDeskRoleResource(Long roleId,Integer level,List<String> nameList);
	
	/**
	 * ��ȡ��Ӧ��ɫ��һ����Դ
	 * @param roleId
	 * @return
	 */
	public List<SysRoleResource> getOneRoleResource(Long roleId);
	
	/**
	 * ��ȡ�Ѿ�����Ȩ�޵Ķ�����������Դ
	 * @param roleId
	 * @param parentId
	 * @return
	 */
	public Map<String,List<SysRoleResource>> getTwoAndThreeRoleResource(Long roleId,Long parentId);

}
