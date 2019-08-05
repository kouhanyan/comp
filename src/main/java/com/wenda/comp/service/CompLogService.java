package com.wenda.comp.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.model.CompLog;

public interface CompLogService {

	/**
	 * 新增后台日志
	 * @param userName
	 * @param ip
	 * @param createDate
	 */
	public void addCompLog(String userName,String ip,Date createDate);
	
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
