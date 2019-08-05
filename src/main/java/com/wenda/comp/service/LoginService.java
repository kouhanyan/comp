package com.wenda.comp.service;

import com.wenda.comp.model.SysRole;

/**
 * <p>
 * Description: 登录验证service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface LoginService {
	/**
	 * 登录验证
	 * 
	 * @param userName
	 * @param rawPass
	 * @return
	 */
	public boolean isLoginSuccess(String userName, String rawPass,
			Integer schoolType);
	
	/**
	 * 获取登录的组织类型
	 * @param userName
	 * @return
	 */
	public Integer getOrgnizeType(String userName);
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public SysRole getSysRoleId(String userName);
}
