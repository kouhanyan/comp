package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.Z3950;
/**
 * <p>
 * Description: Z3950dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface Z3950Dao extends JpaRepository<Z3950, Long>{

	/**
	 * 通过学校查找z3950
	 * @param schoolId
	 * @return
	 */
	@Query("select t from Z3950 t where t.schoolId=?1 or t.schoolId is null")
	public List<Z3950> findBySchool(Long schoolId);
	
	/**
	 * 通过学校Id查找
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from Z3950 t where t.schoolId=?1")
	public Page<Z3950> findBySchoolId(Long schoolId,Pageable pageable);
	
	/**
	 * 查找公司下的Z3950
	 * @return
	 */
	@Query("select t from Z3950 t where t.schoolId is null")
	public Page<Z3950> findNoSchool(Pageable pageable);
	
	/**
	 * 通过学校id和用户id查找
	 * @param schoolId
	 * @param sysUserId
	 * @return
	 */
	@Query("select t from Z3950 t where t.schoolId=?1 and t.sysUser.id=?2")
	public Z3950 findBySchoolIdAndUserId(Long schoolId,Long sysUserId);
}
