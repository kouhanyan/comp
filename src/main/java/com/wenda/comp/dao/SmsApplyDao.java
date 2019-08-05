package com.wenda.comp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SmsApply;

/**
 * <p>
 * Description:∂Ã–≈…Í«Îdao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */

@Repository
public interface SmsApplyDao extends JpaRepository<SmsApply, Long> {

	@Query("select s from SmsApply s where s.schoolId=?1")
	Page<SmsApply> findBySchool(Long schoolId, Pageable pageable);

}
