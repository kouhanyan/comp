package com.wenda.comp.form;

import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: ·´À¡±íµ¥
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class FeedBackQueryForm extends Pager {

	private String sysUserName;

	private String schoolName;

	private Integer isDeal;

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}

}
