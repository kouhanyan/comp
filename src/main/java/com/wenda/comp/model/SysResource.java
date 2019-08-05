package com.wenda.comp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>
 * Description: 系统资源
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-21
 */
@Entity
@Cacheable
@Table(name = "sys_resource")
@SequenceGenerator(name = "s_sys_resource", sequenceName = "s_sys_resource", allocationSize = 1)
public class SysResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_resource")
	private Long id;

	@Column(name = "parent_id")
	private Long parentId;// 父id

	private String name;// 资源名

	private String url;// 资源路径
	@Column(name = "resource_level")
	private Integer resourceLevel;// 资源等级

	private Integer sort;// 排序

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] ico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

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

	public Integer getResourceLevel() {
		return resourceLevel;
	}

	public void setResourceLevel(Integer resourceLevel) {
		this.resourceLevel = resourceLevel;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public byte[] getIco() {
		return ico;
	}

	public void setIco(byte[] ico) {
		this.ico = ico;
	}

}
