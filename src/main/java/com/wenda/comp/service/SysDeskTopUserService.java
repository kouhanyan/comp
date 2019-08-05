package com.wenda.comp.service;
import java.util.List;

import com.wenda.comp.model.SysDesktop;
import com.wenda.comp.model.SysDesktopUser;
import com.wenda.comp.model.SysUser;

/**
 * <p>
 * Description: 用户桌面service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysDeskTopUserService {
	/**
	 * 保存用户桌面图标
	 * @param sysDesktop
	 * @param sysUser
	 */
	public void saveDeskTopUser(SysDesktop sysDesktop,SysUser sysUser);
	
	/**
	 * 删除用户桌面图标
	 * @param sysDesktopId
	 * @param sysUserId
	 */
	public void deleteDeskTopUser(Long sysDesktopId,Long sysUserId);
	
	/**
	 * 获取用户已保存的追加图标
	 * @param sysUserId
	 * @return
	 */
	public List<SysDesktopUser> findByUserId(Long sysUserId);
}
