package com.wenda.comp.form;

import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: ϵͳ�û���
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class SysUserQueryForm extends Pager {

	private String name;//��ʵ����
	
	private String userName;// �û���

	private String rawPass;// ����

	private String schoolName;//ѧУ����
	
	private String captcha;//��֤��
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRawPass() {
		return rawPass;
	}

	public void setRawPass(String rawPass) {
		this.rawPass = rawPass;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	

}
