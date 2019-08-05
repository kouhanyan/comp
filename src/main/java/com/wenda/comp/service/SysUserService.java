package com.wenda.comp.service;

import com.wenda.comp.model.SysUser;

/**
 * <p>
 * Description: 系统用户service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysUserService {
	/**
	 * 用户密码修改
	 * @param sysUser
	 */
	public void editPassward(SysUser sysUser);
	
	/**
	 * 查找当前用户
	 * @param userName
	 * @return
	 */
	public SysUser findByUserName(String userName);
	
}
