package com.wenda.comp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.SysAnnouncementDao;
import com.wenda.comp.dao.jdbc.SysAnnouncementDaoJdbc;
import com.wenda.comp.dao.jdbc.SysVersionDaoJdbc;
import com.wenda.comp.form.SysAnnouncementQueryForm;
import com.wenda.comp.model.SysAnnouncement;
import com.wenda.comp.model.SysVersion;
import com.wenda.comp.service.SysAnnouncementService;
import com.wenda.comp.service.SysVersionService;

/**
 * <p>
 * Description: Í¨¸æseviceImpl
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
@Service
public class SysAnnouncementServiceImpl implements SysAnnouncementService {

	@Autowired
	private SysAnnouncementDao sysAnnouncementDao;

	@Autowired
	private SysAnnouncementDaoJdbc sysAnnouncementDaoJdbc;

	public Page<SysAnnouncement> find(String title, String sender,
			SysAnnouncementQueryForm sysAnnouncementQueryForm) {
		sysAnnouncementQueryForm.setProperties("send_date");
		sysAnnouncementQueryForm.setDirection(Direction.DESC);
		return sysAnnouncementDaoJdbc.query(title, sender,
				sysAnnouncementQueryForm);
	}

	@Transactional
	public void saveOrEdit(SysAnnouncement sysAnnouncement) {
		sysAnnouncementDao.save(sysAnnouncement);

	}

	public SysAnnouncement findOne(Long id) {
		return sysAnnouncementDao.findOne(id);
	}

	public void delete(Long id) {
		sysAnnouncementDao.delete(id);

	}

	@Transactional
	public void setWorkState(Long id) {
		List<SysAnnouncement> sysAnnouncements = sysAnnouncementDao
				.getByIsDisplay(true);
		if (sysAnnouncements != null && sysAnnouncements.size() > 0 && sysAnnouncements.get(0) != null) {
			SysAnnouncement sysAnnouncement = sysAnnouncements.get(0);
			sysAnnouncement.setIsDisplay(false);
			sysAnnouncementDao.save(sysAnnouncement);
		}
		SysAnnouncement sysAnnouncementDisplay = sysAnnouncementDao.findOne(id);
		sysAnnouncementDisplay.setIsDisplay(true);
		sysAnnouncementDao.save(sysAnnouncementDisplay);

	}

	public List<SysAnnouncement> getByIsDisplay(Boolean isDisplay) {
		return sysAnnouncementDao.getByIsDisplay(true);
	}

}
