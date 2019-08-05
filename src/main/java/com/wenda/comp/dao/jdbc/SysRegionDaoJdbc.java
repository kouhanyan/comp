package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysRegion;

/**
 * <p>
 * Description: 行政区划daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysRegionDaoJdbc {
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	/**
	 * 行政区划查询
	 * @param code
	 * @param name
	 * @param parentId
	 * @param pageable
	 * @return
	 */
	public Page<SysRegion> query(String code,String name,String parentName,Pageable pageable);
}
