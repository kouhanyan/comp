package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysRole;

/**
 * <p>
 * Description: 系统角色dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SysRoleDao extends JpaRepository<SysRole, Long>{
	
	/**
	 * 通过学校Id查找
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysRole t where t.school.id=?1")
	public Page<SysRole> findBySchoolId(Long schoolId,Pageable pageable);
	
	/**
	 * 通过学校Id查找List
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysRole t where t.school.id=?1")
	public List<SysRole> findBySchoolId(Long schoolId);
	
	/**
	 * 通过学校Id和Name查找SysRole
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysRole t where t.school.id=?1 and t.name=?2")
	public SysRole findBySchoolIdAndName(Long schoolId,String name);
	
	/**
	 * 角色名相同去重
	 * @param name
	 * @return
	 */
	@Query("select t from SysRole t where t.name=?1")
	public SysRole findByRoleName(String name);
	
}
