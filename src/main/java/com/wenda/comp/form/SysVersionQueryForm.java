package com.wenda.comp.form;

import com.wenda.comp.page.Pager;
/**
 * <p>
 * Description: °æ±¾±íµ¥
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author jzp
 * @Version 1.0 2014-07-18
 */
public class SysVersionQueryForm extends Pager{
	
	private String edition;
	
	private String directory;

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
	
	

}
