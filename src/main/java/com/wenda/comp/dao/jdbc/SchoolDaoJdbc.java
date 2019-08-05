package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.School;

/**
 * <p>
 * Description: 学校daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-22
 */
public interface SchoolDaoJdbc {
    
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	
	/**
	 * 查询学校
	 * @param code
	 * @param simpleName
	 * @param name
	 * @param type
	 * @param pageable
	 * @return
	 */
	public Page<School> query(String code, String simpleName, String name,
			Integer type, Pageable pageable);
}
