package com.wenda.comp.dao.jdbc;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.CompLog;

/**
 * <p>
 * Description: ϵͳ��־daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public interface CompLogDaoJdbc {

	/**
	 * ��ѯϵͳ��̨��־
	 * @param userName
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	public Page<CompLog> query(String userName,Date startDate,Date endDate,Pageable pageable);
}
