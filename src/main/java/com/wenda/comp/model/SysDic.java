package com.wenda.comp.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * Description: 数据字典
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Entity
@Cacheable
@Table(name = "sys_dic")
@SequenceGenerator(name = "s_sys_dic", sequenceName = "s_sys_dic", allocationSize = 1)
public class SysDic implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_dic")
	private Long id;

	@Column(name = "dic_type")
	@NotNull
	private Integer dicType;// 数据类型

	@Column(name = "dic_key")
	@NotNull
	private Integer dicKey;// 数据键值

	@Column(name = "dic_value")
	private String dicValue;// 数据内容值

	@Column(name = "dic_type_desc")
	private String dicTypeDesc;// 数据类型描述

	@Column(name = "sort")
	private Integer sort;// 排序

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDicType() {
		return dicType;
	}

	public void setDicType(Integer dicType) {
		this.dicType = dicType;
	}

	public Integer getDicKey() {
		return dicKey;
	}

	public void setDicKey(Integer dicKey) {
		this.dicKey = dicKey;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicTypeDesc() {
		return dicTypeDesc;
	}

	public void setDicTypeDesc(String dicTypeDesc) {
		this.dicTypeDesc = dicTypeDesc;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
