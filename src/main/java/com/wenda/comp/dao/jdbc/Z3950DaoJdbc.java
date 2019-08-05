package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.Z3950;

/**
 * <p>
 * Description: z3950daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface Z3950DaoJdbc {
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	
	/**
	 * 查询某个学校Z3950
	 * @param name
	 * @param server
	 * @param database
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<Z3950> query(Integer type, String name, String server, String database, Long schoolId,
			Pageable pageable);
}
