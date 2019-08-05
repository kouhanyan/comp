package com.wenda.comp.vo;

import java.util.List;

/**
 * <p>
 * Description: marc
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class Marc {

	private Long biblioTempId;//临时库书目id
	
	private List<MarcField> marcFields;//marc字段集合

	public Long getBiblioTempId() {
		return biblioTempId;
	}

	public void setBiblioTempId(Long biblioTempId) {
		this.biblioTempId = biblioTempId;
	}

	public List<MarcField> getMarcFields() {
		return marcFields;
	}

	public void setMarcFields(List<MarcField> marcFields) {
		this.marcFields = marcFields;
	}

	

}
