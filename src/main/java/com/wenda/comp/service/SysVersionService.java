package com.wenda.comp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SysVersionQueryForm;
import com.wenda.comp.model.SysVersion;

/**
 * <p>
 * Description: �汾Service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysVersionService {
	/**
	 * ��ҳ��ѯ
	 * @param sysVersionQueryForm
	 * @return
	 */
	Page<SysVersion> find(String edition,String directory,SysVersionQueryForm sysVersionQueryForm);
	/**
	 * ������޸�
	 * @param sysVersion
	 */
	void saveOrEdit(SysVersion sysVersion);
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	SysVersion findOne(Long id);
	/**
	 * ɾ��
	 * @param id
	 */
	void delete(Long id);
	/**
	 * ���õ�ǰΪ�汾��Ϣ
	 * @param id
	 */
	void setWorkState(Long id);
	/**
	 * �����Ƿ�Ϊ��ǰ�汾��ȡ��Ϣ
	 * @param isCurrentVersion
	 * @return
	 */
	List<SysVersion> getByICV(Boolean isCurrentVersion);

}
