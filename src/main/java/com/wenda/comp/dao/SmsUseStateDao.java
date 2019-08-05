package com.wenda.comp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SmsUseState;

/**
 * <p>
 * Description: 短信使用状态dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */

@Repository
public interface SmsUseStateDao extends JpaRepository<SmsUseState, Long>{
	
	/**
	 * 根据桌面图标id和用户id查找
	 * @param sysDesktopId
	 * @param sysUserId
	 * @return
	 */
	@Query("select sus from SmsUseState sus where sus.schoolId = ?1")
	public SmsUseState get(Long schoolId);

}
