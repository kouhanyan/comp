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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: 系统公告
 * </p>
 * Copyright: Copyright (c) 2014 Company: wenda
 * 
 * @Author sfy
 * @Version Ⅱ1.0 2014-07-21
 */
@Entity
@Cacheable
@Table(name = "sys_announcement")
@SequenceGenerator(name = "s_sys_announcement", sequenceName = "s_sys_announcement", allocationSize = 1)
public class SysAnnouncement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_announcement")
	private Long id;// id

	@Column(name = "sys_user_id")
	@NotNull
	private Long sysUserId;// 发布者id

	@NotEmpty
	private String sender;// 发布者

	@NotEmpty
	private String title;// 标题

	@NotEmpty
	private String content;// 内容

	@Column(name = "send_date")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sendDate;
	
	@Column(name = "is_display")
	private Boolean isDisplay ;//是否显示在头部

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Boolean getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Boolean isDisplay) {
		this.isDisplay = isDisplay;
	}
	
	@PrePersist
	public void init(){
		this.isDisplay = false;
	}

}
