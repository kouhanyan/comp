package com.wenda.comp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysPublisher;

/**
 * <p>
 * Description: 出版社dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public interface SysPublisherDao extends JpaRepository<SysPublisher, Long>{
         
	/**
	 * 通过代码查找出版社
	 * @param code
	 * @return
	 */
	@Query("select t from SysPublisher t where t.code=?1")
	public SysPublisher findByCode(String code);
	
	/**
	 * 通过出版社代码和学校id查找
	 * @param code
	 * @param schoolId
	 * @return
	 */
	@Query("select t from SysPublisher t where t.code=?1 and t.school.id=?2")
	public SysPublisher findByCodeAndSchoolId(String code,Long schoolId);
	
	/**
	 * 通过学校查找出版社
	 * @param schoolId
	 * @return
	 */
	@Query("select t from SysPublisher t where t.school.id=?1")
	public Page<SysPublisher> findSysPublisherBySchoolId(Long schoolId,Pageable pageable);
	/**
	 * 查询公共出版社
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysPublisher t where t.school.id is null")
	public Page<SysPublisher> findPublicSysPublisher(Pageable pageable);
	/**
	 * 查询公共出版社和学校私有的出版社
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysPublisher t where t.school.id  is null or t.school.id =?1")
	public Page<SysPublisher> findPublicOrBySchoolId(Long schoolId,Pageable pageable);
	/**
	 * 查询公共出版社中是否存在code
	 * @param code
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysPublisher t where t.code=?1 and t.school.id is null")
	public SysPublisher findPublicOrByCode(String code);
}
