package com.wenda.comp.form;

import com.wenda.comp.page.Pager;

public class SysAnnouncementQueryForm extends Pager {
	private String sender;// ������
	private String title;// ����

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

}
