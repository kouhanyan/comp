package com.wenda.comp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: 图书验收
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Entity
@Cacheable
@Table(name = "biblio_acceptance_book")
@SequenceGenerator(name = "s_biblio_acceptance_book", sequenceName = "s_biblio_acceptance_book", allocationSize = 1)
public class BiblioAcceptanceBook implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_biblio_acceptance_book")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "biblio_temp_id")
	private BiblioTemp biblioTemp;// 临时库

	@Column(name = "single_price")
	private Double singlePrice;// 单价

	@Column(name = "total_price")
	private Double totalPrice;// 总价

	private Integer coplies;// 复本数

	@Column(name = "lib_local")
	private String libLocal;// 验收分配

	@Column(name = "vol_num")
	private Integer volNum;// 卷册数量

	@Column(name = "vol_info")
	private String volInfo;// 卷册信息

	@Column(name = "book_source")
	private Integer bookSource;// 文献来源

	@Column(name = "media_type")
	private Integer mediaType;// 介质类型

	@Column(name = "bind_info")
	private Integer bindInfo;// 装帧信息

	@NotNull
	@Column(name = "sys_user_id")
	private Long sysUserId;// 系统用户id

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "accept_date")
	private Date acceptDate;// 验收日期

	@Column(name = "call_no")
	private String callNo;// 索书号

	@Column(name = "discount_rate")
	private Double discountRate;// 折扣率

	@Column(name = "discount_price")
	private Double discountPrice;// 折扣价

	private String remark;// 备注信息

	@NotNull
	@Column(name = "school_id")
	private Long schoolId;// 学校id

	@OneToMany(mappedBy = "biblioAcceptanceBook")
	private List<Collection> collections;// 条码列表

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BiblioTemp getBiblioTemp() {
		return biblioTemp;
	}

	public void setBiblioTemp(BiblioTemp biblioTemp) {
		this.biblioTemp = biblioTemp;
	}

	public Double getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(Double singlePrice) {
		this.singlePrice = singlePrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getCoplies() {
		return coplies;
	}

	public void setCoplies(Integer coplies) {
		this.coplies = coplies;
	}

	public String getLibLocal() {
		return libLocal;
	}

	public void setLibLocal(String libLocal) {
		this.libLocal = libLocal;
	}

	public Integer getVolNum() {
		return volNum;
	}

	public void setVolNum(Integer volNum) {
		this.volNum = volNum;
	}

	public String getVolInfo() {
		return volInfo;
	}

	public void setVolInfo(String volInfo) {
		this.volInfo = volInfo;
	}

	public Integer getBookSource() {
		return bookSource;
	}

	public void setBookSource(Integer bookSource) {
		this.bookSource = bookSource;
	}

	public Integer getMediaType() {
		return mediaType;
	}

	public void setMediaType(Integer mediaType) {
		this.mediaType = mediaType;
	}

	public Integer getBindInfo() {
		return bindInfo;
	}

	public void setBindInfo(Integer bindInfo) {
		this.bindInfo = bindInfo;
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
}
