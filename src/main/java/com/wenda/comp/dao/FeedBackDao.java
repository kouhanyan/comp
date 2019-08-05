package com.wenda.comp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.FeedBack;

/**
 * <p>
 * Description: 反馈dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface FeedBackDao extends JpaRepository<FeedBack, Long>{

	/**
	 * 通过学校Id查找
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from FeedBack t where t.schoolId=?1")
	public Page<FeedBack> findBySchoolId(Long schoolId,Pageable pageable);
}
