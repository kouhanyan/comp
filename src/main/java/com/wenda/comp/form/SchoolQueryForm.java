package com.wenda.comp.form;

import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: 学校表单
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-22
 */
public class SchoolQueryForm extends Pager {

	private String schoolCode;// 学校代码

	private String simpleName;// 学校简称

	private String schoolName;// 学校名称

	private Integer type;// 类型

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
