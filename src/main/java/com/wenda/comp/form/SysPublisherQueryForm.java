package com.wenda.comp.form;

import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: 出版社表单
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class SysPublisherQueryForm extends Pager {

	private String code;//代码

	private String name;//名称
	
	private Long schoolId;//名称

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

}
