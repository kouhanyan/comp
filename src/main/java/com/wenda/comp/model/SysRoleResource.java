package com.wenda.comp.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * Description: 系统角色资源关系
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-28
 */
@Entity
@Cacheable
@Table(name = "sys_role_resource")
@SequenceGenerator(name = "s_sys_role_resource", sequenceName = "s_sys_role_resource", allocationSize = 1)
public class SysRoleResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_role_resource")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "sys_role_id")
	@NotNull
	private SysRole sysRole;// 系统角色

	@ManyToOne
	@JoinColumn(name = "sys_resource_id")
	@NotNull
	private SysResource sysResource;// 系统资源

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysResource getSysResource() {
		return sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}

}
