package com.wenda.comp.service;

import com.wenda.comp.model.SysRole;

/**
 * <p>
 * Description: ϵͳ��ɫservice
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysRoleService {

	/**
	 * ͨ��Id��ȡ��ɫ
	 * @param id
	 * @return
	 */
	public SysRole findRoleById(Long id);
}
