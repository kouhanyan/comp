package com.wenda.comp.form;

import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: 系统资源表单
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class SysResourceQueryForm extends Pager{
  
	private String name;//名称
	
	private String url;//链接地址
	
	private String parentName;//父资源名
	
	private Integer resourceLevel;//层次

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getResourceLevel() {
		return resourceLevel;
	}

	public void setResourceLevel(Integer resourceLevel) {
		this.resourceLevel = resourceLevel;
	}
	
	
}
