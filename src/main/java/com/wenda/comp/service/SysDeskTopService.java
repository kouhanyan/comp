package com.wenda.comp.service;

import java.util.List;

import com.wenda.comp.model.SysDesktop;

/**
 * <p>
 * Description: 系统桌面service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysDeskTopService {
	/**
	 * 查找所有系统桌面
	 * @return
	 */
	public List<SysDesktop> findAllDeskTop();
	
	/**
	 * 查找一个系统桌面
	 * @param id
	 * @return
	 */
	public SysDesktop findOne(Long id);
}
