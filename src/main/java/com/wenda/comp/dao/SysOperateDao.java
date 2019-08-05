package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysOperate;

/**
 * <p>
 * Description: 资源操作dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2015-03-13
 */

@Repository
public interface SysOperateDao extends JpaRepository<SysOperate, Long>{

	/**
	 * 根据指定的资源名称查找对应操作
	 * @param resourceNames
	 * @return
	 */
	@Query("select t from SysOperate t where t.resourceName in (?1)")
	public List<SysOperate> findByResourceName(List<String> resourceNames);
	
	/**
	 * 根据资源名和操作名查找对应操作
	 * @param name
	 * @param resourceName
	 * @return
	 */
	@Query("select t from SysOperate t where t.name=?1 and t.resourceName=?2")
	public SysOperate findByNameAndResourceName(String name,String resourceName);
}
