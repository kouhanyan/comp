package com.wenda.comp.service;

import com.wenda.comp.model.SysRole;

/**
 * <p>
 * Description: 系统角色service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysRoleService {

	/**
	 * 通过Id获取角色
	 * @param id
	 * @return
	 */
	public SysRole findRoleById(Long id);
}
