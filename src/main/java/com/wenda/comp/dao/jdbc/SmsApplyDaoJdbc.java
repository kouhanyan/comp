package com.wenda.comp.dao.jdbc;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wenda.comp.enumModel.SmsApplyStateEnum;
import com.wenda.comp.model.SmsApply;

/**
 * <p>
 * Description: ��������daojdbc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-18
 */
public interface SmsApplyDaoJdbc {
	
	@Autowired
	public abstract void setDataSource(DataSource oracleSource);
	/**
	 * 
	 * ��ҳ��ѯ
	 * @param schoolId
	 * @param appleDate
	 * @param pageable
	 * @return
	 */
	public Page<SmsApply> query(Long schoolId,Date appleStartDate,Date appleEndDate,
			Pageable pageable);
	
	public Page<SmsApply> query(String name,Date appleStartDate,Date appleEndDate,SmsApplyStateEnum applyState,Pageable pageable);
}
