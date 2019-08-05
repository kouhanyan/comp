package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysAnnouncement;

/**
 * <p>
 * Description: 系统公告dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public interface SysAnnouncementDao extends JpaRepository<SysAnnouncement, Long>{
	
	@Query("select s from SysAnnouncement s where s.isDisplay = ?1")
	public List<SysAnnouncement> getByIsDisplay(Boolean isDisplay);
	
}
