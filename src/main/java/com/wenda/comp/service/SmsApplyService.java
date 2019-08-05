package com.wenda.comp.service;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SmsApplyQueryForm;
import com.wenda.comp.model.SmsApply;

/**
 * <p>
 * Description: ��������service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-08-06
 */
public interface SmsApplyService {
	/**
	 * ����
	 * @param sa
	 */
	public void save(SmsApply sa);
	/**
	 * �б��ѯ
	 * @param id ѧУid
	 * @param smsApplyQueryForm
	 * @return
	 */
	public Page<SmsApply> findBySchool(Long id,
			SmsApplyQueryForm smsApplyQueryForm);
	/**
	 * ��ѯ����
	 * @return
	 */
	public Page<SmsApply> findAll(SmsApplyQueryForm smsApplyQueryForm);
	/**
	 * ��ѯ
	 * @param id
	 * @return
	 */
	public SmsApply findOne(Long id);
	/**
	 * ���
	 * @param sa
	 */
	public void audit(SmsApply sa);
}
