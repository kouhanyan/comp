package com.wenda.comp.vo.backUps;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


@SuppressWarnings("serial")
public class CollectionBean  implements Serializable{
	
	private Long id;
	
	private Long biblioTempId;
	
	private Long biblioAcceptanceBookId;
	
	private Long collectionPlaceId;
	
	private Long schoolId;
	
	private Long bookCirculateTypeId;
	
	private Long bookSellerId;// 书商id

	private Long budgetId;// 经费id

	private String barcode;// 条码号

	private Long barcodeNum;// 条码号中的数字

	private String callNo;// 索书号

	private Double singlePrice;// 单价

	private Double totalPrice;// 总价

	private Integer bookSource;// 文献来源

	private Integer mediaType;// 介质类型

	private String bindNo;// 装帧号

	private Integer bindInfo;// 装帧信息

	private Integer volNum;// 卷册数量

	private String volInfo;// 卷册信息

	private Integer totalLendNum;// 借阅次数

	private Integer status;// 馆藏状态

	private Long sysUserId;// 系统用户id

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;// 创建日期

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dealDate;// 处理日期

	private Integer type;// 馆藏类型（新书和旧书）

	private Integer state;// 是否存在于回收站

	private String remark;// 备注

	private Integer isHadRegist;// 馆藏是否已经登记

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBiblioTempId() {
		return biblioTempId;
	}

	public void setBiblioTempId(Long biblioTempId) {
		this.biblioTempId = biblioTempId;
	}

	public Long getBiblioAcceptanceBookId() {
		return biblioAcceptanceBookId;
	}

	public void setBiblioAcceptanceBookId(Long biblioAcceptanceBookId) {
		this.biblioAcceptanceBookId = biblioAcceptanceBookId;
	}

	public Long getCollectionPlaceId() {
		return collectionPlaceId;
	}

	public void setCollectionPlaceId(Long collectionPlaceId) {
		this.collectionPlaceId = collectionPlaceId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Long getBookCirculateTypeId() {
		return bookCirculateTypeId;
	}

	public void setBookCirculateTypeId(Long bookCirculateTypeId) {
		this.bookCirculateTypeId = bookCirculateTypeId;
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

	public Long getBarcodeNum() {
		return barcodeNum;
	}

	public void setBarcodeNum(Long barcodeNum) {
		this.barcodeNum = barcodeNum;
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

	public Integer getTotalLendNum() {
		return totalLendNum;
	}

	public void setTotalLendNum(Integer totalLendNum) {
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

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsHadRegist() {
		return isHadRegist;
	}

	public void setIsHadRegist(Integer isHadRegist) {
		this.isHadRegist = isHadRegist;
	}

	
	
	
}
