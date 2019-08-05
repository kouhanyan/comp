package com.wenda.comp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SysVersionQueryForm;
import com.wenda.comp.model.SysVersion;

/**
 * <p>
 * Description: 版本Service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysVersionService {
	/**
	 * 分页查询
	 * @param sysVersionQueryForm
	 * @return
	 */
	Page<SysVersion> find(String edition,String directory,SysVersionQueryForm sysVersionQueryForm);
	/**
	 * 保存和修改
	 * @param sysVersion
	 */
	void saveOrEdit(SysVersion sysVersion);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	SysVersion findOne(Long id);
	/**
	 * 删除
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 设置当前为版本信息
	 * @param id
	 */
	void setWorkState(Long id);
	/**
	 * 根据是否为当前版本获取信息
	 * @param isCurrentVersion
	 * @return
	 */
	List<SysVersion> getByICV(Boolean isCurrentVersion);

}
