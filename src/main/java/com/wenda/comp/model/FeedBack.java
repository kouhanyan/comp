package com.wenda.comp.model;

import java.io.Serializable;
import java.util.Date;

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
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: 反馈
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Entity
@Cacheable
@Table(name = "feed_back")
@SequenceGenerator(name = "s_feed_back", sequenceName = "s_feed_back", allocationSize = 1)
public class FeedBack implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_feed_back")
	private Long id;

	@Column(name = "sys_user_id")
	@NotNull
	private Long sysUserId;

	@Column(name = "sys_user_name")
	@NotEmpty
	private String sysUserName;

	@Column(name = "school_id")
	@NotNull
	private Long schoolId;

	@Column(name = "school_name")
	@NotEmpty
	private String schoolName;

	@NotEmpty
	private String problem;// 反馈问题

	@Column(name = "create_date")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	@Column(name = "image_path")
	@NotEmpty
	private String imagePath;// 截图路径

	@Column(name = "is_deal")
	private Integer isDeal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}

}
