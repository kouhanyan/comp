package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysDesktopUser;
/**
 * <p>
 * Description: 用户桌面dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public interface SysDesktopUserDao extends JpaRepository<SysDesktopUser, Long>{

	/**
	 * 根据桌面图标id和用户id查找
	 * @param sysDesktopId
	 * @param sysUserId
	 * @return
	 */
	@Query("select t from SysDesktopUser t where t.sysDesktop.id=?1 and t.sysUser.id=?2")
	public SysDesktopUser findByDeskTopIdAndUserId(Long sysDesktopId,Long sysUserId);
	
	/**
	 * 根据用户id查找
	 * @param sysUserId
	 * @return
	 */
	@Query("select t from SysDesktopUser t where t.sysUser.id=?1")
	public List<SysDesktopUser> findByUserId(Long sysUserId);
}
