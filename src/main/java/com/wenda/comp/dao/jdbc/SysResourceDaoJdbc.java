package com.wenda.comp.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.SysResource;

/**
 * <p>
 * Description: ϵͳ��Դdaojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
public interface SysResourceDaoJdbc {
	
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	
	/**
	 * ��ѯϵͳ��Դ
	 * @param name
	 * @param url
	 * @param parentName
	 * @param level
	 * @param pageable
	 * @return
	 */
	public Page<SysResource> query(String name, String url, String parentName,
			Integer level, Pageable pageable);
	
	/**
	 * ��ȡ������ʾ��Դ
	 * @param deskResourceNames
	 * @param roleId
	 * @return
	 */
	public List<SysResource> findDeskResources(List<String> deskResourceNames,Long roleId);
}
