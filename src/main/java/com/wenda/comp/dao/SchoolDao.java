package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.School;

/**
 * <p>
 * Description: ѧУdao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SchoolDao extends JpaRepository<School, Long>{

	/**
	 * ����ѧУ�������
	 * @param code
	 * @return
	 */
	@Query("select t from School t where t.schoolCode=?1")
	public School findByCode(String code);
	
	/**
	 * ����ѧУ����ģ����ѯ
	 * @param name
	 * @return
	 */
	@Query("select t from School t where t.schoolName like ?1")
	public List<School> findByName(String name);
	
	/**
	 * ���������ѯ
	 * @param regionId
	 * @return
	 */
	@Query("select t from School t where t.sysRegion.id=?1")
	public List<School> findByRegionId(Long regionId);
}
