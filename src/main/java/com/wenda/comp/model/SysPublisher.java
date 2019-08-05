package com.wenda.comp.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * Description: ������
 * </p>
 * Copyright: Copyright (c) 2014 Company: wenda
 * 
 * @Author sfy
 * @Version ��1.0 2014-07-21
 */

@Entity
@Cacheable
@Table(name="sys_publisher")
@SequenceGenerator(name = "s_sys_publisher", sequenceName = "s_sys_publisher", allocationSize = 1)
public class SysPublisher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_publisher")
	private Long id;
	
	@NotEmpty
	private String code;// ����
	
	@NotEmpty
	private String name;// ����

	@Column(name="city_name")
	
	private String cityName;// ������������

	@Column(name="city_code")
	private String cityCode;// �������д���

	@Column(name="create_date")
	private Timestamp createDate;// ����ʱ��
	
	@JoinColumn(name = "school_id")
	@ManyToOne
	private School school;// ����ѧУ

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
