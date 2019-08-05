package com.wenda.comp.form;

public class MarcForm {
	private Long schoolName;// 学校id

	private Long place;// 馆藏地点id

	private Long type;// 文献流通类型id

	private Integer charset;// 字符集

	private String[] fileds;

	public Long getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(Long schoolName) {
		this.schoolName = schoolName;
	}

	public Long getPlace() {
		return place;
	}

	public void setPlace(Long place) {
		this.place = place;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Integer getCharset() {
		return charset;
	}

	public void setCharset(Integer charset) {
		this.charset = charset;
	}

	public String[] getFileds() {
		return fileds;
	}

	public void setFileds(String[] fileds) {
		this.fileds = fileds;
	}

}
