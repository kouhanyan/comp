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
 * Description: 用户桌面管理
 * </p>
 * Copyright: Copyright (c) 2014 Company: wenda
 * 
 * @Author ylb
 * @Version Ⅱ1.0 2014-07-21
 */
@Entity
@Cacheable
@Table(name = "sys_desktop_user")
@SequenceGenerator(name = "s_sys_desktop_user", sequenceName = "s_sys_desktop_user", allocationSize = 1)
public class SysDesktopUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_desktop_user")
	private Long id;// id

	@ManyToOne
	@NotNull
	@JoinColumn(name="sys_desktop_id")
	private SysDesktop sysDesktop;// 系统桌面

	@ManyToOne
	@NotNull
	@JoinColumn(name="sys_user_id")
	private SysUser sysUser;// 系统用户

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SysDesktop getSysDesktop() {
		return sysDesktop;
	}

	public void setSysDesktop(SysDesktop sysDesktop) {
		this.sysDesktop = sysDesktop;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

}
