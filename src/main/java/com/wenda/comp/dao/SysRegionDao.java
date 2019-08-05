package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysRegion;

/**
 * <p>
 * Description: 行政区划dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SysRegionDao extends JpaRepository<SysRegion, Long> {

	/**
	 * 通过代码查询行政区划
	 * 
	 * @param code
	 * @return
	 */
	@Query("select t from SysRegion t where t.code like?1")
	public SysRegion findByCode(String code);
	
	@Query("select t from SysRegion t where t.code like?1")
	public List<SysRegion> getLikeByCode(String code);
	
	/**
	 * 通过层次查找
	 * @param regionLevel
	 * @return
	 */
	@Query("select t from SysRegion t where t.regionLevel=?1")
	public List<SysRegion> findByLevel(Integer regionLevel);
	
	/**
	 * 查找非根节点行政区划
	 * @return
	 */
	@Query("select t from SysRegion t where t.regionLevel>1")
	public List<SysRegion> findNotRoots();
	
	/**
	 * 通过id查找以该区划为父区划的区划
	 * @param id
	 * @return
	 */
	@Query("select t from SysRegion t where t.parentId=?1")
	public List<SysRegion> findChildren(Long id);

	/**
	 * 通过上级行政区划查找
	 * @param parentName
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysRegion t where t.name like?1")
	public List<SysRegion> findByParentName(String parentName);
	
	/**
	 * 查询非子节点行政区划
	 * @return
	 */
	@Query("select t from SysRegion t where t.regionLevel<(select max(regionLevel) from SysRegion)")
	public List<SysRegion> findParents();
}
