package com.wenda.comp.form;

import java.util.List;

import com.wenda.comp.model.ResourceOperate;
import com.wenda.comp.model.SysOperate;
import com.wenda.comp.page.Pager;

/**
 * <p>
 * Description: 系统角色表单
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class SysRoleQueryForm extends Pager {

	private Long id;// 角色id

	private String name;// 角色名称

	private String schoolName;// 学校id

	private Long[] checks;

	private List<ResourceOperate> list;// 角色资源关系

	private List<SysOperate> sysOperates;// 资源操作

	public Long[] getChecks() {
		return checks;
	}

	public void setChecks(Long[] checks) {
		this.checks = checks;
	}

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

	public List<ResourceOperate> getList() {
		return list;
	}

	public void setList(List<ResourceOperate> list) {
		this.list = list;
	}

	public List<SysOperate> getSysOperates() {
		return sysOperates;
	}

	public void setSysOperates(List<SysOperate> sysOperates) {
		this.sysOperates = sysOperates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
