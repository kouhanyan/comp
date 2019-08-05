package com.wenda.comp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SysAnnouncementQueryForm;
import com.wenda.comp.model.SysAnnouncement;


/**
 * <p>
 * Description: 系统通告Service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysAnnouncementService {
	/**
	 * 分页查询
	 * @param sysVersionQueryForm
	 * @return
	 */
	Page<SysAnnouncement> find(String title,String sender,SysAnnouncementQueryForm sysAnnouncementQueryForm);
	/**
	 * 保存和修改
	 * @param sysVersion
	 */
	void saveOrEdit(SysAnnouncement sysAnnouncement);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	SysAnnouncement findOne(Long id);
	/**
	 * 删除
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 设置为显示
	 * @param id
	 */
	void setWorkState(Long id);
	/**
	 * 根据是否为当前版本获取信息
	 * @param isCurrentVersion
	 * @return
	 */
	List<SysAnnouncement> getByIsDisplay(Boolean isDisplay);
}
