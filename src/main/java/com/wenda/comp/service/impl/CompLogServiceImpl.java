package com.wenda.comp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.CompLogDao;
import com.wenda.comp.dao.jdbc.CompLogDaoJdbc;
import com.wenda.comp.model.CompLog;
import com.wenda.comp.service.CompLogService;

/**
 * <p>
 * Description: 系统后台日志serviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Service
public class CompLogServiceImpl implements CompLogService{

	@Autowired
	private CompLogDao compLogDao;
	
	@Autowired
	private CompLogDaoJdbc complogDaoJdbc;
	
	/**
	 * 新增后台日志
	 * @param userName
	 * @param ip
	 * @param createDate
	 */
	@Transactional
	public void addCompLog(String userName,String ip,Date createDate){	
		CompLog compLog=new CompLog();
		compLog.setUserName(userName);
		compLog.setIp(ip);
		compLog.setCreateDate(createDate);
		compLogDao.save(compLog);
	}
	
	/**
	 * 查询系统后台日志
	 * @param userName
	 * @param startDate
	 * @param endDate
	 * @param pageable
	 * @return
	 */
	public Page<CompLog> query(String userName,Date startDate,Date endDate,Pageable pageable){	
		return complogDaoJdbc.query(userName, startDate, endDate, pageable);
	}
}
