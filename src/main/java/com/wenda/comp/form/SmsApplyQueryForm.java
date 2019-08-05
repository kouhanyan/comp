package com.wenda.comp.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.wenda.comp.enumModel.SmsApplyStateEnum;
import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: ��������
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-31
 */
public class SmsApplyQueryForm extends Pager {
	
	private String schoolName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date applyStartDate; //��ʼ����
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date applyEndDate; //��ֹ����
	
	private SmsApplyStateEnum smsApplyStateEnum;
	
	
	
	
	

	public SmsApplyStateEnum getSmsApplyStateEnum() {
		return smsApplyStateEnum;
	}

	public void setSmsApplyStateEnum(SmsApplyStateEnum smsApplyStateEnum) {
		this.smsApplyStateEnum = smsApplyStateEnum;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Date getApplyStartDate() {
		return applyStartDate;
	}

	public void setApplyStartDate(Date applyStartDate) {
		this.applyStartDate = applyStartDate;
	}

	public Date getApplyEndDate() {
		return applyEndDate;
	}

	public void setApplyEndDate(Date applyEndDate) {
		this.applyEndDate = applyEndDate;
	}
	
	

}
