package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysDic;
/**
 * <p>
 * Description: �����ֵ�dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public interface SysDicDao extends JpaRepository<SysDic, Long>{

	/**
	 * �����������ͺ����ݼ�ֵ��ѯ�����ֵ�
	 * @param dicType
	 * @param dicKey
	 * @return
	 */
	@Query("select t from SysDic t where t.dicType=?1 and t.dicKey=?2")
	public SysDic findByTypeAndKey(Integer dicType,Integer dicKey);
	
	/**
	 * �����������ͺ����ݼ�ֵ��ѯ�����ֵ�
	 * @param dicType
	 * @param dicKey
	 * @return
	 */
	@Query("select t from SysDic t where t.dicType=?1 and t.dicKey<?2")
	public List<SysDic> findByTypeAndNotEqualKey(Integer dicType,Integer dicKey);
	
	/**
	 * �����������Ͳ�ѯ�����ֵ�List
	 * 
	 * @param dicType
	 * @return
	 */
	@Query("select t from SysDic t where t.dicType=?1")
	public List<SysDic> findByType(Integer dicType);
	
	/**
	 * ���������ֵ�
	 * @param schoolId
	 * @param dicType
	 * @param dicValue
	 * @return
	 */
	@Query("select t from SysDic t where  t.dicType = ?1 and t.dicValue = ?2")
	public SysDic findBySchoolIdAndTypeAndValue(Integer dicType,String dicValue);
}
