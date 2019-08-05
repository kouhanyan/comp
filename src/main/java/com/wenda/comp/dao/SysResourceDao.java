package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysResource;

/**
 * <p>
 * Description: ϵͳ��Դdao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Repository

public interface SysResourceDao extends JpaRepository<SysResource, Long> {

	/**
	 * ���Ҹ���Դ������Դ
	 * 
	 * @param id
	 * @return
	 */
	@Query("select t from SysResource t where t.parentId=?1")
	public List<SysResource> findChildren(Long parentId);

	/**
	 * ͨ����Դ�ȼ����Ҹ���Դ
	 * 
	 * @param level
	 * @return
	 */
	@Query("select t from SysResource t where t.resourceLevel=?1")
	public List<SysResource> findByLevel(Integer level);

	/**
	 * ��ѯ���ӽڵ�ϵͳ��Դ
	 * @return
	 */
	@Query("select t from SysResource t where t.resourceLevel<(select max(resourceLevel) from SysResource)")
	public List<SysResource> findParents();
	
	/**
	 * ͨ����ϵͳ��Դ������
	 * @param parentName
	 * @return
	 */
	@Query("select t from SysResource t where t.parentId in(select id from SysResource where name like?1)")
	public List<SysResource> findByParentName(String parentName);
	
	/**
	 * ͨ������Դ�ĸ�id���Ҹ���Դ
	 * @param parentId
	 * @return
	 */
	@Query("select t from SysResource t where t.id=?1")
	public SysResource findParentResource(Long parentId);
	
	/**
	 * ͨ����Դ���͵ȼ�����
	 * @param name
	 * @param level
	 * @return
	 */
	@Query("select t from SysResource t where t.name=?1 and t.resourceLevel=?2")
	public SysResource findByNameAndLevel(String name,Integer level);
	
	/**
	 * 
	 * @Title: listByName
	 * @Description: ͨ�����ƻ�ȡid
	 * @param name
	 * @return
	 * @return: List<Long>
	 */
	@Query("select t from SysResource t where t.name in ?1")
	public List<SysResource> listByName(List<String> name);
}
