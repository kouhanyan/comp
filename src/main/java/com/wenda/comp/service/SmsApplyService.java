package com.wenda.comp.service;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SmsApplyQueryForm;
import com.wenda.comp.model.SmsApply;

/**
 * <p>
 * Description: 短信申请service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-08-06
 */
public interface SmsApplyService {
	/**
	 * 保存
	 * @param sa
	 */
	public void save(SmsApply sa);
	/**
	 * 列表查询
	 * @param id 学校id
	 * @param smsApplyQueryForm
	 * @return
	 */
	public Page<SmsApply> findBySchool(Long id,
			SmsApplyQueryForm smsApplyQueryForm);
	/**
	 * 查询所有
	 * @return
	 */
	public Page<SmsApply> findAll(SmsApplyQueryForm smsApplyQueryForm);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public SmsApply findOne(Long id);
	/**
	 * 审核
	 * @param sa
	 */
	public void audit(SmsApply sa);
}
