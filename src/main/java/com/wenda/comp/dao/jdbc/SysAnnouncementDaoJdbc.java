package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysAnnouncement;

/**
 * <p>
 * Description: 通告daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysAnnouncementDaoJdbc {
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	/**
	 * 分页查询
	 * @param pageabl
	 * @return
	 */
	public Page<SysAnnouncement> query(String title,String sender,Pageable pageabl);
}
