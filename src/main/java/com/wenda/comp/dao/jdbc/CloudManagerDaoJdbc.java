package com.wenda.comp.dao.jdbc;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.CloudManager;

/**
 * <p>
 * Description: 云端维护daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public interface CloudManagerDaoJdbc {

	@Autowired
	public abstract void setDataSource(DataSource oracleSource);

	/**
	 * 云端维护列表查询
	 * 
	 * @param schoolId
	 * @param dealStatus
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	public Page<CloudManager> query(boolean isComp,Long schoolId, Integer dealStatus,
			Date startDate, Date endDate, Pageable pageable);
}
