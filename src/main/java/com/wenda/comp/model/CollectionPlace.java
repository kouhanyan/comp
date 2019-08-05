package com.wenda.comp.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * Description: 馆藏地
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author ylb
 * @Version 1.0 2014-08-03
 */
@Entity
@Cacheable
@Table(name = "collection_place")
@SequenceGenerator(name = "s_collection_place", sequenceName = "s_collection_place", allocationSize = 1)
public class CollectionPlace implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="s_collection_place")
	private long id ; //主键
	
	@ManyToOne
	@NotNull
	private School school; //学校ID
	
	@ManyToOne
	@NotNull
	private BookCirculateType bookCirculateType; //流通类型ID
	
	@NotEmpty
	private String code; //馆藏类型代码
	
	@NotEmpty
	private String name;//馆藏类型名称
	

	@NotNull
	@Column(name="is_regist")
	private Integer isRegist;//是否需要馆藏登记
	
	@Column(name="is_default")
	private Integer isDefault;//是否设置默认
	
	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public BookCirculateType getBookCirculateType() {
		return bookCirculateType;
	}

	public void setBookCirculateType(BookCirculateType bookCirculateType) {
		this.bookCirculateType = bookCirculateType;
	}

	public Integer getIsRegist() {
		return isRegist;
	}

	public void setIsRegist(Integer isRegist) {
		this.isRegist = isRegist;
	}
	
	@Transient
	public String getCodeAndName(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.getCode()+" | ").append(this.getName());
		return sb.toString();
	}
	
}
