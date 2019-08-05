package com.wenda.comp.service;

import org.springframework.data.domain.Page;

import com.wenda.comp.form.SysPublisherQueryForm;
import com.wenda.comp.model.SysPublisher;


/**
 * <p>
 * Description: 出版社Service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-21
 */
public interface SysPublisherService {
	/**
	 * 保存或者修改
	 */
	public void saveOrEdit(SysPublisher sysPublisher);
	/**
	 * 查询公共的出版社
	 * @param sysPublisherQueryForm
	 * @return
	 */
	public Page<SysPublisher> findPublicSysPublisher(SysPublisherQueryForm sysPublisherQueryForm);
	/**
	 * 查询学校添加的和公共的出版社
	 * @param schoolId
	 * @param sysPublisherQueryForm
	 * @return
	 */
	public Page<SysPublisher> findPublicOrBySchoolId(Long schoolId,SysPublisherQueryForm sysPublisherQueryForm);
	
	/**
	 * 验证是否可以添加
	 * @param code
	 * @param schoolId
	 * @return
	 */
	public SysPublisher validationSaveAble(String code, Long schoolId);
	
	/**
	 * 通过代码查找出版社
	 * @param code
	 * @return
	 */
	public SysPublisher findByCode(String code);
}
