package com.wenda.comp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: 书目临时库
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Entity
@Table(name = "biblio_temp")
@SequenceGenerator(name = "s_biblio_temp", sequenceName = "s_biblio_temp", allocationSize = 1)
public class BiblioTemp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_biblio_temp")
	private Long id;

	@Column(name = "marc_content")
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String marcContent;// 马克数据内容

	@Column(name = "marc_format")
	private Integer marcFormat;// 书目格式

	@Column(name = "book_type")
	private Integer bookType;// 资料类型

	private String attachment;// 附件

	private String address;// 出版地

	private String author;// 著者

	@Column(name = "class_no")
	private String classNo;// 分类号

	@Column(name = "publish_date")
	private String publishDate;// 出版日期

	private String isbn;// 国际标准书号

	@Column(name = "union_no")
	private String unionNo;// 统一书号

	private String language;// 语种

	private String page;// 页码

	private String price;// 单价

	@Column(name = "total_price")
	private String totalPrice;// 套价

	private String publisher;// 出版社

	@Column(name = "book_size")
	private String bookSize;// 尺寸

	private String title;// 题名

	private String edition;// 版次

	private String notes;// 附注内容

	@Column(length = 500)
	private String subject;// 主题

	@Column(length = 500)
	private String summary;// 提要及文摘

	private String frequency;// 出版频率

	@Column(name = "had_inform")
	private Integer hadInform;// 是否已经通报

	@NotNull
	private Integer status;// 编目状态

	@Column(name = "sys_user_id")
	private Long sysUserId;// 系统用户id

	@NotNull
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;// 创建日期

	@NotNull
	@Column(name = "school_id")
	private Long schoolId;// 学校id

	@Column(name = "batch_id")
	private Long batchId;// 书商征订批次id

	@Column(name = "batch_name")
	private String batchName;// 批次名称

	@NotNull
	@Column(name = "is_share")
	private Integer isShare;// 是否共享

	@Column(name = "order_no")
	private String orderNo;// 订购号

	@OneToMany(mappedBy = "biblioTemp")
	private List<BiblioAcceptanceBook> biblioAcceptanceBooks;// 图书验收集合

	@OneToMany(mappedBy = "biblioTemp")
	private List<Collection> collections;// 馆藏集合

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMarcFormat() {
		return marcFormat;
	}

	public void setMarcFormat(Integer marcFormat) {
		this.marcFormat = marcFormat;
	}

	public String getMarcContent() {
		return marcContent;
	}

	public void setMarcContent(String marcContent) {
		this.marcContent = marcContent;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUnionNo() {
		return unionNo;
	}

	public void setUnionNo(String unionNo) {
		this.unionNo = unionNo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookSize() {
		return bookSize;
	}

	public void setBookSize(String bookSize) {
		this.bookSize = bookSize;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getIsShare() {
		return isShare;
	}

	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}

	public Integer getHadInform() {
		return hadInform;
	}

	public void setHadInform(Integer hadInform) {
		this.hadInform = hadInform;
	}

	public Integer getBookType() {
		return bookType;
	}

	public void setBookType(Integer bookType) {
		this.bookType = bookType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public List<BiblioAcceptanceBook> getBiblioAcceptanceBooks() {
		return biblioAcceptanceBooks;
	}

	public void setBiblioAcceptanceBooks(
			List<BiblioAcceptanceBook> biblioAcceptanceBooks) {
		this.biblioAcceptanceBooks = biblioAcceptanceBooks;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}


}
