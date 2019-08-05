package com.wenda.comp.service;

import java.util.List;

import com.wenda.comp.model.SysResource;

/**
 * <p>
 * Description: ϵͳ��Դservice
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysResourceService {

	/**
	 * ͨ����ɫid��Դ�ȼ��Լ���id����
	 * 
	 * @param roleId
	 * @param level
	 * @param parentId
	 * @return
	 */
	public List<SysResource> findByRoleIdAndLevelAndParentId(Long roleId,
			Integer level, Long parentId);
	
	/**
	 * ͨ����id���Ҹ���Դ
	 * 
	 * @param parentId
	 * @return
	 */
	public SysResource findParentResource(Long parentId);
	
	/**
	 * ͨ��id������Դ
	 * @param id
	 * @return
	 */
	public SysResource findById(Long id);
	
	/**
	 * ��ȡ������ʾ��Դ
	 * @param deskResourceNames
	 * @param roleId
	 * @return
	 */
	public List<SysResource> findDeskResources(List<String> deskResourceNames,Long roleId);
	
	/**
	 * ͨ����Դ���͵ȼ�����
	 * @param name
	 * @param level
	 * @return
	 */
	public SysResource findByNameAndLevel(String name,Integer level);
}
