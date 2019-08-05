package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysUser;

/**
 * <p>
 * Description: 系统用户dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SysUserDao extends JpaRepository<SysUser, Long>{

	@Query("select t from SysUser t where t.userName=?1")
	public SysUser findByUserName(String userName); 
	
	@Query("select t from SysUser t where t.school.id=?1")
	public List<SysUser> findBySchoolId(Long schoolId);
	
	/**
	 * 通过学校Id查找
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysUser t where t.school.id=?1")
	public Page<SysUser> findBySchoolId(Long schoolId,Pageable pageable);
	
	@Query("select t from SysUser t where t.school.id=?1")
	public List<SysUser> getListBySchoolId(Long schoolId);
}
