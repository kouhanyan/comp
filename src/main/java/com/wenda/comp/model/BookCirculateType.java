package com.wenda.comp.model;

import java.io.Serializable;
import java.sql.Timestamp;

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
 * Description: ������ͨ����
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author ylb
 * @Version 1.0 2014-07-31
 */
@Entity
@Cacheable
@Table(name = "book_circulate_type")
@SequenceGenerator(name = "s_book_circulate_type", sequenceName = "s_book_circulate_type", allocationSize = 1)
public class BookCirculateType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="s_book_circulate_type")
	private long id ; //����
	
	@NotEmpty
	private String code; //�������ʹ���
	
	@NotEmpty
	private String name;//������������
	
	private String description; //˵��
	
	@NotNull
	@ManyToOne
	private SysUser sysUser; //����Ա
	
	@Column(name = "create_date")
	private Timestamp createDate; //����ʱ��
	
	@NotNull
	@ManyToOne
	private School school; //ѧУID
	
	@Column(name = "is_allow_pre")
	private Integer isAllowPre; //����Ԥ��
	
	@Column(name="is_default")
	private Integer isDefault;//�Ƿ�����Ĭ��
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Integer getIsAllowPre() {
		return isAllowPre;
	}

	public void setIsAllowPre(Integer isAllowPre) {
		this.isAllowPre = isAllowPre;
	}
	
	@Transient
	public String getCodeAndName(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.getCode()+" | ").append(this.getName());
		return sb.toString();
	}
}
