package com.wenda.comp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SysAnnouncementQueryForm;
import com.wenda.comp.model.SysAnnouncement;


/**
 * <p>
 * Description: ϵͳͨ��Service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysAnnouncementService {
	/**
	 * ��ҳ��ѯ
	 * @param sysVersionQueryForm
	 * @return
	 */
	Page<SysAnnouncement> find(String title,String sender,SysAnnouncementQueryForm sysAnnouncementQueryForm);
	/**
	 * ������޸�
	 * @param sysVersion
	 */
	void saveOrEdit(SysAnnouncement sysAnnouncement);
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	SysAnnouncement findOne(Long id);
	/**
	 * ɾ��
	 * @param id
	 */
	void delete(Long id);
	/**
	 * ����Ϊ��ʾ
	 * @param id
	 */
	void setWorkState(Long id);
	/**
	 * �����Ƿ�Ϊ��ǰ�汾��ȡ��Ϣ
	 * @param isCurrentVersion
	 * @return
	 */
	List<SysAnnouncement> getByIsDisplay(Boolean isDisplay);
}
