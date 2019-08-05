package com.wenda.comp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysPublisher;

/**
 * <p>
 * Description: ������dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public interface SysPublisherDao extends JpaRepository<SysPublisher, Long>{
         
	/**
	 * ͨ��������ҳ�����
	 * @param code
	 * @return
	 */
	@Query("select t from SysPublisher t where t.code=?1")
	public SysPublisher findByCode(String code);
	
	/**
	 * ͨ������������ѧУid����
	 * @param code
	 * @param schoolId
	 * @return
	 */
	@Query("select t from SysPublisher t where t.code=?1 and t.school.id=?2")
	public SysPublisher findByCodeAndSchoolId(String code,Long schoolId);
	
	/**
	 * ͨ��ѧУ���ҳ�����
	 * @param schoolId
	 * @return
	 */
	@Query("select t from SysPublisher t where t.school.id=?1")
	public Page<SysPublisher> findSysPublisherBySchoolId(Long schoolId,Pageable pageable);
	/**
	 * ��ѯ����������
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysPublisher t where t.school.id is null")
	public Page<SysPublisher> findPublicSysPublisher(Pageable pageable);
	/**
	 * ��ѯ�����������ѧУ˽�еĳ�����
	 * @param schoolId
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysPublisher t where t.school.id  is null or t.school.id =?1")
	public Page<SysPublisher> findPublicOrBySchoolId(Long schoolId,Pageable pageable);
	/**
	 * ��ѯ�������������Ƿ����code
	 * @param code
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysPublisher t where t.code=?1 and t.school.id is null")
	public SysPublisher findPublicOrByCode(String code);
}
