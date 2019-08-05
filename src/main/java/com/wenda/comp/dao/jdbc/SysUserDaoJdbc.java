package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysUser;

/**
 * <p>
 * Description: 系统用户daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysUserDaoJdbc {
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	/**
	 * 查询系统用户
	 * @param name
	 * @param userName
	 * @param schoolName
	 * @param pageable
	 * @return
	 */
	public Page<SysUser> query(String name,String userName,String schoolName,Pageable pageable);
}
