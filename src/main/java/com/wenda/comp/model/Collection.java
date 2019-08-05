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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * Description: �����
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
@Entity
@Cacheable
@SequenceGenerator(name = "s_collection", sequenceName = "s_collection", allocationSize = 1)
public class Collection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_collection")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "biblio_temp_id")
	private BiblioTemp biblioTemp;// ��ʱ��

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "biblio_Acceptance_book_id")
	private BiblioAcceptanceBook biblioAcceptanceBook;// ͼ������

	@ManyToOne
	@JoinColumn(name = "collection_place_id")
	@NotNull
	private CollectionPlace collectionPlace;// �ݲص�

	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;// ѧУ

	@ManyToOne
	@JoinColumn(name = "book_circulate_type_id")
	private BookCirculateType bookCirculateType;// ������ͨ����

	@Column(name = "book_seller_id")
	private Long bookSellerId;// ����id

	@Column(name = "budget_id")
	private Long budgetId;// ����id

	private String barcode;// �����

	@Column(name = "barcode_num")
	private Long barcodeNum;// ������е�����

	@Column(name = "call_no")
	private String callNo;// �����

	@Column(name = "single_price")
	private Double singlePrice;// ����

	@Column(name = "total_price")
	private Double totalPrice;// �ܼ�

	@Column(name = "book_source")
	private Integer bookSource;// ������Դ

	@Column(name = "media_type")
	private Integer mediaType;// ��������

	@Column(name = "bind_no")
	private String bindNo;// װ֡��

	@Column(name = "bind_info")
	private Integer bindInfo;// װ֡��Ϣ

	@Column(name = "vol_num")
	private Integer volNum;// �������

	@Column(name = "vol_info")
	private String volInfo;// �����Ϣ

	@Column(name = "total_lend_num")
	private int totalLendNum;// ���Ĵ���

	private Integer status;// �ݲ�״̬

	@NotNull
	@Column(name = "sys_user_id")
	private Long sysUserId;// ϵͳ�û�id

	@NotNull
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;// ��������

	@Column(name = "deal_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dealDate;// ��������

	private Integer type;// �ݲ����ͣ�����;��飩

	private Integer state;// �Ƿ�����ڻ���վ

	private String remark;// ��ע

	@Column(name = "is_had_regist")
	private Integer isHadRegist;// �ݲ��Ƿ��Ѿ��Ǽ�

	

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

	public BiblioAcceptanceBook getBiblioAcceptanceBook() {
		return biblioAcceptanceBook;
	}

	public void setBiblioAcceptanceBook(
			BiblioAcceptanceBook biblioAcceptanceBook) {
		this.biblioAcceptanceBook = biblioAcceptanceBook;
	}

	public CollectionPlace getCollectionPlace() {
		return collectionPlace;
	}

	public void setCollectionPlace(CollectionPlace collectionPlace) {
		this.collectionPlace = collectionPlace;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public BookCirculateType getBookCirculateType() {
		return bookCirculateType;
	}

	public void setBookCirculateType(BookCirculateType bookCirculateType) {
		this.bookCirculateType = bookCirculateType;
	}

	public Long getBookSellerId() {
		return bookSellerId;
	}

	public void setBookSellerId(Long bookSellerId) {
		this.bookSellerId = bookSellerId;
	}

	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
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

	public String getBindNo() {
		return bindNo;
	}

	public void setBindNo(String bindNo) {
		this.bindNo = bindNo;
	}

	public Integer getBindInfo() {
		return bindInfo;
	}

	public void setBindInfo(Integer bindInfo) {
		this.bindInfo = bindInfo;
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

	public int getTotalLendNum() {
		return totalLendNum;
	}

	public void setTotalLendNum(int totalLendNum) {
		this.totalLendNum = totalLendNum;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsHadRegist() {
		return isHadRegist;
	}

	public void setIsHadRegist(Integer isHadRegist) {
		this.isHadRegist = isHadRegist;
	}

	public Long getBarcodeNum() {
		return barcodeNum;
	}

	public void setBarcodeNum(Long barcodeNum) {
		this.barcodeNum = barcodeNum;
	}

}
