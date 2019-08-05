package com.wenda.comp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.text.SimpleDateFormat;
import com.wenda.comp.common.util.InternetTime;
import com.wenda.comp.dao.SmsApplyDao;
import com.wenda.comp.dao.SmsRechargeRecodeDao;
import com.wenda.comp.enumModel.SmsApplyStateEnum;
import com.wenda.comp.form.SmsApplyQueryForm;
import com.wenda.comp.model.SmsApply;
import com.wenda.comp.model.SmsRechargeRecode;
import com.wenda.comp.model.SmsUseState;
import com.wenda.comp.service.MailService;
import com.wenda.comp.service.SmsApplyService;
import com.wenda.comp.service.SmsUseStateService;

/**
 * <p>
 * Description: ��������״̬service
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-08-06
 */
@Service
public class SmsApplyServiceImpl implements SmsApplyService {

	@Autowired
	private SmsApplyDao smsApplyDao;
	@Autowired
	private SmsUseStateService SmsUseStateService;
	@Autowired
	private SmsRechargeRecodeDao smsRechargeRecodeDao;
	@Autowired
	private MailService mailService;

	@Transactional
	public void save(SmsApply sa) {
		smsApplyDao.save(sa);

	}

	public Page<SmsApply> findBySchool(Long id,
			SmsApplyQueryForm smsApplyQueryForm) {
		return smsApplyDao.findBySchool(id, smsApplyQueryForm);
	}

	public Page<SmsApply> findAll(SmsApplyQueryForm smsApplyQueryForm) {

		return smsApplyDao.findAll(smsApplyQueryForm);
	}

	public SmsApply findOne(Long id) {
		return smsApplyDao.findOne(id);
	}

	@Transactional
	public void audit(SmsApply sa) {
		// �޸������¼
		sa.setDealDate(new Date());
		sa.setApplyState(SmsApplyStateEnum.HANDLE_SUCCESS);
		save(sa);
		// ���ѧУ�ĵĶ�������
		SmsUseState sus = SmsUseStateService.get(sa.getSchoolId());
		sus.setEnableSms(sus.getEnableSms() + sa.getApplyNum());
		if (sus.getEffectiveDate() == null) {
			sus.setEffectiveDate(new Date());
		}
		sus.setEffectiveDate(InternetTime.addYear(sus.getEffectiveDate(), 1));
		SmsUseStateService.save(sus);
		// ���ɳ�ֵ��¼
		SmsRechargeRecode srr = new SmsRechargeRecode();
		srr.setSchoolId(sa.getSchoolId());
		srr.setAmount(sa.getAmount());
		srr.setNum(sa.getApplyNum());
		srr.setCreateDate(new Date());
		smsRechargeRecodeDao.save(srr);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String content = "<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html;charset=UTF-8' /><title>ƽ̨����</title></head><body><h3>"
				+ sa.getSchoolName()
				+ "��"
				+ sa.getContactName()
				+ "��ʦ���<br/>���"
				+ sa.getProject()
				+ "������ͨ�����</h3><table><tr><th>��ֵ��</th><td>"
				+ sa.getAmount()
				+ "</td><th>�ɵö��ţ�</th><td>"
				+ sa.getApplyNum()
				+ "</td></tr><tr><th>��ֵʱ�䣺</th><td>"
				+ sdf.format(new Date())
				+ "</td><th>��Ч������</th><td>"
				+ sdf.format(InternetTime.addYear(new Date(), 1))
				+ "</td></tr><tr><th></th><td style='font-size:20px;'>��������ͼ��ݷ�������</td></tr><tr><th>��ϵ�ˣ�</th><td>����ʦ</td></tr><th>��ϵ��ʽ:</th><td>88906919</td></table></body></html>";
		// ������
		mailService.sendMail(content, sa.getContactEmail(),"��������ͨ��");

	}

}
