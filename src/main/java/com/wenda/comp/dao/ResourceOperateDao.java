package com.wenda.comp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wenda.comp.model.ResourceOperate;

public interface ResourceOperateDao extends JpaRepository<ResourceOperate, Long>{

	@Query("select t from ResourceOperate t where t.roleId=?1")
	public List<ResourceOperate> getRoleOperates(Long roleId);
	
	@Query("select t from ResourceOperate t where t.roleId=?1 and t.operateId=?2")
	public ResourceOperate findResourceOperate(Long roleId,Long operateId);
	
}
