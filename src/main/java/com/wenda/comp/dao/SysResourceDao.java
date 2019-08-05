package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysResource;

/**
 * <p>
 * Description: 系统资源dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SysResourceDao extends JpaRepository<SysResource, Long> {

	/**
	 * 查找该资源的子资源
	 * 
	 * @param id
	 * @return
	 */
	@Query("select t from SysResource t where t.parentId=?1")
	public List<SysResource> findChildren(Long parentId);

	/**
	 * 通过资源等级查找父资源
	 * 
	 * @param level
	 * @return
	 */
	@Query("select t from SysResource t where t.resourceLevel=?1")
	public List<SysResource> findByLevel(Integer level);

	/**
	 * 查询非子节点系统资源
	 * @return
	 */
	@Query("select t from SysResource t where t.resourceLevel<(select max(resourceLevel) from SysResource)")
	public List<SysResource> findParents();
	
	/**
	 * 通过父系统资源名查找
	 * @param parentName
	 * @return
	 */
	@Query("select t from SysResource t where t.parentId in(select id from SysResource where name like?1)")
	public List<SysResource> findByParentName(String parentName);
	
	/**
	 * 通过子资源的父id查找父资源
	 * @param parentId
	 * @return
	 */
	@Query("select t from SysResource t where t.id=?1")
	public SysResource findParentResource(Long parentId);
	
	/**
	 * 通过资源名和等级查找
	 * @param name
	 * @param level
	 * @return
	 */
	@Query("select t from SysResource t where t.name=?1 and t.resourceLevel=?2")
	public SysResource findByNameAndLevel(String name,Integer level);
	
	/**
	 * 
	 * @Title: listByName
	 * @Description: 通过名称获取id
	 * @param name
	 * @return
	 * @return: List<Long>
	 */
	@Query("select t from SysResource t where t.name in ?1")
	public List<SysResource> listByName(List<String> name);
}
