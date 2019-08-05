package com.wenda.comp.vo;

/**
 * <p>
 * Description: marc字段
 * </p>
 * Copyright: Copyright (c) 2012 Company: wenda
 * 
 * @Author sfy
 * @Version 1.0 2014-07-18
 */
public class MarcField {

	private String marcMark;//非必填字段为空标识符
	
	private String key;// marc字段键值

	private String sign;// marc指示符

	private String content;// marc字段内容
	
	public String getMarcMark() {
		return marcMark;
	}

	public void setMarcMark(String marcMark) {
		this.marcMark = marcMark;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
