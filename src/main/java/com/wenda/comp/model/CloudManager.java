package com.wenda.comp.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: 云端维护
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Entity
@Table(name = "cloud_manager")
@Cacheable
@SequenceGenerator(name = "s_cloud_manager", sequenceName = "s_cloud_manager", allocationSize = 1)
public class CloudManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_cloud_manager")
	private Long id;

	@Column(name = "describe")
	@NotBlank
	private String describe;// 云端维护内容描述

	@Column(name = "deal_status")
	@NotNull
	private Integer dealStatus;// 处理状态

	@NotNull
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;// 创建日期

	@Column(name = "sys_user_id")
	@NotNull
	private Long sysUserId;// 系统用户id

	@NotNull
	@JoinColumn(name = "school_id")
	@ManyToOne
	private School school;// 学校id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

}
