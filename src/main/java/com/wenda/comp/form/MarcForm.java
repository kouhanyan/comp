package com.wenda.comp.form;

public class MarcForm {
	private Long schoolName;// ѧУid

	private Long place;// �ݲصص�id

	private Long type;// ������ͨ����id

	private Integer charset;// �ַ���

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
