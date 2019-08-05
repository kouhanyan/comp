package com.wenda.comp.service;

import com.wenda.comp.model.SmsUseState;

/**
 * <p>
 * Description: 短信使用状态service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-08-06
 */
public interface SmsUseStateService {
	/**
	 * 保存
	 * @param smsUseState
	 */
	public void save(SmsUseState smsUseState);
	
	/**
	 * 查询
	 * @param schoolId
	 * @return
	 */
	public SmsUseState get(Long schoolId);

}
