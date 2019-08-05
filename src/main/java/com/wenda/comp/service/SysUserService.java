package com.wenda.comp.service;

import com.wenda.comp.model.SysUser;

/**
 * <p>
 * Description: ϵͳ�û�service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysUserService {
	/**
	 * �û������޸�
	 * @param sysUser
	 */
	public void editPassward(SysUser sysUser);
	
	/**
	 * ���ҵ�ǰ�û�
	 * @param userName
	 * @return
	 */
	public SysUser findByUserName(String userName);
	
}
