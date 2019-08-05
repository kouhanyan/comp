package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysVersion;

/**
 * <p>
 * Description: °æ±¾dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
@Repository
public interface SysVersionDao  extends JpaRepository<SysVersion, Long>{
	
	@Query("select s from SysVersion s where s.isCurrentVersion = ?1")
	public List<SysVersion> getByIsCV(Boolean isCurrentVersion);
	

}
