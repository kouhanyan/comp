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
 * Description: 短信申请状态service
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
		// 修改申请记录
		sa.setDealDate(new Date());
		sa.setApplyState(SmsApplyStateEnum.HANDLE_SUCCESS);
		save(sa);
		// 添加学校的的短信数量
		SmsUseState sus = SmsUseStateService.get(sa.getSchoolId());
		sus.setEnableSms(sus.getEnableSms() + sa.getApplyNum());
		if (sus.getEffectiveDate() == null) {
			sus.setEffectiveDate(new Date());
		}
		sus.setEffectiveDate(InternetTime.addYear(sus.getEffectiveDate(), 1));
		SmsUseStateService.save(sus);
		// 生成充值记录
		SmsRechargeRecode srr = new SmsRechargeRecode();
		srr.setSchoolId(sa.getSchoolId());
		srr.setAmount(sa.getAmount());
		srr.setNum(sa.getApplyNum());
		srr.setCreateDate(new Date());
		smsRechargeRecodeDao.save(srr);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String content = "<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html;charset=UTF-8' /><title>平台服务</title></head><body><h3>"
				+ sa.getSchoolName()
				+ "的"
				+ sa.getContactName()
				+ "老师你好<br/>你的"
				+ sa.getProject()
				+ "申请已通过审核</h3><table><tr><th>充值金额：</th><td>"
				+ sa.getAmount()
				+ "</td><th>可得短信：</th><td>"
				+ sa.getApplyNum()
				+ "</td></tr><tr><th>充值时间：</th><td>"
				+ sdf.format(new Date())
				+ "</td><th>有效期至：</th><td>"
				+ sdf.format(InternetTime.addYear(new Date(), 1))
				+ "</td></tr><tr><th></th><td style='font-size:20px;'>温州市云图书馆服务中心</td></tr><tr><th>联系人：</th><td>余老师</td></tr><th>联系方式:</th><td>88906919</td></table></body></html>";
		// 发邮箱
		mailService.sendMail(content, sa.getContactEmail(),"短信申请通过");

	}

}
