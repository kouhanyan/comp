package com.wenda.comp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.wenda.comp.enumModel.SmsApplyStateEnum;

/**
 * <p>
 * Description: 短信申请
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author ylb
 * @Version 1.0 2014-09-10
 */
@Entity
@Cacheable
@Table(name = "sms_apply")
@SequenceGenerator(name = "s_sms_apply", sequenceName = "s_sms_apply", allocationSize = 1)
public class SmsApply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sms_apply")
	private Long id;

	@NotNull
	@Column(name = "school_id")
	private Long schoolId;// 学校id

	@NotNull
	@Column(name = "school_name")
	private String schoolName;// 学校用名称

	@NotNull
	@Column(name = "user_id")
	private Long userId;// 用户id

	@NotNull
	@Column(name = "user_name")
	private String userName;// 用户名称

	@Column(name = "apply_state")
	@NotNull
	private SmsApplyStateEnum applyState;// 申请状态

	private String project;// 申请的项目

	private Double amount;// 申请的金额

	@NotNull
	@Column(name = "apply_num")
	private Long applyNum;// 申请条数

	@Column(name = "apply_date")
	private Date applyDate;// 短信申请的时间

	@Column(name = "deal_date")
	private Date dealDate;// 处理申请的时间

	@NotNull
	@Column(name = "contact_name")
	private String contactName;// 联系人

	@NotNull
	@Column(name = "contact_phone")
	private String contactPhone;// 联系人电话

	@NotNull
	@Column(name = "contact_email")
	private String contactEmail;// 联系人邮箱

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(Long applyNum) {
		this.applyNum = applyNum;
	}

	public SmsApplyStateEnum getApplyState() {
		return applyState;
	}

	public void setApplyState(SmsApplyStateEnum applyState) {
		this.applyState = applyState;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	@PrePersist
	public void init() {
		this.applyDate = new Date();
	}

	@PreUpdate
	public void update() {
		this.dealDate = new Date();
	}

	@Transient
	public String getApplyStateStr() {
		return this.applyState.getName();

	}

}
