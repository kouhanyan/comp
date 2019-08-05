package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysRole;

/**
 * <p>
 * Description: 系统角色daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysRoleDaoJdbc {
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	
	/**
	 * 查询系统角色
	 * @param name
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<SysRole> query(String name,String schoolName,Pageable pageable);
	
	/**
	 * 查询系统角色
	 * @param name
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<SysRole> queryBySchoolId(String name,Long schoolId,Pageable pageable);
}
