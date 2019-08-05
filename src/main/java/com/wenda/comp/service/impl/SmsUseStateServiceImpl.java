package com.wenda.comp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenda.comp.dao.SmsUseStateDao;
import com.wenda.comp.model.SmsUseState;
import com.wenda.comp.service.SmsUseStateService;

/**
 * <p>
 * Description: ¶ÌÐÅÊ¹ÓÃ×´Ì¬service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-08-06
 */
@Service
public class SmsUseStateServiceImpl implements SmsUseStateService {
	@Autowired
	private SmsUseStateDao smsUseStateDao;

	@Transactional
	public void save(SmsUseState smsUseState) {
		smsUseStateDao.save(smsUseState);
		
	}
	
	public SmsUseState get(Long schoolId) {
		return smsUseStateDao.get(schoolId);
	}
	
}
