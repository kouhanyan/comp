package com.wenda.comp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.SysVersionDao;
import com.wenda.comp.dao.jdbc.SysVersionDaoJdbc;
import com.wenda.comp.form.SysVersionQueryForm;
import com.wenda.comp.model.SysVersion;
import com.wenda.comp.service.SysVersionService;

/**
 * <p>
 * Description: °æ±¾seviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
@Service
public class SysVersionServiceImpl implements SysVersionService {

	@Autowired
	private SysVersionDaoJdbc sysVersionDaoJdbc;
	@Autowired
	private SysVersionDao sysVersionDao;

	public Page<SysVersion> find(String edition, String directory,
			SysVersionQueryForm sysVersionQueryForm) {
		sysVersionQueryForm.setProperties("create_date");
		sysVersionQueryForm.setDirection(Direction.DESC);
		return sysVersionDaoJdbc.query(edition, directory, sysVersionQueryForm);
	}

	@Transactional
	public void saveOrEdit(SysVersion sysVersion) {
		sysVersionDao.save(sysVersion);

	}

	public SysVersion findOne(Long id) {

		return sysVersionDao.findOne(id);
	}

	public void delete(Long id) {
		sysVersionDao.delete(id);

	}

	@Transactional
	public void setWorkState(Long id) {
		List<SysVersion> sysVersions = sysVersionDao.getByIsCV(true);
		if (sysVersions != null && sysVersions.size() > 0
				&& sysVersions.get(0) != null) {
			SysVersion sysVersion = sysVersions.get(0);
			sysVersion.setIsCurrentVersion(false);
			sysVersionDao.save(sysVersion);
		}
		SysVersion sysVersionWorking = sysVersionDao.findOne(id);
		sysVersionWorking.setIsCurrentVersion(true);
		sysVersionDao.save(sysVersionWorking);
	}

	public List<SysVersion> getByICV(Boolean isCurrentVersion) {
		return sysVersionDao.getByIsCV(true);
	}

}
