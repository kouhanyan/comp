package com.wenda.comp.form;

import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: 行政区划表单
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class SysRegionQueryForm extends Pager {

	private String code;// 行政区划代码

	private String name;// 行政区划名称

	private String parentName;// 父ID

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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
