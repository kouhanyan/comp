package com.wenda.comp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wenda.comp.model.SysDesktop;
/**
 * <p>
 * Description: ϵͳ����dao
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Repository

public interface SysDesktopDao extends JpaRepository<SysDesktop, Long>{

	/**
	 * ͨ��ͼ�����Ʋ����������
	 * @param name
	 * @param pageable
	 * @return
	 */
	@Query("select t from SysDesktop t where t.name like?1")
	public Page<SysDesktop> query(String name,Pageable pageable);
}
