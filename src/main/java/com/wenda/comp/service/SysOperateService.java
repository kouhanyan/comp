package com.wenda.comp.service;

import java.util.List;

import com.wenda.comp.model.SysOperate;

/**
 * <p>
 * Description: ��Դ����service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2015-03-03
 */
public interface SysOperateService{

	/**
	 * ��Դ������Ȩ��
	 * @param roleId
	 * @param level
	 * @param resourceNames
	 * @return
	 */
	public List<SysOperate> findAuthorityOperate(Long roleId, Integer level,
			List<String> resourceNames);
	
	/**
	 * ������Դ���Ͳ��������Ҷ�Ӧ����
	 * @param name
	 * @param resourceName
	 * @return
	 */
	public SysOperate findByNameAndResourceName(String name,String resourceName);
	
	/**
	 * ɾ�����ƵĲ���Ȩ��
	 * @param list
	 */
	public void deleteLimitOperation(List<SysOperate> list);
}
