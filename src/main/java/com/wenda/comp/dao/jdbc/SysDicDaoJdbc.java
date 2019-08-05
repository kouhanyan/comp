package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysDic;

/**
 * <p>
 * Description: 数据字典daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public interface SysDicDaoJdbc {
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	/**
	 * 查询数据字典
	 * @param dicType
	 * @param dicKey
	 * @param dicValue
	 * @param pageable
	 * @return
	 */
	public Page<SysDic> query(Integer dicType, Integer dicKey, String dicValue,
			Pageable pageable);
}
