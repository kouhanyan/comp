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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


/**
 * <p>
 * Description: 学校短信使用状态
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author ylb
 * @Version 1.0 2014-09-10
 */
@Entity
@Cacheable
@Table(name = "sms_use_state")
@SequenceGenerator(name = "s_sms_use_state", sequenceName = "s_sms_use_state", allocationSize = 1)
public class SmsUseState implements Serializable{

	private static final long serialVersionUID = 5780375074775644695L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="s_sms_use_state")
	private Long id; 
	
	@NotNull
	@Column(name="school_id")
	private Long schoolId;//学校id
	
	@Column(name="enable_sms")
	private Long enableSms;//可以使用的短信条数(总条数)
	
	@Column(name="used_sms")
	private Long usedSms;//已使用的短信条数
	
	@Column(name="effective_date")
	private Date effectiveDate;//有效期
	
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	public Long getEnableSms() {
		return enableSms;
	}

	public void setEnableSms(Long enableSms) {
		this.enableSms = enableSms;
	}

	public Long getUsedSms() {
		return usedSms;
	}

	public void setUsedSms(Long usedSms) {
		this.usedSms = usedSms;
	}

	/**
	 * 剩余可用条数
	 * @return
	 */
	@Transient
	public Long getRemainSms(){
		return enableSms - usedSms;
	}
	
	/**
	 * 是否还能发送短信
	 * @return
	 */
	@Transient
	public Boolean getUseable(){
		return (enableSms - usedSms)<=0? false:true;
	}
	
	@PrePersist
	public void init(){
		this.enableSms = 0l;
		this.usedSms = 0l;
	}
	
}
