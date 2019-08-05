package com.wenda.comp.service;

import java.util.List;

import com.wenda.comp.model.SysDesktop;

/**
 * <p>
 * Description: ϵͳ����service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysDeskTopService {
	/**
	 * ��������ϵͳ����
	 * @return
	 */
	public List<SysDesktop> findAllDeskTop();
	
	/**
	 * ����һ��ϵͳ����
	 * @param id
	 * @return
	 */
	public SysDesktop findOne(Long id);
}
