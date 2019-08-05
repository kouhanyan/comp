package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysRole;

/**
 * <p>
 * Description: ϵͳ��ɫdaojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysRoleDaoJdbc {
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	
	/**
	 * ��ѯϵͳ��ɫ
	 * @param name
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<SysRole> query(String name,String schoolName,Pageable pageable);
	
	/**
	 * ��ѯϵͳ��ɫ
	 * @param name
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	public Page<SysRole> queryBySchoolId(String name,Long schoolId,Pageable pageable);
}
