package com.wenda.comp.dao.jdbc;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.CompLog;

/**
 * <p>
 * Description: 系统日志daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public interface CompLogDaoJdbc {

	/**
	 * 查询系统后台日志
	 * @param userName
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	public Page<CompLog> query(String userName,Date startDate,Date endDate,Pageable pageable);
}
