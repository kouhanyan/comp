package com.wenda.comp.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.wenda.comp.page.Pager;

public class CloudManagerQueryForm extends Pager {

	private Long provinceId;

	private Long cityId;

	private Long countyId;

	private Long schoolId;

	private Integer dealStatus;

	private Long sysUserId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;// 开始入馆日期

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;// 结束入馆日期

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

}
