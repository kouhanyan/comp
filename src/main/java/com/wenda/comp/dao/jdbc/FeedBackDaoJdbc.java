package com.wenda.comp.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.FeedBack;

/**
 * <p>
 * Description: 反馈daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public interface FeedBackDaoJdbc {
	
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	/**
	 * 反馈信息查询
	 * @param userName
	 * @param schoolName
	 * @param isDeal
	 * @param pageable
	 * @return
	 */
	public Page<FeedBack> query(Long schoolId,Integer schoolType,String userName,String schoolName,Integer isDeal,Pageable pageable);
}
