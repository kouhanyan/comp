package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysRoleResource;

/**
 * <p>
 * Description: 系统角色资源关系dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SysRoleResourceDao extends JpaRepository<SysRoleResource, Long>{

	/**
	 * 通过系统角色id查找
	 * @param sysRoleId
	 * @return
	 */
	@Query("select t from SysRoleResource t where t.sysRole.id=?1 order by t.sysResource.sort")
	public List<SysRoleResource> findByRoleId(Long sysRoleId);
	
	/**
	 * 通过角色id和资源等级查找
	 * @param sysRoleId
	 * @param level
	 * @return
	 */
	@Query("select t from SysRoleResource t where t.sysRole.id=?1 and t.sysResource.resourceLevel=?2 order by t.sysResource.sort")
	public List<SysRoleResource> findByRoleId(Long sysRoleId,Integer level); 
	
	/**
	 * 通过系统资源id查找
	 * @param sysRoleId
	 * @return
	 */
	@Query("select t from SysRoleResource t where t.sysResource.id=?1 order by t.sysResource.sort")
	public List<SysRoleResource> findByResourceId(Long sysResourceId);
	
	/**
	 * 通过角色Id和资源id查找
	 * @param roleId
	 * @param resourceId
	 * @return
	 */
	@Query("select t from SysRoleResource t where t.sysRole.id=?1 and t.sysResource.id=?2 order by t.sysResource.sort")
	public SysRoleResource findByRoleIdAndResourceId(Long roleId,Long resourceId);
	
	/**
	 * 根据角色id资源等级以及父资源id查找
	 * @param roleId
	 * @param level
	 * @param parentId
	 * @return
	 */
	@Query("select t from SysRoleResource t where t.sysRole.id=?1 and t.sysResource.resourceLevel=?2 and t.sysResource.parentId=?3 order by t.sysResource.sort")
	public List<SysRoleResource> findByRoleIdAndLevelAndParentId(Long roleId,Integer level,Long parentId);
	
	/**
	 * 查找桌面三级资源
	 * @param roleId
	 * @param level
	 * @param nameList
	 * @return
	 */
	@Query("select t from SysRoleResource t where t.sysRole.id=?1 and t.sysResource.resourceLevel=?2 and t.sysResource.name in (?3) order by t.sysResource.sort")
	public List<SysRoleResource> findByRoleIdAndResourceNameAndLevel(Long roleId,Integer level,List<String> nameList);
	
}
