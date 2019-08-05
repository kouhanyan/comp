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

/**
 * 短信充值记录
 * @author jinzhaopo
 *
 */
@Entity
@Cacheable
@Table(name = "sms_recharge_recode")
@SequenceGenerator(name = "s_sms_recharge_recode", sequenceName = "s_sms_recharge_recode", allocationSize = 1)
public class SmsRechargeRecode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sms_recharge_recode")
	private Long id;
	
	@Column(name="create_date")
	private Date createDate;//充值时间
	
	private Double amount;//充值金额
	
	private Long num;//充值数量
	
	@Column(name="school_id")
	private Long schoolId;//学校

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	
	

}
