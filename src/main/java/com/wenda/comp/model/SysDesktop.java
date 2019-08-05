package com.wenda.comp.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * Description: 桌面管理
 * </p>
 * Copyright: Copyright (c) 2014 Company: wenda
 * 
 * @Author sfy
 * @Version Ⅱ1.0 2014-07-21
 */
@Entity
@Cacheable
@Table(name = "sys_desktop")
@SequenceGenerator(name = "s_sys_desktop", sequenceName = "s_sys_desktop", allocationSize = 1)
public class SysDesktop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_desktop")
	private Long id;// id

	@NotEmpty
	private String name;// 图标名称

	@Column(name="screen_no")
	@NotNull
	private Integer screenNo;// 屏幕号

	@NotEmpty
	private String url;// 链接地址

	@Column(name="create_date")
	private Timestamp createDate;// 创建时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(Integer screenNo) {
		this.screenNo = screenNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
