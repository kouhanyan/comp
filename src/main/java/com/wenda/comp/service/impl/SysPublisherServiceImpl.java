package com.wenda.comp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.SysPublisherDao;
import com.wenda.comp.form.SysPublisherQueryForm;
import com.wenda.comp.model.SysPublisher;
import com.wenda.comp.service.SysPublisherService;

/**
 * <p>
 * Description: 出版社Serviceimpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
@Service
public class SysPublisherServiceImpl implements SysPublisherService {

	@Autowired
	private SysPublisherDao sysPublisherDao;

	@Transactional
	public void saveOrEdit(SysPublisher sysPublisher) {
		sysPublisherDao.save(sysPublisher);
	}

	public Page<SysPublisher> findPublicSysPublisher(
			SysPublisherQueryForm sysPublisherQueryForm) {
		return sysPublisherDao.findPublicSysPublisher(sysPublisherQueryForm);
	}

	public Page<SysPublisher> findPublicOrBySchoolId(Long schoolId,
			SysPublisherQueryForm sysPublisherQueryForm) {
		return sysPublisherDao.findPublicOrBySchoolId(schoolId,
				sysPublisherQueryForm);
	}

	@Transactional
	public SysPublisher validationSaveAble(String code, Long schoolId) {
		SysPublisher publicSysPublisher = sysPublisherDao
				.findPublicOrByCode(code);
		SysPublisher schoolSysPublisher = sysPublisherDao
				.findByCodeAndSchoolId(code, schoolId);
		return publicSysPublisher == null ? schoolSysPublisher == null ? null
				: schoolSysPublisher : publicSysPublisher;
	}

	/**
	 * 通过代码查找出版社
	 * @param code
	 * @return
	 */
	public SysPublisher findByCode(String code){	
		return sysPublisherDao.findByCode(code);
	}
}
