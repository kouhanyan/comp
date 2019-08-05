package com.wenda.comp.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.wenda.comp.page.Pager;

public class CompLogQueryForm extends Pager {

	private String userName;// 用户名

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate; // 开始日期

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate; // 终止日期

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

}
