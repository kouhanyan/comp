package com.wenda.comp.service;
import java.util.List;

import com.wenda.comp.model.SysDesktop;
import com.wenda.comp.model.SysDesktopUser;
import com.wenda.comp.model.SysUser;

/**
 * <p>
 * Description: �û�����service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysDeskTopUserService {
	/**
	 * �����û�����ͼ��
	 * @param sysDesktop
	 * @param sysUser
	 */
	public void saveDeskTopUser(SysDesktop sysDesktop,SysUser sysUser);
	
	/**
	 * ɾ���û�����ͼ��
	 * @param sysDesktopId
	 * @param sysUserId
	 */
	public void deleteDeskTopUser(Long sysDesktopId,Long sysUserId);
	
	/**
	 * ��ȡ�û��ѱ����׷��ͼ��
	 * @param sysUserId
	 * @return
	 */
	public List<SysDesktopUser> findByUserId(Long sysUserId);
}
