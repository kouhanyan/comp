package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysVersion;

/**
 * <p>
 * Description: ∞Ê±ædaojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysVersionDaoJdbc {
	
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	/**
	 * ∑÷“≥≤È—Ø
	 * @param pageabl
	 * @return
	 */
	public Page<SysVersion> query(String edition,String directory,Pageable pageabl);
}
