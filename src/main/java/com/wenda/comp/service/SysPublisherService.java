package com.wenda.comp.service;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SysPublisherQueryForm;
import com.wenda.comp.model.SysPublisher;


/**
 * <p>
 * Description: ������Service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysPublisherService {
	/**
	 * ��������޸�
	 */
	public void saveOrEdit(SysPublisher sysPublisher);
	/**
	 * ��ѯ�����ĳ�����
	 * @param sysPublisherQueryForm
	 * @return
	 */
	public Page<SysPublisher> findPublicSysPublisher(SysPublisherQueryForm sysPublisherQueryForm);
	/**
	 * ��ѯѧУ��ӵĺ͹����ĳ�����
	 * @param schoolId
	 * @param sysPublisherQueryForm
	 * @return
	 */
	public Page<SysPublisher> findPublicOrBySchoolId(Long schoolId,SysPublisherQueryForm sysPublisherQueryForm);
	
	/**
	 * ��֤�Ƿ�������
	 * @param code
	 * @param schoolId
	 * @return
	 */
	public SysPublisher validationSaveAble(String code, Long schoolId);
	
	/**
	 * ͨ��������ҳ�����
	 * @param code
	 * @return
	 */
	public SysPublisher findByCode(String code);
}
