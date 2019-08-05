package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysPublisher;

/**
 * <p>
 * Description: 出版社daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public interface SysPublisherDaoJdbc {

	@Autowired
	public abstract void setDataSource(DataSource oracleSource);

	/**
	 * 查询出版社
	 * 
	 * @param code
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<SysPublisher> query(Long schoolId, String code, String name,
			Pageable pageable);
	/**
	 * 查询公共出版设
	 * @param code
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<SysPublisher> queryPublicPulisher(String code, String name,
			Pageable pageable);
	/**
	 * 查询公共出版社和私有的出版社
	 * @param schoolId
	 * @param code
	 * @param name
	 * @param pageable
	 * @return
	 */
	public Page<SysPublisher> queryPublicPulisherOrBySchoolId(Long schoolId, String code, String name,
			Pageable pageable);

}
