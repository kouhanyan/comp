package com.wenda.comp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SmsRechargeRecode;

/**
 * <p>
 * Description: 短信充值记录dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */

@Repository
public interface SmsRechargeRecodeDao extends
		JpaRepository<SmsRechargeRecode, Long> {
	/**
	 * 查询
	 * 
	 * @param schoolId
	 * @param 
	 * @return
	 */
	@Query("select s from SmsRechargeRecode s where s.schoolId=?1")
	Page<SmsRechargeRecode> findBySchoolId(Long schoolId, Pageable pageable);
}
