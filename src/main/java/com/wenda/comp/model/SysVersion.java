package com.wenda.comp.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: �汾
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Entity
@Cacheable
@Table(name = "sys_version")
@SequenceGenerator(name = "s_sys_version", sequenceName = "s_sys_version", allocationSize = 1)
public class SysVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_sys_version")
	private Long id;
	
	private String edition;//���
	
	private String directory;//Ŀ��
	
	@Column(name="release_notes",length=256)
	private String releaseNotes;//�汾˵��
	
	private String characteristic;//�ص�
	
	@Column(name="create_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	
	@Column(name="modify_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifyDate;
	
	@Column(name="is_current_version")
	private Boolean isCurrentVersion;//�Ƿ�Ϊ��ǰ�汾

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getReleaseNotes() {
		return releaseNotes;
	}

	public void setReleaseNotes(String releaseNotes) {
		this.releaseNotes = releaseNotes;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Boolean getIsCurrentVersion() {
		return isCurrentVersion;
	}

	public void setIsCurrentVersion(Boolean isCurrentVersion) {
		this.isCurrentVersion = isCurrentVersion;
	}
	
	@PrePersist
	public void init(){
		this.isCurrentVersion = false;//�����Ƿ�Ϊ��ǰ���
		this.createDate = new Date();//���ô�������
		this.modifyDate = new Date();
	}
	
	@PreUpdate
	public void updateValue(){
		this.modifyDate = new Date();
	}
	
	@Transient
	public String getInfo(){
		return this.edition+"."+this.directory;
		
	}
	@Transient
	public String getCreateDateStr(){
		return new SimpleDateFormat("yyyy-MM-dd").format(this.createDate);
		
	}
	@Transient
	public String getModifyDateStr(){
		return new SimpleDateFormat("yyyy-MM-dd").format(this.modifyDate);
		
	}
	
	
	
	
	
	
	
	

}
