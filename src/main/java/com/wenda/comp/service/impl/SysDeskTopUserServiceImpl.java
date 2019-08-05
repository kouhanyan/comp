package com.wenda.comp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.SysDesktopUserDao;
import com.wenda.comp.model.SysDesktop;
import com.wenda.comp.model.SysDesktopUser;
import com.wenda.comp.model.SysUser;
import com.wenda.comp.service.SysDeskTopUserService;

/**
 * <p>
 * Description: �û�����serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service

public class SysDeskTopUserServiceImpl implements SysDeskTopUserService{

	@Autowired
	private SysDesktopUserDao sysDesktopUserDao;
	
	/**
	 * �����û�����ͼ��
	 * @param sysDesktop
	 * @param sysUser
	 */
	@Transactional
	public void saveDeskTopUser(SysDesktop sysDesktop,SysUser sysUser){	
		SysDesktopUser sdu=sysDesktopUserDao.findByDeskTopIdAndUserId(sysDesktop.getId(), sysUser.getId());
		if(sdu==null)	
		sdu=new SysDesktopUser();	
		sdu.setSysDesktop(sysDesktop);
		sdu.setSysUser(sysUser);
		sysDesktopUserDao.save(sdu);
	}
	
	/**
	 * ɾ���û�����ͼ��
	 * @param sysDesktopId
	 * @param sysUserId
	 */
	@Transactional
	public void deleteDeskTopUser(Long sysDesktopId,Long sysUserId){	
		SysDesktopUser sdu=sysDesktopUserDao.findByDeskTopIdAndUserId(sysDesktopId, sysUserId);
		if(sdu!=null)
			sysDesktopUserDao.delete(sdu);
	}
	
	/**
	 * ��ȡ�û��ѱ����׷��ͼ��
	 * @param sysUserId
	 * @return
	 */
	public List<SysDesktopUser> findByUserId(Long sysUserId){	
		return sysDesktopUserDao.findByUserId(sysUserId);
	}
}
