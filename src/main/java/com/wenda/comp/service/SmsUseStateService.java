package com.wenda.comp.service;

import com.wenda.comp.model.SmsUseState;

/**
 * <p>
 * Description: ����ʹ��״̬service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-08-06
 */
public interface SmsUseStateService {
	/**
	 * ����
	 * @param smsUseState
	 */
	public void save(SmsUseState smsUseState);
	
	/**
	 * ��ѯ
	 * @param schoolId
	 * @return
	 */
	public SmsUseState get(Long schoolId);

}
