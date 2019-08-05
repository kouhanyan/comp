package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysRegion;

/**
 * <p>
 * Description: ��������dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SysRegionDao extends JpaRepository<SysRegion, Long> {

	/**
	 * ͨ�������ѯ��������
	 * 
	 * @param code
	 * @return
	 */
	@Query("select t from SysRegion t where t.code like?1")
	public SysRegion findByCode(String code);
	
	@Query("select t from SysRegion t where t.code like?1")
	public List<SysRegion> getLikeByCode(String code);
	
	/**
	 * ͨ����β���
	 * @param regionLevel
	 * @return
	 */
	@Query("select t from SysRegion t where t.regionLevel=?1")
	public List<SysRegion> findByLevel(Integer regionLevel);
	
	/**
	 * ���ҷǸ��ڵ���������
	 * @return
	 */
	@Query("select t from SysRegion t where t.regionLevel>1")
	public List<SysRegion> findNotRoots();
	
	/**
	 * ͨ��id�����Ը�����Ϊ������������
	 * @param id
	 * @return
	 */
	@Query("select t from SysRegion t where t.parentId=?1")
	public List<SysRegion> findChildren(Long id);

	/**
	 * ͨ���ϼ�������������
	 * @param parentName
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysRegion t where t.name like?1")
	public List<SysRegion> findByParentName(String parentName);
	
	/**
	 * ��ѯ���ӽڵ���������
	 * @return
	 */
	@Query("select t from SysRegion t where t.regionLevel<(select max(regionLevel) from SysRegion)")
	public List<SysRegion> findParents();
}
